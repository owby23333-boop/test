package s;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ServiceConnectionC0061a.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements ServiceConnection {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ThreadPoolExecutor f21692u = new ThreadPoolExecutor(0, 3, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(2048), new ThreadPoolExecutor.DiscardPolicy());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f21693s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f21694t = new LinkedBlockingQueue<>(1);

    /* JADX INFO: compiled from: ServiceConnectionC0061a.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final IBinder f21695s;

        public a(IBinder iBinder) {
            this.f21695s = iBinder;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                String str = "onServiceConnected " + System.currentTimeMillis();
                b.this.f21694t.offer(this.f21695s);
            } catch (Throwable th) {
                StringBuilder sbA = y.b.a("onServiceConnected  ");
                sbA.append(th.getClass().getSimpleName());
                sbA.toString();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        f21692u.execute(new a(iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        StringBuilder sbA = y.b.a("onServiceDisconnected ");
        sbA.append(System.currentTimeMillis());
        sbA.toString();
    }
}
