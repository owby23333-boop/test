package com.google.android.play.core.splitcompat;

import android.util.Log;

/* JADX INFO: loaded from: classes7.dex */
final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ SplitCompat f6952a;

    public m(SplitCompat splitCompat) {
        this.f6952a = splitCompat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f6952a.c.a();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
