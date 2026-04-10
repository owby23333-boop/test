package com.bytedance.sdk.openadsdk.core.dl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.zw;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile g z;
    private volatile SharedPreferences g = com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), "sp_dynamic_tmpl_config", 0);
    private volatile SharedPreferences dl = com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), "sp_dynamic_tmpl_config_v3", 0);

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g();
                }
            }
        }
        return z;
    }

    public void z(String str, String str2) {
        delete(str, str2, false);
    }

    public void delete(String str, String str2, boolean z2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strG = g(str, null, z2);
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(strG);
            if (jSONArray.length() > 0) {
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        i = -1;
                        break;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && str2.equals(jSONObjectOptJSONObject.getString("id"))) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    jSONArray.remove(i);
                    z(str, jSONArray.toString(), z2);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void z(String str, com.bytedance.sdk.component.adexpress.z.dl.dl dlVar) {
        update(str, dlVar, false);
    }

    public void update(String str, com.bytedance.sdk.component.adexpress.z.dl.dl dlVar, boolean z2) {
        if (dlVar == null || dlVar.g() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strG = g(str, null, z2);
            JSONArray jSONArray = strG == null ? new JSONArray() : new JSONArray(strG);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", dlVar.g());
            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, dlVar.dl());
            jSONArray.put(jSONObject);
            z(str, jSONArray.toString(), z2);
        } catch (Exception unused) {
        }
    }

    public JSONArray z(final String str, int i) {
        try {
            final String strG = g(str, null, false);
            e.g(new fo("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.dl.g.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z2;
                    try {
                        Set<com.bytedance.sdk.component.adexpress.z.dl.g> setZ = com.bytedance.sdk.component.adexpress.z.g.g.z(str, false);
                        JSONArray jSONArray = new JSONArray();
                        if (setZ == null || setZ.size() <= 0) {
                            z2 = false;
                        } else {
                            for (com.bytedance.sdk.component.adexpress.z.dl.g gVar : setZ) {
                                if (gVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("id", gVar.g());
                                    jSONObject.put(TKDownloadReason.KSAD_TK_MD5, gVar.dl());
                                    jSONArray.put(jSONObject);
                                }
                            }
                            z2 = true;
                        }
                        if (!(strG == null && z2) && jSONArray.toString().equals(strG)) {
                            return;
                        }
                        g.this.z(str, jSONArray.toString(), false);
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(strG)) {
                return null;
            }
            return new JSONArray(strG);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray g(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!dl.z().z(i)) {
            return z(str);
        }
        try {
            final String strG = g(str, null, true);
            e.g(new fo("tmpl_updatetime") { // from class: com.bytedance.sdk.openadsdk.core.dl.g.2
                @Override // java.lang.Runnable
                public void run() {
                    boolean z2;
                    try {
                        Set<com.bytedance.sdk.openadsdk.core.nativeexpress.z.z> setZ = com.bytedance.sdk.openadsdk.core.nativeexpress.z.g.z().z(str);
                        JSONArray jSONArray = new JSONArray();
                        if (setZ == null || setZ.size() <= 0) {
                            z2 = false;
                        } else {
                            for (com.bytedance.sdk.openadsdk.core.nativeexpress.z.z zVar : setZ) {
                                if (zVar != null) {
                                    JSONObject jSONObject = new JSONObject();
                                    String[] strArrSplit = zVar.z().split("_");
                                    if (strArrSplit.length == 2) {
                                        jSONObject.put("id", strArrSplit[1]);
                                        jSONObject.put(TKDownloadReason.KSAD_TK_MD5, zVar.g());
                                        jSONArray.put(jSONObject);
                                    }
                                }
                            }
                            z2 = true;
                        }
                        if (!(strG == null && z2) && jSONArray.toString().equals(strG)) {
                            return;
                        }
                        g.this.z(str, jSONArray.toString(), true);
                    } catch (Exception unused) {
                    }
                }
            });
            if (TextUtils.isEmpty(strG)) {
                return null;
            }
            return new JSONArray(strG);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONArray z(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.nativeexpress.z.z> setZ = com.bytedance.sdk.openadsdk.core.nativeexpress.z.g.z().z(str);
            if (setZ != null && setZ.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.nativeexpress.z.z zVar : setZ) {
                    if (zVar != null) {
                        JSONObject jSONObject = new JSONObject();
                        String[] strArrSplit = zVar.z().split("_");
                        if (strArrSplit.length == 2) {
                            jSONObject.put("id", strArrSplit[1]);
                            jSONObject.put(TKDownloadReason.KSAD_TK_MD5, zVar.g());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            wp.dl("BidOptTmplManager", "getUgenParentTplIds: ", e);
            return null;
        }
    }

    public void z(String str, String str2, boolean z2) {
        SharedPreferences sharedPreferences;
        String str3;
        try {
            if (z2) {
                sharedPreferences = this.dl;
                str3 = "sp_dynamic_tmpl_config_v3";
            } else {
                sharedPreferences = this.g;
                str3 = "sp_dynamic_tmpl_config";
            }
            if (dl.z().g()) {
                com.bytedance.sdk.component.e.dl.z.g.z(str3, str, str2);
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public String g(String str, String str2, boolean z2) {
        SharedPreferences sharedPreferences;
        String str3;
        try {
            if (z2) {
                sharedPreferences = this.dl;
                str3 = "sp_dynamic_tmpl_config_v3";
            } else {
                sharedPreferences = this.g;
                str3 = "sp_dynamic_tmpl_config";
            }
            if (dl.z().g()) {
                return com.bytedance.sdk.component.e.dl.z.g.g(str3, str, str2);
            }
            return sharedPreferences.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
