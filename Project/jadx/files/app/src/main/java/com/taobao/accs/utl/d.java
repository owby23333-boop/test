package com.taobao.accs.utl;

import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f18306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccsDataListener f18307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f18308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f18309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ExtraInfo f18310g;

    d(String str, String str2, int i2, AccsDataListener accsDataListener, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        this.a = str;
        this.b = str2;
        this.f18306c = i2;
        this.f18307d = accsDataListener;
        this.f18308e = str3;
        this.f18309f = bArr;
        this.f18310g = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.a)) {
            ALog.e(a.TAG, "onData start", Constants.KEY_DATA_ID, this.b, Constants.KEY_SERVICE_ID, this.a, "command", Integer.valueOf(this.f18306c), "className", this.f18307d.getClass().getName());
        }
        this.f18307d.onData(this.a, this.f18308e, this.b, this.f18309f, this.f18310g);
        if (ALog.isPrintLog(ALog.Level.D) || "accs-impaas".equals(this.a)) {
            ALog.e(a.TAG, "onData end", Constants.KEY_DATA_ID, this.b);
        }
    }
}
