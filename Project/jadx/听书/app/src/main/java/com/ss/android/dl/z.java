package com.ss.android.dl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes4.dex */
public class z implements g {
    private final RandomAccessFile z;

    public z(File file) throws FileNotFoundException {
        this.z = new RandomAccessFile(file, "r");
    }

    @Override // com.ss.android.dl.g
    public long z() throws IOException {
        return this.z.length();
    }

    @Override // com.ss.android.dl.g
    public int z(byte[] bArr, int i, int i2) throws IOException {
        return this.z.read(bArr, i, i2);
    }

    @Override // com.ss.android.dl.g
    public void z(long j, long j2) throws IOException {
        this.z.seek(j);
    }

    @Override // com.ss.android.dl.g
    public void g() throws IOException {
        this.z.close();
    }
}
