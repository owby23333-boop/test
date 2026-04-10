package com.qmuiteam.qmui.widget.popup;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.popup.QMUIBasePopup;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUIBasePopup<T extends QMUIBasePopup> {
    public static final float DIM_AMOUNT_NOT_EXIST = -1.0f;
    public static final int NOT_SET = -1;
    protected WeakReference<View> mAttachedViewRf;
    protected Context mContext;
    private PopupWindow.OnDismissListener mDismissListener;
    private QMUISkinManager mSkinManager;
    protected final PopupWindow mWindow;
    protected WindowManager mWindowManager;
    private float mDimAmount = -1.0f;
    private int mDimAmountAttr = 0;
    private QMUISkinManager.OnSkinChangeListener mOnSkinChangeListener = new QMUISkinManager.OnSkinChangeListener() { // from class: com.qmuiteam.qmui.widget.popup.QMUIBasePopup.1
        @Override // com.qmuiteam.qmui.skin.QMUISkinManager.OnSkinChangeListener
        public void onSkinChange(QMUISkinManager qMUISkinManager, int i, int i2) {
            if (QMUIBasePopup.this.mDimAmountAttr != 0) {
                Resources.Theme theme = qMUISkinManager.getTheme(i2);
                QMUIBasePopup qMUIBasePopup = QMUIBasePopup.this;
                qMUIBasePopup.mDimAmount = QMUIResHelper.getAttrFloatValue(theme, qMUIBasePopup.mDimAmountAttr);
                QMUIBasePopup qMUIBasePopup2 = QMUIBasePopup.this;
                qMUIBasePopup2.updateDimAmount(qMUIBasePopup2.mDimAmount);
                QMUIBasePopup.this.onSkinChange(i, i2);
            }
        }
    };
    private View.OnAttachStateChangeListener mOnAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.qmuiteam.qmui.widget.popup.QMUIBasePopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            QMUIBasePopup.this.dismiss();
        }
    };
    private View.OnTouchListener mOutsideTouchDismissListener = new View.OnTouchListener() { // from class: com.qmuiteam.qmui.widget.popup.QMUIBasePopup.3
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 4) {
                return false;
            }
            QMUIBasePopup.this.mWindow.dismiss();
            return true;
        }
    };

    protected void modifyWindowLayoutParams(WindowManager.LayoutParams layoutParams) {
    }

    protected void onDismiss() {
    }

    protected void onSkinChange(int i, int i2) {
    }

    public QMUIBasePopup(Context context) {
        this.mContext = context;
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        PopupWindow popupWindow = new PopupWindow(context);
        this.mWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.qmuiteam.qmui.widget.popup.QMUIBasePopup.4
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                QMUIBasePopup.this.removeOldAttachStateChangeListener();
                QMUIBasePopup.this.mAttachedViewRf = null;
                if (QMUIBasePopup.this.mSkinManager != null) {
                    QMUIBasePopup.this.mSkinManager.unRegister(QMUIBasePopup.this.mWindow);
                    QMUIBasePopup.this.mSkinManager.removeSkinChangeListener(QMUIBasePopup.this.mOnSkinChangeListener);
                }
                QMUIBasePopup.this.onDismiss();
                if (QMUIBasePopup.this.mDismissListener != null) {
                    QMUIBasePopup.this.mDismissListener.onDismiss();
                }
            }
        });
        dismissIfOutsideTouch(true);
    }

    public QMUISkinManager getSkinManager() {
        return this.mSkinManager;
    }

    public T dimAmount(float f) {
        this.mDimAmount = f;
        return this;
    }

    public T dimAmountAttr(int i) {
        this.mDimAmountAttr = i;
        return this;
    }

    public T skinManager(QMUISkinManager qMUISkinManager) {
        this.mSkinManager = qMUISkinManager;
        return this;
    }

    public T setTouchable(boolean z) {
        this.mWindow.setTouchable(true);
        return this;
    }

    public T setFocusable(boolean z) {
        this.mWindow.setFocusable(z);
        return this;
    }

    public T dismissIfOutsideTouch(boolean z) {
        this.mWindow.setOutsideTouchable(z);
        if (z) {
            this.mWindow.setTouchInterceptor(this.mOutsideTouchDismissListener);
        } else {
            this.mWindow.setTouchInterceptor(null);
        }
        return this;
    }

    public T onDismiss(PopupWindow.OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOldAttachStateChangeListener() {
        View view;
        WeakReference<View> weakReference = this.mAttachedViewRf;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.removeOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
    }

    public View getDecorView() {
        View view;
        try {
            if (this.mWindow.getBackground() == null) {
                view = (View) this.mWindow.getContentView().getParent();
            } else {
                view = (View) this.mWindow.getContentView().getParent().getParent();
            }
            return view;
        } catch (Exception unused) {
            return null;
        }
    }

    protected void showAtLocation(View view, int i, int i2) {
        if (ViewCompat.isAttachedToWindow(view)) {
            removeOldAttachStateChangeListener();
            view.addOnAttachStateChangeListener(this.mOnAttachStateChangeListener);
            this.mAttachedViewRf = new WeakReference<>(view);
            this.mWindow.showAtLocation(view, 0, i, i2);
            QMUISkinManager qMUISkinManager = this.mSkinManager;
            if (qMUISkinManager != null) {
                qMUISkinManager.register(this.mWindow);
                this.mSkinManager.addSkinChangeListener(this.mOnSkinChangeListener);
                if (this.mDimAmountAttr != 0) {
                    Resources.Theme currentTheme = this.mSkinManager.getCurrentTheme();
                    if (currentTheme == null) {
                        currentTheme = view.getContext().getTheme();
                    }
                    this.mDimAmount = QMUIResHelper.getAttrFloatValue(currentTheme, this.mDimAmountAttr);
                }
            }
            float f = this.mDimAmount;
            if (f != -1.0f) {
                updateDimAmount(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDimAmount(float f) {
        View decorView = getDecorView();
        if (decorView != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) decorView.getLayoutParams();
            layoutParams.flags |= 2;
            layoutParams.dimAmount = f;
            modifyWindowLayoutParams(layoutParams);
            this.mWindowManager.updateViewLayout(decorView, layoutParams);
        }
    }

    public final void dismiss() {
        this.mWindow.dismiss();
    }
}
