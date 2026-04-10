package com.ss.android.downloadlib.a;

import android.os.Build;
import com.ss.android.downloadlib.addownload.g.fo;
import com.ss.android.downloadlib.addownload.g.gc;
import com.ss.android.downloadlib.addownload.g.m;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.socialbase.appdownloader.gc.a;
import com.ss.android.z.z.gc.a;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z {

    /* JADX INFO: renamed from: com.ss.android.downloadlib.a.z$z, reason: collision with other inner class name */
    private static class C0439z {
        private static z z = new z();
    }

    public static z z() {
        return C0439z.z;
    }

    private z() {
    }

    public void z(long j, int i) {
        gc gcVarGc = m.z().gc(j);
        if (gcVarGc.io()) {
            com.ss.android.downloadlib.gc.dl.z().z("sendClickEvent ModelBox notValid");
            return;
        }
        if (gcVarGc.dl.wp()) {
            int i2 = 1;
            com.ss.android.z.z.dl.g gVar = gcVarGc.dl;
            String strDl = i == 1 ? gVar.dl() : gVar.g();
            String strZ = i.z(gcVarGc.dl.a(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i));
                jSONObject.putOpt("permission_notification", Integer.valueOf(a.z() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.pf.m.dl(wp.getContext())) {
                    i2 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i2));
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            z(strDl, strZ, jSONObject, gcVarGc);
            if (!"click".equals(strZ) || gcVarGc.g == null) {
                return;
            }
            dl.z().z(j, gcVarGc.g.uf());
        }
    }

    public void z(long j, int i, com.ss.android.socialbase.downloader.e.dl dlVar) {
        String strZ;
        gc gcVarGc = m.z().gc(j);
        if (gcVarGc.io()) {
            com.ss.android.downloadlib.gc.dl.z().z("sendEvent ModelBox notValid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        i.z(jSONObject, "download_scene", Integer.valueOf(gcVarGc.tb()));
        if (i == 1) {
            strZ = i.z(gcVarGc.dl.fo(), "storage_deny");
        } else if (i == 2) {
            strZ = i.z(gcVarGc.dl.gc(), "click_start");
            com.ss.android.downloadlib.e.m.z(dlVar, jSONObject);
        } else if (i == 3) {
            strZ = i.z(gcVarGc.dl.m(), "click_pause");
            com.ss.android.downloadlib.e.m.g(dlVar, jSONObject);
        } else if (i == 4) {
            strZ = i.z(gcVarGc.dl.e(), "click_continue");
            com.ss.android.downloadlib.e.m.dl(dlVar, jSONObject);
        } else if (i != 5) {
            strZ = null;
        } else {
            if (dlVar != null) {
                try {
                    com.ss.android.downloadlib.e.m.z(jSONObject, dlVar.e());
                    com.ss.android.downloadlib.z.g(jSONObject, dlVar);
                } catch (Throwable unused) {
                }
            }
            strZ = i.z(gcVarGc.dl.gz(), "click_install");
        }
        z(null, strZ, jSONObject, 0L, 1, gcVarGc);
    }

    public void g(long j, int i) {
        z(j, i, (com.ss.android.socialbase.downloader.e.dl) null);
    }

    public void z(String str, int i, gc gcVar) {
        z(null, str, null, i, 0, gcVar);
    }

    public void z(long j, boolean z, int i) {
        gc gcVarGc = m.z().gc(j);
        if (gcVarGc.io()) {
            com.ss.android.downloadlib.gc.dl.z().z("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (gcVarGc.g.lq() == null) {
            return;
        }
        if (gcVarGc.g instanceof com.ss.android.g.z.z.dl) {
            ((com.ss.android.g.z.z.dl) gcVarGc.g).dl(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        g(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, gcVarGc);
    }

    public void z(long j, com.ss.android.socialbase.downloader.gc.z zVar) {
        gc gcVarGc = m.z().gc(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (zVar != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(zVar.z()));
                jSONObject.putOpt("fail_msg", zVar.g());
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        g("download_failed", jSONObject, gcVarGc);
    }

    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        com.ss.android.g.z.g.g gVarZ = m.z().z(dlVar);
        if (gVarZ == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.e.m.dl(dlVar, jSONObject);
            gVarZ.z(System.currentTimeMillis());
            z(gVarZ.uy(), "download_resume", jSONObject, gVarZ);
            fo.z().z(gVarZ);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public void z(JSONObject jSONObject, com.ss.android.g.z.g.g gVar) {
        z(gVar.uy(), "install_finish", jSONObject, gVar);
    }

    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        com.ss.android.g.z.g.g gVarZ;
        if (dlVar == null || (gVarZ = m.z().z(dlVar)) == null || gVarZ.dl.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.z.z(jSONObject, dlVar);
            jSONObject.putOpt("fail_status", Integer.valueOf(gVarZ.x()));
            jSONObject.putOpt("fail_msg", gVarZ.lq());
            jSONObject.put("download_failed_times", gVarZ.io());
            if (dlVar.s() > 0) {
                jSONObject.put("download_percent", dlVar.sf() / dlVar.s());
            }
            jSONObject.put("download_status", dlVar.zw());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (gVarZ.un() > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - gVarZ.un());
            }
            if (gVarZ.l() > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - gVarZ.l());
            }
            int i = 1;
            jSONObject.put("is_update_download", gVarZ.gb() ? 1 : 2);
            jSONObject.put("can_show_notification", a.z() ? 1 : 2);
            if (!gVarZ.f2024a.get()) {
                i = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        z(gVarZ.uy(), "download_cancel", jSONObject, gVarZ);
    }

    public void g(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        if (dlVar == null) {
            return;
        }
        com.ss.android.g.z.g.g gVarZ = m.z().z(dlVar);
        if (gVarZ == null) {
            com.ss.android.downloadlib.gc.dl.z().z("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (gVarZ.dl.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.e.m.dl(dlVar, jSONObject);
            com.ss.android.downloadlib.z.z(jSONObject, dlVar);
            if (zVar != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(zVar.z()));
                jSONObject.putOpt("fail_msg", zVar.g());
                gVarZ.a(zVar.z());
                gVarZ.z(zVar.g());
            }
            gVarZ.uf();
            jSONObject.put("download_failed_times", gVarZ.io());
            if (dlVar.s() > 0) {
                jSONObject.put("download_percent", dlVar.sf() / dlVar.s());
            }
            int i = 1;
            jSONObject.put("has_send_download_failed_finally", gVarZ.f2024a.get() ? 1 : 2);
            com.ss.android.downloadlib.e.m.z(gVarZ, jSONObject);
            if (!gVarZ.gb()) {
                i = 2;
            }
            jSONObject.put("is_update_download", i);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        z(gVarZ.uy(), "download_failed", jSONObject, gVarZ);
        fo.z().z(gVarZ);
    }

    public void z(String str, long j) {
        z(str, (JSONObject) null, j);
    }

    public void z(String str, com.ss.android.g.z.g.z zVar) {
        z(str, (JSONObject) null, zVar);
    }

    public void z(String str, JSONObject jSONObject, long j) {
        com.ss.android.g.z.g.z zVarA = m.z().a(j);
        if (zVarA != null) {
            z(str, jSONObject, zVarA);
            return;
        }
        gc gcVarGc = m.z().gc(j);
        if (gcVarGc.io()) {
            com.ss.android.downloadlib.gc.dl.z().z("sendUnityEvent ModelBox notValid");
        } else {
            z(str, jSONObject, gcVarGc);
        }
    }

    public void z(String str, JSONObject jSONObject, com.ss.android.g.z.g.z zVar) {
        JSONObject jSONObject2 = new JSONObject();
        i.z(jSONObject2, "unity_label", str);
        z("embeded_ad", "ttdownloader_unity", i.z(jSONObject, jSONObject2), zVar);
    }

    public void z(String str, com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar) {
        g(str, new gc(dlVar.a(), dlVar, gVar, zVar));
    }

    public void g(String str, long j) {
        com.ss.android.g.z.g.g gVarA = m.z().a(j);
        if (gVarA != null) {
            g(str, gVarA);
        } else {
            g(str, m.z().gc(j));
        }
    }

    public void g(String str, com.ss.android.g.z.g.z zVar) {
        z((String) null, str, zVar);
    }

    public void g(String str, JSONObject jSONObject, com.ss.android.g.z.g.z zVar) {
        z((String) null, str, jSONObject, zVar);
    }

    public void z(String str, String str2, com.ss.android.g.z.g.z zVar) {
        z(str, str2, (JSONObject) null, zVar);
    }

    public void z(String str, String str2, JSONObject jSONObject, com.ss.android.g.z.g.z zVar) {
        z(str, str2, jSONObject, 0L, 0, zVar);
    }

    private void z(String str, String str2, JSONObject jSONObject, long j, int i, com.ss.android.g.z.g.z zVar) {
        if (zVar == null) {
            com.ss.android.downloadlib.gc.dl.z().z("onEvent data null");
            return;
        }
        if ((zVar instanceof gc) && ((gc) zVar).io()) {
            com.ss.android.downloadlib.gc.dl.z().z("onEvent ModelBox notValid");
            return;
        }
        try {
            a.z zVarDl = new a.z().z(i.z(str, zVar.uy(), "embeded_ad")).g(str2).g(zVar.dl()).z(zVar.g()).dl(zVar.a());
            if (j <= 0) {
                j = zVar.wp();
            }
            a.z zVarZ = zVarDl.g(j).a(zVar.fo()).z(zVar.v()).z(i.z(z(zVar), jSONObject)).g(zVar.kb()).z(zVar.pf());
            if (i <= 0) {
                i = 2;
            }
            z(zVarZ.z(i).z(zVar.i()).z());
        } catch (Exception e) {
            com.ss.android.downloadlib.gc.dl.z().z(e, "onEvent");
        }
    }

    private JSONObject z(com.ss.android.g.z.g.z zVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            i.z(zVar.e(), jSONObject);
            i.z(zVar.ls(), jSONObject);
            jSONObject.putOpt("download_url", zVar.z());
            jSONObject.putOpt(an.o, zVar.gc());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.m.gc.gz());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.m.gc.fo());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(zVar.gz()));
            if (zVar.gz() == 2) {
                com.ss.android.downloadlib.e.m.g(jSONObject, zVar);
            }
            if (com.ss.android.socialbase.appdownloader.m.gc.ls()) {
                com.ss.android.downloadlib.e.m.z(jSONObject);
            }
        } catch (Exception e) {
            wp.tb().z(e, "getBaseJson");
        }
        return jSONObject;
    }

    private void z(com.ss.android.z.z.gc.a aVar) {
        if (wp.z() == null) {
            return;
        }
        if (aVar.i()) {
            wp.z().z(aVar);
        } else {
            wp.z().g(aVar);
        }
    }
}
