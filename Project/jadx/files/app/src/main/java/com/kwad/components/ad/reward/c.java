package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.bh;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.d.j> oS;

    static class a {
        private static final c oU = new c(0);
    }

    private c() {
        this.oS = new HashSet();
    }

    /* synthetic */ c(byte b) {
        this();
    }

    public static c fD() {
        return a.oU;
    }

    private void fE() {
        if (this.oS.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.d.j> it = this.oS.iterator();
        while (it.hasNext()) {
            it.next().onRewardVerify();
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void a(com.kwad.components.ad.reward.d.j jVar) {
        if (jVar != null) {
            this.oS.add(jVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.d.j jVar) {
        this.oS.remove(jVar);
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            fE();
        } else {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.notifyRewardVerify();
                }
            });
        }
    }
}
