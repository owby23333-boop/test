package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes.dex */
final class p {
    static o a;
    static long b;

    private p() {
    }

    static o a() {
        synchronized (p.class) {
            if (a == null) {
                return new o();
            }
            o oVar = a;
            a = oVar.f880f;
            oVar.f880f = null;
            b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return oVar;
        }
    }

    static void a(o oVar) {
        if (oVar.f880f != null || oVar.f881g != null) {
            throw new IllegalArgumentException();
        }
        if (oVar.f878d) {
            return;
        }
        synchronized (p.class) {
            if (b + PlaybackStateCompat.ACTION_PLAY_FROM_URI <= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                oVar.f880f = a;
                oVar.f877c = 0;
                oVar.b = 0;
                a = oVar;
            }
        }
    }
}
