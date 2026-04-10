package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIFontFitTextView extends AppCompatTextView {
    private Paint mTestPaint;
    private float maxSize;
    private float minSize;

    public QMUIFontFitTextView(Context context) {
        this(context, null);
    }

    public QMUIFontFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.mTestPaint = paint;
        paint.set(getPaint());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIFontFitTextView);
        this.minSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIFontFitTextView_qmui_minTextSize, Math.round(QMUIDisplayHelper.DENSITY * 14.0f));
        this.maxSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIFontFitTextView_qmui_maxTextSize, Math.round(QMUIDisplayHelper.DENSITY * 18.0f));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void refitText(String str, int i) {
        if (i <= 0) {
            return;
        }
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        float f = this.maxSize;
        float f2 = this.minSize;
        this.mTestPaint.set(getPaint());
        this.mTestPaint.setTextSize(this.maxSize);
        float f3 = paddingLeft;
        if (this.mTestPaint.measureText(str) <= f3) {
            f2 = this.maxSize;
        } else {
            this.mTestPaint.setTextSize(this.minSize);
            if (this.mTestPaint.measureText(str) < f3) {
                while (f - f2 > 0.5f) {
                    float f4 = (f + f2) / 2.0f;
                    this.mTestPaint.setTextSize(f4);
                    if (this.mTestPaint.measureText(str) >= f3) {
                        f = f4;
                    } else {
                        f2 = f4;
                    }
                }
            }
        }
        setTextSize(0, f2);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int measuredHeight = getMeasuredHeight();
        refitText(getText().toString(), size);
        setMeasuredDimension(size, measuredHeight);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        refitText(charSequence.toString(), getWidth());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3) {
            refitText(getText().toString(), i);
        }
    }
}
