package com.bumptech.glide.l;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.l.c;

/* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
/* JADX INFO: loaded from: classes2.dex */
final class e implements c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Context f13383s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final c.a f13384t;

    e(@NonNull Context context, @NonNull c.a aVar) {
        this.f13383s = context.getApplicationContext();
        this.f13384t = aVar;
    }

    private void a() {
        s.a(this.f13383s).a(this.f13384t);
    }

    private void b() {
        s.a(this.f13383s).b(this.f13384t);
    }

    @Override // com.bumptech.glide.l.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.l.m
    public void onStart() {
        a();
    }

    @Override // com.bumptech.glide.l.m
    public void onStop() {
        b();
    }
}
