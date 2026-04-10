package com.bytedance.adsdk.lottie.tg;

import android.util.Pair;
import com.alibaba.android.arouter.utils.Consts;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import com.dangdang.reader.utils.DangdangFileManager;
import com.yuewen.t50;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class p {
    private final ga e;

    public p(ga gaVar) {
        this.e = gaVar;
    }

    private File bf(String str) throws FileNotFoundException {
        File file = new File(e(), e(str, d.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(e(), e(str, d.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    @WorkerThread
    public Pair<d, InputStream> e(String str) {
        try {
            File fileBf = bf(str);
            if (fileBf == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileBf);
            d dVar = fileBf.getAbsolutePath().endsWith(DangdangFileManager.FONT_EXTEN) ? d.ZIP : d.JSON;
            com.bytedance.adsdk.lottie.vn.tg.e("Cache hit for " + str + " at " + fileBf.getAbsolutePath());
            return new Pair<>(dVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public File e(String str, InputStream inputStream, d dVar) throws IOException {
        File file = new File(e(), e(str, dVar, true));
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

    public void e(String str, d dVar) {
        File file = new File(e(), e(str, dVar, true));
        File file2 = new File(file.getAbsolutePath().replace(t50.f17863a, ""));
        boolean zRenameTo = file.renameTo(file2);
        com.bytedance.adsdk.lottie.vn.tg.e("Copying temp file to real file (" + file2 + ")");
        if (zRenameTo) {
            return;
        }
        com.bytedance.adsdk.lottie.vn.tg.bf("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + Consts.DOT);
    }

    private File e() {
        File fileE = this.e.e();
        if (fileE.isFile()) {
            fileE.delete();
        }
        if (!fileE.exists()) {
            fileE.mkdirs();
        }
        return fileE;
    }

    private static String e(String str, d dVar, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? dVar.e() : dVar.d);
        return sb.toString();
    }
}
