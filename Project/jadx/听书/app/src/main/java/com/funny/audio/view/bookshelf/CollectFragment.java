package com.funny.audio.view.bookshelf;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.drake.statelayout.StateLayout;
import com.funny.audio.PlayAlbumTrackEvent;
import com.funny.audio.PlayAlbumTrackType;
import com.funny.audio.R;
import com.funny.audio.ad.AdManager;
import com.funny.audio.ad.AdSetting;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.BookshelfEntity;
import com.funny.audio.databinding.FragmentCollectBinding;
import com.funny.audio.view.adapters.CollectAlbumAdapter;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.core.GridSpacingItemDecoration;
import com.funny.audio.view.mine.PureModeRewardAdDialog;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.umeng.commonsdk.statistics.UMErrorCode;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: CollectFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\u0015\u001a\u00020\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0011\u0010\u001d\u001a\u00020\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082D¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/funny/audio/view/bookshelf/CollectFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentCollectBinding;", "()V", "adapter", "Lcom/funny/audio/view/adapters/CollectAlbumAdapter;", "bookshelfEntities", "", "Lcom/funny/audio/database/entities/BookshelfEntity;", "canShowPureModeTip", "", "checkUpdateJobRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "filterType", "", "isEditMode", "selectedAlbumIds", "", "", "tagName", "cancelCollect", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayFilter", "initData", "initView", "view", "Landroid/view/View;", "loadCollect", "onResume", "showPureModeTip", "startCheckUpdateJob", "updateBottomTabState", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CollectFragment extends BaseFragment<FragmentCollectBinding> {
    private boolean isEditMode;
    private CollectAlbumAdapter adapter = new CollectAlbumAdapter();
    private List<BookshelfEntity> bookshelfEntities = new ArrayList();
    private int filterType = FilterCollectType.INSTANCE.getRecentlyRead();
    private Set<String> selectedAlbumIds = new LinkedHashSet();
    private final AtomicReference<Job> checkUpdateJobRef = new AtomicReference<>(null);
    private final String tagName = "CollectFragment";
    private boolean canShowPureModeTip = true;

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.CollectFragment$cancelCollect$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment", f = "CollectFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY}, m = "cancelCollect", n = {}, s = {})
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
            return CollectFragment.this.cancelCollect(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.CollectFragment$loadCollect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment", f = "CollectFragment.kt", i = {0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF}, m = "loadCollect", n = {"this"}, s = {"L$0"})
    static final class C05901 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05901(Continuation<? super C05901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CollectFragment.this.loadCollect(this);
        }
    }

    public static final /* synthetic */ FragmentCollectBinding access$getBd(CollectFragment collectFragment) {
        return collectFragment.getBd();
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        StateLayout stateLayout = getBd().state;
        stateLayout.setLoadingLayout(-1);
        stateLayout.setEmptyLayout(R.layout.page_state_empty);
        stateLayout.setErrorLayout(R.layout.page_state_error);
        getBd().refreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.funny.audio.view.bookshelf.CollectFragment$$ExternalSyntheticLambda0
            @Override // com.scwang.smart.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(RefreshLayout refreshLayout) {
                CollectFragment.initView$lambda$1(this.f$0, refreshLayout);
            }
        });
        this.adapter.submitList(this.bookshelfEntities);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.adapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.bookshelf.CollectFragment$$ExternalSyntheticLambda1
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                CollectFragment.initView$lambda$3(this.f$0, baseQuickAdapter, view2, i);
            }
        }, 1, null);
        getBd().rvCollect.setAdapter(this.adapter);
        getBd().rvCollect.setLayoutManager(new GridLayoutManager(getContext(), 3));
        RecyclerView recyclerView = getBd().rvCollect;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(contextRequireContext, 3, 10.0f, 8.0f, 10.0f, false));
        QMUIFrameLayout qMUIFrameLayout = getBd().lyFilterRecentlyCollect;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.lyFilterRecentlyCollect");
        ViewKt.click$default(qMUIFrameLayout, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.CollectFragment.initView.4
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
                CollectFragment.this.filterType = FilterCollectType.INSTANCE.getRecentlyCollect();
                CollectFragment.this.displayFilter();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(CollectFragment.this, null), 3, null);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.CollectFragment$initView$4$1, reason: invalid class name */
            /* JADX INFO: compiled from: CollectFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment$initView$4$1", f = "CollectFragment.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ CollectFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(CollectFragment collectFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = collectFragment;
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
                        if (this.this$0.loadCollect(this) == coroutine_suspended) {
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
        QMUIFrameLayout qMUIFrameLayout2 = getBd().lyFilterRecentlyRead;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout2, "bd.lyFilterRecentlyRead");
        ViewKt.click$default(qMUIFrameLayout2, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.CollectFragment.initView.5
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
                CollectFragment.this.filterType = FilterCollectType.INSTANCE.getRecentlyRead();
                CollectFragment.this.displayFilter();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(CollectFragment.this, null), 3, null);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.CollectFragment$initView$5$1, reason: invalid class name */
            /* JADX INFO: compiled from: CollectFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment$initView$5$1", f = "CollectFragment.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ CollectFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(CollectFragment collectFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = collectFragment;
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
                        if (this.this$0.loadCollect(this) == coroutine_suspended) {
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
        QMUIFrameLayout qMUIFrameLayout3 = getBd().lyFilterRecentlyUpdate;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout3, "bd.lyFilterRecentlyUpdate");
        ViewKt.click$default(qMUIFrameLayout3, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.CollectFragment.initView.6
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
                CollectFragment.this.filterType = FilterCollectType.INSTANCE.getRecentlyUpdate();
                CollectFragment.this.displayFilter();
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(CollectFragment.this, null), 3, null);
            }

            /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.CollectFragment$initView$6$1, reason: invalid class name */
            /* JADX INFO: compiled from: CollectFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment$initView$6$1", f = "CollectFragment.kt", i = {}, l = {UMErrorCode.E_UM_BE_EMPTY_URL_PATH}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ CollectFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(CollectFragment collectFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = collectFragment;
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
                        if (this.this$0.loadCollect(this) == coroutine_suspended) {
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
        ViewKt.click$default(textView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.CollectFragment.initView.7
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
                CollectFragment.this.isEditMode = !r0.isEditMode;
                if (CollectFragment.this.isEditMode) {
                    CollectFragment.access$getBd(CollectFragment.this).tvEdit.setText("完成");
                    CollectFragment.access$getBd(CollectFragment.this).lyEditBottomTab.setVisibility(0);
                    CollectFragment.this.selectedAlbumIds.clear();
                } else {
                    CollectFragment.access$getBd(CollectFragment.this).tvEdit.setText("编辑");
                    CollectFragment.access$getBd(CollectFragment.this).lyEditBottomTab.setVisibility(8);
                }
                List<BookshelfEntity> list = CollectFragment.this.bookshelfEntities;
                CollectFragment collectFragment = CollectFragment.this;
                for (BookshelfEntity bookshelfEntity : list) {
                    bookshelfEntity.setEditMode(collectFragment.isEditMode);
                    bookshelfEntity.setSelected(false);
                }
                CollectFragment.this.adapter.notifyDataSetChanged();
                CollectFragment.this.updateBottomTabState();
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout4 = getBd().btnSelectAll;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout4, "bd.btnSelectAll");
        ViewKt.click$default(qMUIFrameLayout4, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.CollectFragment.initView.8
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
                if (CollectFragment.this.bookshelfEntities.isEmpty()) {
                    return;
                }
                if (CollectFragment.this.selectedAlbumIds.size() == CollectFragment.this.bookshelfEntities.size()) {
                    List<BookshelfEntity> list = CollectFragment.this.bookshelfEntities;
                    CollectFragment collectFragment = CollectFragment.this;
                    for (BookshelfEntity bookshelfEntity : list) {
                        bookshelfEntity.setSelected(false);
                        collectFragment.selectedAlbumIds.remove(bookshelfEntity.getAlbumId());
                    }
                } else {
                    List<BookshelfEntity> list2 = CollectFragment.this.bookshelfEntities;
                    CollectFragment collectFragment2 = CollectFragment.this;
                    for (BookshelfEntity bookshelfEntity2 : list2) {
                        bookshelfEntity2.setSelected(true);
                        collectFragment2.selectedAlbumIds.add(bookshelfEntity2.getAlbumId());
                    }
                }
                CollectFragment.this.adapter.notifyDataSetChanged();
                CollectFragment.this.updateBottomTabState();
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout5 = getBd().btnCancelCollect;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout5, "bd.btnCancelCollect");
        ViewKt.click$default(qMUIFrameLayout5, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.CollectFragment.initView.9
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
                if (!CollectFragment.this.selectedAlbumIds.isEmpty()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(CollectFragment.this, null), 3, null);
                }
            }

            /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.CollectFragment$initView$9$1, reason: invalid class name */
            /* JADX INFO: compiled from: CollectFragment.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment$initView$9$1", f = "CollectFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 172}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ CollectFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(CollectFragment collectFragment, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = collectFragment;
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
                        if (this.this$0.cancelCollect(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            this.this$0.adapter.notifyDataSetChanged();
                            this.this$0.updateBottomTabState();
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    this.label = 2;
                    if (this.this$0.loadCollect(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.this$0.adapter.notifyDataSetChanged();
                    this.this$0.updateBottomTabState();
                    return Unit.INSTANCE;
                }
            }
        }, 1, null);
        QMUIRadiusImageView qMUIRadiusImageView = getBd().btnPureModeClose;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "bd.btnPureModeClose");
        ViewKt.click$default(qMUIRadiusImageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.CollectFragment.initView.10
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
                CollectFragment.this.canShowPureModeTip = false;
                CollectFragment.this.showPureModeTip();
            }
        }, 1, null);
        QMUIFrameLayout qMUIFrameLayout6 = getBd().btnPureMode;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout6, "bd.btnPureMode");
        ViewKt.click$default(qMUIFrameLayout6, 0, new Function0<Unit>() { // from class: com.funny.audio.view.bookshelf.CollectFragment.initView.11
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
                PureModeRewardAdDialog pureModeRewardAdDialog = new PureModeRewardAdDialog();
                FragmentManager parentFragmentManager = CollectFragment.this.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "this.parentFragmentManager");
                pureModeRewardAdDialog.show(parentFragmentManager);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(CollectFragment this$0, RefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CollectFragment$initView$2$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(CollectFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        BookshelfEntity bookshelfEntity = (BookshelfEntity) adapter.getItem(i);
        if (bookshelfEntity != null) {
            String albumId = bookshelfEntity.getAlbumId();
            if (this$0.isEditMode) {
                bookshelfEntity.setSelected(!bookshelfEntity.getIsSelected());
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
            playAlbumTrackEvent.setType(PlayAlbumTrackType.INSTANCE.getBY_COLLECT());
            playAlbumTrackEvent.setAlbumId(albumId);
            playAlbumTrackEvent.setTrackIndex(bookshelfEntity.getTrackIndex());
            EventBus.getDefault().post(playAlbumTrackEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showPureModeTip() {
        try {
            AdSetting setting = AdManager.INSTANCE.getSetting();
            Intrinsics.checkNotNull(setting);
            if (AdManager.INSTANCE.getShow() && setting.getPureModeRewardAd().getShow()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.canShowPureModeTip && setting.getPureTime().getValueLong() < jCurrentTimeMillis) {
                    getBd().lyPureModeTip.setVisibility(0);
                } else {
                    getBd().lyPureModeTip.setVisibility(8);
                }
            }
        } catch (Exception unused) {
            getBd().lyPureModeTip.setVisibility(8);
        }
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
            boolean r0 = r11 instanceof com.funny.audio.view.bookshelf.CollectFragment.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.bookshelf.CollectFragment$cancelCollect$1 r0 = (com.funny.audio.view.bookshelf.CollectFragment.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.bookshelf.CollectFragment$cancelCollect$1 r0 = new com.funny.audio.view.bookshelf.CollectFragment$cancelCollect$1
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
            com.funny.audio.view.bookshelf.CollectFragment$cancelCollect$2 r11 = new com.funny.audio.view.bookshelf.CollectFragment$cancelCollect$2     // Catch: java.lang.Exception -> L59
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
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.bookshelf.CollectFragment.cancelCollect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.CollectFragment$cancelCollect$2, reason: invalid class name */
    /* JADX INFO: compiled from: CollectFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment$cancelCollect$2", f = "CollectFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CollectFragment.this.new AnonymousClass2(continuation);
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
                List<String> list = CollectionsKt.toList(CollectFragment.this.selectedAlbumIds);
                CollectFragment collectFragment = CollectFragment.this;
                for (String str : list) {
                    DbContext.INSTANCE.getCurrent().bookshelf().remove(str);
                    collectFragment.selectedAlbumIds.remove(str);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.funny.audio.view.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        showPureModeTip();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05911(null), 3, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.CollectFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment$onResume$1", f = "CollectFragment.kt", i = {}, l = {225}, m = "invokeSuspend", n = {}, s = {})
    static final class C05911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05911(Continuation<? super C05911> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CollectFragment.this.new C05911(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CollectFragment.this.loadCollect(this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.funny.audio.view.bookshelf.CollectFragment$initData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CollectFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.bookshelf.CollectFragment$initData$1", f = "CollectFragment.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
    static final class C05891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C05891(Continuation<? super C05891> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CollectFragment.this.new C05891(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CollectFragment.this.loadCollect(this) == coroutine_suspended) {
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
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05891(null), 3, null);
        startCheckUpdateJob();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void displayFilter() {
        int i = this.filterType;
        if (i == FilterCollectType.INSTANCE.getRecentlyRead()) {
            getBd().lyFilterRecentlyRead.setBackgroundResource(R.color.filter_box_background_selected_color);
            getBd().tvFilterRecentlyRead.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_selected_color));
            getBd().lyFilterRecentlyCollect.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterRecentlyCollect.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterRecentlyUpdate.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterRecentlyUpdate.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            return;
        }
        if (i == FilterCollectType.INSTANCE.getRecentlyCollect()) {
            getBd().lyFilterRecentlyRead.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterRecentlyRead.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterRecentlyCollect.setBackgroundResource(R.color.filter_box_background_selected_color);
            getBd().tvFilterRecentlyCollect.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_selected_color));
            getBd().lyFilterRecentlyUpdate.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterRecentlyUpdate.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            return;
        }
        if (i == FilterCollectType.INSTANCE.getRecentlyUpdate()) {
            getBd().lyFilterRecentlyRead.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterRecentlyRead.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterRecentlyCollect.setBackgroundResource(R.color.filter_box_background_normal_color);
            getBd().tvFilterRecentlyCollect.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_normal_color));
            getBd().lyFilterRecentlyUpdate.setBackgroundResource(R.color.filter_box_background_selected_color);
            getBd().tvFilterRecentlyUpdate.setTextColor(ContextCompat.getColor(requireActivity(), R.color.filter_box_text_selected_color));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBottomTabState() {
        if (CollectionsKt.any(this.selectedAlbumIds)) {
            getBd().tvCancelCollect.setText("取消收藏(" + this.selectedAlbumIds.size() + ")");
        } else {
            getBd().tvCancelCollect.setText("取消收藏");
        }
        if ((!this.bookshelfEntities.isEmpty()) && this.selectedAlbumIds.size() == this.bookshelfEntities.size()) {
            getBd().tvSelectAll.setText("取消全选");
        } else {
            getBd().tvSelectAll.setText("全选");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076 A[Catch: Exception -> 0x00ae, LOOP:0: B:22:0x0070->B:24:0x0076, LOOP_END, TryCatch #0 {Exception -> 0x00ae, blocks: (B:12:0x002d, B:21:0x0067, B:22:0x0070, B:24:0x0076, B:25:0x0082, B:27:0x0088, B:28:0x0097), top: B:35:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0088 A[Catch: Exception -> 0x00ae, TryCatch #0 {Exception -> 0x00ae, blocks: (B:12:0x002d, B:21:0x0067, B:22:0x0070, B:24:0x0076, B:25:0x0082, B:27:0x0088, B:28:0x0097), top: B:35:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0097 A[Catch: Exception -> 0x00ae, TRY_LEAVE, TryCatch #0 {Exception -> 0x00ae, blocks: (B:12:0x002d, B:21:0x0067, B:22:0x0070, B:24:0x0076, B:25:0x0082, B:27:0x0088, B:28:0x0097), top: B:35:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadCollect(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.bookshelf.CollectFragment.loadCollect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[Catch: all -> 0x0042, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x0014, B:12:0x003e, B:11:0x001e), top: B:18:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void startCheckUpdateJob() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = r7.checkUpdateJobRef     // Catch: java.lang.Throwable -> L42
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L1e
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = r7.checkUpdateJobRef     // Catch: java.lang.Throwable -> L42
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
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> L42
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch: java.lang.Throwable -> L42
            kotlinx.coroutines.CoroutineScope r1 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r0)     // Catch: java.lang.Throwable -> L42
            r2 = 0
            r3 = 0
            com.funny.audio.view.bookshelf.CollectFragment$startCheckUpdateJob$1$newJob$1 r0 = new com.funny.audio.view.bookshelf.CollectFragment$startCheckUpdateJob$1$newJob$1     // Catch: java.lang.Throwable -> L42
            r4 = 0
            r0.<init>(r7, r4)     // Catch: java.lang.Throwable -> L42
            r4 = r0
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L42
            r5 = 3
            r6 = 0
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L42
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r1 = r7.checkUpdateJobRef     // Catch: java.lang.Throwable -> L42
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
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.bookshelf.CollectFragment.startCheckUpdateJob():void");
    }
}
