package com.funny.audio.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.fragment.app.FragmentManager;
import com.angcyo.tablayout.DslTabLayout;
import com.angcyo.tablayout.DslTabLayoutConfig;
import com.angcyo.tablayout.delegate.ViewPager1Delegate;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.funny.audio.AppManager;
import com.funny.audio.PlayAlbumTrackEvent;
import com.funny.audio.PlayAlbumTrackType;
import com.funny.audio.R;
import com.funny.audio.UpdatePlayerEvent;
import com.funny.audio.ad.AdManager;
import com.funny.audio.api.ApiManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.core.net.AppBody;
import com.funny.audio.core.net.NetModelsKt;
import com.funny.audio.core.net.Response;
import com.funny.audio.databinding.ActivityMainBinding;
import com.funny.audio.media_player.MediaPlayerManager;
import com.funny.audio.media_player.service.MediaService;
import com.funny.audio.models.AlbumDetailInfo;
import com.funny.audio.models.AlbumTrackInfo;
import com.funny.audio.models.AlertNoticeInfo;
import com.funny.audio.view.bookshelf.BookshelfFragment;
import com.funny.audio.view.category.CategoryFragment;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.StatusBarUtils;
import com.funny.audio.view.homepage.HomepageFragment;
import com.funny.audio.view.mine.MineFragment;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.qmuiteam.qmui.widget.QMUIViewPager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0010\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0016J#\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010 \u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/funny/audio/view/MainActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityMainBinding;", "()V", "coverAnimator", "Landroid/animation/ObjectAnimator;", "coverPath", "", "exitFlag", "", "isPlaying", "tagName", "checkAlertNotice", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkUpdate", "clearExitFlag", "initData", "initTab", "initView", "jumpToPlayer", "albumId", "trackIndex", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDataFromManager", "onBackPressed", "onMessageEvent", "playAlbumTrackEvent", "Lcom/funny/audio/PlayAlbumTrackEvent;", "updatePlayerEvent", "Lcom/funny/audio/UpdatePlayerEvent;", "releaseView", "showAlertNoticeDialog", "alertNoticeInfo", "Lcom/funny/audio/models/AlertNoticeInfo;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MainActivity extends BaseActivity<ActivityMainBinding> {
    private ObjectAnimator coverAnimator;
    private boolean exitFlag;
    private boolean isPlaying;
    private String coverPath = "";
    private String tagName = "MainActivity";

    /* JADX INFO: renamed from: com.funny.audio.view.MainActivity$checkAlertNotice$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.MainActivity", f = "MainActivity.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS}, m = "checkAlertNotice", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainActivity.this.checkAlertNotice(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.MainActivity$checkUpdate$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.MainActivity", f = "MainActivity.kt", i = {0}, l = {316}, m = "checkUpdate", n = {"this"}, s = {"L$0"})
    static final class C05661 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05661(Continuation<? super C05661> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainActivity.this.checkUpdate(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.MainActivity$clearExitFlag$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.MainActivity", f = "MainActivity.kt", i = {0}, l = {309}, m = "clearExitFlag", n = {"this"}, s = {"L$0"})
    static final class C05671 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05671(Continuation<? super C05671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainActivity.this.clearExitFlag(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.MainActivity$jumpToPlayer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.MainActivity", f = "MainActivity.kt", i = {0}, l = {236}, m = "jumpToPlayer", n = {"this"}, s = {"L$0"})
    static final class C05711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05711(Continuation<? super C05711> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MainActivity.this.jumpToPlayer(null, 0, this);
        }
    }

    public static final /* synthetic */ ActivityMainBinding access$getBd(MainActivity mainActivity) {
        return mainActivity.getBd();
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        MainActivity mainActivity = this;
        StatusBarUtils.INSTANCE.translucent(mainActivity);
        AppManager.INSTANCE.setMainActivity(mainActivity);
        initTab();
        FrameLayout frameLayout = getBd().lyFloatPlayer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "bd.lyFloatPlayer");
        ViewKt.click$default(frameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.MainActivity.initView.1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo() == null || MediaPlayerManager.INSTANCE.getCurrentAlbumTrackInfo() == null) {
                    return;
                }
                MediaPlayerManager mediaPlayerManager = MediaPlayerManager.INSTANCE;
                AlbumDetailInfo currentAlbumDetailInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo();
                Intrinsics.checkNotNull(currentAlbumDetailInfo);
                List<AlbumTrackInfo> currentAlbumTracks = MediaPlayerManager.INSTANCE.getCurrentAlbumTracks();
                AlbumTrackInfo currentAlbumTrackInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumTrackInfo();
                Intrinsics.checkNotNull(currentAlbumTrackInfo);
                mediaPlayerManager.playAlbumTrack(currentAlbumDetailInfo, currentAlbumTracks, currentAlbumTrackInfo.getSort(), (24 & 8) != 0 ? 0L : 0L, (24 & 16) != 0 ? false : false, (24 & 32) != 0 ? true : true);
            }
        }, 1, null);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(getBd().ivFloatPlayerCover, Key.ROTATION, 0.0f, 360.0f);
        objectAnimatorOfFloat.setDuration(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.coverAnimator = objectAnimatorOfFloat;
        EventBus.getDefault().register(this);
        if (AdManager.INSTANCE.getShow() && AdManager.INSTANCE.getInitSuccess()) {
            try {
                AdManager.INSTANCE.requestPermissionIfNecessary(this);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void releaseView() {
        EventBus.getDefault().unregister(this);
        super.releaseView();
    }

    /* JADX INFO: renamed from: com.funny.audio.view.MainActivity$initData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.MainActivity$initData$1", f = "MainActivity.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    static final class C05681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05681(Continuation<? super C05681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C05681(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (MainActivity.this.checkUpdate(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
        loadDataFromManager();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05681(null), 3, null);
    }

    private final void initTab() {
        DslTabLayout dslTabLayout = getBd().tabSegment;
        Intrinsics.checkNotNullExpressionValue(dslTabLayout, "bd.tabSegment");
        getBd().ivNavHomepage.setImageResource(R.drawable.ic_nav_homepage_selected);
        getBd().tvNavHomepage.setTextColor(getResources().getColor(R.color.primary_color));
        dslTabLayout.configTabLayoutConfig(new Function1<DslTabLayoutConfig, Unit>() { // from class: com.funny.audio.view.MainActivity.initTab.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DslTabLayoutConfig dslTabLayoutConfig) {
                invoke2(dslTabLayoutConfig);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DslTabLayoutConfig configTabLayoutConfig) {
                Intrinsics.checkNotNullParameter(configTabLayoutConfig, "$this$configTabLayoutConfig");
                final MainActivity mainActivity = MainActivity.this;
                configTabLayoutConfig.setOnSelectItemView(new Function4<View, Integer, Boolean, Boolean, Boolean>() { // from class: com.funny.audio.view.MainActivity.initTab.1.1
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num, Boolean bool, Boolean bool2) {
                        return invoke(view, num.intValue(), bool.booleanValue(), bool2.booleanValue());
                    }

                    public final Boolean invoke(View itemView, int i, boolean z, boolean z2) {
                        Intrinsics.checkNotNullParameter(itemView, "itemView");
                        if (z) {
                            if (i == 0) {
                                MainActivity.access$getBd(mainActivity).ivNavHomepage.setImageResource(R.drawable.ic_nav_homepage_selected);
                                MainActivity.access$getBd(mainActivity).ivNavBookshelf.setImageResource(R.drawable.ic_nav_bookshelf_normal);
                                MainActivity.access$getBd(mainActivity).ivNavSquare.setImageResource(R.drawable.ic_nav_square_normal);
                                MainActivity.access$getBd(mainActivity).ivNavMine.setImageResource(R.drawable.ic_nav_mine_normal);
                                MainActivity.access$getBd(mainActivity).tvNavHomepage.setTextColor(mainActivity.getResources().getColor(R.color.primary_color));
                                MainActivity.access$getBd(mainActivity).tvNavBookshelf.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                                MainActivity.access$getBd(mainActivity).tvNavSquare.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                                MainActivity.access$getBd(mainActivity).tvNavMine.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                            } else if (i == 1) {
                                MainActivity.access$getBd(mainActivity).ivNavHomepage.setImageResource(R.drawable.ic_nav_homepage_normal);
                                MainActivity.access$getBd(mainActivity).ivNavBookshelf.setImageResource(R.drawable.ic_nav_bookshelf_selected);
                                MainActivity.access$getBd(mainActivity).ivNavSquare.setImageResource(R.drawable.ic_nav_square_normal);
                                MainActivity.access$getBd(mainActivity).ivNavMine.setImageResource(R.drawable.ic_nav_mine_normal);
                                MainActivity.access$getBd(mainActivity).tvNavHomepage.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                                MainActivity.access$getBd(mainActivity).tvNavBookshelf.setTextColor(mainActivity.getResources().getColor(R.color.primary_color));
                                MainActivity.access$getBd(mainActivity).tvNavSquare.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                                MainActivity.access$getBd(mainActivity).tvNavMine.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                            } else if (i == 2) {
                                MainActivity.access$getBd(mainActivity).ivNavHomepage.setImageResource(R.drawable.ic_nav_homepage_normal);
                                MainActivity.access$getBd(mainActivity).ivNavBookshelf.setImageResource(R.drawable.ic_nav_bookshelf_normal);
                                MainActivity.access$getBd(mainActivity).ivNavSquare.setImageResource(R.drawable.ic_nav_square_selected);
                                MainActivity.access$getBd(mainActivity).ivNavMine.setImageResource(R.drawable.ic_nav_mine_normal);
                                MainActivity.access$getBd(mainActivity).tvNavHomepage.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                                MainActivity.access$getBd(mainActivity).tvNavBookshelf.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                                MainActivity.access$getBd(mainActivity).tvNavSquare.setTextColor(mainActivity.getResources().getColor(R.color.primary_color));
                                MainActivity.access$getBd(mainActivity).tvNavMine.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                            } else if (i == 3) {
                                MainActivity.access$getBd(mainActivity).ivNavHomepage.setImageResource(R.drawable.ic_nav_homepage_normal);
                                MainActivity.access$getBd(mainActivity).ivNavBookshelf.setImageResource(R.drawable.ic_nav_bookshelf_normal);
                                MainActivity.access$getBd(mainActivity).ivNavSquare.setImageResource(R.drawable.ic_nav_square_normal);
                                MainActivity.access$getBd(mainActivity).ivNavMine.setImageResource(R.drawable.ic_nav_mine_selected);
                                MainActivity.access$getBd(mainActivity).tvNavHomepage.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                                MainActivity.access$getBd(mainActivity).tvNavBookshelf.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                                MainActivity.access$getBd(mainActivity).tvNavSquare.setTextColor(mainActivity.getResources().getColor(R.color.primary_text_color));
                                MainActivity.access$getBd(mainActivity).tvNavMine.setTextColor(mainActivity.getResources().getColor(R.color.primary_color));
                            }
                        }
                        return false;
                    }
                });
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HomepageFragment());
        arrayList.add(new BookshelfFragment());
        arrayList.add(new CategoryFragment());
        arrayList.add(new MineFragment());
        QMUIViewPager qMUIViewPager = getBd().viewPager;
        Intrinsics.checkNotNullExpressionValue(qMUIViewPager, "bd.viewPager");
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this.supportFragmentManager");
        qMUIViewPager.setAdapter(viewUtils.createPageAdapter(supportFragmentManager, arrayList));
        qMUIViewPager.setOffscreenPageLimit(arrayList.size());
        qMUIViewPager.setSwipeable(false);
        ViewPager1Delegate.Companion.install$default(ViewPager1Delegate.INSTANCE, qMUIViewPager, dslTabLayout, null, 4, null);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(UpdatePlayerEvent updatePlayerEvent) {
        Intrinsics.checkNotNullParameter(updatePlayerEvent, "updatePlayerEvent");
        loadDataFromManager();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(PlayAlbumTrackEvent playAlbumTrackEvent) {
        Intrinsics.checkNotNullParameter(playAlbumTrackEvent, "playAlbumTrackEvent");
        if (Intrinsics.areEqual(playAlbumTrackEvent.getType(), PlayAlbumTrackType.INSTANCE.getBY_COLLECT()) || Intrinsics.areEqual(playAlbumTrackEvent.getType(), PlayAlbumTrackType.INSTANCE.getBY_HISTORY())) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05741(playAlbumTrackEvent.getAlbumId(), playAlbumTrackEvent.getTrackIndex(), null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.MainActivity$onMessageEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.MainActivity$onMessageEvent$1", f = "MainActivity.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
    static final class C05741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $albumId;
        final /* synthetic */ int $trackIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05741(String str, int i, Continuation<? super C05741> continuation) {
            super(2, continuation);
            this.$albumId = str;
            this.$trackIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C05741(this.$albumId, this.$trackIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MainActivity.this.jumpToPlayer(this.$albumId, this.$trackIndex, this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object jumpToPlayer(java.lang.String r11, int r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.funny.audio.view.MainActivity.C05711
            if (r0 == 0) goto L14
            r0 = r13
            com.funny.audio.view.MainActivity$jumpToPlayer$1 r0 = (com.funny.audio.view.MainActivity.C05711) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            com.funny.audio.view.MainActivity$jumpToPlayer$1 r0 = new com.funny.audio.view.MainActivity$jumpToPlayer$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r11 = r0.L$0
            com.funny.audio.view.MainActivity r11 = (com.funny.audio.view.MainActivity) r11
            kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> L6c
            goto L6c
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r13)
            androidx.viewbinding.ViewBinding r13 = r10.getBd()
            com.funny.audio.databinding.ActivityMainBinding r13 = (com.funny.audio.databinding.ActivityMainBinding) r13
            com.airbnb.lottie.LottieAnimationView r13 = r13.loading
            r2 = 0
            r13.setVisibility(r2)
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L6b
            kotlin.coroutines.CoroutineContext r13 = (kotlin.coroutines.CoroutineContext) r13     // Catch: java.lang.Exception -> L6b
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r13)     // Catch: java.lang.Exception -> L6b
            r5 = 0
            r6 = 0
            com.funny.audio.view.MainActivity$jumpToPlayer$2 r13 = new com.funny.audio.view.MainActivity$jumpToPlayer$2     // Catch: java.lang.Exception -> L6b
            r2 = 0
            r13.<init>(r11, r12, r2)     // Catch: java.lang.Exception -> L6b
            r7 = r13
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L6b
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L6b
            r0.L$0 = r10     // Catch: java.lang.Exception -> L6b
            r0.label = r3     // Catch: java.lang.Exception -> L6b
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L6b
            if (r11 != r1) goto L6b
            return r1
        L6b:
            r11 = r10
        L6c:
            androidx.viewbinding.ViewBinding r11 = r11.getBd()
            com.funny.audio.databinding.ActivityMainBinding r11 = (com.funny.audio.databinding.ActivityMainBinding) r11
            com.airbnb.lottie.LottieAnimationView r11 = r11.loading
            r12 = 8
            r11.setVisibility(r12)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.MainActivity.jumpToPlayer(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object jumpToPlayer$default(MainActivity mainActivity, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return mainActivity.jumpToPlayer(str, i, continuation);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.MainActivity$jumpToPlayer$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.MainActivity$jumpToPlayer$2", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $albumId;
        final /* synthetic */ int $trackIndex;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05722(String str, int i, Continuation<? super C05722> continuation) {
            super(2, continuation);
            this.$albumId = str;
            this.$trackIndex = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05722(this.$albumId, this.$trackIndex, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Response<AlbumDetailInfo> albumDetailInfo = ApiManager.INSTANCE.getBusiness().getAlbumDetailInfo(this.$albumId);
            if (NetModelsKt.successWithData(albumDetailInfo)) {
                AppBody<AlbumDetailInfo> body = albumDetailInfo.getBody();
                Intrinsics.checkNotNull(body);
                AlbumDetailInfo data = body.getData();
                Intrinsics.checkNotNull(data);
                AlbumDetailInfo albumDetailInfo2 = data;
                Response<List<AlbumTrackInfo>> albumTrackList = ApiManager.INSTANCE.getBusiness().getAlbumTrackList(this.$albumId);
                if (NetModelsKt.successWithData(albumTrackList)) {
                    AppBody<List<AlbumTrackInfo>> body2 = albumTrackList.getBody();
                    Intrinsics.checkNotNull(body2);
                    List<AlbumTrackInfo> data2 = body2.getData();
                    Intrinsics.checkNotNull(data2);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(albumDetailInfo2, data2, this.$trackIndex, null), 3, null);
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.funny.audio.view.MainActivity$jumpToPlayer$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MainActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "com.funny.audio.view.MainActivity$jumpToPlayer$2$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AlbumDetailInfo $albumDetailInfo;
            final /* synthetic */ int $trackIndex;
            final /* synthetic */ List<AlbumTrackInfo> $tracks;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AlbumDetailInfo albumDetailInfo, List<AlbumTrackInfo> list, int i, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$albumDetailInfo = albumDetailInfo;
                this.$tracks = list;
                this.$trackIndex = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$albumDetailInfo, this.$tracks, this.$trackIndex, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                MediaPlayerManager.INSTANCE.playAlbumTrack(this.$albumDetailInfo, this.$tracks, this.$trackIndex, (24 & 8) != 0 ? 0L : 0L, (24 & 16) != 0 ? false : true, (24 & 32) != 0 ? true : true);
                return Unit.INSTANCE;
            }
        }
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
                QMUIRadiusImageView qMUIRadiusImageView = getBd().ivFloatPlayerCover;
                Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "bd.ivFloatPlayerCover");
                imageUtils.loadToView(context, qMUIRadiusImageView, this.coverPath);
            }
            if (this.isPlaying != MediaPlayerManager.INSTANCE.isPlaying()) {
                boolean zIsPlaying = MediaPlayerManager.INSTANCE.isPlaying();
                this.isPlaying = zIsPlaying;
                if (zIsPlaying) {
                    getBd().ivPlay.setImageResource(R.drawable.ic_float_player_pause_btn);
                    ObjectAnimator objectAnimator = this.coverAnimator;
                    if (objectAnimator != null) {
                        if (objectAnimator.isStarted()) {
                            objectAnimator.resume();
                        } else {
                            objectAnimator.start();
                        }
                    }
                } else {
                    getBd().ivPlay.setImageResource(R.drawable.ic_float_player_play_btn);
                    ObjectAnimator objectAnimator2 = this.coverAnimator;
                    if (objectAnimator2 != null) {
                        objectAnimator2.pause();
                    }
                }
            }
            long progress = MediaPlayerManager.INSTANCE.getProgress();
            long duration = MediaPlayerManager.INSTANCE.getDuration();
            long buffering = MediaPlayerManager.INSTANCE.getBuffering();
            int i = duration > 0 ? (int) ((progress * ((long) 100)) / duration) : 0;
            if (duration > 0) {
                long j = (buffering * ((long) 100)) / duration;
            }
            getBd().progressBar.setProgress(i);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.exitFlag) {
            this.exitFlag = true;
            DialogUtils.INSTANCE.tip("再按一次返回键退出应用");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05731(null), 3, null);
        } else {
            stopService(new Intent(this, (Class<?>) MediaService.class));
            super.onBackPressed();
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.MainActivity$onBackPressed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.MainActivity$onBackPressed$1", f = "MainActivity.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_REFRESH_BY_TIME}, m = "invokeSuspend", n = {}, s = {})
    static final class C05731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05731(Continuation<? super C05731> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C05731(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MainActivity.this.clearExitFlag(this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object clearExitFlag(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.funny.audio.view.MainActivity.C05671
            if (r0 == 0) goto L14
            r0 = r5
            com.funny.audio.view.MainActivity$clearExitFlag$1 r0 = (com.funny.audio.view.MainActivity.C05671) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.funny.audio.view.MainActivity$clearExitFlag$1 r0 = new com.funny.audio.view.MainActivity$clearExitFlag$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.MainActivity r0 = (com.funny.audio.view.MainActivity) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L47
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            r2 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r2, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            r0 = r4
        L47:
            r5 = 0
            r0.exitFlag = r5
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.MainActivity.clearExitFlag(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkUpdate(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.funny.audio.view.MainActivity.C05661
            if (r0 == 0) goto L14
            r0 = r12
            com.funny.audio.view.MainActivity$checkUpdate$1 r0 = (com.funny.audio.view.MainActivity.C05661) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            com.funny.audio.view.MainActivity$checkUpdate$1 r0 = new com.funny.audio.view.MainActivity$checkUpdate$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.MainActivity r0 = (com.funny.audio.view.MainActivity) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L60
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L37:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.CoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
            kotlinx.coroutines.CoroutineScope r5 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r12)
            r6 = 0
            r7 = 0
            com.funny.audio.view.MainActivity$checkUpdate$updateInfo$1 r12 = new com.funny.audio.view.MainActivity$checkUpdate$updateInfo$1
            r12.<init>(r3)
            r8 = r12
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            r9 = 3
            r10 = 0
            kotlinx.coroutines.Deferred r12 = kotlinx.coroutines.BuildersKt.async$default(r5, r6, r7, r8, r9, r10)
            r0.L$0 = r11
            r0.label = r4
            java.lang.Object r12 = r12.await(r0)
            if (r12 != r1) goto L5f
            return r1
        L5f:
            r0 = r11
        L60:
            com.funny.audio.models.CloudUpdateInfo r12 = (com.funny.audio.models.CloudUpdateInfo) r12
            com.funny.audio.update.AppUpdater r1 = com.funny.audio.update.AppUpdater.INSTANCE
            r2 = 0
            boolean r12 = r1.hasUpdate(r12, r2)
            if (r12 == 0) goto L84
            com.funny.audio.view.update.UpdateDialogFragment r12 = new com.funny.audio.view.update.UpdateDialogFragment
            r12.<init>()
            androidx.fragment.app.FragmentManager r1 = r0.getSupportFragmentManager()
            java.lang.String r2 = "this.supportFragmentManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.funny.audio.view.MainActivity$checkUpdate$2 r2 = new com.funny.audio.view.MainActivity$checkUpdate$2
            r2.<init>()
            com.funny.audio.view.update.UpdateDialogListener r2 = (com.funny.audio.view.update.UpdateDialogListener) r2
            r12.show(r1, r2)
            goto L9d
        L84:
            kotlinx.coroutines.MainCoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r12)
            r5 = 0
            r6 = 0
            com.funny.audio.view.MainActivity$checkUpdate$3 r12 = new com.funny.audio.view.MainActivity$checkUpdate$3
            r12.<init>(r3)
            r7 = r12
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            kotlinx.coroutines.BuildersKt.launch$default(r4, r5, r6, r7, r8, r9)
        L9d:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.MainActivity.checkUpdate(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.funny.audio.view.MainActivity$checkUpdate$3, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.MainActivity$checkUpdate$3", f = "MainActivity.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (MainActivity.this.checkAlertNotice(this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkAlertNotice(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.MainActivity.checkAlertNotice(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void showAlertNoticeDialog(AlertNoticeInfo alertNoticeInfo) {
        AlertNoticeDialogFragment alertNoticeDialogFragment = new AlertNoticeDialogFragment();
        alertNoticeDialogFragment.setAlertNoticeInfo(alertNoticeInfo);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this.supportFragmentManager");
        alertNoticeDialogFragment.show(supportFragmentManager);
    }
}
