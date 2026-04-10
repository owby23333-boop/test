package com.bytedance.embedapplog;

/* JADX INFO: loaded from: classes2.dex */
public class js {
    private static g g = z.z();
    private static int z = 6;

    public static int z() {
        return z;
    }

    public static boolean g() {
        return z <= 3;
    }

    public static void z(String str) {
        z("Logger", str);
    }

    public static void z(String str, String str2) {
        if (str2 == null) {
            return;
        }
        g.z(3);
    }

    public static void g(String str, String str2) {
        if (str2 != null && g.z(4)) {
            g.z(str, str2);
        }
    }

    public static void dl(String str, String str2) {
        if (str2 != null && g.z(5)) {
            g.dl(str, str2);
        }
    }

    public static void g(String str) {
        a("Logger", str);
    }

    public static void a(String str, String str2) {
        if (str2 != null && g.z(6)) {
            g.g(str, str2);
        }
    }

    public static void z(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && g.z(6)) {
            g.z(str, str2, th);
        }
    }

    public static abstract class g {
        public void dl(String str, String str2) {
        }

        public void g(String str, String str2) {
        }

        public void z(String str, String str2) {
        }

        public void z(String str, String str2, Throwable th) {
        }

        public boolean z(int i) {
            return js.z() <= i;
        }
    }

    static final class z extends g {
        private z() {
        }

        static z z() {
            return C0058z.z;
        }

        @Override // com.bytedance.embedapplog.js.g
        public void z(String str, String str2) {
            com.bytedance.sdk.component.utils.wp.z(str, str2);
        }

        @Override // com.bytedance.embedapplog.js.g
        public void z(String str, String str2, Throwable th) {
            com.bytedance.sdk.component.utils.wp.dl(str, str2, th);
        }

        @Override // com.bytedance.embedapplog.js.g
        public void g(String str, String str2) {
            com.bytedance.sdk.component.utils.wp.a(str, str2);
        }

        @Override // com.bytedance.embedapplog.js.g
        public void dl(String str, String str2) {
            com.bytedance.sdk.component.utils.wp.g(str, str2);
        }

        /* JADX INFO: renamed from: com.bytedance.embedapplog.js$z$z, reason: collision with other inner class name */
        static class C0058z {
            private static final z z = new z();
        }
    }
}
