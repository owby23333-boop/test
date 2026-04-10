package com.kwad.components.core.j;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.core.request.k;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static int QU = 12;
    private static int QV = 4;
    private static int QW = 1;

    /* JADX INFO: renamed from: com.kwad.components.core.j.a$a, reason: collision with other inner class name */
    public interface InterfaceC0338a {
        void e(List<c> list);

        void onError(int i, String str);

        void onRequestResult(int i);
    }

    public static void a(SceneImpl sceneImpl, InterfaceC0338a interfaceC0338a) {
        a(15, QV, sceneImpl, e.AGGREGATION, interfaceC0338a);
    }

    public static void b(SceneImpl sceneImpl, InterfaceC0338a interfaceC0338a) {
        a(17, QW, sceneImpl, e.Rh, interfaceC0338a);
    }

    private static void a(int i, int i2, SceneImpl sceneImpl, final int i3, final InterfaceC0338a interfaceC0338a) {
        SceneImpl sceneImplM617clone = sceneImpl.m617clone();
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        sceneImplM617clone.setAdStyle(i);
        sceneImplM617clone.setAdNum(i2);
        a(new ImpInfo(sceneImplM617clone), null, false, true, new k() { // from class: com.kwad.components.core.j.a.1
            @Override // com.kwad.components.core.request.l
            public final void onError(final int i4, final String str) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.j.a.1.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                        interfaceC0338a.onError(i4, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.l
            public final void b(final AdResultData adResultData) {
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.j.a.1.2
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        try {
                            interfaceC0338a.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.j.a.1.3
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        interfaceC0338a.e(a.b(adResultData.getAdTemplateList(), i3));
                        a.a(adResultData, jElapsedRealtime);
                    }
                });
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> b(List<AdTemplate> list, int i) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new c(it.next(), i));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.p.a.se().h(adTemplate, jElapsedRealtime - j);
    }

    private static void a(final ImpInfo impInfo, List<String> list, boolean z, boolean z2, final k kVar, boolean z3) {
        final List list2 = null;
        final boolean z4 = false;
        final boolean z5 = true;
        final boolean z6 = false;
        new com.kwad.components.core.n.a(impInfo) { // from class: com.kwad.components.core.j.a.2
            @Override // com.kwad.components.core.n.a, com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: ou, reason: merged with bridge method [inline-methods] */
            public final com.kwad.components.core.request.a createRequest() {
                com.kwad.components.core.request.a aVar = new com.kwad.components.core.request.a(impInfo, list2, z4, null);
                aVar.aU(z5 ? 1 : 0);
                return aVar;
            }
        }.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.j.a.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                k(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                n((AdResultData) baseResultData);
            }

            private void n(AdResultData adResultData) {
                if (adResultData.isAdResultDataEmpty() && !z6) {
                    kVar.onError(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg);
                } else {
                    kVar.b(adResultData);
                }
            }

            private void k(int i, String str) {
                kVar.onError(i, str);
            }
        });
    }
}
