package com.amgcyo.cuttadon.utils.otherutils;

import android.R;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/* JADX INFO: compiled from: SelectorHepler.java */
/* JADX INFO: loaded from: classes.dex */
public class k0 {
    private static k0 a;

    private k0() {
    }

    public static synchronized k0 a() {
        if (a == null) {
            a = new k0();
        }
        return a;
    }

    public StateListDrawable a(Context context, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(8.0f);
        gradientDrawable.setStroke(com.amgcyo.cuttadon.widget.util.a.a(context, 2.0f), i2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(8.0f);
        gradientDrawable2.setStroke(com.amgcyo.cuttadon.widget.util.a.a(context, 0.5f), i2);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    public StateListDrawable a(Context context, int i2, int i3, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable.setStroke(com.amgcyo.cuttadon.widget.util.a.a(context, 1.5f), i2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(f2);
        gradientDrawable2.setStroke(com.amgcyo.cuttadon.widget.util.a.a(context, 1.0f), i3);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }
}
