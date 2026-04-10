package com.qmuiteam.qmui.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import com.qmuiteam.qmui.layout.IQMUILayout;
import com.qmuiteam.qmui.layout.QMUILayoutHelper;
import com.qmuiteam.qmui.link.QMUILinkTouchMovementMethod;

/* JADX INFO: loaded from: classes4.dex */
public class QMUISpanTouchFixTextView extends AppCompatTextView implements ISpanTouchFix, IQMUILayout {
    private boolean mIsPressedRecord;
    private QMUILayoutHelper mLayoutHelper;
    private boolean mNeedForceEventToParent;
    private boolean mTouchSpanHit;

    public QMUISpanTouchFixTextView(Context context) {
        this(context, null);
    }

    public QMUISpanTouchFixTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUISpanTouchFixTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsPressedRecord = false;
        this.mNeedForceEventToParent = false;
        setHighlightColor(0);
        this.mLayoutHelper = new QMUILayoutHelper(context, attributeSet, i, this);
    }

    public void setNeedForceEventToParent(boolean z) {
        this.mNeedForceEventToParent = z;
        setFocusable(!z);
        setClickable(!z);
        setLongClickable(!z);
    }

    public void setMovementMethodDefault() {
        setMovementMethodCompat(QMUILinkTouchMovementMethod.getInstance());
    }

    public void setMovementMethodCompat(MovementMethod movementMethod) {
        setMovementMethod(movementMethod);
        if (this.mNeedForceEventToParent) {
            setNeedForceEventToParent(true);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(getText() instanceof Spannable) || !(getMovementMethod() instanceof QMUILinkTouchMovementMethod)) {
            this.mTouchSpanHit = false;
            return super.onTouchEvent(motionEvent);
        }
        this.mTouchSpanHit = true;
        return this.mNeedForceEventToParent ? this.mTouchSpanHit : super.onTouchEvent(motionEvent);
    }

    @Override // com.qmuiteam.qmui.widget.textview.ISpanTouchFix
    public void setTouchSpanHit(boolean z) {
        if (this.mTouchSpanHit != z) {
            this.mTouchSpanHit = z;
            setPressed(this.mIsPressedRecord);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.mTouchSpanHit || this.mNeedForceEventToParent) {
            return false;
        }
        return super.performClick();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        if (this.mTouchSpanHit || this.mNeedForceEventToParent) {
            return false;
        }
        return super.performLongClick();
    }

    @Override // android.view.View
    public final void setPressed(boolean z) {
        this.mIsPressedRecord = z;
        if (this.mTouchSpanHit) {
            return;
        }
        onSetPressed(z);
    }

    protected void onSetPressed(boolean z) {
        super.setPressed(z);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateTopDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateTopDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateBottomDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateBottomDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateLeftDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateLeftDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateRightDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.updateRightDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void onlyShowTopDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowTopDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void onlyShowBottomDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowBottomDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void onlyShowLeftDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowLeftDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void onlyShowRightDivider(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.onlyShowRightDivider(i, i2, i3, i4);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setTopDividerAlpha(int i) {
        this.mLayoutHelper.setTopDividerAlpha(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setBottomDividerAlpha(int i) {
        this.mLayoutHelper.setBottomDividerAlpha(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setLeftDividerAlpha(int i) {
        this.mLayoutHelper.setLeftDividerAlpha(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRightDividerAlpha(int i) {
        this.mLayoutHelper.setRightDividerAlpha(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setHideRadiusSide(int i) {
        this.mLayoutHelper.setHideRadiusSide(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public int getHideRadiusSide() {
        return this.mLayoutHelper.getHideRadiusSide();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredWidthSpec = this.mLayoutHelper.getMeasuredWidthSpec(i);
        int measuredHeightSpec = this.mLayoutHelper.getMeasuredHeightSpec(i2);
        super.onMeasure(measuredWidthSpec, measuredHeightSpec);
        int iHandleMiniWidth = this.mLayoutHelper.handleMiniWidth(measuredWidthSpec, getMeasuredWidth());
        int iHandleMiniHeight = this.mLayoutHelper.handleMiniHeight(measuredHeightSpec, getMeasuredHeight());
        if (measuredWidthSpec == iHandleMiniWidth && measuredHeightSpec == iHandleMiniHeight) {
            return;
        }
        super.onMeasure(iHandleMiniWidth, iHandleMiniHeight);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, float f) {
        this.mLayoutHelper.setRadiusAndShadow(i, i2, f);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, int i3, float f) {
        this.mLayoutHelper.setRadiusAndShadow(i, i2, i3, f);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRadiusAndShadow(int i, int i2, int i3, int i4, float f) {
        this.mLayoutHelper.setRadiusAndShadow(i, i2, i3, i4, f);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRadius(int i) {
        this.mLayoutHelper.setRadius(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setRadius(int i, int i2) {
        this.mLayoutHelper.setRadius(i, i2);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public int getRadius() {
        return this.mLayoutHelper.getRadius();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setOutlineInset(int i, int i2, int i3, int i4) {
        this.mLayoutHelper.setOutlineInset(i, i2, i3, i4);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setBorderColor(int i) {
        this.mLayoutHelper.setBorderColor(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setBorderWidth(int i) {
        this.mLayoutHelper.setBorderWidth(i);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setShowBorderOnlyBeforeL(boolean z) {
        this.mLayoutHelper.setShowBorderOnlyBeforeL(z);
        invalidate();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean setWidthLimit(int i) {
        if (!this.mLayoutHelper.setWidthLimit(i)) {
            return true;
        }
        requestLayout();
        invalidate();
        return true;
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean setHeightLimit(int i) {
        if (!this.mLayoutHelper.setHeightLimit(i)) {
            return true;
        }
        requestLayout();
        invalidate();
        return true;
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setUseThemeGeneralShadowElevation() {
        this.mLayoutHelper.setUseThemeGeneralShadowElevation();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setOutlineExcludePadding(boolean z) {
        this.mLayoutHelper.setOutlineExcludePadding(z);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setShadowElevation(int i) {
        this.mLayoutHelper.setShadowElevation(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public int getShadowElevation() {
        return this.mLayoutHelper.getShadowElevation();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setShadowAlpha(float f) {
        this.mLayoutHelper.setShadowAlpha(f);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public float getShadowAlpha() {
        return this.mLayoutHelper.getShadowAlpha();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setShadowColor(int i) {
        this.mLayoutHelper.setShadowColor(i);
    }

    @Override // android.widget.TextView, com.qmuiteam.qmui.layout.IQMUILayout
    public int getShadowColor() {
        return this.mLayoutHelper.getShadowColor();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void setOuterNormalColor(int i) {
        this.mLayoutHelper.setOuterNormalColor(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateBottomSeparatorColor(int i) {
        this.mLayoutHelper.updateBottomSeparatorColor(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateLeftSeparatorColor(int i) {
        this.mLayoutHelper.updateLeftSeparatorColor(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateRightSeparatorColor(int i) {
        this.mLayoutHelper.updateRightSeparatorColor(i);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public void updateTopSeparatorColor(int i) {
        this.mLayoutHelper.updateTopSeparatorColor(i);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mLayoutHelper.drawDividers(canvas, getWidth(), getHeight());
        this.mLayoutHelper.dispatchRoundBorderDraw(canvas);
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean hasBorder() {
        return this.mLayoutHelper.hasBorder();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean hasLeftSeparator() {
        return this.mLayoutHelper.hasLeftSeparator();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean hasTopSeparator() {
        return this.mLayoutHelper.hasTopSeparator();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean hasRightSeparator() {
        return this.mLayoutHelper.hasRightSeparator();
    }

    @Override // com.qmuiteam.qmui.layout.IQMUILayout
    public boolean hasBottomSeparator() {
        return this.mLayoutHelper.hasBottomSeparator();
    }
}
