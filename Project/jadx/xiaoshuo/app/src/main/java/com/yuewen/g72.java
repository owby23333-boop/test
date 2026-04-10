package com.yuewen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.duokan.core.app.AppWrapper;
import com.duokan.core.diagnostic.LogLevel;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class g72 extends BroadcastReceiver {
    public static final String g = "wifi";
    public static final String h = "2g";
    public static final String i = "3g";
    public static final String j = "4g";
    public static final String k = "5g";
    public static final String l = "unknown";
    public static final int m = 16;
    public static final int n = 17;
    public static final int o = 18;
    public static g72 p = new g72(AppWrapper.v());
    public static final /* synthetic */ boolean q = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f11493b;
    public final CopyOnWriteArrayList<e> c = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<d> d = new CopyOnWriteArrayList<>();
    public long e = 0;
    public boolean f = false;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!g72.this.n()) {
                ia0.w().f(LogLevel.EVENT, "net", "network disconnected");
            } else if (g72.this.o()) {
                ia0.w().f(LogLevel.EVENT, "net", "network connected(wifi)");
            } else {
                ia0.w().f(LogLevel.EVENT, "net", "network connected(mobile)");
            }
            g72 g72Var = g72.this;
            g72Var.t(g72Var.n());
            g72.this.q();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f11495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f11496b;

        public b(boolean z, long j) {
            this.f11495a = z;
            this.f11496b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            g72.this.g(this.f11495a, this.f11496b);
        }
    }

    public interface c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f11497a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f11498b = 0;
        public static final int c = 1;
        public static final int d = 2;
        public static final int e = 3;
        public static final int f = 4;
        public static final int g = 5;
    }

    public interface d {
        void u7(g72 g72Var);
    }

    public interface e {
        void V6(g72 g72Var);
    }

    public g72(Context context) {
        this.f11492a = context;
        this.f11493b = (ConnectivityManager) context.getSystemService("connectivity");
        context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
    }

    public static g72 h() {
        return p;
    }

    public void d(d dVar) {
        if (dVar == null) {
            return;
        }
        this.d.addIfAbsent(dVar);
    }

    public void e(e eVar) {
        if (eVar == null) {
            return;
        }
        this.c.addIfAbsent(eVar);
    }

    public final void f() {
        rv1.n(new a(), 700L);
    }

    public final void g(boolean z, long j2) {
        if (j2 > this.e) {
            if (this.f != z) {
                p();
            }
            this.f = z;
            this.e = j2;
        }
    }

    public String i(Context context) {
        int iJ = j();
        return iJ != 2 ? iJ != 3 ? iJ != 4 ? iJ != 5 ? h : g : k : j : i;
    }

    public int j() {
        NetworkInfo activeNetworkInfo = this.f11493b.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        int i2 = 1;
        if (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 6) {
            return 5;
        }
        if (activeNetworkInfo.getType() != 0) {
            return 0;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                i2 = 2;
                break;
            case 13:
            case 18:
                i2 = 3;
                break;
            case 19:
            default:
                String subtypeName = activeNetworkInfo.getSubtypeName();
                i2 = (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName)) ? 0 : 2;
                break;
            case 20:
                return 4;
        }
        return i2;
    }

    public String k() {
        int iJ = j();
        return iJ != 1 ? iJ != 2 ? iJ != 3 ? iJ != 5 ? "unknown" : g : j : i : h;
    }

    public InetAddress l() {
        WifiInfo connectionInfo;
        int ipAddress;
        WifiManager wifiManager = (WifiManager) this.f11492a.getSystemService(g);
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (ipAddress = connectionInfo.getIpAddress()) == 0) {
            return null;
        }
        try {
            return InetAddress.getByAddress(new byte[]{(byte) (ipAddress & 255), (byte) ((ipAddress >> 8) & 255), (byte) ((ipAddress >> 16) & 255), (byte) ((ipAddress >> 24) & 255)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean m() {
        return n() && !o();
    }

    public boolean n() {
        NetworkInfo activeNetworkInfo = this.f11493b.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    public boolean o() {
        NetworkInfo networkInfo = this.f11493b.getNetworkInfo(1);
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f();
    }

    public final void p() {
        Iterator<d> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().u7(this);
        }
    }

    public final void q() {
        Iterator<e> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().V6(this);
        }
    }

    public void r(d dVar) {
        if (dVar == null) {
            return;
        }
        this.d.remove(dVar);
    }

    public void s(e eVar) {
        if (eVar == null) {
            return;
        }
        this.c.remove(eVar);
    }

    public final void t(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z) {
            g(z, jCurrentTimeMillis);
        } else {
            rv1.n(new b(z, jCurrentTimeMillis), 5000L);
        }
    }
}
