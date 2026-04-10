package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.Character;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIVerticalTextView extends AppCompatTextView {
    private boolean mIsVerticalMode;
    private int[] mLineBreakIndex;
    private int mLineCount;
    private float[] mLineWidths;

    private void init() {
    }

    public QMUIVerticalTextView(Context context) {
        super(context);
        this.mIsVerticalMode = true;
        init();
    }

    public QMUIVerticalTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsVerticalMode = true;
        init();
    }

    public QMUIVerticalTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsVerticalMode = true;
        init();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        float fMeasureText;
        float f;
        super.onMeasure(i, i2);
        if (this.mIsVerticalMode) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            float paddingLeft = getPaddingLeft() + getPaddingRight();
            float paddingTop = getPaddingTop() + getPaddingBottom();
            char[] charArray = getText().toString().toCharArray();
            TextPaint paint = getPaint();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int paddingBottom = (mode2 == 0 ? Integer.MAX_VALUE : size2) - getPaddingBottom();
            float paddingTop2 = getPaddingTop();
            this.mLineCount = 0;
            this.mLineWidths = new float[charArray.length + 1];
            this.mLineBreakIndex = new int[charArray.length + 1];
            float f2 = paddingTop2;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1;
            while (i4 < charArray.length) {
                int iCharCount = Character.charCount(Character.codePointAt(charArray, i4));
                if (!isCJKCharacter(r12)) {
                    i3 = size;
                    f = fontMetricsInt.descent - fontMetricsInt.ascent;
                    fMeasureText = paint.measureText(charArray, i4, iCharCount);
                } else {
                    i3 = size;
                    float fMeasureText2 = paint.measureText(charArray, i4, iCharCount);
                    fMeasureText = fontMetricsInt.descent - fontMetricsInt.ascent;
                    f = fMeasureText2;
                }
                float f3 = paddingTop2 + fMeasureText;
                TextPaint textPaint = paint;
                if (f3 > ((float) paddingBottom) && i4 > 0) {
                    if (f2 >= paddingTop2) {
                        paddingTop2 = f2;
                    }
                    this.mLineBreakIndex[i5] = i4 - iCharCount;
                    paddingLeft += this.mLineWidths[i5];
                    i5++;
                    f2 = paddingTop2;
                    paddingTop2 = getPaddingTop() + fMeasureText;
                } else {
                    paddingTop2 = f3;
                    if (f2 < f3) {
                        f2 = paddingTop2;
                    }
                }
                float[] fArr = this.mLineWidths;
                if (fArr[i5] < f) {
                    fArr[i5] = f;
                }
                i4 += iCharCount;
                if (i4 >= charArray.length) {
                    paddingLeft += fArr[i5];
                    paddingTop = getPaddingBottom() + f2;
                }
                i6 = iCharCount;
                size = i3;
                paint = textPaint;
            }
            int i7 = size;
            if (charArray.length > 0) {
                this.mLineCount = i5 + 1;
                this.mLineBreakIndex[i5] = charArray.length - i6;
            }
            int i8 = this.mLineCount;
            if (i8 > 1) {
                int i9 = i8 - 1;
                for (int i10 = 0; i10 < i9; i10++) {
                    paddingLeft += (this.mLineWidths[i10] * (getLineSpacingMultiplier() - 1.0f)) + getLineSpacingExtra();
                }
            }
            if (mode2 == 1073741824) {
                paddingTop = size2;
            } else if (mode2 == Integer.MIN_VALUE) {
                paddingTop = Math.min(paddingTop, size2);
            }
            if (mode == 1073741824) {
                paddingLeft = i7;
            } else if (mode == Integer.MIN_VALUE) {
                paddingLeft = Math.min(paddingLeft, i7);
            }
            setMeasuredDimension((int) paddingLeft, (int) paddingTop);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        Paint.FontMetricsInt fontMetricsInt;
        if (!this.mIsVerticalMode) {
            super.onDraw(canvas);
            return;
        }
        if (this.mLineCount == 0) {
            return;
        }
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        char[] charArray = getText().toString().toCharArray();
        canvas.save();
        float width = (getWidth() - getPaddingRight()) - this.mLineWidths[0];
        float lineSpacingMultiplier = width;
        float paddingTop = getPaddingTop();
        int i = 0;
        int i2 = 0;
        while (i < charArray.length) {
            int iCodePointAt = Character.codePointAt(charArray, i);
            int iCharCount = Character.charCount(iCodePointAt);
            boolean z = !isCJKCharacter(iCodePointAt);
            int iSave = canvas.save();
            if (z) {
                canvas.rotate(90.0f, width, paddingTop);
            }
            if (z) {
                f = (paddingTop - ((this.mLineWidths[i2] - (fontMetricsInt2.bottom - fontMetricsInt2.top)) / 2.0f)) - fontMetricsInt2.descent;
            } else {
                f = paddingTop - fontMetricsInt2.ascent;
            }
            float f2 = width;
            Paint.FontMetricsInt fontMetricsInt3 = fontMetricsInt2;
            int i3 = i;
            canvas.drawText(charArray, i, iCharCount, width, f, paint);
            canvas.restoreToCount(iSave);
            i = i3 + iCharCount;
            if (i < charArray.length) {
                if (i3 + 1 > this.mLineBreakIndex[i2]) {
                    int i4 = i2 + 1;
                    float[] fArr = this.mLineWidths;
                    if (i4 < fArr.length) {
                        lineSpacingMultiplier -= (fArr[i4] * getLineSpacingMultiplier()) + getLineSpacingExtra();
                        i2 = i4;
                        paddingTop = getPaddingTop();
                        width = lineSpacingMultiplier;
                        fontMetricsInt = fontMetricsInt3;
                    }
                }
                if (z) {
                    paddingTop += paint.measureText(charArray, i3, iCharCount);
                    fontMetricsInt = fontMetricsInt3;
                    width = f2;
                } else {
                    fontMetricsInt = fontMetricsInt3;
                    paddingTop += fontMetricsInt.descent - fontMetricsInt.ascent;
                    width = f2;
                }
            } else {
                fontMetricsInt = fontMetricsInt3;
                width = f2;
            }
            fontMetricsInt2 = fontMetricsInt;
        }
        canvas.restore();
    }

    private static boolean isCJKCharacter(int i) {
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(i);
        return unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || unicodeBlockOf == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || unicodeBlockOf == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || unicodeBlockOf == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || unicodeBlockOf == Character.UnicodeBlock.HANGUL_SYLLABLES || unicodeBlockOf == Character.UnicodeBlock.HANGUL_JAMO || unicodeBlockOf == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO || unicodeBlockOf == Character.UnicodeBlock.HIRAGANA || unicodeBlockOf == Character.UnicodeBlock.KATAKANA || unicodeBlockOf == Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS;
    }

    public void setVerticalMode(boolean z) {
        this.mIsVerticalMode = z;
        requestLayout();
    }

    public boolean isVerticalMode() {
        return this.mIsVerticalMode;
    }
}
