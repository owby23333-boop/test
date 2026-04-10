package com.yuewen;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes6.dex */
public class co1 {

    public static class b implements Interpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = 1.0f - f;
            return 1.0f - (f2 * f2);
        }
    }

    public static class c implements Interpolator {
        public static final float c = 8.0f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f9717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f9718b;

        public c() {
            float fA = 1.0f / a(1.0f);
            this.f9717a = fA;
            this.f9718b = 1.0f - (fA * a(1.0f));
        }

        public final float a(float f) {
            float f2 = f * 8.0f;
            return f2 < 1.0f ? f2 - (1.0f - ((float) Math.exp(-f2))) : 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float fA = this.f9717a * a(f);
            return fA > 0.0f ? fA + this.f9718b : fA;
        }
    }

    public static Interpolator a() {
        return new b();
    }

    public static Interpolator b() {
        return new c();
    }
}
