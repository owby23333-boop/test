package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUITipDialogView extends QMUILinearLayout {
    private final int mMaxWidth;
    private final int mMiniHeight;
    private final int mMiniWidth;

    public QMUITipDialogView(Context context) {
        super(context);
        setOrientation(1);
        setGravity(1);
        int attrDimen = QMUIResHelper.getAttrDimen(context, R.attr.qmui_tip_dialog_radius);
        Drawable attrDrawable = QMUIResHelper.getAttrDrawable(context, R.attr.qmui_skin_support_tip_dialog_bg);
        int attrDimen2 = QMUIResHelper.getAttrDimen(context, R.attr.qmui_tip_dialog_padding_horizontal);
        int attrDimen3 = QMUIResHelper.getAttrDimen(context, R.attr.qmui_tip_dialog_padding_vertical);
        setBackground(attrDrawable);
        setPadding(attrDimen2, attrDimen3, attrDimen2, attrDimen3);
        setRadius(attrDimen);
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(R.attr.qmui_skin_support_tip_dialog_bg);
        QMUISkinHelper.setSkinValue(this, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
        this.mMaxWidth = QMUIResHelper.getAttrDimen(context, R.attr.qmui_tip_dialog_max_width);
        this.mMiniWidth = QMUIResHelper.getAttrDimen(context, R.attr.qmui_tip_dialog_min_width);
        this.mMiniHeight = QMUIResHelper.getAttrDimen(context, R.attr.qmui_tip_dialog_min_height);
    }

    @Override // com.qmuiteam.qmui.layout.QMUILinearLayout, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int i3 = this.mMaxWidth;
        if (size > i3) {
            i = View.MeasureSpec.makeMeasureSpec(i3, mode);
        }
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int i4 = this.mMiniWidth;
        boolean z2 = true;
        if (measuredWidth < i4) {
            i = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            z = true;
        } else {
            z = false;
        }
        int measuredHeight = getMeasuredHeight();
        int i5 = this.mMiniHeight;
        if (measuredHeight < i5) {
            i2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        } else {
            z2 = z;
        }
        if (z2) {
            super.onMeasure(i, i2);
        }
    }
}
