package com.zackratos.ultimatebarx.ultimatebarx.java;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.zackratos.ultimatebarx.ultimatebarx.UltimateBarXKt;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarBackground;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public class StatusBarOperator extends BaseOperator {
    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ void apply() {
        super.apply();
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator background(BarBackground barBackground) {
        return super.background(barBackground);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator color(int i) {
        return super.color(i);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator colorRes(int i) {
        return super.colorRes(i);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator drawableRes(int i) {
        return super.drawableRes(i);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator fitWindow(boolean z) {
        return super.fitWindow(z);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator light(boolean z) {
        return super.light(z);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator lvlBackground(BarBackground barBackground) {
        return super.lvlBackground(barBackground);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator lvlColor(int i) {
        return super.lvlColor(i);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator lvlColorRes(int i) {
        return super.lvlColorRes(i);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator lvlDrawableRes(int i) {
        return super.lvlDrawableRes(i);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator, com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public /* bridge */ /* synthetic */ Operator transparent() {
        return super.transparent();
    }

    public StatusBarOperator(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, BarConfig.INSTANCE.newInstance());
    }

    public StatusBarOperator(LifecycleOwner lifecycleOwner, BarConfig barConfig) {
        super(lifecycleOwner, barConfig);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator
    protected void applyActivity(FragmentActivity fragmentActivity) {
        UltimateBarXKt.statusBar(fragmentActivity, this.config, (Function1<? super BarConfig, Unit>) null);
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.BaseOperator
    protected void applyFragment(Fragment fragment) {
        UltimateBarXKt.statusBar(fragment, this.config, (Function1<? super BarConfig, Unit>) null);
    }
}
