package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import com.ss.android.downloadlib.e.v;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class z implements v.z {
    private static z g = null;
    private static final String z = "z";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1997a;
    private com.ss.android.downloadlib.e.v dl = new com.ss.android.downloadlib.e.v(Looper.getMainLooper(), this);

    public static z z() {
        if (g == null) {
            synchronized (z.class) {
                if (g == null) {
                    g = new z();
                }
            }
        }
        return g;
    }

    private z() {
    }

    public void z(com.ss.android.socialbase.downloader.e.dl dlVar, long j, long j2, String str, String str2, String str3, String str4) {
        int i;
        com.ss.android.downloadlib.addownload.g.z zVar = new com.ss.android.downloadlib.addownload.g.z(dlVar.e(), j, j2, str, str2, str3, str4);
        if (com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.m.gc.i() || com.ss.android.socialbase.appdownloader.m.gc.v()) && com.ss.android.socialbase.downloader.pf.uy.z(wp.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
            if (com.ss.android.socialbase.downloader.pf.m.z(dlVar.rg().get("extra_silent_install_succeed"), false)) {
                Message messageObtainMessage = this.dl.obtainMessage(200, zVar);
                messageObtainMessage.arg1 = 2;
                this.dl.sendMessageDelayed(messageObtainMessage, r1.z("check_silent_install_interval", 60000));
                return;
            }
            com.ss.android.g.z.g.g gVarA = com.ss.android.downloadlib.addownload.g.m.z().a(zVar.g);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                i = 5;
            } catch (Exception unused) {
                i = -1;
            }
            wp.m().z(null, new com.ss.android.socialbase.downloader.gc.z(i, jSONObject.toString()), i);
            com.ss.android.downloadlib.a.z.z().z("embeded_ad", "ah_result", jSONObject, gVarA);
        }
        if (com.ss.android.downloadlib.e.gc.dl()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f1997a;
            long jA = com.ss.android.downloadlib.e.gc.a();
            if (jCurrentTimeMillis < com.ss.android.downloadlib.e.gc.gc()) {
                long jGc = com.ss.android.downloadlib.e.gc.gc() - jCurrentTimeMillis;
                jA += jGc;
                this.f1997a = System.currentTimeMillis() + jGc;
            } else {
                this.f1997a = System.currentTimeMillis();
            }
            com.ss.android.downloadlib.e.v vVar = this.dl;
            vVar.sendMessageDelayed(vVar.obtainMessage(200, zVar), jA);
        }
    }

    private void z(com.ss.android.downloadlib.addownload.g.z zVar, int i) {
        int i2;
        if (wp.wp() == null || wp.wp().z() || zVar == null) {
            return;
        }
        if (2 == i) {
            com.ss.android.g.z.g.g gVarA = com.ss.android.downloadlib.addownload.g.m.z().a(zVar.g);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.e.i.gc(wp.getContext(), zVar.f1989a)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i2 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i2 = 5;
                }
            } catch (Exception unused) {
                i2 = -1;
            }
            wp.m().z(null, new com.ss.android.socialbase.downloader.gc.z(i2, jSONObject.toString()), i2);
            com.ss.android.downloadlib.a.z.z().z("embeded_ad", "ah_result", jSONObject, gVarA);
        }
        if (com.ss.android.downloadlib.e.i.gc(wp.getContext(), zVar.f1989a)) {
            com.ss.android.downloadlib.a.z.z().g("delayinstall_installed", zVar.g);
            return;
        }
        if (!com.ss.android.downloadlib.e.i.z(zVar.e)) {
            com.ss.android.downloadlib.a.z.z().g("delayinstall_file_lost", zVar.g);
        } else if (com.ss.android.downloadlib.addownload.z.z.z().z(zVar.f1989a)) {
            com.ss.android.downloadlib.a.z.z().g("delayinstall_conflict_with_back_dialog", zVar.g);
        } else {
            com.ss.android.downloadlib.a.z.z().g("delayinstall_install_start", zVar.g);
            com.ss.android.socialbase.appdownloader.a.z(wp.getContext(), (int) zVar.z);
        }
    }

    @Override // com.ss.android.downloadlib.e.v.z
    public void z(Message message) {
        if (message.what != 200) {
            return;
        }
        z((com.ss.android.downloadlib.addownload.g.z) message.obj, message.arg1);
    }
}
