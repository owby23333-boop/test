package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIBottomSheetListItemView extends QMUIConstraintLayout {
    private AppCompatImageView mIconView;
    private int mItemHeight;
    private AppCompatImageView mMarkView;
    private QMUIFrameLayout mRedPointView;
    private QMUISpanTouchFixTextView mTextView;

    public QMUIBottomSheetListItemView(Context context, boolean z, boolean z2) {
        super(context);
        this.mMarkView = null;
        setBackground(QMUIResHelper.getAttrDrawable(context, R.attr.qmui_skin_support_bottom_sheet_list_item_bg));
        int attrDimen = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_padding_hor);
        setPadding(attrDimen, 0, attrDimen, 0);
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(R.attr.qmui_skin_support_bottom_sheet_list_item_bg);
        QMUISkinHelper.setSkinValue(this, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        AppCompatImageView appCompatImageView = new AppCompatImageView(context);
        this.mIconView = appCompatImageView;
        appCompatImageView.setId(View.generateViewId());
        this.mIconView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new QMUISpanTouchFixTextView(context);
        this.mTextView = qMUISpanTouchFixTextView;
        qMUISpanTouchFixTextView.setId(View.generateViewId());
        QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new QMUISkinSimpleDefaultAttrProvider();
        qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(QMUISkinValueBuilder.TEXT_COLOR, R.attr.qmui_skin_support_bottom_sheet_list_item_text_color);
        QMUIResHelper.assignTextViewWithAttr(this.mTextView, R.attr.qmui_bottom_sheet_list_item_text_style);
        QMUISkinHelper.setSkinDefaultProvider(this.mTextView, qMUISkinSimpleDefaultAttrProvider);
        QMUIFrameLayout qMUIFrameLayout = new QMUIFrameLayout(context);
        this.mRedPointView = qMUIFrameLayout;
        qMUIFrameLayout.setId(View.generateViewId());
        this.mRedPointView.setBackgroundColor(QMUIResHelper.getAttrColor(context, R.attr.qmui_skin_support_bottom_sheet_list_red_point_color));
        qMUISkinValueBuilderAcquire.background(R.attr.qmui_skin_support_bottom_sheet_list_red_point_color);
        QMUISkinHelper.setSkinValue(this.mRedPointView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        if (z) {
            AppCompatImageView appCompatImageView2 = new AppCompatImageView(context);
            this.mMarkView = appCompatImageView2;
            appCompatImageView2.setId(View.generateViewId());
            this.mMarkView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.mMarkView.setImageDrawable(QMUIResHelper.getAttrDrawable(context, R.attr.qmui_skin_support_bottom_sheet_list_mark));
            qMUISkinValueBuilderAcquire.src(R.attr.qmui_skin_support_bottom_sheet_list_mark);
            QMUISkinHelper.setSkinValue(this.mMarkView, qMUISkinValueBuilderAcquire);
        }
        qMUISkinValueBuilderAcquire.release();
        int attrDimen2 = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_list_item_icon_size);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(attrDimen2, attrDimen2);
        layoutParams.leftToLeft = 0;
        layoutParams.topToTop = 0;
        layoutParams.rightToLeft = this.mTextView.getId();
        layoutParams.bottomToBottom = 0;
        layoutParams.horizontalChainStyle = 2;
        layoutParams.horizontalBias = z2 ? 0.5f : 0.0f;
        addView(this.mIconView, layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.leftToRight = this.mIconView.getId();
        layoutParams2.rightToLeft = this.mRedPointView.getId();
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.horizontalChainStyle = 2;
        layoutParams2.horizontalBias = z2 ? 0.5f : 0.0f;
        layoutParams2.leftMargin = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_list_item_icon_margin_right);
        layoutParams2.goneLeftMargin = 0;
        addView(this.mTextView, layoutParams2);
        int attrDimen3 = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_list_item_red_point_size);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(attrDimen3, attrDimen3);
        layoutParams3.leftToRight = this.mTextView.getId();
        if (z) {
            layoutParams3.rightToLeft = this.mMarkView.getId();
            layoutParams3.rightMargin = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_list_item_mark_margin_left);
        } else {
            layoutParams3.rightToRight = 0;
        }
        layoutParams3.topToTop = 0;
        layoutParams3.bottomToBottom = 0;
        layoutParams3.horizontalChainStyle = 2;
        layoutParams3.horizontalBias = z2 ? 0.5f : 0.0f;
        layoutParams3.leftMargin = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_list_item_tip_point_margin_left);
        addView(this.mRedPointView, layoutParams3);
        if (z) {
            ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams4.rightToRight = 0;
            layoutParams4.topToTop = 0;
            layoutParams4.bottomToBottom = 0;
            addView(this.mMarkView, layoutParams4);
        }
        this.mItemHeight = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_list_item_height);
    }

    public void render(QMUIBottomSheetListItemModel qMUIBottomSheetListItemModel, boolean z) {
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        if (qMUIBottomSheetListItemModel.imageSkinSrcAttr != 0) {
            qMUISkinValueBuilderAcquire.src(qMUIBottomSheetListItemModel.imageSkinSrcAttr);
            QMUISkinHelper.setSkinValue(this.mIconView, qMUISkinValueBuilderAcquire);
            this.mIconView.setImageDrawable(QMUISkinHelper.getSkinDrawable(this, qMUIBottomSheetListItemModel.imageSkinSrcAttr));
            this.mIconView.setVisibility(0);
        } else {
            Drawable drawable = qMUIBottomSheetListItemModel.image;
            if (drawable == null && qMUIBottomSheetListItemModel.imageRes != 0) {
                drawable = ContextCompat.getDrawable(getContext(), qMUIBottomSheetListItemModel.imageRes);
            }
            if (drawable != null) {
                drawable.mutate();
                this.mIconView.setImageDrawable(drawable);
                if (qMUIBottomSheetListItemModel.imageSkinTintColorAttr != 0) {
                    qMUISkinValueBuilderAcquire.tintColor(qMUIBottomSheetListItemModel.imageSkinTintColorAttr);
                    QMUISkinHelper.setSkinValue(this.mIconView, qMUISkinValueBuilderAcquire);
                } else {
                    QMUISkinHelper.setSkinValue(this.mIconView, "");
                }
            } else {
                this.mIconView.setVisibility(8);
            }
        }
        qMUISkinValueBuilderAcquire.clear();
        this.mTextView.setText(qMUIBottomSheetListItemModel.text);
        if (qMUIBottomSheetListItemModel.typeface != null) {
            this.mTextView.setTypeface(qMUIBottomSheetListItemModel.typeface);
        }
        if (qMUIBottomSheetListItemModel.textSkinColorAttr != 0) {
            qMUISkinValueBuilderAcquire.textColor(qMUIBottomSheetListItemModel.textSkinColorAttr);
            QMUISkinHelper.setSkinValue(this.mTextView, qMUISkinValueBuilderAcquire);
            ColorStateList skinColorStateList = QMUISkinHelper.getSkinColorStateList(this.mTextView, qMUIBottomSheetListItemModel.textSkinColorAttr);
            if (skinColorStateList != null) {
                this.mTextView.setTextColor(skinColorStateList);
            }
        } else {
            QMUISkinHelper.setSkinValue(this.mTextView, "");
        }
        this.mRedPointView.setVisibility(qMUIBottomSheetListItemModel.hasRedPoint ? 0 : 8);
        AppCompatImageView appCompatImageView = this.mMarkView;
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.qmuiteam.qmui.layout.QMUIConstraintLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
    }
}
