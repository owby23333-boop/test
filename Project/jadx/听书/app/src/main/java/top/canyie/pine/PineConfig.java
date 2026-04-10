package top.canyie.pine;

import android.os.Build;
import java.util.Locale;
import top.canyie.pine.Pine;

/* JADX INFO: loaded from: classes5.dex */
public final class PineConfig {
    public static boolean antiChecks = false;
    public static boolean debug = true;
    public static boolean debuggable = false;
    public static boolean disableHiddenApiPolicy = true;
    public static boolean disableHiddenApiPolicyForPlatformDomain = true;
    public static boolean disableHooks;
    public static Pine.LibLoader libLoader = new Pine.LibLoader() { // from class: top.canyie.pine.PineConfig.1
        @Override // top.canyie.pine.Pine.LibLoader
        public void loadLib() {
            System.loadLibrary("pinesafecheck");
        }
    };
    public static int sdkLevel;
    public static boolean useFastNative;

    static {
        int i = Build.VERSION.SDK_INT;
        sdkLevel = i;
        if (i == 34 && isAtLeastPreReleaseCodename("VanillaIceCream")) {
            sdkLevel = 35;
        }
    }

    private PineConfig() {
        throw new RuntimeException();
    }

    private static boolean isAtLeastPreReleaseCodename(String str) {
        String str2 = Build.VERSION.CODENAME;
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        return !"REL".equals(upperCase) && upperCase.compareTo(str.toUpperCase(locale)) >= 0;
    }
}
