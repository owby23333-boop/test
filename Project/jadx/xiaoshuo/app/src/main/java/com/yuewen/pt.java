package com.yuewen;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes12.dex */
public class pt {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f16197b = 1500;
    public static final float c = 1.05f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObjectAnimator f16198a;

    public static class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f <= 0.2f) {
                return f * 5.0f;
            }
            float f2 = 0.4f;
            if (f > 0.4f) {
                if (f <= 0.6f) {
                    return (f - 0.4f) * 5.0f;
                }
                f2 = 0.8f;
                if (f > 0.8f) {
                    return 0.0f;
                }
            }
            return (f2 - f) * 5.0f;
        }

        public a() {
        }
    }

    public pt(View view) {
        this(view, 1.05f);
    }

    public void a() {
        this.f16198a.cancel();
    }

    public void b() {
        this.f16198a.start();
    }

    public pt(@NonNull View view, float f) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.0f, f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.0f, f));
        this.f16198a = objectAnimatorOfPropertyValuesHolder;
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new a());
        objectAnimatorOfPropertyValuesHolder.setDuration(f16197b);
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(5);
    }
}
