package com.danikula.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: HttpProxyCacheServerClients.java */
/* JADX INFO: loaded from: classes2.dex */
final class g {
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile e f14772c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f14774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f14775f;
    private final AtomicInteger a = new AtomicInteger(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<b> f14773d = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: HttpProxyCacheServerClients.java */
    private static final class a extends Handler implements b {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final String f14776s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final List<b> f14777t;

        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            this.f14776s = str;
            this.f14777t = list;
        }

        @Override // com.danikula.videocache.b
        public void a(File file, String str, int i2) {
            Message messageObtainMessage = obtainMessage();
            messageObtainMessage.arg1 = i2;
            messageObtainMessage.obj = file;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Iterator<b> it = this.f14777t.iterator();
            while (it.hasNext()) {
                it.next().a((File) message.obj, this.f14776s, message.arg1);
            }
        }
    }

    public g(String str, c cVar) {
        k.a(str);
        this.b = str;
        k.a(cVar);
        this.f14775f = cVar;
        this.f14774e = new a(str, this.f14773d);
    }

    private synchronized void b() {
        if (this.a.decrementAndGet() <= 0) {
            this.f14772c.a();
            this.f14772c = null;
        }
    }

    private e c() throws ProxyCacheException {
        String str = this.b;
        c cVar = this.f14775f;
        e eVar = new e(new h(str, cVar.f14752d, cVar.f14753e), new com.danikula.videocache.q.b(this.f14775f.a(this.b), this.f14775f.f14751c));
        eVar.a(this.f14774e);
        return eVar;
    }

    private synchronized void d() throws ProxyCacheException {
        this.f14772c = this.f14772c == null ? c() : this.f14772c;
    }

    public void a(d dVar, Socket socket) throws IOException, ProxyCacheException {
        d();
        try {
            this.a.incrementAndGet();
            this.f14772c.a(dVar, socket);
        } finally {
            b();
        }
    }

    public int a() {
        return this.a.get();
    }
}
