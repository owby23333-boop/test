package com.ryg.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
public final class SoLibManager {
    private static final String TAG = "SoLibManager";
    private static SoLibManager sInstance = new SoLibManager();
    private static String sNativeLibDir = "";
    private ExecutorService mSoExecutor = Executors.newScheduledThreadPool(1);

    public class CopySoTask {
        private Context mContext;
        private long mLastModityTime;
        private String mSoFileName;
        private ZipEntry mZipEntry;
        private ZipFile mZipFile;

        public CopySoTask(Context context, ZipFile zipFile, ZipEntry zipEntry, long j) {
            this.mZipFile = zipFile;
            this.mContext = context;
            this.mZipEntry = zipEntry;
            this.mSoFileName = parseSoFileName(zipEntry.getName());
            this.mLastModityTime = j;
        }

        private int getAvailableSize(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return 0;
            }
            int iAvailable = inputStream.available();
            if (iAvailable <= 0) {
                return 1024;
            }
            return iAvailable;
        }

        private final String parseSoFileName(String str) {
            return str.substring(str.lastIndexOf("/") + 1);
        }

        private void writeSoFile2LibDir() {
            InputStream inputStream;
            FileOutputStream fileOutputStream = null;
            try {
                inputStream = this.mZipFile.getInputStream(this.mZipEntry);
                try {
                    fileOutputStream = new FileOutputStream(new File(SoLibManager.sNativeLibDir, this.mSoFileName));
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
            }
            copy(inputStream, fileOutputStream);
        }

        public void copy(InputStream inputStream, OutputStream outputStream) {
            byte[] bArr;
            if (inputStream == null || outputStream == null) {
                return;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            try {
                bArr = new byte[getAvailableSize(bufferedInputStream)];
            } catch (IOException e) {
                e.printStackTrace();
                bArr = null;
            }
            while (true) {
                try {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            try {
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                bufferedInputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }

        public void copySo() {
            Log.d(SoLibManager.TAG, "start copy " + this.mZipEntry.getName());
            writeSoFile2LibDir();
            DLConfigs.setSoLastModifiedTime(this.mContext, this.mZipEntry.getName(), this.mLastModityTime);
            Log.d(SoLibManager.TAG, "copy so lib success: " + this.mZipEntry.getName());
        }
    }

    private SoLibManager() {
    }

    @SuppressLint({"DefaultLocale"})
    private String getCpuArch(String str) {
        return str.toLowerCase().contains("arm") ? DLConstants.CPU_ARMEABI : str.toLowerCase().contains(DLConstants.CPU_X86) ? DLConstants.CPU_X86 : str.toLowerCase().contains(DLConstants.CPU_MIPS) ? DLConstants.CPU_MIPS : DLConstants.CPU_ARMEABI;
    }

    private String getCpuName() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            String[] strArrSplit = line.split(":\\s+", 2);
            if (strArrSplit.length >= 2) {
                return strArrSplit[1];
            }
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static SoLibManager getSoLoader() {
        return sInstance;
    }

    public void copyPluginSoLib(final Context context, final String str, final String str2) {
        new Thread() { // from class: com.ryg.utils.SoLibManager.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SoLibManager.this.copyPluginSoLib(context, str, str2, 0);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyPluginSoLib(Context context, String str, String str2, int i) {
        String cpuArch = getCpuArch(getCpuName());
        sNativeLibDir = str2;
        Log.d(TAG, "cpuArchitect: " + cpuArch);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (!zipEntryNextElement.isDirectory()) {
                    String name = zipEntryNextElement.getName();
                    if (name.endsWith(".so") && name.contains(cpuArch)) {
                        long time = zipEntryNextElement.getTime();
                        if (time == DLConfigs.getSoLastModifiedTime(context, name)) {
                            Log.d(TAG, "skip copying, the so lib is exist and not change: " + name);
                        } else {
                            new CopySoTask(context, zipFile, zipEntryNextElement, time).copySo();
                        }
                    }
                }
            }
            try {
                zipFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        Log.d(TAG, "### copy so time : " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
    }
}
