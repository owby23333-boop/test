package com.bumptech.glide.l;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: RequestTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class r {
    private final Set<com.bumptech.glide.request.e> a = Collections.newSetFromMap(new WeakHashMap());
    private final Set<com.bumptech.glide.request.e> b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13399c;

    public boolean a(@Nullable com.bumptech.glide.request.e eVar) {
        boolean z2 = true;
        if (eVar == null) {
            return true;
        }
        boolean zRemove = this.a.remove(eVar);
        if (!this.b.remove(eVar) && !zRemove) {
            z2 = false;
        }
        if (z2) {
            eVar.clear();
        }
        return z2;
    }

    public void b(@NonNull com.bumptech.glide.request.e eVar) {
        this.a.add(eVar);
        if (!this.f13399c) {
            eVar.c();
            return;
        }
        eVar.clear();
        Log.isLoggable("RequestTracker", 2);
        this.b.add(eVar);
    }

    public void c() {
        this.f13399c = true;
        for (com.bumptech.glide.request.e eVar : com.bumptech.glide.util.l.a(this.a)) {
            if (eVar.isRunning() || eVar.isComplete()) {
                eVar.clear();
                this.b.add(eVar);
            }
        }
    }

    public void d() {
        this.f13399c = true;
        for (com.bumptech.glide.request.e eVar : com.bumptech.glide.util.l.a(this.a)) {
            if (eVar.isRunning()) {
                eVar.pause();
                this.b.add(eVar);
            }
        }
    }

    public void e() {
        for (com.bumptech.glide.request.e eVar : com.bumptech.glide.util.l.a(this.a)) {
            if (!eVar.isComplete() && !eVar.b()) {
                eVar.clear();
                if (this.f13399c) {
                    this.b.add(eVar);
                } else {
                    eVar.c();
                }
            }
        }
    }

    public void f() {
        this.f13399c = false;
        for (com.bumptech.glide.request.e eVar : com.bumptech.glide.util.l.a(this.a)) {
            if (!eVar.isComplete() && !eVar.isRunning()) {
                eVar.c();
            }
        }
        this.b.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.f13399c + "}";
    }

    public void a() {
        Iterator it = com.bumptech.glide.util.l.a(this.a).iterator();
        while (it.hasNext()) {
            a((com.bumptech.glide.request.e) it.next());
        }
        this.b.clear();
    }

    public boolean b() {
        return this.f13399c;
    }
}
