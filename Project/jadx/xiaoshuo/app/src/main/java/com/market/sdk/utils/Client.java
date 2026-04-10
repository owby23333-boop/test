package com.market.sdk.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.webkit.ProxyConfig;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.market.sdk.SystemProperties;
import com.market.sdk.utils.PrefUtils;
import com.xiaomi.ad.c;
import com.yuewen.kl2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.UUID;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes7.dex */
public class Client {
    private static String DEFAULT_MIUI_BIG_VERSION_CODE = "-1";
    public static int DISPLAY_DENSITY = 0;
    public static int DISPLAY_HEIGHT = 0;
    public static String DISPLAY_RESOLUTION = null;
    public static int DISPLAY_WIDTH = 0;
    public static ArrayList<String> FEATURE = null;
    public static String GLES_VERSION = null;
    public static ArrayList<String> GL_EXTENSION = null;
    public static ArrayList<String> LIBRARY = null;
    public static String RELEASE = null;
    public static int SDK_VERSION = 0;
    public static String SYSTEM_VERSION = null;
    private static final String TAG = "MarketSdkClient";
    public static int TOUCH_SCREEN = 0;
    public static final int XIAOMI_SDK_VERSION_CODE = 11;
    private static boolean mIsInited = false;
    private static final Object mLock = new Object();
    private static String miuiBigVersionCode;

    private static void acquireDeviceConfig(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getDeviceConfigurationInfo();
        TOUCH_SCREEN = deviceConfigurationInfo.reqTouchScreen;
        GLES_VERSION = deviceConfigurationInfo.getGlEsVersion();
    }

    private static void acquireFeature(Context context) {
        FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
        synchronized (mLock) {
            FEATURE = new ArrayList<>();
            if (systemAvailableFeatures != null) {
                for (FeatureInfo featureInfo : systemAvailableFeatures) {
                    if (!TextUtils.isEmpty(featureInfo.name)) {
                        FEATURE.add(featureInfo.name);
                    }
                }
            }
            Collections.sort(FEATURE);
        }
    }

    private static void acquireGLExtensions() {
        String gLExtensions = getGLExtensions();
        synchronized (mLock) {
            GL_EXTENSION = new ArrayList<>();
            if (!TextUtils.isEmpty(gLExtensions)) {
                for (String str : TextUtils.split(gLExtensions, " ")) {
                    if (!TextUtils.isEmpty(str)) {
                        GL_EXTENSION.add(str);
                    }
                }
            }
            Collections.sort(GL_EXTENSION);
        }
    }

    private static void acquireLibrary(Context context) {
        String[] systemSharedLibraryNames = context.getPackageManager().getSystemSharedLibraryNames();
        synchronized (mLock) {
            LIBRARY = new ArrayList<>();
            if (systemSharedLibraryNames != null) {
                for (String str : systemSharedLibraryNames) {
                    if (!TextUtils.isEmpty(str)) {
                        LIBRARY.add(str);
                    }
                }
            }
            Collections.sort(LIBRARY);
        }
    }

