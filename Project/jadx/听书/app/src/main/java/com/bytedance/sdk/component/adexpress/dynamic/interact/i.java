package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.PressInteractView;

/* JADX INFO: loaded from: classes2.dex */
public class i implements e<PressInteractView> {
    private PressInteractView z;

    public i(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        this.z = new PressInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.a.gz.z(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, 20.0f);
        this.z.setLayoutParams(layoutParams);
        this.z.setGuideText(eVar.gb());
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
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public PressInteractView dl() {
        return this.z;
    }
}
