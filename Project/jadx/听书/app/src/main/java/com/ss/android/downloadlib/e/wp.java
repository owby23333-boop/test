package com.ss.android.downloadlib.e;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class wp {

    private static class z {
        private static wp z = new wp();
    }

    public static wp z() {
        return z.z;
    }

    private wp() {
    }

    public void z(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String.format("sdk:%s.%s:", str, str2);
    }

    public void g(String str, String str2, String str3) {
        com.bytedance.sdk.component.utils.wp.a("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }
}
