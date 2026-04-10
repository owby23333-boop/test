package com.bykv.vk.openvk.component.video.z.gc;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static long z(String str, String str2) {
        File fileDl = dl(str, str2);
        if (fileDl.exists()) {
            return fileDl.length();
        }
        File fileG = g(str, str2);
        if (fileG.exists()) {
            return fileG.length();
        }
        return 0L;
    }

    public static File g(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static File dl(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static boolean z(RandomAccessFile randomAccessFile, byte[] bArr, long j, int i) throws IOException {
        try {
            randomAccessFile.seek(j);
            randomAccessFile.write(bArr, 0, i);
            return true;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.z("VideoFilesUtils", "append failed", th);
            return false;
        }
    }
}
