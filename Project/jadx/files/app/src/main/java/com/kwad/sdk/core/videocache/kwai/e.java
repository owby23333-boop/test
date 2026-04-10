package com.kwad.sdk.core.videocache.kwai;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements com.kwad.sdk.core.videocache.kwai.a {
    private final ExecutorService anH = com.kwad.sdk.core.threads.b.xW();

    class a implements Callable<Void> {
        private final File file;

        public a(File file) {
            this.file = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: vu, reason: merged with bridge method [inline-methods] */
        public Void call() throws Throwable {
            e.this.u(this.file);
            return null;
        }
    }

    private void t(List<File> list) {
        long jU = u(list);
        list.size();
        for (File file : list) {
            if (!V(jU)) {
                long length = file.length();
                if (file.delete()) {
                    jU -= length;
                } else {
                    com.kwad.sdk.core.d.b.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private static long u(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(File file) throws Throwable {
        d.r(file);
        t(d.q(file.getParentFile()));
    }

    protected abstract boolean V(long j2);

    @Override // com.kwad.sdk.core.videocache.kwai.a
    public final void n(File file) {
        this.anH.submit(new a(file));
    }
}
