package com.qmuiteam.qmui.span;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/* JADX INFO: loaded from: classes4.dex */
public class QMUICustomTypefaceSpan extends TypefaceSpan {
    public static final Parcelable.Creator<QMUICustomTypefaceSpan> CREATOR = new Parcelable.Creator<QMUICustomTypefaceSpan>() { // from class: com.qmuiteam.qmui.span.QMUICustomTypefaceSpan.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QMUICustomTypefaceSpan createFromParcel(Parcel parcel) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QMUICustomTypefaceSpan[] newArray(int i) {
            return new QMUICustomTypefaceSpan[i];
        }
    };
    private final Typeface newType;

    public QMUICustomTypefaceSpan(String str, Typeface typeface) {
        super(str);
        this.newType = typeface;
    }

    private static void applyCustomTypeFace(Paint paint, Typeface typeface) {
        if (typeface == null) {
            return;
        }
        Typeface typeface2 = paint.getTypeface();
        int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (~typeface.getStyle());
        if ((style & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((style & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(typeface);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        applyCustomTypeFace(textPaint, this.newType);
    }

    @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        applyCustomTypeFace(textPaint, this.newType);
    }
}
