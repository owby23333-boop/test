package com.kwad.sdk.crash.a;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.w;
import com.kwad.sdk.utils.z;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static Context aHU;
    private static String aOV;

    public static void init(Context context, String str) {
        aHU = context;
        aOV = str;
        aOV = w.P(context, "kwad_ex");
    }

    public static File LA() {
        File file;
        if (!TextUtils.isEmpty(aOV)) {
            file = new File(aOV);
        } else {
            Context contextDl = aHU;
            if (contextDl == null) {
                contextDl = ServiceProvider.Pp();
            }
            if (contextDl == null) {
                try {
                    contextDl = z.Dl();
                } catch (Throwable unused) {
                }
            }
            file = contextDl != null ? new File(getDataDir(contextDl), "kwad_ex") : null;
        }
        if (file != null && !file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File LB() {
        return new File(LA(), "java_crash/dump");
    }

    private static File getDataDir(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return new File(context.getExternalFilesDir(null).getAbsolutePath());
        }
        File dataDir = context.getDataDir();
        if (dataDir != null) {
            return dataDir;
        }
        File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
        return !file.exists() ? new File("/data/data/" + context.getPackageName()) : file;
    }

    public static File LC() {
        return new File(LA(), "anr_log/dump");
    }

    public static File LD() {
        return new File(LA(), "native_crash_log/dump");
    }

    public static boolean A(File file) {
        if (file == null) {
            return false;
        }
        return file.exists() || file.mkdirs();
    }
}
