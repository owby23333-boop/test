package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.media3.session.MediaController;
import com.ss.android.socialbase.downloader.a.na;
import com.ss.android.socialbase.downloader.a.un;
import com.ss.android.socialbase.downloader.a.x;
import com.ss.android.socialbase.downloader.downloader.iq;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile uy f2059a;
    private static int bv;
    private static volatile i dl;
    private static volatile p e;
    private static final List<Object> ec;
    private static com.ss.android.socialbase.downloader.gz.dl f;
    private static volatile z fo;
    private static volatile ExecutorService fv;
    private static volatile wp g;
    private static boolean gb;
    private static volatile un gc;
    private static final int gp;
    private static volatile p gz;
    private static volatile x h;
    private static volatile fv hh;
    private static volatile com.ss.android.socialbase.downloader.fo.gz i;
    private static volatile fo io;
    private static volatile ExecutorService iq;
    private static final int j;
    private static boolean jq;
    private static volatile ExecutorService js;
    private static volatile com.ss.android.socialbase.downloader.fo.gz kb;
    private static volatile com.ss.android.socialbase.downloader.gz.g l;
    private static volatile ExecutorService ls;
    private static volatile com.ss.android.socialbase.downloader.impls.z m;
    private static volatile com.ss.android.socialbase.downloader.fo.m mc;
    private static final int na;
    private static volatile ExecutorService p;
    private static volatile ExecutorService pf;
    private static volatile ExecutorService q;
    private static js sv;
    private static volatile tb sy;
    private static int t;
    private static volatile ExecutorService tb;
    private static volatile iq ti;
    private static volatile DownloadReceiver uf;
    private static volatile com.ss.android.socialbase.downloader.fo.m un;
    private static volatile com.ss.android.socialbase.downloader.fo.uy uy;
    private static volatile v v;
    private static boolean vm;
    private static int wj;
    private static volatile com.ss.android.socialbase.downloader.fo.uy wp;
    private static final int xl;
    private static final List<com.ss.android.socialbase.downloader.a.wp> y;
    private static volatile boolean yx;
    private static volatile Context z;
    private static volatile ScheduledExecutorService zw;
    private static volatile List<na> gk = new ArrayList();
    private static volatile boolean x = false;
    private static volatile OkHttpClient lq = null;
    private static final List<com.ss.android.socialbase.downloader.a.v> eo = new ArrayList();
    private static boolean oq = false;

    public interface z {

        /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.downloader.dl$z$z, reason: collision with other inner class name */
        public interface InterfaceC0473z {
            void z();
        }

        pf g();

        p z();

        q z(InterfaceC0473z interfaceC0473z);
    }

    public static void z(js jsVar) {
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        na = iAvailableProcessors;
        xl = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        j = iAvailableProcessors;
        gp = iAvailableProcessors;
        t = 8192;
        y = new ArrayList();
        ec = new ArrayList();
        gb = true;
        jq = false;
        yx = false;
    }

    private dl() {
    }

    static synchronized void z(gz gzVar) {
        if (yx) {
            com.ss.android.socialbase.downloader.m.z.gc("DownloadComponentManager", "component has init");
            return;
        }
        boolean z2 = x;
        dl(gzVar);
        if (g == null) {
            g = new com.ss.android.socialbase.downloader.impls.a();
        }
        if (e == null) {
            e = new com.ss.android.socialbase.downloader.impls.gz();
        }
        if (gz == null && fo != null) {
            gz = fo.z();
        }
        if (dl == null) {
            dl = new com.ss.android.socialbase.downloader.impls.fo();
        }
        if (m == null) {
            m = new com.ss.android.socialbase.downloader.impls.gc();
        }
        if (f2059a == null) {
            f2059a = new com.ss.android.socialbase.downloader.impls.dl();
        }
        if (io == null) {
            io = new com.ss.android.socialbase.downloader.impls.g();
        }
        if (sy == null) {
            sy = new com.ss.android.socialbase.downloader.impls.uy();
        }
        int i2 = wj;
        if (i2 <= 0 || i2 > na) {
            wj = na;
        }
        bv();
        if (x && !z2 && !com.ss.android.socialbase.downloader.pf.m.dl()) {
            com.ss.android.socialbase.downloader.impls.wp.z(true).startService();
        } else if (com.ss.android.socialbase.downloader.pf.m.a()) {
            ExecutorService executorServiceWp = wp();
            if (executorServiceWp != null) {
                executorServiceWp.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.dl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Context contextXl = dl.xl();
                        if (contextXl != null) {
                            com.ss.android.socialbase.downloader.pf.m.a(contextXl);
                        }
                    }
                });
            }
        } else {
            Context contextXl = xl();
            if (contextXl != null) {
                com.ss.android.socialbase.downloader.pf.m.a(contextXl);
            }
        }
        lq();
        yx = true;
    }

    static synchronized void g(gz gzVar) {
        dl(gzVar);
    }

    private static void dl(gz gzVar) {
        if (gzVar != null) {
            if (gzVar.getContext() != null) {
                z(gzVar.getContext());
            }
            if (gzVar.z() != null) {
                z(gzVar.z());
            }
            if (gzVar.g() != null) {
                z(gzVar.g());
            }
            if (gzVar.ls() != null) {
                z(gzVar.ls());
            }
            if (gzVar.io() != null) {
                z(gzVar.io());
            }
            if (gzVar.pf() != 0) {
                g(gzVar.pf());
            }
            if (gzVar.dl() != null) {
                z(gzVar.dl());
            }
            if (gzVar.a() != null) {
                z(gzVar.a());
            }
            if (gzVar.gc() != null) {
                z(gzVar.gc());
            }
            if (gzVar.m() != null) {
                dl(gzVar.m());
            }
            if (gzVar.e() != null) {
                a(gzVar.e());
            }
            if (gzVar.gz() != null) {
                gc(gzVar.gz());
            }
            if (gzVar.fo() != null) {
                m(gzVar.fo());
            }
            if (gzVar.uy() != null) {
                e(gzVar.uy());
            }
            if (gzVar.kb() != null) {
                gz(gzVar.kb());
            }
            if (gzVar.wp() != null) {
                z(gzVar.wp());
            }
            if (gzVar.i() != null) {
                g(gzVar.i());
            }
            if (!gzVar.v().isEmpty()) {
                z(gzVar.v());
            }
            if (gzVar.tb() != null) {
                hh = gzVar.tb();
            }
            if (gzVar.fv() > 1024) {
                t = gzVar.fv();
            }
            if (gzVar.p() != null) {
                z(gzVar.p());
            }
            if (gzVar.js()) {
                x = true;
            }
            if (gzVar.q() != 0) {
                bv = gzVar.q();
            }
            if (gzVar.uf() != null) {
                z(gzVar.uf());
            }
            if (gzVar.hh() != null) {
                mc = gzVar.hh();
            }
            if (gzVar.iq() != null) {
                iq iqVarIq = gzVar.iq();
                ti = iqVarIq;
                if (iqVarIq.z()) {
                    z(ti.g());
                    z(ti.dl());
                } else {
                    z(e());
                    z(gz());
                }
            }
            g(gzVar.zw());
            if (gzVar.sy() != null) {
                z(gzVar.sy());
            }
        }
    }

    private static void bv() {
        if (uf == null) {
            uf = new DownloadReceiver();
        }
        if (oq) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            z.registerReceiver(uf, intentFilter);
            oq = true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public static synchronized void z() {
        if (x) {
            return;
        }
        x = true;
        try {
            Intent intent = new Intent(xl(), (Class<?>) DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            xl().startService(intent);
            if (!com.ss.android.socialbase.downloader.pf.m.dl()) {
                com.ss.android.socialbase.downloader.impls.wp.z(true).startService();
            }
        } catch (Throwable th) {
            x = false;
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public static synchronized boolean g() {
        return x;
    }

    public static com.ss.android.socialbase.downloader.fo.uy dl() {
        return uy;
    }

    public static void z(na naVar) {
        if (naVar == null) {
            return;
        }
        synchronized (gk) {
            gk.add(naVar);
        }
    }

    public static List<na> a() {
        List<na> list;
        synchronized (gk) {
            list = gk;
        }
        return list;
    }

    public static void z(com.ss.android.socialbase.downloader.a.wp wpVar) {
        List<com.ss.android.socialbase.downloader.a.wp> list = y;
        synchronized (list) {
            if (wpVar != null) {
                if (!list.contains(wpVar)) {
                    list.add(wpVar);
                }
            }
        }
    }

    public static void z(com.ss.android.socialbase.downloader.g.a aVar) {
        List<com.ss.android.socialbase.downloader.a.wp> list = y;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.a.wp wpVar : list) {
                if (wpVar != null && aVar != com.ss.android.socialbase.downloader.g.a.SYNC_START && aVar == com.ss.android.socialbase.downloader.g.a.SYNC_SUCCESS) {
                    wpVar.z();
                }
            }
            if (aVar == com.ss.android.socialbase.downloader.g.a.SYNC_SUCCESS) {
                y.clear();
            }
        }
    }

    public static void z(com.ss.android.socialbase.downloader.e.a aVar, int i2) {
        List<Object> list = ec;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static void g(com.ss.android.socialbase.downloader.e.a aVar, int i2) {
        List<Object> list = ec;
        synchronized (list) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public static com.ss.android.socialbase.downloader.fo.gz gc() {
        return kb;
    }

    public static com.ss.android.socialbase.downloader.gz.g m() {
        return l;
    }

    public static com.ss.android.socialbase.downloader.fo.fo z(boolean z2, int i2, String str, List<com.ss.android.socialbase.downloader.e.gc> list) throws Exception {
        return z(z2, i2, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.fo.fo z(boolean z2, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.e.gc> list, int i3, boolean z3, com.ss.android.socialbase.downloader.e.dl dlVar) throws Exception {
        List<com.ss.android.socialbase.downloader.e.gc> list2;
        int i4;
        com.ss.android.socialbase.downloader.fo.fo foVarZ;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.e.gc> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.e.gc("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i4 = 1;
        } else if (z2) {
            list2 = list;
            i4 = i3;
        } else {
            i4 = 2;
            list2 = list;
        }
        int[] iArrZ = z(i4);
        Exception exc = null;
        for (int i5 : iArrZ) {
            try {
                foVarZ = z(i2, str, str2, list2, i5, z3, dlVar);
            } catch (Exception e2) {
                if (dlVar.lk() && com.ss.android.socialbase.downloader.pf.m.e(e2) && com.ss.android.socialbase.downloader.pf.m.dl(list2)) {
                    com.ss.android.socialbase.downloader.m.z.z("dcach::http exception 304, throw excepiton, not retry " + e2);
                    throw e2;
                }
                exc = e2;
            }
            if (foVarZ != null) {
                return foVarZ;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.fo.fo z(int r11, java.lang.String r12, java.lang.String r13, java.util.List<com.ss.android.socialbase.downloader.e.gc> r14, int r15, boolean r16, com.ss.android.socialbase.downloader.e.dl r17) throws java.lang.Throwable {
        /*
            r7 = r15
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.fo.uy r0 = dl()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.fo.uy r0 = e()
        Ld:
            if (r0 == 0) goto L58
            r1 = 0
            r2 = 0
            r3 = 0
            if (r16 == 0) goto L20
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1d
            goto L20
        L1a:
            r0 = move-exception
            r6 = r12
            goto L3f
        L1d:
            r0 = move-exception
            r6 = r12
            goto L42
        L20:
            r5 = r11
            r6 = r12
            r8 = r14
            com.ss.android.socialbase.downloader.fo.fo r0 = r0.z(r11, r12, r14)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L41
            if (r16 == 0) goto L3d
            long r1 = java.lang.System.currentTimeMillis()
            long r4 = r1 - r3
            java.lang.String r8 = "get"
            r9 = 0
            r1 = r0
            r2 = r12
            r3 = r13
            r6 = r8
            r7 = r15
            r8 = r9
            r9 = r17
            com.ss.android.socialbase.downloader.gz.z.z(r1, r2, r3, r4, r6, r7, r8, r9)
        L3d:
            return r0
        L3e:
            r0 = move-exception
        L3f:
            r8 = r2
            goto L44
        L41:
            r0 = move-exception
        L42:
            r2 = r0
            throw r2     // Catch: java.lang.Throwable -> L3e
        L44:
            if (r16 == 0) goto L57
            long r9 = java.lang.System.currentTimeMillis()
            long r4 = r9 - r3
            java.lang.String r9 = "get"
            r2 = r12
            r3 = r13
            r6 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.gz.z.z(r1, r2, r3, r4, r6, r7, r8, r9)
        L57:
            throw r0
        L58:
            com.ss.android.socialbase.downloader.gc.z r0 = new com.ss.android.socialbase.downloader.gc.z
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "httpService not exist, netLib = "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r15)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = 1022(0x3fe, float:1.432E-42)
            r0.<init>(r2, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.dl.z(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.e.dl):com.ss.android.socialbase.downloader.fo.fo");
    }

    public static com.ss.android.socialbase.downloader.fo.e z(String str, List<com.ss.android.socialbase.downloader.e.gc> list) throws Exception {
        return z(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.fo.e z(String str, List<com.ss.android.socialbase.downloader.e.gc> list, int i2, boolean z2, com.ss.android.socialbase.downloader.e.dl dlVar) throws Exception {
        com.ss.android.socialbase.downloader.fo.e eVarG;
        Exception e2 = null;
        for (int i3 : z(i2)) {
            try {
                eVarG = g(str, list, i3, z2, dlVar);
            } catch (Exception e3) {
                e2 = e3;
            }
            if (eVarG != null) {
                return eVarG;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.fo.e g(java.lang.String r12, java.util.List<com.ss.android.socialbase.downloader.e.gc> r13, int r14, boolean r15, com.ss.android.socialbase.downloader.e.dl r16) throws java.lang.Throwable {
        /*
            r7 = r14
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.fo.gz r0 = gc()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.fo.gz r0 = gz()
        Ld:
            if (r0 == 0) goto L5a
            r1 = 0
            r2 = 0
            r3 = 0
            if (r15 == 0) goto L20
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1d
            goto L20
        L1a:
            r0 = move-exception
            r5 = r12
            goto L40
        L1d:
            r0 = move-exception
            r5 = r12
            goto L43
        L20:
            r5 = r12
            r6 = r13
            com.ss.android.socialbase.downloader.fo.e r0 = r0.z(r12, r13)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            if (r15 == 0) goto L3e
            r6 = 0
            long r1 = java.lang.System.currentTimeMillis()
            long r8 = r1 - r3
            java.lang.String r10 = "head"
            r11 = 0
            r1 = r0
            r2 = r12
            r3 = r6
            r4 = r8
            r6 = r10
            r7 = r14
            r8 = r11
            r9 = r16
            com.ss.android.socialbase.downloader.gz.z.z(r1, r2, r3, r4, r6, r7, r8, r9)
        L3e:
            return r0
        L3f:
            r0 = move-exception
        L40:
            r8 = r2
            goto L45
        L42:
            r0 = move-exception
        L43:
            r2 = r0
            throw r2     // Catch: java.lang.Throwable -> L3f
        L45:
            if (r15 == 0) goto L59
            r6 = 0
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r3
            java.lang.String r11 = "head"
            r2 = r12
            r3 = r6
            r4 = r9
            r6 = r11
            r7 = r14
            r9 = r16
            com.ss.android.socialbase.downloader.gz.z.z(r1, r2, r3, r4, r6, r7, r8, r9)
        L59:
            throw r0
        L5a:
            com.ss.android.socialbase.downloader.gc.z r0 = new com.ss.android.socialbase.downloader.gc.z
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "httpService not exist, netLib = "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r14)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = 1022(0x3fe, float:1.432E-42)
            r0.<init>(r2, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.dl.g(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.e.dl):com.ss.android.socialbase.downloader.fo.e");
    }

    private static int[] z(int i2) {
        if (i2 == 1) {
            return new int[]{0};
        }
        if (i2 == 2) {
            return new int[]{1};
        }
        if (i2 == 3) {
            return new int[]{0, 1};
        }
        return new int[]{1, 0};
    }

    public static com.ss.android.socialbase.downloader.fo.uy e() {
        if (wp == null) {
            synchronized (dl.class) {
                if (wp == null) {
                    wp = new com.ss.android.socialbase.downloader.impls.e();
                }
            }
        }
        return wp;
    }

    public static com.ss.android.socialbase.downloader.fo.gz gz() {
        if (i == null) {
            synchronized (dl.class) {
                if (i == null) {
                    i = new com.ss.android.socialbase.downloader.impls.m();
                }
            }
        }
        return i;
    }

    public static synchronized void z(v vVar) {
        if (vVar != null) {
            v = vVar;
            if (g instanceof com.ss.android.socialbase.downloader.impls.a) {
                ((com.ss.android.socialbase.downloader.impls.a) g).gz();
            }
        }
    }

    private static void dl(ExecutorService executorService) {
        if (executorService != null) {
            pf = executorService;
        }
    }

    private static void a(ExecutorService executorService) {
        if (executorService != null) {
            ls = executorService;
        }
    }

    private static void gc(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    private static void m(ExecutorService executorService) {
        if (executorService != null) {
            fv = executorService;
        }
    }

    private static void e(ExecutorService executorService) {
        if (executorService != null) {
            js = executorService;
        }
    }

    private static void gz(ExecutorService executorService) {
        if (executorService != null) {
            tb = executorService;
        }
    }

    public static void z(ExecutorService executorService) {
        if (executorService != null) {
            q = executorService;
        }
    }

    public static void g(ExecutorService executorService) {
        if (executorService != null) {
            iq = executorService;
        }
    }

    private static void z(List<com.ss.android.socialbase.downloader.a.v> list) {
        List<com.ss.android.socialbase.downloader.a.v> list2 = eo;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void z(boolean z2) {
        jq = z2;
    }

    public static boolean fo() {
        return com.ss.android.socialbase.downloader.i.z.dl().z("switch_not_auto_boot_service", jq ? 1 : 0) > 0;
    }

    public static synchronized fv uy() {
        return hh;
    }

    public static void z(Runnable runnable) {
        z(runnable, false);
    }

    public static void g(Runnable runnable) {
        g(runnable, false);
    }

    public static void z(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.pf.m.a()) {
            runnable.run();
        } else {
            kb().execute(runnable);
        }
    }

    public static void g(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !com.ss.android.socialbase.downloader.pf.m.a()) {
            runnable.run();
        } else {
            wp().execute(runnable);
        }
    }

    public static void dl(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.pf.m.a()) {
            runnable.run();
        } else {
            p().execute(runnable);
        }
    }

    public static Future z(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return js().schedule(runnable, j2, timeUnit);
    }

    public static ExecutorService kb() {
        if (pf == null) {
            synchronized (dl.class) {
                if (pf == null) {
                    int i2 = na;
                    com.bytedance.sdk.component.uy.a.a aVar = new com.bytedance.sdk.component.uy.a.a(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.v.z("DownloadThreadPool-cpu-fixed", true));
                    try {
                        aVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                    pf = aVar;
                }
            }
        }
        return pf;
    }

    public static ExecutorService wp() {
        return ls != null ? ls : kb();
    }

    public static ExecutorService i() {
        return fv != null ? fv : pf();
    }

    public static ExecutorService v() {
        return js != null ? js : pf();
    }

    public static ExecutorService pf() {
        if (p == null) {
            synchronized (dl.class) {
                if (p == null) {
                    int i2 = j;
                    com.bytedance.sdk.component.uy.a.a aVar = new com.bytedance.sdk.component.uy.a.a(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.v.z("DownloadThreadPool-mix-fixed", true));
                    try {
                        aVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                    p = aVar;
                }
            }
        }
        return p;
    }

    public static ExecutorService ls() {
        if (q == null) {
            synchronized (dl.class) {
                if (q == null) {
                    int i2 = xl;
                    com.bytedance.sdk.component.uy.a.a aVar = new com.bytedance.sdk.component.uy.a.a(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.v.z("DownloadThreadPool-chunk-fixed", true));
                    try {
                        aVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                    q = aVar;
                }
            }
        }
        return q;
    }

    public static ExecutorService p() {
        if (tb == null) {
            synchronized (dl.class) {
                if (tb == null) {
                    int i2 = gp;
                    com.bytedance.sdk.component.uy.a.a aVar = new com.bytedance.sdk.component.uy.a.a(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.v.z("DownloadThreadPool-db-fixed", true));
                    try {
                        aVar.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                    tb = aVar;
                }
            }
        }
        return tb;
    }

    public static OkHttpClient fv() {
        if (lq == null) {
            synchronized (dl.class) {
                if (lq == null) {
                    lq = tb().build();
                }
            }
        }
        return lq;
    }

    public static ScheduledExecutorService js() {
        if (zw == null) {
            synchronized (dl.class) {
                if (zw == null) {
                    zw = new com.bytedance.sdk.component.uy.a.gc(1, new com.ss.android.socialbase.downloader.v.z("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return zw;
    }

    public static OkHttpClient.Builder tb() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(MediaController.RELEASE_UNBIND_TIMEOUT_MS, TimeUnit.MILLISECONDS).readTimeout(MediaController.RELEASE_UNBIND_TIMEOUT_MS, TimeUnit.MILLISECONDS).writeTimeout(MediaController.RELEASE_UNBIND_TIMEOUT_MS, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (iq != null) {
            builder.dispatcher(new Dispatcher(iq));
        }
        return builder;
    }

    public static com.ss.android.socialbase.downloader.fo.m q() {
        return mc;
    }

    public static com.ss.android.socialbase.downloader.fo.m iq() {
        if (un == null) {
            synchronized (dl.class) {
                if (un == null) {
                    un = new com.ss.android.socialbase.downloader.fo.m() { // from class: com.ss.android.socialbase.downloader.downloader.dl.2
                        @Override // com.ss.android.socialbase.downloader.fo.m
                        public List<InetAddress> z(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return un;
    }

    public static synchronized v zw() {
        return v;
    }

    public static void z(com.ss.android.socialbase.downloader.fo.uy uyVar) {
        if (uyVar != null) {
            uy = uyVar;
        }
        vm = uy != null;
    }

    public static void z(com.ss.android.socialbase.downloader.fo.gz gzVar) {
        if (gzVar != null) {
            kb = gzVar;
        }
    }

    public static wp io() {
        if (g == null) {
            synchronized (dl.class) {
                if (g == null) {
                    g = new com.ss.android.socialbase.downloader.impls.a();
                }
            }
        }
        return g;
    }

    private static void z(wp wpVar) {
        if (wpVar != null) {
            g = wpVar;
        }
    }

    public static p uf() {
        if (e == null) {
            synchronized (dl.class) {
                if (e == null) {
                    e = new com.ss.android.socialbase.downloader.impls.gz();
                }
            }
        }
        return e;
    }

    public static p sy() {
        if (gz == null) {
            synchronized (dl.class) {
                if (gz == null) {
                    gz = fo.z();
                }
            }
        }
        return gz;
    }

    public static List<com.ss.android.socialbase.downloader.a.v> hh() {
        return eo;
    }

    public static i l() {
        if (dl == null) {
            synchronized (dl.class) {
                if (dl == null) {
                    dl = new com.ss.android.socialbase.downloader.impls.fo();
                }
            }
        }
        return dl;
    }

    public static com.ss.android.socialbase.downloader.impls.z h() {
        if (m == null) {
            synchronized (dl.class) {
                if (m == null) {
                    m = new com.ss.android.socialbase.downloader.impls.gc();
                }
            }
        }
        return m;
    }

    private static void z(i iVar) {
        if (iVar != null) {
            dl = iVar;
        }
    }

    private static void g(int i2) {
        if (i2 > 0) {
            wj = i2;
        }
    }

    private static void z(com.ss.android.socialbase.downloader.gz.g gVar) {
        if (gVar != null) {
            l = gVar;
        }
    }

    public static int gk() {
        return bv;
    }

    public static JSONObject x() {
        if (h == null || h.z() == null) {
            return com.ss.android.socialbase.downloader.g.gc.fo;
        }
        return h.z();
    }

    public static void lq() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.g.gc.dl)) {
            com.ss.android.socialbase.downloader.g.gc.dl = "oppo";
            com.ss.android.socialbase.downloader.g.gc.g = "oppo".toUpperCase();
        }
    }

    public static void z(x xVar) {
        h = xVar;
        com.ss.android.socialbase.downloader.i.z.z();
    }

    private static void g(boolean z2) {
        gb = z2;
    }

    public static boolean mc() {
        return gb;
    }

    public static synchronized int un() {
        return t;
    }

    public static uy ti() {
        if (f2059a == null) {
            synchronized (dl.class) {
                if (f2059a == null) {
                    f2059a = new com.ss.android.socialbase.downloader.impls.dl();
                }
            }
        }
        return f2059a;
    }

    private static void z(uy uyVar) {
        if (uyVar != null) {
            f2059a = uyVar;
        }
    }

    public static void z(un unVar) {
        if (unVar != null) {
            gc = unVar;
        }
    }

    public static un eo() {
        return gc;
    }

    public static fo oq() {
        if (io == null) {
            synchronized (dl.class) {
                if (io == null) {
                    io = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return io;
    }

    private static void z(fo foVar) {
        if (foVar != null) {
            io = foVar;
        }
    }

    public static tb wj() {
        if (sy == null) {
            synchronized (dl.class) {
                if (sy == null) {
                    sy = new com.ss.android.socialbase.downloader.impls.uy();
                }
            }
        }
        return sy;
    }

    public static iq na() {
        if (ti == null) {
            synchronized (dl.class) {
                if (ti == null) {
                    ti = new iq.z();
                }
            }
        }
        return ti;
    }

    public static synchronized Context xl() {
        return z;
    }

    public static synchronized void z(Context context) {
        if (context != null) {
            if (z == null) {
                z = context.getApplicationContext();
                com.ss.android.socialbase.downloader.z.z.z().z(z);
            }
        }
    }

    public static int z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return 0;
        }
        String strSy = dlVar.sy();
        if (TextUtils.isEmpty(strSy)) {
            strSy = dlVar.uy();
        }
        return z(strSy, dlVar.kb());
    }

    public static int z(String str, String str2) {
        i iVarL = l();
        if (iVarL == null) {
            return 0;
        }
        return iVarL.z(str, str2);
    }

    public static synchronized boolean j() {
        return vm;
    }

    public static com.ss.android.socialbase.downloader.gz.dl gp() {
        if (f == null) {
            f = new com.ss.android.socialbase.downloader.gz.dl() { // from class: com.ss.android.socialbase.downloader.downloader.dl.3
                @Override // com.ss.android.socialbase.downloader.gz.dl
                public void g(int i2, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.gz.dl
                public void z(int i2, String str, JSONObject jSONObject) {
                }
            };
        }
        return f;
    }

    public static js t() {
        return sv;
    }

    public static void z(com.ss.android.socialbase.downloader.gz.dl dlVar) {
        f = dlVar;
    }

    public static boolean vm() {
        return yx;
    }

    public static void z(z zVar) {
        com.ss.android.socialbase.downloader.m.z.z("wjd", "setIndependentServiceCreator::creator=" + zVar);
        fo = zVar;
    }

    public static boolean y() {
        com.ss.android.socialbase.downloader.m.z.z("wjd", "supportMultiProc::=" + (fo != null));
        return fo != null;
    }

    public static z ec() {
        return fo;
    }
}
