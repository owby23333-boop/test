package com.anythink.expressad.videocommon.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.anythink.expressad.widget.ATImageView;

/* JADX INFO: loaded from: classes2.dex */
public class MyImageView extends ATImageView {
    public MyImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.anythink.expressad.widget.ATImageView, android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
        }
    }

    public MyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyImageView(Context context) {
        super(context);
    }
}
