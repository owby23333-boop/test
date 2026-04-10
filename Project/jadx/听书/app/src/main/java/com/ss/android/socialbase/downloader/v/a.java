package com.ss.android.socialbase.downloader.v;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static ExecutorService z = new com.bytedance.sdk.component.uy.a.a(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new z("Download_OP_Thread"));
    private int dl = 0;
    private volatile SparseArray<dl> g = new SparseArray<>();

    public void z(dl dlVar) {
        dlVar.m();
        synchronized (a.class) {
            int i = this.dl;
            if (i >= 500) {
                g();
                this.dl = 0;
            } else {
                this.dl = i + 1;
            }
            this.g.put(dlVar.gc(), dlVar);
        }
        com.ss.android.socialbase.downloader.e.a aVarDl = dlVar.dl();
        try {
            ExecutorService executorServicePf = com.ss.android.socialbase.downloader.downloader.dl.pf();
            if (aVarDl != null && aVarDl.z() != null) {
                if ("mime_type_plg".equals(aVarDl.z().yt()) && com.ss.android.socialbase.downloader.i.z.dl().z("divide_plugin", 1) == 1) {
                    aVarDl.z().z("executor_group", (Object) 3);
                }
                int iFs = aVarDl.z().fs();
                if (iFs == 3) {
                    executorServicePf = com.ss.android.socialbase.downloader.downloader.dl.i();
                } else if (iFs == 4) {
                    executorServicePf = com.ss.android.socialbase.downloader.downloader.dl.v();
                }
            }
            if (executorServicePf != null) {
                if (com.ss.android.socialbase.downloader.i.z.z(dlVar.gc()).g("pause_with_interrupt", false)) {
                    dlVar.z(executorServicePf.submit(dlVar));
                    return;
                } else {
                    executorServicePf.execute(dlVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.gz.z.z(aVarDl.gc(), aVarDl.z(), new com.ss.android.socialbase.downloader.gc.z(1003, "execute failed cpu thread executor service is null"), aVarDl.z() != null ? aVarDl.z().p() : 0);
        } catch (Exception e) {
            if (aVarDl != null) {
                com.ss.android.socialbase.downloader.gz.z.z(aVarDl.gc(), aVarDl.z(), new com.ss.android.socialbase.downloader.gc.z(1003, com.ss.android.socialbase.downloader.pf.m.g(e, "DownloadThreadPoolExecute")), aVarDl.z() != null ? aVarDl.z().p() : 0);
            }
            wp.z(e);
        } catch (OutOfMemoryError e2) {
            if (aVarDl != null) {
                com.ss.android.socialbase.downloader.gz.z.z(aVarDl.gc(), aVarDl.z(), new com.ss.android.socialbase.downloader.gc.z(1003, "execute OOM"), aVarDl.z() != null ? aVarDl.z().p() : 0);
            }
            wp.z(e2);
        }
    }

    private void g() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.g.size(); i++) {
                int iKeyAt = this.g.keyAt(i);
                if (!this.g.get(iKeyAt).a()) {
                    arrayList.add(Integer.valueOf(iKeyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                try {
                    Integer num = (Integer) arrayList.get(i2);
                    if (num != null) {
                        this.g.remove(num.intValue());
                    }
                } catch (Throwable th) {
                    wp.z(th);
                }
            }
        } catch (Throwable th2) {
            wp.z(th2);
        }
    }

    public void g(dl dlVar) {
        if (dlVar == null) {
            return;
        }
        synchronized (a.class) {
            try {
                if (com.ss.android.socialbase.downloader.pf.z.z(524288)) {
                    int iIndexOfValue = this.g.indexOfValue(dlVar);
                    if (iIndexOfValue >= 0) {
                        this.g.removeAt(iIndexOfValue);
                    }
                } else {
                    this.g.remove(dlVar.gc());
                }
            } finally {
            }
        }
    }

    public boolean z(int i) {
        synchronized (a.class) {
            boolean z2 = false;
            if (this.g != null && this.g.size() > 0) {
                dl dlVar = this.g.get(i);
                if (dlVar != null && dlVar.a()) {
                    z2 = true;
                }
                return z2;
            }
            return false;
        }
    }

    public dl g(int i) {
        synchronized (a.class) {
            g();
            dl dlVar = this.g.get(i);
            if (dlVar == null) {
                return null;
            }
            dlVar.g();
            dl(dlVar);
            this.g.remove(i);
            return dlVar;
        }
    }

    public void dl(int i) {
        synchronized (a.class) {
            g();
            dl dlVar = this.g.get(i);
            if (dlVar != null) {
                dlVar.z();
                dl(dlVar);
                this.g.remove(i);
            }
        }
    }

    private void dl(dl dlVar) {
        Future futureE;
        if (dlVar == null) {
            return;
        }
        try {
            ExecutorService executorServicePf = com.ss.android.socialbase.downloader.downloader.dl.pf();
            com.ss.android.socialbase.downloader.e.a aVarDl = dlVar.dl();
            if (aVarDl != null && aVarDl.z() != null) {
                int iFs = aVarDl.z().fs();
                if (iFs == 3) {
                    executorServicePf = com.ss.android.socialbase.downloader.downloader.dl.i();
                } else if (iFs == 4) {
                    executorServicePf = com.ss.android.socialbase.downloader.downloader.dl.v();
                }
            }
            if (executorServicePf == null || !(executorServicePf instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) executorServicePf).remove(dlVar);
            if (!com.ss.android.socialbase.downloader.i.z.z(dlVar.gc()).g("pause_with_interrupt", false) || (futureE = dlVar.e()) == null) {
                return;
            }
            futureE.cancel(true);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public List<Integer> z() {
        ArrayList arrayList;
        synchronized (a.class) {
            g();
            arrayList = new ArrayList();
            for (int i = 0; i < this.g.size(); i++) {
                dl dlVar = this.g.get(this.g.keyAt(i));
                if (dlVar != null) {
                    arrayList.add(Integer.valueOf(dlVar.gc()));
                }
            }
        }
        return arrayList;
    }

    public void z(int i, long j) {
        this.g.get(i);
    }
}
