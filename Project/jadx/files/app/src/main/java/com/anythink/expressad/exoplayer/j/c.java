package com.anythink.expressad.exoplayer.j;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements h {
    private final AssetManager a;
    private final aa<? super c> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f9652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InputStream f9653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f9654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f9655f;

    public static final class a extends IOException {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    private c(Context context) {
        this(context, null);
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) throws a {
        try {
            this.f9652c = kVar.f9667c;
            String path = this.f9652c.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            this.f9653d = this.a.open(path, 1);
            if (this.f9653d.skip(kVar.f9670f) < kVar.f9670f) {
                throw new EOFException();
            }
            if (kVar.f9671g != -1) {
                this.f9654e = kVar.f9671g;
            } else {
                this.f9654e = this.f9653d.available();
                if (this.f9654e == 2147483647L) {
                    this.f9654e = -1L;
                }
            }
            this.f9655f = true;
            aa<? super c> aaVar = this.b;
            if (aaVar != null) {
                aaVar.b();
            }
            return this.f9654e;
        } catch (IOException e2) {
            throw new a(e2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.f9652c = null;
        try {
            try {
                if (this.f9653d != null) {
                    this.f9653d.close();
                }
            } catch (IOException e2) {
                throw new a(e2);
            }
        } finally {
            this.f9653d = null;
            if (this.f9655f) {
                this.f9655f = false;
                aa<? super c> aaVar = this.b;
                if (aaVar != null) {
                    aaVar.c();
                }
            }
        }
    }

    public c(Context context, aa<? super c> aaVar) {
        this.a = context.getAssets();
        this.b = aaVar;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i2, int i3) throws a {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f9654e;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, i3);
            } catch (IOException e2) {
                throw new a(e2);
            }
        }
        int i4 = this.f9653d.read(bArr, i2, i3);
        if (i4 == -1) {
            if (this.f9654e == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j3 = this.f9654e;
        if (j3 != -1) {
            this.f9654e = j3 - ((long) i4);
        }
        aa<? super c> aaVar = this.b;
        if (aaVar != null) {
            aaVar.a(i4);
        }
        return i4;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.f9652c;
    }
}
