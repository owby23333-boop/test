package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: classes4.dex */
public final class p1 {
    private static volatile p1 z;
    private Throwable g = null;

    private p1() {
    }

    public static p1 z() {
        if (z == null) {
            synchronized (p1.class) {
                if (z == null) {
                    z = new p1();
                }
            }
        }
        return z;
    }

    public final synchronized Throwable g() {
        return this.g;
    }
}
