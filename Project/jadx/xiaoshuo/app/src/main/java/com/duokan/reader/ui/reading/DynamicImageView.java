package com.duokan.reader.ui.reading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes5.dex */
public class DynamicImageView extends ImageView {
    public DynamicImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        if (getDrawable() == null) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(i), (int) Math.ceil((r3 * r0.getIntrinsicHeight()) / r0.getIntrinsicWidth()));
        }
    }
}
