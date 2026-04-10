package com.ss.android.socialbase.downloader.fo.z;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.e.gc;
import com.ss.android.socialbase.downloader.fo.kb;
import com.ss.android.socialbase.downloader.pf.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f2078a;
    private static final HandlerThread dl;
    static long g;
    static long z;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        dl = handlerThread;
        g();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        f2078a = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.fo.z.g.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static Looper z() {
        return dl.getLooper();
    }

    public static void z(final String str, final kb kbVar) {
        f2078a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.fo.z.g.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        try {
                            List<gc> listG = g.g(0L, null, null);
                            dlVarZ = z.z().z(str) ? z.z().z(str, listG) : null;
                            if (dlVarZ == null) {
                                dl dlVar = new dl(str, listG, 0L);
                                try {
                                    dlVar.z();
                                    if (dlVar.gc()) {
                                        z.z().z(str, dlVar);
                                    }
                                    dlVarZ = dlVar;
                                } catch (Exception e) {
                                    e = e;
                                    dlVarZ = dlVar;
                                    wp.z(e);
                                    try {
                                        dlVarZ.dl();
                                        return;
                                    } catch (Throwable unused) {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    dlVarZ = dlVar;
                                    try {
                                        dlVarZ.dl();
                                    } catch (Throwable unused2) {
                                    }
                                    throw th;
                                }
                            }
                            Map<String, String> mapFo = dlVarZ.fo();
                            kb kbVar2 = kbVar;
                            if (kbVar2 != null) {
                                kbVar2.z(mapFo);
                            }
                            try {
                                dlVarZ.dl();
                            } catch (Throwable unused3) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } else {
                    kb kbVar3 = kbVar;
                    if (kbVar3 != null) {
                        kbVar3.z(null);
                    }
                }
            }
        });
    }

    private static void g() {
        z = com.ss.android.socialbase.downloader.i.z.dl().z("preconnect_connection_outdate_time", 300000L);
        g = com.ss.android.socialbase.downloader.i.z.dl().z("preconnect_head_info_outdate_time", 300000L);
        z.z().z(com.ss.android.socialbase.downloader.i.z.dl().z("preconnect_max_cache_size", 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<gc> g(long j, com.ss.android.socialbase.downloader.e.dl dlVar, List<gc> list) {
        return m.z(list, dlVar == null ? null : dlVar.n(), j, 0L);
    }
}
