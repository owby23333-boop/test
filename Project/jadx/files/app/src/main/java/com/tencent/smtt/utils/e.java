package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

/* JADX INFO: loaded from: classes3.dex */
public class e implements Closeable {
    static final char[] a = {127, 'E', 'L', 'F', 0};
    final char[] b = new char[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f19210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    j[] f19211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    l[] f19212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    byte[] f19213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.tencent.smtt.utils.c f19214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f19215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final k[] f19216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f19217j;

    public static abstract class a {
        short a;
        short b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19219d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        short f19220e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        short f19221f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        short f19222g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        short f19223h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        short f19224i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        short f19225j;

        abstract long a();

        abstract long b();
    }

    static class b extends a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f19226k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f19227l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f19228m;

        b() {
        }

        @Override // com.tencent.smtt.utils.e.a
        long a() {
            return this.f19228m;
        }

        @Override // com.tencent.smtt.utils.e.a
        long b() {
            return this.f19227l;
        }
    }

    static class c extends j {
        int a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19230d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19231e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f19232f;

        c() {
        }
    }

    static class d extends k {
        int a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19234d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19235e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f19236f;

        d() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return this.f19234d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.f19233c;
        }
    }

    /* JADX INFO: renamed from: com.tencent.smtt.utils.e$e, reason: collision with other inner class name */
    static class C0536e extends l {
        int a;
        int b;

        C0536e() {
        }
    }

    static class f extends a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f19237k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f19238l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f19239m;

        f() {
        }

        @Override // com.tencent.smtt.utils.e.a
        long a() {
            return this.f19239m;
        }

        @Override // com.tencent.smtt.utils.e.a
        long b() {
            return this.f19238l;
        }
    }

    static class g extends j {
        long a;
        long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f19240c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f19241d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f19242e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f19243f;

        g() {
        }
    }

    static class h extends k {
        long a;
        long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f19244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f19245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f19246e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f19247f;

        h() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return (int) this.f19245d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.f19244c;
        }
    }

    static class i extends l {
        long a;
        long b;

        i() {
        }
    }

    static abstract class j {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f19248g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f19249h;

        j() {
        }
    }

    public static abstract class k {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f19250g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f19251h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f19252i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f19253j;

        public abstract int a();

        public abstract long b();
    }

    static abstract class l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        char f19255d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        char f19256e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        short f19257f;

        l() {
        }
    }

    public e(File file) throws UnknownFormatConversionException, IOException {
        a aVar;
        com.tencent.smtt.utils.c cVar = new com.tencent.smtt.utils.c(file);
        this.f19214g = cVar;
        cVar.a(this.b);
        if (!a()) {
            throw new UnknownFormatConversionException("Invalid elf magic: " + file);
        }
        cVar.a(e());
        boolean zD = d();
        if (zD) {
            f fVar = new f();
            fVar.a = cVar.a();
            fVar.b = cVar.a();
            fVar.f19218c = cVar.b();
            fVar.f19237k = cVar.c();
            fVar.f19238l = cVar.c();
            fVar.f19239m = cVar.c();
            aVar = fVar;
        } else {
            b bVar = new b();
            bVar.a = cVar.a();
            bVar.b = cVar.a();
            bVar.f19218c = cVar.b();
            bVar.f19226k = cVar.b();
            bVar.f19227l = cVar.b();
            bVar.f19228m = cVar.b();
            aVar = bVar;
        }
        this.f19215h = aVar;
        a aVar2 = this.f19215h;
        aVar2.f19219d = cVar.b();
        aVar2.f19220e = cVar.a();
        aVar2.f19221f = cVar.a();
        aVar2.f19222g = cVar.a();
        aVar2.f19223h = cVar.a();
        aVar2.f19224i = cVar.a();
        aVar2.f19225j = cVar.a();
        this.f19216i = new k[aVar2.f19224i];
        for (int i2 = 0; i2 < aVar2.f19224i; i2++) {
            cVar.a(aVar2.a() + ((long) (aVar2.f19223h * i2)));
            if (zD) {
                h hVar = new h();
                hVar.f19250g = cVar.b();
                hVar.f19251h = cVar.b();
                hVar.a = cVar.c();
                hVar.b = cVar.c();
                hVar.f19244c = cVar.c();
                hVar.f19245d = cVar.c();
                hVar.f19252i = cVar.b();
                hVar.f19253j = cVar.b();
                hVar.f19246e = cVar.c();
                hVar.f19247f = cVar.c();
                this.f19216i[i2] = hVar;
            } else {
                d dVar = new d();
                dVar.f19250g = cVar.b();
                dVar.f19251h = cVar.b();
                dVar.a = cVar.b();
                dVar.b = cVar.b();
                dVar.f19233c = cVar.b();
                dVar.f19234d = cVar.b();
                dVar.f19252i = cVar.b();
                dVar.f19253j = cVar.b();
                dVar.f19235e = cVar.b();
                dVar.f19236f = cVar.b();
                this.f19216i[i2] = dVar;
            }
        }
        short s2 = aVar2.f19225j;
        if (s2 > -1) {
            k[] kVarArr = this.f19216i;
            if (s2 < kVarArr.length) {
                k kVar = kVarArr[s2];
                if (kVar.f19251h != 3) {
                    throw new UnknownFormatConversionException("Wrong string section e_shstrndx=" + ((int) aVar2.f19225j));
                }
                this.f19217j = new byte[kVar.a()];
                cVar.a(kVar.b());
                cVar.a(this.f19217j);
                if (this.f19210c) {
                    f();
                    return;
                }
                return;
            }
        }
        throw new UnknownFormatConversionException("Invalid e_shstrndx=" + ((int) aVar2.f19225j));
    }

    public static boolean a(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            long j2 = randomAccessFile.readInt();
            randomAccessFile.close();
            return j2 == 2135247942;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean b(File file) {
        StringBuilder sb;
        String str;
        if (!g() || !a(file)) {
            return true;
        }
        try {
            new e(file);
            return true;
        } catch (IOException e2) {
            String str2 = "checkElfFile IOException: " + e2;
            return false;
        } catch (UnknownFormatConversionException e3) {
            e = e3;
            sb = new StringBuilder();
            str = "checkElfFile UnknownFormatConversionException: ";
            sb.append(str);
            sb.append(e);
            sb.toString();
            return true;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str = "checkElfFile Throwable: ";
            sb.append(str);
            sb.append(e);
            sb.toString();
            return true;
        }
    }

    private void f() throws IOException {
        a aVar = this.f19215h;
        com.tencent.smtt.utils.c cVar = this.f19214g;
        boolean zD = d();
        k kVarA = a(".dynsym");
        if (kVarA != null) {
            cVar.a(kVarA.b());
            int iA = kVarA.a() / (zD ? 24 : 16);
            this.f19212e = new l[iA];
            char[] cArr = new char[1];
            for (int i2 = 0; i2 < iA; i2++) {
                if (zD) {
                    i iVar = new i();
                    iVar.f19254c = cVar.b();
                    cVar.a(cArr);
                    iVar.f19255d = cArr[0];
                    cVar.a(cArr);
                    iVar.f19256e = cArr[0];
                    iVar.a = cVar.c();
                    iVar.b = cVar.c();
                    iVar.f19257f = cVar.a();
                    this.f19212e[i2] = iVar;
                } else {
                    C0536e c0536e = new C0536e();
                    c0536e.f19254c = cVar.b();
                    c0536e.a = cVar.b();
                    c0536e.b = cVar.b();
                    cVar.a(cArr);
                    c0536e.f19255d = cArr[0];
                    cVar.a(cArr);
                    c0536e.f19256e = cArr[0];
                    c0536e.f19257f = cVar.a();
                    this.f19212e[i2] = c0536e;
                }
            }
            k kVar = this.f19216i[kVarA.f19252i];
            cVar.a(kVar.b());
            this.f19213f = new byte[kVar.a()];
            cVar.a(this.f19213f);
        }
        this.f19211d = new j[aVar.f19222g];
        for (int i3 = 0; i3 < aVar.f19222g; i3++) {
            cVar.a(aVar.b() + ((long) (aVar.f19221f * i3)));
            if (zD) {
                g gVar = new g();
                gVar.f19248g = cVar.b();
                gVar.f19249h = cVar.b();
                gVar.a = cVar.c();
                gVar.b = cVar.c();
                gVar.f19240c = cVar.c();
                gVar.f19241d = cVar.c();
                gVar.f19242e = cVar.c();
                gVar.f19243f = cVar.c();
                this.f19211d[i3] = gVar;
            } else {
                c cVar2 = new c();
                cVar2.f19248g = cVar.b();
                cVar2.f19249h = cVar.b();
                cVar2.a = cVar.b();
                cVar2.b = cVar.b();
                cVar2.f19229c = cVar.b();
                cVar2.f19230d = cVar.b();
                cVar2.f19231e = cVar.b();
                cVar2.f19232f = cVar.b();
                this.f19211d[i3] = cVar2;
            }
        }
    }

    private static boolean g() {
        String property = System.getProperty("java.vm.version");
        return property != null && property.startsWith("2");
    }

    public final k a(String str) {
        for (k kVar : this.f19216i) {
            if (str.equals(a(kVar.f19250g))) {
                return kVar;
            }
        }
        return null;
    }

    public final String a(int i2) {
        if (i2 == 0) {
            return "SHN_UNDEF";
        }
        int i3 = i2;
        while (true) {
            byte[] bArr = this.f19217j;
            if (bArr[i3] == 0) {
                return new String(bArr, i2, i3 - i2);
            }
            i3++;
        }
    }

    final boolean a() {
        return this.b[0] == a[0];
    }

    final char b() {
        return this.b[4];
    }

    final char c() {
        return this.b[5];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19214g.close();
    }

    public final boolean d() {
        return b() == 2;
    }

    public final boolean e() {
        return c() == 1;
    }
}
