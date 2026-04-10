package com.qmuiteam.qmui.widget.dialog;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIBottomSheetBehavior<V extends ViewGroup> extends BottomSheetBehavior<V> {
    private DownDragDecisionMaker mDownDragDecisionMaker;
    private boolean mAllowDrag = true;
    private boolean mMotionEventCanDrag = true;

    public interface DownDragDecisionMaker {
        boolean canDrag(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent);
    }

    public void setAllowDrag(boolean z) {
        this.mAllowDrag = z;
    }

    public void setDownDragDecisionMaker(DownDragDecisionMaker downDragDecisionMaker) {
        this.mDownDragDecisionMaker = downDragDecisionMaker;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!this.mAllowDrag) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            DownDragDecisionMaker downDragDecisionMaker = this.mDownDragDecisionMaker;
            this.mMotionEventCanDrag = downDragDecisionMaker == null || downDragDecisionMaker.canDrag(coordinatorLayout, v, motionEvent);
        }
        if (this.mMotionEventCanDrag) {
            return super.onTouchEvent(coordinatorLayout, v, motionEvent);
        }
        return false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!this.mAllowDrag) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            DownDragDecisionMaker downDragDecisionMaker = this.mDownDragDecisionMaker;
            this.mMotionEventCanDrag = downDragDecisionMaker == null || downDragDecisionMaker.canDrag(coordinatorLayout, v, motionEvent);
        }
        if (this.mMotionEventCanDrag) {
            return super.onInterceptTouchEvent(coordinatorLayout, v, motionEvent);
        }
        return false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        if (this.mAllowDrag) {
            return super.onStartNestedScroll(coordinatorLayout, v, view, view2, i, i2);
        }
        return false;
    }
}
