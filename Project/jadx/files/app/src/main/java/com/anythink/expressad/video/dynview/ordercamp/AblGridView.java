package com.anythink.expressad.video.dynview.ordercamp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* JADX INFO: loaded from: classes2.dex */
public class AblGridView extends GridView {
    public AblGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public AblGridView(Context context) {
        super(context);
    }

    public AblGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
