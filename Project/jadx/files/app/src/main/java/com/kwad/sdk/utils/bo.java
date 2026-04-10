package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class bo {
    /* JADX WARN: Multi-variable type inference failed */
    public static Context dt(Context context) {
        Context applicationContext = Wrapper.unwrapContextIfNeed(context).getApplicationContext();
        return applicationContext instanceof ResContext ? ((ResContext) applicationContext).getDelegatedContext().getApplicationContext() : applicationContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static Activity du(@Nullable Context context) {
        boolean z2 = context instanceof ResContext;
        Object delegatedContext = context;
        if (z2) {
            delegatedContext = ((ResContext) context).getDelegatedContext();
        }
        if (delegatedContext instanceof Activity) {
            return (Activity) delegatedContext;
        }
        com.kwad.sdk.core.b.b.we();
        return com.kwad.sdk.core.b.b.getCurrentActivity();
    }
}
