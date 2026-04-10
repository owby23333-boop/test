package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.z.z.g.p;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class fo {
    public static boolean g(int i) {
        return i == 2 || i == 1;
    }

    public static boolean z(int i) {
        return i == 0 || i == 1;
    }

    public static boolean z(com.ss.android.z.z.dl.dl dlVar) {
        return dlVar.io() && (dlVar instanceof com.ss.android.g.z.z.dl) && dlVar.x() == 1;
    }

    public static boolean g(com.ss.android.z.z.dl.dl dlVar) {
        return dlVar != null && dlVar.x() == 2;
    }

    public static boolean z(com.ss.android.z.z.dl.dl dlVar, p pVar) {
        return dlVar.io() && pVar != null;
    }

    public static int z(com.ss.android.downloadlib.addownload.g.gc gcVar, boolean z, com.ss.android.socialbase.appdownloader.m mVar) {
        int iZ;
        if (mVar == null || TextUtils.isEmpty(mVar.z()) || mVar.getContext() == null) {
            return 0;
        }
        try {
            iZ = z(mVar, mVar.z());
        } catch (Throwable th) {
            wp.tb().z(th, "redirectSavePathIfPossible");
            iZ = 4;
        }
        mVar.z(iZ);
        if (iZ == 0) {
            mVar.z(new com.ss.android.downloadlib.dl.z());
        }
        if (!mVar.qd()) {
            mVar.z(new com.ss.android.downloadlib.dl.g());
        }
        int iZ2 = com.ss.android.socialbase.appdownloader.a.kb().z(mVar);
        com.ss.android.g.z.g.g gVarZ = z(gcVar, iZ2);
        com.ss.android.downloadlib.addownload.g.m.z().z(gVarZ);
        gVarZ.e(iZ2);
        gVarZ.gz(System.currentTimeMillis());
        gVarZ.fo(0L);
        com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(mVar.rv());
        if (!z(mVar, zVarZ, iZ2) && gcVar.g.kb()) {
            String strWj = gcVar.g.wj();
            if (TextUtils.isEmpty(strWj)) {
                strWj = zVarZ.dl("download_start_toast_text");
            }
            if (TextUtils.isEmpty(strWj)) {
                strWj = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            wp.dl().z(2, mVar.getContext(), gcVar.g, strWj, null, 0);
        }
        return iZ2;
    }

    private static com.ss.android.g.z.g.g z(com.ss.android.downloadlib.addownload.g.gc gcVar, int i) {
        com.ss.android.g.z.g.g gVar = new com.ss.android.g.z.g.g(gcVar.g, gcVar.dl, gcVar.f1987a, i);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.i.z.z(i).z("download_event_opt", 1) > 1) {
            try {
                String strSy = gcVar.g.sy();
                if (!TextUtils.isEmpty(strSy)) {
                    if (wp.getContext().getPackageManager().getPackageInfo(strSy, 0) == null) {
                        z = false;
                    }
                    gVar.gz(z);
                }
            } catch (Throwable unused) {
            }
        }
        return gVar;
    }

    private static boolean z(com.ss.android.socialbase.appdownloader.m mVar, com.ss.android.socialbase.downloader.i.z zVar, int i) {
        String strOptString;
        JSONArray jSONArrayGc = zVar.gc("ah_plans");
        if (jSONArrayGc != null && jSONArrayGc.length() != 0) {
            int length = jSONArrayGc.length();
            int i2 = 0;
            JSONObject jSONObject = null;
            while (true) {
                if (i2 < length) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayGc.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null && ((strOptString = jSONObjectOptJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.m.z.z(jSONObjectOptJSONObject))) {
                        strOptString.hashCode();
                        switch (strOptString) {
                            case "plan_a":
                            case "plan_b":
                            case "plan_e":
                            case "plan_f":
                                if (com.ss.android.socialbase.appdownloader.g.z(jSONObjectOptJSONObject, zVar).g != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "plan_c":
                                jSONObject = jSONObjectOptJSONObject;
                                continue;
                                break;
                            case "plan_g":
                                if (com.ss.android.socialbase.appdownloader.g.g(jSONObjectOptJSONObject, zVar).g != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                        }
                    }
                    i2++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return com.ss.android.socialbase.appdownloader.g.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), (Intent) null, jSONObject, i, new com.ss.android.socialbase.appdownloader.z());
                }
            }
        }
        return false;
    }

    public static String z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return null;
        }
        try {
            String strGk = dlVar.gk();
            if (!TextUtils.isEmpty(strGk)) {
                return new JSONObject(strGk).optString("notification_jump_url", null);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return null;
    }

    private static int z(com.ss.android.socialbase.appdownloader.m mVar, String str) {
        com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(mVar.rv());
        JSONObject jSONObjectA = zVarZ.a("download_dir");
        if (jSONObjectA == null || TextUtils.isEmpty(jSONObjectA.optString("dir_name"))) {
            return -1;
        }
        String strG = mVar.g();
        String strWj = mVar.wj();
        if (TextUtils.isEmpty(strWj)) {
            strWj = com.ss.android.socialbase.appdownloader.dl.z(str, strG, mVar.wp(), true);
        }
        if (strWj.length() > 255) {
            strWj = strWj.substring(strWj.length() - 255);
        }
        if (TextUtils.isEmpty(strG)) {
            strG = strWj;
        }
        String strDl = mVar.dl();
        if (TextUtils.isEmpty(strDl)) {
            strDl = com.ss.android.socialbase.appdownloader.dl.g();
        }
        String str2 = strDl + File.separator + com.ss.android.socialbase.appdownloader.dl.z(strG, zVarZ);
        com.ss.android.socialbase.downloader.e.dl dlVarZ = com.ss.android.socialbase.appdownloader.a.kb().z(mVar.getContext(), str);
        if (dlVarZ != null && dlVarZ.gl()) {
            mVar.dl(dlVarZ.kb());
            try {
                mVar.z(new JSONObject(dlVarZ.y()));
            } catch (Throwable unused) {
            }
            return 0;
        }
        if (dlVarZ != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.a.kb().z(strWj, mVar.wp()))) {
            return dlVarZ != null ? 8 : 9;
        }
        int iZ = com.ss.android.socialbase.appdownloader.g.z(zVarZ);
        if (iZ == 0) {
            mVar.dl(str2);
        }
        return iZ;
    }

    public static String dl(com.ss.android.z.z.dl.dl dlVar) {
        try {
            if (TextUtils.isEmpty(dlVar.uf())) {
                return null;
            }
            return new JSONObject(dlVar.uf()).optString("clickid");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    public static String a(com.ss.android.z.z.dl.dl dlVar) {
        try {
            if (TextUtils.isEmpty(dlVar.uf())) {
                return null;
            }
            return new JSONObject(dlVar.uf()).optString("intent_extra");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }
}
