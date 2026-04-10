package com.bykv.vk.openvk.component.video.e.ga;

import com.yuewen.t50;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static File bf(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + t50.f17863a);
    }

    public static File d(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static long e(String str, String str2) {
        File fileD = d(str, str2);
        if (fileD.exists()) {
            return fileD.length();
        }
        File fileBf = bf(str, str2);
        if (fileBf.exists()) {
            return fileBf.length();
        }
        return 0L;
    }

    public static void e(RandomAccessFile randomAccessFile, byte[] bArr, int i, int i2, String str) throws IOException {
        try {
            randomAccessFile.seek(i);
            randomAccessFile.write(bArr, 0, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
