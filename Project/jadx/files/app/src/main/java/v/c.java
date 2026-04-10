package v;

/* JADX INFO: compiled from: C0001a.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static c b;
    public int a = -1;

    public static void a(boolean z2) {
        b().a = z2 ? 1 : 0;
    }

    public static void b(String str, String str2) {
        a();
    }

    public static boolean a() {
        return b().a == 1;
    }

    public static void b(String str, String str2, Throwable th) {
        a();
    }

    public static void a(String str, String str2) {
        a();
    }

    public static c b() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public static void a(String str, String str2, Throwable th) {
        a();
    }
}
