package com.dangdang.zframework.network.image.cache;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public interface IDiskCache {
    void clear();

    Drawable get(String str);

    String getDiskCacheDirPath();

    String getDiskCacheFilePath(String str);

    boolean isCached(String str);

    boolean put(String str, Drawable drawable2);

    boolean remove(String str);
}
