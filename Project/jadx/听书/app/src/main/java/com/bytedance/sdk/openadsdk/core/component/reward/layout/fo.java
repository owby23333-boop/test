package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.live.view.DoubleColorBallAnimationView;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends g {
    private DoubleColorBallAnimationView ls;
    private ImageView pf;
    LinearLayout v;

    public fo(TTBaseVideoActivity tTBaseVideoActivity, na naVar, boolean z) {
        super(tTBaseVideoActivity, naVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z() {
        super.z();
        this.pf = new ImageView(this.g);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.pf.setAdjustViewBounds(true);
        this.pf.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.pf.setLayoutParams(layoutParams);
        this.e.addView(this.pf);
        View view = new View(this.g);
        view.setBackgroundColor(Color.parseColor("#A6000000"));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.e.addView(view);
        LinearLayout linearLayout = new LinearLayout(this.g);
        this.v = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.g);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setText(tb.z(this.g, "tt_reward_live_grant"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 24;
        textView.setLayoutParams(layoutParams2);
        this.ls = new DoubleColorBallAnimationView(this.g);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(oq.dl(this.g, 60.0f), oq.dl(this.g, 60.0f));
        layoutParams3.gravity = 17;
        this.ls.setLayoutParams(layoutParams3);
        this.v.addView(this.ls);
        this.v.addView(textView);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        this.v.setLayoutParams(layoutParams4);
        this.e.addView(this.v);
        this.v.setVisibility(8);
        String strG = tf.g(this.dl);
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        com.bytedance.sdk.openadsdk.gz.g.z(strG).width(this.e.getWidth()).height(this.e.getHeight()).to(this.pf);
    }

    public void g() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.ls;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.g();
            this.v.setVisibility(0);
        }
    }

    public void dl() {
        DoubleColorBallAnimationView doubleColorBallAnimationView = this.ls;
        if (doubleColorBallAnimationView != null) {
            doubleColorBallAnimationView.dl();
            this.v.setVisibility(8);
        }
    }
}
