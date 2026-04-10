package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.widget.l;

/* JADX INFO: loaded from: classes4.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long aLM;
    private float aLN;
    private boolean aLO;
    private boolean aLP;
    private ViewTreeObserver.OnScrollChangedListener aLQ;
    private ViewTreeObserver aLR;
    private by aLS;
    private l eF;
    private int oC;

    public AdBasePvFrameLayout(Context context) {
        super(context);
        this.aLM = 500L;
        this.aLN = 0.1f;
        this.aLP = true;
        init();
    }

    public AdBasePvFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLM = 500L;
        this.aLN = 0.1f;
        this.aLP = true;
        init();
    }

    public AdBasePvFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLM = 500L;
        this.aLN = 0.1f;
        this.aLP = true;
        init();
    }

    private void init() {
        this.aLS = new by(this);
        this.oC = m.getScreenHeight(getContext());
        this.aLP = true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z;
        if (this.aLO || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            z = true;
            this.aLO = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            qm();
        }
    }

    private void qm() {
        if (this.aLP) {
            KD();
        }
    }

    private void KD() {
        if (KF()) {
            KE();
        } else {
            KG();
        }
    }

    protected final void KE() {
        KH();
        l lVar = this.eF;
        if (lVar != null) {
            lVar.aT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean KF() {
        return this.aLS.So() && ((float) Math.abs(this.aLS.bbF.height() - getHeight())) <= ((float) getHeight()) * (1.0f - this.aLN) && getHeight() > 0 && getWidth() > 0 && this.aLS.bbF.bottom > 0 && this.aLS.bbF.top < this.oC;
    }

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.aLN = f;
    }

    private void KG() {
        if (this.aLQ == null) {
            this.aLQ = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.KF()) {
                        AdBasePvFrameLayout.this.KE();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.aLR = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aLQ);
            }
        }
    }

    private void KH() {
        ViewTreeObserver viewTreeObserver;
        try {
            if (this.aLQ != null && (viewTreeObserver = this.aLR) != null && viewTreeObserver.isAlive()) {
                this.aLR.removeOnScrollChangedListener(this.aLQ);
            }
            this.aLQ = null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KH();
        this.aLO = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        KG();
    }

    public void setVisibleListener(l lVar) {
        this.eF = lVar;
    }
}
