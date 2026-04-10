package com.bytedance.adsdk.lottie.z.g;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z<K, A> {
    protected com.bytedance.adsdk.lottie.m.dl<A> dl;
    private final dl<K> gc;
    final List<InterfaceC0041z> z = new ArrayList(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f203a = false;
    protected float g = 0.0f;
    private A m = null;
    private float e = -1.0f;
    private float gz = -1.0f;

    private interface dl<T> {
        float a();

        float dl();

        com.bytedance.adsdk.lottie.m.z<T> g();

        boolean g(float f);

        boolean z();

        boolean z(float f);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.z.g.z$z, reason: collision with other inner class name */
    public interface InterfaceC0041z {
        void z();
    }

    abstract A z(com.bytedance.adsdk.lottie.m.z<K> zVar, float f);

    z(List<? extends com.bytedance.adsdk.lottie.m.z<K>> list) {
        this.gc = z(list);
    }

    public void z() {
        this.f203a = true;
    }

    public void z(InterfaceC0041z interfaceC0041z) {
        this.z.add(interfaceC0041z);
    }

    public void z(float f) {
        if (this.gc.z()) {
            return;
        }
        if (f < fo()) {
            f = fo();
        } else if (f > m()) {
            f = m();
        }
        if (f == this.g) {
            return;
        }
        this.g = f;
        if (this.gc.z(f)) {
            g();
        }
    }

    public void g() {
        for (int i = 0; i < this.z.size(); i++) {
            this.z.get(i).z();
        }
    }

    protected com.bytedance.adsdk.lottie.m.z<K> dl() {
        com.bytedance.adsdk.lottie.gc.z("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.lottie.m.z<K> zVarG = this.gc.g();
        com.bytedance.adsdk.lottie.gc.g("BaseKeyframeAnimation#getCurrentKeyframe");
        return zVarG;
    }

    float a() {
        if (this.f203a) {
            return 0.0f;
        }
        com.bytedance.adsdk.lottie.m.z<K> zVarDl = dl();
        if (zVarDl.gc()) {
            return 0.0f;
        }
        return (this.g - zVarDl.dl()) / (zVarDl.a() - zVarDl.dl());
    }

    protected float gc() {
        com.bytedance.adsdk.lottie.m.z<K> zVarDl = dl();
        if (zVarDl == null || zVarDl.gc()) {
            return 0.0f;
        }
        return zVarDl.dl.getInterpolation(a());
    }

    private float fo() {
        if (this.e == -1.0f) {
            this.e = this.gc.dl();
        }
        return this.e;
    }

    float m() {
        if (this.gz == -1.0f) {
            this.gz = this.gc.a();
        }
        return this.gz;
    }

    public A e() {
        A aZ;
        float fA = a();
        if (this.dl == null && this.gc.g(fA)) {
            return this.m;
        }
        com.bytedance.adsdk.lottie.m.z<K> zVarDl = dl();
        if (zVarDl.f160a != null && zVarDl.gc != null) {
            aZ = z(zVarDl, fA, zVarDl.f160a.getInterpolation(fA), zVarDl.gc.getInterpolation(fA));
        } else {
            aZ = z(zVarDl, gc());
        }
        this.m = aZ;
        return aZ;
    }

    public float gz() {
        return this.g;
    }

    protected A z(com.bytedance.adsdk.lottie.m.z<K> zVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> dl<T> z(List<? extends com.bytedance.adsdk.lottie.m.z<T>> list) {
        if (list.isEmpty()) {
            return new g();
        }
        if (list.size() == 1) {
            return new gc(list);
        }
        return new a(list);
    }

    private static final class g<T> implements dl<T> {
        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public float a() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public float dl() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public boolean z() {
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public boolean z(float f) {
            return false;
        }

        private g() {
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public com.bytedance.adsdk.lottie.m.z<T> g() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public boolean g(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    private static final class gc<T> implements dl<T> {
        private float g = -1.0f;
        private final com.bytedance.adsdk.lottie.m.z<T> z;

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public boolean z() {
            return false;
        }

        gc(List<? extends com.bytedance.adsdk.lottie.m.z<T>> list) {
            this.z = list.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public boolean z(float f) {
            return !this.z.gc();
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public com.bytedance.adsdk.lottie.m.z<T> g() {
            return this.z;
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public float dl() {
            return this.z.dl();
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public float a() {
            return this.z.a();
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public boolean g(float f) {
            if (this.g == f) {
                return true;
            }
            this.g = f;
            return false;
        }
    }

    private static final class a<T> implements dl<T> {
        private final List<? extends com.bytedance.adsdk.lottie.m.z<T>> z;
        private com.bytedance.adsdk.lottie.m.z<T> dl = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f204a = -1.0f;
        private com.bytedance.adsdk.lottie.m.z<T> g = dl(0.0f);

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public boolean z() {
            return false;
        }

        a(List<? extends com.bytedance.adsdk.lottie.m.z<T>> list) {
            this.z = list;
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public boolean z(float f) {
            if (this.g.z(f)) {
                return !this.g.gc();
            }
            this.g = dl(f);
            return true;
        }

        private com.bytedance.adsdk.lottie.m.z<T> dl(float f) {
            com.bytedance.adsdk.lottie.m.z<T> zVar = this.z.get(r0.size() - 1);
            if (f >= zVar.dl()) {
                return zVar;
            }
            for (int size = this.z.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.lottie.m.z<T> zVar2 = this.z.get(size);
                if (this.g != zVar2 && zVar2.z(f)) {
                    return zVar2;
                }
            }
            return this.z.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public com.bytedance.adsdk.lottie.m.z<T> g() {
            return this.g;
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public float dl() {
            return this.z.get(0).dl();
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public float a() {
            return this.z.get(r0.size() - 1).a();
        }

        @Override // com.bytedance.adsdk.lottie.z.g.z.dl
        public boolean g(float f) {
            com.bytedance.adsdk.lottie.m.z<T> zVar = this.dl;
            com.bytedance.adsdk.lottie.m.z<T> zVar2 = this.g;
            if (zVar == zVar2 && this.f204a == f) {
                return true;
            }
            this.dl = zVar2;
            this.f204a = f;
            return false;
        }
    }
}
