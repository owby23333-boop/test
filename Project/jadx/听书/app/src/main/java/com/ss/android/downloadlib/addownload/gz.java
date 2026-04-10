package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.downloadlib.e.uy;
import com.ss.android.downloadlib.e.v;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.z.z.g.zw;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gz implements v.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gc f1993a;
    private boolean dl = false;
    private long g;
    private g gc;
    public com.ss.android.downloadlib.addownload.g.gc z;

    public interface g {
        void z(com.ss.android.socialbase.downloader.e.dl dlVar);
    }

    @Override // com.ss.android.downloadlib.e.v.z
    public void z(Message message) {
    }

    public gz(gc gcVar) {
        this.f1993a = gcVar;
    }

    public void z(long j) {
        this.g = j;
        com.ss.android.downloadlib.addownload.g.gc gcVarGc = com.ss.android.downloadlib.addownload.g.m.z().gc(j);
        this.z = gcVarGc;
        if (gcVarGc.io()) {
            com.ss.android.downloadlib.gc.dl.z().z("setAdId ModelBox notValid");
        }
    }

    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        this.dl = false;
        g(dlVar);
    }

    public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        g gVar = this.gc;
        if (gVar != null) {
            gVar.z(dlVar);
            this.gc = null;
        }
    }

    boolean z(Context context, int i, boolean z2) {
        if (com.ss.android.downloadlib.e.i.z(this.z.g)) {
            com.ss.android.g.z.g.g gVarA = com.ss.android.downloadlib.addownload.g.m.z().a(this.z.z);
            if (gVarA != null) {
                com.ss.android.socialbase.downloader.notification.g.z().m(gVarA.js());
            }
            return com.ss.android.downloadlib.g.z.z(this.z);
        }
        if (z(i) && !TextUtils.isEmpty(this.z.g.sy()) && wp.fo().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.g.z.z(this.z, i)) {
                return true;
            }
            return this.f1993a.fo() && this.f1993a.a(true);
        }
        if (!z2 || this.z.f1987a.g() != 4 || this.f1993a.gc()) {
            return false;
        }
        this.f1993a.dl(true);
        return true;
    }

    public boolean z(int i) {
        if (this.z.f1987a.g() == 2 && i == 2) {
            return true;
        }
        return this.z.f1987a.g() == 2 && i == 1 && wp.fo().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean z(int i, com.ss.android.z.z.dl.dl dlVar) {
        return com.ss.android.socialbase.appdownloader.m.gc.dl() && z(i) && !com.ss.android.downloadlib.e.i.z(dlVar);
    }

    boolean z(boolean z2) {
        return !z2 && this.z.f1987a.g() == 1;
    }

    private boolean dl() {
        return a() && gc();
    }

    private boolean a() {
        return (this.z.g == null || TextUtils.isEmpty(this.z.g.sy()) || TextUtils.isEmpty(this.z.g.z())) ? false : true;
    }

    private boolean gc() {
        return this.z.f1987a.a();
    }

    void z(final zw zwVar) {
        if (!TextUtils.isEmpty(this.z.g.pf())) {
            String strPf = this.z.g.pf();
            if (strPf.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                zwVar.z();
                return;
            }
            try {
                String parent = wp.getContext().getExternalCacheDir().getParent();
                if (parent.endsWith("/cache")) {
                    parent = parent.substring(0, parent.indexOf("/cache"));
                }
                if (strPf.startsWith(parent)) {
                    zwVar.z();
                    return;
                }
            } catch (Exception unused) {
            }
        }
        g(new zw() { // from class: com.ss.android.downloadlib.addownload.gz.1
            @Override // com.ss.android.z.z.g.zw
            public void z() {
                zwVar.z();
            }

            @Override // com.ss.android.z.z.g.zw
            public void z(String str) {
                wp.dl().z(1, wp.getContext(), gz.this.z.g, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.a.z.z().g(gz.this.g, 1);
                zwVar.z(str);
            }
        });
    }

    private void g(final zw zwVar) {
        String str;
        if (com.ss.android.downloadlib.e.uy.g(com.kuaishou.weapon.p0.g.j)) {
            if (zwVar != null) {
                zwVar.z();
                return;
            }
            return;
        }
        if (com.ss.android.downloadlib.e.i.z()) {
            str = "android.permission.READ_MEDIA_IMAGES";
            if (com.ss.android.downloadlib.e.uy.g("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.e.uy.g("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.e.uy.g("android.permission.READ_MEDIA_VIDEO")) {
                if (zwVar != null) {
                    zwVar.z();
                    return;
                }
                return;
            }
        } else {
            str = com.kuaishou.weapon.p0.g.i;
        }
        com.ss.android.downloadlib.e.uy.z(new String[]{str}, new uy.z() { // from class: com.ss.android.downloadlib.addownload.gz.2
            @Override // com.ss.android.downloadlib.e.uy.z
            public void z() {
                zw zwVar2 = zwVar;
                if (zwVar2 != null) {
                    zwVar2.z();
                }
            }

            @Override // com.ss.android.downloadlib.e.uy.z
            public void z(String str2) {
                zw zwVar2 = zwVar;
                if (zwVar2 != null) {
                    zwVar2.z(str2);
                }
            }
        });
    }

    void z(Message message, com.ss.android.z.z.gc.gc gcVar, Map<Integer, Object> map) {
        g gVar;
        if (message == null || message.what != 3) {
            return;
        }
        com.ss.android.socialbase.downloader.e.dl dlVar = (com.ss.android.socialbase.downloader.e.dl) message.obj;
        if (message.arg1 != 1 && message.arg1 != 6 && message.arg1 == 2) {
            if (dlVar.by()) {
                com.ss.android.downloadlib.gz.z().z(this.z.g, this.z.f1987a, this.z.dl);
                dlVar.fo(false);
            }
            com.ss.android.downloadlib.a.z.z().z(dlVar);
        }
        gcVar.z(dlVar);
        uy.z(gcVar);
        int iZ = com.ss.android.socialbase.appdownloader.dl.z(dlVar.p());
        long jS = dlVar.s();
        int iSf = jS > 0 ? (int) ((dlVar.sf() * 100) / jS) : 0;
        if ((jS > 0 || com.ss.android.socialbase.downloader.i.z.dl().z("fix_click_start")) && (gVar = this.gc) != null) {
            gVar.z(dlVar);
            this.gc = null;
        }
        for (com.ss.android.z.z.dl.a aVar : z(map)) {
            if (iZ != 1) {
                if (iZ == 2) {
                    aVar.onDownloadPaused(gcVar, uy.z(dlVar.e(), iSf));
                } else if (iZ == 3) {
                    if (dlVar.p() == -4) {
                        aVar.z();
                    } else if (dlVar.p() == -1) {
                        aVar.onDownloadFailed(gcVar);
                    } else if (dlVar.p() == -3) {
                        if (com.ss.android.downloadlib.e.i.z(this.z.g)) {
                            aVar.onInstalled(gcVar);
                        } else {
                            aVar.onDownloadFinished(gcVar);
                        }
                    }
                }
            } else if (dlVar.p() != 11) {
                aVar.onDownloadActive(gcVar, uy.z(dlVar.e(), iSf));
            } else {
                Iterator<com.ss.android.z.z.dl.gc> it = g(map).iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }

    void dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (!fo.z(this.z.g) || this.dl) {
            return;
        }
        com.ss.android.downloadlib.a.z.z().z("file_status", (dlVar == null || !com.ss.android.downloadlib.e.i.g(dlVar.v())) ? 2 : 1, this.z);
        this.dl = true;
    }

    void z() {
        if (this.gc == null) {
            this.gc = new g() { // from class: com.ss.android.downloadlib.addownload.gz.3
                @Override // com.ss.android.downloadlib.addownload.gz.g
                public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
                    com.ss.android.downloadlib.a.z.z().z(gz.this.g, 2, dlVar);
                }
            };
        }
    }

    boolean a(com.ss.android.socialbase.downloader.e.dl dlVar) {
        return m() || gc(dlVar);
    }

    private boolean gc(com.ss.android.socialbase.downloader.e.dl dlVar) {
        return !com.ss.android.downloadlib.e.i.z(this.z.g) && m(dlVar);
    }

    private boolean m() {
        return com.ss.android.downloadlib.e.i.z(this.z.g) && fo.z(this.z.f1987a.z());
    }

    private boolean m(com.ss.android.socialbase.downloader.e.dl dlVar) {
        return dlVar != null && dlVar.p() == -3 && com.ss.android.socialbase.downloader.pf.m.a(dlVar.kb(), dlVar.gz());
    }

    int z(Context context, hh hhVar) {
        com.ss.android.downloadlib.addownload.dl.z zVar;
        com.ss.android.socialbase.downloader.e.gc gcVarZ;
        if (context == null) {
            return 0;
        }
        Map<String, String> mapUy = this.z.g.uy();
        ArrayList arrayList = new ArrayList();
        if (wp.fo().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.z.g.uf()) && (gcVarZ = z(this.z.g.uf())) != null) {
            arrayList.add(gcVarZ);
        }
        if (mapUy != null) {
            for (Map.Entry<String, String> entry : mapUy.entrySet()) {
                if (entry != null) {
                    arrayList.add(new com.ss.android.socialbase.downloader.e.gc(entry.getKey(), entry.getValue()));
                }
            }
        }
        String strZ = com.ss.android.downloadlib.e.a.z(String.valueOf(this.z.g.a()), this.z.g.dl(), this.z.g.kb(), String.valueOf(this.z.g.x()));
        com.ss.android.socialbase.downloader.i.z zVarG = com.ss.android.downloadlib.e.gc.g(this.z.g);
        JSONObject jSONObjectZ = com.ss.android.downloadlib.e.gc.z(this.z.g);
        if (!this.z.f1987a.pf()) {
            jSONObjectZ = com.ss.android.downloadlib.e.i.z(jSONObjectZ);
            com.ss.android.downloadlib.e.i.z(jSONObjectZ, "ah_plans", new JSONArray());
        }
        int iEo = this.z.g.eo();
        if (this.z.g.io() || fo.g(this.z.g)) {
            iEo = 4;
        }
        String strZ2 = z(zVarG);
        com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(com.ss.android.socialbase.downloader.downloader.dl.z(this.z.g.z(), strZ2));
        if (dlVarGz != null && 3 == this.z.g.x()) {
            dlVarGz.fo(true);
        }
        com.ss.android.socialbase.appdownloader.m mVarPf = new com.ss.android.socialbase.appdownloader.m(context, this.z.g.z()).g(this.z.g.g()).z(this.z.g.gz()).gc(strZ).z(arrayList).z(this.z.g.wp()).dl(this.z.g.i()).g(this.z.g.ls()).dl(strZ2).kb(this.z.g.hh()).gz(this.z.g.gc()).uy(this.z.g.na()).z(this.z.g.m()).z(hhVar).wp(this.z.g.q() || zVarG.z("need_independent_process", 0) == 1).z(this.z.g.un()).g(this.z.g.mc()).e(this.z.g.sy()).a(1000).gc(100).z(jSONObjectZ).fo(true).uy(true).g(zVarG.z("retry_count", 5)).dl(zVarG.z("backup_url_retry_count", 0)).uy(true).i(zVarG.z("need_head_connection", 0) == 1).a(zVarG.z("need_https_to_http_retry", 0) == 1).gz(zVarG.z("need_chunk_downgrade_retry", 1) == 1).e(zVarG.z("need_retry_delay", 0) == 1).fo(zVarG.dl("retry_delay_time_array")).kb(zVarG.z("need_reuse_runnable", 0) == 1).m(iEo).ls(this.z.g.xl()).pf(this.z.g.j());
        if (!TextUtils.isEmpty(this.z.g.fo())) {
            mVarPf.m(this.z.g.fo());
        } else {
            mVarPf.m("application/vnd.android.package-archive");
        }
        if (zVarG.z("notification_opt_2", 0) == 1) {
            mVarPf.z(false);
            mVarPf.g(true);
        }
        if (zVarG.z("clear_space_use_disk_handler", 0) == 1) {
            zVar = new com.ss.android.downloadlib.addownload.dl.z();
            mVarPf.z(zVar);
        } else {
            zVar = null;
        }
        if ((this.z.g instanceof com.ss.android.g.z.z.dl) && !TextUtils.isEmpty(((com.ss.android.g.z.z.dl) this.z.g).t())) {
            mVarPf.a(((com.ss.android.g.z.z.dl) this.z.g).t());
        }
        int iZ = fo.z(this.z, dl(), mVarPf);
        if (zVar != null) {
            zVar.z(iZ);
        }
        return iZ;
    }

    private String z(com.ss.android.socialbase.downloader.i.z zVar) {
        boolean zG;
        String strG;
        if (!TextUtils.isEmpty(this.z.g.pf())) {
            return this.z.g.pf();
        }
        com.ss.android.socialbase.downloader.e.dl dlVarZ = com.ss.android.socialbase.appdownloader.a.kb().z(wp.getContext(), this.z.g.z());
        if (!com.ss.android.downloadlib.e.i.z()) {
            zG = com.ss.android.downloadlib.e.uy.g(com.kuaishou.weapon.p0.g.j);
        } else {
            zG = com.ss.android.downloadlib.e.uy.g("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.e.uy.g("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.e.uy.g("android.permission.READ_MEDIA_VIDEO");
        }
        String strG2 = g();
        if (dlVarZ != null && !TextUtils.isEmpty(dlVarZ.kb())) {
            String strKb = dlVarZ.kb();
            if (zG || strKb.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return strKb;
            }
            try {
                if (!TextUtils.isEmpty(strG2)) {
                    if (strKb.startsWith(strG2)) {
                        return strKb;
                    }
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).g(dlVarZ.e());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(zG ? 1 : 2));
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        com.ss.android.downloadlib.a.z.z().z("label_external_permission", jSONObject, this.z);
        try {
            strG = com.ss.android.socialbase.appdownloader.dl.g();
        } catch (Exception unused) {
            strG = null;
        }
        int iZ = com.ss.android.downloadlib.e.gc.z(zVar);
        if (iZ != 0) {
            if (iZ == 4 || (!zG && iZ == 2)) {
                File filesDir = wp.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            } else if ((iZ == 3 || (!zG && iZ == 1)) && !TextUtils.isEmpty(strG2)) {
                return strG2;
            }
        }
        return strG;
    }

    public String g() {
        File externalFilesDir = wp.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    void z(com.ss.android.socialbase.downloader.e.dl dlVar, boolean z2) {
        if (this.z.g == null || dlVar == null || dlVar.e() == 0) {
            return;
        }
        int iP = dlVar.p();
        if (iP == -1 || iP == -4 || fo.z(this.z.g) || (z2 && com.ss.android.downloadlib.a.dl.z().dl() && (iP == -2 || iP == -3))) {
            com.ss.android.downloadlib.a.z.z().z(this.g, 2);
        }
        switch (iP) {
            case -4:
            case -1:
                z();
                com.ss.android.downloadlib.addownload.g.m.z().z(new com.ss.android.g.z.g.g(this.z.g, this.z.dl, this.z.f1987a, dlVar.e()));
                break;
            case -3:
                if (com.ss.android.downloadlib.e.i.z(this.z.g)) {
                    com.ss.android.downloadlib.gc.dl.z().g("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.ss.android.downloadlib.a.z.z().z(this.g, 5, dlVar);
                    if (z2 && com.ss.android.downloadlib.a.dl.z().g() && !com.ss.android.downloadlib.a.dl.z().g(this.g, this.z.g.uf())) {
                        com.ss.android.downloadlib.a.z.z().z(this.g, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.ss.android.downloadlib.a.z.z().z(this.g, 4, dlVar);
                if (z2 && com.ss.android.downloadlib.a.dl.z().g() && !com.ss.android.downloadlib.a.dl.z().g(this.g, this.z.g.uf())) {
                    com.ss.android.downloadlib.a.z.z().z(this.g, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.a.z.z().z(this.g, 3, dlVar);
                break;
        }
    }

    void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.z.z.gc.gc gcVar, List<com.ss.android.z.z.dl.a> list, boolean z2) {
        if (list.isEmpty()) {
            return;
        }
        if (dlVar == null || gcVar == null) {
            Iterator<com.ss.android.z.z.dl.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().z();
            }
            return;
        }
        try {
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        int iSf = dlVar.s() > 0 ? (int) ((dlVar.sf() * 100) / dlVar.s()) : 0;
        int i = iSf >= 0 ? iSf : 0;
        gcVar.z(dlVar);
        uy.z(gcVar);
        for (com.ss.android.z.z.dl.a aVar : list) {
            switch (dlVar.p()) {
                case -4:
                case 0:
                    if (com.ss.android.downloadlib.e.i.z(this.z.g)) {
                        gcVar.g = -3;
                        aVar.onInstalled(gcVar);
                    } else {
                        aVar.z();
                    }
                    break;
                case -3:
                    if (z2) {
                        aVar.onInstalled(gcVar);
                    } else {
                        aVar.onDownloadFinished(gcVar);
                    }
                    break;
                case -2:
                    aVar.onDownloadPaused(gcVar, uy.z(dlVar.e(), i));
                    break;
                case -1:
                    aVar.onDownloadFailed(gcVar);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    aVar.onDownloadActive(gcVar, uy.z(dlVar.e(), i));
                    break;
                case 11:
                    if (!(aVar instanceof com.ss.android.z.z.dl.gc)) {
                        aVar.onDownloadActive(gcVar, uy.z(dlVar.e(), i));
                    }
                    break;
            }
        }
    }

    static class z extends com.ss.android.socialbase.downloader.a.z {
        private com.ss.android.downloadlib.e.v z;

        z(com.ss.android.downloadlib.e.v vVar) {
            this.z = vVar;
        }

        @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
        public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
            z(dlVar, 1);
        }

        @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
        public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
            z(dlVar, 2);
        }

        @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
        public void dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
            z(dlVar, 4);
        }

        @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
        public void a(com.ss.android.socialbase.downloader.e.dl dlVar) {
            z(dlVar, -2);
        }

        @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
        public void gc(com.ss.android.socialbase.downloader.e.dl dlVar) {
            z(dlVar, -3);
        }

        @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
        public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
            z(dlVar, -1);
        }

        @Override // com.ss.android.socialbase.downloader.a.dl, com.ss.android.socialbase.downloader.a.hh
        public void m(com.ss.android.socialbase.downloader.e.dl dlVar) {
            z(dlVar, -4);
        }

        @Override // com.ss.android.socialbase.downloader.a.z, com.ss.android.socialbase.downloader.a.tb
        public void e(com.ss.android.socialbase.downloader.e.dl dlVar) {
            z(dlVar, 11);
        }

        private void z(com.ss.android.socialbase.downloader.e.dl dlVar, int i) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = dlVar;
            messageObtain.arg1 = i;
            this.z.sendMessage(messageObtain);
        }
    }

    public static List<com.ss.android.z.z.dl.a> z(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.z.z.dl.a) {
                    arrayList.add((com.ss.android.z.z.dl.a) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.z.z.dl.a) {
                            arrayList.add((com.ss.android.z.z.dl.a) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.z.z.dl.a) {
                            arrayList.add((com.ss.android.z.z.dl.a) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<com.ss.android.z.z.dl.gc> g(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.z.z.dl.gc) {
                    arrayList.add((com.ss.android.z.z.dl.gc) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.z.z.dl.gc) {
                            arrayList.add((com.ss.android.z.z.dl.gc) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.z.z.dl.gc) {
                            arrayList.add((com.ss.android.z.z.dl.gc) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private com.ss.android.socialbase.downloader.e.gc z(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new com.ss.android.socialbase.downloader.e.gc("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e) {
            wp.tb().z(e, "parseLogExtra Error");
            return null;
        }
    }
}
