package cn.bmob.v3.datatype.up;

import anet.channel.strategy.dispatch.DispatchConstants;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.util.Base64Coder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class UpYunUtils {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    public static final String VERSION = "upyun-android-sdk 2.0.6";

    public static byte[] calculateRFC2104HMACRaw(String str, String str2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
        mac.init(secretKeySpec);
        return mac.doFinal(str2.getBytes());
    }

    public static int getBlockNum(File file, int i2) {
        double length = file.length();
        double d2 = i2;
        Double.isNaN(length);
        Double.isNaN(d2);
        return (int) Math.ceil(length / d2);
    }

    public static String getPolicy(Map<String, Object> map) {
        return Base64Coder.encodeString(new JSONObject(map).toString());
    }

    public static String getSignature(String str, String str2) {
        return md5(str + DispatchConstants.SIGN_SPLIT_SYMBOL + str2);
    }

    public static String md5(byte[] bArr) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("MessageDigest不支持MD5Util", e2);
        }
    }

    public static String md5Hex(File file) {
        int i2;
        try {
            int fileBlockSize = Bmob.getFileBlockSize();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileBlockSize];
            while (true) {
                int i3 = fileInputStream.read(bArr);
                if (i3 <= 0) {
                    break;
                }
                messageDigest.update(bArr, 0, i3);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i4 = b & 255;
                if (i4 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i4));
            }
            try {
                fileInputStream.close();
            } catch (Exception unused) {
            }
            return sb.toString();
        } catch (FileNotFoundException e2) {
            throw new RuntimeException("file not found", e2);
        } catch (IOException e3) {
            throw new RuntimeException("file get md5 failed", e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new RuntimeException("MessageDigest不支持MD5Util", e4);
        }
    }

    public static String getSignature(Map<String, Object> map, String str) {
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : array) {
            stringBuffer.append(obj);
            stringBuffer.append(map.get(obj));
        }
        stringBuffer.append(str);
        return md5(stringBuffer.toString().getBytes());
    }

    public static String md5(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 is unsupported", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("MessageDigest不支持MD5Util", e3);
        }
    }
}
