package com.kwad.components.ad.splashscreen.monitor;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static volatile b FT;

    public static b lZ() {
        if (FT == null) {
            synchronized (b.class) {
                if (FT == null) {
                    FT = new b();
                }
            }
        }
        return FT;
    }

    public static void u(long j) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(1).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setPosId(j));
    }

    public static void f(long j, long j2) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(11).setBeforeLoadDataTime(j2).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setPosId(j));
    }

    public static void e(AdTemplate adTemplate, long j) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(2).setBeforeLoadDataTime(j).setLoadDataTime(adTemplate.loadDataTime).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(com.kwad.sdk.core.response.b.e.el(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, long j, long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(3).setLoadDataTime(adTemplate.loadDataTime).setCheckStatus(i).setCheckDataTime(jElapsedRealtime).setBeforeLoadDataTime(j2).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setLoadAndCheckDataTime(adTemplate.loadDataTime + jElapsedRealtime).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(com.kwad.sdk.core.response.b.e.el(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, int i, long j, long j2) {
        String strK;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(adInfoEl)) {
            strK = com.kwad.sdk.core.response.b.a.K(adInfoEl);
        } else {
            strK = com.kwad.sdk.core.response.b.a.aU(adInfoEl).materialUrl;
        }
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setType(adTemplate.notNetworkRequest ? 2 : 1).setStatus(5).setCheckStatus(i).setLoadDataTime(adTemplate.loadDataTime).setCheckDataTime(jElapsedRealtime).setBeforeLoadDataTime(j2).setLoadAndCheckDataTime(adTemplate.loadDataTime + jElapsedRealtime).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(adInfoEl)).setUrl(strK).setAdTemplate(adTemplate));
    }

    public static void v(long j) {
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(1).setPosId(j));
    }

    public static void a(List<AdTemplate> list, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.kwad.sdk.core.response.b.a.aZ(com.kwad.sdk.core.response.b.e.el(it.next())));
        }
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(2).setIds(arrayList).setLoadDataTime(j).setCount(list.size()).setPosId(j2));
    }

    public static void b(int i, String str, long j) {
        com.kwad.sdk.commercial.b.k(new SplashMonitorInfo().setStatus(3).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void a(AdTemplate adTemplate, long j, int i, int i2) {
        String strK;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(adInfoEl)) {
            strK = com.kwad.sdk.core.response.b.a.K(adInfoEl);
        } else {
            strK = com.kwad.sdk.core.response.b.a.aU(adInfoEl).materialUrl;
        }
        File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(com.kwad.sdk.core.response.b.a.aZ(adInfoEl));
        com.kwad.sdk.commercial.b.g(false, new SplashMonitorInfo().setStatus(1).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(adInfoEl)).setCostTime(j).setCacheValidTime(((long) adInfoEl.adPreloadInfo.validityPeriod) * 1000).setSize((fileCf == null || !fileCf.exists()) ? 0L : fileCf.length()).setUrl(strK).setMaterialType(com.kwad.sdk.core.response.b.a.bc(adInfoEl) ? 1 : 2).setType(i).setRequestType(i2).setAdTemplate(adTemplate));
    }

    public static void d(AdTemplate adTemplate, int i, String str) {
        String strK;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.bc(adInfoEl)) {
            strK = com.kwad.sdk.core.response.b.a.K(adInfoEl);
        } else {
            strK = com.kwad.sdk.core.response.b.a.aU(adInfoEl).materialUrl;
        }
        com.kwad.sdk.commercial.b.g(true, new SplashMonitorInfo().setStatus(2).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(adInfoEl)).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setUrl(strK).setErrorCode(i).setErrorMsg(str).setMaterialType(com.kwad.sdk.core.response.b.a.bc(adInfoEl) ? 1 : 2).setType(1).setAdTemplate(adTemplate));
    }

    public static void k(AdResultData adResultData) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<AdTemplate> it = adResultData.getAdTemplateList().iterator();
        while (true) {
            int i = 1;
            if (it.hasNext()) {
                AdTemplate next = it.next();
                arrayList.add(String.valueOf(com.kwad.sdk.core.response.b.a.J(com.kwad.sdk.core.response.b.e.el(next))));
                arrayList2.add(com.kwad.sdk.core.response.b.a.aZ(com.kwad.sdk.core.response.b.e.el(next)));
                if (com.kwad.sdk.core.response.b.a.bc(com.kwad.sdk.core.response.b.e.el(next))) {
                    i = 2;
                }
                arrayList3.add(Integer.valueOf(i));
            } else {
                com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setTotalCount(adResultData.getAdTemplateList().size()).setCreativeIds(arrayList).setPreloadIds(arrayList2).setMaterialTypes(arrayList3).setStatus(1).setPosId(adResultData.getPosId()));
                return;
            }
        }
    }

    public static void a(long j, List<String> list, List<Integer> list2) {
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setTotalCount(list == null ? 0 : list.size()).setPreloadIds(list).setMaterialTypes(list2).setStatus(2).setPosId(j));
    }

    public static void a(long j, List<String> list, List<Integer> list2, int i, int i2, int i3, int i4) {
        com.kwad.sdk.commercial.b.l(new SplashMonitorInfo().setTotalCount(list == null ? 0 : list.size()).setPreloadIds(list).setMaterialTypes(list2).setUpdateType(i).setClearCount(i2).setClearImageCount(i3).setClearVideoCount(i4).setStatus(3).setPosId(j));
    }

    public static void f(AdTemplate adTemplate, long j) {
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(1).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setType(com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.el(adTemplate)) ? 2 : 1).setCostTime(j).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void g(AdTemplate adTemplate, long j) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(5).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setCostTime(j).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(adInfoEl)).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, long j, long j2, long j3) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(2).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setCostTime(j).setAddLoadTime(j2).setRequestLoadTime(j3).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(adInfoEl)).setLoadProcessType(e.a(com.kwad.components.ad.splashscreen.b.a.FQ) ? 1L : 2L).setAdTemplate(adTemplate));
    }

    public static void e(AdTemplate adTemplate, int i, String str) {
        String strK;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        boolean zBd = com.kwad.sdk.core.response.b.a.bd(adInfoEl);
        SplashMonitorInfo type = new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(3).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(adInfoEl)).setType(zBd ? 2 : 1);
        if (zBd) {
            strK = com.kwad.sdk.core.response.b.a.aU(adInfoEl).materialUrl;
        } else {
            strK = com.kwad.sdk.core.response.b.a.K(adInfoEl);
        }
        com.kwad.sdk.commercial.b.m(type.setUrl(strK).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void ai(AdTemplate adTemplate) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(4).setBuriedPointOptimizeType(e.a(com.kwad.sdk.core.config.c.aBQ)).setVisibleCheckDelayTime(e.Gp()).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, long j, boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setLoadType(adTemplate.splashAdLoadType).setStatus(6).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setViewSource(z ? 1 : 2).setLoadDataTime(jElapsedRealtime).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void aj(AdTemplate adTemplate) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(200).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void ak(AdTemplate adTemplate) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(201).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(202).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setRootVisible(z).setParentVisible(z2).setHasUnbind(z3).setAdTemplate(adTemplate));
    }

    public static void al(AdTemplate adTemplate) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(204).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void am(AdTemplate adTemplate) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(205).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, long j, boolean z, boolean z2) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(203).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setLoadDataTime(SystemClock.elapsedRealtime() - j).setRootVisible(z).setParentVisible(z2).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void an(AdTemplate adTemplate) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(206).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void ao(AdTemplate adTemplate) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(207).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setType(com.kwad.sdk.core.response.b.a.bd(adInfoEl) ? 2 : 1).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, boolean z) {
        if (adTemplate == null) {
            com.kwad.sdk.commercial.b.n(new SplashMonitorInfo().setErrorMsg(str).setViewSource(z ? 1 : 2));
        } else {
            com.kwad.sdk.commercial.b.n(new SplashMonitorInfo().setCreativeId(com.kwad.sdk.core.response.b.a.J(com.kwad.sdk.core.response.b.e.el(adTemplate))).setErrorMsg(str).setViewSource(z ? 1 : 2).setAdTemplate(adTemplate));
        }
    }

    public static void ap(AdTemplate adTemplate) {
        String strConcat;
        boolean z;
        int i;
        AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfoDv = com.kwad.sdk.core.response.b.b.dv(adTemplate);
        boolean z2 = true;
        if (TextUtils.isEmpty(splashPlayCardTKInfoDv.templateId)) {
            strConcat = SplashMonitorInfo.TEMPLATE_ID_EMPTY;
            z = true;
        } else {
            strConcat = "";
            z = false;
        }
        if (splashPlayCardTKInfoDv.renderType != 1) {
            strConcat = strConcat.concat(SplashMonitorInfo.TEMPLATE_RENER_TYPE_ERROR);
            i = splashPlayCardTKInfoDv.renderType;
        } else {
            i = -1;
            z2 = z;
        }
        if (z2) {
            com.kwad.sdk.commercial.b.o(new SplashMonitorInfo().setErrorMsg(strConcat).setErrorCode(i).setAdTemplate(adTemplate));
        }
    }

    public static void b(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.b.p(new SplashMonitorInfo().setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void c(boolean z, int i, String str, long j) {
        com.kwad.sdk.commercial.b.j(new SplashMonitorInfo().setStatus(4).setType(z ? 2 : 1).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long jDG;
        SplashMonitorInfo tkRenderType = new SplashMonitorInfo().setStatus(101).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate));
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            jDG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            jDG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(tkRenderType.setTkDefaultTimeout(jDG).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long jDG;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(102).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            jDG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            jDG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(jDG).setAdTemplate(adTemplate));
    }

    public final void c(AdTemplate adTemplate, String str) {
        long jDG;
        StyleTemplate styleTemplateC = c(adTemplate);
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(103).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate)).setTemplateId(styleTemplateC.templateId).setTemplateVersionCode(styleTemplateC.templateVersionCode);
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            jDG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            jDG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(jDG).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, StyleTemplate styleTemplate, int i, long j, int i2, long j2, long j3, long j4, long j5, long j6) {
        long jDG;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(104).setTemplateId(styleTemplate.templateId).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate)).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            jDG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            jDG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(jDG).setSoSource(i).setSoLoadTime(j).setOfflineSource(i2).setOfflineLoadTime(j2).setTkFileLoadTime(j3).setTkInitTime(j4).setTkRenderTime(j5).setTkTotalTime(j6).setAdTemplate(adTemplate));
    }

    public static void c(AdTemplate adTemplate, StyleTemplate styleTemplate) {
        long jDG;
        SplashMonitorInfo templateVersionCode = new SplashMonitorInfo().setStatus(106).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate)).setTemplateId(styleTemplate.templateId).setTemplateVersionCode(styleTemplate.templateVersionCode);
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            jDG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            jDG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(templateVersionCode.setTkDefaultTimeout(jDG).setAdTemplate(adTemplate));
    }

    public final void d(AdTemplate adTemplate, String str) {
        long jDG;
        StyleTemplate styleTemplateC = c(adTemplate);
        SplashMonitorInfo errorMsg = new SplashMonitorInfo().setStatus(105).setTemplateId(styleTemplateC.templateId).setTemplateVersionCode(styleTemplateC.templateVersionCode).setTkRenderType(com.kwad.sdk.core.response.b.b.dx(adTemplate)).setErrorMsg(str);
        com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (h.ac(adTemplate)) {
            jDG = com.kwad.sdk.core.response.b.b.dw(adTemplate);
        } else {
            jDG = com.kwad.sdk.core.response.b.b.dG(com.kwad.sdk.core.response.b.e.el(adTemplate));
        }
        com.kwad.sdk.commercial.b.m(errorMsg.setTkDefaultTimeout(jDG).setAdTemplate(adTemplate));
    }

    private static StyleTemplate c(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateK = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dK(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (matrixTemplateK != null) {
            styleTemplate.templateId = matrixTemplateK.templateId;
            styleTemplate.templateMd5 = matrixTemplateK.templateMd5;
            styleTemplate.templateUrl = matrixTemplateK.templateUrl;
            styleTemplate.templateVersionCode = (int) matrixTemplateK.templateVersionCode;
        }
        return styleTemplate;
    }

    public static void e(AdTemplate adTemplate, int i, int i2) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(3001).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(adInfoEl)).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setUrl(com.kwad.sdk.core.response.b.a.aU(adInfoEl).materialUrl).setShowType(i2).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, int i2, int i3, long j, long j2) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(3002).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(adInfoEl)).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setUrl(com.kwad.sdk.core.response.b.a.aU(adInfoEl).materialUrl).setShowType(i2).setLoadType(i3).setCostTime(j).setShowDurationMs(j2).setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, int i, int i2, int i3, long j, long j2) {
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        com.kwad.sdk.commercial.b.m(new SplashMonitorInfo().setStatus(3003).setMaterialType(i).setPreloadId(com.kwad.sdk.core.response.b.a.aZ(adInfoEl)).setCreativeId(com.kwad.sdk.core.response.b.a.J(adInfoEl)).setUrl(com.kwad.sdk.core.response.b.a.aU(adInfoEl).materialUrl).setShowType(i2).setLoadType(i3).setCostTime(j).setShowDurationMs(j2).setAdTemplate(adTemplate));
    }
}
