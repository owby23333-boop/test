package com.bytedance.adsdk.lottie.gc;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
public class m extends z implements Choreographer.FrameCallback {
    private com.bytedance.adsdk.lottie.m uy;
    private float g = 1.0f;
    private boolean dl = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f150a = 0;
    private float gc = 0.0f;
    private float m = 0.0f;
    private int e = 0;
    private float gz = -2.1474836E9f;
    private float fo = 2.1474836E9f;
    protected boolean z = false;
    private boolean kb = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(m());
    }

    public float m() {
        com.bytedance.adsdk.lottie.m mVar = this.uy;
        if (mVar == null) {
            return 0.0f;
        }
        return (this.m - mVar.m()) / (this.uy.e() - this.uy.m());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fPf;
        float fLs;
        float fPf2;
        if (this.uy == null) {
            return 0.0f;
        }
        if (tb()) {
            fPf = ls() - this.m;
            fLs = ls();
            fPf2 = pf();
        } else {
            fPf = this.m - pf();
            fLs = ls();
            fPf2 = pf();
        }
        return fPf / (fLs - fPf2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.bytedance.adsdk.lottie.m mVar = this.uy;
        if (mVar == null) {
            return 0L;
        }
        return (long) mVar.gc();
    }

    public float e() {
        return this.m;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.z;
    }

    public void dl(boolean z) {
        this.kb = z;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        p();
        if (this.uy == null || !isRunning()) {
            return;
        }
        com.bytedance.adsdk.lottie.gc.z("LottieValueAnimator#doFrame");
        float fJs = (this.f150a != 0 ? j - r1 : 0L) / js();
        float f = this.gc;
        if (tb()) {
            fJs = -fJs;
        }
        float f2 = f + fJs;
        boolean z = !gz.dl(f2, pf(), ls());
        float f3 = this.gc;
        float fG = gz.g(f2, pf(), ls());
        this.gc = fG;
        if (this.kb) {
            fG = (float) Math.floor(fG);
        }
        this.m = fG;
        this.f150a = j;
        if (!this.kb || this.gc != f3) {
            dl();
        }
        if (z) {
            if (getRepeatCount() != -1 && this.e >= getRepeatCount()) {
                float fPf = this.g < 0.0f ? pf() : ls();
                this.gc = fPf;
                this.m = fPf;
                fv();
                g(tb());
            } else {
                z();
                this.e++;
                if (getRepeatMode() == 2) {
                    this.dl = !this.dl;
                    fo();
                } else {
                    float fLs = tb() ? ls() : pf();
                    this.gc = fLs;
                    this.m = fLs;
                }
                this.f150a = j;
            }
        }
        q();
        com.bytedance.adsdk.lottie.gc.g("LottieValueAnimator#doFrame");
    }

    private float js() {
        com.bytedance.adsdk.lottie.m mVar = this.uy;
        if (mVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / mVar.i()) / Math.abs(this.g);
    }

    public void gz() {
        this.uy = null;
        this.gz = -2.1474836E9f;
        this.fo = 2.1474836E9f;
    }

    public void z(com.bytedance.adsdk.lottie.m mVar) {
        boolean z = this.uy == null;
        this.uy = mVar;
        if (z) {
            z(Math.max(this.gz, mVar.m()), Math.min(this.fo, mVar.e()));
        } else {
            z((int) mVar.m(), (int) mVar.e());
        }
        float f = this.m;
        this.m = 0.0f;
        this.gc = 0.0f;
        z((int) f);
        dl();
    }

    public void z(float f) {
        if (this.gc == f) {
            return;
        }
        float fG = gz.g(f, pf(), ls());
        this.gc = fG;
        if (this.kb) {
            fG = (float) Math.floor(fG);
        }
        this.m = fG;
        this.f150a = 0L;
        dl();
    }

    public void z(int i) {
        z(i, (int) this.fo);
    }

    public void g(float f) {
        z(this.gz, f);
    }

    public void z(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        com.bytedance.adsdk.lottie.m mVar = this.uy;
        float fM = mVar == null ? -3.4028235E38f : mVar.m();
        com.bytedance.adsdk.lottie.m mVar2 = this.uy;
        float fE = mVar2 == null ? Float.MAX_VALUE : mVar2.e();
        float fG = gz.g(f, fM, fE);
        float fG2 = gz.g(f2, fM, fE);
        if (fG == this.gz && fG2 == this.fo) {
            return;
        }
        this.gz = fG;
        this.fo = fG2;
        z((int) gz.g(this.m, fG, fG2));
    }

    public void fo() {
        dl(-uy());
    }

    public void dl(float f) {
        this.g = f;
    }

    public float uy() {
        return this.g;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.dl) {
            return;
        }
        this.dl = false;
        fo();
    }

    public void kb() {
        this.z = true;
        z(tb());
        z((int) (tb() ? ls() : pf()));
        this.f150a = 0L;
        this.e = 0;
        p();
    }

    public void wp() {
        fv();
        g(tb());
    }

    public void i() {
        fv();
        a();
    }

    public void v() {
        this.z = true;
        p();
        this.f150a = 0L;
        if (tb() && e() == pf()) {
            z(ls());
        } else if (!tb() && e() == ls()) {
            z(pf());
        }
        gc();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        g();
        fv();
    }

    private boolean tb() {
        return uy() < 0.0f;
    }

    public float pf() {
        com.bytedance.adsdk.lottie.m mVar = this.uy;
        if (mVar == null) {
            return 0.0f;
        }
        float f = this.gz;
        return f == -2.1474836E9f ? mVar.m() : f;
    }

    public float ls() {
        com.bytedance.adsdk.lottie.m mVar = this.uy;
        if (mVar == null) {
            return 0.0f;
        }
        float f = this.fo;
        return f == 2.1474836E9f ? mVar.e() : f;
    }

    @Override // com.bytedance.adsdk.lottie.gc.z
    void g() {
        super.g();
        g(tb());
    }

    protected void p() {
        if (isRunning()) {
            a(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void fv() {
        a(true);
    }

    protected void a(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.z = false;
        }
    }

    private void q() {
        if (this.uy == null) {
            return;
        }
        float f = this.m;
        if (f < this.gz || f > this.fo) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.gz), Float.valueOf(this.fo), Float.valueOf(this.m)));
        }
    }
}
