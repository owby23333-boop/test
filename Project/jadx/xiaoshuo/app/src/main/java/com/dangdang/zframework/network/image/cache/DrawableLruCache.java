package com.dangdang.zframework.network.image.cache;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.collection.LruCache;
import com.dangdang.zframework.log.LogM;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class DrawableLruCache extends LruCache<String, Drawable> implements IMemoryCache {
    public DrawableLruCache() {
        this(getDefaultLruCacheSize());
    }

    private static int getDefaultLruCacheSize() {
        return ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
    }

    @Override // com.dangdang.zframework.network.image.cache.IMemoryCache
    public void clear() {
        evictAll();
    }

    @Override // com.dangdang.zframework.network.image.cache.IMemoryCache
    public Drawable getDrawable(String str) {
        return get(str);
    }

    @Override // com.dangdang.zframework.network.image.cache.IMemoryCache
    public boolean putDrawable(String str, Drawable drawable2) {
        try {
            put(str, drawable2);
            return true;
        } catch (Exception e) {
            LogM.e(e.toString());
            return false;
        }
    }

    @Override // com.dangdang.zframework.network.image.cache.IMemoryCache
    public Drawable removeDrawable(String str) {
        return remove(str);
    }

    public DrawableLruCache(int i) {
        super(i);
    }

    @Override // androidx.collection.LruCache
    public int sizeOf(String str, Drawable drawable2) {
        Bitmap bitmap = ((BitmapDrawable) drawable2).getBitmap();
        return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
    }
}
