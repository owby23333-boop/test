package com.duokan.dkbookshelf.ui;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes13.dex */
public class DkSimulationInterpolator implements Interpolator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f3174b = 0.35f;
    public static final float c = 0.5f;
    public static final float d = 1.0f;
    public static final float e = 0.175f;
    public static final float f = 0.35000002f;
    public static final int g = 300;
    public static final float[] h = new float[301];
    public static final float[] i = new float[301];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Mode f3175a;

    public enum Mode {
        ACCELERATE,
        DECELERATE
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3176a;

        static {
            int[] iArr = new int[Mode.values().length];
            f3176a = iArr;
            try {
                iArr[Mode.ACCELERATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3176a[Mode.DECELERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i2 = 0; i2 < 300; i2++) {
            float f14 = i2 / 300.0f;
            float f15 = 1.0f;
            while (true) {
                f2 = 2.0f;
                f3 = ((f15 - f12) / 2.0f) + f12;
                f4 = 3.0f;
                f5 = 1.0f - f3;
                f6 = f3 * 3.0f * f5;
                f7 = f3 * f3 * f3;
                float f16 = (((f5 * 0.175f) + (f3 * 0.35000002f)) * f6) + f7;
                if (Math.abs(f16 - f14) < 1.0E-5d) {
                    break;
                } else if (f16 > f14) {
                    f15 = f3;
                } else {
                    f12 = f3;
                }
            }
            h[i2] = (f6 * ((f5 * 0.5f) + f3)) + f7;
            float f17 = 1.0f;
            while (true) {
                f8 = ((f17 - f13) / f2) + f13;
                f9 = 1.0f - f8;
                f10 = f8 * f4 * f9;
                f11 = f8 * f8 * f8;
                float f18 = (((f9 * 0.5f) + f8) * f10) + f11;
                if (Math.abs(f18 - f14) < 1.0E-5d) {
                    break;
                }
                if (f18 > f14) {
                    f17 = f8;
                } else {
                    f13 = f8;
                }
                f2 = 2.0f;
                f4 = 3.0f;
            }
            i[i2] = (f10 * ((f9 * 0.175f) + (f8 * 0.35000002f))) + f11;
        }
        float[] fArr = h;
        i[300] = 1.0f;
        fArr[300] = 1.0f;
    }

    public DkSimulationInterpolator(Mode mode) {
        this.f3175a = mode;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        float f3;
        float fMax = Math.max(0.0f, Math.min(f2, 1.0f));
        int[] iArr = a.f3176a;
        if (iArr[this.f3175a.ordinal()] == 1) {
            fMax = 1.0f - fMax;
        }
        int i2 = (int) (fMax * 300.0f);
        if (i2 < 300) {
            float f4 = i2 / 300.0f;
            int i3 = i2 + 1;
            float[] fArr = h;
            float f5 = fArr[i2];
            f3 = f5 + ((fMax - f4) * ((fArr[i3] - f5) / ((i3 / 300.0f) - f4)));
        } else {
            f3 = 1.0f;
        }
        return iArr[this.f3175a.ordinal()] != 1 ? f3 : 1.0f - f3;
    }
}
