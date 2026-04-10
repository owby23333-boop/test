package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.wu;

/* JADX INFO: loaded from: classes10.dex */
public class TTScrollView extends ScrollView {
    private boolean bf;
    private e d;
    private int e;
    private boolean tg;

    public interface e {
        void e(boolean z);
    }

    public TTScrollView(Context context) {
        super(context);
        this.bf = false;
        this.tg = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.bf) {
            return;
        }
        try {
            this.bf = true;
            View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = getHeight();
            childAt.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            wu.vn("TTScrollView", "onLayout error" + th.toString());
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.onOverScrolled(i, i2, z, z2);
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.e);
            }
        });
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar;
        boolean z = true;
        if (motionEvent.getAction() == 1 && getScrollY() < this.e) {
            if (getScrollY() > this.e / 2) {
                post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView tTScrollView = TTScrollView.this;
                        tTScrollView.smoothScrollTo(0, tTScrollView.e);
                    }
                });
            } else {
                if (getScrollY() > 0) {
                    post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            TTScrollView.this.smoothScrollTo(0, 0);
                        }
                    });
                } else if (getScrollY() != 0) {
                }
                eVar = this.d;
                if (eVar != null && z != this.tg) {
                    eVar.e(z);
                }
                this.tg = z;
            }
            z = false;
            eVar = this.d;
            if (eVar != null) {
                eVar.e(z);
            }
            this.tg = z;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListener(e eVar) {
        this.d = eVar;
    }

    public boolean e() {
        return this.tg;
    }

    public TTScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bf = false;
        this.tg = false;
    }

    public TTScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bf = false;
        this.tg = false;
    }
}
