package com.bytedance.sdk.component.bf.e.bf;

import com.google.common.base.Ascii;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class tg implements Serializable, Comparable<tg> {
    transient int ga;
    final byte[] tg;
    transient String vn;
    static final char[] e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset bf = Charset.forName("UTF-8");
    public static final tg d = e(new byte[0]);

    public tg(byte[] bArr) {
        this.tg = bArr;
    }

    public static tg e(byte... bArr) {
        if (bArr != null) {
            return new tg((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String bf() {
        byte[] bArr = this.tg;
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

    public int d() {
        return this.tg.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof tg) {
            tg tgVar = (tg) obj;
            int iD = tgVar.d();
            byte[] bArr = this.tg;
            if (iD == bArr.length && tgVar.e(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.ga;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.tg);
        this.ga = iHashCode;
        return iHashCode;
    }

    public byte[] tg() {
        return (byte[]) this.tg.clone();
    }

    public String toString() {
        StringBuilder sb;
        if (this.tg.length == 0) {
            return "[size=0]";
        }
        String strE = e();
        int iE = e(strE, 64);
        if (iE == -1) {
            if (this.tg.length <= 64) {
                return "[hex=" + bf() + "]";
            }
            return "[size=" + this.tg.length + " hex=" + e(0, 64).bf() + "…]";
        }
        String strReplace = strE.substring(0, iE).replace("\\", "\\\\").replace(SignatureUtils.DELIMITER, "\\n").replace("\r", "\\r");
        if (iE < strE.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.tg.length);
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

    public String e() {
        String str = this.vn;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.tg, bf);
        this.vn = str2;
        return str2;
    }

    public static tg e(String str) {
        if (str != null) {
            tg tgVar = new tg(str.getBytes(zk.e));
            tgVar.vn = str;
            return tgVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public tg e(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.tg;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.tg.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, i3);
                return new tg(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public byte e(int i) {
        return this.tg[i];
    }

    public boolean e(int i, tg tgVar, int i2, int i3) {
        return tgVar.e(i2, this.tg, i, i3);
    }

    public boolean e(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.tg;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && zk.e(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int compareTo(tg tgVar) {
        int iD = d();
        int iD2 = tgVar.d();
        int iMin = Math.min(iD, iD2);
        for (int i = 0; i < iMin; i++) {
            int iE = e(i) & 255;
            int iE2 = tgVar.e(i) & 255;
            if (iE != iE2) {
                return iE < iE2 ? -1 : 1;
            }
        }
        if (iD == iD2) {
            return 0;
        }
        return iD < iD2 ? -1 : 1;
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
