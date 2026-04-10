package com.market.sdk.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import com.market.sdk.utils.PrefUtils;

/* JADX INFO: loaded from: classes7.dex */
public class AppGlobal {
    private static Context sContext;

    public static ContentResolver getContentResolver() {
        return sContext.getContentResolver();
    }

    public static Context getContext() {
        Context context = sContext;
        if (context != null) {
            return context;
        }
        throw new IllegalArgumentException("sContext is null,should call setContext first!!");
    }

    public static PackageManager getPackageManager() {
        return sContext.getPackageManager();
    }

    private static void init() {
        if (PrefUtils.getLong(com.market.sdk.Constants.SDK_BEGIN_TIME, new PrefUtils.PrefFile[0]) == 0) {
            PrefUtils.setLong(com.market.sdk.Constants.SDK_BEGIN_TIME, System.currentTimeMillis(), new PrefUtils.PrefFile[0]);
        }
    }

    public static void setContext(Context context) {
        sContext = context.getApplicationContext();
        init();
    }

    @Deprecated
    public static void setContext(Activity activity) {
        sContext = activity;
        init();
    }
}
