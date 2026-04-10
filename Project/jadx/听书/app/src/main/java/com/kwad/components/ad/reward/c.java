package com.kwad.components.ad.reward;

import com.kwad.components.core.webview.tachikoma.c.r;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.e.m> rj;

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
        this.rj = new HashSet();
    }

    static class a {
        private static final c rm = new c(0);
    }

    public static c gn() {
        return a.rm;
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.rj.add(mVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.rj.remove(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (this.rj.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.m> it = this.rj.iterator();
        while (it.hasNext()) {
            it.next().a(rVar);
        }
    }

    public final void c(final r rVar) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.this.b(rVar);
            }
        });
    }
}
