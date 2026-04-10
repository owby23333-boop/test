package anetwork.channel.aidl.j;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ byte f557s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ Object f558t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ d f559u;

    e(d dVar, byte b, Object obj) {
        this.f559u = dVar;
        this.f557s = b;
        this.f558t = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f559u.b(this.f557s, this.f558t);
    }
}
