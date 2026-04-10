package com.bytedance.adsdk.g.g.g.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p implements com.bytedance.adsdk.g.g.g.z {
    protected com.bytedance.adsdk.g.g.a.dl dl;
    protected com.bytedance.adsdk.g.g.g.z g;
    protected com.bytedance.adsdk.g.g.g.z z;

    protected p(com.bytedance.adsdk.g.g.a.dl dlVar) {
        this.dl = dlVar;
    }

    public void z(com.bytedance.adsdk.g.g.g.z zVar) {
        this.z = zVar;
    }

    public void g(com.bytedance.adsdk.g.g.g.z zVar) {
        this.g = zVar;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public com.bytedance.adsdk.g.g.a.gc z() {
        return com.bytedance.adsdk.g.g.a.m.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.g.g.g.z
    public String g() {
        return this.z.g() + this.dl.z() + this.g.g();
    }

    public String toString() {
        return g();
    }
}
