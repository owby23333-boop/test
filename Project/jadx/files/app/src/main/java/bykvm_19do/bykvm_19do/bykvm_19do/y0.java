package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;

/* JADX INFO: loaded from: classes.dex */
final class y0 implements a1 {
    y0() {
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        Bundle bundleCall;
        Uri uri = Uri.parse("content://cn.nubia.identity/identity");
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (Build.VERSION.SDK_INT > 17) {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(uri);
            if (contentProviderClientAcquireContentProviderClient == null) {
                return null;
            }
            bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.close();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
        } else {
            bundleCall = context.getContentResolver().call(uri, "getOAID", (String) null, (Bundle) null);
        }
        if (bundleCall != null) {
            if (bundleCall.getInt("code", -1) == 0) {
                a1.a aVar = new a1.a();
                aVar.a = bundleCall.getString("id");
                return aVar;
            }
            TextUtils.isEmpty(bundleCall.getString("message"));
        }
        return null;
    }
}
