package com.bytedance.sdk.component.g.z.g;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes2.dex */
final class e {
    static long g;
    static m z;

    private e() {
    }

    static m z() {
        synchronized (e.class) {
            m mVar = z;
            if (mVar != null) {
                z = mVar.m;
                mVar.m = null;
                g -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return mVar;
            }
            return new m();
        }
    }

    static void z(m mVar) {
        if (mVar.m != null || mVar.e != null) {
            throw new IllegalArgumentException();
        }
        if (mVar.f716a) {
            return;
        }
        synchronized (e.class) {
            long j = g;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            g = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            mVar.m = z;
            mVar.dl = 0;
            mVar.g = 0;
            z = mVar;
        }
    }
}
