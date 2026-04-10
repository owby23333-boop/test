package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    public static Thread a(Runnable runnable) {
        return a(runnable, null);
    }

    public static Thread a(Runnable runnable, String str) {
        if (runnable == null) {
            return null;
        }
        Thread thread = str == null ? new Thread(runnable) : new Thread(runnable, str);
        thread.start();
        return thread;
    }
}
