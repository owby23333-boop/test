package cn.bmob.v3.helper;

import android.content.Context;
import cn.bmob.v3.BmobConstants;
import cn.bmob.v3.util.Utils;
import com.tencent.smtt.sdk.TbsListener;
import com.umeng.analytics.pro.cb;
import java.io.ByteArrayOutputStream;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class RequestHelper {
    private static char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, cb.f19602k, cb.f19603l, cb.f19604m, cb.f19605n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static byte[] decode(String str) {
        int i2;
        byte b;
        int i3;
        byte b2;
        int i4;
        byte b3;
        int i5;
        byte b4;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        int i6 = 0;
        while (i6 < length) {
            while (true) {
                i2 = i6 + 1;
                b = base64DecodeChars[bytes[i6]];
                if (i2 >= length || b != -1) {
                    break;
                }
                i6 = i2;
            }
            if (b == -1) {
                break;
            }
            while (true) {
                i3 = i2 + 1;
                b2 = base64DecodeChars[bytes[i2]];
                if (i3 >= length || b2 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b2 == -1) {
                break;
            }
            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
            while (true) {
                i4 = i3 + 1;
                byte b5 = bytes[i3];
                if (b5 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b3 = base64DecodeChars[b5];
                if (i4 >= length || b3 != -1) {
                    break;
                }
                i3 = i4;
            }
            if (b3 == -1) {
                break;
            }
            byteArrayOutputStream.write(((b2 & cb.f19604m) << 4) | ((b3 & 60) >>> 2));
            while (true) {
                i5 = i4 + 1;
                byte b6 = bytes[i4];
                if (b6 == 61) {
                    return byteArrayOutputStream.toByteArray();
                }
                b4 = base64DecodeChars[b6];
                if (i5 >= length || b4 != -1) {
                    break;
                }
                i4 = i5;
            }
            if (b4 == -1) {
                break;
            }
            byteArrayOutputStream.write(b4 | ((b3 & 3) << 6));
            i6 = i5;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String encode(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            if (i3 == length) {
                sb.append(base64EncodeChars[i4 >>> 2]);
                sb.append(base64EncodeChars[(i4 & 3) << 4]);
                sb.append("==");
                break;
            }
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            if (i5 == length) {
                sb.append(base64EncodeChars[i4 >>> 2]);
                sb.append(base64EncodeChars[((i4 & 3) << 4) | ((i6 & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >>> 4)]);
                sb.append(base64EncodeChars[(i6 & 15) << 2]);
                sb.append("=");
                break;
            }
            int i7 = i5 + 1;
            int i8 = bArr[i5] & 255;
            sb.append(base64EncodeChars[i4 >>> 2]);
            sb.append(base64EncodeChars[((i4 & 3) << 4) | ((i6 & TbsListener.ErrorCode.TPATCH_VERSION_FAILED) >>> 4)]);
            sb.append(base64EncodeChars[((i6 & 15) << 2) | ((i8 & 192) >>> 6)]);
            sb.append(base64EncodeChars[i8 & 63]);
            i2 = i7;
        }
        return sb.toString();
    }

    public static final String getKey1(String str) {
        byte[] bArrString2Byte = Utils.string2Byte(str);
        byte[] bArr = new byte[16];
        for (int i2 = 0; i2 < 16; i2++) {
            bArr[i2] = bArrString2Byte[(bArrString2Byte.length - 16) + i2];
        }
        return Utils.byte2String(bArr);
    }

    public static final String getKey2(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[16];
        for (int i2 = 0; i2 < 16; i2++) {
            bArr[i2] = bytes[(bytes.length - 16) + i2];
        }
        return Utils.byte2String(bArr);
    }

    public static final String getKey3(String str) {
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[16];
        int i2 = 0;
        while (i2 < 16) {
            int i3 = i2 + 1;
            bArr[i2] = bytes[i3];
            i2 = i3;
        }
        return Utils.byte2String(bArr);
    }

    private static final String getOldUserAgent(Context context) {
        try {
            String packageName = context.getPackageName();
            return packageName + "/" + context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "volley/0";
        }
    }

    public static final String getUserAgent(Context context) {
        return getOldUserAgent(context) + String.valueOf(System.currentTimeMillis()) + "Android" + BmobConstants.VERSION_NAME;
    }
}
