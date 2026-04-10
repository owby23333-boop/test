package com.bumptech.glide.load.engine.y;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.y.h;

/* JADX INFO: compiled from: LruResourceCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bumptech.glide.util.h<com.bumptech.glide.load.c, s<?>> implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h.a f13637d;

    public g(long j2) {
        super(j2);
    }

    @Override // com.bumptech.glide.load.engine.y.h
    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i2) {
        if (i2 >= 40) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(b() / 2);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.y.h
    @Nullable
    public /* bridge */ /* synthetic */ s a(@NonNull com.bumptech.glide.load.c cVar, @Nullable s sVar) {
        return (s) super.b(cVar, sVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NonNull com.bumptech.glide.load.c cVar, @Nullable s<?> sVar) {
        h.a aVar = this.f13637d;
        if (aVar == null || sVar == null) {
            return;
        }
        aVar.a(sVar);
    }

    @Override // com.bumptech.glide.load.engine.y.h
    @Nullable
    public /* bridge */ /* synthetic */ s a(@NonNull com.bumptech.glide.load.c cVar) {
        return (s) super.c(cVar);
    }

    @Override // com.bumptech.glide.load.engine.y.h
    public void a(@NonNull h.a aVar) {
        this.f13637d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.util.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int b(@Nullable s<?> sVar) {
        if (sVar == null) {
            return super.b(null);
        }
        return sVar.getSize();
    }
}
