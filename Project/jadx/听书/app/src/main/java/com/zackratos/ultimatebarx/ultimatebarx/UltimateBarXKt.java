package com.zackratos.ultimatebarx.ultimatebarx;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarConfig;
import com.zackratos.ultimatebarx.ultimatebarx.core.CoreKt;
import com.zackratos.ultimatebarx.ultimatebarx.extension.ContextKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UltimateBarX.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0010*\u00020\u0011\u001a'\u0010\u0013\u001a\u00020\u0010*\u00020\b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a'\u0010\u0013\u001a\u00020\u0010*\u00020\u000b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a'\u0010\u0017\u001a\u00020\u0010*\u00020\b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a'\u0010\u0017\u001a\u00020\u0010*\u00020\u000b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a'\u0010\u0018\u001a\u00020\u0010*\u00020\b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a'\u0010\u0018\u001a\u00020\u0010*\u00020\u000b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a'\u0010\u0019\u001a\u00020\u0010*\u00020\b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a1\u0010\u0019\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00072\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016H\u0001\u001a'\u0010\u0019\u001a\u00020\u0010*\u00020\u000b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a1\u0010\u0019\u001a\u00020\u0010*\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00072\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016H\u0001\u001a'\u0010\u001b\u001a\u00020\u0010*\u00020\b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a1\u0010\u001b\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00072\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016H\u0001\u001a'\u0010\u001b\u001a\u00020\u0010*\u00020\u000b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a1\u0010\u001b\u001a\u00020\u0010*\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00072\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016H\u0001\u001a'\u0010\u001c\u001a\u00020\u0010*\u00020\b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a1\u0010\u001c\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00072\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016H\u0001\u001a'\u0010\u001c\u001a\u00020\u0010*\u00020\u000b2\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016\u001a1\u0010\u001c\u001a\u00020\u0010*\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00072\u001b\b\u0002\u0010\u0014\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015¢\u0006\u0002\b\u0016H\u0001\"\u0011\u0010\u0000\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\f\"\u0015\u0010\r\u001a\u00020\u0007*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n\"\u0015\u0010\r\u001a\u00020\u0007*\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u001d"}, d2 = {"navigationBarHeight", "", "getNavigationBarHeight", "()I", "statusBarHeight", "getStatusBarHeight", "navigationBarConfig", "Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarConfig;", "Landroidx/fragment/app/Fragment;", "getNavigationBarConfig", "(Landroidx/fragment/app/Fragment;)Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarConfig;", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)Lcom/zackratos/ultimatebarx/ultimatebarx/bean/BarConfig;", "statusBarConfig", "getStatusBarConfig", "addNavigationBarBottomPadding", "", "Landroid/view/View;", "addStatusBarTopPadding", "getNavigationBar", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getStatusBar", "getStatusBarOnly", "navigationBar", "config", "statusBar", "statusBarOnly", "ultimatebarx_release"}, k = 2, mv = {1, 1, 16})
public final class UltimateBarXKt {
    public static final void statusBar(FragmentActivity statusBar, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(statusBar, "$this$statusBar");
        statusBar(statusBar, BarConfig.INSTANCE.newInstance(), function1);
    }

