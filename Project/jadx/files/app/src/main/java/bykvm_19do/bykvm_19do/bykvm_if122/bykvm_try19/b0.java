package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class b0 {
    private static void a(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            a(str2);
            throw null;
        }
    }
}
