package com.mipay.imageloadhelper.cache;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.mipay.imageloadhelper.Utils;
import com.mipay.imageloadhelper.cache.DiskLruCache;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes17.dex */
public class DiskCache implements ICache<String, Bitmap> {
    private static final int DEFAULT_MAX_MEMORY = 52428800;
    private static final String TAG = "DiskCache";
    private static volatile DiskCache sDiskCache;
    private volatile boolean mAvailable;
    private DiskLruCache mDiskImageCache;

    private DiskCache(Context context) {
        this.mAvailable = true;
        File diskCacheDir = getDiskCacheDir(context, "mibi_image_disk_cache");
        this.mAvailable = diskCacheDir != null;
        if (!this.mAvailable) {
            Log.e(TAG, "make cache dir error");
            return;
        }
        try {
            this.mDiskImageCache = DiskLruCache.open(diskCacheDir, getAppVersion(context), 1, 52428800L);
        } catch (IOException unused) {
            Log.e(TAG, "can not init disk lru cache");
            this.mAvailable = false;
        }
    }

    private static int getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e(TAG, "can not get app version");
            return 1;
        }
    }

    private static File getDiskCacheDir(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            Log.e(TAG, "default disk cache dir is null");
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    public static DiskCache getInstance(Context context) {
        if (sDiskCache == null) {
            synchronized (DiskCache.class) {
                if (sDiskCache == null) {
                    sDiskCache = new DiskCache(context.getApplicationContext());
                }
            }
        }
        return sDiskCache;
    }

    @Override // com.mipay.imageloadhelper.cache.ICache
    public boolean isCacheAvailable() {
        return this.mAvailable;
    }

    @Override // com.mipay.imageloadhelper.cache.ICache
    public Bitmap getCache(String str) {
        try {
            DiskLruCache.Snapshot snapshot = this.mDiskImageCache.get(Utils.calculateMD5key(str));
            if (snapshot == null) {
                return null;
            }
            return BitmapFactory.decodeStream(snapshot.getInputStream(0));
        } catch (IOException unused) {
            Log.e(TAG, "get cache error:" + str);
            this.mAvailable = false;
            return null;
        }
    }

    @Override // com.mipay.imageloadhelper.cache.ICache
    public void putCache(String str, Bitmap bitmap) {
        if (bitmap == null) {
            Log.e(TAG, "bitmap is null,url: " + str);
            return;
        }
        try {
            DiskLruCache.Editor editorEdit = this.mDiskImageCache.edit(Utils.calculateMD5key(str));
            if (editorEdit != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, editorEdit.newOutputStream(0));
                editorEdit.commit();
            }
            this.mDiskImageCache.flush();
        } catch (IOException unused) {
            Log.e(TAG, "put cache error:" + str);
            this.mAvailable = false;
        }
    }
}
