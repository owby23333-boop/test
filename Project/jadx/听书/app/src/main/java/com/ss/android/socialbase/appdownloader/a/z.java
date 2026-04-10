package com.ss.android.socialbase.appdownloader.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.dl.i;
import com.ss.android.socialbase.appdownloader.dl.wp;

/* JADX INFO: loaded from: classes4.dex */
public class z extends com.ss.android.socialbase.appdownloader.dl.g {
    private AlertDialog.Builder z;

    public z(Context context) {
        this.z = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.i
    public i z(int i) {
        AlertDialog.Builder builder = this.z;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.i
    public i z(String str) {
        AlertDialog.Builder builder = this.z;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.i
    public i z(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.z;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.i
    public i g(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.z;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.i
    public i z(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.z;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.dl.i
    public wp z() {
        return new C0453z(this.z);
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.a.z$z, reason: collision with other inner class name */
    private static class C0453z implements wp {
        private AlertDialog z;

        public C0453z(AlertDialog.Builder builder) {
            if (builder != null) {
                this.z = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.dl.wp
        public void z() {
            AlertDialog alertDialog = this.z;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.dl.wp
        public boolean g() {
            AlertDialog alertDialog = this.z;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }
}
