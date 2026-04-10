package com.dangdang.zframework.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.dangdang.zframework.plugin.AppUtil;

/* JADX INFO: loaded from: classes10.dex */
public class DDRadioButton extends RadioButton {
    public DDRadioButton(Context context) {
        super(context);
        init(context);
    }

    public void init(Context context) {
        try {
            Typeface typeface = AppUtil.getInstance(context).getTypeface();
            if (typeface != null) {
                setTypeface(typeface);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable background = getBackground();
        if (background != null) {
            background.setCallback(null);
        }
    }

    public DDRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DDRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}
