package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ResourceCacheKey.java */
/* JADX INFO: loaded from: classes2.dex */
final class u implements com.bumptech.glide.load.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final com.bumptech.glide.util.h<Class<?>, byte[]> f13593j = new com.bumptech.glide.util.h<>(50);
    private final com.bumptech.glide.load.engine.x.b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.c f13594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.c f13595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f13597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Class<?> f13598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.load.f f13599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.i<?> f13600i;

    u(com.bumptech.glide.load.engine.x.b bVar, com.bumptech.glide.load.c cVar, com.bumptech.glide.load.c cVar2, int i2, int i3, com.bumptech.glide.load.i<?> iVar, Class<?> cls, com.bumptech.glide.load.f fVar) {
        this.b = bVar;
        this.f13594c = cVar;
        this.f13595d = cVar2;
        this.f13596e = i2;
        this.f13597f = i3;
        this.f13600i = iVar;
        this.f13598g = cls;
        this.f13599h = fVar;
    }

    private byte[] a() {
        byte[] bArrA = f13593j.a(this.f13598g);
        if (bArrA != null) {
            return bArrA;
        }
        byte[] bytes = this.f13598g.getName().getBytes(com.bumptech.glide.load.c.a);
        f13593j.b(this.f13598g, bytes);
        return bytes;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f13597f == uVar.f13597f && this.f13596e == uVar.f13596e && com.bumptech.glide.util.l.b(this.f13600i, uVar.f13600i) && this.f13598g.equals(uVar.f13598g) && this.f13594c.equals(uVar.f13594c) && this.f13595d.equals(uVar.f13595d) && this.f13599h.equals(uVar.f13599h);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        int iHashCode = (((((this.f13594c.hashCode() * 31) + this.f13595d.hashCode()) * 31) + this.f13596e) * 31) + this.f13597f;
        com.bumptech.glide.load.i<?> iVar = this.f13600i;
        if (iVar != null) {
            iHashCode = (iHashCode * 31) + iVar.hashCode();
        }
        return (((iHashCode * 31) + this.f13598g.hashCode()) * 31) + this.f13599h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f13594c + ", signature=" + this.f13595d + ", width=" + this.f13596e + ", height=" + this.f13597f + ", decodedResourceClass=" + this.f13598g + ", transformation='" + this.f13600i + "', options=" + this.f13599h + '}';
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.b.b(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f13596e).putInt(this.f13597f).array();
        this.f13595d.updateDiskCacheKey(messageDigest);
        this.f13594c.updateDiskCacheKey(messageDigest);
        messageDigest.update(bArr);
        com.bumptech.glide.load.i<?> iVar = this.f13600i;
        if (iVar != null) {
            iVar.updateDiskCacheKey(messageDigest);
        }
        this.f13599h.updateDiskCacheKey(messageDigest);
        messageDigest.update(a());
        this.b.put(bArr);
    }
}
