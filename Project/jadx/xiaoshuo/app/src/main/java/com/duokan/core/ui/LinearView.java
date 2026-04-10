package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes12.dex */
public abstract class LinearView extends LinearLayout {
    public LinearView(Context context) {
        this(context, null);
    }

    public abstract int a(int i);

    public abstract int b(View view);

    public abstract int c(View view, LinearLayout.LayoutParams layoutParams);

    public abstract Rect d(int i);

    public abstract View e(int i);

    public abstract int getCellCount();

    public abstract ImageView.ScaleType getDividerScaleType();

    public abstract Drawable getFirstDivider();

    public abstract Drawable getLastDivider();

    public abstract Drawable getMiddleDivider();

    public abstract void setDividerScaleType(ImageView.ScaleType scaleType);

    public abstract void setFirstDivider(int i);

    public abstract void setFirstDivider(Drawable drawable2);

    public abstract void setLastDivider(int i);

    public abstract void setLastDivider(Drawable drawable2);

    public abstract void setMiddleDivider(int i);

    public abstract void setMiddleDivider(Drawable drawable2);

    public LinearView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
