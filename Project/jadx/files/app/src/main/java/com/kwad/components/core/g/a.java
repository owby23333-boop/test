package com.kwad.components.core.g;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.n.g;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static int JI = 12;
    private static int JJ = 4;
    private static int JK = 1;

    /* JADX INFO: renamed from: com.kwad.components.core.g.a$a, reason: collision with other inner class name */
    public interface InterfaceC0399a {
        void onError(int i2, String str);

        void onInnerAdLoad(@Nullable List<c> list);

        void onRequestResult(int i2);
    }

    private static void a(int i2, int i3, @NonNull SceneImpl sceneImpl, final int i4, final InterfaceC0399a interfaceC0399a) {
        SceneImpl sceneImplM72clone = sceneImpl.m72clone();
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        sceneImplM72clone.setAdStyle(i2);
        sceneImplM72clone.setAdNum(i3);
        a(new com.kwad.components.core.n.kwai.b(sceneImplM72clone), null, false, true, new g() { // from class: com.kwad.components.core.g.a.1
            @Override // com.kwad.components.core.n.h
            public final void a(@NonNull final AdResultData adResultData) {
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            interfaceC0399a.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                });
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        interfaceC0399a.onInnerAdLoad(a.b(adResultData.getAdTemplateList(), i4));
                        a.a(adResultData, jElapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.n.h
            public final void onError(final int i5, final String str) {
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i5), str));
                        interfaceC0399a.onError(i5, str);
                    }
                });
            }
        }, false);
    }

    private static void a(final com.kwad.components.core.n.kwai.b bVar, List<String> list, boolean z2, boolean z3, @NonNull final g gVar, boolean z4) {
        final List list2 = null;
        final boolean z5 = false;
        final boolean z6 = true;
        final boolean z7 = false;
        new com.kwad.components.core.k.a(bVar) { // from class: com.kwad.components.core.g.a.2
            @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: mx, reason: merged with bridge method [inline-methods] */
            public final com.kwad.components.core.n.a createRequest() {
                com.kwad.components.core.n.a aVar = new com.kwad.components.core.n.a(bVar, list2, z5, null);
                aVar.aB(z6 ? 1 : 0);
                return aVar;
            }
        }.request(new p<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.core.g.a.3
            private void b(@NonNull AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty() || z7) {
                    gVar.a(adResultData);
                    return;
                }
                g gVar2 = gVar;
                f fVar = f.afS;
                gVar2.onError(fVar.errorCode, fVar.msg);
            }

            private void e(int i2, String str) {
                gVar.onError(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.g gVar2, int i2, String str) {
                e(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar2, @NonNull BaseResultData baseResultData) {
                b((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdResultData adResultData, long j2) {
        AdTemplate adTemplate;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.m.a.pr().d(adTemplate, jElapsedRealtime - j2);
    }

    public static void a(@NonNull SceneImpl sceneImpl, InterfaceC0399a interfaceC0399a) {
        a(11, JI, sceneImpl, e.REFLOW, interfaceC0399a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<c> b(List<AdTemplate> list, int i2) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new c(it.next(), i2));
        }
        return arrayList;
    }

    public static void b(@NonNull SceneImpl sceneImpl, InterfaceC0399a interfaceC0399a) {
        a(15, JJ, sceneImpl, e.AGGREGATION, interfaceC0399a);
    }

    public static void c(@NonNull SceneImpl sceneImpl, InterfaceC0399a interfaceC0399a) {
        a(17, JK, sceneImpl, e.JU, interfaceC0399a);
    }
}
