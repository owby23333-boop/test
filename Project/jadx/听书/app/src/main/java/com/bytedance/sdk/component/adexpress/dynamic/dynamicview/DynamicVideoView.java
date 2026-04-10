package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.gc {
    FrameLayout g;
    boolean tb;
    TextView z;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean a() {
        return true;
    }

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.tb = false;
        this.pf = new View(context);
        this.pf.setTag(Integer.valueOf(getClickArea()));
        this.z = new TextView(context);
        this.g = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.a.gz.z(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.z.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.z.setBackground(gradientDrawable);
        this.z.setTextSize(10.0f);
        this.z.setGravity(17);
        this.z.setTextColor(-1);
        this.z.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            addView(this.g, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.z);
        addView(this.pf, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.a.z()) {
            addView(this.g, getWidgetLayoutParams());
        }
        dynamicRootView.dl = this.g;
        dynamicRootView.setVideoListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        double dGc = 0.0d;
        double dA = 0.0d;
        for (gz gzVarWp = this.i; gzVarWp != null; gzVarWp = gzVarWp.wp()) {
            double dM = dA + ((double) gzVarWp.m());
            double dE = dGc + ((double) gzVarWp.e());
            dA = dM - ((double) gzVarWp.a());
            dGc = dE - ((double) gzVarWp.gc());
        }
        try {
            float f = (float) dA;
            int iZ = (int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), f);
            int iZ2 = (int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), f + this.gc);
            if (com.bytedance.sdk.component.adexpress.a.dl.z(getContext())) {
                DynamicRoot dynamicRoot = (DynamicRoot) this.v.getChildAt(0);
                int dynamicWidth = dynamicRoot.getDynamicWidth();
                int i = dynamicWidth - iZ2;
                iZ2 = dynamicWidth - iZ;
                iZ = i;
            }
            if (!"open_ad".equals(this.v.getRenderRequest().m())) {
                DynamicRoot dynamicRoot2 = (DynamicRoot) this.v.getChildAt(0);
                float f2 = (float) dGc;
                dynamicRoot2.z.update(iZ, (int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), f2), iZ2, (int) com.bytedance.sdk.component.adexpress.a.gz.z(getContext(), f2 + this.m));
            } else {
                this.v.dl = this.g;
            }
        } catch (Exception unused) {
        }
        this.v.z(dA, dGc, this.gc, this.m, this.wp.pf());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.gc
    public void setTimeUpdate(int i) {
        String str;
        if (this.i.uy().gc().gy() && i > 0 && !this.tb) {
            String str2 = (i >= 60 ? "0" + (i / 60) : "00") + ":";
            int i2 = i % 60;
            if (i2 > 9) {
                str = str2 + i2;
            } else {
                str = str2 + "0" + i2;
            }
            this.z.setText(str);
            this.z.setVisibility(0);
            return;
        }
        this.tb = true;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            dl(getChildAt(i3));
        }
        this.z.setVisibility(8);
    }

    private void dl(View view) {
        if (view == this.z || view == this.js) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.z.m)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            dl(viewGroup.getChildAt(i));
            i++;
        }
    }
}
