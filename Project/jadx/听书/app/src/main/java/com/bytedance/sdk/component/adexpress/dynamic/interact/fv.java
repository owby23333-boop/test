package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView;

/* JADX INFO: loaded from: classes2.dex */
public class fv implements e<DynamicUnlockView> {
    private final DynamicUnlockView z;

    public fv(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        int iVm;
        DynamicUnlockView dynamicUnlockView = new DynamicUnlockView(context);
        this.z = dynamicUnlockView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        if (eVar.vm() > 0) {
            iVm = eVar.vm();
        } else {
            iVm = com.bytedance.sdk.component.adexpress.a.z() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, iVm);
        dynamicUnlockView.setLayoutParams(layoutParams);
        dynamicUnlockView.setClipChildren(false);
        dynamicUnlockView.setText(eVar.gb());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void z() {
        DynamicUnlockView dynamicUnlockView = this.z;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.z();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void g() {
        DynamicUnlockView dynamicUnlockView = this.z;
        if (dynamicUnlockView != null) {
            dynamicUnlockView.g();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DynamicUnlockView dl() {
        return this.z;
    }
}
