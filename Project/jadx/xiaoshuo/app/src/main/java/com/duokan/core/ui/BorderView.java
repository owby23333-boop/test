package com.duokan.core.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes12.dex */
public abstract class BorderView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView.ScaleType f2853a;

    public BorderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2853a = ImageView.ScaleType.FIT_XY;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.scaleType});
        this.f2853a = ImageView.ScaleType.values()[typedArrayObtainStyledAttributes.getInteger(0, this.f2853a.ordinal())];
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    public ImageView.ScaleType getScaleType() {
        return this.f2853a;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.f2853a = scaleType;
        requestLayout();
    }
}
