package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickInteractView;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements e {
    ClickInteractView z;

    public dl(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        this.z = new ClickInteractView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicBaseWidget.getDynamicHeight(), dynamicBaseWidget.getDynamicHeight());
        layoutParams.gravity = 17;
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
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClickInteractView dl() {
        return this.z;
    }
}
