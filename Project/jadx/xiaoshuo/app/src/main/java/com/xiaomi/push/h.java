package com.xiaomi.push;

import com.google.common.base.Ascii;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes8.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f8026a = {100, Ascii.ETB, 84, 114, 72, 0, 4, 97, 73, 97, 2, 52, 84, 102, 18, 32};

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 2).doFinal(bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, 1).doFinal(bArr2);
    }

    private static Cipher a(byte[] bArr, int i) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f8026a);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, secretKeySpec, ivParameterSpec);
        return cipher;
    }
}
