package com.bumptech.glide.request.k;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.l.d;

/* JADX INFO: compiled from: ImageViewTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f<Z> extends k<ImageView, Z> implements d.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private Animatable f13875y;

    public f(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.k.k, com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    public void a(@Nullable Drawable drawable) {
        super.a(drawable);
        c((Object) null);
        d(drawable);
    }

    protected abstract void a(@Nullable Z z2);

    @Override // com.bumptech.glide.request.l.d.a
    @Nullable
    public Drawable b() {
        return ((ImageView) this.f13879s).getDrawable();
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    public void c(@Nullable Drawable drawable) {
        super.c(drawable);
        c((Object) null);
        d(drawable);
    }

    @Override // com.bumptech.glide.request.l.d.a
    public void d(Drawable drawable) {
        ((ImageView) this.f13879s).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.l.m
    public void onStart() {
        Animatable animatable = this.f13875y;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.l.m
    public void onStop() {
        Animatable animatable = this.f13875y;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // com.bumptech.glide.request.k.k, com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        Animatable animatable = this.f13875y;
        if (animatable != null) {
            animatable.stop();
        }
        c((Object) null);
        d(drawable);
    }

    private void c(@Nullable Z z2) {
        a(z2);
        b(z2);
    }

    @Override // com.bumptech.glide.request.k.j
    public void a(@NonNull Z z2, @Nullable com.bumptech.glide.request.l.d<? super Z> dVar) {
        if (dVar != null && dVar.a(z2, this)) {
            b(z2);
        } else {
            c(z2);
        }
    }

    private void b(@Nullable Z z2) {
        if (z2 instanceof Animatable) {
            this.f13875y = (Animatable) z2;
            this.f13875y.start();
        } else {
            this.f13875y = null;
        }
    }
}
