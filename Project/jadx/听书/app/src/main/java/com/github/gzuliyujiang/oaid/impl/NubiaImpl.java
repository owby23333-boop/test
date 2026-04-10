package com.github.gzuliyujiang.oaid.impl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.github.gzuliyujiang.oaid.IGetter;
import com.github.gzuliyujiang.oaid.IOAID;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.OAIDLog;

/* JADX INFO: loaded from: classes3.dex */
class NubiaImpl implements IOAID {
    private final Context context;

    public NubiaImpl(Context context) {
        this.context = context;
    }

    @Override // com.github.gzuliyujiang.oaid.IOAID
    public boolean supported() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.github.gzuliyujiang.oaid.IOAID
    public void doGet(final IGetter getter) {
        if (this.context == null || getter == null) {
            return;
        }
        if (!supported()) {
            OAIDLog.print("Only supports Android 10.0 and above for Nubia");
            getter.onOAIDGetError(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.context.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            contentProviderClientAcquireContentProviderClient.close();
            if (bundleCall == null) {
                throw new OAIDException("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new OAIDException("OAID query failed: " + bundleCall.getString("message"));
            }
            OAIDLog.print("OAID query success: " + string);
            getter.onOAIDGetComplete(string);
        } catch (Exception e) {
            OAIDLog.print(e);
            getter.onOAIDGetError(e);
        }
    }
}
