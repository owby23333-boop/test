package com.qmuiteam.qmui.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.qmuiteam.qmui.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIPriorityLinearLayout extends QMUILinearLayout {
    private ArrayList<View> mTempDisposableChildList;
    private ArrayList<View> mTempMiniWidthChildList;

    public QMUIPriorityLinearLayout(Context context) {
        super(context);
        this.mTempMiniWidthChildList = new ArrayList<>();
        this.mTempDisposableChildList = new ArrayList<>();
    }

    public QMUIPriorityLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempMiniWidthChildList = new ArrayList<>();
        this.mTempDisposableChildList = new ArrayList<>();
    }

    @Override // com.qmuiteam.qmui.layout.QMUILinearLayout, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (getOrientation() == 0) {
            handleHorizontal(i, i2);
        } else {
            handleVertical(i, i2);
        }
        super.onMeasure(i, i2);
    }

    private void handleHorizontal(int i, int i2) {
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int mode = View.MeasureSpec.getMode(i);
        int visibleChildCount = getVisibleChildCount();
        if (mode == 0 || visibleChildCount == 0 || size <= 0) {
            return;
        }
        int iHandlePriorityIncompressible = handlePriorityIncompressible(i, i2);
        if (iHandlePriorityIncompressible >= size) {
            for (View view : this.mTempMiniWidthChildList) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                view.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.miniContentProtectionSize, Integer.MIN_VALUE), i2);
                layoutParams.width = view.getMeasuredWidth();
            }
            Iterator<View> it = this.mTempDisposableChildList.iterator();
            while (it.hasNext()) {
                LayoutParams layoutParams2 = (LayoutParams) it.next().getLayoutParams();
                layoutParams2.width = 0;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
            }
            return;
        }
        int i3 = size - iHandlePriorityIncompressible;
        int iMin = 0;
        int measuredWidth = 0;
        for (View view2 : this.mTempMiniWidthChildList) {
            LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
            view2.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), i2);
            int i4 = layoutParams3.leftMargin + layoutParams3.rightMargin;
            measuredWidth += view2.getMeasuredWidth() + i4;
            iMin += Math.min(view2.getMeasuredWidth(), layoutParams3.miniContentProtectionSize) + i4;
        }
        if (iMin >= i3) {
            for (View view3 : this.mTempMiniWidthChildList) {
                LayoutParams layoutParams4 = (LayoutParams) view3.getLayoutParams();
                layoutParams4.width = Math.min(view3.getMeasuredWidth(), layoutParams4.miniContentProtectionSize);
            }
            Iterator<View> it2 = this.mTempDisposableChildList.iterator();
            while (it2.hasNext()) {
                LayoutParams layoutParams5 = (LayoutParams) it2.next().getLayoutParams();
                layoutParams5.width = 0;
                layoutParams5.leftMargin = 0;
                layoutParams5.rightMargin = 0;
            }
            return;
        }
        if (measuredWidth < i3) {
            if (this.mTempDisposableChildList.isEmpty()) {
                return;
            }
            dispatchSpaceToDisposableChildList(this.mTempDisposableChildList, i, i2, i3 - measuredWidth);
            return;
        }
        Iterator<View> it3 = this.mTempDisposableChildList.iterator();
        while (it3.hasNext()) {
            LayoutParams layoutParams6 = (LayoutParams) it3.next().getLayoutParams();
            layoutParams6.width = 0;
            layoutParams6.leftMargin = 0;
            layoutParams6.rightMargin = 0;
        }
        if (i3 >= measuredWidth || this.mTempMiniWidthChildList.isEmpty()) {
            return;
        }
        dispatchSpaceToMiniWidthChildList(this.mTempMiniWidthChildList, i3, measuredWidth);
    }

    private void handleVertical(int i, int i2) {
        int size = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i2);
        int visibleChildCount = getVisibleChildCount();
        if (mode == 0 || visibleChildCount == 0 || size <= 0) {
            return;
        }
        int iHandlePriorityIncompressible = handlePriorityIncompressible(i, i2);
        if (iHandlePriorityIncompressible >= size) {
            for (View view : this.mTempMiniWidthChildList) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                view.measure(i, View.MeasureSpec.makeMeasureSpec(layoutParams.miniContentProtectionSize, Integer.MIN_VALUE));
                layoutParams.height = view.getMeasuredHeight();
            }
            Iterator<View> it = this.mTempDisposableChildList.iterator();
            while (it.hasNext()) {
                LayoutParams layoutParams2 = (LayoutParams) it.next().getLayoutParams();
                layoutParams2.height = 0;
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
            }
            return;
        }
        int i3 = size - iHandlePriorityIncompressible;
        int iMin = 0;
        int measuredHeight = 0;
        for (View view2 : this.mTempMiniWidthChildList) {
            LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE));
            int i4 = layoutParams3.topMargin + layoutParams3.bottomMargin;
            measuredHeight += view2.getMeasuredHeight() + i4;
            iMin += Math.min(view2.getMeasuredHeight(), layoutParams3.miniContentProtectionSize) + i4;
        }
        if (iMin >= i3) {
            for (View view3 : this.mTempMiniWidthChildList) {
                LayoutParams layoutParams4 = (LayoutParams) view3.getLayoutParams();
                layoutParams4.height = Math.min(view3.getMeasuredHeight(), layoutParams4.miniContentProtectionSize);
            }
            Iterator<View> it2 = this.mTempDisposableChildList.iterator();
            while (it2.hasNext()) {
                LayoutParams layoutParams5 = (LayoutParams) it2.next().getLayoutParams();
                layoutParams5.height = 0;
                layoutParams5.topMargin = 0;
                layoutParams5.bottomMargin = 0;
            }
            return;
        }
        if (measuredHeight < i3) {
            if (this.mTempDisposableChildList.isEmpty()) {
                return;
            }
            dispatchSpaceToDisposableChildList(this.mTempDisposableChildList, i, i2, i3 - measuredHeight);
            return;
        }
        Iterator<View> it3 = this.mTempDisposableChildList.iterator();
        while (it3.hasNext()) {
            LayoutParams layoutParams6 = (LayoutParams) it3.next().getLayoutParams();
            layoutParams6.height = 0;
            layoutParams6.topMargin = 0;
            layoutParams6.bottomMargin = 0;
        }
        if (i3 >= measuredHeight || this.mTempMiniWidthChildList.isEmpty()) {
            return;
        }
        dispatchSpaceToMiniWidthChildList(this.mTempMiniWidthChildList, i3, measuredHeight);
    }

    private int handlePriorityIncompressible(int i, int i2) {
        int i3;
        int i4;
        int measuredHeight;
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        this.mTempMiniWidthChildList.clear();
        this.mTempDisposableChildList.clear();
        int orientation = getOrientation();
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.backupOrRestore();
                int priority = layoutParams.getPriority(orientation);
                if (orientation == 0) {
                    i3 = layoutParams.leftMargin;
                    i4 = layoutParams.rightMargin;
                } else {
                    i3 = layoutParams.topMargin;
                    i4 = layoutParams.bottomMargin;
                }
                int i7 = i3 + i4;
                if (priority == 3) {
                    if (orientation == 0) {
                        if (layoutParams.width >= 0) {
                            measuredHeight = layoutParams.width;
                        } else {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), i2);
                            measuredHeight = childAt.getMeasuredWidth();
                        }
                    } else if (layoutParams.height >= 0) {
                        measuredHeight = layoutParams.height;
                    } else {
                        childAt.measure(i, View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
                        measuredHeight = childAt.getMeasuredHeight();
                    }
                    i5 += measuredHeight + i7;
                } else if (priority == 2) {
                    this.mTempMiniWidthChildList.add(childAt);
                } else if (layoutParams.weight == 0.0f) {
                    this.mTempDisposableChildList.add(childAt);
                }
            }
        }
        return i5;
    }

    protected void dispatchSpaceToDisposableChildList(ArrayList<View> arrayList, int i, int i2, int i3) {
        int measuredWidth;
        for (View view : arrayList) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (getOrientation() == 0) {
                if (i3 <= 0) {
                    layoutParams.leftMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.width = 0;
                }
                i3 -= layoutParams.leftMargin - layoutParams.rightMargin;
                if (i3 > 0) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                    if (view.getMeasuredWidth() >= i3) {
                        layoutParams.width = i3;
                        i3 = 0;
                    } else {
                        measuredWidth = view.getMeasuredWidth();
                        i3 -= measuredWidth;
                    }
                } else {
                    layoutParams.leftMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.width = 0;
                }
            } else {
                if (i3 <= 0) {
                    layoutParams.topMargin = 0;
                    layoutParams.bottomMargin = 0;
                    layoutParams.height = 0;
                }
                i3 -= layoutParams.topMargin - layoutParams.bottomMargin;
                if (i3 > 0) {
                    view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE));
                    if (view.getMeasuredHeight() >= i3) {
                        layoutParams.height = i3;
                        i3 = 0;
                    } else {
                        measuredWidth = view.getMeasuredHeight();
                        i3 -= measuredWidth;
                    }
                } else {
                    layoutParams.topMargin = 0;
                    layoutParams.bottomMargin = 0;
                    layoutParams.height = 0;
                }
            }
        }
    }

    protected void dispatchSpaceToMiniWidthChildList(ArrayList<View> arrayList, int i, int i2) {
        int i3 = i2 - i;
        if (i3 > 0) {
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                LayoutParams layoutParams = (LayoutParams) it.next().getLayoutParams();
                if (getOrientation() == 0) {
                    layoutParams.width = Math.max(0, (int) (r0.getMeasuredWidth() - (i3 * ((((r0.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) * 1.0f) / i2))));
                } else {
                    layoutParams.height = Math.max(0, (int) (r0.getMeasuredHeight() - (i3 * ((((r0.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) * 1.0f) / i2))));
                }
            }
        }
    }

    private int getVisibleChildCount() {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getChildAt(i2).getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public static final int PRIORITY_DISPOSABLE = 1;
        public static final int PRIORITY_INCOMPRESSIBLE = 3;
        public static final int PRIORITY_MINI_CONTENT_PROTECTION = 2;
        private int backupBottomMargin;
        private int backupHeight;
        private int backupLeftMargin;
        private int backupRightMargin;
        private int backupTopMargin;
        private int backupWidth;
        private int miniContentProtectionSize;
        private int priority;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = Integer.MIN_VALUE;
            this.backupHeight = Integer.MIN_VALUE;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPriorityLinearLayout_Layout);
            this.priority = typedArrayObtainStyledAttributes.getInteger(R.styleable.QMUIPriorityLinearLayout_Layout_qmui_layout_priority, 2);
            this.miniContentProtectionSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPriorityLinearLayout_Layout_qmui_layout_miniContentProtectionSize, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = Integer.MIN_VALUE;
            this.backupHeight = Integer.MIN_VALUE;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = Integer.MIN_VALUE;
            this.backupHeight = Integer.MIN_VALUE;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = Integer.MIN_VALUE;
            this.backupHeight = Integer.MIN_VALUE;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = Integer.MIN_VALUE;
            this.backupHeight = Integer.MIN_VALUE;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.priority = 2;
            this.miniContentProtectionSize = 0;
            this.backupWidth = Integer.MIN_VALUE;
            this.backupHeight = Integer.MIN_VALUE;
            this.backupLeftMargin = 0;
            this.backupRightMargin = 0;
            this.backupTopMargin = 0;
            this.backupBottomMargin = 0;
        }

        public void setPriority(int i) {
            this.priority = i;
        }

        public void setMiniContentProtectionSize(int i) {
            this.miniContentProtectionSize = i;
        }

        public int getPriority(int i) {
            if (this.weight > 0.0f) {
                return 1;
            }
            if (i == 0) {
                if (this.width >= 0) {
                    return 3;
                }
            } else if (this.height >= 0) {
                return 3;
            }
            return this.priority;
        }

        void backupOrRestore() {
            int i = this.backupWidth;
            if (i == Integer.MIN_VALUE) {
                this.backupWidth = this.width;
                this.backupLeftMargin = this.leftMargin;
                this.backupRightMargin = this.rightMargin;
            } else {
                this.width = i;
                this.leftMargin = this.backupLeftMargin;
                this.rightMargin = this.backupRightMargin;
            }
            int i2 = this.backupHeight;
            if (i2 == Integer.MIN_VALUE) {
                this.backupHeight = this.height;
                this.backupTopMargin = this.topMargin;
                this.backupBottomMargin = this.bottomMargin;
            } else {
                this.height = i2;
                this.topMargin = this.backupTopMargin;
                this.bottomMargin = this.backupBottomMargin;
            }
        }
    }
}
