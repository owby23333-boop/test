package com.kwad.components.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.kwad.components.core.t.j;

/* JADX INFO: loaded from: classes4.dex */
public class KsStyledLinearLayout extends LinearLayout implements d {
    public KsStyledLinearLayout(Context context) {
        super(context);
    }

    public KsStyledLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public KsStyledLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        j.b(eVar, getBackground());
    }
}
