package com.facebook.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class Shimmer {
    final float[] a = new float[4];
    final int[] b = new int[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f14808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColorInt
    int f14809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColorInt
    int f14810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f14811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f14812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f14813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f14814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f14815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f14816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f14817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f14818m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f14819n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f14820o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f14821p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f14822q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f14823r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    long f14824s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    long f14825t;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    public static class a extends b<a> {
        public a() {
            this.a.f14821p = true;
        }

        @Override // com.facebook.shimmer.Shimmer.b
        protected a b() {
            return this;
        }

        @Override // com.facebook.shimmer.Shimmer.b
        protected /* bridge */ /* synthetic */ b b() {
            b();
            return this;
        }
    }

    public static class c extends b<c> {
        public c() {
            this.a.f14821p = false;
        }

        @Override // com.facebook.shimmer.Shimmer.b
        /* bridge */ /* synthetic */ b a(TypedArray typedArray) {
            a(typedArray);
            return this;
        }

        @Override // com.facebook.shimmer.Shimmer.b
        protected /* bridge */ /* synthetic */ b b() {
            b();
            return this;
        }

        @Override // com.facebook.shimmer.Shimmer.b
        protected c b() {
            return this;
        }

        public c g(@ColorInt int i2) {
            Shimmer shimmer = this.a;
            shimmer.f14810e = (i2 & ViewCompat.MEASURED_SIZE_MASK) | (shimmer.f14810e & (-16777216));
            b();
            return this;
        }

        public c h(@ColorInt int i2) {
            this.a.f14809d = i2;
            b();
            return this;
        }

        @Override // com.facebook.shimmer.Shimmer.b
        c a(TypedArray typedArray) {
            super.a(typedArray);
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_base_color)) {
                g(typedArray.getColor(R$styleable.ShimmerFrameLayout_shimmer_base_color, this.a.f14810e));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_highlight_color)) {
                h(typedArray.getColor(R$styleable.ShimmerFrameLayout_shimmer_highlight_color, this.a.f14809d));
            }
            b();
            return this;
        }
    }

    Shimmer() {
        new RectF();
        this.f14808c = 0;
        this.f14809d = -1;
        this.f14810e = 1291845631;
        this.f14811f = 0;
        this.f14812g = 0;
        this.f14813h = 0;
        this.f14814i = 1.0f;
        this.f14815j = 1.0f;
        this.f14816k = 0.0f;
        this.f14817l = 0.5f;
        this.f14818m = 20.0f;
        this.f14819n = true;
        this.f14820o = true;
        this.f14821p = true;
        this.f14822q = -1;
        this.f14823r = 1;
        this.f14824s = 1000L;
    }

    int a(int i2) {
        int i3 = this.f14813h;
        return i3 > 0 ? i3 : Math.round(this.f14815j * i2);
    }

    int b(int i2) {
        int i3 = this.f14812g;
        return i3 > 0 ? i3 : Math.round(this.f14814i * i2);
    }

    public static abstract class b<T extends b<T>> {
        final Shimmer a = new Shimmer();

        T a(TypedArray typedArray) {
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_clip_to_children)) {
                b(typedArray.getBoolean(R$styleable.ShimmerFrameLayout_shimmer_clip_to_children, this.a.f14819n));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_auto_start)) {
                a(typedArray.getBoolean(R$styleable.ShimmerFrameLayout_shimmer_auto_start, this.a.f14820o));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_base_alpha)) {
                a(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_base_alpha, 0.3f));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_highlight_alpha)) {
                d(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_highlight_alpha, 1.0f));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_duration)) {
                a(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_duration, (int) this.a.f14824s));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_repeat_count)) {
                d(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_repeat_count, this.a.f14822q));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_repeat_delay)) {
                b(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_repeat_delay, (int) this.a.f14825t));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_repeat_mode)) {
                e(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_repeat_mode, this.a.f14823r));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_direction)) {
                int i2 = typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_direction, this.a.f14808c);
                if (i2 == 1) {
                    a(1);
                } else if (i2 == 2) {
                    a(2);
                } else if (i2 != 3) {
                    a(0);
                } else {
                    a(3);
                }
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_shape)) {
                if (typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_shape, this.a.f14811f) != 1) {
                    f(0);
                } else {
                    f(1);
                }
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_dropoff)) {
                b(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_dropoff, this.a.f14817l));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_fixed_width)) {
                c(typedArray.getDimensionPixelSize(R$styleable.ShimmerFrameLayout_shimmer_fixed_width, this.a.f14812g));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_fixed_height)) {
                b(typedArray.getDimensionPixelSize(R$styleable.ShimmerFrameLayout_shimmer_fixed_height, this.a.f14813h));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_intensity)) {
                e(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_intensity, this.a.f14816k));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_width_ratio)) {
                g(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_width_ratio, this.a.f14814i));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_height_ratio)) {
                c(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_height_ratio, this.a.f14815j));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_tilt)) {
                f(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_tilt, this.a.f14818m));
            }
            return (T) b();
        }

        protected abstract T b();

        public T b(@Px int i2) {
            if (i2 >= 0) {
                this.a.f14813h = i2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid height: " + i2);
        }

        public T c(@Px int i2) {
            if (i2 >= 0) {
                this.a.f14812g = i2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid width: " + i2);
        }

        public T d(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
            int iA = (int) (a(0.0f, 1.0f, f2) * 255.0f);
            Shimmer shimmer = this.a;
            shimmer.f14809d = (iA << 24) | (shimmer.f14809d & ViewCompat.MEASURED_SIZE_MASK);
            return (T) b();
        }

        public T e(float f2) {
            if (f2 >= 0.0f) {
                this.a.f14816k = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f2);
        }

        public T f(int i2) {
            this.a.f14811f = i2;
            return (T) b();
        }

        public T g(float f2) {
            if (f2 >= 0.0f) {
                this.a.f14814i = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f2);
        }

        public T f(float f2) {
            this.a.f14818m = f2;
            return (T) b();
        }

        public T b(float f2) {
            if (f2 >= 0.0f) {
                this.a.f14817l = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f2);
        }

        public T c(float f2) {
            if (f2 >= 0.0f) {
                this.a.f14815j = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f2);
        }

        public T d(int i2) {
            this.a.f14822q = i2;
            return (T) b();
        }

        public T e(int i2) {
            this.a.f14823r = i2;
            return (T) b();
        }

        public T b(boolean z2) {
            this.a.f14819n = z2;
            return (T) b();
        }

        public T b(long j2) {
            if (j2 >= 0) {
                this.a.f14825t = j2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j2);
        }

        public T a(int i2) {
            this.a.f14808c = i2;
            return (T) b();
        }

        public T a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
            int iA = (int) (a(0.0f, 1.0f, f2) * 255.0f);
            Shimmer shimmer = this.a;
            shimmer.f14810e = (iA << 24) | (shimmer.f14810e & ViewCompat.MEASURED_SIZE_MASK);
            return (T) b();
        }

        public T a(boolean z2) {
            this.a.f14820o = z2;
            return (T) b();
        }

        public T a(long j2) {
            if (j2 >= 0) {
                this.a.f14824s = j2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j2);
        }

        public Shimmer a() {
            this.a.a();
            this.a.b();
            return this.a;
        }

        private static float a(float f2, float f3, float f4) {
            return Math.min(f3, Math.max(f2, f4));
        }
    }

    void a() {
        if (this.f14811f != 1) {
            int[] iArr = this.b;
            int i2 = this.f14810e;
            iArr[0] = i2;
            int i3 = this.f14809d;
            iArr[1] = i3;
            iArr[2] = i3;
            iArr[3] = i2;
            return;
        }
        int[] iArr2 = this.b;
        int i4 = this.f14809d;
        iArr2[0] = i4;
        iArr2[1] = i4;
        int i5 = this.f14810e;
        iArr2[2] = i5;
        iArr2[3] = i5;
    }

    void b() {
        if (this.f14811f != 1) {
            this.a[0] = Math.max(((1.0f - this.f14816k) - this.f14817l) / 2.0f, 0.0f);
            this.a[1] = Math.max(((1.0f - this.f14816k) - 0.001f) / 2.0f, 0.0f);
            this.a[2] = Math.min(((this.f14816k + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.a[3] = Math.min(((this.f14816k + 1.0f) + this.f14817l) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.f14816k, 1.0f);
        this.a[2] = Math.min(this.f14816k + this.f14817l, 1.0f);
        this.a[3] = 1.0f;
    }
}
