package com.kwad.sdk.ip.direct;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.utils.bw;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static Handler aRF = new Handler(Looper.getMainLooper());
    static int aRP = 80;
    static int port = 80;

    public static c f(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.d.c.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList<C0417b> linkedList = new LinkedList();
            for (int i = 0; i < cVar.MQ(); i++) {
                C0417b c0417b = new C0417b(str);
                c0417b.aRZ = j + j2;
                linkedList.add(c0417b);
                try {
                    aVar.a(c0417b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j + j2);
                try {
                    aVar.shutdown();
                    aVar.join();
                    boolean z = true;
                    float f = 0.0f;
                    for (C0417b c0417b2 : linkedList) {
                        c0417b2.MP();
                        z &= c0417b2.success;
                        cVar.bJ(z);
                        f += c0417b2.aRY;
                    }
                    com.kwad.sdk.core.d.c.d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                    cVar.k(f / linkedList.size());
                    return cVar;
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return cVar;
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.ip.direct.b$b, reason: collision with other inner class name */
    static class C0417b {
        InetSocketAddress aRV;
        SocketChannel aRW;
        Throwable aRX;
        private float aRY;
        long aRZ;
        long aSa;
        long aSb = 0;
        boolean aSc = false;
        private boolean success;

        C0417b(String str) {
            try {
                this.aRV = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.aRX = th;
            }
        }

        final void MP() {
            String string;
            if (this.aSb != 0) {
                string = Long.toString(this.aSb - this.aSa) + "ms";
                this.aRY = this.aSb - this.aSa;
                this.success = true;
            } else {
                Throwable th = this.aRX;
                if (th != null) {
                    string = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    string = "Timed out";
                }
            }
            com.kwad.sdk.core.d.c.d("IpDirect_Ping", this.aRV + " : " + string);
            this.aSc = true;
        }
    }

    static class a extends Thread {
        LinkedList aRR = new LinkedList();
        volatile boolean aRS = false;
        Selector aRQ = Selector.open();

        a() {
            setName("Connector");
        }

        final void a(C0417b c0417b) {
            final SocketChannel socketChannelOpen;
            try {
                socketChannelOpen = SocketChannel.open();
            } catch (Throwable th) {
                th = th;
                socketChannelOpen = null;
            }
            try {
                socketChannelOpen.configureBlocking(false);
                boolean zConnect = socketChannelOpen.connect(c0417b.aRV);
                c0417b.aRW = socketChannelOpen;
                c0417b.aSa = SystemClock.elapsedRealtime();
                if (zConnect) {
                    c0417b.aSb = c0417b.aSa;
                    bw.c(socketChannelOpen);
                } else {
                    synchronized (this.aRR) {
                        this.aRR.add(c0417b);
                    }
                    Selector selector = this.aRQ;
                    if (selector != null) {
                        try {
                            selector.wakeup();
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    bw.c(socketChannelOpen);
                    c0417b.aRX = th;
                    try {
                        b.aRF.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bw.c(socketChannelOpen);
                            }
                        }, c0417b.aRZ);
                    } catch (Throwable unused2) {
                    }
                } finally {
                    try {
                        b.aRF.postDelayed(new Runnable() { // from class: com.kwad.sdk.ip.direct.b.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                bw.c(socketChannelOpen);
                            }
                        }, c0417b.aRZ);
                    } catch (Throwable unused3) {
                    }
                }
            }
        }

        private void MN() {
            synchronized (this.aRR) {
                while (this.aRR.size() > 0) {
                    C0417b c0417b = (C0417b) this.aRR.removeFirst();
                    try {
                        c0417b.aRW.register(this.aRQ, 8, c0417b);
                    } catch (Throwable th) {
                        c0417b.aRW.close();
                        c0417b.aRX = th;
                    }
                }
            }
        }

        private void MO() {
            Iterator<SelectionKey> it = this.aRQ.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0417b c0417b = (C0417b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0417b.aSb = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bw.c(socketChannel);
                    c0417b.aRX = th;
                }
            }
        }

        final void shutdown() {
            this.aRS = true;
            Selector selector = this.aRQ;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.aRQ.select() > 0) {
                        MO();
                    }
                    MN();
                    if (this.aRS) {
                        Selector selector = this.aRQ;
                        if (selector != null) {
                            try {
                                selector.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    }
                    continue;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
