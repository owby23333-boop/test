package com.google.android.play.core.splitcompat;

import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
final class l implements com.google.android.play.core.splitinstall.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ SplitCompat f6951a;

    public l(SplitCompat splitCompat) {
        this.f6951a = splitCompat;
    }

    @Override // com.google.android.play.core.splitinstall.e
    public final Set<String> a() {
        return this.f6951a.b();
    }
}
