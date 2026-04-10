package com.anythink.core.common.g.a;

import com.anythink.core.common.b.n;
import com.anythink.core.common.g.a.c;
import com.anythink.core.common.k.h;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static d f7449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f7454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Socket f7456j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7450c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f7451d = 7;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f7452e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f7453f = d.class.getSimpleName();
    byte[] a = null;
    byte[] b = new byte[1];

    /* JADX INFO: renamed from: com.anythink.core.common.g.a.d$1, reason: invalid class name */
    final class AnonymousClass1 extends com.anythink.core.common.k.b.b {
        final /* synthetic */ c a;
        final /* synthetic */ c.a b;

        AnonymousClass1(c cVar, c.a aVar) {
            this.a = cVar;
            this.b = aVar;
        }

        @Override // com.anythink.core.common.k.b.b
        public final void a() {
            try {
                try {
                    d.this.a(this.a);
                    int iE = d.this.e();
                    if (iE != 1) {
                        throw new Exception("Response Error Code:".concat(String.valueOf(iE)));
                    }
                    if (this.b != null) {
                        this.b.a(this.a);
                    }
                } catch (SocketException unused) {
                    d.b(d.this);
                    d.this.a(this.a);
                    int iE2 = d.this.e();
                    if (iE2 != 1) {
                        throw new Exception("Response Error Code:".concat(String.valueOf(iE2)));
                    }
                    if (this.b != null) {
                        this.b.a(this.a);
                    }
                }
            } catch (Throwable th) {
                this.a.a("", th.getMessage() + "," + h.a(th.getStackTrace()), d.this.f7454h, d.this.f7455i);
                c.a aVar = this.b;
                if (aVar != null) {
                    aVar.a(th);
                }
            }
        }
    }

    private d() {
    }

    private void b() {
        synchronized (this) {
            if (this.f7456j == null) {
                this.f7456j = new Socket();
                this.f7456j.setSoTimeout(BaseConstants.Time.MINUTE);
            }
            com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
            if (aVarB != null) {
                this.f7454h = aVarB.v();
                this.f7455i = aVarB.w();
                this.f7456j.connect(new InetSocketAddress(this.f7454h, this.f7455i), 30000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int e() {
        byte b;
        if (this.f7456j.getInputStream().read(this.b, 0, 1) == -1) {
            throw new SocketException("Socket.InputStream read length = -1!");
        }
        b = this.b[0];
        this.b[0] = 0;
        return b;
    }

    private void c() {
        synchronized (this) {
            try {
                if (this.f7456j != null) {
                    this.f7456j.close();
                    this.f7456j = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    private boolean d() {
        Socket socket = this.f7456j;
        return (socket == null || !socket.isConnected() || this.f7456j.isClosed()) ? false : true;
    }

    protected static synchronized d a() {
        if (f7449g == null) {
            f7449g = new d();
        }
        return f7449g;
    }

    private void a(c cVar, c.a aVar) {
        com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) new AnonymousClass1(cVar, aVar), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(c cVar) {
        if (!((this.f7456j == null || !this.f7456j.isConnected() || this.f7456j.isClosed()) ? false : true)) {
            synchronized (this) {
                if (this.f7456j == null) {
                    this.f7456j = new Socket();
                    this.f7456j.setSoTimeout(BaseConstants.Time.MINUTE);
                }
                com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
                if (aVarB != null) {
                    this.f7454h = aVarB.v();
                    this.f7455i = aVarB.w();
                    this.f7456j.connect(new InetSocketAddress(this.f7454h, this.f7455i), 30000);
                }
            }
        }
        byte[] bArrE = cVar.e();
        if (bArrE != null) {
            int length = bArrE.length;
            if (bArrE.length == 0) {
                return;
            }
            int i2 = length + 7;
            if (this.a == null || this.a.length < i2) {
                this.a = new byte[i2];
            }
            this.a[0] = 0;
            this.a[1] = 3;
            this.a[2] = (byte) cVar.c();
            this.a[3] = (byte) ((length >>> 24) & 255);
            this.a[4] = (byte) ((length >>> 16) & 255);
            this.a[5] = (byte) ((length >>> 8) & 255);
            this.a[6] = (byte) ((length >>> 0) & 255);
            System.arraycopy(bArrE, 0, this.a, 7, bArrE.length);
            OutputStream outputStream = this.f7456j.getOutputStream();
            outputStream.write(this.a, 0, i2);
            outputStream.flush();
        }
    }

    static /* synthetic */ void b(d dVar) {
        synchronized (dVar) {
            try {
                if (dVar.f7456j != null) {
                    dVar.f7456j.close();
                    dVar.f7456j = null;
                }
            } catch (Exception unused) {
            }
        }
    }
}
