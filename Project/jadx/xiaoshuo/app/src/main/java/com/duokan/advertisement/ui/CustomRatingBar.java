package com.duokan.advertisement.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.duokan.advertisement.i;

/* JADX INFO: loaded from: classes12.dex */
public class CustomRatingBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2677b;
    public a c;
    public float d;
    public float e;
    public float f;
    public Drawable g;
    public Drawable h;
    public Drawable i;
    public StepSize j;

    public enum StepSize {
        half(0),
        full(1);

        private int mStep;

        StepSize(int i) {
            this.mStep = i;
        }

        public static StepSize fromStep(int i) {
            for (StepSize stepSize : values()) {
                if (stepSize.mStep == i) {
                    return stepSize;
                }
            }
            return full;
        }
    }

    public interface a {
        void a(float f);
    }

    public CustomRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.t.jk);
        this.d = typedArrayObtainStyledAttributes.getDimension(i.t.pk, 20.0f);
        this.e = typedArrayObtainStyledAttributes.getDimension(i.t.qk, 10.0f);
        this.f = typedArrayObtainStyledAttributes.getFloat(i.t.rk, 1.0f);
        this.j = StepSize.fromStep(typedArrayObtainStyledAttributes.getInt(i.t.sk, 1));
        this.f2677b = typedArrayObtainStyledAttributes.getInteger(i.t.lk, 5);
        this.g = typedArrayObtainStyledAttributes.getDrawable(i.t.mk);
        this.h = typedArrayObtainStyledAttributes.getDrawable(i.t.nk);
        this.i = typedArrayObtainStyledAttributes.getDrawable(i.t.ok);
        this.f2676a = typedArrayObtainStyledAttributes.getBoolean(i.t.kk, true);
        typedArrayObtainStyledAttributes.recycle();
        for (int i = 0; i < this.f2677b; i++) {
            ImageView starImageView = getStarImageView();
            starImageView.setImageDrawable(this.g);
            addView(starImageView);
        }
        setStar(this.f);
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Math.round(this.d), Math.round(this.d));
        layoutParams.setMargins(0, 0, Math.round(this.e), 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageDrawable(this.g);
        imageView.setMinimumWidth(10);
        imageView.setMaxHeight(10);
        return imageView;
    }

    public int getMaxStarCount() {
        return this.f2677b;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.f2676a = z;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.c = aVar;
    }

    public void setStar(float f) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(f);
        }
        this.f = f;
        int i = (int) f;
        for (int i2 = 0; i2 < i; i2++) {
            ((ImageView) getChildAt(i2)).setImageDrawable(this.h);
        }
        for (int i3 = i; i3 < this.f2677b; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.g);
        }
        if (Float.compare(i, f) < 0) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.i);
        }
    }

    public void setStarEmptyDrawable(Drawable drawable2) {
        this.g = drawable2;
    }

    public void setStarFillDrawable(Drawable drawable2) {
        this.h = drawable2;
    }

    public void setStarHalfDrawable(Drawable drawable2) {
        this.i = drawable2;
    }

    public void setStarImageSize(float f) {
        this.d = f;
    }

    public void setStepSize(StepSize stepSize) {
        this.j = stepSize;
    }
}
