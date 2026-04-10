package com.anythink.expressad.exoplayer.scheduler;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String a = "RequirementsWatcher";
    private final Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f10055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.scheduler.a f10056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private C0203b f10057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f10059g;

    @RequiresApi(api = 21)
    private final class a extends ConnectivityManager.NetworkCallback {
        private a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            super.onAvailable(network);
            StringBuilder sb = new StringBuilder();
            sb.append(b.this);
            sb.append(" NetworkCallback.onAvailable");
            b.this.a(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            super.onLost(network);
            StringBuilder sb = new StringBuilder();
            sb.append(b.this);
            sb.append(" NetworkCallback.onLost");
            b.this.a(false);
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.scheduler.b$b, reason: collision with other inner class name */
    private class C0203b extends BroadcastReceiver {
        private C0203b() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(b.this);
            sb.append(" received ");
            sb.append(intent.getAction());
            b.this.a(false);
        }

        /* synthetic */ C0203b(b bVar, byte b) {
            this();
        }
    }

    public interface c {
        void a();

        void b();
    }

    private b(Context context, c cVar, com.anythink.expressad.exoplayer.scheduler.a aVar) {
        this.f10056d = aVar;
        this.f10055c = cVar;
        this.b = context.getApplicationContext();
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(" created");
    }

    private void b() {
        this.b.unregisterReceiver(this.f10057e);
        this.f10057e = null;
        if (this.f10059g != null && af.a >= 21) {
            ((ConnectivityManager) this.b.getSystemService("connectivity")).unregisterNetworkCallback(this.f10059g);
            this.f10059g = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(" stopped");
    }

    private com.anythink.expressad.exoplayer.scheduler.a c() {
        return this.f10056d;
    }

    @TargetApi(23)
    private void d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(16).build();
        this.f10059g = new a(this, (byte) 0);
        connectivityManager.registerNetworkCallback(networkRequestBuild, this.f10059g);
    }

    private void e() {
        if (af.a >= 21) {
            ((ConnectivityManager) this.b.getSystemService("connectivity")).unregisterNetworkCallback(this.f10059g);
            this.f10059g = null;
        }
    }

    private static void f() {
    }

    private static /* synthetic */ void g() {
    }

    public final String toString() {
        return super.toString();
    }

    private void a() {
        com.anythink.expressad.exoplayer.k.a.a(Looper.myLooper());
        a(true);
        IntentFilter intentFilter = new IntentFilter();
        byte b = 0;
        if (this.f10056d.a() != 0) {
            if (af.a >= 23) {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(16).build();
                this.f10059g = new a(this, b);
                connectivityManager.registerNetworkCallback(networkRequestBuild, this.f10059g);
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.f10056d.b()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.f10056d.c()) {
            if (af.a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        this.f10057e = new C0203b(this, b);
        this.b.registerReceiver(this.f10057e, intentFilter, null, new Handler());
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append(" started");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        boolean zA = this.f10056d.a(this.b);
        if (z2 || zA != this.f10058f) {
            this.f10058f = zA;
        }
    }
}
