package com.amgcyo.cuttadon.widget.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class AlignTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f5671s;

    public AlignTextView(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AlignTextView);
        this.f5671s = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        CharSequence text = getText();
        if (!(text instanceof String)) {
            super.onDraw(canvas);
            return;
        }
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.setAntiAlias(true);
        paint.drawableState = getDrawableState();
        paint.setTextSize(getTextSize());
        String str = (String) text;
        Layout layout = getLayout();
        if (layout != null) {
            for (int i2 = 0; i2 < layout.getLineCount(); i2++) {
                int lineBaseline = layout.getLineBaseline(i2) + getPaddingTop();
                int lineStart = layout.getLineStart(i2);
                int lineEnd = layout.getLineEnd(i2);
                if (this.f5671s && layout.getLineCount() == 1) {
                    a(canvas, str.substring(lineStart, lineEnd), lineBaseline, StaticLayout.getDesiredWidth(str, lineStart, lineEnd, getPaint()));
                } else {
                    if (i2 == layout.getLineCount() - 1) {
                        canvas.drawText(str.substring(lineStart), getPaddingLeft(), lineBaseline, getPaint());
                        return;
                    }
                    a(canvas, str.substring(lineStart, lineEnd), lineBaseline, StaticLayout.getDesiredWidth(str, lineStart, lineEnd, getPaint()));
                }
            }
        }
    }

    public AlignTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AlignTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Canvas canvas, String str, float f2, float f3) {
        if (str.length() < 1) {
            return;
        }
        float paddingLeft = getPaddingLeft();
        boolean z2 = str.charAt(str.length() - 1) == '\n';
        int length = str.length() - 1;
        if (!z2 && length != 0) {
            float measuredWidth = (((getMeasuredWidth() - f3) - getPaddingLeft()) - getPaddingRight()) / length;
            for (int i2 = 0; i2 < str.length(); i2++) {
                String strValueOf = String.valueOf(str.charAt(i2));
                float desiredWidth = StaticLayout.getDesiredWidth(strValueOf, getPaint());
                canvas.drawText(strValueOf, paddingLeft, f2, getPaint());
                paddingLeft += desiredWidth + measuredWidth;
            }
            return;
        }
        canvas.drawText(str, paddingLeft, f2, getPaint());
    }
}
