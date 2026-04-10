package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.z.dl.a;
import com.bytedance.sdk.component.widget.recycler.z.dl.dl;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.un;

/* JADX INFO: loaded from: classes2.dex */
public class RewardJointBottomView extends FrameLayout implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSWebView f972a;
    private int[] dl;
    private View.OnClickListener e;
    private boolean fo;
    private int[] g;
    private a gc;
    private boolean gz;
    private int m;
    private final SlideUpLoadMoreArrow uy;
    private float z;

    public RewardJointBottomView(Context context, na naVar) {
        super(context);
        this.g = new int[2];
        this.dl = new int[2];
        this.m = 0;
        this.gz = false;
        this.fo = false;
        SSWebView sSWebView = new SSWebView(context);
        this.f972a = sSWebView;
        sSWebView.setMaterialMeta(un.z(naVar));
        this.f972a.setWebViewClient(null);
        addView(this.f972a, new ViewGroup.LayoutParams(-1, -1));
        this.f972a.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView.1
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                if (Math.abs((RewardJointBottomView.this.f972a.getWebView().getHeight() + RewardJointBottomView.this.f972a.getWebView().getScrollY()) - (RewardJointBottomView.this.f972a.getWebView().getContentHeight() * RewardJointBottomView.this.f972a.getWebView().getScale())) < 10.0f) {
                    if (RewardJointBottomView.this.gz) {
                        return;
                    }
                    RewardJointBottomView.this.gz = true;
                    return;
                }
                RewardJointBottomView.this.gz = false;
            }
        });
        getScrollingChildHelper().z(true);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = new SlideUpLoadMoreArrow(getContext(), 36, true);
        this.uy = slideUpLoadMoreArrow;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        addView(slideUpLoadMoreArrow, layoutParams);
        slideUpLoadMoreArrow.z();
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public void z(String str) {
        this.f972a.loadUrl(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnClickListener onClickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.m = 0;
            this.z = motionEvent.getY();
            z(2, 0);
            this.fo = this.gz;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.z;
                if (y < 0.0f) {
                    z();
                    if (z(0, (int) y, this.g, this.dl, 0)) {
                        y -= this.g[1];
                    }
                    this.m += z((int) ((Math.floor((double) Math.abs(y)) != 0.0d ? y : 0.0f) - this.m));
                } else {
                    int i = (int) (y - this.m);
                    int iZ = z(i);
                    this.m += iZ;
                    z(0, i - iZ, this.g, this.dl, 0);
                }
            }
        } else if (this.fo && this.z - motionEvent.getY() > 100.0f && (onClickListener = this.e) != null) {
            onClickListener.onClick(this);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return super.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return super.dispatchNestedPreFling(f, f2);
    }

    public boolean z(int i, int i2) {
        return getScrollingChildHelper().g(0);
    }

    public boolean z(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().z(i, i2, iArr, iArr2, i3);
    }

    private a getScrollingChildHelper() {
        if (this.gc == null) {
            this.gc = new a(this);
        }
        return this.gc;
    }

    public int z(int i) {
        if (i < 0) {
            return (int) (-Math.abs(Math.min(this.f972a.getWebView().getContentHeight() - (this.f972a.getWebView().getHeight() + this.f972a.getWebView().getScrollY()), -i)));
        }
        if (i > 0) {
            return Math.min(this.f972a.getWebView().getScrollY(), i);
        }
        return 0;
    }

    public SSWebView getWebView() {
        return this.f972a;
    }

    public void z() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.uy;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.setVisibility(8);
            this.uy.g();
        }
    }

    public void g() {
        z();
    }
}
