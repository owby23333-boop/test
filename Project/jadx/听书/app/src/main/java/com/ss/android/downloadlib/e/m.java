package com.ss.android.downloadlib.e;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.socialbase.appdownloader.e;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    public static void z(com.ss.android.socialbase.downloader.e.dl dlVar, JSONObject jSONObject) {
        try {
            dl(dlVar, jSONObject);
            com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
            if (gVarZ == null) {
                return;
            }
            jSONObject.put("is_update_download", gVarZ.gb() ? 1 : 2);
            z(gVarZ, jSONObject);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public static void g(com.ss.android.socialbase.downloader.e.dl dlVar, JSONObject jSONObject) {
        com.ss.android.g.z.g.g gVarZ;
        if (jSONObject == null || (gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar)) == null) {
            return;
        }
        try {
            dl(dlVar, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - gVarZ.ec()));
            jSONObject.putOpt("click_download_size", Long.valueOf(gVarZ.bv()));
            jSONObject.putOpt("download_length", Long.valueOf(dlVar.sf()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(dlVar.s()));
            gVarZ.hh();
            com.ss.android.downloadlib.addownload.g.fo.z().z(gVarZ);
            jSONObject.put("click_pause_times", gVarZ.sy());
            long jS = dlVar.s();
            long jSf = dlVar.sf();
            jSONObject.put("download_percent", (jSf < 0 || jS <= 0) ? 0.0d : jSf / jS);
            jSONObject.put("download_status", dlVar.zw());
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jUn = gVarZ.un();
            if (jUn > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - jUn);
            }
            long jL = gVarZ.l();
            if (jL > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - jL);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(gVarZ.x()));
            jSONObject.putOpt("fail_msg", gVarZ.lq());
            jSONObject.put("download_failed_times", gVarZ.io());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.gc.a.z() ? 1 : 2);
            jSONObject.put("first_speed_time", dlVar.uf());
            jSONObject.put("all_connect_time", dlVar.l());
            jSONObject.put("download_prepare_time", dlVar.h());
            jSONObject.put("download_time", dlVar.bb() + dlVar.l() + dlVar.h());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public static void dl(com.ss.android.socialbase.downloader.e.dl dlVar, JSONObject jSONObject) {
        if (dlVar != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(dlVar.s()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(dlVar.sf()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(dlVar.ux()));
                jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, dlVar.fo());
                jSONObject.putOpt("network_quality", dlVar.ly());
                jSONObject.putOpt("save_path", dlVar.kb());
                jSONObject.putOpt("file_name", dlVar.gz());
                jSONObject.putOpt("download_status", Integer.valueOf(dlVar.zw()));
                com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar.e());
                if (gVarZ != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(gVarZ.ec()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(gVarZ.bv()));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.gc.a.z() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(com.ss.android.socialbase.downloader.pf.m.dl(com.ss.android.downloadlib.addownload.wp.getContext()) ? 1 : 2));
        if (!com.ss.android.socialbase.downloader.pf.m.g(com.ss.android.downloadlib.addownload.wp.getContext())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i));
    }

    public static void z(com.ss.android.g.z.g.g gVar, JSONObject jSONObject) {
        if (jSONObject == null || gVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", gVar.sv() ? 1 : 0);
            jSONObject.put("origin_mime_type", gVar.jq());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public static void z(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArrayGc = com.ss.android.socialbase.downloader.i.z.z(i).gc("ah_report_config");
        if (jSONArrayGc != null) {
            for (int i2 = 0; i2 < jSONArrayGc.length(); i2++) {
                try {
                    String string = jSONArrayGc.getString(i2);
                    e.z zVarZ = com.ss.android.socialbase.appdownloader.m.z.z(string);
                    if (zVarZ != null) {
                        jSONObject.put(string.replaceAll("\\.", "_"), zVarZ.m() + "_" + zVarZ.e());
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.g.z(com.ss.android.socialbase.downloader.downloader.dl.xl()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject z(JSONObject jSONObject, com.ss.android.g.z.g.z zVar) {
        i.z(jSONObject, "open_url", i.z(zVar.m(), "open_url_not_exist"));
        return jSONObject;
    }

    public static JSONObject g(JSONObject jSONObject, com.ss.android.g.z.g.z zVar) {
        i.z(jSONObject, com.ss.android.socialbase.appdownloader.m.gc.uy().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(i.g(com.ss.android.downloadlib.addownload.wp.getContext(), com.ss.android.socialbase.appdownloader.m.gc.uy())));
        i.z(jSONObject, com.ss.android.socialbase.appdownloader.m.gc.uy().replaceAll("\\.", "_") + " versionName", i.dl(com.ss.android.downloadlib.addownload.wp.getContext(), com.ss.android.socialbase.appdownloader.m.gc.uy()));
        return jSONObject;
    }

    public static void z(JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.m.a.z());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.m.a.dl());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.m.a.a());
            int i = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.m.a.z(com.ss.android.downloadlib.addownload.wp.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.m.a.gc() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.m.a.g());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.m.a.g(com.ss.android.downloadlib.addownload.wp.getContext()) ? 1 : 2));
            if (!com.ss.android.socialbase.appdownloader.m.a.m()) {
                i = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }
}
