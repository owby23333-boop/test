package com.bytedance.pangle.res.z;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m implements DataInput {
    public final fo z;

    public m(fo foVar) {
        this.z = foVar;
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        return this.z.skipBytes(i);
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return this.z.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return this.z.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return this.z.readUTF();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        return this.z.readShort();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        return this.z.readLong();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        return this.z.readLine();
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        return this.z.readInt();
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.z.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        this.z.readFully(bArr);
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return this.z.readFloat();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return this.z.readDouble();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return this.z.readChar();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        return this.z.readByte();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        return this.z.readBoolean();
    }
}
