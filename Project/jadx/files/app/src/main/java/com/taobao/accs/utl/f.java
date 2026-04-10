package com.taobao.accs.utl;

import android.content.Intent;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class f implements Runnable {
    final /* synthetic */ NetPerformanceMonitor a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f18316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f18317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f18318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Intent f18319f;

    f(NetPerformanceMonitor netPerformanceMonitor, String str, String str2, AccsDataListener accsDataListener, int i2, Intent intent) {
        this.a = netPerformanceMonitor;
        this.b = str;
        this.f18316c = str2;
        this.f18317d = accsDataListener;
        this.f18318e = i2;
        this.f18319f = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetPerformanceMonitor netPerformanceMonitor = this.a;
        if (netPerformanceMonitor != null) {
            netPerformanceMonitor.real_to_bz_date = System.currentTimeMillis();
        }
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.b)) {
            ALog.e(a.TAG, "onSendData start dataId:" + this.f18316c + " serviceId:" + this.b, new Object[0]);
        }
        this.f18317d.onSendData(this.b, this.f18316c, this.f18318e, a.c(this.f18319f));
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.b)) {
            ALog.e(a.TAG, "onSendData end dataId:" + this.f18316c, new Object[0]);
        }
        AppMonitor.getInstance().commitStat(this.a);
    }
}
