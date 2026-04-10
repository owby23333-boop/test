package com.bytedance.sdk.component.utils;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zk {
    public static boolean bf(List<?> list) {
        return !e(list);
    }

    public static boolean e(List<?> list) {
        return list == null || list.size() == 0;
    }
}
