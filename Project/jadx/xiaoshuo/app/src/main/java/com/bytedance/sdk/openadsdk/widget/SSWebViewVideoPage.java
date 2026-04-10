package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.bytedance.sdk.component.widget.SSWebView;

/* JADX INFO: loaded from: classes10.dex */
public class SSWebViewVideoPage extends SSWebView {
    private float bf;
    private boolean d;
    private boolean e;
    private ViewParent tg;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.e = true;
        this.bf = -1.0f;
        this.d = false;
        w();
    }

    private void w() {
    }

    public void bf(boolean z) {
        if (((ScrollView) this.tg).getScrollY() == 0) {
            if (z) {
                t();
                return;
            } else {
                s();
                return;
            }
        }
        if (!this.e) {
            t();
        } else if (z) {
            s();
        } else {
            t();
        }
    }

    @Override // android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0 && z2) {
            this.e = true;
        } else {
            this.e = false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.tg == null) {
            this.tg = e(this);
        }
        if (motionEvent.getAction() == 0) {
            this.bf = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.bf;
            if (y > 0.0f) {
                bf(true);
            } else if (y != 0.0f && y < 0.0f) {
                bf(false);
            }
            this.bf = motionEvent.getY();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            t();
            this.d = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void s() {
        if (this.d) {
            return;
        }
        this.tg.requestDisallowInterceptTouchEvent(false);
        this.d = true;
    }

    public void t() {
        if (this.d) {
            return;
        }
        this.tg.requestDisallowInterceptTouchEvent(true);
        this.d = true;
    }

    public SSWebViewVideoPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = true;
        this.bf = -1.0f;
        this.d = false;
        w();
    }

    public SSWebViewVideoPage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = true;
        this.bf = -1.0f;
        this.d = false;
        w();
    }
}
