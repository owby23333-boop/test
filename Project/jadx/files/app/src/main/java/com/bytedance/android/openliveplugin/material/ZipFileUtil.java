package com.bytedance.android.openliveplugin.material;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ZipFileUtil {
    private static final int NUM_2048 = 2048;

    private ZipFileUtil() {
    }

    public static String readTextFile(File file) {
        FileInputStream fileInputStream;
        StringBuilder sb = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        while (true) {
            int i2 = fileInputStream.read();
            if (i2 == -1) {
                break;
            }
            sb.append((char) i2);
            return sb.toString();
        }
        fileInputStream.close();
        return sb.toString();
    }

    public static boolean removeDir(File file) {
        if (!file.isDirectory()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return file.delete();
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                removeDir(file2);
            } else {
                file2.delete();
            }
        }
        return file.delete();
    }

    public static void unZipFolder(String str, String str2) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                zipInputStream.close();
                return;
            }
            String name = nextEntry.getName();
            if (!name.contains("..")) {
                if (nextEntry.isDirectory()) {
                    new File(str2 + File.separator + name).mkdirs();
                } else {
                    File file = new File(str2 + File.separator + name);
                    if (file.exists()) {
                        file.delete();
                    } else {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i2 = zipInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        } else {
                            bufferedOutputStream.write(bArr, 0, i2);
                        }
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                }
            }
        }
    }
}
