package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.gz.dl;
import com.bytedance.sdk.openadsdk.core.iq.oq;
import com.bytedance.sdk.openadsdk.gz.g;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import com.funny.audio.core.utils.FileUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SaasAuthProductEnvelope extends BaseSaasEnvelope {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void z() {
    }

    public SaasAuthProductEnvelope(Context context, oq.z zVar) {
        super(context);
        z(context, zVar);
    }

    private void z(Context context, oq.z zVar) {
        if (zVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout relativeLayoutZ = z(context);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        try {
            g.z(dl.z("saas_reward_goods_bg.webp")).to(imageView);
        } catch (Error unused) {
        }
        relativeLayoutZ.addView(imageView);
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setId(2114387802);
        layoutParams.topMargin = com.bytedance.sdk.openadsdk.core.un.oq.dl(context, 20.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText("超值好物");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTypeface(null, 1);
        relativeLayoutZ.addView(textView);
        TextView textView2 = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.topMargin = com.bytedance.sdk.openadsdk.core.un.oq.dl(context, 20.0f);
        textView2.setId(2114387462);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setMaxWidth(com.bytedance.sdk.openadsdk.core.un.oq.dl(context, 200.0f));
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextSize(2, 12.0f);
        textView2.setGravity(17);
        textView2.setText(zVar.z());
        textView2.setTextColor(Color.parseColor("#161823"));
        relativeLayoutZ.addView(textView2);
        int iDl = com.bytedance.sdk.openadsdk.core.un.oq.dl(context, 80.0f);
        int iDl2 = com.bytedance.sdk.openadsdk.core.un.oq.dl(context, 10.0f);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context, iDl2, iDl2);
        tTRoundRectImageView.setId(2114387456);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iDl, iDl);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView2.getId());
        layoutParams3.topMargin = com.bytedance.sdk.openadsdk.core.un.oq.dl(context, 12.0f);
        g.z(zVar.g()).width(iDl).height(iDl).to(tTRoundRectImageView);
        tTRoundRectImageView.setLayoutParams(layoutParams3);
        relativeLayoutZ.addView(tTRoundRectImageView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387457);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, tTRoundRectImageView.getId());
        layoutParams4.topMargin = com.bytedance.sdk.openadsdk.core.un.oq.dl(context, 12.0f);
        linearLayout.setLayoutParams(layoutParams4);
        TextView textView3 = new TextView(context);
        textView3.setTextSize(2, 11.0f);
        textView3.setTypeface(null, 1);
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setText("¥");
        linearLayout.addView(textView3);
        double dA = zVar.a();
        int iFloor = (int) Math.floor(dA);
        int i = (int) ((dA - ((double) iFloor)) * 100.0d);
        TextView textView4 = new TextView(context);
        textView4.setTextSize(2, 16.0f);
        textView4.setTypeface(null, 1);
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setText(String.valueOf(iFloor));
        linearLayout.addView(textView4);
        TextView textView5 = new TextView(context);
        textView5.setTextSize(2, 11.0f);
        textView5.setTypeface(null, 1);
        textView5.setTextColor(Color.parseColor("#F93F3F"));
        textView5.setText(FileUtils.FILE_EXTENSION_SEPARATOR + i + (i >= 10 ? "" : "0"));
        linearLayout.addView(textView5);
        TextView textView6 = new TextView(context);
        textView6.getPaint().setFlags(16);
        textView6.setTextSize(2, 11.0f);
        textView6.setTextColor(Color.parseColor("#161823"));
        textView6.setText("￥" + zVar.dl());
        linearLayout.addView(textView6);
        relativeLayoutZ.addView(linearLayout);
        z(context, "一键关联抖音购买", relativeLayoutZ);
        addView(relativeLayoutZ);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void g() {
        super.g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }
}
