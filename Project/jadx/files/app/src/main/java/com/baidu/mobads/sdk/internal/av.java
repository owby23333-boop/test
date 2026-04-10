package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class av {
    public static final String a = "bqt_ad_tag";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a[] f12879c = new a[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, a> f12880d = new HashMap();
    static volatile a[] b = f12879c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a f12881e = new aw();

    public static abstract class a {
        private final ThreadLocal<String> a = new ThreadLocal<>();

        private String g(Object[] objArr) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(obj);
                sb.append(' ');
            }
            return sb.toString();
        }

        @NonNull
        abstract String a();

        protected abstract void a(int i2, String str, String str2, Throwable th);

        protected boolean a(int i2) {
            return true;
        }

        String b() {
            String str = this.a.get();
            if (str != null) {
                this.a.remove();
            }
            return str;
        }

        public void c(String str) {
            b(3, null, str);
        }

        public void d(String str) {
            b(4, null, str);
        }

        public void e(String str) {
            b(5, null, str);
        }

        public void f(String str) {
            b(6, null, str);
        }

        public void a(String str) {
            if (TextUtils.isEmpty(str)) {
                c("Empty/Null json content");
                return;
            }
            try {
                String strTrim = str.trim();
                if (strTrim.startsWith("{")) {
                    b(3, null, new JSONObject(strTrim).toString(2));
                } else if (strTrim.startsWith("[")) {
                    b(3, null, new JSONArray(strTrim).toString(2));
                } else {
                    f("Invalid Json");
                }
            } catch (Exception unused) {
                f("Invalid Json");
            }
        }

        public void c(Object... objArr) {
            b(4, null, g(objArr));
        }

        public void d(Throwable th, String str) {
            b(5, th, str);
        }

        public void e(Object... objArr) {
            b(6, null, g(objArr));
        }

        public void f(Object... objArr) {
            b(7, null, g(objArr));
        }

        protected String b(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (!obj.getClass().isArray()) {
                return obj.toString();
            }
            if (obj instanceof boolean[]) {
                return Arrays.toString((boolean[]) obj);
            }
            if (obj instanceof byte[]) {
                return Arrays.toString((byte[]) obj);
            }
            if (obj instanceof char[]) {
                return Arrays.toString((char[]) obj);
            }
            if (obj instanceof short[]) {
                return Arrays.toString((short[]) obj);
            }
            if (obj instanceof int[]) {
                return Arrays.toString((int[]) obj);
            }
            if (obj instanceof long[]) {
                return Arrays.toString((long[]) obj);
            }
            if (obj instanceof float[]) {
                return Arrays.toString((float[]) obj);
            }
            if (obj instanceof double[]) {
                return Arrays.toString((double[]) obj);
            }
            return obj instanceof Object[] ? Arrays.deepToString((Object[]) obj) : "Couldn't find a correct type for the object";
        }

        public void c(Throwable th, String str) {
            b(4, th, str);
        }

        public void d(Throwable th) {
            b(5, th, null);
        }

        public void e(Throwable th, String str) {
            b(6, th, str);
        }

        public void f(Throwable th, String str) {
            b(7, th, str);
        }

        public void c(Throwable th) {
            b(4, th, null);
        }

        public void d(Object... objArr) {
            b(5, null, g(objArr));
        }

        public void e(Throwable th) {
            b(6, th, null);
        }

        public void f(Throwable th) {
            b(7, th, null);
        }

        public void g(String str) {
            b(7, null, str);
        }

        private String g(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        public void a(Object... objArr) {
            b(2, null, g(objArr));
        }

        public void a(Throwable th, String str) {
            b(2, th, str);
        }

        public void a(Throwable th) {
            b(2, th, null);
        }

        public void a(Object obj) {
            b(3, null, b(obj));
        }

        public void a(int i2, String str) {
            b(i2, null, str);
        }

        public void a(int i2, Object... objArr) {
            b(i2, null, g(objArr));
        }

        public void a(int i2, Throwable th, String str) {
            b(i2, th, str);
        }

        public void a(int i2, Throwable th) {
            b(i2, th, null);
        }

        protected boolean a(String str, int i2) {
            return a(i2);
        }

        public void b(String str) {
            b(2, null, str);
        }

        protected String a(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        public void b(Throwable th, String str) {
            b(3, th, str);
        }

        public void b(Object... objArr) {
            b(3, null, g(objArr));
        }

        public void b(Throwable th) {
            b(3, th, null);
        }

        private void b(int i2, Throwable th, String str) {
            String strB = b();
            if (a(strB, i2)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str == null) {
                    if (th == null) {
                        return;
                    } else {
                        str = g(th);
                    }
                } else if (th != null) {
                    str = str + "\n" + g(th);
                }
                a(i2, strB, str, th);
            }
        }
    }

    public static void a(boolean z2) {
        try {
            a();
            if (ci.a) {
                a((a) new at());
            } else if (z2) {
                a((a) new as());
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(String str) {
        f12881e.b(str);
    }

    public static void c(String str) {
        f12881e.c(str);
    }

    public static void d(String str) {
        f12881e.d(str);
    }

    public static void e(String str) {
        f12881e.e(str);
    }

    public static void f(String str) {
        f12881e.f(str);
    }

    public static void g(String str) {
        f12881e.g(str);
    }

    public static a h(String str) {
        for (a aVar : b) {
            aVar.a.set(str);
        }
        return f12881e;
    }

    public static void i(String str) {
        synchronized (f12880d) {
            if (f12880d.remove(str) == null) {
                return;
            }
            b = (a[]) f12880d.values().toArray(new a[0]);
        }
    }

    public static void b(Object... objArr) {
        f12881e.b(objArr);
    }

    public static void c(Throwable th, String str) {
        f12881e.c(th, str);
    }

    public static void d(Throwable th, String str) {
        f12881e.d(th, str);
    }

    public static void e(Object... objArr) {
        f12881e.e(objArr);
    }

    public static void f(Object... objArr) {
        f12881e.f(objArr);
    }

    public static void b(Throwable th, String str) {
        f12881e.b(th, str);
    }

    public static void c(Object... objArr) {
        f12881e.c(objArr);
    }

    public static void d(Object... objArr) {
        f12881e.d(objArr);
    }

    public static void e(Throwable th, String str) {
        f12881e.e(th, str);
    }

    public static void f(Throwable th, String str) {
        f12881e.f(th, str);
    }

    public static void b(Throwable th) {
        f12881e.b(th);
    }

    public static void c(Throwable th) {
        f12881e.c(th);
    }

    public static void d(Throwable th) {
        f12881e.d(th);
    }

    public static void e(Throwable th) {
        f12881e.e(th);
    }

    public static void f(Throwable th) {
        f12881e.f(th);
    }

    public static void a() {
        try {
            i("local");
            i("debug");
        } catch (Throwable unused) {
        }
    }

    public static a b() {
        return f12881e;
    }

    public static a c() {
        for (a aVar : b) {
            aVar.a.set(a);
        }
        return f12881e;
    }

    public static void d() {
        synchronized (f12880d) {
            f12880d.clear();
            b = f12879c;
        }
    }

    public static List<a> e() {
        List<a> listUnmodifiableList;
        synchronized (f12880d) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(f12880d.values()));
        }
        return listUnmodifiableList;
    }

    public static int f() {
        int size;
        synchronized (f12880d) {
            size = f12880d.size();
        }
        return size;
    }

    public static void b(a aVar) {
        i(aVar.a());
    }

    public static void a(String str) {
        f12881e.a(str);
    }

    public static void a(Object... objArr) {
        f12881e.a(objArr);
    }

    public static void a(Throwable th, String str) {
        f12881e.a(th, str);
    }

    public static void a(Throwable th) {
        f12881e.a(th);
    }

    public static void a(Object obj) {
        f12881e.a(obj);
    }

    public static void a(int i2, String str) {
        f12881e.a(i2, str);
    }

    public static void a(int i2, Throwable th, String str) {
        f12881e.a(i2, th, str);
    }

    public static void a(int i2, Object... objArr) {
        f12881e.a(i2, objArr);
    }

    public static void a(int i2, Throwable th) {
        f12881e.a(i2, th);
    }

    public static void a(a aVar) {
        if (aVar == null || aVar == f12881e) {
            return;
        }
        synchronized (f12880d) {
            f12880d.put(aVar.a(), aVar);
            b = (a[]) f12880d.values().toArray(new a[0]);
        }
    }
}
