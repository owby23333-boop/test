package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

/* JADX INFO: loaded from: classes8.dex */
class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f7449a;

    public s(Context context) {
        this.f7449a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f7449a.getPackageManager().getPackageInfo(this.f7449a.getPackageName(), 4612);
            r.c(this.f7449a);
            r.d(this.f7449a, packageInfo);
            r.c(this.f7449a, packageInfo);
        } catch (Throwable th) {
            Log.e("ManifestChecker", "", th);
        }
    }
}
