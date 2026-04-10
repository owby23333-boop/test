package com.bytedance.embedapplog;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.embedapplog.gm;

/* JADX INFO: loaded from: classes2.dex */
final class vt implements gm {
    vt() {
    }

    @Override // com.bytedance.embedapplog.gm
    public boolean z(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // com.bytedance.embedapplog.gm
    public gm.z g(Context context) {
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
                gm.z zVar = new gm.z();
                zVar.g = bundleCall.getString("id");
                return zVar;
            }
            String string = bundleCall.getString("message");
            if (!TextUtils.isEmpty(string)) {
                cb.g(string);
            }
            return null;
        } catch (Exception e) {
            cb.z(e);
            return null;
        }
    }
}
