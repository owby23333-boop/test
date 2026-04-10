package com.anythink.expressad.splash.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
public class MBNoRecycledCrashImageView extends ImageView {
    public MBNoRecycledCrashImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }

    public MBNoRecycledCrashImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBNoRecycledCrashImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public MBNoRecycledCrashImageView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
