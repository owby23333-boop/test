package com.funny.audio.core.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FileUtils {
    public static final String FILE_EXTENSION_SEPARATOR = ".";
    public static final String URI_TYPE_FILE = "file";
    public final String TAG = "LAZY";

    private FileUtils() {
        throw new AssertionError();
    }

    public static StringBuilder readFile(String filePath, String charsetName) throws Throwable {
        File file = new File(filePath);
        StringBuilder sb = new StringBuilder("");
        BufferedReader bufferedReader = null;
        if (!file.isFile()) {
            return null;
        }
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetName));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            if (!sb.toString().equals("")) {
                                sb.append("\r\n");
                            }
                            sb.append(line);
                        } else {
                            IOUtils.close(bufferedReader2);
                            return sb;
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        throw new RuntimeException("IOException occurred. ", e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        IOUtils.close(bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static boolean writeFile(String filePath, String content, boolean append) throws Throwable {
        if (StringUtils.isEmpty(content)) {
            return false;
        }
        FileWriter fileWriter = null;
        try {
            try {
                makeDirs(filePath);
                FileWriter fileWriter2 = new FileWriter(filePath, append);
                try {
                    fileWriter2.write(content);
                    IOUtils.close(fileWriter2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    fileWriter = fileWriter2;
                    throw new RuntimeException("IOException occurred. ", e);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    IOUtils.close(fileWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static File getCacheFileDir(Context context) {
        return context.getCacheDir();
    }

    public static boolean writeFile(String filePath, List<String> contentList, boolean append) throws Throwable {
        int i = 0;
        if (contentList.size() == 0 || contentList == null) {
            return false;
        }
        FileWriter fileWriter = null;
        try {
            try {
                makeDirs(filePath);
                FileWriter fileWriter2 = new FileWriter(filePath, append);
                try {
                    for (String str : contentList) {
                        int i2 = i + 1;
                        if (i > 0) {
                            fileWriter2.write("\r\n");
                        }
                        fileWriter2.write(str);
                        i = i2;
                    }
                    IOUtils.close(fileWriter2);
                    return true;
                } catch (IOException e) {
                    e = e;
                    throw new RuntimeException("IOException occurred. ", e);
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    IOUtils.close(fileWriter);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean writeFile(String filePath, String content) {
        return writeFile(filePath, content, false);
    }

    public static boolean writeFile(String filePath, List<String> contentList) {
        return writeFile(filePath, contentList, false);
    }

    public static boolean writeFile(String filePath, InputStream stream) {
        return writeFile(filePath, stream, false);
    }

    public static boolean writeFile(String filePath, InputStream stream, boolean append) {
        return writeFile(filePath != null ? new File(filePath) : null, stream, append);
    }

    public static boolean writeFile(File file, InputStream stream) {
        return writeFile(file, stream, false);
    }

    public static boolean writeFile(File file, InputStream stream, boolean append) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                makeDirs(file.getAbsolutePath());
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, append);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = stream.read(bArr);
                        if (i != -1) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            fileOutputStream2.flush();
                            IOUtils.close(fileOutputStream2);
                            IOUtils.close(stream);
                            return true;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    throw new RuntimeException("FileNotFoundException occurred. ", e);
                } catch (IOException e2) {
                    e = e2;
                    throw new RuntimeException("IOException occurred. ", e);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    IOUtils.close(fileOutputStream);
                    IOUtils.close(stream);
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void moveFile(String sourceFilePath, String destFilePath) {
        if (android.text.TextUtils.isEmpty(sourceFilePath) || android.text.TextUtils.isEmpty(destFilePath)) {
            throw new RuntimeException("Both sourceFilePath and destFilePath cannot be null.");
        }
        moveFile(new File(sourceFilePath), new File(destFilePath));
    }

    public static void moveFile(File srcFile, File destFile) {
        if (srcFile.renameTo(destFile)) {
            return;
        }
        copyFile(srcFile.getAbsolutePath(), destFile.getAbsolutePath());
        deleteFile(srcFile.getAbsolutePath());
    }

    public static boolean copyFile(String sourceFilePath, String destFilePath) {
        try {
            return writeFile(destFilePath, new FileInputStream(sourceFilePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException occurred. ", e);
        }
    }

    public static List<String> readFileToList(String filePath, String charsetName) throws Throwable {
        File file = new File(filePath);
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        if (!file.isFile()) {
            return null;
        }
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetName));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            arrayList.add(line);
                        } else {
                            IOUtils.close(bufferedReader2);
                            return arrayList;
                        }
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        throw new RuntimeException("IOException occurred. ", e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        IOUtils.close(bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static String getFileNameWithoutExtension(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return filePath;
        }
        int iLastIndexOf = filePath.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        int iLastIndexOf2 = filePath.lastIndexOf(File.separator);
        if (iLastIndexOf2 == -1) {
            return iLastIndexOf == -1 ? filePath : filePath.substring(0, iLastIndexOf);
        }
        if (iLastIndexOf == -1) {
            return filePath.substring(iLastIndexOf2 + 1);
        }
        if (iLastIndexOf2 < iLastIndexOf) {
            return filePath.substring(iLastIndexOf2 + 1, iLastIndexOf);
        }
        return filePath.substring(iLastIndexOf2 + 1);
    }

    public static String getFileName(String filePath) {
        int iLastIndexOf;
        return (StringUtils.isEmpty(filePath) || (iLastIndexOf = filePath.lastIndexOf(File.separator)) == -1) ? filePath : filePath.substring(iLastIndexOf + 1);
    }

    public static String getFolderName(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            return filePath;
        }
        int iLastIndexOf = filePath.lastIndexOf(File.separator);
        return iLastIndexOf == -1 ? "" : filePath.substring(0, iLastIndexOf);
    }

    public static String getFileExtension(String filePath) {
        if (StringUtils.isBlank(filePath)) {
            return filePath;
        }
        int iLastIndexOf = filePath.lastIndexOf(FILE_EXTENSION_SEPARATOR);
        return (iLastIndexOf != -1 && filePath.lastIndexOf(File.separator) < iLastIndexOf) ? filePath.substring(iLastIndexOf + 1) : "";
    }

    public static boolean makeDirs(String filePath) {
        String folderName = getFolderName(filePath);
        if (StringUtils.isEmpty(folderName)) {
            return false;
        }
        File file = new File(folderName);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static boolean makeFolders(String filePath) {
        return makeDirs(filePath);
    }

    public static boolean isFileExist(String filePath) {
        if (StringUtils.isBlank(filePath)) {
            return false;
        }
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

    public static boolean isFolderExist(String directoryPath) {
        if (StringUtils.isBlank(directoryPath)) {
            return false;
        }
        File file = new File(directoryPath);
        return file.exists() && file.isDirectory();
    }

    public static boolean deleteFile(String path) {
        if (StringUtils.isBlank(path)) {
            return true;
        }
        File file = new File(path);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return false;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isFile()) {
                file2.delete();
            } else if (file2.isDirectory()) {
                deleteFile(file2.getAbsolutePath());
            }
        }
        return file.delete();
    }

    public static boolean delete(String delFile) {
        File file = new File(delFile);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return deleteSingleFile(delFile);
        }
        return deleteDirectory(delFile);
    }

    public static boolean deleteSingleFile(String filePath$Name) {
        File file = new File(filePath$Name);
        return file.exists() && file.isFile() && file.delete();
    }

    public static boolean deleteDirectory(String filePath) {
        if (!filePath.endsWith(File.separator)) {
            filePath = filePath + File.separator;
        }
        File file = new File(filePath);
        if (file.exists() && file.isDirectory()) {
            boolean zDeleteDirectory = true;
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    zDeleteDirectory = deleteSingleFile(file2.getAbsolutePath());
                    if (!zDeleteDirectory) {
                        break;
                    }
                } else {
                    if (file2.isDirectory() && !(zDeleteDirectory = deleteDirectory(file2.getAbsolutePath()))) {
                        break;
                    }
                }
            }
            if (zDeleteDirectory && file.delete()) {
                return true;
            }
        }
        return false;
    }

    public static long getFileSize(String path) {
        if (StringUtils.isBlank(path)) {
            return -1L;
        }
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            return file.length();
        }
        return -1L;
    }

    public static long getDirSizes(File f) throws Exception {
        long fileSize;
        File[] fileArrListFiles = f.listFiles();
        long j = 0;
        for (int i = 0; i < fileArrListFiles.length; i++) {
            if (fileArrListFiles[i].isDirectory()) {
                fileSize = getDirSizes(fileArrListFiles[i]);
            } else {
                fileSize = getFileSize(fileArrListFiles[i]);
            }
            j += fileSize;
        }
        return j;
    }

    public static long getFileSize(File file) throws Exception {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        file.createNewFile();
        return 0L;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0057: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:30:0x0057 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String md5(java.io.File r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r6 = 8192(0x2000, float:1.148E-41)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
        L10:
            int r3 = r2.read(r6)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
            r4 = -1
            r5 = 0
            if (r3 == r4) goto L1c
            r1.update(r6, r5, r3)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
            goto L10
        L1c:
            byte[] r6 = r1.digest()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
            r1.<init>()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
        L25:
            int r3 = r6.length     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
            if (r5 >= r3) goto L3f
            r3 = r6[r5]     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 16
            if (r3 >= r4) goto L35
            java.lang.String r4 = "0"
            r1.append(r4)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
        L35:
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
            r1.append(r3)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
            int r5 = r5 + 1
            goto L25
        L3f:
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L56
            r2.close()
            return r6
        L47:
            r6 = move-exception
            goto L4d
        L49:
            r6 = move-exception
            goto L58
        L4b:
            r6 = move-exception
            r2 = r0
        L4d:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L56
            if (r2 == 0) goto L55
            r2.close()
        L55:
            return r0
        L56:
            r6 = move-exception
            r0 = r2
        L58:
            if (r0 == 0) goto L5d
            r0.close()
        L5d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.core.utils.FileUtils.md5(java.io.File):java.lang.String");
    }

    public static boolean save2File(InputStream data, String fileName, Boolean createDirectory) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                if (createDirectory.booleanValue()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i = data.read(bArr);
                if (i > -1) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static byte[] readFile4Bytes(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream.read(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return bArr;
            } catch (IOException unused2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String readFileContent(String filePathAndName) {
        try {
            return readFileContent(filePathAndName, null, null, 1024);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0054 A[Catch: all -> 0x0066, IOException -> 0x006b, LOOP:0: B:67:0x004e->B:25:0x0054, LOOP_END, TRY_LEAVE, TryCatch #8 {IOException -> 0x006b, all -> 0x0066, blocks: (B:23:0x004e, B:25:0x0054), top: B:67:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0081 A[Catch: IOException -> 0x0089, TryCatch #0 {IOException -> 0x0089, blocks: (B:41:0x007c, B:43:0x0081, B:45:0x0086), top: B:60:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086 A[Catch: IOException -> 0x0089, TRY_LEAVE, TryCatch #0 {IOException -> 0x0089, blocks: (B:41:0x007c, B:43:0x0081, B:45:0x0086), top: B:60:0x007c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e A[Catch: IOException -> 0x0099, TRY_ENTER, TryCatch #1 {IOException -> 0x0099, blocks: (B:27:0x005c, B:28:0x0062, B:49:0x008e, B:51:0x0093), top: B:62:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093 A[Catch: IOException -> 0x0099, TRY_LEAVE, TryCatch #1 {IOException -> 0x0099, blocks: (B:27:0x005c, B:28:0x0062, B:49:0x008e, B:51:0x0093), top: B:62:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x005c A[EDGE_INSN: B:70:0x005c->B:27:0x005c BREAK  A[LOOP:0: B:67:0x004e->B:25:0x0054], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readFileContent(java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8) throws java.lang.Throwable {
        /*
            java.lang.String r0 = ""
            if (r5 == 0) goto L9e
            boolean r1 = r5.equals(r0)
            if (r1 == 0) goto Lc
            goto L9e
        Lc:
            if (r7 == 0) goto L14
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L16
        L14:
            java.lang.String r7 = "\n"
        L16:
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r1 = r1.exists()
            if (r1 != 0) goto L22
            return r0
        L22:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>(r0)
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L8a
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L77 java.io.IOException -> L8a
            if (r6 == 0) goto L44
            java.lang.String r5 = r6.trim()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            if (r5 == 0) goto L3a
            goto L44
        L3a:
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            r5.<init>(r3, r6)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            goto L49
        L44:
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L72 java.io.IOException -> L75
        L49:
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L8c
            r6.<init>(r5, r8)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L8c
        L4e:
            java.lang.String r8 = r6.readLine()     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L6b
            if (r8 == 0) goto L5c
            java.lang.StringBuffer r8 = r1.append(r8)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L6b
            r8.append(r7)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L6b
            goto L4e
        L5c:
            r6.close()     // Catch: java.io.IOException -> L99
            r5.close()     // Catch: java.io.IOException -> L99
        L62:
            r3.close()     // Catch: java.io.IOException -> L99
            goto L99
        L66:
            r7 = move-exception
            r2 = r6
            r6 = r5
            r5 = r7
            goto L7a
        L6b:
            r2 = r6
            goto L8c
        L6d:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
            goto L7a
        L72:
            r5 = move-exception
            r6 = r2
            goto L7a
        L75:
            r5 = r2
            goto L8c
        L77:
            r5 = move-exception
            r6 = r2
            r3 = r6
        L7a:
            if (r2 == 0) goto L7f
            r2.close()     // Catch: java.io.IOException -> L89
        L7f:
            if (r6 == 0) goto L84
            r6.close()     // Catch: java.io.IOException -> L89
        L84:
            if (r3 == 0) goto L89
            r3.close()     // Catch: java.io.IOException -> L89
        L89:
            throw r5
        L8a:
            r5 = r2
            r3 = r5
        L8c:
            if (r2 == 0) goto L91
            r2.close()     // Catch: java.io.IOException -> L99
        L91:
            if (r5 == 0) goto L96
            r5.close()     // Catch: java.io.IOException -> L99
        L96:
            if (r3 == 0) goto L99
            goto L62
        L99:
            java.lang.String r5 = r1.toString()
            return r5
        L9e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.core.utils.FileUtils.readFileContent(java.lang.String, java.lang.String, java.lang.String, int):java.lang.String");
    }

    public static boolean copyAssetToSDCard(AssetManager assetManager, String fileName, String destinationPath) {
        try {
            InputStream inputStreamOpen = assetManager.open(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationPath);
            if (inputStreamOpen == null) {
                return true;
            }
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i > 0) {
                    fileOutputStream.write(bArr, 0, i);
                } else {
                    fileOutputStream.close();
                    inputStreamOpen.close();
                    return true;
                }
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static void openFile(Context context, File file) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setDataAndType(Uri.fromFile(file), MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(file.getPath())));
            context.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(context, "打开失败.", 0).show();
        }
    }

    public static boolean checkFileSize(String filepath, int maxSize) {
        File file = new File(filepath);
        return file.exists() && !file.isDirectory() && file.length() <= ((long) (maxSize * 1024));
    }

    public static void openMedia(Context context, File file) {
        if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg") || file.getName().endsWith(".jpeg")) {
            viewPhoto(context, file);
        } else {
            openFile(context, file);
        }
    }

    public static void viewPhoto(Context context, String file) {
        viewPhoto(context, new File(file));
    }

    public static void viewPhoto(Context context, File file) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "image/*");
            context.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(context, "打开失败.", 0).show();
        }
    }

    public static boolean saveStrToFile(String str, String fileName) {
        return saveStrToFile(str, fileName, "UTF-8");
    }

    public static boolean saveStrToFile(String str, String fileName, String charsetName) throws Throwable {
        byte[] bytes;
        FileOutputStream fileOutputStream;
        if (str != null && !"".equals(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                File file = new File(fileName);
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (charsetName != null && !"".equals(charsetName)) {
                    bytes = str.getBytes(charsetName);
                } else {
                    bytes = str.getBytes();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(bytes, 0, bytes.length);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                    return true;
                } catch (Exception unused2) {
                    return true;
                }
            } catch (Exception unused3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
        return false;
    }

    public static String uriToPath(Context context, Uri uri) {
        Cursor cursorQuery;
        try {
            if (uri.getScheme().equalsIgnoreCase(URI_TYPE_FILE)) {
                return uri.getPath();
            }
            cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    return cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                }
                return null;
            } catch (Exception unused) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        }
    }

    public static void playSound(Context context, String file) {
        playSound(context, new File(file));
    }

    public static void playSound(Context context, File file) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "audio/*");
            context.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(context, "打开失败.", 0).show();
        }
    }

    public static void playVideo(Context context, String file) {
        playVideo(context, new File(file));
    }

    public static void playVideo(Context context, File file) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "video/*");
            context.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(context, "打开失败.", 0).show();
        }
    }

    public static void renameFile(String oldPath, String newPath) {
        try {
            if (android.text.TextUtils.isEmpty(oldPath) || android.text.TextUtils.isEmpty(newPath) || oldPath.equals(newPath)) {
                return;
            }
            new File(oldPath).renameTo(new File(newPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getAvailableInternalStroageSize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static long getTotalInternalStroageSize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }
}
