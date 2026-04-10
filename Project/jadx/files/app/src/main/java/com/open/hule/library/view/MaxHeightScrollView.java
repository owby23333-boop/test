package com.open.hule.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.open.hule.library.R$styleable;

/* JADX INFO: loaded from: classes3.dex */
public class MaxHeightScrollView extends ScrollView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f17663s;

    public MaxHeightScrollView(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaxHeightScrollView);
        this.f17663s = typedArrayObtainStyledAttributes.getLayoutDimension(R$styleable.MaxHeightScrollView_maxHeight, this.f17663s);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4 = this.f17663s;
        if (i4 > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    public void setMaxHeight(int i2) {
        this.f17663s = i2;
        postInvalidate();
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }
}
