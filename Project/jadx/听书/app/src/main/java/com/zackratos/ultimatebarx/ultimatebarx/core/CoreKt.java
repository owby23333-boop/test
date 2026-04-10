package com.zackratos.ultimatebarx.ultimatebarx.core;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXKt;
import com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXManager;
import com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXObserver;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarBackground;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarConfig;
import com.zackratos.ultimatebarx.ultimatebarx.extension.ActivityKt;
import com.zackratos.ultimatebarx.ultimatebarx.extension.ContextKt;
import com.zackratos.ultimatebarx.ultimatebarx.extension.IntKt;
import com.zackratos.ultimatebarx.ultimatebarx.extension.ViewKt;
import com.zackratos.ultimatebarx.ultimatebarx.rom.Rom;
import com.zackratos.ultimatebarx.ultimatebarx.view.ActivityTag;
import com.zackratos.ultimatebarx.ultimatebarx.view.Creator;
import com.zackratos.ultimatebarx.ultimatebarx.view.FragmentTag;
import com.zackratos.ultimatebarx.ultimatebarx.view.FrameLayoutCreator;
import com.zackratos.ultimatebarx.ultimatebarx.view.RelativeLayoutCreator;
import com.zackratos.ultimatebarx.ultimatebarx.view.Tag;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Core.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u00020\f*\u00020\u000fH\u0001\u001a\u0016\u0010\u0010\u001a\u00020\f*\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\f\u0010\u0014\u001a\u00020\f*\u00020\u000fH\u0001\u001a\f\u0010\u0015\u001a\u00020\f*\u00020\rH\u0003\u001a\f\u0010\u0016\u001a\u00020\f*\u00020\rH\u0001\u001a\f\u0010\u0017\u001a\u00020\f*\u00020\rH\u0001\u001a\f\u0010\u0018\u001a\u00020\f*\u00020\u000fH\u0002\u001a\f\u0010\u0018\u001a\u00020\f*\u00020\nH\u0002\u001a\f\u0010\u0018\u001a\u00020\f*\u00020\rH\u0002\u001a\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0002\u001a\u001c\u0010\u001e\u001a\u00020\f*\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0002\u001a\u0014\u0010 \u001a\u00020\f*\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0013H\u0002\u001a\f\u0010!\u001a\u00020\f*\u00020\rH\u0003\u001a\f\u0010\"\u001a\u00020\f*\u00020\nH\u0000\u001a\f\u0010\"\u001a\u00020\f*\u00020\rH\u0001\u001a\f\u0010#\u001a\u00020\f*\u00020\nH\u0000\u001a\f\u0010#\u001a\u00020\f*\u00020\rH\u0001\u001a\u0014\u0010$\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0002\u001a\u001c\u0010$\u001a\u00020\f*\u00020\u000f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002\u001a\u0014\u0010+\u001a\u00020\f*\u00020\n2\u0006\u0010'\u001a\u00020(H\u0001\u001a\u0014\u0010+\u001a\u00020\f*\u00020\r2\u0006\u0010'\u001a\u00020(H\u0001\u001a\u0014\u0010,\u001a\u00020\f*\u00020\n2\u0006\u0010'\u001a\u00020(H\u0003\u001a\u0014\u0010,\u001a\u00020\f*\u00020\r2\u0006\u0010'\u001a\u00020(H\u0003\u001a\u0014\u0010-\u001a\u00020\f*\u00020\n2\u0006\u0010'\u001a\u00020(H\u0001\u001a\u0014\u0010-\u001a\u00020\f*\u00020\r2\u0006\u0010'\u001a\u00020(H\u0001\u001a\u0014\u0010.\u001a\u00020\f*\u00020\n2\u0006\u0010'\u001a\u00020(H\u0003\u001a\u0014\u0010.\u001a\u00020\f*\u00020\r2\u0006\u0010'\u001a\u00020(H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005¨\u0006/"}, d2 = {"TAG_WRAPPER", "", "manager", "Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager;", "getManager", "()Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXManager;", "manager$delegate", "Lkotlin/Lazy;", "addFrameLayoutWrapper", "Landroid/view/ViewGroup;", "Landroidx/fragment/app/Fragment;", "addKeyboardListener", "", "Landroidx/fragment/app/FragmentActivity;", "addNavigationBarBottomPadding", "Landroid/view/View;", "addObserver", "Landroidx/lifecycle/LifecycleOwner;", "only", "", "addStatusBarTopPadding", "barInitialization", "defaultNavigationBar", "defaultStatusBar", "fixBottomNavigationViewPadding", "getCreator", "Lcom/zackratos/ultimatebarx/ultimatebarx/view/Creator;", "tag", "Lcom/zackratos/ultimatebarx/ultimatebarx/view/Tag;", "landscape", "setNavigationBarPadding", "fitWindow", "setStatusBarPadding", "statusBarInitialization", "statusBarOnlyInitialization", "ultimateBarXInitialization", "updateBackground", QMUISkinValueBuilder.BACKGROUND, "Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarBackground;", "config", "Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarConfig;", "endVersion", "", "updateNavigationBar", "updateNavigationBarView", "updateStatusBar", "updateStatusBarView", "ultimatebarx_release"}, k = 2, mv = {1, 1, 16})
public final class CoreKt {
    private static final String TAG_WRAPPER = "com.zackratos.ultimatebarx.ultimatebarx_fragment_wrapper";
    private static final Lazy manager$delegate = LazyKt.lazy(new Function0<UltimateBarXManager>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.core.CoreKt$manager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UltimateBarXManager invoke() {
            return UltimateBarXManager.INSTANCE.getInstance();
        }
    });

    private static final UltimateBarXManager getManager() {
        return (UltimateBarXManager) manager$delegate.getValue();
    }

    public static final void ultimateBarXInitialization(FragmentActivity ultimateBarXInitialization) {
        Intrinsics.checkParameterIsNotNull(ultimateBarXInitialization, "$this$ultimateBarXInitialization");
        FragmentActivity fragmentActivity = ultimateBarXInitialization;
        if (getManager().getInitialization$ultimatebarx_release(fragmentActivity)) {
            return;
        }
        getManager().putOriginConfig$ultimatebarx_release(ultimateBarXInitialization);
        barInitialization(ultimateBarXInitialization);
        fixBottomNavigationViewPadding(ultimateBarXInitialization);
        addKeyboardListener(ultimateBarXInitialization);
        getManager().putInitialization$ultimatebarx_release(fragmentActivity);
    }

    public static final void statusBarOnlyInitialization(FragmentActivity statusBarOnlyInitialization) {
        Intrinsics.checkParameterIsNotNull(statusBarOnlyInitialization, "$this$statusBarOnlyInitialization");
        FragmentActivity fragmentActivity = statusBarOnlyInitialization;
        if (getManager().getInitialization$ultimatebarx_release(fragmentActivity)) {
            return;
        }
        getManager().putOriginStatusBarConfig$ultimatebarx_release(statusBarOnlyInitialization);
        statusBarInitialization(statusBarOnlyInitialization);
        addKeyboardListener(statusBarOnlyInitialization);
        getManager().putInitialization$ultimatebarx_release(fragmentActivity);
    }

    public static final void ultimateBarXInitialization(Fragment ultimateBarXInitialization) throws IllegalAccessException {
        Intrinsics.checkParameterIsNotNull(ultimateBarXInitialization, "$this$ultimateBarXInitialization");
        Fragment fragment = ultimateBarXInitialization;
        if (getManager().getInitialization$ultimatebarx_release(fragment)) {
            return;
        }
        addFrameLayoutWrapper(ultimateBarXInitialization);
        UltimateBarXManager manager = getManager();
        FragmentActivity fragmentActivityRequireActivity = ultimateBarXInitialization.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity, "requireActivity()");
        BarConfig statusBarConfig$ultimatebarx_release = manager.getStatusBarConfig$ultimatebarx_release(fragmentActivityRequireActivity);
        BarConfig statusBarConfig$ultimatebarx_release2 = getManager().getStatusBarConfig$ultimatebarx_release(fragment);
        statusBarConfig$ultimatebarx_release2.setLight(statusBarConfig$ultimatebarx_release.getLight());
        getManager().putStatusBarConfig$ultimatebarx_release(fragment, statusBarConfig$ultimatebarx_release2);
        UltimateBarXManager manager2 = getManager();
        FragmentActivity fragmentActivityRequireActivity2 = ultimateBarXInitialization.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity2, "requireActivity()");
        BarConfig navigationBarConfig$ultimatebarx_release = manager2.getNavigationBarConfig$ultimatebarx_release(fragmentActivityRequireActivity2);
        BarConfig navigationBarConfig$ultimatebarx_release2 = getManager().getNavigationBarConfig$ultimatebarx_release(fragment);
        navigationBarConfig$ultimatebarx_release2.setLight(navigationBarConfig$ultimatebarx_release.getLight());
        getManager().putNavigationBarConfig$ultimatebarx_release(fragment, navigationBarConfig$ultimatebarx_release2);
        fixBottomNavigationViewPadding(ultimateBarXInitialization);
        getManager().putInitialization$ultimatebarx_release(fragment);
    }

    public static final void statusBarOnlyInitialization(Fragment statusBarOnlyInitialization) throws IllegalAccessException {
        Intrinsics.checkParameterIsNotNull(statusBarOnlyInitialization, "$this$statusBarOnlyInitialization");
        Fragment fragment = statusBarOnlyInitialization;
        if (getManager().getInitialization$ultimatebarx_release(fragment)) {
            return;
        }
        addFrameLayoutWrapper(statusBarOnlyInitialization);
        UltimateBarXManager manager = getManager();
        FragmentActivity fragmentActivityRequireActivity = statusBarOnlyInitialization.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity, "requireActivity()");
        BarConfig statusBarConfig$ultimatebarx_release = manager.getStatusBarConfig$ultimatebarx_release(fragmentActivityRequireActivity);
        BarConfig statusBarConfig$ultimatebarx_release2 = getManager().getStatusBarConfig$ultimatebarx_release(fragment);
        statusBarConfig$ultimatebarx_release2.setLight(statusBarConfig$ultimatebarx_release.getLight());
        getManager().putStatusBarConfig$ultimatebarx_release(fragment, statusBarConfig$ultimatebarx_release2);
        getManager().putInitialization$ultimatebarx_release(fragment);
    }

    public static final void updateStatusBar(FragmentActivity updateStatusBar, BarConfig config) {
        Intrinsics.checkParameterIsNotNull(updateStatusBar, "$this$updateStatusBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        updateStatusBarView(updateStatusBar, config);
        FragmentActivity fragmentActivity = updateStatusBar;
        getManager().putStatusBarDefault$ultimatebarx_release(fragmentActivity);
        getManager().putStatusBarConfig$ultimatebarx_release(fragmentActivity, config);
    }

    public static final void updateNavigationBar(FragmentActivity updateNavigationBar, BarConfig config) {
        Intrinsics.checkParameterIsNotNull(updateNavigationBar, "$this$updateNavigationBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        updateNavigationBarView(updateNavigationBar, config);
        FragmentActivity fragmentActivity = updateNavigationBar;
        getManager().putNavigationBarDefault$ultimatebarx_release(fragmentActivity);
        getManager().putNavigationBarConfig$ultimatebarx_release(fragmentActivity, config);
    }

    public static final void updateStatusBar(Fragment updateStatusBar, BarConfig config) throws IllegalAccessException {
        Intrinsics.checkParameterIsNotNull(updateStatusBar, "$this$updateStatusBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        BarConfig barConfigNewInstance = BarConfig.INSTANCE.newInstance();
        barConfigNewInstance.transparent();
        barConfigNewInstance.setLight(config.getLight());
        FragmentActivity fragmentActivityRequireActivity = updateStatusBar.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity, "requireActivity()");
        updateStatusBar(fragmentActivityRequireActivity, barConfigNewInstance);
        updateStatusBarView(updateStatusBar, config);
        Fragment fragment = updateStatusBar;
        getManager().putStatusBarDefault$ultimatebarx_release(fragment);
        getManager().putStatusBarConfig$ultimatebarx_release(fragment, config);
    }

    public static final void updateNavigationBar(Fragment updateNavigationBar, BarConfig config) throws IllegalAccessException {
        Intrinsics.checkParameterIsNotNull(updateNavigationBar, "$this$updateNavigationBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        BarConfig barConfigNewInstance = BarConfig.INSTANCE.newInstance();
        barConfigNewInstance.transparent();
        barConfigNewInstance.setLight(config.getLight());
        FragmentActivity fragmentActivityRequireActivity = updateNavigationBar.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity, "requireActivity()");
        updateNavigationBar(fragmentActivityRequireActivity, barConfigNewInstance);
        updateNavigationBarView(updateNavigationBar, config);
        Fragment fragment = updateNavigationBar;
        getManager().putNavigationBarDefault$ultimatebarx_release(fragment);
        getManager().putNavigationBarConfig$ultimatebarx_release(fragment, config);
    }

    public static final void defaultStatusBar(FragmentActivity defaultStatusBar) {
        Intrinsics.checkParameterIsNotNull(defaultStatusBar, "$this$defaultStatusBar");
        FragmentActivity fragmentActivity = defaultStatusBar;
        if (getManager().getStatusBarDefault$ultimatebarx_release(fragmentActivity)) {
            return;
        }
        updateStatusBar(defaultStatusBar, getManager().getStatusBarConfig$ultimatebarx_release(fragmentActivity));
    }

    public static final void defaultNavigationBar(FragmentActivity defaultNavigationBar) {
        Intrinsics.checkParameterIsNotNull(defaultNavigationBar, "$this$defaultNavigationBar");
        FragmentActivity fragmentActivity = defaultNavigationBar;
        if (getManager().getNavigationBarDefault$ultimatebarx_release(fragmentActivity)) {
            return;
        }
        updateNavigationBar(defaultNavigationBar, getManager().getNavigationBarConfig$ultimatebarx_release(fragmentActivity));
    }

    public static /* synthetic */ void addObserver$default(LifecycleOwner lifecycleOwner, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        addObserver(lifecycleOwner, z);
    }

    public static final void addObserver(LifecycleOwner addObserver, boolean z) {
        Intrinsics.checkParameterIsNotNull(addObserver, "$this$addObserver");
        if (getManager().getAddObserver$ultimatebarx_release(addObserver)) {
            return;
        }
        addObserver.getLifecycle().addObserver(new UltimateBarXObserver(z));
        getManager().putAddObserver$ultimatebarx_release(addObserver);
    }

    private static final void barInitialization(FragmentActivity fragmentActivity) {
        ViewGroup contentView = ActivityKt.getContentView(fragmentActivity);
        if (contentView != null) {
            contentView.setClipToPadding(false);
        }
        View rootView = ActivityKt.getRootView(fragmentActivity);
        if (rootView != null) {
            rootView.setFitsSystemWindows(false);
        }
        ActivityKt.barTransparent(fragmentActivity);
    }

    private static final void statusBarInitialization(FragmentActivity fragmentActivity) {
        ViewGroup contentView = ActivityKt.getContentView(fragmentActivity);
        if (contentView != null) {
            contentView.setClipToPadding(false);
        }
        View rootView = ActivityKt.getRootView(fragmentActivity);
        if (rootView != null) {
            rootView.setFitsSystemWindows(false);
        }
        ActivityKt.statusBarTransparent(fragmentActivity);
    }

    private static final void updateStatusBarView(FragmentActivity fragmentActivity, BarConfig barConfig) {
        Creator creator;
        ViewGroup contentView = ActivityKt.getContentView(fragmentActivity);
        if (contentView != null) {
            setStatusBarPadding(contentView, barConfig.getFitWindow());
        }
        boolean landscape = ContextKt.getLandscape(getManager().getContext$ultimatebarx_release());
        ViewGroup contentView2 = ActivityKt.getContentView(fragmentActivity);
        View statusBarView = (contentView2 == null || (creator = getCreator(contentView2, ActivityTag.INSTANCE.getInstance(), landscape)) == null) ? null : creator.getStatusBarView(fragmentActivity, barConfig.getFitWindow());
        if (statusBarView != null) {
            updateBackground(statusBarView, barConfig, 23);
        }
    }

    private static final void updateNavigationBarView(FragmentActivity fragmentActivity, BarConfig barConfig) {
        Creator creator;
        FragmentActivity fragmentActivity2 = fragmentActivity;
        if (getManager().getRom$ultimatebarx_release().navigationBarExist(fragmentActivity2)) {
            boolean landscape = ContextKt.getLandscape(getManager().getContext$ultimatebarx_release());
            ViewGroup contentView = ActivityKt.getContentView(fragmentActivity);
            if (contentView != null) {
                setNavigationBarPadding(contentView, landscape, barConfig.getFitWindow());
            }
            ViewGroup contentView2 = ActivityKt.getContentView(fragmentActivity);
            View navigationBarView = (contentView2 == null || (creator = getCreator(contentView2, ActivityTag.INSTANCE.getInstance(), landscape)) == null) ? null : creator.getNavigationBarView(fragmentActivity2, barConfig.getFitWindow());
            if (navigationBarView != null) {
                updateBackground(navigationBarView, barConfig, 26);
            }
        }
    }

    private static final void updateStatusBarView(Fragment fragment, BarConfig barConfig) throws IllegalAccessException {
        View statusBarView;
        ViewGroup viewGroupAddFrameLayoutWrapper = addFrameLayoutWrapper(fragment);
        setStatusBarPadding(viewGroupAddFrameLayoutWrapper, barConfig.getFitWindow());
        Creator creator = getCreator(viewGroupAddFrameLayoutWrapper, FragmentTag.INSTANCE.getInstance(), ContextKt.getLandscape(getManager().getContext$ultimatebarx_release()));
        if (creator != null) {
            Context contextRequireContext = fragment.requireContext();
            Intrinsics.checkExpressionValueIsNotNull(contextRequireContext, "requireContext()");
            statusBarView = creator.getStatusBarView(contextRequireContext, barConfig.getFitWindow());
        } else {
            statusBarView = null;
        }
        if (statusBarView != null) {
            updateBackground(statusBarView, barConfig, 23);
        }
    }

    private static final void updateNavigationBarView(Fragment fragment, BarConfig barConfig) throws IllegalAccessException {
        View navigationBarView;
        Rom rom$ultimatebarx_release = getManager().getRom$ultimatebarx_release();
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity, "requireActivity()");
        if (rom$ultimatebarx_release.navigationBarExist(fragmentActivityRequireActivity)) {
            ViewGroup viewGroupAddFrameLayoutWrapper = addFrameLayoutWrapper(fragment);
            boolean landscape = ContextKt.getLandscape(getManager().getContext$ultimatebarx_release());
            setNavigationBarPadding(viewGroupAddFrameLayoutWrapper, landscape, barConfig.getFitWindow());
            Creator creator = getCreator(viewGroupAddFrameLayoutWrapper, FragmentTag.INSTANCE.getInstance(), landscape);
            if (creator != null) {
                Context contextRequireContext = fragment.requireContext();
                Intrinsics.checkExpressionValueIsNotNull(contextRequireContext, "requireContext()");
                navigationBarView = creator.getNavigationBarView(contextRequireContext, barConfig.getFitWindow());
            } else {
                navigationBarView = null;
            }
            if (navigationBarView != null) {
                updateBackground(navigationBarView, barConfig, 26);
            }
        }
    }

    private static final ViewGroup addFrameLayoutWrapper(Fragment fragment) throws IllegalAccessException {
        View viewRequireView = fragment.requireView();
        Intrinsics.checkExpressionValueIsNotNull(viewRequireView, "requireView()");
        if (viewRequireView instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) viewRequireView;
            if (Intrinsics.areEqual(frameLayout.getTag(), TAG_WRAPPER)) {
                frameLayout.setClipToPadding(false);
                return (ViewGroup) viewRequireView;
            }
        }
        FrameLayout frameLayout2 = new FrameLayout(fragment.requireContext());
        frameLayout2.setClipToPadding(false);
        frameLayout2.setTag(TAG_WRAPPER);
        frameLayout2.setTag(R.id.fragment_container_view_tag, fragment);
        ViewParent parent = viewRequireView.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int iIndexOfChild = viewGroup.indexOfChild(viewRequireView);
            viewGroup.removeViewAt(iIndexOfChild);
            viewGroup.addView(frameLayout2, iIndexOfChild);
        }
        frameLayout2.addView(viewRequireView);
        getManager().getFragmentViewFiled$ultimatebarx_release().set(fragment, frameLayout2);
        return frameLayout2;
    }

    private static final Creator getCreator(ViewGroup viewGroup, Tag tag, boolean z) {
        if (viewGroup instanceof FrameLayout) {
            return new FrameLayoutCreator((FrameLayout) viewGroup, tag, z);
        }
        if (viewGroup instanceof RelativeLayout) {
            return new RelativeLayoutCreator((RelativeLayout) viewGroup, tag, z);
        }
        return null;
    }

    private static final void setStatusBarPadding(ViewGroup viewGroup, boolean z) {
        viewGroup.setPadding(viewGroup.getPaddingLeft(), z ? UltimateBarXKt.getStatusBarHeight() : 0, viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
    }

    private static final void setNavigationBarPadding(ViewGroup viewGroup, boolean z, boolean z2) {
        if (z) {
            viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), z2 ? UltimateBarXKt.getNavigationBarHeight() : 0, viewGroup.getPaddingBottom());
        } else {
            viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), z2 ? UltimateBarXKt.getNavigationBarHeight() : 0);
        }
    }

    private static final void updateBackground(View view, BarConfig barConfig, int i) {
        if (Build.VERSION.SDK_INT < i && barConfig.getLight() && updateBackground(view, barConfig.getLvlBackground())) {
            return;
        }
        updateBackground(view, barConfig.getBackground());
    }

    private static final boolean updateBackground(View view, BarBackground barBackground) {
        if (barBackground.getDrawableRes() > 0) {
            view.setBackgroundResource(barBackground.getDrawableRes());
            return true;
        }
        if (barBackground.getColorRes() > 0) {
            Context context = view.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            view.setBackgroundColor(ContextKt.getColorInt(context, barBackground.getColorRes()));
            return true;
        }
        if (barBackground.getColor() > -16777217) {
            view.setBackgroundColor(barBackground.getColor());
            return true;
        }
        view.setBackgroundColor(0);
        return false;
    }

    public static final void addStatusBarTopPadding(final View addStatusBarTopPadding) {
        Intrinsics.checkParameterIsNotNull(addStatusBarTopPadding, "$this$addStatusBarTopPadding");
        addStatusBarTopPadding.setPadding(addStatusBarTopPadding.getPaddingLeft(), addStatusBarTopPadding.getPaddingTop() + UltimateBarXKt.getStatusBarHeight(), addStatusBarTopPadding.getPaddingRight(), addStatusBarTopPadding.getPaddingBottom());
        final ViewGroup.LayoutParams layoutParams = addStatusBarTopPadding.getLayoutParams();
        if (addStatusBarTopPadding instanceof Toolbar) {
            int i = layoutParams.height;
            if (i == -2 || i == -1) {
                addStatusBarTopPadding.post(new Runnable() { // from class: com.zackratos.ultimatebarx.ultimatebarx.core.CoreKt.addStatusBarTopPadding.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        layoutParams.height = ((Toolbar) addStatusBarTopPadding).getHeight() + UltimateBarXKt.getStatusBarHeight();
                        ((Toolbar) addStatusBarTopPadding).setLayoutParams(layoutParams);
                    }
                });
                return;
            } else {
                layoutParams.height += UltimateBarXKt.getStatusBarHeight();
                ((Toolbar) addStatusBarTopPadding).setLayoutParams(layoutParams);
                return;
            }
        }
        int i2 = layoutParams.height;
        if (i2 != -2) {
            if (i2 == -1) {
                addStatusBarTopPadding.post(new Runnable() { // from class: com.zackratos.ultimatebarx.ultimatebarx.core.CoreKt.addStatusBarTopPadding.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        layoutParams.height = addStatusBarTopPadding.getHeight() + UltimateBarXKt.getStatusBarHeight();
                        addStatusBarTopPadding.setLayoutParams(layoutParams);
                    }
                });
            } else {
                layoutParams.height += UltimateBarXKt.getStatusBarHeight();
                addStatusBarTopPadding.setLayoutParams(layoutParams);
            }
        }
    }

    public static final void addNavigationBarBottomPadding(final View addNavigationBarBottomPadding) {
        Intrinsics.checkParameterIsNotNull(addNavigationBarBottomPadding, "$this$addNavigationBarBottomPadding");
        Context context = addNavigationBarBottomPadding.getContext();
        if (!(context instanceof FragmentActivity) || getManager().getRom$ultimatebarx_release().navigationBarExist(context)) {
            addNavigationBarBottomPadding.setPadding(addNavigationBarBottomPadding.getPaddingLeft(), addNavigationBarBottomPadding.getPaddingTop(), addNavigationBarBottomPadding.getPaddingRight(), addNavigationBarBottomPadding.getPaddingBottom() + UltimateBarXKt.getNavigationBarHeight());
            final ViewGroup.LayoutParams layoutParams = addNavigationBarBottomPadding.getLayoutParams();
            if (addNavigationBarBottomPadding instanceof Toolbar) {
                int i = layoutParams.height;
                if (i == -2 || i == -1) {
                    addNavigationBarBottomPadding.post(new Runnable() { // from class: com.zackratos.ultimatebarx.ultimatebarx.core.CoreKt.addNavigationBarBottomPadding.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            layoutParams.height = ((Toolbar) addNavigationBarBottomPadding).getHeight() + UltimateBarXKt.getNavigationBarHeight();
                            ((Toolbar) addNavigationBarBottomPadding).setLayoutParams(layoutParams);
                        }
                    });
                    return;
                } else {
                    layoutParams.height += UltimateBarXKt.getNavigationBarHeight();
                    ((Toolbar) addNavigationBarBottomPadding).setLayoutParams(layoutParams);
                    return;
                }
            }
            int i2 = layoutParams.height;
            if (i2 != -2) {
                if (i2 == -1) {
                    addNavigationBarBottomPadding.post(new Runnable() { // from class: com.zackratos.ultimatebarx.ultimatebarx.core.CoreKt.addNavigationBarBottomPadding.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            layoutParams.height = addNavigationBarBottomPadding.getHeight() + UltimateBarXKt.getNavigationBarHeight();
                            addNavigationBarBottomPadding.setLayoutParams(layoutParams);
                        }
                    });
                } else {
                    layoutParams.height += UltimateBarXKt.getNavigationBarHeight();
                    addNavigationBarBottomPadding.setLayoutParams(layoutParams);
                }
            }
        }
    }

    private static final void fixBottomNavigationViewPadding(FragmentActivity fragmentActivity) {
        View rootView = ActivityKt.getRootView(fragmentActivity);
        if (rootView != null) {
            fixBottomNavigationViewPadding(rootView);
        }
    }

    private static final void fixBottomNavigationViewPadding(Fragment fragment) {
        View view = fragment.getView();
        if (view != null) {
            fixBottomNavigationViewPadding(view);
        }
    }

    private static final void fixBottomNavigationViewPadding(View view) {
        for (final View view2 : ViewKt.getChildren(view)) {
            if (view2 instanceof BottomNavigationView) {
                final int paddingBottom = ((BottomNavigationView) view2).getPaddingBottom();
                view2.post(new Runnable() { // from class: com.zackratos.ultimatebarx.ultimatebarx.core.CoreKt.fixBottomNavigationViewPadding.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        View view3 = view2;
                        view3.setPadding(((BottomNavigationView) view3).getPaddingLeft(), ((BottomNavigationView) view2).getPaddingTop(), ((BottomNavigationView) view2).getPaddingRight(), paddingBottom);
                    }
                });
            }
        }
    }

    public static final void addKeyboardListener(final FragmentActivity addKeyboardListener) {
        Intrinsics.checkParameterIsNotNull(addKeyboardListener, "$this$addKeyboardListener");
        final View rootView = ActivityKt.getRootView(addKeyboardListener);
        if (rootView != null) {
            com.zackratos.kblistener.kblistener.ViewKt.onKeyboardOpen(rootView, new Function1<Integer, Unit>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.core.CoreKt$addKeyboardListener$$inlined$run$lambda$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    WindowManager.LayoutParams attributes;
                    ViewGroup.LayoutParams layoutParams;
                    Window window = addKeyboardListener.getWindow();
                    if (window == null || (attributes = window.getAttributes()) == null || !IntKt.contain(attributes.softInputMode, 16) || (layoutParams = rootView.getLayoutParams()) == null) {
                        return;
                    }
                    layoutParams.height = rootView.getHeight() - i;
                    rootView.setLayoutParams(layoutParams);
                }
            });
            com.zackratos.kblistener.kblistener.ViewKt.onKeyboardClose(rootView, new Function1<Integer, Unit>() { // from class: com.zackratos.ultimatebarx.ultimatebarx.core.CoreKt$addKeyboardListener$$inlined$run$lambda$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i) {
                    WindowManager.LayoutParams attributes;
                    ViewGroup.LayoutParams layoutParams;
                    Window window = addKeyboardListener.getWindow();
                    if (window == null || (attributes = window.getAttributes()) == null || !IntKt.contain(attributes.softInputMode, 16) || (layoutParams = rootView.getLayoutParams()) == null) {
                        return;
                    }
                    layoutParams.height = i;
                    rootView.setLayoutParams(layoutParams);
                }
            });
        }
    }
}
