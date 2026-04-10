package com.funny.audio.view.category;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.funny.audio.databinding.FragmentCategoryBinding;
import com.funny.audio.models.CategoryItem;
import com.funny.audio.view.NavigationUtils;
import com.funny.audio.view.ViewUtils;
import com.funny.audio.view.core.BaseFragment;
import com.funny.audio.view.core.StatusBarUtils;
import com.qmuiteam.qmui.widget.QMUIViewPager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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

/* JADX INFO: compiled from: CategoryFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/funny/audio/view/category/CategoryFragment;", "Lcom/funny/audio/view/core/BaseFragment;", "Lcom/funny/audio/databinding/FragmentCategoryBinding;", "()V", "fragments", "", "initStatusBar", "", "initTab", "initView", "view", "Landroid/view/View;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CategoryFragment extends BaseFragment<FragmentCategoryBinding> {
    private final List<BaseFragment<?>> fragments = new ArrayList();

    @Override // com.funny.audio.view.core.BaseFragment
    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initStatusBar();
        initTab();
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

    private final void initTab() {
        ImageView imageView = getBd().ivSearch;
        Intrinsics.checkNotNullExpressionValue(imageView, "bd.ivSearch");
        ViewKt.click$default(imageView, 0, new Function0<Unit>() { // from class: com.funny.audio.view.category.CategoryFragment.initTab.1
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
                NavigationUtils.INSTANCE.toSearch(CategoryFragment.this.requireActivity());
            }
        }, 1, null);
        DslTabLayout dslTabLayout = getBd().lyTab;
        Intrinsics.checkNotNullExpressionValue(dslTabLayout, "bd.lyTab");
        QMUIViewPager qMUIViewPager = getBd().viewPager;
        Intrinsics.checkNotNullExpressionValue(qMUIViewPager, "bd.viewPager");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass2(dslTabLayout, qMUIViewPager, null), 3, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.view.category.CategoryFragment$initTab$2, reason: invalid class name */
    /* JADX INFO: compiled from: CategoryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.view.category.CategoryFragment$initTab$2", f = "CategoryFragment.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DslTabLayout $lyTab;
        final /* synthetic */ QMUIViewPager $viewPager;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DslTabLayout dslTabLayout, QMUIViewPager qMUIViewPager, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$lyTab = dslTabLayout;
            this.$viewPager = qMUIViewPager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CategoryFragment.this.new AnonymousClass2(this.$lyTab, this.$viewPager, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CategoryFragment$initTab$2$resp$1(null), 3, null).await(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Response response = (Response) obj;
                if (NetModelsKt.successWithData(response)) {
                    AppBody body = response.getBody();
                    Intrinsics.checkNotNull(body);
                    Object data = body.getData();
                    Intrinsics.checkNotNull(data);
                    for (CategoryItem categoryItem : (List) data) {
                        TextView textView = new TextView(CategoryFragment.this.getContext());
                        textView.setGravity(16);
                        textView.setText(categoryItem.getCategoryName());
                        textView.setTextSize(16.0f);
                        textView.setTypeface(null, 1);
                        this.$lyTab.addView(textView);
                        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.angcyo.tablayout.DslTabLayout.LayoutParams");
                        Context contextRequireContext = CategoryFragment.this.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                        int iDpToPx = ViewKt.dpToPx(contextRequireContext, 8.0f);
                        Context contextRequireContext2 = CategoryFragment.this.requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                        ((DslTabLayout.LayoutParams) layoutParams).setMargins(iDpToPx, 0, ViewKt.dpToPx(contextRequireContext2, 8.0f), 0);
                        CategoryPageFragment categoryPageFragment = new CategoryPageFragment();
                        categoryPageFragment.setCategoryId(categoryItem.getId());
                        CategoryFragment.this.fragments.add(categoryPageFragment);
                    }
                    if (!CategoryFragment.this.fragments.isEmpty()) {
                        ViewUtils viewUtils = ViewUtils.INSTANCE;
                        FragmentManager childFragmentManager = CategoryFragment.this.getChildFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "this@CategoryFragment.childFragmentManager");
                        this.$viewPager.setAdapter(viewUtils.createPageAdapter(childFragmentManager, CategoryFragment.this.fragments));
                        this.$viewPager.setOffscreenPageLimit(CategoryFragment.this.fragments.size());
                        this.$viewPager.setSwipeable(true);
                        ViewPager1Delegate.Companion.install$default(ViewPager1Delegate.INSTANCE, this.$viewPager, this.$lyTab, null, 4, null);
                    }
                }
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }
    }
}
