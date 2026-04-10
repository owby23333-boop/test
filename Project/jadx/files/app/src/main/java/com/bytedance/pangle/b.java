package com.bytedance.pangle;

import android.os.Build;
import com.bytedance.pangle.flipped.FlippedV2Impl;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static void a() {
        com.bytedance.pangle.flipped.c bVar;
        int i2 = Build.VERSION.SDK_INT;
        boolean z2 = false;
        if (i2 >= 30 || (i2 == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
            bVar = new FlippedV2Impl();
        } else {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28 || (i3 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                z2 = true;
            }
            bVar = z2 ? new com.bytedance.pangle.flipped.b() : new com.bytedance.pangle.flipped.a();
        }
        bVar.invokeHiddenApiRestrictions();
    }
}
