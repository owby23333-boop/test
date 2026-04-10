package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bc;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.kwad.sdk.core.webview.b.a {

    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public String SG;
        public int SH;
        public String SI;
        public int SJ;
        public int SK;
        public String SL;
        public String SM;
        public String SN;
        public int SO;
        public String SP;
        public int SQ;
        public String SR;
        public String SS;
        public int ST;
        public int SU;
        public int SV;
        public int SW;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;

        public static a rp() {
            a aVar = new a();
            aVar.SG = "3.3.38";
            aVar.SH = 3033800;
            aVar.SI = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersion();
            aVar.SJ = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getApiVersionCode();
            aVar.SK = 1;
            Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
            aVar.appVersion = com.kwad.sdk.utils.k.bS(context);
            aVar.appName = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getAppName();
            aVar.appId = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getAppId();
            aVar.SL = String.valueOf(com.kwad.sdk.utils.af.cp(context));
            aVar.SM = bc.EK();
            aVar.model = bc.EB();
            aVar.SN = bc.ED();
            aVar.SO = 1;
            aVar.SP = bc.getOsVersion();
            aVar.SQ = bc.EN();
            aVar.SR = bc.getLanguage();
            aVar.SS = bc.getLocale();
            aVar.ST = bc.getScreenWidth(context);
            aVar.SU = bc.getScreenHeight(context);
            aVar.SV = com.kwad.sdk.b.kwai.a.getStatusBarHeight(context);
            aVar.SW = com.kwad.sdk.b.kwai.a.a(context, 50.0f);
            return aVar;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        cVar.a(a.rp());
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getKsPlayableDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
