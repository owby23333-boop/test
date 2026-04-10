package com.bykv.vk.openvk.component.video.z.g.m;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.m.dl;
import com.bykv.vk.openvk.component.video.z.g.a;
import com.bykv.vk.openvk.component.video.z.g.gc;
import com.bykv.vk.openvk.component.video.z.g.m;
import com.bytedance.sdk.component.utils.wp;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static final boolean z = dl.g();
    private C0032z dl;
    private HashMap<String, Boolean> g;

    private z() {
        this.g = new HashMap<>();
        g();
    }

    public static z z() {
        return g.z;
    }

    private static class g {
        private static final z z = new z();
    }

    public boolean g() {
        if (this.dl != null) {
            return true;
        }
        com.bykv.vk.openvk.component.video.z.g.z.dl dlVarDl = dl();
        if (dlVarDl == null) {
            return false;
        }
        gc.z(true);
        gc.g(true);
        gc.z(1);
        m.z().a();
        try {
            C0032z c0032z = new C0032z();
            this.dl = c0032z;
            c0032z.setName("csj_video_cache_preloader");
            this.dl.start();
            gc.z(dlVarDl, com.bykv.vk.openvk.component.video.api.dl.getContext());
            a.dl();
            a.dl().z(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean z(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        if (!g()) {
            return false;
        }
        this.dl.z(aVar);
        return true;
    }

    public String g(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        if (aVar == null) {
            return null;
        }
        boolean z2 = !TextUtils.isEmpty(aVar.p());
        return m.z().z(false, z2, z2 ? aVar.p() : aVar.ls(), aVar.ls());
    }

    private static com.bykv.vk.openvk.component.video.z.g.z.dl dl() {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.g.g(com.bykv.vk.openvk.component.video.api.dl.getContext()), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        com.bykv.vk.openvk.component.video.z.g.z.dl dlVar = null;
        try {
            com.bykv.vk.openvk.component.video.z.g.z.dl dlVar2 = new com.bykv.vk.openvk.component.video.z.g.z.dl(file);
            try {
                dlVar2.z(104857600L);
                return dlVar2;
            } catch (IOException e) {
                e = e;
                dlVar = dlVar2;
                wp.z(e);
                return dlVar;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.z.g.m.z$z, reason: collision with other inner class name */
    class C0032z extends com.bytedance.sdk.component.uy.a.dl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<C0033z> f114a;
        private boolean dl;
        private Queue<C0033z> g;
        private Queue<C0033z> gc;

        public C0032z() {
            super("VideoCachePreloader$PreLoadThread");
            this.f114a = new ArrayBlockingQueue(10);
            this.g = new LinkedBlockingQueue();
            this.dl = true;
            this.gc = new LinkedBlockingQueue();
        }

        private C0033z z(int i, com.bykv.vk.openvk.component.video.api.dl.a aVar) {
            this.f114a.size();
            C0033z c0033zPoll = this.f114a.poll();
            if (c0033zPoll == null) {
                c0033zPoll = new C0033z();
            }
            c0033zPoll.z = i;
            c0033zPoll.m = aVar;
            return c0033zPoll;
        }

        private void z(C0033z c0033z) {
            c0033z.dl = null;
            c0033z.g = null;
            c0033z.z = -1;
            c0033z.m = null;
            this.f114a.offer(c0033z);
        }

        private synchronized void g(C0033z c0033z) {
            this.gc.add(c0033z);
            notify();
        }

        private void dl(C0033z c0033z) {
            if (c0033z == null) {
                return;
            }
            this.g.offer(c0033z);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.dl) {
                synchronized (this) {
                    if (!this.gc.isEmpty()) {
                        z();
                    }
                    while (!this.g.isEmpty()) {
                        C0033z c0033zPoll = this.g.poll();
                        if (c0033zPoll != null) {
                            int i = c0033zPoll.z;
                            if (i != 0) {
                                if (i == 1) {
                                    a.dl().z(c0033zPoll.g);
                                } else if (i == 2) {
                                    a.dl().a();
                                } else if (i == 3) {
                                    a.dl().a();
                                    if (gc.g() != null) {
                                        gc.g().z();
                                    }
                                    if (gc.z() != null) {
                                        gc.z().z();
                                    }
                                } else if (i == 4) {
                                    a.dl().a();
                                    this.dl = false;
                                }
                            } else if (c0033zPoll.dl != null && c0033zPoll.dl.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : c0033zPoll.dl) {
                                    if (com.bykv.vk.openvk.component.video.z.dl.z.z(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                a.dl().z(false, !TextUtils.isEmpty(c0033zPoll.gc), c0033zPoll.f115a, c0033zPoll.g, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            z(c0033zPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        wp.z(e);
                    }
                }
            }
        }

        private void z() {
            while (true) {
                C0033z c0033zPoll = this.gc.poll();
                if (c0033zPoll == null) {
                    return;
                }
                c0033zPoll.g = c0033zPoll.m.ls();
                c0033zPoll.dl = new String[]{c0033zPoll.m.ls()};
                int iG = c0033zPoll.m.g();
                if (iG <= 0) {
                    iG = c0033zPoll.m.m();
                }
                c0033zPoll.f115a = iG;
                c0033zPoll.gc = c0033zPoll.m.p();
                if (!TextUtils.isEmpty(c0033zPoll.m.p())) {
                    c0033zPoll.g = c0033zPoll.m.p();
                }
                c0033zPoll.m = null;
                dl(c0033zPoll);
            }
        }

        public void z(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
            g(z(0, aVar));
        }

        /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.z.g.m.z$z$z, reason: collision with other inner class name */
        private class C0033z {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f115a;
            public String[] dl;
            public String g;
            public String gc;
            public com.bykv.vk.openvk.component.video.api.dl.a m;
            public int z;

            public C0033z() {
            }
        }
    }
}
