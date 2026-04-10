package com.qmuiteam.qmui.widget.tab;

import android.graphics.Typeface;
import android.view.View;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITab {
    public static final int ICON_POSITION_BOTTOM = 3;
    public static final int ICON_POSITION_LEFT = 0;
    public static final int ICON_POSITION_RIGHT = 2;
    public static final int ICON_POSITION_TOP = 1;
    public static final int NO_SIGN_COUNT_AND_RED_POINT = 0;
    public static final int RED_POINT_SIGN_COUNT = -1;
    public static final int SIGN_COUNT_VERTICAL_ALIGN_BOTTOM_TO_CONTENT_TOP = 0;
    public static final int SIGN_COUNT_VERTICAL_ALIGN_MIDDLE_TO_CONTENT = 2;
    public static final int SIGN_COUNT_VERTICAL_ALIGN_TOP_TO_CONTENT_TOP = 1;
    boolean allowIconDrawOutside;
    int iconTextGap;
    int normalColor;
    int normalColorAttr;
    int normalIconAttr;
    int normalTextSize;
    Typeface normalTypeface;
    int selectColor;
    int selectedColorAttr;
    int selectedIconAttr;
    int selectedTextSize;
    Typeface selectedTypeface;
    boolean skinChangeNormalWithTintColor;
    boolean skinChangeSelectedWithTintColor;
    boolean skinChangeWithTintColor;
    private CharSequence text;
    float typefaceUpdateAreaPercent;
    int normalTabIconWidth = -1;
    int normalTabIconHeight = -1;
    float selectedTabIconScale = 1.0f;
    QMUITabIcon tabIcon = null;
    int contentWidth = 0;
    int contentLeft = 0;
    int iconPosition = 1;
    int gravity = 17;
    int signCountDigits = 2;
    int signCountHorizontalOffset = 0;
    int signCountVerticalOffset = 0;
    int signCountVerticalAlign = 0;
    int signCount = 0;
    float rightSpaceWeight = 0.0f;
    float leftSpaceWeight = 0.0f;
    int leftAddonMargin = 0;
    int rightAddonMargin = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconPosition {
    }

    QMUITab(CharSequence charSequence) {
        this.text = charSequence;
    }

    public CharSequence getText() {
        return this.text;
    }

    public void setText(CharSequence charSequence) {
        this.text = charSequence;
    }

    public int getIconPosition() {
        return this.iconPosition;
    }

    public void setIconPosition(int i) {
        this.iconPosition = i;
    }

    public void setSpaceWeight(float f, float f2) {
        this.leftSpaceWeight = f;
        this.rightSpaceWeight = f2;
    }

    public void setTypefaceUpdateAreaPercent(float f) {
        this.typefaceUpdateAreaPercent = f;
    }

    public float getTypefaceUpdateAreaPercent() {
        return this.typefaceUpdateAreaPercent;
    }

    public int getGravity() {
        return this.gravity;
    }

    public void setGravity(int i) {
        this.gravity = i;
    }

    public void setSignCount(int i) {
        this.signCount = i;
    }

    public void setRedPoint() {
        this.signCount = -1;
    }

    public int getSignCount() {
        return this.signCount;
    }

    public boolean isRedPointShowing() {
        return this.signCount == -1;
    }

    public void clearSignCountOrRedPoint() {
        this.signCount = 0;
    }

    public int getNormalColor(View view) {
        int i = this.normalColorAttr;
        if (i == 0) {
            return this.normalColor;
        }
        return QMUISkinHelper.getSkinColor(view, i);
    }

    public int getSelectColor(View view) {
        int i = this.selectedColorAttr;
        if (i == 0) {
            return this.selectColor;
        }
        return QMUISkinHelper.getSkinColor(view, i);
    }

    public int getNormalColorAttr() {
        return this.normalColorAttr;
    }

    public int getSelectedColorAttr() {
        return this.selectedColorAttr;
    }

    public int getNormalIconAttr() {
        return this.normalIconAttr;
    }

    public int getSelectedIconAttr() {
        return this.selectedIconAttr;
    }

    public int getNormalTextSize() {
        return this.normalTextSize;
    }

    public int getSelectedTextSize() {
        return this.selectedTextSize;
    }

    public QMUITabIcon getTabIcon() {
        return this.tabIcon;
    }

    public Typeface getNormalTypeface() {
        return this.normalTypeface;
    }

    public Typeface getSelectedTypeface() {
        return this.selectedTypeface;
    }

    public int getNormalTabIconWidth() {
        QMUITabIcon qMUITabIcon;
        int i = this.normalTabIconWidth;
        return (i != -1 || (qMUITabIcon = this.tabIcon) == null) ? i : qMUITabIcon.getIntrinsicWidth();
    }

    public int getNormalTabIconHeight() {
        QMUITabIcon qMUITabIcon;
        int i = this.normalTabIconHeight;
        return (i != -1 || (qMUITabIcon = this.tabIcon) == null) ? i : qMUITabIcon.getIntrinsicWidth();
    }

    public float getSelectedTabIconScale() {
        return this.selectedTabIconScale;
    }

    public int getIconTextGap() {
        return this.iconTextGap;
    }

    public boolean isAllowIconDrawOutside() {
        return this.allowIconDrawOutside;
    }
}
