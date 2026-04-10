package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.core.lq;
import com.bytedance.sdk.openadsdk.core.x;

/* JADX INFO: loaded from: classes2.dex */
public class DispatchAdSdkInitializerHolder {
    private static com.bytedance.sdk.openadsdk.core.dl g;
    private static volatile Object z;

    public static Object getInstance(Bundle bundle, com.bytedance.sdk.openadsdk.core.dl dlVar) {
        g = dlVar;
        if (z == null) {
            synchronized (DispatchAdSdkInitializerHolder.class) {
                if (z == null) {
                    z = new kb(bundle, dlVar);
                }
            }
        }
        return z;
    }

    public static x getCsjManger() {
        com.bytedance.sdk.openadsdk.core.dl dlVar = g;
        if (dlVar != null) {
            return dlVar.g();
        }
        return null;
    }

    public static boolean isInitSuccess() {
        com.bytedance.sdk.openadsdk.core.dl dlVar = g;
        return dlVar != null && dlVar.z();
    }

    public static lq getCsjLoader(Context context) {
        if (getCsjManger() != null) {
            return getCsjManger().z(context);
        }
        return null;
    }
}
