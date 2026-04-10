package com.amgcyo.cuttadon.widget.lovelydialog;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: compiled from: LovelyDialogCompat.java */
/* JADX INFO: loaded from: classes.dex */
class c implements View.OnClickListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private DialogInterface.OnClickListener f5662s;

    public void a(DialogInterface dialogInterface, int i2) {
        DialogInterface.OnClickListener onClickListener = this.f5662s;
        if (onClickListener != null) {
            onClickListener.onClick(dialogInterface, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
