package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.amgcyo.cuttadon.R$styleable;

/* JADX INFO: loaded from: classes.dex */
public class TintableImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ColorStateList f5093s;

    public TintableImageView(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TintableImageView, i2, 0);
        this.f5093s = typedArrayObtainStyledAttributes.getColorStateList(0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.f5093s;
        if (colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        a();
    }

    public void setColorFilter(ColorStateList colorStateList) {
        this.f5093s = colorStateList;
        super.setColorFilter(colorStateList.getColorForState(getDrawableState(), 0));
    }

    public void setTintList(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f5093s = colorStateList;
            drawableStateChanged();
        }
    }

    public TintableImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public TintableImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2);
    }

    private void a() {
        setColorFilter(this.f5093s.getColorForState(getDrawableState(), 0));
    }
}
