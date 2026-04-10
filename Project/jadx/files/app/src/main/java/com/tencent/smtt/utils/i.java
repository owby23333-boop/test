package com.tencent.smtt.utils;

import java.security.KeyFactory;
import java.security.Provider;
import java.security.Security;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes3.dex */
public class i {
    private static final char[] a = "0123456789abcdef".toCharArray();
    private static i b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19265e;

    private i() {
        int iNextInt = new Random().nextInt(89999999) + 10000000;
        int iNextInt2 = new Random().nextInt(89999999) + 10000000;
        this.f19265e = String.valueOf(iNextInt);
        this.f19263c = this.f19265e + String.valueOf(iNextInt2);
    }

    public static synchronized i a() {
        if (b == null) {
            b = new i();
        }
        return b;
    }

    private String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = a;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    public byte[] a(byte[] bArr) throws Exception {
        return com.tencent.smtt.sdk.stat.a.a(this.f19265e.getBytes(), bArr, 1);
    }

    public void b() throws Exception {
        Security.addProvider((Provider) Class.forName("com.android.org.bouncycastle.jce.provider.BouncyCastleProvider", true, ClassLoader.getSystemClassLoader()).newInstance());
    }

    public String c() throws Exception {
        if (this.f19264d == null) {
            byte[] bytes = this.f19263c.getBytes();
            Cipher cipher = null;
            try {
                try {
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                } catch (Exception unused) {
                    b();
                    cipher = Cipher.getInstance("RSA/ECB/NoPadding");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(android.util.Base64.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRB/Q0hTCD+XtnQhpQJefUCAwEAAQ==".getBytes(), 0))));
            this.f19264d = b(cipher.doFinal(bytes));
        }
        return this.f19264d;
    }
}
