package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class ax {
    private static String TAG = "plugin.signature";

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    private static Signature[] db(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            com.kwad.sdk.core.d.b.w(TAG, "Can not get signature, error = " + e2.getLocalizedMessage());
            com.kwad.sdk.core.d.b.w(TAG, e2);
            return null;
        }
    }

    public static String dc(Context context) {
        try {
            Signature[] signatureArrDb = db(context);
            if (signatureArrDb != null && signatureArrDb.length > 0) {
                return ac.l(signatureArrDb[0].toByteArray());
            }
            return "";
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w(TAG, e2);
            return "";
        }
    }
}
