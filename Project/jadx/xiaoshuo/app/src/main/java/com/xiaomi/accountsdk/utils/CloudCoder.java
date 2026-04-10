package com.xiaomi.accountsdk.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.hasheddeviceidlib.DeviceIdHasher;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SecureRequestForAccount;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.yuewen.yg3;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class CloudCoder {
    public static final int BASE64_FLAG_FOR_APACHE_URL_SAFE_STRING = 11;
    private static final Integer INT_0;
    private static final String RC4_ALGORITHM_NAME = "RC4";
    private static final String URL_REMOTE_DECRYPT;
    private static final String URL_REMOTE_ENCRYPT;
    public static final String UTF_8 = "UTF-8";

    public enum CIPHER_MODE {
        ENCRYPT,
        DECRYPT
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = XMPassport.URL_ACCOUNT_SAFE_API_BASE;
        sb.append(str);
        sb.append("/user/getSecurityToken");
        URL_REMOTE_ENCRYPT = sb.toString();
        URL_REMOTE_DECRYPT = str + "/user/getPlanText";
        INT_0 = 0;
    }

    public static String decodeString(String str, String str2, String str3) throws BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        return decodeString(newAESCipher(str, 2), str2, str3);
    }

    public static byte[] encodeStream(String str, byte[] bArr) throws BadPaddingException, IllegalBlockSizeException, IOException {
        byte[] bArrDoFinal = newRC4Cipher(randomRc4Key128(str), 1).doFinal(bArr);
        if (bArr.length == bArrDoFinal.length) {
            return bArrDoFinal;
        }
        throw new IOException("The encoded data length is not the same with original data");
    }

    public static String encodeString(String str, String str2, String str3) throws BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        Cipher cipherNewAESCipher = newAESCipher(str, 1);
        return cipherNewAESCipher == null ? "" : encodeString(cipherNewAESCipher, str2, str3);
    }

    public static String encodeUpperHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(String.format("%02X", Byte.valueOf(b2)));
        }
        return sb.toString();
    }

    public static String generateNonce() {
        return NonceCoder.generateNonce();
    }

    public static String generatePseudoDeviceId() {
        byte[] bArr = new byte[8];
        new SecureRandom().nextBytes(bArr);
        return encodeUpperHex(bArr);
    }

    public static String generateSignature(String str, String str2, Map<String, String> map, String str3) {
        return Coder.generateSignature(str, str2, map, str3);
    }

    public static String getDataMd5Digest(byte[] bArr) {
        return Coder.getDataMd5Digest(bArr);
    }

    public static String getDataSha1Digest(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(yg3.b.f20351b);
                messageDigest.update(bArr);
                return getHexString(messageDigest.digest());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static String getFileSha1Digest(String str) {
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        try {
            try {
                messageDigest = MessageDigest.getInstance(yg3.b.f20351b);
                try {
                    fileInputStream = new FileInputStream(new File((String) str));
                } catch (Exception e) {
                    e = e;
                    fileInputStream = null;
                } catch (Throwable unused) {
                    str = 0;
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (messageDigest != null) {
                        return getHexString(messageDigest.digest());
                    }
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable unused2) {
                str = 0;
                messageDigest = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i != -1) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        try {
                            break;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
                fileInputStream.close();
                if (messageDigest != null) {
                    return getHexString(messageDigest.digest());
                }
                return null;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable unused3) {
        }
    }

    public static String getHexString(byte[] bArr) {
        return Coder.getHexString(bArr);
    }

    public static String getMd5DigestUpperCase(String str) {
        return Coder.getMd5DigestUpperCase(str);
    }

    public static String hash4SHA1(String str) {
        return Coder.hash4SHA1(str);
    }

    public static String hashAndJoin(String str, List<String> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return hashAndJoin(str, (String[]) list.toArray(new String[list.size()]), i);
    }

    public static String hashDeviceInfo(String str) {
        return DeviceIdHasher.hashDeviceInfo(str, 8);
    }

    public static Cipher newAESCipher(String str, int i) {
        return newAESCipherWithIV(str, i, "0102030405060708".getBytes());
    }

    public static Cipher newAESCipherWithIV(String str, int i, byte[] bArr) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 2), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(i, secretKeySpec, new IvParameterSpec(bArr));
            return cipher;
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static Cipher newRC4Cipher(byte[] bArr, int i) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, RC4_ALGORITHM_NAME);
        try {
            Cipher cipher = Cipher.getInstance(RC4_ALGORITHM_NAME);
            cipher.init(i, secretKeySpec);
            return cipher;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private static byte[] randomRc4Key128(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String remoteEndecrypt(String str, String str2, String str3, String str4, String str5, CIPHER_MODE cipher_mode) throws AccessDeniedException, CipherException, IOException, InvalidResponseException, AuthenticationFailureException {
        String str6;
        if (!TextUtils.isDigitsOnly(str)) {
            throw new IllegalArgumentException("userId is not only digits");
        }
        HashMap map = new HashMap();
        CIPHER_MODE cipher_mode2 = CIPHER_MODE.ENCRYPT;
        if (cipher_mode == cipher_mode2) {
            str6 = URL_REMOTE_ENCRYPT;
            map.put("plainText", str3);
        } else {
            str6 = URL_REMOTE_DECRYPT;
            map.put("token", str3);
        }
        map.put("userId", str);
        HashMap map2 = new HashMap();
        map2.put("cUserId", str2);
        map2.put("serviceToken", str4);
        SimpleRequest.MapContent mapContentPostAsMap = SecureRequestForAccount.postAsMap(str6, map, map2, true, str5);
        Object fromBody = mapContentPostAsMap.getFromBody("code");
        if (!INT_0.equals(fromBody)) {
            throw new InvalidResponseException("failed to encrypt, code: " + fromBody);
        }
        Object fromBody2 = mapContentPostAsMap.getFromBody("data");
        if (!(fromBody2 instanceof Map)) {
            throw new InvalidResponseException("invalid data node");
        }
        Object obj = ((Map) fromBody2).get(cipher_mode == cipher_mode2 ? "cipher" : "plainText");
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new InvalidResponseException("invalid result: " + obj);
    }

    public static String generateNonce(long j) {
        return NonceCoder.generateNonce(j);
    }

    public static String hashDeviceInfo(String str, int i) {
        return DeviceIdHasher.hashDeviceInfo(str, i);
    }

    public static String decodeString(Cipher cipher, String str, String str2) throws BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return new String(cipher.doFinal(Base64.decode(str.getBytes(str2), 2)), str2);
        } catch (IllegalArgumentException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    public static String encodeString(Cipher cipher, String str, String str2) throws BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        return Base64.encodeToString(cipher.doFinal(str.getBytes(str2)), 2);
    }

    public static String hashAndJoin(String str, String[] strArr, int i) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            String strHash4SHA1 = hash4SHA1(str2);
            if (strHash4SHA1 != null) {
                if (i > 0 && i <= strHash4SHA1.length()) {
                    arrayList.add(strHash4SHA1.substring(0, i));
                } else {
                    arrayList.add(strHash4SHA1);
                }
            }
        }
        if (str == null) {
            str = "";
        }
        return TextUtils.join(str, arrayList);
    }
}
