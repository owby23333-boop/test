package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.k;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private final i aCh;
    private boolean aCj;
    private boolean aCk;
    private ViewTreeObserver.OnScrollChangedListener aCm;
    private final bj anS;
    private final View mView;
    private final int my;
    private float aCi = 0.1f;
    private boolean aCl = true;

    public g(View view, i iVar) {
        this.mView = view;
        this.aCh = iVar;
        this.anS = new bj(view);
        this.my = k.getScreenHeight(view.getContext());
    }

    private void Fy() {
        if (Fz()) {
            aw();
        } else {
            zd();
            zc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fz() {
        if (this.anS.EW() && Math.abs(this.anS.aAq.height() - this.mView.getHeight()) <= this.mView.getHeight() * (1.0f - this.aCi) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            Rect rect = this.anS.aAq;
            if (rect.bottom > 0 && rect.top < this.my) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw() {
        zd();
        i iVar = this.aCh;
        if (iVar != null) {
            iVar.onFirstVisible(this.mView);
        }
    }

    private void yY() {
        if (this.aCl) {
            Fy();
        }
    }

    private void zc() {
        if (this.aCm == null) {
            this.aCm = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.g.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (g.this.Fz()) {
                        g.this.aw();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aCm);
            }
        }
    }

    private void zd() {
        if (this.aCm == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.aCm);
            }
            this.aCm = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    public final void Fx() {
        if (this.aCk) {
            yY();
        }
    }

    public final void b(int i2, int i3, int i4, int i5) {
        this.aCk = false;
        if (this.aCj || (i4 | i5) != 0 || (i2 | i3) == 0) {
            return;
        }
        this.aCk = true;
        this.aCj = true;
    }

    public final void bE(boolean z2) {
        this.aCl = z2;
    }

    public final float getVisiblePercent() {
        return this.aCi;
    }

    public final void onAttachedToWindow() {
        zc();
    }

    public final void onDetachedFromWindow() {
        zd();
        this.aCj = false;
    }

    public final void resetPvAfterDataChange() {
        Fy();
    }

    public final void setVisiblePercent(float f2) {
        this.aCi = f2;
    }
}