    public static /* synthetic */ void statusBar$default(FragmentActivity fragmentActivity, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        statusBar(fragmentActivity, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void navigationBar(FragmentActivity navigationBar, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(navigationBar, "$this$navigationBar");
        navigationBar(navigationBar, BarConfig.INSTANCE.newInstance(), function1);
    }

    public static /* synthetic */ void navigationBar$default(FragmentActivity fragmentActivity, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        navigationBar(fragmentActivity, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void statusBarOnly(FragmentActivity statusBarOnly, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(statusBarOnly, "$this$statusBarOnly");
        statusBarOnly(statusBarOnly, BarConfig.INSTANCE.newInstance(), function1);
    }

    public static /* synthetic */ void statusBarOnly$default(FragmentActivity fragmentActivity, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        statusBarOnly(fragmentActivity, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void getStatusBar(FragmentActivity getStatusBar, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(getStatusBar, "$this$getStatusBar");
        statusBar(getStatusBar, getStatusBarConfig(getStatusBar), function1);
    }

    public static /* synthetic */ void getStatusBar$default(FragmentActivity fragmentActivity, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        getStatusBar(fragmentActivity, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void getNavigationBar(FragmentActivity getNavigationBar, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(getNavigationBar, "$this$getNavigationBar");
        navigationBar(getNavigationBar, getNavigationBarConfig(getNavigationBar), function1);
    }

    public static /* synthetic */ void getNavigationBar$default(FragmentActivity fragmentActivity, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        getNavigationBar(fragmentActivity, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void getStatusBarOnly(FragmentActivity getStatusBarOnly, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(getStatusBarOnly, "$this$getStatusBarOnly");
        statusBarOnly(getStatusBarOnly, getStatusBarConfig(getStatusBarOnly), function1);
    }

    public static /* synthetic */ void getStatusBarOnly$default(FragmentActivity fragmentActivity, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        getStatusBarOnly(fragmentActivity, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void statusBar(Fragment statusBar, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(statusBar, "$this$statusBar");
        statusBar(statusBar, BarConfig.INSTANCE.newInstance(), function1);
    }

    public static /* synthetic */ void statusBar$default(Fragment fragment, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        statusBar(fragment, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void navigationBar(Fragment navigationBar, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(navigationBar, "$this$navigationBar");
        navigationBar(navigationBar, BarConfig.INSTANCE.newInstance(), function1);
    }

    public static /* synthetic */ void navigationBar$default(Fragment fragment, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        navigationBar(fragment, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void statusBarOnly(Fragment statusBarOnly, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(statusBarOnly, "$this$statusBarOnly");
        statusBarOnly(statusBarOnly, BarConfig.INSTANCE.newInstance(), function1);
    }

    public static /* synthetic */ void statusBarOnly$default(Fragment fragment, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        statusBarOnly(fragment, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void getStatusBar(Fragment getStatusBar, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(getStatusBar, "$this$getStatusBar");
        statusBar(getStatusBar, getStatusBarConfig(getStatusBar), function1);
    }

    public static /* synthetic */ void getStatusBar$default(Fragment fragment, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        getStatusBar(fragment, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void getNavigationBar(Fragment getNavigationBar, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(getNavigationBar, "$this$getNavigationBar");
        navigationBar(getNavigationBar, getNavigationBarConfig(getNavigationBar), function1);
    }

    public static /* synthetic */ void getNavigationBar$default(Fragment fragment, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        getNavigationBar(fragment, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void getStatusBarOnly(Fragment getStatusBarOnly, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(getStatusBarOnly, "$this$getStatusBarOnly");
        statusBarOnly(getStatusBarOnly, getStatusBarConfig(getStatusBarOnly), function1);
    }

    public static /* synthetic */ void getStatusBarOnly$default(Fragment fragment, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        getStatusBarOnly(fragment, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final BarConfig getStatusBarConfig(FragmentActivity statusBarConfig) {
        Intrinsics.checkParameterIsNotNull(statusBarConfig, "$this$statusBarConfig");
        return GlobalKt.getManager().getStatusBarConfig$ultimatebarx_release(statusBarConfig);
    }

    public static final BarConfig getNavigationBarConfig(FragmentActivity navigationBarConfig) {
        Intrinsics.checkParameterIsNotNull(navigationBarConfig, "$this$navigationBarConfig");
        return GlobalKt.getManager().getNavigationBarConfig$ultimatebarx_release(navigationBarConfig);
    }

    public static final BarConfig getStatusBarConfig(Fragment statusBarConfig) {
        Intrinsics.checkParameterIsNotNull(statusBarConfig, "$this$statusBarConfig");
        return GlobalKt.getManager().getStatusBarConfig$ultimatebarx_release(statusBarConfig);
    }

    public static final BarConfig getNavigationBarConfig(Fragment navigationBarConfig) {
        Intrinsics.checkParameterIsNotNull(navigationBarConfig, "$this$navigationBarConfig");
        return GlobalKt.getManager().getNavigationBarConfig$ultimatebarx_release(navigationBarConfig);
    }

    public static final int getStatusBarHeight() {
        return ContextKt.getStatusBarHeight(GlobalKt.getManager().getContext$ultimatebarx_release());
    }

    public static final int getNavigationBarHeight() {
        if (GlobalKt.getManager().getRom$ultimatebarx_release().navigationBarExist(GlobalKt.getManager().getContext$ultimatebarx_release())) {
            return ContextKt.getNavigationBarHeight(GlobalKt.getManager().getContext$ultimatebarx_release());
        }
        return 0;
    }

    public static final void addStatusBarTopPadding(View addStatusBarTopPadding) {
        Intrinsics.checkParameterIsNotNull(addStatusBarTopPadding, "$this$addStatusBarTopPadding");
        CoreKt.addStatusBarTopPadding(addStatusBarTopPadding);
    }

    public static final void addNavigationBarBottomPadding(View addNavigationBarBottomPadding) {
        Intrinsics.checkParameterIsNotNull(addNavigationBarBottomPadding, "$this$addNavigationBarBottomPadding");
        CoreKt.addNavigationBarBottomPadding(addNavigationBarBottomPadding);
    }

    public static /* synthetic */ void statusBar$default(FragmentActivity fragmentActivity, BarConfig barConfig, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        statusBar(fragmentActivity, barConfig, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void statusBar(FragmentActivity statusBar, BarConfig config, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(statusBar, "$this$statusBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (GlobalKt.getNeedApply()) {
            if (function1 != null) {
                function1.invoke(config);
            }
            OperatorKt.applyStatusBar(statusBar, config);
        }
    }

    public static /* synthetic */ void navigationBar$default(FragmentActivity fragmentActivity, BarConfig barConfig, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        navigationBar(fragmentActivity, barConfig, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void navigationBar(FragmentActivity navigationBar, BarConfig config, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(navigationBar, "$this$navigationBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (GlobalKt.getNeedApply()) {
            if (function1 != null) {
                function1.invoke(config);
            }
            OperatorKt.applyNavigationBar(navigationBar, config);
        }
    }

    public static /* synthetic */ void statusBarOnly$default(FragmentActivity fragmentActivity, BarConfig barConfig, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        statusBarOnly(fragmentActivity, barConfig, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void statusBarOnly(FragmentActivity statusBarOnly, BarConfig config, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(statusBarOnly, "$this$statusBarOnly");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (GlobalKt.getNeedApply()) {
            if (function1 != null) {
                function1.invoke(config);
            }
            OperatorKt.applyStatusBarOnly(statusBarOnly, config);
        }
    }

    public static /* synthetic */ void statusBar$default(Fragment fragment, BarConfig barConfig, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        statusBar(fragment, barConfig, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void statusBar(Fragment statusBar, BarConfig config, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(statusBar, "$this$statusBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (GlobalKt.getNeedApply()) {
            if (function1 != null) {
                function1.invoke(config);
            }
            OperatorKt.applyStatusBar(statusBar, config);
        }
    }

    public static /* synthetic */ void navigationBar$default(Fragment fragment, BarConfig barConfig, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        navigationBar(fragment, barConfig, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void navigationBar(Fragment navigationBar, BarConfig config, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(navigationBar, "$this$navigationBar");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (GlobalKt.getNeedApply()) {
            if (function1 != null) {
                function1.invoke(config);
            }
            OperatorKt.applyNavigationBar(navigationBar, config);
        }
    }

    public static /* synthetic */ void statusBarOnly$default(Fragment fragment, BarConfig barConfig, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        statusBarOnly(fragment, barConfig, (Function1<? super BarConfig, Unit>) function1);
    }

    public static final void statusBarOnly(Fragment statusBarOnly, BarConfig config, Function1<? super BarConfig, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(statusBarOnly, "$this$statusBarOnly");
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (GlobalKt.getNeedApply()) {
            if (function1 != null) {
                function1.invoke(config);
            }
            OperatorKt.applyStatusBarOnly(statusBarOnly, config);
        }
    }
}
