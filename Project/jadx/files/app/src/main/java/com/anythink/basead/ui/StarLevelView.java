package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public class StarLevelView extends ImageView {
    Context a;

    public StarLevelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.a = context;
    }

    public void setState(boolean z2) {
        if (z2) {
            setImageResource(h.a(getContext(), "myoffer_splash_star", i.f10645c));
        } else {
            setImageResource(h.a(getContext(), "myoffer_splash_star_gray", i.f10645c));
        }
    }

    public StarLevelView(Context context) {
        this(context, null);
        this.a = context;
    }

    public StarLevelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = context;
    }
}
