package com.kwad.components.core.b;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d implements com.kwad.components.core.b.c {
    private static volatile d HV = null;
    private static boolean HW = true;

    @NonNull
    private SparseArray<com.kwad.components.core.b.c> HU = new SparseArray<>();

    static class a implements Comparator<AdTemplate> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        private static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int iCp = com.kwad.sdk.core.response.a.d.cp(adTemplate2) - com.kwad.sdk.core.response.a.d.cp(adTemplate);
            if (iCp != 0) {
                return iCp;
            }
            if (adTemplate.fromCache && adTemplate2.fromCache) {
                return 0;
            }
            return adTemplate.fromCache ? 1 : -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }
    }

    static class b extends p<com.kwad.components.core.n.a, AdResultData> {
        private com.kwad.components.core.n.kwai.a Ib;

        public b(com.kwad.components.core.n.kwai.a aVar) {
            this.Ib = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NonNull com.kwad.components.core.n.a aVar, @NonNull final AdResultData adResultData) {
            super.onSuccess(aVar, adResultData);
            com.kwad.sdk.core.threads.b.yc().submit(new Runnable() { // from class: com.kwad.components.core.b.d.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b bVar = b.this;
                    b.c(adResultData);
                }
            });
            if (a(this.Ib, adResultData)) {
                return;
            }
            com.kwad.components.core.n.kwai.a.a(this.Ib, adResultData, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public static void c(AdResultData adResultData) {
            List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
            com.kwad.components.core.b.a aVarMr = com.kwad.components.core.b.a.mr();
            if (aVarMr == null || proceedTemplateList.size() <= 0) {
                return;
            }
            AdTemplate adTemplate = proceedTemplateList.get(0);
            com.kwad.components.core.b.e eVarN = com.kwad.components.core.b.e.n(adResultData.getPosId());
            aVarMr.ms();
            aVarMr.h(g.a(eVarN, adResultData));
            aVarMr.a(com.kwad.components.core.b.e.F(adTemplate));
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(@NonNull com.kwad.components.core.n.a aVar, int i2, String str) {
            super.onError(aVar, i2, str);
            com.kwad.components.core.n.kwai.a.a(this.Ib, i2, str, false);
        }

        protected boolean a(com.kwad.components.core.n.kwai.a aVar, AdResultData adResultData) {
            return false;
        }
    }

    interface c {
        void mz();
    }

    /* JADX INFO: renamed from: com.kwad.components.core.b.d$d, reason: collision with other inner class name */
    public static class C0388d implements com.kwad.components.core.b.c {
        @Override // com.kwad.components.core.b.c
        public final void c(com.kwad.components.core.n.kwai.a aVar) {
            d.a(aVar, new b(aVar));
        }
    }

    public static class e implements com.kwad.components.core.b.c {
        @Override // com.kwad.components.core.b.c
        public final void c(final com.kwad.components.core.n.kwai.a aVar) {
            com.kwad.sdk.core.threads.b.yc().submit(new Runnable() { // from class: com.kwad.components.core.b.d.e.1
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    AdResultData adResultDataD = d.d(aVar);
                    if (adResultDataD != null && !adResultDataD.isAdResultDataEmpty()) {
                        com.kwad.components.core.n.kwai.a.a(aVar, adResultDataD, true);
                    } else {
                        com.kwad.components.core.n.kwai.a aVar2 = aVar;
                        d.a(aVar2, new b(aVar2));
                    }
                }
            });
        }
    }

    public static class f implements com.kwad.components.core.b.c {

        /* JADX INFO: renamed from: com.kwad.components.core.b.d$f$1, reason: invalid class name */
        final class AnonymousClass1 extends b {
            final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(com.kwad.components.core.n.kwai.a aVar, com.kwad.components.core.n.kwai.a aVar2) {
                super(aVar);
                this.bN = aVar2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @WorkerThread
            public void a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i2, c cVar) throws Throwable {
                AdResultData adResultDataD = d.d(this.bN);
                if (adResultDataD == null || adResultDataD.isAdResultDataEmpty()) {
                    if (cVar != null) {
                        cVar.mz();
                        return;
                    }
                    return;
                }
                List listA = d.a((List<AdTemplate>[]) new List[]{adResultDataD.getProceedTemplateList()});
                List listSubList = listA.subList(0, Math.min(i2, listA.size()));
                if (listSubList.size() > 0) {
                    if (adResultData == null) {
                        adResultData = new AdResultData(sceneImpl);
                    }
                    com.kwad.components.core.n.kwai.a.a(this.bN, new AdResultData(adResultData, sceneImpl, listSubList), false);
                }
            }

            @Override // com.kwad.components.core.b.d.b, com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* JADX INFO: renamed from: a */
            public final void onError(@NonNull final com.kwad.components.core.n.a aVar, final int i2, final String str) {
                com.kwad.sdk.core.threads.b.yc().submit(new Runnable() { // from class: com.kwad.components.core.b.d.f.1.2
                    @Override // java.lang.Runnable
                    public final void run() throws Throwable {
                        AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new c() { // from class: com.kwad.components.core.b.d.f.1.2.1
                            @Override // com.kwad.components.core.b.d.c
                            public final void mz() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                com.kwad.components.core.n.kwai.a.a(AnonymousClass1.this.bN, i2, str, false);
                            }
                        });
                    }
                });
            }

            @Override // com.kwad.components.core.b.d.b
            protected final boolean a(final com.kwad.components.core.n.kwai.a aVar, final AdResultData adResultData) {
                AdResultData adResultDataD;
                final SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
                final int adNum = adScene.getAdNum();
                if (adResultData.isAdResultDataEmpty()) {
                    com.kwad.sdk.core.threads.b.yc().submit(new Runnable() { // from class: com.kwad.components.core.b.d.f.1.1
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            AnonymousClass1.this.a(adScene, adResultData, adNum, new c() { // from class: com.kwad.components.core.b.d.f.1.1.1
                                @Override // com.kwad.components.core.b.d.c
                                public final void mz() {
                                    RunnableC03891 runnableC03891 = RunnableC03891.this;
                                    com.kwad.components.core.n.kwai.a.a(aVar, adResultData, false);
                                }
                            });
                        }
                    });
                    return true;
                }
                if (adResultData.isBidding() && (adResultDataD = d.d(aVar)) != null && !adResultDataD.isAdResultDataEmpty()) {
                    List listA = d.a((List<AdTemplate>[]) new List[]{adResultDataD.getProceedTemplateList(), adResultData.getProceedTemplateList()});
                    List listSubList = listA.subList(0, Math.min(adNum, listA.size()));
                    if (listSubList != null && listSubList.size() > 0) {
                        com.kwad.components.core.n.kwai.a.a(aVar, new AdResultData(adResultData, adScene, listSubList), true);
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // com.kwad.components.core.b.c
        public final void c(com.kwad.components.core.n.kwai.a aVar) {
            d.a(aVar, new AnonymousClass1(aVar, aVar));
        }
    }

    private d() {
        this.HU.append(1, new f());
        this.HU.append(2, new e());
        this.HU.append(0, new C0388d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends com.kwad.components.core.n.a> T a(com.kwad.sdk.d.c<T> cVar) {
        return cVar.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(List<AdTemplate>... listArr) {
        if (listArr == null) {
            return null;
        }
        ArrayList<AdTemplate> arrayList = new ArrayList();
        byte b2 = 0;
        for (List<AdTemplate> list : listArr) {
            arrayList.addAll(list);
        }
        Collections.sort(arrayList, new a(b2));
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : arrayList) {
            long jCk = com.kwad.sdk.core.response.a.d.ck(adTemplate);
            if (!hashSet.contains(Long.valueOf(jCk))) {
                hashSet.add(Long.valueOf(jCk));
                arrayList2.add(adTemplate);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final com.kwad.components.core.n.kwai.a aVar, @NonNull p<com.kwad.components.core.n.a, AdResultData> pVar) {
        new com.kwad.components.core.k.a(aVar.Kj) { // from class: com.kwad.components.core.b.d.1
            @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.m
            @NonNull
            /* JADX INFO: renamed from: ag */
            public final AdResultData parseData(String str) {
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(KSLoggerReporter.bs(aVar.getAdStyle()), "requestFinish").b("isCache", Boolean.FALSE).report();
                return AdResultData.createFromResponseJson(str, aVar.Kj.Ot);
            }

            @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: mx */
            public final com.kwad.components.core.n.a createRequest() {
                return d.a(new com.kwad.sdk.d.c<com.kwad.components.core.n.a>() { // from class: com.kwad.components.core.b.d.1.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.d.c
                    /* JADX INFO: renamed from: my, reason: merged with bridge method [inline-methods] */
                    public com.kwad.components.core.n.a get() {
                        if (aVar.getAdStyle() == 4) {
                            aVar.Op = SplashPreloadManager.sm().sn();
                        }
                        return new com.kwad.components.core.n.a(aVar);
                    }
                });
            }
        }.request(pVar);
    }

    static /* synthetic */ boolean a(d dVar) {
        return mv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    @WorkerThread
    public static AdResultData d(com.kwad.components.core.n.kwai.a aVar) throws Throwable {
        com.kwad.components.core.b.a aVarMr = com.kwad.components.core.b.a.mr();
        if (aVarMr == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<g> listB = aVarMr.b(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, com.kwad.components.core.b.e.n(aVar.getPosId()).mC());
        if (com.kwad.sdk.core.config.d.vd()) {
            i(listB);
        }
        if (listB == null || listB.size() <= 0) {
            return null;
        }
        Collections.sort(listB);
        return g.j(listB.subList(0, Math.min(listB.size(), adNum)));
    }

    private static void i(List<g> list) {
        if (list == null) {
            return;
        }
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (com.kwad.components.core.b.f.mF().a(next)) {
                com.kwad.sdk.core.d.b.d("AdCacheFetcherHolder", "filterByMemCached contain: " + next.mM());
                it.remove();
            }
        }
    }

    public static d mu() {
        if (HV == null) {
            synchronized (d.class) {
                if (HV == null) {
                    HV = new d();
                }
            }
        }
        return HV;
    }

    private static boolean mv() {
        if (!HW) {
            return false;
        }
        try {
            Class.forName("com.kwad.devTools.PosConfigFetcher");
            HW = true;
        } catch (ClassNotFoundException unused) {
            HW = false;
        }
        return HW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.b.c mw() {
        return this.HU.get(0);
    }

    @Override // com.kwad.components.core.b.c
    public final void c(final com.kwad.components.core.n.kwai.a aVar) {
        com.kwad.sdk.core.threads.b.yc().submit(new Runnable() { // from class: com.kwad.components.core.b.d.2
            @Override // java.lang.Runnable
            public final void run() {
                final com.kwad.components.core.b.e eVarN = com.kwad.components.core.b.e.n(aVar.getPosId());
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.b.d.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.core.b.b.b(eVarN);
                    }
                });
                com.kwad.components.core.b.c cVarMw = (d.a(d.this) || !(eVarN.isDefault() || eVarN.isEnable())) ? d.this.mw() : (com.kwad.components.core.b.c) d.this.HU.get(eVarN.mB());
                if (cVarMw == null) {
                    cVarMw = (com.kwad.components.core.b.c) d.this.HU.get(1);
                }
                cVarMw.c(aVar);
            }
        });
    }
}
