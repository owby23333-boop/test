package com.duokan.ui;

import android.content.Context;
import com.duokan.core.ui.DialogBox;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes5.dex */
public class BottomPopDialogBox extends DialogBox {
    public BottomPopDialogBox(Context context) {
        this(context, false);
    }

    @Override // com.duokan.core.ui.DialogBox
    public void initPortraitNavBar() {
        setNavigationColor(getContext().getColor(rt2.f.Oi));
    }

    @Override // com.duokan.core.ui.DialogBox
    public boolean onBack() {
        dismiss();
        return true;
    }

    public BottomPopDialogBox(Context context, boolean z) {
        this(context, z, false);
    }

    public BottomPopDialogBox(Context context, boolean z, boolean z2) {
        super(context, z, z2);
        setEnterAnimation(rt2.a.b0);
        setExitAnimation(rt2.a.c0);
    }
}
