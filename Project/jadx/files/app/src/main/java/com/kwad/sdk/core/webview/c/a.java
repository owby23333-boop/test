package com.kwad.sdk.core.webview.c;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.components.c;
import com.kwad.sdk.components.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.x;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.webview.b.a {

    /* JADX INFO: renamed from: com.kwad.sdk.core.webview.c.a$a, reason: collision with other inner class name */
    public static final class C0448a extends com.kwad.sdk.core.response.kwai.a {
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
        public String adB;
        public String adC;
        public String aje;
        public String akH;
        public String akM;
        public String akN;
        public String ala;
        public String apC;
        public String apD;
        public boolean apE;
        public String apF;
        public String appId;
        public String appName;
        public String appVersion;
        public String model;

        public static C0448a zq() {
            C0448a c0448a = new C0448a();
            c0448a.SG = "3.3.38";
            c0448a.SH = 3033800;
            c0448a.aje = "5.0.0";
            c0448a.apF = "1.0";
            c0448a.SI = ((e) ServiceProvider.get(e.class)).getApiVersion();
            c0448a.SJ = ((e) ServiceProvider.get(e.class)).getApiVersionCode();
            c0448a.SK = 1;
            Context context = ((e) ServiceProvider.get(e.class)).getContext();
            c0448a.appVersion = k.bS(context);
            c0448a.appName = ((e) ServiceProvider.get(e.class)).getAppName();
            c0448a.appId = ((e) ServiceProvider.get(e.class)).getAppId();
            c0448a.apC = "";
            c0448a.akN = x.Ds();
            f fVar = (f) c.f(f.class);
            if (fVar != null) {
                c0448a.akM = fVar.nQ();
            }
            c0448a.SL = String.valueOf(af.cp(context));
            c0448a.SM = bc.EK();
            c0448a.model = bc.EB();
            c0448a.SN = bc.ED();
            c0448a.SO = 1;
            c0448a.SP = bc.getOsVersion();
            c0448a.SQ = bc.EN();
            c0448a.SR = bc.getLanguage();
            c0448a.SS = bc.getLocale();
            c0448a.apE = ((e) ServiceProvider.get(e.class)).getIsExternal();
            c0448a.apD = at.getDeviceId();
            c0448a.ST = bc.getScreenWidth(context);
            c0448a.SU = bc.getScreenHeight(context);
            c0448a.adB = at.cB(context);
            c0448a.adC = at.getOaid();
            c0448a.akH = at.cC(context);
            c0448a.ala = at.cD(context);
            c0448a.SV = com.kwad.sdk.b.kwai.a.getStatusBarHeight(context);
            c0448a.SW = com.kwad.sdk.b.kwai.a.a(context, 50.0f);
            return c0448a;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        cVar.a(C0448a.zq());
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getDeviceInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
