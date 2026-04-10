package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class z implements com.kwad.sdk.core.webview.c.a {
    private DialogInterface.OnDismissListener AX;
    private int acI;
    private boolean acJ;
    private final boolean acK;
    private boolean acL;
    private List<com.kwad.components.core.e.d.c> acM;
    private boolean acN;
    protected final com.kwad.sdk.core.webview.b acw;
    private com.kwad.sdk.core.webview.d.a.a eT;

    protected void Y(int i) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "clickAction";
    }

    protected void kr() {
    }

    static /* synthetic */ boolean a(z zVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z, int i, boolean z2, boolean z3) {
        this.acJ = false;
        this.acM = new ArrayList();
        this.acJ = z;
        this.acw = bVar;
        this.acI = i;
        if (cVar != null) {
            cVar.aG(1);
            this.acM.add(cVar);
        }
        this.eT = aVar;
        this.acK = z2;
        this.acN = z3;
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.AX = onDismissListener;
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, 0, false, false);
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.acL = true;
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, int i, boolean z) {
        this(bVar, cVar, null, false, 2, z, false);
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, int i) {
        this(bVar, cVar, aVar, false, 1, false, false);
    }

    public z(com.kwad.sdk.core.webview.b bVar, List<com.kwad.components.core.e.d.c> list, com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, null, aVar, false, 0, false, false);
        if (list != null) {
            this.acM.addAll(list);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (this.acw.KJ() && aVar.adTemplate == null) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        if (this.acw.aMP && !aVar.aNQ) {
            bw.runOnUiThread(new com.kwad.sdk.utils.bg() { // from class: com.kwad.components.core.webview.jshandler.z.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    AdTemplate adTemplate;
                    String strY;
                    if (z.this.acw.aMQ) {
                        if (aVar.adTemplate != null) {
                            adTemplate = aVar.adTemplate;
                            z.this.acM.add(new com.kwad.components.core.e.d.c(adTemplate));
                        } else if (aVar.creativeId >= 0) {
                            adTemplate = com.kwad.sdk.core.response.b.e.a(z.this.acw.KI(), aVar.creativeId, aVar.adStyle);
                        } else {
                            adTemplate = z.this.acw.getAdTemplate();
                            aVar.creativeId = com.kwad.sdk.core.response.b.e.ev(adTemplate);
                            aVar.adStyle = com.kwad.sdk.core.response.b.e.eg(adTemplate);
                        }
                        com.kwad.components.core.e.d.c cVarQ = z.this.Q(aVar.creativeId);
                        if (z.this.AX != null && cVarQ != null) {
                            cVarQ.setOnDismissListener(z.this.AX);
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
                        z.this.Y(com.kwad.components.core.e.d.a.a(z.this.a(new a.C0333a(z.this.acw.TG.getContext()).aB(adTemplate).b(cVarQ).al(strY).aq(z.a(z.this, aVar)).ar(z.this.acJ).c(z.this.acw.mReportExtData).aB(aVar.adN).az(aVar.aNP).aA(aVar.mI).as(z.this.acK || aVar.Ph).aF(z.this.acI).an(z.this.acN).au(z.this.acL).ay(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.z.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                z.this.kr();
                                if (z.this.eT == null || aVar.aNR) {
                                    return;
                                }
                                z.this.eT.a(aVar);
                            }
                        }), aVar, adTemplate)));
                    }
                }
            });
        } else if (this.eT != null) {
            bw.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.z.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (z.this.eT == null || aVar.aNR) {
                        return;
                    }
                    z.this.eT.a(aVar);
                }
            });
        }
        cVar.a(null);
    }

    protected a.C0333a a(a.C0333a c0333a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
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

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.eT = null;
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
}
