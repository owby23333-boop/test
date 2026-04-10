package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.iq.fo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.bytedance.sdk.openadsdk.core.g.z {
    protected int i;
    private boolean kb;
    private com.bytedance.sdk.openadsdk.core.iq.zw uy;
    protected int v;
    protected int wp;

    public a(Context context, na naVar, String str, int i) {
        super(context, naVar, str, i);
        this.wp = 0;
        this.i = -1;
        this.v = -1;
        this.kb = true;
        if (naVar == null) {
            return;
        }
        com.bytedance.sdk.component.kb.gc.z.z().z(naVar.hashCode() + naVar.aq()).put("is_express_ad", Boolean.TRUE);
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.a
    public void dl() {
        this.i = 1;
        this.kb = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.a
    public void a() {
        this.v = 1;
        this.kb = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.g, com.bytedance.sdk.openadsdk.core.g.a
    public void z(View view, com.bytedance.sdk.openadsdk.core.iq.uy uyVar) {
        com.bytedance.sdk.openadsdk.core.g.z.dl.z zVar = (com.bytedance.sdk.openadsdk.core.g.z.dl.z) z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class);
        zVar.z(z(zVar.dl()));
        super.z(view, uyVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.a
    public void gc(int i) {
        this.wp = i;
    }

    protected com.bytedance.sdk.openadsdk.core.iq.fo z(String str) {
        int i;
        int i2;
        String str2;
        String str3;
        String str4;
        String str5;
        int iDl;
        int iDl2;
        View viewE = this.e.e();
        int[] iArrZ = oq.z(viewE);
        if (iArrZ == null || iArrZ.length != 2) {
            i = 0;
            i2 = 0;
        } else {
            i = iArrZ[0];
            i2 = iArrZ[1];
            if (this.wp == 0 && this.kb) {
                this.e.z((oq.dl(this.m, this.e.v()) + i) - 0.5f);
                this.e.g((oq.dl(this.m, this.e.pf()) + i2) - 0.5f);
                this.e.dl((oq.dl(this.m, this.e.ls()) + i) - 0.5f);
                this.e.a((oq.dl(this.m, this.e.p()) + i2) - 0.5f);
            }
        }
        int[] iArrZ2 = {-1, -1};
        int[] iArrDl = new int[2];
        if (this.uy == null || !this.kb) {
            str2 = "";
            str3 = str;
            str4 = "";
            str5 = str4;
        } else {
            this.e.z(this.uy.gc);
            this.e.g(this.uy.m);
            if (this.wp == 0) {
                iArrZ2[0] = oq.dl(this.m, this.uy.e) + i;
                iArrZ2[1] = oq.dl(this.m, this.uy.gz) + i2;
                iDl = oq.dl(this.m, this.uy.fo);
                iDl2 = oq.dl(this.m, this.uy.uy);
            } else {
                iArrZ2[0] = this.uy.e;
                iArrZ2[1] = this.uy.gz;
                iDl = this.uy.fo;
                iDl2 = this.uy.uy;
            }
            str3 = TextUtils.isEmpty(str) ? this.uy.kb : str;
            str2 = this.uy.wp;
            str4 = this.uy.i;
            str5 = this.uy.v;
            iArrDl[0] = iDl;
            iArrDl[1] = iDl2;
            View viewM = this.e.m();
            if (iDl == 0 && iDl2 == 0 && viewM != null) {
                iArrZ2 = oq.z(viewM);
                iArrDl = oq.dl(viewM);
            }
        }
        this.wp = 0;
        return new fo.z().m(this.e.v()).gc(this.e.pf()).a(this.e.ls()).dl(this.e.p()).g(this.e.wp()).z(this.e.i()).g(iArrZ).z(iArrZ2).dl(oq.dl(viewE)).a(iArrDl).dl(this.e.g()).a(this.e.dl()).gc(this.e.a()).g(com.bytedance.sdk.openadsdk.core.uy.ls().dl() ? 1 : 2).z(this.e.uy()).z(str3).g(str4).dl(str2).a(str5).z(oq.m(this.m)).z(oq.gz(this.m)).m(this.i).e(this.v).g(oq.e(this.m)).gc(this.e.fv()).gz(this.e.js()).z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.a
    public void z(com.bytedance.sdk.openadsdk.core.iq.zw zwVar) {
        this.uy = zwVar;
    }
}
