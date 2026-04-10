package com.amgcyo.cuttadon.view.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: LoadingDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class d1 extends Dialog {

    /* JADX INFO: compiled from: LoadingDialog.java */
    public static class b {
        private Context a;
        private boolean b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4695c = false;

        public b(Context context) {
            this.a = context;
        }

        public b a(boolean z2) {
            this.f4695c = z2;
            return this;
        }

        public b b(boolean z2) {
            this.b = z2;
            return this;
        }

        @SuppressLint({"InflateParams"})
        public d1 a() {
            View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.googleprogressbar_loading, (ViewGroup) null);
            d1 d1Var = new d1(this.a, R.style.dialog);
            d1Var.setContentView(viewInflate);
            d1Var.setCancelable(this.b);
            d1Var.setCanceledOnTouchOutside(this.f4695c);
            return d1Var;
        }
    }

    private d1(Context context, int i2) {
        super(context, i2);
    }
}
