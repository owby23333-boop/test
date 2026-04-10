package com.zackratos.ultimatebarx.ultimatebarx;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarConfig;
import com.zackratos.ultimatebarx.ultimatebarx.core.CoreKt;
import com.zackratos.ultimatebarx.ultimatebarx.extension.ActivityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Operator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¨\u0006\b"}, d2 = {"applyNavigationBar", "", "Landroidx/fragment/app/Fragment;", "config", "Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarConfig;", "Landroidx/fragment/app/FragmentActivity;", "applyStatusBar", "applyStatusBarOnly", "ultimatebarx_release"}, k = 2, mv = {1, 1, 16})
public final class OperatorKt {
    public static final void applyStatusBar(FragmentActivity applyStatusBar, BarConfig config) {
        Intrinsics.checkParameterIsNotNull(applyStatusBar, "$this$applyStatusBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        CoreKt.ultimateBarXInitialization(applyStatusBar);
        FragmentActivity fragmentActivity = applyStatusBar;
        ActivityKt.setSystemUiFlagWithLight(applyStatusBar, config.getLight(), GlobalKt.getManager().getNavigationBarConfig$ultimatebarx_release(fragmentActivity).getLight());
        CoreKt.updateStatusBar(applyStatusBar, config);
        CoreKt.defaultNavigationBar(applyStatusBar);
        CoreKt.addObserver$default(fragmentActivity, false, 1, null);
    }

    public static final void applyNavigationBar(FragmentActivity applyNavigationBar, BarConfig config) {
        Intrinsics.checkParameterIsNotNull(applyNavigationBar, "$this$applyNavigationBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        CoreKt.ultimateBarXInitialization(applyNavigationBar);
        FragmentActivity fragmentActivity = applyNavigationBar;
        ActivityKt.setSystemUiFlagWithLight(applyNavigationBar, GlobalKt.getManager().getStatusBarConfig$ultimatebarx_release(fragmentActivity).getLight(), config.getLight());
        CoreKt.updateNavigationBar(applyNavigationBar, config);
        CoreKt.defaultStatusBar(applyNavigationBar);
        CoreKt.addObserver$default(fragmentActivity, false, 1, null);
    }

    public static final void applyStatusBar(Fragment applyStatusBar, BarConfig config) {
        Intrinsics.checkParameterIsNotNull(applyStatusBar, "$this$applyStatusBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        FragmentActivity fragmentActivityRequireActivity = applyStatusBar.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity, "requireActivity()");
        CoreKt.ultimateBarXInitialization(fragmentActivityRequireActivity);
        CoreKt.ultimateBarXInitialization(applyStatusBar);
        Fragment fragment = applyStatusBar;
        boolean light = GlobalKt.getManager().getNavigationBarConfig$ultimatebarx_release(fragment).getLight();
        FragmentActivity fragmentActivityRequireActivity2 = applyStatusBar.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity2, "requireActivity()");
        ActivityKt.setSystemUiFlagWithLight(fragmentActivityRequireActivity2, config.getLight(), light);
        CoreKt.updateStatusBar(applyStatusBar, config);
        FragmentActivity fragmentActivityRequireActivity3 = applyStatusBar.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity3, "requireActivity()");
        CoreKt.defaultNavigationBar(fragmentActivityRequireActivity3);
        CoreKt.addObserver$default(fragment, false, 1, null);
        FragmentActivity fragmentActivityRequireActivity4 = applyStatusBar.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity4, "requireActivity()");
        CoreKt.addObserver$default(fragmentActivityRequireActivity4, false, 1, null);
    }

    public static final void applyNavigationBar(Fragment applyNavigationBar, BarConfig config) {
        Intrinsics.checkParameterIsNotNull(applyNavigationBar, "$this$applyNavigationBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        FragmentActivity fragmentActivityRequireActivity = applyNavigationBar.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity, "requireActivity()");
        CoreKt.ultimateBarXInitialization(fragmentActivityRequireActivity);
        CoreKt.ultimateBarXInitialization(applyNavigationBar);
        Fragment fragment = applyNavigationBar;
        boolean light = GlobalKt.getManager().getStatusBarConfig$ultimatebarx_release(fragment).getLight();
        FragmentActivity fragmentActivityRequireActivity2 = applyNavigationBar.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity2, "requireActivity()");
        ActivityKt.setSystemUiFlagWithLight(fragmentActivityRequireActivity2, light, config.getLight());
        CoreKt.updateNavigationBar(applyNavigationBar, config);
        FragmentActivity fragmentActivityRequireActivity3 = applyNavigationBar.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity3, "requireActivity()");
        CoreKt.defaultStatusBar(fragmentActivityRequireActivity3);
        CoreKt.addObserver$default(fragment, false, 1, null);
        FragmentActivity fragmentActivityRequireActivity4 = applyNavigationBar.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity4, "requireActivity()");
        CoreKt.addObserver$default(fragmentActivityRequireActivity4, false, 1, null);
    }

    public static final void applyStatusBarOnly(FragmentActivity applyStatusBarOnly, BarConfig config) {
        Intrinsics.checkParameterIsNotNull(applyStatusBarOnly, "$this$applyStatusBarOnly");
        Intrinsics.checkParameterIsNotNull(config, "config");
        CoreKt.statusBarOnlyInitialization(applyStatusBarOnly);
        ActivityKt.setStatusBarSystemUiFlagWithLight(applyStatusBarOnly, config.getLight());
        CoreKt.updateStatusBar(applyStatusBarOnly, config);
        CoreKt.addObserver(applyStatusBarOnly, true);
    }

    public static final void applyStatusBarOnly(Fragment applyStatusBarOnly, BarConfig config) {
        Intrinsics.checkParameterIsNotNull(applyStatusBarOnly, "$this$applyStatusBarOnly");
        Intrinsics.checkParameterIsNotNull(config, "config");
        FragmentActivity fragmentActivityRequireActivity = applyStatusBarOnly.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity, "requireActivity()");
        CoreKt.statusBarOnlyInitialization(fragmentActivityRequireActivity);
        CoreKt.statusBarOnlyInitialization(applyStatusBarOnly);
        FragmentActivity fragmentActivityRequireActivity2 = applyStatusBarOnly.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity2, "requireActivity()");
        ActivityKt.setStatusBarSystemUiFlagWithLight(fragmentActivityRequireActivity2, config.getLight());
        CoreKt.updateStatusBar(applyStatusBarOnly, config);
        CoreKt.addObserver(applyStatusBarOnly, true);
        FragmentActivity fragmentActivityRequireActivity3 = applyStatusBarOnly.requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(fragmentActivityRequireActivity3, "requireActivity()");
        CoreKt.addObserver(fragmentActivityRequireActivity3, true);
    }
}
