package com.funny.audio.view.player;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.media3.session.MediaController;
import com.funny.audio.RewardAdType;
import com.funny.audio.RewardAdVerifyEvent;
import com.funny.audio.ad.AdManager;
import com.funny.audio.ad.AdSetting;
import com.funny.audio.ad.loader.RewardVideoAdListener;
import com.funny.audio.ad.loader.RewardVideoAdLoadListener;
import com.funny.audio.ad.loader.RewardVideoAdLoader;
import com.funny.audio.core.ext.LongKt;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.database.entities.AdSettingEntity;
import com.funny.audio.databinding.FragmentTrackPlayerRewardAdDialogBinding;
import com.funny.audio.settings.AppSettingEntityKt;
import com.funny.audio.view.DialogUtils;
import com.funny.audio.view.core.BaseDialogFragment;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: TrackPlayerRewardAdDialog.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\u000e\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0014H\u0002J\b\u0010\"\u001a\u00020\u0014H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/funny/audio/view/player/TrackPlayerRewardAdDialog;", "Lcom/funny/audio/view/core/BaseDialogFragment;", "Lcom/funny/audio/databinding/FragmentTrackPlayerRewardAdDialogBinding;", "()V", "dialogwidthPixels", "", "getDialogwidthPixels", "()I", "setDialogwidthPixels", "(I)V", "isLoading", "", "loadTimeout", "", "loadTimeoutJobRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "showTimeout", "showTimeoutJobRef", "disableCancel", "", "initData", "initView", "view", "Landroid/view/View;", "onDestroy", "onMessageEvent", "rewardAdVerifyEvent", "Lcom/funny/audio/RewardAdVerifyEvent;", "onStart", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "startWaitLoadTimeoutJob", "startWaitShowTimeoutJob", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrackPlayerRewardAdDialog extends BaseDialogFragment<FragmentTrackPlayerRewardAdDialogBinding> {
    private int dialogwidthPixels;
    private boolean isLoading;
    private final long loadTimeout = MediaController.RELEASE_UNBIND_TIMEOUT_MS;
    private final AtomicReference<Job> loadTimeoutJobRef = new AtomicReference<>(null);
    private final long showTimeout = 20000;
    private final AtomicReference<Job> showTimeoutJobRef = new AtomicReference<>(null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean disableCancel$lambda$0(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    public static final /* synthetic */ FragmentTrackPlayerRewardAdDialogBinding access$getBd(TrackPlayerRewardAdDialog trackPlayerRewardAdDialog) {
        return trackPlayerRewardAdDialog.getBd();
    }

    public final int getDialogwidthPixels() {
        return this.dialogwidthPixels;
    }

    public final void setDialogwidthPixels(int i) {
        this.dialogwidthPixels = i;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.dialogwidthPixels = (int) (((double) displayMetrics.widthPixels) * 0.85d);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(this.dialogwidthPixels, -2);
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
        }
    }

    public final void disableCancel() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.funny.audio.view.player.TrackPlayerRewardAdDialog$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return TrackPlayerRewardAdDialog.disableCancel$lambda$0(dialogInterface, i, keyEvent);
                }
            });
        }
    }

    @Override // com.funny.audio.view.core.BaseDialogFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        QMUIFrameLayout qMUIFrameLayout = getBd().btnInactive;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnInactive");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerRewardAdDialog.initView.1
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
                if (TrackPlayerRewardAdDialog.this.isLoading) {
                    return;
                }
                TrackPlayerRewardAdDialog.this.dismissAllowingStateLoss();
                FragmentActivity activity = TrackPlayerRewardAdDialog.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout2 = getBd().btnPositive;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout2, "bd.btnPositive");
        ViewKt.click$default(qMUIFrameLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerRewardAdDialog.initView.2
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
                if (AdManager.INSTANCE.getMediaPlayerRewardVideoAdLoader() != null) {
                    if (TrackPlayerRewardAdDialog.this.isLoading) {
                        return;
                    }
                    TrackPlayerRewardAdDialog.this.isLoading = true;
                    TrackPlayerRewardAdDialog.access$getBd(TrackPlayerRewardAdDialog.this).loading.setVisibility(0);
                    RewardVideoAdLoader mediaPlayerRewardVideoAdLoader = AdManager.INSTANCE.getMediaPlayerRewardVideoAdLoader();
                    Intrinsics.checkNotNull(mediaPlayerRewardVideoAdLoader);
                    FragmentActivity fragmentActivityRequireActivity = TrackPlayerRewardAdDialog.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                    final TrackPlayerRewardAdDialog trackPlayerRewardAdDialog = TrackPlayerRewardAdDialog.this;
                    mediaPlayerRewardVideoAdLoader.load(fragmentActivityRequireActivity, new RewardVideoAdLoadListener() { // from class: com.funny.audio.view.player.TrackPlayerRewardAdDialog.initView.2.1
                        @Override // com.funny.audio.ad.loader.RewardVideoAdLoadListener
                        public void onRewardRepeatedLoad() {
                        }

                        @Override // com.funny.audio.ad.loader.RewardVideoAdLoadListener
                        public void onRewardVideoCached() {
                        }

                        @Override // com.funny.audio.ad.loader.RewardVideoAdLoadListener
                        public void onRewardVideoAdLoad() {
                            trackPlayerRewardAdDialog.isLoading = false;
                            TrackPlayerRewardAdDialog.access$getBd(trackPlayerRewardAdDialog).loading.setVisibility(8);
                            Job job = (Job) trackPlayerRewardAdDialog.loadTimeoutJobRef.get();
                            if (job != null) {
                                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                            }
                            RewardVideoAdLoader mediaPlayerRewardVideoAdLoader2 = AdManager.INSTANCE.getMediaPlayerRewardVideoAdLoader();
                            Intrinsics.checkNotNull(mediaPlayerRewardVideoAdLoader2);
                            FragmentActivity fragmentActivityRequireActivity2 = trackPlayerRewardAdDialog.requireActivity();
                            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "this@TrackPlayerRewardAdDialog.requireActivity()");
                            final TrackPlayerRewardAdDialog trackPlayerRewardAdDialog2 = trackPlayerRewardAdDialog;
                            mediaPlayerRewardVideoAdLoader2.show(fragmentActivityRequireActivity2, new RewardVideoAdListener() { // from class: com.funny.audio.view.player.TrackPlayerRewardAdDialog$initView$2$1$onRewardVideoAdLoad$1
                                @Override // com.funny.audio.ad.loader.RewardVideoAdListener
                                public void onAdClose() {
                                }

                                @Override // com.funny.audio.ad.loader.RewardVideoAdListener
                                public void onAdSkip() {
                                }

                                @Override // com.funny.audio.ad.loader.RewardVideoAdListener
                                public void onAdShow() {
                                    Job job2 = (Job) trackPlayerRewardAdDialog2.showTimeoutJobRef.get();
                                    if (job2 != null) {
                                        Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                                    }
                                }

                                @Override // com.funny.audio.ad.loader.RewardVideoAdListener
                                public void onRewardVerify() {
                                    RewardAdVerifyEvent rewardAdVerifyEvent = new RewardAdVerifyEvent();
                                    rewardAdVerifyEvent.setType(RewardAdType.INSTANCE.getMEDIA_PLAYER());
                                    rewardAdVerifyEvent.setSuccess(true);
                                    EventBus.getDefault().post(rewardAdVerifyEvent);
                                }
                            });
                            trackPlayerRewardAdDialog.startWaitShowTimeoutJob();
                        }

                        @Override // com.funny.audio.ad.loader.RewardVideoAdLoadListener
                        public void onRewardVideoLoadFail(int code, String message) {
                            trackPlayerRewardAdDialog.isLoading = false;
                            TrackPlayerRewardAdDialog.access$getBd(trackPlayerRewardAdDialog).loading.setVisibility(8);
                            DialogUtils.INSTANCE.tip("激励视频加载失败，请重启app试试~");
                            Job job = (Job) trackPlayerRewardAdDialog.loadTimeoutJobRef.get();
                            if (job != null) {
                                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                            }
                            trackPlayerRewardAdDialog.dismissAllowingStateLoss();
                            FragmentActivity activity = trackPlayerRewardAdDialog.getActivity();
                            if (activity != null) {
                                activity.finish();
                            }
                        }
                    });
                    TrackPlayerRewardAdDialog.this.startWaitLoadTimeoutJob();
                    return;
                }
                DialogUtils.INSTANCE.tip("激励视频加载失败！");
                TrackPlayerRewardAdDialog.this.dismissAllowingStateLoss();
                FragmentActivity activity = TrackPlayerRewardAdDialog.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }, 1, null);
        disableCancel();
        EventBus.getDefault().register(this);
    }

    @Override // com.funny.audio.view.core.BaseDialogFragment
    public void initData() {
        super.initData();
        AdSetting setting = AdManager.INSTANCE.getSetting();
        Intrinsics.checkNotNull(setting);
        AdSettingEntity mediaPlayerRewardAd = setting.getMediaPlayerRewardAd();
        if (mediaPlayerRewardAd.getDescription().length() > 0) {
            getBd().tvContent.setText(mediaPlayerRewardAd.getDescription());
            getBd().tvContent.setVisibility(0);
        } else {
            getBd().tvContent.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x0014, B:12:0x003e, B:11:0x001e), top: B:18:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void startWaitLoadTimeoutJob() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = r7.loadTimeoutJobRef     // Catch: java.lang.Throwable -> L42
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L1e
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = r7.loadTimeoutJobRef     // Catch: java.lang.Throwable -> L42
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
            com.funny.audio.view.player.TrackPlayerRewardAdDialog$startWaitLoadTimeoutJob$1$newJob$1 r0 = new com.funny.audio.view.player.TrackPlayerRewardAdDialog$startWaitLoadTimeoutJob$1$newJob$1     // Catch: java.lang.Throwable -> L42
            r4 = 0
            r0.<init>(r7, r4)     // Catch: java.lang.Throwable -> L42
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L42
            r5 = 3
            r6 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L42
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r1 = r7.loadTimeoutJobRef     // Catch: java.lang.Throwable -> L42
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
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.player.TrackPlayerRewardAdDialog.startWaitLoadTimeoutJob():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x0014, B:12:0x003e, B:11:0x001e), top: B:18:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void startWaitShowTimeoutJob() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = r7.showTimeoutJobRef     // Catch: java.lang.Throwable -> L42
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L1e
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = r7.showTimeoutJobRef     // Catch: java.lang.Throwable -> L42
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
            com.funny.audio.view.player.TrackPlayerRewardAdDialog$startWaitShowTimeoutJob$1$newJob$1 r0 = new com.funny.audio.view.player.TrackPlayerRewardAdDialog$startWaitShowTimeoutJob$1$newJob$1     // Catch: java.lang.Throwable -> L42
            r4 = 0
            r0.<init>(r7, r4)     // Catch: java.lang.Throwable -> L42
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L42
            r5 = 3
            r6 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L42
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r1 = r7.showTimeoutJobRef     // Catch: java.lang.Throwable -> L42
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
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.player.TrackPlayerRewardAdDialog.startWaitShowTimeoutJob():void");
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        show(manager, "TrackPlayerRewardAd");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(RewardAdVerifyEvent rewardAdVerifyEvent) {
        Intrinsics.checkNotNullParameter(rewardAdVerifyEvent, "rewardAdVerifyEvent");
        if (Intrinsics.areEqual(rewardAdVerifyEvent.getType(), RewardAdType.INSTANCE.getMEDIA_PLAYER())) {
            DialogUtils.INSTANCE.tip("可以愉快地听书啦~");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C06341(null), 3, null);
            dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.player.TrackPlayerRewardAdDialog$onMessageEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TrackPlayerRewardAdDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.player.TrackPlayerRewardAdDialog$onMessageEvent$1", f = "TrackPlayerRewardAdDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06341(Continuation<? super C06341> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06341(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AdSetting setting = AdManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting);
            AdSettingEntity mediaPlayerRewardAd = setting.getMediaPlayerRewardAd();
            long jMin = Math.min(LongKt.getEndOfDayTimestamp(), System.currentTimeMillis() + mediaPlayerRewardAd.getRewardDuration());
            AdSetting setting2 = AdManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting2);
            AppSettingEntityKt.save(setting2.getRewardTime(), Boxing.boxLong(jMin));
            return Unit.INSTANCE;
        }
    }

    @Override // com.funny.audio.view.core.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
