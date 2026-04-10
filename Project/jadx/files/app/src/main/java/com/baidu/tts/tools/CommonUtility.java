package com.baidu.tts.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.anythink.expressad.foundation.g.a;
import com.umeng.analytics.pro.cb;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class CommonUtility {
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    public static byte[] AES_cbc_decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher.getMaxAllowedKeyLength(ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String AES_cbc_encrypt(String str, String str2, String str3) {
        try {
            Cipher.getMaxAllowedKeyLength(ALGORITHM);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(a.bN), "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(1, secretKeySpec, new IvParameterSpec(str3.getBytes(a.bN)));
            return parseByte2HexStr(cipher.doFinal(str.getBytes(a.bN)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] addCAFHeaderForPCMData(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        long length = ((16 * (44 + bArr.length)) * ((long) 1)) / 8;
        byte[] bArr2 = {82, 73, 70, 70, (byte) (r3 & 255), (byte) ((r3 >> 8) & 255), (byte) ((r3 >> 16) & 255), (byte) ((r3 >> 24) & 255), 87, 65, 86, 69, 102, 109, 116, 32, cb.f19605n, 0, 0, 0, 1, 0, (byte) 1, 0, (byte) 128, (byte) 62, (byte) 0, (byte) 0, (byte) (length & 255), (byte) ((length >> 8) & 255), (byte) ((length >> 16) & 255), (byte) ((length >> 24) & 255), 2, 0, cb.f19605n, 0, 100, 97, 116, 97, (byte) (r1 & 255), (byte) ((r1 >> 8) & 255), (byte) ((r1 >> 16) & 255), (byte) ((r1 >> 24) & 255)};
        byte[] bArr3 = new byte[bArr2.length + bArr.length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
        return bArr3;
    }

    public static void asserts(boolean z2, String str) {
        if (!z2) {
            throw new AssertionError(str);
        }
    }

    private static int[] computeFailure(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        int i2 = 0;
        for (int i3 = 1; i3 < bArr.length; i3++) {
            while (i2 > 0 && bArr[i2] != bArr[i3]) {
                i2 = iArr[i2 - 1];
            }
            if (bArr[i2] == bArr[i3]) {
                i2++;
            }
            iArr[i3] = i2;
        }
        return iArr;
    }

    public static byte[] copyBytesOfRange(byte[] bArr, int i2, int i3) {
        if (i2 > i3 || i2 < 0 || i3 < 0 || i3 > bArr.length) {
            return null;
        }
        byte[] bArr2 = new byte[i3 - i2];
        for (int i4 = i2; i4 < i3; i4++) {
            bArr2[i4 - i2] = bArr[i4];
        }
        return bArr2;
    }

    public static String generateSerialNumber() {
        return UUID.randomUUID().toString();
    }

    public static NetworkInfo getNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static int indexOf(byte[] bArr, byte[] bArr2, int i2) {
        try {
            int[] iArrComputeFailure = computeFailure(bArr2);
            int i3 = 0;
            if (bArr.length == 0 || i2 >= bArr.length) {
                return -1;
            }
            while (i2 < bArr.length) {
                while (i3 > 0 && bArr2[i3] != bArr[i2]) {
                    i3 = iArrComputeFailure[i3 - 1];
                }
                if (bArr2[i3] == bArr[i2]) {
                    i3++;
                }
                if (i3 == bArr2.length) {
                    return (i2 - bArr2.length) + 1;
                }
                i2++;
            }
        } catch (Exception unused) {
        }
        return -1;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1;
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb.append(hexString.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < str.length() / 2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            bArr[i2] = (byte) ((Integer.parseInt(str.substring(i3, i4), 16) * 16) + Integer.parseInt(str.substring(i4, i3 + 2), 16));
        }
        return bArr;
    }

    public static byte[] shortArrayToByteArray(short[] sArr) {
        int length = sArr.length;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(sArr.length * 2);
        byteBufferAllocate.clear();
        byteBufferAllocate.order(ByteOrder.nativeOrder());
        for (int i2 = 0; i2 < length; i2++) {
            byteBufferAllocate.putShort(i2 * 2, sArr[i2]);
        }
        return byteBufferAllocate.array();
    }

    public static String urlEncoded(HashMap<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (str2 == null) {
                str2 = "";
            }
            if (i2 == 0) {
                sb.append(String.format("%s=%s", str, URLEncoder.encode(str2, a.bN)));
            } else {
                sb.append(String.format("&%s=%s", str, URLEncoder.encode(str2, a.bN)));
            }
            i2++;
        }
        return sb.toString();
    }
}
