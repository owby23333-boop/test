package org.android.agoo.control;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AgooFactory f21280c;

    e(AgooFactory agooFactory, String str, String str2) {
        this.f21280c = agooFactory;
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21280c.updateMsgStatus(this.a, this.b);
    }
}
