package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public class AdTextView extends TextView {
    public AdTextView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setBackgroundResource(h.a(context, "myoffer_bg_banner_ad_choice", i.f10645c));
        setTextColor(-1);
        setText(context.getResources().getString(h.a(context, "basead_ad_text", i.f10649g)));
        setTextSize(8.0f);
        setGravity(17);
        setPadding(h.a(context, 3.0f), 0, h.a(context, 3.0f), 0);
    }

    public AdTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AdTextView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
