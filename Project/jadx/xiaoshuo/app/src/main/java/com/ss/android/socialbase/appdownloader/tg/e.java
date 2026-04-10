package com.ss.android.socialbase.appdownloader.tg;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.d.wu;
import com.ss.android.socialbase.appdownloader.d.xu;

/* JADX INFO: loaded from: classes4.dex */
public class e extends com.ss.android.socialbase.appdownloader.d.bf {
    private AlertDialog.Builder e;

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.tg.e$e, reason: collision with other inner class name */
    public static class C0496e implements wu {
        private AlertDialog e;

        public C0496e(AlertDialog.Builder builder) {
            if (builder != null) {
                this.e = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.d.wu
        public boolean bf() {
            AlertDialog alertDialog = this.e;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // com.ss.android.socialbase.appdownloader.d.wu
        public void e() {
            AlertDialog alertDialog = this.e;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }
    }

    public e(Context context) {
        this.e = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.d.xu
    public xu bf(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.e;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.d.xu
    public xu e(int i) {
        AlertDialog.Builder builder = this.e;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.d.xu
    public xu e(String str) {
        AlertDialog.Builder builder = this.e;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.d.xu
    public xu e(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.e;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.d.xu
    public xu e(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.e;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.d.xu
    public wu e() {
        return new C0496e(this.e);
    }
}
