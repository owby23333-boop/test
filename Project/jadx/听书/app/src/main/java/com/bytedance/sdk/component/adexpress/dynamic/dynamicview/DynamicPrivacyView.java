package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicPrivacyView extends DynamicBaseWidgetImp {
    private TextView g;
    private TextView iq;
    private TextView q;
    private TextView tb;
    private TextView z;
    private LinearLayout zw;

    public DynamicPrivacyView(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.z = new TextView(this.kb);
        this.g = new TextView(this.kb);
        this.tb = new TextView(this.kb);
        this.zw = new LinearLayout(this.kb);
        this.q = new TextView(this.kb);
        this.iq = new TextView(this.kb);
        this.z.setTag(9);
        this.g.setTag(10);
        this.tb.setTag(12);
        this.zw.addView(this.tb);
        this.zw.addView(this.iq);
        this.zw.addView(this.g);
        this.zw.addView(this.q);
        this.zw.addView(this.z);
        addView(this.zw, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected boolean dl() {
        this.z.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.z.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.g.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.g.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        this.tb.setOnTouchListener((View.OnTouchListener) getDynamicClickListener());
        this.tb.setOnClickListener((View.OnClickListener) getDynamicClickListener());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(this.e, this.gz);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        this.tb.setText("功能");
        this.g.setText("权限");
        this.q.setText(" | ");
        this.iq.setText(" | ");
        this.z.setText("隐私");
        if (this.wp != null) {
            this.tb.setTextColor(this.wp.e());
            this.tb.setTextSize(this.wp.gc());
            this.g.setTextColor(this.wp.e());
            this.g.setTextSize(this.wp.gc());
            this.q.setTextColor(this.wp.e());
            this.iq.setTextColor(this.wp.e());
            this.z.setTextColor(this.wp.e());
            this.z.setTextSize(this.wp.gc());
            return false;
        }
        this.tb.setTextColor(-1);
        this.tb.setTextSize(12.0f);
        this.g.setTextColor(-1);
        this.g.setTextSize(12.0f);
        this.q.setTextColor(-1);
        this.iq.setTextColor(-1);
        this.z.setTextColor(-1);
        this.z.setTextSize(12.0f);
        return false;
    }
}
