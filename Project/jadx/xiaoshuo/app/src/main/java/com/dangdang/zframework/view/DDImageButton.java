package com.dangdang.zframework.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes10.dex */
public class DDImageButton extends ImageButton {
    public DDImageButton(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable background = getBackground();
        if (background != null) {
            background.setCallback(null);
        }
        Drawable drawable2 = getDrawable();
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
    }

    public DDImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DDImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
