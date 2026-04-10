package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.QMUIInterpolatorStaticHolder;
import com.qmuiteam.qmui.layout.QMUIFrameLayout;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.util.QMUIViewOffsetHelper;

/* JADX INFO: loaded from: classes4.dex */
public abstract class QMUIContinuousNestedBottomDelegateLayout extends QMUIFrameLayout implements NestedScrollingChild2, NestedScrollingParent2, IQMUIContinuousNestedBottomView {
    private static final int INVALID_POINTER = -1;
    public static final String KEY_SCROLL_INFO_OFFSET = "@qmui_scroll_info_bottom_dl_offset";
    private int activePointerId;
    private boolean isBeingDragged;
    private int lastMotionY;
    private Runnable mCheckLayoutAction;
    private final NestedScrollingChildHelper mChildHelper;
    private View mContentView;
    private QMUIViewOffsetHelper mContentViewOffsetHelper;
    private View mHeaderView;
    private QMUIViewOffsetHelper mHeaderViewOffsetHelper;
    private int mNestedOffsetY;
    private IQMUIContinuousNestedScrollCommon.OnScrollNotifier mOnScrollNotifier;
    private final NestedScrollingParentHelper mParentHelper;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private Rect mTempRect;
    private final ViewFlinger mViewFlinger;
    private int touchSlop;
    private VelocityTracker velocityTracker;

    protected int getContentBottomMargin() {
        return 0;
    }

    protected int getHeaderHeightLayoutParam() {
        return -2;
    }

    protected int getHeaderStickyHeight() {
        return 0;
    }

    protected abstract View onCreateContentView();

