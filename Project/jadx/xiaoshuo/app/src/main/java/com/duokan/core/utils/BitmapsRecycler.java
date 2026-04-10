package com.duokan.core.utils;

/* JADX INFO: loaded from: classes12.dex */
public interface BitmapsRecycler {

    public enum RecycleReason {
        ApplicationExit,
        OutOfMemory,
        LowMemory
    }

    void a(RecycleReason recycleReason);
}
