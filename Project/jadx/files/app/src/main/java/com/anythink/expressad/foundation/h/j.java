package com.anythink.expressad.foundation.h;

import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.cb;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static final String a = "j";
    private static Map<Character, Character> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<Character, Character> f10652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static char[] f10653d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static byte[] f10654e = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, cb.f19602k, cb.f19603l, cb.f19604m, cb.f19605n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    static {
        HashMap map = new HashMap();
        f10652c = map;
        map.put('v', 'A');
        f10652c.put('S', 'B');
        f10652c.put('o', 'C');
        f10652c.put('a', 'D');
        f10652c.put('j', 'E');
        f10652c.put('c', 'F');
        f10652c.put('7', 'G');
        f10652c.put('d', 'H');
        f10652c.put('R', 'I');
        f10652c.put('z', 'J');
        f10652c.put('p', 'K');
        f10652c.put('W', 'L');
        f10652c.put('i', 'M');
        f10652c.put('f', 'N');
        f10652c.put('G', 'O');
        f10652c.put('y', 'P');
        f10652c.put('N', 'Q');
        f10652c.put('x', 'R');
        f10652c.put('Z', 'S');
        f10652c.put('n', 'T');
        f10652c.put('V', 'U');
        f10652c.put('5', 'V');
        f10652c.put('k', 'W');
        f10652c.put('+', 'X');
        f10652c.put('D', 'Y');
        f10652c.put('H', 'Z');
        f10652c.put('L', 'a');
        f10652c.put('Y', 'b');
        f10652c.put('h', 'c');
        f10652c.put('J', 'd');
        f10652c.put('4', 'e');
        f10652c.put('6', 'f');
        f10652c.put('l', 'g');
        f10652c.put('t', 'h');
        f10652c.put('0', 'i');
        f10652c.put('U', 'j');
        f10652c.put('3', 'k');
        f10652c.put('Q', 'l');
        f10652c.put('r', 'm');
        f10652c.put('g', 'n');
        f10652c.put('E', 'o');
        f10652c.put('u', 'p');
        f10652c.put('q', 'q');
        f10652c.put('8', 'r');
        f10652c.put('s', 's');
        f10652c.put('w', 't');
        f10652c.put('/', 'u');
        f10652c.put('X', 'v');
        f10652c.put('M', 'w');
        f10652c.put('e', 'x');
        f10652c.put('B', 'y');
        f10652c.put('A', 'z');
        f10652c.put('T', '0');
        f10652c.put('2', '1');
        f10652c.put('F', '2');
        f10652c.put('b', '3');
        f10652c.put('9', '4');
        f10652c.put('P', '5');
        f10652c.put('1', '6');
        f10652c.put('O', '7');
        f10652c.put('I', '8');
        f10652c.put('K', '9');
        f10652c.put('m', '+');
        f10652c.put('C', '/');
        HashMap map2 = new HashMap();
        b = map2;
        map2.put('A', 'v');
        b.put('B', 'S');
        b.put('C', 'o');
        b.put('D', 'a');
        b.put('E', 'j');
        b.put('F', 'c');
        b.put('G', '7');
        b.put('H', 'd');
        b.put('I', 'R');
        b.put('J', 'z');
        b.put('K', 'p');
        b.put('L', 'W');
        b.put('M', 'i');
        b.put('N', 'f');
        b.put('O', 'G');
        b.put('P', 'y');
        b.put('Q', 'N');
        b.put('R', 'x');
        b.put('S', 'Z');
        b.put('T', 'n');
        b.put('U', 'V');
        b.put('V', '5');
        b.put('W', 'k');
        b.put('X', '+');
        b.put('Y', 'D');
        b.put('Z', 'H');
        b.put('a', 'L');
        b.put('b', 'Y');
        b.put('c', 'h');
        b.put('d', 'J');
        b.put('e', '4');
        b.put('f', '6');
        b.put('g', 'l');
        b.put('h', 't');
        b.put('i', '0');
        b.put('j', 'U');
        b.put('k', '3');
        b.put('l', 'Q');
        b.put('m', 'r');
        b.put('n', 'g');
        b.put('o', 'E');
        b.put('p', 'u');
        b.put('q', 'q');
        b.put('r', '8');
        b.put('s', 's');
        b.put('t', 'w');
        b.put('u', '/');
        b.put('v', 'X');
        b.put('w', 'M');
        b.put('x', 'e');
        b.put('y', 'B');
        b.put('z', 'A');
        b.put('0', 'T');
        b.put('1', '2');
        b.put('2', 'F');
        b.put('3', 'b');
        b.put('4', '9');
        b.put('5', 'P');
        b.put('6', '1');
        b.put('7', 'O');
        b.put('8', 'I');
        b.put('9', 'K');
        b.put('+', 'm');
        b.put('/', 'C');
    }

    private j() {
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(f10653d[i4 >>> 2]);
                stringBuffer.append(f10653d[(i4 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                stringBuffer.append(f10653d[i4 >>> 2]);
                stringBuffer.append(f10653d[((i4 & 3) << 4) | ((i6 & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >>> 4)]);
                stringBuffer.append(f10653d[(i6 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i7 = i5 + 1;
            int i8 = bArr[i5] & 255;
            stringBuffer.append(f10653d[i4 >>> 2]);
            stringBuffer.append(f10653d[((i4 & 3) << 4) | ((i6 & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >>> 4)]);
            stringBuffer.append(f10653d[((i6 & 15) << 2) | ((i8 & 192) >>> 6)]);
            stringBuffer.append(f10653d[i8 & 63]);
            i2 = i7;
        }
        return stringBuffer.toString();
    }

    public static String b(String str) {
        return q.a(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
    
        if (r2 == (-1)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        r1.write(r2 | ((r5 & 3) << 6));
        r2 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] c(java.lang.String r8) {
        /*
            byte[] r8 = r8.getBytes()
            int r0 = r8.length
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>(r0)
            r2 = 0
        Lb:
            if (r2 >= r0) goto L82
        Ld:
            byte[] r3 = com.anythink.expressad.foundation.h.j.f10654e
            int r4 = r2 + 1
            r2 = r8[r2]
            r2 = r3[r2]
            r3 = -1
            if (r4 >= r0) goto L1d
            if (r2 == r3) goto L1b
            goto L1d
        L1b:
            r2 = r4
            goto Ld
        L1d:
            if (r2 == r3) goto L82
        L1f:
            byte[] r5 = com.anythink.expressad.foundation.h.j.f10654e
            int r6 = r4 + 1
            r4 = r8[r4]
            r4 = r5[r4]
            if (r6 >= r0) goto L2e
            if (r4 == r3) goto L2c
            goto L2e
        L2c:
            r4 = r6
            goto L1f
        L2e:
            if (r4 == r3) goto L82
            int r2 = r2 << 2
            r5 = r4 & 48
            int r5 = r5 >>> 4
            r2 = r2 | r5
            r1.write(r2)
        L3a:
            int r2 = r6 + 1
            r5 = r8[r6]
            r6 = 61
            if (r5 != r6) goto L47
            byte[] r8 = r1.toByteArray()
            return r8
        L47:
            byte[] r7 = com.anythink.expressad.foundation.h.j.f10654e
            r5 = r7[r5]
            if (r2 >= r0) goto L52
            if (r5 == r3) goto L50
            goto L52
        L50:
            r6 = r2
            goto L3a
        L52:
            if (r5 == r3) goto L82
            r4 = r4 & 15
            int r4 = r4 << 4
            r7 = r5 & 60
            int r7 = r7 >>> 2
            r4 = r4 | r7
            r1.write(r4)
        L60:
            int r4 = r2 + 1
            r2 = r8[r2]
            if (r2 != r6) goto L6b
            byte[] r8 = r1.toByteArray()
            return r8
        L6b:
            byte[] r7 = com.anythink.expressad.foundation.h.j.f10654e
            r2 = r7[r2]
            if (r4 >= r0) goto L76
            if (r2 == r3) goto L74
            goto L76
        L74:
            r2 = r4
            goto L60
        L76:
            if (r2 == r3) goto L82
            r3 = r5 & 3
            int r3 = r3 << 6
            r2 = r2 | r3
            r1.write(r2)
            r2 = r4
            goto Lb
        L82:
            byte[] r8 = r1.toByteArray()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.j.c(java.lang.String):byte[]");
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : q.b(str);
    }
}
