package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static EnumC0025b b = EnumC0025b.OFF;
    private c a;

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b$b, reason: collision with other inner class name */
    public enum EnumC0025b {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    public interface c {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    private static class d {
        private static final b a = new b();
    }

    private b() {
        this.a = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.a();
    }

    public static void a(EnumC0025b enumC0025b) {
        synchronized (b.class) {
            b unused = d.a;
            b = enumC0025b;
        }
    }

    public static void a(String str, String str2) {
        b unused = d.a;
        if (b.compareTo(EnumC0025b.DEBUG) <= 0) {
            d.a.a.a(str, str2);
        }
    }

    public static boolean a() {
        return EnumC0025b.DEBUG == b;
    }

    public static void b(String str, String str2) {
        b unused = d.a;
        if (b.compareTo(EnumC0025b.ERROR) <= 0) {
            d.a.a.b(str, str2);
        }
    }
}
