package com.funny.audio.view.homepage;

import android.content.Context;
import android.view.View;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.QuickAdapterHelper;
import com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.drake.statelayout.StateLayout;
import com.funny.audio.R;
import com.funny.audio.databinding.FragmentHomepageUpdateBinding;
import com.funny.audio.models.UpdateAlbumInfo;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.adapters.UpdateAlbumAdapter;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.core.GridSpacingItemDecoration;
import com.funny.audio.view.homepage.HomepageUpdateFragment;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: HomepageUpdateFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0011\u0010\u0010\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/funny/audio/view/homepage/HomepageUpdateFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentHomepageUpdateBinding;", "()V", "adapter", "Lcom/funny/audio/view/adapters/UpdateAlbumAdapter;", "helper", "Lcom/chad/library/adapter4/QuickAdapterHelper;", "page", "", "pageSize", "initData", "", "initView", "view", "Landroid/view/View;", "loadUpdateAlbums", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshData", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomepageUpdateFragment extends BaseFragment<FragmentHomepageUpdateBinding> {
    private QuickAdapterHelper helper;
    private int page = 1;
    private int pageSize = 15;
    private final UpdateAlbumAdapter adapter = new UpdateAlbumAdapter();

    /* JADX INFO: renamed from: com.funny.audio.view.homepage.HomepageUpdateFragment$loadUpdateAlbums$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomepageUpdateFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.homepage.HomepageUpdateFragment", f = "HomepageUpdateFragment.kt", i = {0}, l = {AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID}, m = "loadUpdateAlbums", n = {"this"}, s = {"L$0"})
    static final class C06091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06091(Continuation<? super C06091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomepageUpdateFragment.this.loadUpdateAlbums(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.homepage.HomepageUpdateFragment$refreshData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomepageUpdateFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.homepage.HomepageUpdateFragment", f = "HomepageUpdateFragment.kt", i = {0}, l = {107}, m = "refreshData", n = {"this"}, s = {"L$0"})
    static final class C06101 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06101(Continuation<? super C06101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomepageUpdateFragment.this.refreshData(this);
        }
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        StateLayout stateLayout = getBd().state;
        stateLayout.setEmptyLayout(R.layout.page_state_empty);
        stateLayout.setLoadingLayout(R.layout.page_state_loading);
        stateLayout.setErrorLayout(R.layout.page_state_error);
        getBd().state.onError(new AnonymousClass2());
        getBd().refreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.funny.audio.view.homepage.HomepageUpdateFragment$$ExternalSyntheticLambda0
            @Override // com.scwang.smart.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(RefreshLayout refreshLayout) {
                HomepageUpdateFragment.initView$lambda$1(this.f$0, refreshLayout);
            }
        });
        UpdateAlbumAdapter updateAlbumAdapter = this.adapter;
        ItemClickUtilsKt.setOnDebouncedItemClick$default(updateAlbumAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.homepage.HomepageUpdateFragment$$ExternalSyntheticLambda1
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                HomepageUpdateFragment.initView$lambda$3(this.f$0, baseQuickAdapter, view2, i);
            }
        }, 1, null);
        RecyclerView recyclerView = getBd().rvUpdates;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "bd.rvUpdates");
        this.adapter.setItemAnimation(BaseQuickAdapter.AnimationType.ScaleIn);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(contextRequireContext, 3, 10.0f, 8.0f, 16.0f, false));
        QuickAdapterHelper quickAdapterHelperBuild = new QuickAdapterHelper.Builder(updateAlbumAdapter).setTrailingLoadStateAdapter(new TrailingLoadStateAdapter.OnTrailingListener() { // from class: com.funny.audio.view.homepage.HomepageUpdateFragment$initView$helper$1
            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onFailRetry() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomepageUpdateFragment$initView$helper$1$onFailRetry$1(this.this$0, null), 3, null);
            }

            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onLoad() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomepageUpdateFragment$initView$helper$1$onLoad$1(this.this$0, null), 3, null);
            }

            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public boolean isAllowLoading() {
                return !this.this$0.getBd().refreshLayout.isRefreshing();
            }
        }).build();
        recyclerView.setAdapter(quickAdapterHelperBuild.getMAdapter());
        this.helper = quickAdapterHelperBuild;
    }

    /* JADX INFO: renamed from: com.funny.audio.view.homepage.HomepageUpdateFragment$initView$2, reason: invalid class name */
    /* JADX INFO: compiled from: HomepageUpdateFragment.kt */
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
            final HomepageUpdateFragment homepageUpdateFragment = HomepageUpdateFragment.this;
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.funny.audio.view.homepage.HomepageUpdateFragment$initView$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomepageUpdateFragment.AnonymousClass2.invoke$lambda$0(homepageUpdateFragment, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(HomepageUpdateFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomepageUpdateFragment$initView$2$1$1(this$0, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(HomepageUpdateFragment this$0, RefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomepageUpdateFragment$initView$3$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(HomepageUpdateFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        UpdateAlbumInfo updateAlbumInfo = (UpdateAlbumInfo) adapter.getItem(i);
        if (updateAlbumInfo != null) {
            NavigationUtils.INSTANCE.toAlbumDetail(this$0.getActivity(), updateAlbumInfo.getId());
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.homepage.HomepageUpdateFragment$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomepageUpdateFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.homepage.HomepageUpdateFragment$initData$1", f = "HomepageUpdateFragment.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomepageUpdateFragment.this.new AnonymousClass1(continuation);
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
                if (HomepageUpdateFragment.this.refreshData(this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object refreshData(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.homepage.HomepageUpdateFragment.C06101
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.homepage.HomepageUpdateFragment$refreshData$1 r0 = (com.funny.audio.view.homepage.HomepageUpdateFragment.C06101) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.homepage.HomepageUpdateFragment$refreshData$1 r0 = new com.funny.audio.view.homepage.HomepageUpdateFragment$refreshData$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.homepage.HomepageUpdateFragment r0 = (com.funny.audio.view.homepage.HomepageUpdateFragment) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L60
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            r10.page = r3
            r11 = 15
            r10.pageSize = r11
            androidx.viewbinding.ViewBinding r11 = r10.getBd()
            com.funny.audio.databinding.FragmentHomepageUpdateBinding r11 = (com.funny.audio.databinding.FragmentHomepageUpdateBinding) r11
            com.drake.statelayout.StateLayout r4 = r11.state
            java.lang.String r11 = "bd.state"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r11)
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 7
            r9 = 0
            com.drake.statelayout.StateLayout.showLoading$default(r4, r5, r6, r7, r8, r9)
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r11 = r10.loadUpdateAlbums(r0)
            if (r11 != r1) goto L5f
            return r1
        L5f:
            r0 = r10
        L60:
            androidx.viewbinding.ViewBinding r11 = r0.getBd()
            com.funny.audio.databinding.FragmentHomepageUpdateBinding r11 = (com.funny.audio.databinding.FragmentHomepageUpdateBinding) r11
            com.scwang.smart.refresh.layout.SmartRefreshLayout r11 = r11.refreshLayout
            r11.finishRefresh()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.homepage.HomepageUpdateFragment.refreshData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[Catch: Exception -> 0x0105, TryCatch #0 {Exception -> 0x0105, blocks: (B:12:0x002d, B:21:0x0062, B:23:0x006a, B:25:0x008b, B:27:0x008f, B:29:0x00aa, B:28:0x00a3, B:30:0x00c0, B:32:0x00c4, B:33:0x00d2, B:34:0x00e2, B:36:0x00e6, B:37:0x00f4), top: B:47:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e2 A[Catch: Exception -> 0x0105, TryCatch #0 {Exception -> 0x0105, blocks: (B:12:0x002d, B:21:0x0062, B:23:0x006a, B:25:0x008b, B:27:0x008f, B:29:0x00aa, B:28:0x00a3, B:30:0x00c0, B:32:0x00c4, B:33:0x00d2, B:34:0x00e2, B:36:0x00e6, B:37:0x00f4), top: B:47:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadUpdateAlbums(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.homepage.HomepageUpdateFragment.loadUpdateAlbums(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
