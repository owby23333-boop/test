package com.kwad.components.ad.reward.h.kwai;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h.k;
import com.kwad.components.ad.reward.h.l;
import com.kwad.components.ad.reward.h.m;
import com.kwad.components.ad.reward.h.n;
import com.kwad.components.ad.reward.h.o;
import com.kwad.components.ad.reward.h.p;
import com.kwad.components.ad.reward.h.q;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.a.g;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends g implements f.b {

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private WeakReference<j> qQ;
    private com.kwad.components.ad.reward.b.e xC;
    private l xD;
    private k xE;
    private List<AdTemplate> xF;

    @Nullable
    private DialogInterface.OnDismissListener xG;

    public d(@NonNull j jVar, long j2, Context context) {
        super(j2, context);
        this.xF = null;
        this.qQ = new WeakReference<>(jVar);
    }

    public d(j jVar, long j2, Context context, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(-1L, context);
        this.xF = null;
        this.xG = onDismissListener;
        this.qQ = new WeakReference<>(jVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.f.b
    public final void c(AdTemplate adTemplate, long j2) {
        com.kwad.components.core.g.c cVar = new com.kwad.components.core.g.c(adTemplate, com.kwad.components.core.g.e.AGGREGATION);
        WeakReference<j> weakReference = this.qQ;
        j jVar = weakReference != null ? weakReference.get() : null;
        if (jVar != null) {
            jVar.c(cVar);
        }
    }

    @Override // com.kwad.components.core.webview.a.g
    public final t createLogHandler(com.kwad.sdk.core.webview.b bVar) {
        WeakReference<j> weakReference = this.qQ;
        return new n(weakReference != null ? weakReference.get() : null, this.mPlayedDuration, bVar);
    }

    public final void g(List<AdTemplate> list) {
        this.xF = list;
    }

    public final BackPressHandleResult gI() {
        l lVar = this.xD;
        if (lVar == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        lVar.ju();
        return BackPressHandleResult.HANDLED;
    }

    public final com.kwad.components.ad.reward.b.e jB() {
        return this.xC;
    }

    public final k jC() {
        return this.xE;
    }

    @Override // com.kwad.components.core.webview.a.g
    public final void onRegisterWebCardHandler(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, com.kwad.sdk.components.l lVar, ViewGroup viewGroup) {
        super.onRegisterWebCardHandler(bVar, cVar, lVar, viewGroup);
        this.mApkDownloadHelper = cVar;
        lVar.c(new o(bVar, cVar, null, this.mPlayedDuration, this, this.xG));
        this.xC = new com.kwad.components.ad.reward.b.e();
        lVar.c(this.xC);
        lVar.c(new q(this.mContext, this.qQ.get()));
        lVar.c(new m(this.qQ.get()));
        this.xD = new l();
        lVar.c(this.xD);
        this.xE = new k();
        lVar.c(this.xE);
        List<AdTemplate> list = this.xF;
        if (list != null) {
            this.xE.f(list);
            this.xF = null;
        }
        lVar.c(new p(this.qQ.get(), obtainAdTemplate()));
        f fVar = new f(bVar);
        fVar.a(this);
        lVar.c(fVar);
    }
}
