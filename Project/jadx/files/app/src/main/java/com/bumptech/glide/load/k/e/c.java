package com.bumptech.glide.load.k.e;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.o;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.k;

/* JADX INFO: compiled from: DrawableResource.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T extends Drawable> implements s<T>, o {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected final T f13713s;

    public c(T t2) {
        k.a(t2);
        this.f13713s = t2;
    }

    @Override // com.bumptech.glide.load.engine.o
    public void b() {
        T t2 = this.f13713s;
        if (t2 instanceof BitmapDrawable) {
            ((BitmapDrawable) t2).getBitmap().prepareToDraw();
        } else if (t2 instanceof com.bumptech.glide.load.k.g.c) {
            ((com.bumptech.glide.load.k.g.c) t2).c().prepareToDraw();
        }
    }

    @Override // com.bumptech.glide.load.engine.s
    @NonNull
    public final T get() {
        Drawable.ConstantState constantState = this.f13713s.getConstantState();
        return constantState == null ? this.f13713s : (T) constantState.newDrawable();
    }
}
