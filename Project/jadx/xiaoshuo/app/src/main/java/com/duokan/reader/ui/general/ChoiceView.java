package com.duokan.reader.ui.general;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.duokan.core.ui.LinearSelectableView;
import com.yuewen.st2;

/* JADX INFO: loaded from: classes5.dex */
public class ChoiceView extends LinearSelectableView {
    public ChoiceView(Context context) {
        this(context, null);
    }

    public ChoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.background});
        if (!typedArrayObtainStyledAttributes.hasValue(0)) {
            setBackgroundResource(st2.h.Dk);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
