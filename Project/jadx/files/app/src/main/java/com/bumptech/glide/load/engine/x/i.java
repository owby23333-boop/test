package com.bumptech.glide.load.engine.x;

/* JADX INFO: compiled from: IntegerArrayAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements a<int[]> {
    @Override // com.bumptech.glide.load.engine.x.a
    public int a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.x.a
    public String getTag() {
        return "IntegerArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.x.a
    public int a(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.x.a
    public int[] newArray(int i2) {
        return new int[i2];
    }
}
