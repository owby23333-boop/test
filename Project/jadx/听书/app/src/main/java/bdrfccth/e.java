package bdrfccth;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f67a;
    public static final String b;
    public static final String c;
    public static final int d;

    static {
        c("awt.toolkit");
        c("file.encoding");
        c("file.separator");
        c("java.awt.fonts");
        c("java.awt.graphicsenv");
        c("java.awt.headless");
        c("java.awt.printerjob");
        c("java.class.path");
        c("java.class.version");
        c("java.compiler");
        c("java.endorsed.dirs");
        c("java.ext.dirs");
        c("java.home");
        c("java.io.tmpdir");
        c("java.library.path");
        c("java.runtime.name");
        c("java.runtime.version");
        c("java.specification.name");
        c("java.specification.vendor");
        String strC = c("java.specification.version");
        f67a = strC;
        d = "0.9".equals(strC) ? 1 : "1.1".equals(strC) ? 2 : "1.2".equals(strC) ? 3 : "1.3".equals(strC) ? 4 : "1.4".equals(strC) ? 5 : "1.5".equals(strC) ? 6 : "1.6".equals(strC) ? 7 : "1.7".equals(strC) ? 8 : "1.8".equals(strC) ? 9 : 0;
        c("java.util.prefs.PreferencesFactory");
        c("java.vendor");
        c("java.vendor.url");
        c("java.version");
        c("java.vm.info");
        c("java.vm.name");
        c("java.vm.specification.name");
        c("java.vm.specification.vendor");
        c("java.vm.specification.version");
        c("java.vm.vendor");
        c("java.vm.version");
        c("line.separator");
        c("os.arch");
        b = c("os.name");
        c = c("os.version");
        c("path.separator");
        c(c("user.country") == null ? "user.region" : "user.country");
        c("user.dir");
        c("user.home");
        c("user.language");
        c("user.name");
        c("user.timezone");
        a("1.1");
        a("1.2");
        a("1.3");
        a("1.4");
        a("1.5");
        a("1.6");
        a("1.7");
        b("AIX");
        b("HP-UX");
        b("Irix");
        if (!b("Linux")) {
            b("LINUX");
        }
        b("Mac");
        b("Mac OS X");
        b("FreeBSD");
        b("OpenBSD");
        b("NetBSD");
        b("OS/2");
        b("Solaris");
        b("SunOS");
        b("Windows");
        a("Windows", "5.0");
        a("Windows", "5.2");
        a("Windows Server 2008", "6.1");
        a("Windows 9", "4.0");
        a("Windows 9", "4.1");
        a("Windows", "4.9");
        b("Windows NT");
        a("Windows", "5.1");
        a("Windows", "6.0");
        a("Windows", "6.1");
    }

    public static void a(String str) {
        String str2 = f67a;
        if (str2 == null) {
            return;
        }
        str2.startsWith(str);
    }

    public static void a(String str, String str2) {
        String str3 = b;
        String str4 = c;
        if (str3 == null || str4 == null || !str3.startsWith(str)) {
            return;
        }
        str4.startsWith(str2);
    }

    public static boolean b(String str) {
        String str2 = b;
        if (str2 == null) {
            return false;
        }
        return str2.startsWith(str);
    }

    public static String c(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException e) {
            System.err.println("Caught a SecurityException reading the system property '" + str + "'; the SystemUtils property value will default to null.");
            return null;
        }
    }
}
