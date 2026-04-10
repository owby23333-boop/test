package com.funny.audio.ad;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.funny.audio.AppManager;
import com.funny.audio.ad.loader.FeedAdLoader;
import com.funny.audio.ad.loader.InterstitialAdLoader;
import com.funny.audio.ad.loader.RewardVideoAdLoader;
import com.funny.audio.api.ApiManager;
import com.funny.audio.core.net.AppBody;
import com.funny.audio.core.net.NetModelsKt;
import com.funny.audio.core.net.Response;
import com.funny.audio.models.AdInfo;
import com.umeng.analytics.pro.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\nJ\u000e\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102J\u000e\u00104\u001a\u00020/2\u0006\u0010\t\u001a\u000205R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b+\u0010\u0012R\u000e\u0010,\u001a\u00020-X\u0082D¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/funny/audio/ad/AdManager;", "", "()V", "bookshelfInterstitialAdLoader", "Lcom/funny/audio/ad/loader/InterstitialAdLoader;", "getBookshelfInterstitialAdLoader", "()Lcom/funny/audio/ad/loader/InterstitialAdLoader;", "setBookshelfInterstitialAdLoader", "(Lcom/funny/audio/ad/loader/InterstitialAdLoader;)V", d.R, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "initSuccess", "", "getInitSuccess", "()Z", "setInitSuccess", "(Z)V", "mediaPlayerFeedAdLoader", "Lcom/funny/audio/ad/loader/FeedAdLoader;", "getMediaPlayerFeedAdLoader", "()Lcom/funny/audio/ad/loader/FeedAdLoader;", "setMediaPlayerFeedAdLoader", "(Lcom/funny/audio/ad/loader/FeedAdLoader;)V", "mediaPlayerRewardVideoAdLoader", "Lcom/funny/audio/ad/loader/RewardVideoAdLoader;", "getMediaPlayerRewardVideoAdLoader", "()Lcom/funny/audio/ad/loader/RewardVideoAdLoader;", "setMediaPlayerRewardVideoAdLoader", "(Lcom/funny/audio/ad/loader/RewardVideoAdLoader;)V", "pureModeRewardVideoAdLoader", "getPureModeRewardVideoAdLoader", "setPureModeRewardVideoAdLoader", "setting", "Lcom/funny/audio/ad/AdSetting;", "getSetting", "()Lcom/funny/audio/ad/AdSetting;", "setSetting", "(Lcom/funny/audio/ad/AdSetting;)V", "show", "getShow", "tagName", "", "init", "", "app", "loadAdInfos", "", "Lcom/funny/audio/models/AdInfo;", "requestPermissionIfNecessary", "Landroid/content/Context;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AdManager {
    private static InterstitialAdLoader bookshelfInterstitialAdLoader;
    private static Application context;
    private static boolean initSuccess;
    private static FeedAdLoader mediaPlayerFeedAdLoader;
    private static RewardVideoAdLoader mediaPlayerRewardVideoAdLoader;
    private static RewardVideoAdLoader pureModeRewardVideoAdLoader;
    private static AdSetting setting;
    public static final AdManager INSTANCE = new AdManager();
    private static final String tagName = "AdManager";

    private AdManager() {
    }

    public final Application getContext() {
        return context;
    }

    public final void setContext(Application application) {
        context = application;
    }

    public final AdSetting getSetting() {
        return setting;
    }

    public final void setSetting(AdSetting adSetting) {
        setting = adSetting;
    }

    public final boolean getInitSuccess() {
        return initSuccess;
    }

    public final void setInitSuccess(boolean z) {
        initSuccess = z;
    }

    public final RewardVideoAdLoader getMediaPlayerRewardVideoAdLoader() {
        return mediaPlayerRewardVideoAdLoader;
    }

    public final void setMediaPlayerRewardVideoAdLoader(RewardVideoAdLoader rewardVideoAdLoader) {
        mediaPlayerRewardVideoAdLoader = rewardVideoAdLoader;
    }

    public final RewardVideoAdLoader getPureModeRewardVideoAdLoader() {
        return pureModeRewardVideoAdLoader;
    }

    public final void setPureModeRewardVideoAdLoader(RewardVideoAdLoader rewardVideoAdLoader) {
        pureModeRewardVideoAdLoader = rewardVideoAdLoader;
    }

    public final FeedAdLoader getMediaPlayerFeedAdLoader() {
        return mediaPlayerFeedAdLoader;
    }

    public final void setMediaPlayerFeedAdLoader(FeedAdLoader feedAdLoader) {
        mediaPlayerFeedAdLoader = feedAdLoader;
    }

    public final InterstitialAdLoader getBookshelfInterstitialAdLoader() {
        return bookshelfInterstitialAdLoader;
    }

    public final void setBookshelfInterstitialAdLoader(InterstitialAdLoader interstitialAdLoader) {
        bookshelfInterstitialAdLoader = interstitialAdLoader;
    }

    public final boolean getShow() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        AdSetting adSetting = setting;
        Intrinsics.checkNotNull(adSetting);
        if (adSetting.getGlobalAd().getShow()) {
            return adSetting.getFreeTime().getValueLong() == -1 || jCurrentTimeMillis > adSetting.getFreeTime().getValueLong();
        }
        return false;
    }

    public final void init(Application app) {
        Intrinsics.checkNotNullParameter(app, "app");
        context = app;
        try {
            List<AdInfo> listLoadAdInfos = loadAdInfos();
            if (listLoadAdInfos == null) {
                initSuccess = false;
            } else {
                Log.i(tagName, "获取云端广告配置成功！更新本地数据库广告配置");
                AdSetting.INSTANCE.setUp(listLoadAdInfos);
            }
            AdSetting adSettingLoad = AdSetting.INSTANCE.load(app);
            setting = adSettingLoad;
            Intrinsics.checkNotNull(adSettingLoad);
            if (adSettingLoad.getGlobalAd().getShow()) {
                TTAdConfig.Builder builder = new TTAdConfig.Builder();
                AdSetting adSetting = setting;
                Intrinsics.checkNotNull(adSetting);
                TTAdConfig.Builder builderAppId = builder.appId(adSetting.getGlobalAd().getCodeId());
                AdSetting adSetting2 = setting;
                Intrinsics.checkNotNull(adSetting2);
                TTAdSdk.init(context, builderAppId.appName(adSetting2.getGlobalAd().getName()).useMediation(true).debug(false).supportMultiProcess(false).build());
                TTAdSdk.start(new TTAdSdk.Callback() { // from class: com.funny.audio.ad.AdManager.init.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                    public void success() {
                        Log.i(AdManager.tagName, "融合sdk初始化成功！");
                        AdManager.INSTANCE.setInitSuccess(true);
                        AdSetting setting2 = AdManager.INSTANCE.getSetting();
                        Intrinsics.checkNotNull(setting2);
                        if (setting2.getMediaPlayerRewardAd().getShow()) {
                            AdManager.INSTANCE.setMediaPlayerRewardVideoAdLoader(new RewardVideoAdLoader());
                            RewardVideoAdLoader mediaPlayerRewardVideoAdLoader2 = AdManager.INSTANCE.getMediaPlayerRewardVideoAdLoader();
                            Intrinsics.checkNotNull(mediaPlayerRewardVideoAdLoader2);
                            Application context2 = AdManager.INSTANCE.getContext();
                            Intrinsics.checkNotNull(context2);
                            AdSetting setting3 = AdManager.INSTANCE.getSetting();
                            Intrinsics.checkNotNull(setting3);
                            mediaPlayerRewardVideoAdLoader2.init(context2, setting3.getMediaPlayerRewardAd());
                        }
                        AdSetting setting4 = AdManager.INSTANCE.getSetting();
                        Intrinsics.checkNotNull(setting4);
                        if (setting4.getPureModeRewardAd().getShow()) {
                            AdManager.INSTANCE.setPureModeRewardVideoAdLoader(new RewardVideoAdLoader());
                            RewardVideoAdLoader pureModeRewardVideoAdLoader2 = AdManager.INSTANCE.getPureModeRewardVideoAdLoader();
                            Intrinsics.checkNotNull(pureModeRewardVideoAdLoader2);
                            Application context3 = AdManager.INSTANCE.getContext();
                            Intrinsics.checkNotNull(context3);
                            AdSetting setting5 = AdManager.INSTANCE.getSetting();
                            Intrinsics.checkNotNull(setting5);
                            pureModeRewardVideoAdLoader2.init(context3, setting5.getPureModeRewardAd());
                        }
                        AdSetting setting6 = AdManager.INSTANCE.getSetting();
                        Intrinsics.checkNotNull(setting6);
                        if (setting6.getMediaPlayerFeedAd().getShow()) {
                            AdManager.INSTANCE.setMediaPlayerFeedAdLoader(new FeedAdLoader());
                            FeedAdLoader mediaPlayerFeedAdLoader2 = AdManager.INSTANCE.getMediaPlayerFeedAdLoader();
                            Intrinsics.checkNotNull(mediaPlayerFeedAdLoader2);
                            Application context4 = AdManager.INSTANCE.getContext();
                            Intrinsics.checkNotNull(context4);
                            AdSetting setting7 = AdManager.INSTANCE.getSetting();
                            Intrinsics.checkNotNull(setting7);
                            mediaPlayerFeedAdLoader2.init(context4, setting7.getMediaPlayerFeedAd());
                        }
                        AdSetting setting8 = AdManager.INSTANCE.getSetting();
                        Intrinsics.checkNotNull(setting8);
                        if (setting8.getBookshelfInterstitialAd().getShow()) {
                            AdManager.INSTANCE.setBookshelfInterstitialAdLoader(new InterstitialAdLoader());
                            InterstitialAdLoader bookshelfInterstitialAdLoader2 = AdManager.INSTANCE.getBookshelfInterstitialAdLoader();
                            Intrinsics.checkNotNull(bookshelfInterstitialAdLoader2);
                            Application context5 = AdManager.INSTANCE.getContext();
                            Intrinsics.checkNotNull(context5);
                            AdSetting setting9 = AdManager.INSTANCE.getSetting();
                            Intrinsics.checkNotNull(setting9);
                            bookshelfInterstitialAdLoader2.init(context5, setting9.getBookshelfInterstitialAd());
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                    public void fail(int code, String msg) {
                        Log.e(AdManager.tagName, "融合sdk初始化失败: " + code + ", " + msg);
                        AdManager.INSTANCE.setInitSuccess(false);
                    }
                });
            }
        } catch (Exception unused) {
            initSuccess = false;
            Log.e(tagName, "融合sdk初始化失败！");
        }
    }

    public final List<AdInfo> loadAdInfos() {
        String appKey = AppManager.INSTANCE.getAppKey();
        Response<List<AdInfo>> adInfo = ApiManager.INSTANCE.getCloud().getAdInfo(appKey, AppManager.INSTANCE.getAppChannel());
        if (adInfo == null || !NetModelsKt.successWithData(adInfo)) {
            String str = tagName;
            Log.e(str, "根据包名渠道获取不到广告配置信息");
            Response<List<AdInfo>> adInfo2 = ApiManager.INSTANCE.getCloud().getAdInfo(appKey);
            if (adInfo2 == null || !NetModelsKt.successWithData(adInfo2)) {
                Log.e(str, "根据包名获取不到广告配置信息");
                adInfo2 = ApiManager.INSTANCE.getCloud().getAdInfo();
                if (adInfo2 == null || !NetModelsKt.successWithData(adInfo2)) {
                    Log.e(str, "获取不到广告配置信息");
                    return null;
                }
            }
            adInfo = adInfo2;
        }
        AppBody<List<AdInfo>> body = adInfo.getBody();
        Intrinsics.checkNotNull(body);
        List<AdInfo> data = body.getData();
        Intrinsics.checkNotNull(data);
        return data;
    }

    public final void requestPermissionIfNecessary(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.requestPermissionIfNecessary(context2);
        }
    }
}
