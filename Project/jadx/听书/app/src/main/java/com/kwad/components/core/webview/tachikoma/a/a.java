package com.kwad.components.core.webview.tachikoma.a;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.components.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements m {
    private DialogInterface.OnDismissListener AX;
    private int acI;
    private boolean acJ;
    private final boolean acK;
    private boolean acL;
    private List<com.kwad.components.core.e.d.c> acM;
    private boolean acN;
    protected final com.kwad.sdk.core.webview.b acw;
    private com.kwad.sdk.core.webview.d.a.a eT;

    static /* synthetic */ boolean a(a aVar, com.kwad.sdk.core.webview.d.b.a aVar2) {
        return b(aVar2);
    }

    private a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z, int i, boolean z2, boolean z3) {
        this.acJ = false;
        this.acM = new ArrayList();
        this.acJ = false;
        this.acw = bVar;
        this.acI = 0;
        if (cVar != null) {
            cVar.aG(1);
            this.acM.add(cVar);
        }
        this.eT = aVar;
        this.acK = false;
        this.acN = false;
    }

    public a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.acL = true;
    }

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        aVar.parseJson(new JSONObject((String) obj));
                    }
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (this.acw.KJ() && aVar.adTemplate == null) {
            return null;
        }
        if (this.acw.aMP && !aVar.aNQ) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.a.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    AdTemplate adTemplate;
                    String strY;
                    if (a.this.acw.aMQ) {
                        if (aVar.adTemplate != null) {
                            adTemplate = aVar.adTemplate;
                            a.this.acM.add(new com.kwad.components.core.e.d.c(adTemplate));
                        } else if (aVar.creativeId >= 0) {
                            adTemplate = com.kwad.sdk.core.response.b.e.a(a.this.acw.KI(), aVar.creativeId, aVar.adStyle);
                        } else {
                            adTemplate = a.this.acw.getAdTemplate();
                            aVar.creativeId = com.kwad.sdk.core.response.b.e.ev(adTemplate);
                            aVar.adStyle = com.kwad.sdk.core.response.b.e.eg(adTemplate);
                        }
                        com.kwad.components.core.e.d.c cVarQ = a.this.Q(aVar.creativeId);
                        if (a.this.AX != null && cVarQ != null) {
                            cVarQ.setOnDismissListener(a.this.AX);
                        }
                        if (!TextUtils.isEmpty(aVar.Pv)) {
                            try {
                                strY = com.kwad.components.core.e.b.a.y(Long.parseLong(aVar.Pv));
                            } catch (Exception unused) {
                                strY = aVar.Pv;
                            }
                        } else {
                            strY = (adTemplate == null || adTemplate.tkLiveShopItemInfo == null) ? null : adTemplate.tkLiveShopItemInfo.itemId;
                        }
                        com.kwad.components.core.e.d.a.a(a.this.a(new a.C0333a(a.this.acw.TG.getContext()).aB(adTemplate).b(cVarQ).al(strY).aq(a.a(a.this, aVar)).ar(a.this.acJ).c(a.this.acw.mReportExtData).aB(aVar.adN).az(aVar.aNP).aA(aVar.mI).as(a.this.acK || aVar.Ph).aF(a.this.acI).an(a.this.acN).au(a.this.acL).ay(true).a(new a.b() { // from class: com.kwad.components.core.webview.tachikoma.a.a.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (a.this.eT == null || aVar.aNR) {
                                    return;
                                }
                                a.this.eT.a(aVar);
                            }
                        }), aVar, adTemplate));
                    }
                }
            });
        } else if (this.eT != null) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.eT == null || aVar.aNR) {
                        return;
                    }
                    a.this.eT.a(aVar);
                }
            });
        }
        return null;
    }

    protected final com.kwad.components.core.e.d.c Q(long j) {
        List<com.kwad.components.core.e.d.c> list = this.acM;
        if (list == null) {
            return null;
        }
        if (j < 0 && list.size() == 1) {
            return this.acM.get(0);
        }
        for (com.kwad.components.core.e.d.c cVar : this.acM) {
            if (com.kwad.sdk.core.response.b.e.ev(cVar.pH()) == j) {
                return cVar;
            }
        }
        return null;
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        return aVar.adN == 1;
    }

    protected final a.C0333a a(a.C0333a c0333a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        if (aVar.adO != null && !TextUtils.isEmpty(aVar.adO.Pj)) {
            c0333a.am(aVar.adO.Pj);
        }
        if (aVar.adO != null && aVar.adO.aha != 0) {
            c0333a.aD(aVar.adO.aha);
        }
        if (com.kwad.sdk.core.response.b.e.eE(adTemplate) && aVar.adO != null && aVar.adO.aNT != null) {
            aj.a aVar2 = new aj.a();
            aVar2.f((float) aVar.adO.aNT.x, (float) aVar.adO.aNT.y);
            aVar2.e((float) aVar.adO.aNT.x, (float) aVar.adO.aNT.y);
            aVar2.B(aVar.adO.aNT.width, aVar.adO.aNT.height);
            c0333a.d(aVar2);
        } else {
            com.kwad.sdk.widget.g gVar = this.acw.aMN;
            if (gVar != null) {
                c0333a.d(gVar.getTouchCoords());
            }
        }
        c0333a.a(null, null, null);
        return c0333a;
    }
}
