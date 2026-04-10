package com.xiaomi.onetrack.api;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.xiaomi.onetrack.OneTrack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7546a = "BroadcastManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7547b = "onetrack_broadcast_manager";
    private static volatile c c = null;
    private static final int e = 10;
    private static final int f = 100;
    private static final int g = 101;
    private static volatile boolean h = false;
    private static volatile boolean j = false;
    private Handler d;
    private CopyOnWriteArrayList<j> i = new CopyOnWriteArrayList<>();
    private AtomicBoolean k = new AtomicBoolean(false);
    private boolean l = false;
    private boolean m = false;
    private BroadcastReceiver n = new d(this);
    private BroadcastReceiver o = new e(this);

    public class a extends Handler {
        public /* synthetic */ a(c cVar, Looper looper, d dVar) {
            this(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean zA;
            if (message == null) {
                return;
            }
            int i = message.what;
            if (i == 100 || i == 101) {
                try {
                    c.this.a(i);
                } catch (Exception e) {
                    com.xiaomi.onetrack.util.p.a(c.f7546a, "screenReceiver exception: ", e);
                }
            }
            if (message.what == 10) {
                if (c.this.k.get()) {
                    try {
                        if (OneTrack.isRestrictGetNetworkInfo()) {
                            zA = com.xiaomi.onetrack.b.n.c();
                            com.xiaomi.onetrack.b.n.b(!zA);
                        } else {
                            zA = com.xiaomi.onetrack.g.c.a();
                            com.xiaomi.onetrack.b.n.b(zA);
                        }
                        com.xiaomi.onetrack.util.p.a(c.f7546a, "Only one of allowed NetworkInfo :" + OneTrack.isRestrictGetNetworkInfo() + " ,network status changed, isNetworkConnected: " + com.xiaomi.onetrack.b.n.c());
                        if (zA) {
                            if (c.this.l) {
                                com.xiaomi.onetrack.a.c.b.a().a(com.xiaomi.onetrack.b.n.c());
                            }
                            if (c.this.m) {
                                com.xiaomi.onetrack.c.s.a().a(com.xiaomi.onetrack.b.n.c());
                            }
                        }
                    } catch (Throwable th) {
                        com.xiaomi.onetrack.util.p.b(c.f7546a, "MESSAGE_BROADCAST_NET_RECEIVER throwable:" + th.getMessage());
                    }
                }
                c.this.k.set(true);
            }
        }

        private a(Looper looper) {
            super(looper);
        }
    }

    private c() {
        try {
            HandlerThread handlerThread = new HandlerThread(f7547b);
            handlerThread.start();
            this.d = new a(this, handlerThread.getLooper(), null);
        } catch (Throwable unused) {
        }
    }

    private void g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        com.xiaomi.onetrack.f.a.b().registerReceiver(this.n, intentFilter);
        Log.d(com.xiaomi.onetrack.util.p.a(f7546a), "register screen receiver");
    }

    private void h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        com.xiaomi.onetrack.f.a.b().registerReceiver(this.o, intentFilter);
        Log.d(com.xiaomi.onetrack.util.p.a(f7546a), "register net receiver");
    }

    public void e() {
        if (h) {
            return;
        }
        h = true;
        try {
            g();
        } catch (Throwable unused) {
            h = false;
        }
    }

    public void f() {
        if (j) {
            return;
        }
        j = true;
        boolean zB = com.xiaomi.onetrack.g.c.b();
        com.xiaomi.onetrack.util.p.a(f7546a, "Get network status for the first time, isNetworkConnected: " + zB);
        com.xiaomi.onetrack.b.n.b(zB);
        try {
            h();
        } catch (Throwable unused) {
            j = false;
        }
    }

    public static void b() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
    }

    public void c() {
        this.l = true;
    }

    public void d() {
        this.m = true;
    }

    public static c a() {
        if (c == null) {
            b();
        }
        return c;
    }

    public void a(j jVar) {
        if (this.i.contains(jVar)) {
            return;
        }
        this.i.add(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        for (j jVar : this.i) {
            if (i == 100) {
                jVar.a(true);
            } else if (i == 101) {
                jVar.a(false);
            }
        }
    }
}
