package com.kwad.components.ad.interstitial.g;

import android.app.Activity;
import android.content.DialogInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static boolean d(final c cVar) {
        Activity ownerActivity;
        if (cVar.kW != null && (ownerActivity = cVar.kW.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo adInfoEl = e.el(cVar.mAdTemplate);
            int iDO = com.kwad.components.ad.interstitial.c.b.dO();
            int iDP = com.kwad.components.ad.interstitial.c.b.dP();
            if (iDO > com.kwad.sdk.core.response.b.a.cw(adInfoEl) && iDP < com.kwad.sdk.core.response.b.a.cx(adInfoEl)) {
                if (com.kwad.sdk.core.response.b.a.cy(adInfoEl) == 2) {
                    com.kwad.components.ad.interstitial.h.b.e(cVar);
                    return true;
                }
                if (com.kwad.sdk.core.response.b.a.cy(adInfoEl) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.b.a.cz(adInfoEl), new a.InterfaceC0348a() { // from class: com.kwad.components.ad.interstitial.g.a.1
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0348a
                        public final void c(DialogInterface dialogInterface) {
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0348a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.c(cVar.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().dk(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0348a
                        public final void b(DialogInterface dialogInterface) {
                            c cVar2 = cVar;
                            cVar2.a(false, -1, cVar2.cq);
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.adlog.c.e(cVar.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS).dk(8));
                            cVar.kW.dismiss();
                        }
                    }).show();
                    com.kwad.sdk.core.adlog.c.d(cVar.mAdTemplate, new JSONObject(), new com.kwad.sdk.core.adlog.c.b().df(149).dk(8));
                    return true;
                }
            }
        }
        return false;
    }
}
