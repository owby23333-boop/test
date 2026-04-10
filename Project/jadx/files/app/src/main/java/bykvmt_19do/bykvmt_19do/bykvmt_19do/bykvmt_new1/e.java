package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_new1;

import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: TTCallbackUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final List<String> a = new ArrayList();
    private static final List<String> b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<String> f2153c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<String> f2154d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List<String> f2155e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<String> f2156f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<String> f2157g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<String> f2158h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List<String> f2159i = new ArrayList();

    static {
        a.add("onRewardVideoAdLoad");
        a.add("onRewardVideoLoadFail");
        a.add("onRewardVideoCached");
        a.add("onRewardedAdShow");
        a.add("onRewardedAdShowFail");
        a.add("onRewardClick");
        a.add("onVideoComplete");
        a.add("onRewardVerify");
        a.add("onRewardedAdClosed");
        a.add("onVideoError");
        a.add("onSkippedVideo");
        b.add("onFullVideoAdLoad");
        b.add("onFullVideoLoadFail");
        b.add("onFullVideoCached");
        b.add("onFullVideoAdShow");
        b.add("onFullVideoAdShowFail");
        b.add("onFullVideoAdClick");
        b.add("onVideoComplete");
        b.add("onSkippedVideo");
        b.add("onFullVideoAdClosed");
        b.add("onVideoError");
        b.add("onRewardVerify");
        f2153c.add("onAdLoaded");
        f2153c.add("onAdFailedToLoad");
        f2153c.add("onAdShow");
        f2153c.add("onAdShowFail");
        f2153c.add("onAdClicked");
        f2153c.add("onAdClosed");
        f2153c.add("onAdOpened");
        f2153c.add("onAdLeftApplication");
        f2154d.add("onInterstitialLoad");
        f2154d.add("onInterstitialLoadFail");
        f2154d.add("onInterstitialShow");
        f2154d.add("onInterstitialShowFail");
        f2154d.add("onInterstitialAdClick");
        f2154d.add("onInterstitialClosed");
        f2154d.add("onAdOpened");
        f2154d.add("onAdLeftApplication");
        f2155e.add("onSplashAdLoadSuccess");
        f2155e.add("onSplashAdLoadFail");
        f2155e.add("onAdLoadTimeout");
        f2155e.add("onAdClicked");
        f2155e.add("onAdShow");
        f2155e.add("onAdShowFail");
        f2155e.add("onAdSkip");
        f2155e.add("onAdDismiss");
        f2156f.add("onAdLoaded");
        f2156f.add("onAdLoadedFial");
        f2156f.add("onAdShow");
        f2156f.add(IAdInterListener.AdCommandType.AD_CLICK);
        f2156f.add("onVideoStart");
        f2156f.add("onVideoPause");
        f2156f.add("onVideoResume");
        f2156f.add("onVideoCompleted");
        f2156f.add("onVideoError");
        f2157g.add("onAdLoaded");
        f2157g.add("onAdLoadedFial");
        f2157g.add("onAdShow");
        f2157g.add(IAdInterListener.AdCommandType.AD_CLICK);
        f2157g.add("onVideoStart");
        f2157g.add("onVideoPause");
        f2157g.add("onVideoResume");
        f2157g.add("onVideoCompleted");
        f2157g.add("onVideoError");
        f2157g.add("onRenderSuccess");
        f2157g.add("onRenderFail");
        f2158h.add("onInterstitialFullAdLoad");
        f2158h.add("onInterstitialFullLoadFail");
        f2158h.add("onInterstitialFullCached");
        f2158h.add("onInterstitialFullShow");
        f2158h.add("onInterstitialFullShowFail");
        f2158h.add("onInterstitialFullClick");
        f2158h.add("onInterstitialFullClosed");
        f2158h.add("onVideoComplete");
        f2158h.add("onVideoError");
        f2158h.add("onSkippedVideo");
        f2158h.add("onAdOpened");
        f2158h.add("onAdLeftApplication");
        f2158h.add("onRewardVerify");
        f2159i.add("onAdLoadSuccess");
        f2159i.add("onAdLoadFail");
        f2159i.add("onAdShow");
        f2159i.add(IAdInterListener.AdCommandType.AD_CLICK);
        f2159i.add("onVideoStart");
        f2159i.add("onVideoPause");
        f2159i.add("onVideoResume");
        f2159i.add("onVideoCompleted");
        f2159i.add("onVideoError");
        f2159i.add("onRenderSuccess");
        f2159i.add("onRenderFail");
    }

    public static List<bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a> a(int i2, int i3) {
        List<String> listB = b(i2, i3);
        if (listB == null || listB.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : listB) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a aVar = new bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.a();
            aVar.a(str);
            aVar.b(false);
            arrayList.add(aVar);
        }
        return arrayList;
    }

    private static List<String> b(int i2, int i3) {
        switch (i2) {
            case 1:
                return f2153c;
            case 2:
                return f2154d;
            case 3:
                return f2155e;
            case 4:
            case 6:
            default:
                return null;
            case 5:
                return f2157g;
            case 7:
                return a;
            case 8:
                return b;
            case 9:
                return f2159i;
            case 10:
                return f2158h;
        }
    }
}
