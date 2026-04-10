package com.funny.audio.ad.view;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.funny.audio.ad.AdManager;
import com.funny.audio.ad.AdSetting;
import com.funny.audio.ad.UIUtils;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.ActivityResumeSplashBinding;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.StatusBarUtils;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.umeng.analytics.pro.an;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ResumeSplashActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010#\u001a\u00020$H\u0016J\u0006\u0010%\u001a\u00020$J\b\u0010&\u001a\u00020$H\u0017J\u0010\u0010'\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010\u0015J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/funny/audio/ad/view/ResumeSplashActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityResumeSplashBinding;", "()V", "AD_TIME_OUT", "", "adNativeLoader", "Lcom/bytedance/sdk/openadsdk/TTAdNative;", "getAdNativeLoader", "()Lcom/bytedance/sdk/openadsdk/TTAdNative;", "setAdNativeLoader", "(Lcom/bytedance/sdk/openadsdk/TTAdNative;)V", "codeId", "", "getCodeId", "()Ljava/lang/String;", "setCodeId", "(Ljava/lang/String;)V", "flag", "", "splashAd", "Lcom/bytedance/sdk/openadsdk/CSJSplashAd;", "getSplashAd", "()Lcom/bytedance/sdk/openadsdk/CSJSplashAd;", "setSplashAd", "(Lcom/bytedance/sdk/openadsdk/CSJSplashAd;)V", "tagName", "getTagName", "setTagName", "timeoutJobRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "totalTimeout", "", "waitAdInitJobRef", "initView", "", "loadSplashAd", "onBackPressed", "showSplashAd", an.aw, "startTimeoutJob", "startWaitAdInitJob", "toPage", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResumeSplashActivity extends BaseActivity<ActivityResumeSplashBinding> {
    private TTAdNative adNativeLoader;
    private CSJSplashAd splashAd;
    private String codeId = "";
    private final int AD_TIME_OUT = 6000;
    private final long totalTimeout = 20000;
    private final AtomicReference<Job> timeoutJobRef = new AtomicReference<>(null);
    private final AtomicReference<Job> waitAdInitJobRef = new AtomicReference<>(null);
    private String tagName = "ResumeSplashActivity";
    private boolean flag = true;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    public final String getCodeId() {
        return this.codeId;
    }

    public final void setCodeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.codeId = str;
    }

    public final TTAdNative getAdNativeLoader() {
        return this.adNativeLoader;
    }

    public final void setAdNativeLoader(TTAdNative tTAdNative) {
        this.adNativeLoader = tTAdNative;
    }

    public final CSJSplashAd getSplashAd() {
        return this.splashAd;
    }

    public final void setSplashAd(CSJSplashAd cSJSplashAd) {
        this.splashAd = cSJSplashAd;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final void setTagName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagName = str;
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        StatusBarUtils.INSTANCE.fullscreenToolbar(this);
        AdSetting setting = AdManager.INSTANCE.getSetting();
        Intrinsics.checkNotNull(setting);
        this.codeId = setting.getResumeSplashAd().getCodeId();
        this.adNativeLoader = TTAdSdk.getAdManager().createAdNative(this);
        QMUIFrameLayout qMUIFrameLayout = getBd().btnOverTime;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnOverTime");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.ad.view.ResumeSplashActivity.initView.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ResumeSplashActivity.this.toPage();
            }
        }, 1, null);
        startTimeoutJob();
        startWaitAdInitJob();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x0014, B:12:0x003e, B:11:0x001e), top: B:18:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void startTimeoutJob() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = r7.timeoutJobRef     // Catch: java.lang.Throwable -> L42
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L1e
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = r7.timeoutJobRef     // Catch: java.lang.Throwable -> L42
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L42
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0     // Catch: java.lang.Throwable -> L42
            r1 = 0
            if (r0 == 0) goto L1c
            boolean r0 = r0.isCompleted()     // Catch: java.lang.Throwable -> L42
            r2 = 1
            if (r0 != r2) goto L1c
            r1 = r2
        L1c:
            if (r1 == 0) goto L3e
        L1e:
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L42
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch: java.lang.Throwable -> L42
            kotlinx.coroutines.CoroutineScope r1 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r0)     // Catch: java.lang.Throwable -> L42
            r2 = 0
            r3 = 0
            com.funny.audio.ad.view.ResumeSplashActivity$startTimeoutJob$1$newJob$1 r0 = new com.funny.audio.ad.view.ResumeSplashActivity$startTimeoutJob$1$newJob$1     // Catch: java.lang.Throwable -> L42
            r4 = 0
            r0.<init>(r7, r4)     // Catch: java.lang.Throwable -> L42
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L42
            r5 = 3
            r6 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L42
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r1 = r7.timeoutJobRef     // Catch: java.lang.Throwable -> L42
            r1.set(r0)     // Catch: java.lang.Throwable -> L42
        L3e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L42
            monitor-exit(r7)
            return
        L42:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.ad.view.ResumeSplashActivity.startTimeoutJob():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x0014, B:12:0x003e, B:11:0x001e), top: B:18:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void startWaitAdInitJob() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = r7.waitAdInitJobRef     // Catch: java.lang.Throwable -> L42
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L1e
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = r7.waitAdInitJobRef     // Catch: java.lang.Throwable -> L42
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L42
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0     // Catch: java.lang.Throwable -> L42
            r1 = 0
            if (r0 == 0) goto L1c
            boolean r0 = r0.isCompleted()     // Catch: java.lang.Throwable -> L42
            r2 = 1
            if (r0 != r2) goto L1c
            r1 = r2
        L1c:
            if (r1 == 0) goto L3e
        L1e:
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L42
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch: java.lang.Throwable -> L42
            kotlinx.coroutines.CoroutineScope r1 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r0)     // Catch: java.lang.Throwable -> L42
            r2 = 0
            r3 = 0
            com.funny.audio.ad.view.ResumeSplashActivity$startWaitAdInitJob$1$newJob$1 r0 = new com.funny.audio.ad.view.ResumeSplashActivity$startWaitAdInitJob$1$newJob$1     // Catch: java.lang.Throwable -> L42
            r4 = 0
            r0.<init>(r7, r4)     // Catch: java.lang.Throwable -> L42
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L42
            r5 = 3
            r6 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L42
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r1 = r7.waitAdInitJobRef     // Catch: java.lang.Throwable -> L42
            r1.set(r0)     // Catch: java.lang.Throwable -> L42
        L3e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L42
            monitor-exit(r7)
            return
        L42:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.ad.view.ResumeSplashActivity.startWaitAdInitJob():void");
    }

    public final void loadSplashAd() {
        ResumeSplashActivity resumeSplashActivity = this;
        int screenWidthInPx = UIUtils.getScreenWidthInPx(resumeSplashActivity);
        int screenHeightInPx = UIUtils.getScreenHeightInPx(resumeSplashActivity);
        int statusBarHeight = StatusBarUtils.INSTANCE.getStatusBarHeight(this);
        UIUtils.getScreenWidthDp(resumeSplashActivity);
        UIUtils.px2dip(resumeSplashActivity, screenHeightInPx * 1.0f);
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(this.codeId).setImageAcceptedSize(screenWidthInPx, screenHeightInPx + statusBarHeight).build();
        TTAdNative tTAdNative = this.adNativeLoader;
        if (tTAdNative != null) {
            tTAdNative.loadSplashAd(adSlotBuild, new TTAdNative.CSJSplashAdListener() { // from class: com.funny.audio.ad.view.ResumeSplashActivity.loadSplashAd.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashLoadSuccess(CSJSplashAd ad) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashLoadFail(CSJAdError error) {
                    Log.e(ResumeSplashActivity.this.getTagName(), "开屏广告加载失败：" + (error != null ? Integer.valueOf(error.getCode()) : null) + " | " + (error != null ? error.getMsg() : null));
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashRenderSuccess(CSJSplashAd ad) {
                    ResumeSplashActivity.this.setSplashAd(ad);
                    ResumeSplashActivity.this.showSplashAd(ad);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
                public void onSplashRenderFail(CSJSplashAd ad, CSJAdError error) {
                    Log.e(ResumeSplashActivity.this.getTagName(), "开屏广告渲染失败：" + (error != null ? Integer.valueOf(error.getCode()) : null) + " | " + (error != null ? error.getMsg() : null));
                    ResumeSplashActivity.this.toPage();
                }
            }, this.AD_TIME_OUT);
        }
    }

    public final void showSplashAd(CSJSplashAd ad) {
        if (ad == null) {
            toPage();
            return;
        }
        ad.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.funny.audio.ad.view.ResumeSplashActivity.showSplashAd.1
            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClick(CSJSplashAd ad2) {
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdShow(CSJSplashAd ad2) {
            }

            @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
            public void onSplashAdClose(CSJSplashAd ad2, int code) {
                ResumeSplashActivity.this.toPage();
            }
        });
        FrameLayout frameLayout = getBd().lyAdContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "bd.lyAdContainer");
        View splashView = ad.getSplashView();
        UIUtils.removeFromParent(splashView);
        frameLayout.removeAllViews();
        frameLayout.addView(splashView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toPage() {
        if (this.flag) {
            this.flag = false;
            Job job = this.timeoutJobRef.get();
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            finish();
        }
    }
}
