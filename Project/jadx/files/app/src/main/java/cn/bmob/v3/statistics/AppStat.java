package cn.bmob.v3.statistics;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class AppStat {
    private static volatile boolean isInited;

    public static final synchronized boolean i(String str, String str2) {
        return i(str, str2, false);
    }

    private static native void init(String str, String str2, boolean z2);

    public static final synchronized boolean i(String str, String str2, boolean z2) {
        if (isInited) {
        } else {
            try {
                System.loadLibrary("BmobStat");
                init(str, str2, z2);
                isInited = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return isInited;
    }
}
