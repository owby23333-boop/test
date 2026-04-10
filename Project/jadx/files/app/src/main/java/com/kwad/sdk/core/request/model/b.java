package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.utils.x;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.kwai.a {
    public String OH;
    public String SN;
    public int SO;
    public int SQ;
    public String SR;
    public int ST;
    public int SU;
    public String adB;
    public String adC;
    public String akA;
    public String akB;
    public String akC;
    public String akD;
    public String akE;
    public int akF;
    public int akG;
    public String akH;
    public String akI;
    public String akJ;
    public int akK;
    public String akL;
    public String akM;
    public String akN;
    public JSONArray akO;
    public String akP;
    public String akR;
    public String akS;
    public String akT;
    public String akV;
    public String akW;
    public String akz;
    public int akQ = 0;
    public long akU = 0;

    public static b g(boolean z2, int i2) {
        b bVar = new b();
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        Context context = eVar.getContext();
        bVar.adB = at.cB(context);
        bVar.akz = at.cE(context);
        bVar.akA = at.cF(context);
        bVar.akB = bc.di(context);
        bVar.adC = at.getOaid();
        bVar.akL = bc.EB();
        bVar.SN = bc.ED();
        bVar.SO = 1;
        bVar.SQ = bc.EN();
        bVar.akE = bc.getOsVersion();
        bVar.SR = k.getLanguage();
        bVar.SU = k.getScreenHeight(context);
        bVar.ST = k.getScreenWidth(context);
        bVar.akF = k.bU(context);
        bVar.akG = k.bV(context);
        bVar.akH = at.cC(context);
        if (z2) {
            bVar.akO = InstalledAppInfoManager.bY(context);
        }
        bVar.akI = at.getDeviceId();
        bVar.akU = bc.EC();
        bVar.akJ = bc.EK();
        bVar.akN = x.Ds();
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            bVar.akM = fVar.nQ();
        }
        bVar.akK = bc.EL();
        StringBuilder sb = new StringBuilder("DeviceInfo i=");
        sb.append(eVar.getAppId());
        sb.append(",n=");
        sb.append(eVar.getAppName());
        sb.append(",external:");
        sb.append(eVar.getIsExternal());
        sb.append(",v1:");
        sb.append(eVar.getApiVersion());
        sb.append(",v2:3.3.38");
        sb.append(",d:");
        sb.append(bVar.akI);
        sb.append(",dh:");
        String str = bVar.akI;
        sb.append(str != null ? Integer.valueOf(str.hashCode()) : "");
        sb.append(",o:");
        sb.append(bVar.adC);
        sb.append(",b:417");
        sb.append(",p:");
        sb.append(ao.isInMainProcess(context));
        sb.append(",dy:");
        sb.append(com.kwad.b.kwai.a.XW);
        com.kwad.sdk.core.d.b.bL(sb.toString());
        bVar.akP = bc.EM();
        bVar.akQ = i2;
        if (sT()) {
            bVar.akR = k.D(context, "com.smile.gifmaker");
            bVar.akS = k.D(context, "com.kuaishou.nebula");
            bVar.akT = k.D(context, "com.tencent.mm");
        }
        bVar.OH = bc.EI();
        bVar.akD = ad.cn(context);
        bVar.akV = bc.ER();
        bVar.akW = bc.eE("/data/data");
        return bVar;
    }

    private static boolean sT() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sT();
    }

    public static b xC() {
        b bVar = new b();
        bVar.adC = at.getOaid();
        bVar.akI = at.getDeviceId();
        bVar.akL = bc.EB();
        bVar.SO = 1;
        bVar.SQ = bc.EN();
        bVar.akE = bc.getOsVersion();
        bVar.akN = x.Ds();
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            bVar.akM = fVar.nQ();
        }
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        if (eVar != null) {
            bVar.adB = at.cB(eVar.getContext());
        }
        return bVar;
    }
}
