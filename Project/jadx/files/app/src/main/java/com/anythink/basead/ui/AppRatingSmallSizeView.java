package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes2.dex */
public class AppRatingSmallSizeView extends AppRatingView {
    public AppRatingSmallSizeView(Context context) {
        this(context, null, 0);
    }

    public AppRatingSmallSizeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppRatingSmallSizeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setStarSizeInDp(13);
        setStarMargin(4);
    }
}
