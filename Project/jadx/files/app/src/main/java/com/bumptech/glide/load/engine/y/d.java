package com.bumptech.glide.load.engine.y;

import com.bumptech.glide.load.engine.y.a;
import java.io.File;

/* JADX INFO: compiled from: DiskLruCacheFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements a.InterfaceC0261a {
    private final long a;
    private final a b;

    /* JADX INFO: compiled from: DiskLruCacheFactory.java */
    public interface a {
        File a();
    }

    public d(a aVar, long j2) {
        this.a = j2;
        this.b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.y.a.InterfaceC0261a
    public com.bumptech.glide.load.engine.y.a build() {
        File fileA = this.b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.isDirectory() || fileA.mkdirs()) {
            return e.a(fileA, this.a);
        }
        return null;
    }
}
