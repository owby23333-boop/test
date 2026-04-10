package com.kwad.sdk.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class u {
    private static String gO(String str) {
        return bo.h("kssdk_api_pref", str, "");
    }

    public static String aX(Context context) {
        return gO("curversion");
    }
}
