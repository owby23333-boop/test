package com.funny.audio.view.album;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter4.BaseQuickAdapter;
import com.chad.library.adapter4.QuickAdapterHelper;
import com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter;
import com.chad.library.adapter4.util.ItemClickUtilsKt;
import com.drake.statelayout.StateLayout;
import com.funny.audio.R;
import com.funny.audio.databinding.FragmentAlbumLikeListBinding;
import com.funny.audio.models.AlbumDetailInfo;
import com.funny.audio.models.AlbumInfo;
import com.funny.audio.models.CategoryItem;
import com.funny.audio.models.TagItem;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.adapters.DetailAlbumLikeAdapter;
import com.funny.audio.view.album.AlbumLikesFragment;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.core.GridSpacingItemDecoration;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AlbumLikesFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0011\u0010\u001f\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0011\u0010!\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/funny/audio/view/album/AlbumLikesFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentAlbumLikeListBinding;", "()V", "adapter", "Lcom/funny/audio/view/adapters/DetailAlbumLikeAdapter;", "albumDetailInfo", "Lcom/funny/audio/models/AlbumDetailInfo;", "getAlbumDetailInfo", "()Lcom/funny/audio/models/AlbumDetailInfo;", "setAlbumDetailInfo", "(Lcom/funny/audio/models/AlbumDetailInfo;)V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "categoryId", "categoryPage", "", "helper", "Lcom/chad/library/adapter4/QuickAdapterHelper;", "tagId", "tagPage", "type", "initData", "", "initView", "view", "Landroid/view/View;", "loadLikeAlbums", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshData", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AlbumLikesFragment extends BaseFragment<FragmentAlbumLikeListBinding> {
    private AlbumDetailInfo albumDetailInfo;
    private QuickAdapterHelper helper;
    private String albumId = "";
    private int tagPage = 1;
    private int categoryPage = 1;
    private String type = AlbumLikeType.INSTANCE.getTag();
    private String tagId = "";
    private String categoryId = "";
    private DetailAlbumLikeAdapter adapter = new DetailAlbumLikeAdapter();

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumLikesFragment$loadLikeAlbums$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AlbumLikesFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumLikesFragment", f = "AlbumLikesFragment.kt", i = {0, 1}, l = {138, 166}, m = "loadLikeAlbums", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class C05841 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C05841(Continuation<? super C05841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AlbumLikesFragment.this.loadLikeAlbums(this);
        }
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
        StateLayout stateLayout = getBd().state;
        stateLayout.setEmptyLayout(R.layout.page_state_empty);
        stateLayout.setLoadingLayout(R.layout.page_state_loading);
        stateLayout.setErrorLayout(R.layout.page_state_error);
        getBd().state.onError(new AnonymousClass2());
        DetailAlbumLikeAdapter detailAlbumLikeAdapter = this.adapter;
        ItemClickUtilsKt.setOnDebouncedItemClick$default(detailAlbumLikeAdapter, 0L, new BaseQuickAdapter.OnItemClickListener() { // from class: com.funny.audio.view.album.AlbumLikesFragment$$ExternalSyntheticLambda0
            @Override // com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
            public final void onClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                AlbumLikesFragment.initView$lambda$2(this.f$0, baseQuickAdapter, view2, i);
            }
        }, 1, null);
        RecyclerView recyclerView = getBd().rvLikes;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "bd.rvLikes");
        this.adapter.setItemAnimation(BaseQuickAdapter.AnimationType.ScaleIn);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(contextRequireContext, 3, 10.0f, 8.0f, 10.0f, false));
        QuickAdapterHelper quickAdapterHelperBuild = new QuickAdapterHelper.Builder(detailAlbumLikeAdapter).setTrailingLoadStateAdapter(new TrailingLoadStateAdapter.OnTrailingListener() { // from class: com.funny.audio.view.album.AlbumLikesFragment$initView$helper$1
            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onFailRetry() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AlbumLikesFragment$initView$helper$1$onFailRetry$1(this.this$0, null), 3, null);
            }

            @Override // com.chad.library.adapter4.loadState.trailing.TrailingLoadStateAdapter.OnTrailingListener
            public void onLoad() {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AlbumLikesFragment$initView$helper$1$onLoad$1(this.this$0, null), 3, null);
            }
        }).build();
        recyclerView.setAdapter(quickAdapterHelperBuild.getMAdapter());
        this.helper = quickAdapterHelperBuild;
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumLikesFragment$initView$2, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumLikesFragment.kt */
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
            final AlbumLikesFragment albumLikesFragment = AlbumLikesFragment.this;
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.funny.audio.view.album.AlbumLikesFragment$initView$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AlbumLikesFragment.AnonymousClass2.invoke$lambda$0(albumLikesFragment, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(AlbumLikesFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AlbumLikesFragment$initView$2$1$1(this$0, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(AlbumLikesFragment this$0, BaseQuickAdapter adapter, View view, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        AlbumInfo albumInfo = (AlbumInfo) adapter.getItem(i);
        if (albumInfo != null) {
            NavigationUtils.INSTANCE.toAlbumDetail(this$0.getActivity(), albumInfo.getId());
        }
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void initData() {
        AlbumDetailInfo albumDetailInfo = this.albumDetailInfo;
        Intrinsics.checkNotNull(albumDetailInfo);
        List<TagItem> tags = albumDetailInfo.getTags();
        AlbumDetailInfo albumDetailInfo2 = this.albumDetailInfo;
        Intrinsics.checkNotNull(albumDetailInfo2);
        List<CategoryItem> categories = albumDetailInfo2.getCategories();
        List<TagItem> list = tags;
        if (!list.isEmpty()) {
            this.tagId = ((TagItem) CollectionsKt.random(list, Random.INSTANCE)).getId();
        }
        List<CategoryItem> list2 = categories;
        if (!list2.isEmpty()) {
            this.categoryId = ((CategoryItem) CollectionsKt.random(list2, Random.INSTANCE)).getId();
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.album.AlbumLikesFragment$initData$1, reason: invalid class name */
    /* JADX INFO: compiled from: AlbumLikesFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.album.AlbumLikesFragment$initData$1", f = "AlbumLikesFragment.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AlbumLikesFragment.this.new AnonymousClass1(continuation);
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
                if (AlbumLikesFragment.this.refreshData(this) == coroutine_suspended) {
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
    public final Object refreshData(Continuation<? super Unit> continuation) throws Throwable {
        this.tagPage = 1;
        this.categoryPage = 1;
        this.type = this.tagId.length() > 0 ? AlbumLikeType.INSTANCE.getTag() : AlbumLikeType.INSTANCE.getCategory();
        StateLayout stateLayout = getBd().state;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "bd.state");
        StateLayout.showLoading$default(stateLayout, null, false, false, 7, null);
        Object objLoadLikeAlbums = loadLikeAlbums(continuation);
        return objLoadLikeAlbums == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objLoadLikeAlbums : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085 A[Catch: Exception -> 0x01f7, TryCatch #0 {Exception -> 0x01f7, blocks: (B:13:0x0031, B:54:0x0148, B:56:0x0150, B:58:0x0171, B:60:0x0175, B:62:0x0179, B:64:0x0194, B:63:0x018d, B:65:0x01aa, B:67:0x01ae, B:69:0x01b2, B:70:0x01c0, B:71:0x01d0, B:73:0x01d4, B:75:0x01d8, B:76:0x01e6, B:18:0x0042, B:27:0x007d, B:29:0x0085, B:31:0x00a6, B:33:0x00aa, B:35:0x00c5, B:34:0x00be, B:37:0x00d3, B:36:0x00cb), top: B:88:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb A[Catch: Exception -> 0x01f7, TryCatch #0 {Exception -> 0x01f7, blocks: (B:13:0x0031, B:54:0x0148, B:56:0x0150, B:58:0x0171, B:60:0x0175, B:62:0x0179, B:64:0x0194, B:63:0x018d, B:65:0x01aa, B:67:0x01ae, B:69:0x01b2, B:70:0x01c0, B:71:0x01d0, B:73:0x01d4, B:75:0x01d8, B:76:0x01e6, B:18:0x0042, B:27:0x007d, B:29:0x0085, B:31:0x00a6, B:33:0x00aa, B:35:0x00c5, B:34:0x00be, B:37:0x00d3, B:36:0x00cb), top: B:88:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0150 A[Catch: Exception -> 0x01f7, TryCatch #0 {Exception -> 0x01f7, blocks: (B:13:0x0031, B:54:0x0148, B:56:0x0150, B:58:0x0171, B:60:0x0175, B:62:0x0179, B:64:0x0194, B:63:0x018d, B:65:0x01aa, B:67:0x01ae, B:69:0x01b2, B:70:0x01c0, B:71:0x01d0, B:73:0x01d4, B:75:0x01d8, B:76:0x01e6, B:18:0x0042, B:27:0x007d, B:29:0x0085, B:31:0x00a6, B:33:0x00aa, B:35:0x00c5, B:34:0x00be, B:37:0x00d3, B:36:0x00cb), top: B:88:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d0 A[Catch: Exception -> 0x01f7, TryCatch #0 {Exception -> 0x01f7, blocks: (B:13:0x0031, B:54:0x0148, B:56:0x0150, B:58:0x0171, B:60:0x0175, B:62:0x0179, B:64:0x0194, B:63:0x018d, B:65:0x01aa, B:67:0x01ae, B:69:0x01b2, B:70:0x01c0, B:71:0x01d0, B:73:0x01d4, B:75:0x01d8, B:76:0x01e6, B:18:0x0042, B:27:0x007d, B:29:0x0085, B:31:0x00a6, B:33:0x00aa, B:35:0x00c5, B:34:0x00be, B:37:0x00d3, B:36:0x00cb), top: B:88:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.funny.audio.view.album.AlbumLikesFragment$loadLikeAlbums$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadLikeAlbums(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.album.AlbumLikesFragment.loadLikeAlbums(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
