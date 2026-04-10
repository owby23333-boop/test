package com.kwad.components.ad.interstitial.d;

import android.app.Activity;
import android.content.DialogInterface;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.core.page.widget.a;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.tencent.smtt.sdk.TbsListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static boolean c(final c cVar) {
        Activity ownerActivity;
        d dVar = cVar.hR;
        if (dVar != null && (ownerActivity = dVar.getOwnerActivity()) != null && !ownerActivity.isFinishing()) {
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(cVar.mAdTemplate);
            int iCO = com.kwad.components.ad.interstitial.a.b.cO();
            int iCP = com.kwad.components.ad.interstitial.a.b.cP();
            if (iCO > com.kwad.sdk.core.response.a.a.bQ(adInfoCb) && iCP < com.kwad.sdk.core.response.a.a.bR(adInfoCb)) {
                if (com.kwad.sdk.core.response.a.a.bS(adInfoCb) == 2) {
                    com.kwad.components.ad.interstitial.e.b.d(cVar);
                    return true;
                }
                if (com.kwad.sdk.core.response.a.a.bS(adInfoCb) == 1) {
                    new com.kwad.components.core.page.widget.a(ownerActivity, com.kwad.sdk.core.response.a.a.bV(adInfoCb), new a.InterfaceC0408a() { // from class: com.kwad.components.ad.interstitial.d.a.1
                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
                        public final void a(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.report.a.c(cVar.mAdTemplate, (JSONObject) null, new i().bj(8));
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
                        public final void b(DialogInterface dialogInterface) {
                            c cVar2 = cVar;
                            cVar2.a(false, -1, cVar2.eM);
                            dialogInterface.dismiss();
                            com.kwad.sdk.core.report.a.a(cVar.mAdTemplate, new i().bh(TbsListener.ErrorCode.NEEDDOWNLOAD_STATIC_INSTALLING).bj(8));
                            cVar.hR.dismiss();
                        }

                        @Override // com.kwad.components.core.page.widget.a.InterfaceC0408a
                        public final void c(DialogInterface dialogInterface) {
                        }
                    }).show();
                    com.kwad.sdk.core.report.a.d(cVar.mAdTemplate, new JSONObject(), new i().bh(149).bj(8));
                    return true;
                }
            }
        }
        return false;
    }
}
