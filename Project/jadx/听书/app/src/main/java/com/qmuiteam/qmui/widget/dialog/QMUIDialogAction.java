package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.view.View;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIDialogAction {
    public static final int ACTION_PROP_NEGATIVE = 2;
    public static final int ACTION_PROP_NEUTRAL = 1;
    public static final int ACTION_PROP_POSITIVE = 0;
    private int mActionProp;
    private QMUIButton mButton;
    private int mIconRes;
    private boolean mIsEnabled;
    private ActionListener mOnClickListener;
    private int mSkinBackgroundAttr;
    private int mSkinIconTintColorAttr;
    private int mSkinSeparatorColorAttr;
    private int mSkinTextColorAttr;
    private CharSequence mStr;

    public interface ActionListener {
        void onClick(QMUIDialog qMUIDialog, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Prop {
    }

    public QMUIDialogAction(Context context, int i) {
        this(context.getResources().getString(i));
    }

    public QMUIDialogAction(CharSequence charSequence) {
        this(charSequence, (ActionListener) null);
    }

    public QMUIDialogAction(Context context, int i, ActionListener actionListener) {
        this(context.getResources().getString(i), actionListener);
    }

    public QMUIDialogAction(CharSequence charSequence, ActionListener actionListener) {
        this.mIconRes = 0;
        this.mActionProp = 1;
        this.mSkinTextColorAttr = 0;
        this.mSkinBackgroundAttr = 0;
        this.mSkinIconTintColorAttr = 0;
        this.mSkinSeparatorColorAttr = R.attr.qmui_skin_support_dialog_action_divider_color;
        this.mIsEnabled = true;
        this.mStr = charSequence;
        this.mOnClickListener = actionListener;
    }

    public QMUIDialogAction prop(int i) {
        this.mActionProp = i;
        return this;
    }

    public QMUIDialogAction iconRes(int i) {
        this.mIconRes = i;
        return this;
    }

    public QMUIDialogAction onClick(ActionListener actionListener) {
        this.mOnClickListener = actionListener;
        return this;
    }

    public QMUIDialogAction skinTextColorAttr(int i) {
        this.mSkinTextColorAttr = i;
        return this;
    }

    public QMUIDialogAction skinBackgroundAttr(int i) {
        this.mSkinBackgroundAttr = i;
        return this;
    }

    public QMUIDialogAction skinIconTintColorAttr(int i) {
        this.mSkinIconTintColorAttr = i;
        return this;
    }

    QMUIDialogAction skinSeparatorColorAttr(int i) {
        this.mSkinSeparatorColorAttr = i;
        return this;
    }

    public QMUIDialogAction setEnabled(boolean z) {
        this.mIsEnabled = z;
        QMUIButton qMUIButton = this.mButton;
        if (qMUIButton != null) {
            qMUIButton.setEnabled(z);
        }
        return this;
    }

    public QMUIButton buildActionView(final QMUIDialog qMUIDialog, final int i) {
        QMUIButton qMUIButtonGenerateActionButton = generateActionButton(qMUIDialog.getContext(), this.mStr, this.mIconRes, this.mSkinBackgroundAttr, this.mSkinTextColorAttr, this.mSkinIconTintColorAttr);
        this.mButton = qMUIButtonGenerateActionButton;
        qMUIButtonGenerateActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIDialogAction.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (QMUIDialogAction.this.mOnClickListener == null || !QMUIDialogAction.this.mButton.isEnabled()) {
                    return;
                }
                QMUIDialogAction.this.mOnClickListener.onClick(qMUIDialog, i);
            }
        });
        return this.mButton;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.qmuiteam.qmui.layout.QMUIButton generateActionButton(android.content.Context r17, java.lang.CharSequence r18, int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.widget.dialog.QMUIDialogAction.generateActionButton(android.content.Context, java.lang.CharSequence, int, int, int, int):com.qmuiteam.qmui.layout.QMUIButton");
    }

    public int getActionProp() {
        return this.mActionProp;
    }
}
