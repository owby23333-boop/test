package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.n;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.r.d;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.d;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bh;
import com.kwai.adclient.logger.model.BusinessType;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
public class KSRewardVideoActivityProxy extends com.kwad.components.core.j.b<j> implements com.kwad.components.ad.reward.g.c, j.b, n.a, d.b, d.a, OnAdLiveResumeInterceptor {
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_TEMPLATE_PLAY_AGAIN = "key_template_json_play_again";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    private static final String TAG = "RewardVideo";
    private String listenerKey;
    private DetailVideoView mDetailVideoView;
    private boolean mIsBackEnable;
    private com.kwad.components.ad.reward.model.c mModel;
    private boolean mPageDismissCalled;
    private long mPageEnterTime;
    private FrameLayout mPlayLayout;
    private long mPlayTime;
    private n mRewardPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bg mTimerHelper;
    private final com.kwad.components.ad.reward.d.j mRewardVerifyListener = new com.kwad.components.ad.reward.d.j() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.d.j
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.hC()) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.components.ad.reward.d.d mAdRewardStepListener = new com.kwad.components.ad.reward.d.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
        @Override // com.kwad.components.ad.reward.d.d
        public final void fI() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };
    private com.kwad.components.core.video.i mVideoPlayStateListener = new com.kwad.components.core.video.j() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
        @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
        public final void onVideoPlayProgress(long j2, long j3) {
            KSRewardVideoActivityProxy.this.mPlayTime = j3;
        }
    };
    private AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayProgress(long j2) {
            super.onLivePlayProgress(j2);
            KSRewardVideoActivityProxy.this.mPlayTime = j2;
        }
    };
    private com.kwad.components.ad.reward.d.b mAdOpenInteractionListener = new com.kwad.components.ad.reward.d.c() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.8
        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void bN() {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerE = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (rewardAdInteractionListenerE != null) {
                rewardAdInteractionListenerE.onAdClicked();
            }
            ((j) KSRewardVideoActivityProxy.this.mCallerContext).fN = true;
            ((j) KSRewardVideoActivityProxy.this.mCallerContext).ge();
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void h(boolean z2) {
            com.kwad.sdk.kwai.kwai.c.tm().tp();
            KSRewardVideoActivityProxy.this.notifyPageDismiss(false);
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onRewardVerify() {
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayEnd() {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerE = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (rewardAdInteractionListenerE != null) {
                rewardAdInteractionListenerE.onVideoPlayEnd();
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayError(int i2, int i3) {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerE = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (rewardAdInteractionListenerE != null) {
                rewardAdInteractionListenerE.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoPlayStart() {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerE = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
            if (rewardAdInteractionListenerE != null) {
                rewardAdInteractionListenerE.onVideoPlayStart();
            }
        }

        @Override // com.kwad.components.ad.reward.d.c, com.kwad.components.ad.reward.d.b
        public final void onVideoSkipToEnd(long j2) {
            try {
                KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerE = a.E(KSRewardVideoActivityProxy.this.getUniqueId());
                if (rewardAdInteractionListenerE != null) {
                    rewardAdInteractionListenerE.onVideoSkipToEnd(j2);
                }
            } catch (Throwable unused) {
            }
        }
    };

    public static class a {
        private static final HashMap<String, a> pf = new HashMap<>();
        private KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
        private com.kwad.components.core.g.d oc;
        private KsRewardVideoAd.RewardAdInteractionListener pg;
        private KsRewardVideoAd.RewardAdInteractionListener ph;

        @Nullable
        private static a D(String str) {
            return pf.get(str);
        }

        public static KsRewardVideoAd.RewardAdInteractionListener E(String str) {
            a aVarD = D(str);
            if (aVarD != null) {
                return aVarD.ph;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void F(String str) {
            a aVarD = D(str);
            if (aVarD != null) {
                aVarD.ph = aVarD.mInteractionListener;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void G(String str) {
            a aVarD = D(str);
            if (aVarD != null) {
                aVarD.ph = aVarD.pg;
            }
        }

        public static com.kwad.components.core.g.d H(String str) {
            a aVarD = D(str);
            if (aVarD != null) {
                return aVarD.oc;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void I(String str) {
            a aVarD = D(str);
            if (aVarD != null) {
                aVarD.destroy();
                pf.put(str, null);
            }
        }

        public static void a(String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2, com.kwad.components.core.g.d dVar) {
            a aVar = new a();
            aVar.mInteractionListener = rewardAdInteractionListener;
            aVar.pg = rewardAdInteractionListener2;
            aVar.oc = dVar;
            aVar.ph = aVar.mInteractionListener;
            pf.put(str, aVar);
        }

        private void destroy() {
            this.mInteractionListener = null;
            this.pg = null;
            this.ph = null;
            com.kwad.components.core.g.d dVar = this.oc;
            if (dVar != null) {
                dVar.destroy();
                this.oc = null;
            }
        }
    }

    private bg getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bg();
            this.mTimerHelper.startTiming();
        }
        return this.mTimerHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUniqueId() {
        return this.listenerKey;
    }

    private void handleNotifyVerify() {
        ((j) this.mCallerContext).mRewardVerifyCalled = true;
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        h.fQ().n(this.mModel.getAdTemplate());
        com.kwad.sdk.core.report.a.aD(this.mModel.getAdTemplate());
        if (!((j) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.b.a.hi().hj().P(com.kwad.components.ad.reward.b.b.rQ);
        }
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerE = a.E(getUniqueId());
        if (rewardAdInteractionListenerE != null) {
            rewardAdInteractionListenerE.onRewardVerify();
            com.kwad.components.ad.reward.monitor.a.a(this.mModel.getAdTemplate(), 0, -1, true);
        }
        if (com.kwad.sdk.core.response.a.a.cv(this.mModel.bK())) {
            T t2 = this.mCallerContext;
            if (((j) t2).mAdTemplate.converted || ((j) t2).pO || ((j) t2).go()) {
                return;
            }
            j.a(getActivity(), (j) this.mCallerContext);
        }
    }

    private void initPlayAgain() {
        if (this.mModel.getAdTemplate() == null || this.mModel.getAdTemplate().mPlayAgain == null) {
            return;
        }
        final AdTemplate adTemplate = this.mModel.getAdTemplate().mPlayAgain;
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d(KSRewardVideoActivityProxy.TAG, "cache playAgain result: " + com.kwad.components.ad.b.a.a(adTemplate, true));
            }
        });
    }

    private boolean isLaunchTaskCompleted() {
        T t2 = this.mCallerContext;
        return ((j) t2).qc != null && ((j) t2).qc.isCompleted();
    }

    public static void launch(Activity activity, @NonNull AdTemplate adTemplate, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener2, com.kwad.components.core.g.d dVar, int i2) {
        Intent intent;
        com.kwad.sdk.utils.l.ct(adTemplate);
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.a.a(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KSRewardLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.a.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KsRewardVideoActivity.class);
        }
        intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.putExtra("key_template_json", adTemplate.toJson().toString());
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra(KEY_REWARD_TYPE, i2);
        if (adTemplate.hasPlayAgain() && rewardAdInteractionListener2 != null) {
            intent.putExtra(KEY_TEMPLATE_PLAY_AGAIN, adTemplate.mPlayAgain.toJson().toString());
        }
        String uniqueId = adTemplate.getUniqueId();
        a.a(uniqueId, rewardAdInteractionListener, rewardAdInteractionListener2, dVar);
        a.F(uniqueId);
        activity.startActivity(intent);
        com.kwad.sdk.kwai.kwai.c.tm().aR(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        T t2 = this.mCallerContext;
        if (((j) t2).qd != null) {
            ((j) t2).qd.markOpenNsCompleted();
        }
    }

    private boolean needHandledOnResume() {
        return ((j) this.mCallerContext).gp() || isRefluxVisible();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPageDismiss(boolean z2) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return;
        }
        this.mPageDismissCalled = true;
        com.kwad.sdk.core.report.a.m(cVar.getAdTemplate(), (int) Math.ceil(this.mPlayTime / 1000.0f));
        if (z2) {
            com.kwad.sdk.core.report.a.a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((j) this.mCallerContext).mReportExtData);
        } else {
            com.kwad.sdk.core.report.a.a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.hF());
        }
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListenerE = a.E(getUniqueId());
        if (rewardAdInteractionListenerE != null) {
            rewardAdInteractionListenerE.onPageDismiss();
        }
    }

    private void notifyRewardStep(int i2, int i3) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.a.d.cl(cVar.getAdTemplate()) || ((j) this.mCallerContext).pU.contains(Integer.valueOf(i3))) {
            return;
        }
        ((j) this.mCallerContext).pU.add(Integer.valueOf(i3));
        o.a(i2, i3, (j) this.mCallerContext, this.mModel);
        if (a.E(getUniqueId()) == null) {
            return;
        }
        try {
            a.E(getUniqueId()).onRewardStepVerify(i2, i3);
            com.kwad.components.ad.reward.monitor.a.a(this.mModel.getAdTemplate(), i2, i3, false);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.a.d.cl(cVar.getAdTemplate()) || ((j) this.mCallerContext).mRewardVerifyCalled) {
            return;
        }
        if (this.mModel.hB()) {
            T t2 = this.mCallerContext;
            if (((j) t2).qc != null && ((j) t2).qc.isCompleted()) {
                handleNotifyVerify();
                return;
            }
            return;
        }
        if (!this.mModel.hC()) {
            handleNotifyVerify();
            return;
        }
        T t3 = this.mCallerContext;
        if (((j) t3).qd != null && ((j) t3).qd.isCompleted()) {
            handleNotifyVerify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        if (this.mModel.hB()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
                return;
            }
            return;
        }
        if (!this.mModel.hC()) {
            notifyRewardStep(0, 0);
            return;
        }
        T t2 = this.mCallerContext;
        boolean z2 = ((j) t2).qd != null && ((j) t2).qd.isCompleted();
        notifyRewardStep(1, 0);
        if (z2) {
            notifyRewardStep(1, 1);
        }
    }

    public static void register() {
        com.kwad.sdk.service.a.a(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    @Override // com.kwad.components.core.l.d
    public boolean checkIntentData(@Nullable Intent intent) {
        this.mModel = com.kwad.components.ad.reward.model.c.c(intent);
        if (this.mModel != null) {
            return true;
        }
        com.kwad.sdk.f.a.U("reward", TTLogUtil.TAG_EVENT_SHOW);
        return false;
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        notifyPageDismiss(false);
    }

    @Override // com.kwad.components.core.l.d
    public int getLayoutId() {
        return R.layout.ksad_activity_reward_video;
    }

    @Override // com.kwad.components.core.l.d
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.l.d
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.a.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime);
        com.kwad.components.ad.reward.monitor.a.K(true);
        com.kwad.components.core.r.d.qb().a(this);
        c.fD().a(this.mRewardVerifyListener);
        initPlayAgain();
    }

    @Override // com.kwad.components.core.l.d
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mDetailVideoView = (DetailVideoView) this.mRootContainer.findViewById(R.id.ksad_video_player);
        this.mPlayLayout = (FrameLayout) this.mRootContainer.findViewById(R.id.ksad_reward_play_layout);
        boolean z2 = !ah.cu(this.mContext);
        if ((this.mModel.hB() || this.mModel.hC()) && z2) {
            this.mDetailVideoView.setForce(true);
        }
        this.mDetailVideoView.f(true, com.kwad.sdk.core.config.d.vh());
        com.kwad.sdk.f.a.U("reward", TTLogUtil.TAG_EVENT_SHOW);
    }

    @Override // com.kwad.components.ad.reward.j.b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    public boolean isRefluxVisible() {
        return this.mRewardPresenter.isRefluxVisible();
    }

    @Override // com.kwad.components.core.l.d
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.j.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        BackPressHandleResult backPressHandleResultGI = this.mRewardPresenter.gI();
        if (backPressHandleResultGI.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (backPressHandleResultGI.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            notifyPageDismiss(false);
        } else if (this.mIsBackEnable) {
            notifyPageDismiss(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "adShowSuccess").report();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.j.b
    public j onCreateCallerContext() {
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo adInfoBK = this.mModel.bK();
        final j jVar = new j(this);
        jVar.mPageEnterTime = this.mPageEnterTime;
        jVar.mAdOpenInteractionListener = this.mAdOpenInteractionListener;
        jVar.mAdRewardStepListener = this.mAdRewardStepListener;
        jVar.mScreenOrientation = this.mModel.getScreenOrientation();
        jVar.mVideoPlayConfig = this.mModel.hD();
        jVar.mReportExtData = this.mModel.hF();
        jVar.mRootContainer = this.mRootContainer;
        jVar.mAdTemplate = adTemplate;
        jVar.qo = com.kwad.sdk.core.response.a.b.m70do(adInfoBK) ? LoadStrategy.FULL_TK : LoadStrategy.MULTI;
        com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        jVar.pv = this.mDetailVideoView;
        com.kwad.components.ad.reward.j.a aVar = new com.kwad.components.ad.reward.j.a(jVar, this.mModel.hE() == 2);
        jVar.pw = new com.kwad.components.ad.reward.j.b(aVar);
        jVar.pw.ka().a(this.mVideoPlayStateListener);
        jVar.a(aVar);
        jVar.a((j.b) this);
        if (com.kwad.sdk.core.response.a.a.ay(adInfoBK)) {
            jVar.mApkDownloadHelper = new com.kwad.components.core.d.b.c(adTemplate, this.mModel.hF());
        }
        jVar.pz = new RewardActionBarControl(jVar, this.mContext, adTemplate);
        jVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.a.b.bf(adTemplate)) {
            jVar.pA = new l(jVar, this.mModel.hF(), null);
            jVar.pA.a(new com.kwad.components.ad.reward.b.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
                @Override // com.kwad.components.ad.reward.b.d
                public final void a(com.kwad.components.ad.reward.b.b bVar) {
                    jVar.b(bVar);
                }
            });
        }
        if (com.kwad.sdk.core.response.a.b.bG(adTemplate)) {
            String strBI = com.kwad.sdk.core.response.a.b.bI(adTemplate);
            if (!TextUtils.isEmpty(strBI)) {
                jVar.pB = new com.kwad.components.ad.i.b(this.mModel.hF(), strBI);
                jVar.pB.a(this);
            }
        }
        if (com.kwad.sdk.core.response.a.a.ak(adInfoBK)) {
            jVar.pC = new com.kwad.components.ad.i.a().ah(true);
        }
        jVar.pN = true;
        if (com.kwad.sdk.core.response.a.a.bu(adInfoBK)) {
            jVar.py = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        jVar.qg = 0L;
        if (this.mModel.bK() != null) {
            jVar.qg = com.kwad.sdk.core.response.a.a.bu(this.mModel.bK()) ? com.kwad.sdk.core.response.a.a.aj(this.mModel.bK()) : com.kwad.sdk.core.response.a.a.ae(this.mModel.bK());
        }
        jVar.a((com.kwad.components.ad.reward.g.c) this);
        jVar.mTimerHelper = getTimerHelper();
        return jVar;
    }

    @Override // com.kwad.components.core.j.b
    public Presenter onCreatePresenter() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null) {
            return null;
        }
        this.mRewardPresenter = new n(this, this.mRootContainer, cVar, (j) this.mCallerContext);
        this.mRewardPresenter.a(this);
        return this.mRewardPresenter;
    }

    @Override // com.kwad.components.core.j.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        c.fD().b(this.mRewardVerifyListener);
        super.onDestroy();
        notifyPageDismiss(false);
        T t2 = this.mCallerContext;
        if (t2 != 0) {
            ((j) t2).pw.b(this.mVideoPlayStateListener, this.mAdLivePlayStateListener);
            if (((j) this.mCallerContext).pw.jY()) {
                ((j) this.mCallerContext).pw.jZ().removeInterceptor(this);
                ((j) this.mCallerContext).pw.jZ().unRegisterAdLivePlayStateListener(this.mAdLivePlayStateListener);
            }
            a.I(getUniqueId());
        }
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            String strE = com.kwad.sdk.core.response.a.a.E(cVar.bK());
            if (!TextUtils.isEmpty(strE)) {
                com.kwad.sdk.core.videocache.b.a.bl(this.mContext.getApplicationContext()).cC(strE);
            }
        }
        com.kwad.components.core.r.d.qb().b(this);
        h.fQ().release();
        this.listenerKey = null;
    }

    @Override // com.kwad.components.core.r.d.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.core.j.b, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        T t2 = this.mCallerContext;
        if (t2 != 0) {
            ((j) t2).mPageEnterTime = -1L;
        }
    }

    @Override // com.kwad.components.ad.reward.g.c, com.kwad.components.core.webview.jshandler.d.a
    public void onPlayAgainClick(final boolean z2) {
        final AdTemplate adTemplate;
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || (adTemplate = cVar.getAdTemplate().mPlayAgain) == null) {
            return;
        }
        adTemplate.inPlayAgain = true;
        n nVar = this.mRewardPresenter;
        if (z2) {
            nVar.s(adTemplate);
        } else {
            nVar.ko();
            this.mRewardPresenter = null;
            this.mPresenter = null;
        }
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.9
            @Override // java.lang.Runnable
            public final void run() {
                if (!z2) {
                    ((j) KSRewardVideoActivityProxy.this.mCallerContext).releaseSync();
                }
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.9.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        KSRewardVideoActivityProxy.this.mModel.x(adTemplate);
                        a.G(KSRewardVideoActivityProxy.this.getUniqueId());
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        if (z2) {
                            return;
                        }
                        KSRewardVideoActivityProxy.this.initMVP();
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreDestroy() {
        super.onPreDestroy();
        com.kwad.components.core.webview.a.c.a.rE().rF();
    }

    @Override // com.kwad.components.core.j.b, com.kwad.components.core.l.d, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar != null) {
            AdTemplate adTemplate = cVar.getAdTemplate();
            com.kwad.sdk.core.c.a.wg();
            com.kwad.sdk.core.c.a.ao(adTemplate);
        }
        com.kwad.components.ad.reward.b.a.hi().Q(this.mContext);
    }

    @Override // com.kwad.components.ad.reward.n.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        T t2 = this.mCallerContext;
        ((j) t2).mRewardVerifyCalled = false;
        ((j) t2).pS = false;
    }
}
