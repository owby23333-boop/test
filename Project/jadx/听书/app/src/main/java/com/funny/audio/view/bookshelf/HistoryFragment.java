package com.funny.audio.view.bookshelf;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.QuickAdapterHelper;
import com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.drake.statelayout.StateLayout;
import com.funny.audio.PlayAlbumTrackEvent;
import com.funny.audio.PlayAlbumTrackType;
import com.funny.audio.R;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.PlayHistoryEntity;
import com.funny.audio.databinding.FragmentHistoryBinding;
import com.funny.audio.view.adapters.HistoryAlbumAdapter;
import com.funny.audio.view.bookshelf.HistoryFragment;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.core.LinearSpacingItemDecoration;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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

/* JADX INFO: compiled from: HistoryFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0011\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0011\u0010\u0019\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0011\u0010\u001b\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\b\u0010\u001c\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/funny/audio/view/bookshelf/HistoryFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentHistoryBinding;", "()V", "adapter", "Lcom/funny/audio/view/adapters/HistoryAlbumAdapter;", "filterType", "", "helper", "Lcom/chad/library/adapter4/QuickAdapterHelper;", "isEditMode", "", "page", "pageSize", "selectedAlbumIds", "", "", "deleteHistory", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayFilter", "initData", "initView", "view", "Landroid/view/View;", "loadHistoryAlbums", "onResume", "refreshData", "updateBottomTabState", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HistoryFragment extends BaseFragment<FragmentHistoryBinding> {
    private QuickAdapterHelper helper;
    private boolean isEditMode;
    private HistoryAlbumAdapter adapter = new HistoryAlbumAdapter();
    private int filterType = FilterHistoryType.INSTANCE.getAll();
    private int page = 1;
    private int pageSize = 15;
    private Set<String> selectedAlbumIds = new LinkedHashSet();

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$deleteHistory$1, reason: invalid class name */
    /* JADX INFO: compiled from: HistoryFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment", f = "HistoryFragment.kt", i = {}, l = {224}, m = "deleteHistory", n = {}, s = {})
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
            return HistoryFragment.this.deleteHistory(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$loadHistoryAlbums$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HistoryFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment", f = "HistoryFragment.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD}, m = "loadHistoryAlbums", n = {"this"}, s = {"L$0"})
    static final class C05941 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05941(Continuation<? super C05941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HistoryFragment.this.loadHistoryAlbums(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$refreshData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HistoryFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment", f = "HistoryFragment.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT}, m = "refreshData", n = {"this"}, s = {"L$0"})
    static final class C05961 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05961(Continuation<? super C05961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HistoryFragment.this.refreshData(this);
        }
    }

    public static final /* synthetic */ FragmentHistoryBinding access$getBd(HistoryFragment historyFragment) {
        return historyFragment.getBd();
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        StateLayout stateLayout = getBd().state;
        stateLayout.setLoadingLayout(-1);
        stateLayout.setEmptyLayout(R.layout.page_state_empty);
        stateLayout.setErrorLayout(R.layout.page_state_error);
        getBd().state.onError(new C05932());
        getBd().refreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.funny.audio.view.bookshelf.HistoryFragment$$ExternalSyntheticLambda0
            @Override // com.scwang.smart.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(RefreshLayout refreshLayout) {
                HistoryFragment.initView$lambda$1(this.f$0, refreshLayout);
            }
        });
        final HistoryAlbumAdapter historyAlbumAdapter = this.adapter;
        HistoryAlbumAdapter historyAlbumAdapter2 = historyAlbumAdapter;
        ItemClickUtilsKt.setOnDebouncedItemClick$default(historyAlbumAdapter2, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.bookshelf.HistoryFragment$$ExternalSyntheticLambda1
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                HistoryFragment.initView$lambda$3(this.f$0, baseQuickAdapter, view2, i);
            }
        }, 1, null);
        RecyclerView recyclerView = getBd().rvHistory;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "bd.rvHistory");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        recyclerView.addItemDecoration(new LinearSpacingItemDecoration(contextRequireContext, 8.0f, 0.0f, 1));
        QuickAdapterHelper quickAdapterHelperBuild = new QuickAdapterHelper.Builder(historyAlbumAdapter2).setTrailingLoadStateAdapter(new TrailingLoadStateAdapter.OnTrailingListener() { // from class: com.funny.audio.view.bookshelf.HistoryFragment$initView$helper$1
            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onFailRetry() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HistoryFragment$initView$helper$1$onFailRetry$1(this.this$0, null), 3, null);
            }

            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onLoad() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HistoryFragment$initView$helper$1$onLoad$1(this.this$0, null), 3, null);
            }

            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public boolean isAllowLoading() {
                return !HistoryFragment.access$getBd(this.this$0).refreshLayout.isRefreshing();
            }
        }).build();
        recyclerView.setAdapter(quickAdapterHelperBuild.getMAdapter());
        this.helper = quickAdapterHelperBuild;
        QMUIFrameLayout qMUIFrameLayout = getBd().lyFilterAll;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.lyFilterAll");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.HistoryFragment.initView.5
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
                HistoryFragment.this.filterType = FilterHistoryType.INSTANCE.getAll();
                HistoryFragment.this.displayFilter();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(HistoryFragment.this, null), 3, null);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$initView$5$1, reason: invalid class name */
            /* JADX INFO: compiled from: HistoryFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment$initView$5$1", f = "HistoryFragment.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ HistoryFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(HistoryFragment historyFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = historyFragment;
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
                        this.label = 1;
                        if (this.this$0.refreshData(this) == coroutine_suspended) {
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
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout2 = getBd().lyFilterToday;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout2, "bd.lyFilterToday");
        ViewKt.click$default(qMUIFrameLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.HistoryFragment.initView.6
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
                HistoryFragment.this.filterType = FilterHistoryType.INSTANCE.getToday();
                HistoryFragment.this.displayFilter();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(HistoryFragment.this, null), 3, null);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$initView$6$1, reason: invalid class name */
            /* JADX INFO: compiled from: HistoryFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment$initView$6$1", f = "HistoryFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ HistoryFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(HistoryFragment historyFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = historyFragment;
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
                        this.label = 1;
                        if (this.this$0.refreshData(this) == coroutine_suspended) {
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
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout3 = getBd().lyFilterYesterday;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout3, "bd.lyFilterYesterday");
        ViewKt.click$default(qMUIFrameLayout3, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.HistoryFragment.initView.7
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
                HistoryFragment.this.filterType = FilterHistoryType.INSTANCE.getYesterday();
                HistoryFragment.this.displayFilter();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(HistoryFragment.this, null), 3, null);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$initView$7$1, reason: invalid class name */
            /* JADX INFO: compiled from: HistoryFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment$initView$7$1", f = "HistoryFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SPADE}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ HistoryFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(HistoryFragment historyFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = historyFragment;
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
                        this.label = 1;
                        if (this.this$0.refreshData(this) == coroutine_suspended) {
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
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout4 = getBd().lyFilterEarlier;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout4, "bd.lyFilterEarlier");
        ViewKt.click$default(qMUIFrameLayout4, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.HistoryFragment.initView.8
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
                HistoryFragment.this.filterType = FilterHistoryType.INSTANCE.getEarlier();
                HistoryFragment.this.displayFilter();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(HistoryFragment.this, null), 3, null);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$initView$8$1, reason: invalid class name */
            /* JADX INFO: compiled from: HistoryFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment$initView$8$1", f = "HistoryFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ HistoryFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(HistoryFragment historyFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = historyFragment;
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
                        this.label = 1;
                        if (this.this$0.refreshData(this) == coroutine_suspended) {
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
        }, 1, null);
        TextView textView = getBd().tvEdit;
        Intrinsics.checkNotNullExpressionValue(textView, "bd.tvEdit");
        ViewKt.click$default(textView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.HistoryFragment.initView.9
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
                HistoryFragment.this.isEditMode = !r0.isEditMode;
                if (HistoryFragment.this.isEditMode) {
                    HistoryFragment.access$getBd(HistoryFragment.this).tvEdit.setText("完成");
                    HistoryFragment.access$getBd(HistoryFragment.this).lyEditBottomTab.setVisibility(0);
                    HistoryFragment.this.selectedAlbumIds.clear();
                } else {
                    HistoryFragment.access$getBd(HistoryFragment.this).tvEdit.setText("编辑");
                    HistoryFragment.access$getBd(HistoryFragment.this).lyEditBottomTab.setVisibility(8);
                }
                List<PlayHistoryEntity> items = historyAlbumAdapter.getItems();
                HistoryFragment historyFragment = HistoryFragment.this;
                for (PlayHistoryEntity playHistoryEntity : items) {
                    playHistoryEntity.setEditMode(historyFragment.isEditMode);
                    playHistoryEntity.setSelected(false);
                }
                historyAlbumAdapter.notifyDataSetChanged();
                HistoryFragment.this.updateBottomTabState();
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout5 = getBd().btnSelectAll;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout5, "bd.btnSelectAll");
        ViewKt.click$default(qMUIFrameLayout5, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.HistoryFragment.initView.10
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
                List<PlayHistoryEntity> list = CollectionsKt.toList(historyAlbumAdapter.getItems());
                if (list.isEmpty()) {
                    return;
                }
                if (this.selectedAlbumIds.size() == list.size()) {
                    HistoryFragment historyFragment = this;
                    for (PlayHistoryEntity playHistoryEntity : list) {
                        playHistoryEntity.setSelected(false);
                        historyFragment.selectedAlbumIds.remove(playHistoryEntity.getAlbumId());
                    }
                } else {
                    HistoryFragment historyFragment2 = this;
                    for (PlayHistoryEntity playHistoryEntity2 : list) {
                        playHistoryEntity2.setSelected(true);
                        historyFragment2.selectedAlbumIds.add(playHistoryEntity2.getAlbumId());
                    }
                }
                historyAlbumAdapter.notifyDataSetChanged();
                this.updateBottomTabState();
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout6 = getBd().btnDeleteHistory;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout6, "bd.btnDeleteHistory");
        ViewKt.click$default(qMUIFrameLayout6, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.HistoryFragment.initView.11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$initView$11$1, reason: invalid class name */
            /* JADX INFO: compiled from: HistoryFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment$initView$11$1", f = "HistoryFragment.kt", i = {}, l = {205, 206}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ HistoryAlbumAdapter $adapter;
                int label;
                final /* synthetic */ HistoryFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(HistoryFragment historyFragment, HistoryAlbumAdapter historyAlbumAdapter, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = historyFragment;
                    this.$adapter = historyAlbumAdapter;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$adapter, continuation);
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
                        if (this.this$0.deleteHistory(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            this.$adapter.notifyDataSetChanged();
                            this.this$0.updateBottomTabState();
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    this.label = 2;
                    if (this.this$0.refreshData(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.$adapter.notifyDataSetChanged();
                    this.this$0.updateBottomTabState();
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (!HistoryFragment.this.selectedAlbumIds.isEmpty()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(HistoryFragment.this, historyAlbumAdapter, null), 3, null);
                }
            }
        }, 1, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$initView$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HistoryFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C05932 extends Lambda implements Function2<View, Object, Unit> {
        C05932() {
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
            final HistoryFragment historyFragment = HistoryFragment.this;
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.funny.audio.view.bookshelf.HistoryFragment$initView$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistoryFragment.C05932.invoke$lambda$0(historyFragment, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(HistoryFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HistoryFragment$initView$2$1$1(this$0, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HistoryFragment this$0, RefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HistoryFragment$initView$3$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(HistoryFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        PlayHistoryEntity playHistoryEntity = (PlayHistoryEntity) adapter.getItem(i);
        if (playHistoryEntity != null) {
            String albumId = playHistoryEntity.getAlbumId();
            if (this$0.isEditMode) {
                playHistoryEntity.setSelected(!playHistoryEntity.getIsSelected());
                if (this$0.selectedAlbumIds.contains(albumId)) {
                    this$0.selectedAlbumIds.remove(albumId);
                } else {
                    this$0.selectedAlbumIds.add(albumId);
                }
                adapter.notifyDataSetChanged();
                this$0.updateBottomTabState();
                return;
            }
            PlayAlbumTrackEvent playAlbumTrackEvent = new PlayAlbumTrackEvent();
            playAlbumTrackEvent.setType(PlayAlbumTrackType.INSTANCE.getBY_HISTORY());
            playAlbumTrackEvent.setAlbumId(albumId);
            playAlbumTrackEvent.setTrackIndex(playHistoryEntity.getTrackIndex());
            EventBus.getDefault().post(playAlbumTrackEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteHistory(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.bookshelf.HistoryFragment.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.bookshelf.HistoryFragment$deleteHistory$1 r0 = (com.funny.audio.view.bookshelf.HistoryFragment.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.bookshelf.HistoryFragment$deleteHistory$1 r0 = new com.funny.audio.view.bookshelf.HistoryFragment$deleteHistory$1
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
            com.funny.audio.view.bookshelf.HistoryFragment$deleteHistory$2 r11 = new com.funny.audio.view.bookshelf.HistoryFragment$deleteHistory$2     // Catch: java.lang.Exception -> L59
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
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.bookshelf.HistoryFragment.deleteHistory(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$deleteHistory$2, reason: invalid class name */
    /* JADX INFO: compiled from: HistoryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment$deleteHistory$2", f = "HistoryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HistoryFragment.this.new AnonymousClass2(continuation);
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
                List<String> list = CollectionsKt.toList(HistoryFragment.this.selectedAlbumIds);
                HistoryFragment historyFragment = HistoryFragment.this;
                for (String str : list) {
                    DbContext.INSTANCE.getCurrent().playHistory().remove(str);
                    historyFragment.selectedAlbumIds.remove(str);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$initData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HistoryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment$initData$1", f = "HistoryFragment.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
    static final class C05921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05921(Continuation<? super C05921> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HistoryFragment.this.new C05921(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (HistoryFragment.this.refreshData(this) == coroutine_suspended) {
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
        displayFilter();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05921(null), 3, null);
    }

    @Override // com.funny.audio.view.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05951(null), 3, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.HistoryFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HistoryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.HistoryFragment$onResume$1", f = "HistoryFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE}, m = "invokeSuspend", n = {}, s = {})
    static final class C05951 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05951(Continuation<? super C05951> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HistoryFragment.this.new C05951(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05951) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (HistoryFragment.this.refreshData(this) == coroutine_suspended) {
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
    public final java.lang.Object refreshData(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.funny.audio.view.bookshelf.HistoryFragment.C05961
            if (r0 == 0) goto L14
            r0 = r5
            com.funny.audio.view.bookshelf.HistoryFragment$refreshData$1 r0 = (com.funny.audio.view.bookshelf.HistoryFragment.C05961) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.funny.audio.view.bookshelf.HistoryFragment$refreshData$1 r0 = new com.funny.audio.view.bookshelf.HistoryFragment$refreshData$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.bookshelf.HistoryFragment r0 = (com.funny.audio.view.bookshelf.HistoryFragment) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4b
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r4.page = r3
            r5 = 15
            r4.pageSize = r5
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.loadHistoryAlbums(r0)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            r0 = r4
        L4b:
            androidx.viewbinding.ViewBinding r5 = r0.getBd()
            com.funny.audio.databinding.FragmentHistoryBinding r5 = (com.funny.audio.databinding.FragmentHistoryBinding) r5
            com.scwang.smart.refresh.layout.SmartRefreshLayout r5 = r5.refreshLayout
            r5.finishRefresh()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.bookshelf.HistoryFragment.refreshData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071 A[Catch: Exception -> 0x00df, LOOP:0: B:22:0x006b->B:24:0x0071, LOOP_END, TryCatch #0 {Exception -> 0x00df, blocks: (B:12:0x002d, B:21:0x0062, B:22:0x006b, B:24:0x0071, B:25:0x007d, B:27:0x0087, B:29:0x008b, B:31:0x00a6, B:30:0x009f, B:32:0x00bc, B:34:0x00c0, B:35:0x00ce), top: B:44:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087 A[Catch: Exception -> 0x00df, TryCatch #0 {Exception -> 0x00df, blocks: (B:12:0x002d, B:21:0x0062, B:22:0x006b, B:24:0x0071, B:25:0x007d, B:27:0x0087, B:29:0x008b, B:31:0x00a6, B:30:0x009f, B:32:0x00bc, B:34:0x00c0, B:35:0x00ce), top: B:44:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bc A[Catch: Exception -> 0x00df, TryCatch #0 {Exception -> 0x00df, blocks: (B:12:0x002d, B:21:0x0062, B:22:0x006b, B:24:0x0071, B:25:0x007d, B:27:0x0087, B:29:0x008b, B:31:0x00a6, B:30:0x009f, B:32:0x00bc, B:34:0x00c0, B:35:0x00ce), top: B:44:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadHistoryAlbums(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.bookshelf.HistoryFragment.loadHistoryAlbums(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayFilter() {
        int i = this.filterType;
        if (i == FilterHistoryType.INSTANCE.getAll()) {
            getBd().lyFilterAll.setBackgroundResource(R.color.filter_box_background_selected_color);
            getBd().tvFilterAll.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_selected_color));
            getBd().lyFilterToday.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterToday.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterYesterday.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterYesterday.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterEarlier.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterEarlier.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            return;
        }
        if (i == FilterHistoryType.INSTANCE.getToday()) {
            getBd().lyFilterAll.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterAll.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterToday.setBackgroundResource(R.color.filter_box_background_selected_color);
            getBd().tvFilterToday.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_selected_color));
            getBd().lyFilterYesterday.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterYesterday.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterEarlier.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterEarlier.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            return;
        }
        if (i == FilterHistoryType.INSTANCE.getYesterday()) {
            getBd().lyFilterAll.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterAll.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterToday.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterToday.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterYesterday.setBackgroundResource(R.color.filter_box_background_selected_color);
            getBd().tvFilterYesterday.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_selected_color));
            getBd().lyFilterEarlier.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterEarlier.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            return;
        }
        if (i == FilterHistoryType.INSTANCE.getEarlier()) {
            getBd().lyFilterAll.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterAll.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterToday.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterToday.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterYesterday.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterYesterday.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterEarlier.setBackgroundResource(R.color.filter_box_background_selected_color);
            getBd().tvFilterEarlier.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_selected_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBottomTabState() {
        if (CollectionsKt.any(this.selectedAlbumIds)) {
            getBd().tvDeleteHistory.setText("删除(" + this.selectedAlbumIds.size() + ")");
        } else {
            getBd().tvDeleteHistory.setText("删除");
        }
        List list = CollectionsKt.toList(this.adapter.getItems());
        if ((!list.isEmpty()) && this.selectedAlbumIds.size() == list.size()) {
            getBd().tvSelectAll.setText("取消全选");
        } else {
            getBd().tvSelectAll.setText("全选");
        }
    }
}
