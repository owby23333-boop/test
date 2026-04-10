package com.bytedance.sdk.openadsdk.core.v;

import com.bytedance.sdk.component.utils.vn;
import com.bytedance.sdk.component.utils.wu;
import com.bytedance.sdk.component.zk.ga;
import com.bytedance.sdk.component.zk.p;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes10.dex */
public abstract class e {

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.v.e$e, reason: collision with other inner class name */
    public class CallableC0158e implements Callable<Void> {
        private final File bf;

        private CallableC0158e(File file) {
            this.bf = file;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            e.this.bf(this.bf);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(File file) throws IOException {
        try {
            vn.bf(file);
        } catch (Throwable th) {
            wu.e("LruDiskFile", "setLastModifiedNowError", th);
        }
        List<File> listE = vn.e(file.getParentFile());
        wu.vn("splashLoadAd", "LruDiskFile touchInBackground files.size() " + listE.size());
        e(listE);
    }

    public abstract void e(List<File> list);

    public abstract boolean e(long j, int i);

    public abstract boolean e(File file, long j, int i);

    public void e(File file) throws IOException {
        final com.bytedance.sdk.component.zk.vn vnVar = new com.bytedance.sdk.component.zk.vn(new CallableC0158e(file), 1, 2);
        ga.bf(new p("touch", vnVar.e()) { // from class: com.bytedance.sdk.openadsdk.core.v.e.1
            @Override // java.lang.Runnable
            public void run() {
                vnVar.run();
            }
        });
    }

    public long bf(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }
}
