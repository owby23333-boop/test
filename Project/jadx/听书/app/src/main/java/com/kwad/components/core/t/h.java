package com.kwad.components.core.t;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes4.dex */
public final class h {
    private long Ek;
    private a YN;
    private long YL = 100;
    private long YM = 0;
    private boolean QC = false;
    private Handler YO = new Handler(Looper.getMainLooper());
    private Runnable YP = new Runnable() { // from class: com.kwad.components.core.t.h.1
        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.YO == null) {
                return;
            }
            if (h.this.QC) {
                h.this.YO.postDelayed(this, h.this.YL / 2);
                return;
            }
            h.this.td();
            if (h.this.YO != null) {
                h.this.YO.postDelayed(this, h.this.YL);
            }
        }
    };

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void onProgress(long j, long j2);
    }

    public h(long j) {
        this.Ek = j;
    }

    public final void start() {
        Handler handler = this.YO;
        if (handler == null) {
            return;
        }
        handler.post(this.YP);
    }

    public final void stop() {
        Handler handler = this.YO;
        if (handler != null) {
            handler.removeCallbacks(this.YP);
            this.YO = null;
        }
    }

    public final void pause() {
        this.QC = true;
    }

    public final void resume() {
        this.QC = false;
    }

    public final void a(a aVar) {
        this.YN = aVar;
    }

    protected final void td() {
        a aVar = this.YN;
        if (aVar != null) {
            long j = this.Ek;
            long j2 = j - this.YM;
            aVar.onProgress(j2, j);
            if (j2 <= 0) {
                stop();
            }
        }
        this.YM += this.YL;
    }
}
