package com.yuewen;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class r41 {
    public static boolean a(File file, long j, long j2) {
        return file.exists() && file.lastModified() == j && file.length() == j2;
    }

    public static boolean b(String str, long j, long j2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str), j, j2);
    }
}
