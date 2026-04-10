package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class RewardAuthToastLayout extends RelativeLayout {
    public RewardAuthToastLayout(Context context, int i) {
        super(context);
        z(context, i);
    }

    private void z(Context context, int i) {
        setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, oq.dl(context, 36.0f));
        layoutParams.topMargin = oq.dl(context, 160.0f);
        setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#55161823"));
        gradientDrawable.setCornerRadius(oq.dl(context, 50.0f));
        linearLayout.setBackground(gradientDrawable);
        layoutParams2.addRule(14);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        addView(linearLayout);
        ImageView imageView = new ImageView(context);
        tb.z(context, "tt_reward_auth_gold_icon", imageView);
        int iDl = oq.dl(context, 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iDl, iDl);
        layoutParams3.leftMargin = oq.dl(context, 12.0f);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(layoutParams3);
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setTypeface(null, 1);
        textView.setText("授权抖音账号得" + i + "金币");
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.leftMargin = oq.dl(context, 8.0f);
        textView.setTextSize(2, 15.0f);
        textView.setTextColor(-1);
        textView.setLayoutParams(layoutParams4);
        linearLayout.addView(textView);
        ImageView imageView2 = new ImageView(context);
        tb.z(context, "tt_ic_top_arrow_right", imageView2);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, iDl);
        layoutParams5.rightMargin = oq.dl(context, 12.0f);
        imageView2.setLayoutParams(layoutParams5);
        linearLayout.addView(imageView2);
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardAuthToastLayout.1
            @Override // java.lang.Runnable
            public void run() {
                RewardAuthToastLayout.this.setVisibility(0);
            }
        }, 2500L);
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.RewardAuthToastLayout.2
            @Override // java.lang.Runnable
            public void run() {
                RewardAuthToastLayout.this.setVisibility(8);
            }
        }, 5500L);
    }
}
