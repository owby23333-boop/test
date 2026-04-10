package com.bytedance.sdk.openadsdk.res.layout.video;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements com.bytedance.sdk.openadsdk.res.layout.z {
    @Override // com.bytedance.sdk.openadsdk.res.layout.z
    public View g(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387870);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(Color.parseColor("#00000000"));
        relativeLayout.setGravity(16);
        relativeLayout.setVisibility(8);
        TextView textView = new TextView(context);
        textView.setId(2114387817);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14, -1);
        textView.setLayoutParams(layoutParams);
        textView.setIncludeFontPadding(false);
        textView.setText(tb.z(context, "tt_video_without_wifi_tips"));
        textView.setTextColor(tb.uy(context, "tt_ssxinzi9"));
        textView.setTextSize(2, 14.0f);
        textView.setVisibility(8);
        relativeLayout.addView(textView);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setId(2114387880);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387817);
        layoutParams2.addRule(13, -1);
        relativeLayout2.setLayoutParams(layoutParams2);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387800);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(oq.dl(context, 44.0f), oq.dl(context, 44.0f));
        layoutParams3.addRule(15, -1);
        layoutParams3.addRule(14, -1);
        imageView.setLayoutParams(layoutParams3);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tb.z(context, "tt_new_play_video", imageView);
        relativeLayout2.addView(imageView);
        relativeLayout.addView(relativeLayout2);
        return relativeLayout;
    }
}
