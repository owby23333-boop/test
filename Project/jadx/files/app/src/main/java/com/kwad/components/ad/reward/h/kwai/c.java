package com.kwad.components.ad.reward.h.kwai;

import android.text.TextUtils;
import com.kwad.components.ad.reward.b.f;
import com.kwad.components.core.webview.a.g;
import com.kwad.sdk.components.l;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.core.webview.a.b.c implements e {
    private a xA;

    public final void a(com.kwad.components.ad.reward.b.b bVar) {
        a aVar = this.xA;
        if (aVar != null) {
            aVar.b(bVar);
        }
    }

    @Override // com.kwad.components.core.webview.a.b.a
    public final g ij() {
        this.xA = (a) this.Vi;
        return new d(this.xA.jw(), this.xA.mPlayedDuration, getContext());
    }

    @Override // com.kwad.components.core.webview.a.b.a, com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new f(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.h.kwai.c.1
            @Override // com.kwad.components.ad.reward.b.d
            public final void a(com.kwad.components.ad.reward.b.b bVar2) {
                com.kwad.sdk.core.d.b.d("RewardTKDialogFragmentPresenter", "onUpdateExtraReward : " + bVar2.hl());
                c.this.a(bVar2);
            }
        }));
        lVar.c(new com.kwad.components.core.webview.jshandler.b(new com.kwad.components.core.webview.jshandler.c() { // from class: com.kwad.components.ad.reward.h.kwai.c.2
            @Override // com.kwad.components.core.webview.jshandler.c
            public final void a(com.kwad.components.core.webview.jshandler.b bVar2, String str) {
                if (TextUtils.equals(str, "getExtraReward")) {
                    bVar2.a(com.kwad.components.ad.reward.b.a.hi().hj());
                    com.kwad.components.ad.reward.b.a.hi().a(bVar2);
                }
            }
        }));
    }
}
