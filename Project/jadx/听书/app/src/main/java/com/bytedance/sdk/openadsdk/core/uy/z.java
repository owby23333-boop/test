package com.bytedance.sdk.openadsdk.core.uy;

import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.component.uy.gz;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    protected abstract void z(List<File> list);

    protected abstract boolean z(long j, int i);

    protected abstract boolean z(File file, long j, int i);

    public void z(File file) throws IOException {
        final gz gzVar = new gz(new CallableC0207z(file), 1, 2);
        e.g(new fo("touch", gzVar.z()) { // from class: com.bytedance.sdk.openadsdk.core.uy.z.1
            @Override // java.lang.Runnable
            public void run() {
                gzVar.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(File file) throws IOException {
        try {
            m.g(file);
        } catch (Throwable unused) {
        }
        List<File> listZ = m.z(file.getParentFile());
        wp.a("splashLoadAd", "LruDiskFile touchInBackground files.size() " + listZ.size());
        z(listZ);
    }

    long g(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.uy.z$z, reason: collision with other inner class name */
    private class CallableC0207z implements Callable<Void> {
        private final File g;

        private CallableC0207z(File file) {
            this.g = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            z.this.g(this.g);
            return null;
        }
    }
}
