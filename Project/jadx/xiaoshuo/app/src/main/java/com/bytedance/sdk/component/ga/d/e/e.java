package com.bytedance.sdk.component.ga.d.e;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.sdk.component.ga.bf, Cloneable {
    private static volatile com.bytedance.sdk.component.ga.bf vn;
    private int bf;
    private boolean d;
    private long e;
    private File ga;
    private boolean tg;

    public e(int i, long j, File file) {
        this(i, j, i != 0, j != 0, file);
    }

    private static long p() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static com.bytedance.sdk.component.ga.bf vn() {
        return vn;
    }

    @Override // com.bytedance.sdk.component.ga.bf
    public int bf() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.component.ga.bf
    public boolean d() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.ga.bf
    public long e() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.ga.bf
    public File ga() {
        return this.ga;
    }

    @Override // com.bytedance.sdk.component.ga.bf
    public boolean tg() {
        return this.tg;
    }

    public e(int i, long j, boolean z, boolean z2, File file) {
        this.e = j;
        this.bf = i;
        this.d = z;
        this.tg = z2;
        this.ga = file;
    }

    public static void e(Context context, com.bytedance.sdk.component.ga.bf bfVar) {
        if (bfVar != null) {
            vn = bfVar;
        } else {
            vn = e(new File(context.getCacheDir(), "image"));
        }
    }

    public static com.bytedance.sdk.component.ga.bf e(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (vn == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 31457280);
            jMin = Math.min(p() / 16, 41943040L);
        } else {
            iMin = Math.min(vn.bf() / 2, 31457280);
            jMin = Math.min(vn.e() / 2, 41943040L);
        }
        return new e(Math.max(iMin, 26214400), Math.max(jMin, 20971520L), file);
    }
}
