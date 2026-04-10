package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;

/* JADX INFO: loaded from: classes4.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public String aIB;
    public String aIC;
    public int aID;
    public int operatorType;

    public static d IM() {
        d dVar = new d();
        try {
            Context contextPp = ServiceProvider.Pp();
            dVar.aIB = bd.dq(contextPp);
            dVar.aIC = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bo();
            dVar.aID = ao.df(contextPp);
            dVar.operatorType = ao.d(contextPp, bd.dt(contextPp), bc.useNetworkStateDisable());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return dVar;
    }

    public static d IN() {
        d dVar = new d();
        dVar.aID = ao.df(ServiceProvider.getContext());
        return dVar;
    }
}
