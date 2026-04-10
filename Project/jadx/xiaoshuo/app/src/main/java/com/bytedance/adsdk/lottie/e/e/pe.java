package com.bytedance.adsdk.lottie.e.e;

import com.bytedance.adsdk.lottie.d.bf.k;
import com.bytedance.adsdk.lottie.e.bf.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class pe implements e.InterfaceC0061e, d {
    private final boolean bf;
    private final List<e.InterfaceC0061e> d = new ArrayList();
    private final String e;
    private final com.bytedance.adsdk.lottie.e.bf.e<?, Float> ga;
    private final com.bytedance.adsdk.lottie.e.bf.e<?, Float> p;
    private final k.e tg;
    private final com.bytedance.adsdk.lottie.e.bf.e<?, Float> vn;

    public pe(com.bytedance.adsdk.lottie.d.d.e eVar, com.bytedance.adsdk.lottie.d.bf.k kVar) {
        this.e = kVar.e();
        this.bf = kVar.ga();
        this.tg = kVar.getType();
        com.bytedance.adsdk.lottie.e.bf.e<Float, Float> eVarE = kVar.d().e();
        this.ga = eVarE;
        com.bytedance.adsdk.lottie.e.bf.e<Float, Float> eVarE2 = kVar.bf().e();
        this.vn = eVarE2;
        com.bytedance.adsdk.lottie.e.bf.e<Float, Float> eVarE3 = kVar.tg().e();
        this.p = eVarE3;
        eVar.e(eVarE);
        eVar.e(eVarE2);
        eVar.e(eVarE3);
        eVarE.e(this);
        eVarE2.e(this);
        eVarE3.e(this);
    }

    @Override // com.bytedance.adsdk.lottie.e.e.d
    public String bf() {
        return this.e;
    }

    public com.bytedance.adsdk.lottie.e.bf.e<?, Float> d() {
        return this.ga;
    }

    @Override // com.bytedance.adsdk.lottie.e.e.d
    public void e(List<d> list, List<d> list2) {
    }

    public com.bytedance.adsdk.lottie.e.bf.e<?, Float> ga() {
        return this.p;
    }

    public k.e getType() {
        return this.tg;
    }

    public com.bytedance.adsdk.lottie.e.bf.e<?, Float> tg() {
        return this.vn;
    }

    public boolean vn() {
        return this.bf;
    }

    @Override // com.bytedance.adsdk.lottie.e.bf.e.InterfaceC0061e
    public void e() {
        for (int i = 0; i < this.d.size(); i++) {
            this.d.get(i).e();
        }
    }

    public void e(e.InterfaceC0061e interfaceC0061e) {
        this.d.add(interfaceC0061e);
    }
}
