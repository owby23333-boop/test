package com.dangdang.zframework.network.image.cache;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public interface IMemoryCache {
    void clear();

    Drawable getDrawable(String str);

    boolean putDrawable(String str, Drawable drawable2);

    Drawable removeDrawable(String str);
}
