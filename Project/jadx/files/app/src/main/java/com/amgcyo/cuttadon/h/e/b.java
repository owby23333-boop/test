package com.amgcyo.cuttadon.h.e;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import java.util.List;

/* JADX INFO: compiled from: KsInteractionAd.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.amgcyo.cuttadon.h.e.a {

    /* JADX INFO: compiled from: KsInteractionAd.java */
    class a implements KsLoadManager.InterstitialAdListener {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onError(int i2, String str) {
            b.this.a(this.a, i2, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
            if (g.a(list)) {
                return;
            }
            b.b(this.a, list.get(0), new KsVideoPlayConfig.Builder().videoSoundEnable(true).build());
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onRequestResult(int i2) {
            String str = "插屏广告请求填充个数 " + i2;
        }
    }

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.e.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: KsInteractionAd.java */
    class C0099b implements KsInterstitialAd.AdInteractionListener {
        C0099b() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClicked() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdClosed() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onAdShow() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onPageDismiss() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onSkippedAd() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayEnd() {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayError(int i2, int i3) {
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public void onVideoPlayStart() {
        }
    }

    /* JADX INFO: compiled from: KsInteractionAd.java */
    private static class c {
        private static final b a = new b(null);
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, KsInterstitialAd ksInterstitialAd, KsVideoPlayConfig ksVideoPlayConfig) {
        if (ksInterstitialAd != null) {
            ksInterstitialAd.setAdInteractionListener(new C0099b());
            ksInterstitialAd.showInterstitialAd((Activity) context, ksVideoPlayConfig);
        }
    }

    public static b c() {
        return c.a;
    }

    private b() {
    }

    public void a(Context context, String str) {
        if (!b(str) || context == null) {
            return;
        }
        KsScene ksSceneBuild = new KsScene.Builder(Long.valueOf(str).longValue()).build();
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager != null && ksSceneBuild != null) {
            loadManager.loadInterstitialAd(ksSceneBuild, new a(context));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ks error:");
        sb.append(loadManager == null);
        sb.append(" ");
        sb.append(ksSceneBuild == null);
        g.a(new Throwable(sb.toString()), "KsInteractionAd");
    }
}
