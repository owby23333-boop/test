package com.bytedance.msdk.gz;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static <T> boolean z(List<T> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean g(List<T> list) {
        return list == null || list.size() == 0 || list.get(0) == null;
    }
}
