package d.a.o;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class l {
    public final anetwork.channel.entity.h a;
    public d.a.m.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile AtomicBoolean f20760d = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile a f20761e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Future f20762f = null;

    public l(anetwork.channel.entity.h hVar, d.a.m.a aVar) {
        this.a = hVar;
        this.f20759c = hVar.f591i;
        this.b = aVar;
    }

    public void a() {
        Future future = this.f20762f;
        if (future != null) {
            future.cancel(true);
            this.f20762f = null;
        }
    }

    public void b() {
        if (this.f20761e != null) {
            this.f20761e.cancel();
            this.f20761e = null;
        }
    }
}
