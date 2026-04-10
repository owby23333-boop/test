package com.funny.audio.view.album;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.angcyo.tablayout.DslTabLayout;
import com.angcyo.tablayout.delegate.ViewPager1Delegate;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.funny.audio.AppManager;
import com.funny.audio.PlayAlbumTrackEvent;
import com.funny.audio.PlayAlbumTrackType;
import com.funny.audio.R;
import com.funny.audio.UpdatePlayerEvent;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.PlayHistoryEntity;
import com.funny.audio.databinding.ActivityAlbumDetailBinding;
import com.funny.audio.media_player.MediaPlayerManager;
import com.funny.audio.models.AlbumDetailInfo;
import com.funny.audio.models.AlbumStatus;
import com.funny.audio.models.AlbumTrackInfo;
import com.funny.audio.models.TagItem;
import com.funny.audio.update.AppUpdater;
import com.funny.audio.view.DialogUtils;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.ViewUtils;
import com.funny.audio.view.adapters.AlbumTagAdapter;
import com.funny.audio.view.core.BaseActivity;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.core.MessageDialogFragment;
import com.funny.audio.view.core.StatusBarUtils;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: AlbumDetailActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0011\u0010\u001b\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u0018H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\b\u0010#\u001a\u00020\u0018H\u0016J\u0011\u0010$\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0011\u0010%\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\b\u0010&\u001a\u00020\u0018H\u0002J\u0011\u0010'\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0007J\b\u0010+\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u000bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lcom/funny/audio/view/album/AlbumDetailActivity;", "Lcom/funny/audio/view/core/BaseActivity;", "Lcom/funny/audio/databinding/ActivityAlbumDetailBinding;", "()V", "albumDetailInfo", "Lcom/funny/audio/models/AlbumDetailInfo;", "albumId", "", "albumTagAdapter", "Lcom/funny/audio/view/adapters/AlbumTagAdapter;", "albumTagItems", "", "Lcom/funny/audio/models/TagItem;", "currentAlbumPlaying", "", "currentTrackIndex", "", "currentTrackTitle", "isCollect", "playHistoryEntity", "Lcom/funny/audio/database/entities/PlayHistoryEntity;", "tabFragments", "Lcom/funny/audio/view/core/BaseFragment;", "cancelCollect", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkOffShelf", "collect", "displayCollectFlag", "initAlbumTags", "initBottomBar", "initData", "initStatusBar", "initTabs", "initTopBar", "initView", "loadAlbumDetail", "loadCollectFlag", "loadFromManager", "loadPlayHistory", "onMessageEvent", "updatePlayerEvent", "Lcom/funny/audio/UpdatePlayerEvent;", "releaseView", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AlbumDetailActivity extends BaseActivity<ActivityAlbumDetailBinding> {
    private AlbumDetailInfo albumDetailInfo;
    private boolean currentAlbumPlaying;
    private boolean isCollect;
    private PlayHistoryEntity playHistoryEntity;
    private String albumId = "";
    private AlbumTagAdapter albumTagAdapter = new AlbumTagAdapter();
    private final List<TagItem> albumTagItems = new ArrayList();
    private List<BaseFragment<?>> tabFragments = new ArrayList();
    private int currentTrackIndex = -1;
    private String currentTrackTitle = "";

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumDetailActivity$cancelCollect$1, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumDetailActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity", f = "AlbumDetailActivity.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL}, m = "cancelCollect", n = {}, s = {})
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
            return AlbumDetailActivity.this.cancelCollect(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumDetailActivity$collect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumDetailActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity", f = "AlbumDetailActivity.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME}, m = "collect", n = {}, s = {})
    static final class C05751 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C05751(Continuation<? super C05751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumDetailActivity.this.collect(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumDetailActivity$loadAlbumDetail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumDetailActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity", f = "AlbumDetailActivity.kt", i = {0}, l = {192}, m = "loadAlbumDetail", n = {"this"}, s = {"L$0"})
    static final class C05801 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05801(Continuation<? super C05801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumDetailActivity.this.loadAlbumDetail(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumDetailActivity$loadCollectFlag$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumDetailActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity", f = "AlbumDetailActivity.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS}, m = "loadCollectFlag", n = {"this"}, s = {"L$0"})
    static final class C05811 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05811(Continuation<? super C05811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumDetailActivity.this.loadCollectFlag(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumDetailActivity$loadPlayHistory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumDetailActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity", f = "AlbumDetailActivity.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_REFRESH_BY_TIME}, m = "loadPlayHistory", n = {"this"}, s = {"L$0"})
    static final class C05821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C05821(Continuation<? super C05821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumDetailActivity.this.loadPlayHistory(this);
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initView() {
        NavigationUtils navigationUtils = NavigationUtils.INSTANCE;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        this.albumId = navigationUtils.getAlbumId(intent);
        initStatusBar();
        initTopBar();
        initAlbumTags();
        initBottomBar();
        EventBus.getDefault().register(this);
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void releaseView() {
        EventBus.getDefault().unregister(this);
        super.releaseView();
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumDetailActivity$initData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumDetailActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity$initData$1", f = "AlbumDetailActivity.kt", i = {}, l = {79, 80, 81}, m = "invokeSuspend", n = {}, s = {})
    static final class C05781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05781(Continuation<? super C05781> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AlbumDetailActivity.this.new C05781(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0051 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r6)
                goto L52
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L44
            L21:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L36
            L25:
                kotlin.ResultKt.throwOnFailure(r6)
                com.funny.audio.view.album.AlbumDetailActivity r6 = com.funny.audio.view.album.AlbumDetailActivity.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r4
                java.lang.Object r6 = com.funny.audio.view.album.AlbumDetailActivity.access$loadAlbumDetail(r6, r1)
                if (r6 != r0) goto L36
                return r0
            L36:
                com.funny.audio.view.album.AlbumDetailActivity r6 = com.funny.audio.view.album.AlbumDetailActivity.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r3
                java.lang.Object r6 = com.funny.audio.view.album.AlbumDetailActivity.access$loadCollectFlag(r6, r1)
                if (r6 != r0) goto L44
                return r0
            L44:
                com.funny.audio.view.album.AlbumDetailActivity r6 = com.funny.audio.view.album.AlbumDetailActivity.this
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r6 = com.funny.audio.view.album.AlbumDetailActivity.access$loadPlayHistory(r6, r1)
                if (r6 != r0) goto L52
                return r0
            L52:
                com.funny.audio.view.album.AlbumDetailActivity r6 = com.funny.audio.view.album.AlbumDetailActivity.this
                com.funny.audio.view.album.AlbumDetailActivity.access$checkOffShelf(r6)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.album.AlbumDetailActivity.C05781.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.funny.audio.view.core.BaseActivity
    public void initData() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05781(null), 3, null);
    }

    private final void initTopBar() {
        getBd().appBack.setOnClickListener(new View.OnClickListener() { // from class: com.funny.audio.view.album.AlbumDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlbumDetailActivity.initTopBar$lambda$0(this.f$0, view);
            }
        });
        ImageView imageView = getBd().albumShare;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.albumShare");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.album.AlbumDetailActivity.initTopBar.2
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
                    Intent intent = new Intent("android.intent.action.SEND");
                    AlbumDetailActivity albumDetailActivity = AlbumDetailActivity.this;
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", "您的好友正在使用《" + albumDetailActivity.getContext().getResources().getString(R.string.app_name) + "》免费畅听海量听书资源，下载链接：" + AppUpdater.INSTANCE.getShareAppUrl());
                    AlbumDetailActivity.this.getContext().startActivity(Intent.createChooser(intent, "分享至"));
                } catch (Exception unused) {
                }
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTopBar$lambda$0(AlbumDetailActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    private final void initStatusBar() {
        AlbumDetailActivity albumDetailActivity = this;
        StatusBarUtils.INSTANCE.translucent(albumDetailActivity);
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils.INSTANCE.setStatusBarDarkMode(albumDetailActivity);
        } else {
            StatusBarUtils.INSTANCE.setStatusBarLightMode(albumDetailActivity);
        }
    }

    private final void initAlbumTags() {
        RecyclerView recyclerView = getBd().rvAlbumTags;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "bd.rvAlbumTags");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.albumTagAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.album.AlbumDetailActivity$$ExternalSyntheticLambda1
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AlbumDetailActivity.initAlbumTags$lambda$2(this.f$0, baseQuickAdapter, view, i);
            }
        }, 1, null);
        this.albumTagAdapter.submitList(this.albumTagItems);
        recyclerView.setAdapter(this.albumTagAdapter);
        recyclerView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAlbumTags$lambda$2(AlbumDetailActivity this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        TagItem tagItem = (TagItem) adapter.getItem(i);
        if (tagItem != null) {
            NavigationUtils.INSTANCE.toTagAlbum(this$0, tagItem.getId());
        }
    }

    private final void initTabs() {
        DslTabLayout dslTabLayout = getBd().lyTab;
        Intrinsics.checkNotNullExpressionValue(dslTabLayout, "bd.lyTab");
        QMUIViewPager qMUIViewPager = getBd().viewPager;
        Intrinsics.checkNotNullExpressionValue(qMUIViewPager, "bd.viewPager");
        this.tabFragments = new ArrayList();
        AlbumTracksFragment albumTracksFragment = new AlbumTracksFragment();
        albumTracksFragment.setAlbumId(this.albumId);
        albumTracksFragment.setAlbumDetailInfo(this.albumDetailInfo);
        this.tabFragments.add(albumTracksFragment);
        AlbumLikesFragment albumLikesFragment = new AlbumLikesFragment();
        albumLikesFragment.setAlbumId(this.albumId);
        AlbumDetailInfo albumDetailInfo = this.albumDetailInfo;
        Intrinsics.checkNotNull(albumDetailInfo);
        albumLikesFragment.setAlbumDetailInfo(albumDetailInfo);
        this.tabFragments.add(albumLikesFragment);
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this.supportFragmentManager");
        qMUIViewPager.setAdapter(viewUtils.createPageAdapter(supportFragmentManager, this.tabFragments));
        qMUIViewPager.setOffscreenPageLimit(this.tabFragments.size());
        qMUIViewPager.setSwipeable(true);
        ViewPager1Delegate.Companion.install$default(ViewPager1Delegate.INSTANCE, qMUIViewPager, dslTabLayout, null, 4, null);
    }

    private final void initBottomBar() {
        LinearLayout linearLayout = getBd().lyCollectFlag;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "bd.lyCollectFlag");
        ViewKt.click$default(linearLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.album.AlbumDetailActivity.initBottomBar.1
            {
                super(0);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumDetailActivity$initBottomBar$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: AlbumDetailActivity.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity$initBottomBar$1$1", f = "AlbumDetailActivity.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME, 166}, m = "invokeSuspend", n = {}, s = {})
            static final class C02421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ AlbumDetailActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C02421(AlbumDetailActivity albumDetailActivity, Continuation<? super C02421> continuation) {
                    super(2, continuation);
                    this.this$0 = albumDetailActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C02421(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C02421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C02421(AlbumDetailActivity.this, null), 3, null);
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout = getBd().btnPlay;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.btnPlay");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.album.AlbumDetailActivity.initBottomBar.2
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
                if (AlbumDetailActivity.this.currentAlbumPlaying) {
                    MediaPlayerManager.INSTANCE.playPause();
                    return;
                }
                PlayAlbumTrackEvent playAlbumTrackEvent = new PlayAlbumTrackEvent();
                playAlbumTrackEvent.setType(PlayAlbumTrackType.INSTANCE.getBY_ALBUM_DETAIL());
                playAlbumTrackEvent.setTrackIndex(AlbumDetailActivity.this.currentTrackIndex > 0 ? AlbumDetailActivity.this.currentTrackIndex : 0);
                playAlbumTrackEvent.setAlbumId(AlbumDetailActivity.this.albumId);
                EventBus.getDefault().post(playAlbumTrackEvent);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadAlbumDetail(kotlin.coroutines.Continuation<? super kotlin.Unit> r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 664
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.album.AlbumDetailActivity.loadAlbumDetail(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkOffShelf() {
        AlbumDetailInfo albumDetailInfo = this.albumDetailInfo;
        if (albumDetailInfo == null || albumDetailInfo.getStatus() == AlbumStatus.INSTANCE.getNORMAL()) {
            return;
        }
        MessageDialogFragment positiveBtn = new MessageDialogFragment().setTitle("专辑状态异常").setContent("资源因为不可抗力因素或者受到损坏暂时无法播放，先去收听其他资源吧~").setPositiveBtn("返回", new DialogUtils.OnButtonClickListener() { // from class: com.funny.audio.view.album.AlbumDetailActivity$checkOffShelf$1$1
            @Override // com.funny.audio.view.DialogUtils.OnButtonClickListener
            public boolean onClick(View v) {
                this.this$0.finish();
                return true;
            }
        });
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "this.supportFragmentManager");
        positiveBtn.show(supportFragmentManager);
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
            boolean r0 = r11 instanceof com.funny.audio.view.album.AlbumDetailActivity.C05811
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.album.AlbumDetailActivity$loadCollectFlag$1 r0 = (com.funny.audio.view.album.AlbumDetailActivity.C05811) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.album.AlbumDetailActivity$loadCollectFlag$1 r0 = new com.funny.audio.view.album.AlbumDetailActivity$loadCollectFlag$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.album.AlbumDetailActivity r0 = (com.funny.audio.view.album.AlbumDetailActivity) r0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L6b
            goto L60
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L6b
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> L6b
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)     // Catch: java.lang.Exception -> L6b
            r5 = 0
            r6 = 0
            com.funny.audio.view.album.AlbumDetailActivity$loadCollectFlag$bookshelfEntity$1 r11 = new com.funny.audio.view.album.AlbumDetailActivity$loadCollectFlag$bookshelfEntity$1     // Catch: java.lang.Exception -> L6b
            r2 = 0
            r11.<init>(r10, r2)     // Catch: java.lang.Exception -> L6b
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L6b
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L6b
            r0.L$0 = r10     // Catch: java.lang.Exception -> L6b
            r0.label = r3     // Catch: java.lang.Exception -> L6b
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L6b
            if (r11 != r1) goto L5f
            return r1
        L5f:
            r0 = r10
        L60:
            com.funny.audio.database.entities.BookshelfEntity r11 = (com.funny.audio.database.entities.BookshelfEntity) r11     // Catch: java.lang.Exception -> L6b
            if (r11 == 0) goto L65
            goto L66
        L65:
            r3 = 0
        L66:
            r0.isCollect = r3     // Catch: java.lang.Exception -> L6b
            r0.displayCollectFlag()     // Catch: java.lang.Exception -> L6b
        L6b:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.album.AlbumDetailActivity.loadCollectFlag(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadPlayHistory(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.String r0 = "续播 | "
            boolean r1 = r12 instanceof com.funny.audio.view.album.AlbumDetailActivity.C05821
            if (r1 == 0) goto L16
            r1 = r12
            com.funny.audio.view.album.AlbumDetailActivity$loadPlayHistory$1 r1 = (com.funny.audio.view.album.AlbumDetailActivity.C05821) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L16
            int r12 = r1.label
            int r12 = r12 - r3
            r1.label = r12
            goto L1b
        L16:
            com.funny.audio.view.album.AlbumDetailActivity$loadPlayHistory$1 r1 = new com.funny.audio.view.album.AlbumDetailActivity$loadPlayHistory$1
            r1.<init>(r12)
        L1b:
            java.lang.Object r12 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L3c
            if (r3 != r4) goto L34
            java.lang.Object r2 = r1.L$1
            com.funny.audio.view.album.AlbumDetailActivity r2 = (com.funny.audio.view.album.AlbumDetailActivity) r2
            java.lang.Object r1 = r1.L$0
            com.funny.audio.view.album.AlbumDetailActivity r1 = (com.funny.audio.view.album.AlbumDetailActivity) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L9e
            goto L69
        L34:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L3c:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.CoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L9e
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12     // Catch: java.lang.Exception -> L9e
            kotlinx.coroutines.CoroutineScope r5 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r12)     // Catch: java.lang.Exception -> L9e
            r6 = 0
            r7 = 0
            com.funny.audio.view.album.AlbumDetailActivity$loadPlayHistory$2 r12 = new com.funny.audio.view.album.AlbumDetailActivity$loadPlayHistory$2     // Catch: java.lang.Exception -> L9e
            r3 = 0
            r12.<init>(r3)     // Catch: java.lang.Exception -> L9e
            r8 = r12
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch: java.lang.Exception -> L9e
            r9 = 3
            r10 = 0
            kotlinx.coroutines.Deferred r12 = kotlinx.coroutines.BuildersKt.async$default(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L9e
            r1.L$0 = r11     // Catch: java.lang.Exception -> L9e
            r1.L$1 = r11     // Catch: java.lang.Exception -> L9e
            r1.label = r4     // Catch: java.lang.Exception -> L9e
            java.lang.Object r12 = r12.await(r1)     // Catch: java.lang.Exception -> L9e
            if (r12 != r2) goto L67
            return r2
        L67:
            r1 = r11
            r2 = r1
        L69:
            com.funny.audio.database.entities.PlayHistoryEntity r12 = (com.funny.audio.database.entities.PlayHistoryEntity) r12     // Catch: java.lang.Exception -> L9e
            r2.playHistoryEntity = r12     // Catch: java.lang.Exception -> L9e
            com.funny.audio.database.entities.PlayHistoryEntity r12 = r1.playHistoryEntity     // Catch: java.lang.Exception -> L9e
            if (r12 == 0) goto L9b
            java.lang.String r2 = r12.getLastTrackTitle()     // Catch: java.lang.Exception -> L9e
            r1.currentTrackTitle = r2     // Catch: java.lang.Exception -> L9e
            int r2 = r12.getTrackIndex()     // Catch: java.lang.Exception -> L9e
            r1.currentTrackIndex = r2     // Catch: java.lang.Exception -> L9e
            androidx.viewbinding.ViewBinding r2 = r1.getBd()     // Catch: java.lang.Exception -> L9e
            com.funny.audio.databinding.ActivityAlbumDetailBinding r2 = (com.funny.audio.databinding.ActivityAlbumDetailBinding) r2     // Catch: java.lang.Exception -> L9e
            com.funny.audio.view.core.MarqueeTextView r2 = r2.tvPlayText     // Catch: java.lang.Exception -> L9e
            java.lang.String r12 = r12.getLastTrackTitle()     // Catch: java.lang.Exception -> L9e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e
            r3.<init>(r0)     // Catch: java.lang.Exception -> L9e
            java.lang.StringBuilder r12 = r3.append(r12)     // Catch: java.lang.Exception -> L9e
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Exception -> L9e
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch: java.lang.Exception -> L9e
            r2.setText(r12)     // Catch: java.lang.Exception -> L9e
        L9b:
            r1.loadFromManager()     // Catch: java.lang.Exception -> L9e
        L9e:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.album.AlbumDetailActivity.loadPlayHistory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumDetailActivity$loadPlayHistory$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumDetailActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/funny/audio/database/entities/PlayHistoryEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity$loadPlayHistory$2", f = "AlbumDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05832 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PlayHistoryEntity>, Object> {
        int label;

        C05832(Continuation<? super C05832> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AlbumDetailActivity.this.new C05832(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PlayHistoryEntity> continuation) {
            return ((C05832) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return DbContext.INSTANCE.getCurrent().playHistory().album(AlbumDetailActivity.this.albumId);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayCollectFlag() {
        if (this.isCollect) {
            getBd().ivCollectFlag.setImageResource(R.drawable.ic_album_detail_collect_seleted);
            getBd().tvCollectFlag.setText("已收藏");
        } else {
            getBd().ivCollectFlag.setImageResource(R.drawable.ic_album_detail_collect_normal);
            getBd().tvCollectFlag.setText("收藏");
        }
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
            boolean r0 = r11 instanceof com.funny.audio.view.album.AlbumDetailActivity.C05751
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.album.AlbumDetailActivity$collect$1 r0 = (com.funny.audio.view.album.AlbumDetailActivity.C05751) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.album.AlbumDetailActivity$collect$1 r0 = new com.funny.audio.view.album.AlbumDetailActivity$collect$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L5d
            goto L5d
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L32:
            kotlin.ResultKt.throwOnFailure(r11)
            com.funny.audio.models.AlbumDetailInfo r11 = r10.albumDetailInfo     // Catch: java.lang.Exception -> L5d
            if (r11 == 0) goto L5d
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L5d
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2     // Catch: java.lang.Exception -> L5d
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r2)     // Catch: java.lang.Exception -> L5d
            r5 = 0
            r6 = 0
            com.funny.audio.view.album.AlbumDetailActivity$collect$2$1 r2 = new com.funny.audio.view.album.AlbumDetailActivity$collect$2$1     // Catch: java.lang.Exception -> L5d
            r7 = 0
            r2.<init>(r11, r10, r7)     // Catch: java.lang.Exception -> L5d
            r7 = r2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L5d
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L5d
            r0.label = r3     // Catch: java.lang.Exception -> L5d
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L5d
            if (r11 != r1) goto L5d
            return r1
        L5d:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.album.AlbumDetailActivity.collect(kotlin.coroutines.Continuation):java.lang.Object");
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
            boolean r0 = r11 instanceof com.funny.audio.view.album.AlbumDetailActivity.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.album.AlbumDetailActivity$cancelCollect$1 r0 = (com.funny.audio.view.album.AlbumDetailActivity.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.album.AlbumDetailActivity$cancelCollect$1 r0 = new com.funny.audio.view.album.AlbumDetailActivity$cancelCollect$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> L59
            goto L59
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L32:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L59
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11     // Catch: java.lang.Exception -> L59
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)     // Catch: java.lang.Exception -> L59
            r5 = 0
            r6 = 0
            com.funny.audio.view.album.AlbumDetailActivity$cancelCollect$2 r11 = new com.funny.audio.view.album.AlbumDetailActivity$cancelCollect$2     // Catch: java.lang.Exception -> L59
            r2 = 0
            r11.<init>(r2)     // Catch: java.lang.Exception -> L59
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Exception -> L59
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L59
            r0.label = r3     // Catch: java.lang.Exception -> L59
            java.lang.Object r11 = r11.await(r0)     // Catch: java.lang.Exception -> L59
            if (r11 != r1) goto L59
            return r1
        L59:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.album.AlbumDetailActivity.cancelCollect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumDetailActivity$cancelCollect$2, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumDetailActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumDetailActivity$cancelCollect$2", f = "AlbumDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AlbumDetailActivity.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DbContext.INSTANCE.getCurrent().bookshelf().remove(AlbumDetailActivity.this.albumId);
                AlbumDetailActivity.this.isCollect = false;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void loadFromManager() {
        AlbumTrackInfo currentAlbumTrackInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumTrackInfo();
        if (currentAlbumTrackInfo != null) {
            if (!Intrinsics.areEqual(currentAlbumTrackInfo.getAlbumId(), this.albumId)) {
                getBd().ivPlay.setImageResource(R.drawable.ic_float_player_play_btn);
                String str = this.currentTrackTitle.length() > 0 ? "续播 | " + this.currentTrackTitle : "开始播放";
                if (!Intrinsics.areEqual(getBd().tvPlayText.getText(), str)) {
                    getBd().tvPlayText.setText(str);
                }
                this.currentAlbumPlaying = false;
                return;
            }
            if (MediaPlayerManager.INSTANCE.isPlaying()) {
                this.currentAlbumPlaying = true;
                getBd().ivPlay.setImageResource(R.drawable.ic_float_player_pause_btn);
                getBd().tvPlayText.setText("暂停播放");
            } else {
                this.currentAlbumPlaying = false;
                getBd().ivPlay.setImageResource(R.drawable.ic_float_player_play_btn);
                String str2 = "续播 | " + currentAlbumTrackInfo.getTitle();
                if (!Intrinsics.areEqual(getBd().tvPlayText.getText(), str2)) {
                    getBd().tvPlayText.setText(str2);
                }
            }
            this.currentTrackIndex = currentAlbumTrackInfo.getSort();
            this.currentTrackTitle = currentAlbumTrackInfo.getTitle();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(UpdatePlayerEvent updatePlayerEvent) {
        Intrinsics.checkNotNullParameter(updatePlayerEvent, "updatePlayerEvent");
        loadFromManager();
    }
}
