package com.duokan.core.ui;

import android.content.Context;
import com.yuewen.cx;

/* JADX INFO: loaded from: classes12.dex */
public class CancelableDialogBox extends DialogBox implements cx {
    private boolean mCancelOnBack;
    private boolean mCancelOnTouchOutside;
    private cx.a mOnCancelListener;

    public CancelableDialogBox(Context context) {
        super(context);
        this.mOnCancelListener = null;
        this.mCancelOnBack = true;
        this.mCancelOnTouchOutside = true;
    }

    private void n() {
        cx.a aVar = this.mOnCancelListener;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void cancel() {
        if (isShowing()) {
            onCancel();
            dismiss();
        }
    }

    @Override // com.duokan.core.ui.DialogBox
    public boolean onBack() {
        if (!isShowing() || !this.mCancelOnBack) {
            return super.onBack();
        }
        cancel();
        return true;
    }

    @Override // com.duokan.core.ui.DialogBox
    public void onCancel() {
        n();
        super.onCancel();
    }

    @Override // com.duokan.core.ui.DialogBox
    public void onDismiss() {
        super.onDismiss();
        this.mOnCancelListener = null;
    }

    @Override // com.duokan.core.ui.DialogBox
    public boolean onTouchOutside() {
        if (!isShowing() || !this.mCancelOnTouchOutside) {
            return super.onTouchOutside();
        }
        cancel();
        return true;
    }

    @Override // com.yuewen.cx
    public void open(cx.a aVar) {
        this.mOnCancelListener = aVar;
        show();
    }

    public void setCancelOnBack(boolean z) {
        this.mCancelOnBack = z;
    }

    public void setCancelOnTouchOutside(boolean z) {
        this.mCancelOnTouchOutside = z;
    }
}
