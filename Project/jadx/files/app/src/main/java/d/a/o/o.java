package d.a.o;

import d.a.o.m.a;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class o implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ m f20764s;

    o(m mVar) {
        this.f20764s = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar = this.f20764s;
        mVar.new a(0, mVar.a.a.a(), this.f20764s.a.b).a(this.f20764s.a.a.a(), this.f20764s.a.b);
    }
}
