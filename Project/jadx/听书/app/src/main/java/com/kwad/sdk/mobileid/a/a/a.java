package com.kwad.sdk.mobileid.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private ConnectivityManager.NetworkCallback aTn;
    private ConnectivityManager aTo;
    private volatile boolean aTp = false;

    /* JADX INFO: renamed from: com.kwad.sdk.mobileid.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0422a {
        void Ny();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.aTp = true;
        return true;
    }

    public final void a(Context context, final InterfaceC0422a interfaceC0422a) {
        synchronized (this) {
            this.aTo = ck(context);
            try {
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
                if (this.aTn == null) {
                    this.aTn = new ConnectivityManager.NetworkCallback() { // from class: com.kwad.sdk.mobileid.a.a.a.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onAvailable(Network network) {
                            a.this.aTo.bindProcessToNetwork(network);
                            if (interfaceC0422a != null && !a.this.aTp) {
                                interfaceC0422a.Ny();
                            }
                            a.a(a.this, true);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onUnavailable() {
                            a.this.aTo.bindProcessToNetwork(null);
                            c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onUnavailable unbindNetwork");
                            a.this.Nt();
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onLost(Network network) {
                            a.this.aTo.bindProcessToNetwork(null);
                            c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onLost unbindNetwork");
                            a.this.Nt();
                        }
                    };
                }
                if (!this.aTp) {
                    this.aTo.requestNetwork(networkRequestBuild, this.aTn);
                } else {
                    c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "isRequestUaidToken is true unbindNetwork");
                    Nt();
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }

    public final void Nt() {
        synchronized (this) {
            if (this.aTn == null) {
                return;
            }
            try {
                ConnectivityManager connectivityManager = this.aTo;
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(this.aTn);
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
            this.aTo.bindProcessToNetwork(null);
            this.aTn = null;
        }
    }

    private static ConnectivityManager ck(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }
}
