package com.mibi.sdk.pay.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.mibi.sdk.pay.ui.R;

/* JADX INFO: loaded from: classes15.dex */
public class MibiScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7184a;

    public MibiScrollView(Context context) {
        this(context, null);
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MibiScrollView);
            this.f7184a = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MibiScrollView_maxHeight, -1);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f7184a <= 0) {
            super.onMeasure(i, i2);
        } else if (View.MeasureSpec.getSize(i2) <= this.f7184a) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.f7184a, View.MeasureSpec.getMode(i2)));
        }
    }

    public MibiScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MibiScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }
}
