package com.bytedance.sdk.openadsdk.core.component.reward.view.lp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.SlideUpLoadMoreArrow;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.youth.banner.config.BannerConfig;

/* JADX INFO: loaded from: classes2.dex */
public class RewardLpBottomView extends LinearLayout {
    private RewardLandingPageAppInfoView dl;
    private SlideUpLoadMoreArrow g;
    private boolean z;

    public RewardLpBottomView(Context context) {
        super(context);
        this.z = false;
    }

    public void z(na naVar, String str) {
        if (naVar == null) {
            return;
        }
        this.z = z(naVar);
        dl();
        if (!js.dl(naVar)) {
            g(naVar, str);
        }
        setOrientation(1);
        setVisibility(8);
        setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, BannerConfig.INDICATOR_SELECTED_COLOR}));
    }

    private void dl() {
        this.g = new SlideUpLoadMoreArrow(getContext(), this.z ? 12 : 48, false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        addView(this.g, layoutParams);
    }

    private boolean z(na naVar) {
        return naVar.lt() == 4;
    }

    public void z() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        SlideUpLoadMoreArrow slideUpLoadMoreArrow = this.g;
        if (slideUpLoadMoreArrow != null) {
            slideUpLoadMoreArrow.z();
        }
        a();
    }

    public void g() {
        SlideUpLoadMoreArrow slideUpLoadMoreArrow;
        if (getVisibility() == 0 && (slideUpLoadMoreArrow = this.g) != null) {
            slideUpLoadMoreArrow.g();
            this.g.setVisibility(8);
        }
    }

    private void g(na naVar, String str) {
        if (this.z) {
            RewardLandingPageAppInfoView rewardLandingPageAppInfoView = new RewardLandingPageAppInfoView(getContext());
            this.dl = rewardLandingPageAppInfoView;
            rewardLandingPageAppInfoView.z(naVar, str);
            addView(this.dl, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private void a() {
        if (this.dl == null) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RewardLpBottomView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RewardLpBottomView.this.dl == null) {
                    return;
                }
                int measuredHeight = RewardLpBottomView.this.dl.getMeasuredHeight();
                View viewFindViewById = RewardLpBottomView.this.getRootView().findViewById(2114387658);
                if (viewFindViewById == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = measuredHeight;
                    viewFindViewById.setLayoutParams(layoutParams2);
                }
            }
        });
    }

    public void setDownLoadClickListener(View.OnClickListener onClickListener) {
        RewardLandingPageAppInfoView rewardLandingPageAppInfoView = this.dl;
        if (rewardLandingPageAppInfoView == null || onClickListener == null) {
            return;
        }
        rewardLandingPageAppInfoView.setDownLoadClickListener(onClickListener);
    }
}
