package com.kwad.sdk.core.videocache;

import android.content.Context;
import android.net.Uri;
import com.kwad.sdk.core.network.kwai.a;
import com.kwad.sdk.utils.an;
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

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private final Object anc;
    private final ExecutorService and;
    private final Map<String, g> ane;
    private final ServerSocket anf;
    private final Thread ang;
    private final com.kwad.sdk.core.videocache.c anh;
    private final int port;

    public static final class a {
        private File amQ;
        private com.kwad.sdk.core.videocache.c.b amT;
        private com.kwad.sdk.core.videocache.kwai.a amS = new com.kwad.sdk.core.videocache.kwai.g(536870912);
        private com.kwad.sdk.core.videocache.kwai.c amR = new com.kwad.sdk.core.videocache.kwai.f();
        private com.kwad.sdk.core.videocache.a.b amU = new com.kwad.sdk.core.videocache.a.a();

        public a(Context context) {
            this.amT = com.kwad.sdk.core.videocache.c.c.bn(context);
            this.amQ = n.bk(context);
        }

        private com.kwad.sdk.core.videocache.c yL() {
            return new com.kwad.sdk.core.videocache.c(this.amQ, this.amR, this.amS, this.amT, this.amU);
        }

        public final a T(long j2) {
            this.amS = new com.kwad.sdk.core.videocache.kwai.g(104857600L);
            return this;
        }

        public final f yK() {
            return new f(yL(), (byte) 0);
        }
    }

    final class b implements Runnable {
        private final Socket ani;

        public b(Socket socket) {
            this.ani = socket;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "schedule SocketProcessorRunnable run");
            f.this.a(this.ani);
        }
    }

    final class c implements Runnable {
        private final CountDownLatch ank;

        public c(CountDownLatch countDownLatch) {
            this.ank = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.ank.countDown();
                f.this.yI();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    private f(com.kwad.sdk.core.videocache.c cVar) {
        this.anc = new Object();
        this.and = com.kwad.sdk.core.threads.b.yd();
        this.ane = new ConcurrentHashMap();
        this.anh = (com.kwad.sdk.core.videocache.c) an.checkNotNull(cVar);
        try {
            this.anf = new ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"));
            this.port = this.anf.getLocalPort();
            i.install("127.0.0.1", this.port);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.ang = new Thread(new c(countDownLatch));
            this.ang.start();
            countDownLatch.await();
        } catch (IOException | InterruptedException e2) {
            this.and.shutdown();
            throw new IllegalStateException("Error starting local proxy server", e2);
        }
    }

    /* synthetic */ f(com.kwad.sdk.core.videocache.c cVar, byte b2) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.kwad.sdk.core.videocache.f] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public void a(Socket socket) {
        ?? sb;
        ?? YJ = "Opened connections: ";
        try {
            try {
                d dVarB = d.b(socket.getInputStream());
                com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "Request to cache proxy:" + dVarB);
                cF(k.decode(dVarB.uri)).a(dVarB, socket);
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (ProxyCacheException e2) {
                e = e2;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (SocketException e3) {
                com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "Closing socket… Socket is closed by client.");
                e3.printStackTrace();
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            } catch (IOException e4) {
                e = e4;
                onError(new ProxyCacheException("Error processing request", e));
                b(socket);
                sb = new StringBuilder("Opened connections: ");
            }
            YJ = yJ();
            sb.append(YJ);
            socket = sb.toString();
            com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", socket);
        } catch (Throwable th) {
            b(socket);
            com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", ((String) YJ) + yJ());
            throw th;
        }
    }

    private File aM(String str) {
        com.kwad.sdk.core.videocache.c cVar = this.anh;
        return new File(cVar.amQ, cVar.amR.generate(str));
    }

    private String b(String str, boolean z2) {
        if (!aM(str).exists()) {
            return cD(str);
        }
        File fileAM = aM(str);
        m(fileAM);
        return Uri.fromFile(fileAM).toString();
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
            com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "Releasing input stream… Socket is closed by client.");
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error closing socket input stream", e2));
        }
    }

    private boolean cA(String str) {
        an.ae(str, "Url can't be null!");
        return aM(str).exists();
    }

    private String cD(String str) {
        return String.format(Locale.US, "http://%s:%d/%s", "127.0.0.1", Integer.valueOf(this.port), k.encode(str));
    }

    private File cE(String str) {
        return new File(this.anh.amQ, this.anh.amR.generate(str) + ".download");
    }

    private g cF(String str) {
        g gVar;
        synchronized (this.anc) {
            gVar = this.ane.get(str);
            if (gVar == null) {
                gVar = new g(str, this.anh);
                this.ane.put(str, gVar);
            }
        }
        return gVar;
    }

    private static void d(Socket socket) {
        try {
            if (socket.isOutputShutdown()) {
                return;
            }
            socket.shutdownOutput();
        } catch (IOException unused) {
            com.kwad.sdk.core.d.b.w("HttpProxyCacheServer", "Failed to close socket on proxy side: {}. It seems client have already closed connection.");
        }
    }

    private void e(Socket socket) {
        try {
            if (socket.isClosed()) {
                return;
            }
            socket.close();
        } catch (IOException e2) {
            onError(new ProxyCacheException("Error closing socket", e2));
        }
    }

    private void m(File file) {
        try {
            this.anh.amS.n(file);
        } catch (IOException unused) {
            com.kwad.sdk.core.d.b.e("HttpProxyCacheServer", "Error touching file " + file);
        }
    }

    private static void onError(Throwable th) {
        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yI() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Socket socketAccept = this.anf.accept();
                com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "Accept new socket " + socketAccept);
                this.and.submit(new b(socketAccept));
            } catch (IOException e2) {
                onError(new ProxyCacheException("Error during waiting connection", e2));
                return;
            }
        }
    }

    private int yJ() {
        int iYJ;
        synchronized (this.anc) {
            iYJ = 0;
            Iterator<g> it = this.ane.values().iterator();
            while (it.hasNext()) {
                iYJ += it.next().yJ();
            }
        }
        return iYJ;
    }

    public final boolean a(String str, int i2, a.C0442a c0442a) {
        com.kwad.sdk.core.d.b.d("HttpProxyCacheServer", "preloadSync preloadUrl " + str);
        if (cA(str)) {
            return true;
        }
        return com.kwad.sdk.core.network.kwai.a.a(cD(str), null, c0442a, i2);
    }

    public final boolean cB(String str) {
        an.ae(str, "Url can't be null!");
        return cE(str).exists() || aM(str).exists();
    }

    public final boolean cC(String str) {
        g gVar = this.ane.get(str);
        if (gVar == null) {
            return false;
        }
        gVar.shutdown();
        this.ane.remove(str);
        return true;
    }

    public final String cz(String str) {
        return b(str, true);
    }
}
