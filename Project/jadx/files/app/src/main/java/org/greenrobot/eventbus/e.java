package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: HandlerPoster.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends Handler implements k {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final j f21333s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f21334t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final c f21335u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f21336v;

    protected e(c cVar, Looper looper, int i2) {
        super(looper);
        this.f21335u = cVar;
        this.f21334t = i2;
        this.f21333s = new j();
    }

    @Override // org.greenrobot.eventbus.k
    public void a(o oVar, Object obj) {
        i iVarA = i.a(oVar, obj);
        synchronized (this) {
            this.f21333s.a(iVarA);
            if (!this.f21336v) {
                this.f21336v = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                i iVarA = this.f21333s.a();
                if (iVarA == null) {
                    synchronized (this) {
                        iVarA = this.f21333s.a();
                        if (iVarA == null) {
                            this.f21336v = false;
                            return;
                        }
                    }
                }
                this.f21335u.a(iVarA);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f21334t);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.f21336v = true;
        } finally {
            this.f21336v = false;
        }
    }
}
