package com.ss.android.socialbase.appdownloader.z;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static z z(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null || context == null || jSONObject == null) {
            return null;
        }
        String strKb = dlVar.kb();
        if (TextUtils.isEmpty(strKb) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(strKb);
        com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(dlVar);
        if (str.equals("v1")) {
            return new uy(context, zVarZ, dlVar.v());
        }
        if (str.equals("v2")) {
            return new kb(context, zVarZ, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new wp(context, zVarZ, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new e(context, zVarZ, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new gz(context, zVarZ, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String strV = dlVar.v("file_content_uri");
            if (TextUtils.isEmpty(strV)) {
                return null;
            }
            return new fo(context, zVarZ, file.getAbsolutePath(), strV, dlVar.gz());
        }
        if (str.equals(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
            return new dl(context, zVarZ, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new i(context, zVarZ, com.ss.android.socialbase.appdownloader.dl.z(dlVar.e(), com.ss.android.socialbase.downloader.downloader.e.g(context).wp(dlVar.e()), context, com.ss.android.socialbase.appdownloader.a.kb().gc(), new File(dlVar.kb() + File.separator + dlVar.gz())).toString());
    }

    public static boolean z(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.i.z zVar) {
        z iVar;
        if (context != null && str != null) {
            String strG = com.ss.android.socialbase.appdownloader.dl.g();
            if (!TextUtils.isEmpty(strG) && !TextUtils.isEmpty(str)) {
                if (com.ss.android.socialbase.appdownloader.m.gc.a() && str.equals("v1")) {
                    iVar = new uy(context, zVar, strG);
                } else if (com.ss.android.socialbase.appdownloader.m.gc.a() && str.equals("v2")) {
                    iVar = new kb(context, zVar, strG);
                } else if (com.ss.android.socialbase.appdownloader.m.gc.a() && str.equals("v3")) {
                    iVar = new wp(context, zVar, strG);
                } else if (com.ss.android.socialbase.appdownloader.m.gc.gc() && str.equals("o1")) {
                    iVar = new e(context, zVar, strG);
                } else if (com.ss.android.socialbase.appdownloader.m.gc.gc() && str.equals("o2")) {
                    iVar = new gz(context, zVar, strG);
                } else if (com.ss.android.socialbase.appdownloader.m.gc.gc() && str.equals("o3")) {
                    iVar = new fo(context, zVar, strG, strG, strG);
                } else if (com.ss.android.socialbase.appdownloader.m.gc.a() && str.equals(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
                    iVar = new dl(context, zVar, strG, jSONObject);
                } else {
                    iVar = (com.ss.android.socialbase.appdownloader.m.gc.a() && str.equals("vbi")) ? new i(context, zVar, strG) : null;
                }
                if (iVar != null && iVar.z()) {
                    return true;
                }
            }
        }
        return false;
    }
}
