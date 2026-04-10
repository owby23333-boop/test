package com.bytedance.adsdk.lottie.e.bf;

import android.view.animation.Interpolator;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.yuewen.w51;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class e<K, A> {
    protected com.bytedance.adsdk.lottie.p.d<A> d;
    private final d<K> ga;
    final List<InterfaceC0061e> e = new ArrayList(1);
    private boolean tg = false;
    protected float bf = 0.0f;
    private A vn = null;
    private float p = -1.0f;
    private float v = -1.0f;

    public static final class bf<T> implements d<T> {
        private bf() {
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public com.bytedance.adsdk.lottie.p.e<T> bf() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public float d() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public boolean e() {
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public float tg() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public boolean bf(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public boolean e(float f) {
            return false;
        }
    }

    public interface d<T> {
        com.bytedance.adsdk.lottie.p.e<T> bf();

        boolean bf(float f);

        @FloatRange(from = w51.l, to = 1.0d)
        float d();

        boolean e();

        boolean e(float f);

        @FloatRange(from = w51.l, to = 1.0d)
        float tg();
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.e.bf.e$e, reason: collision with other inner class name */
    public interface InterfaceC0061e {
        void e();
    }

    public static final class ga<T> implements d<T> {
        private float bf = -1.0f;
        private final com.bytedance.adsdk.lottie.p.e<T> e;

        public ga(List<? extends com.bytedance.adsdk.lottie.p.e<T>> list) {
            this.e = list.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public com.bytedance.adsdk.lottie.p.e<T> bf() {
            return this.e;
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public float d() {
            return this.e.d();
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public boolean e() {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public float tg() {
            return this.e.tg();
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public boolean bf(float f) {
            if (this.bf == f) {
                return true;
            }
            this.bf = f;
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public boolean e(float f) {
            return !this.e.ga();
        }
    }

    public static final class tg<T> implements d<T> {
        private final List<? extends com.bytedance.adsdk.lottie.p.e<T>> e;
        private com.bytedance.adsdk.lottie.p.e<T> d = null;
        private float tg = -1.0f;
        private com.bytedance.adsdk.lottie.p.e<T> bf = d(0.0f);

        public tg(List<? extends com.bytedance.adsdk.lottie.p.e<T>> list) {
            this.e = list;
        }

        private com.bytedance.adsdk.lottie.p.e<T> d(float f) {
            List<? extends com.bytedance.adsdk.lottie.p.e<T>> list = this.e;
            com.bytedance.adsdk.lottie.p.e<T> eVar = list.get(list.size() - 1);
            if (f >= eVar.d()) {
                return eVar;
            }
            for (int size = this.e.size() - 2; size >= 1; size--) {
                com.bytedance.adsdk.lottie.p.e<T> eVar2 = this.e.get(size);
                if (this.bf != eVar2 && eVar2.e(f)) {
                    return eVar2;
                }
            }
            return this.e.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public com.bytedance.adsdk.lottie.p.e<T> bf() {
            return this.bf;
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public boolean e() {
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public float tg() {
            return this.e.get(r0.size() - 1).tg();
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public boolean bf(float f) {
            com.bytedance.adsdk.lottie.p.e<T> eVar = this.d;
            com.bytedance.adsdk.lottie.p.e<T> eVar2 = this.bf;
            if (eVar == eVar2 && this.tg == f) {
                return true;
            }
            this.d = eVar2;
            this.tg = f;
            return false;
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public boolean e(float f) {
            if (this.bf.e(f)) {
                return !this.bf.ga();
            }
            this.bf = d(f);
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.e.bf.e.d
        public float d() {
            return this.e.get(0).d();
        }
    }

    public e(List<? extends com.bytedance.adsdk.lottie.p.e<K>> list) {
        this.ga = e(list);
    }

    @FloatRange(from = w51.l, to = 1.0d)
    private float zk() {
        if (this.p == -1.0f) {
            this.p = this.ga.d();
        }
        return this.p;
    }

    public void bf() {
        for (int i = 0; i < this.e.size(); i++) {
            this.e.get(i).e();
        }
    }

    public com.bytedance.adsdk.lottie.p.e<K> d() {
        com.bytedance.adsdk.lottie.ga.e("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.lottie.p.e<K> eVarBf = this.ga.bf();
        com.bytedance.adsdk.lottie.ga.bf("BaseKeyframeAnimation#getCurrentKeyframe");
        return eVarBf;
    }

    public abstract A e(com.bytedance.adsdk.lottie.p.e<K> eVar, float f);

    public void e() {
        this.tg = true;
    }

    public float ga() {
        com.bytedance.adsdk.lottie.p.e<K> eVarD = d();
        if (eVarD == null || eVarD.ga()) {
            return 0.0f;
        }
        return eVarD.d.getInterpolation(tg());
    }

    public A p() {
        float fTg = tg();
        if (this.d == null && this.ga.bf(fTg)) {
            return this.vn;
        }
        com.bytedance.adsdk.lottie.p.e<K> eVarD = d();
        Interpolator interpolator = eVarD.tg;
        A aE = (interpolator == null || eVarD.ga == null) ? e(eVarD, ga()) : e(eVarD, fTg, interpolator.getInterpolation(fTg), eVarD.ga.getInterpolation(fTg));
        this.vn = aE;
        return aE;
    }

    public float tg() {
        if (this.tg) {
            return 0.0f;
        }
        com.bytedance.adsdk.lottie.p.e<K> eVarD = d();
        if (eVarD.ga()) {
            return 0.0f;
        }
        return (this.bf - eVarD.d()) / (eVarD.tg() - eVarD.d());
    }

    public float v() {
        return this.bf;
    }

    @FloatRange(from = w51.l, to = 1.0d)
    public float vn() {
        if (this.v == -1.0f) {
            this.v = this.ga.tg();
        }
        return this.v;
    }

    public void e(InterfaceC0061e interfaceC0061e) {
        this.e.add(interfaceC0061e);
    }

    public void e(@FloatRange(from = w51.l, to = 1.0d) float f) {
        if (this.ga.e()) {
            return;
        }
        if (f < zk()) {
            f = zk();
        } else if (f > vn()) {
            f = vn();
        }
        if (f == this.bf) {
            return;
        }
        this.bf = f;
        if (this.ga.e(f)) {
            bf();
        }
    }

    public void e(com.bytedance.adsdk.lottie.p.d<A> dVar) {
        com.bytedance.adsdk.lottie.p.d<A> dVar2 = this.d;
        if (dVar2 != null) {
            dVar2.e(null);
        }
        this.d = dVar;
        if (dVar != null) {
            dVar.e(this);
        }
    }

    public A e(com.bytedance.adsdk.lottie.p.e<K> eVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> d<T> e(List<? extends com.bytedance.adsdk.lottie.p.e<T>> list) {
        if (list.isEmpty()) {
            return new bf();
        }
        if (list.size() == 1) {
            return new ga(list);
        }
        return new tg(list);
    }
}
