package com.mibi.sdk.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import com.mibi.sdk.common.Utils;

/* JADX INFO: loaded from: classes13.dex */
public final class MibiEnvironment {
    public static final String KEY_IS_STAGING = "mibi_sdk_is_staging";
    private static final String TAG = "MibiEnvironment";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context sAppContext;

    private MibiEnvironment() {
    }

    public static boolean isStaging() {
        if (sAppContext != null) {
            return Utils.getBooleanPref(sAppContext, KEY_IS_STAGING, false);
        }
        MibiLog.d(TAG, "context can't be null");
        return false;
    }

    public static void setStaging(Context context, boolean z) {
        if (context == null || context.getApplicationContext() == null) {
            MibiLog.d(TAG, "context or context.getApplicationContext() can't be null");
        } else {
            sAppContext = context.getApplicationContext();
            Utils.setBooleanPref(context, KEY_IS_STAGING, z);
        }
    }
}
