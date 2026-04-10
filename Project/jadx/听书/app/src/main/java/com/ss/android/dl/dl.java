package com.ss.android.dl;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.utils.wp;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes4.dex */
public class dl {
    private static final char[] z = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String z(File file) {
        return z(file, 9, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
    }

    public static String z(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return g(file, i, j);
                }
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        return "";
    }

    public static int z(String str, File file) {
        return z(str, file, (g) null);
    }

    public static int z(String str, File file, g gVar) {
        int i;
        long j;
        String strG;
        if (str == null || str.length() == 0) {
            return 2;
        }
        try {
            if (gVar != null) {
                if (gVar.z() <= 0) {
                    try {
                        gVar.g();
                    } catch (Throwable unused) {
                    }
                    return 5;
                }
            } else if (file == null || !file.exists()) {
                return 5;
            }
            try {
                z zVarZ = z(str);
                if (zVarZ == null) {
                    i = -1;
                    j = -1;
                } else {
                    if (zVarZ.z > 1) {
                        return 3;
                    }
                    i = zVarZ.dl;
                    j = zVarZ.f1965a;
                }
                z zVarZ2 = null;
                try {
                    if (gVar != null) {
                        strG = z(gVar, i, j);
                    } else {
                        strG = g(file, i, j);
                    }
                } catch (Throwable th) {
                    wp.z(th);
                    strG = null;
                }
                if (strG != null && strG.length() != 0) {
                    if (zVarZ == null || (zVarZ.z == 1 && zVarZ.g == 1)) {
                        if (strG.equals(str)) {
                            return 0;
                        }
                    } else if (zVarZ.gc != null) {
                        try {
                            zVarZ2 = z(strG);
                        } catch (Throwable unused2) {
                        }
                        if (zVarZ2 != null && zVarZ.dl == zVarZ2.dl && zVarZ.f1965a == zVarZ2.f1965a && zVarZ.gc.equals(zVarZ2.gc)) {
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

    private static String g(File file, int i, long j) throws Exception {
        return z(new com.ss.android.dl.z(file), i, j);
    }

    private static String z(g gVar, int i, long j) throws Exception {
        long j2;
        int i2 = i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        if (messageDigest == null) {
            return "";
        }
        try {
            long jZ = gVar.z();
            long j3 = 0;
            if (i2 <= 0 || j <= 0 || ((long) i2) * j > (8 * jZ) / 10) {
                j2 = jZ;
                i2 = 1;
            } else {
                j2 = j;
            }
            byte[] bArr = new byte[8192];
            z(gVar, messageDigest, bArr, 0L, j2);
            if (i2 > 2) {
                int i3 = i2 - 1;
                long j4 = (jZ - (((long) i2) * j2)) / ((long) i3);
                int i4 = 1;
                while (i4 < i3) {
                    j3 += j2 + j4;
                    z(gVar, messageDigest, bArr, j3, j2);
                    i4++;
                    i3 = i3;
                }
            }
            if (i2 > 1) {
                z(gVar, messageDigest, bArr, jZ - j2, j2);
            }
            String strZ = z(messageDigest.digest());
            if (i2 == 1 && j2 == jZ) {
                return strZ;
            }
            String str = z(i2, j2) + ";" + strZ;
            try {
                gVar.g();
            } catch (Throwable unused) {
            }
            return str;
        } finally {
            try {
                gVar.g();
            } catch (Throwable unused2) {
            }
        }
    }

    private static void z(g gVar, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        gVar.z(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int iZ = gVar.z(bArr, 0, (int) Math.min(j2 - j3, bArr.length));
            if (iZ <= 0) {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + iZ + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
            messageDigest.update(bArr, 0, iZ);
            j3 += (long) iZ;
        }
    }

    private static String z(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        int length = bArr.length;
        int i = length * 2;
        char[] cArr = new char[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = bArr[i3 + 0] & 255;
            int i5 = i2 + 1;
            char[] cArr2 = z;
            cArr[i2] = cArr2[i4 >> 4];
            i2 = i5 + 1;
            cArr[i5] = cArr2[i4 & 15];
        }
        return new String(cArr, 0, i);
    }

    private static String z(int i, long j) {
        return "ttmd5:1:1:" + z(i) + "g" + z(j);
    }

    private static z z(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] strArrSplit = str.split(";");
        String[] strArrSplit2 = strArrSplit[0].split(":");
        z zVar = new z();
        zVar.z = Integer.parseInt(strArrSplit2[1]);
        if (zVar.z > 1) {
            return zVar;
        }
        zVar.g = Integer.parseInt(strArrSplit2[2]);
        String[] strArrSplit3 = strArrSplit2[3].split("g");
        zVar.dl = (int) g(strArrSplit3[0]);
        zVar.f1965a = g(strArrSplit3[1]);
        zVar.gc = strArrSplit[1];
        return zVar;
    }

    private static String z(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    private static long g(String str) throws RuntimeException {
        return (Long.parseLong(str, 16) - 31) >> 4;
    }

    private static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1965a;
        private int dl;
        private int g;
        private String gc;
        private int z;

        private z() {
        }
    }
}
