package com.bytedance.sdk.component.g.z.g;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Serializable, Comparable<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte[] f715a;
    transient int gc;
    transient String m;
    static final char[] z = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset g = Charset.forName("UTF-8");
    public static final a dl = z(new byte[0]);

    a(byte[] bArr) {
        this.f715a = bArr;
    }

    public static a z(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new a((byte[]) bArr.clone());
    }

    public String z() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f715a, g);
        this.m = str2;
        return str2;
    }

    public static a z(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        a aVar = new a(str.getBytes(uy.z));
        aVar.m = str;
        return aVar;
    }

    public String g() {
        byte[] bArr = this.f715a;
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

    public a z(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f715a;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f715a.length + ")");
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
        return new a(bArr2);
    }

    public byte z(int i) {
        return this.f715a[i];
    }

    public int dl() {
        return this.f715a.length;
    }

    public byte[] a() {
        return (byte[]) this.f715a.clone();
    }

    public boolean z(int i, a aVar, int i2, int i3) {
        return aVar.z(i2, this.f715a, i, i3);
    }

    public boolean z(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.f715a;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && uy.z(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            int iDl = aVar.dl();
            byte[] bArr = this.f715a;
            if (iDl == bArr.length && aVar.z(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.gc;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.f715a);
        this.gc = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        int iDl = dl();
        int iDl2 = aVar.dl();
        int iMin = Math.min(iDl, iDl2);
        for (int i = 0; i < iMin; i++) {
            int iZ = z(i) & 255;
            int iZ2 = aVar.z(i) & 255;
            if (iZ != iZ2) {
                return iZ < iZ2 ? -1 : 1;
            }
        }
        if (iDl == iDl2) {
            return 0;
        }
        return iDl < iDl2 ? -1 : 1;
    }

    public String toString() {
        if (this.f715a.length == 0) {
            return "[size=0]";
        }
        String strZ = z();
        int iZ = z(strZ, 64);
        if (iZ == -1) {
            if (this.f715a.length <= 64) {
                return "[hex=" + g() + "]";
            }
            return "[size=" + this.f715a.length + " hex=" + z(0, 64).g() + "…]";
        }
        String strReplace = strZ.substring(0, iZ).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return iZ < strZ.length() ? "[size=" + this.f715a.length + " text=" + strReplace + "…]" : "[text=" + strReplace + "]";
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
