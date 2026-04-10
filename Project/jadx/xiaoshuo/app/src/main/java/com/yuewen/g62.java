package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public interface g62 {
    default boolean g3(String str) {
        return ic(str, null);
    }

    default boolean ic(String str, Runnable runnable) {
        return s7(str, null, true, runnable);
    }

    boolean s7(String str, Object obj, boolean z, Runnable runnable);
}
