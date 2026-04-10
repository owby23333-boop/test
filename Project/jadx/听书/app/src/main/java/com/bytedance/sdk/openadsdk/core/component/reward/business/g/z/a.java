package com.bytedance.sdk.openadsdk.core.component.reward.business.g.z;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.uy;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.gp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class a extends z {
    z g;

    public a(Activity activity, na naVar) {
        super(activity, naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.g.z.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z z(uy uyVar) {
        ArrayList<bm> arrayListGc = gp.gc(this.e);
        if (arrayListGc == null) {
            return new g.z(false, 0, "");
        }
        for (bm bmVar : arrayListGc) {
            if (bmVar.dl() == 1) {
                this.g = new dl(this.gz, this.e, bmVar);
            }
            z zVar = this.g;
            if (zVar != null) {
                zVar.dl(this.wp);
                this.g.a(this.kb);
                this.g.z(this.z);
                this.g.g(fo());
                this.g.z(this.ls);
                g.z zVarZ = this.g.z(uyVar);
                if (zVarZ.dl()) {
                    return zVarZ;
                }
            }
        }
        return new g.z(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        z zVar = this.g;
        if (zVar == null) {
            return null;
        }
        return zVar.z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public void g(String str) {
        super.g(str);
        z zVar = this.g;
        if (zVar == null) {
            return;
        }
        zVar.g(str);
    }
}
