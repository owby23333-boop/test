package com.ss.android.socialbase.appdownloader.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.appdownloader.a;
import com.ss.android.socialbase.appdownloader.dl;
import com.ss.android.socialbase.appdownloader.dl.gz;
import com.ss.android.socialbase.downloader.downloader.e;
import com.ss.android.socialbase.downloader.downloader.js;
import com.ss.android.socialbase.downloader.downloader.v;
import com.ss.android.socialbase.downloader.impls.fv;
import com.ss.android.socialbase.downloader.pf.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class g implements v {
    private BroadcastReceiver g;
    private List<Integer> z;

    @Override // com.ss.android.socialbase.downloader.downloader.v
    public List<String> z() {
        return dl.dl();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.v
    public void z(final List<com.ss.android.socialbase.downloader.e.dl> list, final int i) {
        if (m.a()) {
            com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.a.g.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        g.this.g(list, i);
                    } catch (Exception e) {
                        wp.z(e);
                    }
                }
            });
        } else {
            g(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<com.ss.android.socialbase.downloader.e.dl> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        a.kb();
        Context contextXl = com.ss.android.socialbase.downloader.downloader.dl.xl();
        if (contextXl == null) {
            return;
        }
        boolean zG = m.g(contextXl);
        Iterator<com.ss.android.socialbase.downloader.e.dl> it = list.iterator();
        while (it.hasNext()) {
            z(contextXl, it.next(), zG, i);
        }
        List<Integer> list2 = this.z;
        if (list2 == null || list2.isEmpty() || this.g != null) {
            return;
        }
        this.g = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.a.g.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (m.g(applicationContext)) {
                    com.ss.android.socialbase.downloader.m.z.g("LaunchResume", "onReceive : wifi connected !!!");
                    com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.a.g.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (g.this.z != null && !g.this.z.isEmpty()) {
                                    int size = g.this.z.size();
                                    Integer[] numArr = new Integer[size];
                                    g.this.z.toArray(numArr);
                                    g.this.z.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        com.ss.android.socialbase.downloader.e.dl dlVarGz = e.g(applicationContext).gz(numArr[i2].intValue());
                                        if (dlVarGz != null && (dlVarGz.zw() == -5 || (dlVarGz.zw() == -2 && dlVarGz.jq()))) {
                                            g.this.z(applicationContext, dlVarGz, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                wp.z(e);
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(g.this.g);
                    } catch (Throwable th) {
                        wp.z(th);
                    }
                    g.this.g = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            contextXl.registerReceiver(this.g, intentFilter);
        } catch (Throwable th) {
            wp.z(th);
            this.g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, boolean z, int i) {
        boolean z2;
        if (dlVar == null || !dlVar.wx()) {
            return;
        }
        int iZw = dlVar.zw();
        if (iZw == -5 && ("application/ttpatch".equalsIgnoreCase(dlVar.yt()) || !dlVar.qz())) {
            com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e());
            int iZ = zVarZ.z("failed_resume_max_count", 0);
            double dZ = zVarZ.z("failed_resume_max_hours", 72.0d);
            double dZ2 = zVarZ.z("failed_resume_min_hours", 12.0d);
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z3 = (dlVar.jq() && z) ? true : dlVar.to() < iZ && ((double) (jCurrentTimeMillis - dlVar.rw())) < dZ * 3600000.0d && ((double) (jCurrentTimeMillis - dlVar.lz())) > dZ2 * 3600000.0d;
            if (z3) {
                boolean z4 = zVarZ.z("failed_resume_need_wifi", 1) == 1;
                boolean z5 = zVarZ.z("failed_resume_need_wait_wifi", 0) == 1;
                if (z || !z4 || !z5) {
                    dl.z(dlVar, true, z4);
                    dlVar.fo(jCurrentTimeMillis);
                    dlVar.kb(dlVar.to() + 1);
                    dlVar.zt();
                    if (dlVar.jq() && z) {
                        dlVar.gc(true);
                        js jsVarLs = a.kb().ls();
                        if (jsVarLs != null) {
                            jsVarLs.z(dlVar, 5, i);
                        }
                    }
                    z2 = true;
                } else {
                    if (this.z == null) {
                        this.z = new ArrayList();
                    }
                    int iE = dlVar.e();
                    if (!this.z.contains(Integer.valueOf(iE))) {
                        this.z.add(Integer.valueOf(iE));
                    }
                    dlVar.a(true);
                    fv.z().z(dlVar);
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            com.ss.android.socialbase.downloader.m.z.dl("LaunchResume", "launchResume, name = " + dlVar.fo() + ", canShowNotification = " + z3 + ", downloadResumed = " + z2);
            gz gzVarPf = a.kb().pf();
            if (gzVarPf != null) {
                gzVarPf.z(dlVar, z2);
                return;
            }
            return;
        }
        if (iZw == -3 && z(dlVar)) {
            com.ss.android.socialbase.downloader.i.z zVarZ2 = com.ss.android.socialbase.downloader.i.z.z(dlVar.e());
            if (dl.z(context, dlVar)) {
                return;
            }
            int iZ2 = zVarZ2.z("uninstall_resume_max_count", 0);
            double dZ3 = zVarZ2.z("uninstall_resume_max_hours", 72.0d);
            double dZ4 = zVarZ2.z("uninstall_resume_min_hours", 12.0d);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            boolean z6 = dlVar.jh() < iZ2 && ((double) (jCurrentTimeMillis2 - dlVar.rw())) < dZ3 * 3600000.0d && ((double) (jCurrentTimeMillis2 - dlVar.fq())) > dZ4 * 3600000.0d;
            com.ss.android.socialbase.downloader.m.z.dl("LaunchResume", "uninstallResume, name = " + dlVar.fo() + ", canShowNotification = " + z6);
            if (z6) {
                com.ss.android.socialbase.downloader.notification.z zVarGc = com.ss.android.socialbase.downloader.notification.g.z().gc(dlVar.e());
                if (zVarGc == null) {
                    zVarGc = new com.ss.android.socialbase.appdownloader.gc.z(context, dlVar.e(), dlVar.fo(), dlVar.kb(), dlVar.gz(), dlVar.gk());
                    com.ss.android.socialbase.downloader.notification.g.z().z(zVarGc);
                } else {
                    zVarGc.z(dlVar);
                }
                zVarGc.g(dlVar.s());
                zVarGc.z(dlVar.s());
                zVarGc.z(dlVar.p(), null, false, false);
                dlVar.uy(jCurrentTimeMillis2);
                dlVar.wp(dlVar.jh() + 1);
                dlVar.zt();
                return;
            }
            return;
        }
        if (iZw == -2) {
            if (dlVar.jq()) {
                if (z) {
                    dl.z(dlVar, true, true);
                    dlVar.zt();
                    dlVar.gc(true);
                    gz gzVarPf2 = a.kb().pf();
                    if (gzVarPf2 != null) {
                        gzVarPf2.z(dlVar, true);
                    }
                    js jsVarLs2 = a.kb().ls();
                    if (jsVarLs2 != null) {
                        jsVarLs2.z(dlVar, 5, i);
                        return;
                    }
                    return;
                }
                if (this.z == null) {
                    this.z = new ArrayList();
                }
                int iE2 = dlVar.e();
                if (!this.z.contains(Integer.valueOf(iE2))) {
                    this.z.add(Integer.valueOf(iE2));
                }
                fv.z().z(dlVar);
            }
            z(dlVar, context);
        }
    }

    private void z(com.ss.android.socialbase.downloader.e.dl dlVar, Context context) {
        com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e());
        int iZ = zVarZ.z("paused_resume_max_count", 0);
        double dZ = zVarZ.z("paused_resume_max_hours", 72.0d);
        int iKa = dlVar.ka();
        if (iKa < iZ && ((double) (System.currentTimeMillis() - dlVar.rw())) < dZ * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.z zVarGc = com.ss.android.socialbase.downloader.notification.g.z().gc(dlVar.e());
            if (zVarGc == null) {
                zVarGc = new com.ss.android.socialbase.appdownloader.gc.z(context, dlVar.e(), dlVar.fo(), dlVar.kb(), dlVar.gz(), dlVar.gk());
                com.ss.android.socialbase.downloader.notification.g.z().z(zVarGc);
            } else {
                zVarGc.z(dlVar);
            }
            zVarGc.g(dlVar.s());
            zVarGc.z(dlVar.sf());
            zVarGc.z(dlVar.p(), null, false, false);
            dlVar.p(iKa + 1);
            dlVar.zt();
        }
    }

    private boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).g("uninstall_can_not_resume_for_force_task", false)) {
            return m.z(dlVar, false, dlVar.mc());
        }
        return dlVar.qz();
    }
}
