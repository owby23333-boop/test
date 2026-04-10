package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIPriorityLinearLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes5.dex */
public class QMUIBottomSheetRootLayout extends QMUIPriorityLinearLayout {
    private final float mHeightPercent;
    private final int mMaxWidth;
    private final int mUsePercentMinHeight;

    public QMUIBottomSheetRootLayout(Context context) {
        this(context, null);
    }

    public QMUIBottomSheetRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        setBackground(QMUIResHelper.getAttrDrawable(context, R.attr.qmui_skin_support_bottom_sheet_bg));
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(R.attr.qmui_skin_support_bottom_sheet_bg);
        QMUISkinHelper.setSkinValue(this, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
        int attrDimen = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_radius);
        if (attrDimen > 0) {
            setRadius(attrDimen, 3);
        }
        this.mUsePercentMinHeight = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_use_percent_min_height);
        this.mHeightPercent = QMUIResHelper.getAttrFloatValue(context, R.attr.qmui_bottom_sheet_height_percent);
        this.mMaxWidth = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_max_width);
    }

    @Override // com.qmuiteam.qmui.layout.QMUIPriorityLinearLayout, com.qmuiteam.qmui.layout.QMUILinearLayout, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int i3 = this.mMaxWidth;
        if (size > i3) {
            i = View.MeasureSpec.makeMeasureSpec(i3, mode);
        }
        int size2 = View.MeasureSpec.getSize(i2);
        if (size2 >= this.mUsePercentMinHeight) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (size2 * this.mHeightPercent), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
    }
}
