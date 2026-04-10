package com.bytedance.sdk.component.dl.z;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class m implements Serializable, Comparable<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    transient int f695a;
    final byte[] dl;
    transient String gc;
    static final char[] z = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final m g = z(new byte[0]);

    m(byte[] bArr) {
        this.dl = bArr;
    }

    public static m z(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new m((byte[]) bArr.clone());
    }

    public static m z(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        m mVar = new m(str.getBytes(q.z));
        mVar.gc = str;
        return mVar;
    }

    public String z() {
        String str = this.gc;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.dl, q.z);
        this.gc = str2;
        return str2;
    }

    public String g() {
        return g.z(this.dl);
    }

    public m dl() {
        return dl("SHA-1");
    }

    public m a() {
        return dl("SHA-256");
    }

    private m dl(String str) {
        try {
            return z(MessageDigest.getInstance(str).digest(this.dl));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public String gc() {
        byte[] bArr = this.dl;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = z;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static m g(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(String.valueOf(str)));
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((z(str.charAt(i2)) << 4) + z(str.charAt(i2 + 1)));
        }
        return z(bArr);
    }

    private static int z(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c)));
            }
        }
        return (c - c2) + 10;
    }

    public m m() {
        int i = 0;
        while (true) {
            byte[] bArr = this.dl;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new m(bArr2);
            }
            i++;
        }
    }

    public m z(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.dl;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.dl.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new m(bArr2);
    }

    public byte z(int i) {
        return this.dl[i];
    }

    public int e() {
        return this.dl.length;
    }

    public byte[] gz() {
        return (byte[]) this.dl.clone();
    }

    void z(dl dlVar) {
        byte[] bArr = this.dl;
        dlVar.dl(bArr, 0, bArr.length);
    }

    public boolean z(int i, m mVar, int i2, int i3) {
        return mVar.z(i2, this.dl, i, i3);
    }

    public boolean z(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.dl;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && q.z(bArr2, i, bArr, i2, i3);
    }

    public final boolean z(m mVar) {
        return z(0, mVar, 0, mVar.e());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            int iE = mVar.e();
            byte[] bArr = this.dl;
            if (iE == bArr.length && mVar.z(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.f695a;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.dl);
        this.f695a = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(m mVar) {
        int iE = e();
        int iE2 = mVar.e();
        int iMin = Math.min(iE, iE2);
        for (int i = 0; i < iMin; i++) {
            int iZ = z(i) & 255;
            int iZ2 = mVar.z(i) & 255;
            if (iZ != iZ2) {
                return iZ < iZ2 ? -1 : 1;
            }
        }
        if (iE == iE2) {
            return 0;
        }
        return iE < iE2 ? -1 : 1;
    }

    public String toString() {
        if (this.dl.length == 0) {
            return "[size=0]";
        }
        String strZ = z();
        int iZ = z(strZ, 64);
        if (iZ == -1) {
            if (this.dl.length <= 64) {
                return "[hex=" + gc() + "]";
            }
            return "[size=" + this.dl.length + " hex=" + z(0, 64).gc() + "…]";
        }
        String strReplace = strZ.substring(0, iZ).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return iZ < strZ.length() ? "[size=" + this.dl.length + " text=" + strReplace + "…]" : "[text=" + strReplace + "]";
    }

    static int z(String str, int i) {
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
