package com.bytedance.sdk.component.m.dl.z;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.m.g, Cloneable {
    private static volatile com.bytedance.sdk.component.m.g e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f770a;
    private int dl;
    private int g;
    private boolean gc;
    private File m;
    private long z;

    @Override // com.bytedance.sdk.component.m.g
    public boolean isQueryAll() {
        return true;
    }

    public z(int i, long j, File file) {
        this(i, 0, j, i != 0, j != 0, file);
    }

    public z(int i, int i2, long j, boolean z, boolean z2, File file) {
        this.z = j;
        this.g = i;
        this.dl = i2;
        this.f770a = z;
        this.gc = z2;
        this.m = file;
    }

    @Override // com.bytedance.sdk.component.m.g
    public long getFileCacheSize() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.m.g
    public int getMemoryCacheSize() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.m.g
    public boolean isMemoryCache() {
        return this.f770a;
    }

    @Override // com.bytedance.sdk.component.m.g
    public boolean isDiskCache() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.component.m.g
    public File getCacheDir() {
        return this.m;
    }

    @Override // com.bytedance.sdk.component.m.g
    public boolean isRawMemoryCache() {
        return this.dl > 0;
    }

    @Override // com.bytedance.sdk.component.m.g
    public int getRawMemoryCacheSize() {
        return this.dl;
    }

    public static void z(Context context, com.bytedance.sdk.component.m.g gVar) {
        if (gVar != null) {
            e = gVar;
        } else {
            e = z(new File(com.bytedance.sdk.openadsdk.api.plugin.g.g(context), "image"));
        }
    }

    public static com.bytedance.sdk.component.m.g z(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (e == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 10485760);
            jMin = Math.min(g() / 16, 31457280L);
        } else {
            iMin = Math.min(e.getMemoryCacheSize() / 2, 10485760);
            jMin = Math.min(e.getFileCacheSize() / 2, 31457280L);
        }
        return new z(Math.max(iMin, AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE), Math.max(jMin, 10485760L), file);
    }

    public static com.bytedance.sdk.component.m.g z() {
        return e;
    }

    private static long g() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
