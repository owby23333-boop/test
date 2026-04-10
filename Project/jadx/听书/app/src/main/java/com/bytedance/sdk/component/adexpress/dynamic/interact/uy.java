package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.utils.h;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements e<ViewGroup> {
    private final FrameLayout g;
    private final DynamicLottieView z;

    public uy(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar, String str, String str2) {
        int iVm;
        DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
        this.z = dynamicLottieView;
        dynamicLottieView.setAnimationsLoop(true);
        dynamicLottieView.setOnlyLoadNetImage(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.g = frameLayout;
        frameLayout.addView(dynamicLottieView, new FrameLayout.LayoutParams(-2, -2));
        double dLw = eVar.lw();
        dLw = dLw == 0.0d ? 1.0d : dLw;
        double dRv = eVar.rv();
        double d = dRv != 0.0d ? dRv : 1.0d;
        if ("24".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/swiper_up_star.json" : str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if ("20".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/brush_mask.json" : str);
            z(context, frameLayout, eVar);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 81;
            if (eVar.vm() > 0) {
                iVm = eVar.vm();
            } else {
                iVm = com.bytedance.sdk.component.adexpress.a.z() ? 0 : 120;
            }
            layoutParams2.bottomMargin = (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, iVm);
            frameLayout.setLayoutParams(layoutParams2);
            frameLayout.setClipChildren(false);
            return;
        }
        dynamicLottieView.setImageLottieTosPath(str);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * dLw), (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * d));
        layoutParams3.gravity = 17;
        frameLayout.setLayoutParams(layoutParams3);
    }

    private void z(Context context, FrameLayout frameLayout, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -h.z(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(context.getString(tb.g(context, "tt_splash_brush_mask_title")));
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        textView2.setId(2097610738);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, h.z(context, 5.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setText(context.getString(tb.g(context, "tt_splash_brush_mask_hint")));
        if (eVar != null && !TextUtils.isEmpty(eVar.gb())) {
            textView2.setText(eVar.gb());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void z() {
        DynamicLottieView dynamicLottieView = this.z;
        if (dynamicLottieView != null) {
            dynamicLottieView.fo();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void g() {
        try {
            this.z.e();
            ViewParent parent = this.g.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.g);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public ViewGroup dl() {
        return this.g;
    }
}
