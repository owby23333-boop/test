package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: classes4.dex */
public class NubiaDeviceIDHelper {
    private static final String TAG = "NubiaDeviceIDHelper";
    private Context mContext;

    public NubiaDeviceIDHelper(Context context) {
        this.mContext = context;
    }

    public String getOAID() {
        String string;
        string = "";
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall != null) {
                string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : "";
                LiteApiLogger.i(TAG, "getOAID oaid:" + string + "faledMsg:" + bundleCall.getString("message"));
            }
        } catch (Exception e) {
            LiteApiLogger.i(TAG, "getOAID fail");
            LiteApiLogger.printStackTraceOnly(e);
        }
        return string;
    }
}
