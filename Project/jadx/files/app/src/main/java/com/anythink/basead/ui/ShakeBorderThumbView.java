package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeBorderThumbView extends BaseShakeView {
    public ShakeBorderThumbView(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    final void a() {
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(h.a(n.a().g(), "myoffer_bg_shake_border_thumb", i.f10645c));
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_shake_border_thumb", "layout"), (ViewGroup) this, true);
        int iA = h.a(getContext(), 10.0f);
        int iA2 = h.a(getContext(), 12.0f);
        int iA3 = h.a(getContext(), 6.0f);
        setPadding(iA, iA3, iA2, iA3);
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeBorderThumbView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public ShakeBorderThumbView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
