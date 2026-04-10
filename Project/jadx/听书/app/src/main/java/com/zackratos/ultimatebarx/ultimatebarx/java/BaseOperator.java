package com.zackratos.ultimatebarx.ultimatebarx.java;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarBackground;
import com.zackratos.ultimatebarx.ultimatebarx.bean.BarConfig;

/* JADX INFO: loaded from: classes4.dex */
abstract class BaseOperator implements Operator {
    protected BarConfig config;
    private final LifecycleOwner owner;

    protected abstract void applyActivity(FragmentActivity fragmentActivity);

    protected abstract void applyFragment(Fragment fragment);

    public BaseOperator(LifecycleOwner lifecycleOwner, BarConfig barConfig) {
        this.owner = lifecycleOwner;
        this.config = barConfig;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator fitWindow(boolean z) {
        this.config.setFitWindow(z);
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator background(BarBackground barBackground) {
        this.config.setBackground(barBackground);
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator color(int i) {
        this.config.setColor(i);
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator colorRes(int i) {
        this.config.setColorRes(i);
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator drawableRes(int i) {
        this.config.setDrawableRes(i);
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator transparent() {
        this.config.transparent();
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator light(boolean z) {
        this.config.setLight(z);
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator lvlBackground(BarBackground barBackground) {
        this.config.setLvlBackground(barBackground);
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator lvlColor(int i) {
        this.config.setLvlColor(i);
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator lvlColorRes(int i) {
        this.config.setLvlColorRes(i);
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public Operator lvlDrawableRes(int i) {
        this.config.setLvlDrawableRes(i);
        return this;
    }

    @Override // com.zackratos.ultimatebarx.ultimatebarx.java.Operator
    public void apply() {
        LifecycleOwner lifecycleOwner = this.owner;
        if (lifecycleOwner instanceof FragmentActivity) {
            applyActivity((FragmentActivity) lifecycleOwner);
        } else if (lifecycleOwner instanceof Fragment) {
            applyFragment((Fragment) lifecycleOwner);
        }
    }
}
