package com.yuewen;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes10.dex */
public class ua3 {
    public static byte[] a(byte[] bArr, String str) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(com.alipay.sdk.m.p.d.f1901a).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(1, publicKeyGeneratePublic);
        return cipher.doFinal(bArr);
    }
}
