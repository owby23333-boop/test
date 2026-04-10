package com.anythink.basead.ui.a;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = 0;
        view.setLayoutParams(layoutParams);
    }
}
