package com.bytedance.sdk.openadsdk.core.ugeno.dl;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.dl.tb;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.sdk.openadsdk.core.i.m;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.ugeno.e.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements fv, tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f1344a;
    private com.bytedance.adsdk.ugeno.g.dl<View> dl;
    private int e;
    private m g;
    private tb gc;
    private String m;
    private Context z;

    interface z {
        void z(ls lsVar);
    }

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
    }

    public g(Context context, com.bytedance.sdk.openadsdk.core.i.m mVar, String str, int i) {
        this.z = context;
        this.g = mVar;
        this.m = str;
        this.e = i;
    }

    public void z(z zVar) {
        this.f1344a = zVar;
    }

    public void z(tb tbVar) {
        this.gc = tbVar;
    }

    public void z(final JSONObject jSONObject, final JSONObject jSONObject2, final e eVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g(jSONObject, jSONObject2, eVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.dl.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.g(jSONObject, jSONObject2, eVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject, JSONObject jSONObject2, e eVar) {
        pf pfVar = new pf(this.z);
        com.bytedance.adsdk.ugeno.g.dl<View> dlVarZ = pfVar.z(jSONObject);
        this.dl = dlVarZ;
        if (dlVarZ == null) {
            com.bytedance.sdk.openadsdk.core.i.m mVar = this.g;
            if (mVar != null) {
                mVar.z(-1, "ugeno render fail");
            }
            if (eVar != null) {
                eVar.z(-1, "");
                return;
            }
            return;
        }
        pfVar.z((tb) this);
        pfVar.z((fv) this);
        pfVar.g(jSONObject2);
        this.g.z(0L);
        if (eVar != null) {
            eVar.z(this.dl);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(ls lsVar, fv.g gVar, fv.z zVar) {
        z zVar2;
        if (lsVar == null || lsVar.g() != 1 || (zVar2 = this.f1344a) == null) {
            return;
        }
        zVar2.z(lsVar);
    }

    @Override // com.bytedance.adsdk.ugeno.dl.tb
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, MotionEvent motionEvent) {
        tb tbVar = this.gc;
        if (tbVar != null) {
            tbVar.z(dlVar, motionEvent);
        }
    }
}
