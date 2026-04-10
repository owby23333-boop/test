package com.efs.sdk.base.core.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f1583a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f1583a)) {
            synchronized (d.class) {
                if (TextUtils.isEmpty(f1583a)) {
                    String strB = b(context);
                    f1583a = strB;
                    if (TextUtils.isEmpty(strB)) {
                        f1583a = c(context);
                    }
                }
            }
        }
        return f1583a;
    }

    private static String b(Context context) {
        try {
            File file = new File(a.a(context), "efsid");
            if (file.exists()) {
                return b.a(file);
            }
            return null;
        } catch (Exception e) {
            Log.e("efs.base", "get uuid error", e);
            return null;
        }
    }

    private static String c(Context context) {
        String string = "";
        for (int i = 0; i < 3; i++) {
            try {
                string = UUID.randomUUID().toString();
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(string)) {
            }
        }
        try {
            File fileA = a.a(context);
            File file = new File(fileA, "efsid" + Process.myPid());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            b.a(file, string);
            if (file.renameTo(new File(fileA, "efsid"))) {
                file.delete();
            }
        } catch (Exception e) {
            Log.e("efs.base", "save uuid '" + string + "' error", e);
        }
        return string;
    }
}
