package com.bytedance.pangle.util.g.z;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private final byte[] z = new byte[2];
    private final byte[] g = new byte[4];

    public int z(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.g);
        return g(this.g);
    }

    public int g(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.z);
        return z(this.z);
    }

    public void z(RandomAccessFile randomAccessFile, int i) throws IOException {
        z(this.z, i);
        randomAccessFile.write(this.z);
    }

    public void z(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        z(this.z, i);
        byteArrayOutputStream.write(this.z);
    }

    public void z(OutputStream outputStream, int i) throws IOException {
        g(this.g, i);
        outputStream.write(this.g);
    }

    private int z(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    private int g(byte[] bArr) {
        return ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16) | (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    private void z(byte[] bArr, int i) {
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }

    private void g(byte[] bArr, int i) {
        bArr[3] = (byte) (i >>> 24);
        bArr[2] = (byte) (i >>> 16);
        bArr[1] = (byte) (i >>> 8);
        bArr[0] = (byte) (i & 255);
    }
}
