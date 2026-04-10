package com.dangdang.zframework.utils;

import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.alibaba.android.arouter.utils.Consts;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes10.dex */
public class FileUtil {
    public static final String ENCODING_UTF_8 = "utf-8";
    public static final int MAX_LENGTH = 10240;
    private static final char SYSTEM_SEPARATOR = File.separatorChar;
    private static final char WINDOWS_SEPARATOR = '\\';

    public static void cleanDirectory(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        IOException e = null;
        for (File file2 : fileArrListFiles) {
            try {
                forceDelete(file2);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static float converYuan(float f) {
        return f / 100.0f;
    }

    public static void copyAllFiles(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            File[] fileArrListFiles = new File(str).listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    File file2 = new File(str2 + File.separator + file.getName());
                    if (file.isDirectory()) {
                        file2.mkdirs();
                        copyAllFiles(file.getAbsolutePath(), file2.getAbsolutePath());
                    } else if (file.canRead()) {
                        file2.getParentFile().mkdirs();
                        byte[] bArr = new byte[1024];
                        FileInputStream fileInputStream = new FileInputStream(file);
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        for (int i = fileInputStream.read(bArr); i != -1; i = fileInputStream.read(bArr)) {
                            fileOutputStream.write(bArr, 0, i);
                        }
                        fileInputStream.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteCurrFile(File file) {
        if (!file.exists()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                file2.delete();
            }
        }
        file.delete();
        return true;
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + Consts.DOT);
        }
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean zExists = file.exists();
        if (file.delete()) {
            return;
        }
        if (zExists) {
            throw new IOException("Unable to delete file: " + file);
        }
        throw new FileNotFoundException("File does not exist: " + file);
    }

    public static String formatFileSize(double d) {
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        int i = 0;
        while (d > 1024.0d) {
            i++;
            d /= 1024.0d;
        }
        if (i == 0) {
            return decimalFormat.format(d) + "B";
        }
        if (i == 1) {
            return decimalFormat.format(d) + "KB";
        }
        if (i == 2) {
            return decimalFormat.format(d) + "MB";
        }
        if (i != 3) {
            return "";
        }
        return decimalFormat.format(d) + "GB";
    }

    public static byte[] getBytesFromFile(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e = e;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            close(fileInputStream2);
            throw th;
        }
        try {
            try {
                byte[] bytesFromStream = StreamUtil.getBytesFromStream(fileInputStream);
                close(fileInputStream);
                return bytesFromStream;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                close(fileInputStream2);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            e.printStackTrace();
            close(fileInputStream);
            return null;
        }
    }

    public static String getFileType(File file) {
        if (file == null) {
            return "";
        }
        String name = file.getName();
        String lowerCase = name.substring(name.lastIndexOf(Consts.DOT) + 1, name.length()).toLowerCase();
        return ((lowerCase.equals("m4a") || lowerCase.equals("mp3") || lowerCase.equals("mid") || lowerCase.equals("xmf") || lowerCase.equals("ogg") || lowerCase.equals("wav")) ? "audio" : (lowerCase.equals("3gp") || lowerCase.equals("mp4")) ? "video" : (lowerCase.equals("jpg") || lowerCase.equals("gif") || lowerCase.equals("png") || lowerCase.equals("jpeg") || lowerCase.equals("bmp")) ? "image" : lowerCase.equals("txt") ? "text" : lowerCase.equals("pdf") ? "pdf" : ProxyConfig.MATCH_ALL_SCHEMES) + "/*";
    }

    public static String getSdCardPath() {
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x002b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:22:0x002b */
    public static String getStringFromFile(File file) throws Throwable {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e = e;
                fileInputStream = null;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                close(closeable2);
                throw th;
            }
            try {
                String str = new String(StreamUtil.getBytesFromStream(fileInputStream), "utf-8");
                close(fileInputStream);
                return str;
            } catch (FileNotFoundException e3) {
                e = e3;
                e.printStackTrace();
                close(fileInputStream);
                return null;
            } catch (UnsupportedEncodingException e4) {
                e = e4;
                e.printStackTrace();
                close(fileInputStream);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
            close(closeable2);
            throw th;
        }
    }

    public static boolean isSymlink(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        if (isSystemWindows()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == '\\';
    }

    public static void moveAllFiles(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        copyAllFiles(str, str2);
        recurrenceDeleteFile(new File(str));
    }

    public static void recurrenceDeleteFile(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                recurrenceDeleteFile(file2);
            }
        }
        file.delete();
    }

    public static boolean writeDataToFile(byte[] bArr, File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.flush();
                    close(fileOutputStream2);
                    return true;
                } catch (FileNotFoundException e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    close(fileOutputStream);
                    return false;
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    close(fileOutputStream);
                    return false;
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    close(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    close(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
            } catch (UnsupportedEncodingException e5) {
                e = e5;
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
