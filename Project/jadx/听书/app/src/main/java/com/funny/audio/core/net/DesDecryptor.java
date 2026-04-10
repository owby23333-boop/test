package com.funny.audio.core.net;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: CryptoLib.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/funny/audio/core/net/DesDecryptor;", "", "()V", "decrypt", "", "encryptedText", "secretKey", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DesDecryptor {
    public static final DesDecryptor INSTANCE = new DesDecryptor();

    private DesDecryptor() {
    }

    public final String decrypt(String encryptedText, String secretKey) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(encryptedText, "encryptedText");
        Intrinsics.checkNotNullParameter(secretKey, "secretKey");
        byte[] bytes = secretKey.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(2, secretKeySpec);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        Intrinsics.checkNotNullExpressionValue(decryptedData, "decryptedData");
        return new String(decryptedData, Charsets.UTF_8);
    }
}
