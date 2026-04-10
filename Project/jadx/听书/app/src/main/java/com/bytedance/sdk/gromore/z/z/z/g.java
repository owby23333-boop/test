package com.bytedance.sdk.gromore.z.z.z;

import android.app.Activity;
import com.bytedance.msdk.api.a.e;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.dl {
    private com.bytedance.msdk.api.a.g z;

    public g(Activity activity, Map<String, Object> map, com.bytedance.msdk.api.a.z.z.dl dlVar) {
        if (dlVar == null || activity == null) {
            return;
        }
        if (map != null) {
            this.z = dlVar.z(activity, map);
        } else {
            this.z = dlVar.z(activity);
        }
    }

    public g(com.bytedance.msdk.api.a.g gVar) {
        this.z = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.dl
    public void z() {
        com.bytedance.msdk.api.a.g gVar = this.z;
        if (gVar != null) {
            gVar.z();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.dl
    public void z(final com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.z zVar) {
        com.bytedance.msdk.api.a.g gVar = this.z;
        if (gVar != null) {
            gVar.z(new e() { // from class: com.bytedance.sdk.gromore.z.z.z.g.1
                @Override // com.bytedance.msdk.api.a.e
                public void z(int i, String str) {
                    com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.z(i, str);
                    }
                }

                @Override // com.bytedance.msdk.api.a.e
                public void z() {
                    com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.z();
                    }
                }

                @Override // com.bytedance.msdk.api.a.e
                public void g() {
                    com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.g();
                    }
                }
            });
        }
    }
}
