package com.mibi.sdk.common;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.p.d;
import com.market.sdk.reflect.Field;
import com.mibi.sdk.common.utils.MibiLog;
import com.xiaomi.ad.y;
import com.yuewen.gm;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes13.dex */
public class Coder {
    public static final String AES_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", y.j, gm.a.f11596b, "d", "e", gm.a.f11595a};
    private static final String[] HEX_DIGITS_UPPERCASE = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", ExifInterface.LONGITUDE_EAST, Field.FLOAT_SIGNATURE_PRIMITIVE};
    private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final String TAG = "Coder";

    public static String byteArrayToString(byte[] bArr) {
        return byteArrayToString(bArr, false);
    }

    public static String byteToHexString(byte b2) {
        return byteToHexString(b2, false);
    }

    public static final String decodeAES(String str, String str2) {
        byte[] bArrDecodeBase64Bytes;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (bArrDecodeBase64Bytes = decodeBase64Bytes(str2)) != null && bArrDecodeBase64Bytes.length == 16) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDecodeBase64Bytes, "AES");
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
                byte[] bArrDecodeBase64Bytes2 = decodeBase64Bytes(str);
                if (bArrDecodeBase64Bytes2 == null) {
                    return null;
                }
                return new String(cipher.doFinal(bArrDecodeBase64Bytes2));
            } catch (IllegalArgumentException e) {
                MibiLog.e(TAG, "illegal argument" + e.getMessage());
                if (CommonConstants.isGlobalHost()) {
                    MibiLog.d(TAG, "is global host, maybe the account's region is not cn");
                }
                return null;
            } catch (InvalidAlgorithmParameterException e2) {
                MibiLog.e(TAG, "algorithm param invalid, " + e2.getMessage());
                return null;
            } catch (InvalidKeyException e3) {
                MibiLog.e(TAG, "key invalid, " + e3.getMessage());
                return null;
            } catch (NoSuchAlgorithmException e4) {
                MibiLog.e(TAG, "no such algorithm, " + e4.getMessage());
            } catch (BadPaddingException e5) {
                MibiLog.e(TAG, "bad padding, " + e5.getMessage());
                return null;
            } catch (IllegalBlockSizeException e6) {
                MibiLog.e(TAG, "illegal block size, " + e6.getMessage());
                return null;
            } catch (NoSuchPaddingException e7) {
                MibiLog.e(TAG, "no such padding, " + e7.getMessage());
                return null;
            } catch (Exception e8) {
                MibiLog.e(TAG, e8.getMessage());
                return null;
            }
        }
        return null;
    }

    public static final String decodeBase64(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static final byte[] decodeBase64Bytes(String str) {
        return Base64.decode(str, 0);
    }

    public static final InputStream decodeBase64Stream(InputStream inputStream) {
        return new Base64InputStream(inputStream, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v12, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.FileInputStream] */
    public static boolean decodeFileAES(String str, String str2, String str3) throws Throwable {
        byte[] bArrDecodeBase64Bytes;
        ?? r6;
        ?? r2;
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (bArrDecodeBase64Bytes = decodeBase64Bytes(str3)) != null) {
            ?? fileOutputStream = 16;
            if (bArrDecodeBase64Bytes.length == 16) {
                CipherOutputStream cipherOutputStream = null;
                try {
                    try {
                        File file = new File(str);
                        File file2 = new File((String) str2);
                        if (file.exists() && file.isFile()) {
                            if (!file2.getParentFile().exists()) {
                                file2.getParentFile().mkdirs();
                            }
                            file2.createNewFile();
                            str2 = new FileInputStream(file);
                            try {
                                fileOutputStream = new FileOutputStream(file2);
                                try {
                                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDecodeBase64Bytes, "AES");
                                    IvParameterSpec ivParameterSpec = new IvParameterSpec("0102030405060708".getBytes());
                                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                                    cipher.init(2, secretKeySpec, ivParameterSpec);
                                    CipherOutputStream cipherOutputStream2 = new CipherOutputStream(fileOutputStream, cipher);
                                    try {
                                        byte[] bArr = new byte[1024];
                                        while (true) {
                                            int i = str2.read(bArr);
                                            if (i == -1) {
                                                break;
                                            }
                                            cipherOutputStream2.write(bArr, 0, i);
                                            cipherOutputStream2.flush();
                                        }
                                        cipherOutputStream = cipherOutputStream2;
                                        r2 = fileOutputStream;
                                        r6 = str2;
                                    } catch (Exception e) {
                                        cipherOutputStream = cipherOutputStream2;
                                        e = e;
                                        e.printStackTrace();
                                        if (cipherOutputStream != null) {
                                            try {
                                                cipherOutputStream.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                                return false;
                                            }
                                        }
                                        if (fileOutputStream != 0) {
                                            fileOutputStream.close();
                                        }
                                        if (str2 != 0) {
                                            str2.close();
                                        }
                                        return false;
                                    } catch (Throwable th) {
                                        cipherOutputStream = cipherOutputStream2;
                                        th = th;
                                        if (cipherOutputStream != null) {
                                            try {
                                                cipherOutputStream.close();
                                            } catch (Exception e3) {
                                                e3.printStackTrace();
                                                return false;
                                            }
                                        }
                                        if (fileOutputStream != 0) {
                                            fileOutputStream.close();
                                        }
                                        if (str2 != 0) {
                                            str2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                fileOutputStream = 0;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = 0;
                            }
                        } else {
                            r6 = 0;
                            r2 = 0;
                        }
                        if (cipherOutputStream != null) {
                            try {
                                cipherOutputStream.close();
                            } catch (Exception e6) {
                                e6.printStackTrace();
                                return false;
                            }
                        }
                        if (r2 != 0) {
                            r2.close();
                        }
                        if (r6 == 0) {
                            return true;
                        }
                        r6.close();
                        return true;
                    } catch (Exception e7) {
                        e = e7;
                        str2 = 0;
                        fileOutputStream = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = 0;
                        fileOutputStream = 0;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        return false;
    }

    public static String encodeAES(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            MibiLog.d(TAG, "data or key/iv invalid");
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, getSecretKeySpec(str2), getIvParameterSpec(str3));
            return encodeBase64(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            MibiLog.d(TAG, "encodeAes failed : " + e.getMessage(), e);
            return null;
        }
    }

    public static final String encodeBase64(String str) {
        return Base64.encodeToString(str.getBytes(), 2);
    }

    public static final byte[] encodeBase64Bytes(String str) {
        return Base64.encode(str.getBytes(), 2);
    }

    public static final OutputStream encodeBase64Stream(OutputStream outputStream) {
        return new Base64OutputStream(outputStream, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [javax.crypto.CipherInputStream] */
    /* JADX WARN: Type inference failed for: r6v11, types: [javax.crypto.CipherInputStream] */
    /* JADX WARN: Type inference failed for: r6v12, types: [javax.crypto.CipherInputStream] */
    /* JADX WARN: Type inference failed for: r6v13, types: [javax.crypto.CipherInputStream] */
    /* JADX WARN: Type inference failed for: r6v14, types: [javax.crypto.CipherInputStream] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v36, types: [javax.crypto.CipherInputStream] */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v41 */
    /* JADX WARN: Type inference failed for: r6v42 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [javax.crypto.CipherInputStream] */
    /* JADX WARN: Type inference failed for: r6v9, types: [javax.crypto.CipherInputStream] */
    public static boolean encodeFileAES(String str, String str2, String str3) throws Throwable {
        byte[] bArrDecodeBase64Bytes;
        ?? r5;
        ?? r6;
        ?? r52;
        ?? r62;
        ?? r53;
        ?? r63;
        ?? r54;
        ?? r64;
        ?? r55;
        ?? r65;
        ?? r56;
        ?? r66;
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (bArrDecodeBase64Bytes = decodeBase64Bytes(str3)) == null || bArrDecodeBase64Bytes.length != 16) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDecodeBase64Bytes, "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
                byte[] bArr = new byte[1024];
                FileInputStream fileInputStream2 = new FileInputStream((String) str);
                try {
                    str = new FileOutputStream((String) str2);
                    try {
                        str2 = new CipherInputStream(fileInputStream2, cipher);
                        while (true) {
                            try {
                                int i = str2.read(bArr);
                                if (i == -1) {
                                    str.flush();
                                    try {
                                        fileInputStream2.close();
                                        str.close();
                                        str2.close();
                                        return true;
                                    } catch (Exception unused) {
                                        return false;
                                    }
                                }
                                str.write(bArr, 0, i);
                                str.flush();
                            } catch (FileNotFoundException e) {
                                e = e;
                                fileInputStream = fileInputStream2;
                                r56 = str;
                                r66 = str2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused2) {
                                        return false;
                                    }
                                }
                                if (r56 != 0) {
                                    r56.close();
                                }
                                if (r66 != 0) {
                                    r66.close();
                                }
                                return false;
                            } catch (IOException e2) {
                                e = e2;
                                fileInputStream = fileInputStream2;
                                r55 = str;
                                r65 = str2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused3) {
                                        return false;
                                    }
                                }
                                if (r55 != 0) {
                                    r55.close();
                                }
                                if (r65 != 0) {
                                    r65.close();
                                }
                                return false;
                            } catch (InvalidAlgorithmParameterException e3) {
                                e = e3;
                                fileInputStream = fileInputStream2;
                                r54 = str;
                                r64 = str2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused4) {
                                        return false;
                                    }
                                }
                                if (r54 != 0) {
                                    r54.close();
                                }
                                if (r64 != 0) {
                                    r64.close();
                                }
                                return false;
                            } catch (InvalidKeyException e4) {
                                e = e4;
                                fileInputStream = fileInputStream2;
                                r53 = str;
                                r63 = str2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused5) {
                                        return false;
                                    }
                                }
                                if (r53 != 0) {
                                    r53.close();
                                }
                                if (r63 != 0) {
                                    r63.close();
                                }
                                return false;
                            } catch (NoSuchAlgorithmException e5) {
                                e = e5;
                                fileInputStream = fileInputStream2;
                                r52 = str;
                                r62 = str2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused6) {
                                        return false;
                                    }
                                }
                                if (r52 != 0) {
                                    r52.close();
                                }
                                if (r62 != 0) {
                                    r62.close();
                                }
                                return false;
                            } catch (NoSuchPaddingException e6) {
                                e = e6;
                                fileInputStream = fileInputStream2;
                                r5 = str;
                                r6 = str2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused7) {
                                        return false;
                                    }
                                }
                                if (r5 != 0) {
                                    r5.close();
                                }
                                if (r6 != 0) {
                                    r6.close();
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception unused8) {
                                        return false;
                                    }
                                }
                                if (str != 0) {
                                    str.close();
                                }
                                if (str2 != 0) {
                                    str2.close();
                                }
                                throw th;
                            }
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        str2 = 0;
                    } catch (IOException e8) {
                        e = e8;
                        str2 = 0;
                    } catch (InvalidAlgorithmParameterException e9) {
                        e = e9;
                        str2 = 0;
                    } catch (InvalidKeyException e10) {
                        e = e10;
                        str2 = 0;
                    } catch (NoSuchAlgorithmException e11) {
                        e = e11;
                        str2 = 0;
                    } catch (NoSuchPaddingException e12) {
                        e = e12;
                        str2 = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        str2 = 0;
                    }
                } catch (FileNotFoundException e13) {
                    e = e13;
                    str = 0;
                    str2 = 0;
                } catch (IOException e14) {
                    e = e14;
                    str = 0;
                    str2 = 0;
                } catch (InvalidAlgorithmParameterException e15) {
                    e = e15;
                    str = 0;
                    str2 = 0;
                } catch (InvalidKeyException e16) {
                    e = e16;
                    str = 0;
                    str2 = 0;
                } catch (NoSuchAlgorithmException e17) {
                    e = e17;
                    str = 0;
                    str2 = 0;
                } catch (NoSuchPaddingException e18) {
                    e = e18;
                    str = 0;
                    str2 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    str = 0;
                    str2 = 0;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                r56 = 0;
                r66 = 0;
            } catch (IOException e20) {
                e = e20;
                r55 = 0;
                r65 = 0;
            } catch (InvalidAlgorithmParameterException e21) {
                e = e21;
                r54 = 0;
                r64 = 0;
            } catch (InvalidKeyException e22) {
                e = e22;
                r53 = 0;
                r63 = 0;
            } catch (NoSuchAlgorithmException e23) {
                e = e23;
                r52 = 0;
                r62 = 0;
            } catch (NoSuchPaddingException e24) {
                e = e24;
                r5 = 0;
                r6 = 0;
            } catch (Throwable th4) {
                th = th4;
                str = 0;
                str2 = 0;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static final String encodeMD5(String str) {
        byte[] bArrEncodeMD5Bytes = encodeMD5Bytes(str);
        if (bArrEncodeMD5Bytes != null) {
            return byteArrayToString(bArrEncodeMD5Bytes);
        }
        return null;
    }

    public static final byte[] encodeMD5Bytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String encodeSHA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(str.getBytes());
            return byteArrayToString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final byte[] encodeSHABytes(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptRSA(String str, String str2) {
        PublicKey rSAPubKey;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (rSAPubKey = getRSAPubKey(str)) == null) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance(RSA_ALGORITHM);
            cipher.init(1, rSAPubKey);
            return encodeBase64(cipher.doFinal(str2.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            MibiLog.d(TAG, "encrypt rsa failed : " + e.getMessage(), e);
            return null;
        }
    }

    public static String generateAESRandom() {
        try {
            SecureRandom secureRandom = new SecureRandom();
            byte[] bArr = new byte[Cipher.getInstance("AES/CBC/PKCS5Padding").getBlockSize()];
            secureRandom.nextBytes(bArr);
            return encodeBase64(bArr);
        } catch (Exception e) {
            MibiLog.d(TAG, "generate random aes key/iv failed : " + e.getMessage(), e);
            return null;
        }
    }

    private static IvParameterSpec getIvParameterSpec(String str) {
        byte[] bArrDecodeBase64Bytes = decodeBase64Bytes(str);
        if (bArrDecodeBase64Bytes == null || bArrDecodeBase64Bytes.length != 16) {
            return null;
        }
        return new IvParameterSpec(bArrDecodeBase64Bytes);
    }

    private static PublicKey getRSAPubKey(String str) {
        try {
            return KeyFactory.getInstance(d.f1901a).generatePublic(new X509EncodedKeySpec(decodeBase64Bytes(str)));
        } catch (Exception e) {
            MibiLog.d(TAG, "get rsa pubKey failed : " + e.getMessage(), e);
            return null;
        }
    }

    private static SecretKeySpec getSecretKeySpec(String str) {
        byte[] bArrDecodeBase64Bytes = decodeBase64Bytes(str);
        if (bArrDecodeBase64Bytes == null || bArrDecodeBase64Bytes.length != 16) {
            return null;
        }
        return new SecretKeySpec(bArrDecodeBase64Bytes, "AES");
    }

    public static String byteArrayToString(byte[] bArr, boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(byteToHexString(b2, z));
        }
        return stringBuffer.toString();
    }

    public static String byteToHexString(byte b2, boolean z) {
        int i = b2;
        if (b2 < 0) {
            i = b2 + 256;
        }
        int i2 = i / 16;
        int i3 = i % 16;
        if (z) {
            StringBuilder sb = new StringBuilder();
            String[] strArr = HEX_DIGITS_UPPERCASE;
            sb.append(strArr[i2]);
            sb.append(strArr[i3]);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        String[] strArr2 = HEX_DIGITS;
        sb2.append(strArr2[i2]);
        sb2.append(strArr2[i3]);
        return sb2.toString();
    }

    public static final String encodeBase64(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static final String encodeMD5(File file) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[1024];
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i > 0) {
                            messageDigest.update(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                            }
                        }
                    }
                    return byteArrayToString(messageDigest.digest());
                } catch (IOException e2) {
                    e2.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return null;
                } catch (NoSuchAlgorithmException e4) {
                    e4.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                    return null;
                }
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
        } catch (FileNotFoundException e7) {
            e7.printStackTrace();
            return null;
        }
    }

    public static final String encodeAES(String str, String str2) {
        byte[] bArrDecodeBase64Bytes;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (bArrDecodeBase64Bytes = decodeBase64Bytes(str2)) != null && bArrDecodeBase64Bytes.length == 16) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDecodeBase64Bytes, "AES");
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, secretKeySpec, new IvParameterSpec("0102030405060708".getBytes()));
                return encodeBase64(cipher.doFinal(str.getBytes()));
            } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            }
        }
        return null;
    }
}
