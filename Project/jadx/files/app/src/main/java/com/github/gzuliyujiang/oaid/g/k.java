package com.github.gzuliyujiang.oaid.g;

import android.annotation.SuppressLint;
import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.github.gzuliyujiang.oaid.OAIDException;

/* JADX INFO: compiled from: NubiaImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements com.github.gzuliyujiang.oaid.d {
    private final Context a;

    public k(Context context) {
        this.a = context;
    }

    @Override // com.github.gzuliyujiang.oaid.d
    @SuppressLint({"AnnotateVersionCheck"})
    public boolean a() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public void a(com.github.gzuliyujiang.oaid.c cVar) {
        if (this.a == null || cVar == null) {
            return;
        }
        if (!a()) {
            com.github.gzuliyujiang.oaid.e.a("Only supports Android 10.0 and above for Nubia");
            cVar.a(new OAIDException("Only supports Android 10.0 and above for Nubia"));
            return;
        }
        try {
            ContentProviderClient contentProviderClientAcquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(Uri.parse("content://cn.nubia.identity/identity"));
            if (contentProviderClientAcquireContentProviderClient == null) {
                return;
            }
            Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call("getOAID", null, null);
            if (Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireContentProviderClient.close();
            } else {
                contentProviderClientAcquireContentProviderClient.release();
            }
            if (bundleCall == null) {
                throw new OAIDException("OAID query failed: bundle is null");
            }
            String string = bundleCall.getInt("code", -1) == 0 ? bundleCall.getString("id") : null;
            if (string == null || string.length() == 0) {
                throw new OAIDException("OAID query failed: " + bundleCall.getString("message"));
            }
            com.github.gzuliyujiang.oaid.e.a("OAID query success: " + string);
            cVar.a(string);
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
            cVar.a(e2);
        }
    }
}
