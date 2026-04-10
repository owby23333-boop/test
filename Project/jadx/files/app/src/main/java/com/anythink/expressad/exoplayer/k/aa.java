package com.anythink.expressad.exoplayer.k;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class aa implements c {
    aa() {
    }

    @Override // com.anythink.expressad.exoplayer.k.c
    public final long a() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.anythink.expressad.exoplayer.k.c
    public final long b() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.anythink.expressad.exoplayer.k.c
    public final void a(long j2) {
        SystemClock.sleep(j2);
    }

    @Override // com.anythink.expressad.exoplayer.k.c
    public final k a(Looper looper, @Nullable Handler.Callback callback) {
        return new ab(new Handler(looper, callback));
    }
}
