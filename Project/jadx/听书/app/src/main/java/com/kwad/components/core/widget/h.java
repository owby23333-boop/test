package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class h extends ViewOutlineProvider {
    private float ajn;

    private h(float f) {
        this.ajn = f;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.ajn);
    }

    public static void b(View view, float f) {
        if (f <= 0.0f) {
            view.setOutlineProvider(null);
            view.setClipToOutline(false);
        } else {
            view.setOutlineProvider(new h(f));
            view.setClipToOutline(true);
        }
    }
}
