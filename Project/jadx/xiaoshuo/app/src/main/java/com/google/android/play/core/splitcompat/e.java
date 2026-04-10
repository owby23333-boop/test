package com.google.android.play.core.splitcompat;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes7.dex */
final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Set f6942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f6943b;
    private final /* synthetic */ o c;
    private final /* synthetic */ d d;

    public e(d dVar, o oVar, Set set, AtomicBoolean atomicBoolean) {
        this.d = dVar;
        this.c = oVar;
        this.f6942a = set;
        this.f6943b = atomicBoolean;
    }

    @Override // com.google.android.play.core.splitcompat.i
    public final void a(ZipFile zipFile, Set<k> set) {
        this.d.a(this.c, (Set<k>) set, new f(this));
    }
}
