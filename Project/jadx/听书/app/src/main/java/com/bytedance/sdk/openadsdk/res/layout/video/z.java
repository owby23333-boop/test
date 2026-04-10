package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.widget.RoundImageView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements com.bytedance.sdk.openadsdk.res.layout.z {
    protected RelativeLayout z(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(Color.parseColor("#99000000"));
        if (i != 0) {
            relativeLayout.setId(i);
        }
        return relativeLayout;
    }

    protected View g(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387911);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oq.dl(context, 66.0f), oq.dl(context, 66.0f));
        layoutParams.addRule(14);
        if (i != 0) {
            layoutParams.setMargins(0, oq.dl(context, i), 0, 0);
        }
        relativeLayout.setLayoutParams(layoutParams);
        tb.z(context, "tt_live_avatar_bg", relativeLayout);
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387831);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(oq.dl(context, 65.0f), oq.dl(context, 65.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(10);
        roundImageView.setLayoutParams(layoutParams2);
        relativeLayout.addView(roundImageView);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387608);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(oq.dl(context, 42.0f), oq.dl(context, 18.0f));
        layoutParams3.addRule(13);
        layoutParams3.addRule(12);
        imageView.setLayoutParams(layoutParams3);
        tb.z(context, "tt_live_ad_status_icon", (View) imageView);
        relativeLayout.addView(imageView);
        return relativeLayout;
    }

    protected View z(Context context, int i, int i2) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387693);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, oq.dl(context, 44.0f));
        layoutParams.addRule(12);
        layoutParams.setMargins(oq.dl(context, 40.0f), 0, oq.dl(context, 40.0f), oq.dl(context, i));
        relativeLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(oq.dl(context, 5.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387876);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(oq.dl(context, 14.0f), oq.dl(context, 16.0f));
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, 0, oq.dl(context, i2), 0);
        imageView.setLayoutParams(layoutParams2);
        tb.z(context, "tt_live_ad_loading_btn_status", (View) imageView);
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387752);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, 2114387876);
        layoutParams3.addRule(17, 2114387876);
        layoutParams3.addRule(15);
        textView.setLayoutParams(layoutParams3);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setText(tb.z(context, "tt_live_loading_btn"));
        textView.setTextColor(-1);
        relativeLayout.addView(textView);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(oq.dl(context, 14.0f), oq.dl(context, 16.0f));
        layoutParams4.addRule(1, 2114387752);
        layoutParams4.addRule(13);
        layoutParams4.setMargins(0, 0, oq.dl(context, 6.0f), 0);
        imageView2.setLayoutParams(layoutParams4);
        tb.z(context, "tt_splash_click_bar_go", (View) imageView2);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }
}
