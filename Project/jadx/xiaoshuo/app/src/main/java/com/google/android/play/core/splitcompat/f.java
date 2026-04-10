package com.google.android.play.core.splitcompat;

import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
final class f implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ e f6944a;

    public f(e eVar) {
        this.f6944a = eVar;
    }

    @Override // com.google.android.play.core.splitcompat.j
    public final void a(k kVar, File file, boolean z) {
        this.f6944a.f6942a.add(file);
        if (z) {
            return;
        }
        this.f6944a.f6943b.set(false);
    }
}
