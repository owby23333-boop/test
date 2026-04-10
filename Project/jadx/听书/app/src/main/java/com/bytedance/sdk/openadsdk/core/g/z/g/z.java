package com.bytedance.sdk.openadsdk.core.g.z.g;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.un.oq;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    private com.bytedance.sdk.openadsdk.core.nativeexpress.dl gc;
    private int m;

    public z() {
    }

    public z(na naVar, Context context) {
        this.z = naVar;
        this.g = context;
    }

    public void z(com.bytedance.sdk.openadsdk.core.nativeexpress.dl dlVar) {
        this.gc = dlVar;
    }

    public void z(int i) {
        this.m = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.z.z
    public void z(View view) {
        this.f1076a = view;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.z.z
    public int z(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.g.z.dl dlVar) {
        if (this.gc == null) {
            return 0;
        }
        if (this.dl == null) {
            this.dl = new uy();
        }
        View viewM = this.dl.m();
        int[] iArrZ = new int[2];
        int[] iArrDl = new int[2];
        if (viewM != null) {
            iArrZ = oq.z(viewM);
            iArrDl = oq.dl(viewM);
        }
        this.gc.z(this.f1076a, this.m, new zw.z().a(this.dl.v()).dl(this.dl.pf()).g(this.dl.ls()).z(this.dl.p()).g(this.dl.wp()).z(this.dl.i()).z(iArrZ[0]).g(iArrZ[1]).dl(iArrDl[0]).a(iArrDl[1]).z(this.dl.gc()).z(this.dl.uy()).z());
        return 1;
    }
}
