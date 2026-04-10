package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.dl.v;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements fv, l.z, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private mc f1368a;
    private e.z dl;
    private com.bytedance.sdk.openadsdk.core.ugeno.e.e e;
    private Context g;
    private na gc;
    private AtomicBoolean gz = new AtomicBoolean(false);
    private final l m = new l(Looper.getMainLooper(), this);
    private com.bytedance.adsdk.ugeno.g.dl<View> z;

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
    }

    public z(Context context, na naVar) {
        this.g = context;
        this.gc = naVar;
    }

    public void z(e.z zVar) {
        this.dl = zVar;
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
                this.dl.z();
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

    public void z(final JSONObject jSONObject, final JSONObject jSONObject2, final com.bytedance.sdk.openadsdk.core.ugeno.e.e eVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g(jSONObject, jSONObject2, eVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.g(jSONObject, jSONObject2, eVar);
                }
            });
        }
    }

    private JSONObject z(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("easy_dl_dialog")) == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, jSONObjectOptJSONObject.opt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
            jSONObject2.put("app_version", jSONObjectOptJSONObject.opt("app_version"));
            jSONObject2.put("developer_name", jSONObjectOptJSONObject.opt("developer_name"));
            jSONObject2.put(an.o, jSONObjectOptJSONObject.opt(an.o));
            jSONObject2.put("score", jSONObjectOptJSONObject.opt("score"));
            jSONObject2.put("icon_url", jSONObjectOptJSONObject.opt("icon_url"));
            jSONObject2.put("description", jSONObjectOptJSONObject.opt("description"));
            jSONObject2.put("creative_tags", jSONObjectOptJSONObject.opt("creative_tags"));
            jSONObject2.put("easy_pl_material", jSONObjectOptJSONObject.opt("easy_pl_material"));
            jSONObject3.put("ugen_download_dialog", jSONObject2);
            return jSONObject3;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.e.e eVar) {
        this.e = eVar;
        pf pfVar = new pf(this.g);
        v vVar = new v();
        vVar.z(this.g);
        HashMap map = new HashMap();
        mc mcVar = new mc(this.g);
        this.f1368a = mcVar;
        mcVar.z(this.dl);
        this.f1368a.z(this);
        this.f1368a.g(z(jSONObject2));
        String strG = eo.g(this.gc);
        this.f1368a.dl(eo.g(strG));
        this.f1368a.z(strG);
        map.put("key_js_object", this.f1368a);
        map.put("key_material", this.gc);
        vVar.g(jSONObject2);
        vVar.z(map);
        pfVar.z("easy_dl_dialog", vVar);
        com.bytedance.adsdk.ugeno.g.dl<View> dlVarZ = pfVar.z(jSONObject);
        this.z = dlVarZ;
        if (dlVarZ == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.e.e eVar2 = this.e;
            if (eVar2 != null) {
                eVar2.z(-1, "UGenWidget is null");
                return;
            }
            return;
        }
        pfVar.z(this);
        pfVar.g(jSONObject2);
        l lVar = this.m;
        if (lVar != null) {
            lVar.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private void g() {
        l lVar = this.m;
        if (lVar == null) {
            return;
        }
        lVar.removeMessages(1);
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message == null || message.what != 1 || this.gz.get()) {
            return;
        }
        if (this.e != null) {
            this.gz.set(true);
            this.e.z(10, "load time out");
        }
        g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.g
    public void z() {
        g();
        if (this.gz.get() || this.e == null) {
            return;
        }
        this.gz.set(true);
        this.e.z(this.z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.g
    public void z(int i, String str) {
        g();
        if (this.gz.get() || this.e == null) {
            return;
        }
        this.gz.set(true);
        this.e.z(i, str);
    }
}
