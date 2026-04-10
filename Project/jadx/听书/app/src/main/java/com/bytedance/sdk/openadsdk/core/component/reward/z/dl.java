package com.bytedance.sdk.openadsdk.core.component.reward.z;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.analytics.pro.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl {
    private final com.bytedance.sdk.openadsdk.core.gc.gc.a g;
    protected Context z;

    protected abstract int g();

    protected dl(Context context) {
        this.z = context == null ? zw.getContext() : context.getApplicationContext();
        this.g = new com.bytedance.sdk.openadsdk.core.gc.gc.a(g());
    }

    public void z(final String str) {
        com.bytedance.sdk.openadsdk.hh.e.z(new fo("rewardFull preloadOnDestroy") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.dl.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarZ = com.bytedance.sdk.openadsdk.core.component.reward.z.z.z.z().z(str);
                if (gVarZ == null || TextUtils.isEmpty(gVarZ.a())) {
                    return;
                }
                na naVarZ = com.bytedance.sdk.openadsdk.core.gc.a.gc.z(dl.this.g()).z(gVarZ.a(), false, 0L);
                if (zw.g().g(gVarZ.a()) && naVarZ != null) {
                    if (naVarZ.ti() + naVarZ.zw() < System.currentTimeMillis()) {
                        com.bytedance.sdk.openadsdk.core.gc.a.gc.z(dl.this.g()).z(gVarZ.a());
                    }
                }
                if (naVarZ == null) {
                    dl.this.z(gVarZ);
                }
            }
        });
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (this.g != null) {
            this.g.z(gVar, z(true, System.currentTimeMillis(), (com.bytedance.sdk.openadsdk.core.component.reward.business.g.dl) null));
        }
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, a aVar) {
        if (gVar != null) {
            gVar.a();
        }
        z(gVar, aVar, (com.bytedance.sdk.openadsdk.core.component.reward.business.g.dl) null);
    }

    protected void z(final com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, final a aVar, com.bytedance.sdk.openadsdk.core.component.reward.business.g.dl dlVar) {
        boolean z = (dlVar == null || !dlVar.dl()) && com.bytedance.sdk.openadsdk.core.live.gc.a.z(gVar.iq());
        j jVarZ = z(false, aVar != null ? aVar.z() : System.currentTimeMillis(), dlVar);
        com.bytedance.sdk.openadsdk.core.gc.gc.a aVar2 = this.g;
        if (aVar2 != null) {
            aVar2.z(gVar, jVarZ, z ? -1 : 0, new com.bytedance.sdk.openadsdk.core.gc.gc.gc() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.z.dl.2
                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
                public void z(Object obj) {
                    gVar.a();
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.z(obj);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
                public void g(Object obj) {
                    gVar.a();
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.g(obj);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.gc.gc.gc
                public void z(int i, String str) {
                    gVar.a();
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.z(i, str);
                    }
                }
            });
        }
    }

    private j z(boolean z, long j, com.bytedance.sdk.openadsdk.core.component.reward.business.g.dl dlVar) {
        boolean z2;
        j jVar = new j();
        jVar.gz = j;
        if (z) {
            jVar.z = 2;
        }
        jVar.m = 2;
        if (dlVar == null || !dlVar.dl()) {
            z2 = false;
        } else {
            jVar.g = dlVar.z();
            jVar.dl = dlVar.g();
            z2 = true;
            jVar.f1172a = 1;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", z2);
        bundle.putBoolean("is_preload", z);
        bundle.putLong(d.p, jVar.gz);
        jVar.pf = bundle;
        return jVar;
    }
}
