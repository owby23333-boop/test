package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends AlertDialog {
    protected ViewGroup CC;
    public Activity mActivity;
    protected final Context mContext;

    protected float dv() {
        return -1.0f;
    }

    protected ViewGroup dw() {
        return null;
    }

    protected abstract int getLayoutId();

    protected abstract void h(View view);

    protected boolean oX() {
        return false;
    }

    protected g(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(activity);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getLayoutId() != 0) {
                this.CC = (ViewGroup) com.kwad.sdk.o.m.inflate(this.mContext, getLayoutId(), null);
            } else {
                this.CC = dw();
            }
            setContentView(this.CC);
            setCanceledOnTouchOutside(oX());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().clearFlags(131072);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            if (dv() != -1.0f) {
                attributes.dimAmount = dv();
            }
            getWindow().setAttributes(attributes);
            setCancelable(true);
            h(this.CC);
        } catch (Throwable th) {
            if (com.kwad.sdk.l.Cf().Bk()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                dismiss();
                return;
            }
            throw th;
        }
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        super.setContentView(i);
        this.CC = (ViewGroup) com.kwad.sdk.o.m.inflate(this.mContext, i, null);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        T t = (T) this.CC.findViewById(i);
        return t != null ? t : (T) super.findViewById(i);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        setTitle((CharSequence) null);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        try {
            com.kwad.sdk.o.m.n(activity);
        } catch (Throwable unused) {
        }
        try {
            super.dismiss();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }
}
