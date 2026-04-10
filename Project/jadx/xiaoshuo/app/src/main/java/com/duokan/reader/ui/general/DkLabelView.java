package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class DkLabelView extends TextView {

    public enum ContentMode {
        DEFAULT,
        ZH_CN,
        EN,
        NUM
    }

    public DkLabelView(Context context) {
        this(context, null);
    }

    public void setContentMode(ContentMode contentMode) {
    }

    public DkLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
