package com.bytedance.sdk.gromore.z.z.e.gc;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.dl.a.wp;
import com.bytedance.sdk.gromore.z.z.gc;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.tb.z.g.z.e;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f885a;
    private e dl;
    private com.bytedance.sdk.openadsdk.mediation.g.g.z g;
    private wp z;

    public dl(Context context, com.bytedance.sdk.openadsdk.mediation.g.g.z zVar, e eVar) {
        this.g = zVar;
        if (zVar != null) {
            this.z = new wp(context);
            this.dl = eVar;
        }
    }

    @Override // com.bytedance.sdk.gromore.z.z.gc
    public void z() {
        HashMap map = new HashMap();
        String strI = this.g.i();
        if (!TextUtils.isEmpty(strI)) {
            map.put(MediationConstant.ADN_GDT, strI);
        }
        this.z.z(new com.bytedance.msdk.api.z.g(7, this.g.gk()), new com.bytedance.msdk.api.a.z.gz.g() { // from class: com.bytedance.sdk.gromore.z.z.e.gc.dl.1
            @Override // com.bytedance.msdk.api.a.z.gz.g
            public void z(com.bytedance.msdk.api.z zVar) {
                if (zVar == null || dl.this.dl == null) {
                    return;
                }
                dl.this.dl.z(zVar.z, zVar.g);
            }

            @Override // com.bytedance.msdk.api.a.z.gz.g
            public void z() {
                if (dl.this.dl != null) {
                    if (dl.this.f885a == null) {
                        dl.this.f885a = new z(dl.this.z);
                    }
                    dl.this.dl.z(dl.this.f885a);
                }
            }

            @Override // com.bytedance.msdk.api.a.z.gz.g
            public void g() {
                if (dl.this.dl != null) {
                    dl.this.dl.z();
                    if (dl.this.f885a == null) {
                        dl.this.f885a = new z(dl.this.z);
                    }
                    dl.this.dl.g(dl.this.f885a);
                }
            }
        });
    }
}
