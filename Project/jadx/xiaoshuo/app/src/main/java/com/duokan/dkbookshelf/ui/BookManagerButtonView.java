package com.duokan.dkbookshelf.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.yuewen.es2;

/* JADX INFO: loaded from: classes13.dex */
public class BookManagerButtonView extends FrameLayout {
    public BookManagerButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackground(ContextCompat.getDrawable(context, es2.h.D8));
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.5f);
        }
    }
}
