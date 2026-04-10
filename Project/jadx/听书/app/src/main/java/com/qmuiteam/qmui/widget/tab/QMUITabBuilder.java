package com.qmuiteam.qmui.widget.tab;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITabBuilder {
    private boolean allowIconDrawOutside;
    private boolean dynamicChangeIconColor;
    private int gravity;
    private int iconPosition;
    private int iconTextGap;
    private int normalColor;
    private int normalColorAttr;
    private Drawable normalDrawable;
    private int normalDrawableAttr;
    int normalTabIconHeight;
    private int normalTabIconWidth;
    private int normalTextSize;
    private Typeface normalTypeface;
    private int selectColor;
    private int selectTextSize;
    private int selectedColorAttr;
    private Drawable selectedDrawable;
    private int selectedDrawableAttr;
    float selectedTabIconScale;
    private Typeface selectedTypeface;
    private int signCount;
    private int signCountDigits;
    private int signCountHorizontalOffset;
    private int signCountVerticalAlign;
    private int signCountVerticalOffset;
    private boolean skinChangeNormalWithTintColor;
    private boolean skinChangeSelectedWithTintColor;
    private boolean skinChangeWithTintColor;
    private CharSequence text;
    float typefaceUpdateAreaPercent;

    QMUITabBuilder(Context context) {
        this.normalDrawableAttr = 0;
        this.selectedDrawableAttr = 0;
        this.dynamicChangeIconColor = false;
        this.skinChangeWithTintColor = false;
        this.skinChangeNormalWithTintColor = true;
        this.skinChangeSelectedWithTintColor = true;
        this.normalColorAttr = R.attr.qmui_skin_support_tab_normal_color;
        this.selectedColorAttr = R.attr.qmui_skin_support_tab_selected_color;
        this.normalColor = 0;
        this.selectColor = 0;
        this.iconPosition = 1;
        this.gravity = 17;
        this.normalTabIconWidth = -1;
        this.normalTabIconHeight = -1;
        this.selectedTabIconScale = 1.0f;
        this.typefaceUpdateAreaPercent = 0.25f;
        this.signCount = 0;
        this.signCountDigits = 2;
        this.signCountVerticalAlign = 0;
        this.allowIconDrawOutside = true;
        this.iconTextGap = QMUIDisplayHelper.dp2px(context, 2);
        int iDp2px = QMUIDisplayHelper.dp2px(context, 12);
        this.selectTextSize = iDp2px;
        this.normalTextSize = iDp2px;
        int iDp2px2 = QMUIDisplayHelper.dp2px(context, 3);
        this.signCountHorizontalOffset = iDp2px2;
        this.signCountVerticalOffset = iDp2px2;
    }

    QMUITabBuilder(QMUITabBuilder qMUITabBuilder) {
        this.normalDrawableAttr = 0;
        this.selectedDrawableAttr = 0;
        this.dynamicChangeIconColor = false;
        this.skinChangeWithTintColor = false;
        this.skinChangeNormalWithTintColor = true;
        this.skinChangeSelectedWithTintColor = true;
        this.normalColorAttr = R.attr.qmui_skin_support_tab_normal_color;
        this.selectedColorAttr = R.attr.qmui_skin_support_tab_selected_color;
        this.normalColor = 0;
        this.selectColor = 0;
        this.iconPosition = 1;
        this.gravity = 17;
        this.normalTabIconWidth = -1;
        this.normalTabIconHeight = -1;
        this.selectedTabIconScale = 1.0f;
        this.typefaceUpdateAreaPercent = 0.25f;
        this.signCount = 0;
        this.signCountDigits = 2;
        this.signCountVerticalAlign = 0;
        this.allowIconDrawOutside = true;
        this.normalDrawableAttr = qMUITabBuilder.normalDrawableAttr;
        this.selectedDrawableAttr = qMUITabBuilder.selectedDrawableAttr;
        this.normalDrawable = qMUITabBuilder.normalDrawable;
        this.selectedDrawable = qMUITabBuilder.selectedDrawable;
        this.dynamicChangeIconColor = qMUITabBuilder.dynamicChangeIconColor;
        this.normalTextSize = qMUITabBuilder.normalTextSize;
        this.selectTextSize = qMUITabBuilder.selectTextSize;
        this.normalColorAttr = qMUITabBuilder.normalColorAttr;
        this.selectedColorAttr = qMUITabBuilder.selectedColorAttr;
        this.iconPosition = qMUITabBuilder.iconPosition;
        this.gravity = qMUITabBuilder.gravity;
        this.text = qMUITabBuilder.text;
        this.signCount = qMUITabBuilder.signCount;
        this.signCountDigits = qMUITabBuilder.signCountDigits;
        this.signCountHorizontalOffset = qMUITabBuilder.signCountHorizontalOffset;
        this.signCountVerticalOffset = qMUITabBuilder.signCountVerticalOffset;
        this.signCountVerticalAlign = qMUITabBuilder.signCountVerticalAlign;
        this.normalTypeface = qMUITabBuilder.normalTypeface;
        this.selectedTypeface = qMUITabBuilder.selectedTypeface;
        this.normalTabIconWidth = qMUITabBuilder.normalTabIconWidth;
        this.normalTabIconHeight = qMUITabBuilder.normalTabIconHeight;
        this.selectedTabIconScale = qMUITabBuilder.selectedTabIconScale;
        this.iconTextGap = qMUITabBuilder.iconTextGap;
        this.allowIconDrawOutside = qMUITabBuilder.allowIconDrawOutside;
        this.typefaceUpdateAreaPercent = qMUITabBuilder.typefaceUpdateAreaPercent;
        this.skinChangeNormalWithTintColor = qMUITabBuilder.skinChangeNormalWithTintColor;
        this.skinChangeSelectedWithTintColor = qMUITabBuilder.skinChangeSelectedWithTintColor;
        this.skinChangeWithTintColor = qMUITabBuilder.skinChangeWithTintColor;
        this.normalColor = qMUITabBuilder.normalColor;
        this.selectColor = qMUITabBuilder.selectColor;
    }

    public QMUITabBuilder setAllowIconDrawOutside(boolean z) {
        this.allowIconDrawOutside = z;
        return this;
    }

    public QMUITabBuilder setTypefaceUpdateAreaPercent(float f) {
        this.typefaceUpdateAreaPercent = f;
        return this;
    }

    public QMUITabBuilder setNormalDrawable(Drawable drawable) {
        this.normalDrawable = drawable;
        return this;
    }

    public QMUITabBuilder setNormalDrawableAttr(int i) {
        this.normalDrawableAttr = i;
        return this;
    }

    public QMUITabBuilder setSelectedDrawable(Drawable drawable) {
        this.selectedDrawable = drawable;
        return this;
    }

    public QMUITabBuilder setSelectedDrawableAttr(int i) {
        this.selectedDrawableAttr = i;
        return this;
    }

    @Deprecated
    public QMUITabBuilder skinChangeWithTintColor(boolean z) {
        this.skinChangeWithTintColor = z;
        return this;
    }

    public QMUITabBuilder skinChangeNormalWithTintColor(boolean z) {
        this.skinChangeNormalWithTintColor = z;
        return this;
    }

    public QMUITabBuilder skinChangeSelectedWithTintColor(boolean z) {
        this.skinChangeSelectedWithTintColor = z;
        return this;
    }

    public QMUITabBuilder setTextSize(int i, int i2) {
        this.normalTextSize = i;
        this.selectTextSize = i2;
        return this;
    }

    public QMUITabBuilder setTypeface(Typeface typeface, Typeface typeface2) {
        this.normalTypeface = typeface;
        this.selectedTypeface = typeface2;
        return this;
    }

    public QMUITabBuilder setNormalIconSizeInfo(int i, int i2) {
        this.normalTabIconWidth = i;
        this.normalTabIconHeight = i2;
        return this;
    }

    public QMUITabBuilder setSelectedIconScale(float f) {
        this.selectedTabIconScale = f;
        return this;
    }

    public QMUITabBuilder setIconTextGap(int i) {
        this.iconTextGap = i;
        return this;
    }

    public QMUITabBuilder setSignCount(int i) {
        this.signCount = i;
        return this;
    }

    public QMUITabBuilder setSignCountMarginInfo(int i, int i2, int i3) {
        return setSignCountMarginInfo(i, i2, 0, i3);
    }

    public QMUITabBuilder setSignCountMarginInfo(int i, int i2, int i3, int i4) {
        this.signCountDigits = i;
        this.signCountHorizontalOffset = i2;
        this.signCountVerticalOffset = i4;
        this.signCountVerticalAlign = i3;
        return this;
    }

    public QMUITabBuilder setColorAttr(int i, int i2) {
        this.normalColorAttr = i;
        this.selectedColorAttr = i2;
        return this;
    }

    public QMUITabBuilder setNormalColorAttr(int i) {
        this.normalColorAttr = i;
        return this;
    }

    public QMUITabBuilder setSelectedColorAttr(int i) {
        this.selectedColorAttr = i;
        return this;
    }

    public QMUITabBuilder setColor(int i, int i2) {
        this.normalColorAttr = 0;
        this.selectedColorAttr = 0;
        this.normalColor = i;
        this.selectColor = i2;
        return this;
    }

    public QMUITabBuilder setNormalColor(int i) {
        this.normalColorAttr = 0;
        this.normalColor = i;
        return this;
    }

    public QMUITabBuilder setSelectColor(int i) {
        this.selectedColorAttr = 0;
        this.selectColor = i;
        return this;
    }

    public QMUITabBuilder setDynamicChangeIconColor(boolean z) {
        this.dynamicChangeIconColor = z;
        return this;
    }

    public QMUITabBuilder setGravity(int i) {
        this.gravity = i;
        return this;
    }

    public QMUITabBuilder setIconPosition(int i) {
        this.iconPosition = i;
        return this;
    }

    public QMUITabBuilder setText(CharSequence charSequence) {
        this.text = charSequence;
        return this;
    }

    public QMUITab build(Context context) {
        int i;
        int i2;
        QMUITab qMUITab = new QMUITab(this.text);
        if (!this.skinChangeWithTintColor) {
            if (!this.skinChangeNormalWithTintColor && (i2 = this.normalDrawableAttr) != 0) {
                this.normalDrawable = QMUIResHelper.getAttrDrawable(context, i2);
            }
            if (!this.skinChangeSelectedWithTintColor && (i = this.selectedDrawableAttr) != 0) {
                this.selectedDrawable = QMUIResHelper.getAttrDrawable(context, i);
            }
        }
        qMUITab.skinChangeWithTintColor = this.skinChangeWithTintColor;
        qMUITab.skinChangeNormalWithTintColor = this.skinChangeNormalWithTintColor;
        qMUITab.skinChangeSelectedWithTintColor = this.skinChangeSelectedWithTintColor;
        if (this.normalDrawable != null) {
            if (this.dynamicChangeIconColor || this.selectedDrawable == null) {
                qMUITab.tabIcon = new QMUITabIcon(this.normalDrawable, null, true);
                qMUITab.skinChangeSelectedWithTintColor = qMUITab.skinChangeNormalWithTintColor;
            } else {
                qMUITab.tabIcon = new QMUITabIcon(this.normalDrawable, this.selectedDrawable, false);
            }
            qMUITab.tabIcon.setBounds(0, 0, this.normalTabIconWidth, this.normalTabIconHeight);
        }
        qMUITab.normalIconAttr = this.normalDrawableAttr;
        qMUITab.selectedIconAttr = this.selectedDrawableAttr;
        qMUITab.normalTabIconWidth = this.normalTabIconWidth;
        qMUITab.normalTabIconHeight = this.normalTabIconHeight;
        qMUITab.selectedTabIconScale = this.selectedTabIconScale;
        qMUITab.gravity = this.gravity;
        qMUITab.iconPosition = this.iconPosition;
        qMUITab.normalTextSize = this.normalTextSize;
        qMUITab.selectedTextSize = this.selectTextSize;
        qMUITab.normalTypeface = this.normalTypeface;
        qMUITab.selectedTypeface = this.selectedTypeface;
        qMUITab.normalColorAttr = this.normalColorAttr;
        qMUITab.selectedColorAttr = this.selectedColorAttr;
        qMUITab.normalColor = this.normalColor;
        qMUITab.selectColor = this.selectColor;
        qMUITab.signCount = this.signCount;
        qMUITab.signCountDigits = this.signCountDigits;
        qMUITab.signCountHorizontalOffset = this.signCountHorizontalOffset;
        qMUITab.signCountVerticalAlign = this.signCountVerticalAlign;
        qMUITab.signCountVerticalOffset = this.signCountVerticalOffset;
        qMUITab.iconTextGap = this.iconTextGap;
        qMUITab.typefaceUpdateAreaPercent = this.typefaceUpdateAreaPercent;
        return qMUITab;
    }
}
