package com.baidu.tts.tools;

import com.umeng.analytics.pro.cb;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class MD5 {
    private static volatile MD5 mInstance;
    private char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private MD5() {
    }

    private void appendHexPair(byte b, StringBuffer stringBuffer) {
        char[] cArr = this.hexChar;
        char c2 = cArr[(b & 240) >> 4];
        char c3 = cArr[b & cb.f19604m];
        stringBuffer.append(c2);
        stringBuffer.append(c3);
    }

    private String bufferToHex(byte[] bArr) {
        return bufferToHex(bArr, 0, bArr.length);
    }

    public static MD5 getInstance() {
        if (mInstance == null) {
            synchronized (MD5.class) {
                if (mInstance == null) {
                    mInstance = new MD5();
                }
            }
        }
        return mInstance;
    }

    public String getBigFileMd5(File file) throws Throwable {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        if (file != null) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
            } catch (Exception unused) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int i2 = fileInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i2);
                }
                String strBufferToHex = bufferToHex(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return strBufferToHex;
            } catch (Exception unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return null;
    }

    public String getFileMd5(String str) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileChannel channel;
        MessageDigest messageDigest;
        File file;
        FileChannel fileChannel = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            file = new File(str);
            fileInputStream2 = new FileInputStream(file);
            try {
                channel = fileInputStream2.getChannel();
            } catch (Exception unused) {
                channel = null;
            } catch (Throwable th) {
                fileInputStream = fileInputStream2;
                th = th;
            }
        } catch (Exception unused2) {
            fileInputStream2 = null;
            channel = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            messageDigest.update(channel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
            String strBufferToHex = bufferToHex(messageDigest.digest());
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            fileInputStream2.close();
            return strBufferToHex;
        } catch (Exception unused3) {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return null;
        } catch (Throwable th3) {
            fileInputStream = fileInputStream2;
            th = th3;
            fileChannel = channel;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    throw th;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public String getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            int length = bArrDigest.length;
            char[] cArr = new char[length * 2];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i2 + 1;
                cArr[i2] = this.hexChar[(bArrDigest[i3] >>> 4) & 15];
                i2 = i4 + 1;
                cArr[i4] = this.hexChar[bArrDigest[i3] & cb.f19604m];
            }
            return new String(cArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private String bufferToHex(byte[] bArr, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer(i3 * 2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            appendHexPair(bArr[i2], stringBuffer);
            i2++;
        }
        return stringBuffer.toString();
    }

    public String getBigFileMd5(String str) {
        return getBigFileMd5(new File(str));
    }
}
