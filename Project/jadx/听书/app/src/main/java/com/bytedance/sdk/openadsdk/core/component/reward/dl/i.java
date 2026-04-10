package com.bytedance.sdk.openadsdk.core.component.reward.dl;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.bm;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i extends z {
    z p;

    public i(Activity activity, na naVar) {
        super(activity, naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.z, com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public g.z g(uy uyVar) {
        ArrayList<bm> arrayListTb = gb.tb(this.e);
        if (arrayListTb == null) {
            return new g.z(false, 0, "");
        }
        for (bm bmVar : arrayListTb) {
            switch (bmVar.dl()) {
                case 1:
                    this.p = new wp(this.gz, this.e, bmVar);
                    break;
                case 2:
                    this.p = new kb(this.gz, this.e, bmVar);
                    break;
                case 3:
                    this.p = new m(this.gz, this.e, bmVar);
                    break;
                case 4:
                    this.p = new e(this.gz, this.e, bmVar);
                    break;
                case 5:
                    this.p = new fo(this.gz, this.e, bmVar);
                    break;
                case 6:
                    this.p = new a(this.gz, this.e, bmVar);
                    break;
            }
            z zVar = this.p;
            if (zVar != null) {
                zVar.z(this.dl);
                this.p.z(this.z);
                this.p.g(this.g);
                this.p.g(this.f944a);
                this.p.dl(this.wp);
                this.p.a(this.kb);
                this.p.dl(this.m);
                this.p.a(this.gc);
                this.p.z(this.ls);
                this.p.g(fo());
                g.z zVarG = this.p.g(uyVar);
                if (zVarG.dl()) {
                    return zVarG;
                }
            }
        }
        return new g.z(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public void g(String str) {
        super.g(str);
        z zVar = this.p;
        if (zVar == null) {
            return;
        }
        zVar.g(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.g
    public String z() {
        z zVar = this.p;
        if (zVar == null) {
            return null;
        }
        String strZ = zVar.z();
        try {
            JSONObject jSONObject = new JSONObject(strZ);
            jSONObject.put("is_need_click", this.gc);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return strZ;
        }
    }
}
