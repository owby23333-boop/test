package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView2;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends p<ClickSlideUpView> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.p
    protected void a() {
    }

    public gc(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        super(context, dynamicBaseWidget, eVar);
        z(eVar);
    }

    private void z(com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        this.z = new ClickSlideUpView2(this.g);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 81;
        this.z.setLayoutParams(layoutParams);
        if (this.z instanceof ClickSlideUpView2) {
            ((ClickSlideUpView2) this.z).setButtonText(this.f565a.gb());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.p, com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void z() {
        this.z.z();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.p, com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void g() {
        this.z.g();
    }
}
