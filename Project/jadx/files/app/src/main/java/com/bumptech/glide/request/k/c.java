package com.bumptech.glide.request.k;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.l;

/* JADX INFO: compiled from: CustomTarget.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> implements j<T> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f13862s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f13863t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private com.bumptech.glide.request.e f13864u;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.k.j
    public void a(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.k.j
    public final void a(@Nullable com.bumptech.glide.request.e eVar) {
        this.f13864u = eVar;
    }

    @Override // com.bumptech.glide.request.k.j
    public final void a(@NonNull i iVar) {
    }

    @Override // com.bumptech.glide.request.k.j
    public final void b(@NonNull i iVar) {
        iVar.a(this.f13862s, this.f13863t);
    }

    @Override // com.bumptech.glide.request.k.j
    public void c(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.l.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.l.m
    public void onStart() {
    }

    @Override // com.bumptech.glide.l.m
    public void onStop() {
    }

    public c(int i2, int i3) {
        if (l.b(i2, i3)) {
            this.f13862s = i2;
            this.f13863t = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }

    @Override // com.bumptech.glide.request.k.j
    @Nullable
    public final com.bumptech.glide.request.e a() {
        return this.f13864u;
    }
}
