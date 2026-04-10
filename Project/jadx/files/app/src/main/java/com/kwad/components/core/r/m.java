package com.kwad.components.core.r;

import android.content.Intent;
import android.os.Bundle;
import com.kwad.sdk.api.loader.Loader;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static void e(Intent intent) {
        if (intent == null) {
            return;
        }
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        Bundle extras = intent.getExtras();
        if (externalClassLoader == null || extras == null) {
            return;
        }
        extras.setClassLoader(externalClassLoader);
    }
}
