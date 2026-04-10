package com.anythink.expressad.exoplayer.j;

import android.text.TextUtils;
import com.anythink.expressad.exoplayer.j.h;
import com.anythink.expressad.exoplayer.k.af;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface s extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.anythink.expressad.exoplayer.k.u<String> f9739c = new com.anythink.expressad.exoplayer.k.u<String>() { // from class: com.anythink.expressad.exoplayer.j.s.1
        @Override // com.anythink.expressad.exoplayer.k.u
        public final /* synthetic */ boolean a(String str) {
            String strD = af.d(str);
            if (TextUtils.isEmpty(strD)) {
                return false;
            }
            return ((strD.contains("text") && !strD.contains(com.anythink.expressad.exoplayer.k.o.O)) || strD.contains(com.baidu.mobads.sdk.internal.a.f12785f) || strD.contains("xml")) ? false : true;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private static boolean a2(String str) {
            String strD = af.d(str);
            if (TextUtils.isEmpty(strD)) {
                return false;
            }
            return ((strD.contains("text") && !strD.contains(com.anythink.expressad.exoplayer.k.o.O)) || strD.contains(com.baidu.mobads.sdk.internal.a.f12785f) || strD.contains("xml")) ? false : true;
        }
    };

    public static abstract class a implements b {
        private final f a = new f();

        protected abstract s a(f fVar);

        @Override // com.anythink.expressad.exoplayer.j.s.b, com.anythink.expressad.exoplayer.j.h.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final s a() {
            return a(this.a);
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b
        public final f c() {
            return this.a;
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b
        @Deprecated
        public final void d() {
            this.a.a();
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b
        @Deprecated
        public final void a(String str, String str2) {
            this.a.a(str, str2);
        }

        @Override // com.anythink.expressad.exoplayer.j.s.b
        @Deprecated
        public final void a(String str) {
            this.a.a(str);
        }
    }

    public interface b extends h.a {
        @Override // com.anythink.expressad.exoplayer.j.h.a
        /* synthetic */ h a();

        @Deprecated
        void a(String str);

        @Deprecated
        void a(String str, String str2);

        /* JADX INFO: renamed from: b */
        s a();

        f c();

        @Deprecated
        void d();
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f9743f;

        public d(String str, k kVar) {
            super("Invalid content type: ".concat(String.valueOf(str)), kVar);
            this.f9743f = str;
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f9744f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map<String, List<String>> f9745g;

        public e(int i2, Map<String, List<String>> map, k kVar) {
            super("Response code: ".concat(String.valueOf(i2)), kVar);
            this.f9744f = i2;
            this.f9745g = map;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    int a(byte[] bArr, int i2, int i3);

    @Override // com.anythink.expressad.exoplayer.j.h
    long a(k kVar);

    void a(String str);

    void a(String str, String str2);

    @Override // com.anythink.expressad.exoplayer.j.h
    void b();

    Map<String, List<String>> c();

    void d();

    public static class c extends IOException {
        public static final int a = 1;
        public static final int b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f9740c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f9741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final k f9742e;

        /* JADX INFO: loaded from: classes.dex */
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        private c(k kVar, int i2) {
            this.f9742e = kVar;
            this.f9741d = i2;
        }

        public c(String str, k kVar) {
            super(str);
            this.f9742e = kVar;
            this.f9741d = 1;
        }

        public c(IOException iOException, k kVar, int i2) {
            super(iOException);
            this.f9742e = kVar;
            this.f9741d = i2;
        }

        public c(String str, IOException iOException, k kVar) {
            super(str, iOException);
            this.f9742e = kVar;
            this.f9741d = 1;
        }
    }

    public static final class f {
        private final Map<String, String> a = new HashMap();
        private Map<String, String> b;

        private synchronized void b(Map<String, String> map) {
            this.b = null;
            this.a.clear();
            this.a.putAll(map);
        }

        public final synchronized void a(String str, String str2) {
            this.b = null;
            this.a.put(str, str2);
        }

        private synchronized void a(Map<String, String> map) {
            this.b = null;
            this.a.putAll(map);
        }

        public final synchronized Map<String, String> b() {
            if (this.b == null) {
                this.b = Collections.unmodifiableMap(new HashMap(this.a));
            }
            return this.b;
        }

        public final synchronized void a(String str) {
            this.b = null;
            this.a.remove(str);
        }

        public final synchronized void a() {
            this.b = null;
            this.a.clear();
        }
    }
}
