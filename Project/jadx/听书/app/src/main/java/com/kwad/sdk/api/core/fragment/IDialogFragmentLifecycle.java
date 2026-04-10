package com.kwad.sdk.api.core.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

/* JADX INFO: loaded from: classes4.dex */
interface IDialogFragmentLifecycle extends IFragmentLifecycle {
    void onCancel(DialogInterface dialogInterface);

    Dialog onCreateDialog(Bundle bundle);

    void onDismiss(DialogInterface dialogInterface);
}
