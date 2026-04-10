package com.ss.android.downloadlib.dl;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.downloadlib.e.kb;
import com.ss.android.socialbase.appdownloader.dl.i;
import com.ss.android.socialbase.appdownloader.dl.wp;
import com.ss.android.z.z.gc.dl;

/* JADX INFO: loaded from: classes4.dex */
public class e extends com.ss.android.socialbase.appdownloader.dl.z {
    private static String z = "e";

    @Override // com.ss.android.socialbase.appdownloader.dl.z, com.ss.android.socialbase.appdownloader.dl.a
    public i z(Context context) {
        return new i(context) { // from class: com.ss.android.downloadlib.dl.e.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private DialogInterface.OnClickListener f2003a;
            private dl.z dl;
            private DialogInterface.OnClickListener gc;
            private DialogInterface.OnCancelListener m;
            final /* synthetic */ Context z;

            {
                this.z = context;
                this.dl = new dl.z(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.dl.i
            public i z(int i) {
                this.dl.z(this.z.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.dl.i
            public i z(String str) {
                this.dl.g(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.dl.i
            public i z(int i, DialogInterface.OnClickListener onClickListener) {
                this.dl.dl(this.z.getResources().getString(i));
                this.f2003a = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.dl.i
            public i g(int i, DialogInterface.OnClickListener onClickListener) {
                this.dl.a(this.z.getResources().getString(i));
                this.gc = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.dl.i
            public i z(DialogInterface.OnCancelListener onCancelListener) {
                this.m = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.dl.i
            public i z(boolean z2) {
                this.dl.z(z2);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.dl.i
            public wp z() {
                this.dl.z(new dl.g() { // from class: com.ss.android.downloadlib.dl.e.1.1
                    @Override // com.ss.android.z.z.gc.dl.g
                    public void z(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.f2003a != null) {
                            AnonymousClass1.this.f2003a.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.z.z.gc.dl.g
                    public void g(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.gc != null) {
                            AnonymousClass1.this.gc.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.z.z.gc.dl.g
                    public void dl(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.m == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.m.onCancel(dialogInterface);
                    }
                });
                kb.z(e.z, "getThemedAlertDlgBuilder", null);
                this.dl.z(3);
                return new z(com.ss.android.downloadlib.addownload.wp.dl().g(this.dl.z()));
            }
        };
    }

    private static class z implements wp {
        private Dialog z;

        public z(Dialog dialog) {
            if (dialog != null) {
                this.z = dialog;
                z();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.dl.wp
        public void z() {
            Dialog dialog = this.z;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.dl.wp
        public boolean g() {
            Dialog dialog = this.z;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }
}
