package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.ScrollView;
import com.bytedance.sdk.component.widget.SSWebView;

/* JADX INFO: loaded from: classes3.dex */
public class SSWebViewVideoPage extends SSWebView {
    private boolean e;
    private boolean gc;
    private ViewParent gz;
    private float m;

    public SSWebViewVideoPage(Context context) {
        super(context);
        this.gc = true;
        this.m = -1.0f;
        this.e = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gz == null) {
            this.gz = z((View) this);
        }
        if (motionEvent.getAction() == 0) {
            this.m = motionEvent.getY();
        } else if (motionEvent.getAction() == 2) {
            float y = motionEvent.getY() - this.m;
            if (y > 0.0f) {
                z(true);
            } else if (y != 0.0f && y < 0.0f) {
                z(false);
            }
            this.m = motionEvent.getY();
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            m();
            this.e = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void z(boolean z) {
        if (((ScrollView) this.gz).getScrollY() == 0) {
            if (z) {
                m();
                return;
            } else {
                e();
                return;
            }
        }
        if (!this.gc) {
            m();
        } else if (z) {
            e();
        } else {
            m();
        }
    }

    public void m() {
        if (this.e) {
            return;
        }
        this.gz.requestDisallowInterceptTouchEvent(true);
        this.e = true;
    }

    public void e() {
        if (this.e) {
            return;
        }
        this.gz.requestDisallowInterceptTouchEvent(false);
        this.e = true;
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
        if (i2 == 0 && z2) {
            this.gc = true;
        } else {
            this.gc = false;
        }
    }
}
