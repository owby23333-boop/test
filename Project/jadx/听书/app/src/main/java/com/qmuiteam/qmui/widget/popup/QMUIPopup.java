package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIPopup extends QMUINormalPopup<QMUIPopup> {
    public QMUIPopup(Context context, int i, int i2) {
        super(context, i, i2);
    }

    @Override // com.qmuiteam.qmui.widget.popup.QMUINormalPopup
    public QMUIPopup show(View view) {
        return (QMUIPopup) super.show(view);
    }

    @Override // com.qmuiteam.qmui.widget.popup.QMUINormalPopup
    public QMUIPopup show(View view, int i, int i2, int i3, int i4) {
        return (QMUIPopup) super.show(view, i, i2, i3, i4);
    }
}
