package com.anythink.expressad.b;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a a;

    private a() {
    }

    private static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    private static void a(String str, String str2) throws Throwable {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            new c();
            c.a(str, str2);
            return;
        }
        throw new IOException("zipFilePath or destDirectory is null");
    }

    private void a(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            for (File file2 : file.listFiles()) {
                a(new File(file2.getAbsolutePath()));
            }
            file.delete();
        }
    }
}
