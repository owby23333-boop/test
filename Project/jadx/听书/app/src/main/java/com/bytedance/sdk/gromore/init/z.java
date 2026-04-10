package com.bytedance.sdk.gromore.init;

import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.x;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static String a() {
        return "7.1.0.5";
    }

    public static int z() {
        return gk.dl;
    }

    public static x g() {
        return DispatchAdSdkInitializerHolder.getCsjManger();
    }

    public static String dl() {
        return gk.f1105a;
    }

    public static boolean gc() {
        return DispatchAdSdkInitializerHolder.isInitSuccess();
    }

    public static void z(int i) {
        x xVarG = g();
        if (xVarG != null) {
            xVarG.z(i);
        }
    }

    public static void z(boolean z) {
        x xVarG = g();
        if (xVarG == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_paid", z);
        if (bundle.keySet().isEmpty()) {
            return;
        }
        xVarG.z(SparseArray.class, bundle);
    }
}
