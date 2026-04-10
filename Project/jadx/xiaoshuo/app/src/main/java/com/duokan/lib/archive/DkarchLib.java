package com.duokan.lib.archive;

import android.content.Context;
import androidx.annotation.NonNull;
import com.yuewen.ir0;
import com.yuewen.qt1;
import java.io.File;

/* JADX INFO: loaded from: classes12.dex */
public class DkarchLib extends ir0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3754a = "DkarchLib";

    public static void a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        if (new File(str2).canWrite()) {
            extract(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (qt1.g()) {
            qt1.d(f3754a, "-->extractInternalFile(): archPath=" + str + ", extPath=" + str2);
        }
        extract(str, str2);
    }

    private static native void extract(String str, String str2);
}
