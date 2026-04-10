package com.duokan.reader.ui.reading;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.duokan.core.ui.LinearSelectableView;
import com.yuewen.mt2;

/* JADX INFO: loaded from: classes5.dex */
public class TabView extends LinearSelectableView {
    public TabView(Context context) {
        this(context, null);
    }

    public TabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.background});
        if (!typedArrayObtainStyledAttributes.hasValue(0)) {
            setBackgroundResource(mt2.h.m8);
        }
        typedArrayObtainStyledAttributes.recycle();
        setSelectAnimateEnable(false);
    }
}
