package com.google.android.play.core.splitcompat;

import java.util.Set;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes7.dex */
final class g implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Set f6945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ o f6946b;
    private final /* synthetic */ d c;

    public g(d dVar, Set set, o oVar) {
        this.c = dVar;
        this.f6945a = set;
        this.f6946b = oVar;
    }

    @Override // com.google.android.play.core.splitcompat.i
    public final void a(ZipFile zipFile, Set<k> set) {
        this.f6945a.addAll(this.c.a((Set<k>) set, this.f6946b, zipFile));
    }
}
