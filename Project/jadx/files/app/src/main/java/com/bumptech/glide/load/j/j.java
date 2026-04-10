package com.bumptech.glide.load.j;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: LazyHeaders.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements h {
    private final Map<String, List<i>> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Map<String, String> f13672c;

    /* JADX INFO: compiled from: LazyHeaders.java */
    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f13673d = d();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Map<String, List<i>> f13674e;
        private boolean a = true;
        private Map<String, List<i>> b = f13674e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13675c = true;

        static {
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(f13673d)) {
                map.put("User-Agent", Collections.singletonList(new b(f13673d)));
            }
            f13674e = Collections.unmodifiableMap(map);
        }

        private void c() {
            if (this.a) {
                this.a = false;
                this.b = b();
            }
        }

        @VisibleForTesting
        static String d() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = property.charAt(i2);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public a a(@NonNull String str, @NonNull String str2) {
            a(str, new b(str2));
            return this;
        }

        public a b(@NonNull String str, @Nullable i iVar) {
            c();
            if (iVar == null) {
                this.b.remove(str);
            } else {
                List<i> listA = a(str);
                listA.clear();
                listA.add(iVar);
            }
            if (this.f13675c && "User-Agent".equalsIgnoreCase(str)) {
                this.f13675c = false;
            }
            return this;
        }

        public a a(@NonNull String str, @NonNull i iVar) {
            if (this.f13675c && "User-Agent".equalsIgnoreCase(str)) {
                b(str, iVar);
                return this;
            }
            c();
            a(str).add(iVar);
            return this;
        }

        private List<i> a(String str) {
            List<i> list = this.b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.b.put(str, arrayList);
            return arrayList;
        }

        private Map<String, List<i>> b() {
            HashMap map = new HashMap(this.b.size());
            for (Map.Entry<String, List<i>> entry : this.b.entrySet()) {
                map.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return map;
        }

        public j a() {
            this.a = true;
            return new j(this.b);
        }
    }

    /* JADX INFO: compiled from: LazyHeaders.java */
    static final class b implements i {

        @NonNull
        private final String a;

        b(@NonNull String str) {
            this.a = str;
        }

        @Override // com.bumptech.glide.load.j.i
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    private Map<String, String> a() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.b.entrySet()) {
            String strA = a(entry.getValue());
            if (!TextUtils.isEmpty(strA)) {
                map.put(entry.getKey(), strA);
            }
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.b.equals(((j) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.j.h
    public Map<String, String> getHeaders() {
        if (this.f13672c == null) {
            synchronized (this) {
                if (this.f13672c == null) {
                    this.f13672c = Collections.unmodifiableMap(a());
                }
            }
        }
        return this.f13672c;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.b + '}';
    }

    @NonNull
    private String a(@NonNull List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strA = list.get(i2).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }
}
