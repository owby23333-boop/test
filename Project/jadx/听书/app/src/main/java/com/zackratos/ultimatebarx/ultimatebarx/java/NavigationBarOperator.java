package com.zackratos.ultimatebarx.ultimatebarx.java;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXKt;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
class NavigationBarOperator extends BaseOperator {
    public NavigationBarOperator(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, BarConfig.INSTANCE.newInstance());
    }

    public NavigationBarOperator(LifecycleOwner lifecycleOwner, BarConfig barConfig) {
        super(lifecycleOwner, barConfig);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator
    protected void applyActivity(FragmentActivity fragmentActivity) {
        UltimateBarXKt.navigationBar(fragmentActivity, this.config, (Function1<? super BarConfig, Unit>) null);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator
    protected void applyFragment(Fragment fragment) {
        UltimateBarXKt.navigationBar(fragment, this.config, (Function1<? super BarConfig, Unit>) null);
    }
}
