package com.bumptech.glide.load.k;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.k;

/* JADX INFO: compiled from: SimpleResource.java */
/* JADX INFO: loaded from: classes2.dex */
public class b<T> implements s<T> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected final T f13710s;

    public b(@NonNull T t2) {
        k.a(t2);
        this.f13710s = t2;
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Class<T> a() {
        return (Class<T>) this.f13710s.getClass();
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public final T get() {
        return this.f13710s;
    }

    @Override // com.bumptech.glide.load.engine.s
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.s
    public void recycle() {
    }
}
