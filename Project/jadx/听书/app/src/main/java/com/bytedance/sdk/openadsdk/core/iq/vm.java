package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class vm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1202a;
    private int dl;
    private nh e;
    private int g;
    private int gc;
    private JSONObject gz;
    private me m;
    private int z;

    public vm(JSONObject jSONObject, String str, j jVar) {
        this.z = 2;
        this.g = 0;
        this.dl = 1;
        this.f1202a = 0;
        this.gc = 100;
        if (jSONObject == null) {
            return;
        }
        this.z = jSONObject.optInt("render_control", jVar != null ? jVar.m : 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("render");
        if (jSONObjectOptJSONObject != null) {
            this.g = jSONObjectOptJSONObject.optInt("render_sequence", 0);
            this.dl = jSONObjectOptJSONObject.optInt("backup_render_control", 1);
            this.f1202a = jSONObjectOptJSONObject.optInt("render_thread", 0);
            this.gc = jSONObjectOptJSONObject.optInt("reserve_time", 100);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("tpl_info");
        if (jSONObjectOptJSONObject2 != null) {
            me meVar = new me();
            meVar.g(jSONObjectOptJSONObject2.optString("id"));
            meVar.dl(jSONObjectOptJSONObject2.optString(TKDownloadReason.KSAD_TK_MD5));
            meVar.a(jSONObjectOptJSONObject2.optString("url"));
            meVar.gc(jSONObjectOptJSONObject2.optString("data"));
            meVar.m(jSONObjectOptJSONObject2.optString("diff_data"));
            meVar.e(jSONObjectOptJSONObject2.optString("dynamic_creative"));
            meVar.z(jSONObjectOptJSONObject2.optString("version"));
            meVar.gz(jSONObjectOptJSONObject2.optString("material_type"));
            meVar.fo(jSONObjectOptJSONObject2.optString("ugen_url"));
            meVar.uy(jSONObjectOptJSONObject2.optString("ugen_md5"));
            meVar.wp(jSONObjectOptJSONObject2.optString("express_gesture_priority"));
            meVar.kb(jSONObjectOptJSONObject2.optString("engine_version"));
            this.m = meVar;
            com.bytedance.sdk.component.adexpress.z.dl.a aVarZ = z(str);
            if (aVarZ != null) {
                com.bytedance.sdk.component.adexpress.z.g.g.z(aVarZ);
            }
            com.bytedance.sdk.openadsdk.core.ugeno.uy.z(meVar.fo(), meVar.uy(), (com.bytedance.sdk.openadsdk.core.ugeno.dl) null);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("tpl_info_v3");
        if (jSONObjectOptJSONObject3 != null) {
            nh nhVarZ = nh.z(jSONObjectOptJSONObject3);
            this.e = nhVarZ;
            com.bytedance.sdk.openadsdk.core.nativeexpress.z.g.z().z(nhVarZ, str, an.aw);
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("dynamic_creative");
        if (jSONObjectOptJSONObject4 != null) {
            this.gz = jSONObjectOptJSONObject4;
        }
    }

    public static void z(na naVar, int i) {
        vm vmVarI = i(naVar);
        if (vmVarI == null) {
            return;
        }
        vmVarI.z = i;
    }

    public void z(JSONObject jSONObject) {
        try {
            jSONObject.put("render_control", this.z);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("render_sequence", this.g);
            jSONObject2.put("backup_render_control", this.dl);
            jSONObject2.put("render_thread", this.f1202a);
            jSONObject2.put("reserve_time", this.gc);
            jSONObject.put("render", jSONObject2);
            if (this.m != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("id", this.m.g());
                jSONObject3.put(TKDownloadReason.KSAD_TK_MD5, this.m.dl());
                jSONObject3.put("url", this.m.a());
                jSONObject3.put("data", this.m.gc());
                jSONObject3.put("diff_data", this.m.m());
                jSONObject3.put("version", this.m.z());
                jSONObject3.put("dynamic_creative", this.m.e());
                jSONObject3.put("material_type", this.m.gz());
                jSONObject3.put("ugen_url", this.m.fo());
                jSONObject3.put("ugen_md5", this.m.uy());
                jSONObject3.put("engine_version", this.m.kb());
                jSONObject3.put("express_gesture_priority", this.m.wp());
                jSONObject.put("tpl_info", jSONObject3);
            }
            jSONObject.put("dynamic_creative", this.gz);
            nh nhVar = this.e;
            if (nhVar != null) {
                jSONObject.put("tpl_info_v3", nhVar.fo());
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    private com.bytedance.sdk.component.adexpress.z.dl.a z(String str) {
        me meVar = this.m;
        if (meVar == null) {
            return null;
        }
        String strG = meVar.g();
        String strA = this.m.a();
        String strDl = this.m.dl();
        String strGc = this.m.gc();
        return com.bytedance.sdk.component.adexpress.z.dl.a.z().z(strG).g(strDl).dl(strA).a(strGc).gc(this.m.z()).m(String.valueOf(str));
    }

    private static vm i(na naVar) {
        if (naVar == null) {
            return null;
        }
        return naVar.ec();
    }

    public static int z(na naVar) {
        vm vmVarI = i(naVar);
        if (vmVarI == null) {
            return 2;
        }
        return vmVarI.z;
    }

    public static int g(na naVar) {
        vm vmVarI = i(naVar);
        if (vmVarI == null) {
            return 0;
        }
        return vmVarI.g;
    }

    public static int dl(na naVar) {
        vm vmVarI = i(naVar);
        if (vmVarI == null) {
            return 1;
        }
        return vmVarI.dl;
    }

    public static int a(na naVar) {
        vm vmVarI = i(naVar);
        if (vmVarI == null) {
            return 0;
        }
        return vmVarI.f1202a;
    }

    public static int gc(na naVar) {
        vm vmVarI = i(naVar);
        if (vmVarI == null) {
            return 100;
        }
        return vmVarI.gc;
    }

    public static me m(na naVar) {
        vm vmVarI = i(naVar);
        if (vmVarI == null) {
            return null;
        }
        return vmVarI.m;
    }

    public static nh e(na naVar) {
        vm vmVarI = i(naVar);
        if (vmVarI == null) {
            return null;
        }
        return vmVarI.e;
    }

    public static boolean gz(na naVar) {
        vm vmVarI = i(naVar);
        if (vmVarI == null) {
            return false;
        }
        me meVar = vmVarI.m;
        if (meVar != null) {
            return !TextUtils.isEmpty(meVar.kb());
        }
        int i = vmVarI.g;
        return i == 9 || i == 10;
    }

    public static com.bytedance.sdk.component.adexpress.z.dl.a fo(na naVar) {
        vm vmVarI = i(naVar);
        if (vmVarI == null) {
            return null;
        }
        return vmVarI.z(String.valueOf(com.bytedance.sdk.openadsdk.core.un.eo.fo(naVar)));
    }

    public static boolean uy(na naVar) {
        return naVar != null && g(naVar) == 7;
    }

    public static boolean kb(na naVar) {
        return naVar != null && g(naVar) == 3;
    }

    public static boolean wp(na naVar) {
        return naVar != null && g(naVar) == 10;
    }
}
