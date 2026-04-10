package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.e.l> rg;

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.rg = new HashSet();
    }

    static class a {
        private static final b ri = new b(0);
    }

    public static b gk() {
        return a.ri;
    }

    public final void a(com.kwad.components.ad.reward.e.l lVar) {
        if (lVar != null) {
            this.rg.add(lVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.l lVar) {
        this.rg.remove(lVar);
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private void gl() {
        if (this.rg.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.l> it = this.rg.iterator();
        while (it.hasNext()) {
            it.next().onRewardVerify();
        }
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            gl();
        } else {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.b.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.this.notifyRewardVerify();
                }
            });
        }
    }
}
