package com.xiaomi.push.service;

import com.iflytek.aikit.media.param.MscKeys;

/* JADX INFO: loaded from: classes8.dex */
public class bo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f8256a = 8;
    private int d = -666;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f994a = new byte[256];
    private int c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8257b = 0;

    public static int a(byte b2) {
        return b2 >= 0 ? b2 : b2 + 256;
    }

    private void a(int i, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i2 = 0; i2 < 256; i2++) {
            this.f994a[i2] = (byte) i2;
        }
        this.c = 0;
        this.f8257b = 0;
        while (true) {
            int i3 = this.f8257b;
            if (i3 >= i) {
                break;
            }
            int iA = ((this.c + a(this.f994a[i3])) + a(bArr[this.f8257b % length])) % 256;
            this.c = iA;
            a(this.f994a, this.f8257b, iA);
            this.f8257b++;
        }
        if (i != 256) {
            this.d = ((this.c + a(this.f994a[i])) + a(bArr[i % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i4 = i - 1;
            sb.append(i4);
            sb.append(":");
            for (int i5 = 0; i5 <= i; i5++) {
                sb.append(" ");
                sb.append(a(this.f994a[i5]));
            }
            sb.append("   j_");
            sb.append(i4);
            sb.append(MscKeys.KEY_VAL_SEP);
            sb.append(this.c);
            sb.append("   j_");
            sb.append(i);
            sb.append(MscKeys.KEY_VAL_SEP);
            sb.append(this.d);
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i4);
            sb.append("]=");
            sb.append(a(this.f994a[this.c]));
            sb.append("   S_");
            sb.append(i4);
            sb.append("[j_");
            sb.append(i);
            sb.append("]=");
            sb.append(a(this.f994a[this.d]));
            if (this.f994a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            com.xiaomi.channel.commonutils.logger.b.m106a(sb.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    private void a() {
        this.c = 0;
        this.f8257b = 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte m773a() {
        int i = (this.f8257b + 1) % 256;
        this.f8257b = i;
        int iA = (this.c + a(this.f994a[i])) % 256;
        this.c = iA;
        a(this.f994a, this.f8257b, iA);
        byte[] bArr = this.f994a;
        return bArr[(a(bArr[this.f8257b]) + a(this.f994a[this.c])) % 256];
    }

    private static void a(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b2;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        bo boVar = new bo();
        boVar.a(bArr);
        boVar.a();
        for (int i = 0; i < bArr2.length; i++) {
            bArr3[i] = (byte) (bArr2[i] ^ boVar.m773a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i, int i2) {
        byte[] bArr3;
        int i3;
        if (i >= 0 && i <= bArr2.length && i + i2 <= bArr2.length) {
            if (z) {
                bArr3 = bArr2;
                i3 = i;
            } else {
                bArr3 = new byte[i2];
                i3 = 0;
            }
            bo boVar = new bo();
            boVar.a(bArr);
            boVar.a();
            for (int i4 = 0; i4 < i2; i4++) {
                bArr3[i3 + i4] = (byte) (bArr2[i + i4] ^ boVar.m773a());
            }
            return bArr3;
        }
        throw new IllegalArgumentException("start = " + i + " len = " + i2);
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, com.xiaomi.push.bl.m233a(str));
    }

    public static byte[] a(String str, String str2) {
        byte[] bArrM233a = com.xiaomi.push.bl.m233a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[bArrM233a.length + 1 + bytes.length];
        for (int i = 0; i < bArrM233a.length; i++) {
            bArr[i] = bArrM233a[i];
        }
        bArr[bArrM233a.length] = 95;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[bArrM233a.length + 1 + i2] = bytes[i2];
        }
        return bArr;
    }
}
