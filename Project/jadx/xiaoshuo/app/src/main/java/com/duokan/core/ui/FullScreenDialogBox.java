package com.duokan.core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes12.dex */
public class FullScreenDialogBox extends CancelableDialogBox {
    public FullScreenDialogBox(Context context) {
        super(context);
        setGravity(119);
        setDimAmount(0.0f);
    }

    @Override // com.duokan.core.ui.DialogBox
    public void setContentView(View view) {
        setContentView(view, view.getLayoutParams() != null ? view.getLayoutParams() : new ViewGroup.LayoutParams(-1, -1));
    }
}
