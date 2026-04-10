package com.bykv.vk.openvk.component.video.e.bf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
class v {
    private final RandomAccessFile e;

    public static class e extends Exception {
        public e(Throwable th) {
            super(th);
        }
    }

    public v(File file, String str) throws e {
        try {
            this.e = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e2) {
            throw new e(e2);
        }
    }

    public void e(long j) throws e {
        try {
            this.e.seek(j);
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public void e(byte[] bArr, int i, int i2) throws e {
        try {
            this.e.write(bArr, i, i2);
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public int e(byte[] bArr) throws e {
        try {
            return this.e.read(bArr);
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public void e() {
        com.bykv.vk.openvk.component.video.e.d.e.e(this.e);
    }
}
