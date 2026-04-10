package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes8.dex */
class bh implements Callable<bi> {
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public bi call() {
        NetworkInfo activeNetworkInfo;
        Context contextM693a = C0855r.m693a();
        if (contextM693a == null) {
            return null;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) contextM693a.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return null;
            }
            return new bi(activeNetworkInfo);
        } catch (Exception unused) {
            return null;
        }
    }
}
