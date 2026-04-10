package com.amgcyo.cuttadon.j.f;

import android.content.Context;
import com.tencent.smtt.sdk.TbsListener;

/* JADX INFO: compiled from: OppoNotchUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static int a() {
        return 80;
    }

    public static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static int b() {
        return TbsListener.ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE;
    }
}
