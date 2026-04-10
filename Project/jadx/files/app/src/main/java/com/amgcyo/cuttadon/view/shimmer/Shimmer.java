package com.amgcyo.cuttadon.view.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class Shimmer {
    final float[] a = new float[4];
    final int[] b = new int[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f5408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @ColorInt
    int f5409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @ColorInt
    int f5410e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f5411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f5412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f5413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f5414i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f5415j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f5416k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    float f5417l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    float f5418m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f5419n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f5420o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f5421p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f5422q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f5423r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    long f5424s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    long f5425t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    long f5426u;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    public static class a extends b<a> {
        public a() {
            this.a.f5421p = true;
        }

        @Override // com.amgcyo.cuttadon.view.shimmer.Shimmer.b
        protected a b() {
            return this;
        }

        @Override // com.amgcyo.cuttadon.view.shimmer.Shimmer.b
        protected /* bridge */ /* synthetic */ b b() {
            b();
            return this;
        }
    }

    public static class c extends b<c> {
        public c() {
            this.a.f5421p = false;
        }

        @Override // com.amgcyo.cuttadon.view.shimmer.Shimmer.b
        /* bridge */ /* synthetic */ b a(TypedArray typedArray) {
            a(typedArray);
            return this;
        }

        @Override // com.amgcyo.cuttadon.view.shimmer.Shimmer.b
        protected /* bridge */ /* synthetic */ b b() {
            b();
            return this;
        }

        @Override // com.amgcyo.cuttadon.view.shimmer.Shimmer.b
        protected c b() {
            return this;
        }

        public c g(@ColorInt int i2) {
            Shimmer shimmer = this.a;
            shimmer.f5410e = (i2 & ViewCompat.MEASURED_SIZE_MASK) | (shimmer.f5410e & (-16777216));
            b();
            return this;
        }

        public c h(@ColorInt int i2) {
            this.a.f5409d = i2;
            b();
            return this;
        }

        @Override // com.amgcyo.cuttadon.view.shimmer.Shimmer.b
        c a(TypedArray typedArray) {
            super.a(typedArray);
            if (typedArray.hasValue(2)) {
                g(typedArray.getColor(2, this.a.f5410e));
            }
            if (typedArray.hasValue(12)) {
                h(typedArray.getColor(12, this.a.f5409d));
            }
            b();
            return this;
        }
    }

    Shimmer() {
        new RectF();
        this.f5408c = 0;
        this.f5409d = -1;
        this.f5410e = 1291845631;
        this.f5411f = 0;
        this.f5412g = 0;
        this.f5413h = 0;
        this.f5414i = 1.0f;
        this.f5415j = 1.0f;
        this.f5416k = 0.0f;
        this.f5417l = 0.5f;
        this.f5418m = 20.0f;
        this.f5419n = true;
        this.f5420o = true;
        this.f5421p = true;
        this.f5422q = -1;
        this.f5423r = 1;
        this.f5424s = 1000L;
    }

    int a(int i2) {
        int i3 = this.f5413h;
        return i3 > 0 ? i3 : Math.round(this.f5415j * i2);
    }

    int b(int i2) {
        int i3 = this.f5412g;
        return i3 > 0 ? i3 : Math.round(this.f5414i * i2);
    }

    public static abstract class b<T extends b<T>> {
        final Shimmer a = new Shimmer();

        T a(TypedArray typedArray) {
            if (typedArray.hasValue(3)) {
                b(typedArray.getBoolean(3, this.a.f5419n));
            }
            if (typedArray.hasValue(0)) {
                a(typedArray.getBoolean(0, this.a.f5420o));
            }
            if (typedArray.hasValue(1)) {
                a(typedArray.getFloat(1, 0.3f));
            }
            if (typedArray.hasValue(11)) {
                d(typedArray.getFloat(11, 1.0f));
            }
            if (typedArray.hasValue(7)) {
                a(typedArray.getInt(7, (int) this.a.f5424s));
            }
            if (typedArray.hasValue(14)) {
                d(typedArray.getInt(14, this.a.f5422q));
            }
            if (typedArray.hasValue(15)) {
                b(typedArray.getInt(15, (int) this.a.f5425t));
            }
            if (typedArray.hasValue(16)) {
                e(typedArray.getInt(16, this.a.f5423r));
            }
            if (typedArray.hasValue(18)) {
                c(typedArray.getInt(18, (int) this.a.f5426u));
            }
            if (typedArray.hasValue(5)) {
                int i2 = typedArray.getInt(5, this.a.f5408c);
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
            if (typedArray.hasValue(17)) {
                if (typedArray.getInt(17, this.a.f5411f) != 1) {
                    f(0);
                } else {
                    f(1);
                }
            }
            if (typedArray.hasValue(6)) {
                b(typedArray.getFloat(6, this.a.f5417l));
            }
            if (typedArray.hasValue(9)) {
                c(typedArray.getDimensionPixelSize(9, this.a.f5412g));
            }
            if (typedArray.hasValue(8)) {
                b(typedArray.getDimensionPixelSize(8, this.a.f5413h));
            }
            if (typedArray.hasValue(13)) {
                e(typedArray.getFloat(13, this.a.f5416k));
            }
            if (typedArray.hasValue(20)) {
                g(typedArray.getFloat(20, this.a.f5414i));
            }
            if (typedArray.hasValue(10)) {
                c(typedArray.getFloat(10, this.a.f5415j));
            }
            if (typedArray.hasValue(19)) {
                f(typedArray.getFloat(19, this.a.f5418m));
            }
            return (T) b();
        }

        protected abstract T b();

        public T b(@Px int i2) {
            if (i2 >= 0) {
                this.a.f5413h = i2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid height: " + i2);
        }

        public T c(@Px int i2) {
            if (i2 >= 0) {
                this.a.f5412g = i2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid width: " + i2);
        }

        public T d(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
            int iA = (int) (a(0.0f, 1.0f, f2) * 255.0f);
            Shimmer shimmer = this.a;
            shimmer.f5409d = (iA << 24) | (shimmer.f5409d & ViewCompat.MEASURED_SIZE_MASK);
            return (T) b();
        }

        public T e(float f2) {
            if (f2 >= 0.0f) {
                this.a.f5416k = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f2);
        }

        public T f(int i2) {
            this.a.f5411f = i2;
            return (T) b();
        }

        public T g(float f2) {
            if (f2 >= 0.0f) {
                this.a.f5414i = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f2);
        }

        public T f(float f2) {
            this.a.f5418m = f2;
            return (T) b();
        }

        public T b(float f2) {
            if (f2 >= 0.0f) {
                this.a.f5417l = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f2);
        }

        public T c(float f2) {
            if (f2 >= 0.0f) {
                this.a.f5415j = f2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f2);
        }

        public T d(int i2) {
            this.a.f5422q = i2;
            return (T) b();
        }

        public T e(int i2) {
            this.a.f5423r = i2;
            return (T) b();
        }

        public T b(boolean z2) {
            this.a.f5419n = z2;
            return (T) b();
        }

        public T c(long j2) {
            if (j2 >= 0) {
                this.a.f5426u = j2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given a negative start delay: " + j2);
        }

        public T b(long j2) {
            if (j2 >= 0) {
                this.a.f5425t = j2;
                return (T) b();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j2);
        }

        public T a(int i2) {
            this.a.f5408c = i2;
            return (T) b();
        }

        public T a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
            int iA = (int) (a(0.0f, 1.0f, f2) * 255.0f);
            Shimmer shimmer = this.a;
            shimmer.f5410e = (iA << 24) | (shimmer.f5410e & ViewCompat.MEASURED_SIZE_MASK);
            return (T) b();
        }

        public T a(boolean z2) {
            this.a.f5420o = z2;
            return (T) b();
        }

        public T a(long j2) {
            if (j2 >= 0) {
                this.a.f5424s = j2;
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
        if (this.f5411f != 1) {
            int[] iArr = this.b;
            int i2 = this.f5410e;
            iArr[0] = i2;
            int i3 = this.f5409d;
            iArr[1] = i3;
            iArr[2] = i3;
            iArr[3] = i2;
            return;
        }
        int[] iArr2 = this.b;
        int i4 = this.f5409d;
        iArr2[0] = i4;
        iArr2[1] = i4;
        int i5 = this.f5410e;
        iArr2[2] = i5;
        iArr2[3] = i5;
    }

    void b() {
        if (this.f5411f != 1) {
            this.a[0] = Math.max(((1.0f - this.f5416k) - this.f5417l) / 2.0f, 0.0f);
            this.a[1] = Math.max(((1.0f - this.f5416k) - 0.001f) / 2.0f, 0.0f);
            this.a[2] = Math.min(((this.f5416k + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.a[3] = Math.min(((this.f5416k + 1.0f) + this.f5417l) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.f5416k, 1.0f);
        this.a[2] = Math.min(this.f5416k + this.f5417l, 1.0f);
        this.a[3] = 1.0f;
    }
}
