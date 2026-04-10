package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class be {
    private static String ban;
    private static File bao;

    private static boolean Rv() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static String dD(Context context) {
        if (!TextUtils.isEmpty(ban)) {
            return ban;
        }
        String path = null;
        if (Rv()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    path = externalFilesDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(path)) {
            path = context.getFilesDir().getPath();
        }
        String str = path + File.separator + "ksadsdk";
        ban = str;
        return str;
    }

    public static File dE(Context context) {
        File file = bao;
        if (file != null) {
            return file;
        }
        String path = null;
        if (Rv()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    path = externalCacheDir.getPath();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (TextUtils.isEmpty(path)) {
            path = context.getCacheDir().getPath();
        }
        File file2 = new File(path + File.separator + "ksadsdk");
        bao = file2;
        if (!file2.exists()) {
            bao.mkdirs();
        }
        return bao;
    }

    public static File dF(Context context) {
        File file = new File(dD(context) + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File dG(Context context) {
        File file = new File(dD(context) + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File dH(Context context) {
        String strDD;
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            strDD = dD(context);
        } else {
            strDD = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(strDD + File.separator + "ksadlog");
    }

    public static String dI(Context context) {
        File filesDir;
        return (context == null || (filesDir = context.getFilesDir()) == null) ? "" : filesDir.getPath() + File.separator + "ksadsdk";
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        return dI(context) + File.separator + "ksad/download/js";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        return dI(context) + File.separator + "ksad/download/js" + File.separator + str;
    }

    public static String dJ(Context context) {
        return dE(context).getPath() + "/cookie";
    }
}
