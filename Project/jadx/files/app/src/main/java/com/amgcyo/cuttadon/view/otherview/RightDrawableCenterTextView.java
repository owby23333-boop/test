package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes.dex */
public class RightDrawableCenterTextView extends AppCompatTextView {
    public RightDrawableCenterTextView(Context context) {
        this(context, null);
    }

    private void a() {
        setGravity(21);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getCompoundDrawables()[2] != null) {
            canvas.translate((((((getPaint().measureText(getText().toString()) + r0.getMinimumWidth()) + getCompoundDrawablePadding()) + getPaddingLeft()) + getPaddingRight()) - getWidth()) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    public RightDrawableCenterTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RightDrawableCenterTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
