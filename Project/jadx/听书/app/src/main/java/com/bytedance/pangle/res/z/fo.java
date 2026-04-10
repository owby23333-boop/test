package com.bytedance.pangle.res.z;

import com.google.common.base.Ascii;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class fo extends FilterInputStream implements DataInput {
    public static int z(byte b, byte b2, byte b3, byte b4) {
        return (b << Ascii.CAN) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }

    public static long z(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((((long) b2) & 255) << 48) | ((((long) b) & 255) << 56) | ((((long) b3) & 255) << 40) | ((((long) b4) & 255) << 32) | ((((long) b5) & 255) << 24) | ((((long) b6) & 255) << 16) | ((((long) b7) & 255) << 8) | (((long) b8) & 255);
    }

    public fo(gc gcVar) {
        super(gcVar);
    }

    @Override // java.io.DataInput
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        a.z(this, bArr);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        a.z(this, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return (int) this.in.skip(i);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        int i = this.in.read();
        if (i >= 0) {
            return i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return z((byte) 0, (byte) 0, g(), g());
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        byte bG = g();
        byte bG2 = g();
        return z(g(), g(), bG2, bG);
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        byte bG = g();
        byte bG2 = g();
        byte bG3 = g();
        byte bG4 = g();
        byte bG5 = g();
        byte bG6 = g();
        return z(g(), g(), bG6, bG5, bG4, bG3, bG2, bG);
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return new DataInputStream(this.in).readUTF();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return readUnsignedByte() != 0;
    }

    private byte g() throws IOException {
        int i = this.in.read();
        if (-1 != i) {
            return (byte) i;
        }
        throw new EOFException();
    }

    public gc z() {
        return (gc) this.in;
    }
}
