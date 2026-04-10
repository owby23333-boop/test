package com.dangdang.zframework.network.image.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.dangdang.zframework.utils.FileUtil;
import com.dangdang.zframework.utils.MD5Util;
import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class DefaultDiskCache implements IDiskCache {
    private Context mContext;

    public DefaultDiskCache(Context context) {
        this.mContext = context;
    }

    private boolean saveFile(Bitmap bitmap, File file) {
        return saveFile(bitmap, file, Bitmap.CompressFormat.PNG, 100);
    }

    @Override // com.dangdang.zframework.network.image.cache.IDiskCache
    public void clear() {
        FileUtil.deleteCurrFile(new File(getDiskCacheDirPath()));
    }

    @Override // com.dangdang.zframework.network.image.cache.IDiskCache
    public Drawable get(String str) {
        File file = new File(getDiskCacheFilePath(str));
        if (file.exists()) {
            try {
                return Drawable.createFromPath(file.getAbsolutePath());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.dangdang.zframework.network.image.cache.IDiskCache
    public String getDiskCacheDirPath() {
        return this.mContext.getCacheDir().getAbsolutePath() + "/ImageCache/";
    }

    @Override // com.dangdang.zframework.network.image.cache.IDiskCache
    public String getDiskCacheFilePath(String str) {
        return getDiskCacheDirPath() + MD5Util.getMD5Str(str);
    }

    @Override // com.dangdang.zframework.network.image.cache.IDiskCache
    public boolean isCached(String str) {
        return new File(getDiskCacheFilePath(str)).exists();
    }

    @Override // com.dangdang.zframework.network.image.cache.IDiskCache
    public boolean put(String str, Drawable drawable2) {
        File file = new File(getDiskCacheDirPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        return saveFile(((BitmapDrawable) drawable2).getBitmap(), new File(getDiskCacheFilePath(str)));
    }

    @Override // com.dangdang.zframework.network.image.cache.IDiskCache
    public boolean remove(String str) {
        File file = new File(getDiskCacheFilePath(str));
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean saveFile(android.graphics.Bitmap r6, java.io.File r7, android.graphics.Bitmap.CompressFormat r8, int r9) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
            if (r6 == 0) goto Lb
            boolean r2 = r6.isRecycled()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            if (r2 == 0) goto Lb
            return r0
        Lb:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            r2.<init>()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            if (r6 == 0) goto L36
            r6.compress(r8, r9, r2)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L67
            byte[] r6 = r2.toByteArray()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L67
            long r8 = com.dangdang.zframework.utils.DeviceUtil.getAvailaSizeAtSdCard()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L67
            int r3 = r6.length     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L67
            long r3 = (long) r3     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L67
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 <= 0) goto L36
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L67
            r8.<init>(r7)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L67
            int r7 = r6.length     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r8.write(r6, r0, r7)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L31
            r1 = r8
            goto L36
        L2e:
            r6 = move-exception
            r1 = r8
            goto L68
        L31:
            r6 = move-exception
            r1 = r8
            goto L4f
        L34:
            r6 = move-exception
            goto L4f
        L36:
            if (r1 == 0) goto L40
            r1.close()     // Catch: java.io.IOException -> L3c
            goto L40
        L3c:
            r6 = move-exception
            r6.printStackTrace()
        L40:
            r2.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r6 = move-exception
            r6.printStackTrace()
        L48:
            r6 = 1
            return r6
        L4a:
            r6 = move-exception
            r2 = r1
            goto L68
        L4d:
            r6 = move-exception
            r2 = r1
        L4f:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L67
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.io.IOException -> L58
            goto L5c
        L58:
            r6 = move-exception
            r6.printStackTrace()
        L5c:
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r6 = move-exception
            r6.printStackTrace()
        L66:
            return r0
        L67:
            r6 = move-exception
        L68:
            if (r1 == 0) goto L72
            r1.close()     // Catch: java.io.IOException -> L6e
            goto L72
        L6e:
            r7 = move-exception
            r7.printStackTrace()
        L72:
            if (r2 == 0) goto L7c
            r2.close()     // Catch: java.io.IOException -> L78
            goto L7c
        L78:
            r7 = move-exception
            r7.printStackTrace()
        L7c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dangdang.zframework.network.image.cache.DefaultDiskCache.saveFile(android.graphics.Bitmap, java.io.File, android.graphics.Bitmap$CompressFormat, int):boolean");
    }
}
