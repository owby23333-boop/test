package com.amgcyo.cuttadon.view.otherview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.amgcyo.cuttadon.R$styleable;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FixedAnimationRadioButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000fH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/amgcyo/cuttadon/view/otherview/FixedAnimatedRadioButton;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animatedScaleRate", "", "animationOpen", "", "mDefaultDrawableBounds", "", "Landroid/graphics/Rect;", "[Landroid/graphics/Rect;", "maxScaleRate", "minScaleRate", "init", "", "onAnimationUpdate", "animation", "Landroid/animation/ValueAnimator;", "setButtonDrawable", "buttonDrawable", "Landroid/graphics/drawable/Drawable;", "setChecked", "checked", "app_fmydRelease"}, k = 1, mv = {1, 1, 16})
public final class FixedAnimatedRadioButton extends AppCompatRadioButton implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f4975s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f4976t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f4977u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Rect[] f4978v;

    public FixedAnimatedRadioButton(@Nullable Context context) {
        super(context);
        this.f4975s = 1.0f;
        this.f4976t = 0.85f;
        this.f4977u = 1.0f;
        a(context, null);
    }

    private final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R$styleable.FixedAnimatedRadioButton) : null;
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.getBoolean(0, true);
            this.f4977u = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
            this.f4976t = typedArrayObtainStyledAttributes.getFloat(2, 0.85f);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@Nullable ValueAnimator animation) {
        Drawable[] drawableArr;
        Rect[] rectArr;
        Rect rect;
        Drawable drawable = null;
        Object animatedValue = animation != null ? animation.getAnimatedValue() : null;
        if (animatedValue == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        }
        this.f4975s = ((Float) animatedValue).floatValue();
        try {
            int i2 = 0;
            if (this.f4978v == null) {
                this.f4978v = new Rect[4];
                Drawable[] compoundDrawables = getCompoundDrawables();
                int length = compoundDrawables.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    Drawable drawable2 = compoundDrawables[i3];
                    int i5 = i4 + 1;
                    if (drawable2 != null) {
                        Rect rect2 = new Rect(drawable2.getBounds());
                        Rect[] rectArr2 = this.f4978v;
                        if (rectArr2 != null) {
                            rectArr2[i4] = rect2;
                        }
                    }
                    i3++;
                    i4 = i5;
                }
            }
            Drawable[] compoundDrawables2 = getCompoundDrawables();
            int length2 = compoundDrawables2.length;
            Drawable drawable3 = null;
            Drawable drawable4 = null;
            Drawable drawable5 = null;
            int i6 = 0;
            while (i2 < length2) {
                Drawable drawable6 = compoundDrawables2[i2];
                int i7 = i6 + 1;
                if (drawable6 == null || (rectArr = this.f4978v) == null || (rect = rectArr[i6]) == null) {
                    drawableArr = compoundDrawables2;
                } else {
                    Rect rect3 = new Rect(rect);
                    rect3.left = rect.left;
                    drawableArr = compoundDrawables2;
                    float f2 = 1;
                    rect3.right = rect.right - ((int) (rect.width() * (f2 - this.f4975s)));
                    rect3.top = rect.top + (((int) (rect.height() * (f2 - this.f4975s))) / 2);
                    rect3.bottom = rect.bottom - (((int) (rect.height() * (f2 - this.f4975s))) / 2);
                    if (i6 == 0) {
                        drawable6.setBounds(rect3);
                        drawable = drawable6;
                    } else if (i6 == 1) {
                        drawable6.setBounds(rect3);
                        drawable3 = drawable6;
                    } else if (i6 == 2) {
                        drawable6.setBounds(rect3);
                        drawable4 = drawable6;
                    } else if (i6 == 3) {
                        drawable6.setBounds(rect3);
                        drawable5 = drawable6;
                    }
                }
                i2++;
                compoundDrawables2 = drawableArr;
                i6 = i7;
            }
            setCompoundDrawables(drawable, drawable3, drawable4, drawable5);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.appcompat.widget.AppCompatRadioButton, android.widget.CompoundButton
    public void setButtonDrawable(@Nullable Drawable buttonDrawable) {
        if (Build.VERSION.SDK_INT > 19) {
            super.setButtonDrawable(buttonDrawable);
            return;
        }
        try {
            Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (checked) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f4976t, this.f4977u);
            valueAnimatorOfFloat.addUpdateListener(this);
            valueAnimatorOfFloat.setDuration(300L);
            valueAnimatorOfFloat.start();
            return;
        }
        float f2 = this.f4975s;
        if (f2 != 1.0f) {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(f2, 1.0f);
            valueAnimatorOfFloat2.addUpdateListener(this);
            valueAnimatorOfFloat2.setDuration(0L);
            valueAnimatorOfFloat2.start();
        }
    }

    public FixedAnimatedRadioButton(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4975s = 1.0f;
        this.f4976t = 0.85f;
        this.f4977u = 1.0f;
        a(context, attributeSet);
    }

    public FixedAnimatedRadioButton(@Nullable Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4975s = 1.0f;
        this.f4976t = 0.85f;
        this.f4977u = 1.0f;
        a(context, attributeSet);
    }
}
