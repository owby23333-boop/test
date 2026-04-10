package com.amgcyo.cuttadon.h.c;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: compiled from: GdtInterstitial.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static UnifiedInterstitialAD a;
    private static String b;

    /* JADX INFO: renamed from: com.amgcyo.cuttadon.h.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GdtInterstitial.java */
    class C0093a implements UnifiedInterstitialADListener {
        final /* synthetic */ com.amgcyo.cuttadon.h.f.d a;
        final /* synthetic */ boolean b;

        C0093a(com.amgcyo.cuttadon.h.f.d dVar, boolean z2) {
            this.a = dVar;
            this.b = z2;
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClicked() {
            com.amgcyo.cuttadon.h.f.d dVar = this.a;
            if (dVar != null) {
                dVar.onAdClicked();
            }
            if (a.a != null) {
                a.a.close();
                a.a.destroy();
                UnifiedInterstitialAD unused = a.a = null;
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onADClosed() {
            com.amgcyo.cuttadon.h.f.d dVar = this.a;
            if (dVar != null) {
                dVar.onAdDismiss();
            }
            if (a.a != null) {
                a.a.close();
                a.a.destroy();
                UnifiedInterstitialAD unused = a.a = null;
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
            String str = "eCPM = " + a.a.getECPM() + " , eCPMLevel = " + a.a.getECPMLevel();
            com.amgcyo.cuttadon.h.f.d dVar = this.a;
            if (dVar != null) {
                dVar.a();
            }
            try {
                if (this.b) {
                    a.a.showAsPopupWindow();
                } else {
                    a.a.show();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onNoAD(AdError adError) {
            String str = "onNoAD: " + adError.getErrorCode() + " msg: " + adError.getErrorMsg();
            com.amgcyo.cuttadon.h.f.d dVar = this.a;
            if (dVar != null) {
                dVar.a(adError.getErrorCode(), adError.getErrorMsg());
            }
            if (a.a != null) {
                a.a.close();
                a.a.destroy();
                UnifiedInterstitialAD unused = a.a = null;
            }
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderFail() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onRenderSuccess() {
        }

        @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
        public void onVideoCached() {
        }
    }

    public static void a(Context context, String str, boolean z2, com.amgcyo.cuttadon.h.f.d dVar) {
        if (a == null || !b.equals(str)) {
            b = str;
            UnifiedInterstitialAD unifiedInterstitialAD = a;
            if (unifiedInterstitialAD != null) {
                unifiedInterstitialAD.close();
                a.destroy();
                a = null;
            }
            a = new UnifiedInterstitialAD((Activity) context, b, new C0093a(dVar, z2));
        }
        a.loadAD();
    }
}
