package com.kwad.components.core.l;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends AlertDialog {
    public Activity mActivity;
    protected final Context mContext;
    protected ViewGroup yX;

    protected e(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = Wrapper.wrapContextIfNeed(activity);
    }

    protected ViewGroup cm() {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    @CallSuper
    public void dismiss() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        try {
            Wrapper.onDestroy(activity);
        } catch (Throwable unused) {
        }
        try {
            super.dismiss();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i2) {
        T t2 = (T) this.yX.findViewById(i2);
        return t2 != null ? t2 : (T) super.findViewById(i2);
    }

    protected abstract void g(View view);

    @LayoutRes
    protected abstract int getLayoutId();

    protected boolean nb() {
        return false;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.yX = getLayoutId() != 0 ? (ViewGroup) com.kwad.sdk.i.a.inflate(this.mContext, getLayoutId(), null) : cm();
            setContentView(this.yX);
            setCanceledOnTouchOutside(nb());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().setLayout(-1, -1);
            g(this.yX);
        } catch (Throwable th) {
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            com.kwad.components.core.c.a.b(th);
            dismiss();
        }
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onStart() {
        super.onStart();
        setTitle((CharSequence) null);
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        super.setContentView(i2);
        this.yX = (ViewGroup) com.kwad.sdk.i.a.inflate(this.mContext, i2, null);
    }
}
