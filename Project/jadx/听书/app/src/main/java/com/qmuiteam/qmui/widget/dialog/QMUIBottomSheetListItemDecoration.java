package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.skin.IQMUISkinHandlerDecoration;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUIResHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIBottomSheetListItemDecoration extends RecyclerView.ItemDecoration implements IQMUISkinHandlerDecoration {
    private final int mSeparatorAttr;
    private final Paint mSeparatorPaint;

    public QMUIBottomSheetListItemDecoration(Context context) {
        Paint paint = new Paint();
        this.mSeparatorPaint = paint;
        paint.setStrokeWidth(QMUIResHelper.getAttrDimen(context, R.attr.qmui_bottom_sheet_list_item_separator_height));
        paint.setStyle(Paint.Style.STROKE);
        int i = R.attr.qmui_skin_support_bottom_sheet_separator_color;
        this.mSeparatorAttr = i;
        if (i != 0) {
            paint.setColor(QMUIResHelper.getAttrColor(context, i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (adapter == null || layoutManager == null || this.mSeparatorAttr == 0) {
            return;
        }
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            View childAt = recyclerView.getChildAt(i);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
            if (childAt instanceof QMUIBottomSheetListItemView) {
                if (childAdapterPosition > 0 && adapter.getItemViewType(childAdapterPosition - 1) != 3) {
                    float decoratedTop = layoutManager.getDecoratedTop(childAt);
                    canvas.drawLine(0.0f, decoratedTop, recyclerView.getWidth(), decoratedTop, this.mSeparatorPaint);
                }
                int i2 = childAdapterPosition + 1;
                if (i2 < adapter.getItemCount() && adapter.getItemViewType(i2) == 3) {
                    float decoratedBottom = layoutManager.getDecoratedBottom(childAt);
                    canvas.drawLine(0.0f, decoratedBottom, recyclerView.getWidth(), decoratedBottom, this.mSeparatorPaint);
                }
            }
        }
    }

    @Override // com.qmuiteam.qmui.skin.IQMUISkinHandlerDecoration
    public void handle(RecyclerView recyclerView, QMUISkinManager qMUISkinManager, int i, Resources.Theme theme) {
        int i2 = this.mSeparatorAttr;
        if (i2 != 0) {
            this.mSeparatorPaint.setColor(QMUIResHelper.getAttrColor(theme, i2));
        }
    }
}
