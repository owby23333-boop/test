package com.ss.android.downloadlib.addownload;

import android.os.Handler;
import com.ss.android.downloadlib.addownload.gc;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private com.ss.android.downloadlib.addownload.g.gc g;
    private Handler z;
    private AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f1967a = new AtomicBoolean(false);

    a(Handler handler) {
        this.z = handler;
    }

    public void z(com.ss.android.downloadlib.addownload.g.gc gcVar) {
        this.g = gcVar;
    }

    public boolean z() {
        return this.f1967a.get();
    }

    public void z(boolean z) {
        this.f1967a.set(z);
    }

    void z(final int i, final long j, long j2, final gc.z zVar) {
        this.f1967a.set(false);
        if (zVar == null) {
            return;
        }
        if (!com.ss.android.downloadlib.e.gc.m(i) || !com.ss.android.downloadlib.e.gc.gc(i)) {
            zVar.z();
            return;
        }
        long jDl = com.ss.android.downloadlib.e.gc.dl(i);
        this.dl.set(false);
        final String strZ = this.g.g.z();
        com.ss.android.g.z.g.g gVarG = com.ss.android.downloadlib.addownload.g.m.z().g(strZ);
        if (gVarG == null) {
            gVarG = new com.ss.android.g.z.g.g(this.g.g, this.g.dl, this.g.f1987a, 0);
            com.ss.android.downloadlib.addownload.g.m.z().z(gVarG);
        }
        final com.ss.android.g.z.g.g gVar = gVarG;
        gVar.gc(false);
        if (wp.i() != null) {
            wp.i();
        }
        com.ss.android.downloadlib.addownload.dl.a.z().z(gVar.z());
        boolean zA = com.ss.android.downloadlib.e.gc.a(i);
        if (j2 > 0) {
            z(i, strZ, j2, gVar, j, zVar);
        } else if (zA) {
            z(strZ, gVar, new gc.g() { // from class: com.ss.android.downloadlib.addownload.a.1
                @Override // com.ss.android.downloadlib.addownload.gc.g
                public void z(long j3) throws Throwable {
                    a.this.z(i, strZ, j3, gVar, j, zVar);
                }
            });
        } else {
            jDl = 0;
        }
        this.z.postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dl.get()) {
                    return;
                }
                a.this.dl.set(true);
                zVar.z();
            }
        }, jDl);
    }

    private void z(String str, com.ss.android.g.z.g.g gVar, final gc.g gVar2) {
        if (gVar2 == null) {
            return;
        }
        com.ss.android.socialbase.downloader.fo.z.g.z(str, new com.ss.android.socialbase.downloader.fo.kb() { // from class: com.ss.android.downloadlib.addownload.a.3
            @Override // com.ss.android.socialbase.downloader.fo.kb
            public void z(Map<String, String> map) {
                if (a.this.dl.get()) {
                    return;
                }
                a.this.dl.set(true);
                long jZ = a.this.z(map);
                if (jZ > 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("apk_size", Long.valueOf(jZ));
                        jSONObject.putOpt("available_space", Long.valueOf(a.a()));
                    } catch (JSONException e) {
                        com.bytedance.sdk.component.utils.wp.z(e);
                    }
                }
                gVar2.z(jZ);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long z(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if ("content-length".equalsIgnoreCase(key)) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str, long j, final com.ss.android.g.z.g.g gVar, long j2, final gc.z zVar) throws Throwable {
        this.dl.set(true);
        boolean z = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j));
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            long jLongValue = (Double.valueOf((com.ss.android.downloadlib.e.gc.z(i) + 1.0d) * j).longValue() + com.ss.android.downloadlib.e.gc.g(i)) - j2;
            long jA = a();
            if (jA < jLongValue) {
                z(gVar, jSONObject, jLongValue, jA);
                z(gVar);
                long jA2 = a();
                if (jA2 < jLongValue) {
                    gVar.a(true);
                    final String strZ = gVar.z();
                    com.ss.android.downloadlib.addownload.dl.a.z().z(strZ, new com.ss.android.downloadlib.addownload.dl.gc() { // from class: com.ss.android.downloadlib.addownload.a.4
                    });
                    z = z(i, gVar, str, jLongValue);
                    if (z) {
                        gVar.gc(true);
                    }
                } else {
                    g(gVar, jSONObject, jA, jA2);
                }
            }
        }
        if (z) {
            return;
        }
        this.z.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.5
            @Override // java.lang.Runnable
            public void run() {
                zVar.z();
            }
        });
    }

    private boolean z(int i, com.ss.android.g.z.g.g gVar, String str, long j) {
        if (!com.ss.android.downloadlib.e.gc.m(i)) {
            return false;
        }
        if (wp.i() != null) {
            return wp.i().z(i, str, true, j);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_dialog_result", 3);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().z("cleanspace_window_show", jSONObject, gVar);
        return false;
    }

    public static boolean z(final com.ss.android.socialbase.downloader.e.dl dlVar, long j) {
        int iE = dlVar.e();
        boolean z = false;
        if (!com.ss.android.downloadlib.e.gc.m(iE)) {
            return false;
        }
        if (wp.i() != null && (z = wp.i().z(iE, dlVar.uy(), false, j))) {
            com.ss.android.downloadlib.addownload.dl.a.z().z(dlVar.uy(), new com.ss.android.downloadlib.addownload.dl.gc() { // from class: com.ss.android.downloadlib.addownload.a.6
            });
        }
        return z;
    }

    public static JSONObject z(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }

    public static void z(int i) {
        if (com.ss.android.downloadlib.e.gc.m(i) && wp.i() != null && wp.i().g()) {
            wp.i();
        }
    }

    public static long g() {
        if (wp.i() != null) {
            return wp.i().z();
        }
        return 0L;
    }

    private static void z(com.ss.android.g.z.g.g gVar) throws Throwable {
        long jA = a();
        if (wp.i() != null) {
            wp.i();
        }
        com.ss.android.downloadlib.addownload.dl.dl.z();
        com.ss.android.downloadlib.addownload.dl.dl.g();
        if (com.ss.android.downloadlib.e.gc.e(gVar.js())) {
            com.ss.android.downloadlib.addownload.dl.dl.z(wp.getContext());
        }
        long jA2 = a();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(jA2 - jA));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().z("clean_quite_finish", jSONObject, gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long a() {
        return com.ss.android.downloadlib.e.i.g(0L);
    }

    private void z(com.ss.android.g.z.g.g gVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().z("clean_space_no_enough_for_download", jSONObject, gVar);
    }

    private void g(com.ss.android.g.z.g.g gVar, JSONObject jSONObject, long j, long j2) {
        gVar.wp("1");
        com.ss.android.downloadlib.addownload.g.fo.z().z(gVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.downloadlib.a.z.z().z("cleanspace_download_after_quite_clean", jSONObject, gVar);
    }
}
