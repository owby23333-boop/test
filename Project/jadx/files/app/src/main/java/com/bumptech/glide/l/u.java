package com.bumptech.glide.l;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: TargetTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u implements m {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.k.j<?>> f13415s = Collections.newSetFromMap(new WeakHashMap());

    public void a(@NonNull com.bumptech.glide.request.k.j<?> jVar) {
        this.f13415s.add(jVar);
    }

    public void b(@NonNull com.bumptech.glide.request.k.j<?> jVar) {
        this.f13415s.remove(jVar);
    }

    @NonNull
    public List<com.bumptech.glide.request.k.j<?>> c() {
        return com.bumptech.glide.util.l.a(this.f13415s);
    }

    @Override // com.bumptech.glide.l.m
    public void onDestroy() {
        Iterator it = com.bumptech.glide.util.l.a(this.f13415s).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.k.j) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.l.m
    public void onStart() {
        Iterator it = com.bumptech.glide.util.l.a(this.f13415s).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.k.j) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.l.m
    public void onStop() {
        Iterator it = com.bumptech.glide.util.l.a(this.f13415s).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.k.j) it.next()).onStop();
        }
    }

    public void b() {
        this.f13415s.clear();
    }
}
