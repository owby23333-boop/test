package com.anythink.expressad.exoplayer.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
final class ab implements k {
    private final Handler a;

    public ab(Handler handler) {
        this.a = handler;
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final Looper a() {
        return this.a.getLooper();
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean b(int i2) {
        return this.a.sendEmptyMessage(i2);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final Message a(int i2) {
        return this.a.obtainMessage(i2);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final void b() {
        this.a.removeMessages(2);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final Message a(int i2, Object obj) {
        return this.a.obtainMessage(i2, obj);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final Message a(int i2, int i3) {
        return this.a.obtainMessage(i2, i3, 0);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final Message a(int i2, int i3, Object obj) {
        return this.a.obtainMessage(0, i2, i3, obj);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean a(long j2) {
        return this.a.sendEmptyMessageAtTime(2, j2);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final void a(Object obj) {
        this.a.removeCallbacksAndMessages(obj);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean a(Runnable runnable) {
        return this.a.post(runnable);
    }

    @Override // com.anythink.expressad.exoplayer.k.k
    public final boolean a(Runnable runnable, long j2) {
        return this.a.postDelayed(runnable, j2);
    }
}
