package com.bytedance.sdk.component.dl.z;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes2.dex */
final class ls {
    static long g;
    static pf z;

    private ls() {
    }

    static pf z() {
        synchronized (ls.class) {
            pf pfVar = z;
            if (pfVar != null) {
                z = pfVar.m;
                pfVar.m = null;
                g -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return pfVar;
            }
            return new pf();
        }
    }

    static void z(pf pfVar) {
        if (pfVar.m != null || pfVar.e != null) {
            throw new IllegalArgumentException();
        }
        if (pfVar.f696a) {
            return;
        }
        synchronized (ls.class) {
            long j = g;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            g = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            pfVar.m = z;
            pfVar.dl = 0;
            pfVar.g = 0;
            z = pfVar;
        }
    }
}
