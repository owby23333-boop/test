package com.kwad.components.ad.reward.h;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class o extends com.kwad.components.core.webview.jshandler.g {
    private long vy;
    private WeakReference<com.kwad.components.ad.reward.j> xv;

    public o(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.components.ad.reward.j jVar, long j2, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, cVar, aVar, onDismissListener);
        this.vy = -1L;
        this.vy = j2;
        if (jVar != null) {
            this.xv = new WeakReference<>(jVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.g
    @NonNull
    public final y.b a(com.kwad.sdk.core.webview.c.a.a aVar, AdTemplate adTemplate) {
        long playDuration;
        y.b bVarA = super.a(aVar, adTemplate);
        WeakReference<com.kwad.components.ad.reward.j> weakReference = this.xv;
        if (weakReference == null || weakReference.get() == null) {
            playDuration = this.vy;
            if (playDuration > 0) {
            }
            return bVarA;
        }
        playDuration = this.xv.get().pw.getPlayDuration();
        bVarA.vy = playDuration;
        return bVarA;
    }

    @Override // com.kwad.components.core.webview.jshandler.g
    public final void jv() {
        super.jv();
        if (this.Sk != null) {
            com.kwad.components.ad.reward.b.a.hi().c(this.Sk.getAdTemplate(), com.kwad.components.ad.reward.b.b.STATUS_NONE);
        }
    }
}
