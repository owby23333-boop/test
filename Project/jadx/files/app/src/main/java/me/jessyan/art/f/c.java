package me.jessyan.art.f;

import android.content.Context;
import android.os.Environment;
import java.io.File;

/* JADX INFO: compiled from: DataHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static File a(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return context.getCacheDir();
        }
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        File file = new File(b(context));
        a(file);
        return file;
    }

    public static String b(Context context) {
        return "/mnt/sdcard/" + context.getPackageName();
    }

    public static File a(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
