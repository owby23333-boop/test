package com.amgcyo.cuttadon.view.xtablayout;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.amgcyo.cuttadon.view.xtablayout.d;

/* JADX INFO: compiled from: ValueAnimatorCompatImplEclairMr1.java */
/* JADX INFO: loaded from: classes.dex */
class e extends d.g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Handler f5634k = new Handler(Looper.getMainLooper());
    private long a;
    private boolean b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Interpolator f5638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.g.a f5639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.g.b f5640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f5641i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f5635c = new int[2];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f5636d = new float[2];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5637e = 200;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Runnable f5642j = new a();

    /* JADX INFO: compiled from: ValueAnimatorCompatImplEclairMr1.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.update();
        }
    }

    e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        if (this.b) {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.a) / this.f5637e;
            Interpolator interpolator = this.f5638f;
            if (interpolator != null) {
                fUptimeMillis = interpolator.getInterpolation(fUptimeMillis);
            }
            this.f5641i = fUptimeMillis;
            d.g.b bVar = this.f5640h;
            if (bVar != null) {
                bVar.a();
            }
            if (SystemClock.uptimeMillis() >= this.a + ((long) this.f5637e)) {
                this.b = false;
                d.g.a aVar = this.f5639g;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
        if (this.b) {
            f5634k.postDelayed(this.f5642j, 10L);
        }
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public float b() {
        return this.f5641i;
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public int c() {
        int[] iArr = this.f5635c;
        return com.amgcyo.cuttadon.view.xtablayout.a.a(iArr[0], iArr[1], b());
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public long d() {
        return this.f5637e;
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public boolean e() {
        return this.b;
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void f() {
        if (this.b) {
            return;
        }
        if (this.f5638f == null) {
            this.f5638f = new AccelerateDecelerateInterpolator();
        }
        this.a = SystemClock.uptimeMillis();
        this.b = true;
        d.g.a aVar = this.f5639g;
        if (aVar != null) {
            aVar.c();
        }
        f5634k.postDelayed(this.f5642j, 10L);
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(Interpolator interpolator) {
        this.f5638f = interpolator;
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(d.g.a aVar) {
        this.f5639g = aVar;
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(d.g.b bVar) {
        this.f5640h = bVar;
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(int i2, int i3) {
        int[] iArr = this.f5635c;
        iArr[0] = i2;
        iArr[1] = i3;
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(float f2, float f3) {
        float[] fArr = this.f5636d;
        fArr[0] = f2;
        fArr[1] = f3;
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a(int i2) {
        this.f5637e = i2;
    }

    @Override // com.amgcyo.cuttadon.view.xtablayout.d.g
    public void a() {
        this.b = false;
        f5634k.removeCallbacks(this.f5642j);
        d.g.a aVar = this.f5639g;
        if (aVar != null) {
            aVar.b();
        }
    }
}
