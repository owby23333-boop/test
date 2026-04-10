package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.gz.dl;
import com.bytedance.sdk.openadsdk.core.iq.oq;
import com.bytedance.sdk.openadsdk.gz.g;

/* JADX INFO: loaded from: classes2.dex */
public class SaasAuthCouponEnvelope extends BaseSaasEnvelope {
    private TextView z;

    public SaasAuthCouponEnvelope(Context context, oq.g gVar) {
        super(context);
        z(context, gVar);
    }

    private void z(Context context, oq.g gVar) {
        if (gVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout relativeLayoutZ = z(context);
        ImageView imageView = new ImageView(context);
        try {
            g.z(dl.z("saas_reward_coupon_bg.webp")).to(imageView);
        } catch (Error unused) {
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayoutZ.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        textView.setId(2114387802);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setLayoutParams(layoutParams);
        layoutParams.topMargin = com.bytedance.sdk.openadsdk.core.un.oq.dl(context, 20.0f);
        textView.setText("优惠券");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTextSize(2, 16.0f);
        relativeLayoutZ.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387461);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        linearLayout.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(context);
        this.z = textView2;
        textView2.setId(2114387460);
        this.z.setText(String.valueOf(gVar.z()));
        this.z.setTextColor(Color.parseColor("#F93F3F"));
        this.z.setTextSize(2, 60.0f);
        linearLayout.addView(this.z, new RelativeLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(context);
        textView3.setText("元");
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setTextSize(2, 20.0f);
        linearLayout.addView(textView3, new RelativeLayout.LayoutParams(-2, -2));
        relativeLayoutZ.addView(linearLayout);
        TextView textView4 = new TextView(context);
        textView4.setId(2114387459);
        textView4.setText("满" + gVar.g() + "元可用");
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, linearLayout.getId());
        layoutParams3.topMargin = com.bytedance.sdk.openadsdk.core.un.oq.dl(context, -4.0f);
        relativeLayoutZ.addView(textView4, layoutParams3);
        TextView textView5 = new TextView(context);
        textView5.setText("领取后30分钟内有效");
        textView5.setTextColor(Color.parseColor("#894200"));
        textView5.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, textView4.getId());
        layoutParams4.topMargin = com.bytedance.sdk.openadsdk.core.un.oq.dl(context, 8.0f);
        relativeLayoutZ.addView(textView5, layoutParams4);
        z(context, "一键关联抖音领取", relativeLayoutZ);
        addView(relativeLayoutZ);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void z() {
        setVisibility(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void g() {
        setVisibility(8);
        super.g();
    }
}
