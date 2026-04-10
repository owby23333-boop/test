package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends RelativeLayout {
    private Runnable ZM;
    protected final c aKI;

    public void o(int i, int i2) {
    }

    protected abstract void onPlayStateChanged(int i);

    protected abstract void reset();

    protected abstract void tx();

    public b(Context context, c cVar) {
        super(context);
        this.aKI = cVar;
    }

    protected final void tD() {
        tE();
        if (this.ZM == null) {
            this.ZM = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.tx();
                    if (b.this.ZM != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.ZM, 1000L);
                    }
                }
            };
        }
        post(this.ZM);
    }

    protected final void tE() {
        Runnable runnable = this.ZM;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.ZM = null;
        }
    }
}
