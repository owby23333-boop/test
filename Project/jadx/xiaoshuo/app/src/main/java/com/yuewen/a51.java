package com.yuewen;

import android.app.Activity;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes5.dex */
public final class a51 implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f8405a;

    public a51(Activity activity) {
        this.f8405a = activity;
    }

    public final void a() {
        this.f8405a.finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        a();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        a();
    }
}
