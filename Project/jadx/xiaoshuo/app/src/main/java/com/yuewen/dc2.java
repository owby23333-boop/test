package com.yuewen;

import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public abstract class dc2 implements View.OnClickListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f10132b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f10133a;

    public dc2() {
        this.f10133a = 500L;
    }

    public final boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - f10132b;
        if (j > 0 && j < this.f10133a) {
            return true;
        }
        f10132b = jCurrentTimeMillis;
        return false;
    }

    public abstract void b(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (a()) {
            return;
        }
        b(view);
    }

    public dc2(long j) {
        this.f10133a = j;
    }
}
