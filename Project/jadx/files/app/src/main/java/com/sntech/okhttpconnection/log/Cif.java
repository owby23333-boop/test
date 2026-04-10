package com.sntech.okhttpconnection.log;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.sntech.okhttpconnection.log.if, reason: invalid class name */
/* JADX INFO: compiled from: CryptoUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cif {

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static final byte[] f121do = Cfor.m135do("x04VOtkJ");

    /* JADX INFO: renamed from: com.sntech.okhttpconnection.log.if$do, reason: invalid class name */
    /* JADX INFO: compiled from: CryptoUtils.java */
    public static class Cdo {
        /* JADX INFO: renamed from: do, reason: not valid java name */
        public static byte[] m132do(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        }

        /* JADX INFO: renamed from: if, reason: not valid java name */
        public static byte[] m133if(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        }
    }

    /* JADX INFO: renamed from: com.sntech.okhttpconnection.log.if$if, reason: invalid class name and collision with other inner class name */
    /* JADX INFO: compiled from: CryptoUtils.java */
    public static class C0507if {
        /* JADX INFO: renamed from: do, reason: not valid java name */
        public static byte[] m136do(byte[] bArr) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    gZIPOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.sntech.okhttpconnection.log.if$new, reason: invalid class name */
    /* JADX INFO: compiled from: CryptoUtils.java */
    public static class Cnew {
        /* JADX INFO: renamed from: do, reason: not valid java name */
        public static byte[] m137do(byte[] bArr) throws Exception {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtBXKwTT+bbYukXr9GxnfHcUJOZYp4BrT3AdOeCdEr3n/YT42o3oNOf6nCGuz0Wod61rrxcTlVS/A+sjhQLBf2H6kkOVM4Xc+LU+2xBRXEkmFRZQf8lzSrzLDclrqS7IhHIwUdWZJR6vdQJlvD6VA/AtnzVIGvbQPVhbnVzo2er+Moww/3Aqp8xBn7qF11tgL4AcyWqtDwPYY7cTC22IcxZeB3Um/WyWpAsR2a61RlyANfQ56znGXirZImI4SRFcIVwsSvBXrysnFVx07VNoXELRZEeIywjMfyK1QbSu9/Q2NZwnIR0cD/Cr/QAPr9qkhX3uHNjPZrBYZ+FxwBkijmQIDAQAB".replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", "").replaceAll("\n", ""), 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, rSAPublicKey);
            return cipher.doFinal(bArr);
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static JSONObject m131do(JSONObject jSONObject, String str, String str2) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("od", jSONObject);
        jSONObject2.put("did", str);
        jSONObject2.put("r", str2);
        jSONObject2.put("user_id", com.sntech.okhttpconnection.log.Cdo.f111new);
        jSONObject2.put("p", com.sntech.okhttpconnection.log.Cdo.f110if.getPackageName());
        jSONObject2.put("s_v", com.sntech.okhttpconnection.log.Cdo.f108for);
        jSONObject2.put("p_s", com.sntech.okhttpconnection.log.Cfor.m130try(com.sntech.okhttpconnection.log.Cdo.f110if));
        return jSONObject2;
    }

    /* JADX INFO: renamed from: com.sntech.okhttpconnection.log.if$for, reason: invalid class name */
    /* JADX INFO: compiled from: CryptoUtils.java */
    public static class Cfor {
        /* JADX INFO: renamed from: do, reason: not valid java name */
        public static String m134do(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                for (byte b : messageDigest.digest()) {
                    int i2 = b & 255;
                    if (i2 < 16) {
                        stringBuffer.append("0" + Integer.toHexString(i2));
                    } else {
                        stringBuffer.append(Integer.toHexString(i2));
                    }
                }
                return stringBuffer.toString();
            } catch (NoSuchAlgorithmException unused) {
                return "No";
            }
        }

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public static byte[] m135do(String str) {
            if (str == null) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
    }
}
