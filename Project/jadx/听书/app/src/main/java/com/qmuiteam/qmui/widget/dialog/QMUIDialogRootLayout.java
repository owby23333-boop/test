package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIWindowHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIDialogRootLayout extends ViewGroup {
    private boolean isOverlayOccurEventNotified;
    private boolean mCheckKeyboardOverlay;
    private QMUIDialogView mDialogView;
    private FrameLayout.LayoutParams mDialogViewLp;
    private int mInsetHor;
    private int mInsetVer;
    private int mLastContentInsetTop;
    private float mMaxPercent;
    private int mMaxWidth;
    private int mMinWidth;
    private OverlayOccurInMeasureCallback mOverlayOccurInMeasureCallback;

    interface OverlayOccurInMeasureCallback {
        void call();
    }

    public QMUIDialogRootLayout(Context context, QMUIDialogView qMUIDialogView, FrameLayout.LayoutParams layoutParams) {
        super(context);
        this.mCheckKeyboardOverlay = false;
        this.mMaxPercent = 0.75f;
        this.isOverlayOccurEventNotified = false;
        this.mLastContentInsetTop = 0;
        this.mDialogView = qMUIDialogView;
        layoutParams = layoutParams == null ? new FrameLayout.LayoutParams(-2, -2) : layoutParams;
        this.mDialogViewLp = layoutParams;
        addView(this.mDialogView, layoutParams);
        this.mMinWidth = QMUIResHelper.getAttrDimen(context, R.attr.qmui_dialog_min_width);
        this.mMaxWidth = QMUIResHelper.getAttrDimen(context, R.attr.qmui_dialog_max_width);
        this.mInsetHor = QMUIResHelper.getAttrDimen(context, R.attr.qmui_dialog_inset_hor);
        this.mInsetVer = QMUIResHelper.getAttrDimen(context, R.attr.qmui_dialog_inset_ver);
        setId(R.id.qmui_dialog_root_layout);
    }

    public void setMinWidth(int i) {
        this.mMinWidth = i;
    }

    public void setMaxWidth(int i) {
        this.mMaxWidth = i;
    }

    public void setInsetHor(int i) {
        this.mInsetHor = i;
    }

    public void setInsetVer(int i) {
        this.mInsetVer = i;
    }

    public void setOverlayOccurInMeasureCallback(OverlayOccurInMeasureCallback overlayOccurInMeasureCallback) {
        this.mOverlayOccurInMeasureCallback = overlayOccurInMeasureCallback;
    }

    public void setCheckKeyboardOverlay(boolean z) {
        this.mCheckKeyboardOverlay = z;
    }

    public void setMaxPercent(float f) {
        this.mMaxPercent = f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int iMakeMeasureSpec;
        int iMin;
        int iMakeMeasureSpec2;
        if (this.mCheckKeyboardOverlay) {
            Rect rectUnSafeGetWindowVisibleInsets = QMUIWindowHelper.unSafeGetWindowVisibleInsets(this);
            Rect rectUnSafeGetContentInsets = QMUIWindowHelper.unSafeGetContentInsets(this);
            i3 = rectUnSafeGetWindowVisibleInsets != null ? rectUnSafeGetWindowVisibleInsets.bottom : 0;
            if (rectUnSafeGetContentInsets != null) {
                this.mLastContentInsetTop = rectUnSafeGetContentInsets.top;
                i4 = rectUnSafeGetContentInsets.top + rectUnSafeGetContentInsets.bottom;
            } else {
                i4 = 0;
            }
        } else {
            i3 = 0;
            i4 = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (this.mDialogViewLp.width > 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mDialogViewLp.width, 1073741824);
        } else {
            int iMin2 = Math.min(this.mMaxWidth, size - (this.mInsetHor * 2));
            int i5 = this.mMinWidth;
            if (iMin2 <= i5) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            } else if (this.mDialogViewLp.width == -1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin2, 1073741824);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin2, Integer.MIN_VALUE);
            }
        }
        if (this.mDialogViewLp.height > 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.mDialogViewLp.height, 1073741824);
        } else {
            if (i3 > 0) {
                if (getRootView() != null && getRootView().getHeight() > 0) {
                    size2 = getRootView().getHeight();
                    if (!this.isOverlayOccurEventNotified) {
                        this.isOverlayOccurEventNotified = true;
                        OverlayOccurInMeasureCallback overlayOccurInMeasureCallback = this.mOverlayOccurInMeasureCallback;
                        if (overlayOccurInMeasureCallback != null) {
                            overlayOccurInMeasureCallback.call();
                        }
                    }
                }
                iMin = Math.max(((size2 - (this.mInsetVer * 2)) - i3) - i4, 0);
            } else {
                this.isOverlayOccurEventNotified = false;
                iMin = Math.min((size2 - (this.mInsetVer * 2)) - i4, (int) ((QMUIDisplayHelper.getScreenHeight(getContext()) * this.mMaxPercent) - (this.mInsetVer * 2)));
            }
            if (this.mDialogViewLp.height == -1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
            } else {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
            }
        }
        this.mDialogView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        int measuredWidth = this.mDialogView.getMeasuredWidth();
        int i6 = this.mMinWidth;
        if (measuredWidth < i6) {
            this.mDialogView.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), iMakeMeasureSpec2);
        }
        setMeasuredDimension(this.mDialogView.getMeasuredWidth(), this.mDialogView.getMeasuredHeight() + (this.mInsetVer * 2) + i3 + i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = ((i3 - i) - this.mDialogView.getMeasuredWidth()) / 2;
        QMUIDialogView qMUIDialogView = this.mDialogView;
        qMUIDialogView.layout(measuredWidth, this.mInsetVer, qMUIDialogView.getMeasuredWidth() + measuredWidth, this.mInsetVer + this.mDialogView.getMeasuredHeight());
    }

    public QMUIDialogView getDialogView() {
        return this.mDialogView;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mLastContentInsetTop > 0) {
            motionEvent.offsetLocation(0.0f, -r0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
