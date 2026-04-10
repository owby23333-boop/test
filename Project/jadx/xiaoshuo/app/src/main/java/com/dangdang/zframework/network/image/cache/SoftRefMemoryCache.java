package com.dangdang.zframework.network.image.cache;

import android.graphics.drawable.Drawable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class SoftRefMemoryCache implements IMemoryCache {
    private boolean isCleanRef = true;
    private Map<String, SoftRefDrawable> mDrawableCache = new Hashtable();
    private ReferenceQueue<Drawable> mRefQueue = new ReferenceQueue<>();

    public class CleanReferenceThread extends Thread {
        public CleanReferenceThread() {
            setName("dd[HD]-CleanReference");
        }

        private void cleanDrawables() {
            SoftRefDrawable softRefDrawable;
            Exception e;
            SoftRefDrawable softRefDrawable2 = (SoftRefDrawable) SoftRefMemoryCache.this.mRefQueue.poll();
            while (softRefDrawable2 != null) {
                try {
                    SoftRefMemoryCache.this.mDrawableCache.remove(softRefDrawable2.getKey());
                    softRefDrawable = (SoftRefDrawable) SoftRefMemoryCache.this.mRefQueue.poll();
                    try {
                        Thread.sleep(100L);
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (Exception e3) {
                    softRefDrawable = softRefDrawable2;
                    e = e3;
                }
                softRefDrawable2 = softRefDrawable;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (SoftRefMemoryCache.this.isCleanRef) {
                cleanDrawables();
                try {
                    Thread.sleep(5000L);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public SoftRefMemoryCache() {
        new CleanReferenceThread().start();
    }

    @Override // com.dangdang.zframework.network.image.cache.IMemoryCache
    public void clear() {
        this.isCleanRef = false;
        this.mDrawableCache.clear();
    }

    @Override // com.dangdang.zframework.network.image.cache.IMemoryCache
    public Drawable getDrawable(String str) {
        SoftRefDrawable softRefDrawable = this.mDrawableCache.get(str);
        if (softRefDrawable != null) {
            return softRefDrawable.get();
        }
        return null;
    }

    @Override // com.dangdang.zframework.network.image.cache.IMemoryCache
    public boolean putDrawable(String str, Drawable drawable2) {
        this.mDrawableCache.put(str, new SoftRefDrawable(drawable2, str, this.mRefQueue));
        return false;
    }

    @Override // com.dangdang.zframework.network.image.cache.IMemoryCache
    public Drawable removeDrawable(String str) {
        SoftRefDrawable softRefDrawableRemove = this.mDrawableCache.remove(str);
        if (softRefDrawableRemove != null) {
            return softRefDrawableRemove.get();
        }
        return null;
    }

    public static class SoftRefDrawable extends SoftReference<Drawable> {
        private String key;

        public SoftRefDrawable(Drawable drawable2, String str) {
            super(drawable2);
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }

        public SoftRefDrawable(Drawable drawable2, String str, ReferenceQueue<? super Drawable> referenceQueue) {
            super(drawable2, referenceQueue);
            this.key = str;
        }
    }
}
