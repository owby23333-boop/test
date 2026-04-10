package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicRoot extends DynamicBaseWidgetImp {
    public g z;

    public DynamicRoot(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        return super.gz();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected g z(Bitmap bitmap) {
        z zVar = new z(bitmap, this.z);
        this.z = zVar;
        return zVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected GradientDrawable getDrawable() {
        g gVar = new g();
        this.z = gVar;
        return gVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    protected GradientDrawable z(GradientDrawable.Orientation orientation, int[] iArr) {
        g gVar = new g(orientation, iArr);
        this.z = gVar;
        return gVar;
    }
}
