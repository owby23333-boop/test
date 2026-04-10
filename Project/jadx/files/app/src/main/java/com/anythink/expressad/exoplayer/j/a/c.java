package com.anythink.expressad.exoplayer.j.a;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.j.a.a;
import com.anythink.expressad.exoplayer.j.r;
import com.anythink.expressad.exoplayer.j.z;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.anythink.expressad.exoplayer.j.h {
    public static final long a = 2097152;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9594c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9595d = 4;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9596e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9597f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9598g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f9599h = 102400;
    private boolean A;
    private long B;
    private long C;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.a.a f9600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.h f9601j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.h f9602k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.j.h f9603l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private final b f9604m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f9605n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f9606o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f9607p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.anythink.expressad.exoplayer.j.h f9608q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f9609r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Uri f9610s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Uri f9611t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f9612u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f9613v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f9614w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f9615x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private e f9616y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f9617z;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.j.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0201c {
    }

    public c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar) {
        this(aVar, hVar, 0, (byte) 0);
    }

    private void c() {
        this.f9615x = 0L;
        if (g()) {
            this.f9600i.d(this.f9613v, this.f9614w);
        }
    }

    private boolean d() {
        return !f();
    }

    private boolean e() {
        return this.f9608q == this.f9603l;
    }

    private boolean f() {
        return this.f9608q == this.f9601j;
    }

    private boolean g() {
        return this.f9608q == this.f9602k;
    }

    private void h() {
        com.anythink.expressad.exoplayer.j.h hVar = this.f9608q;
        if (hVar == null) {
            return;
        }
        try {
            hVar.b();
        } finally {
            this.f9608q = null;
            this.f9609r = false;
            e eVar = this.f9616y;
            if (eVar != null) {
                this.f9600i.a(eVar);
                this.f9616y = null;
            }
        }
    }

    private static void i() {
    }

    private void j() {
        if (this.f9604m == null || this.B <= 0) {
            return;
        }
        this.f9600i.c();
        this.B = 0L;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(com.anythink.expressad.exoplayer.j.k kVar) throws IOException {
        try {
            this.f9613v = f.a(kVar);
            this.f9610s = kVar.f9667c;
            com.anythink.expressad.exoplayer.j.a.a aVar = this.f9600i;
            String str = this.f9613v;
            Uri uri = this.f9610s;
            String strA = aVar.c(str).a("exo_redir", (String) null);
            Uri uri2 = strA == null ? null : Uri.parse(strA);
            if (uri2 == null) {
                uri2 = uri;
            }
            this.f9611t = uri2;
            this.f9612u = kVar.f9673i;
            this.f9614w = kVar.f9670f;
            boolean z2 = true;
            if (((this.f9606o && this.f9617z) ? (byte) 0 : (this.f9607p && kVar.f9671g == -1) ? (byte) 1 : (byte) -1) == -1) {
                z2 = false;
            }
            this.A = z2;
            if (kVar.f9671g != -1 || this.A) {
                this.f9615x = kVar.f9671g;
            } else {
                this.f9615x = this.f9600i.b(this.f9613v);
                if (this.f9615x != -1) {
                    this.f9615x -= kVar.f9670f;
                    if (this.f9615x <= 0) {
                        throw new com.anythink.expressad.exoplayer.j.i();
                    }
                }
            }
            a(false);
            return this.f9615x;
        } catch (IOException e2) {
            b(e2);
            throw e2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() throws IOException {
        this.f9610s = null;
        this.f9611t = null;
        if (this.f9604m != null && this.B > 0) {
            this.f9600i.c();
            this.B = 0L;
        }
        try {
            h();
        } catch (IOException e2) {
            b(e2);
            throw e2;
        }
    }

    private c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, int i2) {
        this(aVar, hVar, i2, (byte) 0);
    }

    private c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, int i2, byte b2) {
        this(aVar, hVar, new r(), new com.anythink.expressad.exoplayer.j.a.b(aVar), i2, null);
    }

    private c(com.anythink.expressad.exoplayer.j.a.a aVar, com.anythink.expressad.exoplayer.j.h hVar, com.anythink.expressad.exoplayer.j.h hVar2, com.anythink.expressad.exoplayer.j.g gVar, int i2, @Nullable b bVar) {
        this.f9600i = aVar;
        this.f9601j = hVar2;
        this.f9605n = (i2 & 1) != 0;
        this.f9606o = (i2 & 2) != 0;
        this.f9607p = (i2 & 4) != 0;
        this.f9603l = hVar;
        this.f9602k = new z(hVar, gVar);
        this.f9604m = bVar;
    }

    private void b(IOException iOException) {
        if (f() || (iOException instanceof a.C0200a)) {
            this.f9617z = true;
        }
    }

    private int b(com.anythink.expressad.exoplayer.j.k kVar) {
        if (this.f9606o && this.f9617z) {
            return 0;
        }
        return (this.f9607p && kVar.f9671g == -1) ? 1 : -1;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i2, int i3) throws IOException {
        boolean z2 = false;
        if (i3 == 0) {
            return 0;
        }
        if (this.f9615x == 0) {
            return -1;
        }
        try {
            if (this.f9614w >= this.C) {
                a(true);
            }
            int iA = this.f9608q.a(bArr, i2, i3);
            if (iA != -1) {
                if (f()) {
                    this.B += (long) iA;
                }
                long j2 = iA;
                this.f9614w += j2;
                if (this.f9615x != -1) {
                    this.f9615x -= j2;
                }
            } else if (this.f9609r) {
                c();
            } else {
                if (this.f9615x <= 0) {
                    if (this.f9615x == -1) {
                    }
                }
                h();
                a(false);
                return a(bArr, i2, i3);
            }
            return iA;
        } catch (IOException e2) {
            if (this.f9609r) {
                Throwable cause = e2;
                while (true) {
                    if (cause != null) {
                        if ((cause instanceof com.anythink.expressad.exoplayer.j.i) && ((com.anythink.expressad.exoplayer.j.i) cause).b == 0) {
                            z2 = true;
                            break;
                        }
                        cause = cause.getCause();
                    } else {
                        break;
                    }
                }
                if (z2) {
                    c();
                    return -1;
                }
            }
            b(e2);
            throw e2;
        }
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        return this.f9611t;
    }

    private void a(boolean z2) throws InterruptedIOException {
        e eVarA;
        long jMin;
        com.anythink.expressad.exoplayer.j.k kVar;
        com.anythink.expressad.exoplayer.j.h hVar;
        if (this.A) {
            eVarA = null;
        } else if (this.f9605n) {
            try {
                eVarA = this.f9600i.a(this.f9613v, this.f9614w);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            eVarA = this.f9600i.b(this.f9613v, this.f9614w);
        }
        if (eVarA == null) {
            com.anythink.expressad.exoplayer.j.h hVar2 = this.f9603l;
            kVar = new com.anythink.expressad.exoplayer.j.k(this.f9610s, this.f9614w, this.f9615x, this.f9613v, this.f9612u);
            hVar = hVar2;
        } else if (eVarA.f9619d) {
            Uri uriFromFile = Uri.fromFile(eVarA.f9620e);
            long j2 = this.f9614w - eVarA.b;
            long jMin2 = eVarA.f9618c - j2;
            long j3 = this.f9615x;
            if (j3 != -1) {
                jMin2 = Math.min(jMin2, j3);
            }
            com.anythink.expressad.exoplayer.j.k kVar2 = new com.anythink.expressad.exoplayer.j.k(uriFromFile, this.f9614w, j2, jMin2, this.f9613v, this.f9612u);
            hVar = this.f9601j;
            kVar = kVar2;
        } else {
            if (eVarA.a()) {
                jMin = this.f9615x;
            } else {
                jMin = eVarA.f9618c;
                long j4 = this.f9615x;
                if (j4 != -1) {
                    jMin = Math.min(jMin, j4);
                }
            }
            kVar = new com.anythink.expressad.exoplayer.j.k(this.f9610s, this.f9614w, jMin, this.f9613v, this.f9612u);
            hVar = this.f9602k;
            if (hVar == null) {
                hVar = this.f9603l;
                this.f9600i.a(eVarA);
                eVarA = null;
            }
        }
        this.C = (this.A || hVar != this.f9603l) ? Long.MAX_VALUE : this.f9614w + f9599h;
        if (z2) {
            com.anythink.expressad.exoplayer.k.a.b(e());
            if (hVar == this.f9603l) {
                return;
            }
            try {
                h();
            } catch (Throwable th) {
                if (eVarA.b()) {
                    this.f9600i.a(eVarA);
                }
                throw th;
            }
        }
        if (eVarA != null && eVarA.b()) {
            this.f9616y = eVarA;
        }
        this.f9608q = hVar;
        this.f9609r = kVar.f9671g == -1;
        long jA = hVar.a(kVar);
        k kVar3 = new k();
        if (this.f9609r && jA != -1) {
            this.f9615x = jA;
            j.a(kVar3, this.f9614w + this.f9615x);
        }
        if (d()) {
            this.f9611t = this.f9608q.a();
            if (true ^ this.f9610s.equals(this.f9611t)) {
                j.a(kVar3, this.f9611t);
            } else {
                kVar3.a("exo_redir");
            }
        }
        if (g()) {
            this.f9600i.a(this.f9613v, kVar3);
        }
    }

    private static Uri a(com.anythink.expressad.exoplayer.j.a.a aVar, String str, Uri uri) {
        String strA = aVar.c(str).a("exo_redir", (String) null);
        Uri uri2 = strA != null ? Uri.parse(strA) : null;
        return uri2 == null ? uri : uri2;
    }

    private static boolean a(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof com.anythink.expressad.exoplayer.j.i) && ((com.anythink.expressad.exoplayer.j.i) cause).b == 0) {
                return true;
            }
        }
        return false;
    }
}
