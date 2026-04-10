package com.amgcyo.cuttadon.widget.ui;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: compiled from: FixedSpeedScroller.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Scroller {
    private int a;

    public a(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.a = TTAdConstant.STYLE_SIZE_RADIO_3_2;
    }

    public void a(int i2) {
        this.a = i2;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5, int i6) {
        super.startScroll(i2, i3, i4, i5, this.a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i2, int i3, int i4, int i5) {
        super.startScroll(i2, i3, i4, i5, this.a);
    }
}
