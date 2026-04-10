package com.bytedance.sdk.openadsdk.xu.e;

import com.bytedance.sdk.component.ga.p;
import com.bytedance.sdk.component.ga.wu;
import com.bytedance.sdk.openadsdk.core.dt.n;
import com.bytedance.sdk.openadsdk.core.y.e.e;

/* JADX INFO: loaded from: classes10.dex */
public class e extends com.bytedance.sdk.openadsdk.core.y.e.e {
    private n e;

    private void e(wu wuVar) {
        p pVarVn = wuVar.vn();
        if (pVarVn == null || !tg()) {
            return;
        }
        e(pVarVn.e());
    }

    private void ga() {
        if (tg()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            n nVar = this.e;
            nVar.v(jCurrentTimeMillis - nVar.k());
            this.e.bh(jCurrentTimeMillis);
        }
    }

    private boolean tg() {
        n nVar = this.e;
        return nVar != null && nVar.y();
    }

    public n d() {
        return this.e;
    }

    private void e(long j) {
        this.e.t(j);
        n nVar = this.e;
        nVar.zk(j - nVar.pe());
    }

    public void e(n nVar) {
        this.e = nVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.e.e
    public void e(wu wuVar, e.bf bfVar) {
        e(wuVar);
        super.e(wuVar, bfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.y.e.e
    public void e() {
        ga();
    }
}
