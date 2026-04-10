package com.bumptech.glide.load.k.e;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.s;

/* JADX INFO: compiled from: NonOwnedDrawableResource.java */
/* JADX INFO: loaded from: classes2.dex */
final class e extends c<Drawable> {
    private e(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    static s<Drawable> a(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new e(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.s
    public int getSize() {
        return Math.max(1, this.f13713s.getIntrinsicWidth() * this.f13713s.getIntrinsicHeight() * 4);
    }

    @Override // com.bumptech.glide.load.engine.s
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public Class<Drawable> a() {
        return this.f13713s.getClass();
    }
}
