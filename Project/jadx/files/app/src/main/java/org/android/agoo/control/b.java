package org.android.agoo.control;

import com.taobao.accs.base.TaoBaseService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class b implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TaoBaseService.ExtraInfo f21277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AgooFactory f21278d;

    b(AgooFactory agooFactory, byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        this.f21278d = agooFactory;
        this.a = bArr;
        this.b = str;
        this.f21277c = extraInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21278d.msgReceiverPreHandler(this.a, this.b, this.f21277c, true);
    }
}
