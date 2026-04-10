package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.content.res.Resources;
import anet.channel.strategy.dispatch.DispatchConstants;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static String a = "DomainSameTool";

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID)) > 0;
        } catch (Throwable th) {
            o.b(a, th.getMessage(), th);
            return false;
        }
    }

    private static void b(Context context) {
        if (context == null) {
        }
    }
}
