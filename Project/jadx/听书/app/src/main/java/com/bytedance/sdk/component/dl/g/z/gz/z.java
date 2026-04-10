package com.bytedance.sdk.component.dl.g.z.gz;

import com.bytedance.sdk.component.dl.g.z.dl;
import com.bytedance.sdk.component.dl.g.z.e.gc;
import com.bytedance.sdk.component.dl.z.uy;
import com.bytedance.sdk.component.dl.z.wp;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    private byte[] e;
    private byte[] gz;
    private static final byte[] z = {42};
    private static final String[] g = new String[0];
    private static final String[] dl = {"*"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final z f685a = new z();
    private final AtomicBoolean gc = new AtomicBoolean(false);
    private final CountDownLatch m = new CountDownLatch(1);

    public static z z() {
        return f685a;
    }

    public String z(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrZ = z(strArrSplit);
        if (strArrSplit.length == strArrZ.length && strArrZ[0].charAt(0) != '!') {
            return null;
        }
        if (strArrZ[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrZ.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrZ.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i = length - length2; i < strArrSplit2.length; i++) {
            sb.append(strArrSplit2[i]).append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] z(String[] strArr) {
        String str;
        String strZ;
        String strZ2;
        int i = 0;
        if (!this.gc.get() && this.gc.compareAndSet(false, true)) {
            g();
        } else {
            try {
                this.m.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.e == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(dl.gc);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                strZ = null;
                break;
            }
            strZ = z(this.e, bArr, i3);
            if (strZ != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = z;
                strZ2 = z(this.e, bArr2, i4);
                if (strZ2 != null) {
                    break;
                }
            }
            strZ2 = null;
        } else {
            strZ2 = null;
        }
        if (strZ2 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String strZ3 = z(this.gz, bArr, i);
                if (strZ3 != null) {
                    str = strZ3;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strZ == null && strZ2 == null) {
            return dl;
        }
        String[] strArrSplit = strZ != null ? strZ.split("\\.") : g;
        String[] strArrSplit2 = strZ2 != null ? strZ2.split("\\.") : g;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static String z(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z2;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 >= 0 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z3 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z3) {
                    i3 = 46;
                    z2 = false;
                } else {
                    z2 = z3;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 != 0) {
                    break;
                }
                i12++;
                i11++;
                if (i12 == i9) {
                    break;
                }
                if (bArr2[i10].length != i11) {
                    z3 = z2;
                } else {
                    if (i10 == bArr2.length - 1) {
                        break;
                    }
                    i10++;
                    i11 = -1;
                    z3 = true;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, dl.gc);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    private void g() {
        boolean z2 = false;
        while (true) {
            try {
                try {
                    dl();
                    break;
                } catch (InterruptedIOException unused) {
                    z2 = true;
                } catch (IOException e) {
                    gc.g().z(5, "Failed to read public suffix list", e);
                    if (z2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    private void dl() throws IOException {
        InputStream resourceAsStream = z.class.getResourceAsStream(PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        com.bytedance.sdk.component.dl.z.gc gcVarZ = wp.z(new uy(wp.z(resourceAsStream)));
        try {
            byte[] bArr = new byte[gcVarZ.uy()];
            gcVarZ.z(bArr);
            byte[] bArr2 = new byte[gcVarZ.uy()];
            gcVarZ.z(bArr2);
            synchronized (this) {
                this.e = bArr;
                this.gz = bArr2;
            }
            this.m.countDown();
        } finally {
            dl.z(gcVarZ);
        }
    }
}
