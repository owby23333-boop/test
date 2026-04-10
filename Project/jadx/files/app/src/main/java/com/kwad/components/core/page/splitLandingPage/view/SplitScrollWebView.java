package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.r.e;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes3.dex */
public class SplitScrollWebView extends KsAdWebView {
    private int MT;
    private boolean Nq;
    private a Nr;
    private float Ns;
    private boolean Nt;

    public interface a {
        void d(float f2);

        boolean pi();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Nq = false;
        pc();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nq = false;
        pc();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Nq = false;
        pc();
    }

    private void pc() {
        this.MT = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.MT != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.b.kwai.a.d((Activity) getContext()) : com.kwad.sdk.b.kwai.a.getScreenHeight(getContext())) - (e.qe() ? com.kwad.sdk.b.kwai.a.getStatusBarHeight(getContext()) : 0)) - this.MT, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (this.Nq) {
            return super.onTouchEvent(motionEventObtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y2 = motionEvent.getY();
        if (actionMasked == 0) {
            this.Ns = y2;
            this.Nt = false;
            return super.onTouchEvent(motionEvent);
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float f2 = this.Ns;
                float f3 = f2 - y2;
                a aVar = this.Nr;
                if (aVar != null && y2 <= f2) {
                    this.Nt = true;
                    aVar.d(f3);
                }
                return super.onTouchEvent(motionEventObtain);
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        if (this.Nr == null) {
            return false;
        }
        if ((this.Ns - y2 < 0.0f && !this.Nt) || !this.Nr.pi()) {
            return false;
        }
        this.Nq = true;
        return false;
    }

    public void setDisableAnimation(boolean z2) {
        this.Nq = z2;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.Nr = aVar;
    }
}
