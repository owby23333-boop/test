package com.google.android.play.core.a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T extends IInterface> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Handler> f6913a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f6914b;
    private final com.google.android.play.core.splitcompat.b.b c;
    private final String d;
    private boolean f;
    private final Intent g;
    private final g<T> h;
    private final WeakReference<f> i;
    private ServiceConnection k;
    private T l;
    private final List<a> e = new ArrayList();
    private final IBinder.DeathRecipient j = new IBinder.DeathRecipient(this) { // from class: com.google.android.play.core.a.c

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f6915a;

        {
            this.f6915a = this;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            this.f6915a.c();
        }
    };

    public b(Context context, com.google.android.play.core.splitcompat.b.b bVar, String str, Intent intent, g<T> gVar, f fVar) {
        this.f6914b = context;
        this.c = bVar;
        this.d = str;
        this.g = intent;
        this.h = gVar;
        this.i = new WeakReference<>(fVar);
    }

    public static /* synthetic */ ServiceConnection a(b bVar, ServiceConnection serviceConnection) {
        bVar.k = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        this.c.a("unlinkToDeath", new Object[0]);
        this.l.asBinder().unlinkToDeath(this.j, 0);
    }

    public final T b() {
        return this.l;
    }

    private final Handler d() {
        Handler handler;
        Map<String, Handler> map = f6913a;
        synchronized (map) {
            if (!map.containsKey(this.d)) {
                HandlerThread handlerThread = new HandlerThread(this.d, 10);
                handlerThread.start();
                map.put(this.d, new Handler(handlerThread.getLooper()));
            }
            handler = map.get(this.d);
        }
        return handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        this.c.a("linkToDeath", new Object[0]);
        try {
            this.l.asBinder().linkToDeath(this.j, 0);
        } catch (RemoteException e) {
            this.c.a(e, "linkToDeath failed", new Object[0]);
        }
    }

    public final /* synthetic */ void c() {
        this.c.a("reportBinderDeath", new Object[0]);
        f fVar = this.i.get();
        if (fVar != null) {
            this.c.a("calling onBinderDied", new Object[0]);
            fVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(a aVar) {
        byte b2 = 0;
        if (this.l != null || this.f) {
            if (!this.f) {
                aVar.run();
                return;
            } else {
                this.c.a("Waiting to bind to the service.", new Object[0]);
                this.e.add(aVar);
                return;
            }
        }
        this.c.a("Initiate binding to the service.", new Object[0]);
        this.e.add(aVar);
        h hVar = new h(this, b2);
        this.k = hVar;
        this.f = true;
        if (this.f6914b.bindService(this.g, hVar, 1)) {
            return;
        }
        this.c.a("Failed to bind to the service.", new Object[0]);
        this.f = false;
        Iterator<a> it = this.e.iterator();
        while (it.hasNext()) {
            com.google.android.play.core.tasks.i<?> iVarA = it.next().a();
            if (iVarA != null) {
                iVarA.a((Exception) new k());
            }
        }
        this.e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(a aVar) {
        d().post(aVar);
    }

    public final void a() {
        c(new e(this));
    }

    public final void a(a aVar) {
        c(new d(this, aVar));
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.f = false;
        return false;
    }
}
