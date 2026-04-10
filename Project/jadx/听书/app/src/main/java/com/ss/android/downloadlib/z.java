package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.MediaController;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.ss.android.downloadlib.addownload.g.a;
import com.ss.android.downloadlib.addownload.i;
import com.ss.android.downloadlib.addownload.kb;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.a.ti;
import com.ss.android.socialbase.downloader.z.z;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z implements com.ss.android.g.z.z, g.dl, ti, z.InterfaceC0484z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile z f2020a = null;
    private static String z = "z";
    private g dl;
    private long g;

    private z() {
        com.ss.android.socialbase.appdownloader.g.z(this);
        com.ss.android.socialbase.downloader.z.z.z().z(this);
    }

    public static z z() {
        if (f2020a == null) {
            synchronized (z.class) {
                if (f2020a == null) {
                    f2020a = new z();
                }
            }
        }
        return f2020a;
    }

    public static synchronized void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.g.z.g.g gVar) {
        if (dlVar == null) {
            com.ss.android.downloadlib.gc.dl.z().z("onDownloadFinish info null");
            return;
        }
        if (gVar == null) {
            com.ss.android.downloadlib.gc.dl.z().z("onDownloadFinish nativeModel null");
            return;
        }
        if (gVar.mc() != 1) {
            return;
        }
        com.ss.android.downloadlib.dl.gz.z().a(gVar);
        String strDl = dl(dlVar, gVar);
        com.ss.android.downloadlib.addownload.g.m.z().g(dlVar.uy(), strDl);
        Map<Long, com.ss.android.g.z.g.g> mapZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar.uy(), strDl);
        gVar.m(System.currentTimeMillis());
        gVar.gc(2);
        gVar.g(strDl);
        mapZ.put(Long.valueOf(gVar.g()), gVar);
        com.ss.android.downloadlib.addownload.g.fo.z().z(mapZ.values());
        z(gVar);
        kb.z().g(gVar.q(), dlVar);
        gVar.wp(System.currentTimeMillis());
        gz.z().z(dlVar, strDl);
        if ("application/vnd.android.package-archive".equals(dlVar.yt())) {
            if (com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVar).z("enable_app_install_receiver", 1) != 1 && wp.fo().optInt("enable_app_install_receiver", 1) != 1) {
                i.z().z(gVar);
            }
            z().g(dlVar, gVar);
            if (gVar.wj()) {
                com.ss.android.downloadlib.addownload.z.z.z().z(dlVar.e(), gVar.g(), gVar.wp(), strDl, dlVar.fo(), gVar.a(), dlVar.v());
            }
        }
    }

    public synchronized void z(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.ss.android.downloadlib.e.i.g()) {
            throw new RuntimeException("handleAppInstalled in main thread.");
        }
        final com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(str);
        if (gVarZ == null) {
            com.ss.android.downloadlib.addownload.g.a.z().z(str);
            return;
        }
        com.ss.android.downloadlib.addownload.gc gcVarZ = gz.z().z(gVarZ.z());
        if (gcVarZ != null) {
            gcVarZ.m();
        }
        if (gVarZ.dl.get()) {
            return;
        }
        if (com.ss.android.socialbase.downloader.i.z.z(gVarZ.js()).g("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.g.z().m(gVarZ.js());
        }
        new com.ss.android.downloadlib.g.g().z(gVarZ, new com.ss.android.downloadlib.g.e() { // from class: com.ss.android.downloadlib.z.1
            @Override // com.ss.android.downloadlib.g.e
            public void z(boolean z2) {
                com.ss.android.socialbase.downloader.m.z.g(z.z, "appBackForeground->".concat(String.valueOf(z2)));
                if (z2) {
                    if (!(com.ss.android.downloadlib.g.m.dl(gVarZ) ? com.ss.android.downloadlib.g.z.z(str, gVarZ) : false) && com.ss.android.downloadlib.g.m.a(gVarZ) && gVarZ.oq() == 4) {
                        com.ss.android.downloadlib.addownload.z.z.z().z(gVarZ);
                        return;
                    }
                    return;
                }
                if (com.ss.android.downloadlib.g.z.z(str, gVarZ) || gVarZ.oq() != 4) {
                    return;
                }
                com.ss.android.downloadlib.addownload.z.z.z().z(gVarZ);
            }
        }, com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVarZ).z("try_applink_delay_after_installed", 0));
        com.ss.android.downloadlib.dl.gz.z().m(gVarZ);
        z(str, gVarZ);
        com.ss.android.downloadlib.addownload.z.z.z().g(str);
        com.ss.android.socialbase.downloader.e.dl dlVarZ = z((List<com.ss.android.socialbase.downloader.e.dl>) com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).g("application/vnd.android.package-archive"), str);
        if (dlVarZ != null) {
            if (com.ss.android.socialbase.downloader.i.z.z(dlVarZ.e()).g("no_hide_notification") != 1) {
                com.ss.android.socialbase.downloader.notification.g.z().z(dlVarZ.e());
            }
            gz.z().g(dlVarZ, str);
            com.ss.android.downloadlib.addownload.dl.a.z(dlVarZ);
            return;
        }
        gz.z().g(null, str);
    }

    void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.g.z.g.g gVar, int i) {
        long jMax;
        if (dlVar == null || gVar == null) {
            return;
        }
        a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        gVar.g(jCurrentTimeMillis);
        gVar.e(com.ss.android.downloadlib.e.i.z(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            jMax = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        } else {
            long jZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("check_install_failed_delay_time", 120000L);
            if (jZ < 0) {
                return;
            } else {
                jMax = Math.max(jZ, MediaController.RELEASE_UNBIND_TIMEOUT_MS);
            }
        }
        long j = jMax;
        g gVar2 = new g(gVar.g(), dlVar.e(), jCurrentTimeMillis, i);
        gc.z().z(gVar2, j);
        this.dl = gVar2;
        com.ss.android.downloadlib.addownload.g.fo.z().z(gVar);
    }

    private static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2021a;
        private long dl;
        private int g;
        private long gc;
        private long z;

        private g(long j, int i, long j2, int i2) {
            this.z = j;
            this.g = i;
            this.dl = j2;
            this.f2021a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            this.gc = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (z()) {
                    z.z().z(this.z, this.g);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(21:12|(1:19)(20:16|(0)|21|52|22|23|54|24|(1:26)|27|(1:29)(1:30)|31|(1:34)|35|(1:37)(1:38)|39|(1:41)|42|49|50)|20|21|52|22|23|54|24|(0)|27|(0)(0)|31|(1:34)|35|(0)(0)|39|(0)|42|49|50) */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00f2, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00f4, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00f5, code lost:
        
            r3 = r6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00f7, code lost:
        
            com.bytedance.sdk.component.utils.wp.z(r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:26:0x00ae A[Catch: Exception -> 0x00f2, TryCatch #1 {Exception -> 0x00f2, blocks: (B:24:0x008c, B:26:0x00ae, B:31:0x00c1, B:34:0x00ce, B:39:0x00dd, B:42:0x00ee), top: B:54:0x008c }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00ec  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean z() {
            /*
                Method dump skipped, instruction units count: 261
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.z.g.z():boolean");
        }

        private int z(boolean z, com.ss.android.g.z.g.g gVar, com.ss.android.socialbase.downloader.e.dl dlVar, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e());
            int i = 1;
            if (zVarZ.z("install_failed_check_ttmd5", 1) == 1) {
                int iXt = dlVar.xt();
                try {
                    jSONObject.put("ttmd5_status", iXt);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.pf.m.z(iXt)) {
                    return 2005;
                }
            }
            int i2 = this.f2021a;
            if (i2 != 2000) {
                return i2;
            }
            if (zVarZ.z("install_failed_check_signature", 1) == 1 && com.ss.android.downloadlib.e.i.gc(wp.getContext(), gVar.gc())) {
                if (!com.ss.android.downloadlib.e.i.z(com.ss.android.downloadlib.e.i.fo(wp.getContext(), dlVar.v()), com.ss.android.downloadlib.e.i.gz(wp.getContext(), gVar.gc()))) {
                    return 2006;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.gc;
            long j2 = this.dl;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (gVar.h() <= this.dl) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable unused2) {
            }
            return !z2 ? 2003 : 2004;
        }
    }

    public void z(final long j, int i) {
        long jZ = com.ss.android.socialbase.downloader.i.z.z(i).z("check_install_finish_hijack_delay_time", 900000L);
        if (jZ < 0) {
            return;
        }
        gc.z().z(new Runnable() { // from class: com.ss.android.downloadlib.z.2
            @Override // java.lang.Runnable
            public void run() {
                z.z().z(j);
            }
        }, Math.max(jZ, 300000L));
    }

    public void z(long j) {
        a.z zVarZ;
        int iIntValue;
        try {
            com.ss.android.g.z.g.g gVarA = com.ss.android.downloadlib.addownload.g.m.z().a(j);
            if (gVarA != null && !com.ss.android.downloadlib.e.i.g(gVarA) && !gVarA.dl.get()) {
                Pair<a.z, Integer> pairG = com.ss.android.downloadlib.addownload.g.a.z().g(gVarA);
                if (pairG != null) {
                    zVarZ = (a.z) pairG.first;
                    iIntValue = ((Integer) pairG.second).intValue();
                } else {
                    zVarZ = com.ss.android.downloadlib.addownload.g.a.z().z(gVarA);
                    iIntValue = -1;
                }
                if (zVarZ == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.g.a.z().g(zVarZ.z);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", zVarZ.f1984a);
                jSONObject.put("installed_pkg_name", zVarZ.z);
                if (iIntValue != -1) {
                    jSONObject.put("error_code", iIntValue);
                    com.ss.android.downloadlib.e.m.z(jSONObject, gVarA.js());
                    com.ss.android.downloadlib.a.z.z().g("install_finish_hijack", jSONObject, gVarA);
                    return;
                }
                com.ss.android.downloadlib.a.z.z().g("install_finish_may_hijack", jSONObject, gVarA);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.gc.dl.z().z(th, "trySendInstallFinishHijack");
        }
    }

    public void z(String str, com.ss.android.g.z.g.g gVar) {
        if (gVar != null && com.ss.android.downloadlib.e.i.g(gVar) && gVar.dl.compareAndSet(false, true)) {
            int i = 4;
            if (gVar.oq() == 4) {
                com.ss.android.z.z.g.kb kbVarIq = wp.iq();
                if (kbVarIq != null) {
                    kbVarIq.z(gVar.q());
                }
            } else {
                i = 3;
            }
            com.ss.android.downloadlib.a.z.z().z(gVar.uy(), "install_finish", z(gVar, str, i), gVar);
            com.ss.android.downloadlib.addownload.g.fo.z().z(gVar);
        }
    }

    private static com.ss.android.socialbase.downloader.e.dl z(List<com.ss.android.socialbase.downloader.e.dl> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (com.ss.android.socialbase.downloader.e.dl dlVar : list) {
                if (dlVar != null) {
                    if (str.equals(dlVar.x())) {
                        return dlVar;
                    }
                    if (com.ss.android.downloadlib.e.i.z(wp.getContext(), dlVar.v(), str)) {
                        return dlVar;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject z(JSONObject jSONObject, com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (jSONObject != null && dlVar != null) {
            int i = 1;
            if (com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", dlVar.e());
                jSONObject.put("name", dlVar.gz());
                jSONObject.put("cur_bytes", dlVar.sf());
                jSONObject.put("total_bytes", dlVar.s());
                jSONObject.put("network_quality", dlVar.ly());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.fo.wp.z().g().name());
                jSONObject.put("only_wifi", dlVar.io() ? 1 : 0);
                jSONObject.put("need_https_degrade", dlVar.dt() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", dlVar.tb() ? 1 : 0);
                jSONObject.put("chunk_count", dlVar.ux());
                jSONObject.put("retry_count", dlVar.oq());
                jSONObject.put("cur_retry_time", dlVar.bw());
                jSONObject.put("need_retry_delay", dlVar.xo() ? 1 : 0);
                jSONObject.put("backup_url_used", dlVar.t() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", dlVar.dl() != null ? dlVar.dl() : "");
                jSONObject.put("need_independent_process", dlVar.tf() ? 1 : 0);
                jSONObject.put("total_retry_count", dlVar.na());
                jSONObject.put("cur_retry_time_in_total", dlVar.xl());
                jSONObject.put("real_download_time", dlVar.bb());
                jSONObject.put("first_speed_time", dlVar.uf());
                jSONObject.put("all_connect_time", dlVar.l());
                jSONObject.put("download_prepare_time", dlVar.h());
                jSONObject.put("download_time", dlVar.bb() + dlVar.l() + dlVar.h());
                jSONObject.put("chunk_downgrade_retry_used", dlVar.kp() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", dlVar.lt() ? 1 : 0);
                jSONObject.put("failed_resume_count", dlVar.to());
                jSONObject.put("preconnect_level", dlVar.po());
                jSONObject.put(TKDownloadReason.KSAD_TK_MD5, dlVar.mc());
                jSONObject.put("expect_file_length", dlVar.un());
                jSONObject.put("retry_schedule_count", dlVar.ec());
                jSONObject.put("rw_concurrent", dlVar.rv() ? 1 : 0);
                double dSf = dlVar.sf() / 1048576.0d;
                double dBb = dlVar.bb() / 1000.0d;
                if (dSf > 0.0d && dBb > 0.0d) {
                    double d = dSf / dBb;
                    try {
                        jSONObject.put("download_speed", d);
                    } catch (Exception unused) {
                    }
                    com.ss.android.socialbase.downloader.m.z.g(z, "download speed : " + d + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).i(dlVar.e()) ? 1 : 0);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
                if (dlVar.mj() != null) {
                    jSONObject.put("backup_url_count", dlVar.mj().size());
                    jSONObject.put("cur_backup_url_index", dlVar.js());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.dl.a.z().g(dlVar.uy()));
                jSONObject.put("mime_type", dlVar.yt());
                if (!com.ss.android.socialbase.downloader.pf.m.dl(wp.getContext())) {
                    i = 2;
                }
                jSONObject.put("network_available", i);
                jSONObject.put("status_code", dlVar.wo());
                g(jSONObject, dlVar);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
        return jSONObject;
    }

    public static JSONObject g(JSONObject jSONObject, com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (jSONObject == null || dlVar == null || com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long jG = com.ss.android.downloadlib.e.i.g(0L);
            double d = jG;
            jSONObject.put("available_space", d / 1048576.0d);
            long jS = dlVar.s();
            double d2 = jS;
            jSONObject.put("apk_size", d2 / 1048576.0d);
            if (jG > 0 && jS > 0) {
                jSONObject.put("available_space_ratio", d / d2);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        return jSONObject;
    }

    public void g(com.ss.android.socialbase.downloader.e.dl dlVar, final com.ss.android.g.z.g.g gVar) {
        if (dlVar == null || gVar == null || com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String strV = dlVar.v();
        if (TextUtils.isEmpty(strV)) {
            return;
        }
        gc.z().g(new Runnable() { // from class: com.ss.android.downloadlib.z.3
            @Override // java.lang.Runnable
            public void run() {
                String strZ = com.ss.android.downloadlib.e.z.z(strV);
                if (TextUtils.isEmpty(strZ)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.ats.a.z(wp.getContext(), "sp_ttdownloader_md5", 0).edit().putString(String.valueOf(gVar.g()), strZ).apply();
            }
        });
    }

    private static void z(com.ss.android.g.z.g.g gVar) {
        if (gVar == null) {
            return;
        }
        String strGp = TextUtils.isEmpty(gVar.gp()) ? "" : gVar.gp();
        com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(gVar.js());
        gVar.wp("");
        com.ss.android.downloadlib.addownload.g.fo.z().z(gVar);
        JSONObject jSONObjectZ = z(new JSONObject(), dlVarGz);
        int i = 1;
        try {
            jSONObjectZ.putOpt("finish_reason", strGp);
            jSONObjectZ.putOpt("finish_from_reserve_wifi", Integer.valueOf(dlVarGz.bv() ? 1 : 0));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVarGz);
        com.ss.android.downloadlib.e.m.z(jSONObjectZ, dlVarGz.e());
        try {
            jSONObjectZ.put("download_failed_times", gVarZ.io());
            jSONObjectZ.put("can_show_notification", com.ss.android.socialbase.appdownloader.gc.a.z() ? 1 : 2);
            if (dlVarGz.un() > 0 && dlVarGz.s() > 0) {
                jSONObjectZ.put("file_length_gap", dlVarGz.un() - dlVarGz.s());
            }
            jSONObjectZ.put("ttmd5_status", dlVarGz.hh());
            jSONObjectZ.put("has_send_download_failed_finally", gVarZ.f2024a.get() ? 1 : 2);
            if (!gVarZ.gb()) {
                i = 2;
            }
            jSONObjectZ.put("is_update_download", i);
            com.ss.android.downloadlib.e.m.z(gVarZ, jSONObjectZ);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        com.ss.android.downloadlib.a.z.z().g("download_finish", jSONObjectZ, gVar);
    }

    private int z(com.ss.android.g.z.g.g gVar, com.ss.android.socialbase.downloader.e.dl dlVar, String str, JSONObject jSONObject) {
        int iG = com.ss.android.socialbase.appdownloader.dl.g(wp.getContext(), dlVar);
        int iG2 = com.ss.android.downloadlib.e.i.g(wp.getContext(), str);
        if (iG > 0 && iG2 > 0 && iG != iG2) {
            return iG2 > iG ? 3011 : 3010;
        }
        if (com.ss.android.socialbase.downloader.i.z.z(gVar.js()).z("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = com.bytedance.sdk.openadsdk.ats.a.z(wp.getContext(), "sp_ttdownloader_md5", 0).getString(String.valueOf(gVar.g()), null);
        if (TextUtils.isEmpty(string) && dlVar != null) {
            string = com.ss.android.downloadlib.e.z.z(dlVar.v());
        }
        int iZ = com.ss.android.downloadlib.e.z.z(string, com.ss.android.downloadlib.e.z.g(str));
        try {
            jSONObject.put("ttmd5_status", iZ);
        } catch (Throwable unused) {
        }
        if (iZ == 0) {
            return 3000;
        }
        return iZ == 1 ? 3002 : 3001;
    }

    public static String dl(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.g.z.g.g gVar) {
        File file = new File(dlVar.kb(), dlVar.gz());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = wp.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.dl.z());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(dlVar.x())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", dlVar.x());
            } catch (JSONException e2) {
                com.bytedance.sdk.component.utils.wp.z(e2);
            }
            com.ss.android.downloadlib.a.z.z().z("embeded_ad", "package_name_error", jSONObject, gVar);
            return str;
        }
        return dlVar.x();
    }

    @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
    public void g() {
        com.ss.android.socialbase.downloader.m.z.g(z, "onAppForeground()");
        a();
        z(5);
    }

    @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
    public void dl() {
        com.ss.android.socialbase.downloader.m.z.g(z, "onAppBackground()");
        z(6);
    }

    synchronized void a() {
        g gVar = this.dl;
        if (gVar != null) {
            gVar.g();
            this.dl = null;
        }
    }

    @Override // com.ss.android.g.z.z
    public void z(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.g < 120000) {
            return;
        }
        gc.z().z(new RunnableC0447z(i), this.g > 0 ? ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS : 8000L);
        this.g = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(ConcurrentHashMap<Long, com.ss.android.g.z.g.g> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.g.z.g.g gVar : concurrentHashMap.values()) {
            if (gVar.dl.get()) {
                if (jCurrentTimeMillis - gVar.un() >= com.ss.android.socialbase.downloader.i.z.z(gVar.js()).z("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(gVar.g()));
                }
            } else if (gVar.mc() == 1) {
                if (g(gVar) <= 0 && jCurrentTimeMillis - gVar.un() >= com.ss.android.socialbase.downloader.i.z.z(gVar.js()).z("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(gVar.g()));
                }
            } else if (gVar.mc() == 2) {
                if (!gVar.f()) {
                    if (com.ss.android.downloadlib.e.i.g(gVar)) {
                        if (gVar.oq() == 4) {
                            i = gVar.oq();
                            com.ss.android.z.z.g.kb kbVarIq = wp.iq();
                            if (kbVarIq != null) {
                                kbVarIq.z(gVar.q());
                            }
                        }
                        gVar.uy(false);
                        com.ss.android.downloadlib.a.z.z().z(z(gVar, gVar.gc(), i), gVar);
                        arrayList.add(Long.valueOf(gVar.g()));
                        com.ss.android.downloadlib.addownload.dl.a.z(gVar);
                    } else if (gVar.f() && gVar.oq() == 4 && i == 1 && !com.ss.android.downloadlib.e.i.g(gVar)) {
                        com.ss.android.downloadlib.e.wp.z().z(z, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                        fo.z().z(gVar);
                    } else if (jCurrentTimeMillis - gVar.un() >= com.ss.android.socialbase.downloader.i.z.z(gVar.js()).z("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(gVar.g()));
                    } else if (TextUtils.isEmpty(gVar.gc())) {
                        arrayList.add(Long.valueOf(gVar.g()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(gVar.g()));
            }
        }
        com.ss.android.downloadlib.addownload.g.m.z().z(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.g.dl
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.appdownloader.z zVar) {
        JSONObject jSONObjectG;
        if (dlVar == null || zVar == null) {
            return;
        }
        JSONArray jSONArrayGc = com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).gc("ah_report_config");
        if (zVar.g != 0) {
            dlVar.rg().remove("intent");
        }
        if (jSONArrayGc == null || (jSONObjectG = g(dlVar, zVar)) == null) {
            return;
        }
        dlVar.rg().put("ah_ext_json", jSONObjectG);
    }

    @Override // com.ss.android.socialbase.downloader.a.ti
    public void z(final com.ss.android.socialbase.downloader.e.dl dlVar, String str) {
        if (dlVar == null) {
            com.ss.android.downloadlib.gc.dl.z().z("info is null");
        } else if ((com.ss.android.socialbase.downloader.i.z.z(dlVar).g("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) dlVar.rg().get("ah_ext_json");
            com.ss.android.downloadlib.g.gc.z().g(new com.ss.android.downloadlib.g.a() { // from class: com.ss.android.downloadlib.z.4
                @Override // com.ss.android.downloadlib.g.a
                public void z(boolean z2) {
                    if (!z2) {
                        Intent intent = (Intent) dlVar.rg().get("intent");
                        if (intent != null) {
                            dlVar.rg().remove("intent");
                            com.ss.android.socialbase.appdownloader.dl.z(wp.getContext(), intent);
                            com.ss.android.downloadlib.e.i.z(jSONObject, LiveConfigKey.BACKUP, (Object) 1);
                        } else {
                            com.ss.android.downloadlib.e.i.z(jSONObject, LiveConfigKey.BACKUP, (Object) 2);
                        }
                    }
                    com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
                    if (gVarZ != null) {
                        com.ss.android.downloadlib.a.z.z().z(z2 ? "installer_delay_success" : "installer_delay_failed", jSONObject, gVarZ);
                    } else {
                        com.ss.android.downloadlib.gc.dl.z().g("ah nativeModel=null");
                    }
                    if (z2) {
                        wp.q();
                        wp.getContext();
                    }
                }
            });
        }
    }

    private int g(com.ss.android.g.z.g.g gVar) {
        int iZw;
        double dZ = com.ss.android.socialbase.downloader.i.z.z(gVar.js()).z("download_failed_finally_hours", 48.0d);
        if (dZ <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - gVar.un() < dZ * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (gVar.f2024a.get()) {
            return 0;
        }
        com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(gVar.js());
        if (dlVarGz == null || (iZw = dlVarGz.zw()) == -3 || iZw == -4) {
            return -1;
        }
        if (!com.ss.android.socialbase.downloader.g.m.g(iZw) && gVar.f2024a.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                z(jSONObject, dlVarGz);
                jSONObject.putOpt("download_status", Integer.valueOf(iZw));
                jSONObject.putOpt("fail_status", Integer.valueOf(gVar.x()));
                jSONObject.putOpt("fail_msg", gVar.lq());
                jSONObject.put("download_failed_times", gVar.io());
                if (dlVarGz.s() > 0) {
                    jSONObject.put("download_percent", dlVarGz.sf() / dlVarGz.s());
                }
                jSONObject.put("is_update_download", gVar.gb() ? 1 : 2);
                com.ss.android.downloadlib.a.z.z().z(gVar.uy(), "download_failed_finally", jSONObject, gVar);
                com.ss.android.downloadlib.addownload.g.fo.z().z(gVar);
                return 0;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
        return 1;
    }

    private JSONObject g(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.appdownloader.z zVar) {
        com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
        if (gVarZ == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        zVar.z(jSONObject);
        try {
            jSONObject.put("download_id", dlVar.e());
            jSONObject.put("name", dlVar.gz());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        com.ss.android.downloadlib.e.m.z(jSONObject, dlVar.e());
        com.ss.android.downloadlib.a.z.z().z("embeded_ad", "ah_result", jSONObject, gVarZ);
        return jSONObject;
    }

    /* JADX INFO: renamed from: com.ss.android.downloadlib.z$z, reason: collision with other inner class name */
    private class RunnableC0447z implements Runnable {
        private final int g;

        public RunnableC0447z(int i) {
            this.g = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.g.m.z().g();
                ConcurrentHashMap<Long, com.ss.android.g.z.g.g> concurrentHashMapDl = com.ss.android.downloadlib.addownload.g.m.z().dl();
                if (concurrentHashMapDl == null || concurrentHashMapDl.isEmpty()) {
                    return;
                }
                z.this.z(concurrentHashMapDl, this.g);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    private JSONObject z(com.ss.android.g.z.g.g gVar, String str, int i) {
        com.ss.android.socialbase.appdownloader.z zVarZ;
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(gVar.js());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.ss.android.downloadlib.e.m.z(jSONObject, gVar.js());
            com.ss.android.downloadlib.e.m.z(gVar, jSONObject);
            jSONObject.put("is_update_download", gVar.gb() ? 1 : 2);
            jSONObject.put("install_after_back_app", gVar.zx() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", gVar.vm() ? "1" : "2");
            if (dlVarGz != null) {
                z(jSONObject, dlVarGz);
                try {
                    jSONObject.put("uninstall_resume_count", dlVarGz.jh());
                    if (gVar.h() > 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - gVar.h();
                        jSONObject.put("install_time", jCurrentTimeMillis);
                        if (jCurrentTimeMillis > com.ss.android.socialbase.downloader.i.z.z(dlVarGz.e()).z("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String strZ = com.ss.android.socialbase.downloader.pf.m.z(dlVarGz.rg().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(strZ) && (zVarZ = com.ss.android.socialbase.appdownloader.z.z(strZ)) != null) {
                    zVarZ.z(jSONObject);
                }
            }
            int iZ = z(gVar, dlVarGz, str, jSONObject);
            jSONObject.put("fail_status", iZ);
            if (iZ == 3000) {
                jSONObject.put("hijack", 2);
            } else if (iZ == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        return jSONObject;
    }

    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, long j, long j2, long j3, long j4, long j5, boolean z2) {
        com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
        if (gVarZ == null) {
            com.ss.android.downloadlib.gc.dl.z().z("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z2 ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.ss.android.downloadlib.e.m.dl(dlVar, jSONObject);
            com.ss.android.downloadlib.a.z.z().z("cleanup", jSONObject, gVarZ);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }
}
