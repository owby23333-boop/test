package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIDialogView extends QMUIConstraintLayout {
    private OnDecorationListener mOnDecorationListener;

    public interface OnDecorationListener {
        void onDraw(Canvas canvas, QMUIDialogView qMUIDialogView);

        void onDrawOver(Canvas canvas, QMUIDialogView qMUIDialogView);
    }

    public QMUIDialogView(Context context) {
        this(context, null);
    }

    public QMUIDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setId(R.id.qmui_dialog_layout);
    }

    public void setOnDecorationListener(OnDecorationListener onDecorationListener) {
        this.mOnDecorationListener = onDecorationListener;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        OnDecorationListener onDecorationListener = this.mOnDecorationListener;
        if (onDecorationListener != null) {
            onDecorationListener.onDraw(canvas, this);
        }
    }

    @Override // com.qmuiteam.qmui.layout.QMUIConstraintLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        OnDecorationListener onDecorationListener = this.mOnDecorationListener;
        if (onDecorationListener != null) {
            onDecorationListener.onDrawOver(canvas, this);
        }
    }
}
