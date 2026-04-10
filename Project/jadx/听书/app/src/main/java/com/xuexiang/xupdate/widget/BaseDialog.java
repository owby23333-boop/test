package com.xuexiang.xupdate.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.xuexiang.xupdate.R;
import com.xuexiang.xupdate.utils.DialogUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseDialog extends Dialog {
    private View mContentView;
    private boolean mIsSyncSystemUiVisibility;

    protected abstract void initListeners();

    protected abstract void initViews();

    public BaseDialog(Context context, int i) {
        this(context, R.style.XUpdate_Dialog, i);
    }

    public BaseDialog(Context context, View view) {
        this(context, R.style.XUpdate_Dialog, view);
    }

    public BaseDialog(Context context) {
        super(context, R.style.XUpdate_Dialog);
    }

    public BaseDialog(Context context, int i, int i2) {
        super(context, i);
        init(i2);
    }

    public BaseDialog(Context context, int i, View view) {
        super(context, i);
        init(view);
    }

    private void init(int i) {
        init(getLayoutInflater().inflate(i, (ViewGroup) null));
    }

    private void init(View view) {
        setContentView(view);
        this.mContentView = view;
        setCanceledOnTouchOutside(true);
        initViews();
        initListeners();
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) this.mContentView.findViewById(i);
    }

    protected BaseDialog setDialogSize(int i, int i2) {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = i;
            attributes.height = i2;
            window.setAttributes(attributes);
        }
        return this;
    }

    protected String getString(int i) {
        return getContext().getResources().getString(i);
    }

    protected Drawable getDrawable(int i) {
        return ContextCompat.getDrawable(getContext(), i);
    }

    public BaseDialog setIsSyncSystemUiVisibility(boolean z) {
        this.mIsSyncSystemUiVisibility = z;
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        showIfSync(this.mIsSyncSystemUiVisibility);
    }

    public void showIfSync(boolean z) {
        if (z) {
            if (DialogUtils.showWindow(DialogUtils.findActivity(getContext()), getWindow(), new DialogUtils.IWindowShower() { // from class: com.xuexiang.xupdate.widget.BaseDialog.1
                @Override // com.xuexiang.xupdate.utils.DialogUtils.IWindowShower
                public void show(Window window) {
                    BaseDialog.this.performShow();
                }
            })) {
                return;
            }
            performShow();
            return;
        }
        performShow();
    }

    protected void performShow() {
        super.show();
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && DialogUtils.isShouldHideInput(getWindow(), motionEvent)) {
            DialogUtils.hideSoftInput(getCurrentFocus());
        }
        return super.onTouchEvent(motionEvent);
    }
}
