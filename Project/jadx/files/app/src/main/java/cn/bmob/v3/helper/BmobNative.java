package cn.bmob.v3.helper;

import android.content.Context;
import cn.bmob.v3.BmobConstants;

/* JADX INFO: loaded from: classes.dex */
public class BmobNative {
    public static String SECRET_KEY;

    static {
        try {
            System.loadLibrary(BmobConstants.TAG);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        SECRET_KEY = "";
    }

    public static final native void clear();

    public static final native String decrypt(String str, String str2);

    public static final native String decryptByKey(String str);

    public static final native String encrypt(String str, String str2);

    public static final native String encryptByKey(String str);

    public static final native String getAcceptId();

    public static final native String getAppId();

    public static final native String getInterval();

    public static final native boolean hasKey();

    public static final native boolean init(Context context, String str);

    public static final native void saveInterval(String str);

    public static final native void saveKey(String str);
}
