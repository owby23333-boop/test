package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class au {
    private static String azh;
    private static File azi;

    private static boolean Ek() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return false;
        }
    }

    private static String cP(Context context) {
        if (!TextUtils.isEmpty(azh)) {
            return azh;
        }
        String path = null;
        if (Ek()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    path = externalFilesDir.getPath();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        if (TextUtils.isEmpty(path)) {
            path = context.getFilesDir().getPath();
        }
        String str = path + File.separator + "ksadsdk";
        azh = str;
        return str;
    }

    public static File cQ(Context context) {
        File file = azi;
        if (file != null) {
            return file;
        }
        String path = null;
        if (Ek()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    path = externalCacheDir.getPath();
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
            }
        }
        if (TextUtils.isEmpty(path)) {
            path = context.getCacheDir().getPath();
        }
        File file2 = new File(path + File.separator + "ksadsdk");
        azi = file2;
        if (!file2.exists()) {
            azi.mkdirs();
        }
        return azi;
    }

    public static File cR(Context context) {
        File file = new File(cP(context) + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cS(Context context) {
        File file = new File(cP(context) + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cT(Context context) {
        String strCP;
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            strCP = cP(context);
        } else {
            strCP = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(strCP + File.separator + "ksadlog");
    }

    public static String cU(Context context) {
        if (context == null) {
            return "";
        }
        return context.getFilesDir().getPath() + File.separator + "ksadsdk";
    }

    public static String cV(Context context) {
        return cQ(context).getPath() + "/cookie";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        return cU(context) + File.separator + "ksad/download/js" + File.separator + str;
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        return cU(context) + File.separator + "ksad/download/js";
    }
}
