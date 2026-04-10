package com.sntech.stat;

import android.content.Context;
import android.util.Base64;
import com.anythink.core.c.e;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
import q.b;
import q.d;

/* JADX INFO: renamed from: com.sntech.stat.for, reason: invalid class name */
/* JADX INFO: compiled from: SNCTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cfor implements Runnable {
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static JSONObject m146do(Context context, JSONObject jSONObject) throws Exception {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream;
        JSONObject jSONObject2 = new JSONObject();
        String str = d.a(UUID.randomUUID().toString().getBytes()) + System.currentTimeMillis();
        int iRandom = (int) ((Math.random() * 20.0d) + 1.0d);
        String strA = str;
        for (int i2 = 0; i2 < iRandom; i2++) {
            strA = d.a(strA.getBytes());
        }
        byte[] bytes = jSONObject.toString().getBytes();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bytes == null || bytes.length == 0) {
            byteArray = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream3);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
            } catch (Exception unused) {
                boolean z2 = Cdo.f125do;
            }
            byteArray = byteArrayOutputStream3.toByteArray();
        }
        byte[] bArrEncode = Base64.encode(byteArray, 2);
        byte[] bytes2 = strA.getBytes();
        byte[] bArr = b.f21664d;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
        String strEncodeToString = Base64.encodeToString(cipher.doFinal(bArrEncode), 2);
        byte[] bytes3 = strA.getBytes();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtBXKwTT+bbYukXr9GxnfHcUJOZYp4BrT3AdOeCdEr3n/YT42o3oNOf6nCGuz0Wod61rrxcTlVS/A+sjhQLBf2H6kkOVM4Xc+LU+2xBRXEkmFRZQf8lzSrzLDclrqS7IhHIwUdWZJR6vdQJlvD6VA/AtnzVIGvbQPVhbnVzo2er+Moww/3Aqp8xBn7qF11tgL4AcyWqtDwPYY7cTC22IcxZeB3Um/WyWpAsR2a61RlyANfQ56znGXirZImI4SRFcIVwsSvBXrysnFVx07VNoXELRZEeIywjMfyK1QbSu9/Q2NZwnIR0cD/Cr/QAPr9qkhX3uHNjPZrBYZ+FxwBkijmQIDAQAB", 0)));
        int length = bytes3.length / 245;
        if (bytes3.length % 245 != 0) {
            length++;
        }
        try {
            try {
                Cipher cipher2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher2.init(1, rSAPublicKey);
                byteArrayOutputStream = new ByteArrayOutputStream(length * 256);
                for (int i3 = 0; i3 < bytes3.length; i3 += 245) {
                    try {
                        int length2 = bytes3.length - i3;
                        if (length2 > 245) {
                            length2 = 245;
                        }
                        byteArrayOutputStream.write(cipher2.doFinal(bytes3, i3, length2));
                    } catch (Exception e2) {
                        e = e2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        throw new Exception("ENCRYPT ERROR:", e);
                    } catch (Throwable th) {
                        th = th;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e3) {
                                throw new Exception("CLOSE ByteArrayOutputStream ERROR:", e3);
                            }
                        }
                        throw th;
                    }
                }
                byteArrayOutputStream.flush();
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                    String strEncodeToString2 = Base64.encodeToString(byteArray2, 2);
                    jSONObject2.put("s_v", b.a);
                    jSONObject2.put("v", "1.3.80");
                    jSONObject2.put("p", context.getPackageName());
                    jSONObject2.put(e.a, 1);
                    jSONObject2.put("d", strEncodeToString);
                    jSONObject2.put("k", strEncodeToString2);
                    jSONObject2.put("c", b.b);
                    jSONObject2.put("did", b.a(context));
                    return jSONObject2;
                } catch (Exception e4) {
                    throw new Exception("CLOSE ByteArrayOutputStream ERROR:", e4);
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = byteArrayOutputStream2;
        }
    }
}
