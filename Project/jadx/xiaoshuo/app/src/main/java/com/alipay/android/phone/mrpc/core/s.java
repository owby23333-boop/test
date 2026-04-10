package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f1661a;

    public static final boolean a(Context context) {
        Boolean bool = f1661a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean boolValueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            f1661a = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Exception e) {
            Log.e("MiscUtils", "", e);
            return false;
        }
    }
}
