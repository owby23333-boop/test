package com.bumptech.glide.l;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.l.c;
import com.bumptech.glide.util.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: SingletonConnectivityReceiver.java */
/* JADX INFO: loaded from: classes2.dex */
final class s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile s f13400d;
    private final c a;

    @GuardedBy("this")
    final Set<c.a> b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f13401c;

    /* JADX INFO: compiled from: SingletonConnectivityReceiver.java */
    class a implements f.b<ConnectivityManager> {
        final /* synthetic */ Context a;

        a(s sVar, Context context) {
            this.a = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.f.b
        public ConnectivityManager get() {
            return (ConnectivityManager) this.a.getSystemService("connectivity");
        }
    }

    /* JADX INFO: compiled from: SingletonConnectivityReceiver.java */
    class b implements c.a {
        b() {
        }

        @Override // com.bumptech.glide.l.c.a
        public void a(boolean z2) {
            ArrayList arrayList;
            synchronized (s.this) {
                arrayList = new ArrayList(s.this.b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((c.a) it.next()).a(z2);
            }
        }
    }

    /* JADX INFO: compiled from: SingletonConnectivityReceiver.java */
    private interface c {
        void a();

        boolean register();
    }

    /* JADX INFO: compiled from: SingletonConnectivityReceiver.java */
    @RequiresApi(24)
    private static final class d implements c {
        boolean a;
        final c.a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f.b<ConnectivityManager> f13402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ConnectivityManager.NetworkCallback f13403d = new a();

        /* JADX INFO: compiled from: SingletonConnectivityReceiver.java */
        class a extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: renamed from: com.bumptech.glide.l.s$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SingletonConnectivityReceiver.java */
            class RunnableC0256a implements Runnable {

                /* JADX INFO: renamed from: s, reason: collision with root package name */
                final /* synthetic */ boolean f13404s;

                RunnableC0256a(boolean z2) {
                    this.f13404s = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(this.f13404s);
                }
            }

            a() {
            }

            private void b(boolean z2) {
                com.bumptech.glide.util.l.a(new RunnableC0256a(z2));
            }

            void a(boolean z2) {
                com.bumptech.glide.util.l.b();
                d dVar = d.this;
                boolean z3 = dVar.a;
                dVar.a = z2;
                if (z3 != z2) {
                    dVar.b.a(z2);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(@NonNull Network network) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(@NonNull Network network) {
                b(false);
            }
        }

        d(f.b<ConnectivityManager> bVar, c.a aVar) {
            this.f13402c = bVar;
            this.b = aVar;
        }

        @Override // com.bumptech.glide.l.s.c
        public void a() {
            this.f13402c.get().unregisterNetworkCallback(this.f13403d);
        }

        @Override // com.bumptech.glide.l.s.c
        @SuppressLint({"MissingPermission"})
        public boolean register() {
            this.a = this.f13402c.get().getActiveNetwork() != null;
            try {
                this.f13402c.get().registerDefaultNetworkCallback(this.f13403d);
                return true;
            } catch (RuntimeException unused) {
                Log.isLoggable("ConnectivityMonitor", 5);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: SingletonConnectivityReceiver.java */
    private static final class e implements c {
        private final Context a;
        final c.a b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f.b<ConnectivityManager> f13406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f13407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final BroadcastReceiver f13408e = new a();

        /* JADX INFO: compiled from: SingletonConnectivityReceiver.java */
        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@NonNull Context context, Intent intent) {
                e eVar = e.this;
                boolean z2 = eVar.f13407d;
                eVar.f13407d = eVar.b();
                if (z2 != e.this.f13407d) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        String str = "connectivity changed, isConnected: " + e.this.f13407d;
                    }
                    e eVar2 = e.this;
                    eVar2.b.a(eVar2.f13407d);
                }
            }
        }

        e(Context context, f.b<ConnectivityManager> bVar, c.a aVar) {
            this.a = context.getApplicationContext();
            this.f13406c = bVar;
            this.b = aVar;
        }

        @Override // com.bumptech.glide.l.s.c
        public void a() {
            this.a.unregisterReceiver(this.f13408e);
        }

        @SuppressLint({"MissingPermission"})
        boolean b() {
            try {
                NetworkInfo activeNetworkInfo = this.f13406c.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException unused) {
                Log.isLoggable("ConnectivityMonitor", 5);
                return true;
            }
        }

        @Override // com.bumptech.glide.l.s.c
        public boolean register() {
            this.f13407d = b();
            try {
                this.a.registerReceiver(this.f13408e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                return true;
            } catch (SecurityException unused) {
                Log.isLoggable("ConnectivityMonitor", 5);
                return false;
            }
        }
    }

    private s(@NonNull Context context) {
        f.b bVarA = com.bumptech.glide.util.f.a(new a(this, context));
        b bVar = new b();
        this.a = Build.VERSION.SDK_INT >= 24 ? new d(bVarA, bVar) : new e(context, bVarA, bVar);
    }

    static s a(@NonNull Context context) {
        if (f13400d == null) {
            synchronized (s.class) {
                if (f13400d == null) {
                    f13400d = new s(context.getApplicationContext());
                }
            }
        }
        return f13400d;
    }

    synchronized void b(c.a aVar) {
        this.b.remove(aVar);
        b();
    }

    @GuardedBy("this")
    private void b() {
        if (this.f13401c && this.b.isEmpty()) {
            this.a.a();
            this.f13401c = false;
        }
    }

    synchronized void a(c.a aVar) {
        this.b.add(aVar);
        a();
    }

    @GuardedBy("this")
    private void a() {
        if (this.f13401c || this.b.isEmpty()) {
            return;
        }
        this.f13401c = this.a.register();
    }
}
