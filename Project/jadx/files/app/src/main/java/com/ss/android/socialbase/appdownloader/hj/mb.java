package com.ss.android.socialbase.appdownloader.hj;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.b.jb;
import com.ss.android.socialbase.appdownloader.b.je;

/* JADX INFO: loaded from: classes3.dex */
public class mb extends com.ss.android.socialbase.appdownloader.b.ox {
    private AlertDialog.Builder mb;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.hj.mb$mb, reason: collision with other inner class name */
    private static class C0523mb implements jb {
        private AlertDialog mb;

        public C0523mb(AlertDialog.Builder builder) {
            if (builder != null) {
                this.mb = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.jb
        public void mb() {
            AlertDialog alertDialog = this.mb;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.jb
        public boolean ox() {
            AlertDialog alertDialog = this.mb;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }

    public mb(Context context) {
        this.mb = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public je mb(int i2) {
        AlertDialog.Builder builder = this.mb;
        if (builder != null) {
            builder.setTitle(i2);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public je ox(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.mb;
        if (builder != null) {
            builder.setNegativeButton(i2, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public je mb(String str) {
        AlertDialog.Builder builder = this.mb;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public je mb(int i2, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.mb;
        if (builder != null) {
            builder.setPositiveButton(i2, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public je mb(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.mb;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.je
    public jb mb() {
        return new C0523mb(this.mb);
    }
}
