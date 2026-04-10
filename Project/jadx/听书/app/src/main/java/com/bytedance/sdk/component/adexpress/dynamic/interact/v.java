package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class v implements e<ShakeAnimationView>, pf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DynamicBaseWidget f566a;
    private Context dl;
    private com.bytedance.sdk.component.adexpress.dynamic.dl.uy e;
    private ShakeAnimationView g;
    private com.bytedance.sdk.component.adexpress.dynamic.dl.e gc;
    private boolean gz;
    private String m;
    public int z;

    public v(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar, String str, com.bytedance.sdk.component.adexpress.dynamic.dl.uy uyVar, boolean z, int i) {
        this.dl = context;
        this.f566a = dynamicBaseWidget;
        this.gc = eVar;
        this.m = str;
        this.e = uyVar;
        this.gz = z;
        this.z = i;
        m();
    }

    private void m() {
        final com.bytedance.sdk.component.adexpress.dynamic.gc.z dynamicClickListener = this.f566a.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 1);
            dynamicClickListener.z(jSONObject);
        } catch (Throwable unused) {
        }
        if ("16".equals(this.m)) {
            Context context = this.dl;
            ShakeAnimationView shakeAnimationView = new ShakeAnimationView(context, com.bytedance.sdk.component.adexpress.dl.z.gz(context), this.e, this.gz, this.z);
            this.g = shakeAnimationView;
            if (shakeAnimationView.getShakeLayout() != null) {
                this.g.getShakeLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
        } else {
            Context context2 = this.dl;
            this.g = new ShakeAnimationView(context2, com.bytedance.sdk.component.adexpress.dl.z.e(context2), this.e, this.gz, this.z);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.g.setGravity(17);
        layoutParams.gravity = 17;
        this.g.setLayoutParams(layoutParams);
        this.g.setTranslationY(com.bytedance.sdk.component.adexpress.a.gz.z(this.dl, this.gc.tc()));
        this.g.setShakeText(this.gc.gb());
        this.g.setClipChildren(false);
        this.g.setOnShakeViewListener(new ShakeAnimationView.z() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.v.1
            @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.z
            public void z(boolean z) {
                com.bytedance.sdk.component.adexpress.dynamic.gc.z zVar = dynamicClickListener;
                if (zVar != null) {
                    zVar.z(z, v.this);
                }
                v.this.g.setOnClickListener((View.OnClickListener) dynamicClickListener);
                v.this.g.performClick();
                if (v.this.gc == null || !v.this.gc.f()) {
                    return;
                }
                v.this.g.setOnClickListener(null);
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void z() {
        this.g.z();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void g() {
        this.g.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ShakeAnimationView dl() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.pf
    public void gc() {
        if (this.g.getParent() != null) {
            ((ViewGroup) this.g.getParent()).setVisibility(8);
        }
    }
}
