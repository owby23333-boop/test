package com.bytedance.embedapplog;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.rk;

/* JADX INFO: loaded from: classes.dex */
final class zr implements rk {
    @Override // com.bytedance.embedapplog.rk
    public boolean bf(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // com.bytedance.embedapplog.rk
    public rk.e d(Context context) {
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return null;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                return null;
            }
            if (bundleCall.getInt("code", -1) == 0) {
                rk.e eVar = new rk.e();
                eVar.bf = bundleCall.getString("id");
                return eVar;
            }
            String string = bundleCall.getString("message");
            if (!TextUtils.isEmpty(string)) {
                tx.bf(string);
            }
            return null;
        } catch (Exception e) {
            tx.e(e);
            return null;
        }
    }
}
