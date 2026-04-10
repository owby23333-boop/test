package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationButton;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.pf = new AnimationButton(context);
        this.pf.setTag(Integer.valueOf(getClickArea()));
        addView(this.pf, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (com.bytedance.sdk.component.adexpress.a.z() && "fillButton".equals(this.i.uy().getType())) {
            ((TextView) this.pf).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) this.pf).setMaxLines(1);
            FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
            widgetLayoutParams.width -= this.wp.fv() * 2;
            widgetLayoutParams.height -= this.wp.fv() * 2;
            widgetLayoutParams.topMargin += this.wp.fv();
            widgetLayoutParams.leftMargin += this.wp.fv();
            widgetLayoutParams.setMarginStart(widgetLayoutParams.leftMargin);
            widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
            return widgetLayoutParams;
        }
        return super.getWidgetLayoutParams();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        if (TextUtils.equals("download-progress-button", this.i.uy().getType()) && TextUtils.isEmpty(this.wp.uy())) {
            this.pf.setVisibility(4);
            return true;
        }
        this.pf.setTextAlignment(this.wp.gz());
        ((TextView) this.pf).setText(this.wp.uy());
        ((TextView) this.pf).setTextColor(this.wp.e());
        ((TextView) this.pf).setTextSize(this.wp.gc());
        ((TextView) this.pf).setGravity(17);
        ((TextView) this.pf).setIncludeFontPadding(false);
        if ("fillButton".equals(this.i.uy().getType())) {
            this.pf.setPadding(0, 0, 0, 0);
        } else {
            this.pf.setPadding(this.wp.dl(), this.wp.g(), this.wp.a(), this.wp.z());
        }
        return true;
    }
}
