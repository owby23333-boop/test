package com.baidu.tts.tools.cuid.util;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class CommonParam {
    private static final boolean DEBUG = false;
    private static final String TAG = "CommonParam";

    @Deprecated
    public static String getCUID(Context context) {
        return DeviceId.getCUID(context);
    }
}
