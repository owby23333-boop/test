package com.funny.audio.core.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class IOUtils {
    private IOUtils() {
        throw new AssertionError();
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throw new RuntimeException("IOException occurred. ", e);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean saveTextValue(String fileName, String content, boolean append) {
        try {
            File file = new File(fileName);
            if (!append && file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes("UTF-8"));
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void deleteAllFile(String Path) {
        File[] fileArrListFiles = new File(Path).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    System.out.println(file.getName());
                } else {
                    file.delete();
                }
            }
        }
    }
}
