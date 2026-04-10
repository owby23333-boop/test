package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.QMUIInterpolatorStaticHolder;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIContinuousNestedTopAreaBehavior extends QMUIViewOffsetBehavior<View> {
    private static final int INVALID_POINTER = -1;
    private int activePointerId;
    private boolean isBeingDragged;
    private boolean isInFlingOrScroll;
    private boolean isInTouch;
    private int lastMotionY;
    private Callback mCallback;
    private final int[] mScrollConsumed;
    private final ViewFlinger mViewFlinger;
    private boolean replaceCancelActionWithMoveActionForWebView;
    private int touchSlop;
    private VelocityTracker velocityTracker;

    public interface Callback {
        void onTopAreaOffset(int i);

        void onTopBehaviorFlingOrScrollEnd();

        void onTopBehaviorFlingOrScrollStart();

        void onTopBehaviorTouchBegin();

        void onTopBehaviorTouchEnd();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return (i & 2) != 0;
    }

    public QMUIContinuousNestedTopAreaBehavior(Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedTopAreaBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollConsumed = new int[2];
        this.activePointerId = -1;
        this.touchSlop = -1;
        this.isInTouch = false;
        this.isInFlingOrScroll = false;
        this.replaceCancelActionWithMoveActionForWebView = true;
        this.mViewFlinger = new ViewFlinger(context);
    }

    public void setReplaceCancelActionWithMoveActionForWebView(boolean z) {
        this.replaceCancelActionWithMoveActionForWebView = z;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b3  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r7, android.view.View r8, android.view.MotionEvent r9) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mViewFlinger.stop();
            this.isInTouch = true;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (!coordinatorLayout.isPointInChildBounds(view, x, y)) {
                return false;
            }
            this.lastMotionY = y;
            this.activePointerId = motionEvent.getPointerId(0);
            ensureVelocityTracker();
        } else {
            if (actionMasked == 1) {
                this.isInTouch = false;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onTopBehaviorTouchEnd();
                }
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.velocityTracker.computeCurrentVelocity(1000);
                    this.mViewFlinger.fling(coordinatorLayout, view, -((int) (this.velocityTracker.getYVelocity(this.activePointerId) + 0.5f)));
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                int i = this.lastMotionY - y2;
                if (!this.isBeingDragged && Math.abs(i) > this.touchSlop) {
                    this.isBeingDragged = true;
                    Callback callback2 = this.mCallback;
                    if (callback2 != null) {
                        callback2.onTopBehaviorTouchBegin();
                    }
                    i = i > 0 ? i - this.touchSlop : i + this.touchSlop;
                }
                if (this.isBeingDragged) {
                    this.lastMotionY = y2;
                    scroll(coordinatorLayout, view, i);
                }
            } else if (actionMasked == 3) {
            }
            if (this.isInTouch) {
                this.isInTouch = false;
                Callback callback3 = this.mCallback;
                if (callback3 != null) {
                    callback3.onTopBehaviorTouchEnd();
                }
            }
            this.isBeingDragged = false;
            this.activePointerId = -1;
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.velocityTracker = null;
            }
        }
        VelocityTracker velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void scroll(CoordinatorLayout coordinatorLayout, View view, int i) {
        int[] iArr = this.mScrollConsumed;
        iArr[0] = 0;
        iArr[1] = 0;
        onNestedPreScroll(coordinatorLayout, view, view, 0, i, iArr, 0);
        int iConsumeScroll = i - this.mScrollConsumed[1];
        if (view instanceof IQMUIContinuousNestedTopView) {
            iConsumeScroll = ((IQMUIContinuousNestedTopView) view).consumeScroll(iConsumeScroll);
        }
        int i2 = iConsumeScroll;
        onNestedScroll(coordinatorLayout, view, view, 0, i - i2, 0, i2, 0);
    }

    void smoothScrollBy(CoordinatorLayout coordinatorLayout, View view, int i, int i2) {
        this.mViewFlinger.startScroll(coordinatorLayout, view, i, i2);
    }

    void stopFlingOrScroll() {
        this.mViewFlinger.stop();
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        int size = View.MeasureSpec.getSize(i3);
        if (i5 == -1) {
            if (size == 0) {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.onMeasureChild(view, i, i2, View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), i4);
            return true;
        }
        coordinatorLayout.onMeasureChild(view, i, i2, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE), i4);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        int height;
        int height2;
        if (view2.getParent() != coordinatorLayout) {
            return;
        }
        if (view2 == view) {
            if (i2 < 0) {
                if (view.getTop() <= i2) {
                    setTopAndBottomOffset((view.getTop() - i2) - getLayoutTop());
                    iArr[1] = iArr[1] + i2;
                    return;
                } else {
                    if (view.getTop() < 0) {
                        int top2 = view.getTop();
                        setTopAndBottomOffset(0 - getLayoutTop());
                        iArr[1] = iArr[1] + top2;
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i2 <= 0 || !(view2 instanceof IQMUIContinuousNestedBottomView)) {
            return;
        }
        int contentHeight = ((IQMUIContinuousNestedBottomView) view2).getContentHeight();
        if (contentHeight != -1) {
            height = coordinatorLayout.getHeight() - contentHeight;
            height2 = view.getHeight();
        } else {
            height = coordinatorLayout.getHeight() - view.getHeight();
            height2 = view2.getHeight();
        }
        int i4 = height - height2;
        if (view.getTop() - i2 >= i4) {
            setTopAndBottomOffset((view.getTop() - i2) - getLayoutTop());
            iArr[1] = iArr[1] + i2;
        } else if (view.getTop() > i4) {
            int top3 = view.getTop() - i4;
            setTopAndBottomOffset(i4);
            iArr[1] = iArr[1] + top3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5) {
        if (view2.getParent() != coordinatorLayout) {
            return;
        }
        boolean z = false;
        if (view2 != view) {
            if (i4 < 0) {
                if (view.getTop() <= i4) {
                    setTopAndBottomOffset((view.getTop() - i4) - getLayoutTop());
                    return;
                }
                if (view.getTop() < 0) {
                    int top2 = view.getTop();
                    setTopAndBottomOffset(0 - getLayoutTop());
                    if (i4 != Integer.MIN_VALUE) {
                        i2 = i4 - top2;
                    }
                    i4 = i2;
                }
                if (view instanceof IQMUIContinuousNestedTopView) {
                    ((IQMUIContinuousNestedTopView) view).consumeScroll(i4);
                    return;
                }
                return;
            }
            return;
        }
        if (i4 > 0) {
            View viewFindBottomView = findBottomView(coordinatorLayout);
            if (viewFindBottomView == 0 || viewFindBottomView.getVisibility() == 8) {
                int height = coordinatorLayout.getHeight();
                if (view2.getBottom() - height >= i4) {
                    setTopAndBottomOffset((view2.getTop() - i4) - getLayoutTop());
                    return;
                } else {
                    if (view2.getBottom() - height > 0) {
                        setTopAndBottomOffset((view2.getTop() - (view2.getBottom() - height)) - getLayoutTop());
                        return;
                    }
                    return;
                }
            }
            IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = (IQMUIContinuousNestedBottomView) viewFindBottomView;
            int contentHeight = iQMUIContinuousNestedBottomView.getContentHeight();
            int height2 = coordinatorLayout.getHeight();
            if (contentHeight != -1) {
                height2 = (coordinatorLayout.getHeight() + viewFindBottomView.getHeight()) - contentHeight;
            } else {
                z = true;
            }
            if (viewFindBottomView.getBottom() - height2 > i4) {
                setTopAndBottomOffset((view2.getTop() - i4) - getLayoutTop());
                return;
            }
            if (viewFindBottomView.getBottom() - height2 > 0) {
                int bottom = viewFindBottomView.getBottom() - height2;
                setTopAndBottomOffset((view2.getTop() - bottom) - getLayoutTop());
                if (i4 != Integer.MAX_VALUE) {
                    i4 -= bottom;
                }
            }
            if (z) {
                iQMUIContinuousNestedBottomView.consumeScroll(i4);
            }
        }
    }

    private View findBottomView(CoordinatorLayout coordinatorLayout) {
        for (int i = 0; i < coordinatorLayout.getChildCount(); i++) {
            View childAt = coordinatorLayout.getChildAt(i);
            if (childAt instanceof IQMUIContinuousNestedBottomView) {
                return childAt;
            }
        }
        return null;
    }

    class ViewFlinger implements Runnable {
        private View mCurrentChild;
        private CoordinatorLayout mCurrentParent;
        private int mLastFlingY;
        OverScroller mOverScroller;
        Interpolator mInterpolator = QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
        private boolean mEatRunOnAnimationRequest = false;
        private boolean mReSchedulePostAnimationCallback = false;

        ViewFlinger(Context context) {
            this.mOverScroller = new OverScroller(context, QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mReSchedulePostAnimationCallback = false;
            boolean z = true;
            this.mEatRunOnAnimationRequest = true;
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currY = overScroller.getCurrY();
                int i = currY - this.mLastFlingY;
                this.mLastFlingY = currY;
                CoordinatorLayout coordinatorLayout = this.mCurrentParent;
                if (coordinatorLayout != null && this.mCurrentChild != null) {
                    if (coordinatorLayout instanceof QMUIContinuousNestedScrollLayout) {
                        QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout = (QMUIContinuousNestedScrollLayout) coordinatorLayout;
                        if ((i > 0 && qMUIContinuousNestedScrollLayout.getCurrentScroll() >= qMUIContinuousNestedScrollLayout.getScrollRange()) || (i < 0 && qMUIContinuousNestedScrollLayout.getCurrentScroll() <= 0)) {
                            z = false;
                        }
                    }
                    if (z) {
                        QMUIContinuousNestedTopAreaBehavior.this.scroll(this.mCurrentParent, this.mCurrentChild, i);
                        postOnAnimation();
                    } else {
                        this.mOverScroller.abortAnimation();
                    }
                }
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
                return;
            }
            this.mCurrentParent = null;
            this.mCurrentChild = null;
            onFlingOrScrollEnd();
        }

        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        private void internalPostOnAnimation() {
            if (this.mCurrentChild != null) {
                this.mCurrentParent.removeCallbacks(this);
                ViewCompat.postOnAnimation(this.mCurrentChild, this);
            }
        }

        public void fling(CoordinatorLayout coordinatorLayout, View view, int i) {
            onFlingOrScrollStart(coordinatorLayout, view);
            this.mOverScroller.fling(0, 0, 0, i, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public void startScroll(CoordinatorLayout coordinatorLayout, View view, int i, int i2) {
            onFlingOrScrollStart(coordinatorLayout, view);
            this.mOverScroller.startScroll(0, 0, 0, i, i2);
            postOnAnimation();
        }

        private void onFlingOrScrollStart(CoordinatorLayout coordinatorLayout, View view) {
            QMUIContinuousNestedTopAreaBehavior.this.isInFlingOrScroll = true;
            if (QMUIContinuousNestedTopAreaBehavior.this.mCallback != null) {
                QMUIContinuousNestedTopAreaBehavior.this.mCallback.onTopBehaviorFlingOrScrollStart();
            }
            this.mCurrentParent = coordinatorLayout;
            this.mCurrentChild = view;
            this.mLastFlingY = 0;
            if (this.mInterpolator != QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR) {
                this.mInterpolator = QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
                this.mOverScroller = new OverScroller(this.mCurrentParent.getContext(), QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
            }
        }

        public void stop() {
            View view = this.mCurrentChild;
            if (view != null) {
                view.removeCallbacks(this);
            }
            this.mOverScroller.abortAnimation();
            this.mCurrentChild = null;
            this.mCurrentParent = null;
            onFlingOrScrollEnd();
        }

        private void onFlingOrScrollEnd() {
            if (QMUIContinuousNestedTopAreaBehavior.this.mCallback != null && QMUIContinuousNestedTopAreaBehavior.this.isInFlingOrScroll) {
                QMUIContinuousNestedTopAreaBehavior.this.mCallback.onTopBehaviorFlingOrScrollEnd();
            }
            QMUIContinuousNestedTopAreaBehavior.this.isInFlingOrScroll = false;
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIViewOffsetBehavior
    public boolean setTopAndBottomOffset(int i) {
        boolean topAndBottomOffset = super.setTopAndBottomOffset(i);
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onTopAreaOffset(i);
        }
        return topAndBottomOffset;
    }
}
