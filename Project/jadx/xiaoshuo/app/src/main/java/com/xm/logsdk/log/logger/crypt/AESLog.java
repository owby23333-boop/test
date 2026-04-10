package com.xm.logsdk.log.logger.crypt;

import android.util.Log;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes8.dex */
public class AESLog implements ICrypt {
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String KEY_ALGORITHM = "AES";
    public static String sIV = "0123012301230123";
    private String mKey;
    private Cipher mCipherEnc = null;
    private Cipher mCipherDec = null;

    public AESLog(String str) {
        this.mKey = str;
    }

    private Cipher createCipher(boolean z) {
        int i = !z ? 2 : 1;
        try {
            String str = this.mKey;
            if (str == null && str.length() != 16) {
                return null;
            }
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec secretIv = getSecretIv(sIV);
            if (secretIv != null) {
                cipher.init(i, getSecretKey(this.mKey), secretIv);
            } else {
                cipher.init(i, getSecretKey(this.mKey));
            }
            return cipher;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Cipher getCipherDec() {
        Cipher cipher = this.mCipherDec;
        if (cipher != null) {
            return cipher;
        }
        Cipher cipherCreateCipher = createCipher(false);
        this.mCipherDec = cipherCreateCipher;
        return cipherCreateCipher;
    }

    private Cipher getCipherEnc() {
        Cipher cipher = this.mCipherEnc;
        if (cipher != null) {
            return cipher;
        }
        Cipher cipherCreateCipher = createCipher(true);
        this.mCipherEnc = cipherCreateCipher;
        return cipherCreateCipher;
    }

    private IvParameterSpec getSecretIv(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return new IvParameterSpec(str.getBytes(StandardCharsets.UTF_8));
    }

    private SecretKeySpec getSecretKey(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return new SecretKeySpec(str.getBytes(StandardCharsets.UTF_8), KEY_ALGORITHM);
    }

    @Override // com.xm.logsdk.log.logger.crypt.ICrypt
    public String decrypt(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return "";
        }
        if (getCipherDec() == null) {
            return new String(bArr);
        }
        try {
            return new String(getCipherDec().doFinal(bArr, i, i2), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return new String(bArr);
        }
    }

    @Override // com.xm.logsdk.log.logger.crypt.ICrypt
    public byte[] encrypt(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (getCipherEnc() == null) {
            return bArr;
        }
        try {
            return getCipherEnc().doFinal(bArr, i, i2);
        } catch (Exception e) {
            e.printStackTrace();
            return bArr;
        }
    }

    public void log(String str) {
        Log.i("AESLOG", str);
    }

    public byte[] encrypt(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (getCipherEnc() != null) {
            try {
                return getCipherEnc().doFinal(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    public String decrypt(String str) {
        if (str != null && getCipherDec() != null) {
            try {
                return new String(getCipherDec().doFinal(str.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }
}
