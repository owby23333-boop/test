package com.kwad.components.ad.reward.k;

import android.content.DialogInterface;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends z {
    private WeakReference<com.kwad.components.ad.reward.g> AK;
    private long yU;

    public q(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.components.ad.reward.g gVar, long j, com.kwad.sdk.core.webview.d.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, cVar, aVar, onDismissListener);
        this.yU = j;
        if (gVar != null) {
            this.AK = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.z
    public final void kr() {
        super.kr();
        if (this.acw != null) {
            com.kwad.components.ad.reward.c.a.hV().c(this.acw.getAdTemplate(), com.kwad.components.ad.reward.c.b.STATUS_NONE);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.z
    public final a.C0333a a(a.C0333a c0333a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        long playDuration;
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.AK;
        if (weakReference != null && weakReference.get() != null) {
            playDuration = this.AK.get().rE.getPlayDuration();
        } else {
            playDuration = this.yU;
            if (playDuration <= 0) {
                playDuration = 0;
            }
        }
        return super.a(c0333a, aVar, adTemplate).B(playDuration);
    }
}
