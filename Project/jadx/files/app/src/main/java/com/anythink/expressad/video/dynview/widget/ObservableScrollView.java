package com.anythink.expressad.video.dynview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/* JADX INFO: loaded from: classes2.dex */
public class ObservableScrollView extends HorizontalScrollView {
    private a a;

    public ObservableScrollView(Context context) {
        super(context);
        this.a = null;
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int i2) {
        super.fling(i2 / 4);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = null;
    }

    public ObservableScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
    }
}
