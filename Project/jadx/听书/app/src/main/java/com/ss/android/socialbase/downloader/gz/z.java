package com.ss.android.socialbase.downloader.gz;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.ss.android.socialbase.downloader.a.l;
import com.ss.android.socialbase.downloader.a.pf;
import com.ss.android.socialbase.downloader.downloader.fv;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.fo.fo;
import com.ss.android.socialbase.downloader.fo.gc;
import com.ss.android.socialbase.downloader.g.m;
import com.ss.android.socialbase.downloader.gc.gz;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z {
    public static void z(a aVar, com.ss.android.socialbase.downloader.gc.z zVar, int i) {
        if (aVar == null) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.e.dl dlVarZ = aVar.z();
            if (dlVarZ == null) {
                return;
            }
            l lVarGc = aVar.gc();
            boolean zDl = m.dl(i);
            if (!zDl && !(zDl = z(dlVarZ.nh(), i)) && lVarGc != null && (lVarGc instanceof com.ss.android.socialbase.downloader.a.a)) {
                zDl = z(((com.ss.android.socialbase.downloader.a.a) lVarGc).z(), i);
            }
            if (zDl) {
                try {
                    pf pfVarA = aVar.a();
                    if (pfVarA != null) {
                        pfVarA.z(dlVarZ, zVar, i);
                    }
                } catch (Throwable th) {
                    wp.z(th);
                }
                z(lVarGc, dlVarZ, zVar, i);
                z(com.ss.android.socialbase.downloader.downloader.dl.m(), dlVarZ, zVar, i);
            }
        } catch (Throwable th2) {
            wp.z(th2);
        }
    }

    private static boolean z(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void z(l lVar, com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, int i) {
        if (lVar == null) {
            return;
        }
        try {
            String strG = lVar.g();
            if (TextUtils.isEmpty(strG)) {
                strG = "default";
            }
            JSONObject jSONObjectZ = z(strG, dlVar, zVar, i);
            if (jSONObjectZ == null) {
                jSONObjectZ = new JSONObject();
            }
            lVar.z(jSONObjectZ);
        } catch (Throwable unused) {
        }
    }

    public static void z(g gVar, com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, int i) {
        if (gVar == null || !dlVar.tc() || TextUtils.isEmpty(dlVar.me())) {
            return;
        }
        try {
            JSONObject jSONObjectZ = z(dlVar.me(), dlVar, zVar, i);
            if (jSONObjectZ == null) {
                jSONObjectZ = new JSONObject();
            }
            if (i == -1) {
                jSONObjectZ.put(NotificationCompat.CATEGORY_STATUS, zVar.z());
            } else {
                z(i, jSONObjectZ, dlVar);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private static void z(int i, JSONObject jSONObject, com.ss.android.socialbase.downloader.e.dl dlVar) throws JSONException {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i != -3) {
            str = i != -2 ? i != 0 ? i != 2 ? i != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double dW = dlVar.w();
            if (dW >= 0.0d) {
                jSONObject.put("download_speed", dW);
            }
            str = "download_success";
        }
        jSONObject.put(NotificationCompat.CATEGORY_STATUS, str);
    }

    public static String z(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e) {
            wp.z(e);
            return "";
        }
    }

    private static JSONObject z(String str, com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, int i) {
        String strG;
        String strZ;
        String strZ2;
        int iDl;
        String lastPathSegment;
        String host;
        String path;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                fv fvVarUy = com.ss.android.socialbase.downloader.downloader.dl.uy();
                if (fvVarUy != null) {
                    strG = fvVarUy.g();
                    strZ = z(strG);
                    strZ2 = fvVarUy.z();
                    iDl = fvVarUy.dl();
                } else {
                    strG = "";
                    strZ = strG;
                    strZ2 = strZ;
                    iDl = 0;
                }
                String strA = (zVar == null || !(zVar instanceof gz)) ? "" : ((gz) zVar).a();
                jSONObject2.put("event_page", str);
                jSONObject2.put(PluginConstants.KEY_APP_ID, strZ2);
                jSONObject2.put("device_id", strG);
                jSONObject2.put("device_id_postfix", strZ);
                jSONObject2.put("update_version", iDl);
                jSONObject2.put("download_status", i);
                if (dlVar != null) {
                    jSONObject2.put("setting_tag", com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).dl("setting_tag"));
                    jSONObject2.put("download_id", dlVar.e());
                    jSONObject2.put("name", dlVar.gz());
                    jSONObject2.put("url", dlVar.uy());
                    jSONObject2.put("save_path", dlVar.kb());
                    jSONObject2.put("download_time", dlVar.oz());
                    jSONObject2.put("cur_bytes", dlVar.sf());
                    jSONObject2.put("total_bytes", dlVar.s());
                    jSONObject2.put("network_quality", dlVar.ly());
                    int i2 = 1;
                    jSONObject2.put("only_wifi", dlVar.io() ? 1 : 0);
                    jSONObject2.put("need_https_degrade", dlVar.dt() ? 1 : 0);
                    jSONObject2.put("https_degrade_retry_used", dlVar.tb() ? 1 : 0);
                    jSONObject2.put(TKDownloadReason.KSAD_TK_MD5, dlVar.mc() == null ? "" : dlVar.mc());
                    jSONObject2.put("chunk_count", dlVar.ux());
                    jSONObject2.put("is_force", dlVar.vo() ? 1 : 0);
                    jSONObject2.put("retry_count", dlVar.oq());
                    jSONObject2.put("cur_retry_time", dlVar.bw());
                    jSONObject2.put("need_retry_delay", dlVar.xo() ? 1 : 0);
                    jSONObject2.put("need_reuse_first_connection", dlVar.sd() ? 1 : 0);
                    jSONObject2.put("default_http_service_backup", dlVar.pf() ? 1 : 0);
                    jSONObject2.put("retry_delay_status", dlVar.fp().ordinal());
                    jSONObject2.put("backup_url_used", dlVar.t() ? 1 : 0);
                    jSONObject2.put("download_byte_error_retry_status", dlVar.yw().ordinal());
                    jSONObject2.put("forbidden_handler_status", dlVar.vt().ordinal());
                    jSONObject2.put("need_independent_process", dlVar.tf() ? 1 : 0);
                    jSONObject2.put("head_connection_error_msg", dlVar.dl() != null ? dlVar.dl() : "");
                    jSONObject2.put("extra", dlVar.gk() != null ? dlVar.gk() : "");
                    if (!dlVar.zz()) {
                        i2 = 0;
                    }
                    jSONObject2.put("add_listener_to_same_task", i2);
                    jSONObject2.put("backup_url_count", dlVar.mj() != null ? dlVar.mj().size() : 0);
                    jSONObject2.put("cur_backup_url_index", dlVar.mj() != null ? dlVar.js() : -1);
                    jSONObject2.put("forbidden_urls", dlVar.j() != null ? dlVar.j().toString() : "");
                    jSONObject2.put("task_id", TextUtils.isEmpty(dlVar.te()) ? "" : dlVar.te());
                    try {
                        String strUy = dlVar.uy();
                        if (TextUtils.isEmpty(strUy)) {
                            lastPathSegment = "";
                            host = lastPathSegment;
                            path = host;
                        } else {
                            Uri uri = Uri.parse(strUy);
                            host = uri.getHost();
                            path = uri.getPath();
                            lastPathSegment = uri.getLastPathSegment();
                            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                                try {
                                    path = path.substring(0, path.length() - lastPathSegment.length());
                                } catch (Throwable th) {
                                    wp.z(th);
                                }
                            }
                        }
                        jSONObject2.put("url_host", host);
                        jSONObject2.put("url_path", path);
                        jSONObject2.put("url_last_path_segment", lastPathSegment);
                    } catch (Throwable th2) {
                        wp.z(th2);
                    }
                }
                jSONObject2.put("error_code", zVar != null ? zVar.z() : 0);
                jSONObject2.put("error_msg", zVar != null ? zVar.g() : "");
                jSONObject2.put("request_log", strA);
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                wp.z(e);
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003c A[PHI: r8
  0x003c: PHI (r8v8 int) = (r8v0 int), (r8v2 int) binds: [B:12:0x0023, B:19:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void z(com.ss.android.socialbase.downloader.fo.e r13, java.lang.String r14, java.lang.String r15, long r16, java.lang.String r18, int r19, java.io.IOException r20, com.ss.android.socialbase.downloader.e.dl r21) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.gz.z.z(com.ss.android.socialbase.downloader.fo.e, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.e.dl):void");
    }

    public static void z(com.ss.android.socialbase.downloader.i.z zVar, com.ss.android.socialbase.downloader.e.dl dlVar, String str, fo foVar, boolean z, boolean z2, com.ss.android.socialbase.downloader.gc.z zVar2, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        z("download_io", zVar.g("monitor_download_io"), zVar, dlVar, str, null, null, foVar, z, z2, zVar2, j, j2, z3, j3, j4, j5, null);
    }

    public static void z(com.ss.android.socialbase.downloader.i.z zVar, com.ss.android.socialbase.downloader.e.dl dlVar, String str, String str2, String str3, boolean z, fo foVar, com.ss.android.socialbase.downloader.gc.z zVar2, long j, long j2) {
        z("segment_io", zVar.g("monitor_segment_io"), zVar, dlVar, str, str2, str3, foVar, z, false, zVar2, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.socialbase.downloader.gz.dl] */
    /* JADX WARN: Type inference failed for: r14v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    private static void z(String str, int i, com.ss.android.socialbase.downloader.i.z zVar, com.ss.android.socialbase.downloader.e.dl dlVar, String str2, String str3, String str4, fo foVar, boolean z, boolean z2, com.ss.android.socialbase.downloader.gc.z zVar2, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        String strG;
        int iZ;
        String strM;
        int i2;
        ?? r2;
        int i3;
        if (i <= 0 || j2 <= 0) {
            return;
        }
        try {
            Uri uri = Uri.parse(str2);
            String host = uri.getHost();
            String path = uri.getPath();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            if (z) {
                strG = null;
                iZ = 1;
            } else if (z2) {
                strG = null;
                iZ = 2;
            } else if (zVar2 != null) {
                iZ = !com.ss.android.socialbase.downloader.pf.m.dl(com.ss.android.socialbase.downloader.downloader.dl.xl()) ? 1049 : zVar2.z();
                strG = zVar2.g();
            } else {
                strG = null;
                iZ = 0;
            }
            ?? jSONObject2 = new JSONObject();
            strM = "";
            if (foVar != null) {
                i3 = foVar instanceof gc ? 0 : 1;
                String strZ = foVar.z("X-Cache");
                ?? Contains = TextUtils.isEmpty(strZ) ? -1 : strZ.toLowerCase().contains("hit");
                zVar.z("monitor_sla", 1);
                strM = foVar instanceof com.ss.android.socialbase.downloader.fo.z ? ((com.ss.android.socialbase.downloader.fo.z) foVar).m() : "";
                i2 = iZ;
                r2 = Contains;
            } else {
                i2 = iZ;
                r2 = -1;
                i3 = -1;
            }
            double d = j / 1048576.0d;
            double d2 = j2;
            double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject2.put("setting_tag", zVar.dl("setting_tag"));
            jSONObject2.put("url_host", host);
            jSONObject2.putOpt("host_ip", str3);
            jSONObject2.putOpt("host_real_ip", str4);
            jSONObject2.put("url_path", path);
            jSONObject2.put("url_last_path_segment", lastPathSegment);
            jSONObject2.put("net_lib", i3);
            jSONObject2.put("hit_cdn_cache", r2);
            jSONObject2.put("status_code", i2);
            jSONObject2.put("request_log", strM);
            if (strG != null) {
                jSONObject2.put("error_msg", com.ss.android.socialbase.downloader.pf.m.z(strG, zVar.z("exception_msg_length", 500)));
            }
            jSONObject2.put("download_sec", nanos);
            jSONObject2.put("download_mb", d);
            if (nanos > 0.0d) {
                jSONObject2.put("download_speed", d / nanos);
            }
            if (z3) {
                jSONObject2.put("rw_read_time", j3 / d2);
                jSONObject2.put("rw_write_time", j4 / d2);
                jSONObject2.put("rw_sync_time", j5 / d2);
            }
            jSONObject2.put("pkg_name", dlVar.x());
            jSONObject2.put("name", dlVar.fo());
            if (i == 1 || i == 3) {
                com.ss.android.socialbase.downloader.downloader.dl.m();
            }
            if (i == 2 || i == 3) {
                com.ss.android.socialbase.downloader.downloader.dl.gp().z(dlVar.e(), str, jSONObject2);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public static void z(com.ss.android.socialbase.downloader.e.dl dlVar, List<com.ss.android.socialbase.downloader.kb.fo> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.kb.fo.z(list));
            jSONObject.put("cur_bytes", dlVar.sf());
            jSONObject.put("total_bytes", dlVar.s());
            dl dlVarGp = com.ss.android.socialbase.downloader.downloader.dl.gp();
            if (dlVarGp != null) {
                dlVarGp.z(dlVar.e(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }
}
