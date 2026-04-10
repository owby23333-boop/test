package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.b.k;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static List<WeakReference<k.b>> OT;

    public interface b {
        void onAdClicked();
    }

    public static int a(Context context, AdTemplate adTemplate, b bVar, c cVar, boolean z, boolean z2, boolean z3, boolean z4) {
        com.kwad.sdk.commercial.d.a.f(adTemplate, true);
        adTemplate.converted = true;
        d.az(false);
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        C0333a c0333aAt = new C0333a(context).aB(adTemplate).a(bVar).b(cVar).aq(z).ar(z2).an(z4).at(false);
        int iAn = com.kwad.sdk.core.response.b.a.an(adInfoEl);
        if (!(z3 || c0333aAt.px() == 2 || c0333aAt.px() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfoEl)) && !c0333aAt.pt()) {
            if (iAn == 1) {
                if (com.kwad.sdk.core.response.b.a.bi(adInfoEl)) {
                    return k(c0333aAt);
                }
                return l(c0333aAt);
            }
            if (iAn == 2) {
                int iH = h(c0333aAt);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bi(adInfoEl)) {
                    return k(c0333aAt);
                }
                return l(c0333aAt);
            }
        }
        int iH2 = h(c0333aAt);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(adInfoEl)) {
            if (j(c0333aAt)) {
                return 11;
            }
            return l(c0333aAt);
        }
        int iM = m(c0333aAt);
        if (adInfoEl.status != 2 && adInfoEl.status != 3) {
            e(c0333aAt);
        }
        return iM;
    }

    public static int a(C0333a c0333a) {
        Context context = c0333a.getContext();
        AdTemplate adTemplate = c0333a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        d.az(false);
        if (c0333a.pl()) {
            return b(c0333a);
        }
        if (c0333a.pu()) {
            return a(context, adTemplate, c0333a.ph(), c0333a.ij(), c0333a.Pd, c0333a.po(), false, c0333a.pk());
        }
        com.kwad.sdk.commercial.d.a.f(adTemplate, false);
        if (c(c0333a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        int iAn = com.kwad.sdk.core.response.b.a.an(adInfoEl);
        if (!(c0333a.px() == 2 || c0333a.px() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfoEl)) && !c0333a.pt()) {
            if (iAn == 1) {
                if (com.kwad.sdk.core.response.b.a.bi(adInfoEl)) {
                    return k(c0333a);
                }
                return l(c0333a);
            }
            if (iAn == 2) {
                int iH = h(c0333a);
                if (iH == 1) {
                    return 13;
                }
                if (iH == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bi(adInfoEl)) {
                    return k(c0333a);
                }
                return l(c0333a);
            }
        }
        int iH2 = h(c0333a);
        if (iH2 == 1) {
            return 13;
        }
        if (iH2 == 2) {
            return 16;
        }
        int i = i(c0333a);
        if (i == 1) {
            return 12;
        }
        if (i == 2) {
            return 17;
        }
        if (c0333a.ps() && !com.kwad.sdk.core.response.b.a.aF(adInfoEl)) {
            return n(c0333a);
        }
        if (!com.kwad.sdk.core.response.b.a.aF(adInfoEl)) {
            if (adTemplate.isWebViewDownload) {
                int iM = m(c0333a);
                adTemplate.isWebViewDownload = false;
                return iM;
            }
            if (j(c0333a)) {
                return 11;
            }
            return l(c0333a);
        }
        if (c0333a.px() == 2 || c0333a.px() == 1) {
            c0333a.at(false);
            e(c0333a);
            return m(c0333a);
        }
        if (c0333a.ps() && com.kwad.sdk.core.response.b.a.b(adInfoEl, com.kwad.sdk.core.config.e.Fn()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(adInfoEl)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
            int iQ = c0333a.ij().q(c0333a);
            if (iQ == 0) {
                return k(c0333a);
            }
            e(c0333a);
            d(adTemplate, iQ);
            return iQ;
        }
        e(c0333a);
        c0333a.at(true);
        return m(c0333a);
    }

    private static int b(C0333a c0333a) {
        Context context = c0333a.getContext();
        AdTemplate adTemplate = c0333a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        Activity activityEj = m.ej(context);
        if (activityEj != null && com.kwad.sdk.core.response.b.a.V(adInfoEl) && !c0333a.pf() && !c0333a.pk()) {
            c0333a.ay(2);
            com.kwad.components.core.e.e.e.a(activityEj, c0333a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0344a().aA(com.kwad.sdk.core.response.b.b.cN(adTemplate)).aD(adTemplate).aG(true).qW());
        d(adTemplate, 20);
        return 20;
    }

    private static boolean c(C0333a c0333a) {
        return com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(c0333a.getAdTemplate())) ? !c0333a.pv() && c.A(c0333a) == 3 : d(c0333a) == 1;
    }

    private static int d(C0333a c0333a) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(c0333a.getAdTemplate());
        if (adInfoEl.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int iDW = c0333a.dW();
        if (iDW == 2) {
            return adInfoEl.unDownloadConf.unDownloadRegionConf.describeBarType;
        }
        if (iDW == 3) {
            return adInfoEl.unDownloadConf.unDownloadRegionConf.materialJumpType;
        }
        return adInfoEl.unDownloadConf.unDownloadRegionConf.actionBarType;
    }

    private static void e(C0333a c0333a) {
        if (c0333a.pf()) {
            return;
        }
        g(c0333a);
        f(c0333a);
        if (c0333a.ph() != null) {
            try {
                c0333a.ph().onAdClicked();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        com.kwad.sdk.commercial.d.a.bo(c0333a.getAdTemplate());
    }

    private static void f(C0333a c0333a) {
        if (c0333a.pp()) {
            com.kwad.sdk.core.adlog.c.a(c0333a.adTemplate, c0333a.pq(), c0333a.ix());
        }
    }

    public static void a(k.b bVar) {
        if (OT == null) {
            OT = new CopyOnWriteArrayList();
        }
        OT.add(new WeakReference<>(bVar));
    }

    public static void b(k.b bVar) {
        if (OT == null) {
            return;
        }
        int i = 0;
        while (true) {
            if (i >= OT.size()) {
                i = -1;
                break;
            }
            WeakReference<k.b> weakReference = OT.get(i);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            OT.remove(i);
        }
    }

    private static void g(C0333a c0333a) {
        k.b bVar;
        List<WeakReference<k.b>> list = OT;
        if (list == null || list.isEmpty() || c0333a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : OT) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.S(com.kwad.sdk.core.response.b.e.ev(c0333a.adTemplate));
            }
        }
    }

    private static int h(C0333a c0333a) {
        AdTemplate adTemplate = c0333a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        int iA = d.a(c0333a, 1);
        if (iA == 1) {
            d.az(true);
            e(c0333a);
            if ((com.kwad.sdk.core.response.b.a.cQ(adInfoEl) || com.kwad.sdk.core.response.b.a.cR(adInfoEl)) && !c0333a.py()) {
                com.kwad.sdk.core.adlog.c.m(c0333a.getAdTemplate(), (int) Math.ceil(c0333a.pn() / 1000.0f));
            }
            d(adTemplate, 13);
        } else if (iA == 2) {
            e(c0333a);
            d(adTemplate, 16);
        }
        return iA;
    }

    private static int i(C0333a c0333a) {
        Context context = c0333a.getContext();
        AdTemplate adTemplate = c0333a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(c0333a.getAdTemplate());
        Activity activityEj = m.ej(c0333a.getContext());
        if (activityEj != null && com.kwad.sdk.core.response.b.a.T(adInfoEl) && !c0333a.pf() && e.E(adInfoEl) && !c0333a.pk()) {
            c0333a.ay(1);
            com.kwad.components.core.e.e.e.a(activityEj, c0333a);
            e(c0333a);
            d(adTemplate, 17);
            return 2;
        }
        int iE = e.e(context, adTemplate);
        if (iE == 1) {
            e(c0333a);
            d(adTemplate, 12);
        }
        return iE;
    }

    private static boolean j(C0333a c0333a) {
        AdTemplate adTemplate = c0333a.getAdTemplate();
        boolean zI = com.kwad.sdk.utils.e.i(c0333a.getContext(), adTemplate);
        if (zI) {
            e(c0333a);
            com.kwad.sdk.core.adlog.c.k(adTemplate, 0);
            d(adTemplate, 11);
        }
        return zI;
    }

    private static int k(C0333a c0333a) {
        e(c0333a);
        AdTemplate adTemplate = c0333a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(c0333a.getAdTemplate());
        Activity activityEj = m.ej(c0333a.getContext());
        if (activityEj != null && com.kwad.sdk.core.response.b.a.V(adInfoEl) && !c0333a.pf() && !c0333a.pk()) {
            c0333a.ay(2);
            com.kwad.components.core.e.e.e.a(activityEj, c0333a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewVideoActivityProxy.launch(c0333a.getContext(), adTemplate);
        d(adTemplate, 15);
        return 15;
    }

    private static int l(C0333a c0333a) {
        e(c0333a);
        Context context = c0333a.getContext();
        AdTemplate adTemplate = c0333a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        Activity activityEj = m.ej(context);
        if (activityEj != null && com.kwad.sdk.core.response.b.a.V(adInfoEl) && !c0333a.pf() && !c0333a.pk()) {
            c0333a.ay(2);
            com.kwad.components.core.e.e.e.a(activityEj, c0333a);
            d(adTemplate, 19);
            return 19;
        }
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0344a().aA(com.kwad.sdk.core.response.b.b.cN(adTemplate)).aD(adTemplate).aH(c0333a.pi()).aO(1).qW());
        d(adTemplate, 14);
        return 14;
    }

    private static int m(C0333a c0333a) {
        c cVarIj = c0333a.ij();
        if (cVarIj == null) {
            cVarIj = new c(c0333a.adTemplate);
            c0333a.b(cVarIj);
        }
        int iR = cVarIj.r(c0333a);
        d(c0333a.getAdTemplate(), iR);
        return iR;
    }

    private static void d(AdTemplate adTemplate, int i) {
        switch (i) {
            case 0:
                com.kwad.sdk.commercial.d.a.bE(adTemplate);
                break;
            case 1:
                com.kwad.sdk.commercial.d.a.bt(adTemplate);
                break;
            case 2:
                com.kwad.sdk.commercial.d.a.bD(adTemplate);
                break;
            case 3:
                com.kwad.sdk.commercial.d.a.bv(adTemplate);
                break;
            case 4:
                com.kwad.sdk.commercial.d.a.bB(adTemplate);
                break;
            case 5:
                com.kwad.sdk.commercial.d.a.bC(adTemplate);
                break;
            case 6:
                com.kwad.sdk.commercial.d.a.bw(adTemplate);
                break;
            case 7:
                com.kwad.sdk.commercial.d.a.bx(adTemplate);
                break;
            case 8:
                com.kwad.sdk.commercial.d.a.by(adTemplate);
                break;
            case 9:
                com.kwad.sdk.commercial.d.a.bA(adTemplate);
                break;
            case 10:
                com.kwad.sdk.commercial.d.a.bz(adTemplate);
                break;
            case 11:
                com.kwad.sdk.commercial.d.a.bs(adTemplate);
                break;
            case 12:
                com.kwad.sdk.commercial.d.a.br(adTemplate);
                break;
            case 13:
                com.kwad.sdk.commercial.d.a.bq(adTemplate);
                break;
            case 14:
                com.kwad.sdk.commercial.d.a.bp(adTemplate);
                break;
            case 15:
                com.kwad.sdk.commercial.d.a.bu(adTemplate);
                break;
            case 16:
                com.kwad.sdk.commercial.d.a.bG(adTemplate);
                break;
            case 17:
                com.kwad.sdk.commercial.d.a.bJ(adTemplate);
                break;
            case 18:
                com.kwad.sdk.commercial.d.a.bF(adTemplate);
                break;
            case 19:
                com.kwad.sdk.commercial.d.a.bH(adTemplate);
                break;
            case 20:
                com.kwad.sdk.commercial.d.a.bI(adTemplate);
                break;
        }
    }

    private static int n(C0333a c0333a) {
        AdTemplate adTemplate = c0333a.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (j(c0333a)) {
            return 11;
        }
        if (com.kwad.sdk.core.response.b.a.b(adInfoEl, com.kwad.sdk.core.config.e.Fn()) && !adTemplate.mAdWebVideoPageShowing) {
            return k(c0333a);
        }
        return l(c0333a);
    }

    /* JADX INFO: renamed from: com.kwad.components.core.e.d.a$a, reason: collision with other inner class name */
    public static class C0333a {
        private boolean OU;
        private boolean OV;
        private boolean OW;
        private boolean OX;
        private boolean OY;
        private boolean OZ;
        private boolean Pa;
        private b Pb;
        private c Pc;
        private boolean Pd;
        private boolean Pe;
        private long Pf;
        private boolean Pg;
        private boolean Ph;
        public String Pj;
        public a.C0392a Pk;
        private JSONObject Pn;
        private boolean Pp;
        private int Pq;
        private int Pr;
        private int Ps;
        private int Pt;
        private Callable<String> Pu;
        private String Pv;
        private AdTemplate adTemplate;
        private final Context context;
        private int mG;
        private int mI;
        public aj.a mK;
        public long yU;
        public int Pi = -1;
        public int Pl = 0;
        public int Pm = -1;
        private boolean Po = false;

        public C0333a(Context context) {
            this.context = context;
        }

        public final String pd() {
            return this.Pv;
        }

        public final C0333a al(String str) {
            this.Pv = str;
            return this;
        }

        public final C0333a a(Callable<String> callable) {
            this.Pu = callable;
            return this;
        }

        public final Callable<String> pe() {
            return this.Pu;
        }

        public final Context getContext() {
            return this.context;
        }

        public final void am(boolean z) {
            this.Pe = true;
        }

        public final boolean pf() {
            return this.Pe;
        }

        public final void ay(int i) {
            this.Pr = i;
        }

        public final int pg() {
            return this.Pr;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final C0333a aB(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final b ph() {
            return this.Pb;
        }

        public final boolean pi() {
            return this.OY;
        }

        public final C0333a a(b bVar) {
            this.Pb = bVar;
            return this;
        }

        public final int pj() {
            return this.Pt;
        }

        public final C0333a az(int i) {
            this.Pt = i;
            return this;
        }

        public final C0333a aA(int i) {
            this.mI = i;
            return this;
        }

        public final int dZ() {
            return this.mI;
        }

        public final C0333a an(boolean z) {
            this.OZ = z;
            return this;
        }

        public final boolean pk() {
            return this.OZ;
        }

        public final c ij() {
            return this.Pc;
        }

        public final C0333a b(c cVar) {
            this.Pc = cVar;
            return this;
        }

        public final C0333a ao(boolean z) {
            this.Pa = true;
            return this;
        }

        public final boolean pl() {
            return this.Pa;
        }

        public final C0333a ap(boolean z) {
            this.OY = true;
            return this;
        }

        public final boolean pm() {
            return this.Pd;
        }

        public final C0333a aq(boolean z) {
            this.Pd = z;
            return this;
        }

        public final long pn() {
            return this.Pf;
        }

        public final C0333a A(long j) {
            this.Pf = j;
            return this;
        }

        public final boolean po() {
            return this.Pg;
        }

        public final C0333a ar(boolean z) {
            this.Pg = z;
            return this;
        }

        public final int dW() {
            return this.mG;
        }

        public final C0333a aB(int i) {
            this.mG = i;
            return this;
        }

        public final boolean pp() {
            return this.Ph;
        }

        public final C0333a as(boolean z) {
            this.Ph = z;
            return this;
        }

        public final com.kwad.sdk.core.adlog.c.a pq() {
            return com.kwad.sdk.core.adlog.c.a.EK().cX(this.mI).dr(this.Pj).e(this.mK).cY(this.Pl).cZ(this.Pm).au(this.yU).a(this.Pk).da(this.Pi);
        }

        public final C0333a am(String str) {
            this.Pj = str;
            return this;
        }

        public final C0333a aC(int i) {
            this.Pl = i;
            return this;
        }

        public final C0333a aD(int i) {
            this.Pm = i;
            return this;
        }

        public final C0333a B(long j) {
            this.yU = j;
            return this;
        }

        public final C0333a d(aj.a aVar) {
            this.mK = aVar;
            return this;
        }

        public final C0333a a(String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            if (this.Pk == null) {
                this.Pk = new a.C0392a();
            }
            this.Pk.a(this.adTemplate, null, null, null);
            return this;
        }

        public final boolean pr() {
            return this.Po;
        }

        public final C0333a at(boolean z) {
            this.Po = z;
            return this;
        }

        public final JSONObject ix() {
            return this.Pn;
        }

        public final C0333a c(JSONObject jSONObject) {
            this.Pn = jSONObject;
            return this;
        }

        public final boolean ps() {
            return this.OV;
        }

        public final C0333a au(boolean z) {
            this.OV = z;
            return this;
        }

        public final boolean pt() {
            return this.OX;
        }

        public final C0333a av(boolean z) {
            this.OX = true;
            return this;
        }

        public final boolean pu() {
            return this.OU;
        }

        public final C0333a aw(boolean z) {
            this.OU = z;
            return this;
        }

        public final boolean pv() {
            return this.Pp;
        }

        public final C0333a ax(boolean z) {
            this.Pp = z;
            return this;
        }

        public final int pw() {
            return this.Pq;
        }

        public final C0333a aE(int i) {
            this.Pq = i;
            return this;
        }

        public final int px() {
            return this.Ps;
        }

        public final C0333a aF(int i) {
            this.Ps = i;
            return this;
        }

        public final boolean py() {
            return this.OW;
        }

        public final C0333a ay(boolean z) {
            this.OW = true;
            return this;
        }
    }
}
