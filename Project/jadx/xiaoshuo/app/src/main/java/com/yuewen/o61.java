package com.yuewen;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public class o61 extends Animation {

    @ColorInt
    public static final int e = -15658735;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f15215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f15216b;
    public ColorDrawable c;
    public final View d;

    public o61(@NonNull View view, float f, float f2) {
        this.f15215a = f;
        this.f15216b = f2;
        Drawable foreground = view.getForeground();
        if (foreground instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) foreground;
            if (colorDrawable.getColor() == -15658735) {
                this.c = colorDrawable;
                this.f15215a = foreground.getAlpha() / 255.0f;
            }
        }
        if (this.c == null) {
            ColorDrawable colorDrawable2 = new ColorDrawable(e);
            this.c = colorDrawable2;
            colorDrawable2.setAlpha((int) (this.f15215a * 255.0f));
            view.setForeground(this.c);
        }
        this.d = view;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        ColorDrawable colorDrawable = this.c;
        if (colorDrawable == null) {
            return;
        }
        float f2 = this.f15216b;
        float f3 = this.f15215a;
        colorDrawable.setAlpha((int) ((((f2 - f3) * f) + f3) * 255.0f));
        if (this.f15216b >= this.f15215a || f < 1.0f) {
            return;
        }
        this.d.setForeground(null);
        this.f15215a = -1.0f;
    }

    @Override // android.view.animation.Animation
    public void cancel() {
        super.cancel();
        this.d.setForeground(null);
        this.f15215a = -1.0f;
    }
}
