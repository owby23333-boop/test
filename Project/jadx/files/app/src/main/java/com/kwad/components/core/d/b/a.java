package com.kwad.components.core.d.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.a.kwai.k;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static List<WeakReference<k.b>> IU;

    /* JADX INFO: renamed from: com.kwad.components.core.d.b.a$a, reason: collision with other inner class name */
    public static class C0395a {
        private boolean IV;
        private boolean IW;
        private boolean IX;
        private b IY;
        private c IZ;
        private boolean Ja;
        private long Jb;
        private boolean Jc;
        private boolean Jd;
        private y.b Je;
        private JSONObject Jf;
        private boolean Jg = false;
        private boolean Jh;
        private int Ji;
        private int Jj;
        private int Jk;
        private String Jl;
        private AdTemplate adTemplate;
        private final Context context;
        private IAdLivePlayModule eU;
        private int jQ;
        private int jS;

        public C0395a(Context context) {
            this.context = context;
        }

        public final C0395a J(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0395a a(b bVar) {
            this.IY = bVar;
            return this;
        }

        public final C0395a a(y.b bVar) {
            this.Je = bVar;
            return this;
        }

        public final C0395a al(boolean z2) {
            this.Ja = z2;
            return this;
        }

        public final C0395a am(String str) {
            this.Jl = str;
            return this;
        }

        public final C0395a am(boolean z2) {
            this.Jc = z2;
            return this;
        }

        public final C0395a an(int i2) {
            this.Jk = i2;
            return this;
        }

        public final C0395a an(boolean z2) {
            this.Jd = z2;
            return this;
        }

        public final C0395a ao(int i2) {
            this.jS = i2;
            return this;
        }

        public final C0395a ao(boolean z2) {
            this.Jg = z2;
            return this;
        }

        public final C0395a ap(int i2) {
            this.jQ = i2;
            return this;
        }

        public final C0395a ap(boolean z2) {
            this.IW = z2;
            return this;
        }

        public final C0395a aq(int i2) {
            this.Ji = i2;
            return this;
        }

        public final C0395a aq(boolean z2) {
            this.IX = true;
            return this;
        }

        public final C0395a ar(int i2) {
            this.Jj = i2;
            return this;
        }

        public final C0395a ar(boolean z2) {
            this.IV = z2;
            return this;
        }

        public final C0395a as(boolean z2) {
            this.Jh = z2;
            return this;
        }

        public final C0395a b(c cVar) {
            this.IZ = cVar;
            return this;
        }

        public final C0395a b(@Nullable IAdLivePlayModule iAdLivePlayModule) {
            this.eU = iAdLivePlayModule;
            return this;
        }

        public final C0395a d(JSONObject jSONObject) {
            this.Jf = jSONObject;
            return this;
        }

        public final int db() {
            return this.jQ;
        }

        public final int de() {
            return this.jS;
        }

        public final c fx() {
            return this.IZ;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final y.b getClientParams() {
            return this.Je;
        }

        public final Context getContext() {
            return this.context;
        }

        public final JSONObject hF() {
            return this.Jf;
        }

        public final IAdLivePlayModule jZ() {
            return this.eU;
        }

        public final String nh() {
            return this.Jl;
        }

        public final b ni() {
            return this.IY;
        }

        public final int nj() {
            return this.Jk;
        }

        public final boolean nk() {
            return this.Ja;
        }

        public final long nl() {
            return this.Jb;
        }

        public final boolean nm() {
            return this.Jc;
        }

        public final boolean nn() {
            return this.Jd;
        }

        public final boolean no() {
            return this.Jg;
        }

        public final boolean np() {
            return this.IW;
        }

        public final boolean nq() {
            return this.IX;
        }

        public final boolean nr() {
            return this.IV;
        }

        public final boolean ns() {
            return this.Jh;
        }

        public final int nt() {
            return this.Ji;
        }

        public final int nu() {
            return this.Jj;
        }

        public final C0395a q(long j2) {
            this.Jb = j2;
            return this;
        }
    }

    public interface b {
        void onAdClicked();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(@androidx.annotation.NonNull android.content.Context r6, @androidx.annotation.NonNull com.kwad.sdk.core.response.model.AdTemplate r7, @androidx.annotation.NonNull com.kwad.components.core.d.b.a.b r8, @androidx.annotation.Nullable com.kwad.components.core.d.b.c r9, boolean r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.d.b.a.a(android.content.Context, com.kwad.sdk.core.response.model.AdTemplate, com.kwad.components.core.d.b.a$b, com.kwad.components.core.d.b.c, boolean, boolean, boolean):int");
    }

    public static int a(C0395a c0395a) {
        d.at(false);
        if (c0395a.nr()) {
            a(c0395a.getContext(), c0395a.getAdTemplate(), c0395a.ni(), c0395a.fx(), c0395a.Ja, c0395a.nm(), false);
            return 0;
        }
        if (b(c0395a)) {
            return 0;
        }
        c0395a.getAdTemplate().converted = true;
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(c0395a.getAdTemplate());
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
        int iAf = com.kwad.sdk.core.response.a.a.af(adInfoCb);
        if (!(c0395a.nu() == 2 || c0395a.nu() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aL(adInfoCb)) && !c0395a.nq()) {
            if (iAf == 1) {
                boolean zBa = com.kwad.sdk.core.response.a.a.ba(adInfoCb);
                e(c0395a);
                if (zBa) {
                    c(c0395a.getContext(), c0395a.getAdTemplate());
                } else {
                    a(c0395a.getContext(), new AdWebViewActivityProxy.a.C0405a().as(com.kwad.sdk.core.response.a.b.bh(c0395a.getAdTemplate())).M(c0395a.getAdTemplate()).ow());
                }
                return 0;
            }
            if (iAf == 2) {
                if (a(c0395a, 1) == 1) {
                    if (com.kwad.sdk.core.response.a.a.cn(adInfoCb)) {
                        com.kwad.sdk.core.report.a.m(c0395a.getAdTemplate(), (int) Math.ceil(c0395a.nl() / 1000.0f));
                    }
                    d.at(true);
                    e(c0395a);
                    return 0;
                }
                boolean zBa2 = com.kwad.sdk.core.response.a.a.ba(adInfoCb);
                e(c0395a);
                if (zBa2) {
                    c(c0395a.getContext(), c0395a.getAdTemplate());
                } else {
                    a(c0395a.getContext(), new AdWebViewActivityProxy.a.C0405a().as(com.kwad.sdk.core.response.a.b.bh(c0395a.getAdTemplate())).M(c0395a.getAdTemplate()).ow());
                }
                return 0;
            }
        }
        if (a(c0395a, 1) == 1) {
            if (com.kwad.sdk.core.response.a.a.cn(adInfoCb) || com.kwad.sdk.core.response.a.a.co(adInfoCb)) {
                com.kwad.sdk.core.report.a.m(c0395a.getAdTemplate(), (int) Math.ceil(c0395a.nl() / 1000.0f));
            }
            d.at(true);
            e(c0395a);
            return 0;
        }
        if (e.e(c0395a.getContext(), c0395a.getAdTemplate()) == 1) {
            e(c0395a);
            return 0;
        }
        if (c0395a.np() && !com.kwad.sdk.core.response.a.a.ay(adInfoCb)) {
            e(c0395a);
            i(c0395a);
            return 0;
        }
        if (!com.kwad.sdk.core.response.a.a.ay(adInfoCb)) {
            if (c0395a.getAdTemplate().isWebViewDownload) {
                return h(c0395a);
            }
            boolean zG = com.kwad.sdk.utils.d.g(c0395a.getContext(), com.kwad.sdk.core.response.a.a.cs(adInfoCb), com.kwad.sdk.core.response.a.a.ar(adInfoCb));
            e(c0395a);
            if (zG) {
                com.kwad.sdk.core.report.a.k(c0395a.getAdTemplate(), 0);
                return 0;
            }
            a(c0395a.getContext(), new AdWebViewActivityProxy.a.C0405a().as(com.kwad.sdk.core.response.a.b.bh(c0395a.getAdTemplate())).M(c0395a.getAdTemplate()).ow());
            return 0;
        }
        if (com.kwad.sdk.core.response.a.a.ay(adInfoCb)) {
            if (c0395a.nu() == 2 || c0395a.nu() == 1) {
                c0395a.ao(false);
                e(c0395a);
            } else {
                e(c0395a);
                if (!c(c0395a)) {
                    c0395a.ao(true);
                }
            }
            return h(c0395a);
        }
        return 0;
    }

    private static int a(C0395a c0395a, int i2) {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = c0395a.getAdTemplate();
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck((adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) ? null : KSLoggerReporter.bs(sceneImpl.getAdStyle()), "dplinkStart").report();
        return d.b(c0395a, 1);
    }

    private static void a(Context context, AdWebViewActivityProxy.a aVar) {
        AdWebViewActivityProxy.launch(context, aVar);
        if (aVar.getAdTemplate() == null || aVar.getAdTemplate().mAdScene == null) {
            return;
        }
        KSLoggerReporter.bs(aVar.getAdTemplate().mAdScene.getAdStyle());
    }

    public static void a(k.b bVar) {
        if (IU == null) {
            IU = new CopyOnWriteArrayList();
        }
        IU.add(new WeakReference<>(bVar));
    }

    public static void b(k.b bVar) {
        if (IU == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= IU.size()) {
                i2 = -1;
                break;
            }
            WeakReference<k.b> weakReference = IU.get(i2);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            IU.remove(i2);
        }
    }

    private static boolean b(C0395a c0395a) {
        return com.kwad.sdk.core.response.a.a.ay(com.kwad.sdk.core.response.a.d.cb(c0395a.getAdTemplate())) ? !c0395a.ns() && c.s(c0395a) == 3 : d(c0395a) == 1;
    }

    private static void c(Context context, AdTemplate adTemplate) {
        AdWebViewVideoActivityProxy.launch(context, adTemplate);
        SceneImpl sceneImpl = adTemplate.mAdScene;
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(sceneImpl != null ? KSLoggerReporter.bs(sceneImpl.getAdStyle()) : null, "toVideoH5Web").report();
    }

    private static boolean c(C0395a c0395a) {
        AdTemplate adTemplate = c0395a.getAdTemplate();
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (!c0395a.np() || !com.kwad.sdk.core.response.a.a.b(adInfoCb, com.kwad.sdk.core.config.d.uy()) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aL(adInfoCb)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0395a.fx().nC()) {
            return false;
        }
        c(c0395a.getContext(), adTemplate);
        return true;
    }

    private static int d(C0395a c0395a) {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(c0395a.getAdTemplate());
        if (adInfoCb.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int iDb = c0395a.db();
        return iDb != 2 ? iDb != 3 ? adInfoCb.unDownloadConf.unDownloadRegionConf.actionBarType : adInfoCb.unDownloadConf.unDownloadRegionConf.materialJumpType : adInfoCb.unDownloadConf.unDownloadRegionConf.describeBarType;
    }

    private static void e(C0395a c0395a) {
        g(c0395a);
        f(c0395a);
        if (c0395a.ni() != null) {
            c0395a.ni().onAdClicked();
        }
    }

    private static void f(C0395a c0395a) {
        if (c0395a.nn()) {
            com.kwad.sdk.core.report.a.a(c0395a.adTemplate, c0395a.Je, c0395a.hF());
        }
    }

    private static void g(C0395a c0395a) {
        k.b bVar;
        List<WeakReference<k.b>> list = IU;
        if (list == null || list.isEmpty() || c0395a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : IU) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.y(com.kwad.sdk.core.response.a.d.ck(c0395a.adTemplate));
            }
        }
    }

    private static int h(C0395a c0395a) {
        c cVarFx = c0395a.fx();
        if (cVarFx == null) {
            cVarFx = new c(c0395a.adTemplate);
            c0395a.b(cVarFx);
        }
        SceneImpl sceneImpl = c0395a.getAdTemplate().mAdScene;
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(sceneImpl != null ? KSLoggerReporter.bs(sceneImpl.getAdStyle()) : null, "toDownload").report();
        return cVarFx.m(c0395a);
    }

    private static void i(C0395a c0395a) {
        AdTemplate adTemplate = c0395a.getAdTemplate();
        Context context = c0395a.getContext();
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (com.kwad.sdk.utils.d.g(context, com.kwad.sdk.core.response.a.a.cs(adInfoCb), com.kwad.sdk.core.response.a.a.ar(adInfoCb))) {
            com.kwad.sdk.core.report.a.k(adTemplate, 0);
        } else if (!com.kwad.sdk.core.response.a.a.b(adInfoCb, com.kwad.sdk.core.config.d.uy()) || adTemplate.mAdWebVideoPageShowing) {
            a(context, new AdWebViewActivityProxy.a.C0405a().as(com.kwad.sdk.core.response.a.b.bh(c0395a.getAdTemplate())).M(c0395a.getAdTemplate()).ow());
        } else {
            c(context, adTemplate);
        }
    }
}
