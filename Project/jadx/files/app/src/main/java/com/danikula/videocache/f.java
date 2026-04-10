package com.danikula.videocache;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: HttpProxyCacheServer.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private final Object a;
    private final ExecutorService b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, g> f14760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ServerSocket f14761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f14762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Thread f14763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.danikula.videocache.c f14764g;

    /* JADX INFO: compiled from: HttpProxyCacheServer.java */
    public static final class b {
        private File a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.danikula.videocache.s.b f14766d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.danikula.videocache.q.a f14765c = new com.danikula.videocache.q.g(536870912);
        private com.danikula.videocache.q.c b = new com.danikula.videocache.q.f();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.danikula.videocache.r.b f14767e = new com.danikula.videocache.r.a();

        public b(Context context) {
            this.f14766d = com.danikula.videocache.s.c.a(context);
            this.a = p.b(context);
        }

        private com.danikula.videocache.c b() {
            return new com.danikula.videocache.c(this.a, this.b, this.f14765c, this.f14766d, this.f14767e);
        }

        public b a(long j2) {
            this.f14765c = new com.danikula.videocache.q.g(j2);
            return this;
        }

        public f a() {
            return new f(b());
        }
    }

    /* JADX INFO: compiled from: HttpProxyCacheServer.java */
    private final class c implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final Socket f14768s;

        public c(Socket socket) {
            this.f14768s = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.d(this.f14768s);
        }
    }

    /* JADX INFO: compiled from: HttpProxyCacheServer.java */
    private final class d implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final CountDownLatch f14770s;

        public d(CountDownLatch countDownLatch) {
            this.f14770s = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14770s.countDown();
            f.this.b();
        }
    }

    private String c(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.f14762e), m.c(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.danikula.videocache.f] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public void d(Socket socket) {
        ?? sb;
        ?? A = "Opened connections: ";
        try {
            try {
                com.danikula.videocache.d dVarA = com.danikula.videocache.d.a(socket.getInputStream());
                j.a("Request to cache proxy:" + dVarA);
                d(m.b(dVarA.a)).a(dVarA, socket);
                e(socket);
                sb = new StringBuilder();
            } catch (ProxyCacheException e2) {
                e = e2;
                a(new ProxyCacheException("Error processing request", e));
                e(socket);
                sb = new StringBuilder();
            } catch (SocketException unused) {
                j.a("Closing socket… Socket is closed by client.");
                e(socket);
                sb = new StringBuilder();
            } catch (IOException e3) {
                e = e3;
                a(new ProxyCacheException("Error processing request", e));
                e(socket);
                sb = new StringBuilder();
            }
            sb.append("Opened connections: ");
            A = a();
            sb.append(A);
            socket = sb.toString();
            j.a(socket);
        } catch (Throwable th) {
            e(socket);
            ?? sb2 = new StringBuilder();
            sb2.append(A);
            sb2.append(a());
            j.a(sb2.toString());
            throw th;
        }
    }

    private void e(Socket socket) {
        b(socket);
        c(socket);
        a(socket);
    }

    public String b(String str) {
        return a(str, true);
    }

    private f(com.danikula.videocache.c cVar) {
        this.a = new Object();
        this.b = Executors.newFixedThreadPool(8);
        this.f14760c = new ConcurrentHashMap();
        k.a(cVar);
        this.f14764g = cVar;
        try {
            this.f14761d = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.f14762e = this.f14761d.getLocalPort();
            i.a("127.0.0.1", this.f14762e);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f14763f = new Thread(new d(countDownLatch));
            this.f14763f.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e2) {
            this.b.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.f14761d.accept();
                j.a("Accept new socket " + socketAccept);
                this.b.submit(new c(socketAccept));
            } catch (IOException e2) {
                a(new ProxyCacheException("Error during waiting connection", e2));
                return;
            }
        }
    }

    private void c(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            j.d("Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    public String a(String str, boolean z2) {
        if (z2 && a(str).exists()) {
            File fileA = a(str);
            a(fileA);
            return Uri.fromFile(fileA).toString();
        }
        return c(str);
    }

    private void b(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            j.a("Releasing input stream… Socket is closed by client.");
        } catch (IOException e2) {
            a(new ProxyCacheException("Error closing socket input stream", e2));
        }
    }

    public File a(String str) {
        com.danikula.videocache.c cVar = this.f14764g;
        return new File(cVar.a, cVar.b.generate(str));
    }

    private void a(File file) {
        try {
            this.f14764g.f14751c.a(file);
        } catch (IOException unused) {
            j.b("Error touching file " + file);
        }
    }

    private int a() {
        int iA;
        synchronized (this.a) {
            iA = 0;
            Iterator<g> it = this.f14760c.values().iterator();
            while (it.hasNext()) {
                iA += it.next().a();
            }
        }
        return iA;
    }

    private g d(String str) throws ProxyCacheException {
        g gVar;
        synchronized (this.a) {
            gVar = this.f14760c.get(str);
            if (gVar == null) {
                gVar = new g(str, this.f14764g);
                this.f14760c.put(str, gVar);
            }
        }
        return gVar;
    }

    private void a(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e2) {
            a(new ProxyCacheException("Error closing socket", e2));
        }
    }

    private void a(Throwable th) {
        j.b("HttpProxyCacheServer error");
    }
}
