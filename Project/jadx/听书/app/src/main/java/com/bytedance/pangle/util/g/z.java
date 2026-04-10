package com.bytedance.pangle.util.g;

import com.bytedance.pangle.util.e;
import com.bytedance.pangle.util.fo;
import com.bytedance.pangle.util.g.g.a;
import com.bytedance.pangle.util.g.g.dl;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private final com.bytedance.pangle.util.g.z.g g = new com.bytedance.pangle.util.g.z.g();
    private final a z;

    public z(a aVar) {
        this.z = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0115 A[Catch: all -> 0x013a, TryCatch #4 {all -> 0x013a, blocks: (B:24:0x00c8, B:26:0x012a, B:25:0x0115), top: B:61:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(boolean r24, boolean r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.g.z.z(boolean, boolean):void");
    }

    private boolean z(dl dlVar, boolean z, boolean z2) {
        if (z) {
            if (fo.m() && dlVar.wp().equals("classes.dex")) {
                return false;
            }
            if (dlVar.wp().startsWith("classes") && dlVar.wp().endsWith(".dex")) {
                return true;
            }
        }
        return z2 && dlVar.wp().startsWith("lib/") && dlVar.wp().endsWith(".so");
    }

    void z(File file) throws ZipException {
        if (file.exists() && !file.delete()) {
            throw new ZipException("Could not delete temporary file");
        }
    }

    void z(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j, long j2, String str) throws IOException {
        e.z(randomAccessFile, randomAccessFile2, j, j + j2, str);
    }

    private void z(File file, File file2) throws ZipException {
        if (!file2.renameTo(file)) {
            throw new ZipException("cannot rename modified zip file");
        }
    }
}
