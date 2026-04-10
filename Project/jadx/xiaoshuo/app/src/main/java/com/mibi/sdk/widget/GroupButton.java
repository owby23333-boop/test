package com.mibi.sdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes17.dex */
@SuppressLint({"AppCompatCustomView"})
public class GroupButton extends Button {
    private static final int[] STATE_FIRST_V = {R.attr.state_first_v};
    private static final int[] STATE_MIDDLE_V = {R.attr.state_middle_v};
    private static final int[] STATE_LAST_V = {R.attr.state_last_v};
    private static final int[] STATE_FIRST_H = {R.attr.state_first_h};
    private static final int[] STATE_MIDDLE_H = {R.attr.state_middle_h};
    private static final int[] STATE_LAST_H = {R.attr.state_last_h};
    private static final int[] STATE_SINGLE_H = {R.attr.state_single_h};

    public GroupButton(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null && (viewGroup instanceof LinearLayout)) {
            int orientation = ((LinearLayout) viewGroup).getOrientation();
            int iIndexOfChild = viewGroup.indexOfChild(this);
            int i2 = 0;
            boolean z = true;
            boolean z2 = true;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                if (viewGroup.getChildAt(i3).getVisibility() == 0) {
                    i2++;
                    if (i3 < iIndexOfChild) {
                        z = false;
                    }
                    if (i3 > iIndexOfChild) {
                        z2 = false;
                    }
                }
            }
            boolean z3 = i2 == 1;
            if (orientation == 1) {
                int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
                View.mergeDrawableStates(iArrOnCreateDrawableState, STATE_SINGLE_H);
                if (!z3) {
                    if (z) {
                        View.mergeDrawableStates(iArrOnCreateDrawableState, STATE_FIRST_V);
                    } else if (z2) {
                        View.mergeDrawableStates(iArrOnCreateDrawableState, STATE_LAST_V);
                    } else {
                        View.mergeDrawableStates(iArrOnCreateDrawableState, STATE_MIDDLE_V);
                    }
                }
                return iArrOnCreateDrawableState;
            }
            boolean z4 = getLayoutDirection() == 1;
            int[] iArrOnCreateDrawableState2 = super.onCreateDrawableState(i + 1);
            if (z3) {
                View.mergeDrawableStates(iArrOnCreateDrawableState2, STATE_SINGLE_H);
            } else if (z) {
                View.mergeDrawableStates(iArrOnCreateDrawableState2, z4 ? STATE_LAST_H : STATE_FIRST_H);
            } else if (z2) {
                View.mergeDrawableStates(iArrOnCreateDrawableState2, z4 ? STATE_FIRST_H : STATE_LAST_H);
            } else {
                View.mergeDrawableStates(iArrOnCreateDrawableState2, STATE_MIDDLE_H);
            }
            return iArrOnCreateDrawableState2;
        }
        return super.onCreateDrawableState(i);
    }

    public GroupButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GroupButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
