package com.bytedance.sdk.openadsdk.core.ugeno.e;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.dl.v;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.mc;
import com.bytedance.sdk.openadsdk.core.nativeexpress.uy;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.ugeno.component.g.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements fv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f1347a;
    private com.bytedance.adsdk.ugeno.g.dl<View> dl;
    private com.bytedance.adsdk.ugeno.g.dl e;
    private gz fo;
    private com.bytedance.sdk.openadsdk.core.i.m g;
    private dl gc;
    private g gz;
    private int i;
    private mc kb;
    private na m;
    private uy uy;
    private String wp;
    private Context z;

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
    }

    public m(Context context, com.bytedance.sdk.openadsdk.core.i.m mVar, na naVar, String str, int i) {
        this.z = context;
        this.g = mVar;
        this.m = naVar;
        this.wp = str;
        this.i = i;
    }

    public void z(a aVar) {
        this.f1347a = aVar;
    }

    public void z(gz gzVar) {
        this.fo = gzVar;
    }

    public void z(dl dlVar) {
        this.gc = dlVar;
    }

    public void z(final JSONObject jSONObject, final List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> list, final e eVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            g(jSONObject, list, eVar);
        } else {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.g(jSONObject, (List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl>) list, eVar);
                }
            });
        }
    }

    public void z(uy uyVar) {
        this.uy = uyVar;
    }

    public void z(g gVar) {
        this.gz = gVar;
    }

    public com.bytedance.adsdk.ugeno.g.dl z() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject, List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> list, e eVar) {
        pf pfVar = new pf(this.z);
        v vVar = new v();
        vVar.z(this.z);
        HashMap map = new HashMap();
        map.put("key_material", this.m);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() && i <= 2; i++) {
            arrayList.add(list.get(i).z());
        }
        mc mcVar = new mc(this.z);
        this.kb = mcVar;
        mcVar.z(this.uy);
        this.kb.z(this.gz);
        this.kb.z(this.wp);
        this.kb.dl(this.i);
        map.put("key_data_list", arrayList);
        map.put("key_js_object", this.kb);
        vVar.z(map);
        pfVar.z("aggPage", vVar);
        com.bytedance.adsdk.ugeno.g.dl<View> dlVarZ = pfVar.z(jSONObject);
        this.dl = dlVarZ;
        if (dlVarZ == null || list == null || list.size() <= 0) {
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
        com.bytedance.adsdk.ugeno.g.dl<T> dlVarA = this.dl.a("recycler_layout");
        this.e = dlVarA;
        if (dlVarA instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.g.m) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.g.m) dlVarA).z(list);
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.g.m) this.e).z(new m.g() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.m.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.m.g
                public void z() {
                    if (m.this.f1347a != null) {
                        m.this.f1347a.a(m.this.e);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.m.g
                public void z(int i2, int i3) {
                    if (m.this.f1347a != null) {
                        m.this.f1347a.z(i2, i3);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.m.g
                public void z(RecyclerView recyclerView, int i2) {
                    if (m.this.f1347a != null) {
                        m.this.f1347a.z(recyclerView, i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.m.g
                public void z(int i2, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl dlVar) {
                    if (m.this.f1347a != null) {
                        m.this.f1347a.z(m.this.e, i2, view, dlVar);
                    }
                }
            });
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.g.m) this.e).z(new com.bytedance.sdk.openadsdk.core.ugeno.component.g.a() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.m.3
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.a
                public void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
                    if (m.this.f1347a != null) {
                        m.this.f1347a.gc(dlVar);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.a
                public void g(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
                    if (m.this.f1347a != null) {
                        m.this.f1347a.m(dlVar);
                    }
                }
            });
        }
        pfVar.z(new com.bytedance.adsdk.ugeno.dl.uy() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.m.4
            @Override // com.bytedance.adsdk.ugeno.dl.uy
            public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
                if (m.this.gc != null) {
                    m.this.gc.dl(dlVar);
                }
            }
        });
        pfVar.z(this);
        JSONObject jSONObjectKv = this.m.kv();
        if (list != null && list.size() > 0) {
            try {
                jSONObjectKv.put("ugen_sub_meta", list.get(0).z());
            } catch (JSONException e) {
                wp.z(e);
            }
        }
        pfVar.g(jSONObjectKv);
        this.g.z(0L);
        if (eVar != null) {
            eVar.z(this.dl);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(ls lsVar, fv.g gVar, fv.z zVar) {
        gz gzVar;
        if (lsVar == null) {
            return;
        }
        if (lsVar.g() == 1) {
            g(lsVar, (fv.g) null, (fv.z) null);
            return;
        }
        if (lsVar.g() != 10 || (gzVar = this.fo) == null) {
            return;
        }
        gzVar.g(lsVar.z());
        mc mcVar = this.kb;
        if (mcVar != null) {
            mcVar.z("webviewVisible", (JSONObject) null);
        }
    }

    private void g(ls lsVar, fv.g gVar, fv.z zVar) {
        if (lsVar == null || lsVar.z() == null) {
            return;
        }
        JSONObject jSONObjectDl = lsVar.dl();
        String strOptString = jSONObjectDl.optString("type");
        String strOptString2 = jSONObjectDl.optString("nodeId");
        strOptString.hashCode();
        if (strOptString.equals("onDismiss")) {
            com.bytedance.adsdk.ugeno.g.dl<T> dlVarA = this.dl.a(strOptString2);
            if (dlVarA != 0) {
                dlVarA.g(8);
            }
        } else if (strOptString.equals("onShow")) {
            com.bytedance.adsdk.ugeno.g.dl<T> dlVarA2 = this.dl.a(strOptString2);
            if (dlVarA2 != 0) {
                dlVarA2.g(0);
            }
        } else {
            dl dlVar = this.gc;
            if (dlVar != null) {
                dlVar.dl(lsVar.z());
            }
        }
        final String strOptString3 = jSONObjectDl.optString("reportType");
        if (!TextUtils.isEmpty(strOptString3)) {
            com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.m.5
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("type", strOptString3);
                    return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("agg_click").g(jSONObject.toString());
                }
            }, "agg_click");
        }
        if (gVar == null || lsVar.a() == null) {
            return;
        }
        gVar.z(lsVar.a());
    }
}
