package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.ViewGroup;
import com.duokan.core.ui.DialogBox;

/* JADX INFO: loaded from: classes5.dex */
public class LoadingDialogBox extends DialogBox {
    public LoadingDialogBox(Context context) {
        super(context);
        setContentView(new LoadingDialogView(context), new ViewGroup.LayoutParams(-2, -2));
        setGravity(17);
        setDimAmount(0.0f);
    }
}
