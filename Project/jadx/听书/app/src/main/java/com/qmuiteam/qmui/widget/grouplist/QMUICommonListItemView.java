package com.qmuiteam.qmui.widget.grouplist;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class QMUICommonListItemView extends QMUIConstraintLayout {
    public static final int ACCESSORY_TYPE_CHEVRON = 1;
    public static final int ACCESSORY_TYPE_CUSTOM = 3;
    public static final int ACCESSORY_TYPE_NONE = 0;
    public static final int ACCESSORY_TYPE_SWITCH = 2;
    public static final int HORIZONTAL = 1;
    public static final int TIP_POSITION_LEFT = 0;
    public static final int TIP_POSITION_RIGHT = 1;
    private static final int TIP_SHOW_NEW = 2;
    private static final int TIP_SHOW_NOTHING = 0;
    private static final int TIP_SHOW_RED_POINT = 1;
    public static final int VERTICAL = 0;
    private int mAccessoryType;
    private ViewGroup mAccessoryView;
    protected TextView mDetailTextView;
    private boolean mDisableSwitchSelf;
    protected ImageView mImageView;
    private ImageView mNewTipView;
    private int mOrientation;
    private ImageView mRedDot;
    protected CheckBox mSwitch;
    protected TextView mTextView;
    private int mTipPosition;
    private int mTipShown;

    public interface LayoutParamConfig {
        ConstraintLayout.LayoutParams onConfig(ConstraintLayout.LayoutParams layoutParams);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface QMUICommonListItemAccessoryType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface QMUICommonListItemOrientation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface QMUICommonListItemTipPosition {
    }

    public static class SkinConfig {
        public int iconTintColorRes = R.attr.qmui_skin_support_common_list_icon_tint_color;
        public int iconSrcRes = 0;
        public int titleTextColorRes = R.attr.qmui_skin_support_common_list_title_color;
        public int detailTextColorRes = R.attr.qmui_skin_support_common_list_detail_color;
        public int newTipSrcRes = R.attr.qmui_skin_support_common_list_new_drawable;
        public int tipDotColorRes = R.attr.qmui_skin_support_common_list_red_point_tint_color;
    }

    public QMUICommonListItemView(Context context) {
        this(context, null);
    }

    public QMUICommonListItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUICommonListItemViewStyle);
    }

    public QMUICommonListItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOrientation = 1;
        this.mTipPosition = 0;
        this.mDisableSwitchSelf = false;
        this.mTipShown = 0;
        init(context, attributeSet, i);
    }

    protected void init(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater.from(context).inflate(R.layout.qmui_common_list_item, (ViewGroup) this, true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUICommonListItemView, i, 0);
        int i2 = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUICommonListItemView_qmui_orientation, 1);
        int i3 = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUICommonListItemView_qmui_accessory_type, 0);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUICommonListItemView_qmui_common_list_title_color, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.QMUICommonListItemView_qmui_common_list_detail_color, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.mImageView = (ImageView) findViewById(R.id.group_list_item_imageView);
        this.mTextView = (TextView) findViewById(R.id.group_list_item_textView);
        this.mRedDot = (ImageView) findViewById(R.id.group_list_item_tips_dot);
        this.mNewTipView = (ImageView) findViewById(R.id.group_list_item_tips_new);
        this.mDetailTextView = (TextView) findViewById(R.id.group_list_item_detailTextView);
        this.mTextView.setTextColor(color);
        this.mDetailTextView.setTextColor(color2);
        this.mAccessoryView = (ViewGroup) findViewById(R.id.group_list_item_accessoryView);
        setOrientation(i2);
        setAccessoryType(i3);
    }

    public void updateImageViewLp(LayoutParamConfig layoutParamConfig) {
        if (layoutParamConfig != null) {
            this.mImageView.setLayoutParams(layoutParamConfig.onConfig((ConstraintLayout.LayoutParams) this.mImageView.getLayoutParams()));
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable == null) {
            this.mImageView.setVisibility(8);
        } else {
            this.mImageView.setImageDrawable(drawable);
            this.mImageView.setVisibility(0);
        }
    }

    public void setTipPosition(int i) {
        if (this.mTipPosition != i) {
            this.mTipPosition = i;
            updateLayoutParams();
        }
    }

    public CharSequence getText() {
        return this.mTextView.getText();
    }

    public void setText(CharSequence charSequence) {
        this.mTextView.setText(charSequence);
        if (QMUILangHelper.isNullOrEmpty(charSequence)) {
            this.mTextView.setVisibility(8);
        } else {
            this.mTextView.setVisibility(0);
        }
    }

    public void showRedDot(boolean z) {
        int i = this.mTipShown;
        if (z) {
            this.mTipShown = 1;
        } else if (i == 1) {
            this.mTipShown = 0;
        }
        if (i != this.mTipShown) {
            updateLayoutParams();
        }
    }

    public void showNewTip(boolean z) {
        int i = this.mTipShown;
        if (z) {
            this.mTipShown = 2;
        } else if (i == 2) {
            this.mTipShown = 0;
        }
        if (i != this.mTipShown) {
            updateLayoutParams();
        }
    }

    public CharSequence getDetailText() {
        return this.mDetailTextView.getText();
    }

    public void setDetailText(CharSequence charSequence) {
        this.mDetailTextView.setText(charSequence);
        if (QMUILangHelper.isNullOrEmpty(charSequence)) {
            this.mDetailTextView.setVisibility(8);
        } else {
            this.mDetailTextView.setVisibility(0);
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (this.mOrientation == i) {
            return;
        }
        this.mOrientation = i;
        updateLayoutParams();
    }

    private void updateLayoutParams() {
        this.mNewTipView.setVisibility(this.mTipShown == 2 ? 0 : 8);
        this.mRedDot.setVisibility(this.mTipShown == 1 ? 0 : 8);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mTextView.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.mDetailTextView.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.mNewTipView.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.mRedDot.getLayoutParams();
        if (this.mOrientation == 0) {
            this.mTextView.setTextSize(0, QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_title_v_text_size));
            this.mDetailTextView.setTextSize(0, QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_detail_v_text_size));
            layoutParams.verticalChainStyle = 2;
            layoutParams.bottomToBottom = -1;
            layoutParams.bottomToTop = this.mDetailTextView.getId();
            layoutParams2.horizontalChainStyle = -1;
            layoutParams2.verticalChainStyle = 2;
            layoutParams2.leftToLeft = this.mTextView.getId();
            layoutParams2.leftToRight = -1;
            layoutParams2.horizontalBias = 0.0f;
            layoutParams2.topToTop = -1;
            layoutParams2.topToBottom = this.mTextView.getId();
            layoutParams2.leftMargin = 0;
            layoutParams2.topMargin = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_detail_v_margin_with_title);
            int i = this.mTipShown;
            if (i == 2) {
                if (this.mTipPosition == 0) {
                    updateTipLeftVerRelatedLayoutParam(this.mNewTipView, layoutParams3, layoutParams, layoutParams2);
                    return;
                } else {
                    updateTipRightVerRelatedLayoutParam(this.mNewTipView, layoutParams3, layoutParams, layoutParams2);
                    return;
                }
            }
            if (i == 1) {
                if (this.mTipPosition == 0) {
                    updateTipLeftVerRelatedLayoutParam(this.mRedDot, layoutParams4, layoutParams, layoutParams2);
                    return;
                } else {
                    updateTipRightVerRelatedLayoutParam(this.mRedDot, layoutParams4, layoutParams, layoutParams2);
                    return;
                }
            }
            int attrDimen = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
            layoutParams.horizontalChainStyle = -1;
            layoutParams.rightToLeft = this.mAccessoryView.getId();
            layoutParams.rightMargin = attrDimen;
            layoutParams.goneRightMargin = 0;
            layoutParams2.leftToRight = this.mAccessoryView.getId();
            layoutParams2.rightMargin = attrDimen;
            layoutParams2.goneRightMargin = 0;
            return;
        }
        this.mTextView.setTextSize(0, QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_title_h_text_size));
        this.mDetailTextView.setTextSize(0, QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_detail_h_text_size));
        layoutParams.verticalChainStyle = -1;
        layoutParams.bottomToBottom = 0;
        layoutParams.bottomToTop = -1;
        layoutParams2.verticalChainStyle = -1;
        layoutParams2.leftToLeft = -1;
        layoutParams2.topToTop = 0;
        layoutParams2.topToBottom = -1;
        layoutParams2.topMargin = 0;
        layoutParams2.leftMargin = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_detail_h_margin_with_title);
        int i2 = this.mTipShown;
        if (i2 == 2) {
            if (this.mTipPosition == 0) {
                updateTipLeftHorRelatedLayoutParam(this.mNewTipView, layoutParams3, layoutParams, layoutParams2);
                return;
            } else {
                updateTipRightHorRelatedLayoutParam(this.mNewTipView, layoutParams3, layoutParams, layoutParams2);
                return;
            }
        }
        if (i2 == 1) {
            if (this.mTipPosition == 0) {
                updateTipLeftHorRelatedLayoutParam(this.mRedDot, layoutParams4, layoutParams, layoutParams2);
                return;
            } else {
                updateTipRightHorRelatedLayoutParam(this.mRedDot, layoutParams4, layoutParams, layoutParams2);
                return;
            }
        }
        int attrDimen2 = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
        layoutParams.horizontalChainStyle = -1;
        layoutParams.rightToLeft = this.mAccessoryView.getId();
        layoutParams.rightMargin = attrDimen2;
        layoutParams.goneRightMargin = 0;
        layoutParams2.leftToRight = this.mTextView.getId();
        layoutParams2.rightToLeft = this.mAccessoryView.getId();
        layoutParams2.rightMargin = attrDimen2;
        layoutParams2.goneRightMargin = 0;
    }

    private void updateTipLeftVerRelatedLayoutParam(View view, ConstraintLayout.LayoutParams layoutParams, ConstraintLayout.LayoutParams layoutParams2, ConstraintLayout.LayoutParams layoutParams3) {
        int attrDimen = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_holder_margin_with_title);
        int attrDimen2 = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
        layoutParams2.horizontalChainStyle = 2;
        layoutParams2.horizontalBias = 0.0f;
        layoutParams2.rightToLeft = view.getId();
        layoutParams2.rightMargin = attrDimen;
        layoutParams.leftToRight = this.mTextView.getId();
        layoutParams.rightToLeft = this.mAccessoryView.getId();
        layoutParams.rightMargin = attrDimen2;
        layoutParams.topToTop = this.mTextView.getId();
        layoutParams.bottomToBottom = this.mTextView.getId();
        layoutParams.goneRightMargin = 0;
        layoutParams3.rightToLeft = this.mAccessoryView.getId();
        layoutParams3.rightMargin = attrDimen2;
        layoutParams3.goneRightMargin = 0;
    }

    private void updateTipRightVerRelatedLayoutParam(View view, ConstraintLayout.LayoutParams layoutParams, ConstraintLayout.LayoutParams layoutParams2, ConstraintLayout.LayoutParams layoutParams3) {
        int attrDimen = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
        layoutParams.leftToRight = -1;
        layoutParams.rightToLeft = this.mAccessoryView.getId();
        layoutParams.rightMargin = attrDimen;
        layoutParams.goneRightMargin = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams2.horizontalChainStyle = -1;
        layoutParams2.rightToLeft = view.getId();
        layoutParams2.rightMargin = attrDimen;
        layoutParams3.rightToLeft = view.getId();
        layoutParams3.rightMargin = attrDimen;
    }

    private void updateTipLeftHorRelatedLayoutParam(View view, ConstraintLayout.LayoutParams layoutParams, ConstraintLayout.LayoutParams layoutParams2, ConstraintLayout.LayoutParams layoutParams3) {
        int attrDimen = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_holder_margin_with_title);
        int attrDimen2 = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
        layoutParams2.horizontalChainStyle = 2;
        layoutParams2.horizontalBias = 0.0f;
        layoutParams2.rightToLeft = view.getId();
        layoutParams2.rightMargin = attrDimen;
        layoutParams.leftToRight = this.mTextView.getId();
        layoutParams.rightToLeft = this.mAccessoryView.getId();
        layoutParams.rightMargin = attrDimen2;
        layoutParams.topToTop = this.mTextView.getId();
        layoutParams.bottomToBottom = this.mTextView.getId();
        layoutParams.goneRightMargin = 0;
        layoutParams3.leftToRight = view.getId();
        layoutParams3.rightToLeft = this.mAccessoryView.getId();
        layoutParams3.rightMargin = attrDimen2;
        layoutParams3.goneRightMargin = 0;
    }

    private void updateTipRightHorRelatedLayoutParam(View view, ConstraintLayout.LayoutParams layoutParams, ConstraintLayout.LayoutParams layoutParams2, ConstraintLayout.LayoutParams layoutParams3) {
        int attrDimen = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_common_list_item_accessory_margin_left);
        layoutParams.leftToRight = -1;
        layoutParams.rightToLeft = this.mAccessoryView.getId();
        layoutParams.rightMargin = attrDimen;
        layoutParams.goneRightMargin = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams2.horizontalChainStyle = -1;
        layoutParams2.rightToLeft = view.getId();
        layoutParams2.rightMargin = attrDimen;
        layoutParams2.horizontalBias = 0.0f;
        layoutParams3.leftToRight = this.mTextView.getId();
        layoutParams3.rightToLeft = view.getId();
        layoutParams3.rightMargin = attrDimen;
    }

    public int getAccessoryType() {
        return this.mAccessoryType;
    }

    public void setAccessoryType(int i) {
        this.mAccessoryView.removeAllViews();
        this.mAccessoryType = i;
        if (i == 0) {
            this.mAccessoryView.setVisibility(8);
        } else if (i == 1) {
            ImageView accessoryImageView = getAccessoryImageView();
            accessoryImageView.setImageDrawable(QMUIResHelper.getAttrDrawable(getContext(), R.attr.qmui_common_list_item_chevron));
            this.mAccessoryView.addView(accessoryImageView);
            this.mAccessoryView.setVisibility(0);
        } else if (i == 2) {
            if (this.mSwitch == null) {
                AppCompatCheckBox appCompatCheckBox = new AppCompatCheckBox(getContext());
                this.mSwitch = appCompatCheckBox;
                appCompatCheckBox.setBackground(null);
                this.mSwitch.setButtonDrawable(QMUIResHelper.getAttrDrawable(getContext(), R.attr.qmui_common_list_item_switch));
                this.mSwitch.setLayoutParams(getAccessoryLayoutParams());
                if (this.mDisableSwitchSelf) {
                    this.mSwitch.setClickable(false);
                    this.mSwitch.setEnabled(false);
                }
            }
            this.mAccessoryView.addView(this.mSwitch);
            this.mAccessoryView.setVisibility(0);
        } else if (i == 3) {
            this.mAccessoryView.setVisibility(0);
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.mTextView.getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.mDetailTextView.getLayoutParams();
        if (this.mAccessoryView.getVisibility() != 8) {
            layoutParams2.goneRightMargin = layoutParams2.rightMargin;
            layoutParams.goneRightMargin = layoutParams.rightMargin;
        } else {
            layoutParams2.goneRightMargin = 0;
            layoutParams.goneRightMargin = 0;
        }
    }

    private ViewGroup.LayoutParams getAccessoryLayoutParams() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    private ImageView getAccessoryImageView() {
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        appCompatImageView.setLayoutParams(getAccessoryLayoutParams());
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER);
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.tintColor(R.attr.qmui_skin_support_common_list_chevron_color);
        QMUISkinHelper.setSkinValue(appCompatImageView, qMUISkinValueBuilderAcquire);
        QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
        return appCompatImageView;
    }

    public TextView getTextView() {
        return this.mTextView;
    }

    public TextView getDetailTextView() {
        return this.mDetailTextView;
    }

    public CheckBox getSwitch() {
        return this.mSwitch;
    }

    public ViewGroup getAccessoryContainerView() {
        return this.mAccessoryView;
    }

    public void addAccessoryCustomView(View view) {
        if (this.mAccessoryType == 3) {
            this.mAccessoryView.addView(view);
        }
    }

    public void setDisableSwitchSelf(boolean z) {
        this.mDisableSwitchSelf = z;
        CheckBox checkBox = this.mSwitch;
        if (checkBox != null) {
            checkBox.setClickable(!z);
            this.mSwitch.setEnabled(!z);
        }
    }

    public void setSkinConfig(SkinConfig skinConfig) {
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        if (skinConfig.iconTintColorRes != 0) {
            qMUISkinValueBuilderAcquire.tintColor(skinConfig.iconTintColorRes);
        }
        if (skinConfig.iconSrcRes != 0) {
            qMUISkinValueBuilderAcquire.src(skinConfig.iconSrcRes);
        }
        QMUISkinHelper.setSkinValue(this.mImageView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        if (skinConfig.titleTextColorRes != 0) {
            qMUISkinValueBuilderAcquire.textColor(skinConfig.titleTextColorRes);
        }
        QMUISkinHelper.setSkinValue(this.mTextView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        if (skinConfig.detailTextColorRes != 0) {
            qMUISkinValueBuilderAcquire.textColor(skinConfig.detailTextColorRes);
        }
        QMUISkinHelper.setSkinValue(this.mDetailTextView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        if (skinConfig.newTipSrcRes != 0) {
            qMUISkinValueBuilderAcquire.src(skinConfig.newTipSrcRes);
        }
        QMUISkinHelper.setSkinValue(this.mNewTipView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.clear();
        if (skinConfig.tipDotColorRes != 0) {
            qMUISkinValueBuilderAcquire.bgTintColor(skinConfig.tipDotColorRes);
        }
        QMUISkinHelper.setSkinValue(this.mRedDot, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
    }
}
