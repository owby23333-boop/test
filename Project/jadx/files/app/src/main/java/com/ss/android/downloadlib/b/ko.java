package com.ss.android.downloadlib.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.downloadlib.utils.x;
import com.ss.android.socialbase.appdownloader.b.jb;
import com.ss.android.socialbase.appdownloader.b.je;

/* JADX INFO: loaded from: classes3.dex */
public class ko extends com.ss.android.socialbase.appdownloader.b.mb {
    private static String mb = "ko";

    private static class mb implements jb {
        private Dialog mb;

        public mb(Dialog dialog) {
            if (dialog != null) {
                this.mb = dialog;
                mb();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.jb
        public void mb() {
            Dialog dialog = this.mb;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.jb
        public boolean ox() {
            Dialog dialog = this.mb;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.mb, com.ss.android.socialbase.appdownloader.b.b
    public je mb(final Context context) {
        return new je() { // from class: com.ss.android.downloadlib.b.ko.1
            private DownloadAlertDialogInfo.mb b;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private DialogInterface.OnClickListener f18026h;
            private DialogInterface.OnClickListener hj;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            private DialogInterface.OnCancelListener f18027u;

            {
                this.b = new DownloadAlertDialogInfo.mb(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je mb(int i2) {
                this.b.mb(context.getResources().getString(i2));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je ox(int i2, DialogInterface.OnClickListener onClickListener) {
                this.b.hj(context.getResources().getString(i2));
                this.f18026h = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je mb(String str) {
                this.b.ox(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je mb(int i2, DialogInterface.OnClickListener onClickListener) {
                this.b.b(context.getResources().getString(i2));
                this.hj = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je mb(DialogInterface.OnCancelListener onCancelListener) {
                this.f18027u = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public je mb(boolean z2) {
                this.b.mb(z2);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.je
            public jb mb() {
                this.b.mb(new DownloadAlertDialogInfo.ox() { // from class: com.ss.android.downloadlib.b.ko.1.1
                    @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f18027u == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.f18027u.onCancel(dialogInterface);
                    }

                    @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
                    public void mb(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.hj != null) {
                            AnonymousClass1.this.hj.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
                    public void ox(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f18026h != null) {
                            AnonymousClass1.this.f18026h.onClick(dialogInterface, -2);
                        }
                    }
                });
                x.mb(ko.mb, "getThemedAlertDlgBuilder", null);
                this.b.mb(3);
                return new mb(com.ss.android.downloadlib.addownload.x.b().ox(this.b.mb()));
            }
        };
    }

    @Override // com.ss.android.socialbase.appdownloader.b.mb, com.ss.android.socialbase.appdownloader.b.b
    public boolean mb() {
        return true;
    }
}
