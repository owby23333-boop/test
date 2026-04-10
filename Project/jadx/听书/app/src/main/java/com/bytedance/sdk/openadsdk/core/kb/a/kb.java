package com.bytedance.sdk.openadsdk.core.kb.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.un.m;
import com.bytedance.sdk.openadsdk.core.widget.uy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class kb {
    private static AlertDialog z(Activity activity, final com.bytedance.sdk.openadsdk.core.kb.a.z zVar) {
        return new com.bytedance.sdk.openadsdk.core.widget.uy(activity).z(zVar.z).g(zVar.g).dl(zVar.dl).a(zVar.f1216a).z(zVar.gc).z(new uy.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.kb.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.uy.z
            public void onClickYes(Dialog dialog) {
                if (zVar.m != null) {
                    zVar.m.z(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.uy.z
            public void onClickNo(Dialog dialog) {
                if (zVar.m != null) {
                    zVar.m.g(dialog);
                }
            }
        }).z(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.kb.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (zVar.m != null) {
                    zVar.m.dl(dialogInterface);
                }
            }
        });
    }

    public static void z(WeakReference<Context> weakReference, boolean z2, final com.bytedance.sdk.openadsdk.core.kb.a.z zVar) {
        m.z zVar2 = new m.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.kb.3
            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnYes() {
                if (zVar.m != null) {
                    zVar.m.z(new z());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogBtnNo() {
                if (zVar.m != null) {
                    zVar.m.g(new z());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.un.m.z
            public void onDialogCancel() {
                if (zVar.m != null) {
                    zVar.m.dl(new z());
                }
            }
        };
        if (z2) {
            com.bytedance.sdk.openadsdk.core.un.m.z(weakReference.get(), String.valueOf(zVar.hashCode()), zVar.z, zVar.g, zVar.dl, zVar.f1216a, zVar2);
        } else {
            com.bytedance.sdk.openadsdk.core.un.m.z(weakReference.get(), String.valueOf(zVar.hashCode()), zVar.z, zVar.g, zVar2);
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

    public static AlertDialog z(Activity activity, boolean z2, com.bytedance.sdk.openadsdk.core.kb.a.z zVar) {
        if (z2) {
            AlertDialog alertDialogZ = z(activity, zVar);
            if (activity != null && !activity.isFinishing()) {
                alertDialogZ.show();
            }
            return alertDialogZ;
        }
        return z(activity, tb.gz(activity, "Theme.Dialog.TTDownload"), zVar);
    }

    private static AlertDialog z(Activity activity, int i, final com.bytedance.sdk.openadsdk.core.kb.a.z zVar) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(zVar.z).setMessage(zVar.g).setPositiveButton(zVar.dl, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.kb.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (zVar.m != null) {
                    zVar.m.z(dialogInterface);
                }
            }
        }).setNegativeButton(zVar.f1216a, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.kb.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (zVar.m != null) {
                    zVar.m.g(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.kb.a.kb.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (zVar.m != null) {
                    zVar.m.dl(dialogInterface);
                }
            }
        });
        if (zVar.gc != null) {
            onCancelListener.setIcon(zVar.gc);
        }
        AlertDialog alertDialogCreate = onCancelListener.create();
        if (activity != null && !activity.isFinishing()) {
            alertDialogCreate.show();
        }
        return alertDialogCreate;
    }
}
