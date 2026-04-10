package com.bytedance.sdk.component.fo.a;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private g g;
    private z z;

    public interface g {
        void z(String str, String str2);
    }

    public enum z {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    private dl() {
        this.z = z.OFF;
        this.g = new com.bytedance.sdk.component.fo.a.g();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.fo.a.dl$dl, reason: collision with other inner class name */
    private static class C0130dl {
        private static final dl z = new dl();
    }

    public static void z(z zVar) {
        synchronized (dl.class) {
            C0130dl.z.z = zVar;
        }
    }

    public static void z(String str, String str2) {
        if (C0130dl.z.z.compareTo(z.ERROR) <= 0) {
            C0130dl.z.g.z(str, str2);
        }
    }

    public static void g(String str, String str2) {
        if (C0130dl.z.z.compareTo(z.DEBUG) <= 0) {
            dl unused = C0130dl.z;
        }
    }
}
