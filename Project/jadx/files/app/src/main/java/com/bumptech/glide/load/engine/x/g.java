package com.bumptech.glide.load.engine.x;

/* JADX INFO: compiled from: ByteArrayAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements a<byte[]> {
    @Override // com.bumptech.glide.load.engine.x.a
    public int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.x.a
    public String getTag() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.x.a
    public int a(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.x.a
    public byte[] newArray(int i2) {
        return new byte[i2];
    }
}
