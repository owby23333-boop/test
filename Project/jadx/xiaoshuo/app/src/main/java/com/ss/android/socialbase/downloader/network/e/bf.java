package com.ss.android.socialbase.downloader.network.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.m;
import com.ss.android.socialbase.downloader.zk.vn;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class bf {
    static long bf;
    private static final HandlerThread d;
    static long e;
    private static final Handler tg;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        d = handlerThread;
        bf();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        tg = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.e.bf.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void bf() {
        e = com.ss.android.socialbase.downloader.p.e.d().e("preconnect_connection_outdate_time", 300000L);
        bf = com.ss.android.socialbase.downloader.p.e.d().e("preconnect_head_info_outdate_time", 300000L);
        e.e().e(com.ss.android.socialbase.downloader.p.e.d().e("preconnect_max_cache_size", 3));
    }

    public static Looper e() {
        return d.getLooper();
    }

    public static void e(final String str, final m mVar) {
        tg.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.e.bf.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (TextUtils.isEmpty(str)) {
                    m mVar2 = mVar;
                    if (mVar2 != null) {
                        mVar2.e(null);
                        return;
                    }
                    return;
                }
                try {
                    try {
                        List<com.ss.android.socialbase.downloader.model.d> listBf = bf.bf(0L, null, null);
                        dVarE = e.e().e(str) ? e.e().e(str, listBf) : null;
                        if (dVarE == null) {
                            d dVar = new d(str, listBf, 0L);
                            try {
                                dVar.e();
                                if (dVar.ga()) {
                                    e.e().e(str, dVar);
                                }
                                dVarE = dVar;
                            } catch (Exception e2) {
                                e = e2;
                                dVarE = dVar;
                                e.printStackTrace();
                            } catch (Throwable th) {
                                th = th;
                                dVarE = dVar;
                                try {
                                    dVarE.d();
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> mapZk = dVarE.zk();
                        m mVar3 = mVar;
                        if (mVar3 != null) {
                            mVar3.e(mapZk);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    dVarE.d();
                } catch (Throwable unused2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.ss.android.socialbase.downloader.model.d> bf(long j, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.d> list) {
        return vn.e(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }
}
