package com.qmuiteam.qmui.widget.dialog;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.LayoutInflaterCompat;
import com.qmuiteam.qmui.skin.QMUISkinLayoutInflaterFactory;
import com.qmuiteam.qmui.skin.QMUISkinManager;

/* JADX INFO: loaded from: classes5.dex */
public class QMUIBaseDialog extends AppCompatDialog {
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private QMUISkinManager mSkinManager;

    protected void onSetCancelable(boolean z) {
    }

    public QMUIBaseDialog(Context context, int i) {
        super(context, i);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.mSkinManager = null;
        supportRequestWindowFeature(1);
    }

    public void setSkinManager(QMUISkinManager qMUISkinManager) {
        QMUISkinManager qMUISkinManager2 = this.mSkinManager;
        if (qMUISkinManager2 != null) {
            qMUISkinManager2.unRegister(this);
        }
        this.mSkinManager = qMUISkinManager;
        if (!isShowing() || qMUISkinManager == null) {
            return;
        }
        this.mSkinManager.register(this);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStart() {
        super.onStart();
        QMUISkinManager qMUISkinManager = this.mSkinManager;
        if (qMUISkinManager != null) {
            qMUISkinManager.register(this);
        }
    }

    @Override // android.app.Dialog
    public LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = super.getLayoutInflater();
        LayoutInflater.Factory2 factory2 = layoutInflater.getFactory2();
        if (factory2 instanceof QMUISkinLayoutInflaterFactory) {
            LayoutInflaterCompat.setFactory2(layoutInflater, ((QMUISkinLayoutInflaterFactory) factory2).cloneForLayoutInflaterIfNeeded(layoutInflater));
        }
        return layoutInflater;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        QMUISkinManager qMUISkinManager = this.mSkinManager;
        if (qMUISkinManager != null) {
            qMUISkinManager.unRegister(this);
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.cancelable != z) {
            this.cancelable = z;
            onSetCancelable(z);
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z;
        this.canceledOnTouchOutsideSet = true;
    }

    protected boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Context context = getContext();
        if (context instanceof ContextWrapper) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            super.dismiss();
            return;
        }
        try {
            super.dismiss();
        } catch (Throwable unused) {
        }
    }
}
