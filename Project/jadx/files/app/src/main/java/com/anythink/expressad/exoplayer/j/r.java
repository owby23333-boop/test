package com.anythink.expressad.exoplayer.j;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements h {
    private final aa<? super r> a;
    private RandomAccessFile b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f9736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9738e;

    public static class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    public r() {
        this(null);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) throws a {
        try {
            this.f9736c = kVar.f9667c;
            this.b = new RandomAccessFile(kVar.f9667c.getPath(), "r");
            this.b.seek(kVar.f9670f);
            this.f9737d = kVar.f9671g == -1 ? this.b.length() - kVar.f9670f : kVar.f9671g;
            if (this.f9737d < 0) {
                throw new EOFException();
            }
            this.f9738e = true;
            aa<? super r> aaVar = this.a;
            if (aaVar != null) {
                aaVar.b();
            }
            return this.f9737d;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.f9736c = null;
        try {
            try {
                if (this.b != null) {
                    this.b.close();
                }
            } catch (IOException e2) {
                throw new a(e2);
            }
        } finally {
            this.b = null;
            if (this.f9738e) {
                this.f9738e = false;
                aa<? super r> aaVar = this.a;
                if (aaVar != null) {
                    aaVar.c();
                }
            }
        }
    }

    public r(aa<? super r> aaVar) {
        this.a = aaVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i2, int i3) throws a {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f9737d;
        if (j2 == 0) {
            return -1;
        }
        try {
            int i4 = this.b.read(bArr, i2, (int) Math.min(j2, i3));
            if (i4 > 0) {
                this.f9737d -= (long) i4;
                aa<? super r> aaVar = this.a;
                if (aaVar != null) {
                    aaVar.a(i4);
                }
            }
            return i4;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.f9736c;
    }
}
