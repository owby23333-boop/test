package com.qmuiteam.qmui.span;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.QMUILog;
import com.qmuiteam.qmui.link.ITouchableSpan;
import com.qmuiteam.qmui.skin.IQMUISkinHandlerSpan;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUITouchableSpan extends ClickableSpan implements ITouchableSpan, IQMUISkinHandlerSpan {
    private static final String TAG = "QMUITouchableSpan";
    private boolean mIsNeedUnderline = false;
    private boolean mIsPressed;
    private int mNormalBackgroundColor;
    private int mNormalBgAttr;
    private int mNormalTextColor;
    private int mNormalTextColorAttr;
    private int mPressedBackgroundColor;
    private int mPressedBgAttr;
    private int mPressedTextColor;
    private int mPressedTextColorAttr;

    public abstract void onSpanClick(View view);

    @Override // android.text.style.ClickableSpan, com.qmuiteam.qmui.link.ITouchableSpan
    public final void onClick(View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            onSpanClick(view);
        }
    }

    public QMUITouchableSpan(int i, int i2, int i3, int i4) {
        this.mNormalTextColor = i;
        this.mPressedTextColor = i2;
        this.mNormalBackgroundColor = i3;
        this.mPressedBackgroundColor = i4;
    }

    public QMUITouchableSpan(View view, int i, int i2, int i3, int i4) {
        this.mNormalBgAttr = i3;
        this.mPressedBgAttr = i4;
        this.mNormalTextColorAttr = i;
        this.mPressedTextColorAttr = i2;
        if (i != 0) {
            this.mNormalTextColor = QMUISkinHelper.getSkinColor(view, i);
        }
        if (i2 != 0) {
            this.mPressedTextColor = QMUISkinHelper.getSkinColor(view, i2);
        }
        if (i3 != 0) {
            this.mNormalBackgroundColor = QMUISkinHelper.getSkinColor(view, i3);
        }
        if (i4 != 0) {
            this.mPressedBackgroundColor = QMUISkinHelper.getSkinColor(view, i4);
        }
    }

    public int getNormalBackgroundColor() {
        return this.mNormalBackgroundColor;
    }

    public void setNormalTextColor(int i) {
        this.mNormalTextColor = i;
    }

    public void setPressedTextColor(int i) {
        this.mPressedTextColor = i;
    }

    public int getNormalTextColor() {
        return this.mNormalTextColor;
    }

    public int getPressedBackgroundColor() {
        return this.mPressedBackgroundColor;
    }

    public int getPressedTextColor() {
        return this.mPressedTextColor;
    }

    @Override // com.qmuiteam.qmui.link.ITouchableSpan
    public void setPressed(boolean z) {
        this.mIsPressed = z;
    }

    public boolean isPressed() {
        return this.mIsPressed;
    }

    public void setIsNeedUnderline(boolean z) {
        this.mIsNeedUnderline = z;
    }

    public boolean isNeedUnderline() {
        return this.mIsNeedUnderline;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.mIsPressed ? this.mPressedTextColor : this.mNormalTextColor);
        textPaint.bgColor = this.mIsPressed ? this.mPressedBackgroundColor : this.mNormalBackgroundColor;
        textPaint.setUnderlineText(this.mIsNeedUnderline);
    }

    @Override // com.qmuiteam.qmui.skin.IQMUISkinHandlerSpan
    public void handle(View view, QMUISkinManager qMUISkinManager, int i, Resources.Theme theme) {
        boolean z;
        int i2 = this.mNormalTextColorAttr;
        if (i2 != 0) {
            this.mNormalTextColor = QMUIResHelper.getAttrColor(theme, i2);
            z = false;
        } else {
            z = true;
        }
        int i3 = this.mPressedTextColorAttr;
        if (i3 != 0) {
            this.mPressedTextColor = QMUIResHelper.getAttrColor(theme, i3);
            z = false;
        }
        int i4 = this.mNormalBgAttr;
        if (i4 != 0) {
            this.mNormalBackgroundColor = QMUIResHelper.getAttrColor(theme, i4);
            z = false;
        }
        int i5 = this.mPressedBgAttr;
        if (i5 != 0) {
            this.mPressedBackgroundColor = QMUIResHelper.getAttrColor(theme, i5);
            z = false;
        }
        if (z) {
            QMUILog.w(TAG, "There are no attrs for skin. Please use constructor with 5 parameters", new Object[0]);
        }
    }
}
