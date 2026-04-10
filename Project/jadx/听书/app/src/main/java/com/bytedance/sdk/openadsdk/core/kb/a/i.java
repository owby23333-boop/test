package com.bytedance.sdk.openadsdk.core.kb.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.a.fo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class i implements a {
    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public e g() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public boolean z(com.ss.android.z.z.dl.dl dlVar, com.ss.android.socialbase.downloader.e.dl dlVar2) {
        return true;
    }

    private i() {
    }

    public static a a() {
        return new i();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public void z(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.kb.dl.g.z zVarZ;
        na naVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.bytedance.sdk.openadsdk.core.kb.z.uy.EXTRA_DOWN_INFO_KEY);
        if (jSONObjectOptJSONObject == null || !oq.z() || (zVarZ = com.bytedance.sdk.openadsdk.core.kb.dl.g.z.z(jSONObjectOptJSONObject)) == null || (naVar = zVarZ.z) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.fo.z(str, naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public JSONObject z() {
        JSONObject jSONObjectG = com.bytedance.sdk.openadsdk.core.kb.fo.g();
        try {
            if (!zw.g().hh()) {
                jSONObjectG.put("enable_app_install_receiver", 0);
            }
            if (jSONObjectG.optInt("enable_target_34", -1) == -1) {
                jSONObjectG.put("enable_target_34", zw.g().qz());
            }
        } catch (Exception unused) {
        }
        return jSONObjectG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public String z(boolean z) {
        return com.bytedance.sdk.openadsdk.core.kb.fo.z(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public void z(Activity activity, String[] strArr, m mVar) {
        wp.z(activity, strArr, mVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public boolean z(Context context, String str) {
        return wp.z(context, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public void z(int i, String str, Map<String, Object> map, gc gcVar) {
        uy.z(i, str, map, gcVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public void z(String str, byte[] bArr, String str2, gc gcVar) {
        uy.z(str, bArr, str2, 0, gcVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public AlertDialog z(Activity activity, boolean z, z zVar) {
        return kb.z(activity, z, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public void z(WeakReference<Context> weakReference, boolean z, z zVar) {
        kb.z(weakReference, z, zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public boolean z(String str) {
        return fo.z(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.m.dl(new File(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public boolean dl() {
        return com.bytedance.sdk.openadsdk.core.uy.ls().z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public void z(gz gzVar, boolean z) {
        if (z(gzVar)) {
            try {
                com.bytedance.sdk.component.uy.e.z(fo.z.z(gzVar, z), 5);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public boolean g(com.ss.android.z.z.dl.dl dlVar, com.ss.android.socialbase.downloader.e.dl dlVar2) {
        int i;
        String str;
        String str2;
        String str3;
        JSONObject jSONObjectOptJSONObject;
        if (dlVar == null || dlVar2 == null) {
            return false;
        }
        String strUf = dlVar.uf();
        String strHh = dlVar.hh();
        String strGz = dlVar.gz();
        String strSy = dlVar.sy();
        String strV = dlVar2.v();
        long jA = dlVar.a();
        int iE = dlVar2.e();
        JSONObject jSONObjectE = com.ss.android.downloadlib.addownload.g.m.z().a(jA).e();
        String strOptString = null;
        if (jSONObjectE == null || (jSONObjectOptJSONObject = jSONObjectE.optJSONObject(com.bytedance.sdk.openadsdk.core.kb.z.uy.EXTRA_DOWN_INFO_KEY)) == null) {
            i = 0;
            str = strUf;
            str2 = null;
            str3 = null;
        } else {
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("material_meta");
            if (jSONObjectOptJSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("download_conf");
                iOptInt = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt("enable_notification", 0) : 0;
                strOptString = jSONObjectOptJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(strUf)) {
                strUf = jSONObjectOptJSONObject2.optString("ext");
            }
            i = iOptInt;
            str = strUf;
            str3 = strOptString;
            str2 = strOptString2;
        }
        return new com.bytedance.sdk.openadsdk.core.kb.m().z(strGz, strHh, strSy, iE, str, strV, i, str2, str3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a.a
    public boolean z(com.ss.android.z.z.dl.dl dlVar) {
        String str;
        String str2;
        JSONObject jSONObjectOptJSONObject;
        if (dlVar == null) {
            return true;
        }
        String strUf = dlVar.uf();
        String strHh = dlVar.hh();
        String strGz = dlVar.gz();
        String strSy = dlVar.sy();
        JSONObject jSONObjectE = com.ss.android.downloadlib.addownload.g.m.z().a(dlVar.a()).e();
        String strOptString = null;
        if (jSONObjectE == null || (jSONObjectOptJSONObject = jSONObjectE.optJSONObject(com.bytedance.sdk.openadsdk.core.kb.z.uy.EXTRA_DOWN_INFO_KEY)) == null) {
            str = null;
            str2 = null;
        } else {
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("material_meta");
            if (jSONObjectOptJSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("download_conf");
                iOptInt = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt("enable_notification", 0) : 0;
                strOptString = jSONObjectOptJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(strUf)) {
                strUf = jSONObjectOptJSONObject2.optString("ext");
            }
            str2 = strOptString;
            str = strOptString2;
        }
        return new com.bytedance.sdk.openadsdk.core.kb.m().z(strGz, strHh, strSy, strUf, iOptInt, str, str2);
    }

    private boolean z(gz gzVar) {
        JSONObject jSONObjectA;
        if (gzVar == null || (jSONObjectA = gzVar.a()) == null) {
            return false;
        }
        String strOptString = jSONObjectA.optString("ad_extra_data");
        if (TextUtils.isEmpty(strOptString)) {
            return false;
        }
        try {
            return new JSONObject(strOptString).optJSONObject(com.bytedance.sdk.openadsdk.core.kb.z.uy.EXTRA_DOWN_INFO_KEY) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
