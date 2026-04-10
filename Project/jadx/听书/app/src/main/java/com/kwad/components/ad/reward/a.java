package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private final Set<com.kwad.components.ad.reward.e.j> rb;

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.rb = new HashSet();
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.a$a, reason: collision with other inner class name */
    static class C0295a {
        private static final a rf = new a(0);
    }

    public static a gg() {
        return C0295a.rf;
    }

    public final void a(com.kwad.components.ad.reward.e.j jVar) {
        if (jVar != null) {
            this.rb.add(jVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.j jVar) {
        this.rb.remove(jVar);
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, com.kwad.components.ad.reward.e.n nVar) {
        if (this.rb.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.rb.iterator();
        while (it.hasNext()) {
            it.next().a(playableSource, nVar);
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void c(final PlayableSource playableSource, final com.kwad.components.ad.reward.e.n nVar) {
        if (isMainThread()) {
            b(playableSource, nVar);
        } else {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    a.this.b(playableSource, nVar);
                }
            });
        }
    }

    public final void gh() {
        if (isMainThread()) {
            gi();
        } else {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.a.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    a.this.gh();
                }
            });
        }
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.a.3
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    a.this.c(playableSource);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.rb.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.rb.iterator();
        while (it.hasNext()) {
            it.next().dl();
        }
    }

    private void gi() {
        if (this.rb.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.rb.iterator();
        while (it.hasNext()) {
            it.next().dk();
        }
    }
}
