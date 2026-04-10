package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.dl.gz;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicSplitLineView extends DynamicBaseWidgetImp {
    public DynamicSplitLineView(Context context, DynamicRootView dynamicRootView, gz gzVar) {
        super(context, dynamicRootView, gzVar);
        this.pf = new View(context);
        addView(this.pf, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.a
    public boolean gz() {
        super.gz();
        this.pf.setBackgroundColor(this.wp.l());
        return true;
    }
}
