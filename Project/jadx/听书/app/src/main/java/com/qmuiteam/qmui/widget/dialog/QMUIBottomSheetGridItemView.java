package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.skin.defaultAttr.QMUISkinSimpleDefaultAttrProvider;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIBottomSheetGridItemView extends QMUIConstraintLayout {
    protected AppCompatImageView mIconIv;
    protected Object mModelTag;
    protected AppCompatImageView mSubscriptIv;
    protected TextView mTitleTv;

    public QMUIBottomSheetGridItemView(Context context) {
        this(context, null);
    }

    public QMUIBottomSheetGridItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIBottomSheetGridItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setChangeAlphaWhenPress(true);
        setPadding(0, QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_grid_item_padding_top), 0, QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_grid_item_padding_bottom));
        AppCompatImageView appCompatImageViewOnCreateIconView = onCreateIconView(context);
        this.mIconIv = appCompatImageViewOnCreateIconView;
        appCompatImageViewOnCreateIconView.setId(View.generateViewId());
        this.mIconIv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int attrDimen = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_grid_item_icon_size);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(attrDimen, attrDimen);
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        addView(this.mIconIv, layoutParams);
        TextView textViewOnCreateTitleView = onCreateTitleView(context);
        this.mTitleTv = textViewOnCreateTitleView;
        textViewOnCreateTitleView.setId(View.generateViewId());
        QMUISkinSimpleDefaultAttrProvider qMUISkinSimpleDefaultAttrProvider = new QMUISkinSimpleDefaultAttrProvider();
        qMUISkinSimpleDefaultAttrProvider.setDefaultSkinAttr(QMUISkinValueBuilder.TEXT_COLOR, R.attr.qmui_skin_support_bottom_sheet_grid_item_text_color);
        QMUIResHelper.assignTextViewWithAttr(this.mTitleTv, R.attr.qmui_bottom_sheet_grid_item_text_style);
        QMUISkinHelper.setSkinDefaultProvider(this.mTitleTv, qMUISkinSimpleDefaultAttrProvider);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams2.leftToLeft = 0;
        layoutParams2.rightToRight = 0;
        layoutParams2.topToBottom = this.mIconIv.getId();
        layoutParams2.topMargin = QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_grid_item_text_margin_top);
        addView(this.mTitleTv, layoutParams2);
    }

    protected AppCompatImageView onCreateIconView(Context context) {
        return new AppCompatImageView(context);
    }

    protected TextView onCreateTitleView(Context context) {
        return new QMUISpanTouchFixTextView(context);
    }

    public void render(QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel) {
        this.mModelTag = qMUIBottomSheetGridItemModel.tag;
        setTag(qMUIBottomSheetGridItemModel.tag);
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        renderIcon(qMUIBottomSheetGridItemModel, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        renderTitle(qMUIBottomSheetGridItemModel, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        renderSubScript(qMUIBottomSheetGridItemModel, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
    }

    public Object getModelTag() {
        return this.mModelTag;
    }

    protected void renderIcon(QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel, QMUISkinValueBuilder qMUISkinValueBuilder) {
        if (qMUIBottomSheetGridItemModel.imageSkinSrcAttr != 0) {
            qMUISkinValueBuilder.src(qMUIBottomSheetGridItemModel.imageSkinSrcAttr);
            QMUISkinHelper.setSkinValue(this.mIconIv, qMUISkinValueBuilder);
            this.mIconIv.setImageDrawable(QMUISkinHelper.getSkinDrawable(this.mIconIv, qMUIBottomSheetGridItemModel.imageSkinSrcAttr));
            return;
        }
        Drawable drawable = qMUIBottomSheetGridItemModel.image;
        if (drawable == null && qMUIBottomSheetGridItemModel.imageRes != 0) {
            drawable = ContextCompat.getDrawable(getContext(), qMUIBottomSheetGridItemModel.imageRes);
        }
        if (drawable != null) {
            drawable.mutate();
        }
        this.mIconIv.setImageDrawable(drawable);
        if (qMUIBottomSheetGridItemModel.imageSkinTintColorAttr != 0) {
            qMUISkinValueBuilder.tintColor(qMUIBottomSheetGridItemModel.imageSkinTintColorAttr);
            QMUISkinHelper.setSkinValue(this.mIconIv, qMUISkinValueBuilder);
        } else {
            QMUISkinHelper.setSkinValue(this.mIconIv, "");
        }
    }

    protected void renderTitle(QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel, QMUISkinValueBuilder qMUISkinValueBuilder) {
        this.mTitleTv.setText(qMUIBottomSheetGridItemModel.text);
        if (qMUIBottomSheetGridItemModel.textSkinColorAttr != 0) {
            qMUISkinValueBuilder.textColor(qMUIBottomSheetGridItemModel.textSkinColorAttr);
        }
        QMUISkinHelper.setSkinValue(this.mTitleTv, qMUISkinValueBuilder);
        if (qMUIBottomSheetGridItemModel.typeface != null) {
            this.mTitleTv.setTypeface(qMUIBottomSheetGridItemModel.typeface);
        }
    }

    protected void renderSubScript(QMUIBottomSheetGridItemModel qMUIBottomSheetGridItemModel, QMUISkinValueBuilder qMUISkinValueBuilder) {
        if (qMUIBottomSheetGridItemModel.subscriptRes != 0 || qMUIBottomSheetGridItemModel.subscript != null || qMUIBottomSheetGridItemModel.subscriptSkinSrcAttr != 0) {
            if (this.mSubscriptIv == null) {
                AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                this.mSubscriptIv = appCompatImageView;
                appCompatImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
                layoutParams.rightToRight = this.mIconIv.getId();
                layoutParams.topToTop = this.mIconIv.getId();
                addView(this.mSubscriptIv, layoutParams);
            }
            this.mSubscriptIv.setVisibility(0);
            if (qMUIBottomSheetGridItemModel.subscriptSkinSrcAttr != 0) {
                qMUISkinValueBuilder.src(qMUIBottomSheetGridItemModel.subscriptSkinSrcAttr);
                QMUISkinHelper.setSkinValue(this.mSubscriptIv, qMUISkinValueBuilder);
                this.mIconIv.setImageDrawable(QMUISkinHelper.getSkinDrawable(this.mSubscriptIv, qMUIBottomSheetGridItemModel.subscriptSkinSrcAttr));
                return;
            }
            Drawable drawable = qMUIBottomSheetGridItemModel.subscript;
            if (drawable == null && qMUIBottomSheetGridItemModel.subscriptRes != 0) {
                drawable = ContextCompat.getDrawable(getContext(), qMUIBottomSheetGridItemModel.subscriptRes);
            }
            if (drawable != null) {
                drawable.mutate();
            }
            this.mSubscriptIv.setImageDrawable(drawable);
            if (qMUIBottomSheetGridItemModel.subscriptSkinTintColorAttr != 0) {
                qMUISkinValueBuilder.tintColor(qMUIBottomSheetGridItemModel.subscriptSkinTintColorAttr);
                QMUISkinHelper.setSkinValue(this.mSubscriptIv, qMUISkinValueBuilder);
                return;
            } else {
                QMUISkinHelper.setSkinValue(this.mSubscriptIv, "");
                return;
            }
        }
        AppCompatImageView appCompatImageView2 = this.mSubscriptIv;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(8);
        }
    }
}
