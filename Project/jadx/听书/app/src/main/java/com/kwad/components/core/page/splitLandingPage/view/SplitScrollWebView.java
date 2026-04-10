package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.kwad.components.core.t.d;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: classes4.dex */
public class SplitScrollWebView extends KsAdWebView {
    private int UZ;
    private boolean VA;
    private boolean Vx;
    private a Vy;
    private float Vz;

    public interface a {
        void f(float f);

        boolean rL();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Vx = false;
        rF();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Vx = false;
        rF();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Vx = false;
        rF();
    }

    public void setDisableAnimation(boolean z) {
        this.Vx = z;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.Vy = aVar;
    }

    private void rF() {
        this.UZ = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int screenHeight;
        if (this.UZ != 0) {
            int statusBarHeight = d.tc() ? com.kwad.sdk.c.a.a.getStatusBarHeight(getContext()) : 0;
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.c.a.a.g((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - statusBarHeight) - this.UZ, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (this.Vx) {
            return super.onTouchEvent(motionEventObtain);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        float y = motionEvent.getY();
        if (actionMasked == 0) {
            this.Vz = y;
            this.VA = false;
            return super.onTouchEvent(motionEvent);
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float f = this.Vz;
                float f2 = f - y;
                a aVar = this.Vy;
                if (aVar != null && y <= f) {
                    this.VA = true;
                    aVar.f(f2);
                }
                return super.onTouchEvent(motionEventObtain);
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        a aVar2 = this.Vy;
        if (aVar2 == null) {
            return false;
        }
        if ((this.Vz - y < 0.0f && !this.VA) || !aVar2.rL()) {
            return false;
        }
        this.Vx = true;
        return false;
    }
}
