package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIButton;
import com.qmuiteam.qmui.layout.QMUIPriorityLinearLayout;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetBaseBuilder;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetBehavior;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUIBottomSheetBaseBuilder<T extends QMUIBottomSheetBaseBuilder> {
    private boolean mAddCancelBtn;
    private String mCancelText;
    private Context mContext;
    protected QMUIBottomSheet mDialog;
    private DialogInterface.OnDismissListener mOnBottomDialogDismissListener;
    private QMUISkinManager mSkinManager;
    private CharSequence mTitle;
    private int mRadius = -1;
    private boolean mAllowDrag = false;
    private QMUIBottomSheetBehavior.DownDragDecisionMaker mDownDragDecisionMaker = null;

    protected void onAddCustomViewAfterContent(QMUIBottomSheet qMUIBottomSheet, QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, Context context) {
    }

    protected void onAddCustomViewBetweenTitleAndContent(QMUIBottomSheet qMUIBottomSheet, QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, Context context) {
    }

    protected abstract View onCreateContentView(QMUIBottomSheet qMUIBottomSheet, QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, Context context);

    public QMUIBottomSheetBaseBuilder(Context context) {
        this.mContext = context;
    }

    public T setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }

    protected boolean hasTitle() {
        CharSequence charSequence = this.mTitle;
        return (charSequence == null || charSequence.length() == 0) ? false : true;
    }

    public T setAllowDrag(boolean z) {
        this.mAllowDrag = z;
        return this;
    }

    public T setSkinManager(QMUISkinManager qMUISkinManager) {
        this.mSkinManager = qMUISkinManager;
        return this;
    }

    public T setDownDragDecisionMaker(QMUIBottomSheetBehavior.DownDragDecisionMaker downDragDecisionMaker) {
        this.mDownDragDecisionMaker = downDragDecisionMaker;
        return this;
    }

    public T setAddCancelBtn(boolean z) {
        this.mAddCancelBtn = z;
        return this;
    }

    public T setCancelText(String str) {
        this.mCancelText = str;
        return this;
    }

    public T setRadius(int i) {
        this.mRadius = i;
        return this;
    }

    public T setOnBottomDialogDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnBottomDialogDismissListener = onDismissListener;
        return this;
    }

    public QMUIBottomSheet build() {
        return build(R.style.QMUI_BottomSheet);
    }

    public QMUIBottomSheet build(int i) {
        QMUIBottomSheet qMUIBottomSheet = new QMUIBottomSheet(this.mContext, i);
        this.mDialog = qMUIBottomSheet;
        Context context = qMUIBottomSheet.getContext();
        QMUIBottomSheetRootLayout rootView = this.mDialog.getRootView();
        rootView.removeAllViews();
        View viewOnCreateTitleView = onCreateTitleView(this.mDialog, rootView, context);
        if (viewOnCreateTitleView != null) {
            this.mDialog.addContentView(viewOnCreateTitleView);
        }
        onAddCustomViewBetweenTitleAndContent(this.mDialog, rootView, context);
        View viewOnCreateContentView = onCreateContentView(this.mDialog, rootView, context);
        if (viewOnCreateContentView != null) {
            QMUIPriorityLinearLayout.LayoutParams layoutParams = new QMUIPriorityLinearLayout.LayoutParams(-1, -2);
            layoutParams.setPriority(1);
            this.mDialog.addContentView(viewOnCreateContentView, layoutParams);
        }
        onAddCustomViewAfterContent(this.mDialog, rootView, context);
        if (this.mAddCancelBtn) {
            QMUIBottomSheet qMUIBottomSheet2 = this.mDialog;
            qMUIBottomSheet2.addContentView(onCreateCancelBtn(qMUIBottomSheet2, rootView, context), new QMUIPriorityLinearLayout.LayoutParams(-1, QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_cancel_btn_height)));
        }
        DialogInterface.OnDismissListener onDismissListener = this.mOnBottomDialogDismissListener;
        if (onDismissListener != null) {
            this.mDialog.setOnDismissListener(onDismissListener);
        }
        int i2 = this.mRadius;
        if (i2 != -1) {
            this.mDialog.setRadius(i2);
        }
        this.mDialog.setSkinManager(this.mSkinManager);
        QMUIBottomSheetBehavior<QMUIBottomSheetRootLayout> behavior = this.mDialog.getBehavior();
        behavior.setAllowDrag(this.mAllowDrag);
        behavior.setDownDragDecisionMaker(this.mDownDragDecisionMaker);
        return this.mDialog;
    }

    protected View onCreateTitleView(QMUIBottomSheet qMUIBottomSheet, QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, Context context) {
        if (!hasTitle()) {
            return null;
        }
        QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new QMUISpanTouchFixTextView(context);
        qMUISpanTouchFixTextView.setId(R.id.qmui_bottom_sheet_title);
        qMUISpanTouchFixTextView.setText(this.mTitle);
        qMUISpanTouchFixTextView.onlyShowBottomDivider(0, 0, 1, QMUIResHelper.getAttrColor(context, R.attr.qmui_skin_support_bottom_sheet_separator_color));
        QMUIResHelper.assignTextViewWithAttr(qMUISpanTouchFixTextView, R.attr.qmui_bottom_sheet_title_style);
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.textColor(R.attr.qmui_skin_support_bottom_sheet_title_text_color);
        qMUISkinValueBuilderAcquire.bottomSeparator(R.attr.qmui_skin_support_bottom_sheet_separator_color);
        QMUISkinHelper.setSkinValue(qMUISpanTouchFixTextView, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
        return qMUISpanTouchFixTextView;
    }

    protected View onCreateCancelBtn(final QMUIBottomSheet qMUIBottomSheet, QMUIBottomSheetRootLayout qMUIBottomSheetRootLayout, Context context) {
        QMUIButton qMUIButton = new QMUIButton(context);
        qMUIButton.setId(R.id.qmui_bottom_sheet_cancel);
        String str = this.mCancelText;
        if (str == null || str.isEmpty()) {
            this.mCancelText = context.getString(R.string.qmui_cancel);
        }
        qMUIButton.setPadding(0, 0, 0, 0);
        qMUIButton.setBackground(QMUIResHelper.getAttrDrawable(context, R.attr.qmui_skin_support_bottom_sheet_cancel_bg));
        qMUIButton.setText(this.mCancelText);
        QMUIResHelper.assignTextViewWithAttr(qMUIButton, R.attr.qmui_bottom_sheet_cancel_style);
        qMUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetBaseBuilder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                qMUIBottomSheet.cancel();
            }
        });
        qMUIButton.onlyShowTopDivider(0, 0, 1, QMUIResHelper.getAttrColor(context, R.attr.qmui_skin_support_bottom_sheet_separator_color));
        QMUISkinValueBuilder qMUISkinValueBuilderAcquire = QMUISkinValueBuilder.acquire();
        qMUISkinValueBuilderAcquire.textColor(R.attr.qmui_skin_support_bottom_sheet_cancel_text_color);
        qMUISkinValueBuilderAcquire.topSeparator(R.attr.qmui_skin_support_bottom_sheet_separator_color);
        qMUISkinValueBuilderAcquire.background(R.attr.qmui_skin_support_bottom_sheet_cancel_bg);
        QMUISkinHelper.setSkinValue(qMUIButton, qMUISkinValueBuilderAcquire);
        qMUISkinValueBuilderAcquire.release();
        return qMUIButton;
    }
}
