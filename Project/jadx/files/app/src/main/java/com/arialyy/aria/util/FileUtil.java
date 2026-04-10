package com.arialyy.aria.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import com.arialyy.aria.core.AriaConfig;
import com.umeng.analytics.pro.o;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class FileUtil {
    private static final Pattern DIR_SEPORATOR = Pattern.compile("/");
    private static final String EXTERNAL_STORAGE_PATH = Environment.getExternalStorageDirectory().getPath();
    private static final String TAG = "FileUtil";

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0037 -> B:41:0x0053). Please report as a decompilation issue!!! */
    public static boolean canWrite(String str) throws Throwable {
        File file;
        boolean z2 = true;
        if (new File(str).canWrite()) {
            return true;
        }
        File file2 = null;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            try {
                file = new File(str, "tw.txt");
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(1);
                    fileWriter.close();
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e3) {
                    e = e3;
                    file2 = file;
                    e.printStackTrace();
                    z2 = false;
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                } catch (Throwable th) {
                    th = th;
                    if (file != null) {
                        try {
                            if (file.exists()) {
                                file.delete();
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
            return z2;
        } catch (Throwable th2) {
            th = th2;
            file = file2;
        }
    }

    public static boolean checkMemorySpace(String str, long j2) {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                createDir(file.getParentFile().getPath());
            }
            str = file.getParentFile().getPath();
        }
        StatFs statFs = new StatFs(str);
        return j2 <= ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    @Deprecated
    private static boolean checkSDMemorySpace(String str, long j2) {
        List<String> sDPathList = getSDPathList(AriaConfig.getInstance().getAPP());
        if (sDPathList != null && !sDPathList.isEmpty()) {
            for (String str2 : sDPathList) {
                if (str.contains(str2) && j2 > 0 && j2 > getAvailableExternalMemorySize(str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<String> compareMountsWithVold(List<String> list, List<String> list2) {
        for (int size = list.size() - 1; size >= 0; size--) {
            String str = list.get(size);
            File file = new File(str);
            if (!file.exists() || !file.isDirectory() || !file.canWrite()) {
                list.remove(size);
            } else if (list2 != null && !list2.contains(str)) {
                list.remove(size);
            }
        }
        if (list2 != null) {
            list2.clear();
        }
        return list;
    }

    public static boolean createDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return false;
        }
        if (file.mkdirs()) {
            return true;
        }
        ALog.d(TAG, "创建失败，请检查路径和是否配置文件权限！");
        return false;
    }

    public static boolean createFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            return createFile(new File(str));
        }
        ALog.e(TAG, "文件路径不能为null");
        return false;
    }

    public static void createFileFormInputStream(InputStream inputStream, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 <= 0) {
                    inputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static String createFileName(String str) {
        int iIndexOf = str.indexOf("?");
        String strSubstring = "";
        if (iIndexOf > 0) {
            String strSubstring2 = str.substring(0, iIndexOf);
            int iLastIndexOf = strSubstring2.lastIndexOf("/");
            if (iLastIndexOf > 0) {
                strSubstring = strSubstring2.substring(iLastIndexOf + 1);
            }
        } else {
            int iLastIndexOf2 = str.lastIndexOf("/");
            if (iLastIndexOf2 > 0) {
                strSubstring = str.substring(iLastIndexOf2 + 1);
            }
        }
        return TextUtils.isEmpty(strSubstring) ? CommonUtil.keyToHashKey(str) : strSubstring;
    }

    public static boolean deleteDir(File file) {
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        for (File file2 : file.listFiles()) {
            deleteDir(file2);
        }
        return file.delete();
    }

    public static boolean deleteFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            return deleteFile(new File(str));
        }
        ALog.e(TAG, "删除文件失败，路径为空");
        return false;
    }

    public static long getAvailMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    private static long getAvailableExternalMemorySize(String str) {
        StatFs statFs = new StatFs(str);
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static String getFileExtensionName(String str) {
        int iLastIndexOf;
        if (!TextUtils.isEmpty(str) && (iLastIndexOf = str.lastIndexOf(".")) > -1) {
            return str.substring(iLastIndexOf + 1);
        }
        return null;
    }

    private static List<String> getSDPathList(Context context) {
        if (Build.VERSION.SDK_INT < 17) {
            return compareMountsWithVold(readMountsFile(), readVoldFile());
        }
        try {
            return getVolumeList(context);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static List<String> getStorageDirectories() {
        ArrayList arrayList = new ArrayList();
        String str = System.getenv("EXTERNAL_STORAGE");
        String str2 = System.getenv("SECONDARY_STORAGE");
        String str3 = System.getenv("EMULATED_STORAGE_TARGET");
        if (!TextUtils.isEmpty(str3)) {
            String[] strArrSplit = DIR_SEPORATOR.split(Environment.getExternalStorageDirectory().getAbsolutePath());
            String str4 = strArrSplit[strArrSplit.length - 1];
            boolean z2 = false;
            if (!TextUtils.isEmpty(str4) && TextUtils.isDigitsOnly(str4)) {
                z2 = true;
            }
            if (!z2) {
                str4 = "";
            }
            if (TextUtils.isEmpty(str4)) {
                arrayList.add(str);
            } else {
                arrayList.add(str3 + File.separator + str4);
            }
        } else if (TextUtils.isEmpty(str)) {
            arrayList.add("/storage/sdcard0");
        } else {
            arrayList.add(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            Collections.addAll(arrayList, str2.split(File.pathSeparator));
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            String str5 = (String) arrayList.get(size);
            File file = new File(str5);
            if (!file.exists() || !file.isDirectory() || !canWrite(str5)) {
                arrayList.remove(size);
            }
        }
        return arrayList;
    }

    private static long getTotalExternalMemorySize(String str) {
        StatFs statFs = new StatFs(str);
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static long getTotalMemory() {
        long jIntValue = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            jIntValue = Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024;
            bufferedReader.close();
            return jIntValue;
        } catch (IOException e2) {
            e2.printStackTrace();
            return jIntValue;
        }
    }

    public static String getTsCacheDir(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("m3u8文保存路径为空");
        }
        File file = new File(str);
        return String.format("%s/.%s_%s", file.getParent(), file.getName(), Integer.valueOf(i2));
    }

    private static List<String> getVolumeList(Context context) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ArrayList<String> arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            List<StorageVolume> storageVolumes = ((StorageManager) context.getSystemService("storage")).getStorageVolumes();
            Method declaredMethod = StorageVolume.class.getDeclaredMethod("getPath", new Class[0]);
            declaredMethod.setAccessible(true);
            for (StorageVolume storageVolume : storageVolumes) {
                if (storageVolume.getState().equals("mounted")) {
                    arrayList.add((String) declaredMethod.invoke(storageVolume, new Object[0]));
                }
            }
        } else {
            arrayList.addAll(getStorageDirectories());
        }
        if (arrayList.isEmpty()) {
            arrayList = new ArrayList();
            arrayList.add(EXTERNAL_STORAGE_PATH);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : arrayList) {
            File file = new File(str);
            if (file.exists() && file.isDirectory() && canWrite(str)) {
                int iHashCode = (file.getTotalSpace() + "-" + file.getUsableSpace()).hashCode();
                String str2 = (String) linkedHashMap.get(Integer.valueOf(iHashCode));
                if (TextUtils.isEmpty(str2) || str2.length() >= str.length()) {
                    linkedHashMap.put(Integer.valueOf(iHashCode), str);
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = linkedHashMap.keySet().iterator();
        while (it.hasNext()) {
            arrayList2.add(linkedHashMap.get((Integer) it.next()));
        }
        return arrayList2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0032 -> B:30:0x0035). Please report as a decompilation issue!!! */
    public static Properties loadConfig(File file) throws Throwable {
        Properties properties = new Properties();
        if (!file.exists()) {
            createFile(file.getPath());
        }
        FileInputStream fileInputStream = null;
        try {
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
            }
            return properties;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0109 A[Catch: IOException -> 0x0105, TRY_LEAVE, TryCatch #0 {IOException -> 0x0105, blocks: (B:60:0x0101, B:64:0x0109), top: B:70:0x0101 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean mergeFile(java.lang.String r22, java.util.List<java.lang.String> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.util.FileUtil.mergeFile(java.lang.String, java.util.List):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x011e A[Catch: IOException -> 0x011a, TRY_LEAVE, TryCatch #0 {IOException -> 0x011a, blocks: (B:64:0x0116, B:68:0x011e), top: B:74:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean mergeSFtpFile(java.lang.String r23, java.util.List<java.lang.String> r24, long r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.util.FileUtil.mergeSFtpFile(java.lang.String, java.util.List, long):boolean");
    }

    private static List<String> readMountsFile() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(EXTERNAL_STORAGE_PATH);
        try {
            Scanner scanner = new Scanner(new File("/proc/mounts"));
            while (scanner.hasNext()) {
                String strNextLine = scanner.nextLine();
                if (strNextLine.startsWith("/dev/block/vold/") || strNextLine.startsWith("/dev/block//vold/")) {
                    String str = strNextLine.split(" ")[1];
                    if (!str.equals(EXTERNAL_STORAGE_PATH)) {
                        arrayList.add(str);
                    }
                }
            }
            scanner.close();
        } catch (Exception unused) {
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static Object readObjFromFile(String str) throws Throwable {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "文件路径为空");
            return null;
        }
        ?? Exists = new File(str).exists();
        try {
            try {
                if (Exists == 0) {
                    ALog.e(TAG, String.format("文件【%s】不存在", str));
                    return null;
                }
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (IOException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (ClassNotFoundException e4) {
                    e = e4;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    Exists = 0;
                    if (Exists != 0) {
                        try {
                            Exists.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    Object object = new ObjectInputStream(fileInputStream).readObject();
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                    return object;
                } catch (FileNotFoundException e7) {
                    e = e7;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (IOException e8) {
                    e = e8;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (ClassNotFoundException e9) {
                    e = e9;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                }
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static List<String> readVoldFile() {
        Scanner scanner;
        try {
            try {
                scanner = new Scanner(new File("/system/etc/vold.fstab"));
            } catch (FileNotFoundException unused) {
                scanner = new Scanner(new File("/system/etc/vold.conf"));
            }
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(EXTERNAL_STORAGE_PATH);
                while (scanner.hasNext()) {
                    String strNextLine = scanner.nextLine();
                    if (!TextUtils.isEmpty(strNextLine)) {
                        String strTrim = strNextLine.trim();
                        if (strTrim.startsWith("dev_mount")) {
                            String[] strArrSplit = strTrim.split(" ");
                            if (strArrSplit.length >= 3) {
                                String strSubstring = strArrSplit[2];
                                if (strSubstring.contains(":")) {
                                    strSubstring = strSubstring.substring(0, strSubstring.indexOf(":"));
                                }
                                if (!strSubstring.equals(EXTERNAL_STORAGE_PATH)) {
                                    arrayList.add(strSubstring);
                                }
                            }
                        } else if (strTrim.startsWith("mount_point")) {
                            String strTrim2 = strTrim.replaceAll("mount_point", "").trim();
                            if (!strTrim2.equals(EXTERNAL_STORAGE_PATH)) {
                                arrayList.add(strTrim2);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (Exception unused2) {
                return arrayList;
            }
        } catch (Exception unused3) {
            return null;
        }
    }

    public static void saveConfig(File file, Properties properties) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                    try {
                        properties.store(fileOutputStream2, (String) null);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (Exception e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public static void splitFile(String str, int i2) {
        File file;
        long j2;
        int i3 = i2;
        try {
            File file2 = new File(str);
            long length = file2.length();
            FileInputStream fileInputStream = new FileInputStream(file2);
            FileChannel channel = fileInputStream.getChannel();
            long j3 = length / ((long) i3);
            long j4 = 0;
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i3 - 1;
                if (i4 == i5) {
                    j3 = length - (j3 * ((long) i5));
                }
                String str2 = file2.getPath() + "." + i4 + ".part";
                ALog.d(TAG, String.format("block = %s", Long.valueOf(j3)));
                File file3 = new File(str2);
                if (!file3.exists()) {
                    createFile(file3);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                FileChannel channel2 = fileOutputStream.getChannel();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(o.a.f19783t);
                while (true) {
                    int i6 = channel.read(byteBufferAllocate);
                    file = file2;
                    if (i6 == -1) {
                        j2 = length;
                        break;
                    }
                    byteBufferAllocate.flip();
                    channel2.write(byteBufferAllocate);
                    byteBufferAllocate.compact();
                    j2 = length;
                    j4 += (long) i6;
                    if (j4 >= ((long) (i4 + 1)) * j3) {
                        break;
                    }
                    file2 = file;
                    length = j2;
                }
                ALog.d(TAG, String.format("len = %s", Long.valueOf(file3.length())));
                fileOutputStream.close();
                channel2.close();
                i4++;
                i3 = i2;
                file2 = file;
                length = j2;
            }
            fileInputStream.close();
            channel.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0040 A[Catch: IOException -> 0x0044, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0044, blocks: (B:12:0x0021, B:25:0x0036, B:30:0x0040), top: B:42:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void writeObjToFile(java.lang.String r2, java.lang.Object r3) throws java.lang.Throwable {
        /*
            boolean r0 = r3 instanceof java.io.Serializable
            if (r0 != 0) goto Lc
            java.lang.String r2 = "FileUtil"
            java.lang.String r3 = "对象写入文件失败，data数据必须实现Serializable接口"
            com.arialyy.aria.util.ALog.e(r2, r3)
            return
        Lc:
            r0 = 0
            boolean r1 = createFile(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30 java.io.FileNotFoundException -> L3a
            if (r1 != 0) goto L14
            return
        L14:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30 java.io.FileNotFoundException -> L3a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2e java.io.IOException -> L30 java.io.FileNotFoundException -> L3a
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L28 java.io.FileNotFoundException -> L2b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L28 java.io.FileNotFoundException -> L2b
            r2.writeObject(r3)     // Catch: java.lang.Throwable -> L25 java.io.IOException -> L28 java.io.FileNotFoundException -> L2b
            r1.close()     // Catch: java.io.IOException -> L44
            goto L48
        L25:
            r2 = move-exception
            r0 = r1
            goto L49
        L28:
            r2 = move-exception
            r0 = r1
            goto L31
        L2b:
            r2 = move-exception
            r0 = r1
            goto L3b
        L2e:
            r2 = move-exception
            goto L49
        L30:
            r2 = move-exception
        L31:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.io.IOException -> L44
            goto L48
        L3a:
            r2 = move-exception
        L3b:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L48
            r0.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r2 = move-exception
            r2.printStackTrace()
        L48:
            return
        L49:
            if (r0 == 0) goto L53
            r0.close()     // Catch: java.io.IOException -> L4f
            goto L53
        L4f:
            r3 = move-exception
            r3.printStackTrace()
        L53:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.util.FileUtil.writeObjToFile(java.lang.String, java.lang.Object):void");
    }

    public static boolean createFile(File file) {
        if (file.getParentFile() == null || !file.getParentFile().exists()) {
            ALog.d(TAG, "目标文件所在路径不存在，准备创建……");
            if (!createDir(file.getParent())) {
                ALog.d(TAG, "创建目录文件所在的目录失败！文件路径【" + file.getPath() + "】");
            }
        }
        deleteFile(file);
        try {
            return file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean deleteFile(File file) {
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        if (file.renameTo(file2)) {
            return file2.delete();
        }
        return file.delete();
    }
}
