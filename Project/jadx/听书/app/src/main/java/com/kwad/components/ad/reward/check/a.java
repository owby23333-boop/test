package com.kwad.components.ad.reward.check;

import com.kwad.sdk.commercial.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static void b(AdTemplate adTemplate, int i) {
        b.f(new RewardCheckMonitorInfo().setRequestStatus(1).setCheckType(i).setEnviType(0).setCreativeId(com.kwad.sdk.core.response.b.a.J(e.el(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, String str) {
        b.f(new RewardCheckMonitorInfo().setRequestStatus(2).setCheckType(i).setEnviType(0).setDataLoadInterval(j).setCode(i2).setErrorMsg(str).setCreativeId(com.kwad.sdk.core.response.b.a.J(e.el(adTemplate))).setAdTemplate(adTemplate));
    }
}
