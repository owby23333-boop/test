package com.bytedance.sdk.gromore.z.z.e.m;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.a.kb;
import com.bytedance.msdk.dl.a.i;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements com.bytedance.sdk.gromore.z.z.m.dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f886a;
    private com.bytedance.sdk.openadsdk.tb.z.g.z.z dl;
    private com.bytedance.sdk.openadsdk.mediation.g.g.z g;
    private i z;

    public dl(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, com.bytedance.sdk.openadsdk.tb.z.g.z.z zVar2, boolean z) {
        this.g = zVar;
        this.f886a = z;
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "CSJMSplashLoader 构造函数创建 mAdSlotValueSet = " + this.g + " mAdSlotValueSet.getCodeId() = " + this.g.a());
        if (this.g != null) {
            this.z = new i(context);
            this.dl = zVar2;
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.gc
    public void z() {
        z(-1);
    }

    @Override // com.bytedance.sdk.gromore.z.z.m.dl
    public void z(int i) {
        final com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.dl dlVarI;
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "CSJMSplashLoader load timeout = ".concat(String.valueOf(i)));
        com.bytedance.msdk.core.kb.z.z().g();
        com.bytedance.msdk.api.z.g gVar = new com.bytedance.msdk.api.z.g(3, this.g.gk());
        gVar.z(this.f886a);
        if (i != -1) {
            gVar.gz(i);
        }
        com.bytedance.sdk.openadsdk.mediation.g.g.g gVarL = this.g.l();
        this.z.z(gVar, (gVarL == null || (dlVarI = gVarL.i()) == null || TextUtils.isEmpty(dlVarI.z()) || TextUtils.isEmpty(dlVarI.dl()) || TextUtils.isEmpty(dlVarI.g())) ? null : new kb() { // from class: com.bytedance.sdk.gromore.z.z.e.m.dl.1
            @Override // com.bytedance.msdk.api.a.kb
            public int z() {
                String strZ = dlVarI.z();
                strZ.hashCode();
                switch (strZ) {
                    case "klevin":
                        return 9;
                    case "pangle":
                        return 1;
                    case "sigmob":
                        return 8;
                    case "xiaomi":
                        return 10;
                    case "ks":
                        return 7;
                    case "gdt":
                        return 3;
                    case "baidu":
                        return 6;
                    case "mintegral":
                        return 4;
                    default:
                        return super.z();
                }
            }

            @Override // com.bytedance.msdk.api.a.kb
            public String g() {
                return dlVarI.g();
            }

            @Override // com.bytedance.msdk.api.a.kb
            public String dl() {
                return dlVarI.dl();
            }

            @Override // com.bytedance.msdk.api.a.kb
            public String a() {
                return dlVarI.a();
            }
        }, new com.bytedance.msdk.api.a.z.fo.dl() { // from class: com.bytedance.sdk.gromore.z.z.e.m.dl.2
            @Override // com.bytedance.msdk.api.a.z.fo.dl
            public void z(com.bytedance.msdk.api.z zVar) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "CSJMSplashLoader onSplashAdLoadFail");
                if (zVar == null || dl.this.dl == null) {
                    return;
                }
                com.bytedance.sdk.gromore.z.z.z zVar2 = new com.bytedance.sdk.gromore.z.z.z(zVar.z, zVar.g);
                dl.this.dl.z(zVar2);
                dl.this.dl.z(null, zVar2);
            }

            @Override // com.bytedance.msdk.api.a.z.fo.dl
            public void z() {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "CSJMSplashLoader onSplashAdLoadSuccess");
                if (dl.this.dl != null) {
                    z zVar = new z(dl.this.z, dl.this.dl);
                    dl.this.dl.z(zVar);
                    dl.this.dl.g(zVar);
                }
            }
        });
    }
}
