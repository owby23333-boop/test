package org.greenrobot.eventbus;

/* JADX INFO: compiled from: AsyncPoster.java */
/* JADX INFO: loaded from: classes3.dex */
class a implements Runnable, k {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final j f21294s = new j();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final c f21295t;

    a(c cVar) {
        this.f21295t = cVar;
    }

    @Override // org.greenrobot.eventbus.k
    public void a(o oVar, Object obj) {
        this.f21294s.a(i.a(oVar, obj));
        this.f21295t.a().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        i iVarA = this.f21294s.a();
        if (iVarA == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f21295t.a(iVarA);
    }
}
