package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpView;

/* JADX INFO: loaded from: classes2.dex */
public class a extends p<ClickSlideUpView> {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.p
    protected void a() {
    }

    public a(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        super(context, dynamicBaseWidget, eVar);
        z(eVar);
    }

    private void z(com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        this.z = new ClickSlideUpView(this.g);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.g, eVar.vm());
        this.z.setLayoutParams(layoutParams);
        this.z.setSlideText(this.f565a.gb());
        if (this.z instanceof ClickSlideUpView) {
            ((ClickSlideUpView) this.z).setButtonText(this.f565a.uy());
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
