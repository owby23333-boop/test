package com.anythink.basead.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.anythink.core.common.k.h;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeTextHintWhiteView extends BaseShakeView {
    public ShakeTextHintWhiteView(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    final void a() {
        setOrientation(0);
        setGravity(17);
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_shake_text_hint_white", "layout"), (ViewGroup) this, true);
        int iA = h.a(getContext(), 4.0f);
        setPadding(iA, iA, iA, iA);
    }

    public ShakeTextHintWhiteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeTextHintWhiteView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public ShakeTextHintWhiteView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
