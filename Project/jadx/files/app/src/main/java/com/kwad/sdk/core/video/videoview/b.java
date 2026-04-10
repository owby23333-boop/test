package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends RelativeLayout {
    private Runnable QH;

    @NonNull
    protected final c amO;

    public b(Context context, @NonNull c cVar) {
        super(context);
        this.amO = cVar;
    }

    public void l(int i2, int i3) {
    }

    protected abstract void onPlayStateChanged(int i2);

    protected final void qA() {
        qB();
        if (this.QH == null) {
            this.QH = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.qu();
                    if (b.this.QH != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.QH, 1000L);
                    }
                }
            };
        }
        post(this.QH);
    }

    protected final void qB() {
        Runnable runnable = this.QH;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.QH = null;
        }
    }

    protected abstract void qu();

    protected abstract void reset();
}
