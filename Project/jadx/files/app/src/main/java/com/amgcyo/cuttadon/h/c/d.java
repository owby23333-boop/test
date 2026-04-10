package com.amgcyo.cuttadon.h.c;

import android.app.Activity;
import android.content.Context;
import com.amgcyo.cuttadon.h.a.e;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.util.AdError;
import java.util.Locale;

/* JADX INFO: compiled from: GdtUniInterFullAdUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private static UnifiedInterstitialAD a;

    /* JADX INFO: compiled from: GdtUniInterFullAdUtil.java */
    class a implements UnifiedInterstitialADListener {
        final /* synthetic */ com.amgcyo.cuttadon.h.f.b a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.c.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GdtUniInterFullAdUtil.java */
        class C0095a implements UnifiedInterstitialMediaListener {
            C0095a() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoComplete() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoError(AdError adError) {
                com.amgcyo.cuttadon.h.f.b bVar = a.this.a;
                if (bVar != null) {
                    bVar.AdError(adError.getErrorCode(), adError.getErrorMsg(), "gdt_new");
                }
                System.out.println("gdt onVideoError");
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long j2) {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
            }
        }

        a(com.amgcyo.cuttadon.h.f.b bVar, Context context) {
            this.a = bVar;
            this.b = context;
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            e.a();
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            com.amgcyo.cuttadon.h.f.b bVar = this.a;
            if (bVar != null) {
                bVar.goToMainActivity();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADExposure() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADLeftApplication() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADOpened() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADReceive() {
            d.a.setMediaListener(new C0095a());
            if (d.a != null) {
                d.a.showFullScreenAD((Activity) this.b);
                return;
            }
            com.amgcyo.cuttadon.h.f.b bVar = this.a;
            if (bVar != null) {
                bVar.goToMainActivity();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            int errorCode = adError.getErrorCode();
            String errorMsg = adError.getErrorMsg();
            if (errorCode == 102006) {
                errorMsg = "暂无数据返回，请稍后重试！";
            }
            System.out.println(String.format(Locale.getDefault(), "onNoAD, error code: %d, error msg: %s", Integer.valueOf(errorCode), errorMsg));
            com.amgcyo.cuttadon.h.f.b bVar = this.a;
            if (bVar != null) {
                bVar.AdError(adError.getErrorCode(), adError.getErrorMsg(), "gdt_new");
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
            System.out.println("gdt onrenderfail");
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
        }
    }

    public static void a(Context context, String str, com.amgcyo.cuttadon.h.f.b bVar) {
        a = new UnifiedInterstitialAD((Activity) context, str, new a(bVar, context));
        a.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(h.f("gdt_new")).build());
        a.loadFullScreenAD();
    }
}
