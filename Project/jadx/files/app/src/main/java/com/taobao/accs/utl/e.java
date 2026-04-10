package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class e implements Runnable {
    final /* synthetic */ NetPerformanceMonitor a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f18311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f18312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f18313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f18314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Intent f18315g;

    e(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i2, byte[] bArr, Intent intent) {
        this.a = netPerformanceMonitor;
        this.b = str;
        this.f18311c = str2;
        this.f18312d = accsDataListener;
        this.f18313e = i2;
        this.f18314f = bArr;
        this.f18315g = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetPerformanceMonitor netPerformanceMonitor = this.a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.b)) {
            ALog.e(a.TAG, "onResponse start dataId:" + this.f18311c + " serviceId:" + this.b, new Object[0]);
        }
        this.f18312d.onResponse(this.b, this.f18311c, this.f18313e, this.f18314f, a.c(this.f18315g));
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.b)) {
            ALog.e(a.TAG, "onResponse end dataId:" + this.f18311c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.a);
    }
}
