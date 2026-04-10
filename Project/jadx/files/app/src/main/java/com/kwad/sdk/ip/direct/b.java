package com.kwad.sdk.ip.direct;

import android.os.SystemClock;
import com.kwad.sdk.utils.bh;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    static int ati = 80;
    static int port = 80;

    static class a extends Thread {
        LinkedList atk = new LinkedList();
        volatile boolean atl = false;
        Selector atj = Selector.open();

        a() {
            setName("Connector");
        }

        private void Bf() {
            synchronized (this.atk) {
                while (this.atk.size() > 0) {
                    C0455b c0455b = (C0455b) this.atk.removeFirst();
                    try {
                        c0455b.atn.register(this.atj, 8, c0455b);
                    } catch (Throwable th) {
                        c0455b.atn.close();
                        c0455b.ato = th;
                    }
                }
            }
        }

        private void Bg() {
            Iterator<SelectionKey> it = this.atj.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0455b c0455b = (C0455b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0455b.atr = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bh.c(socketChannel);
                    c0455b.ato = th;
                }
            }
        }

        final void a(C0455b c0455b) {
            SocketChannel socketChannelOpen;
            try {
                socketChannelOpen = SocketChannel.open();
            } catch (Throwable th) {
                th = th;
                socketChannelOpen = null;
            }
            try {
                socketChannelOpen.configureBlocking(false);
                boolean zConnect = socketChannelOpen.connect(c0455b.atm);
                c0455b.atn = socketChannelOpen;
                c0455b.atq = SystemClock.elapsedRealtime();
                if (zConnect) {
                    c0455b.atr = c0455b.atq;
                    bh.c(socketChannelOpen);
                    return;
                }
                synchronized (this.atk) {
                    this.atk.add(c0455b);
                }
                if (this.atj != null) {
                    try {
                        this.atj.wakeup();
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bh.c(socketChannelOpen);
                c0455b.ato = th;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.atj.select() > 0) {
                        Bg();
                    }
                    Bf();
                    if (this.atl) {
                        if (this.atj != null) {
                            try {
                                this.atj.close();
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

        final void shutdown() {
            this.atl = true;
            Selector selector = this.atj;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.ip.direct.b$b, reason: collision with other inner class name */
    static class C0455b {
        InetSocketAddress atm;
        SocketChannel atn;
        Throwable ato;
        private float atp;
        long atq;
        long atr = 0;
        boolean ats = false;
        private boolean success;

        C0455b(String str) {
            try {
                this.atm = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.ato = th;
            }
        }

        final void Bh() {
            String string;
            if (this.atr != 0) {
                string = Long.toString(this.atr - this.atq) + "ms";
                this.atp = this.atr - this.atq;
                this.success = true;
            } else {
                Throwable th = this.ato;
                if (th != null) {
                    string = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    string = "Timed out";
                }
            }
            com.kwad.sdk.core.d.b.d("IpDirect_Ping", this.atm + " : " + string);
            this.ats = true;
        }
    }

    public static c f(String str, long j2) {
        a aVar;
        long j3 = j2 / 5;
        com.kwad.sdk.core.d.b.d("IpDirect_Ping", "ping:" + str);
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
            LinkedList<C0455b> linkedList = new LinkedList();
            for (int i2 = 0; i2 < cVar.Bi(); i2++) {
                C0455b c0455b = new C0455b(str);
                linkedList.add(c0455b);
                try {
                    aVar.a(c0455b);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            try {
                Thread.sleep(j2 + j3);
                try {
                    aVar.shutdown();
                    aVar.join();
                    float f2 = 0.0f;
                    boolean z2 = true;
                    for (C0455b c0455b2 : linkedList) {
                        c0455b2.Bh();
                        z2 &= c0455b2.success;
                        cVar.bg(z2);
                        f2 += c0455b2.atp;
                    }
                    com.kwad.sdk.core.d.b.d("IpDirect_Ping", "sum:" + f2 + "*size:" + linkedList.size());
                    cVar.i(f2 / ((float) linkedList.size()));
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
}
