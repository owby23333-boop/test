package com.zackratos.ultimatebarx.ultimatebarx.java;

import com.zackratos.ultimatebarx.ultimatebarx.bean.BarBackground;

/* JADX INFO: loaded from: classes4.dex */
public interface Operator {
    void apply();

    Operator background(BarBackground barBackground);

    Operator color(int i);

    Operator colorRes(int i);

    Operator drawableRes(int i);

    Operator fitWindow(boolean z);

    Operator light(boolean z);

    Operator lvlBackground(BarBackground barBackground);

    Operator lvlColor(int i);

    Operator lvlColorRes(int i);

    Operator lvlDrawableRes(int i);

    Operator transparent();
}
