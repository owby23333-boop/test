package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.components.h;
import com.kwad.sdk.components.p;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.s;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    private static boolean aIb;
    private static JSONArray aIc;
    public String LM;
    public String LN;
    public String LO;
    public String LP;
    public String LQ;
    public int Qv;
    public int Qw;
    public String aCk;
    public String aCl;
    public String aId;
    public String aIe;
    public String aIf;
    public String aIg;
    public String aIh;
    public int aIi;
    public int aIj;
    public String aIk;
    public String aIl;
    public int aIm;
    public String aIn;
    public String aIo;
    public JSONArray aIp;
    public String aIq;
    public String aIr;
    public String aIt;
    public String aIu;
    public String aIv;

    @Deprecated
    public String aIx;
    public String aIy;
    public int aIz;
    public int adi;
    public int adk;
    public String adl;
    public String uaid;
    public int aIs = 0;
    public long aIw = 0;

    public static b IK() {
        b bVar = new b();
        try {
            bVar.aCl = bd.getOaid();
            bVar.LQ = bd.getDeviceId();
            bVar.LM = br.RT();
            bVar.adi = 1;
            bVar.adk = br.Sg();
            bVar.LO = br.getOsVersion();
            bVar.aIo = ag.Qz();
            if (ag.QC()) {
                bVar.aIq = ag.QB();
            }
            if (ag.QD() && !TextUtils.isEmpty(ag.QA())) {
                bVar.uaid = ag.QA();
            }
            h hVar = (h) com.kwad.sdk.components.d.f(h.class);
            if (hVar != null) {
                bVar.aIn = hVar.qd();
            }
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) != null) {
                bVar.aCk = bd.m618do(ServiceProvider.Pp());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    public static b h(boolean z, int i) {
        b bVar = new b();
        try {
            Context contextPp = ServiceProvider.Pp();
            bVar.aCk = bd.m618do(contextPp);
            bVar.aId = bd.dr(contextPp);
            bVar.aIe = bd.ds(contextPp);
            bVar.aIf = br.dU(contextPp);
            bVar.aCl = bd.getOaid();
            bVar.LM = br.RT();
            bVar.LN = br.RV();
            bVar.adi = 1;
            bVar.adk = br.Sg();
            bVar.LO = br.getOsVersion();
            bVar.adl = m.getLanguage();
            bVar.Qv = m.getScreenHeight(contextPp);
            bVar.Qw = m.getScreenWidth(contextPp);
            bVar.aIi = m.cI(contextPp);
            bVar.aIj = m.cJ(contextPp);
            bVar.aIk = bd.dp(contextPp);
            if (z) {
                bVar.aIp = bF(contextPp);
            }
            bVar.aIz = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Ca();
            bVar.aIr = br.Sf();
            if (ag.QC()) {
                bVar.aIq = ag.QB();
            }
            if (ag.QD() && !TextUtils.isEmpty(ag.QA())) {
                bVar.uaid = ag.QA();
            }
            bVar.LQ = bd.getDeviceId();
            bVar.aIw = br.RU();
            bVar.aIl = br.Sd();
            bVar.aIo = ag.Qz();
            h hVar = (h) com.kwad.sdk.components.d.f(h.class);
            if (hVar != null) {
                bVar.aIn = hVar.qd();
            }
            bVar.aIm = br.Se();
            try {
                com.kwad.sdk.core.d.c.T("DeviceInfo", a((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class), bVar, contextPp));
            } catch (Exception unused) {
            }
            bVar.aIr = br.Sf();
            bVar.aIs = i;
            if (BC() && com.kwad.sdk.app.b.Dw() != null) {
                bVar.aIt = com.kwad.sdk.app.b.Dw().getVersion(contextPp, "com.smile.gifmaker");
                bVar.aIu = com.kwad.sdk.app.b.Dw().getVersion(contextPp, "com.kuaishou.nebula");
                bVar.aIv = com.kwad.sdk.app.b.Dw().getVersion(contextPp, "com.tencent.mm");
            }
            bVar.LP = br.Sb();
            bVar.aIh = am.dc(contextPp);
            bVar.aIy = br.hz("/data/data");
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return bVar;
    }

    private static boolean BC() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BC();
    }

    private static boolean BD() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BD();
    }

    private static String a(com.kwad.sdk.service.a.f fVar, b bVar, Context context) {
        StringBuilder sbAppend = new StringBuilder("i=").append(fVar.getAppId()).append(",n=").append(fVar.getAppName()).append(",external:").append(fVar.Bk()).append(",v1:").append(fVar.getApiVersion()).append(",v2:4.6.30.1,d:").append(bVar.LQ).append(",dh:");
        String str = bVar.LQ;
        String string = sbAppend.append(str != null ? Integer.valueOf(str.hashCode()) : "").append(",b:214,p:").append(ay.isInMainProcess(context)).append(",dy:").append(com.kwad.framework.a.a.akY).toString();
        return !BD() ? string + ",o:" + bVar.aCl : string;
    }

    private static synchronized JSONArray bF(Context context) {
        if (!aIb) {
            aIb = true;
            p pVar = (p) com.kwad.sdk.components.d.f(p.class);
            com.kwad.sdk.core.d.c.d("DeviceInfo", "getAppList: OptDataFetchComponent: " + pVar);
            if (pVar != null && s.PW()) {
                pVar.a(context, new com.kwad.sdk.g.a<JSONArray>() { // from class: com.kwad.sdk.core.request.model.b.1
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(JSONArray jSONArray) {
                        g(jSONArray);
                    }

                    private static void g(JSONArray jSONArray) {
                        JSONArray unused = b.aIc = jSONArray;
                    }
                });
            }
        }
        JSONArray jSONArray = aIc;
        if (jSONArray == null) {
            return null;
        }
        aIc = null;
        return jSONArray;
    }
}
