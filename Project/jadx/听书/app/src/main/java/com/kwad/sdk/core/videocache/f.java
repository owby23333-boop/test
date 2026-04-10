package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.ax;
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

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    private final Object aKY;
    private final ExecutorService aKZ;
    private final Map<String, g> aLa;
    private final ServerSocket aLb;
    private final Thread aLc;
    private final com.kwad.sdk.core.videocache.c aLd;
    private final int port;

    /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b2) {
        this(cVar);
    }

    private f(com.kwad.sdk.core.videocache.c cVar) {
        this.aKY = new Object();
        this.aKZ = GlobalThreadPools.Jw();
        this.aLa = new ConcurrentHashMap();
        this.aLd = (com.kwad.sdk.core.videocache.c) ax.checkNotNull(cVar);
        try {
            ServerSocket serverSocket = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.aLb = serverSocket;
            int localPort = serverSocket.getLocalPort();
            this.port = localPort;
            i.install("127.0.0.1", localPort);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new c(countDownLatch));
            this.aLc = thread;
            thread.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e) {
            this.aKZ.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e);
        }
    }

    public final String eJ(String str) {
        return str == null ? "" : f(str, true);
    }

    private String f(String str, boolean z) {
        if (aa(str).exists()) {
            File fileAa = aa(str);
            r(fileAa);
            return Uri.fromFile(fileAa).toString();
        }
        return eN(str);
    }

    public final boolean a(String str, long j, a.C0405a c0405a, AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (eK(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.a.a.a(eN(str), null, c0405a, j, false, adHttpResponseListener);
    }

    public final boolean eK(String str) {
        ax.ax(str, "Url can't be null!");
        return aa(str).exists();
    }

    public final boolean eL(String str) {
        ax.ax(str, "Url can't be null!");
        return eO(str).exists() || aa(str).exists();
    }

    public final boolean eM(String str) {
        g gVar = this.aLa.get(str);
        if (gVar == null) {
            return false;
        }
        gVar.shutdown();
        this.aLa.remove(str);
        return true;
    }

    private String eN(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.port), l.encode(str));
    }

    private File aa(String str) {
        return new File(this.aLd.aKK, this.aLd.aKL.generate(str));
    }

    private File eO(String str) {
        return new File(this.aLd.aKK, this.aLd.aKL.generate(str) + ".download");
    }

    private void r(File file) {
        try {
            this.aLd.aKM.s(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kl() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.aLb.accept();
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Accept new socket " + socketAccept);
                this.aKZ.submit(new b(socketAccept));
            } catch (IOException e) {
                onError(new ProxyCacheException("Error during waiting connection", e));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.String] */
    public void a(Socket socket) {
        ?? sb;
        ?? Km = "Opened connections: ";
        try {
            try {
                d dVarB = d.b(socket.getInputStream());
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Request to cache proxy:" + dVarB);
                eP(l.decode(dVarB.uri)).a(dVarB, socket);
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e) {
                e = e;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (SocketException e2) {
                com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e2.printStackTrace();
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (IOException e3) {
                e = e3;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            }
            Km = Km();
            socket = sb.append(Km).toString();
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", (String) socket);
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", ((String) Km) + Km());
            throw th;
        }
    }

    private g eP(String str) {
        g gVar;
        synchronized (this.aKY) {
            gVar = this.aLa.get(str);
            if (gVar == null) {
                gVar = new g(str, this.aLd);
                this.aLa.put(str, gVar);
            }
        }
        return gVar;
    }

    private int Km() {
        int iKm;
        synchronized (this.aKY) {
            Iterator<g> it = this.aLa.values().iterator();
            iKm = 0;
            while (it.hasNext()) {
                iKm += it.next().Km();
            }
        }
        return iKm;
    }

    private void b(Socket socket) {
        c(socket);
        d(socket);
        e(socket);
    }

    private void c(Socket socket) {
        try {
            if (socket.isInputShutdown()) {
                return;
            }
            socket.shutdownInput();
        } catch (SocketException unused) {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket input stream", e));
        }
    }

    private static void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            com.kwad.sdk.core.d.c.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e) {
            onError(new ProxyCacheException("Error closing socket", e));
        }
    }

    private static void onError(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTraceOnly(th);
    }

    final class c implements Runnable {
        private final CountDownLatch aLg;

        public c(CountDownLatch countDownLatch) {
            this.aLg = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.aLg.countDown();
                f.this.Kl();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
        }
    }

    final class b implements Runnable {
        private final Socket aLe;

        public b(Socket socket) {
            this.aLe = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.aLe);
        }
    }

    public static final class a {
        private File aKK;
        private com.kwad.sdk.core.videocache.d.c aKN;
        private int aKP;
        private Context context;
        private int aKQ = 0;
        private com.kwad.sdk.core.videocache.a.a aKM = new com.kwad.sdk.core.videocache.a.g(536870912);
        private com.kwad.sdk.core.videocache.a.c aKL = new com.kwad.sdk.core.videocache.a.f();
        private com.kwad.sdk.core.videocache.b.b aKO = new com.kwad.sdk.core.videocache.b.a();

        public a(Context context) {
            this.context = context;
            this.aKK = o.bQ(context);
        }

        public final a aJ(long j) {
            this.aKM = new com.kwad.sdk.core.videocache.a.g(536870912L);
            return this;
        }

        public final a dN(int i) {
            this.aKP = i;
            return this;
        }

        public final a dO(int i) {
            this.aKQ = i;
            return this;
        }

        public final f Kn() {
            this.aKN = com.kwad.sdk.core.videocache.d.d.k(this.context, this.aKQ);
            return new f(Ko(), (byte) 0);
        }

        private com.kwad.sdk.core.videocache.c Ko() {
            return new com.kwad.sdk.core.videocache.c(this.aKK, this.aKL, this.aKM, this.aKN, this.aKO, this.aKP, this.aKQ);
        }
    }
}
