package com.bumptech.glide.load.k.d;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.k;

/* JADX INFO: compiled from: BytesResource.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements s<byte[]> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final byte[] f13711s;

    public b(byte[] bArr) {
        k.a(bArr);
        this.f13711s = bArr;
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Class<byte[]> a() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.s
    public int getSize() {
        return this.f13711s.length;
    }

    @Override // com.bumptech.glide.load.engine.s
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public byte[] get() {
        return this.f13711s;
    }
}
