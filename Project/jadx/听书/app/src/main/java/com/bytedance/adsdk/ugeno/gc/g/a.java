package com.bytedance.adsdk.ugeno.gc.g;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.gc.m;

/* JADX INFO: loaded from: classes2.dex */
public class a extends z {
    @Override // com.bytedance.adsdk.ugeno.gc.g.z
    public void g() {
    }

    public a(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
        super(dlVar, str, zVar);
    }

    @Override // com.bytedance.adsdk.ugeno.gc.g.z
    public void z() {
        com.bytedance.adsdk.ugeno.g.dl dlVarG;
        com.bytedance.adsdk.ugeno.z.z zVarUy;
        if (this.m == null || this.m.size() <= 0) {
            return;
        }
        String str = this.m.get("name");
        if (TextUtils.isEmpty(str) || (dlVarG = this.dl.g(this.dl)) == null || (zVarUy = dlVarG.m(str).uy(str)) == null) {
            return;
        }
        zVarUy.g();
        zVarUy.z(new com.bytedance.adsdk.ugeno.z.g() { // from class: com.bytedance.adsdk.ugeno.gc.g.a.1
            @Override // com.bytedance.adsdk.ugeno.z.g
            public void z() {
            }

            @Override // com.bytedance.adsdk.ugeno.z.g
            public void g() {
                a.this.dl();
            }
        });
    }
}
