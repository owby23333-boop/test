package com.kwad.components.ad.interstitial.aggregate;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.n.g;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private volatile boolean il;
    private m<com.kwad.components.core.n.a, AdResultData> im;

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.aggregate.c$1, reason: invalid class name */
    final class AnonymousClass1 extends g {
        final /* synthetic */ SceneImpl ek;
        final /* synthetic */ long hO;

        /* JADX INFO: renamed from: io, reason: collision with root package name */
        final /* synthetic */ b f16956io;

        AnonymousClass1(SceneImpl sceneImpl, b bVar, long j2) {
            this.ek = sceneImpl;
            this.f16956io = bVar;
            this.hO = j2;
        }

        @Override // com.kwad.components.core.n.h
        public final void a(@NonNull final AdResultData adResultData) {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    final ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = AnonymousClass1.this.ek;
                            }
                            arrayList.add(adTemplate);
                        }
                    }
                    bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1.this.f16956io.onInterstitialAdLoad(arrayList);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c cVar = c.this;
                            c.a(adResultData, anonymousClass1.hO);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.components.core.n.h
        public final void onError(final int i2, final String str) {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                }
            });
        }
    }

    static class a {
        private static c iv = new c(0);
    }

    public interface b {
        void onInterstitialAdLoad(@Nullable List<AdTemplate> list);
    }

    private c() {
        this.il = false;
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private void a(com.kwad.components.core.n.kwai.b bVar, @NonNull final g gVar) {
        this.im = new com.kwad.components.core.k.a(bVar);
        this.im.request(new p<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.ad.interstitial.aggregate.c.2
            private void b(@NonNull AdResultData adResultData) {
                c.a(c.this, false);
                if (!adResultData.isAdResultDataEmpty()) {
                    gVar.a(adResultData);
                    return;
                }
                g gVar2 = gVar;
                f fVar = f.afS;
                gVar2.onError(fVar.errorCode, fVar.msg);
            }

            private void e(int i2, String str) {
                c.a(c.this, false);
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

    static /* synthetic */ boolean a(c cVar, boolean z2) {
        cVar.il = false;
        return false;
    }

    public static c cA() {
        return a.iv;
    }

    public final void a(int i2, int i3, @NonNull SceneImpl sceneImpl, b bVar) {
        if (this.il) {
            return;
        }
        SceneImpl sceneImplM72clone = sceneImpl.m72clone();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        sceneImplM72clone.setAdStyle(16);
        sceneImplM72clone.setAdNum(i3);
        a(new com.kwad.components.core.n.kwai.b(sceneImplM72clone), new AnonymousClass1(sceneImpl, bVar, jElapsedRealtime));
    }

    public final void release() {
        m<com.kwad.components.core.n.a, AdResultData> mVar = this.im;
        if (mVar != null) {
            mVar.cancel();
        }
    }
}
