package com.bytedance.sdk.component.d.e;

import com.google.common.base.Ascii;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import miuix.security.DigestUtils;

/* JADX INFO: loaded from: classes.dex */
public class vn implements Serializable, Comparable<vn> {
    final byte[] d;
    transient String ga;
    transient int tg;
    static final char[] e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final vn bf = e(new byte[0]);

    public vn(byte[] bArr) {
        this.d = bArr;
    }

    public static vn e(byte... bArr) {
        if (bArr != null) {
            return new vn((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String bf() {
        return bf.e(this.d);
    }

    public vn d() {
        return d(DigestUtils.ALGORITHM_SHA_1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof vn) {
            vn vnVar = (vn) obj;
            int iP = vnVar.p();
            byte[] bArr = this.d;
            if (iP == bArr.length && vnVar.e(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public String ga() {
        byte[] bArr = this.d;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = e;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & Ascii.SI];
        }
        return new String(cArr);
    }

    public int hashCode() {
        int i = this.tg;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.d);
        this.tg = iHashCode;
        return iHashCode;
    }

    public int p() {
        return this.d.length;
    }

    public vn tg() {
        return d("SHA-256");
    }

    public String toString() {
        StringBuilder sb;
        if (this.d.length == 0) {
            return "[size=0]";
        }
        String strE = e();
        int iE = e(strE, 64);
        if (iE == -1) {
            if (this.d.length <= 64) {
                return "[hex=" + ga() + "]";
            }
            return "[size=" + this.d.length + " hex=" + e(0, 64).ga() + "…]";
        }
        String strReplace = strE.substring(0, iE).replace("\\", "\\\\").replace(SignatureUtils.DELIMITER, "\\n").replace("\r", "\\r");
        if (iE < strE.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.d.length);
            sb.append(" text=");
            sb.append(strReplace);
            sb.append("…]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(strReplace);
            sb.append("]");
        }
        return sb.toString();
    }

    public byte[] v() {
        return (byte[]) this.d.clone();
    }

    public vn vn() {
        int i = 0;
        while (true) {
            byte[] bArr = this.d;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new vn(bArr2);
            }
            i++;
        }
    }

    public static vn bf(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((e(str.charAt(i2)) << 4) + e(str.charAt(i2 + 1)));
        }
        return e(bArr);
    }

    private vn d(String str) {
        try {
            return e(MessageDigest.getInstance(str).digest(this.d));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static vn e(String str) {
        if (str != null) {
            vn vnVar = new vn(str.getBytes(pe.e));
            vnVar.ga = str;
            return vnVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String e() {
        String str = this.ga;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.d, pe.e);
        this.ga = str2;
        return str2;
    }

    private static int e(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    public vn e(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.d;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.d.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new vn(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: bf, reason: merged with bridge method [inline-methods] */
    public int compareTo(vn vnVar) {
        int iP = p();
        int iP2 = vnVar.p();
        int iMin = Math.min(iP, iP2);
        for (int i = 0; i < iMin; i++) {
            int iE = e(i) & 255;
            int iE2 = vnVar.e(i) & 255;
            if (iE != iE2) {
                return iE < iE2 ? -1 : 1;
            }
        }
        if (iP == iP2) {
            return 0;
        }
        return iP < iP2 ? -1 : 1;
    }

    public byte e(int i) {
        return this.d[i];
    }

    public void e(d dVar) {
        byte[] bArr = this.d;
        dVar.d(bArr, 0, bArr.length);
    }

    public boolean e(int i, vn vnVar, int i2, int i3) {
        return vnVar.e(i2, this.d, i, i3);
    }

    public boolean e(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.d;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && pe.e(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean e(vn vnVar) {
        return e(0, vnVar, 0, vnVar.p());
    }

    public static int e(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
