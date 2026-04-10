package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class h {
    private static File Zq;

    private static File aB(Context context) {
        if (Zq == null) {
            Zq = d(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return Zq;
    }

    static void c(File file) {
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
                c(file2);
            }
        }
        file.delete();
    }

    private static File d(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if ((file.exists() && file.isDirectory()) || !com.kwad.sdk.api.a.bI.booleanValue()) {
            return file;
        }
        throw new RuntimeException("Can not ensureDir:" + file);
    }

    static void e(File file) {
        try {
            c(file);
        } catch (Exception unused) {
        }
    }

    static File k(Context context, String str) {
        return new File(aB(context), "dynamic-" + System.currentTimeMillis() + "-" + str + com.anythink.china.common.a.a.f6395g);
    }

    static String l(Context context, String str) {
        return d(new File(aB(context), "apk-" + str)).getPath();
    }

    static File m(Context context, String str) {
        return d(new File(aB(context), "apk-" + str));
    }

    static String n(Context context, String str) {
        return new File(l(context, str), "dynamic.apk").getPath();
    }

    static String o(Context context, String str) {
        return d(new File(l(context, str), "dex")).getPath();
    }

    static String p(Context context, String str) {
        return d(new File(l(context, str), "libs")).getPath();
    }

    static void q(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.kwai.a.submit(new Runnable() { // from class: com.kwad.sdk.api.loader.h.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    File[] fileArrListFiles = h.m(context, str).getParentFile().listFiles();
                    if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                        return;
                    }
                    for (File file : fileArrListFiles) {
                        if (g.q(str, file.getName().substring(file.getName().indexOf("-") + 1))) {
                            h.c(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
