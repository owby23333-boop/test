package com.qmuiteam.qmui.alpha;

import android.content.Context;
import android.util.AttributeSet;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIAlphaTextView extends QMUISpanTouchFixTextView implements QMUIAlphaViewInf {
    private QMUIAlphaViewHelper mAlphaViewHelper;

    public QMUIAlphaTextView(Context context) {
        super(context);
    }

    public QMUIAlphaTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIAlphaTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private QMUIAlphaViewHelper getAlphaViewHelper() {
        if (this.mAlphaViewHelper == null) {
            this.mAlphaViewHelper = new QMUIAlphaViewHelper(this);
        }
        return this.mAlphaViewHelper;
    }

    @Override // com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView
    protected void onSetPressed(boolean z) {
        super.onSetPressed(z);
        getAlphaViewHelper().onPressedChanged(this, z);
    }

    @Override // android.widget.TextView, android.view.View
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
