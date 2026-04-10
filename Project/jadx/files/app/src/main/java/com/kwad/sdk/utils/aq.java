package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.api.core.ResContext;

/* JADX INFO: loaded from: classes3.dex */
public final class aq {
    public static int ao(Context context, String str) {
        Resources resourcesCA = cA(context);
        if (resourcesCA == null) {
            resourcesCA = context.getResources();
        }
        return resourcesCA.getIdentifier(str, com.anythink.expressad.foundation.h.i.f10645c, context.getPackageName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public static Resources cA(Context context) {
        if (context == null) {
            return null;
        }
        Object applicationContext = context.getApplicationContext();
        boolean z2 = applicationContext instanceof ResContext;
        ?? delegatedContext = applicationContext;
        if (z2) {
            delegatedContext = ((ResContext) applicationContext).getDelegatedContext();
        }
        return delegatedContext.getResources();
    }
}
