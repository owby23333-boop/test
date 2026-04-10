package com.bytedance.hume.readapk.a;

import com.xiaomi.verificationsdk.internal.Constants;
import java.io.DataInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f2080a = {108, 116, 108, 111, 118, 101, 122, 104};

    public static String a(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        String str = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, Constants.RANDOM_LONG);
                } catch (FileNotFoundException e) {
                    e = e;
                    randomAccessFile = null;
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (IOException e3) {
                    e = e3;
                    randomAccessFile = null;
                } catch (Exception e4) {
                    e = e4;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    long length = randomAccessFile.length();
                    byte[] bArr = f2080a;
                    byte[] bArr2 = new byte[bArr.length];
                    long length2 = length - ((long) bArr.length);
                    randomAccessFile.seek(length2);
                    randomAccessFile.readFully(bArr2);
                    if (!a(bArr2)) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        return "";
                    }
                    long j = length2 - 2;
                    randomAccessFile.seek(j);
                    int iA = a(randomAccessFile);
                    if (iA <= 0) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                        return "";
                    }
                    randomAccessFile.seek(j - ((long) iA));
                    byte[] bArr3 = new byte[iA];
                    randomAccessFile.readFully(bArr3);
                    String str2 = new String(bArr3, "UTF-8");
                    try {
                        randomAccessFile.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    str = str2;
                } catch (FileNotFoundException e9) {
                    e = e9;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (UnsupportedEncodingException e10) {
                    e = e10;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (IOException e11) {
                    e = e11;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (Exception e12) {
                    e = e12;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                }
            } catch (IOException e13) {
                e13.printStackTrace();
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
        }
    }

    private static short a(DataInput dataInput) throws IOException {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }

    private static boolean a(byte[] bArr) {
        if (bArr.length != f2080a.length) {
            return false;
        }
        int i = 0;
        while (true) {
            byte[] bArr2 = f2080a;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }
}
