package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.QMUILoadingView;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes5.dex */
public class QMUITipDialog extends QMUIBaseDialog {
    public QMUITipDialog(Context context) {
        this(context, R.style.QMUI_TipDialog);
    }

    public QMUITipDialog(Context context, int i) {
        super(context, i);
        setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class Builder {
        public static final int ICON_TYPE_FAIL = 3;
        public static final int ICON_TYPE_INFO = 4;
        public static final int ICON_TYPE_LOADING = 1;
        public static final int ICON_TYPE_NOTHING = 0;
        public static final int ICON_TYPE_SUCCESS = 2;
        private Context mContext;
        private int mCurrentIconType = 0;
        private QMUISkinManager mSkinManager;
        private CharSequence mTipWord;

        @Retention(RetentionPolicy.SOURCE)
        public @interface IconType {
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setIconType(int i) {
            this.mCurrentIconType = i;
            return this;
        }

        public Builder setTipWord(CharSequence charSequence) {
            this.mTipWord = charSequence;
            return this;
        }

        public Builder setSkinManager(QMUISkinManager qMUISkinManager) {
            this.mSkinManager = qMUISkinManager;
            return this;
        }

        public QMUITipDialog create() {
            return create(true);
        }

        public QMUITipDialog create(boolean z) {
            return create(z, R.style.QMUI_TipDialog);
        }

        public QMUITipDialog create(boolean z, int i) {
            Drawable attrDrawable;
            QMUITipDialog qMUITipDialog = new QMUITipDialog(this.mContext, i);
            qMUITipDialog.setCancelable(z);
            qMUITipDialog.setSkinManager(this.mSkinManager);
            Context context = qMUITipDialog.getContext();
            QMUITipDialogView qMUITipDialogView = new QMUITipDialogView(context);
            QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
            int i2 = this.mCurrentIconType;
            if (i2 == 1) {
                QMUILoadingView qMUILoadingView = new QMUILoadingView(context);
                qMUILoadingView.setColor(QMUIResHelper.getAttrColor(context, R.attr.qmui_skin_support_tip_dialog_loading_color));
                qMUILoadingView.setSize(QMUIResHelper.getAttrDimen(context, R.attr.qmui_tip_dialog_loading_size));
                qMUISkinValueBuilderAcquire.tintColor(R.attr.qmui_skin_support_tip_dialog_loading_color);
                QMUISkinHelper.setSkinValue(qMUILoadingView, qMUISkinValueBuilderAcquire);
                qMUITipDialogView.addView(qMUILoadingView, onCreateIconOrLoadingLayoutParams(context));
            } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                AppCompatImageView appCompatImageView = new AppCompatImageView(context);
                qMUISkinValueBuilderAcquire.clear();
                int i3 = this.mCurrentIconType;
                if (i3 == 2) {
                    attrDrawable = QMUIResHelper.getAttrDrawable(context, R.attr.qmui_skin_support_tip_dialog_icon_success_src);
                    qMUISkinValueBuilderAcquire.src(R.attr.qmui_skin_support_tip_dialog_icon_success_src);
                } else if (i3 == 3) {
                    attrDrawable = QMUIResHelper.getAttrDrawable(context, R.attr.qmui_skin_support_tip_dialog_icon_error_src);
                    qMUISkinValueBuilderAcquire.src(R.attr.qmui_skin_support_tip_dialog_icon_error_src);
                } else {
                    attrDrawable = QMUIResHelper.getAttrDrawable(context, R.attr.qmui_skin_support_tip_dialog_icon_info_src);
                    qMUISkinValueBuilderAcquire.src(R.attr.qmui_skin_support_tip_dialog_icon_info_src);
                }
                appCompatImageView.setImageDrawable(attrDrawable);
                QMUISkinHelper.setSkinValue(appCompatImageView, qMUISkinValueBuilderAcquire);
                qMUITipDialogView.addView(appCompatImageView, onCreateIconOrLoadingLayoutParams(context));
            }
            CharSequence charSequence = this.mTipWord;
            if (charSequence != null && charSequence.length() > 0) {
                QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new QMUISpanTouchFixTextView(context);
                qMUISpanTouchFixTextView.setEllipsize(TextUtils.TruncateAt.END);
                qMUISpanTouchFixTextView.setId(R.id.qmui_tip_content_id);
                qMUISpanTouchFixTextView.setGravity(17);
                qMUISpanTouchFixTextView.setTextSize(0, QMUIResHelper.getAttrDimen(context, R.attr.qmui_tip_dialog_text_size));
                qMUISpanTouchFixTextView.setTextColor(QMUIResHelper.getAttrColor(context, R.attr.qmui_skin_support_tip_dialog_text_color));
                qMUISpanTouchFixTextView.setText(this.mTipWord);
                qMUISkinValueBuilderAcquire.clear();
                qMUISkinValueBuilderAcquire.textColor(R.attr.qmui_skin_support_tip_dialog_text_color);
                QMUISkinHelper.setSkinValue(qMUISpanTouchFixTextView, qMUISkinValueBuilderAcquire);
                qMUITipDialogView.addView(qMUISpanTouchFixTextView, onCreateTextLayoutParams(context, this.mCurrentIconType));
            }
            qMUISkinValueBuilderAcquire.release();
            qMUITipDialog.setContentView(qMUITipDialogView);
            return qMUITipDialog;
        }

        protected LinearLayout.LayoutParams onCreateIconOrLoadingLayoutParams(Context context) {
            return new LinearLayout.LayoutParams(-2, -2);
        }

        protected LinearLayout.LayoutParams onCreateTextLayoutParams(Context context, int i) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i != 0) {
                layoutParams.topMargin = QMUIResHelper.getAttrDimen(context, R.attr.qmui_tip_dialog_text_margin_top);
            }
            return layoutParams;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static class CustomBuilder {
        private int mContentLayoutId;
        private Context mContext;
        private QMUISkinManager mSkinManager;

        public CustomBuilder(Context context) {
            this.mContext = context;
        }

        public CustomBuilder setSkinManager(QMUISkinManager qMUISkinManager) {
            this.mSkinManager = qMUISkinManager;
            return this;
        }

        public CustomBuilder setContent(int i) {
            this.mContentLayoutId = i;
            return this;
        }

        public QMUITipDialog create() {
            QMUITipDialog qMUITipDialog = new QMUITipDialog(this.mContext);
            qMUITipDialog.setSkinManager(this.mSkinManager);
            Context context = qMUITipDialog.getContext();
            QMUITipDialogView qMUITipDialogView = new QMUITipDialogView(context);
            LayoutInflater.from(context).inflate(this.mContentLayoutId, (ViewGroup) qMUITipDialogView, true);
            qMUITipDialog.setContentView(qMUITipDialogView);
            return qMUITipDialog;
        }
    }
}
