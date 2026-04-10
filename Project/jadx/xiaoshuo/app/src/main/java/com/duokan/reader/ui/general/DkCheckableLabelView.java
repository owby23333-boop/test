package com.duokan.reader.ui.general;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;

/* JADX INFO: loaded from: classes5.dex */
public class DkCheckableLabelView extends DkLabelView implements Checkable {
    public static final int[] c = {R.attr.state_checked};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5377b;

    public DkCheckableLabelView(Context context) {
        this(context, null);
    }

    public int getValue() {
        return this.f5377b;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f5376a;
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, c);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f5376a != z) {
            this.f5376a = z;
            refreshDrawableState();
        }
    }

    public void setValue(int i) {
        this.f5377b = i;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f5376a);
    }

    public DkCheckableLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
    }
}
