package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.HandLongPressView;

/* JADX INFO: loaded from: classes2.dex */
public class kb implements e {
    private HandLongPressView z;

    public kb(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        this.z = new HandLongPressView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.a.gz.z(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, 180.0f));
        layoutParams.gravity = 17;
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
    public ViewGroup dl() {
        return this.z;
    }
}
