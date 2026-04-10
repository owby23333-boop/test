package com.bytedance.adsdk.e.bf.e.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class w implements com.bytedance.adsdk.e.bf.e.e {
    protected com.bytedance.adsdk.e.bf.e.e bf;
    protected com.bytedance.adsdk.e.bf.d.bf d;
    protected com.bytedance.adsdk.e.bf.e.e e;

    public w(com.bytedance.adsdk.e.bf.d.bf bfVar) {
        this.d = bfVar;
    }

    public void bf(com.bytedance.adsdk.e.bf.e.e eVar) {
        this.bf = eVar;
    }

    public void e(com.bytedance.adsdk.e.bf.e.e eVar) {
        this.e = eVar;
    }

    public String toString() {
        return bf();
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public String bf() {
        return this.e.bf() + this.d.e() + this.bf.bf();
    }

    @Override // com.bytedance.adsdk.e.bf.e.e
    public com.bytedance.adsdk.e.bf.d.tg e() {
        return com.bytedance.adsdk.e.bf.d.ga.OPERATOR_RESULT;
    }
}
