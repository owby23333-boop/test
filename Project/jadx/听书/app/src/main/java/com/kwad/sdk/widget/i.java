package com.kwad.sdk.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.m;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    private final by aLS;
    private final k bdG;
    private boolean bdI;
    private boolean bdJ;
    private ViewTreeObserver.OnScrollChangedListener bdL;
    private final View mView;
    private final int oC;
    private float bdH = 0.1f;
    private boolean bdK = true;

    public i(View view, k kVar) {
        this.mView = view;
        this.bdG = kVar;
        this.aLS = new by(view);
        this.oC = m.getScreenHeight(view.getContext());
    }

    public final void co(boolean z) {
        this.bdK = z;
    }

    public final void setVisiblePercent(float f) {
        this.bdH = f;
    }

    public final float getVisiblePercent() {
        return this.bdH;
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.bdJ = false;
        if (this.bdI || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.bdJ = true;
        this.bdI = true;
    }

    public final void SP() {
        if (this.bdJ) {
            qm();
        }
    }

    public final void onAttachedToWindow() {
        KG();
    }

    public final void onDetachedFromWindow() {
        KH();
        this.bdI = false;
    }

    private void qm() {
        if (this.bdK) {
            SQ();
        }
    }

    private void SQ() {
        if (SR()) {
            aT();
        } else {
            KH();
            KG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT() {
        try {
            KH();
            k kVar = this.bdG;
            if (kVar != null) {
                kVar.E(this.mView);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SR() {
        return this.aLS.So() && ((float) Math.abs(this.aLS.bbF.height() - this.mView.getHeight())) <= ((float) this.mView.getHeight()) * (1.0f - this.bdH) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0 && this.aLS.bbF.bottom > 0 && this.aLS.bbF.top < this.oC;
    }

    private void KG() {
        if (this.bdL == null) {
            this.bdL = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.i.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (i.this.SR()) {
                        i.this.aT();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.bdL);
            }
        }
    }

    private void KH() {
        if (this.bdL == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.bdL);
            }
            this.bdL = null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
