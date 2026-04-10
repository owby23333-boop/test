package com.amgcyo.cuttadon.utils.otherutils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ZipUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class y0 {
    public static boolean a(String str, String str2) {
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (zipEntryNextElement.isDirectory()) {
                    new File(str2 + "/" + zipEntryNextElement.getName()).mkdirs();
                } else {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntryNextElement));
                    File file = new File(str2 + "/" + zipEntryNextElement.getName());
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = bufferedInputStream.read(bArr, 0, 4096);
                        if (i2 == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, i2);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    bufferedInputStream.close();
                }
            }
            zipFile.close();
            return true;
        } catch (Exception e2) {
            String str3 = "unzip error! zip file:" + str + " unzip to path:" + str2;
            e2.printStackTrace();
            return false;
        }
    }
}
