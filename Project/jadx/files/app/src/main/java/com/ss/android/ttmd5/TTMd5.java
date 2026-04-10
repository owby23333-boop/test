package com.ss.android.ttmd5;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class TTMd5 {
    private static final int DEFAULT_SAMPLE_COUNT = 9;
    private static final int DEFAULT_SAMPLE_SIZE = 8192;
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String PROTOCOL = "ttmd5";
    private static final String TAG = "TTMd5";
    private static final int VERSION_MAIN = 1;
    private static final int VERSION_SUB = 1;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CHECK_MD5_STATUS {
        public static final int FILE_NOT_EXIST = 5;
        public static final int GET_FILE_MD5_ERROR = 6;
        public static final int MD5_EMPTY = 2;
        public static final int MD5_MATCH = 0;
        public static final int MD5_NOT_MATCH = 1;
        public static final int TTMD5_TAG_PARSER_ERROR = 4;
        public static final int TTMD5_VERSION_NOT_SUPPORT = 3;
        public static final int UNKNOWN_ERROR = 99;
    }

    private static class TTMd5Args {
        private String realMd5;
        private int sampleCount;
        private long sampleSize;
        private int versionMain;
        private int versionSub;

        private TTMd5Args() {
        }
    }

    private static String _ttmd5(File file, int i2, long j2) throws Exception {
        return _ttmd5(new FileRandomAccess(file), i2, j2);
    }

    public static int checkMd5(String str, File file) {
        return checkMd5(str, file, null);
    }

    private static long decryptNum(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    private static String encryptionNum(long j2) {
        return Long.toHexString((j2 << 4) + 31);
    }

    private static String generateTTMd5Tag(int i2, long j2) {
        return "ttmd5:1:1:" + encryptionNum(i2) + "g" + encryptionNum(j2);
    }

    public static String md5(File file) {
        return ttmd5(file, -1, -1L);
    }

    private static TTMd5Args parserTTMd5Args(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(";");
        String[] strArrSplit2 = strArrSplit[0].split(":");
        TTMd5Args tTMd5Args = new TTMd5Args();
        tTMd5Args.versionMain = Integer.parseInt(strArrSplit2[1]);
        if (tTMd5Args.versionMain > 1) {
            return tTMd5Args;
        }
        tTMd5Args.versionSub = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split("g");
        tTMd5Args.sampleCount = (int) decryptNum(strArrSplit3[0]);
        tTMd5Args.sampleSize = decryptNum(strArrSplit3[1]);
        tTMd5Args.realMd5 = strArrSplit[1];
        return tTMd5Args;
    }

    private static String toHexString(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        int length = bArr.length;
        int i2 = length * 2;
        char[] cArr = new char[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = bArr[i4 + 0] & 255;
            int i6 = i3 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i3] = cArr2[i5 >> 4];
            i3 = i6 + 1;
            cArr[i6] = cArr2[i5 & 15];
        }
        return new String(cArr, 0, i2);
    }

    public static String ttmd5(File file) {
        return ttmd5(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    private static void updateSample(IRandomAccess iRandomAccess, MessageDigest messageDigest, byte[] bArr, long j2, long j3) throws IOException {
        iRandomAccess.seek(j2, j3);
        long j4 = 0;
        while (j4 < j3) {
            int i2 = iRandomAccess.read(bArr, 0, (int) Math.min(j3 - j4, bArr.length));
            if (i2 <= 0) {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + i2 + ", readTotalCount = " + j4 + ", sampleSize = " + j3);
            }
            messageDigest.update(bArr, 0, i2);
            j4 += (long) i2;
        }
    }

    private static String _ttmd5(IRandomAccess iRandomAccess, int i2, long j2) throws Exception {
        long j3;
        int i3 = i2;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long length = iRandomAccess.length();
            if (i3 <= 0 || j2 <= 0 || ((long) i3) * j2 > (8 * length) / 10) {
                j3 = length;
                i3 = 1;
            } else {
                j3 = j2;
            }
            byte[] bArr = new byte[8192];
            updateSample(iRandomAccess, messageDigest, bArr, 0L, j3);
            if (i3 > 2) {
                int i4 = i3 - 1;
                long j4 = (length - (((long) i3) * j3)) / ((long) i4);
                long j5 = 0;
                int i5 = 1;
                while (i5 < i4) {
                    long j6 = j5 + j3 + j4;
                    updateSample(iRandomAccess, messageDigest, bArr, j6, j3);
                    i5++;
                    i4 = i4;
                    j5 = j6;
                }
            }
            if (i3 > 1) {
                updateSample(iRandomAccess, messageDigest, bArr, length - j3, j3);
            }
            String hexString = toHexString(messageDigest.digest());
            if (i3 == 1 && j3 == length) {
                try {
                    iRandomAccess.close();
                } catch (Throwable unused) {
                }
                return hexString;
            }
            String str = generateTTMd5Tag(i3, j3) + ";" + hexString;
            try {
                iRandomAccess.close();
            } catch (Throwable unused2) {
            }
            return str;
        } catch (Throwable th) {
            try {
                iRandomAccess.close();
            } catch (Throwable unused3) {
            }
            throw th;
        }
    }

    public static int checkMd5(String str, File file, IRandomAccess iRandomAccess) {
        String str_ttmd5;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (iRandomAccess != null) {
                if (iRandomAccess.length() <= 0) {
                    try {
                        iRandomAccess.close();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            int i2 = -1;
            long j2 = -1;
            try {
                TTMd5Args tTMd5Args = parserTTMd5Args(str);
                if (tTMd5Args != null) {
                    if (tTMd5Args.versionMain > 1) {
                        return 3;
                    }
                    i2 = tTMd5Args.sampleCount;
                    j2 = tTMd5Args.sampleSize;
                }
                TTMd5Args tTMd5Args2 = null;
                try {
                    str_ttmd5 = iRandomAccess != null ? _ttmd5(iRandomAccess, i2, j2) : _ttmd5(file, i2, j2);
                } catch (Throwable th) {
                    th.printStackTrace();
                    str_ttmd5 = null;
                }
                if (str_ttmd5 != null && str_ttmd5.length() != 0) {
                    if (tTMd5Args == null || (tTMd5Args.versionMain == 1 && tTMd5Args.versionSub == 1)) {
                        if (str_ttmd5.equals(str)) {
                            return 0;
                        }
                    } else if (tTMd5Args.realMd5 != null) {
                        try {
                            tTMd5Args2 = parserTTMd5Args(str_ttmd5);
                        } catch (Throwable unused2) {
                        }
                        if (tTMd5Args2 != null && tTMd5Args.sampleCount == tTMd5Args2.sampleCount && tTMd5Args.sampleSize == tTMd5Args2.sampleSize && tTMd5Args.realMd5.equals(tTMd5Args2.realMd5)) {
                            return 0;
                        }
                    }
                    return 1;
                }
                return 6;
            } catch (Throwable unused3) {
                return 4;
            }
        } catch (Throwable unused4) {
            return 99;
        }
    }

    public static String ttmd5(File file, int i2) {
        return ttmd5(file, i2, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(File file, int i2, long j2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return _ttmd5(file, i2, j2);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static String ttmd5(IRandomAccess iRandomAccess) {
        return ttmd5(iRandomAccess, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(IRandomAccess iRandomAccess, int i2) {
        return ttmd5(iRandomAccess, i2, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String ttmd5(IRandomAccess iRandomAccess, int i2, long j2) {
        if (iRandomAccess == null) {
            return "";
        }
        try {
            return _ttmd5(iRandomAccess, i2, j2);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int checkMd5(File file, File file2) {
        if (file == null || file2 == null) {
            return 5;
        }
        try {
            if (file.exists() && file2.exists()) {
                if (file == file2) {
                    return 0;
                }
                return _ttmd5(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI).equals(_ttmd5(file2, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) ? 0 : 1;
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 99;
        }
    }
}
