package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.BluePressInteractView;

/* JADX INFO: loaded from: classes2.dex */
public class z implements e {
    private BluePressInteractView z;

    public z(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        double dLw = eVar.lw();
        dLw = dLw == 0.0d ? 1.0d : dLw;
        double dRv = eVar.rv();
        double d = dRv != 0.0d ? dRv : 1.0d;
        int dynamicWidth = (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * dLw);
        int dynamicWidth2 = (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * d);
        this.z = new BluePressInteractView(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, eVar.zx() - 7);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, eVar.b() - 3);
        this.z.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void z() {
        this.z.z();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void g() {
        this.z.g();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public ViewGroup dl() {
        return this.z;
    }
}
