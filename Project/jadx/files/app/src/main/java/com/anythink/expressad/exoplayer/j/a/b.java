package com.anythink.expressad.exoplayer.j.a;

import com.anythink.expressad.exoplayer.j.a.a;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.anythink.expressad.exoplayer.j.g {
    public static final int a = 20480;
    private final com.anythink.expressad.exoplayer.j.a.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f9584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f9586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.j.k f9587f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private File f9588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private OutputStream f9589h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FileOutputStream f9590i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f9591j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f9592k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private x f9593l;

    public static class a extends a.C0200a {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public b(com.anythink.expressad.exoplayer.j.a.a aVar) {
        this(aVar, 2097152L, a, true);
    }

    private void b() {
        long j2 = this.f9587f.f9671g;
        if (j2 != -1) {
            Math.min(j2 - this.f9592k, this.f9584c);
        }
        com.anythink.expressad.exoplayer.j.a.a aVar = this.b;
        com.anythink.expressad.exoplayer.j.k kVar = this.f9587f;
        this.f9588g = aVar.c(kVar.f9672h, kVar.f9669e + this.f9592k);
        this.f9590i = new FileOutputStream(this.f9588g);
        int i2 = this.f9585d;
        if (i2 > 0) {
            x xVar = this.f9593l;
            if (xVar == null) {
                this.f9593l = new x(this.f9590i, i2);
            } else {
                xVar.a(this.f9590i);
            }
            this.f9589h = this.f9593l;
        } else {
            this.f9589h = this.f9590i;
        }
        this.f9591j = 0L;
    }

    private void c() {
        OutputStream outputStream = this.f9589h;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            if (this.f9586e) {
                this.f9590i.getFD().sync();
            }
            af.a(this.f9589h);
            this.f9589h = null;
            File file = this.f9588g;
            this.f9588g = null;
            this.b.a(file);
        } catch (Throwable th) {
            af.a(this.f9589h);
            this.f9589h = null;
            File file2 = this.f9588g;
            this.f9588g = null;
            file2.delete();
            throw th;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.g
    public final void a(com.anythink.expressad.exoplayer.j.k kVar) throws a {
        if (kVar.f9671g == -1 && !kVar.a(2)) {
            this.f9587f = null;
            return;
        }
        this.f9587f = kVar;
        this.f9592k = 0L;
        try {
            b();
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    private b(com.anythink.expressad.exoplayer.j.a.a aVar, long j2, boolean z2) {
        this(aVar, j2, a, z2);
    }

    private b(com.anythink.expressad.exoplayer.j.a.a aVar, long j2, int i2) {
        this(aVar, j2, i2, true);
    }

    private b(com.anythink.expressad.exoplayer.j.a.a aVar, long j2, int i2, boolean z2) {
        this.b = (com.anythink.expressad.exoplayer.j.a.a) com.anythink.expressad.exoplayer.k.a.a(aVar);
        this.f9584c = j2;
        this.f9585d = i2;
        this.f9586e = z2;
    }

    @Override // com.anythink.expressad.exoplayer.j.g
    public final void a(byte[] bArr, int i2, int i3) throws a {
        if (this.f9587f == null) {
            return;
        }
        int i4 = 0;
        while (i4 < i3) {
            try {
                if (this.f9591j == this.f9584c) {
                    c();
                    b();
                }
                int iMin = (int) Math.min(i3 - i4, this.f9584c - this.f9591j);
                this.f9589h.write(bArr, i2 + i4, iMin);
                i4 += iMin;
                long j2 = iMin;
                this.f9591j += j2;
                this.f9592k += j2;
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.g
    public final void a() throws a {
        if (this.f9587f == null) {
            return;
        }
        try {
            c();
        } catch (IOException e2) {
            throw new a(e2);
        }
    }
}