    protected abstract View onCreateHeaderView();

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return (i & 2) != 0;
    }

    public QMUIContinuousNestedBottomDelegateLayout(Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedBottomDelegateLayout(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public QMUIContinuousNestedBottomDelegateLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.activePointerId = -1;
        this.touchSlop = -1;
        this.mScrollConsumed = new int[2];
        this.mScrollOffset = new int[2];
        this.mTempRect = new Rect();
        this.mNestedOffsetY = 0;
        this.mCheckLayoutAction = new Runnable() { // from class: com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.1
            @Override // java.lang.Runnable
            public void run() {
                QMUIContinuousNestedBottomDelegateLayout.this.checkLayout();
            }
        };
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        ViewCompat.setNestedScrollingEnabled(this, true);
        this.mHeaderView = onCreateHeaderView();
        View viewOnCreateContentView = onCreateContentView();
        this.mContentView = viewOnCreateContentView;
        if (!(viewOnCreateContentView instanceof IQMUIContinuousNestedBottomView)) {
            throw new IllegalStateException("the view create by onCreateContentView() should implement from IQMUIContinuousNestedBottomView");
        }
        addView(this.mHeaderView, new FrameLayout.LayoutParams(-1, getHeaderHeightLayoutParam()));
        addView(this.mContentView, new FrameLayout.LayoutParams(-1, -1));
        this.mHeaderViewOffsetHelper = new QMUIViewOffsetHelper(this.mHeaderView);
        this.mContentViewOffsetHelper = new QMUIViewOffsetHelper(this.mContentView);
        this.mViewFlinger = new ViewFlinger();
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public int getOffsetCurrent() {
        return -this.mHeaderViewOffsetHelper.getTopAndBottomOffset();
    }

    public int getOffsetRange() {
        return -getMiniOffset();
    }

    private int getMiniOffset() {
        int contentHeight = ((IQMUIContinuousNestedBottomView) this.mContentView).getContentHeight();
        int headerStickyHeight = ((-this.mHeaderView.getHeight()) - ((FrameLayout.LayoutParams) this.mHeaderView.getLayoutParams()).bottomMargin) + getHeaderStickyHeight();
        return contentHeight != -1 ? Math.min(headerStickyHeight + (this.mContentView.getHeight() - contentHeight), 0) : headerStickyHeight;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getContentHeight() {
        int contentHeight = ((IQMUIContinuousNestedBottomView) this.mContentView).getContentHeight();
        if (contentHeight == -1 || contentHeight > this.mContentView.getHeight()) {
            return -1;
        }
        int contentBottomMargin = getContentBottomMargin();
        if (this.mHeaderView.getHeight() + contentHeight + contentBottomMargin > getHeight()) {
            return -1;
        }
        return this.mHeaderView.getHeight() + contentHeight + contentBottomMargin;
    }

    @Override // com.qmuiteam.qmui.layout.QMUIFrameLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.mContentView.measure(i, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i2) - getHeaderStickyHeight()) - getContentBottomMargin(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.mHeaderView;
        view.layout(0, 0, view.getMeasuredWidth(), this.mHeaderView.getMeasuredHeight());
        int bottom = this.mHeaderView.getBottom();
        View view2 = this.mContentView;
        view2.layout(0, bottom, view2.getMeasuredWidth(), this.mContentView.getMeasuredHeight() + bottom);
        this.mHeaderViewOffsetHelper.onViewLayout();
        this.mContentViewOffsetHelper.onViewLayout();
        postCheckLayout();
    }

    public void postCheckLayout() {
        removeCallbacks(this.mCheckLayoutAction);
        post(this.mCheckLayoutAction);
    }

    public void checkLayout() {
        int offsetCurrent = getOffsetCurrent();
        int offsetRange = getOffsetRange();
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = (IQMUIContinuousNestedBottomView) this.mContentView;
        if (offsetCurrent >= offsetRange || iQMUIContinuousNestedBottomView.getCurrentScroll() <= 0) {
            return;
        }
        iQMUIContinuousNestedBottomView.consumeScroll(Integer.MIN_VALUE);
    }

    private int offsetBy(int i) {
        int iMax;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mHeaderView.getLayoutParams();
        int miniOffset = getMiniOffset();
        if (i > 0) {
            iMax = Math.min(this.mHeaderView.getTop() - miniOffset, i);
        } else {
            iMax = i < 0 ? Math.max(this.mHeaderView.getTop() - layoutParams.topMargin, i) : 0;
        }
        if (iMax != 0) {
            QMUIViewOffsetHelper qMUIViewOffsetHelper = this.mHeaderViewOffsetHelper;
            qMUIViewOffsetHelper.setTopAndBottomOffset(qMUIViewOffsetHelper.getTopAndBottomOffset() - iMax);
            QMUIViewOffsetHelper qMUIViewOffsetHelper2 = this.mContentViewOffsetHelper;
            qMUIViewOffsetHelper2.setTopAndBottomOffset(qMUIViewOffsetHelper2.getTopAndBottomOffset() - iMax);
        }
        this.mOnScrollNotifier.notify(-this.mHeaderViewOffsetHelper.getTopAndBottomOffset(), this.mHeaderView.getHeight() + ((IQMUIContinuousNestedBottomView) this.mContentView).getScrollOffsetRange());
        return i - iMax;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public void consumeScroll(int i) {
        if (i == Integer.MAX_VALUE) {
            offsetBy(i);
            ((IQMUIContinuousNestedBottomView) this.mContentView).consumeScroll(Integer.MAX_VALUE);
        } else if (i == Integer.MIN_VALUE) {
            ((IQMUIContinuousNestedBottomView) this.mContentView).consumeScroll(Integer.MIN_VALUE);
            offsetBy(i);
        } else {
            ((IQMUIContinuousNestedBottomView) this.mContentView).consumeScroll(i);
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public void smoothScrollYBy(int i, int i2) {
        ((IQMUIContinuousNestedBottomView) this.mContentView).smoothScrollYBy(i, i2);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public void stopScroll() {
        ((IQMUIContinuousNestedBottomView) this.mContentView).stopScroll();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getCurrentScroll() {
        return (-this.mHeaderViewOffsetHelper.getTopAndBottomOffset()) + ((IQMUIContinuousNestedBottomView) this.mContentView).getCurrentScroll();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedBottomView
    public int getScrollOffsetRange() {
        if (getContentHeight() != -1) {
            return 0;
        }
        return (this.mHeaderView.getHeight() - getHeaderStickyHeight()) + ((IQMUIContinuousNestedBottomView) this.mContentView).getScrollOffsetRange();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void injectScrollNotifier(final IQMUIContinuousNestedScrollCommon.OnScrollNotifier onScrollNotifier) {
        this.mOnScrollNotifier = onScrollNotifier;
        KeyEvent.Callback callback = this.mContentView;
        if (callback instanceof IQMUIContinuousNestedBottomView) {
            ((IQMUIContinuousNestedBottomView) callback).injectScrollNotifier(new IQMUIContinuousNestedScrollCommon.OnScrollNotifier() { // from class: com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.2
                @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
                public void notify(int i, int i2) {
                    onScrollNotifier.notify(i - QMUIContinuousNestedBottomDelegateLayout.this.mHeaderView.getTop(), i2 + QMUIContinuousNestedBottomDelegateLayout.this.mHeaderView.getHeight());
                }

                @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
                public void onScrollStateChange(View view, int i) {
                    onScrollNotifier.onScrollStateChange(view, i);
                }
            });
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void saveScrollInfo(Bundle bundle) {
        bundle.putInt(KEY_SCROLL_INFO_OFFSET, this.mHeaderViewOffsetHelper.getTopAndBottomOffset());
        KeyEvent.Callback callback = this.mContentView;
        if (callback != null) {
            ((IQMUIContinuousNestedBottomView) callback).saveScrollInfo(bundle);
        }
    }

    @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon
    public void restoreScrollInfo(Bundle bundle) {
        int iConstrain = QMUILangHelper.constrain(bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0), getMiniOffset(), 0);
        this.mHeaderViewOffsetHelper.setTopAndBottomOffset(iConstrain);
        this.mContentViewOffsetHelper.setTopAndBottomOffset(iConstrain);
        KeyEvent.Callback callback = this.mContentView;
        if (callback != null) {
            ((IQMUIContinuousNestedBottomView) callback).restoreScrollInfo(bundle);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return this.mChildHelper.startNestedScroll(i, i2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        this.mChildHelper.stopNestedScroll(i);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return this.mChildHelper.hasNestedScrollingParent(i);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return dispatchNestedScroll(i, i2, i3, i4, iArr, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i, i2);
        startNestedScroll(2, i2);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        this.mParentHelper.onStopNestedScroll(view, i);
        stopNestedScroll(i);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        int iOffsetBy = offsetBy(i4);
        dispatchNestedScroll(0, i4 - iOffsetBy, 0, iOffsetBy, null, i5);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        dispatchNestedPreScroll(i, i2, iArr, null, i3);
        int i4 = iArr[1];
        int i5 = i2 - i4;
        if (i5 > 0) {
            iArr[1] = i4 + (i5 - offsetBy(i5));
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        this.mViewFlinger.fling((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    private boolean isPointInHeaderBounds(int i, int i2) {
        QMUIViewHelper.getDescendantRect(this, this.mHeaderView, this.mTempRect);
        return this.mTempRect.contains(i, i2);
    }

    private void ensureVelocityTracker() {
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r5.touchSlop
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r5.touchSlop = r0
        L12:
            int r0 = r6.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r5.isBeingDragged
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r6.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L86
            r4 = -1
            if (r0 == r2) goto L7e
            if (r0 == r1) goto L5c
            r1 = 3
            if (r0 == r1) goto L7e
            r1 = 5
            if (r0 == r1) goto L33
            goto La8
        L33:
            int r0 = r6.getActionIndex()
            if (r0 == 0) goto L5a
            float r1 = r6.getX()
            int r1 = (int) r1
            float r4 = r6.getY()
            int r4 = (int) r4
            boolean r1 = r5.isPointInHeaderBounds(r1, r4)
            if (r1 != 0) goto L5a
            float r1 = r6.getX(r0)
            int r1 = (int) r1
            float r6 = r6.getY(r0)
            int r6 = (int) r6
            boolean r6 = r5.isPointInHeaderBounds(r1, r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            r2 = r3
        L5b:
            return r2
        L5c:
            int r0 = r5.activePointerId
            if (r0 != r4) goto L61
            goto La8
        L61:
            int r0 = r6.findPointerIndex(r0)
            if (r0 != r4) goto L68
            goto La8
        L68:
            float r6 = r6.getY(r0)
            int r6 = (int) r6
            int r0 = r5.lastMotionY
            int r0 = r6 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r5.touchSlop
            if (r0 <= r1) goto La8
            r5.isBeingDragged = r2
            r5.lastMotionY = r6
            goto La8
        L7e:
            r5.isBeingDragged = r3
            r5.activePointerId = r4
            r5.stopNestedScroll(r3)
            goto La8
        L86:
            com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout$ViewFlinger r0 = r5.mViewFlinger
            r0.stop()
            r5.isBeingDragged = r3
            float r0 = r6.getX()
            int r0 = (int) r0
            float r2 = r6.getY()
            int r2 = (int) r2
            boolean r0 = r5.isPointInHeaderBounds(r0, r2)
            if (r0 == 0) goto La8
            r5.lastMotionY = r2
            int r6 = r6.getPointerId(r3)
            r5.activePointerId = r6
            r5.startNestedScroll(r1, r3)
        La8:
            boolean r6 = r5.isBeingDragged
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedBottomDelegateLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 0) {
            this.mNestedOffsetY = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.mNestedOffsetY);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mViewFlinger.stop();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (!isPointInHeaderBounds(x, y)) {
                return false;
            }
            this.lastMotionY = y;
            this.activePointerId = motionEvent.getPointerId(0);
            ensureVelocityTracker();
            startNestedScroll(2, 0);
        } else {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.velocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEventObtain);
                    this.velocityTracker.computeCurrentVelocity(1000);
                    this.mViewFlinger.fling(-((int) (this.velocityTracker.getYVelocity(this.activePointerId) + 0.5f)));
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                int i = this.lastMotionY - y2;
                if (!this.isBeingDragged) {
                    int iAbs = Math.abs(i);
                    int i2 = this.touchSlop;
                    if (iAbs > i2) {
                        this.isBeingDragged = true;
                        i = i > 0 ? i - i2 : i + i2;
                    }
                }
                if (this.isBeingDragged) {
                    this.lastMotionY = y2;
                    if (i < 0 && ((IQMUIContinuousNestedBottomView) this.mContentView).getCurrentScroll() > 0) {
                        return true;
                    }
                    int[] iArr = this.mScrollConsumed;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    if (dispatchNestedPreScroll(0, i, iArr, this.mScrollOffset)) {
                        i -= this.mScrollConsumed[1];
                        int i3 = this.mScrollOffset[1];
                        this.lastMotionY = y2 - i3;
                        motionEventObtain.offsetLocation(0.0f, i3);
                        this.mNestedOffsetY += this.mScrollOffset[1];
                    }
                    int iOffsetBy = offsetBy(i);
                    if (dispatchNestedScroll(0, i - iOffsetBy, 0, iOffsetBy, this.mScrollOffset, 0)) {
                        int i4 = this.mScrollOffset[1];
                        this.lastMotionY = y2 - i4;
                        motionEventObtain.offsetLocation(0.0f, i4);
                        this.mNestedOffsetY += this.mScrollOffset[1];
                    }
                }
            } else if (actionMasked == 3) {
            }
            this.isBeingDragged = false;
            this.activePointerId = -1;
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.velocityTracker = null;
            }
            stopNestedScroll(0);
        }
        VelocityTracker velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    class ViewFlinger implements Runnable {
        private int mLastFlingY;
        OverScroller mOverScroller;
        Interpolator mInterpolator = QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
        private boolean mEatRunOnAnimationRequest = false;
        private boolean mReSchedulePostAnimationCallback = false;

        ViewFlinger() {
            this.mOverScroller = new OverScroller(QMUIContinuousNestedBottomDelegateLayout.this.getContext(), QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currY = overScroller.getCurrY();
                int i = currY - this.mLastFlingY;
                this.mLastFlingY = currY;
                IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = (IQMUIContinuousNestedBottomView) QMUIContinuousNestedBottomDelegateLayout.this.mContentView;
                if (i <= 0 || iQMUIContinuousNestedBottomView.getCurrentScroll() < iQMUIContinuousNestedBottomView.getScrollOffsetRange()) {
                    if (!QMUIContinuousNestedBottomDelegateLayout.this.mChildHelper.hasNestedScrollingParent(1)) {
                        QMUIContinuousNestedBottomDelegateLayout.this.startNestedScroll(2, 1);
                    }
                    QMUIContinuousNestedBottomDelegateLayout.this.consumeScroll(i);
                    postOnAnimation();
                } else {
                    stop();
                }
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
            } else {
                QMUIContinuousNestedBottomDelegateLayout.this.stopNestedScroll(1);
            }
        }

        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        private void internalPostOnAnimation() {
            QMUIContinuousNestedBottomDelegateLayout.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(QMUIContinuousNestedBottomDelegateLayout.this, this);
        }

        public void fling(int i) {
            QMUIContinuousNestedBottomDelegateLayout.this.startNestedScroll(2, 1);
            this.mLastFlingY = 0;
            if (this.mInterpolator != QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR) {
                this.mInterpolator = QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR;
                this.mOverScroller = new OverScroller(QMUIContinuousNestedBottomDelegateLayout.this.getContext(), QMUIInterpolatorStaticHolder.QUNITIC_INTERPOLATOR);
            }
            this.mOverScroller.fling(0, 0, 0, i, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public void stop() {
            QMUIContinuousNestedBottomDelegateLayout.this.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }
    }
}
