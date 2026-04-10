package com.kwad.sdk.crash.kwai;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static Context Om;
    private static String aqG;

    private static File getDataDir(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = i2 >= 24 ? context.getDataDir() : null;
        if (dataDir == null) {
            dataDir = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (!dataDir.exists()) {
                return new File("/data/data/" + context.getPackageName());
            }
        }
        return dataDir;
    }

    public static void init(@NonNull Context context, @Nullable String str) {
        Om = context;
        aqG = str;
    }

    public static boolean v(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }

    public static File zT() {
        File file = !TextUtils.isEmpty(aqG) ? new File(aqG) : new File(getDataDir(Om), "kwad_ex");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File zU() {
        return new File(zT(), "java_crash/dump");
    }

    public static File zV() {
        return new File(zT(), "anr_log/dump");
    }

    public static File zW() {
        return new File(zT(), "native_crash_log/dump");
    }
}
