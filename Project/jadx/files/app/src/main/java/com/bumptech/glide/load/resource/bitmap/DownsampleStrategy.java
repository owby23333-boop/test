package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DownsampleStrategy {
    public static final DownsampleStrategy a;
    public static final DownsampleStrategy b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DownsampleStrategy f13751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final DownsampleStrategy f13752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DownsampleStrategy f13753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bumptech.glide.load.e<DownsampleStrategy> f13754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final boolean f13755g;

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    private static class a extends DownsampleStrategy {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            if (Math.min(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    private static class b extends DownsampleStrategy {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            int iCeil = (int) Math.ceil(Math.max(i3 / i5, i2 / i4));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    private static class c extends DownsampleStrategy {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return b(i2, i3, i4, i5) == 1.0f ? SampleSizeRounding.QUALITY : DownsampleStrategy.a.a(i2, i3, i4, i5);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, DownsampleStrategy.a.b(i2, i3, i4, i5));
        }
    }

    private static class d extends DownsampleStrategy {
        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            return Math.max(i4 / i2, i5 / i3);
        }
    }

    private static class e extends DownsampleStrategy {
        e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return DownsampleStrategy.f13755g ? SampleSizeRounding.QUALITY : SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            if (DownsampleStrategy.f13755g) {
                return Math.min(i4 / i2, i5 / i3);
            }
            if (Math.max(i3 / i5, i2 / i4) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r2);
        }
    }

    private static class f extends DownsampleStrategy {
        f() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i2, int i3, int i4, int i5) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }
    }

    static {
        new a();
        new b();
        a = new e();
        b = new c();
        f13751c = new d();
        f13752d = new f();
        f13753e = f13751c;
        f13754f = com.bumptech.glide.load.e.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", f13753e);
        f13755g = Build.VERSION.SDK_INT >= 19;
    }

    public abstract SampleSizeRounding a(int i2, int i3, int i4, int i5);

    public abstract float b(int i2, int i3, int i4, int i5);
}
