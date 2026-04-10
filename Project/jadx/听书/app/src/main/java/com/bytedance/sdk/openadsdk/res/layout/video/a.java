package com.bytedance.sdk.openadsdk.res.layout.video;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class a extends z {
    @Override // com.bytedance.sdk.openadsdk.res.layout.z
    public View g(Context context) {
        RelativeLayout relativeLayoutZ = z(context, 2114387616);
        relativeLayoutZ.setVisibility(8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        relativeLayoutZ.addView(relativeLayout, layoutParams);
        relativeLayout.addView(g(context, 0));
        TextView textView = new TextView(context);
        textView.setId(2114387742);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387911);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, oq.dl(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(2, 16.0f);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387807);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2114387742);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, oq.dl(context, 8.0f), 0, 0);
        textView2.setLayoutParams(layoutParams3);
        textView2.setTextColor(context.getResources().getColor(R.color.white));
        textView2.setTextSize(2, 12.0f);
        textView2.setText(tb.z(context, "tt_live_loading_text"));
        relativeLayout.addView(textView2);
        relativeLayout.addView(z(context));
        return relativeLayoutZ;
    }

    private View z(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387693);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, oq.dl(context, 32.0f));
        layoutParams.addRule(3, 2114387807);
        layoutParams.addRule(14);
        layoutParams.topMargin = oq.dl(context, 17.0f);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(oq.dl(context, 5.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setMinimumWidth(oq.dl(context, 110.0f));
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387876);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(oq.dl(context, 12.0f), oq.dl(context, 14.0f));
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = oq.dl(context, 6.0f);
        imageView.setLayoutParams(layoutParams2);
        tb.z(context, "tt_live_ad_loading_btn_status", (View) imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387752);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, 2114387876);
        layoutParams3.addRule(17, 2114387876);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setText(tb.z(context, "tt_live_loading_btn"));
        textView.setTextColor(-1);
        textView.setTextSize(2, 11.0f);
        textView.setLayoutParams(layoutParams3);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(oq.dl(context, 12.0f), oq.dl(context, 14.0f));
        layoutParams4.addRule(13);
        layoutParams4.addRule(1, 2114387752);
        layoutParams4.addRule(17, 2114387752);
        imageView2.setLayoutParams(layoutParams4);
        tb.z(context, "tt_splash_click_bar_go", (View) imageView2);
        relativeLayout.addView(imageView);
        relativeLayout.addView(textView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }
}
