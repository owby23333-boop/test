package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class TTScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1495a;
    private z dl;
    private boolean g;
    private int z;

    public interface z {
        void z(boolean z);
    }

    public TTScrollView(Context context) {
        super(context);
        this.g = false;
        this.f1495a = false;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (this.g) {
            return;
        }
        try {
            this.g = true;
            View childAt = ((ViewGroup) getChildAt(0)).getChildAt(1);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = getHeight();
            childAt.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            wp.a("TTScrollView", "onLayout error" + th.toString());
        }
    }

    public void setListener(z zVar) {
        this.dl = zVar;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        z zVar;
        boolean z2 = true;
        if (motionEvent.getAction() == 1 && getScrollY() < this.z) {
            if (getScrollY() > this.z / 2) {
                post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTScrollView tTScrollView = TTScrollView.this;
                        tTScrollView.smoothScrollTo(0, tTScrollView.z);
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
                zVar = this.dl;
                if (zVar != null && z2 != this.f1495a) {
                    zVar.z(z2);
                }
                this.f1495a = z2;
            }
            z2 = false;
            zVar = this.dl;
            if (zVar != null) {
                zVar.z(z2);
            }
            this.f1495a = z2;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onOverScrolled(int i, int i2, boolean z2, boolean z3) {
        super.onOverScrolled(i, i2, z2, z3);
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.z = getChildAt(0).getMeasuredHeight();
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.widget.TTScrollView.3
            @Override // java.lang.Runnable
            public void run() {
                TTScrollView tTScrollView = TTScrollView.this;
                tTScrollView.smoothScrollTo(0, tTScrollView.z);
            }
        });
    }

    public boolean z() {
        return this.f1495a;
    }
}
