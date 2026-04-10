package p000;

import android.content.Context;
import bhjuguyt.Loader;
import bhjuguyt.hidden.Hidden0;

/* JADX INFO: loaded from: classes5.dex */
public class ClassLoaderUtil {
    private static Context appContext;
    public static ClassLoader applicationClassLoader;
    public static boolean toastEnabled;

    static {
        Loader.registerNativesForClass(0, ClassLoaderUtil.class);
        Hidden0.special_clinit_0_00(ClassLoaderUtil.class);
    }

    public static native ClassLoader getActivityClassLoader();

    public static native boolean getAndSaveClassLoaders();

    public static native ClassLoader getApplicationContextClassLoader();

    public static native ClassLoader getBootClassLoader();

    public static native ClassLoader getClassClassLoader();

    public static native Context getContext();

    public static native ClassLoader getContextClassLoader();

    public static native ClassLoader getLoadedApkClassLoader();

    public static native void setContext(Context context);

    private static native void showToast(Context context, String str);
}
