package com.dangdang.zframework.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes10.dex */
public class StretchedImageView extends ImageView {
    public StretchedImageView(Context context) {
        this(context, null, 0);
    }

    public float getInitialScale(int i, int i2, int i3, int i4) {
        float f = i / i2;
        float f2 = i3 / i4;
        if (f > 0.0f && f2 > 0.0f) {
            return Math.min(f, f2);
        }
        if (f > 0.0f && f2 == 0.0f) {
            return f;
        }
        if (f != 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return f2;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Drawable drawable2 = getDrawable();
        if (drawable2 == null) {
            super.onMeasure(i, i2);
            return;
        }
        float initialScale = getInitialScale(View.MeasureSpec.getSize(i), drawable2.getIntrinsicWidth(), View.MeasureSpec.getSize(i2), drawable2.getIntrinsicHeight());
        getImageMatrix().setScale(initialScale, initialScale);
        setMeasuredDimension((int) (drawable2.getIntrinsicWidth() * initialScale), (int) (drawable2.getIntrinsicHeight() * initialScale));
    }

    public StretchedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StretchedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setImageMatrix(new Matrix());
        setScaleType(ImageView.ScaleType.MATRIX);
    }
}
