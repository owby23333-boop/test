package com.bytedance.adsdk.lottie.dl;

import android.util.Pair;
import com.funny.audio.core.utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private final gc z;

    public e(gc gcVar) {
        this.z = gcVar;
    }

    Pair<dl, InputStream> z(String str) {
        dl dlVar;
        try {
            File fileG = g(str);
            if (fileG == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileG);
            if (fileG.getAbsolutePath().endsWith(".zip")) {
                dlVar = dl.ZIP;
            } else {
                dlVar = dl.JSON;
            }
            com.bytedance.adsdk.lottie.gc.gc.z("Cache hit for " + str + " at " + fileG.getAbsolutePath());
            return new Pair<>(dlVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    File z(String str, InputStream inputStream, dl dlVar) throws IOException {
        File file = new File(z(), z(str, dlVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    void z(String str, dl dlVar) {
        File file = new File(z(), z(str, dlVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        com.bytedance.adsdk.lottie.gc.gc.z("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.bytedance.adsdk.lottie.gc.gc.g("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + FileUtils.FILE_EXTENSION_SEPARATOR);
    }

    private File g(String str) throws FileNotFoundException {
        File file = new File(z(), z(str, dl.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(z(), z(str, dl.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File z() {
        File fileZ = this.z.z();
        if (fileZ.isFile()) {
            fileZ.delete();
        }
        if (!fileZ.exists()) {
            fileZ.mkdirs();
        }
        return fileZ;
    }

    private static String z(String str, dl dlVar, boolean z) {
        return "lottie_cache_" + str.replaceAll("\\W+", "") + (z ? dlVar.z() : dlVar.dl);
    }
}
