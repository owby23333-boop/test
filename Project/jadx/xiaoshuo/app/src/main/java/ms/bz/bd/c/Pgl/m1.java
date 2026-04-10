package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: classes9.dex */
public class m1 {
    private static volatile m1 e;
    private int bf = 0;
    private Throwable d = null;

    private m1() {
    }

    public static m1 e() {
        if (e == null) {
            synchronized (m1.class) {
                if (e == null) {
                    e = new m1();
                }
            }
        }
        return e;
    }

    public synchronized Throwable bf() {
        return this.d;
    }
}
