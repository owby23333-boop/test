package com.kwad.components.core.widget.kwai;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class b extends a {
    private View mRootView;

    public b(@NonNull View view, int i2) {
        super(view, i2);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.kwai.a
    public boolean et() {
        return com.kwad.sdk.b.kwai.a.a(this.mRootView, 70, true);
    }
}
