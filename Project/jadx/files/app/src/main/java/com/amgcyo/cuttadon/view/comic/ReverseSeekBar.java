package com.amgcyo.cuttadon.view.comic;

import android.content.Context;
import android.util.AttributeSet;
import com.mardous.discreteseekbar.DiscreteSeekBar;

/* JADX INFO: loaded from: classes.dex */
public class ReverseSeekBar extends DiscreteSeekBar {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private boolean f4486b0;

    public ReverseSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4486b0 = false;
    }

    @Override // com.mardous.discreteseekbar.DiscreteSeekBar
    public boolean a() {
        return this.f4486b0;
    }

    public void setReverse(boolean z2) {
        this.f4486b0 = z2;
        invalidate();
    }

    public ReverseSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4486b0 = false;
    }

    public ReverseSeekBar(Context context) {
        super(context);
        this.f4486b0 = false;
    }
}
