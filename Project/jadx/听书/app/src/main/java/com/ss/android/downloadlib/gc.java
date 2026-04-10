package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.downloadlib.e.i;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f2009a;
    private ScheduledExecutorService dl;
    private ExecutorService g;
    private ExecutorService z;

    private static class z {
        private static gc z = new gc();
    }

    public static gc z() {
        return z.z;
    }

    private gc() {
    }

    public void z(Runnable runnable) {
        z(runnable, false);
    }

    public void g(Runnable runnable) {
        g(runnable, false);
    }

    public void z(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !i.g()) {
            runnable.run();
        } else {
            g().execute(runnable);
        }
    }

    public void dl(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        gc().execute(runnable);
    }

    public void g(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (z2 && !i.g()) {
            runnable.run();
        } else {
            dl().execute(runnable);
        }
    }

    public void z(Runnable runnable, long j) {
        try {
            a().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public ExecutorService g() {
        if (this.z == null) {
            synchronized (gc.class) {
                if (this.z == null) {
                    this.z = new com.bytedance.sdk.component.uy.a.a(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.v.z(uy.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.z;
    }

    public ExecutorService dl() {
        if (this.g == null) {
            synchronized (gc.class) {
                if (this.g == null) {
                    this.g = new com.bytedance.sdk.component.uy.a.a(0, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.v.z(uy.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.g;
    }

    public ScheduledExecutorService a() {
        if (this.dl == null) {
            synchronized (gc.class) {
                if (this.dl == null) {
                    this.dl = new com.bytedance.sdk.component.uy.a.gc(0, new com.ss.android.socialbase.downloader.v.z(uy.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.dl;
    }

    public ExecutorService gc() {
        if (this.f2009a == null) {
            synchronized (gc.class) {
                if (this.f2009a == null) {
                    this.f2009a = new com.bytedance.sdk.component.uy.a.a(5, Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.ss.android.socialbase.downloader.v.z(uy.class.getName() + "-InstallFinishCheckCPUThreadPool"));
                }
            }
        }
        return this.f2009a;
    }

    public void m() {
        z(new Runnable() { // from class: com.ss.android.downloadlib.gc.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (gc.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i = 0; i < 13; i++) {
                            SharedPreferences sharedPreferencesZ = com.bytedance.sdk.openadsdk.ats.a.z(com.ss.android.downloadlib.addownload.wp.getContext(), strArr[i], 0);
                            if (sharedPreferencesZ != null) {
                                sharedPreferencesZ.edit().clear().apply();
                            }
                        }
                        com.ss.android.socialbase.downloader.downloader.wp wpVarIo = com.ss.android.socialbase.downloader.downloader.dl.io();
                        if (!(wpVarIo instanceof com.ss.android.socialbase.downloader.impls.a)) {
                            return;
                        }
                        SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArrayZ = ((com.ss.android.socialbase.downloader.impls.a) wpVarIo).z().z();
                        for (int size = sparseArrayZ.size() - 1; size >= 0; size--) {
                            com.ss.android.socialbase.downloader.e.dl dlVar = sparseArrayZ.get(sparseArrayZ.keyAt(size));
                            if (dlVar != null) {
                                com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.downloadlib.addownload.wp.getContext()).uy(dlVar.e());
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }
}
