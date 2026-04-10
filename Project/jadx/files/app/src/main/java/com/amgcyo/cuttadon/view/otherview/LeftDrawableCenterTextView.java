package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes.dex */
public class LeftDrawableCenterTextView extends AppCompatTextView {
    public LeftDrawableCenterTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getCompoundDrawables()[0] != null) {
            canvas.translate((getWidth() - ((getPaint().measureText(getText().toString()) + r0.getIntrinsicWidth()) + getCompoundDrawablePadding())) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    public LeftDrawableCenterTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LeftDrawableCenterTextView(Context context) {
        super(context);
    }
}
