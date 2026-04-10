package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Set f6953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ SplitCompat f6954b;

    public n(SplitCompat splitCompat, Set set) {
        this.f6954b = splitCompat;
        this.f6953a = set;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Iterator it = this.f6953a.iterator();
            while (it.hasNext()) {
                this.f6954b.c.f((String) it.next());
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
        }
    }
}
