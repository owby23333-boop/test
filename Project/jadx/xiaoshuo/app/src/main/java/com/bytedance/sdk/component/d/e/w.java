package com.bytedance.sdk.component.d.e;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes.dex */
final class w {
    static long bf;
    static s e;

    private w() {
    }

    public static s e() {
        synchronized (w.class) {
            s sVar = e;
            if (sVar == null) {
                return new s();
            }
            e = sVar.vn;
            sVar.vn = null;
            bf -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return sVar;
        }
    }

    public static void e(s sVar) {
        if (sVar.vn == null && sVar.p == null) {
            if (sVar.tg) {
                return;
            }
            synchronized (w.class) {
                long j = bf;
                if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                bf = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                sVar.vn = e;
                sVar.d = 0;
                sVar.bf = 0;
                e = sVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
