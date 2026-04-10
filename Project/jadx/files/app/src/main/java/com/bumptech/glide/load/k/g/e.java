package com.bumptech.glide.load.k.g;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.o;

/* JADX INFO: compiled from: GifDrawableResource.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends com.bumptech.glide.load.k.e.c<c> implements o {
    public e(c cVar) {
        super(cVar);
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Class<c> a() {
        return c.class;
    }

    @Override // com.bumptech.glide.load.k.e.c, com.bumptech.glide.load.engine.o
    public void b() {
        ((c) this.f13713s).c().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.s
    public int getSize() {
        return ((c) this.f13713s).f();
    }

    @Override // com.bumptech.glide.load.engine.s
    public void recycle() {
        ((c) this.f13713s).stop();
        ((c) this.f13713s).g();
    }
}
