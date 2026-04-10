package com.kwad.sdk.utils;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ap {
    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }

    public static boolean T(List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static boolean L(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean a(Object obj, Object obj2) {
        return obj != null && obj.equals(obj2);
    }
}
