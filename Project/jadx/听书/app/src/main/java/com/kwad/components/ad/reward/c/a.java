package com.kwad.components.ad.reward.c;

import android.content.Context;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static volatile a uf;
    private g tm;
    private b ug;
    private volatile boolean uh = false;
    private volatile boolean ui = false;
    private List<WeakReference<j>> uj = new CopyOnWriteArrayList();

    public static a hV() {
        if (uf == null) {
            synchronized (a.class) {
                if (uf == null) {
                    uf = new a();
                }
            }
        }
        return uf;
    }

    private a() {
    }

    public final synchronized void reset() {
        this.ug = null;
        this.ui = false;
        this.uh = false;
        this.tm = null;
    }

    public final void setCallerContext(g gVar) {
        this.tm = gVar;
    }

    public final synchronized void c(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + i);
        g gVar = this.tm;
        if (gVar != null && gVar.gW() && i == b.STATUS_NONE) {
            com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        b bVarHW = hV().hW();
        bVarHW.aa(i);
        hV().a(adTemplate, bVarHW);
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
        this.ug = bVar;
        if (bVar.un == b.uk && !this.uh) {
            this.uh = true;
            c.a(this.ug, com.kwad.components.ad.reward.e.f.N(adTemplate.getUniqueId()));
            com.kwad.sdk.core.adlog.c.j(adTemplate, isNeoScan());
        }
        for (WeakReference<j> weakReference : this.uj) {
            if (weakReference.get() == null) {
                this.uj.remove(weakReference);
            } else {
                b bVarHW = hW();
                com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + bVarHW.toJson().toString());
                weakReference.get().a(bVarHW);
            }
        }
    }

    private boolean isNeoScan() {
        return this.tm.mAdResultData.adGlobalConfigInfo != null && this.tm.mAdResultData.adGlobalConfigInfo.neoPageType == 1;
    }

    public final synchronized b hW() {
        if (this.ug == null) {
            b bVarHZ = c.hZ();
            this.ug = bVarHZ;
            bVarHZ.un = 0;
        }
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.ug.un);
        return this.ug;
    }

    private synchronized boolean hX() {
        b bVar = this.ug;
        if (bVar != null) {
            if (bVar.un == b.uk) {
                return true;
            }
        }
        return false;
    }

    public final void a(j jVar) {
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + jVar);
        if (jVar != null) {
            this.uj.add(new WeakReference<>(jVar));
        }
    }

    public final void R(Context context) {
        boolean zHX = hX();
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + zHX + ", hadToast: " + this.ui);
        if (this.ui || !zHX) {
            return;
        }
        this.ui = true;
        ac.Q(context, "恭喜获得第2份奖励");
    }
}
