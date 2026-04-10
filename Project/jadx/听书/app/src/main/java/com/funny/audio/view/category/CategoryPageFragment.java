package com.funny.audio.view.category;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.QuickAdapterHelper;
import com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.drake.statelayout.StateLayout;
import com.funny.audio.R;
import com.funny.audio.databinding.FragmentCategoryPageBinding;
import com.funny.audio.models.AlbumInfo;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.adapters.CategoryAlbumAdapter;
import com.funny.audio.view.category.CategoryPageFragment;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.core.LinearSpacingItemDecoration;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CategoryPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0011\u0010\u0016\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/funny/audio/view/category/CategoryPageFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentCategoryPageBinding;", "()V", "adapter", "Lcom/funny/audio/view/adapters/CategoryAlbumAdapter;", "categoryId", "", "getCategoryId", "()Ljava/lang/String;", "setCategoryId", "(Ljava/lang/String;)V", "helper", "Lcom/chad/library/adapter4/QuickAdapterHelper;", "page", "", "pageSize", "initData", "", "initView", "view", "Landroid/view/View;", "loadAlbums", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshData", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CategoryPageFragment extends BaseFragment<FragmentCategoryPageBinding> {
    private QuickAdapterHelper helper;
    private String categoryId = "";
    private final CategoryAlbumAdapter adapter = new CategoryAlbumAdapter();
    private int page = 1;
    private int pageSize = 15;

    /* JADX INFO: renamed from: com.funny.audio.view.category.CategoryPageFragment$loadAlbums$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CategoryPageFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.category.CategoryPageFragment", f = "CategoryPageFragment.kt", i = {0}, l = {124}, m = "loadAlbums", n = {"this"}, s = {"L$0"})
    static final class C05971 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05971(Continuation<? super C05971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CategoryPageFragment.this.loadAlbums(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.category.CategoryPageFragment$refreshData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CategoryPageFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.category.CategoryPageFragment", f = "CategoryPageFragment.kt", i = {0}, l = {114}, m = "refreshData", n = {"this"}, s = {"L$0"})
    static final class C05981 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05981(Continuation<? super C05981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CategoryPageFragment.this.refreshData(this);
        }
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryId = str;
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        StateLayout stateLayout = getBd().state;
        stateLayout.setLoadingLayout(R.layout.page_state_loading);
        stateLayout.setEmptyLayout(R.layout.page_state_empty);
        stateLayout.setErrorLayout(R.layout.page_state_error);
        getBd().state.onError(new AnonymousClass2());
        getBd().refreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.funny.audio.view.category.CategoryPageFragment$$ExternalSyntheticLambda0
            @Override // com.scwang.smart.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(RefreshLayout refreshLayout) {
                CategoryPageFragment.initView$lambda$1(this.f$0, refreshLayout);
            }
        });
        this.adapter.setItemAnimation(BaseQuickAdapter.AnimationType.ScaleIn);
        ItemClickUtilsKt.setOnDebouncedItemClick$default(this.adapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.category.CategoryPageFragment$$ExternalSyntheticLambda1
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                CategoryPageFragment.initView$lambda$3(this.f$0, baseQuickAdapter, view2, i);
            }
        }, 1, null);
        QuickAdapterHelper quickAdapterHelperBuild = new QuickAdapterHelper.Builder(this.adapter).setTrailingLoadStateAdapter(new TrailingLoadStateAdapter.OnTrailingListener() { // from class: com.funny.audio.view.category.CategoryPageFragment$initView$helper$1
            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onFailRetry() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CategoryPageFragment$initView$helper$1$onFailRetry$1(this.this$0, null), 3, null);
            }

            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onLoad() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CategoryPageFragment$initView$helper$1$onLoad$1(this.this$0, null), 3, null);
            }
        }).build();
        getBd().rvAlbums.setLayoutManager(new LinearLayoutManager(getContext()));
        getBd().rvAlbums.setAdapter(quickAdapterHelperBuild.getMAdapter());
        RecyclerView recyclerView = getBd().rvAlbums;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "this.requireContext()");
        recyclerView.addItemDecoration(new LinearSpacingItemDecoration(contextRequireContext, 12.0f, 10.0f, 1));
        this.helper = quickAdapterHelperBuild;
    }

    /* JADX INFO: renamed from: com.funny.audio.view.category.CategoryPageFragment$initView$2, reason: invalid class name */
    /* JADX INFO: compiled from: CategoryPageFragment.kt */
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
            final CategoryPageFragment categoryPageFragment = CategoryPageFragment.this;
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.funny.audio.view.category.CategoryPageFragment$initView$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CategoryPageFragment.AnonymousClass2.invoke$lambda$0(categoryPageFragment, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(CategoryPageFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CategoryPageFragment$initView$2$1$1(this$0, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(CategoryPageFragment this$0, RefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CategoryPageFragment$initView$3$1(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(CategoryPageFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        AlbumInfo albumInfo = (AlbumInfo) adapter.getItem(i);
        if (albumInfo != null) {
            NavigationUtils.INSTANCE.toAlbumDetail(this$0.requireActivity(), albumInfo.getId());
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.category.CategoryPageFragment$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: CategoryPageFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.category.CategoryPageFragment$initData$1", f = "CategoryPageFragment.kt", i = {}, l = {104, 105}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CategoryPageFragment.this.new AnonymousClass1(continuation);
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
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            if (CategoryPageFragment.this.refreshData(this) == coroutine_suspended) {
                return coroutine_suspended;
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
            boolean r0 = r11 instanceof com.funny.audio.view.category.CategoryPageFragment.C05981
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.category.CategoryPageFragment$refreshData$1 r0 = (com.funny.audio.view.category.CategoryPageFragment.C05981) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.category.CategoryPageFragment$refreshData$1 r0 = new com.funny.audio.view.category.CategoryPageFragment$refreshData$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.category.CategoryPageFragment r0 = (com.funny.audio.view.category.CategoryPageFragment) r0
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
            com.funny.audio.databinding.FragmentCategoryPageBinding r11 = (com.funny.audio.databinding.FragmentCategoryPageBinding) r11
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
            java.lang.Object r11 = r10.loadAlbums(r0)
            if (r11 != r1) goto L5f
            return r1
        L5f:
            r0 = r10
        L60:
            androidx.viewbinding.ViewBinding r11 = r0.getBd()
            com.funny.audio.databinding.FragmentCategoryPageBinding r11 = (com.funny.audio.databinding.FragmentCategoryPageBinding) r11
            com.scwang.smart.refresh.layout.SmartRefreshLayout r11 = r11.refreshLayout
            r11.finishRefresh()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.category.CategoryPageFragment.refreshData(kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object loadAlbums(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.category.CategoryPageFragment.loadAlbums(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
