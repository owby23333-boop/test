package com.funny.audio.view.homepage;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.drake.statelayout.StateLayout;
import com.funny.audio.R;
import com.funny.audio.databinding.FragmentHomepageRecommendBinding;
import com.funny.audio.models.BannerInfo;
import com.funny.audio.models.BannerRelationTypes;
import com.funny.audio.models.GroupInfo;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.adapters.HomepageBannerAdapter;
import com.funny.audio.view.adapters.HomepageGroupAdapter;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.homepage.HomepageRecommendFragment;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.listener.OnPageChangeListener;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: HomepageRecommendFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0011\u0010\u001a\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0011\u0010\u001d\u001a\u00020\u0012H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/funny/audio/view/homepage/HomepageRecommendFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentHomepageRecommendBinding;", "()V", "adapter", "Lcom/funny/audio/view/adapters/HomepageGroupAdapter;", "bannerInfos", "", "Lcom/funny/audio/models/BannerInfo;", "groupInfos", "Lcom/funny/audio/models/GroupInfo;", "tabId", "", "getTabId", "()Ljava/lang/String;", "setTabId", "(Ljava/lang/String;)V", "initBanner", "", "initData", "initGroups", "initRefresh", "initState", "initView", "view", "Landroid/view/View;", "loadBanner", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadData", "loadGroups", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomepageRecommendFragment extends BaseFragment<FragmentHomepageRecommendBinding> {
    private List<BannerInfo> bannerInfos = new ArrayList();
    private List<GroupInfo> groupInfos = new ArrayList();
    private HomepageGroupAdapter adapter = new HomepageGroupAdapter();
    private String tabId = "";

    /* JADX INFO: renamed from: com.funny.audio.view.homepage.HomepageRecommendFragment$loadBanner$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomepageRecommendFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.homepage.HomepageRecommendFragment", f = "HomepageRecommendFragment.kt", i = {0}, l = {169}, m = "loadBanner", n = {"this"}, s = {"L$0"})
    static final class C06041 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06041(Continuation<? super C06041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomepageRecommendFragment.this.loadBanner(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.homepage.HomepageRecommendFragment$loadData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomepageRecommendFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.homepage.HomepageRecommendFragment", f = "HomepageRecommendFragment.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, 155}, m = "loadData", n = {"this", "this"}, s = {"L$0", "L$0"})
    static final class C06051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06051(Continuation<? super C06051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomepageRecommendFragment.this.loadData(this);
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.view.homepage.HomepageRecommendFragment$loadGroups$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomepageRecommendFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.homepage.HomepageRecommendFragment", f = "HomepageRecommendFragment.kt", i = {0}, l = {192}, m = "loadGroups", n = {"this"}, s = {"L$0"})
    static final class C06061 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C06061(Continuation<? super C06061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HomepageRecommendFragment.this.loadGroups(this);
        }
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final void setTabId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tabId = str;
    }

    @Override // com.funny.audio.view.core.BaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initRefresh();
        initState();
        initBanner();
        initGroups();
    }

    private final void initRefresh() {
        getBd().refreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.funny.audio.view.homepage.HomepageRecommendFragment$$ExternalSyntheticLambda0
            @Override // com.scwang.smart.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(RefreshLayout refreshLayout) {
                HomepageRecommendFragment.initRefresh$lambda$0(this.f$0, refreshLayout);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRefresh$lambda$0(HomepageRecommendFragment this$0, RefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomepageRecommendFragment$initRefresh$1$1(this$0, null), 3, null);
    }

    private final void initState() {
        StateLayout stateLayout = getBd().state;
        stateLayout.setEmptyLayout(R.layout.page_state_empty);
        stateLayout.setLoadingLayout(R.layout.page_state_loading);
        stateLayout.setErrorLayout(R.layout.page_state_error);
        getBd().state.onError(new C06032());
    }

    /* JADX INFO: renamed from: com.funny.audio.view.homepage.HomepageRecommendFragment$initState$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomepageRecommendFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C06032 extends Lambda implements Function2<View, Object, Unit> {
        C06032() {
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
            final HomepageRecommendFragment homepageRecommendFragment = HomepageRecommendFragment.this;
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.funny.audio.view.homepage.HomepageRecommendFragment$initState$2$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomepageRecommendFragment.C06032.invoke$lambda$0(homepageRecommendFragment, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(HomepageRecommendFragment this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new HomepageRecommendFragment$initState$2$1$1(this$0, null), 3, null);
        }
    }

    private final void initBanner() {
        Banner banner = getBd().banner;
        Intrinsics.checkNotNullExpressionValue(banner, "bd.banner");
        HomepageBannerAdapter homepageBannerAdapter = new HomepageBannerAdapter(this.bannerInfos);
        banner.addOnPageChangeListener(new OnPageChangeListener() { // from class: com.funny.audio.view.homepage.HomepageRecommendFragment.initBanner.1
            @Override // com.youth.banner.listener.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // com.youth.banner.listener.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // com.youth.banner.listener.OnPageChangeListener
            public void onPageSelected(int position) {
            }
        });
        banner.addBannerLifecycleObserver(this).setAdapter(homepageBannerAdapter).setLoopTime(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT).setScrollTime(100).setIndicator(new CircleIndicator(getContext()));
        banner.setOnBannerListener(new OnBannerListener<BannerInfo>() { // from class: com.funny.audio.view.homepage.HomepageRecommendFragment.initBanner.2
            @Override // com.youth.banner.listener.OnBannerListener
            public void OnBannerClick(BannerInfo data, int position) {
                if (data != null) {
                    HomepageRecommendFragment homepageRecommendFragment = HomepageRecommendFragment.this;
                    String relationType = data.getRelationType();
                    if (Intrinsics.areEqual(relationType, BannerRelationTypes.INSTANCE.getALBUM())) {
                        NavigationUtils.INSTANCE.toAlbumDetail(homepageRecommendFragment.getContext(), data.getRelationId());
                    } else if (Intrinsics.areEqual(relationType, BannerRelationTypes.INSTANCE.getH5_IN())) {
                        NavigationUtils.toH5In$default(NavigationUtils.INSTANCE, homepageRecommendFragment.getContext(), data.getRelationId(), null, 4, null);
                    } else if (Intrinsics.areEqual(relationType, BannerRelationTypes.INSTANCE.getH5_OUT())) {
                        NavigationUtils.INSTANCE.toH5Out(homepageRecommendFragment.getContext(), data.getRelationId());
                    }
                }
            }
        });
    }

    private final void initGroups() {
        HomepageGroupAdapter homepageGroupAdapter = this.adapter;
        RecyclerView recyclerView = getBd().rvGroups;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "bd.rvGroups");
        homepageGroupAdapter.submitList(this.groupInfos);
        recyclerView.setAdapter(homepageGroupAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    /* JADX INFO: renamed from: com.funny.audio.view.homepage.HomepageRecommendFragment$initData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HomepageRecommendFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.homepage.HomepageRecommendFragment$initData$1", f = "HomepageRecommendFragment.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    static final class C06021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06021(Continuation<? super C06021> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomepageRecommendFragment.this.new C06021(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (HomepageRecommendFragment.this.loadData(this) == coroutine_suspended) {
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
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C06021(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadData(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.funny.audio.view.homepage.HomepageRecommendFragment.C06051
            if (r0 == 0) goto L14
            r0 = r14
            com.funny.audio.view.homepage.HomepageRecommendFragment$loadData$1 r0 = (com.funny.audio.view.homepage.HomepageRecommendFragment.C06051) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            com.funny.audio.view.homepage.HomepageRecommendFragment$loadData$1 r0 = new com.funny.audio.view.homepage.HomepageRecommendFragment$loadData$1
            r0.<init>(r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            java.lang.String r4 = "bd.state"
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L46
            if (r2 == r6) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.homepage.HomepageRecommendFragment r0 = (com.funny.audio.view.homepage.HomepageRecommendFragment) r0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L76
            goto L84
        L34:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L3c:
            java.lang.Object r2 = r0.L$0
            com.funny.audio.view.homepage.HomepageRecommendFragment r2 = (com.funny.audio.view.homepage.HomepageRecommendFragment) r2
            kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> L44
            goto L68
        L44:
            r0 = r2
            goto L76
        L46:
            kotlin.ResultKt.throwOnFailure(r14)
            androidx.viewbinding.ViewBinding r14 = r13.getBd()     // Catch: java.lang.Exception -> L75
            com.funny.audio.databinding.FragmentHomepageRecommendBinding r14 = (com.funny.audio.databinding.FragmentHomepageRecommendBinding) r14     // Catch: java.lang.Exception -> L75
            com.drake.statelayout.StateLayout r7 = r14.state     // Catch: java.lang.Exception -> L75
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)     // Catch: java.lang.Exception -> L75
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 7
            r12 = 0
            com.drake.statelayout.StateLayout.showLoading$default(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Exception -> L75
            r0.L$0 = r13     // Catch: java.lang.Exception -> L75
            r0.label = r6     // Catch: java.lang.Exception -> L75
            java.lang.Object r14 = r13.loadBanner(r0)     // Catch: java.lang.Exception -> L75
            if (r14 != r1) goto L67
            return r1
        L67:
            r2 = r13
        L68:
            r0.L$0 = r2     // Catch: java.lang.Exception -> L44
            r0.label = r3     // Catch: java.lang.Exception -> L44
            java.lang.Object r14 = r2.loadGroups(r0)     // Catch: java.lang.Exception -> L44
            if (r14 != r1) goto L73
            return r1
        L73:
            r0 = r2
            goto L84
        L75:
            r0 = r13
        L76:
            androidx.viewbinding.ViewBinding r14 = r0.getBd()
            com.funny.audio.databinding.FragmentHomepageRecommendBinding r14 = (com.funny.audio.databinding.FragmentHomepageRecommendBinding) r14
            com.drake.statelayout.StateLayout r14 = r14.state
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r4)
            com.drake.statelayout.StateLayout.showError$default(r14, r5, r6, r5)
        L84:
            androidx.viewbinding.ViewBinding r14 = r0.getBd()
            com.funny.audio.databinding.FragmentHomepageRecommendBinding r14 = (com.funny.audio.databinding.FragmentHomepageRecommendBinding) r14
            com.drake.statelayout.StateLayout r14 = r14.state
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r4)
            com.drake.statelayout.StateLayout.showContent$default(r14, r5, r6, r5)
            androidx.viewbinding.ViewBinding r14 = r0.getBd()
            com.funny.audio.databinding.FragmentHomepageRecommendBinding r14 = (com.funny.audio.databinding.FragmentHomepageRecommendBinding) r14
            com.scwang.smart.refresh.layout.SmartRefreshLayout r14 = r14.refreshLayout
            r14.finishRefresh()
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.homepage.HomepageRecommendFragment.loadData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadBanner(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.homepage.HomepageRecommendFragment.C06041
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.homepage.HomepageRecommendFragment$loadBanner$1 r0 = (com.funny.audio.view.homepage.HomepageRecommendFragment.C06041) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.homepage.HomepageRecommendFragment$loadBanner$1 r0 = new com.funny.audio.view.homepage.HomepageRecommendFragment$loadBanner$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.homepage.HomepageRecommendFragment r0 = (com.funny.audio.view.homepage.HomepageRecommendFragment) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L60
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)
            r5 = 0
            r6 = 0
            com.funny.audio.view.homepage.HomepageRecommendFragment$loadBanner$resp$1 r11 = new com.funny.audio.view.homepage.HomepageRecommendFragment$loadBanner$resp$1
            r2 = 0
            r11.<init>(r2)
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r11 = r11.await(r0)
            if (r11 != r1) goto L5f
            return r1
        L5f:
            r0 = r10
        L60:
            com.funny.audio.core.net.Response r11 = (com.funny.audio.core.net.Response) r11
            boolean r1 = com.funny.audio.core.net.NetModelsKt.successWithData(r11)
            if (r1 == 0) goto Lb8
            java.util.List<com.funny.audio.models.BannerInfo> r1 = r0.bannerInfos
            r1.clear()
            com.funny.audio.core.net.AppBody r11 = r11.getBody()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.lang.Object r11 = r11.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.util.List r11 = (java.util.List) r11
            r1 = r11
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r3
            if (r1 == 0) goto Lb8
            java.util.Iterator r11 = r11.iterator()
        L8b:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L9d
            java.lang.Object r1 = r11.next()
            com.funny.audio.models.BannerInfo r1 = (com.funny.audio.models.BannerInfo) r1
            java.util.List<com.funny.audio.models.BannerInfo> r2 = r0.bannerInfos
            r2.add(r1)
            goto L8b
        L9d:
            androidx.viewbinding.ViewBinding r11 = r0.getBd()
            com.funny.audio.databinding.FragmentHomepageRecommendBinding r11 = (com.funny.audio.databinding.FragmentHomepageRecommendBinding) r11
            com.youth.banner.Banner r11 = r11.banner
            com.youth.banner.adapter.BannerAdapter r11 = r11.getAdapter()
            r11.notifyDataSetChanged()
            androidx.viewbinding.ViewBinding r11 = r0.getBd()
            com.funny.audio.databinding.FragmentHomepageRecommendBinding r11 = (com.funny.audio.databinding.FragmentHomepageRecommendBinding) r11
            com.youth.banner.Banner r11 = r11.banner
            r0 = 0
            r11.setVisibility(r0)
        Lb8:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.homepage.HomepageRecommendFragment.loadBanner(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadGroups(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.funny.audio.view.homepage.HomepageRecommendFragment.C06061
            if (r0 == 0) goto L14
            r0 = r11
            com.funny.audio.view.homepage.HomepageRecommendFragment$loadGroups$1 r0 = (com.funny.audio.view.homepage.HomepageRecommendFragment.C06061) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            com.funny.audio.view.homepage.HomepageRecommendFragment$loadGroups$1 r0 = new com.funny.audio.view.homepage.HomepageRecommendFragment$loadGroups$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.funny.audio.view.homepage.HomepageRecommendFragment r0 = (com.funny.audio.view.homepage.HomepageRecommendFragment) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L72
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = r10.tabId
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            int r11 = r11.length()
            if (r11 != 0) goto L45
            r11 = r3
            goto L46
        L45:
            r11 = 0
        L46:
            if (r11 == 0) goto L4b
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L4b:
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            kotlinx.coroutines.CoroutineScope r4 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r11)
            r5 = 0
            r6 = 0
            com.funny.audio.view.homepage.HomepageRecommendFragment$loadGroups$resp$1 r11 = new com.funny.audio.view.homepage.HomepageRecommendFragment$loadGroups$resp$1
            r2 = 0
            r11.<init>(r10, r2)
            r7 = r11
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 3
            r9 = 0
            kotlinx.coroutines.Deferred r11 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r11 = r11.await(r0)
            if (r11 != r1) goto L71
            return r1
        L71:
            r0 = r10
        L72:
            com.funny.audio.core.net.Response r11 = (com.funny.audio.core.net.Response) r11
            boolean r1 = com.funny.audio.core.net.NetModelsKt.successWithData(r11)
            if (r1 == 0) goto Lbc
            com.funny.audio.core.net.AppBody r11 = r11.getBody()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.lang.Object r11 = r11.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.util.List r11 = (java.util.List) r11
            r1 = r11
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r3
            if (r1 == 0) goto Lbc
            java.util.Iterator r11 = r11.iterator()
        L98:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto Lb7
            java.lang.Object r1 = r11.next()
            com.funny.audio.models.GroupInfo r1 = (com.funny.audio.models.GroupInfo) r1
            java.util.List r2 = r1.getAlbums()
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r3 = 6
            if (r2 < r3) goto L98
            java.util.List<com.funny.audio.models.GroupInfo> r2 = r0.groupInfos
            r2.add(r1)
            goto L98
        Lb7:
            com.funny.audio.view.adapters.HomepageGroupAdapter r11 = r0.adapter
            r11.notifyDataSetChanged()
        Lbc:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.view.homepage.HomepageRecommendFragment.loadGroups(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
