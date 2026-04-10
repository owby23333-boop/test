package com.dangdang.zframework.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import com.dangdang.zframework.plugin.AppUtil;

/* JADX INFO: loaded from: classes10.dex */
public class DDEditText extends EditText {
    public DDEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
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

    public DDEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DDEditText(Context context) {
        super(context);
        init(context);
    }
}
