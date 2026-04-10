package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.dl.v;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.widget.dl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements fv {
    private dl.z dl;
    private com.bytedance.adsdk.ugeno.g.dl<View> g;
    private Context z;

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
    }

    public gz(Context context) {
        this.z = context;
    }

    public void z(dl.z zVar) {
        this.dl = zVar;
    }

    public void z(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.e.e eVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g(jSONObject, jSONObject2, eVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gz.1
                @Override // java.lang.Runnable
                public void run() {
                    gz.this.g(jSONObject, jSONObject2, eVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.e.e eVar) {
        pf pfVar = new pf(this.z);
        v vVar = new v();
        vVar.z(this.z);
        pfVar.z("ugen_download_dialog", vVar);
        com.bytedance.adsdk.ugeno.g.dl<View> dlVarZ = pfVar.z(jSONObject);
        this.g = dlVarZ;
        if (dlVarZ != null) {
            pfVar.z(this);
            pfVar.g(jSONObject2);
        }
        if (eVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar = this.g;
        if (dlVar == null) {
            eVar.z(-1, "UGenWidget is null");
        } else {
            eVar.z(dlVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(ls lsVar, fv.g gVar, fv.z zVar) {
        JSONObject jSONObjectDl;
        if (lsVar == null || this.dl == null) {
            return;
        }
        if (lsVar.g() != 1 || (jSONObjectDl = lsVar.dl()) == null) {
        }
        String strOptString = jSONObjectDl.optString("type");
        strOptString.hashCode();
        switch (strOptString) {
            case "openAppPermission":
                this.dl.g(null);
                break;
            case "openAppFunctionDesc":
                this.dl.gc(null);
                break;
            case "closeDialog":
                this.dl.dl(null);
                break;
            case "downloadEvent":
                this.dl.z(null);
                break;
            case "openAppPolicy":
                this.dl.a(null);
                break;
        }
    }
}
