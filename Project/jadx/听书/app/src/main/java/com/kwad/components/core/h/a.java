package com.kwad.components.core.h;

import android.os.Handler;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {
    private InterfaceC0334a QE;
    private volatile Handler iK;
    private long QB = 1000;
    private boolean QC = true;
    private long QD = 0;
    private float mSpeed = 1.0f;

    /* JADX INFO: renamed from: com.kwad.components.core.h.a$a, reason: collision with other inner class name */
    public interface InterfaceC0334a {
        void D(long j);
    }

    public a(Handler handler) {
        this.iK = handler;
    }

    public final void a(InterfaceC0334a interfaceC0334a) {
        this.QE = interfaceC0334a;
    }

    public final void start() {
        this.QC = false;
        if (this.iK != null) {
            this.iK.post(this);
        }
    }

    public final void pause() {
        this.QC = true;
    }

    public final void resume() {
        this.QC = false;
    }

    public final void stop() {
        if (this.iK != null) {
            this.iK.removeCallbacks(this);
        }
    }

    public final void destroy() {
        stop();
        this.iK = null;
    }

    public final void setSpeed(float f) {
        if (f > 0.0f) {
            this.mSpeed = f;
        }
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC0334a interfaceC0334a;
        if (this.iK != null) {
            if (!this.QC && (interfaceC0334a = this.QE) != null) {
                interfaceC0334a.D(this.QD);
                this.QD += this.QB;
            }
            if (this.iK != null) {
                this.iK.postDelayed(this, (long) (this.QB / this.mSpeed));
            }
        }
    }
}
