package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIDialogBlockBuilder extends QMUIDialogBuilder<QMUIDialogBlockBuilder> {
    private CharSequence mContent;

    public QMUIDialogBlockBuilder(Context context) {
        super(context);
        setActionDivider(1, R.attr.qmui_skin_support_dialog_action_divider_color, 0, 0);
    }

    public QMUIDialogBlockBuilder setContent(CharSequence charSequence) {
        this.mContent = charSequence;
        return this;
    }

    public QMUIDialogBlockBuilder setContent(int i) {
        this.mContent = getBaseContext().getResources().getString(i);
        return this;
    }

    @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
    protected View onCreateTitle(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
        CharSequence charSequence;
        View viewOnCreateTitle = super.onCreateTitle(qMUIDialog, qMUIDialogView, context);
        if (viewOnCreateTitle != null && ((charSequence = this.mContent) == null || charSequence.length() == 0)) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.QMUIDialogTitleTvCustomDef, R.attr.qmui_dialog_title_style, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.QMUIDialogTitleTvCustomDef_qmui_paddingBottomWhenNotContent) {
                    viewOnCreateTitle.setPadding(viewOnCreateTitle.getPaddingLeft(), viewOnCreateTitle.getPaddingTop(), viewOnCreateTitle.getPaddingRight(), typedArrayObtainStyledAttributes.getDimensionPixelSize(index, viewOnCreateTitle.getPaddingBottom()));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        return viewOnCreateTitle;
    }

    @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
    protected View onCreateContent(QMUIDialog qMUIDialog, QMUIDialogView qMUIDialogView, Context context) {
        CharSequence charSequence = this.mContent;
        if (charSequence == null || charSequence.length() <= 0) {
            return null;
        }
        QMUISpanTouchFixTextView qMUISpanTouchFixTextView = new QMUISpanTouchFixTextView(context);
        QMUIResHelper.assignTextViewWithAttr(qMUISpanTouchFixTextView, R.attr.qmui_dialog_message_content_style);
        if (!hasTitle()) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.QMUIDialogMessageTvCustomDef, R.attr.qmui_dialog_message_content_style, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.QMUIDialogMessageTvCustomDef_qmui_paddingTopWhenNotTitle) {
                    qMUISpanTouchFixTextView.setPadding(qMUISpanTouchFixTextView.getPaddingLeft(), typedArrayObtainStyledAttributes.getDimensionPixelSize(index, qMUISpanTouchFixTextView.getPaddingTop()), qMUISpanTouchFixTextView.getPaddingRight(), qMUISpanTouchFixTextView.getPaddingBottom());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        qMUISpanTouchFixTextView.setText(this.mContent);
        return wrapWithScroll(qMUISpanTouchFixTextView);
    }

    @Override // com.qmuiteam.qmui.widget.dialog.QMUIDialogBuilder
    public QMUIDialog create(int i) {
        setActionContainerOrientation(1);
        return super.create(i);
    }
}
