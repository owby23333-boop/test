package com.mipay.imageloadhelper.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes17.dex */
public class CacheManager {
    private static final String TAG = "CacheManager";

    public static class CacheTaskManager {
        private static final Object MARK_OBJECT = new Object();
        private static ConcurrentHashMap<String, Object> sRunningTaskMap = new ConcurrentHashMap<>();

        private CacheTaskManager() {
        }

        public static boolean isRunning(String str) {
            return sRunningTaskMap.contains(str);
        }

        public static void markRunning(String str) {
            if (sRunningTaskMap.containsKey(str)) {
                return;
            }
            sRunningTaskMap.put(str, MARK_OBJECT);
        }

        public static void unMarkRunning(String str) {
            if (sRunningTaskMap.contains(str)) {
                sRunningTaskMap.remove(str);
            }
        }
    }

    private static DiskCache getDiskCache(Context context) {
        return DiskCache.getInstance(context);
    }

    public static Bitmap getFromCache(Context context, String str) {
        Bitmap cache;
        Bitmap cache2;
        MemoryCache memoryCache = getMemoryCache();
        if (memoryCache != null && memoryCache.isCacheAvailable() && (cache2 = memoryCache.getCache(str)) != null) {
            return cache2;
        }
        DiskCache diskCache = getDiskCache(context);
        if (diskCache == null || !diskCache.isCacheAvailable() || (cache = diskCache.getCache(str)) == null) {
            return null;
        }
        if (memoryCache != null && memoryCache.isCacheAvailable()) {
            memoryCache.putCache(str, cache);
        }
        return cache;
    }

    private static MemoryCache getMemoryCache() {
        return MemoryCache.getInstance();
    }

    public static void saveCache(Context context, String str, Bitmap bitmap) {
        if (CacheTaskManager.isRunning(str)) {
            Log.d(TAG, "url is saving cache");
            return;
        }
        CacheTaskManager.markRunning(str);
        MemoryCache memoryCache = getMemoryCache();
        if (memoryCache != null && memoryCache.isCacheAvailable() && memoryCache.getCache(str) == null) {
            memoryCache.putCache(str, bitmap);
        }
        DiskCache diskCache = getDiskCache(context);
        if (diskCache != null && diskCache.isCacheAvailable() && diskCache.getCache(str) == null) {
            diskCache.putCache(str, bitmap);
        }
        CacheTaskManager.unMarkRunning(str);
    }
}
