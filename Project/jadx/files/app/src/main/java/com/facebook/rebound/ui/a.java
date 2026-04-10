package com.facebook.rebound.ui;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final int a(float f2, Resources resources) {
        return (int) TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
    }

    public static final FrameLayout.LayoutParams b() {
        return a(-1, -2);
    }

    public static final FrameLayout.LayoutParams a(int i2, int i3) {
        return new FrameLayout.LayoutParams(i2, i3);
    }

    public static final FrameLayout.LayoutParams a() {
        return a(-1, -1);
    }
}
