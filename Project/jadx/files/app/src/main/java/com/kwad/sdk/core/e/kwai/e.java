package com.kwad.sdk.core.e.kwai;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String string;
        Bundle bundleCall;
        string = "";
        try {
            Uri uri = Uri.parse("content://cn.nubia.identity/identity");
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(uri);
                bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireContentProviderClient.close();
                } else {
                    contentProviderClientAcquireContentProviderClient.release();
                }
            } else {
                bundleCall = this.mContext.getContentResolver().call(uri, "getOAID", (String) null, (Bundle) null);
            }
            if (bundleCall != null) {
                string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : "";
                String string2 = bundleCall.getString("message");
                StringBuilder sb = new StringBuilder("getOAID oaid:");
                sb.append(string);
                sb.append("faledMsg:");
                sb.append(string2);
            }
        } catch (Exception unused) {
        }
        return string;
    }
}
