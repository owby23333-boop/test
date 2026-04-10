package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;

/* JADX INFO: loaded from: classes10.dex */
public class TTDislikeScrollListView extends TTDislikeListView {
    public TTDislikeScrollListView(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public TTDislikeScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TTDislikeScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
