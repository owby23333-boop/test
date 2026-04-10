package com.anythink.expressad.exoplayer.j.a;

import android.util.SparseArray;
import com.anythink.expressad.exoplayer.j.a.a;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
final class h {
    public static final String a = "cached_content_index.exi";
    private static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9628c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashMap<String, g> f9629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseArray<String> f9630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.anythink.expressad.exoplayer.k.b f9631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Cipher f9632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SecretKeySpec f9633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f9634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f9635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private x f9636k;

    private h(File file) {
        this(file, null);
    }

    private boolean f() throws Throwable {
        DataInputStream dataInputStream;
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(this.f9631f.c());
            dataInputStream = new DataInputStream(bufferedInputStream);
        } catch (IOException unused) {
            dataInputStream = null;
        } catch (Throwable th) {
            th = th;
            dataInputStream = null;
        }
        try {
            int i2 = dataInputStream.readInt();
            if (i2 >= 0 && i2 <= 2) {
                if ((dataInputStream.readInt() & 1) != 0) {
                    if (this.f9632g == null) {
                        af.a((Closeable) dataInputStream);
                        return false;
                    }
                    byte[] bArr = new byte[16];
                    dataInputStream.readFully(bArr);
                    try {
                        this.f9632g.init(2, this.f9633h, new IvParameterSpec(bArr));
                        dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f9632g));
                    } catch (InvalidAlgorithmParameterException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e3) {
                        e = e3;
                        throw new IllegalStateException(e);
                    }
                } else if (this.f9634i) {
                    this.f9635j = true;
                }
                int i3 = dataInputStream.readInt();
                int iA = 0;
                for (int i4 = 0; i4 < i3; i4++) {
                    g gVarA = g.a(i2, dataInputStream);
                    a(gVarA);
                    iA += gVarA.a(i2);
                }
                int i5 = dataInputStream.readInt();
                boolean z2 = dataInputStream.read() == -1;
                if (i5 == iA && z2) {
                    af.a((Closeable) dataInputStream);
                    return true;
                }
                af.a((Closeable) dataInputStream);
                return false;
            }
            af.a((Closeable) dataInputStream);
            return false;
        } catch (IOException unused2) {
            if (dataInputStream != null) {
                af.a((Closeable) dataInputStream);
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            if (dataInputStream != null) {
                af.a((Closeable) dataInputStream);
            }
            throw th;
        }
    }

    private void g() throws Throwable {
        Throwable th;
        IOException e2;
        DataOutputStream dataOutputStream;
        try {
            try {
                OutputStream outputStreamB = this.f9631f.b();
                if (this.f9636k == null) {
                    this.f9636k = new x(outputStreamB);
                } else {
                    this.f9636k.a(outputStreamB);
                }
                dataOutputStream = new DataOutputStream(this.f9636k);
            } catch (IOException e3) {
                e2 = e3;
            } catch (Throwable th2) {
                th = th2;
                af.a((Closeable) null);
                throw th;
            }
            try {
                dataOutputStream.writeInt(2);
                int iA = 0;
                dataOutputStream.writeInt(this.f9634i ? 1 : 0);
                if (this.f9634i) {
                    byte[] bArr = new byte[16];
                    new Random().nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        this.f9632g.init(1, this.f9633h, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(this.f9636k, this.f9632g));
                    } catch (InvalidAlgorithmParameterException e4) {
                        e = e4;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e5) {
                        e = e5;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(this.f9629d.size());
                for (g gVar : this.f9629d.values()) {
                    gVar.a(dataOutputStream);
                    iA += gVar.a(2);
                }
                dataOutputStream.writeInt(iA);
                this.f9631f.a(dataOutputStream);
                af.a((Closeable) null);
            } catch (IOException e6) {
                e2 = e6;
                throw new a.C0200a(e2);
            }
        } catch (Throwable th3) {
            th = th3;
            af.a((Closeable) null);
            throw th;
        }
    }

    private static Cipher h() {
        if (af.a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public final void a() {
        com.anythink.expressad.exoplayer.k.a.b(!this.f9635j);
        if (f()) {
            return;
        }
        this.f9631f.a();
        this.f9629d.clear();
        this.f9630e.clear();
    }

    public final void b() throws Throwable {
        Throwable th;
        IOException e2;
        DataOutputStream dataOutputStream;
        if (this.f9635j) {
            try {
                try {
                    OutputStream outputStreamB = this.f9631f.b();
                    if (this.f9636k == null) {
                        this.f9636k = new x(outputStreamB);
                    } else {
                        this.f9636k.a(outputStreamB);
                    }
                    dataOutputStream = new DataOutputStream(this.f9636k);
                } catch (IOException e3) {
                    e2 = e3;
                } catch (Throwable th2) {
                    th = th2;
                    af.a((Closeable) null);
                    throw th;
                }
                try {
                    dataOutputStream.writeInt(2);
                    dataOutputStream.writeInt(this.f9634i ? 1 : 0);
                    if (this.f9634i) {
                        byte[] bArr = new byte[16];
                        new Random().nextBytes(bArr);
                        dataOutputStream.write(bArr);
                        try {
                            this.f9632g.init(1, this.f9633h, new IvParameterSpec(bArr));
                            dataOutputStream.flush();
                            dataOutputStream = new DataOutputStream(new CipherOutputStream(this.f9636k, this.f9632g));
                        } catch (InvalidAlgorithmParameterException e4) {
                            e = e4;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e5) {
                            e = e5;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream.writeInt(this.f9629d.size());
                    int iA = 0;
                    for (g gVar : this.f9629d.values()) {
                        gVar.a(dataOutputStream);
                        iA += gVar.a(2);
                    }
                    dataOutputStream.writeInt(iA);
                    this.f9631f.a(dataOutputStream);
                    af.a((Closeable) null);
                    this.f9635j = false;
                } catch (IOException e6) {
                    e2 = e6;
                    throw new a.C0200a(e2);
                }
            } catch (Throwable th3) {
                th = th3;
                af.a((Closeable) null);
                throw th;
            }
        }
    }

    public final Collection<g> c() {
        return this.f9629d.values();
    }

    public final void d(String str) {
        g gVar = this.f9629d.get(str);
        if (gVar == null || !gVar.d() || gVar.b()) {
            return;
        }
        this.f9629d.remove(str);
        this.f9630e.remove(gVar.a);
        this.f9635j = true;
    }

    public final Set<String> e() {
        return this.f9629d.keySet();
    }

    private h(File file, byte[] bArr) {
        this(file, bArr, bArr != null);
    }

    public final int c(String str) {
        return a(str).a;
    }

    public final i e(String str) {
        g gVarB = b(str);
        return gVarB != null ? gVarB.a() : l.b;
    }

    public h(File file, byte[] bArr, boolean z2) {
        this.f9634i = z2;
        if (bArr != null) {
            com.anythink.expressad.exoplayer.k.a.a(bArr.length == 16);
            try {
                this.f9632g = h();
                this.f9633h = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            com.anythink.expressad.exoplayer.k.a.b(!z2);
            this.f9632g = null;
            this.f9633h = null;
        }
        this.f9629d = new HashMap<>();
        this.f9630e = new SparseArray<>();
        this.f9631f = new com.anythink.expressad.exoplayer.k.b(new File(file, a));
    }

    public final g a(String str) {
        g gVar = this.f9629d.get(str);
        if (gVar != null) {
            return gVar;
        }
        SparseArray<String> sparseArray = this.f9630e;
        int size = sparseArray.size();
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            iKeyAt = 0;
            while (iKeyAt < size && iKeyAt == sparseArray.keyAt(iKeyAt)) {
                iKeyAt++;
            }
        }
        g gVar2 = new g(iKeyAt, str);
        a(gVar2);
        this.f9635j = true;
        return gVar2;
    }

    public final void d() {
        String[] strArr = new String[this.f9629d.size()];
        this.f9629d.keySet().toArray(strArr);
        for (String str : strArr) {
            d(str);
        }
    }

    public final String a(int i2) {
        return this.f9630e.get(i2);
    }

    public final void a(String str, k kVar) {
        if (a(str).a(kVar)) {
            this.f9635j = true;
        }
    }

    private void a(g gVar) {
        this.f9629d.put(gVar.b, gVar);
        this.f9630e.put(gVar.a, gVar.b);
    }

    private static int a(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            iKeyAt = 0;
            while (iKeyAt < size && iKeyAt == sparseArray.keyAt(iKeyAt)) {
                iKeyAt++;
            }
        }
        return iKeyAt;
    }

    private g f(String str) {
        SparseArray<String> sparseArray = this.f9630e;
        int size = sparseArray.size();
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            iKeyAt = 0;
            while (iKeyAt < size && iKeyAt == sparseArray.keyAt(iKeyAt)) {
                iKeyAt++;
            }
        }
        g gVar = new g(iKeyAt, str);
        a(gVar);
        this.f9635j = true;
        return gVar;
    }

    public final g b(String str) {
        return this.f9629d.get(str);
    }
}
