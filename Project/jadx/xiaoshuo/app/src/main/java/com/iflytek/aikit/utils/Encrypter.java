package com.iflytek.aikit.utils;

import com.iflytek.aikit.utils.log.LogUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class Encrypter {
    public static final int BUFFER_SIZE = 1024;
    public static final byte GZIP_KEY = 5;
    private static final String RSA_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCt8H0BF3SquJmk6xIo2bTldgvtazLIeSbR4cle\np7zeUAtI/mC7UgFl8xXFCTemVambyQFnM5GsZOI1BpAMJO7N/YHRX7hvCZG6D0rEXQEdKXhKFIBQ\nmOYRYZP042vWRcKZ6iQLdLYmyg6tIzjYVfH0f6YX8OLIU7fy0TA/c88rzwIDAQAB";
    private static final int SDK_VERSION_KITKAT = 19;

    public static synchronized String MD5(String str) {
        StringBuffer stringBuffer;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] bArrDigest = messageDigest.digest(bArr);
            stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
        } catch (Exception e) {
            LogUtil.e(e);
            return "";
        }
        return stringBuffer.toString();
    }

    public static int byteArrayToInt(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += (bArr[i2] & 255) << ((3 - i2) * 8);
        }
        return i;
    }

    public static synchronized String cut16MD5(String str) {
        LogUtil.d("cut16MD5 start:" + str);
        String strMD5 = MD5(str);
        LogUtil.d("cut16MD5 start:" + strMD5);
        StringBuffer stringBuffer = new StringBuffer();
        if (strMD5 != null && strMD5.length() != 0) {
            LogUtil.d("cut16MD5 md5 size is:" + strMD5.length());
            for (int i = 0; i < strMD5.length(); i++) {
                if (i % 2 == 0) {
                    LogUtil.d("cut16MD5 result i:" + strMD5.charAt(i));
                    stringBuffer.append(strMD5.charAt(i));
                }
                LogUtil.d("cut16MD5 result i = :" + i);
            }
            LogUtil.d("cut16MD5 result:" + ((Object) stringBuffer));
            return stringBuffer.toString();
        }
        return null;
    }

    public static byte[] encrypt(byte[] bArr) {
        try {
            byte[] encoded = AESUtil.generateKey().getEncoded();
            byte[] bArrEncrypt = bArr != null ? AESUtil.encrypt(zip(bArr), encoded) : null;
            byte[] bArrEncryptByPublicKey = RSAUtil.encryptByPublicKey(encoded, RSAUtil.loadPublicKey(RSA_PUBLIC_KEY));
            if (bArrEncryptByPublicKey != null && bArrEncrypt != null) {
                int length = bArrEncryptByPublicKey.length;
                int length2 = bArrEncrypt.length;
                byte[] bArr2 = new byte[length + length2 + 10];
                bArr2[0] = 1;
                System.arraycopy(intToByteArray(length), 0, bArr2, 1, 4);
                System.arraycopy(bArrEncryptByPublicKey, 0, bArr2, 5, length);
                int i = 5 + length;
                bArr2[i] = 3;
                int i2 = i + 1;
                System.arraycopy(intToByteArray(length2), 0, bArr2, i2, 4);
                System.arraycopy(bArrEncrypt, 0, bArr2, i2 + 4, length2);
                return bArr2;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getFileMd5(java.io.File r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8.exists()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.nio.channels.FileChannel r2 = r0.getChannel()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4e
            java.nio.channels.FileChannel$MapMode r3 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4e
            r4 = 0
            long r6 = r8.length()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4e
            java.nio.MappedByteBuffer r8 = r2.map(r3, r4, r6)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4e
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4e
            r2.update(r8)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4e
            java.math.BigInteger r8 = new java.math.BigInteger     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4e
            byte[] r2 = r2.digest()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4e
            r3 = 1
            r8.<init>(r3, r2)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4e
            r2 = 16
            java.lang.String r1 = r8.toString(r2)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L4e
            r0.close()     // Catch: java.io.IOException -> L3a
            goto L4d
        L3a:
            r8 = move-exception
            r8.printStackTrace()
            goto L4d
        L3f:
            r8 = move-exception
            goto L45
        L41:
            r8 = move-exception
            goto L50
        L43:
            r8 = move-exception
            r0 = r1
        L45:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L4e
            if (r0 == 0) goto L4d
            r0.close()     // Catch: java.io.IOException -> L3a
        L4d:
            return r1
        L4e:
            r8 = move-exception
            r1 = r0
        L50:
            if (r1 == 0) goto L5a
            r1.close()     // Catch: java.io.IOException -> L56
            goto L5a
        L56:
            r0 = move-exception
            r0.printStackTrace()
        L5a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.aikit.utils.Encrypter.getFileMd5(java.io.File):java.lang.String");
    }

    public static byte[] intToByteArray(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] lightcode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 5);
        }
        return bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] zip(byte[] r3) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L28
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L28
            r2.write(r3)     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L36
            r2.finish()     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L36
            byte[] r0 = r1.toByteArray()     // Catch: java.io.IOException -> L24 java.lang.Throwable -> L36
            r2.close()     // Catch: java.io.IOException -> L1f
            r1.close()     // Catch: java.io.IOException -> L1f
            goto L35
        L1f:
            r3 = move-exception
            r3.printStackTrace()
            goto L35
        L24:
            r3 = move-exception
            goto L2a
        L26:
            r3 = move-exception
            goto L38
        L28:
            r3 = move-exception
            r2 = r0
        L2a:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L36
            if (r2 == 0) goto L32
            r2.close()     // Catch: java.io.IOException -> L1f
        L32:
            r1.close()     // Catch: java.io.IOException -> L1f
        L35:
            return r0
        L36:
            r3 = move-exception
            r0 = r2
        L38:
            if (r0 == 0) goto L3d
            r0.close()     // Catch: java.io.IOException -> L41
        L3d:
            r1.close()     // Catch: java.io.IOException -> L41
            goto L45
        L41:
            r0 = move-exception
            r0.printStackTrace()
        L45:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.aikit.utils.Encrypter.zip(byte[]):byte[]");
    }

    public static byte[] zip5xDecode(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        IOException iOException;
        byte[] bArr2;
        GZIPInputStream gZIPInputStream2 = null;
        byte[] byteArray = null;
        gZIPInputStream2 = null;
        if (bArr == null) {
            return null;
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 5);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bArr3 = new byte[1024];
                    while (true) {
                        int i2 = gZIPInputStream.read(bArr3, 0, 1024);
                        if (i2 == -1) {
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.flush();
                            try {
                                gZIPInputStream.close();
                                byteArrayInputStream.close();
                                byteArrayOutputStream.close();
                                return byteArray;
                            } catch (IOException e) {
                                LogUtil.e(e);
                                return byteArray;
                            }
                        }
                        byteArrayOutputStream.write(bArr3, 0, i2);
                    }
                } catch (IOException e2) {
                    bArr2 = byteArray;
                    gZIPInputStream2 = gZIPInputStream;
                    iOException = e2;
                    LogUtil.e(iOException);
                    if (gZIPInputStream2 != null) {
                        try {
                            gZIPInputStream2.close();
                        } catch (IOException e3) {
                            LogUtil.e(e3);
                            return bArr2;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e4) {
                            LogUtil.e(e4);
                            throw th;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (Throwable th3) {
                gZIPInputStream = gZIPInputStream2;
                th = th3;
            }
        } catch (IOException e5) {
            iOException = e5;
            bArr2 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public static byte[] zip5xEncode(byte[] bArr) throws Throwable {
        byte[] bArr2;
        ?? r0 = 0;
        byte[] byteArray = null;
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.finish();
                    byteArray = byteArrayOutputStream.toByteArray();
                    for (int i = 0; i < byteArray.length; i++) {
                        byteArray[i] = (byte) (byteArray[i] ^ 5);
                    }
                    try {
                        gZIPOutputStream2.close();
                        byteArrayOutputStream.close();
                        r0 = byteArray;
                    } catch (IOException e) {
                        LogUtil.e(e);
                        r0 = byteArray;
                    }
                } catch (IOException e2) {
                    e = e2;
                    bArr2 = byteArray;
                    gZIPOutputStream = gZIPOutputStream2;
                    LogUtil.e(e);
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e3) {
                            LogUtil.e(e3);
                            r0 = bArr2;
                            return r0;
                        }
                    }
                    byteArrayOutputStream.close();
                    r0 = bArr2;
                } catch (Throwable th) {
                    th = th;
                    r0 = gZIPOutputStream2;
                    if (r0 != 0) {
                        try {
                            r0.close();
                        } catch (IOException e4) {
                            LogUtil.e(e4);
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                bArr2 = null;
            }
            return r0;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
