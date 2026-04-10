package com.bytedance.sdk.openadsdk.core.component.splash.g.z;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.e;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.gc;
import com.bytedance.sdk.openadsdk.core.component.splash.dl.z.m;
import com.bytedance.sdk.openadsdk.core.sy;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private e z = new e();
    private int dl = 3;
    private final sy g = zw.z();

    public void z(final gc gcVar, final com.bytedance.sdk.openadsdk.core.component.splash.dl.dl.g<m, e> gVar) {
        if (this.g == null || gcVar == null) {
            return;
        }
        this.z.g(false);
        this.g.z(gcVar.a(), gcVar.gc(), this.dl, new sy.g() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.g.z.dl.1
            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
                dl.this.z.g(i);
                dl.this.z.dl(gVar2 != null ? gVar2.dl() : 0);
                if (TextUtils.isEmpty(str)) {
                    str = "load ad error";
                }
                dl.this.z.z(str);
                gVar.z(dl.this.z);
            }

            @Override // com.bytedance.sdk.openadsdk.core.sy.g
            public void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar2) {
                if (zVar == null || zVar.g() == null) {
                    dl.this.z.g(1);
                    dl.this.z.z("no ad or material");
                    gVar.z(dl.this.z);
                    return;
                }
                m mVar = new m(zVar, false);
                mVar.g(gVar2.fo());
                mVar.dl(gVar2.uy());
                mVar.a(gVar2.kb());
                mVar.gc(gVar2.wp());
                mVar.z(gcVar.z());
                mVar.z(gcVar.dl());
                gVar.g(mVar);
            }
        });
    }
}
