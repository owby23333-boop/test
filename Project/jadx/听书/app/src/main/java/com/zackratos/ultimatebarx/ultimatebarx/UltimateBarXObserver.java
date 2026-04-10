package com.zackratos.ultimatebarx.ultimatebarx;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UltimateBarXObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\f\u0010\n\u001a\u00020\u0006*\u00020\u000bH\u0002J\f\u0010\f\u001a\u00020\u0006*\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/zackratos/ultimatebarx/ultimatebarx/UltimateBarXObserver;", "Landroidx/lifecycle/LifecycleObserver;", "only", "", "(Z)V", "onDestroy", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onResume", "resetLight", "Landroidx/fragment/app/Fragment;", "resetStatusBarOnlyLight", "ultimatebarx_release"}, k = 1, mv = {1, 1, 16})
public final class UltimateBarXObserver implements LifecycleObserver {
    private final boolean only;

    public UltimateBarXObserver(boolean z) {
        this.only = z;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        UltimateBarXManager.INSTANCE.getInstance().removeAllData$ultimatebarx_release(owner);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume(LifecycleOwner owner) {
        Intrinsics.checkParameterIsNotNull(owner, "owner");
        if (owner instanceof Fragment) {
            if (this.only) {
                resetStatusBarOnlyLight((Fragment) owner);
            } else {
                resetLight((Fragment) owner);
            }
        }
    }

    private final void resetStatusBarOnlyLight(Fragment fragment) {
        if (UltimateBarXManager.INSTANCE.getInstance().getStatusBarDefault$ultimatebarx_release(fragment)) {
            BarConfig statusBarConfig = UltimateBarXKt.getStatusBarConfig(fragment);
            FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
            Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity, "requireActivity()");
            if (statusBarConfig.getLight() != UltimateBarXKt.getStatusBarConfig(fragmentActivityRequireActivity).getLight()) {
                UltimateBarXKt.getStatusBarOnly$default(fragment, (Function1) null, 1, (Object) null);
            }
        }
    }

    private final void resetLight(Fragment fragment) {
        Fragment fragment2 = fragment;
        boolean statusBarDefault$ultimatebarx_release = UltimateBarXManager.INSTANCE.getInstance().getStatusBarDefault$ultimatebarx_release(fragment2);
        boolean navigationBarDefault$ultimatebarx_release = UltimateBarXManager.INSTANCE.getInstance().getNavigationBarDefault$ultimatebarx_release(fragment2);
        if (statusBarDefault$ultimatebarx_release) {
            BarConfig statusBarConfig = UltimateBarXKt.getStatusBarConfig(fragment);
            FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
            Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity, "requireActivity()");
            if (statusBarConfig.getLight() != UltimateBarXKt.getStatusBarConfig(fragmentActivityRequireActivity).getLight()) {
                UltimateBarXKt.getStatusBar$default(fragment, (Function1) null, 1, (Object) null);
            }
        }
        if (navigationBarDefault$ultimatebarx_release) {
            BarConfig navigationBarConfig = UltimateBarXKt.getNavigationBarConfig(fragment);
            FragmentActivity fragmentActivityRequireActivity2 = fragment.requireActivity();
            Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity2, "requireActivity()");
            if (navigationBarConfig.getLight() != UltimateBarXKt.getNavigationBarConfig(fragmentActivityRequireActivity2).getLight()) {
                UltimateBarXKt.getNavigationBar$default(fragment, (Function1) null, 1, (Object) null);
            }
        }
    }
}
