package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
final class j {
    private static File aug;
    private static final String auh;

    static {
        auh = Ax() ? "dynamic_apk" : "dynamic.apk";
    }

    private static boolean Ax() {
        return Build.VERSION.SDK_INT == 30 || Build.VERSION.SDK_INT == 31 || Build.VERSION.SDK_INT == 32;
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!(file.exists() && file.isDirectory()) && com.kwad.sdk.api.a.oz.booleanValue()) {
            throw new RuntimeException("Can not ensureDir:" + file);
        }
        return file;
    }

    private static File ba(Context context) {
        if (aug == null) {
            aug = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return aug;
    }

    static File s(Context context, String str) {
        return new File(ba(context), "dynamic-" + System.currentTimeMillis() + "-" + str + ".apk");
    }

    static String t(Context context, String str) {
        return i(new File(ba(context), "apk-" + str)).getPath();
    }

    static File u(Context context, String str) {
        return i(new File(ba(context), "apk-" + str));
    }

    static String v(Context context, String str) {
        return new File(t(context, str), auh).getPath();
    }

    static String w(Context context, String str) {
        return i(new File(t(context, str), "dex")).getPath();
    }

    static String x(Context context, String str) {
        return i(new File(t(context, str), "libs")).getPath();
    }

    static void h(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                h(file2);
            }
        }
        file.delete();
    }

    static void j(File file) {
        try {
            h(file);
        } catch (Exception unused) {
        }
    }

    static void y(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.j.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    File[] fileArrListFiles = j.u(context, str).getParentFile().listFiles();
                    if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                        return;
                    }
                    for (File file : fileArrListFiles) {
                        if (i.L(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            j.h(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
