package com.kwad.components.core.c;

import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class j extends o<com.kwad.components.core.request.a, AdResultData> {
    private final com.kwad.components.core.request.model.a NR;

    protected boolean a(com.kwad.components.core.request.model.a aVar, AdResultData adResultData) {
        return false;
    }

    public j(com.kwad.components.core.request.model.a aVar) {
        this.NR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        a aVarNZ = a.nZ();
        if (aVarNZ == null || proceedTemplateList.size() <= 0) {
            return;
        }
        AdTemplate adTemplate = proceedTemplateList.get(0);
        e eVarX = e.x(adResultData.getPosId());
        aVarNZ.oa();
        aVarNZ.j(h.a(eVarX, adResultData));
        aVarNZ.a(e.au(adTemplate));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(com.kwad.components.core.request.a aVar, final AdResultData adResultData) {
        super.onSuccess(aVar, adResultData);
        GlobalThreadPools.Jt().submit(new bg() { // from class: com.kwad.components.core.c.j.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                j jVar = j.this;
                j.m(adResultData);
            }
        });
        if (a(this.NR, adResultData)) {
            return;
        }
        com.kwad.components.core.request.model.a.a(this.NR, adResultData, false);
    }

    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onError(com.kwad.components.core.request.a aVar, int i, String str) {
        super.onError(aVar, i, str);
        com.kwad.components.core.request.model.a.a(this.NR, i, str, false);
    }
}
