package com.ss.android.e;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    private static final char[] e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static class e {
        private int bf;
        private int d;
        private int e;
        private String ga;
        private long tg;

        private e() {
        }
    }

    private static String bf(File file, int i, long j) throws Exception {
        return e(new com.ss.android.e.e(file), i, j);
    }

    public static String e(File file) {
        return e(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    private static long bf(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    public static String e(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return bf(file, i, j);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static int e(String str, File file) {
        return e(str, file, (bf) null);
    }

    public static int e(String str, File file, bf bfVar) {
        int i;
        long j;
        String strBf;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (bfVar != null) {
                if (bfVar.e() <= 0) {
                    try {
                        bfVar.bf();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                e eVarE = e(str);
                if (eVarE == null) {
                    i = -1;
                    j = -1;
                } else {
                    if (eVarE.e > 1) {
                        return 3;
                    }
                    i = eVarE.d;
                    j = eVarE.tg;
                }
                e eVarE2 = null;
                try {
                    if (bfVar != null) {
                        strBf = e(bfVar, i, j);
                    } else {
                        strBf = bf(file, i, j);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    strBf = null;
                }
                if (strBf != null && strBf.length() != 0) {
                    if (eVarE != null && (eVarE.e != 1 || eVarE.bf != 1)) {
                        if (eVarE.ga != null) {
                            try {
                                eVarE2 = e(strBf);
                            } catch (Throwable unused2) {
                            }
                            if (eVarE2 != null && eVarE.d == eVarE2.d && eVarE.tg == eVarE2.tg && eVarE.ga.equals(eVarE2.ga)) {
                                return 0;
                            }
                        }
                    } else if (strBf.equals(str)) {
                        return 0;
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

    private static String e(bf bfVar, int i, long j) throws Exception {
        long j2;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long jE = bfVar.e();
            if (i2 <= 0 || j <= 0 || ((long) i2) * j > (8 * jE) / 10) {
                j2 = jE;
                i2 = 1;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            long j3 = 0;
            e(bfVar, messageDigest, bArr, 0L, j2);
            if (i2 > 2) {
                int i3 = i2 - 1;
                long j4 = (jE - (((long) i2) * j2)) / ((long) i3);
                int i4 = 1;
                while (i4 < i3) {
                    j3 += j2 + j4;
                    e(bfVar, messageDigest, bArr, j3, j2);
                    i4++;
                    i3 = i3;
                }
            }
            if (i2 > 1) {
                e(bfVar, messageDigest, bArr, jE - j2, j2);
            }
            String strE = e(messageDigest.digest());
            if (i2 == 1 && j2 == jE) {
                return strE;
            }
            String str = e(i2, j2) + ";" + strE;
            try {
                bfVar.bf();
            } catch (Throwable unused) {
            }
            return str;
        } finally {
            try {
                bfVar.bf();
            } catch (Throwable unused2) {
            }
        }
    }

    private static void e(bf bfVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        bfVar.e(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int iE = bfVar.e(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (iE > 0) {
                messageDigest.update(bArr, 0, iE);
                j3 += (long) iE;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iE + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
        }
    }

    private static String e(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int i = length * 2;
            char[] cArr = new char[i];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = bArr[i3 + 0] & 255;
                int i5 = i2 + 1;
                char[] cArr2 = e;
                cArr[i2] = cArr2[i4 >> 4];
                i2 = i5 + 1;
                cArr[i5] = cArr2[i4 & 15];
            }
            return new String(cArr, 0, i);
        }
        throw new NullPointerException("bytes is null");
    }

    private static String e(int i, long j) {
        return "ttmd5:1:1:" + e(i) + "g" + e(j);
    }

    private static e e(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(";");
        String[] strArrSplit2 = strArrSplit[0].split(":");
        e eVar = new e();
        eVar.e = Integer.parseInt(strArrSplit2[1]);
        if (eVar.e > 1) {
            return eVar;
        }
        eVar.bf = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split("g");
        eVar.d = (int) bf(strArrSplit3[0]);
        eVar.tg = bf(strArrSplit3[1]);
        eVar.ga = strArrSplit[1];
        return eVar;
    }

    private static String e(long j) {
        return Long.toHexString((j << 4) + 31);
    }
}
