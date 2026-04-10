package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bh;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private final Set<com.kwad.components.ad.reward.d.k> oV;

    static class a {
        private static final d oY = new d(0);
    }

    private d() {
        this.oV = new HashSet();
    }

    /* synthetic */ d(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable com.kwad.components.core.webview.a.a.p pVar) {
        if (this.oV.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.d.k> it = this.oV.iterator();
        while (it.hasNext()) {
            it.next().a(pVar);
        }
    }

    public static d fG() {
        return a.oY;
    }

    public final void a(com.kwad.components.ad.reward.d.k kVar) {
        if (kVar != null) {
            this.oV.add(kVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.d.k kVar) {
        this.oV.remove(kVar);
    }

    public final void c(@Nullable final com.kwad.components.core.webview.a.a.p pVar) {
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.this.b(pVar);
            }
        });
    }
}
