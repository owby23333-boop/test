package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.f;
import org.greenrobot.eventbus.g;

/* JADX INFO: compiled from: EventBusBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final ExecutorService f21322m = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f21325e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f21327g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f21328h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    List<org.greenrobot.eventbus.p.b> f21330j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    f f21331k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    g f21332l;
    boolean a = true;
    boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f21323c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f21324d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f21326f = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    ExecutorService f21329i = f21322m;

    d() {
    }

    Object a() {
        try {
            return Looper.getMainLooper();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    f b() {
        f fVar = this.f21331k;
        return fVar != null ? fVar : (!f.a.a() || a() == null) ? new f.b() : new f.a("EventBus");
    }

    g c() {
        Object objA;
        g gVar = this.f21332l;
        if (gVar != null) {
            return gVar;
        }
        if (!f.a.a() || (objA = a()) == null) {
            return null;
        }
        return new g.a((Looper) objA);
    }
}
