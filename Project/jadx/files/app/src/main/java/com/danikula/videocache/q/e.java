package com.danikula.videocache.q;

import com.danikula.videocache.j;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: LruDiskUsage.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements com.danikula.videocache.q.a {
    private final ExecutorService a = Executors.newSingleThreadExecutor();

    /* JADX INFO: compiled from: LruDiskUsage.java */
    private class a implements Callable<Void> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final File f14792s;

        public a(File file) {
            this.f14792s = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            e.this.b(this.f14792s);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        d.e(file);
        b(d.a(file.getParentFile()));
    }

    protected abstract boolean a(File file, long j2, int i2);

    @Override // com.danikula.videocache.q.a
    public void a(File file) throws IOException {
        this.a.submit(new a(file));
    }

    private long a(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    private void b(List<File> list) {
        long jA = a(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, jA, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    jA -= length;
                    j.c("Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    j.b("Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }
}
