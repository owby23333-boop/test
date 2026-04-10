package com.ss.android.z.z.z;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.ss.android.z.z.dl.dl;
import com.ss.android.z.z.g.v;

/* JADX INFO: loaded from: classes4.dex */
public class z implements v {
    @Override // com.ss.android.z.z.g.v
    public void z(int i, Context context, dl dlVar, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.z.z.g.v
    public Dialog g(com.ss.android.z.z.gc.dl dlVar) {
        return z(dlVar);
    }

    private static Dialog z(final com.ss.android.z.z.gc.dl dlVar) {
        if (dlVar == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(dlVar.z).setTitle(dlVar.g).setMessage(dlVar.dl).setPositiveButton(dlVar.f2121a, new DialogInterface.OnClickListener() { // from class: com.ss.android.z.z.z.z.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dlVar.gz != null) {
                    dlVar.gz.z(dialogInterface);
                }
            }
        }).setNegativeButton(dlVar.gc, new DialogInterface.OnClickListener() { // from class: com.ss.android.z.z.z.z.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (dlVar.gz != null) {
                    dlVar.gz.g(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(dlVar.m);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.z.z.z.z.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dlVar.gz != null) {
                    dlVar.gz.dl(dialogInterface);
                }
            }
        });
        if (dlVar.e != null) {
            alertDialogShow.setIcon(dlVar.e);
        }
        return alertDialogShow;
    }
}
