package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.a.e;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.dl {
    boolean g;
    private boolean iq;
    private int q;
    private int tb;
    int z;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.q = 0;
        setTag(Integer.valueOf(getClickArea()));
        fo();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().l()) {
            return;
        }
        if (this.pf != null) {
            this.pf.setVisibility(8);
        }
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void gc() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.g) {
            layoutParams.leftMargin = this.fo;
        } else {
            layoutParams.leftMargin = this.fo + this.q;
        }
        if (this.iq && this.wp != null) {
            layoutParams.leftMargin = ((this.fo + this.q) - ((int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.dl()))) - ((int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.a()));
        }
        if (com.bytedance.sdk.component.adexpress.a.z()) {
            layoutParams.topMargin = this.uy - ((int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.g()));
        } else {
            layoutParams.topMargin = this.uy;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        if (e.g(this.v.getRenderRequest().m())) {
            return true;
        }
        super.gz();
        setPadding((int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.dl()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.g()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.a()), (int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.z()));
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.iq && this.wp != null) {
            setMeasuredDimension(this.tb + ((int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.dl())) + ((int) com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.wp.a())), this.gz);
        } else if (this.g) {
            setMeasuredDimension(this.e, this.gz);
        } else {
            setMeasuredDimension(this.z, this.gz);
        }
    }

    private void fo() {
        List<gz> listKb = this.i.kb();
        if (listKb == null || listKb.size() <= 0) {
            return;
        }
        Iterator<gz> it = listKb.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            gz next = it.next();
            if (TextUtils.equals("skip-with-time-skip-btn", next.uy().getType())) {
                this.tb = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.kb, next.gz() + (com.bytedance.sdk.component.adexpress.a.z() ? next.i() : 0));
                this.z = this.e - this.tb;
            }
        }
        this.q = this.e - this.z;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dl
    public void z(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.iq != z2) {
            this.iq = z2;
            gc();
            return;
        }
        if (z && this.g != z) {
            this.g = z;
            gc();
        }
        this.g = z;
    }
}
