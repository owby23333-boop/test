package com.funny.audio.view.player;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.funny.audio.UpdatePlayerEvent;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.database.DbContext;
import com.funny.audio.database.dao.PlayHistoryDao;
import com.funny.audio.database.entities.PlayHistoryEntity;
import com.funny.audio.databinding.FragmentAlbumTrackListBinding;
import com.funny.audio.media_player.MediaPlayerManager;
import com.funny.audio.models.AlbumDetailInfo;
import com.funny.audio.models.AlbumTrackInfo;
import com.funny.audio.models.TrackSelectionInfo;
import com.funny.audio.view.adapters.AlbumTrackAdapter;
import com.funny.audio.view.adapters.TrackSelectionAdapter;
import com.funny.audio.view.core.BaseBottomSheetDialogFragment;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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

/* JADX INFO: compiled from: TrackListFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0007J\b\u0010%\u001a\u00020\u001dH\u0016J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/funny/audio/view/player/TrackListFragment;", "Lcom/funny/audio/view/core/BaseBottomSheetDialogFragment;", "Lcom/funny/audio/databinding/FragmentAlbumTrackListBinding;", "()V", "albumDetailInfo", "Lcom/funny/audio/models/AlbumDetailInfo;", "getAlbumDetailInfo", "()Lcom/funny/audio/models/AlbumDetailInfo;", "setAlbumDetailInfo", "(Lcom/funny/audio/models/AlbumDetailInfo;)V", "ascending", "", "currentPlaySort", "", "isPlaying", "trackSelectionAdapter", "Lcom/funny/audio/view/adapters/TrackSelectionAdapter;", "trackSelections", "", "Lcom/funny/audio/models/TrackSelectionInfo;", "tracks", "Lcom/funny/audio/models/AlbumTrackInfo;", "getTracks", "()Ljava/util/List;", "setTracks", "(Ljava/util/List;)V", "tracksAdapter", "Lcom/funny/audio/view/adapters/AlbumTrackAdapter;", "initData", "", "initView", "view", "Landroid/view/View;", "loadDataFromManager", "onMessageEvent", "updatePlayerEvent", "Lcom/funny/audio/UpdatePlayerEvent;", "releaseView", "tracksToSelections", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrackListFragment extends BaseBottomSheetDialogFragment<FragmentAlbumTrackListBinding> {
    private AlbumDetailInfo albumDetailInfo;
    private boolean isPlaying;
    private List<AlbumTrackInfo> tracks = new ArrayList();
    private final AlbumTrackAdapter tracksAdapter = new AlbumTrackAdapter();
    private final TrackSelectionAdapter trackSelectionAdapter = new TrackSelectionAdapter();
    private List<TrackSelectionInfo> trackSelections = new ArrayList();
    private boolean ascending = true;
    private int currentPlaySort = -1;

    public static final /* synthetic */ FragmentAlbumTrackListBinding access$getBd(TrackListFragment trackListFragment) {
        return trackListFragment.getBd();
    }

    public final AlbumDetailInfo getAlbumDetailInfo() {
        return this.albumDetailInfo;
    }

    public final void setAlbumDetailInfo(AlbumDetailInfo albumDetailInfo) {
        this.albumDetailInfo = albumDetailInfo;
    }

    public final List<AlbumTrackInfo> getTracks() {
        return this.tracks;
    }

    public final void setTracks(List<AlbumTrackInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tracks = list;
    }

    @Override // com.funny.audio.view.core.BaseBottomSheetDialogFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.initView(view);
        List<AlbumTrackInfo> list = this.tracks;
        if (list.size() > 1) {
            CollectionsKt.sortWith(list, new Comparator() { // from class: com.funny.audio.view.player.TrackListFragment$initView$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((AlbumTrackInfo) t).getSort()), Integer.valueOf(((AlbumTrackInfo) t2).getSort()));
                }
            });
        }
        getBd().tvTrackCount.setText("共" + this.tracks.size() + "集");
        final RecyclerView recyclerView = getBd().rvTracks;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "bd.rvTracks");
        final RecyclerView recyclerView2 = getBd().rvTrackSelections;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "bd.rvTrackSelections");
        List<TrackSelectionInfo> listTracksToSelections = tracksToSelections(this.tracks);
        this.trackSelections = listTracksToSelections;
        this.trackSelectionAdapter.submitList(listTracksToSelections);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.trackSelectionAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.player.TrackListFragment$$ExternalSyntheticLambda0
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                TrackListFragment.initView$lambda$1(this.f$0, recyclerView, recyclerView2, baseQuickAdapter, view2, i);
            }
        }, 1, null);
        recyclerView2.setAdapter(this.trackSelectionAdapter);
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 3));
        this.tracksAdapter.submitList(this.tracks);
        this.tracksAdapter.setItemAnimation(BaseQuickAdapter.AnimationType.SlideInRight);
        this.tracksAdapter.setAnimationEnable(true);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.tracksAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.player.TrackListFragment$$ExternalSyntheticLambda1
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                TrackListFragment.initView$lambda$2(this.f$0, baseQuickAdapter, view2, i);
            }
        }, 1, null);
        recyclerView.setAdapter(this.tracksAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.funny.audio.view.player.TrackListFragment.initView.4
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
                    Iterator it = TrackListFragment.this.trackSelections.iterator();
                    while (it.hasNext()) {
                        ((TrackSelectionInfo) it.next()).setCurrent(false);
                    }
                    TrackSelectionInfo trackSelectionInfo = (TrackSelectionInfo) CollectionsKt.getOrNull(TrackListFragment.this.trackSelections, iFindLastVisibleItemPosition / 50);
                    if (trackSelectionInfo != null) {
                        trackSelectionInfo.setCurrent(true);
                        TrackListFragment.this.trackSelectionAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
        LinearLayout linearLayout = getBd().lyTrackAscending;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "bd.lyTrackAscending");
        ViewKt.click$default(linearLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackListFragment.initView.5
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
                if (CollectionsKt.any(TrackListFragment.this.getTracks())) {
                    if (TrackListFragment.this.ascending) {
                        TrackListFragment.access$getBd(TrackListFragment.this).tvTrackAscending.setText("倒序");
                    } else {
                        TrackListFragment.access$getBd(TrackListFragment.this).tvTrackAscending.setText("正序");
                    }
                    CollectionsKt.reverse(TrackListFragment.this.getTracks());
                    CollectionsKt.reverse(TrackListFragment.this.trackSelections);
                    TrackListFragment.this.ascending = !r0.ascending;
                    TrackListFragment.this.tracksAdapter.notifyDataSetChanged();
                    TrackListFragment.this.trackSelectionAdapter.notifyDataSetChanged();
                }
            }
        }, 1, null);
        LinearLayout linearLayout2 = getBd().lyTrackSelections;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "bd.lyTrackSelections");
        ViewKt.click$default(linearLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackListFragment.initView.6
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
        ViewKt.click$default(qMUIRoundButton, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackListFragment.initView.7
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
        ViewKt.click$default(qMUIRoundButton2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackListFragment.initView.8
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
                recyclerView.scrollToPosition(this.getTracks().size() - 1);
            }
        }, 1, null);
        QMUIRoundButton qMUIRoundButton3 = getBd().btnCurrent;
        Intrinsics.checkNotNullExpressionValue(qMUIRoundButton3, "bd.btnCurrent");
        ViewKt.click$default(qMUIRoundButton3, 0, new Function0<Unit>() { // from class: com.funny.audio.view.player.TrackListFragment.initView.9
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
                if (TrackListFragment.this.currentPlaySort != -1) {
                    if (TrackListFragment.this.ascending) {
                        recyclerView.scrollToPosition(TrackListFragment.this.currentPlaySort);
                    } else {
                        recyclerView.scrollToPosition(TrackListFragment.this.getTracks().size() - TrackListFragment.this.currentPlaySort);
                    }
                }
            }
        }, 1, null);
        getBd().btnTop.setVisibility(0);
        getBd().btnBottom.setVisibility(0);
        EventBus.getDefault().register(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(TrackListFragment this$0, RecyclerView rvTracks, RecyclerView rvTrackSelections, BaseQuickAdapter adapter, View view, int i) {
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
    public static final void initView$lambda$2(TrackListFragment this$0, BaseQuickAdapter adapter, View view, int i) {
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
        this$0.dismiss();
    }

    @Override // com.funny.audio.view.core.BaseBottomSheetDialogFragment
    public void releaseView() {
        EventBus.getDefault().unregister(this);
        super.releaseView();
    }

    @Override // com.funny.audio.view.core.BaseBottomSheetDialogFragment
    public void initData() {
        super.initData();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.player.TrackListFragment$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrackListFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.player.TrackListFragment$initData$1", f = "TrackListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TrackListFragment.this.new AnonymousClass1(continuation);
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
            PlayHistoryDao playHistoryDaoPlayHistory = DbContext.INSTANCE.getCurrent().playHistory();
            AlbumDetailInfo albumDetailInfo = TrackListFragment.this.getAlbumDetailInfo();
            Intrinsics.checkNotNull(albumDetailInfo);
            PlayHistoryEntity playHistoryEntityAlbum = playHistoryDaoPlayHistory.album(albumDetailInfo.getId());
            if (playHistoryEntityAlbum != null) {
                TrackListFragment.this.currentPlaySort = playHistoryEntityAlbum.getTrackIndex();
                TrackListFragment.access$getBd(TrackListFragment.this).btnCurrent.setVisibility(0);
                List<AlbumTrackInfo> tracks = TrackListFragment.this.getTracks();
                TrackListFragment trackListFragment = TrackListFragment.this;
                for (AlbumTrackInfo albumTrackInfo : tracks) {
                    albumTrackInfo.setCurrent(albumTrackInfo.getSort() == trackListFragment.currentPlaySort);
                }
            }
            TrackListFragment.this.trackSelectionAdapter.notifyDataSetChanged();
            TrackListFragment.this.tracksAdapter.notifyDataSetChanged();
            return Unit.INSTANCE;
        }
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
            String id = currentAlbumDetailInfo.getId();
            AlbumDetailInfo albumDetailInfo = this.albumDetailInfo;
            Intrinsics.checkNotNull(albumDetailInfo);
            if (Intrinsics.areEqual(id, albumDetailInfo.getId())) {
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
}
