package com.yuewen;

import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public class b51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f8982a = "extra_first_start";

    public static boolean a(Intent intent) {
        return intent.getBooleanExtra(f8982a, false);
    }

    public static void b(Intent intent, boolean z) {
        intent.putExtra(f8982a, z);
    }
}
