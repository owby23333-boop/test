package com.bytedance.sdk.openadsdk.core.kb.z;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.m;
import com.bytedance.sdk.openadsdk.core.widget.uy;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static AlertDialog getBackInstallDialog(Activity activity, final DialogBuilder dialogBuilder) {
        return new com.bytedance.sdk.openadsdk.core.widget.uy(activity).z(dialogBuilder.title).g(dialogBuilder.message).dl(dialogBuilder.positiveBtnText).a(dialogBuilder.negativeBtnText).z(dialogBuilder.icon).z(new uy.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.z.gz.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.uy.z
            public void onClickYes(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.uy.z
            public void onClickNo(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialog);
                }
            }
        }).z(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.kb.z.gz.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
    }

    public static void showDialogByDelegate(WeakReference<Context> weakReference, boolean z2, final DialogBuilder dialogBuilder) {
        m.z zVar = new m.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.z.gz.3
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(new z());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(new z());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(new z());
                }
            }
        };
        if (z2) {
            com.bytedance.sdk.openadsdk.core.un.m.z(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, dialogBuilder.positiveBtnText, dialogBuilder.negativeBtnText, zVar);
        } else {
            com.bytedance.sdk.openadsdk.core.un.m.z(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, zVar);
        }
    }

    private static class z implements DialogInterface {
        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }

        private z() {
        }
    }

    public static AlertDialog showDialogBySelf(Activity activity, boolean z2, DialogBuilder dialogBuilder) {
        if (z2) {
            AlertDialog backInstallDialog = getBackInstallDialog(activity, dialogBuilder);
            if (activity != null && !activity.isFinishing()) {
                backInstallDialog.show();
            }
            return backInstallDialog;
        }
        return createAlertDialog(activity, tb.gz(activity, "Theme.Dialog.TTDownload"), dialogBuilder);
    }

    private static AlertDialog createAlertDialog(Activity activity, int i, final DialogBuilder dialogBuilder) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(dialogBuilder.title).setMessage(dialogBuilder.message).setPositiveButton(dialogBuilder.positiveBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.kb.z.gz.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialogInterface);
                }
            }
        }).setNegativeButton(dialogBuilder.negativeBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.kb.z.gz.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.kb.z.gz.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
        if (dialogBuilder.icon != null) {
            onCancelListener.setIcon(dialogBuilder.icon);
        }
        AlertDialog alertDialogCreate = onCancelListener.create();
        if (activity != null && !activity.isFinishing()) {
            alertDialogCreate.show();
        }
        return alertDialogCreate;
    }
}
