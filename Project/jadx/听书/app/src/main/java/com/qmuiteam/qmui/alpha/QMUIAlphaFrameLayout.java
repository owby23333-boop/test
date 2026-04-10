package com.qmuiteam.qmui.alpha;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIAlphaFrameLayout extends FrameLayout implements QMUIAlphaViewInf {
    private QMUIAlphaViewHelper mAlphaViewHelper;

    public QMUIAlphaFrameLayout(Context context) {
        super(context);
    }

    public QMUIAlphaFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIAlphaFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private QMUIAlphaViewHelper getAlphaViewHelper() {
        if (this.mAlphaViewHelper == null) {
            this.mAlphaViewHelper = new QMUIAlphaViewHelper(this);
        }
        return this.mAlphaViewHelper;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        getAlphaViewHelper().onPressedChanged(this, z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        getAlphaViewHelper().onEnabledChanged(this, z);
    }

    @Override // com.qmuiteam.qmui.alpha.QMUIAlphaViewInf
    public void setChangeAlphaWhenPress(boolean z) {
        getAlphaViewHelper().setChangeAlphaWhenPress(z);
    }

    @Override // com.qmuiteam.qmui.alpha.QMUIAlphaViewInf
    public void setChangeAlphaWhenDisable(boolean z) {
        getAlphaViewHelper().setChangeAlphaWhenDisable(z);
    }
}
