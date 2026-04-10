package com.bytedance.sdk.component.v.tg;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private InterfaceC0107bf bf;
    private e e;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.v.tg.bf$bf, reason: collision with other inner class name */
    public interface InterfaceC0107bf {
        void bf(String str, String str2);

        void e(String str, String str2);
    }

    public static class d {
        private static final bf e = new bf();
    }

    public enum e {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    public static void bf(String str, String str2) {
        if (d.e.e.compareTo(e.DEBUG) <= 0) {
            d.e.bf.bf(str, str2);
        }
    }

    public static void e(e eVar) {
        synchronized (bf.class) {
            d.e.e = eVar;
        }
    }

    private bf() {
        this.e = e.OFF;
        this.bf = new com.bytedance.sdk.component.v.tg.e();
    }

    public static void e(String str, String str2) {
        if (d.e.e.compareTo(e.ERROR) <= 0) {
            d.e.bf.e(str, str2);
        }
    }
}
