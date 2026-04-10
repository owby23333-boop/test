package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bh;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.d.h> oN;

    static class a {
        private static final b oR = new b(0);
    }

    private b() {
        this.oN = new HashSet();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.d.l lVar) {
        if (this.oN.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.d.h> it = this.oN.iterator();
        while (it.hasNext()) {
            it.next().a(playableSource, lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.oN.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.d.h> it = this.oN.iterator();
        while (it.hasNext()) {
            it.next().cb();
        }
    }

    private void fB() {
        if (this.oN.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.d.h> it = this.oN.iterator();
        while (it.hasNext()) {
            it.next().ca();
        }
    }

    public static b fz() {
        return a.oR;
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.d.h hVar) {
        if (hVar != null) {
            this.oN.add(hVar);
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(com.kwad.components.ad.reward.d.h hVar) {
        this.oN.remove(hVar);
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c(playableSource);
                }
            });
        }
    }

    public final void c(final PlayableSource playableSource, @Nullable final com.kwad.components.ad.reward.d.l lVar) {
        if (isMainThread()) {
            b(playableSource, lVar);
        } else {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b(playableSource, lVar);
                }
            });
        }
    }

    public final void fA() {
        if (isMainThread()) {
            fB();
        } else {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.fA();
                }
            });
        }
    }
}
