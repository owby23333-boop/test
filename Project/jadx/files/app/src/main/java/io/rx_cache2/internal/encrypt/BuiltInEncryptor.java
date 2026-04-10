package io.rx_cache2.internal.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInEncryptor implements Encryptor {
    private static final int FILE_BUF = 1024;
    private static final int KEY_LENGTH = 128;
    private Cipher decryptCipher;
    private Cipher encryptCipher;

    private SecretKeySpec generateSecretKey(String str) throws Exception {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(str.getBytes("UTF-8"));
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, secureRandom);
        return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), "AES");
    }

    private void initCiphers(String str) {
        try {
            SecretKeySpec secretKeySpecGenerateSecretKey = generateSecretKey(str);
            this.encryptCipher = Cipher.getInstance("AES");
            this.encryptCipher.init(1, secretKeySpecGenerateSecretKey);
            this.decryptCipher = Cipher.getInstance("AES");
            this.decryptCipher.init(2, secretKeySpecGenerateSecretKey);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void write(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    try {
                        int i2 = inputStream.read(bArr);
                        if (i2 == -1) {
                            inputStream.close();
                            outputStream.flush();
                            outputStream.close();
                            return;
                        }
                        outputStream.write(bArr, 0, i2);
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    inputStream.close();
                    outputStream.flush();
                    outputStream.close();
                    return;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                return;
            }
        }
    }

    @Override // io.rx_cache2.internal.encrypt.Encryptor
    public void decrypt(String str, File file, File file2) {
        initCiphers(str);
        try {
            write(new FileInputStream(file), new CipherOutputStream(new FileOutputStream(file2), this.decryptCipher));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // io.rx_cache2.internal.encrypt.Encryptor
    public void encrypt(String str, File file, File file2) {
        initCiphers(str);
        try {
            write(new CipherInputStream(new FileInputStream(file), this.encryptCipher), new FileOutputStream(file2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
