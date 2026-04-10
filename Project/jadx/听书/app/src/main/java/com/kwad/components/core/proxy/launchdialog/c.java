package com.kwad.components.core.proxy.launchdialog;

import com.kwad.components.core.proxy.launchdialog.g;
import com.kwad.components.core.proxy.n;
import com.kwad.sdk.utils.bw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements n {
    private static long Wr = 7000;
    private DetectEventType Ws;
    private WeakReference<com.kwad.components.core.proxy.a> Wt;
    private List<g> Wu = new ArrayList();
    private a Wv = new a(this, 0);
    private boolean started = false;

    public c(DetectEventType detectEventType, com.kwad.components.core.proxy.a aVar, g... gVarArr) {
        this.Ws = detectEventType;
        this.Wt = new WeakReference<>(aVar);
        this.Wu.addAll(Arrays.asList(gVarArr));
    }

    public final void a(f fVar) {
        this.Wv.Wx = fVar;
    }

    public final boolean b(DetectEventType detectEventType) {
        return detectEventType != null && detectEventType.equals(this.Ws);
    }

    public final void start() {
        this.started = true;
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "start call: " + this.Ws);
        bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.proxy.launchdialog.c.1
            @Override // java.lang.Runnable
            public final void run() {
                c.this.Wv.l(c.this.rY());
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DETECT_TIMEOUT call: " + c.this.Ws);
                c.this.stop();
            }
        }, Wr);
        d dVarRU = rU();
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "start call current: " + dVarRU + this.Ws);
        a(dVarRU);
    }

    public final void stop() {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "stop call: " + this.Ws);
        this.Wv.stop();
        this.started = false;
    }

    private d rU() {
        com.kwad.components.core.proxy.a aVar;
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.Wt;
        if (weakReference == null || weakReference.get() == null || (aVar = this.Wt.get()) == null) {
            return null;
        }
        return aVar.rU();
    }

    private void a(d dVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "checkMatch event: " + dVar);
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.Wt;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        if (this.Wu.size() == 0) {
            this.Wv.k(rY());
            return;
        }
        g gVar = this.Wu.get(0);
        if (gVar instanceof g.a) {
            if (this.Wu.size() < 2) {
                this.Wv.m(rY());
                return;
            }
            g gVar2 = this.Wu.get(1);
            if (!(gVar2 instanceof g.b)) {
                this.Wv.m(rY());
                return;
            }
            d dVarRT = this.Wt.get().rT();
            g.b bVar = (g.b) gVar2;
            long jSb = dVarRT.sb();
            com.kwad.sdk.core.d.c.d("LifecycleSequence", "checkMatch last: " + dVarRT);
            g.a aVar = (g.a) gVar;
            if (aVar.K(jSb) && bVar.b(dVar.sa())) {
                this.Wu.remove(gVar);
                this.Wu.remove(gVar2);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem remove first: " + gVar + this.Ws);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem remove second: " + gVar2 + this.Ws);
                if (rX()) {
                    return;
                }
                this.Wv.j(rY());
                return;
            }
            com.kwad.sdk.core.d.c.d("LifecycleSequence", "DurationMoreThanItem not match two: " + aVar.K(jSb) + ", " + bVar.b(dVar.sa()));
            this.Wv.m(rY());
            return;
        }
        if (gVar instanceof g.b) {
            if (((g.b) gVar).b(dVar.sa())) {
                this.Wu.remove(gVar);
                com.kwad.sdk.core.d.c.d("LifecycleSequence", "PageEventItem remove: " + gVar);
                if (rX()) {
                    return;
                }
                this.Wv.j(rY());
                return;
            }
            this.Wv.m(rY());
        }
    }

    private boolean rX() {
        if (this.Wu.size() != 0) {
            return false;
        }
        this.Wv.k(rY());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.proxy.a rY() {
        WeakReference<com.kwad.components.core.proxy.a> weakReference = this.Wt;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.kwad.components.core.proxy.k
    public final void a(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(rU());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void b(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(rU());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void c(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", "LifecycleSequence onResume: " + aVar.getPageName() + " , type:" + this.Ws);
        if (this.started) {
            a(rU());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void d(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", this.started + " LifecycleSequence onPause: " + aVar.getPageName() + " , type:" + this.Ws);
        if (this.started) {
            a(rU());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void e(com.kwad.components.core.proxy.a aVar) {
        com.kwad.sdk.core.d.c.d("LifecycleSequence", this.started + " LifecycleSequence onStop: " + aVar.getPageName() + " , type:" + this.Ws);
        if (this.started) {
            a(rU());
        }
    }

    @Override // com.kwad.components.core.proxy.k
    public final void f(com.kwad.components.core.proxy.a aVar) {
        if (this.started) {
            a(rU());
        }
    }

    @Override // com.kwad.components.core.proxy.n
    public final boolean g(com.kwad.components.core.proxy.a aVar) {
        WeakReference<com.kwad.components.core.proxy.a> weakReference;
        if (aVar == null || (weakReference = this.Wt) == null || weakReference.get() == null) {
            return false;
        }
        return this.Wt.get().equals(aVar);
    }

    class a implements f {
        private f Wx;
        private boolean Wy;

        private a() {
            this.Wy = false;
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            rZ();
            this.Wx = null;
        }

        private void rZ() {
            this.Wy = true;
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void j(com.kwad.components.core.proxy.a aVar) {
            f fVar = this.Wx;
            if (fVar == null) {
                return;
            }
            fVar.j(aVar);
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void k(com.kwad.components.core.proxy.a aVar) {
            f fVar;
            if (this.Wy || (fVar = this.Wx) == null) {
                return;
            }
            fVar.k(aVar);
            rZ();
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void l(com.kwad.components.core.proxy.a aVar) {
            f fVar;
            if (this.Wy || (fVar = this.Wx) == null) {
                return;
            }
            fVar.l(aVar);
            rZ();
        }

        @Override // com.kwad.components.core.proxy.launchdialog.f
        public final void m(com.kwad.components.core.proxy.a aVar) {
            f fVar;
            if (this.Wy || (fVar = this.Wx) == null) {
                return;
            }
            fVar.m(aVar);
            rZ();
        }
    }
}
