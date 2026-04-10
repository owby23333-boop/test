package com.funny.audio.view.album;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.drake.statelayout.StateLayout;
import com.funny.audio.PlayAlbumTrackEvent;
import com.funny.audio.PlayAlbumTrackType;
import com.funny.audio.R;
import com.funny.audio.UpdatePlayerEvent;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.databinding.FragmentAlbumTrackListBinding;
import com.funny.audio.media_player.MediaPlayerManager;
import com.funny.audio.models.AlbumDetailInfo;
import com.funny.audio.models.AlbumTrackInfo;
import com.funny.audio.models.TrackSelectionInfo;
import com.funny.audio.view.adapters.AlbumTrackAdapter;
import com.funny.audio.view.adapters.TrackSelectionAdapter;
import com.funny.audio.view.album.AlbumTracksFragment;
import com.funny.audio.view.core.BaseFragment;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: AlbumTracksFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0016J\u0011\u0010$\u001a\u00020\u001fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u001fH\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+H\u0007J\b\u0010,\u001a\u00020\u001fH\u0016J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/funny/audio/view/album/AlbumTracksFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentAlbumTrackListBinding;", "()V", "albumDetailInfo", "Lcom/funny/audio/models/AlbumDetailInfo;", "getAlbumDetailInfo", "()Lcom/funny/audio/models/AlbumDetailInfo;", "setAlbumDetailInfo", "(Lcom/funny/audio/models/AlbumDetailInfo;)V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "ascending", "", "currentPlaySort", "", "isPlaying", "trackSelectionAdapter", "Lcom/funny/audio/view/adapters/TrackSelectionAdapter;", "trackSelections", "", "Lcom/funny/audio/models/TrackSelectionInfo;", "tracks", "Lcom/funny/audio/models/AlbumTrackInfo;", "tracksAdapter", "Lcom/funny/audio/view/adapters/AlbumTrackAdapter;", "initData", "", "initState", "initView", "view", "Landroid/view/View;", "loadData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDataFromManager", "onMessageEvent", "playAlbumTrackEvent", "Lcom/funny/audio/PlayAlbumTrackEvent;", "updatePlayerEvent", "Lcom/funny/audio/UpdatePlayerEvent;", "releaseView", "tracksToSelections", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AlbumTracksFragment extends BaseFragment<FragmentAlbumTrackListBinding> {
    private AlbumDetailInfo albumDetailInfo;
    private boolean isPlaying;
    private String albumId = "";
    private final AlbumTrackAdapter tracksAdapter = new AlbumTrackAdapter();
    private List<AlbumTrackInfo> tracks = new ArrayList();
    private final TrackSelectionAdapter trackSelectionAdapter = new TrackSelectionAdapter();
    private List<TrackSelectionInfo> trackSelections = new ArrayList();
    private boolean ascending = true;
    private int currentPlaySort = -1;

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumTracksFragment$loadData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumTracksFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumTracksFragment", f = "AlbumTracksFragment.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY, 235}, m = "loadData", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class C05851 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05851(Continuation<? super C05851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumTracksFragment.this.loadData(this);
        }
    }

    public static final /* synthetic */ FragmentAlbumTrackListBinding access$getBd(AlbumTracksFragment albumTracksFragment) {
        return albumTracksFragment.getBd();
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final AlbumDetailInfo getAlbumDetailInfo() {
        return this.albumDetailInfo;
    }

    public final void setAlbumDetailInfo(AlbumDetailInfo albumDetailInfo) {
        this.albumDetailInfo = albumDetailInfo;
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initState();
        final RecyclerView recyclerView = getBd().rvTracks;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "bd.rvTracks");
        final RecyclerView recyclerView2 = getBd().rvTrackSelections;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "bd.rvTrackSelections");
        this.trackSelectionAdapter.submitList(this.trackSelections);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.trackSelectionAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.album.AlbumTracksFragment$$ExternalSyntheticLambda0
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                AlbumTracksFragment.initView$lambda$0(this.f$0, recyclerView, recyclerView2, baseQuickAdapter, view2, i);
            }
        }, 1, null);
        recyclerView2.setAdapter(this.trackSelectionAdapter);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.tracksAdapter.submitList(this.tracks);
        this.tracksAdapter.setItemAnimation(BaseQuickAdapter.AnimationType.SlideInRight);
        this.tracksAdapter.setAnimationEnable(true);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.tracksAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.album.AlbumTracksFragment$$ExternalSyntheticLambda1
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                AlbumTracksFragment.initView$lambda$1(this.f$0, baseQuickAdapter, view2, i);
            }
        }, 1, null);
        recyclerView.setAdapter(this.tracksAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.funny.audio.view.album.AlbumTracksFragment.initView.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView3, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView3, "recyclerView");
                super.onScrolled(recyclerView3, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView3.getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager != null) {
                    linearLayoutManager.findFirstVisibleItemPosition();
                }
                int iFindLastVisibleItemPosition = linearLayoutManager != null ? linearLayoutManager.findLastVisibleItemPosition() : -1;
                if (iFindLastVisibleItemPosition >= 0) {
                    Iterator it = AlbumTracksFragment.this.trackSelections.iterator();
                    while (it.hasNext()) {
                        ((TrackSelectionInfo) it.next()).setCurrent(false);
                    }
                    TrackSelectionInfo trackSelectionInfo = (TrackSelectionInfo) CollectionsKt.getOrNull(AlbumTracksFragment.this.trackSelections, iFindLastVisibleItemPosition / 50);
                    if (trackSelectionInfo != null) {
                        trackSelectionInfo.setCurrent(true);
                        AlbumTracksFragment.this.trackSelectionAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
        LinearLayout linearLayout = getBd().lyTrackAscending;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "bd.lyTrackAscending");
        ViewKt.click$default(linearLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.album.AlbumTracksFragment.initView.4
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
                if (CollectionsKt.any(AlbumTracksFragment.this.tracks)) {
                    if (AlbumTracksFragment.this.ascending) {
                        AlbumTracksFragment.access$getBd(AlbumTracksFragment.this).tvTrackAscending.setText("倒序");
                    } else {
                        AlbumTracksFragment.access$getBd(AlbumTracksFragment.this).tvTrackAscending.setText("正序");
                    }
                    CollectionsKt.reverse(AlbumTracksFragment.this.tracks);
                    CollectionsKt.reverse(AlbumTracksFragment.this.trackSelections);
                    AlbumTracksFragment.this.ascending = !r0.ascending;
                    AlbumTracksFragment.this.tracksAdapter.notifyDataSetChanged();
                    AlbumTracksFragment.this.trackSelectionAdapter.notifyDataSetChanged();
                }
            }
        }, 1, null);
        LinearLayout linearLayout2 = getBd().lyTrackSelections;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "bd.lyTrackSelections");
        ViewKt.click$default(linearLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.album.AlbumTracksFragment.initView.5
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
                int visibility = recyclerView2.getVisibility();
                if (visibility == 0) {
                    recyclerView2.setVisibility(8);
                } else {
                    if (visibility != 8) {
                        return;
                    }
                    recyclerView2.setVisibility(0);
                }
            }
        }, 1, null);
        QMUIRoundButton qMUIRoundButton = getBd().btnTop;
        Intrinsics.checkNotNullExpressionValue(qMUIRoundButton, "bd.btnTop");
        ViewKt.click$default(qMUIRoundButton, 0, new Function0<Unit>() { // from class: com.funny.audio.view.album.AlbumTracksFragment.initView.6
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
                recyclerView.scrollToPosition(0);
            }
        }, 1, null);
        QMUIRoundButton qMUIRoundButton2 = getBd().btnBottom;
        Intrinsics.checkNotNullExpressionValue(qMUIRoundButton2, "bd.btnBottom");
        ViewKt.click$default(qMUIRoundButton2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.album.AlbumTracksFragment.initView.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                recyclerView.scrollToPosition(this.tracks.size() - 1);
            }
        }, 1, null);
        QMUIRoundButton qMUIRoundButton3 = getBd().btnCurrent;
        Intrinsics.checkNotNullExpressionValue(qMUIRoundButton3, "bd.btnCurrent");
        ViewKt.click$default(qMUIRoundButton3, 0, new Function0<Unit>() { // from class: com.funny.audio.view.album.AlbumTracksFragment.initView.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (AlbumTracksFragment.this.currentPlaySort != -1) {
                    if (AlbumTracksFragment.this.ascending) {
                        recyclerView.scrollToPosition(AlbumTracksFragment.this.currentPlaySort);
                    } else {
                        recyclerView.scrollToPosition(AlbumTracksFragment.this.tracks.size() - AlbumTracksFragment.this.currentPlaySort);
                    }
                }
            }
        }, 1, null);
        EventBus.getDefault().register(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(AlbumTracksFragment this$0, RecyclerView rvTracks, RecyclerView rvTrackSelections, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rvTracks, "$rvTracks");
        Intrinsics.checkNotNullParameter(rvTrackSelections, "$rvTrackSelections");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        TrackSelectionInfo trackSelectionInfo = this$0.trackSelections.get(i);
        if (this$0.ascending) {
            rvTracks.scrollToPosition(trackSelectionInfo.getStart());
        } else {
            rvTracks.scrollToPosition(this$0.tracks.size() - trackSelectionInfo.getStart());
        }
        rvTrackSelections.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(AlbumTracksFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        AlbumTrackInfo albumTrackInfo = this$0.tracks.get(i);
        List mutableList = CollectionsKt.toMutableList((Collection) this$0.tracks);
        if (!this$0.ascending) {
            CollectionsKt.reverse(mutableList);
        }
        MediaPlayerManager mediaPlayerManager = MediaPlayerManager.INSTANCE;
        AlbumDetailInfo albumDetailInfo = this$0.albumDetailInfo;
        Intrinsics.checkNotNull(albumDetailInfo);
        mediaPlayerManager.playAlbumTrack(albumDetailInfo, mutableList, albumTrackInfo.getSort(), (24 & 8) != 0 ? 0L : 0L, (24 & 16) != 0 ? false : true, (24 & 32) != 0);
        this$0.requireActivity().finish();
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumTracksFragment$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumTracksFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumTracksFragment$initData$1", f = "AlbumTracksFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AlbumTracksFragment.this.new AnonymousClass1(continuation);
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
                this.label = 1;
                if (AlbumTracksFragment.this.loadData(this) == coroutine_suspended) {
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

    @Override // com.funny.audio.view.core.BaseFragment
    public void initData() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void releaseView() {
        EventBus.getDefault().unregister(this);
        super.releaseView();
    }

    private final void initState() {
        StateLayout stateLayout = getBd().state;
        stateLayout.setEmptyLayout(R.layout.page_state_empty);
        stateLayout.setLoadingLayout(R.layout.page_state_loading);
        stateLayout.setErrorLayout(R.layout.page_state_error);
        getBd().state.onError(new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumTracksFragment$initState$2, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumTracksFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function2<View, Object, Unit> {
        AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, Object obj) {
            invoke2(view, obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View onError, Object obj) {
            Intrinsics.checkNotNullParameter(onError, "$this$onError");
            View viewFindViewById = onError.findViewById(R.id.btnPageRetry);
            final AlbumTracksFragment albumTracksFragment = AlbumTracksFragment.this;
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.funny.audio.view.album.AlbumTracksFragment$initState$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlbumTracksFragment.AnonymousClass2.invoke$lambda$0(albumTracksFragment, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(AlbumTracksFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AlbumTracksFragment$initState$2$1$1(this$0, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1 A[Catch: Exception -> 0x004c, TryCatch #0 {Exception -> 0x004c, blocks: (B:18:0x0048, B:26:0x0097, B:28:0x00a1, B:30:0x00ba, B:46:0x0181, B:47:0x01a6), top: B:54:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0134 A[Catch: Exception -> 0x01cc, TryCatch #1 {Exception -> 0x01cc, blocks: (B:13:0x0037, B:34:0x0130, B:36:0x0134, B:37:0x014d, B:39:0x0153, B:43:0x0164, B:44:0x0168), top: B:55:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a6 A[Catch: Exception -> 0x004c, TRY_LEAVE, TryCatch #0 {Exception -> 0x004c, blocks: (B:18:0x0048, B:26:0x0097, B:28:0x00a1, B:30:0x00ba, B:46:0x0181, B:47:0x01a6), top: B:54:0x0048 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadData(kotlin.coroutines.Continuation<? super kotlin.Unit> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.album.AlbumTracksFragment.loadData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final List<TrackSelectionInfo> tracksToSelections(List<AlbumTrackInfo> tracks) {
        List<List> listChunked = CollectionsKt.chunked(tracks, 50);
        ArrayList arrayList = new ArrayList();
        for (List list : listChunked) {
            AlbumTrackInfo albumTrackInfo = (AlbumTrackInfo) CollectionsKt.first(list);
            AlbumTrackInfo albumTrackInfo2 = (AlbumTrackInfo) CollectionsKt.last(list);
            TrackSelectionInfo trackSelectionInfo = new TrackSelectionInfo(0, 0, false, 7, null);
            trackSelectionInfo.setStart(albumTrackInfo.getSort());
            trackSelectionInfo.setEnd(albumTrackInfo2.getSort());
            trackSelectionInfo.setCurrent(false);
            arrayList.add(trackSelectionInfo);
        }
        return arrayList;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(UpdatePlayerEvent updatePlayerEvent) {
        Intrinsics.checkNotNullParameter(updatePlayerEvent, "updatePlayerEvent");
        loadDataFromManager();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onMessageEvent(PlayAlbumTrackEvent playAlbumTrackEvent) {
        Object next;
        Intrinsics.checkNotNullParameter(playAlbumTrackEvent, "playAlbumTrackEvent");
        if (!this.tracks.isEmpty() && Intrinsics.areEqual(this.albumId, playAlbumTrackEvent.getAlbumId()) && Intrinsics.areEqual(playAlbumTrackEvent.getType(), PlayAlbumTrackType.INSTANCE.getBY_ALBUM_DETAIL())) {
            Iterator<T> it = this.tracks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((AlbumTrackInfo) next).getSort() == playAlbumTrackEvent.getTrackIndex()) {
                        break;
                    }
                }
            }
            AlbumTrackInfo albumTrackInfo = (AlbumTrackInfo) next;
            int sort = albumTrackInfo != null ? albumTrackInfo.getSort() : 0;
            MediaPlayerManager mediaPlayerManager = MediaPlayerManager.INSTANCE;
            AlbumDetailInfo albumDetailInfo = this.albumDetailInfo;
            Intrinsics.checkNotNull(albumDetailInfo);
            mediaPlayerManager.playAlbumTrack(albumDetailInfo, this.tracks, sort, (24 & 8) != 0 ? 0L : 0L, (24 & 16) != 0 ? false : true, (24 & 32) != 0 ? true : true);
            requireActivity().finish();
        }
    }

    private final void loadDataFromManager() {
        AlbumTrackInfo currentAlbumTrackInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumTrackInfo();
        AlbumDetailInfo currentAlbumDetailInfo = MediaPlayerManager.INSTANCE.getCurrentAlbumDetailInfo();
        if (currentAlbumTrackInfo == null || currentAlbumDetailInfo == null) {
            return;
        }
        try {
            if (Intrinsics.areEqual(currentAlbumDetailInfo.getId(), this.albumId)) {
                if (this.isPlaying != MediaPlayerManager.INSTANCE.isPlaying()) {
                    this.isPlaying = MediaPlayerManager.INSTANCE.isPlaying();
                    for (AlbumTrackInfo albumTrackInfo : this.tracks) {
                        albumTrackInfo.setPlaying(albumTrackInfo.getSort() == this.currentPlaySort && this.isPlaying);
                    }
                    this.tracksAdapter.notifyDataSetChanged();
                }
                if (currentAlbumTrackInfo.getSort() != this.currentPlaySort) {
                    this.currentPlaySort = currentAlbumTrackInfo.getSort();
                    for (AlbumTrackInfo albumTrackInfo2 : this.tracks) {
                        albumTrackInfo2.setCurrent(albumTrackInfo2.getSort() == this.currentPlaySort);
                        albumTrackInfo2.setPlaying(albumTrackInfo2.getSort() == this.currentPlaySort && this.isPlaying);
                    }
                    this.tracksAdapter.notifyDataSetChanged();
                }
            }
        } catch (Exception unused) {
        }
    }
}
