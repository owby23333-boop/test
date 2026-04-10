package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ClickSlideUpShakeView;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import com.bytedance.sdk.component.adexpress.widget.ShakeClickView;

/* JADX INFO: loaded from: classes2.dex */
public class m extends p<ClickSlideUpShakeView> implements pf {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.p
    protected void a() {
    }

    public m(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar, com.bytedance.sdk.component.adexpress.dynamic.dl.uy uyVar, boolean z, int i) {
        super(context, dynamicBaseWidget, eVar);
        this.g = context;
        this.f565a = eVar;
        this.dl = dynamicBaseWidget;
        z(uyVar, eVar, z, i);
    }

    private void z(com.bytedance.sdk.component.adexpress.dynamic.dl.uy uyVar, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar, boolean z, int i) {
        int iVm;
        this.z = new ClickSlideUpShakeView(this.g, uyVar, z, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.g, 300.0f));
        layoutParams.gravity = 81;
        Context context = this.g;
        if (eVar.vm() > 0) {
            iVm = eVar.vm();
        } else {
            iVm = com.bytedance.sdk.component.adexpress.a.z() ? 0 : 120;
        }
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.a.gz.z(context, iVm);
        this.z.setLayoutParams(layoutParams);
        this.z.setClipChildren(false);
        this.z.setSlideText(this.f565a.gb());
        if (this.z instanceof ClickSlideUpShakeView) {
            ((ClickSlideUpShakeView) this.z).setShakeText(this.f565a.sv());
            final ShakeClickView shakeView = ((ClickSlideUpShakeView) this.z).getShakeView();
            if (shakeView != null) {
                shakeView.setOnShakeViewListener(new ShakeAnimationView.z() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.m.1
                    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.z
                    public void z(boolean z2) {
                        if (m.this.dl.getDynamicClickListener() != null) {
                            m.this.dl.getDynamicClickListener().z(z2, m.this);
                        }
                        shakeView.performClick();
                    }
                });
                shakeView.setOnClickListener((View.OnClickListener) this.dl.getDynamicClickListener());
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.pf
    public void gc() {
        if (this.z.getParent() != null) {
            ((ViewGroup) this.z.getParent()).setVisibility(8);
        }
    }
}
