package com.qmuiteam.qmui.widget.pullLayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.QMUIInterpolatorStaticHolder;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUIViewOffsetHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIPullLayout extends FrameLayout implements NestedScrollingParent3 {
    public static final float DEFAULT_FLING_FRACTION = 0.002f;
    public static final int DEFAULT_MIN_SCROLL_DURATION = 300;
    public static final float DEFAULT_PULL_RATE = 0.45f;
    public static final float DEFAULT_SCROLL_SPEED_PER_PIXEL = 1.5f;
    public static final int PULL_EDGE_BOTTOM = 8;
    public static final int PULL_EDGE_LEFT = 1;
    public static final int PULL_EDGE_RIGHT = 4;
    public static final int PULL_EDGE_TOP = 2;
    public static final int PUL_EDGE_ALL = 15;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PULLING = 1;
    private static final int STATE_SETTLING_DELIVER = 5;
    private static final int STATE_SETTLING_FLING = 6;
    private static final int STATE_SETTLING_TO_INIT_OFFSET = 4;
    private static final int STATE_SETTLING_TO_TRIGGER_OFFSET = 2;
    private static final int STATE_TRIGGERING = 3;
    private ActionListener mActionListener;
    private PullAction mBottomPullAction;
    private int mEnabledEdges;
    private PullAction mLeftPullAction;
    private int mMinScrollDuration;
    private float mNestedPreFlingVelocityScaleDown;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private final int[] mNestedScrollingV2ConsumedCompat;
    private PullAction mRightPullAction;
    private OverScroller mScroller;
    private int mState;
    private Runnable mStopTargetFlingRunnable;
    private StopTargetViewFlingImpl mStopTargetViewFlingImpl;
    private QMUIViewOffsetHelper mTargetOffsetHelper;
    private View mTargetView;
    private PullAction mTopPullAction;

    public interface ActionListener {
        void onActionTriggered(PullAction pullAction);
    }

    public interface ActionPullWatcherView {
        void onActionFinished();

        void onActionTriggered();

        void onPull(PullAction pullAction, int i);
    }

    public interface ActionViewOffsetCalculator {
        int calculateOffset(PullAction pullAction, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PullEdge {
    }

    public interface StopTargetViewFlingImpl {
        void stopFling(View view);
    }

    protected void onTargetViewLeftAndRightOffsetChanged(int i) {
    }

    protected void onTargetViewTopAndBottomOffsetChanged(int i) {
    }

    public QMUIPullLayout(Context context) {
        this(context, null);
    }

    public QMUIPullLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIPullLayoutStyle);
    }

    public QMUIPullLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLeftPullAction = null;
        this.mTopPullAction = null;
        this.mRightPullAction = null;
        this.mBottomPullAction = null;
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mStopTargetViewFlingImpl = DefaultStopTargetViewFlingImpl.getInstance();
        this.mStopTargetFlingRunnable = null;
        this.mNestedPreFlingVelocityScaleDown = 10.0f;
        this.mMinScrollDuration = 300;
        this.mState = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPullLayout, i, 0);
        this.mEnabledEdges = typedArrayObtainStyledAttributes.getInt(R.styleable.QMUIPullLayout_qmui_pull_enable_edge, 15);
        typedArrayObtainStyledAttributes.recycle();
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mScroller = new OverScroller(context, QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        String str;
        super.onFinishInflate();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isTarget) {
                if (z) {
                    throw new RuntimeException("More than one view in xml are marked by qmui_is_target = true.");
                }
                setTargetView(childAt);
                z = true;
            } else {
                if ((layoutParams.edge & i) != 0) {
                    if (layoutParams.edge == 1) {
                        str = TtmlNode.LEFT;
                    } else if (layoutParams.edge == 2) {
                        str = "top";
                    } else if (layoutParams.edge != 4) {
                        str = layoutParams.edge == 8 ? "bottom" : "";
                    } else {
                        str = TtmlNode.RIGHT;
                    }
                    throw new RuntimeException("More than one view in xml marked by qmui_layout_edge = ".concat(str));
                }
                i |= layoutParams.edge;
                setActionView(childAt, layoutParams);
            }
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            if (this.mScroller.isFinished()) {
                int i = this.mState;
                if (i == 4) {
                    this.mState = 0;
                    return;
                }
                if (i == 3) {
                    return;
                }
                if (i == 6) {
                    checkScrollToTargetOffsetOrInitOffset(false);
                    return;
                }
                if (i == 2) {
                    this.mState = 3;
                    if (this.mLeftPullAction != null && isEdgeEnabled(1) && this.mScroller.getFinalX() == this.mLeftPullAction.getTargetTriggerOffset()) {
                        onActionTriggered(this.mLeftPullAction);
                    }
                    if (this.mRightPullAction != null && isEdgeEnabled(4) && this.mScroller.getFinalX() == (-this.mRightPullAction.getTargetTriggerOffset())) {
                        onActionTriggered(this.mRightPullAction);
                    }
                    if (this.mTopPullAction != null && isEdgeEnabled(2) && this.mScroller.getFinalY() == this.mTopPullAction.getTargetTriggerOffset()) {
                        onActionTriggered(this.mTopPullAction);
                    }
                    if (this.mBottomPullAction != null && isEdgeEnabled(8) && this.mScroller.getFinalY() == (-this.mBottomPullAction.getTargetTriggerOffset())) {
                        onActionTriggered(this.mBottomPullAction);
                    }
                    setHorOffsetToTargetOffsetHelper(this.mScroller.getCurrX());
                    setVerOffsetToTargetOffsetHelper(this.mScroller.getCurrY());
                    return;
                }
                return;
            }
            setHorOffsetToTargetOffsetHelper(this.mScroller.getCurrX());
            setVerOffsetToTargetOffsetHelper(this.mScroller.getCurrY());
            postInvalidateOnAnimation();
        }
    }

    public void setStopTargetViewFlingImpl(StopTargetViewFlingImpl stopTargetViewFlingImpl) {
        this.mStopTargetViewFlingImpl = stopTargetViewFlingImpl;
    }

    public void setMinScrollDuration(int i) {
        this.mMinScrollDuration = i;
    }

    public void setTargetView(View view) {
        if (view.getParent() != this) {
            throw new RuntimeException("Target already exists other parent view.");
        }
        if (view.getParent() == null) {
            addView(view, new LayoutParams(-1, -1));
        }
        innerSetTargetView(view);
    }

    private void innerSetTargetView(View view) {
        this.mTargetView = view;
        this.mTargetOffsetHelper = new QMUIViewOffsetHelper(view);
    }

    public void setActionView(View view, LayoutParams layoutParams) {
        PullActionBuilder pullActionBuilderActionInitOffset = new PullActionBuilder(view, layoutParams.edge).canOverPull(layoutParams.canOverPull).pullRate(layoutParams.pullRate).needReceiveFlingFromTargetView(layoutParams.needReceiveFlingFromTarget).receivedFlingFraction(layoutParams.receivedFlingFraction).scrollSpeedPerPixel(layoutParams.scrollSpeedPerPixel).targetTriggerOffset(layoutParams.targetTriggerOffset).triggerUntilScrollToTriggerOffset(layoutParams.triggerUntilScrollToTriggerOffset).scrollToTriggerOffsetAfterTouchUp(layoutParams.scrollToTriggerOffsetAfterTouchUp).actionInitOffset(layoutParams.actionInitOffset);
        view.setLayoutParams(layoutParams);
        setActionView(pullActionBuilderActionInitOffset);
    }

    public void setActionView(PullActionBuilder pullActionBuilder) {
        if (pullActionBuilder.mActionView.getParent() != this) {
            throw new RuntimeException("Action view already exists other parent view.");
        }
        if (pullActionBuilder.mActionView.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = pullActionBuilder.mActionView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            addView(pullActionBuilder.mActionView, layoutParams);
        }
        if (pullActionBuilder.mPullEdge == 1) {
            this.mLeftPullAction = pullActionBuilder.build();
            return;
        }
        if (pullActionBuilder.mPullEdge == 2) {
            this.mTopPullAction = pullActionBuilder.build();
        } else if (pullActionBuilder.mPullEdge == 4) {
            this.mRightPullAction = pullActionBuilder.build();
        } else if (pullActionBuilder.mPullEdge == 8) {
            this.mBottomPullAction = pullActionBuilder.build();
        }
    }

    public void setActionListener(ActionListener actionListener) {
        this.mActionListener = actionListener;
    }

    public void setEnabledEdges(int i) {
        this.mEnabledEdges = i;
    }

    public boolean isEdgeEnabled(int i) {
        return (this.mEnabledEdges & i) == i && getPullAction(i) != null;
    }

    private PullAction getPullAction(int i) {
        if (i == 1) {
            return this.mLeftPullAction;
        }
        if (i == 2) {
            return this.mTopPullAction;
        }
        if (i == 4) {
            return this.mRightPullAction;
        }
        if (i == 8) {
            return this.mBottomPullAction;
        }
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        View view = this.mTargetView;
        if (view != null) {
            view.layout(0, 0, i5, i6);
            this.mTargetOffsetHelper.onViewLayout();
        }
        PullAction pullAction = this.mLeftPullAction;
        if (pullAction != null) {
            View view2 = pullAction.mActionView;
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = view2.getMeasuredHeight();
            int i7 = (i6 - measuredHeight) / 2;
            view2.layout(-measuredWidth, i7, 0, measuredHeight + i7);
            this.mLeftPullAction.mViewOffsetHelper.onViewLayout();
        }
        PullAction pullAction2 = this.mTopPullAction;
        if (pullAction2 != null) {
            View view3 = pullAction2.mActionView;
            int measuredWidth2 = view3.getMeasuredWidth();
            int i8 = (i5 - measuredWidth2) / 2;
            view3.layout(i8, -view3.getMeasuredHeight(), measuredWidth2 + i8, 0);
            this.mTopPullAction.mViewOffsetHelper.onViewLayout();
        }
        PullAction pullAction3 = this.mRightPullAction;
        if (pullAction3 != null) {
            View view4 = pullAction3.mActionView;
            int measuredWidth3 = view4.getMeasuredWidth();
            int measuredHeight2 = view4.getMeasuredHeight();
            int i9 = (i6 - measuredHeight2) / 2;
            view4.layout(i5, i9, measuredWidth3 + i5, measuredHeight2 + i9);
            this.mRightPullAction.mViewOffsetHelper.onViewLayout();
        }
        PullAction pullAction4 = this.mBottomPullAction;
        if (pullAction4 != null) {
            View view5 = pullAction4.mActionView;
            int measuredWidth4 = view5.getMeasuredWidth();
            int i10 = (i5 - measuredWidth4) / 2;
            view5.layout(i10, i6, measuredWidth4 + i10, view5.getMeasuredHeight() + i6);
            this.mBottomPullAction.mViewOffsetHelper.onViewLayout();
        }
    }

    public void setNestedPreFlingVelocityScaleDown(float f) {
        this.mNestedPreFlingVelocityScaleDown = f;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        if (this.mTargetView == view2 && i == 1 && (isEdgeEnabled(1) || isEdgeEnabled(4))) {
            return true;
        }
        return i == 2 && (isEdgeEnabled(2) || isEdgeEnabled(8));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            removeStopTargetFlingRunnable();
            this.mScroller.abortAnimation();
            this.mState = 1;
        }
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        int iCheckEdgeBottomScrollUp = checkEdgeBottomScrollUp(checkEdgeTopScrollUp(checkEdgeBottomScrollDown(checkEdgeTopScrollDown(i2, iArr, i3), iArr, i3), iArr, i3), iArr, i3);
        int iCheckEdgeRightScrollLeft = checkEdgeRightScrollLeft(checkEdgeLeftScrollLeft(checkEdgeRightScrollRight(checkEdgeLeftScrollRight(i, iArr, i3), iArr, i3), iArr, i3), iArr, i3);
        if (i == iCheckEdgeRightScrollLeft && i2 == iCheckEdgeBottomScrollUp && this.mState == 5) {
            checkStopTargetFling(view, iCheckEdgeRightScrollLeft, iCheckEdgeBottomScrollUp, i3);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        int iCheckEdgeBottomScrollUp = checkEdgeBottomScrollUp(checkEdgeTopScrollUp(checkEdgeBottomScrollDown(checkEdgeTopScrollDown(i4, iArr, i5), iArr, i5), iArr, i5), iArr, i5);
        int iCheckEdgeRightScrollLeft = checkEdgeRightScrollLeft(checkEdgeLeftScrollLeft(checkEdgeRightScrollRight(checkEdgeLeftScrollRight(i3, iArr, i5), iArr, i5), iArr, i5), iArr, i5);
        if (iCheckEdgeBottomScrollUp == i4 && iCheckEdgeRightScrollLeft == i3 && this.mState == 5) {
            checkStopTargetFling(view, iCheckEdgeRightScrollLeft, iCheckEdgeBottomScrollUp, i5);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, i5, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        int leftAndRightOffset = this.mTargetOffsetHelper.getLeftAndRightOffset();
        int topAndBottomOffset = this.mTargetOffsetHelper.getTopAndBottomOffset();
        if (this.mLeftPullAction != null && isEdgeEnabled(1)) {
            if (f < 0.0f && !this.mTargetView.canScrollHorizontally(-1)) {
                this.mState = 6;
                this.mScroller.fling(leftAndRightOffset, topAndBottomOffset, (int) (-(f / this.mNestedPreFlingVelocityScaleDown)), 0, 0, this.mLeftPullAction.isCanOverPull() ? Integer.MAX_VALUE : this.mLeftPullAction.getTargetTriggerOffset(), topAndBottomOffset, topAndBottomOffset);
                postInvalidateOnAnimation();
                return true;
            }
            if (f > 0.0f && leftAndRightOffset > 0) {
                this.mState = 4;
                this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, -leftAndRightOffset, 0, scrollDuration(this.mLeftPullAction, leftAndRightOffset));
                postInvalidateOnAnimation();
                return true;
            }
        }
        if (this.mRightPullAction != null && isEdgeEnabled(4)) {
            if (f > 0.0f && !this.mTargetView.canScrollHorizontally(1)) {
                this.mState = 6;
                this.mScroller.fling(leftAndRightOffset, topAndBottomOffset, (int) (-(f / this.mNestedPreFlingVelocityScaleDown)), 0, this.mRightPullAction.isCanOverPull() ? Integer.MIN_VALUE : -this.mRightPullAction.getTargetTriggerOffset(), 0, topAndBottomOffset, topAndBottomOffset);
                postInvalidateOnAnimation();
                return true;
            }
            if (f < 0.0f && leftAndRightOffset < 0) {
                this.mState = 4;
                this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, -leftAndRightOffset, 0, scrollDuration(this.mRightPullAction, leftAndRightOffset));
                postInvalidateOnAnimation();
                return true;
            }
        }
        if (this.mTopPullAction != null && isEdgeEnabled(2)) {
            if (f2 < 0.0f && !this.mTargetView.canScrollVertically(-1)) {
                this.mState = 6;
                this.mScroller.fling(leftAndRightOffset, topAndBottomOffset, 0, (int) (-(f2 / this.mNestedPreFlingVelocityScaleDown)), leftAndRightOffset, leftAndRightOffset, 0, this.mTopPullAction.isCanOverPull() ? Integer.MAX_VALUE : this.mTopPullAction.getTargetTriggerOffset());
                postInvalidateOnAnimation();
                return true;
            }
            if (f2 > 0.0f && topAndBottomOffset > 0) {
                this.mState = 4;
                this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, 0, -topAndBottomOffset, scrollDuration(this.mTopPullAction, topAndBottomOffset));
                postInvalidateOnAnimation();
                return true;
            }
        }
        if (this.mBottomPullAction != null && isEdgeEnabled(8)) {
            if (f2 > 0.0f && !this.mTargetView.canScrollVertically(1)) {
                this.mState = 6;
                this.mScroller.fling(leftAndRightOffset, topAndBottomOffset, 0, (int) (-(f2 / this.mNestedPreFlingVelocityScaleDown)), leftAndRightOffset, leftAndRightOffset, this.mBottomPullAction.isCanOverPull() ? Integer.MIN_VALUE : -this.mBottomPullAction.getTargetTriggerOffset(), 0);
                postInvalidateOnAnimation();
                return true;
            }
            if (f2 < 0.0f && topAndBottomOffset < 0) {
                this.mState = 4;
                this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, 0, -topAndBottomOffset, scrollDuration(this.mBottomPullAction, topAndBottomOffset));
                postInvalidateOnAnimation();
                return true;
            }
        }
        this.mState = 5;
        return super.onNestedPreFling(view, f, f2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        int i2 = this.mState;
        if (i2 == 1) {
            checkScrollToTargetOffsetOrInitOffset(false);
        } else {
            if (i2 != 5 || i == 0) {
                return;
            }
            removeStopTargetFlingRunnable();
            checkScrollToTargetOffsetOrInitOffset(false);
        }
    }

    private int scrollDuration(PullAction pullAction, int i) {
        return Math.max(this.mMinScrollDuration, Math.abs((int) (pullAction.mScrollSpeedPerPixel * i)));
    }

    private void onActionTriggered(PullAction pullAction) {
        if (pullAction.mIsActionRunning) {
            return;
        }
        pullAction.mIsActionRunning = true;
        ActionListener actionListener = this.mActionListener;
        if (actionListener != null) {
            actionListener.onActionTriggered(pullAction);
        }
        if (pullAction.mActionView instanceof ActionPullWatcherView) {
            ((ActionPullWatcherView) pullAction.mActionView).onActionTriggered();
        }
    }

    public void finishActionRun(PullAction pullAction) {
        finishActionRun(pullAction, true);
    }

    public void finishActionRun(PullAction pullAction, boolean z) {
        PullAction pullAction2;
        PullAction pullAction3;
        PullAction pullAction4;
        PullAction pullAction5;
        if (pullAction != getPullAction(pullAction.mPullEdge)) {
            return;
        }
        pullAction.mIsActionRunning = false;
        if (pullAction.mActionView instanceof ActionPullWatcherView) {
            ((ActionPullWatcherView) pullAction.mActionView).onActionFinished();
        }
        if (this.mState == 1) {
            return;
        }
        if (!z) {
            this.mState = 0;
            setVerOffsetToTargetOffsetHelper(0);
            setHorOffsetToTargetOffsetHelper(0);
            return;
        }
        this.mState = 4;
        int pullEdge = pullAction.getPullEdge();
        int topAndBottomOffset = this.mTargetOffsetHelper.getTopAndBottomOffset();
        int leftAndRightOffset = this.mTargetOffsetHelper.getLeftAndRightOffset();
        if (pullEdge == 2 && (pullAction5 = this.mTopPullAction) != null && topAndBottomOffset > 0) {
            this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, 0, -topAndBottomOffset, scrollDuration(pullAction5, topAndBottomOffset));
            postInvalidateOnAnimation();
            return;
        }
        if (pullEdge == 8 && (pullAction4 = this.mBottomPullAction) != null && topAndBottomOffset < 0) {
            this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, 0, -topAndBottomOffset, scrollDuration(pullAction4, topAndBottomOffset));
            postInvalidateOnAnimation();
            return;
        }
        if (pullEdge == 1 && (pullAction3 = this.mLeftPullAction) != null && leftAndRightOffset > 0) {
            this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, -leftAndRightOffset, 0, scrollDuration(pullAction3, leftAndRightOffset));
            postInvalidateOnAnimation();
        } else {
            if (pullEdge != 4 || (pullAction2 = this.mRightPullAction) == null || leftAndRightOffset >= 0) {
                return;
            }
            this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, -leftAndRightOffset, 0, scrollDuration(pullAction2, leftAndRightOffset));
            postInvalidateOnAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkScrollToTargetOffsetOrInitOffset(boolean z) {
        if (this.mTargetView == null) {
            return;
        }
        this.mScroller.abortAnimation();
        int leftAndRightOffset = this.mTargetOffsetHelper.getLeftAndRightOffset();
        int topAndBottomOffset = this.mTargetOffsetHelper.getTopAndBottomOffset();
        int i = 0;
        if (this.mLeftPullAction != null && isEdgeEnabled(1) && leftAndRightOffset > 0) {
            this.mState = 4;
            if (!z) {
                int targetTriggerOffset = this.mLeftPullAction.getTargetTriggerOffset();
                if (leftAndRightOffset == targetTriggerOffset) {
                    onActionTriggered(this.mLeftPullAction);
                    return;
                }
                if (leftAndRightOffset > targetTriggerOffset) {
                    if (!this.mLeftPullAction.mScrollToTriggerOffsetAfterTouchUp) {
                        this.mState = 3;
                        onActionTriggered(this.mLeftPullAction);
                        return;
                    } else {
                        if (!this.mLeftPullAction.mTriggerUntilScrollToTriggerOffset) {
                            this.mState = 3;
                            onActionTriggered(this.mLeftPullAction);
                        } else {
                            this.mState = 2;
                        }
                        i = targetTriggerOffset;
                    }
                }
            }
            int i2 = i - leftAndRightOffset;
            this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, i2, 0, scrollDuration(this.mLeftPullAction, i2));
            postInvalidateOnAnimation();
            return;
        }
        if (this.mRightPullAction != null && isEdgeEnabled(4) && leftAndRightOffset < 0) {
            this.mState = 4;
            if (!z) {
                int i3 = -this.mRightPullAction.getTargetTriggerOffset();
                if (leftAndRightOffset == i3) {
                    this.mState = 3;
                    onActionTriggered(this.mRightPullAction);
                    return;
                } else if (leftAndRightOffset < i3) {
                    if (!this.mRightPullAction.mScrollToTriggerOffsetAfterTouchUp) {
                        this.mState = 3;
                        onActionTriggered(this.mRightPullAction);
                        return;
                    } else {
                        if (!this.mRightPullAction.mTriggerUntilScrollToTriggerOffset) {
                            this.mState = 3;
                            onActionTriggered(this.mRightPullAction);
                        } else {
                            this.mState = 2;
                        }
                        i = i3;
                    }
                }
            }
            int i4 = i - leftAndRightOffset;
            this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, i4, 0, scrollDuration(this.mRightPullAction, i4));
            postInvalidateOnAnimation();
            return;
        }
        if (this.mTopPullAction != null && isEdgeEnabled(2) && topAndBottomOffset > 0) {
            this.mState = 4;
            if (!z) {
                int targetTriggerOffset2 = this.mTopPullAction.getTargetTriggerOffset();
                if (topAndBottomOffset == targetTriggerOffset2) {
                    this.mState = 3;
                    onActionTriggered(this.mTopPullAction);
                    return;
                } else if (topAndBottomOffset > targetTriggerOffset2) {
                    if (!this.mTopPullAction.mScrollToTriggerOffsetAfterTouchUp) {
                        this.mState = 3;
                        onActionTriggered(this.mTopPullAction);
                        return;
                    } else {
                        if (!this.mTopPullAction.mTriggerUntilScrollToTriggerOffset) {
                            this.mState = 3;
                            onActionTriggered(this.mTopPullAction);
                        } else {
                            this.mState = 2;
                        }
                        i = targetTriggerOffset2;
                    }
                }
            }
            int i5 = i - topAndBottomOffset;
            this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, leftAndRightOffset, i5, scrollDuration(this.mTopPullAction, i5));
            postInvalidateOnAnimation();
            return;
        }
        if (this.mBottomPullAction != null && isEdgeEnabled(8) && topAndBottomOffset < 0) {
            this.mState = 4;
            if (!z) {
                int i6 = -this.mBottomPullAction.getTargetTriggerOffset();
                if (topAndBottomOffset == i6) {
                    onActionTriggered(this.mBottomPullAction);
                    return;
                }
                if (topAndBottomOffset < i6) {
                    if (!this.mBottomPullAction.mScrollToTriggerOffsetAfterTouchUp) {
                        this.mState = 3;
                        onActionTriggered(this.mBottomPullAction);
                        return;
                    } else {
                        if (!this.mBottomPullAction.mTriggerUntilScrollToTriggerOffset) {
                            this.mState = 3;
                            onActionTriggered(this.mBottomPullAction);
                        } else {
                            this.mState = 2;
                        }
                        i = i6;
                    }
                }
            }
            int i7 = i - topAndBottomOffset;
            this.mScroller.startScroll(leftAndRightOffset, topAndBottomOffset, leftAndRightOffset, i7, scrollDuration(this.mBottomPullAction, i7));
            postInvalidateOnAnimation();
            return;
        }
        this.mState = 0;
    }

    private void removeStopTargetFlingRunnable() {
        Runnable runnable = this.mStopTargetFlingRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.mStopTargetFlingRunnable = null;
        }
    }

    private void checkStopTargetFling(final View view, int i, int i2, int i3) {
        if (this.mStopTargetFlingRunnable != null || i3 == 0) {
            return;
        }
        if ((i2 >= 0 || this.mTargetView.canScrollVertically(-1)) && ((i2 <= 0 || this.mTargetView.canScrollVertically(1)) && ((i >= 0 || this.mTargetView.canScrollHorizontally(-1)) && (i <= 0 || this.mTargetView.canScrollHorizontally(1))))) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.1
            @Override // java.lang.Runnable
            public void run() {
                QMUIPullLayout.this.mStopTargetViewFlingImpl.stopFling(view);
                QMUIPullLayout.this.mStopTargetFlingRunnable = null;
                QMUIPullLayout.this.checkScrollToTargetOffsetOrInitOffset(false);
            }
        };
        this.mStopTargetFlingRunnable = runnable;
        post(runnable);
    }

    private void setHorOffsetToTargetOffsetHelper(int i) {
        this.mTargetOffsetHelper.setLeftAndRightOffset(i);
        onTargetViewLeftAndRightOffsetChanged(i);
        PullAction pullAction = this.mLeftPullAction;
        if (pullAction != null) {
            pullAction.onTargetMoved(i);
            if (this.mLeftPullAction.mActionView instanceof ActionPullWatcherView) {
                ((ActionPullWatcherView) this.mLeftPullAction.mActionView).onPull(this.mLeftPullAction, i);
            }
        }
        PullAction pullAction2 = this.mRightPullAction;
        if (pullAction2 != null) {
            int i2 = -i;
            pullAction2.onTargetMoved(i2);
            if (this.mRightPullAction.mActionView instanceof ActionPullWatcherView) {
                ((ActionPullWatcherView) this.mRightPullAction.mActionView).onPull(this.mRightPullAction, i2);
            }
        }
    }

    private void setVerOffsetToTargetOffsetHelper(int i) {
        this.mTargetOffsetHelper.setTopAndBottomOffset(i);
        onTargetViewTopAndBottomOffsetChanged(i);
        PullAction pullAction = this.mTopPullAction;
        if (pullAction != null) {
            pullAction.onTargetMoved(i);
            if (this.mTopPullAction.mActionView instanceof ActionPullWatcherView) {
                ((ActionPullWatcherView) this.mTopPullAction.mActionView).onPull(this.mTopPullAction, i);
            }
        }
        PullAction pullAction2 = this.mBottomPullAction;
        if (pullAction2 != null) {
            int i2 = -i;
            pullAction2.onTargetMoved(i2);
            if (this.mBottomPullAction.mActionView instanceof ActionPullWatcherView) {
                ((ActionPullWatcherView) this.mBottomPullAction.mActionView).onPull(this.mBottomPullAction, i2);
            }
        }
    }

    private int checkEdgeTopScrollDown(int i, int[] iArr, int i2) {
        int topAndBottomOffset = this.mTargetOffsetHelper.getTopAndBottomOffset();
        if (i > 0 && isEdgeEnabled(2) && topAndBottomOffset > 0) {
            float pullRate = i2 == 0 ? this.mTopPullAction.getPullRate() : 1.0f;
            int i3 = (int) (i * pullRate);
            if (i3 == 0) {
                return i;
            }
            int i4 = 0;
            if (topAndBottomOffset >= i3) {
                iArr[1] = iArr[1] + i;
                i = 0;
                i4 = topAndBottomOffset - i3;
            } else {
                int i5 = (int) (topAndBottomOffset / pullRate);
                iArr[1] = iArr[1] + i5;
                i -= i5;
            }
            setVerOffsetToTargetOffsetHelper(i4);
        }
        return i;
    }

    private int checkEdgeTopScrollUp(int i, int[] iArr, int i2) {
        int targetTriggerOffset;
        if (i < 0 && isEdgeEnabled(2) && !this.mTargetView.canScrollVertically(-1) && (i2 == 0 || this.mTopPullAction.mNeedReceiveFlingFromTargetView)) {
            int topAndBottomOffset = this.mTargetOffsetHelper.getTopAndBottomOffset();
            float pullRate = i2 == 0 ? this.mTopPullAction.getPullRate() : this.mTopPullAction.getFlingRate(topAndBottomOffset);
            int i3 = (int) (i * pullRate);
            if (i3 == 0) {
                return i;
            }
            if (this.mTopPullAction.mCanOverPull || (-i3) <= this.mTopPullAction.getTargetTriggerOffset() - topAndBottomOffset) {
                iArr[1] = iArr[1] + i;
                i = 0;
                targetTriggerOffset = topAndBottomOffset - i3;
            } else {
                int targetTriggerOffset2 = (int) ((topAndBottomOffset - this.mTopPullAction.getTargetTriggerOffset()) / pullRate);
                iArr[1] = iArr[1] + targetTriggerOffset2;
                i -= targetTriggerOffset2;
                targetTriggerOffset = this.mBottomPullAction.getTargetTriggerOffset();
            }
            setVerOffsetToTargetOffsetHelper(targetTriggerOffset);
        }
        return i;
    }

    private int checkEdgeBottomScrollDown(int i, int[] iArr, int i2) {
        int i3;
        if (i > 0 && isEdgeEnabled(8) && !this.mTargetView.canScrollVertically(1) && (i2 == 0 || this.mBottomPullAction.mNeedReceiveFlingFromTargetView)) {
            int topAndBottomOffset = this.mTargetOffsetHelper.getTopAndBottomOffset();
            float pullRate = i2 == 0 ? this.mBottomPullAction.getPullRate() : this.mBottomPullAction.getFlingRate(-topAndBottomOffset);
            int i4 = (int) (i * pullRate);
            if (i4 == 0) {
                return i;
            }
            if (this.mBottomPullAction.mCanOverPull || topAndBottomOffset - i4 >= (-this.mBottomPullAction.getTargetTriggerOffset())) {
                iArr[1] = iArr[1] + i;
                i = 0;
                i3 = topAndBottomOffset - i4;
            } else {
                int i5 = (int) (((-this.mBottomPullAction.getTargetTriggerOffset()) - topAndBottomOffset) / pullRate);
                iArr[1] = iArr[1] + i5;
                i -= i5;
                i3 = -this.mBottomPullAction.getTargetTriggerOffset();
            }
            setVerOffsetToTargetOffsetHelper(i3);
        }
        return i;
    }

    private int checkEdgeBottomScrollUp(int i, int[] iArr, int i2) {
        int topAndBottomOffset = this.mTargetOffsetHelper.getTopAndBottomOffset();
        if (i < 0 && isEdgeEnabled(8) && topAndBottomOffset < 0) {
            float pullRate = i2 == 0 ? this.mBottomPullAction.getPullRate() : 1.0f;
            int i3 = (int) (i * pullRate);
            if (i3 == 0) {
                return i;
            }
            int i4 = 0;
            if (topAndBottomOffset <= i3) {
                iArr[1] = iArr[1] + i;
                i = 0;
                i4 = topAndBottomOffset - i3;
            } else {
                int i5 = (int) (topAndBottomOffset / pullRate);
                iArr[1] = iArr[1] + i5;
                i -= i5;
            }
            setVerOffsetToTargetOffsetHelper(i4);
        }
        return i;
    }

    private int checkEdgeLeftScrollRight(int i, int[] iArr, int i2) {
        int leftAndRightOffset = this.mTargetOffsetHelper.getLeftAndRightOffset();
        if (i > 0 && isEdgeEnabled(1) && leftAndRightOffset > 0) {
            float pullRate = i2 == 0 ? this.mLeftPullAction.getPullRate() : 1.0f;
            int i3 = (int) (i * pullRate);
            if (i3 == 0) {
                return i;
            }
            int i4 = 0;
            if (leftAndRightOffset >= i3) {
                iArr[0] = iArr[0] + i;
                i = 0;
                i4 = leftAndRightOffset - i3;
            } else {
                int i5 = (int) (leftAndRightOffset / pullRate);
                iArr[0] = iArr[0] + i5;
                i -= i5;
            }
            setHorOffsetToTargetOffsetHelper(i4);
        }
        return i;
    }

    private int checkEdgeLeftScrollLeft(int i, int[] iArr, int i2) {
        int targetTriggerOffset;
        int leftAndRightOffset = this.mTargetOffsetHelper.getLeftAndRightOffset();
        if (i < 0 && isEdgeEnabled(1) && !this.mTargetView.canScrollHorizontally(-1) && (i2 == 0 || this.mLeftPullAction.mNeedReceiveFlingFromTargetView)) {
            float pullRate = i2 == 0 ? this.mLeftPullAction.getPullRate() : this.mLeftPullAction.getFlingRate(leftAndRightOffset);
            int i3 = (int) (i * pullRate);
            if (i3 == 0) {
                return i;
            }
            if (this.mLeftPullAction.mCanOverPull || (-i3) <= this.mLeftPullAction.getTargetTriggerOffset() - leftAndRightOffset) {
                iArr[0] = iArr[0] + i;
                targetTriggerOffset = leftAndRightOffset - i3;
                i = 0;
            } else {
                int targetTriggerOffset2 = (int) ((leftAndRightOffset - this.mLeftPullAction.getTargetTriggerOffset()) / pullRate);
                iArr[0] = iArr[0] + targetTriggerOffset2;
                i -= targetTriggerOffset2;
                targetTriggerOffset = this.mLeftPullAction.getTargetTriggerOffset();
            }
            setHorOffsetToTargetOffsetHelper(targetTriggerOffset);
        }
        return i;
    }

    private int checkEdgeRightScrollRight(int i, int[] iArr, int i2) {
        int i3;
        if (i > 0 && isEdgeEnabled(4) && !this.mTargetView.canScrollHorizontally(1) && (i2 == 0 || this.mRightPullAction.mNeedReceiveFlingFromTargetView)) {
            int leftAndRightOffset = this.mTargetOffsetHelper.getLeftAndRightOffset();
            float pullRate = i2 == 0 ? this.mRightPullAction.getPullRate() : this.mRightPullAction.getFlingRate(-leftAndRightOffset);
            int i4 = (int) (i * pullRate);
            if (i4 == 0) {
                return i;
            }
            if (this.mRightPullAction.mCanOverPull || leftAndRightOffset - i4 >= (-this.mRightPullAction.getTargetTriggerOffset())) {
                iArr[0] = iArr[0] + i;
                i3 = leftAndRightOffset - i4;
                i = 0;
            } else {
                int i5 = (int) (((-this.mRightPullAction.getTargetTriggerOffset()) - leftAndRightOffset) / pullRate);
                iArr[0] = iArr[0] + i5;
                i -= i5;
                i3 = -this.mRightPullAction.getTargetTriggerOffset();
            }
            setHorOffsetToTargetOffsetHelper(i3);
        }
        return i;
    }

    private int checkEdgeRightScrollLeft(int i, int[] iArr, int i2) {
        int leftAndRightOffset = this.mTargetOffsetHelper.getLeftAndRightOffset();
        if (i < 0 && isEdgeEnabled(4) && leftAndRightOffset < 0) {
            float pullRate = i2 == 0 ? this.mRightPullAction.getPullRate() : 1.0f;
            int i3 = (int) (i * pullRate);
            if (i3 == 0) {
                return i;
            }
            int i4 = 0;
            if (leftAndRightOffset <= i) {
                iArr[0] = iArr[0] + i;
                i = 0;
                i4 = leftAndRightOffset - i3;
            } else {
                int i5 = (int) (leftAndRightOffset / pullRate);
                iArr[0] = iArr[0] + i5;
                i -= i5;
            }
            setHorOffsetToTargetOffsetHelper(i4);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public int actionInitOffset;
        public boolean canOverPull;
        public int edge;
        public boolean isTarget;
        public boolean needReceiveFlingFromTarget;
        public float pullRate;
        public float receivedFlingFraction;
        public float scrollSpeedPerPixel;
        public boolean scrollToTriggerOffsetAfterTouchUp;
        public int targetTriggerOffset;
        public boolean triggerUntilScrollToTriggerOffset;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.isTarget = false;
            this.edge = 2;
            this.targetTriggerOffset = -2;
            this.canOverPull = false;
            this.pullRate = 0.45f;
            this.needReceiveFlingFromTarget = true;
            this.receivedFlingFraction = 0.002f;
            this.actionInitOffset = 0;
            this.scrollSpeedPerPixel = 1.5f;
            this.triggerUntilScrollToTriggerOffset = false;
            this.scrollToTriggerOffsetAfterTouchUp = true;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIPullLayout_Layout);
            boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIPullLayout_Layout_qmui_is_target, false);
            this.isTarget = z;
            if (!z) {
                this.edge = typedArrayObtainStyledAttributes.getInteger(R.styleable.QMUIPullLayout_Layout_qmui_pull_edge, 2);
                try {
                    this.targetTriggerOffset = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLayout_Layout_qmui_target_view_trigger_offset, -2);
                } catch (Exception unused) {
                    if (typedArrayObtainStyledAttributes.getInt(R.styleable.QMUIPullLayout_Layout_qmui_target_view_trigger_offset, -2) == -2) {
                        this.targetTriggerOffset = -2;
                    }
                }
                this.canOverPull = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIPullLayout_Layout_qmui_can_over_pull, false);
                this.pullRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.QMUIPullLayout_Layout_qmui_pull_rate, this.pullRate);
                this.needReceiveFlingFromTarget = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIPullLayout_Layout_qmui_need_receive_fling_from_target_view, true);
                this.receivedFlingFraction = typedArrayObtainStyledAttributes.getFloat(R.styleable.QMUIPullLayout_Layout_qmui_received_fling_fraction, this.receivedFlingFraction);
                this.actionInitOffset = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIPullLayout_Layout_qmui_action_view_init_offset, 0);
                this.scrollSpeedPerPixel = typedArrayObtainStyledAttributes.getFloat(R.styleable.QMUIPullLayout_Layout_qmui_scroll_speed_per_pixel, this.scrollSpeedPerPixel);
                this.triggerUntilScrollToTriggerOffset = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIPullLayout_Layout_qmui_trigger_until_scroll_to_trigger_offset, false);
                this.scrollToTriggerOffsetAfterTouchUp = typedArrayObtainStyledAttributes.getBoolean(R.styleable.QMUIPullLayout_Layout_qmui_scroll_to_trigger_offset_after_touch_up, true);
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.isTarget = false;
            this.edge = 2;
            this.targetTriggerOffset = -2;
            this.canOverPull = false;
            this.pullRate = 0.45f;
            this.needReceiveFlingFromTarget = true;
            this.receivedFlingFraction = 0.002f;
            this.actionInitOffset = 0;
            this.scrollSpeedPerPixel = 1.5f;
            this.triggerUntilScrollToTriggerOffset = false;
            this.scrollToTriggerOffsetAfterTouchUp = true;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.isTarget = false;
            this.edge = 2;
            this.targetTriggerOffset = -2;
            this.canOverPull = false;
            this.pullRate = 0.45f;
            this.needReceiveFlingFromTarget = true;
            this.receivedFlingFraction = 0.002f;
            this.actionInitOffset = 0;
            this.scrollSpeedPerPixel = 1.5f;
            this.triggerUntilScrollToTriggerOffset = false;
            this.scrollToTriggerOffsetAfterTouchUp = true;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.isTarget = false;
            this.edge = 2;
            this.targetTriggerOffset = -2;
            this.canOverPull = false;
            this.pullRate = 0.45f;
            this.needReceiveFlingFromTarget = true;
            this.receivedFlingFraction = 0.002f;
            this.actionInitOffset = 0;
            this.scrollSpeedPerPixel = 1.5f;
            this.triggerUntilScrollToTriggerOffset = false;
            this.scrollToTriggerOffsetAfterTouchUp = true;
        }
    }

    public static final class PullAction {
        private final int mActionInitOffset;
        private final View mActionView;
        private final ActionViewOffsetCalculator mActionViewOffsetCalculator;
        private final boolean mCanOverPull;
        private boolean mIsActionRunning = false;
        private final boolean mNeedReceiveFlingFromTargetView;
        private final int mPullEdge;
        private final float mPullRate;
        private final float mReceivedFlingFraction;
        private final float mScrollSpeedPerPixel;
        private final boolean mScrollToTriggerOffsetAfterTouchUp;
        private final int mTargetTriggerOffset;
        private final boolean mTriggerUntilScrollToTriggerOffset;
        private final QMUIViewOffsetHelper mViewOffsetHelper;

        PullAction(View view, int i, boolean z, float f, int i2, int i3, float f2, boolean z2, float f3, boolean z3, boolean z4, ActionViewOffsetCalculator actionViewOffsetCalculator) {
            this.mActionView = view;
            this.mTargetTriggerOffset = i;
            this.mCanOverPull = z;
            this.mPullRate = f;
            this.mNeedReceiveFlingFromTargetView = z2;
            this.mReceivedFlingFraction = f3;
            this.mActionInitOffset = i2;
            this.mScrollSpeedPerPixel = f2;
            this.mPullEdge = i3;
            this.mTriggerUntilScrollToTriggerOffset = z3;
            this.mScrollToTriggerOffsetAfterTouchUp = z4;
            this.mActionViewOffsetCalculator = actionViewOffsetCalculator;
            this.mViewOffsetHelper = new QMUIViewOffsetHelper(view);
            updateOffset(i2);
        }

        public int getActionPullSize() {
            int i = this.mPullEdge;
            if (i == 2 || i == 8) {
                return this.mActionView.getHeight();
            }
            return this.mActionView.getWidth();
        }

        public int getActionInitOffset() {
            return this.mActionInitOffset;
        }

        public int getTargetTriggerOffset() {
            int i = this.mTargetTriggerOffset;
            return i == -2 ? getActionPullSize() - (getActionInitOffset() * 2) : i;
        }

        public float getScrollSpeedPerPixel() {
            return this.mScrollSpeedPerPixel;
        }

        public float getPullRate() {
            return this.mPullRate;
        }

        public boolean isNeedReceiveFlingFromTargetView() {
            return this.mNeedReceiveFlingFromTargetView;
        }

        public boolean isScrollToTriggerOffsetAfterTouchUp() {
            return this.mScrollToTriggerOffsetAfterTouchUp;
        }

        public boolean isTriggerUntilScrollToTriggerOffset() {
            return this.mTriggerUntilScrollToTriggerOffset;
        }

        public float getFlingRate(int i) {
            float f = this.mPullRate;
            return Math.min(f, Math.max(f - ((i - getTargetTriggerOffset()) * this.mReceivedFlingFraction), 0.0f));
        }

        public boolean isCanOverPull() {
            return this.mCanOverPull;
        }

        public int getPullEdge() {
            return this.mPullEdge;
        }

        void updateOffset(int i) {
            int i2 = this.mPullEdge;
            if (i2 == 1) {
                this.mViewOffsetHelper.setLeftAndRightOffset(i);
                return;
            }
            if (i2 == 2) {
                this.mViewOffsetHelper.setTopAndBottomOffset(i);
            } else if (i2 == 4) {
                this.mViewOffsetHelper.setLeftAndRightOffset(-i);
            } else {
                this.mViewOffsetHelper.setTopAndBottomOffset(-i);
            }
        }

        void onTargetMoved(int i) {
            updateOffset(this.mActionViewOffsetCalculator.calculateOffset(this, i));
        }
    }

    public static class PullActionBuilder {
        private int mActionInitOffset;
        private final View mActionView;
        private ActionViewOffsetCalculator mActionViewOffsetCalculator;
        private boolean mCanOverPull;
        private int mPullEdge;
        private int mTargetTriggerOffset = -2;
        private float mPullRate = 0.45f;
        private boolean mNeedReceiveFlingFromTargetView = true;
        private float mReceivedFlingFraction = 0.002f;
        private float mScrollSpeedPerPixel = 1.5f;
        private boolean mTriggerUntilScrollToTriggerOffset = false;
        private boolean mScrollToTriggerOffsetAfterTouchUp = true;

        public PullActionBuilder(View view, int i) {
            this.mActionView = view;
            this.mPullEdge = i;
        }

        public PullActionBuilder triggerUntilScrollToTriggerOffset(boolean z) {
            this.mTriggerUntilScrollToTriggerOffset = z;
            return this;
        }

        public PullActionBuilder scrollToTriggerOffsetAfterTouchUp(boolean z) {
            this.mScrollToTriggerOffsetAfterTouchUp = z;
            return this;
        }

        public PullActionBuilder targetTriggerOffset(int i) {
            this.mTargetTriggerOffset = i;
            return this;
        }

        public PullActionBuilder canOverPull(boolean z) {
            this.mCanOverPull = z;
            return this;
        }

        public PullActionBuilder receivedFlingFraction(float f) {
            this.mReceivedFlingFraction = f;
            return this;
        }

        public PullActionBuilder needReceiveFlingFromTargetView(boolean z) {
            this.mNeedReceiveFlingFromTargetView = z;
            return this;
        }

        public PullActionBuilder pullRate(float f) {
            this.mPullRate = f;
            return this;
        }

        public PullActionBuilder scrollSpeedPerPixel(float f) {
            this.mScrollSpeedPerPixel = f;
            return this;
        }

        public PullActionBuilder actionInitOffset(int i) {
            this.mActionInitOffset = i;
            return this;
        }

        public PullActionBuilder actionViewOffsetCalculator(ActionViewOffsetCalculator actionViewOffsetCalculator) {
            this.mActionViewOffsetCalculator = actionViewOffsetCalculator;
            return this;
        }

        PullAction build() {
            if (this.mActionViewOffsetCalculator == null) {
                this.mActionViewOffsetCalculator = new QMUIAlwaysFollowOffsetCalculator();
            }
            return new PullAction(this.mActionView, this.mTargetTriggerOffset, this.mCanOverPull, this.mPullRate, this.mActionInitOffset, this.mPullEdge, this.mScrollSpeedPerPixel, this.mNeedReceiveFlingFromTargetView, this.mReceivedFlingFraction, this.mTriggerUntilScrollToTriggerOffset, this.mScrollToTriggerOffsetAfterTouchUp, this.mActionViewOffsetCalculator);
        }
    }

    public static class DefaultStopTargetViewFlingImpl implements StopTargetViewFlingImpl {
        private static DefaultStopTargetViewFlingImpl sInstance;

        public static DefaultStopTargetViewFlingImpl getInstance() {
            if (sInstance == null) {
                sInstance = new DefaultStopTargetViewFlingImpl();
            }
            return sInstance;
        }

        private DefaultStopTargetViewFlingImpl() {
        }

        @Override // com.qmuiteam.qmui.widget.pullLayout.QMUIPullLayout.StopTargetViewFlingImpl
        public void stopFling(View view) {
            if (view instanceof RecyclerView) {
                ((RecyclerView) view).stopScroll();
            }
        }
    }
}
