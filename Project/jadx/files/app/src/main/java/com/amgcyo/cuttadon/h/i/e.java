package com.amgcyo.cuttadon.h.i;

import android.app.Activity;
import android.content.Context;
import com.amgcyo.cuttadon.f.o;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.AdError;
import com.anythink.interstitial.api.ATInterstitial;
import com.anythink.interstitial.api.ATInterstitialListener;
import com.sntech.ads.api.event.SNEvent;

/* JADX INFO: compiled from: ToponInterstitialAdUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: compiled from: ToponInterstitialAdUtil.java */
    class a implements ATInterstitialListener {
        final /* synthetic */ String a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ATInterstitial f3993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f3994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.amgcyo.cuttadon.h.f.b f3995e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f3996f;

        a(String str, Context context, ATInterstitial aTInterstitial, boolean z2, com.amgcyo.cuttadon.h.f.b bVar, String str2) {
            this.a = str;
            this.b = context;
            this.f3993c = aTInterstitial;
            this.f3994d = z2;
            this.f3995e = bVar;
            this.f3996f = str2;
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdClicked(ATAdInfo aTAdInfo) {
            String str = "onInterstitialAdClicked:" + aTAdInfo.toString();
            com.amgcyo.cuttadon.h.j.a.c(aTAdInfo);
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdClose(ATAdInfo aTAdInfo) {
            String str = "onInterstitialAdClose:" + aTAdInfo.toString();
            e.this.a(this.f3993c);
            e.this.a(this.b, this.f3996f, this.f3995e, 1);
            com.amgcyo.cuttadon.h.f.b bVar = this.f3995e;
            if (bVar != null) {
                bVar.goToMainActivity();
            }
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdLoadFail(AdError adError) {
            String str = "onInterstitialAdLoadFail:" + adError.getFullErrorInfo();
            com.amgcyo.cuttadon.h.f.b bVar = this.f3995e;
            if (bVar != null) {
                bVar.AdError(0L, adError.getFullErrorInfo(), "topon_new");
            }
            o.g("插屏广告加载失败：" + adError.getFullErrorInfo());
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdLoaded() {
            String str = " onInterstitialAdLoaded： loadType：" + this.a;
            if ((this.b instanceof Activity) && this.f3993c.isAdReady() && this.f3994d) {
                this.f3993c.show((Activity) this.b);
            }
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdShow(ATAdInfo aTAdInfo) {
            String str = "onInterstitialAdShow:" + aTAdInfo.toString();
            com.amgcyo.cuttadon.h.j.a.d(aTAdInfo);
            com.amgcyo.cuttadon.h.j.a.a(SNEvent.AdType.INTERSTITIAL, aTAdInfo);
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdVideoEnd(ATAdInfo aTAdInfo) {
            String str = "onInterstitialAdVideoEnd:" + aTAdInfo.toString();
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdVideoError(AdError adError) {
            String str = "onInterstitialAdVideoError:" + adError.getFullErrorInfo();
        }

        @Override // com.anythink.interstitial.api.ATInterstitialListener
        public void onInterstitialAdVideoStart(ATAdInfo aTAdInfo) {
            String str = "onInterstitialAdVideoStart:" + aTAdInfo.toString();
        }
    }

    /* JADX INFO: compiled from: ToponInterstitialAdUtil.java */
    private static class b {
        private static final e a = new e();
    }

    public static e a() {
        return b.a;
    }

    public void a(Context context, String str, com.amgcyo.cuttadon.h.f.b bVar, int i2) {
        ATInterstitial aTInterstitial = new ATInterstitial(context, str);
        boolean z2 = i2 == 0;
        String str2 = z2 ? "实时加载" : "预加载";
        String str3 = str2 + "插屏全屏广告";
        aTInterstitial.setAdListener(new a(str2, context, aTInterstitial, z2, bVar, str));
        aTInterstitial.setAdSourceStatusListener(new com.amgcyo.cuttadon.h.i.a(str2 + " 插屏全屏", "ToponInterstitialAdUtil"));
        aTInterstitial.load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ATInterstitial aTInterstitial) {
        if (aTInterstitial != null) {
            aTInterstitial.setAdSourceStatusListener(null);
            aTInterstitial.setAdDownloadListener(null);
            aTInterstitial.setAdListener(null);
        }
    }
}
