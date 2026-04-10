package com.bykv.vk.component.ttvideo.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class HardWareInfo {
    private static final int ATOM = 1;
    public static final int CPU_FAMILY_ARM = 1;
    public static final int CPU_FAMILY_MIPS = 3;
    public static final int CPU_FAMILY_UNKNOWN = 0;
    public static final int CPU_FAMILY_X86 = 2;
    private static final int NEON = 0;
    private static int[] mArmArchitecture = new int[3];
    private static int mCpuType;

    private static boolean isAndroidJB2() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        com.bykv.vk.component.ttvideo.utils.HardWareInfo.mArmArchitecture[0] = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] getCpuInfo() {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.utils.HardWareInfo.getCpuInfo():int[]");
    }

    public static int[] getCpuArchitecture() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/proc/cpuinfo");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] strArrSplit = line.replace("\t", "").split(":");
                    if (strArrSplit.length == 2) {
                        String strTrim = strArrSplit[0].trim();
                        String strTrim2 = strArrSplit[1].trim();
                        if (strTrim.compareTo("Processor") == 0) {
                            StringBuilder sb = new StringBuilder();
                            for (int iIndexOf = strTrim2.indexOf("ARMv") + 4; iIndexOf < strTrim2.length(); iIndexOf++) {
                                String string = new StringBuilder().append(strTrim2.charAt(iIndexOf)).toString();
                                if (!string.matches("\\d")) {
                                    break;
                                }
                                sb.append(string);
                            }
                            int[] iArr = mArmArchitecture;
                            iArr[0] = 1;
                            iArr[1] = Integer.parseInt(sb.toString());
                        } else if (strTrim.compareToIgnoreCase("Features") == 0) {
                            if (strTrim2.contains("neon")) {
                                mArmArchitecture[2] = 0;
                            }
                        } else if (strTrim.compareToIgnoreCase("model name") == 0) {
                            if (strTrim2.contains("Intel")) {
                                int[] iArr2 = mArmArchitecture;
                                iArr2[0] = 2;
                                iArr2[2] = 1;
                            }
                        } else if (strTrim.compareToIgnoreCase("cpu family") == 0) {
                            mArmArchitecture[1] = Integer.parseInt(strTrim2);
                        }
                    }
                } catch (Throwable th) {
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                    throw th;
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (Exception e) {
            wp.z(e);
        }
        return mArmArchitecture;
    }

    private static long getDirectoryAvailableSize(String str) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(str);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                availableBlocks = statFs.getAvailableBlocks();
            }
            return blockSize * availableBlocks;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private static long getDirectoryTotalSize(String str) {
        long blockSize;
        long blockCount;
        try {
            StatFs statFs = new StatFs(str);
            if (isAndroidJB2()) {
                blockSize = statFs.getBlockSizeLong();
                blockCount = statFs.getBlockCountLong();
            } else {
                blockSize = statFs.getBlockSize();
                blockCount = statFs.getBlockCount();
            }
            return blockSize * blockCount;
        } catch (IllegalArgumentException unused) {
            return -1L;
        }
    }

    private static long getTotalStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryTotalSize(g.z(context).getParent());
    }

    private static long getAvailableStorageSize(Context context) {
        if (context == null || Environment.getDataDirectory() == null) {
            return -1L;
        }
        return getDirectoryAvailableSize(g.z(context).getParent());
    }

    public static long[] getSDCardSize(Context context) {
        long[] jArr = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState())) {
            long availableStorageSize = getAvailableStorageSize(context);
            jArr[0] = getTotalStorageSize(context);
            jArr[1] = availableStorageSize;
        }
        return jArr;
    }

    public static long getProcessCpuInfo() throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String line = bufferedReader.readLine();
            bufferedReader.close();
            String[] strArrSplit = line.split(" ");
            try {
                bufferedReader.close();
            } catch (Exception e) {
                wp.z(e);
            }
            try {
                return Long.parseLong(strArrSplit[13]) + Long.parseLong(strArrSplit[14]) + Long.parseLong(strArrSplit[15]) + Long.parseLong(strArrSplit[16]);
            } catch (ArrayIndexOutOfBoundsException unused2) {
                return 0L;
            }
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e2) {
                    wp.z(e2);
                }
            }
            return 0L;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e3) {
                    wp.z(e3);
                }
            }
            throw th;
        }
    }

    public static int getCpuFamily() {
        if (mCpuType == 0) {
            getCpuInfo();
            mCpuType = mArmArchitecture[0];
        }
        return mCpuType;
    }
}
