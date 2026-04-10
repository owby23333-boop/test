package com.ss.android.e;

import com.xiaomi.verificationsdk.internal.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes4.dex */
public class e implements bf {
    private final RandomAccessFile e;

    public e(File file) throws FileNotFoundException {
        this.e = new RandomAccessFile(file, Constants.RANDOM_LONG);
    }

    @Override // com.ss.android.e.bf
    public void bf() throws IOException {
        this.e.close();
    }

    @Override // com.ss.android.e.bf
    public long e() throws IOException {
        return this.e.length();
    }

    @Override // com.ss.android.e.bf
    public int e(byte[] bArr, int i, int i2) throws IOException {
        return this.e.read(bArr, i, i2);
    }

    @Override // com.ss.android.e.bf
    public void e(long j, long j2) throws IOException {
        this.e.seek(j);
    }
}
