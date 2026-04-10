package com.ss.android.socialbase.downloader.fo;

import android.net.Uri;
import android.os.Handler;
import java.net.InetAddress;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dl {
    private final Handler dl;
    private final Handler g;
    private final com.ss.android.socialbase.downloader.pf.gz<String, g> z;

    public interface z {
        void z(String str, List<InetAddress> list);
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.fo.dl$dl, reason: collision with other inner class name */
    private static class C0477dl {
        private static final dl z = new dl();
    }

    private dl() {
        this.z = new com.ss.android.socialbase.downloader.pf.gz<>(4, 16, false);
        this.g = new Handler(com.ss.android.socialbase.downloader.fo.z.g.z());
        this.dl = new Handler(com.ss.android.socialbase.downloader.v.gc.z());
    }

    public static dl z() {
        return C0477dl.z;
    }

    public void z(final String str, final z zVar, final long j) {
        this.g.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.fo.dl.1
            @Override // java.lang.Runnable
            public void run() {
                dl.this.g(str, zVar, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final String str, final z zVar, long j) {
        final g gVar;
        List<InetAddress> listZ;
        m mVarQ;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.z) {
                gVar = this.z.get(host);
            }
            if (gVar != null) {
                if (System.currentTimeMillis() - gVar.g < com.ss.android.socialbase.downloader.i.z.dl().z("dns_expire_min", 10) * 60 * 1000) {
                    if (zVar != null) {
                        zVar.z(str, gVar.z);
                        return;
                    }
                    return;
                }
            }
            Runnable runnable = new Runnable() { // from class: com.ss.android.socialbase.downloader.fo.dl.2
                @Override // java.lang.Runnable
                public void run() {
                    z zVar2 = zVar;
                    if (zVar2 != null) {
                        String str2 = str;
                        g gVar2 = gVar;
                        zVar2.z(str2, gVar2 == null ? null : gVar2.z);
                    }
                }
            };
            this.dl.postDelayed(runnable, j);
            if (com.ss.android.socialbase.downloader.i.z.dl().z("use_host_dns", 1) != 1 || (mVarQ = com.ss.android.socialbase.downloader.downloader.dl.q()) == null) {
                listZ = null;
            } else {
                try {
                    listZ = mVarQ.z(host);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                    listZ = null;
                }
            }
            if (listZ == null || listZ.isEmpty()) {
                try {
                    listZ = com.ss.android.socialbase.downloader.downloader.dl.iq().z(host);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.wp.z(th2);
                }
            }
            if (listZ != null && !listZ.isEmpty()) {
                z(host, listZ);
            } else if (gVar != null) {
                listZ = gVar.z;
            }
            this.dl.removeCallbacks(runnable);
            if (zVar != null) {
                zVar.z(str, listZ);
            }
        } catch (Throwable th3) {
            com.bytedance.sdk.component.utils.wp.z(th3);
        }
    }

    private void z(String str, List<InetAddress> list) {
        synchronized (this.z) {
            g gVar = this.z.get(str);
            if (gVar == null) {
                gVar = new g();
                this.z.put(str, gVar);
            }
            gVar.z = list;
            gVar.g = System.currentTimeMillis();
        }
    }

    private static class g {
        long g;
        List<InetAddress> z;

        private g() {
        }
    }
}
