package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* JADX INFO: loaded from: classes2.dex */
public class p<E extends SlideUpView> implements e<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.sdk.component.adexpress.dynamic.dl.e f565a;
    protected DynamicBaseWidget dl;
    protected Context g;
    protected int gc;
    protected SlideUpView z;

    public p(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar, int i) {
        this.gc = i;
        this.g = context;
        this.dl = dynamicBaseWidget;
        this.f565a = eVar;
        a();
    }

    public p(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.dl.e eVar) {
        this(context, dynamicBaseWidget, eVar, 0);
    }

    protected void a() {
        this.z = new SlideUpView(this.g, this.f565a.xl());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.g, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.a.gz.z(this.g, 100 - this.gc);
        this.z.setLayoutParams(layoutParams);
        try {
            this.z.setGuideText(this.f565a.gb());
        } catch (Throwable unused) {
        }
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
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public E dl() {
        return (E) this.z;
    }
}
