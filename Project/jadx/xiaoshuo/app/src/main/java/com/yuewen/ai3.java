package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public class ai3 extends bi3 {
    public pp2 f = new pp2();

    @Override // com.yuewen.bi3
    public void a(int i) {
        super.a(i);
        this.f.f16093a = i;
    }

    @Override // com.yuewen.bi3
    public int b() {
        pp2 pp2Var = this.f;
        return pp2Var != null ? pp2Var.f16093a : super.b();
    }

    @Override // com.yuewen.bi3
    public void d(Object obj) {
        super.d(obj);
        if (obj instanceof pp2) {
            this.f = (pp2) obj;
        }
    }

    @Override // com.yuewen.bi3
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public pp2 c() {
        return this.f;
    }
}
