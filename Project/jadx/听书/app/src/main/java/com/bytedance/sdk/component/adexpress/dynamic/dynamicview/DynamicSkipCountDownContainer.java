package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicSkipCountDownContainer extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.dl {
    private int g;
    private int tb;
    private int z;

    public DynamicSkipCountDownContainer(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        fo();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.dl()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.g()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.a()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.z()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void gc() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.fo;
        layoutParams.topMargin = this.uy;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.tb == 0) {
            setMeasuredDimension(this.g, this.gz);
        } else {
            setMeasuredDimension(this.z, this.gz);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dl
    public void z(CharSequence charSequence, boolean z, int i, boolean z2) {
        this.tb = i;
    }

    private void fo() {
        List<gz> listKb = this.i.kb();
        if (listKb == null || listKb.size() <= 0) {
            return;
        }
        for (gz gzVar : listKb) {
            if (gzVar.uy().z() == 21) {
                this.z = (int) (this.e - com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, gzVar.gz()));
            }
            if (gzVar.uy().z() == 20) {
                this.g = (int) (this.e - com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, gzVar.gz()));
            }
        }
    }
}
