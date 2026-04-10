package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideRightView;

/* JADX INFO: loaded from: classes2.dex */
public class ls implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.dl.e f564a;
    private DynamicBaseWidget dl;
    private Context g;
    private SlideRightView z;

    public ls(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        this.g = context;
        this.dl = dynamicBaseWidget;
        this.f564a = eVar;
        a();
    }

    private void a() {
        this.z = new SlideRightView(this.g);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.g, 120.0f));
        layoutParams.gravity = 17;
        this.z.setLayoutParams(layoutParams);
        this.z.setClipChildren(false);
        this.z.setGuideText(this.f564a.gb());
        DynamicBaseWidget dynamicBaseWidget = this.dl;
        if (dynamicBaseWidget != null) {
            this.z.setOnClickListener((View.OnClickListener) dynamicBaseWidget.getDynamicClickListener());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void z() {
        SlideRightView slideRightView = this.z;
        if (slideRightView != null) {
            slideRightView.z();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public void g() {
        SlideRightView slideRightView = this.z;
        if (slideRightView != null) {
            slideRightView.g();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.e
    public ViewGroup dl() {
        return this.z;
    }
}
