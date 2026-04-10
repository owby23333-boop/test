package com.bytedance.sdk.openadsdk.core;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class AdSdkInitializerHolder {
    private static String MEDIATION_CLASS_NAME = "com.bytedance.sdk.gromore.init.DispatchAdSdkInitializerHolder";
    private static String PACKAGE_NAME = "com.byted.pangle";
    private static volatile Object mDispatchAdSdkInitializer;
    private static volatile dl mInitializer;

    public static Object getNewInstance(Bundle bundle) {
        if (mInitializer == null) {
            synchronized (AdSdkInitializerHolder.class) {
                if (mInitializer == null) {
                    mInitializer = new dl(bundle);
                    mDispatchAdSdkInitializer = getDispatchAdSdkInitializer(bundle, mInitializer);
                }
            }
        }
        int sdkVersion = bundle.getInt("api_sdk_version", 0);
        if (sdkVersion == 0) {
            sdkVersion = getSdkVersion();
            com.bytedance.sdk.component.utils.wp.z("wzj,通过反射取apiSdkVersion值=".concat(String.valueOf(sdkVersion)));
            if (sdkVersion == 0) {
                return null;
            }
        }
        com.bykv.z.z().z(sdkVersion);
        if (sdkVersion >= 6803) {
            return mDispatchAdSdkInitializer != null ? mDispatchAdSdkInitializer : mInitializer;
        }
        if (mDispatchAdSdkInitializer != null) {
            return new com.bytedance.sdk.openadsdk.ls.g.g.g((Function) mDispatchAdSdkInitializer);
        }
        return new com.bytedance.sdk.openadsdk.ls.g.g.z(mInitializer);
    }

    private static int getSdkVersion() {
        try {
            return Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk").getField("SDK_VERSION_CODE").getInt(null);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.core.q.v.z().z("init", th);
            com.bytedance.sdk.component.utils.wp.z(th);
            return 0;
        }
    }

    public static boolean hasDispatchAdSdkInitializer() {
        return mDispatchAdSdkInitializer != null;
    }

    private static Object getDispatchAdSdkInitializer(Bundle bundle, dl dlVar) {
        try {
            return Class.forName(MEDIATION_CLASS_NAME).getDeclaredMethod("getInstance", Bundle.class, dl.class).invoke(null, bundle, dlVar);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean isSdkInitSuccess() {
        if (mInitializer != null) {
            return mInitializer.z();
        }
        return false;
    }
}
