package com.qmuiteam.qmui.span;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;
import com.qmuiteam.qmui.skin.IQMUISkinHandlerSpan;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIDrawableHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIAlignMiddleImageSpan extends ImageSpan implements IQMUISkinHandlerSpan {
    public static final int ALIGN_MIDDLE = -100;
    private boolean mAvoidSuperChangeFontMetrics;
    private Drawable mDrawable;
    private int mDrawableTintColorAttr;
    private float mFontWidthMultiple;
    private int mWidth;

    public QMUIAlignMiddleImageSpan(Drawable drawable, int i) {
        this(drawable, i, 0.0f);
    }

    public QMUIAlignMiddleImageSpan(Drawable drawable, int i, float f) {
        super(drawable.mutate(), i);
        this.mFontWidthMultiple = -1.0f;
        this.mAvoidSuperChangeFontMetrics = false;
        this.mDrawable = getDrawable();
        if (f >= 0.0f) {
            this.mFontWidthMultiple = f;
        }
    }

    public void setSkinSupportWithTintColor(View view, int i) {
        this.mDrawableTintColorAttr = i;
        Drawable drawable = this.mDrawable;
        if (drawable == null || view == null || i == 0) {
            return;
        }
        QMUIDrawableHelper.setDrawableTintColor(drawable, QMUISkinHelper.getSkinColor(view, i));
        view.invalidate();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.mAvoidSuperChangeFontMetrics) {
            this.mWidth = getDrawable().getBounds().right;
        } else {
            this.mWidth = super.getSize(paint, charSequence, i, i2, fontMetricsInt);
        }
        if (this.mFontWidthMultiple > 0.0f) {
            this.mWidth = (int) (paint.measureText("子") * this.mFontWidthMultiple);
        }
        return this.mWidth;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.mVerticalAlignment == -100) {
            Drawable drawable = this.mDrawable;
            canvas.save();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.translate(f, i4 + fontMetricsInt.top + (((fontMetricsInt.bottom - fontMetricsInt.top) - (drawable.getBounds().bottom - drawable.getBounds().top)) / 2));
            drawable.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
    }

    public void setAvoidSuperChangeFontMetrics(boolean z) {
        this.mAvoidSuperChangeFontMetrics = z;
    }

    @Override // com.qmuiteam.qmui.skin.IQMUISkinHandlerSpan
    public void handle(View view, QMUISkinManager qMUISkinManager, int i, Resources.Theme theme) {
        int i2 = this.mDrawableTintColorAttr;
        if (i2 != 0) {
            QMUIDrawableHelper.setDrawableTintColor(this.mDrawable, QMUIResHelper.getAttrColor(theme, i2));
        }
    }
}
