package com.bytedance.sdk.openadsdk.core.mc.z;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import com.bytedance.sdk.component.utils.wp;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static volatile dl z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f1264a;
    private Network dl;
    private ConnectivityManager g;
    private boolean gc;

    public interface z {
        void z(Network network);
    }

    public static dl z(Context context) {
        if (z == null) {
            synchronized (dl.class) {
                if (z == null) {
                    z = new dl(context);
                }
            }
        }
        return z;
    }

    private dl(Context context) {
        try {
            this.g = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            wp.z(e);
        }
    }

    private static boolean z(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public int z() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.g;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || (activeNetwork = this.g.getActiveNetwork()) == null || (networkCapabilities = this.g.getNetworkCapabilities(activeNetwork)) == null) {
                return 0;
            }
            boolean zHasTransport = networkCapabilities.hasTransport(4);
            boolean zHasTransport2 = networkCapabilities.hasTransport(0);
            boolean zHasTransport3 = networkCapabilities.hasTransport(1);
            if (zHasTransport) {
                return 4;
            }
            if (z(this.g) && zHasTransport3) {
                return 3;
            }
            if (zHasTransport3) {
                return 1;
            }
            return zHasTransport2 ? 2 : 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    static class g extends ConnectivityManager.NetworkCallback {
        private AtomicBoolean dl = new AtomicBoolean(false);
        private final dl g;
        private z z;

        public g(z zVar, dl dlVar) {
            this.z = zVar;
            this.g = dlVar;
        }

        public void z(z zVar) {
            this.z = zVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (this.dl.compareAndSet(false, true)) {
                try {
                    this.g.dl = network;
                    this.z.z(network);
                    this.g.gc = false;
                } catch (Exception unused) {
                    this.g.dl = null;
                    this.z.z(null);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.g.gc = true;
        }
    }

    public void z(z zVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.g;
        if (connectivityManager == null) {
            zVar.z(null);
            return;
        }
        Network network = this.dl;
        if (network != null && !this.gc && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            zVar.z(this.dl);
            return;
        }
        g gVar = this.f1264a;
        if (gVar != null) {
            gVar.z(zVar);
            return;
        }
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        g gVar2 = new g(zVar, z);
        this.f1264a = gVar2;
        try {
            this.g.requestNetwork(networkRequestBuild, gVar2);
        } catch (Exception unused) {
            zVar.z(null);
        }
    }

    public synchronized void g() {
        ConnectivityManager connectivityManager = this.g;
        if (connectivityManager == null) {
            return;
        }
        try {
            try {
                g gVar = this.f1264a;
                if (gVar == null) {
                    return;
                }
                connectivityManager.unregisterNetworkCallback(gVar);
            } catch (Exception unused) {
            }
        } finally {
            this.f1264a = null;
            this.dl = null;
        }
    }
}
