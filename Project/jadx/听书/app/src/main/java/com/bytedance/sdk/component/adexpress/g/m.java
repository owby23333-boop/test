package com.bytedance.sdk.component.adexpress.g;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.g.uy;

/* JADX INFO: loaded from: classes2.dex */
public class m implements uy {
    private i dl;
    private z g;
    private Context z;

    @Override // com.bytedance.sdk.component.adexpress.g.uy
    public void z() {
    }

    public m(Context context, i iVar, z zVar) {
        this.z = context;
        this.g = zVar;
        this.dl = iVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy
    public boolean z(final uy.z zVar) {
        this.dl.e().fo();
        this.g.z(new e() { // from class: com.bytedance.sdk.component.adexpress.g.m.1
            @Override // com.bytedance.sdk.component.adexpress.g.e
            public void z(View view, v vVar) {
                if (zVar.dl()) {
                    return;
                }
                pf pfVarG = zVar.g();
                if (pfVarG != null) {
                    pfVarG.z(m.this.g, vVar);
                }
                zVar.z(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.g.e
            public void z(int i, String str) {
                pf pfVarG = zVar.g();
                if (pfVarG != null) {
                    pfVarG.a_(i);
                }
            }
        });
        return true;
    }

    public void z(dl dlVar) {
        this.g.z(dlVar);
    }
}
