package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ag {
    public static boolean F(@Nullable List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
