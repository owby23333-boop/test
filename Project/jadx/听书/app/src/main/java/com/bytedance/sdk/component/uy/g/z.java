package com.bytedance.sdk.component.uy.g;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.l;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private Handler dl;
    private Handler g;
    private final a<g> z;

    private z() {
        this.z = a.z(2);
    }

    public static z z() {
        return C0143z.z;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.uy.g.z$z, reason: collision with other inner class name */
    private static class C0143z {
        private static final z z = new z();
    }

    public Handler g() {
        if (this.g == null) {
            synchronized (z.class) {
                if (this.g == null) {
                    this.g = z("csj_io_handler");
                }
            }
        }
        return this.g;
    }

    public Handler dl() {
        if (this.dl == null) {
            synchronized (z.class) {
                if (this.dl == null) {
                    this.dl = z("csj_main_handler");
                }
            }
        }
        return this.dl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final Handler handler, final Handler handler2) {
        if (handler.getLooper().getQueue().isIdle()) {
            handler.removeCallbacksAndMessages(null);
            handler.getLooper().quit();
        } else {
            handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.uy.g.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.z(handler, handler2);
                }
            }, 1000L);
        }
    }

    public l z(l.z zVar, final String str) {
        g gVar = (g) this.z.z();
        if (gVar != null) {
            gVar.z(zVar);
            gVar.post(new Runnable() { // from class: com.bytedance.sdk.component.uy.g.z.2
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return gVar;
        }
        return g(zVar, str);
    }

    public l z(String str) {
        return z((l.z) null, str);
    }

    private g g(l.z zVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new g(handlerThread, zVar);
    }

    public boolean z(l lVar) {
        if (!(lVar instanceof g)) {
            return false;
        }
        g gVar = (g) lVar;
        if (this.z.z(gVar)) {
            return true;
        }
        gVar.g();
        return true;
    }
}
