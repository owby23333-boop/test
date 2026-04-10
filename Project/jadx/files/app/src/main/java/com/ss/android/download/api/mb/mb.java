package com.ss.android.download.api.mb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.je;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;

/* JADX INFO: loaded from: classes3.dex */
public class mb implements je {
    @Override // com.ss.android.download.api.config.je
    public void mb(int i2, @Nullable Context context, DownloadModel downloadModel, String str, Drawable drawable, int i3) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.download.api.config.je
    public Dialog ox(@NonNull DownloadAlertDialogInfo downloadAlertDialogInfo) {
        return mb(downloadAlertDialogInfo);
    }

    private static Dialog mb(final DownloadAlertDialogInfo downloadAlertDialogInfo) {
        if (downloadAlertDialogInfo == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(downloadAlertDialogInfo.mb).setTitle(downloadAlertDialogInfo.ox).setMessage(downloadAlertDialogInfo.b).setPositiveButton(downloadAlertDialogInfo.hj, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.mb.mb.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                DownloadAlertDialogInfo.ox oxVar = downloadAlertDialogInfo.ww;
                if (oxVar != null) {
                    oxVar.mb(dialogInterface);
                }
            }
        }).setNegativeButton(downloadAlertDialogInfo.f17944h, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.mb.mb.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                DownloadAlertDialogInfo.ox oxVar = downloadAlertDialogInfo.ww;
                if (oxVar != null) {
                    oxVar.ox(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(downloadAlertDialogInfo.f17945u);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.mb.mb.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                DownloadAlertDialogInfo.ox oxVar = downloadAlertDialogInfo.ww;
                if (oxVar != null) {
                    oxVar.b(dialogInterface);
                }
            }
        });
        Drawable drawable = downloadAlertDialogInfo.ko;
        if (drawable != null) {
            alertDialogShow.setIcon(drawable);
        }
        return alertDialogShow;
    }
}
