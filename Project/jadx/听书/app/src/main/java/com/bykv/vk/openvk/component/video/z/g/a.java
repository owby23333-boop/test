package com.bykv.vk.openvk.component.video.z.g;

import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.component.video.z.g.fo;
import com.bykv.vk.openvk.component.video.z.g.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a gc;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f103a;
    private final g<Runnable> dl;
    private volatile com.bykv.vk.openvk.component.video.z.g.z.dl e;
    private final HashSet<z> fo;
    private final SparseArray<Map<String, com.bykv.vk.openvk.component.video.z.g.g>> g;
    private volatile com.bykv.vk.openvk.component.video.z.g.z.g gz;
    private volatile String i;
    private volatile dl kb;
    private volatile com.bykv.vk.openvk.component.video.z.g.g.dl m;
    private final g.InterfaceC0031g uy;
    private volatile boolean v;
    private volatile dl wp;
    private volatile int z = 163840;

    void z(com.bykv.vk.openvk.component.video.z.g.z.dl dlVar) {
        this.e = dlVar;
    }

    void z(com.bykv.vk.openvk.component.video.z.g.g.dl dlVar) {
        this.m = dlVar;
    }

    public void z(int i) {
        if (i > 0) {
            this.z = i;
        }
        if (gc.dl) {
            com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_Preloader", "MaxPreloadSize: ".concat(String.valueOf(i)));
        }
    }

    private a() {
        SparseArray<Map<String, com.bykv.vk.openvk.component.video.z.g.g>> sparseArray = new SparseArray<>(2);
        this.g = sparseArray;
        this.fo = new HashSet<>();
        this.uy = new g.InterfaceC0031g() { // from class: com.bykv.vk.openvk.component.video.z.g.a.1
            @Override // com.bykv.vk.openvk.component.video.z.g.g.InterfaceC0031g
            public void z(com.bykv.vk.openvk.component.video.z.g.g gVar) {
                int iM = gVar.m();
                synchronized (a.this.g) {
                    Map map = (Map) a.this.g.get(iM);
                    if (map != null) {
                        map.remove(gVar.gz);
                    }
                }
                if (gc.dl) {
                    String str = gVar.gz;
                }
            }
        };
        g<Runnable> gVar = new g<>();
        this.dl = gVar;
        ExecutorService executorServiceZ = z(gVar);
        this.f103a = executorServiceZ;
        gVar.z((ThreadPoolExecutor) executorServiceZ);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    dl z() {
        return this.kb;
    }

    dl g() {
        return this.wp;
    }

    public static a dl() {
        if (gc == null) {
            synchronized (a.class) {
                if (gc == null) {
                    gc = new a();
                }
            }
        }
        return gc;
    }

    void z(boolean z2, String str) {
        com.bykv.vk.openvk.component.video.z.g.g gVarRemove;
        this.i = str;
        this.v = z2;
        if (gc.dl) {
            com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_Preloader", "setCurrentPlayKey, ".concat(String.valueOf(str)));
        }
        HashSet<com.bykv.vk.openvk.component.video.z.g.g> hashSet = null;
        HashSet<z> hashSet2 = null;
        if (str == null) {
            synchronized (this.fo) {
                if (!this.fo.isEmpty()) {
                    hashSet2 = new HashSet(this.fo);
                    this.fo.clear();
                }
            }
            if (hashSet2 != null) {
                for (z zVar : hashSet2) {
                    z(zVar.z, zVar.g, zVar.dl, zVar.f105a, zVar.gc, zVar.m);
                    if (gc.dl) {
                        com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + zVar.f105a);
                    }
                }
                return;
            }
            return;
        }
        int i = gc.gz;
        if (i != 3 && i != 2) {
            if (i == 1) {
                synchronized (this.g) {
                    Map<String, com.bykv.vk.openvk.component.video.z.g.g> map = this.g.get(com.bykv.vk.openvk.component.video.z.g.g.g.z(z2));
                    gVarRemove = map != null ? map.remove(str) : null;
                }
                if (gVarRemove != null) {
                    gVarRemove.z();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.g) {
            int size = this.g.size();
            for (int i2 = 0; i2 < size; i2++) {
                SparseArray<Map<String, com.bykv.vk.openvk.component.video.z.g.g>> sparseArray = this.g;
                Map<String, com.bykv.vk.openvk.component.video.z.g.g> map2 = sparseArray.get(sparseArray.keyAt(i2));
                if (map2 != null) {
                    Collection<com.bykv.vk.openvk.component.video.z.g.g> collectionValues = map2.values();
                    if (collectionValues != null && !collectionValues.isEmpty()) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.addAll(collectionValues);
                    }
                    map2.clear();
                }
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        for (com.bykv.vk.openvk.component.video.z.g.g gVar : hashSet) {
            gVar.z();
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + gVar.e);
            }
        }
        if (i == 3) {
            synchronized (this.fo) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    z zVar2 = (z) ((com.bykv.vk.openvk.component.video.z.g.g) it.next()).v;
                    if (zVar2 != null) {
                        this.fo.add(zVar2);
                    }
                }
            }
        }
    }

    public void z(boolean z2, boolean z3, int i, String str, String... strArr) {
        z(z2, z3, i, str, null, strArr);
    }

    public void z(boolean z2, boolean z3, int i, String str, Map<String, String> map, String... strArr) {
        ArrayList arrayList;
        boolean z4 = gc.dl;
        com.bykv.vk.openvk.component.video.z.g.z.z zVar = z2 ? this.gz : this.e;
        com.bykv.vk.openvk.component.video.z.g.g.dl dlVar = this.m;
        if (zVar == null || dlVar == null) {
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            return;
        }
        int i2 = i <= 0 ? this.z : i;
        String strZ = z3 ? str : com.bykv.vk.openvk.component.video.api.m.g.z(str);
        File fileA = zVar.a(strZ);
        if (fileA != null && fileA.length() >= i2) {
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_Preloader", "no need preload, file size: " + fileA.length() + ", need preload size: " + i2);
                return;
            }
            return;
        }
        if (m.z().z(com.bykv.vk.openvk.component.video.z.g.g.g.z(z2), strZ)) {
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.g("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: ".concat(String.valueOf(str)));
                return;
            }
            return;
        }
        synchronized (this.g) {
            Map<String, com.bykv.vk.openvk.component.video.z.g.g> map2 = this.g.get(z2 ? 1 : 0);
            if (map2.containsKey(strZ)) {
                return;
            }
            int i3 = i2;
            z zVar2 = new z(z2, z3, i2, str, map, strArr);
            String str2 = this.i;
            if (str2 != null) {
                int i4 = gc.gz;
                if (i4 == 3) {
                    synchronized (this.fo) {
                        this.fo.add(zVar2);
                    }
                    if (gc.dl) {
                        com.bytedance.sdk.component.utils.wp.g("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                    }
                    return;
                }
                if (i4 == 2) {
                    if (gc.dl) {
                        com.bytedance.sdk.component.utils.wp.g("TAG_PROXY_Preloader", "cancel preload: ".concat(String.valueOf(str)));
                    }
                    return;
                } else if (i4 == 1 && this.v == z2 && str2.equals(strZ)) {
                    if (gc.dl) {
                        com.bytedance.sdk.component.utils.wp.g("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                    }
                    return;
                }
            }
            List<fo.g> listZ = com.bykv.vk.openvk.component.video.z.dl.z.z(com.bykv.vk.openvk.component.video.z.dl.z.z(map));
            if (listZ != null) {
                arrayList = new ArrayList(listZ.size());
                int size = listZ.size();
                for (int i5 = 0; i5 < size; i5++) {
                    fo.g gVar = listZ.get(i5);
                    if (gVar != null) {
                        arrayList.add(new fo.g(gVar.z, gVar.g));
                    }
                }
            } else {
                arrayList = null;
            }
            com.bykv.vk.openvk.component.video.z.g.g gVarZ = new g.z().z(zVar).z(dlVar).z(str).g(strZ).z(new wp(com.bykv.vk.openvk.component.video.z.dl.z.z(strArr))).z((List<fo.g>) arrayList).z(i3).z(this.uy).z(zVar2).z();
            map2.put(strZ, gVarZ);
            this.f103a.execute(gVarZ);
        }
    }

    public void z(String str) {
        z(false, false, str);
    }

    public void z(final boolean z2, final boolean z3, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bykv.vk.openvk.component.video.z.dl.z.z(new com.bytedance.sdk.component.uy.fo("cancel b b S") { // from class: com.bykv.vk.openvk.component.video.z.g.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.component.video.z.g.g gVar;
                synchronized (a.this.g) {
                    Map map = (Map) a.this.g.get(com.bykv.vk.openvk.component.video.z.g.g.g.z(z2));
                    if (map != null) {
                        gVar = (com.bykv.vk.openvk.component.video.z.g.g) map.remove(z3 ? str : com.bykv.vk.openvk.component.video.api.m.g.z(str));
                    } else {
                        gVar = null;
                    }
                }
                if (gVar != null) {
                    gVar.z();
                }
            }
        });
    }

    public void a() {
        com.bykv.vk.openvk.component.video.z.dl.z.z(new com.bytedance.sdk.component.uy.fo("cancelAll") { // from class: com.bykv.vk.openvk.component.video.z.g.a.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bykv.vk.openvk.component.video.z.g.g> arrayList = new ArrayList();
                synchronized (a.this.g) {
                    int size = a.this.g.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) a.this.g.get(a.this.g.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    a.this.dl.clear();
                }
                for (com.bykv.vk.openvk.component.video.z.g.g gVar : arrayList) {
                    gVar.z();
                    if (gc.dl) {
                        com.bytedance.sdk.component.utils.wp.g("TAG_PROXY_Preloader", "PreloadTask: " + gVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    private static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f105a;
        final int dl;
        final boolean g;
        final Map<String, String> gc;
        final String[] m;
        final boolean z;

        z(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.z = z;
            this.g = z2;
            this.dl = i;
            this.f105a = str;
            this.gc = map;
            this.m = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            z zVar = (z) obj;
            if (this.z == zVar.z && this.g == zVar.g && this.dl == zVar.dl) {
                return this.f105a.equals(zVar.f105a);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.z ? 1 : 0) * 31) + (this.g ? 1 : 0)) * 31) + this.dl) * 31) + this.f105a.hashCode();
        }
    }

    private static final class g<T> extends LinkedBlockingDeque<T> {
        private ThreadPoolExecutor z;

        private g() {
        }

        public void z(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.z != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.z = threadPoolExecutor;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.z.getPoolSize();
                int activeCount = this.z.getActiveCount();
                int maximumPoolSize = this.z.getMaximumPoolSize();
                if (activeCount >= poolSize && poolSize < maximumPoolSize) {
                    if (gc.dl) {
                        com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_TT", "create new preloader thread");
                    }
                    return false;
                }
                return offerFirst(t);
            }
        }
    }

    private static ExecutorService z(final g<Runnable> gVar) {
        int i;
        int iZ = com.bykv.vk.openvk.component.video.z.dl.z.z();
        if (iZ > 0) {
            if (iZ > 4) {
                i = 4;
            }
            return new com.bytedance.sdk.component.uy.a.a(0, i, 60L, TimeUnit.SECONDS, gVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.component.video.z.g.a.4
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    com.bytedance.sdk.component.uy.a.dl dlVar = new com.bytedance.sdk.component.uy.a.dl(runnable) { // from class: com.bykv.vk.openvk.component.video.z.g.a.4.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Process.setThreadPriority(10);
                            } catch (Throwable th) {
                                com.bytedance.sdk.component.utils.wp.z(th);
                            }
                            super.run();
                        }
                    };
                    dlVar.setName("csj_video_preload_" + dlVar.getId());
                    dlVar.setDaemon(true);
                    if (gc.dl) {
                        com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_Preloader", "new preload thead: " + dlVar.getName());
                    }
                    return dlVar;
                }
            }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.component.video.z.g.a.5
                @Override // java.util.concurrent.RejectedExecutionHandler
                public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    try {
                        gVar.offerFirst(runnable);
                        if (gc.dl) {
                            com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                        }
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                }
            });
        }
        iZ = 1;
        i = iZ;
        return new com.bytedance.sdk.component.uy.a.a(0, i, 60L, TimeUnit.SECONDS, gVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.component.video.z.g.a.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.uy.a.dl dlVar = new com.bytedance.sdk.component.uy.a.dl(runnable) { // from class: com.bykv.vk.openvk.component.video.z.g.a.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            com.bytedance.sdk.component.utils.wp.z(th);
                        }
                        super.run();
                    }
                };
                dlVar.setName("csj_video_preload_" + dlVar.getId());
                dlVar.setDaemon(true);
                if (gc.dl) {
                    com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_Preloader", "new preload thead: " + dlVar.getName());
                }
                return dlVar;
            }
        }, new RejectedExecutionHandler() { // from class: com.bykv.vk.openvk.component.video.z.g.a.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    gVar.offerFirst(runnable);
                    if (gc.dl) {
                        com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            }
        });
    }
}
