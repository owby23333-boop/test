package com.ss.android.socialbase.downloader.impls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes4.dex */
public class gc extends z {
    private static com.ss.android.socialbase.downloader.v.a g;

    public static void dl(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService executorServiceLs = com.ss.android.socialbase.downloader.downloader.dl.ls();
        if (executorServiceLs != null) {
            executorServiceLs.invokeAll(list);
        }
    }

    public static List<Future> a(List<Runnable> list) {
        ExecutorService executorServiceLs = com.ss.android.socialbase.downloader.downloader.dl.ls();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(executorServiceLs.submit(it.next()));
        }
        return arrayList;
    }

    public gc() {
        g = new com.ss.android.socialbase.downloader.v.a();
    }

    public static Runnable gc(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService executorServiceLs = com.ss.android.socialbase.downloader.downloader.dl.ls();
                if ((executorServiceLs instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) executorServiceLs).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.m.z.a("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.impls.z
    public boolean z(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarA;
        com.ss.android.socialbase.downloader.v.a aVar = g;
        if (aVar == null || !aVar.z(i) || (dlVarA = a(i)) == null) {
            return false;
        }
        if (com.ss.android.socialbase.downloader.g.m.g(dlVarA.p())) {
            return true;
        }
        g(i);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.z
    public void z(com.ss.android.socialbase.downloader.v.dl dlVar) {
        com.ss.android.socialbase.downloader.v.a aVar = g;
        if (aVar == null) {
            return;
        }
        aVar.g(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.z
    public void z(int i, com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g("DownloadTask", "start doDownload for task : ".concat(String.valueOf(i)));
        g.z(new com.ss.android.socialbase.downloader.v.dl(aVar, this.z));
    }

    @Override // com.ss.android.socialbase.downloader.impls.z
    public void g(int i) {
        com.ss.android.socialbase.downloader.v.a aVar = g;
        if (aVar == null) {
            return;
        }
        aVar.dl(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.z
    protected com.ss.android.socialbase.downloader.v.dl dl(int i) {
        com.ss.android.socialbase.downloader.v.a aVar = g;
        if (aVar == null) {
            return null;
        }
        return aVar.g(i);
    }

    @Override // com.ss.android.socialbase.downloader.impls.z
    public List<Integer> z() {
        return g.z();
    }

    @Override // com.ss.android.socialbase.downloader.impls.z
    public void z(int i, long j) {
        com.ss.android.socialbase.downloader.v.a aVar = g;
        if (aVar == null) {
            return;
        }
        aVar.z(i, j);
    }
}
