package com.kwad.components.ad.fullscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.n;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
public class KsFullScreenVideoActivityProxy extends com.kwad.components.core.m.b<com.kwad.components.ad.reward.g> implements OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "FullScreenVideo";
    private static final HashMap<String, c> sHashMap = new HashMap<>();
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.fullscreen.c.b mFullScreenPresenter;
    private c mInteractionListener;
    private boolean mIsBackEnable;
    private boolean mPageDismissCalled;
    public long mPageEnterTime;
    private JSONObject mReportExtData;
    private AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    private bv mTimerHelper;
    private KsVideoPlayConfig mVideoPlayConfig;
    private b model;
    private boolean mReportedPageResume = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private d mAdOpenInteractionListener = new d() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.2
        @Override // com.kwad.components.ad.fullscreen.d, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z) {
            if (KsFullScreenVideoActivityProxy.this.notifyPageDismiss()) {
                super.i(z);
            }
        }
    };

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "KsFullScreenVideoActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return true;
    }

    public static void launch(Context context, AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, c cVar) {
        Intent intent;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.b.c.r(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(false, adTemplateR);
        n.eL(adTemplateR);
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.c.a(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
            intent = new Intent(context, (Class<?>) KsFullScreenLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.c.a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
            intent = new Intent(context, (Class<?>) FeedDownloadActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.ol().l(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        sHashMap.put(getListenerKey(adTemplateR), cVar);
        try {
            context.startActivity(intent);
            com.kwad.sdk.a.a.c.CU().bm(true);
            reportSubPageCreate(PageCreateStage.END_LAUNCH.getStage(), adTemplateR);
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.c.a(false, adTemplateR, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            throw th;
        }
    }

    private static String getListenerKey(AdTemplate adTemplate) {
        return adTemplate == null ? "" : String.valueOf(com.kwad.sdk.core.response.b.e.el(adTemplate).adBaseInfo.creativeId);
    }

    public static void register() {
        com.kwad.sdk.service.c.a(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
        com.kwad.sdk.service.c.a(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.d.c.bL(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.monitor.b.b(false, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage(), this.mAdTemplate);
    }

    private static void reportSubPageCreate(String str, AdTemplate adTemplate) {
        com.kwad.components.ad.reward.monitor.c.c(false, adTemplate, str);
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        try {
            super.onPause();
            getTimerHelper().Sm();
            if (this.mCallerContext != 0) {
                ((com.kwad.components.ad.reward.g) this.mCallerContext).mPageEnterTime = -1L;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            getTimerHelper().Sl();
            if (this.mReportedPageResume) {
                return;
            }
            com.kwad.components.ad.reward.monitor.c.f(false, this.mAdTemplate);
            this.mReportedPageResume = true;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(Intent intent) {
        if (com.kwad.sdk.core.config.e.Gg()) {
            this.mVideoPlayConfig = com.kwad.components.core.internal.api.e.b(getIntent().getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
            if (serializableExtra instanceof KsVideoPlayConfig) {
                this.mVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
            }
        }
        AdResultData adResultDataD = com.kwad.components.core.c.f.ol().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = adResultDataD;
        if (adResultDataD == null) {
            return false;
        }
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultDataD);
        this.model = new b(this.mAdTemplate);
        this.mAdOpenInteractionListener.setAdTemplate(this.mAdTemplate);
        return (this.mVideoPlayConfig == null || this.mAdTemplate == null) ? false : true;
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        b bVar = this.model;
        if (bVar != null && bVar.jk) {
            return R.layout.ksad_activity_fullscreen_tk;
        }
        return R.layout.ksad_activity_fullscreen_video_legacy;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mPageEnterTime = jElapsedRealtime;
        com.kwad.components.ad.reward.monitor.c.a(false, this.mAdTemplate, jElapsedRealtime);
        com.kwad.components.ad.reward.monitor.c.g(false, this.mAdTemplate);
        c cVar = sHashMap.get(getListenerKey(this.mAdTemplate));
        this.mInteractionListener = cVar;
        this.mAdOpenInteractionListener.a(cVar);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        this.mScreenOrientation = this.mVideoPlayConfig.isShowLandscape() ? 1 : 0;
        this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        initVideoPlayConfig(this.mVideoPlayConfig);
    }

    private void initVideoPlayConfig(KsVideoPlayConfig ksVideoPlayConfig) {
        if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        JSONObject jSONObject = new JSONObject();
        this.mReportExtData = jSONObject;
        aa.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.m.b
    public com.kwad.components.ad.reward.g onCreateCallerContext() {
        long jAm;
        com.kwad.components.ad.reward.g gVar = new com.kwad.components.ad.reward.g(this);
        gVar.a(this.mAdResultData);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.rC = false;
        gVar.rD = this.mAdOpenInteractionListener;
        gVar.mScreenOrientation = this.mScreenOrientation;
        gVar.mVideoPlayConfig = this.mVideoPlayConfig;
        gVar.mReportExtData = this.mReportExtData;
        gVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate, this.mReportExtData);
        }
        gVar.rG = new RewardActionBarControl(gVar, this.mContext, this.mAdTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate)) {
            gVar.rH = new j(gVar, this.mReportExtData, null);
        }
        if (com.kwad.sdk.core.response.b.a.bK(this.mAdInfo)) {
            gVar.rF = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar.rS = false;
        if (com.kwad.sdk.core.response.b.a.bK(this.mAdInfo)) {
            jAm = com.kwad.sdk.core.response.b.a.ar(this.mAdInfo);
        } else {
            jAm = com.kwad.sdk.core.response.b.a.am(this.mAdInfo);
        }
        gVar.sq = jAm;
        gVar.mTimerHelper = getTimerHelper();
        gVar.rE = new com.kwad.components.ad.reward.m.e(gVar);
        return gVar;
    }

    private bv getTimerHelper() {
        if (this.mTimerHelper == null) {
            bv bvVar = new bv();
            this.mTimerHelper = bvVar;
            bvVar.startTiming();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.components.core.m.b
    public Presenter onCreatePresenter() {
        getActivity();
        com.kwad.components.ad.fullscreen.c.b bVar = new com.kwad.components.ad.fullscreen.c.b(this, this.mRootContainer, this.model, (com.kwad.components.ad.reward.g) this.mCallerContext);
        this.mFullScreenPresenter = bVar;
        return bVar;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.ad.fullscreen.c.b bVar = this.mFullScreenPresenter;
        if ((bVar == null || !bVar.onBackPressed()) && this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.i(false);
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            this.mAdOpenInteractionListener.i(false);
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                String strK = com.kwad.sdk.core.response.b.a.K(adInfo);
                if (!TextUtils.isEmpty(strK)) {
                    com.kwad.sdk.core.videocache.c.a.bR(this.mContext.getApplicationContext()).eM(strK);
                }
            }
            if (this.mCallerContext != 0 && ((com.kwad.components.ad.reward.g) this.mCallerContext).rE != null && ((com.kwad.components.ad.reward.g) this.mCallerContext).rE.kW()) {
                ((com.kwad.components.ad.reward.g) this.mCallerContext).rE.kX().removeInterceptor(this);
            }
            sHashMap.remove(getListenerKey(this.mAdTemplate));
            this.mInteractionListener = null;
            com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.d.be(this.mAdTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss() {
        if (this.mPageDismissCalled) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (this.mAdTemplate != null && this.mAdInfo != null) {
            long time = getTimerHelper().getTime();
            com.kwad.sdk.a.a.c.CU().CX();
            com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 6, time, this.mReportExtData);
            if (com.kwad.sdk.core.response.b.a.cS(this.mAdInfo) && !((com.kwad.components.ad.reward.g) this.mCallerContext).mw) {
                com.kwad.sdk.core.adlog.c.m(this.model.getAdTemplate(), (int) Math.ceil(time / 1000.0f));
            }
        }
        return true;
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return ((com.kwad.components.ad.reward.g) this.mCallerContext).gG();
    }
}
