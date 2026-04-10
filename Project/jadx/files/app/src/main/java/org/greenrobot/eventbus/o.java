package org.greenrobot.eventbus;

/* JADX INFO: compiled from: Subscription.java */
/* JADX INFO: loaded from: classes3.dex */
final class o {
    final Object a;
    final m b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile boolean f21352c = true;

    o(Object obj, m mVar) {
        this.a = obj;
        this.b = mVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.a == oVar.a && this.b.equals(oVar.b);
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.f21343f.hashCode();
    }
}
