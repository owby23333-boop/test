package com.bytedance.sdk.component.bf.e.bf;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes.dex */
final class vn {
    static long bf;
    static ga e;

    private vn() {
    }

    public static ga e() {
        synchronized (vn.class) {
            ga gaVar = e;
            if (gaVar == null) {
                return new ga();
            }
            e = gaVar.vn;
            gaVar.vn = null;
            bf -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return gaVar;
        }
    }

    public static void e(ga gaVar) {
        if (gaVar.vn == null && gaVar.p == null) {
            if (gaVar.tg) {
                return;
            }
            synchronized (vn.class) {
                long j = bf;
                if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                bf = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                gaVar.vn = e;
                gaVar.d = 0;
                gaVar.bf = 0;
                e = gaVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
