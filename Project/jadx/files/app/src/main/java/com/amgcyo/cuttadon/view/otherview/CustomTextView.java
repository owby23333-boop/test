package com.amgcyo.cuttadon.view.otherview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class CustomTextView extends AppCompatTextView {
    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
    }
}
