package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.j;

/* JADX INFO: loaded from: classes3.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long anM;
    private float anN;
    private boolean anO;
    private boolean anP;
    private ViewTreeObserver.OnScrollChangedListener anQ;
    private ViewTreeObserver anR;
    private bj anS;
    private j cK;
    private int my;

    public AdBasePvFrameLayout(@NonNull Context context) {
        super(context);
        this.anM = 500L;
        this.anN = 0.1f;
        this.anP = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anM = 500L;
        this.anN = 0.1f;
        this.anP = true;
        init();
    }

    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.anM = 500L;
        this.anN = 0.1f;
        this.anP = true;
        init();
    }

    private void init() {
        this.anS = new bj(this);
        this.my = k.getScreenHeight(getContext());
        this.anP = true;
    }

    private void yY() {
        if (this.anP) {
            yZ();
        }
    }

    private void yZ() {
        if (zb()) {
            za();
        } else {
            zc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zb() {
        if (!this.anS.EW() || Math.abs(this.anS.aAq.height() - getHeight()) > getHeight() * (1.0f - this.anN) || getHeight() <= 0 || getWidth() <= 0) {
            return false;
        }
        Rect rect = this.anS.aAq;
        return rect.bottom > 0 && rect.top < this.my;
    }

    private void zc() {
        if (this.anQ == null) {
            this.anQ = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.zb()) {
                        AdBasePvFrameLayout.this.za();
                    }
                }
            };
            this.anR = getViewTreeObserver();
            ViewTreeObserver viewTreeObserver = this.anR;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.anQ);
            }
        }
    }

    private void zd() {
        try {
            if (this.anQ != null && this.anR != null && this.anR.isAlive()) {
                this.anR.removeOnScrollChangedListener(this.anQ);
            }
            this.anQ = null;
        } catch (Exception e2) {
            b.printStackTrace(e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        zc();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zd();
        this.anO = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        boolean z2 = true;
        if (this.anO || (i4 | i5) != 0 || (i2 | i3) == 0) {
            z2 = false;
        } else {
            this.anO = true;
        }
        super.onSizeChanged(i2, i3, i4, i5);
        if (z2) {
            yY();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f2) {
        this.anN = f2;
    }

    public void setVisibleListener(j jVar) {
        this.cK = jVar;
    }

    protected final void za() {
        zd();
        j jVar = this.cK;
        if (jVar != null) {
            jVar.aw();
        }
    }
}
