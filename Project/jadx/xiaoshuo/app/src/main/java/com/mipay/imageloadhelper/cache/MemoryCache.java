package com.mipay.imageloadhelper.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

/* JADX INFO: loaded from: classes17.dex */
public class MemoryCache implements ICache<String, Bitmap> {
    private static final int DEFAULT_MAX_MEMORY = 10240;
    private static volatile MemoryCache sMemoryCache;
    private LruCache<String, Bitmap> mImageCache;

    private MemoryCache() {
        int iMaxMemory = ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
        this.mImageCache = new LruCache<String, Bitmap>(iMaxMemory <= 0 ? 10240 : iMaxMemory) { // from class: com.mipay.imageloadhelper.cache.MemoryCache.1
            @Override // android.util.LruCache
            public int sizeOf(String str, Bitmap bitmap) {
                return bitmap.getByteCount() / 1024;
            }
        };
    }

    public static MemoryCache getInstance() {
        if (sMemoryCache == null) {
            synchronized (MemoryCache.class) {
                if (sMemoryCache == null) {
                    sMemoryCache = new MemoryCache();
                }
            }
        }
        return sMemoryCache;
    }

    @Override // com.mipay.imageloadhelper.cache.ICache
    public boolean isCacheAvailable() {
        return true;
    }

    @Override // com.mipay.imageloadhelper.cache.ICache
    public Bitmap getCache(String str) {
        return this.mImageCache.get(str);
    }

    @Override // com.mipay.imageloadhelper.cache.ICache
    public void putCache(String str, Bitmap bitmap) {
        this.mImageCache.put(str, bitmap);
    }
}
