package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.exception.KSAdPreCreateException;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.t.c;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bv;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
public class KSRewardVideoActivityProxy extends com.kwad.components.core.m.b<g> implements g.b, n.a, c.b, OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "RewardVideo";
    private String listenerKey;
    private boolean mIsBackEnable;
    private com.kwad.components.ad.reward.model.c mModel;
    private boolean mPageDismissCalled;
    private long mPageEnterTime;
    private n mRewardPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bv mTimerHelper;
    private boolean mReportedPageResume = false;
    private boolean mIsFinishVideoLookStep = false;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.it() && ((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).sc != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private com.kwad.components.ad.reward.e.i mAdOpenInteractionListener = new com.kwad.components.ad.reward.e.i() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void cW() {
            super.cW();
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).iH = true;
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).gN();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void onRewardVerify() {
            if (!((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult || ((g) KSRewardVideoActivityProxy.this.mCallerContext).sc == 2) {
                return;
            }
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z) {
            if (KSRewardVideoActivityProxy.this.notifyPageDismiss(z)) {
                com.kwad.sdk.a.a.c.CU().CX();
                super.i(z);
            }
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.components.ad.reward.e.d mAdRewardStepListener = new com.kwad.components.ad.reward.e.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.components.ad.reward.e.d
        public final void gp() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return true;
    }

    private bv getTimerHelper() {
        if (this.mTimerHelper == null) {
            bv bvVar = new bv();
            this.mTimerHelper = bvVar;
            bvVar.startTiming();
        }
        return this.mTimerHelper;
    }

    public static void launch(Activity activity, AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.j.d dVar, int i) {
        Intent intent;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.b.c.r(adResultData);
        com.kwad.components.ad.reward.monitor.c.i(true, adTemplateR);
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        com.kwad.sdk.utils.n.eL(adTemplateR);
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            ksVideoPlayConfig.setShowLandscape(false);
        }
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.c.a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KSRewardLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.c.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KsRewardVideoActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("key_template_json", adTemplateR.toJson().toString());
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.ol().l(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        intent.putExtra(KEY_REWARD_TYPE, i);
        String uniqueId = adTemplateR.getUniqueId();
        com.kwad.components.ad.reward.e.f.a(uniqueId, rewardAdInteractionListener, dVar);
        com.kwad.components.ad.reward.e.f.O(uniqueId);
        try {
            activity.startActivity(intent);
            com.kwad.sdk.a.a.c.CU().bm(true);
            com.kwad.components.ad.reward.monitor.c.c(true, adTemplateR, PageCreateStage.END_LAUNCH.getStage());
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.c.a(true, adTemplateR, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            ServiceProvider.reportSdkCaughtException(new KSAdPreCreateException("ksad_pre_create_exception_error_start_activity", th));
            throw th;
        }
    }

    public static void register() {
        com.kwad.sdk.service.c.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
        reportSubPageCreate(PageCreateStage.END_CHILD_ON_PRE_CREATE.getStage());
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(Intent intent) {
        com.kwad.components.ad.reward.model.c cVarA = com.kwad.components.ad.reward.model.c.a(intent);
        this.mModel = cVarA;
        return cVarA != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.b.b(true, cVar != null ? cVar.getAdTemplate() : null);
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null && cVar.jk) {
            return R.layout.ksad_activity_reward_neo;
        }
        return R.layout.ksad_activity_reward_video_legacy;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mAdOpenInteractionListener.setAdTemplate(this.mModel.getAdTemplate());
        this.mAdOpenInteractionListener.R(getUniqueId());
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.c.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime, this.mModel.iy());
        com.kwad.components.ad.reward.monitor.c.g(true, this.mModel.getAdTemplate());
        com.kwad.components.core.t.c.sZ().a(this);
        b.gk().a(this.mRewardVerifyListener);
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        if (this.mCallerContext != 0) {
            ((g) this.mCallerContext).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.d.c.bL(this.mModel.getAdTemplate());
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        com.kwad.sdk.core.d.c.d(TAG, "onCreateStageChange: " + pageCreateStage.getStage());
        reportSubPageCreate(pageCreateStage.getStage());
    }

    private void reportSubPageCreate(String str) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.c.c(true, cVar != null ? cVar.getAdTemplate() : null, str);
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                AdTemplate adTemplate = cVar.getAdTemplate();
                com.kwad.sdk.core.local.a.Hq();
                com.kwad.sdk.core.local.a.ch(adTemplate);
            }
            if (!this.mReportedPageResume) {
                com.kwad.components.ad.reward.monitor.c.f(true, this.mModel.getAdTemplate());
                this.mReportedPageResume = true;
            }
            com.kwad.components.ad.reward.c.a.hV().R(this.mContext);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.m.b
    public Presenter onCreatePresenter() {
        if (this.mModel == null) {
            return null;
        }
        n nVar = new n(this, this.mContext, this.mRootContainer, this.mModel, (g) this.mCallerContext);
        this.mRewardPresenter = nVar;
        nVar.a(this);
        return this.mRewardPresenter;
    }

    private String getUniqueId() {
        return this.listenerKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.m.b
    public g onCreateCallerContext() {
        long jAm;
        AdResultData adResultDataIu = this.mModel.iu();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo adInfoCU = this.mModel.cU();
        final g gVar = new g(this);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.rC = this.mModel.iw() == 2;
        gVar.rD = this.mAdOpenInteractionListener;
        gVar.mAdRewardStepListener = this.mAdRewardStepListener;
        gVar.mScreenOrientation = this.mModel.getScreenOrientation();
        gVar.mVideoPlayConfig = this.mModel.iv();
        gVar.mReportExtData = this.mModel.ix();
        gVar.mRootContainer = this.mRootContainer;
        gVar.a(adResultDataIu);
        gVar.sx = com.kwad.sdk.core.response.b.b.em(adInfoCU) ? LoadStrategy.FULL_TK : LoadStrategy.MULTI;
        gVar.a(this);
        if (com.kwad.sdk.core.response.b.a.aF(adInfoCU)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(adTemplate, this.mModel.ix());
        }
        gVar.rG = new RewardActionBarControl(gVar, this.mContext, adTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.b.b.cL(adTemplate)) {
            gVar.rH = new j(gVar, this.mModel.ix(), null);
            gVar.rH.a(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
                @Override // com.kwad.components.ad.reward.c.d
                public final void a(com.kwad.components.ad.reward.c.b bVar) {
                    gVar.b(bVar);
                }
            });
        }
        if (com.kwad.sdk.core.response.b.a.as(adInfoCU)) {
            gVar.rI = new com.kwad.components.ad.l.a().ah(true);
        }
        gVar.rS = true;
        if (com.kwad.sdk.core.response.b.a.bK(adInfoCU)) {
            gVar.rF = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar.sq = 0L;
        if (this.mModel.cU() != null) {
            if (com.kwad.sdk.core.response.b.a.bK(this.mModel.cU())) {
                jAm = com.kwad.sdk.core.response.b.a.ar(this.mModel.cU());
            } else {
                jAm = com.kwad.sdk.core.response.b.a.am(this.mModel.cU());
            }
            gVar.sq = jAm;
        }
        gVar.mTimerHelper = getTimerHelper();
        gVar.rE = new com.kwad.components.ad.reward.m.e(gVar);
        gVar.jk = this.mModel.jk;
        return gVar;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        n nVar = this.mRewardPresenter;
        if (nVar == null) {
            super.onBackPressed();
            return;
        }
        BackPressHandleResult backPressHandleResultHx = nVar.hx();
        if (backPressHandleResultHx.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (backPressHandleResultHx.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            this.mAdOpenInteractionListener.i(false);
        } else if (this.mIsBackEnable) {
            this.mAdOpenInteractionListener.i(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.i(false);
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreDestroy() {
        super.onPreDestroy();
        com.kwad.components.core.webview.tachikoma.e.c.vO().vP();
    }

    @Override // com.kwad.components.core.m.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            b.gk().b(this.mRewardVerifyListener);
            super.onDestroy();
            this.mAdOpenInteractionListener.i(false);
            if (this.mCallerContext != 0) {
                i.hs().H(String.valueOf(((g) this.mCallerContext).mAdTemplate));
                com.kwad.components.ad.reward.e.f.Q(getUniqueId());
            }
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                String strK = com.kwad.sdk.core.response.b.a.K(cVar.cU());
                if (!TextUtils.isEmpty(strK)) {
                    com.kwad.sdk.core.videocache.c.a.bR(this.mContext.getApplicationContext()).eM(strK);
                }
                com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.d.be(this.mModel.getAdTemplate()));
            }
            com.kwad.components.core.t.c.sZ().b(this);
            this.listenerKey = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        if (this.mModel.is()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
                return;
            }
            return;
        }
        if (this.mModel.it()) {
            boolean z = ((g) this.mCallerContext).sn != null && ((g) this.mCallerContext).sn.isCompleted();
            notifyRewardStep(1, 0);
            if (z) {
                notifyRewardStep(1, 1);
                return;
            }
            return;
        }
        if (this.mIsFinishVideoLookStep) {
            return;
        }
        this.mIsFinishVideoLookStep = true;
        notifyRewardStep(0, 0);
    }

    private void notifyRewardStep(final int i, final int i2) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.b.e.ew(cVar.getAdTemplate()) || ((g) this.mCallerContext).rZ.contains(Integer.valueOf(i2))) {
            return;
        }
        ((g) this.mCallerContext).rZ.add(Integer.valueOf(i2));
        o.a(i, i2, (g) this.mCallerContext, this.mModel);
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.i(i, i2)) {
                        com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), i, i2, false);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        });
    }

    private boolean isLaunchTaskCompleted() {
        return ((g) this.mCallerContext).sm != null && ((g) this.mCallerContext).sm.isCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        if (((g) this.mCallerContext).sn != null) {
            ((g) this.mCallerContext).sn.markOpenNsCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        if (this.mModel == null || !((g) this.mCallerContext).mCheckExposureResult || com.kwad.sdk.core.response.b.e.ew(this.mModel.getAdTemplate()) || ((g) this.mCallerContext).gW()) {
            return;
        }
        boolean z = false;
        if (this.mModel.is()) {
            if (((g) this.mCallerContext).sm != null && ((g) this.mCallerContext).sm.isCompleted()) {
                z = true;
            }
            if (z) {
                handleNotifyVerify(true);
                return;
            }
            return;
        }
        if (this.mModel.it()) {
            if (((g) this.mCallerContext).sn != null && ((g) this.mCallerContext).sn.isCompleted()) {
                z = true;
            }
            if (z) {
                handleNotifyVerify(true);
                return;
            }
            return;
        }
        handleNotifyVerify(false);
    }

    private void handleNotifyVerify(boolean z) {
        this.mAdOpenInteractionListener.setCallerContext((g) this.mCallerContext);
        ((g) this.mCallerContext).F(true);
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        if (z || ((g) this.mCallerContext).sc == 0) {
            e.gy().L(this.mModel.getAdTemplate());
        }
        com.kwad.sdk.core.adlog.c.i(this.mModel.getAdTemplate(), isNeoScan());
        if (!((g) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.c.a.hV().hW().aa(com.kwad.components.ad.reward.c.b.ul);
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.ib()) {
                    com.kwad.components.ad.reward.monitor.c.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), 0, -1, true);
                }
            }
        });
        if (!com.kwad.sdk.core.response.b.a.cY(this.mModel.cU()) || ((g) this.mCallerContext).mAdTemplate.converted || ((g) this.mCallerContext).rT || ((g) this.mCallerContext).gU()) {
            return;
        }
        g.a(getActivity(), (g) this.mCallerContext);
    }

    private boolean isNeoScan() {
        return this.mModel.iy() != null && this.mModel.iy().neoPageType == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss(boolean z) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (!com.kwad.sdk.core.response.b.a.cS(cVar.cU()) || !((g) this.mCallerContext).gT()) {
            com.kwad.sdk.core.adlog.c.m(this.mModel.getAdTemplate(), (int) Math.ceil(getTimerHelper().getTime() / 1000.0f));
        }
        if (z) {
            if (this.mModel.iy() == null || this.mModel.iy().neoPageType != 1) {
                com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((g) this.mCallerContext).mReportExtData);
            }
        } else if (this.mModel.iy() == null || this.mModel.iy().neoPageType != 1) {
            com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.ix());
        }
        return true;
    }

    @Override // com.kwad.components.core.t.c.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.ad.reward.n.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        ((g) this.mCallerContext).F(false);
        ((g) this.mCallerContext).rX = false;
    }

    @Override // com.kwad.components.ad.reward.g.b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    private boolean needHandledOnResume() {
        return ((g) this.mCallerContext).gV();
    }
}
