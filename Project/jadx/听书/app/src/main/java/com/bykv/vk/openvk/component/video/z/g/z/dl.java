package com.bykv.vk.openvk.component.video.z.g.z;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.openvk.component.video.z.g.a;
import com.bykv.vk.openvk.component.video.z.g.gc;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends com.bykv.vk.openvk.component.video.z.g.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f119a;
    private final ReentrantReadWriteLock dl;
    private volatile long e;
    private final g fo;
    private final LinkedHashMap<String, File> g = new LinkedHashMap<>(0, 0.75f, true);
    private final ReentrantReadWriteLock.WriteLock gc;
    private volatile float gz;
    private final Handler kb;
    private final Set<z> m;
    private final Runnable uy;
    public final File z;

    public interface z {
        void z(String str);

        void z(Set<String> set);
    }

    public void z(z zVar) {
        if (zVar != null) {
            this.m.add(zVar);
        }
    }

    public dl(File file) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.dl = reentrantReadWriteLock;
        this.f119a = reentrantReadWriteLock.readLock();
        this.gc = reentrantReadWriteLock.writeLock();
        this.m = Collections.newSetFromMap(new ConcurrentHashMap());
        this.e = 104857600L;
        this.gz = 0.5f;
        this.fo = new g();
        this.uy = new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.g.z.dl.1
            @Override // java.lang.Runnable
            public void run() {
                e.g(new fo("cleanupCmd", 1) { // from class: com.bykv.vk.openvk.component.video.z.g.z.dl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dl.this.g(dl.this.e);
                    }
                });
            }
        };
        this.kb = new Handler(Looper.getMainLooper());
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            throw new IOException("dir error!  ".concat(String.valueOf(file == null ? " dir null" : "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite())));
        }
        this.z = file;
        e.g(new fo("DiskLruCache", 5) { // from class: com.bykv.vk.openvk.component.video.z.g.z.dl.2
            @Override // java.lang.Runnable
            public void run() {
                dl.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.gc.lock();
        try {
            File[] fileArrListFiles = this.z.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                final HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList<File> arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.z.g.z.dl.3
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLongValue = ((Long) map.get(file2)).longValue() - ((Long) map.get(file3)).longValue();
                        if (jLongValue < 0) {
                            return -1;
                        }
                        return jLongValue > 0 ? 1 : 0;
                    }
                });
                for (File file2 : arrayList) {
                    this.g.put(z(file2), file2);
                }
            }
            this.gc.unlock();
            dl();
        } catch (Throwable th) {
            this.gc.unlock();
            throw th;
        }
    }

    public void z(long j) {
        this.e = j;
        dl();
    }

    private void dl() {
        this.kb.removeCallbacks(this.uy);
        this.kb.postDelayed(this.uy, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    public void z() {
        a.dl().a();
        Context context = gc.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.z.g.g.dl.z(context).z(0);
        }
        this.kb.removeCallbacks(this.uy);
        e.g(new fo("clear", 1) { // from class: com.bykv.vk.openvk.component.video.z.g.z.dl.4
            @Override // java.lang.Runnable
            public void run() {
                dl.this.g(0L);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.z.z
    public void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.fo.z(str);
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.z.z
    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.fo.g(str);
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.z.z
    public File dl(String str) {
        this.f119a.lock();
        File file = this.g.get(str);
        this.f119a.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.z, str);
        this.gc.lock();
        this.g.put(str, file2);
        this.gc.unlock();
        Iterator<z> it = this.m.iterator();
        while (it.hasNext()) {
            it.next().z(str);
        }
        dl();
        return file2;
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.z.z
    public File a(String str) {
        if (!this.f119a.tryLock()) {
            return null;
        }
        File file = this.g.get(str);
        this.f119a.unlock();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e5 A[LOOP:3: B:41:0x00df->B:43:0x00e5, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(long r13) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.z.g.z.dl.g(long):void");
    }

    private String z(File file) {
        return file.getName();
    }

    private static final class g {
        private final Map<String, Integer> z;

        private g() {
            this.z = new HashMap();
        }

        synchronized void z(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.z.get(str);
                if (num == null) {
                    this.z.put(str, 1);
                    return;
                }
                this.z.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }

        synchronized void g(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.z.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.z.remove(str);
                    return;
                }
                this.z.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }

        synchronized boolean dl(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.z.containsKey(str);
        }
    }
}
