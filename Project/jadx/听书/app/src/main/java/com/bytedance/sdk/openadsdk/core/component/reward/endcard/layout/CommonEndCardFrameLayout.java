package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.PlayableEndcardFrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardLpBottomView;
import com.bytedance.sdk.openadsdk.core.g.g;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.res.gc;

/* JADX INFO: loaded from: classes2.dex */
public class CommonEndCardFrameLayout extends AbstractEndCardFrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSWebView f950a;
    private SSWebView dl;
    private FrameLayout gc;
    private RewardLpBottomView m;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void setClickListener(g gVar) {
    }

    public CommonEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    void z() {
        setId(2114387542);
        if (!TextUtils.isEmpty(tf.gz(this.g))) {
            SSWebView sSWebView = new SSWebView(this.z);
            sSWebView.setMaterialMeta(un.z(this.g));
            sSWebView.setId(2114387697);
            sSWebView.setLayerType(2, null);
            sSWebView.setVisibility(4);
            this.dl = sSWebView;
            addView(sSWebView, new FrameLayout.LayoutParams(-1, -1));
        }
        LinearLayout linearLayout = new LinearLayout(this.z);
        linearLayout.setId(2114387541);
        linearLayout.setOrientation(1);
        PlayableEndcardFrameLayout playableEndcardFrameLayout = new PlayableEndcardFrameLayout(this.z);
        playableEndcardFrameLayout.setId(2114387675);
        SSWebView sSWebView2 = new SSWebView(this.z);
        sSWebView2.setMaterialMeta(un.z(this.g));
        sSWebView2.setId(2114387859);
        sSWebView2.setLayerType(2, null);
        sSWebView2.setVisibility(4);
        this.f950a = sSWebView2;
        playableEndcardFrameLayout.addView(sSWebView2, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this.z);
        frameLayout.setId(2114387919);
        frameLayout.setVisibility(8);
        playableEndcardFrameLayout.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayoutG = gc.g(this.z);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-2236963, -1});
        gradientDrawable.setShape(0);
        linearLayoutG.setBackground(gradientDrawable);
        playableEndcardFrameLayout.addView(linearLayoutG, new FrameLayout.LayoutParams(-1, -1));
        RewardLpBottomView rewardLpBottomView = new RewardLpBottomView(this.z);
        rewardLpBottomView.setId(2114387824);
        rewardLpBottomView.setVisibility(8);
        this.m = rewardLpBottomView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        playableEndcardFrameLayout.addView(rewardLpBottomView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        linearLayout.addView(playableEndcardFrameLayout, layoutParams2);
        addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(this.z);
        frameLayout2.setId(2114387798);
        frameLayout2.setBackgroundColor(0);
        frameLayout2.setVisibility(8);
        addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        this.gc = frameLayout2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.f950a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void g() {
        super.g();
        RewardLpBottomView rewardLpBottomView = this.m;
        if (rewardLpBottomView != null) {
            rewardLpBottomView.g();
        }
    }
}
