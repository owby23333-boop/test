package com.funny.audio.view.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.net.MailTo;
import androidx.fragment.app.FragmentManager;
import androidx.media3.common.C;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.funny.audio.AppManager;
import com.funny.audio.R;
import com.funny.audio.UpdatePlayerEvent;
import com.funny.audio.ad.AdManager;
import com.funny.audio.ad.AdSetting;
import com.funny.audio.ad.loader.FeedAdLoader;
import com.funny.audio.ad.loader.FlowAdListener;
import com.funny.audio.ad.loader.FlowAdLoadListener;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.ActivityTrackPlayerBinding;
import com.funny.audio.media_player.MediaPlayerManager;
import com.funny.audio.media_player.TimePauseSetting;
import com.funny.audio.media_player.TimePauseType;
import com.funny.audio.models.AlbumDetailInfo;
import com.funny.audio.models.AlbumTrackInfo;
import com.funny.audio.view.ImageUtils;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.StatusBarUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUISlider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: TrackPlayerActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0010\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0011\u0010\u0019\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u0006\u0010\u001b\u001a\u00020\u0011J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020\u0011H\u0014J\b\u0010#\u001a\u00020\u0011H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/funny/audio/view/player/TrackPlayerActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityTrackPlayerBinding;", "()V", "albumTitle", "", "albumTrackTitle", "canUpdateSlide", "", "coverPath", "enterTime", "", "isCollect", "isLoadFeedAd", "isLoading", "isPlaying", "cancelCollect", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collect", "displayCollectFlag", "finish", "initData", "initStatusBar", "initView", "loadCollectFlag", "loadDataFromManager", "loadFeedAd", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onMessageEvent", "updatePlayerEvent", "Lcom/funny/audio/UpdatePlayerEvent;", "onResume", "releaseView", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrackPlayerActivity extends BaseActivity<ActivityTrackPlayerBinding> {
    private boolean isCollect;
    private boolean isLoadFeedAd;
    private boolean isPlaying;
    private String coverPath = "";
    private String albumTrackTitle = "";
    private String albumTitle = "";
    private boolean isLoading = true;
    private boolean canUpdateSlide = true;
    private long enterTime = System.currentTimeMillis();

    /* JADX INFO: renamed from: com.funny.audio.view.player.TrackPlayerActivity$cancelCollect$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrackPlayerActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.player.TrackPlayerActivity", f = "TrackPlayerActivity.kt", i = {}, l = {429}, m = "cancelCollect", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TrackPlayerActivity.this.cancelCollect(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.player.TrackPlayerActivity$collect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TrackPlayerActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.player.TrackPlayerActivity", f = "TrackPlayerActivity.kt", i = {}, l = {TTAdConstant.VIDEO_URL_CODE}, m = "collect", n = {}, s = {})
    static final class C06301 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06301(Continuation<? super C06301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TrackPlayerActivity.this.collect(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.player.TrackPlayerActivity$loadCollectFlag$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TrackPlayerActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.player.TrackPlayerActivity", f = "TrackPlayerActivity.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS}, m = "loadCollectFlag", n = {"this"}, s = {"L$0"})
    static final class C06331 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06331(Continuation<? super C06331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TrackPlayerActivity.this.loadCollectFlag(this);
        }
    }

    public static final /* synthetic */ ActivityTrackPlayerBinding access$getBd(TrackPlayerActivity trackPlayerActivity) {
        return trackPlayerActivity.getBd();
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        initStatusBar();
        getBd().slider.setCallback(new QMUISlider.Callback() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.1
            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onLongTouch(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onStartMoving(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchUp(QMUISlider slider, int progress, int tickCount) {
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onProgressChange(QMUISlider slider, int progress, int tickCount, boolean fromUser) {
                TrackPlayerActivity.access$getBd(TrackPlayerActivity.this).tvProgressTime.setText(TrackPlayerActivityKt.formatDuration((long) ((((double) progress) / ((double) tickCount)) * MediaPlayerManager.INSTANCE.getDuration())));
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onTouchDown(QMUISlider slider, int progress, int tickCount, boolean hitThumb) {
                if (hitThumb) {
                    TrackPlayerActivity.this.canUpdateSlide = false;
                }
            }

            @Override // com.qmuiteam.qmui.widget.QMUISlider.Callback
            public void onStopMoving(QMUISlider slider, int progress, int tickCount) {
                TrackPlayerActivity.this.canUpdateSlide = true;
                long duration = (long) ((((double) progress) / ((double) tickCount)) * MediaPlayerManager.INSTANCE.getDuration());
                TrackPlayerActivity.access$getBd(TrackPlayerActivity.this).tvProgressTime.setText(TrackPlayerActivityKt.formatDuration(duration));
                TrackPlayerActivity.access$getBd(TrackPlayerActivity.this).slider.setCurrentProgress(progress);
                MediaPlayerManager.INSTANCE.seekToMs(duration);
            }
        });
        ImageView imageView = getBd().ivPlay;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.ivPlay");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.2
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
                if (TrackPlayerActivity.this.isLoading) {
                    return;
                }
                MediaPlayerManager.INSTANCE.playPause();
            }
        }, 1, null);
        ImageView imageView2 = getBd().ivBackward;
        Intrinsics.checkNotNullExpressionValue(imageView2, "bd.ivBackward");
        ViewKt.click$default(imageView2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.3
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
                if (TrackPlayerActivity.this.isLoading) {
                    return;
                }
                MediaPlayerManager.INSTANCE.seekToMs(MediaPlayerManager.INSTANCE.getProgress() < C.DEFAULT_SEEK_FORWARD_INCREMENT_MS ? 0L : MediaPlayerManager.INSTANCE.getProgress() - C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
            }
        }, 1, null);
        ImageView imageView3 = getBd().ivForward;
        Intrinsics.checkNotNullExpressionValue(imageView3, "bd.ivForward");
        ViewKt.click$default(imageView3, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.4
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
                long progress;
                if (TrackPlayerActivity.this.isLoading) {
                    return;
                }
                if (MediaPlayerManager.INSTANCE.getProgress() + C.DEFAULT_SEEK_FORWARD_INCREMENT_MS > MediaPlayerManager.INSTANCE.getDuration()) {
                    progress = MediaPlayerManager.INSTANCE.getDuration();
                } else {
                    progress = MediaPlayerManager.INSTANCE.getProgress() + C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
                }
                MediaPlayerManager.INSTANCE.seekToMs(progress);
            }
        }, 1, null);
        ImageView imageView4 = getBd().ivSeekToPrevious;
        Intrinsics.checkNotNullExpressionValue(imageView4, "bd.ivSeekToPrevious");
        ViewKt.click$default(imageView4, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.5
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
                if (TrackPlayerActivity.this.isLoading) {
                    return;
                }
                MediaPlayerManager.INSTANCE.seekToPrevious();
            }
        }, 1, null);
        ImageView imageView5 = getBd().ivSeekToNext;
        Intrinsics.checkNotNullExpressionValue(imageView5, "bd.ivSeekToNext");
        ViewKt.click$default(imageView5, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.6
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
                if (TrackPlayerActivity.this.isLoading) {
                    return;
                }
                MediaPlayerManager.INSTANCE.seekToNext();
            }
        }, 1, null);
        LinearLayout linearLayout = getBd().lyTrackList;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "bd.lyTrackList");
        ViewKt.click$default(linearLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.7
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
                if (MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo() == null) {
                    return;
                }
                TrackListFragment trackListFragment = new TrackListFragment();
                AlbumDetailInfo currentAlbumDetailInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo();
                Intrinsics.checkNotNull(currentAlbumDetailInfo);
                trackListFragment.setAlbumDetailInfo(currentAlbumDetailInfo);
                trackListFragment.setTracks(MediaPlayerManager.INSTANCE.getCurrentAlbumTracks());
                trackListFragment.show(TrackPlayerActivity.this.getSupportFragmentManager(), "TrackPlayerTrackList");
            }
        }, 1, null);
        LinearLayout linearLayout2 = getBd().lyTiming;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "bd.lyTiming");
        ViewKt.click$default(linearLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.8
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
                if (MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo() == null) {
                    return;
                }
                new TrackTimingFragment().show(TrackPlayerActivity.this.getSupportFragmentManager(), "TrackPlayerTiming");
            }
        }, 1, null);
        LinearLayout linearLayout3 = getBd().lySkip;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "bd.lySkip");
        ViewKt.click$default(linearLayout3, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.9
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
                if (MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo() == null) {
                    return;
                }
                new TrackSkipFragment().show(TrackPlayerActivity.this.getSupportFragmentManager(), "TrackPlayerSkip");
            }
        }, 1, null);
        LinearLayout linearLayout4 = getBd().lySpeed;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "bd.lySpeed");
        ViewKt.click$default(linearLayout4, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.10
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
                if (MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo() == null) {
                    return;
                }
                new TrackSpeedFragment().show(TrackPlayerActivity.this.getSupportFragmentManager(), "TrackPlayerSpeed");
            }
        }, 1, null);
        LinearLayout linearLayout5 = getBd().lyBookshelf;
        Intrinsics.checkNotNullExpressionValue(linearLayout5, "bd.lyBookshelf");
        ViewKt.click$default(linearLayout5, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.11
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo();
            }
        }, 1, null);
        TextView textView = getBd().tvAlbumTitle;
        Intrinsics.checkNotNullExpressionValue(textView, "bd.tvAlbumTitle");
        ViewKt.click$default(textView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.12
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
                if (MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo() == null) {
                    return;
                }
                TrackPlayerActivity.this.finish();
                NavigationUtils navigationUtils = NavigationUtils.INSTANCE;
                Activity mainActivity = AppManager.INSTANCE.getMainActivity();
                AlbumDetailInfo currentAlbumDetailInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo();
                Intrinsics.checkNotNull(currentAlbumDetailInfo);
                navigationUtils.toAlbumDetail(mainActivity, currentAlbumDetailInfo.getId());
            }
        }, 1, null);
        ImageView imageView6 = getBd().ivAlbumDetail;
        Intrinsics.checkNotNullExpressionValue(imageView6, "bd.ivAlbumDetail");
        ViewKt.click$default(imageView6, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.13
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
                if (MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo() == null) {
                    return;
                }
                TrackPlayerActivity.this.finish();
                NavigationUtils navigationUtils = NavigationUtils.INSTANCE;
                Activity mainActivity = AppManager.INSTANCE.getMainActivity();
                AlbumDetailInfo currentAlbumDetailInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo();
                Intrinsics.checkNotNull(currentAlbumDetailInfo);
                navigationUtils.toAlbumDetail(mainActivity, currentAlbumDetailInfo.getId());
            }
        }, 1, null);
        ImageView imageView7 = getBd().ivTrackRetract;
        Intrinsics.checkNotNullExpressionValue(imageView7, "bd.ivTrackRetract");
        ViewKt.click$default(imageView7, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.14
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
                TrackPlayerActivity.this.finish();
            }
        }, 1, null);
        LinearLayout linearLayout6 = getBd().lyBookshelf;
        Intrinsics.checkNotNullExpressionValue(linearLayout6, "bd.lyBookshelf");
        ViewKt.click$default(linearLayout6, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.15
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.funny.audio.view.player.TrackPlayerActivity$initView$15$1, reason: invalid class name */
            /* JADX INFO: compiled from: TrackPlayerActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.player.TrackPlayerActivity$initView$15$1", f = "TrackPlayerActivity.kt", i = {}, l = {189, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ TrackPlayerActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(TrackPlayerActivity trackPlayerActivity, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = trackPlayerActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (this.this$0.isCollect) {
                            this.label = 1;
                            if (this.this$0.cancelCollect(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            this.label = 2;
                            if (this.this$0.collect(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1 && i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    this.this$0.displayCollectFlag();
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo() == null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(TrackPlayerActivity.this, null), 3, null);
            }
        }, 1, null);
        ImageView imageView8 = getBd().trackReport;
        Intrinsics.checkNotNullExpressionValue(imageView8, "bd.trackReport");
        ViewKt.click$default(imageView8, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackPlayerActivity.initView.16
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
                try {
                    String string = TrackPlayerActivity.this.getContext().getString(R.string.contact_email_text);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.contact_email_text)");
                    AlbumTrackInfo currentAlbumTrackInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumTrackInfo();
                    String string2 = TrackPlayerActivity.this.getContext().getString(R.string.app_name);
                    Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.app_name)");
                    Intent intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
                    intent.putExtra("android.intent.extra.EMAIL", new String[]{string});
                    intent.putExtra("android.intent.extra.SUBJECT", "反馈播放问题(" + string2 + ")");
                    AlbumDetailInfo currentAlbumDetailInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo();
                    String title = currentAlbumDetailInfo != null ? currentAlbumDetailInfo.getTitle() : null;
                    AlbumDetailInfo currentAlbumDetailInfo2 = MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo();
                    intent.putExtra("android.intent.extra.TEXT", "专辑名称是：" + title + "[id:" + (currentAlbumDetailInfo2 != null ? currentAlbumDetailInfo2.getId() : null) + "]\n\n当前播放失败章节是：" + (currentAlbumTrackInfo != null ? currentAlbumTrackInfo.getTitle() : null) + "[id:" + (currentAlbumTrackInfo != null ? currentAlbumTrackInfo.getId() : null) + "][sort:" + (currentAlbumTrackInfo != null ? Integer.valueOf(currentAlbumTrackInfo.getSort()) : null) + "]\n\n我们将会尽快处理该音频的播放问题。");
                    TrackPlayerActivity.this.getContext().startActivity(intent);
                } catch (Exception unused) {
                }
            }
        }, 1, null);
        EventBus.getDefault().register(this);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.player.TrackPlayerActivity$initData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TrackPlayerActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.player.TrackPlayerActivity$initData$1", f = "TrackPlayerActivity.kt", i = {}, l = {225}, m = "invokeSuspend", n = {}, s = {})
    static final class C06311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06311(Continuation<? super C06311> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TrackPlayerActivity.this.new C06311(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (TrackPlayerActivity.this.loadCollectFlag(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
        loadDataFromManager();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C06311(null), 3, null);
    }

    private final void initStatusBar() {
        TrackPlayerActivity trackPlayerActivity = this;
        StatusBarUtils.INSTANCE.translucent(trackPlayerActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(trackPlayerActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(trackPlayerActivity);
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void releaseView() {
        EventBus.getDefault().unregister(this);
        super.releaseView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(UpdatePlayerEvent updatePlayerEvent) {
        Intrinsics.checkNotNullParameter(updatePlayerEvent, "updatePlayerEvent");
        loadDataFromManager();
    }

    private final void loadDataFromManager() {
        AlbumTrackInfo currentAlbumTrackInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumTrackInfo();
        AlbumDetailInfo currentAlbumDetailInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo();
        if (currentAlbumTrackInfo == null || currentAlbumDetailInfo == null) {
            return;
        }
        try {
            if (!Intrinsics.areEqual(this.coverPath, currentAlbumDetailInfo.getCoverPath())) {
                this.coverPath = currentAlbumDetailInfo.getCoverPath();
                ImageUtils imageUtils = ImageUtils.INSTANCE;
                Context context = getContext();
                QMUIRadiusImageView qMUIRadiusImageView = getBd().ivCover;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "bd.ivCover");
                imageUtils.loadToView(context, qMUIRadiusImageView, this.coverPath);
            }
            if (!Intrinsics.areEqual(this.albumTrackTitle, currentAlbumTrackInfo.getTitle())) {
                this.albumTrackTitle = currentAlbumTrackInfo.getTitle();
                getBd().tvTrackTitle.setText(this.albumTrackTitle);
            }
            if (!Intrinsics.areEqual(this.albumTitle, currentAlbumDetailInfo.getTitle())) {
                this.albumTitle = currentAlbumDetailInfo.getTitle();
                getBd().tvAlbumTitle.setText(this.albumTitle);
            }
            if (this.isLoading != MediaPlayerManager.INSTANCE.isLoading()) {
                boolean zIsLoading = MediaPlayerManager.INSTANCE.isLoading();
                this.isLoading = zIsLoading;
                if (zIsLoading) {
                    getBd().lyLoading.setVisibility(0);
                } else {
                    getBd().lyLoading.setVisibility(8);
                }
            }
            if (this.isPlaying != MediaPlayerManager.INSTANCE.isPlaying()) {
                boolean zIsPlaying = MediaPlayerManager.INSTANCE.isPlaying();
                this.isPlaying = zIsPlaying;
                if (zIsPlaying) {
                    getBd().ivPlay.setImageResource(R.drawable.ic_player_pause);
                } else {
                    getBd().ivPlay.setImageResource(R.drawable.ic_player_play);
                }
            }
            long progress = MediaPlayerManager.INSTANCE.getProgress();
            long duration = MediaPlayerManager.INSTANCE.getDuration();
            long buffering = MediaPlayerManager.INSTANCE.getBuffering();
            getBd().tvTotalTime.setText(TrackPlayerActivityKt.formatDuration(duration));
            int i = duration > 0 ? (int) ((((long) 1000) * progress) / duration) : 0;
            if (duration > 0) {
                long j = (buffering * ((long) 1000)) / duration;
            }
            if (this.canUpdateSlide && !this.isLoading) {
                getBd().slider.setCurrentProgress(i);
                getBd().tvProgressTime.setText(TrackPlayerActivityKt.formatDuration(progress));
            }
            TimePauseSetting timePauseSetting = MediaPlayerManager.INSTANCE.getTimePauseSetting();
            if (timePauseSetting.getEnable()) {
                int type = timePauseSetting.getType();
                if (type == TimePauseType.INSTANCE.getEPISODES()) {
                    getBd().tvTiming.setText(timePauseSetting.getValue() + "集");
                    return;
                } else {
                    if (type == TimePauseType.INSTANCE.getMINUTES()) {
                        getBd().tvTiming.setText(TrackPlayerActivityKt.formatDuration(timePauseSetting.getValue()));
                        return;
                    }
                    return;
                }
            }
            getBd().tvTiming.setText("定时");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadCollectFlag(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.player.TrackPlayerActivity.C06331
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.player.TrackPlayerActivity$loadCollectFlag$1 r0 = (com.funny.audio.view.player.TrackPlayerActivity.C06331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.player.TrackPlayerActivity$loadCollectFlag$1 r0 = new com.funny.audio.view.player.TrackPlayerActivity$loadCollectFlag$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.player.TrackPlayerActivity r0 = (com.funny.audio.view.player.TrackPlayerActivity) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L77
            goto L6c
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            com.funny.audio.media_player.MediaPlayerManager r11 = com.funny.audio.media_player.MediaPlayerManager.INSTANCE     // Catch: java.lang.Exception -> L77
            com.funny.audio.models.AlbumDetailInfo r11 = r11.getCurrentAlbumDetailInfo()     // Catch: java.lang.Exception -> L77
            if (r11 == 0) goto L77
            java.lang.String r11 = r11.getId()     // Catch: java.lang.Exception -> L77
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L77
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2     // Catch: java.lang.Exception -> L77
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r2)     // Catch: java.lang.Exception -> L77
            r5 = 0
            r6 = 0
            com.funny.audio.view.player.TrackPlayerActivity$loadCollectFlag$2$bookshelfEntity$1 r2 = new com.funny.audio.view.player.TrackPlayerActivity$loadCollectFlag$2$bookshelfEntity$1     // Catch: java.lang.Exception -> L77
            r7 = 0
            r2.<init>(r11, r7)     // Catch: java.lang.Exception -> L77
            r7 = r2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L77
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L77
            r0.L$0 = r10     // Catch: java.lang.Exception -> L77
            r0.label = r3     // Catch: java.lang.Exception -> L77
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L77
            if (r11 != r1) goto L6b
            return r1
        L6b:
            r0 = r10
        L6c:
            com.funny.audio.database.entities.BookshelfEntity r11 = (com.funny.audio.database.entities.BookshelfEntity) r11     // Catch: java.lang.Exception -> L77
            if (r11 == 0) goto L71
            goto L72
        L71:
            r3 = 0
        L72:
            r0.isCollect = r3     // Catch: java.lang.Exception -> L77
            r0.displayCollectFlag()     // Catch: java.lang.Exception -> L77
        L77:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.player.TrackPlayerActivity.loadCollectFlag(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayCollectFlag() {
        if (this.isCollect) {
            getBd().ivBookShelf.setImageResource(R.drawable.ic_player_remove_bookshelf);
            getBd().tvBookshelf.setText("已加书架");
        } else {
            getBd().ivBookShelf.setImageResource(R.drawable.ic_player_add_bookshelf);
            getBd().tvBookshelf.setText("加入书架");
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.track_player_open, 0);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.track_player_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object collect(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.player.TrackPlayerActivity.C06301
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.player.TrackPlayerActivity$collect$1 r0 = (com.funny.audio.view.player.TrackPlayerActivity.C06301) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.player.TrackPlayerActivity$collect$1 r0 = new com.funny.audio.view.player.TrackPlayerActivity$collect$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L61
            goto L61
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L32:
            kotlin.ResultKt.throwOnFailure(r11)
            com.funny.audio.media_player.MediaPlayerManager r11 = com.funny.audio.media_player.MediaPlayerManager.INSTANCE     // Catch: java.lang.Exception -> L61
            com.funny.audio.models.AlbumDetailInfo r11 = r11.getCurrentAlbumDetailInfo()     // Catch: java.lang.Exception -> L61
            if (r11 == 0) goto L61
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L61
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2     // Catch: java.lang.Exception -> L61
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r2)     // Catch: java.lang.Exception -> L61
            r5 = 0
            r6 = 0
            com.funny.audio.view.player.TrackPlayerActivity$collect$2$1 r2 = new com.funny.audio.view.player.TrackPlayerActivity$collect$2$1     // Catch: java.lang.Exception -> L61
            r7 = 0
            r2.<init>(r11, r10, r7)     // Catch: java.lang.Exception -> L61
            r7 = r2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L61
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L61
            r0.label = r3     // Catch: java.lang.Exception -> L61
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L61
            if (r11 != r1) goto L61
            return r1
        L61:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.player.TrackPlayerActivity.collect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object cancelCollect(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.player.TrackPlayerActivity.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.player.TrackPlayerActivity$cancelCollect$1 r0 = (com.funny.audio.view.player.TrackPlayerActivity.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.player.TrackPlayerActivity$cancelCollect$1 r0 = new com.funny.audio.view.player.TrackPlayerActivity$cancelCollect$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L65
            goto L65
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L32:
            kotlin.ResultKt.throwOnFailure(r11)
            com.funny.audio.media_player.MediaPlayerManager r11 = com.funny.audio.media_player.MediaPlayerManager.INSTANCE     // Catch: java.lang.Exception -> L65
            com.funny.audio.models.AlbumDetailInfo r11 = r11.getCurrentAlbumDetailInfo()     // Catch: java.lang.Exception -> L65
            if (r11 == 0) goto L65
            java.lang.String r11 = r11.getId()     // Catch: java.lang.Exception -> L65
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L65
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2     // Catch: java.lang.Exception -> L65
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r2)     // Catch: java.lang.Exception -> L65
            r5 = 0
            r6 = 0
            com.funny.audio.view.player.TrackPlayerActivity$cancelCollect$2$1 r2 = new com.funny.audio.view.player.TrackPlayerActivity$cancelCollect$2$1     // Catch: java.lang.Exception -> L65
            r7 = 0
            r2.<init>(r11, r10, r7)     // Catch: java.lang.Exception -> L65
            r7 = r2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L65
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L65
            r0.label = r3     // Catch: java.lang.Exception -> L65
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L65
            if (r11 != r1) goto L65
            return r1
        L65:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.player.TrackPlayerActivity.cancelCollect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            AdSetting setting = AdManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting);
            if (AdManager.INSTANCE.getShow() && setting.getResumeSplashAd().getShow() && jCurrentTimeMillis - this.enterTime > setting.getResumeSplashAd().getShowInterval() && (!setting.getPureModeRewardAd().getShow() || setting.getPureTime().getValueLong() <= jCurrentTimeMillis)) {
                NavigationUtils.INSTANCE.toResumeSplashAd(this);
            }
            this.enterTime = jCurrentTimeMillis;
        } catch (Exception unused) {
        }
        try {
            AdSetting setting2 = AdManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting2);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (AdManager.INSTANCE.getShow() && setting2.getMediaPlayerRewardAd().getShow() && jCurrentTimeMillis2 > setting2.getRewardTime().getValueLong()) {
                TrackPlayerRewardAdDialog trackPlayerRewardAdDialog = new TrackPlayerRewardAdDialog();
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this.supportFragmentManager");
                trackPlayerRewardAdDialog.show(supportFragmentManager);
            }
        } catch (Exception unused2) {
        }
        try {
            loadFeedAd();
        } catch (Exception unused3) {
        }
    }

    public final void loadFeedAd() {
        final FeedAdLoader mediaPlayerFeedAdLoader;
        AdSetting setting = AdManager.INSTANCE.getSetting();
        Intrinsics.checkNotNull(setting);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (AdManager.INSTANCE.getShow() && setting.getMediaPlayerFeedAd().getShow()) {
            if ((!setting.getPureModeRewardAd().getShow() || setting.getPureTime().getValueLong() <= jCurrentTimeMillis) && (mediaPlayerFeedAdLoader = AdManager.INSTANCE.getMediaPlayerFeedAdLoader()) != null) {
                mediaPlayerFeedAdLoader.load(this, new FlowAdLoadListener() { // from class: com.funny.audio.view.player.TrackPlayerActivity$loadFeedAd$1$1
                    @Override // com.funny.audio.ad.loader.FlowAdLoadListener
                    public void onLoadFail(int code, String msg) {
                    }

                    @Override // com.funny.audio.ad.loader.FlowAdLoadListener
                    public void onRepeatedLoad() {
                    }

                    @Override // com.funny.audio.ad.loader.FlowAdLoadListener
                    public void onAdLoad() {
                        FeedAdLoader feedAdLoader = mediaPlayerFeedAdLoader;
                        TrackPlayerActivity trackPlayerActivity = this;
                        TrackPlayerActivity trackPlayerActivity2 = trackPlayerActivity;
                        FrameLayout frameLayout = TrackPlayerActivity.access$getBd(trackPlayerActivity).lyAdContainer;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "bd.lyAdContainer");
                        final TrackPlayerActivity trackPlayerActivity3 = this;
                        feedAdLoader.show(trackPlayerActivity2, frameLayout, new FlowAdListener() { // from class: com.funny.audio.view.player.TrackPlayerActivity$loadFeedAd$1$1$onAdLoad$1
                            @Override // com.funny.audio.ad.loader.FlowAdListener
                            public void onAdShow() {
                                TrackPlayerActivity.access$getBd(trackPlayerActivity3).ivCover.setVisibility(8);
                                TrackPlayerActivity.access$getBd(trackPlayerActivity3).lyAdContainer.setVisibility(0);
                            }

                            @Override // com.funny.audio.ad.loader.FlowAdListener
                            public void onAdClose() {
                                TrackPlayerActivity.access$getBd(trackPlayerActivity3).ivCover.setVisibility(0);
                                TrackPlayerActivity.access$getBd(trackPlayerActivity3).lyAdContainer.setVisibility(8);
                            }
                        });
                    }
                });
            }
        }
    }
}
