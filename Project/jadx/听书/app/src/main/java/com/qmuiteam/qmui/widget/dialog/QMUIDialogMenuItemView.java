package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIDialogMenuItemView extends QMUIConstraintLayout {
    private int index;
    private boolean mIsChecked;
    private MenuItemViewListener mListener;

    public interface MenuItemViewListener {
        void onClick(int i);
    }

    protected void notifyCheckChange(boolean z) {
    }

    public QMUIDialogMenuItemView(Context context) {
        super(context, null, R.attr.qmui_dialog_menu_item_style);
        this.index = -1;
        this.mIsChecked = false;
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.background(R.attr.qmui_skin_support_s_dialog_menu_item_bg);
        QMUISkinHelper.setSkinValue(this, qMUISkinValueBuilderAcquire);
        QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
    }

    public static TextView createItemTextView(Context context) {
        QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new QMUISpanTouchFixTextView(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMenuTextStyleDef, R.attr.qmui_dialog_menu_item_style, 0);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R.styleable.QMUIDialogMenuTextStyleDef_android_gravity) {
                qMUISpanTouchFixTextView.setGravity(typedArrayObtainStyledAttributes.getInt(index, -1));
            } else if (index == R.styleable.QMUIDialogMenuTextStyleDef_android_textColor) {
                qMUISpanTouchFixTextView.setTextColor(typedArrayObtainStyledAttributes.getColorStateList(index));
            } else if (index == R.styleable.QMUIDialogMenuTextStyleDef_android_textSize) {
                qMUISpanTouchFixTextView.setTextSize(0, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        qMUISpanTouchFixTextView.setId(View.generateViewId());
        qMUISpanTouchFixTextView.setSingleLine(true);
        qMUISpanTouchFixTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        qMUISpanTouchFixTextView.setDuplicateParentStateEnabled(false);
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.textColor(R.attr.qmui_skin_support_dialog_menu_item_text_color);
        QMUISkinHelper.setSkinValue(qMUISpanTouchFixTextView, qMUISkinValueBuilderAcquire);
        QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
        return qMUISpanTouchFixTextView;
    }

    public int getMenuIndex() {
        return this.index;
    }

    public void setMenuIndex(int i) {
        this.index = i;
    }

    public boolean isChecked() {
        return this.mIsChecked;
    }

    public void setChecked(boolean z) {
        this.mIsChecked = z;
        notifyCheckChange(z);
    }

    public void setListener(MenuItemViewListener menuItemViewListener) {
        if (!isClickable()) {
            setClickable(true);
        }
        this.mListener = menuItemViewListener;
    }

    @Override // android.view.View
    public boolean performClick() {
        MenuItemViewListener menuItemViewListener = this.mListener;
        if (menuItemViewListener != null) {
            menuItemViewListener.onClick(this.index);
        }
        return super.performClick();
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class TextItemView extends QMUIDialogMenuItemView {
        protected TextView mTextView;

        public TextItemView(Context context) {
            super(context);
            init();
        }

        public TextItemView(Context context, CharSequence charSequence) {
            super(context);
            init();
            setText(charSequence);
        }

        private void init() {
            this.mTextView = createItemTextView(getContext());
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
            layoutParams.leftToLeft = 0;
            layoutParams.rightToRight = 0;
            layoutParams.bottomToBottom = 0;
            layoutParams.topToTop = 0;
            addView(this.mTextView, layoutParams);
        }

        public void setText(CharSequence charSequence) {
            this.mTextView.setText(charSequence);
        }

        @Deprecated
        public void setTextColor(int i) {
            this.mTextView.setTextColor(i);
        }

        public void setTextColorAttr(int i) {
            this.mTextView.setTextColor(QMUISkinHelper.getSkinColor(this, i));
            QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.textColor(i);
            QMUISkinHelper.setSkinValue(this.mTextView, qMUISkinValueBuilderAcquire);
            QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class MarkItemView extends QMUIDialogMenuItemView {
        private AppCompatImageView mCheckedView;
        private Context mContext;
        private TextView mTextView;

        public MarkItemView(Context context) {
            super(context);
            this.mContext = context;
            AppCompatImageView appCompatImageView = new AppCompatImageView(this.mContext);
            this.mCheckedView = appCompatImageView;
            appCompatImageView.setId(View.generateViewId());
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMenuMarkDef, R.attr.qmui_dialog_menu_item_style, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int dimensionPixelSize = 0;
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.QMUIDialogMenuMarkDef_qmui_dialog_menu_item_check_mark_margin_hor) {
                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.QMUIDialogMenuMarkDef_qmui_dialog_menu_item_mark_drawable) {
                    this.mCheckedView.setImageDrawable(QMUIResHelper.getAttrDrawable(context, typedArrayObtainStyledAttributes, index));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.src(R.attr.qmui_skin_support_dialog_mark_drawable);
            QMUISkinHelper.setSkinValue(this.mCheckedView, qMUISkinValueBuilderAcquire);
            QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.rightToRight = 0;
            layoutParams.topToTop = 0;
            layoutParams.bottomToBottom = 0;
            addView(this.mCheckedView, layoutParams);
            this.mTextView = createItemTextView(this.mContext);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(0, 0);
            layoutParams2.leftToLeft = 0;
            layoutParams2.topToTop = 0;
            layoutParams2.bottomToBottom = 0;
            layoutParams2.rightToLeft = this.mCheckedView.getId();
            layoutParams2.rightMargin = dimensionPixelSize;
            addView(this.mTextView, layoutParams2);
            this.mCheckedView.setVisibility(4);
        }

        public MarkItemView(Context context, CharSequence charSequence) {
            this(context);
            setText(charSequence);
        }

        public void setText(CharSequence charSequence) {
            this.mTextView.setText(charSequence);
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
        protected void notifyCheckChange(boolean z) {
            this.mCheckedView.setVisibility(z ? 0 : 4);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class CheckItemView extends QMUIDialogMenuItemView {
        private AppCompatImageView mCheckedView;
        private Context mContext;
        private TextView mTextView;

        public CheckItemView(Context context, boolean z) {
            super(context);
            this.mContext = context;
            AppCompatImageView appCompatImageView = new AppCompatImageView(this.mContext);
            this.mCheckedView = appCompatImageView;
            appCompatImageView.setId(View.generateViewId());
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMenuCheckDef, R.attr.qmui_dialog_menu_item_style, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            int dimensionPixelSize = 0;
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.QMUIDialogMenuCheckDef_qmui_dialog_menu_item_check_mark_margin_hor) {
                    dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.QMUIDialogMenuCheckDef_qmui_dialog_menu_item_check_drawable) {
                    this.mCheckedView.setImageDrawable(QMUIResHelper.getAttrDrawable(context, typedArrayObtainStyledAttributes, index));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.topToTop = 0;
            layoutParams.bottomToBottom = 0;
            if (z) {
                layoutParams.rightToRight = 0;
            } else {
                layoutParams.leftToLeft = 0;
            }
            QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
            qMUISkinValueBuilderAcquire.src(R.attr.qmui_skin_support_s_dialog_check_drawable);
            QMUISkinHelper.setSkinValue(this.mCheckedView, qMUISkinValueBuilderAcquire);
            QMUISkinValueBuilder.release(qMUISkinValueBuilderAcquire);
            addView(this.mCheckedView, layoutParams);
            this.mTextView = createItemTextView(this.mContext);
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(0, 0);
            if (z) {
                layoutParams2.leftToLeft = 0;
                layoutParams2.rightToLeft = this.mCheckedView.getId();
                layoutParams2.rightMargin = dimensionPixelSize;
            } else {
                layoutParams2.rightToRight = 0;
                layoutParams2.leftToRight = this.mCheckedView.getId();
                layoutParams2.leftMargin = dimensionPixelSize;
            }
            layoutParams2.topToTop = 0;
            layoutParams2.bottomToBottom = 0;
            addView(this.mTextView, layoutParams2);
        }

        public CheckItemView(Context context, boolean z, CharSequence charSequence) {
            this(context, z);
            setText(charSequence);
        }

        public void setText(CharSequence charSequence) {
            this.mTextView.setText(charSequence);
        }

        public CharSequence getText() {
            return this.mTextView.getText();
        }

        @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogMenuItemView
        protected void notifyCheckChange(boolean z) {
            QMUIViewHelper.safeSetImageViewSelected(this.mCheckedView, z);
        }
    }
}
