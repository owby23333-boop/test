package com.bumptech.glide.l;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: ActivityFragmentLifecycle.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements l {
    private final Set<m> a = Collections.newSetFromMap(new WeakHashMap());
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13382c;

    a() {
    }

    @Override // com.bumptech.glide.l.l
    public void a(@NonNull m mVar) {
        this.a.remove(mVar);
    }

    @Override // com.bumptech.glide.l.l
    public void b(@NonNull m mVar) {
        this.a.add(mVar);
        if (this.f13382c) {
            mVar.onDestroy();
        } else if (this.b) {
            mVar.onStart();
        } else {
            mVar.onStop();
        }
    }

    void c() {
        this.b = false;
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStop();
        }
    }

    void a() {
        this.f13382c = true;
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onDestroy();
        }
    }

    void b() {
        this.b = true;
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStart();
        }
    }
}
