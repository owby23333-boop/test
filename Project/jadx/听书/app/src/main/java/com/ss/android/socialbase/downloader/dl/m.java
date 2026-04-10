package com.ss.android.socialbase.downloader.dl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.dl.dl;
import com.ss.android.socialbase.downloader.dl.g;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.dl;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.kb.fo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class m implements ServiceConnection, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f2055a;
    private static int dl;
    private static boolean g;
    private dl.z.InterfaceC0473z e;
    private Future<?> fo;
    private dl z;
    private Handler gc = new Handler(Looper.getMainLooper());
    private g m = null;
    private Runnable gz = new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.m.1
        @Override // java.lang.Runnable
        public void run() {
            if (m.g || m.this.e == null) {
                return;
            }
            m.this.e.z();
        }
    };
    private CountDownLatch uy = new CountDownLatch(1);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void i(int i) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public Map<Long, fo> wp(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public ArrayList<fo> v(int i) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean z(int i, Map<Long, fo> map) {
        return false;
    }

    public m() {
        SqlDownloadCacheService.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), this);
    }

    public void z(dl.z.InterfaceC0473z interfaceC0473z) {
        this.e = interfaceC0473z;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        g = true;
        this.gc.removeCallbacks(this.gz);
        try {
            this.z = dl.z.z(iBinder);
        } catch (Throwable th) {
            wp.z(th);
        }
        this.fo = com.ss.android.socialbase.downloader.downloader.dl.kb().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.m.2
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinder2;
                IBinder.DeathRecipient deathRecipient;
                synchronized (this) {
                    try {
                        try {
                            if (m.this.m != null && m.this.z != null) {
                                m.this.z.z(m.this.m);
                            }
                            iBinder2 = iBinder;
                            deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.dl.m.2.1
                                @Override // android.os.IBinder.DeathRecipient
                                public void binderDied() {
                                    boolean unused = m.g = false;
                                    if (m.this.e() || m.this.e == null) {
                                        return;
                                    }
                                    m.this.gc.postDelayed(m.this.gz, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                                }
                            };
                        } catch (Throwable th2) {
                            try {
                                com.ss.android.socialbase.downloader.m.z.g("SqlDownloadCacheAidlWra", "onServiceConnected fail", th2);
                                if (m.this.e != null) {
                                    m.this.e.z();
                                }
                                m.this.uy.countDown();
                                iBinder2 = iBinder;
                                deathRecipient = new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.dl.m.2.1
                                    @Override // android.os.IBinder.DeathRecipient
                                    public void binderDied() {
                                        boolean unused = m.g = false;
                                        if (m.this.e() || m.this.e == null) {
                                            return;
                                        }
                                        m.this.gc.postDelayed(m.this.gz, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                                    }
                                };
                            } finally {
                                m.this.uy.countDown();
                                try {
                                    iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.dl.m.2.1
                                        @Override // android.os.IBinder.DeathRecipient
                                        public void binderDied() {
                                            boolean unused = m.g = false;
                                            if (m.this.e() || m.this.e == null) {
                                                return;
                                            }
                                            m.this.gc.postDelayed(m.this.gz, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                                        }
                                    }, 0);
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        iBinder2.linkToDeath(deathRecipient, 0);
                    } catch (Throwable unused2) {
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.z = null;
        g = false;
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.dl.m$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SqlDownloadCacheService.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), m.this);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.q
    public void z(final SparseArray<com.ss.android.socialbase.downloader.e.dl> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.e.g>> sparseArray2, final a aVar) {
        com.ss.android.socialbase.downloader.downloader.dl.kb().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.dl.m.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                a aVar2;
                Future future;
                m.this.z(new g.z() { // from class: com.ss.android.socialbase.downloader.dl.m.4.1
                    @Override // com.ss.android.socialbase.downloader.dl.g
                    public void z(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.pf.m.z(sparseArray, map);
                        com.ss.android.socialbase.downloader.pf.m.z(sparseArray2, map2);
                        aVar.z();
                        m.this.z((g) null);
                    }
                });
                try {
                    z = !m.this.uy.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    wp.z(th);
                    z = false;
                }
                if (z && (future = m.this.fo) != null) {
                    future.cancel(true);
                }
                m.this.z();
                if (!z || (aVar2 = aVar) == null) {
                    return;
                }
                aVar2.z();
            }
        });
    }

    public void z(g gVar) {
        synchronized (this) {
            dl dlVar = this.z;
            if (dlVar != null) {
                try {
                    dlVar.z(gVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            } else {
                this.m = gVar;
            }
        }
    }

    public void z() {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.z();
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl g(int i) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.g(i);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.dl> z(String str) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.z(str);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.dl> g(String str) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.g(str);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.dl> dl(String str) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.dl(str);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.dl> a(String str) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.a(str);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.dl> g() {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.g();
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public List<com.ss.android.socialbase.downloader.e.g> dl(int i) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.dl(i);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void a(int i) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.a(i);
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(com.ss.android.socialbase.downloader.e.g gVar) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.z(gVar);
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void g(com.ss.android.socialbase.downloader.e.g gVar) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.g(gVar);
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(int i, int i2, long j) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.z(i, i2, j);
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(int i, int i2, int i3, long j) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.z(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(int i, int i2, int i3, int i4) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.z(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl z(int i, int i2) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.z(i, i2);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        try {
            dl dlVar2 = this.z;
            if (dlVar2 != null) {
                return dlVar2.z(dlVar);
            }
            return false;
        } catch (RemoteException e) {
            wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean gc(int i) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.gc(i);
            }
            return false;
        } catch (RemoteException e) {
            wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean m(int i) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.m(i);
            }
            return false;
        } catch (RemoteException e) {
            wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void dl() {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.dl();
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl e(int i) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.e(i);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl z(int i, long j, String str, String str2) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.z(i, j, str, str2);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl z(int i, long j) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.z(i, j);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl g(int i, long j) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.g(i, j);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl gz(int i) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.gz(i);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl dl(int i, long j) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.dl(i, j);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl a(int i, long j) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.a(i, j);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl fo(int i) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.fo(i);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public com.ss.android.socialbase.downloader.e.dl uy(int i) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.uy(i);
            }
            return null;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean a() {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.a();
            }
            return false;
        } catch (RemoteException e) {
            wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public boolean gc() {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                return dlVar.gc();
            }
            return false;
        } catch (RemoteException e) {
            wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        try {
            dl dlVar2 = this.z;
            if (dlVar2 != null) {
                dlVar2.g(dlVar);
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.z(i, list);
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.wp
    public void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
        try {
            dl dlVar = this.z;
            if (dlVar != null) {
                dlVar.g(i, list);
            }
        } catch (RemoteException e) {
            wp.z(e);
        }
    }
}
