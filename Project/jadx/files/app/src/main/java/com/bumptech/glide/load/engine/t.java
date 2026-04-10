package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.j.n;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: ResourceCacheGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
class t implements e, d.a<Object> {
    private File A;
    private u B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final e.a f13585s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final f<?> f13586t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f13587u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f13588v = -1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.bumptech.glide.load.c f13589w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private List<com.bumptech.glide.load.j.n<File, ?>> f13590x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f13591y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile n.a<?> f13592z;

    t(f<?> fVar, e.a aVar) {
        this.f13586t = fVar;
        this.f13585s = aVar;
    }

    private boolean b() {
        return this.f13591y < this.f13590x.size();
    }

    @Override // com.bumptech.glide.load.engine.e
    public boolean a() {
        com.bumptech.glide.util.m.b.a("ResourceCacheGenerator.startNext");
        try {
            List<com.bumptech.glide.load.c> listC = this.f13586t.c();
            boolean z2 = false;
            if (listC.isEmpty()) {
                return false;
            }
            List<Class<?>> listK = this.f13586t.k();
            if (listK.isEmpty()) {
                if (File.class.equals(this.f13586t.m())) {
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.f13586t.h() + " to " + this.f13586t.m());
            }
            while (true) {
                if (this.f13590x != null && b()) {
                    this.f13592z = null;
                    while (!z2 && b()) {
                        List<com.bumptech.glide.load.j.n<File, ?>> list = this.f13590x;
                        int i2 = this.f13591y;
                        this.f13591y = i2 + 1;
                        this.f13592z = list.get(i2).a(this.A, this.f13586t.n(), this.f13586t.f(), this.f13586t.i());
                        if (this.f13592z != null && this.f13586t.c(this.f13592z.f13681c.a())) {
                            this.f13592z.f13681c.a(this.f13586t.j(), this);
                            z2 = true;
                        }
                    }
                    return z2;
                }
                this.f13588v++;
                if (this.f13588v >= listK.size()) {
                    this.f13587u++;
                    if (this.f13587u >= listC.size()) {
                        return false;
                    }
                    this.f13588v = 0;
                }
                com.bumptech.glide.load.c cVar = listC.get(this.f13587u);
                Class<?> cls = listK.get(this.f13588v);
                this.B = new u(this.f13586t.b(), cVar, this.f13586t.l(), this.f13586t.n(), this.f13586t.f(), this.f13586t.b((Class) cls), cls, this.f13586t.i());
                this.A = this.f13586t.d().a(this.B);
                if (this.A != null) {
                    this.f13589w = cVar;
                    this.f13590x = this.f13586t.a(this.A);
                    this.f13591y = 0;
                }
            }
        } finally {
            com.bumptech.glide.util.m.b.a();
        }
    }

    @Override // com.bumptech.glide.load.engine.e
    public void cancel() {
        n.a<?> aVar = this.f13592z;
        if (aVar != null) {
            aVar.f13681c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(Object obj) {
        this.f13585s.a(this.f13589w, obj, this.f13592z.f13681c, DataSource.RESOURCE_DISK_CACHE, this.B);
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void a(@NonNull Exception exc) {
        this.f13585s.a(this.B, exc, this.f13592z.f13681c, DataSource.RESOURCE_DISK_CACHE);
    }
}
