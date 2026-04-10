package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.y.a;
import java.io.File;

/* JADX INFO: compiled from: DataCacheWriter.java */
/* JADX INFO: loaded from: classes2.dex */
class d<DataType> implements a.b {
    private final com.bumptech.glide.load.a<DataType> a;
    private final DataType b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.f f13514c;

    d(com.bumptech.glide.load.a<DataType> aVar, DataType datatype, com.bumptech.glide.load.f fVar) {
        this.a = aVar;
        this.b = datatype;
        this.f13514c = fVar;
    }

    @Override // com.bumptech.glide.load.engine.y.a.b
    public boolean a(@NonNull File file) {
        return this.a.a(this.b, file, this.f13514c);
    }
}
