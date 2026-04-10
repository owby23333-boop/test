package com.duokan.reader.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ViewFlipper;
import com.duokan.core.diagnostic.LogLevel;
import com.yuewen.ia0;

/* JADX INFO: loaded from: classes5.dex */
public class DkViewFlipper extends ViewFlipper {
    public DkViewFlipper(Context context) {
        super(context);
    }

    @Override // android.widget.ViewFlipper, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            ia0.w().j(LogLevel.ERROR, "ViewFlipper", "onDetachedFromWindow", th);
        }
    }

    public DkViewFlipper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
