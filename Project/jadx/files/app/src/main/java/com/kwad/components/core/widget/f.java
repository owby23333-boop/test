package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public final class f extends ViewOutlineProvider {
    private float WR;

    private f(float f2) {
        this.WR = f2;
    }

    @RequiresApi(api = 21)
    public static void b(View view, float f2) {
        boolean z2;
        if (f2 <= 0.0f) {
            view.setOutlineProvider(null);
            z2 = false;
        } else {
            view.setOutlineProvider(new f(f2));
            z2 = true;
        }
        view.setClipToOutline(z2);
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.WR);
    }
}
