package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_byte12b;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.j;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f929e = {42};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f930f = new String[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f931g = {"*"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f932h = new a();
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final CountDownLatch b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f934d;

    public static a a() {
        return f932h;
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i2) {
        int i3;
        int i4;
        int i5;
        int length = bArr.length;
        int i6 = 0;
        while (i6 < length) {
            int i7 = (i6 + length) / 2;
            while (i7 > -1 && bArr[i7] != 10) {
                i7--;
            }
            int i8 = i7 + 1;
            int i9 = 1;
            while (true) {
                i3 = i8 + i9;
                if (bArr[i3] == 10) {
                    break;
                }
                i9++;
            }
            int i10 = i3 - i8;
            int i11 = i2;
            boolean z2 = false;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (z2) {
                    z2 = false;
                    i4 = 46;
                } else {
                    i4 = bArr2[i11][i12] & 255;
                }
                i5 = i4 - (bArr[i8 + i13] & 255);
                if (i5 == 0) {
                    i13++;
                    i12++;
                    if (i13 == i10) {
                        break;
                    }
                    if (bArr2[i11].length == i12) {
                        if (i11 == bArr2.length - 1) {
                            break;
                        }
                        i11++;
                        z2 = true;
                        i12 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i5 >= 0) {
                if (i5 <= 0) {
                    int i14 = i10 - i13;
                    int length2 = bArr2[i11].length - i12;
                    while (true) {
                        i11++;
                        if (i11 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i11].length;
                    }
                    if (length2 >= i14) {
                        if (length2 <= i14) {
                            return new String(bArr, i8, i10, c.f1149i);
                        }
                    }
                }
                i6 = i3 + 1;
            }
            length = i8 - 1;
        }
        return null;
    }

    private String[] a(String[] strArr) {
        String strA;
        String strA2;
        String strA3;
        if (this.a.get() || !this.a.compareAndSet(false, true)) {
            try {
                this.b.await();
            } catch (InterruptedException unused) {
            }
        } else {
            c();
        }
        synchronized (this) {
            if (this.f933c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(c.f1149i);
        }
        int i3 = 0;
        while (true) {
            if (i3 >= bArr.length) {
                strA = null;
                break;
            }
            strA = a(this.f933c, bArr, i3);
            if (strA != null) {
                break;
            }
            i3++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = f929e;
                strA2 = a(this.f933c, bArr2, i4);
                if (strA2 != null) {
                    break;
                }
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            for (int i5 = 0; i5 < bArr.length - 1; i5++) {
                strA3 = a(this.f934d, bArr, i5);
                if (strA3 != null) {
                    break;
                }
            }
            strA3 = null;
        } else {
            strA3 = null;
        }
        if (strA3 != null) {
            return ("!" + strA3).split("\\.");
        }
        if (strA == null && strA2 == null) {
            return f931g;
        }
        String[] strArrSplit = strA != null ? strA.split("\\.") : f930f;
        String[] strArrSplit2 = strA2 != null ? strA2.split("\\.") : f930f;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private void b() throws IOException {
        InputStream resourceAsStream = a.class.getResourceAsStream(PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        e eVarA = l.a(new j(l.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[eVarA.readInt()];
            eVarA.readFully(bArr);
            byte[] bArr2 = new byte[eVarA.readInt()];
            eVarA.readFully(bArr2);
            synchronized (this) {
                this.f933c = bArr;
                this.f934d = bArr2;
            }
            this.b.countDown();
        } finally {
            c.a(eVarA);
        }
    }

    private void c() {
        boolean z2 = false;
        while (true) {
            try {
                try {
                    b();
                    break;
                } catch (InterruptedIOException unused) {
                    z2 = true;
                } catch (IOException e2) {
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(5, "Failed to read public suffix list", e2);
                    if (!z2) {
                        return;
                    }
                }
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (!z2) {
            return;
        }
        Thread.currentThread().interrupt();
    }

    public String a(String str) {
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrA = a(strArrSplit);
        if (strArrSplit.length == strArrA.length && strArrA[0].charAt(0) != '!') {
            return null;
        }
        char cCharAt = strArrA[0].charAt(0);
        int length = strArrSplit.length;
        int length2 = strArrA.length;
        if (cCharAt != '!') {
            length2++;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i2 = length - length2; i2 < strArrSplit2.length; i2++) {
            sb.append(strArrSplit2[i2]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
