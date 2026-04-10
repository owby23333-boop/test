package me.jessyan.art.http.imageloader.glide;

import com.tencent.smtt.sdk.TbsListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes3.dex */
public class GlideFileUtil {
    public static InputStream byte2Input(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    public static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, bArrCopyOf, bArr.length, bArr2.length);
        return bArrCopyOf;
    }

    public static byte[] getBytesByFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1000);
            byte[] bArr = new byte[1000];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    fileInputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getFileMD5s(File file, int i2) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int i3 = fileInputStream.read(bArr, 0, 1024);
                if (i3 == -1) {
                    fileInputStream.close();
                    return new BigInteger(1, messageDigest.digest()).toString(i2);
                }
                messageDigest.update(bArr, 0, i3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static InputStream getRemoveDataByteArray(byte[] bArr) {
        return getRemoveDataByteArray(0, 0, bArr);
    }

    public static byte[] input2byte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[100];
        while (true) {
            int i2 = inputStream.read(bArr, 0, 100);
            if (i2 <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    private static byte[] list2byte(List<Byte> list) {
        if (list == null) {
            return null;
        }
        list.size();
        byte[] bArr = new byte[list.size()];
        int i2 = 0;
        Iterator<Byte> it = list.iterator();
        while (it.hasNext()) {
            bArr[i2] = it.next().byteValue();
            i2++;
        }
        return bArr;
    }

    public static byte[] subBytes(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return bArr2;
    }

    public static InputStream getRemoveDataByteArray(int i2, int i3, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            if (i2 != 0) {
                try {
                    ArrayList arrayList = new ArrayList();
                    CRC32 crc32 = new CRC32();
                    crc32.update(String.valueOf(i2).getBytes());
                    int value = (int) (crc32.getValue() % 256);
                    int length = bArr.length;
                    boolean z2 = false;
                    int i4 = 0;
                    for (int i5 = 0; i5 < length; i5++) {
                        byte b = bArr[i5];
                        int i6 = b < 0 ? b & 255 : b;
                        if (z2) {
                            i4++;
                            z2 = false;
                        } else {
                            if (i6 == value && i4 < i3) {
                                z2 = true;
                            }
                            arrayList.add(Byte.valueOf(b));
                        }
                    }
                    bArr = list2byte(arrayList);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (bArr == null) {
                return null;
            }
            byte[] bArrSubBytes = subBytes(bArr, 0, TbsListener.ErrorCode.INFO_CODE_BASE);
            byte[] bArrSubBytes2 = subBytes(bArr, bArrSubBytes.length, bArr.length - TbsListener.ErrorCode.INFO_CODE_BASE);
            byte[] bArr2 = new byte[bArrSubBytes.length / 2];
            for (int i7 = 0; i7 < bArrSubBytes.length; i7++) {
                if (i7 % 2 == 0) {
                    bArr2[i7 / 2] = bArrSubBytes[i7];
                }
            }
            return new ByteArrayInputStream(concat(bArr2, bArrSubBytes2));
        }
        return null;
    }

    public static byte[] getRemoveDataByteArray(int i2, int i3, String str) {
        String str2 = "ID:" + i2 + " info:" + i3;
        byte[] bytesByFile = getBytesByFile(str);
        if (bytesByFile != null && bytesByFile.length > 0) {
            if (i2 != 0) {
                try {
                    ArrayList arrayList = new ArrayList();
                    CRC32 crc32 = new CRC32();
                    crc32.update(String.valueOf(i2).getBytes());
                    int value = (int) (crc32.getValue() % 256);
                    int length = bytesByFile.length;
                    boolean z2 = false;
                    int i4 = 0;
                    for (int i5 = 0; i5 < length; i5++) {
                        byte b = bytesByFile[i5];
                        int i6 = b < 0 ? b & 255 : b;
                        if (z2) {
                            i4++;
                            z2 = false;
                        } else {
                            if (i6 == value && i4 < i3) {
                                z2 = true;
                            }
                            arrayList.add(Byte.valueOf(b));
                        }
                    }
                    bytesByFile = list2byte(arrayList);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (bytesByFile == null) {
                return null;
            }
            byte[] bArrSubBytes = subBytes(bytesByFile, 0, TbsListener.ErrorCode.INFO_CODE_BASE);
            byte[] bArrSubBytes2 = subBytes(bytesByFile, bArrSubBytes.length, bytesByFile.length - TbsListener.ErrorCode.INFO_CODE_BASE);
            byte[] bArr = new byte[bArrSubBytes.length / 2];
            for (int i7 = 0; i7 < bArrSubBytes.length; i7++) {
                if (i7 % 2 == 0) {
                    bArr[i7 / 2] = bArrSubBytes[i7];
                }
            }
            return concat(bArr, bArrSubBytes2);
        }
        return null;
    }
}
