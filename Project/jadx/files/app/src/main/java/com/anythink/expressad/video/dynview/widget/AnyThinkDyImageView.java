package com.anythink.expressad.video.dynview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.anythink.expressad.foundation.h.o;

/* JADX INFO: loaded from: classes2.dex */
public class AnyThinkDyImageView extends ImageView {
    private static final String a = "AnyThinkDyImageView";

    public AnyThinkDyImageView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            o.d(a, th.getMessage());
        }
    }

    public AnyThinkDyImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnyThinkDyImageView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
