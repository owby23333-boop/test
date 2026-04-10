package com.yuewen;

import android.content.Context;
import android.content.res.Configuration;
import com.xiaomi.verificationsdk.internal.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class a61 {
    public static final int c = 1033;
    public static final int d = 2052;
    public static final int e = 1028;
    public static final int f = 1041;
    public static final int g = 0;
    public static final int h = 33;
    public static final int i = 19;
    public static final int j = 11;
    public static final int k = 1;
    public static final int l = 1;
    public static final int m = 1;
    public static final int n = 25;
    public static final int o = 2;
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 3;
    public static final int s = 1;
    public static final String t = "UTF-16BE";
    public static final String u = "ucs-2";
    public static final String v = "GBK";
    public static final String w = "Big5";
    public static final String x = "iso-2022-jp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RandomAccessFile f8408a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8409b = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8411b;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8413b;
        public long c;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8415b;
        public int c;
        public int d;
        public int e;
        public int f;
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8417b;
        public int c;
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8419b;
        public int c;
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8421b;
        public int c;
        public int d;
    }

    public static int a(byte b2) {
        return b2 & 255;
    }

    public static int h(byte b2, byte b3) {
        return (a(b2) << 8) | a(b3);
    }

    public static int i(byte b2, byte b3, byte b4, byte b5) {
        return (a(b2) << 24) | (a(b3) << 16) | (a(b4) << 8) | a(b5);
    }

    public static int j(byte[] bArr, int i2) {
        return i(bArr[i2], bArr[i2 + 1], bArr[i2 + 2], bArr[i2 + 3]);
    }

    public int A(byte[] bArr) {
        try {
            return this.f8408a.read(bArr);
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public void B(long j2) {
        try {
            this.f8408a.seek(j2);
            if (j2 != this.f8408a.getFilePointer()) {
                System.out.print(com.alipay.sdk.m.y.k.j);
                System.out.print(j2);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        try {
            this.f8408a.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public String c() {
        return this.f8409b;
    }

    public final String d() {
        return "UTF-16BE";
    }

    public final String e() {
        return u;
    }

    public String f(e eVar, f fVar, c cVar) {
        byte[] bArr;
        if (eVar == null || fVar == null || cVar == null) {
            return null;
        }
        B(fVar.c);
        a aVar = new a();
        int i2 = 4;
        byte[] bArr2 = new byte[4];
        if (4 != A(bArr2)) {
            b();
            return null;
        }
        char c2 = 2;
        char c3 = 3;
        aVar.f8411b = h(bArr2[2], bArr2[3]);
        b bVar = new b();
        int i3 = 8;
        byte[] bArr3 = new byte[8];
        String strQ = null;
        int i4 = 0;
        while (i4 < aVar.f8411b) {
            if (i3 != A(bArr3)) {
                b();
                return null;
            }
            bVar.f8412a = h(bArr3[0], bArr3[1]);
            bVar.f8413b = h(bArr3[c2], bArr3[c3]);
            bVar.c = j(bArr3, i2);
            if (v(cVar, bVar)) {
                long jO = o();
                bArr = bArr3;
                B(((long) fVar.c) + bVar.c);
                byte[] bArr4 = new byte[cVar.e];
                if (A(bArr4) > 0) {
                    strQ = q(cVar, bArr4);
                    if (cVar.c == 2052) {
                        break;
                    }
                }
                B(jO);
            } else {
                bArr = bArr3;
            }
            i4++;
            bArr3 = bArr;
            i2 = 4;
            c2 = 2;
            i3 = 8;
            c3 = 3;
        }
        b();
        return strQ;
    }

    public String g(String str) {
        boolean z;
        if (!z(str)) {
            return null;
        }
        try {
            if (this.f8408a.length() == 0) {
                return null;
            }
            int i2 = 12;
            byte[] bArr = new byte[12];
            if (-1 == A(bArr)) {
                b();
                return null;
            }
            e eVar = new e();
            char c2 = 0;
            int i3 = 1;
            eVar.f8419b = h(bArr[0], bArr[1]);
            char c3 = 2;
            char c4 = 3;
            eVar.c = h(bArr[2], bArr[3]);
            char c5 = 4;
            eVar.f8418a = h(bArr[4], bArr[5]);
            String strR = q41.r(str);
            if ((strR != null && strR.equalsIgnoreCase(g61.p)) && (eVar.f8419b != 1 || eVar.c != 0)) {
                b();
                return null;
            }
            f fVar = new f();
            byte[] bArr2 = new byte[16];
            int i4 = 0;
            while (true) {
                if (i4 >= eVar.f8418a) {
                    z = false;
                    break;
                }
                A(bArr2);
                if (r(bArr2, 4).compareToIgnoreCase("name") == 0) {
                    fVar.c = j(bArr2, 8);
                    fVar.d = j(bArr2, 12);
                    z = true;
                    break;
                }
                i4++;
            }
            if (!z) {
                b();
                return null;
            }
            B(fVar.c);
            d dVar = new d();
            byte[] bArr3 = new byte[6];
            if (6 != A(bArr3)) {
                b();
                return null;
            }
            dVar.f8417b = h(bArr3[2], bArr3[3]);
            dVar.c = h(bArr3[4], bArr3[5]);
            c cVar = new c();
            byte[] bArr4 = new byte[12];
            String strQ = null;
            int i5 = 0;
            while (i5 < dVar.f8417b) {
                if (i2 != A(bArr4)) {
                    b();
                    return null;
                }
                cVar.f8414a = h(bArr4[c2], bArr4[i3]);
                cVar.f8415b = h(bArr4[c3], bArr4[c4]);
                cVar.c = h(bArr4[c5], bArr4[5]);
                cVar.d = h(bArr4[6], bArr4[7]);
                if ((w(cVar) || x(cVar) || t(cVar) || u(cVar)) && cVar.d == i3) {
                    cVar.e = h(bArr4[8], bArr4[9]);
                    cVar.f = h(bArr4[10], bArr4[11]);
                    long jO = o();
                    B(fVar.c + cVar.f + dVar.c);
                    byte[] bArr5 = new byte[cVar.e];
                    if (A(bArr5) > 0) {
                        strQ = q(cVar, bArr5);
                        if (cVar.c == 2052) {
                            break;
                        }
                    }
                    B(jO);
                }
                i5++;
                i2 = 12;
                c2 = 0;
                c3 = 2;
                i3 = 1;
                c5 = 4;
                c4 = 3;
            }
            b();
            return strQ;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String k() {
        return x;
    }

    public String l(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        Locale locale = Locale.getDefault();
        configuration.locale = locale;
        if (locale == Locale.JAPANESE) {
            return "ja";
        }
        if (locale == Locale.CHINA) {
            return "chn";
        }
        if (locale == Locale.UK || locale == Locale.US || locale == Locale.ENGLISH) {
            return "eng";
        }
        return null;
    }

    public String m(c cVar, byte[] bArr) {
        if (cVar.f8414a != 1) {
            return null;
        }
        int i2 = cVar.c;
        return i2 == 33 ? p() : i2 == 19 ? s() : i2 == 11 ? k() : y(bArr) ? e() : c();
    }

    public String n(c cVar, byte[] bArr) {
        if (cVar.f8414a != 3) {
            return null;
        }
        int i2 = cVar.c;
        return (i2 == 2052 || i2 == 1041) ? d() : y(bArr) ? d() : c();
    }

    public long o() {
        try {
            return this.f8408a.getFilePointer();
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public final String p() {
        return "GBK";
    }

    public String q(c cVar, byte[] bArr) {
        int i2 = cVar.f8414a;
        try {
            return new String(bArr, i2 == 3 ? n(cVar, bArr) : i2 == 1 ? m(cVar, bArr) : c());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String r(byte[] bArr, int i2) {
        try {
            return new String(bArr, 0, i2, c());
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String s() {
        return w;
    }

    public final boolean t(c cVar) {
        int i2 = cVar.c;
        return (i2 == 1033 && cVar.f8414a == 3) || i2 == 0 || cVar.f8414a == 1;
    }

    public final boolean u(c cVar) {
        int i2 = cVar.c;
        return (i2 == 1041 && cVar.f8414a == 3) || i2 == 11 || cVar.f8414a == 1;
    }

    public final boolean v(c cVar, b bVar) {
        return bVar.f8412a == cVar.f8414a && bVar.f8413b == cVar.f8415b;
    }

    public final boolean w(c cVar) {
        int i2 = cVar.f8414a;
        return (i2 == 3 && cVar.c == 2052) || (i2 == 1 && cVar.c == 33);
    }

    public final boolean x(c cVar) {
        int i2 = cVar.f8414a;
        return (i2 == 3 && cVar.c == 1028) || (i2 == 1 && cVar.c == 19);
    }

    public final boolean y(byte[] bArr) {
        try {
            Charset.forName("UTF-16BE").newDecoder().decode(ByteBuffer.wrap(bArr));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean z(String str) {
        try {
            this.f8408a = new RandomAccessFile(str, Constants.RANDOM_LONG);
            this.f8409b = new r50().e(new File(str));
            return true;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
