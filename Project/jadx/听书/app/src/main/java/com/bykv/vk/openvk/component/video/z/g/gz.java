package com.bykv.vk.openvk.component.video.z.g;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
class gz {
    private final RandomAccessFile z;

    gz(File file, String str) throws z {
        try {
            this.z = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new z(e);
        }
    }

    void z(long j) throws z {
        try {
            this.z.seek(j);
        } catch (IOException e) {
            throw new z(e);
        }
    }

    void z(byte[] bArr, int i, int i2) throws z {
        try {
            this.z.write(bArr, i, i2);
        } catch (IOException e) {
            throw new z(e);
        }
    }

    int z(byte[] bArr) throws z {
        try {
            return this.z.read(bArr);
        } catch (IOException e) {
            throw new z(e);
        }
    }

    void z() {
        com.bykv.vk.openvk.component.video.z.dl.z.z(this.z);
    }

    static class z extends Exception {
        z(Throwable th) {
            super(th);
        }
    }
}
