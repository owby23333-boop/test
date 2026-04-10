package com.ss.android.socialbase.appdownloader;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.utils.wp;
import com.funny.audio.core.utils.FileUtils;
import com.ss.android.socialbase.appdownloader.dl.kb;
import com.ss.android.socialbase.appdownloader.dl.ls;
import com.ss.android.socialbase.appdownloader.dl.v;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.a.lq;
import com.ss.android.socialbase.downloader.a.pf;
import com.ss.android.socialbase.downloader.a.ti;
import com.ss.android.socialbase.downloader.downloader.js;
import com.ss.android.socialbase.downloader.impls.fv;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static boolean e = false;
    private static volatile a g = null;
    private static boolean gz = false;
    private static boolean m = false;
    private static final String z = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2028a;
    private String dl;
    private Future fo;
    private com.ss.android.socialbase.appdownloader.dl.e fv;
    private com.ss.android.socialbase.appdownloader.dl.a i;
    private ls iq;
    private kb js;
    private com.ss.android.socialbase.appdownloader.dl.gz ls;
    private v p;
    private com.ss.android.socialbase.appdownloader.dl.fo pf;
    private ti q;
    private lq tb;
    private int uy;
    private com.ss.android.socialbase.appdownloader.dl.gc v;
    private com.ss.android.socialbase.appdownloader.dl.dl zw;
    private DownloadReceiver gc = new DownloadReceiver();
    private boolean kb = false;
    private boolean wp = false;

    public com.ss.android.socialbase.appdownloader.dl.dl z() {
        return this.zw;
    }

    public void z(com.ss.android.socialbase.appdownloader.dl.dl dlVar) {
        this.zw = dlVar;
    }

    public com.ss.android.socialbase.appdownloader.dl.a g() {
        return this.i;
    }

    public com.ss.android.socialbase.appdownloader.dl.gc dl() {
        return this.v;
    }

    public com.ss.android.socialbase.appdownloader.dl.fo a() {
        return this.pf;
    }

    public void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f2028a = str;
    }

    public String gc() {
        return this.f2028a;
    }

    public com.ss.android.socialbase.appdownloader.dl.e m() {
        return this.fv;
    }

    public void z(com.ss.android.socialbase.appdownloader.dl.e eVar) {
        this.fv = eVar;
    }

    public boolean e() {
        return com.ss.android.socialbase.downloader.i.z.g().optInt("package_flag_config", 1) == 1;
    }

    public kb gz() {
        return this.js;
    }

    public void z(kb kbVar) {
        this.js = kbVar;
    }

    public File fo() {
        return com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).dl();
    }

    public String uy() {
        return this.dl;
    }

    private a() {
    }

    public static a kb() {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a();
                }
            }
        }
        return g;
    }

    @Deprecated
    public void z(Context context, String str, com.ss.android.socialbase.appdownloader.dl.a aVar, com.ss.android.socialbase.appdownloader.dl.gc gcVar, com.ss.android.socialbase.appdownloader.dl.fo foVar) {
        if (aVar != null) {
            this.i = aVar;
        }
        if (gcVar != null) {
            this.v = gcVar;
        }
        if (foVar != null) {
            this.pf = foVar;
        }
        dl(context);
    }

    private void dl(Context context) {
        if (context == null || m) {
            return;
        }
        com.ss.android.socialbase.downloader.g.gc.z("application/vnd.android.package-archive");
        com.ss.android.socialbase.downloader.downloader.dl.z(context);
        com.ss.android.socialbase.downloader.downloader.dl.z(new com.ss.android.socialbase.appdownloader.a.g());
        if (this.wp) {
            com.ss.android.socialbase.downloader.downloader.dl.z(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.tb();
                }
            }, 5L, TimeUnit.SECONDS);
        } else {
            tb();
        }
        q();
        m = true;
    }

    public void g(String str) {
        com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).gc(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb() {
        synchronized (this.gc) {
            if (e) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme(FileUtils.URI_TYPE_FILE);
                com.ss.android.socialbase.downloader.downloader.dl.xl().registerReceiver(this.gc, intentFilter);
                com.ss.android.socialbase.downloader.downloader.dl.xl().registerReceiver(this.gc, intentFilter2);
                e = true;
            } catch (Exception e2) {
                wp.z(e2);
            }
            com.ss.android.socialbase.downloader.m.z.g(z, "registerDownloadReceiver mIsRegistered:" + e);
        }
    }

    public void wp() {
        if (com.ss.android.socialbase.downloader.i.z.dl().z("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.m.z.g(z, "disable app install receiver");
            return;
        }
        synchronized (this.gc) {
            try {
                if (gz) {
                    return;
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme("package");
                    com.ss.android.socialbase.downloader.downloader.dl.xl().registerReceiver(this.gc, intentFilter);
                    gz = true;
                    ls lsVar = this.iq;
                    if (lsVar != null) {
                        lsVar.z();
                    }
                } catch (Throwable th) {
                    wp.z(th);
                }
                com.ss.android.socialbase.downloader.m.z.g(z, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + e);
            } finally {
                g(0);
            }
        }
    }

    private void g(int i) {
        this.uy = com.ss.android.socialbase.downloader.i.z.dl().z("app_install_keep_receiver_time_s", 60);
        com.ss.android.socialbase.downloader.m.z.g(z, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.uy);
        if (this.uy <= 0) {
            return;
        }
        if (i > 0) {
            this.uy = i;
        }
        Future future = this.fo;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        this.fo = com.ss.android.socialbase.downloader.downloader.dl.z(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.m.z.g(a.z, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                a.this.i();
                a.this.tb();
            }
        }, this.uy, TimeUnit.SECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0022 A[Catch: all -> 0x001c, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0014, B:10:0x0018, B:16:0x0022, B:17:0x0027, B:15:0x001f), top: B:22:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void i() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.DownloadReceiver r0 = r3.gc
            monitor-enter(r0)
            boolean r1 = com.ss.android.socialbase.appdownloader.a.e     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            android.content.Context r1 = com.ss.android.socialbase.downloader.downloader.dl.xl()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            com.ss.android.socialbase.appdownloader.DownloadReceiver r2 = r3.gc     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r1.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            boolean r1 = com.ss.android.socialbase.appdownloader.a.gz     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            com.ss.android.socialbase.appdownloader.dl.ls r1 = r3.iq     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            r1.g()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            goto L22
        L1c:
            r1 = move-exception
            goto L30
        L1e:
            r1 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r1)     // Catch: java.lang.Throwable -> L1c
        L22:
            r1 = 0
            com.ss.android.socialbase.appdownloader.a.e = r1     // Catch: java.lang.Throwable -> L1c
            com.ss.android.socialbase.appdownloader.a.gz = r1     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.a.z
            java.lang.String r1 = "registerDownloadReceiver unRegisterDownloadReceiver"
            com.ss.android.socialbase.downloader.m.z.g(r0, r1)
            return
        L30:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.a.i():void");
    }

    private void q() {
        fv.z(new fv.g() { // from class: com.ss.android.socialbase.appdownloader.a.3
            @Override // com.ss.android.socialbase.downloader.impls.fv.g
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar, long j, boolean z2, int i) {
                RetryJobSchedulerService.z(dlVar, j, z2, i);
            }
        });
    }

    public static boolean z(Context context, int i) {
        return dl.z(context, i, true) == 1;
    }

    public void z(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    com.ss.android.socialbase.downloader.downloader.e.g(context).gc(i);
                    break;
                case -3:
                    dl.z(context, i, true);
                    break;
                case -2:
                    com.ss.android.socialbase.downloader.downloader.e.g(context).dl(i);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    com.ss.android.socialbase.downloader.downloader.e.g(context).z(i);
                    break;
            }
        } catch (Exception e2) {
            wp.z(e2);
        }
    }

    public int z(m mVar) {
        boolean z2;
        int i;
        String str;
        String str2;
        int i2;
        JSONObject jSONObject;
        com.ss.android.socialbase.downloader.e.dl dlVarGz;
        if (mVar == null || mVar.getContext() == null) {
            return 0;
        }
        try {
            List<com.ss.android.socialbase.downloader.e.gc> listZ = z(mVar.a());
            String strZ = mVar.z();
            if (TextUtils.isEmpty(strZ)) {
                return 0;
            }
            final int iJs = mVar.js();
            final boolean z3 = iJs == 0;
            String strWj = mVar.wj();
            String strG = mVar.g();
            if (TextUtils.isEmpty(strWj)) {
                strWj = dl.z(strZ, strG, mVar.wp(), z3);
            }
            if (strWj.length() > 255) {
                strWj = strWj.substring(strWj.length() - 255);
            }
            if (TextUtils.isEmpty(strG)) {
                strG = strWj;
            }
            String strWp = mVar.wp();
            if (strWj.endsWith(".apk") && !dl.dl(mVar.wp())) {
                strWp = "application/vnd.android.package-archive";
            }
            String str3 = strWp;
            String strDl = mVar.dl();
            if (TextUtils.isEmpty(mVar.dl())) {
                strDl = dl.g();
            }
            String str4 = strDl;
            if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(strWj)) {
                String strY = mVar.y();
                if (TextUtils.isEmpty(strY)) {
                    strY = strZ;
                }
                int iZ = com.ss.android.socialbase.downloader.downloader.dl.z(strY, str4);
                if (com.ss.android.socialbase.downloader.i.z.z(mVar.rv()).z("resume_task_override_settings") && (dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).gz(iZ)) != null) {
                    try {
                        mVar.z(new JSONObject(dlVarGz.y()));
                    } catch (Throwable unused) {
                    }
                }
                com.ss.android.socialbase.downloader.i.z.z(iZ, mVar.rv());
                boolean zOq = mVar.oq();
                boolean z4 = (com.ss.android.socialbase.downloader.i.z.z(iZ).z("modify_force", 1) == 1 && !zOq && com.ss.android.socialbase.downloader.pf.m.a(str4, strWj) && com.ss.android.socialbase.downloader.downloader.e.g(mVar.getContext()).gz(iZ) == null) ? true : zOq;
                hh hhVarUy = mVar.uy();
                if (hhVarUy != null || (!mVar.gc() && !mVar.m())) {
                    z2 = z4;
                    i = iZ;
                    str = str4;
                    str2 = str3;
                } else if (mVar.v() != null) {
                    hhVarUy = new com.ss.android.socialbase.appdownloader.gc.g(mVar.v());
                    z2 = z4;
                    i = iZ;
                    str = str4;
                    str2 = str3;
                } else {
                    z2 = z4;
                    i = iZ;
                    str = str4;
                    str2 = str3;
                    hhVarUy = new com.ss.android.socialbase.appdownloader.gc.g(mVar.getContext(), iZ, strG, str4, strWj, mVar.kb());
                }
                pf pfVarXl = mVar.xl();
                if (pfVarXl == null) {
                    pfVarXl = new pf() { // from class: com.ss.android.socialbase.appdownloader.a.4
                        @Override // com.ss.android.socialbase.downloader.a.pf
                        public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, int i3) {
                            if (a.this.pf != null) {
                                a.this.pf.z(dlVar, zVar, i3);
                            }
                        }
                    };
                }
                List<com.ss.android.socialbase.downloader.a.v> listHh = com.ss.android.socialbase.downloader.downloader.dl.hh();
                if (!listHh.isEmpty()) {
                    Iterator<com.ss.android.socialbase.downloader.a.v> it = listHh.iterator();
                    while (it.hasNext()) {
                        mVar.z(it.next());
                    }
                }
                String strKb = mVar.kb();
                try {
                    if (!TextUtils.isEmpty(strKb)) {
                        jSONObject = new JSONObject(strKb);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("auto_install_with_notification", mVar.e());
                    jSONObject.put("auto_install_without_notification", mVar.m());
                    strKb = jSONObject.toString();
                } catch (Throwable unused2) {
                }
                boolean z5 = mVar.gc() || mVar.m();
                if (!z5 || com.ss.android.socialbase.downloader.i.z.z(i).g("enable_notification_ui") <= 0) {
                    i2 = i;
                } else {
                    i2 = i;
                    com.ss.android.socialbase.appdownloader.gc.dl.z().z(i2, mVar.zx());
                }
                final com.ss.android.socialbase.downloader.e.a aVarP = com.ss.android.socialbase.downloader.downloader.e.z(mVar.getContext()).dl(strZ).g(mVar.b()).z(strWj).g(strG).a(str).g(mVar.gz()).z(listZ).z(pfVarXl).z(mVar.zw()).g(mVar.io()).a(z5).gc(strKb).m(str2).a(mVar.gk()).dl(mVar.x()).z(mVar.fo()).g(hhVarUy).z(z(mVar.j())).dl(z2).m(mVar.p()).e(mVar.fv()).z(mVar.pf()).z(mVar.ls()).gc(mVar.i()).e(mVar.tb()).gz(mVar.q()).z(mVar.iq()).gz(mVar.uf()).fo(mVar.sy()).fo(mVar.hh()).uy(mVar.l()).wp(mVar.lq()).i(mVar.mc()).z(mVar.eo()).z(mVar.na()).z(mVar.h()).v(mVar.un()).z(mVar.gp()).z(mVar.lw()).kb(mVar.ti()).z(mVar.t()).z(mVar.rv()).uy(mVar.zx()).pf(mVar.jq()).wp(mVar.sv()).z(mVar.f()).gc(mVar.bv()).g(mVar.gb()).ls(mVar.yx()).kb(mVar.y()).p(mVar.qd());
                if (aVarP != null && !mVar.vm().isEmpty()) {
                    aVarP.dl(mVar.vm());
                }
                if (aVarP != null) {
                    if (z5 && mVar.ec() && mVar.getActivity() != null && !mVar.getActivity().isFinishing() && !com.ss.android.socialbase.appdownloader.gc.a.z()) {
                        final String str5 = strG;
                        com.ss.android.socialbase.appdownloader.gc.a.z(mVar.getActivity(), new com.ss.android.socialbase.appdownloader.dl.pf() { // from class: com.ss.android.socialbase.appdownloader.a.5
                            @Override // com.ss.android.socialbase.appdownloader.dl.pf
                            public void z() {
                                com.ss.android.socialbase.downloader.m.z.g(a.z, "notification permission granted, start download :" + str5);
                                a.this.z(aVarP, iJs, z3);
                            }

                            @Override // com.ss.android.socialbase.appdownloader.dl.pf
                            public void g() {
                                com.ss.android.socialbase.downloader.m.z.g(a.z, "notification permission denied, start download :" + str5);
                                a.this.z(aVarP, iJs, z3);
                            }
                        });
                    } else {
                        com.ss.android.socialbase.downloader.m.z.g(z, "notification permission need not request, start download :".concat(String.valueOf(strG)));
                        com.ss.android.socialbase.appdownloader.gc.a.z(i2);
                        z(aVarP, iJs, z3);
                        aVarP.z();
                    }
                }
                return i2;
            }
            return 0;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.gz.z.z(mVar.na(), (com.ss.android.socialbase.downloader.e.dl) null, new com.ss.android.socialbase.downloader.gc.z(1003, com.ss.android.socialbase.downloader.pf.m.g(th, "addDownloadTask")), 0);
            com.ss.android.socialbase.downloader.m.z.gc(z, String.format("add download task error:%s", th));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.ss.android.socialbase.downloader.e.a aVar, int i, boolean z2) {
        if (aVar == null) {
            return;
        }
        aVar.ls();
        com.ss.android.socialbase.downloader.e.dl dlVarZ = aVar.z();
        if (dlVarZ != null) {
            dlVarZ.v(i);
        }
        if (dlVarZ == null || !z2) {
            return;
        }
        dlVarZ.pf(z2);
    }

    private List<com.ss.android.socialbase.downloader.e.gc> z(List<com.ss.android.socialbase.downloader.e.gc> list) {
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.e.gc gcVar : list) {
                if (gcVar != null && !TextUtils.isEmpty(gcVar.z()) && !TextUtils.isEmpty(gcVar.g())) {
                    if (gcVar.z().equals("User-Agent")) {
                        z2 = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.e.gc(gcVar.z(), gcVar.g()));
                }
            }
        }
        if (!z2) {
            arrayList.add(new com.ss.android.socialbase.downloader.e.gc("User-Agent", com.ss.android.socialbase.appdownloader.g.z.z));
        }
        return arrayList;
    }

    public String z(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || dl.dl(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    private gk z(final com.ss.android.socialbase.appdownloader.dl.m mVar) {
        if (mVar == null) {
            return null;
        }
        return new gk() { // from class: com.ss.android.socialbase.appdownloader.a.6
            @Override // com.ss.android.socialbase.downloader.a.gk
            public void z(int i, com.ss.android.socialbase.downloader.e.dl dlVar, String str, String str2) {
                if (i != 1 && i != 3) {
                    if (i == 9) {
                        com.ss.android.socialbase.downloader.downloader.dl.xl();
                        return;
                    } else if (i != 5 && i != 6 && i != 7) {
                        return;
                    }
                }
                dlVar.p();
            }

            @Override // com.ss.android.socialbase.downloader.a.gk
            public boolean z(boolean z2) {
                return mVar.z(z2);
            }

            @Override // com.ss.android.socialbase.downloader.a.gk
            public String z() {
                return mVar.z();
            }
        };
    }

    public com.ss.android.socialbase.downloader.e.dl z(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                com.ss.android.socialbase.downloader.e.dl dlVarZ = z(context, str, fo());
                if (dlVarZ == null) {
                    dlVarZ = z(context, str, com.bytedance.sdk.openadsdk.api.plugin.g.z(context, Environment.DIRECTORY_DOWNLOADS));
                }
                if (dlVarZ == null) {
                    dlVarZ = z(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (dlVarZ == null) {
                    dlVarZ = z(context, str, com.bytedance.sdk.openadsdk.api.plugin.g.z(context));
                }
                return (dlVarZ == null && com.ss.android.socialbase.downloader.i.z.dl().z("get_download_info_by_list")) ? g(context, str) : dlVarZ;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.m.z.g(z, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private com.ss.android.socialbase.downloader.e.dl z(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.downloader.e.g(context).g(str, file.getAbsolutePath());
    }

    private com.ss.android.socialbase.downloader.e.dl g(Context context, String str) {
        List<com.ss.android.socialbase.downloader.e.dl> listZ = com.ss.android.socialbase.downloader.downloader.e.g(context).z(str);
        if (listZ == null) {
            return null;
        }
        for (com.ss.android.socialbase.downloader.e.dl dlVar : listZ) {
            if (dlVar != null && dlVar.gl()) {
                return dlVar;
            }
        }
        return null;
    }

    public List<com.ss.android.socialbase.downloader.e.dl> z(Context context) {
        return com.ss.android.socialbase.downloader.downloader.e.g(context).dl("application/vnd.android.package-archive");
    }

    public List<com.ss.android.socialbase.downloader.e.dl> g(Context context) {
        return com.ss.android.socialbase.downloader.downloader.e.g(context).a("application/vnd.android.package-archive");
    }

    public v v() {
        return this.p;
    }

    public com.ss.android.socialbase.appdownloader.dl.gz pf() {
        return this.ls;
    }

    public void z(com.ss.android.socialbase.appdownloader.dl.gz gzVar) {
        this.ls = gzVar;
    }

    public js ls() {
        return com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).g();
    }

    public void z(js jsVar) {
        com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).z(jsVar);
    }

    public void z(lq lqVar) {
        this.tb = lqVar;
    }

    public lq p() {
        return this.tb;
    }

    public void z(ti tiVar) {
        this.q = tiVar;
    }

    public ti fv() {
        return this.q;
    }

    public void z(int i) {
        if (com.ss.android.socialbase.downloader.i.z.dl().z("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        wp();
        g(i);
    }

    public void z(ls lsVar) {
        this.iq = lsVar;
    }

    public static Pair<Intent, Boolean> g(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 31 && com.ss.android.socialbase.downloader.i.z.z(i).g("enable_target_34") > 0) {
            return new Pair<>(new Intent(context, (Class<?>) DownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) DownloadHandlerService.class), Boolean.FALSE);
    }

    public static PendingIntent z(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }
}
