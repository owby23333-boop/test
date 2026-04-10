package com.kwad.components.ad.reward.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.components.ad.reward.j;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static volatile a rK;
    private j qS;

    @Nullable
    private b rL;
    private volatile boolean rM = false;
    private volatile boolean rN = false;
    private List<WeakReference<com.kwad.components.core.webview.jshandler.b>> rO = new CopyOnWriteArrayList();

    private a() {
    }

    public static a hi() {
        if (rK == null) {
            synchronized (a.class) {
                if (rK == null) {
                    rK = new a();
                }
            }
        }
        return rK;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean hk() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.kwad.components.ad.reward.b.b r0 = r2.rL     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            com.kwad.components.ad.reward.b.b r0 = r2.rL     // Catch: java.lang.Throwable -> L12
            int r0 = r0.rS     // Catch: java.lang.Throwable -> L12
            int r1 = com.kwad.components.ad.reward.b.b.rP     // Catch: java.lang.Throwable -> L12
            if (r0 != r1) goto L10
            r0 = 1
        Le:
            monitor-exit(r2)
            return r0
        L10:
            r0 = 0
            goto Le
        L12:
            r0 = move-exception
            monitor-exit(r2)
            goto L16
        L15:
            throw r0
        L16:
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.b.a.hk():boolean");
    }

    public final void Q(Context context) {
        boolean zHk = hk();
        com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + zHk + ", hadToast: " + this.rN);
        if (this.rN || !zHk) {
            return;
        }
        this.rN = true;
        u.F(context, "恭喜获得第2份奖励");
    }

    public final void a(com.kwad.components.core.webview.jshandler.b bVar) {
        com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + bVar);
        if (bVar != null) {
            this.rO.add(new WeakReference<>(bVar));
        }
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
        this.rL = bVar;
        if (bVar.rS == b.rP && !this.rM) {
            this.rM = true;
            c.a(this.rL, KSRewardVideoActivityProxy.a.E(adTemplate.getUniqueId()));
            com.kwad.sdk.core.report.a.aE(adTemplate);
        }
        for (WeakReference<com.kwad.components.core.webview.jshandler.b> weakReference : this.rO) {
            if (weakReference.get() == null) {
                this.rO.remove(weakReference);
            } else {
                b bVarHj = hj();
                com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + bVarHj.toJson().toString());
                weakReference.get().a(bVarHj);
            }
        }
    }

    public final synchronized void c(AdTemplate adTemplate, int i2) {
        com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "updateExtraReward: " + i2);
        if (this.qS != null && this.qS.mRewardVerifyCalled && i2 == b.STATUS_NONE) {
            com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        b bVarHj = hi().hj();
        bVarHj.P(i2);
        hi().a(adTemplate, bVarHj);
    }

    @NonNull
    public final synchronized b hj() {
        if (this.rL == null) {
            this.rL = c.hm();
            this.rL.rS = 0;
        }
        com.kwad.sdk.core.d.b.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.rL.rS);
        return this.rL;
    }

    public final synchronized void reset() {
        this.rL = null;
        this.rN = false;
        this.rM = false;
        this.qS = null;
    }

    public final void setCallerContext(j jVar) {
        this.qS = jVar;
    }
}
