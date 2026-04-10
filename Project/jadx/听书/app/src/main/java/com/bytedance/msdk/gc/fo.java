package com.bytedance.msdk.gc;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.msdk.gz.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo implements com.bytedance.sdk.component.gz.z.kb {
    public com.bytedance.msdk.gc.g.z<z> z;
    private static final Handler g = new Handler(com.bytedance.msdk.z.gc.m.g());
    private static final Runnable dl = new Runnable() { // from class: com.bytedance.msdk.gc.fo.2
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.z.gc.dl.z("TMe", "--==--- upload event routine");
            com.bytedance.sdk.component.gz.g.z.a("csj_mediation");
            fo.g();
        }
    };

    @Override // com.bytedance.sdk.component.gz.z.kb
    public void z(final List<com.bytedance.sdk.component.gz.z.g> list, final com.bytedance.sdk.component.gz.z.uy uyVar) {
        if (list != null && list.size() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            final ArrayList arrayList = new ArrayList();
            int i = 0;
            JSONObject jSONObject = null;
            for (com.bytedance.sdk.component.gz.z.g gVar : list) {
                JSONObject jSONObjectE = gVar.e();
                byte bGc = gVar.gc();
                byte bA = gVar.a();
                if (bGc == 2 && bA == 3) {
                    g(jSONObjectE, list.size(), jCurrentTimeMillis, i, jSONObject);
                    arrayList.add(new e(gVar.dl(), jSONObjectE));
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("not_v3", jSONObjectE);
                        jSONObject2.putOpt("batchId", Long.valueOf(jCurrentTimeMillis));
                        jSONObject2.putOpt("batchIndex", Integer.valueOf(i));
                        l.z(jSONObject2);
                    } catch (Throwable unused) {
                    }
                }
                i++;
                jSONObject = jSONObjectE;
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.z.gc.m.e().execute(new Runnable() { // from class: com.bytedance.msdk.gc.fo.1
                    @Override // java.lang.Runnable
                    public void run() {
                        gc gcVarZ = fo.this.z(arrayList);
                        if (uyVar == null || gcVarZ == null) {
                            return;
                        }
                        com.bytedance.sdk.component.gz.g.g.dl.g gVar2 = new com.bytedance.sdk.component.gz.g.g.dl.g(gcVarZ.z, gcVarZ.g, gcVarZ.dl, gcVarZ.f470a, "");
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new com.bytedance.sdk.component.gz.g.g.dl.z(gVar2, list));
                        uyVar.z(arrayList2);
                        if (gcVarZ.z) {
                            fo.g();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g() {
        Handler handler = g;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(dl, com.bytedance.msdk.core.g.g().hh());
    }

    private void z(JSONObject jSONObject, int i, long j, int i2, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString("event_extra");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(strOptString);
                jSONObject3.putOpt("size", Integer.valueOf(i));
                jSONObject3.putOpt("batchId", Long.valueOf(j));
                jSONObject3.putOpt("batchIndex", Integer.valueOf(i2));
                jSONObject3.putOpt("preEventId", jSONObject2 != null ? jSONObject2.optString("event_id") : "-1");
                jSONObject.put("event_extra", jSONObject3.toString());
            } catch (Throwable unused) {
            }
        }
    }

    private void g(JSONObject jSONObject, int i, long j, int i2, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("params");
                if (jSONObjectOptJSONObject != null) {
                    z(jSONObjectOptJSONObject, i, j, i2, jSONObject2 != null ? jSONObject2.optJSONObject("params") : null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public gc z(List<z> list) {
        try {
            if (this.z == null) {
                this.z = com.bytedance.msdk.core.g.z();
            }
        } catch (Exception unused) {
        }
        com.bytedance.msdk.gc.g.z<z> zVar = this.z;
        if (zVar == null) {
            return null;
        }
        return zVar.z(list);
    }
}