    private static void acquireScreenAttr(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(kl2.t9)).getDefaultDisplay().getMetrics(displayMetrics);
        DISPLAY_HEIGHT = displayMetrics.heightPixels;
        DISPLAY_WIDTH = displayMetrics.widthPixels;
        DISPLAY_RESOLUTION = DISPLAY_HEIGHT + ProxyConfig.MATCH_ALL_SCHEMES + DISPLAY_WIDTH;
        DISPLAY_DENSITY = displayMetrics.densityDpi;
    }

    private static void acquireSystemInfo(Context context) {
        RELEASE = Build.VERSION.RELEASE;
        SYSTEM_VERSION = Build.VERSION.INCREMENTAL;
        SDK_VERSION = Build.VERSION.SDK_INT;
    }

    public static String getCountry() {
        return Locale.getDefault().getCountry();
    }

    public static String getCpuArch() {
        ArrayList arrayList = new ArrayList();
        if (isLaterThanLollipop()) {
            String string = SystemProperties.getString("ro.product.cpu.abilist", "");
            if (!TextUtils.isEmpty(string)) {
                arrayList = new ArrayList(Arrays.asList(TextUtils.split(string, ",")));
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(android.os.Build.CPU_ABI);
            arrayList.add(android.os.Build.CPU_ABI2);
        }
        return TextUtils.join(",", arrayList);
    }

    public static String getDevice() {
        return android.os.Build.DEVICE;
    }

    public static int getDeviceType() {
        return isTablet() ? 1 : 0;
    }

    private static String getGLExtensions() {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY || !egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
            return null;
        }
        int[] iArr = new int[1];
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!egl10.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, eGLConfigArr, 1, iArr)) {
            return null;
        }
        EGLConfig eGLConfig = iArr[0] > 0 ? eGLConfigArr[0] : null;
        EGLContext eGLContextEglCreateContext = egl10.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, null);
        EGLSurface eGLSurfaceEglCreatePbufferSurface = egl10.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfig, new int[]{12375, 480, 12374, 800, 12344});
        if (eGLSurfaceEglCreatePbufferSurface == null || eGLSurfaceEglCreatePbufferSurface == EGL10.EGL_NO_SURFACE) {
            return null;
        }
        egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext);
        if (!egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext)) {
            return null;
        }
        String strGlGetString = ((GL10) eGLContextEglCreateContext.getGL()).glGetString(7939);
        egl10.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface);
        egl10.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
        egl10.eglTerminate(eGLDisplayEglGetDisplay);
        if (strGlGetString != null) {
            return strGlGetString.trim();
        }
        return null;
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getMiuiBigVersionCode() {
        return SystemProperties.getString(c.f7255a, DEFAULT_MIUI_BIG_VERSION_CODE);
    }

    public static String getMiuiBigVersionName() {
        String string = SystemProperties.getString("ro.miui.ui.version.name", "");
        if (TextUtils.isEmpty(string) || isStableBuild()) {
            return string;
        }
        if (isAlphaBuild()) {
            return string + "-alpha";
        }
        return string + "-dev";
    }

    public static String getModel() {
        return android.os.Build.MODEL;
    }

    public static String getRegion() {
        return SystemProperties.getString("ro.miui.region", "CN");
    }

    public static int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getUUid() {
        String string = PrefUtils.getString(com.market.sdk.Constants.EXTRA_UUID, "", new PrefUtils.PrefFile[0]);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strValueOf = String.valueOf(UUID.randomUUID());
        PrefUtils.setString(com.market.sdk.Constants.EXTRA_UUID, strValueOf, new PrefUtils.PrefFile[0]);
        return strValueOf;
    }

    public static void init(Context context) {
        if (mIsInited) {
            return;
        }
        acquireScreenAttr(context);
        acquireDeviceConfig(context);
        acquireFeature(context);
        acquireLibrary(context);
        acquireGLExtensions();
        acquireSystemInfo(context);
        mIsInited = true;
    }

    public static boolean isAlphaBuild() {
        return miui.os.Build.IS_ALPHA_BUILD;
    }

    public static boolean isInternationalMiui() {
        return isMiui() && SystemProperties.getString("ro.product.mod_device", "").contains("_global");
    }

    public static boolean isLaterThanHoneycomb() {
        return SDK_VERSION >= 11;
    }

    public static boolean isLaterThanLollipop() {
        return getSdkVersion() >= 21;
    }

    public static boolean isLaterThanN() {
        return SDK_VERSION >= 24;
    }

    public static boolean isMiui() {
        if (miuiBigVersionCode == null) {
            miuiBigVersionCode = getMiuiBigVersionCode();
        }
        return (TextUtils.isEmpty(miuiBigVersionCode) || DEFAULT_MIUI_BIG_VERSION_CODE.equals(miuiBigVersionCode)) ? false : true;
    }

    public static boolean isStableBuild() {
        return miui.os.Build.IS_STABLE_VERSION;
    }

    public static boolean isTablet() {
        return SystemProperties.getString("ro.build.characteristics", "").contains("tablet");
    }
}
