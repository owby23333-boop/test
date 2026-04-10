package com.funny.audio.view.homepage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.angcyo.tablayout.DslTabLayout;
import com.angcyo.tablayout.delegate.ViewPager1Delegate;
import com.funny.audio.AppManager;
import com.funny.audio.core.ext.ViewKt;
import com.funny.audio.core.net.AppBody;
import com.funny.audio.core.net.NetModelsKt;
import com.funny.audio.core.net.Response;
import com.funny.audio.databinding.FragmentHomepageBinding;
import com.funny.audio.models.TabInfo;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.ViewUtils;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.core.StatusBarUtils;
import com.qmuiteam.qmui.kotlin.ViewKtKt;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.widget.QMUIViewPager;
import java.util.ArrayList;
import java.util.Comparator;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: HomepageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/funny/audio/view/homepage/HomepageFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentHomepageBinding;", "()V", "tabFragments", "", "tagName", "", "initStatusBar", "", "initTab", "initView", "view", "Landroid/view/View;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HomepageFragment extends BaseFragment<FragmentHomepageBinding> {
    private List<BaseFragment<?>> tabFragments = new ArrayList();
    private final String tagName = "HomepageFragment";

    @Override // com.funny.audio.view.core.BaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initStatusBar();
        QMUIFrameLayout qMUIFrameLayout = getBd().lySearchBar;
        Intrinsics.checkNotNullExpressionValue(qMUIFrameLayout, "bd.lySearchBar");
        ViewKtKt.onClick$default(qMUIFrameLayout, 0L, new Function1<View, Unit>() { // from class: com.funny.audio.view.homepage.HomepageFragment.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.checkNotNullParameter(it, "it");
                NavigationUtils.INSTANCE.toSearch(HomepageFragment.this.getActivity());
            }
        }, 1, null);
        initTab();
    }

    private final void initTab() {
        DslTabLayout dslTabLayout = getBd().lyTab;
        Intrinsics.checkNotNullExpressionValue(dslTabLayout, "bd.lyTab");
        QMUIViewPager qMUIViewPager = getBd().viewPager;
        Intrinsics.checkNotNullExpressionValue(qMUIViewPager, "bd.viewPager");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(dslTabLayout, qMUIViewPager, null), 3, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.homepage.HomepageFragment$initTab$1, reason: invalid class name */
    /* JADX INFO: compiled from: HomepageFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.homepage.HomepageFragment$initTab$1", f = "HomepageFragment.kt", i = {0}, l = {103}, m = "invokeSuspend", n = {"recommendFragment"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DslTabLayout $lyTab;
        final /* synthetic */ QMUIViewPager $viewPager;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DslTabLayout dslTabLayout, QMUIViewPager qMUIViewPager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$lyTab = dslTabLayout;
            this.$viewPager = qMUIViewPager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HomepageFragment.this.new AnonymousClass1(this.$lyTab, this.$viewPager, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objAwait;
            HomepageRecommendFragment homepageRecommendFragment;
            boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            float f = 16.0f;
            int i2 = 16;
            boolean z2 = false;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextView textView = new TextView(HomepageFragment.this.getContext());
                    textView.setGravity(16);
                    textView.setText("推荐");
                    textView.setTextSize(16.0f);
                    textView.setTypeface(null, 1);
                    this.$lyTab.addView(textView);
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                    Context contextRequireContext = HomepageFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    int iDpToPx = ViewKt.dpToPx(contextRequireContext, 8.0f);
                    Context contextRequireContext2 = HomepageFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                    ((DslTabLayout.LayoutParams) layoutParams).setMargins(iDpToPx, 0, ViewKt.dpToPx(contextRequireContext2, 8.0f), 0);
                    HomepageRecommendFragment homepageRecommendFragment2 = new HomepageRecommendFragment();
                    HomepageFragment.this.tabFragments.add(homepageRecommendFragment2);
                    TextView textView2 = new TextView(HomepageFragment.this.getContext());
                    textView2.setGravity(16);
                    textView2.setText("更新");
                    textView2.setTextSize(16.0f);
                    textView2.setTypeface(null, 1);
                    this.$lyTab.addView(textView2);
                    ViewGroup.LayoutParams layoutParams2 = textView2.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                    Context contextRequireContext3 = HomepageFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
                    int iDpToPx2 = ViewKt.dpToPx(contextRequireContext3, 8.0f);
                    Context contextRequireContext4 = HomepageFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext()");
                    ((DslTabLayout.LayoutParams) layoutParams2).setMargins(iDpToPx2, 0, ViewKt.dpToPx(contextRequireContext4, 8.0f), 0);
                    HomepageFragment.this.tabFragments.add(new HomepageUpdateFragment());
                    TextView textView3 = new TextView(HomepageFragment.this.getContext());
                    textView3.setGravity(16);
                    textView3.setText("新书");
                    textView3.setTextSize(16.0f);
                    textView3.setTypeface(null, 1);
                    this.$lyTab.addView(textView3);
                    ViewGroup.LayoutParams layoutParams3 = textView3.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                    Context contextRequireContext5 = HomepageFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext()");
                    int iDpToPx3 = ViewKt.dpToPx(contextRequireContext5, 8.0f);
                    Context contextRequireContext6 = HomepageFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext()");
                    ((DslTabLayout.LayoutParams) layoutParams3).setMargins(iDpToPx3, 0, ViewKt.dpToPx(contextRequireContext6, 8.0f), 0);
                    HomepageFragment.this.tabFragments.add(new HomepageNewFragment());
                    this.L$0 = homepageRecommendFragment2;
                    this.label = 1;
                    objAwait = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new HomepageFragment$initTab$1$resp$1(null), 3, null).await(this);
                    if (objAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    homepageRecommendFragment = homepageRecommendFragment2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    homepageRecommendFragment = (HomepageRecommendFragment) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objAwait = obj;
                }
                Response response = (Response) objAwait;
                if (NetModelsKt.successWithData(response)) {
                    AppBody body = response.getBody();
                    Intrinsics.checkNotNull(body);
                    Object data = body.getData();
                    Intrinsics.checkNotNull(data);
                    List list = (List) data;
                    if (!list.isEmpty()) {
                        if (list.size() > 1) {
                            CollectionsKt.sortWith(list, new Comparator() { // from class: com.funny.audio.view.homepage.HomepageFragment$initTab$1$invokeSuspend$$inlined$sortBy$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.util.Comparator
                                public final int compare(T t, T t2) {
                                    return ComparisonsKt.compareValues(Integer.valueOf(((TabInfo) t).getSort()), Integer.valueOf(((TabInfo) t2).getSort()));
                                }
                            });
                        }
                        HomepageFragment homepageFragment = HomepageFragment.this;
                        DslTabLayout dslTabLayout = this.$lyTab;
                        int i3 = 0;
                        for (Object obj2 : list) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            TabInfo tabInfo = (TabInfo) obj2;
                            if (i3 == 0) {
                                homepageRecommendFragment.setTabId(tabInfo.getId());
                                z = z2;
                            } else {
                                TextView textView4 = new TextView(homepageFragment.getContext());
                                textView4.setGravity(i2);
                                textView4.setText(tabInfo.getName());
                                textView4.setTextSize(f);
                                textView4.setTypeface(null, 1);
                                dslTabLayout.addView(textView4);
                                ViewGroup.LayoutParams layoutParams4 = textView4.getLayoutParams();
                                Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                                Context contextRequireContext7 = homepageFragment.requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext7, "requireContext()");
                                int iDpToPx4 = ViewKt.dpToPx(contextRequireContext7, 8.0f);
                                Context contextRequireContext8 = homepageFragment.requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext8, "requireContext()");
                                z = false;
                                ((DslTabLayout.LayoutParams) layoutParams4).setMargins(iDpToPx4, 0, ViewKt.dpToPx(contextRequireContext8, 8.0f), 0);
                                HomepageTabPageFragment homepageTabPageFragment = new HomepageTabPageFragment();
                                homepageTabPageFragment.setTabId(tabInfo.getId());
                                homepageFragment.tabFragments.add(homepageTabPageFragment);
                            }
                            z2 = z;
                            i3 = i4;
                            f = 16.0f;
                            i2 = 16;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            ViewUtils viewUtils = ViewUtils.INSTANCE;
            FragmentManager childFragmentManager = HomepageFragment.this.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            this.$viewPager.setAdapter(viewUtils.createPageAdapter(childFragmentManager, HomepageFragment.this.tabFragments));
            this.$viewPager.setOffscreenPageLimit(HomepageFragment.this.tabFragments.size());
            ViewPager1Delegate.Companion.install$default(ViewPager1Delegate.INSTANCE, this.$viewPager, this.$lyTab, null, 4, null);
            return Unit.INSTANCE;
        }
    }

    private final void initStatusBar() {
        if (AppManager.INSTANCE.isNightMode()) {
            StatusBarUtils statusBarUtils = StatusBarUtils.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            statusBarUtils.setStatusBarDarkMode(fragmentActivityRequireActivity);
            return;
        }
        StatusBarUtils statusBarUtils2 = StatusBarUtils.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
        statusBarUtils2.setStatusBarLightMode(fragmentActivityRequireActivity2);
    }
}
