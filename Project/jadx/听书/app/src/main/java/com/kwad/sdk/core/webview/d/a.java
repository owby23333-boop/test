package com.kwad.sdk.core.webview.d;

import android.content.Context;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.webview.c.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, c cVar) {
        cVar.a(C0411a.KX());
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.webview.d.a$a, reason: collision with other inner class name */
    public static final class C0411a extends com.kwad.sdk.core.response.a.a {
        public String LN;
        public int Qv;
        public int Qw;
        public String SDKVersion;
        public int SDKVersionCode;
        public String aCk;
        public String aCl;
        public String aHz;
        public String aIB;
        public String aIk;
        public String aIn;
        public String aIo;
        public String aNI;
        public String aNJ;
        public boolean aNK;
        public String aNL;
        public String adg;
        public String adh;
        public int adi;
        public String adj;
        public int adk;
        public String adl;
        public String adm;
        public int adn;
        public int ado;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;
        public String sdkApiVersion;
        public int sdkApiVersionCode;
        public int sdkType;

        public static C0411a KX() {
            C0411a c0411a = new C0411a();
            c0411a.SDKVersion = BuildConfig.VERSION_NAME;
            c0411a.SDKVersionCode = BuildConfig.VERSION_CODE;
            c0411a.aHz = "6.1.7";
            c0411a.aNL = "1.3";
            c0411a.sdkApiVersion = ((f) ServiceProvider.get(f.class)).getApiVersion();
            c0411a.sdkApiVersionCode = ((f) ServiceProvider.get(f.class)).getApiVersionCode();
            c0411a.sdkType = 1;
            Context context = ((f) ServiceProvider.get(f.class)).getContext();
            c0411a.appVersion = m.cE(context);
            c0411a.appName = ((f) ServiceProvider.get(f.class)).getAppName();
            c0411a.appId = ((f) ServiceProvider.get(f.class)).getAppId();
            c0411a.aNI = "";
            c0411a.aIo = ag.Qz();
            h hVar = (h) d.f(h.class);
            if (hVar != null) {
                c0411a.aIn = hVar.qd();
            }
            c0411a.adg = String.valueOf(ao.df(context));
            c0411a.adh = br.Sd();
            c0411a.model = br.RT();
            c0411a.LN = br.RV();
            c0411a.adi = 1;
            c0411a.adj = br.getOsVersion();
            c0411a.adk = br.Sg();
            c0411a.adl = br.getLanguage();
            c0411a.adm = br.getLocale();
            c0411a.aNK = ((f) ServiceProvider.get(f.class)).Bk();
            c0411a.aNJ = bd.getDeviceId();
            c0411a.Qw = br.getScreenWidth(context);
            c0411a.Qv = br.getScreenHeight(context);
            c0411a.aCk = bd.m618do(context);
            c0411a.aCl = bd.getOaid();
            c0411a.aIk = bd.dp(context);
            c0411a.aIB = bd.dq(context);
            c0411a.adn = com.kwad.sdk.c.a.a.getStatusBarHeight(context);
            c0411a.ado = com.kwad.sdk.c.a.a.a(context, 50.0f);
            return c0411a;
        }
    }
}
