package com.qmuiteam.qmui.widget.dialog;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIResHelper;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIBottomSheetGridLineLayout extends LinearLayout {
    private static ItemWidthCalculator DEFAULT_CALCULATOR = new ItemWidthCalculator() { // from class: com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetGridLineLayout.1
        @Override // com.qmuiteam.qmui.widget.dialog.QMUIBottomSheetGridLineLayout.ItemWidthCalculator
        public int calculate(Context context, int i, int i2, int i3, int i4, int i5) {
            int i6;
            int i7 = i - i4;
            int i8 = i7 - i5;
            if (i3 >= 3 && (i6 = i8 - (i3 * i2)) > 0 && i6 < i2) {
                i2 = i8 / (i8 / i2);
            }
            return i3 * i2 > i8 ? (int) (i7 / ((i7 / i2) + 0.5f)) : i2;
        }
    };
    private int itemWidth;
    private int linePaddingHor;
    private List<Pair<View, LinearLayout.LayoutParams>> mFirstLineViews;
    private final ItemWidthCalculator mItemWidthCalculator;
    private List<Pair<View, LinearLayout.LayoutParams>> mSecondLineViews;
    private int maxItemCountInLines;
    private int miniItemWidth;

    public interface ItemWidthCalculator {
        int calculate(Context context, int i, int i2, int i3, int i4, int i5);
    }

    public QMUIBottomSheetGridLineLayout(QMUIBottomSheet qMUIBottomSheet, ItemWidthCalculator itemWidthCalculator, List<Pair<View, LinearLayout.LayoutParams>> list, List<Pair<View, LinearLayout.LayoutParams>> list2) {
        super(qMUIBottomSheet.getContext());
        this.miniItemWidth = -1;
        boolean z = true;
        setOrientation(1);
        setGravity(48);
        this.mItemWidthCalculator = itemWidthCalculator == null ? DEFAULT_CALCULATOR : itemWidthCalculator;
        setPadding(0, QMUIResHelper.getAttrDimen(qMUIBottomSheet.getContext(), R.attr.qmui_bottom_sheet_grid_padding_top), 0, QMUIResHelper.getAttrDimen(qMUIBottomSheet.getContext(), R.attr.qmui_bottom_sheet_grid_padding_bottom));
        this.mFirstLineViews = list;
        this.mSecondLineViews = list2;
        this.maxItemCountInLines = Math.max(list != null ? list.size() : 0, list2 != null ? list2.size() : 0);
        this.linePaddingHor = QMUIResHelper.getAttrDimen(qMUIBottomSheet.getContext(), R.attr.qmui_bottom_sheet_padding_hor);
        if (list == null || list.isEmpty()) {
            z = false;
        } else {
            addView(createHorScroller(qMUIBottomSheet, list), new LinearLayout.LayoutParams(-2, -2));
        }
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        HorizontalScrollView horizontalScrollViewCreateHorScroller = createHorScroller(qMUIBottomSheet, list2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (z) {
            layoutParams.topMargin = QMUIResHelper.getAttrDimen(qMUIBottomSheet.getContext(), R.attr.qmui_bottom_sheet_grid_line_vertical_space);
        }
        addView(horizontalScrollViewCreateHorScroller, layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int i3 = this.maxItemCountInLines;
        int i4 = this.linePaddingHor;
        this.itemWidth = calculateItemWidth(size, i3, i4, i4);
        List<Pair<View, LinearLayout.LayoutParams>> list = this.mFirstLineViews;
        if (list != null) {
            for (Pair<View, LinearLayout.LayoutParams> pair : list) {
                if (((LinearLayout.LayoutParams) pair.second).width != this.itemWidth) {
                    ((LinearLayout.LayoutParams) pair.second).width = this.itemWidth;
                }
            }
        }
        List<Pair<View, LinearLayout.LayoutParams>> list2 = this.mSecondLineViews;
        if (list2 != null) {
            for (Pair<View, LinearLayout.LayoutParams> pair2 : list2) {
                if (((LinearLayout.LayoutParams) pair2.second).width != this.itemWidth) {
                    ((LinearLayout.LayoutParams) pair2.second).width = this.itemWidth;
                }
            }
        }
        super.onMeasure(i, i2);
    }

    protected HorizontalScrollView createHorScroller(QMUIBottomSheet qMUIBottomSheet, List<Pair<View, LinearLayout.LayoutParams>> list) {
        Context context = qMUIBottomSheet.getContext();
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(context);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setClipToPadding(true);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i = this.linePaddingHor;
        linearLayout.setPadding(i, 0, i, 0);
        horizontalScrollView.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2));
        for (int i2 = 0; i2 < list.size(); i2++) {
            Pair<View, LinearLayout.LayoutParams> pair = list.get(i2);
            linearLayout.addView((View) pair.first, (ViewGroup.LayoutParams) pair.second);
        }
        return horizontalScrollView;
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i, int i2) {
        super.measureChild(view, i, i2);
    }

    private int calculateItemWidth(int i, int i2, int i3, int i4) {
        if (this.miniItemWidth == -1) {
            this.miniItemWidth = QMUIResHelper.getAttrDimen(getContext(), R.attr.qmui_bottom_sheet_grid_item_mini_width);
        }
        return this.mItemWidthCalculator.calculate(getContext(), i, this.miniItemWidth, i2, i3, i4);
    }
}
