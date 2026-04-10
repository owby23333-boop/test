package com.bytedance.sdk.component.m;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public interface g {
    File getCacheDir();

    long getFileCacheSize();

    int getMemoryCacheSize();

    int getRawMemoryCacheSize();

    boolean isDiskCache();

    boolean isMemoryCache();

    boolean isQueryAll();

    boolean isRawMemoryCache();
}
