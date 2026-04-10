package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class g implements com.kwad.sdk.core.webview.b.a {
    protected final com.kwad.sdk.core.webview.b Sk;
    private int Sl;
    private boolean Sm;
    private final boolean Sn;
    private List<com.kwad.components.core.d.b.c> So;

    @Nullable
    private com.kwad.sdk.core.webview.c.kwai.a cV;

    @Nullable
    private DialogInterface.OnDismissListener xG;

    public g(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this(bVar, cVar, aVar, false, 0, false);
    }

    public g(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, int i2) {
        this(bVar, cVar, aVar, false, 1, false);
    }

    public g(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, int i2, boolean z2) {
        this(bVar, cVar, null, false, 2, z2);
    }

    public g(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, cVar, aVar, false, 0, false);
        this.xG = onDismissListener;
    }

    public g(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.d.b.c cVar, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar, boolean z2, int i2, boolean z3) {
        this.Sm = false;
        this.So = new ArrayList();
        this.Sm = z2;
        this.Sk = bVar;
        this.Sl = i2;
        if (cVar != null) {
            cVar.as(1);
            this.So.add(cVar);
        }
        this.cV = aVar;
        this.Sn = z3;
    }

    public g(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable List<com.kwad.components.core.d.b.c> list, @Nullable com.kwad.sdk.core.webview.c.kwai.a aVar) {
        this(bVar, null, aVar, false, 0, false);
        if (list != null) {
            this.So.addAll(list);
        }
    }

    private static boolean S(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.bW(adTemplate) == 13;
    }

    static /* synthetic */ boolean a(g gVar, com.kwad.sdk.core.webview.c.a.a aVar) {
        return a(aVar);
    }

    private static boolean a(com.kwad.sdk.core.webview.c.a.a aVar) {
        return aVar.Ty == 1;
    }

    @NonNull
    protected y.b a(com.kwad.sdk.core.webview.c.a.a aVar, AdTemplate adTemplate) {
        com.kwad.sdk.core.webview.c.a.c cVar;
        int i2;
        y.b bVar = new y.b();
        com.kwad.sdk.core.webview.c.a.c cVar2 = aVar.Tz;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.To)) {
            bVar.To = aVar.Tz.To;
        }
        com.kwad.sdk.core.webview.c.a.c cVar3 = aVar.Tz;
        if (cVar3 != null && (i2 = cVar3.apK) != 0) {
            bVar.aks = i2;
        }
        if (!S(adTemplate) || (cVar = aVar.Tz) == null || cVar.apL == null) {
            com.kwad.sdk.widget.e eVar = this.Sk.aoM;
            if (eVar != null) {
                bVar.jU = eVar.getTouchCoords();
            }
        } else {
            ab.a aVar2 = new ab.a();
            com.kwad.sdk.core.webview.c.a.b bVar2 = aVar.Tz.apL;
            aVar2.g((float) bVar2.f16964x, (float) bVar2.f16965y);
            com.kwad.sdk.core.webview.c.a.b bVar3 = aVar.Tz.apL;
            aVar2.f((float) bVar3.f16964x, (float) bVar3.f16965y);
            com.kwad.sdk.core.webview.c.a.b bVar4 = aVar.Tz.apL;
            aVar2.t(bVar4.width, bVar4.height);
            bVar.jU = aVar2;
        }
        return bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        Runnable runnable;
        if (this.Sk.zf()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        final com.kwad.sdk.core.webview.c.a.a aVar = new com.kwad.sdk.core.webview.c.a.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
        if (!this.Sk.aoO) {
            if (this.cV != null) {
                runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.g.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (g.this.cV != null) {
                            g.this.cV.onAdClicked(aVar);
                        }
                    }
                };
            }
            cVar.a(null);
        }
        runnable = new Runnable() { // from class: com.kwad.components.core.webview.jshandler.g.1
            @Override // java.lang.Runnable
            public final void run() {
                AdTemplate adTemplate;
                TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
                com.kwad.sdk.core.webview.b bVar = g.this.Sk;
                if (bVar.aoP) {
                    if (aVar.creativeId >= 0) {
                        List<AdTemplate> listZe = bVar.ze();
                        com.kwad.sdk.core.webview.c.a.a aVar2 = aVar;
                        adTemplate = com.kwad.sdk.core.response.a.d.a(listZe, aVar2.creativeId, aVar2.adStyle);
                    } else {
                        adTemplate = bVar.getAdTemplate();
                        aVar.creativeId = com.kwad.sdk.core.response.a.d.ck(adTemplate);
                        aVar.adStyle = com.kwad.sdk.core.response.a.d.bW(adTemplate);
                    }
                    com.kwad.components.core.d.b.c cVarW = g.this.w(aVar.creativeId);
                    if (g.this.xG != null && cVarW != null) {
                        cVarW.setOnDismissListener(g.this.xG);
                    }
                    String strO = null;
                    if (!TextUtils.isEmpty(aVar.Jl)) {
                        try {
                            strO = com.kwad.components.core.d.kwai.a.o(Long.parseLong(aVar.Jl));
                        } catch (Exception unused) {
                            strO = aVar.Jl;
                        }
                    } else if (adTemplate != null && (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) != null) {
                        strO = tKAdLiveShopItemInfo.itemId;
                    }
                    com.kwad.components.core.d.b.a.a(new a.C0395a(g.this.Sk.LI.getContext()).J(adTemplate).b(cVarW).am(strO).al(g.a(g.this, aVar)).am(g.this.Sm).d(g.this.Sk.mReportExtData).ap(aVar.Ty).an(aVar.apJ).ao(aVar.jS).an(g.this.Sn || aVar.Jd).ar(g.this.Sl).a(g.this.a(aVar, adTemplate)).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.g.1.1
                        @Override // com.kwad.components.core.d.b.a.b
                        public final void onAdClicked() {
                            g.this.jv();
                            if (g.this.cV != null) {
                                g.this.cV.onAdClicked(aVar);
                            }
                        }
                    }));
                }
            }
        };
        bh.runOnUiThread(runnable);
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    protected void jv() {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.cV = null;
    }

    @Nullable
    protected final com.kwad.components.core.d.b.c w(long j2) {
        List<com.kwad.components.core.d.b.c> list = this.So;
        if (list == null) {
            return null;
        }
        if (j2 < 0 && list.size() == 1) {
            return this.So.get(0);
        }
        for (com.kwad.components.core.d.b.c cVar : this.So) {
            if (com.kwad.sdk.core.response.a.d.ck(cVar.nE()) == j2) {
                return cVar;
            }
        }
        return null;
    }
}
