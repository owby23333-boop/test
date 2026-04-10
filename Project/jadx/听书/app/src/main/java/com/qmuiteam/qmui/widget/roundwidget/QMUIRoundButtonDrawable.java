package com.qmuiteam.qmui.widget.roundwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import com.qmuiteam.qmui.R;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIRoundButtonDrawable extends GradientDrawable {
    private ColorStateList mFillColors;
    private ColorStateList mStrokeColors;
    private boolean mRadiusAdjustBounds = true;
    private int mStrokeWidth = 0;

    public void setBgData(ColorStateList colorStateList) {
        super.setColor(colorStateList);
    }

    public void setStrokeData(int i, ColorStateList colorStateList) {
        this.mStrokeWidth = i;
        this.mStrokeColors = colorStateList;
        super.setStroke(i, colorStateList);
    }

    public int getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public void setStrokeColors(ColorStateList colorStateList) {
        setStrokeData(this.mStrokeWidth, colorStateList);
    }

    public void setIsRadiusAdjustBounds(boolean z) {
        this.mRadiusAdjustBounds = z;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.mFillColors;
        if (colorStateList != null) {
            setColor(colorStateList.getColorForState(iArr, 0));
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.mStrokeColors;
        if (colorStateList2 == null) {
            return zOnStateChange;
        }
        setStroke(this.mStrokeWidth, colorStateList2.getColorForState(iArr, 0));
        return true;
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.mFillColors;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.mStrokeColors) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mRadiusAdjustBounds) {
            setCornerRadius(Math.min(rect.width(), rect.height()) / 2);
        }
    }

    public static QMUIRoundButtonDrawable fromAttributeSet(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIRoundButton, i, 0);
        ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.QMUIRoundButton_qmui_backgroundColor);
        ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.QMUIRoundButton_qmui_borderColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_borderWidth, 0);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIRoundButton_qmui_isRadiusAdjustBounds, false);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radius, 0);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusTopLeft, 0);
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusTopRight, 0);
        int dimensionPixelSize5 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusBottomLeft, 0);
        int dimensionPixelSize6 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRoundButton_qmui_radiusBottomRight, 0);
        typedArrayObtainStyledAttributes.recycle();
        QMUIRoundButtonDrawable qMUIRoundButtonDrawable = new QMUIRoundButtonDrawable();
        qMUIRoundButtonDrawable.setBgData(colorStateList);
        qMUIRoundButtonDrawable.setStrokeData(dimensionPixelSize, colorStateList2);
        if (dimensionPixelSize3 > 0 || dimensionPixelSize4 > 0 || dimensionPixelSize5 > 0 || dimensionPixelSize6 > 0) {
            float f = dimensionPixelSize3;
            float f2 = dimensionPixelSize4;
            float f3 = dimensionPixelSize6;
            float f4 = dimensionPixelSize5;
            qMUIRoundButtonDrawable.setCornerRadii(new float[]{f, f, f2, f2, f3, f3, f4, f4});
        } else {
            qMUIRoundButtonDrawable.setCornerRadius(dimensionPixelSize2);
            if (dimensionPixelSize2 <= 0) {
                z = z2;
            }
        }
        qMUIRoundButtonDrawable.setIsRadiusAdjustBounds(z);
        return qMUIRoundButtonDrawable;
    }
}
