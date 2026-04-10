package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon;
import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior;
import com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar;
import com.qmuiteam.qmui.util.QMUILangHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class QMUIContinuousNestedScrollLayout extends CoordinatorLayout implements QMUIContinuousNestedTopAreaBehavior.Callback, QMUIDraggableScrollBar.Callback {
    public static final String KEY_SCROLL_INFO_OFFSET = "@qmui_nested_scroll_layout_offset";
    private QMUIContinuousNestedBottomAreaBehavior mBottomAreaBehavior;
    private IQMUIContinuousNestedBottomView mBottomView;
    private Runnable mCheckLayoutAction;
    private int mCurrentScrollState;
    private float mDismissDownY;
    private QMUIDraggableScrollBar mDraggableScrollBar;
    private boolean mEnableScrollBarFadeInOut;
    private boolean mIsDismissDownEvent;
    private boolean mIsDraggableScrollBarEnabled;
    private boolean mKeepBottomAreaStableWhenCheckLayout;
    private List<OnScrollListener> mOnScrollListeners;
    private QMUIContinuousNestedTopAreaBehavior mTopAreaBehavior;
    private IQMUIContinuousNestedTopView mTopView;
    private int mTouchSlap;

    /* JADX INFO: loaded from: classes4.dex */
    public interface OnScrollListener {
        void onScroll(QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout, int i, int i2, int i3, int i4, int i5, int i6);

        void onScrollStateChange(QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout, int i, boolean z);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar.Callback
    public void onDragEnd() {
    }

    public QMUIContinuousNestedScrollLayout(Context context) {
        this(context, null);
    }

    public QMUIContinuousNestedScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIContinuousNestedScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOnScrollListeners = new ArrayList();
        this.mCheckLayoutAction = new Runnable() { // from class: com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.1
            @Override // java.lang.Runnable
            public void run() {
                QMUIContinuousNestedScrollLayout.this.checkLayout();
            }
        };
        this.mKeepBottomAreaStableWhenCheckLayout = false;
        this.mEnableScrollBarFadeInOut = true;
        this.mIsDraggableScrollBarEnabled = false;
        this.mCurrentScrollState = 0;
        this.mIsDismissDownEvent = false;
        this.mDismissDownY = 0.0f;
        this.mTouchSlap = -1;
    }

    private void ensureScrollBar() {
        if (this.mDraggableScrollBar == null) {
            QMUIDraggableScrollBar qMUIDraggableScrollBarCreateScrollBar = createScrollBar(getContext());
            this.mDraggableScrollBar = qMUIDraggableScrollBarCreateScrollBar;
            qMUIDraggableScrollBarCreateScrollBar.setEnableFadeInAndOut(this.mEnableScrollBarFadeInOut);
            this.mDraggableScrollBar.setCallback(this);
            CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 5;
            addView(this.mDraggableScrollBar, layoutParams);
        }
    }

    public void setDraggableScrollBarEnabled(boolean z) {
        if (this.mIsDraggableScrollBarEnabled != z) {
            this.mIsDraggableScrollBarEnabled = z;
            if (z && !this.mEnableScrollBarFadeInOut) {
                ensureScrollBar();
                this.mDraggableScrollBar.setPercent(getCurrentScrollPercent());
                this.mDraggableScrollBar.awakenScrollBar();
            }
            QMUIDraggableScrollBar qMUIDraggableScrollBar = this.mDraggableScrollBar;
            if (qMUIDraggableScrollBar != null) {
                qMUIDraggableScrollBar.setVisibility(z ? 0 : 8);
            }
        }
    }

    public void setEnableScrollBarFadeInOut(boolean z) {
        if (this.mEnableScrollBarFadeInOut != z) {
            this.mEnableScrollBarFadeInOut = z;
            if (this.mIsDraggableScrollBarEnabled && !z) {
                ensureScrollBar();
                this.mDraggableScrollBar.setPercent(getCurrentScrollPercent());
                this.mDraggableScrollBar.awakenScrollBar();
            }
            QMUIDraggableScrollBar qMUIDraggableScrollBar = this.mDraggableScrollBar;
            if (qMUIDraggableScrollBar != null) {
                qMUIDraggableScrollBar.setEnableFadeInAndOut(z);
                this.mDraggableScrollBar.invalidate();
            }
        }
    }

    protected QMUIDraggableScrollBar createScrollBar(Context context) {
        return new QMUIDraggableScrollBar(context);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar.Callback
    public void onDragStarted() {
        stopScroll();
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar.Callback
    public void onDragToPercent(float f) {
        scrollBy(((int) (getScrollRange() * f)) - getCurrentScroll());
    }

    public int getCurrentScroll() {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        int currentScroll = (iQMUIContinuousNestedTopView != null ? 0 + iQMUIContinuousNestedTopView.getCurrentScroll() : 0) + getOffsetCurrent();
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        return iQMUIContinuousNestedBottomView != null ? currentScroll + iQMUIContinuousNestedBottomView.getCurrentScroll() : currentScroll;
    }

    public int getScrollRange() {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        int scrollOffsetRange = (iQMUIContinuousNestedTopView != null ? 0 + iQMUIContinuousNestedTopView.getScrollOffsetRange() : 0) + getOffsetRange();
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        return iQMUIContinuousNestedBottomView != null ? scrollOffsetRange + iQMUIContinuousNestedBottomView.getScrollOffsetRange() : scrollOffsetRange;
    }

    public float getCurrentScrollPercent() {
        int scrollRange = getScrollRange();
        if (scrollRange == 0) {
            return 0.0f;
        }
        return (getCurrentScroll() * 1.0f) / scrollRange;
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mOnScrollListeners.contains(onScrollListener)) {
            return;
        }
        this.mOnScrollListeners.add(onScrollListener);
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListeners.remove(onScrollListener);
    }

    public void setKeepBottomAreaStableWhenCheckLayout(boolean z) {
        this.mKeepBottomAreaStableWhenCheckLayout = z;
    }

    public boolean isKeepBottomAreaStableWhenCheckLayout() {
        return this.mKeepBottomAreaStableWhenCheckLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTopAreaView(View view, CoordinatorLayout.LayoutParams layoutParams) {
        if (!(view instanceof IQMUIContinuousNestedTopView)) {
            throw new IllegalStateException("topView must implement from IQMUIContinuousNestedTopView");
        }
        Object obj = this.mTopView;
        if (obj != null) {
            removeView((View) obj);
        }
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = (IQMUIContinuousNestedTopView) view;
        this.mTopView = iQMUIContinuousNestedTopView;
        iQMUIContinuousNestedTopView.injectScrollNotifier(new IQMUIContinuousNestedScrollCommon.OnScrollNotifier() { // from class: com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.2
            @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
            public void onScrollStateChange(View view2, int i) {
            }

            @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
            public void notify(int i, int i2) {
                int i3 = QMUIContinuousNestedScrollLayout.this.mTopAreaBehavior == null ? 0 : -QMUIContinuousNestedScrollLayout.this.mTopAreaBehavior.getTopAndBottomOffset();
                int currentScroll = QMUIContinuousNestedScrollLayout.this.mBottomView == null ? 0 : QMUIContinuousNestedScrollLayout.this.mBottomView.getCurrentScroll();
                int scrollOffsetRange = QMUIContinuousNestedScrollLayout.this.mBottomView != null ? QMUIContinuousNestedScrollLayout.this.mBottomView.getScrollOffsetRange() : 0;
                QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout = QMUIContinuousNestedScrollLayout.this;
                qMUIContinuousNestedScrollLayout.dispatchScroll(i, i2, i3, qMUIContinuousNestedScrollLayout.getOffsetRange(), currentScroll, scrollOffsetRange);
            }
        });
        if (layoutParams == null) {
            layoutParams = new CoordinatorLayout.LayoutParams(-1, -2);
        }
        CoordinatorLayout.Behavior behavior = layoutParams.getBehavior();
        if (behavior instanceof QMUIContinuousNestedTopAreaBehavior) {
            this.mTopAreaBehavior = (QMUIContinuousNestedTopAreaBehavior) behavior;
        } else {
            QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior = new QMUIContinuousNestedTopAreaBehavior(getContext());
            this.mTopAreaBehavior = qMUIContinuousNestedTopAreaBehavior;
            layoutParams.setBehavior(qMUIContinuousNestedTopAreaBehavior);
        }
        this.mTopAreaBehavior.setCallback(this);
        addView(view, 0, layoutParams);
    }

    public IQMUIContinuousNestedTopView getTopView() {
        return this.mTopView;
    }

    public IQMUIContinuousNestedBottomView getBottomView() {
        return this.mBottomView;
    }

    public QMUIContinuousNestedTopAreaBehavior getTopAreaBehavior() {
        return this.mTopAreaBehavior;
    }

    public QMUIContinuousNestedBottomAreaBehavior getBottomAreaBehavior() {
        return this.mBottomAreaBehavior;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBottomAreaView(View view, CoordinatorLayout.LayoutParams layoutParams) {
        if (!(view instanceof IQMUIContinuousNestedBottomView)) {
            throw new IllegalStateException("bottomView must implement from IQMUIContinuousNestedBottomView");
        }
        Object obj = this.mBottomView;
        if (obj != null) {
            removeView((View) obj);
        }
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = (IQMUIContinuousNestedBottomView) view;
        this.mBottomView = iQMUIContinuousNestedBottomView;
        iQMUIContinuousNestedBottomView.injectScrollNotifier(new IQMUIContinuousNestedScrollCommon.OnScrollNotifier() { // from class: com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout.3
            @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
            public void notify(int i, int i2) {
                int currentScroll = QMUIContinuousNestedScrollLayout.this.mTopView == null ? 0 : QMUIContinuousNestedScrollLayout.this.mTopView.getCurrentScroll();
                int scrollOffsetRange = QMUIContinuousNestedScrollLayout.this.mTopView == null ? 0 : QMUIContinuousNestedScrollLayout.this.mTopView.getScrollOffsetRange();
                int i3 = QMUIContinuousNestedScrollLayout.this.mTopAreaBehavior != null ? -QMUIContinuousNestedScrollLayout.this.mTopAreaBehavior.getTopAndBottomOffset() : 0;
                QMUIContinuousNestedScrollLayout qMUIContinuousNestedScrollLayout = QMUIContinuousNestedScrollLayout.this;
                qMUIContinuousNestedScrollLayout.dispatchScroll(currentScroll, scrollOffsetRange, i3, qMUIContinuousNestedScrollLayout.getOffsetRange(), i, i2);
            }

            @Override // com.qmuiteam.qmui.nestedScroll.IQMUIContinuousNestedScrollCommon.OnScrollNotifier
            public void onScrollStateChange(View view2, int i) {
                QMUIContinuousNestedScrollLayout.this.dispatchScrollStateChange(i, false);
            }
        });
        if (layoutParams == null) {
            layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        }
        CoordinatorLayout.Behavior behavior = layoutParams.getBehavior();
        if (behavior instanceof QMUIContinuousNestedBottomAreaBehavior) {
            this.mBottomAreaBehavior = (QMUIContinuousNestedBottomAreaBehavior) behavior;
        } else {
            QMUIContinuousNestedBottomAreaBehavior qMUIContinuousNestedBottomAreaBehavior = new QMUIContinuousNestedBottomAreaBehavior();
            this.mBottomAreaBehavior = qMUIContinuousNestedBottomAreaBehavior;
            layoutParams.setBehavior(qMUIContinuousNestedBottomAreaBehavior);
        }
        addView(view, 0, layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        postCheckLayout();
    }

    public void postCheckLayout() {
        removeCallbacks(this.mCheckLayoutAction);
        post(this.mCheckLayoutAction);
    }

    public void checkLayout() {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView == null || this.mBottomView == null) {
            return;
        }
        int currentScroll = iQMUIContinuousNestedTopView.getCurrentScroll();
        int scrollOffsetRange = this.mTopView.getScrollOffsetRange();
        int i = -this.mTopAreaBehavior.getTopAndBottomOffset();
        int offsetRange = getOffsetRange();
        if (offsetRange <= 0) {
            return;
        }
        if (i >= offsetRange || (i > 0 && this.mKeepBottomAreaStableWhenCheckLayout)) {
            this.mTopView.consumeScroll(Integer.MAX_VALUE);
            if (this.mBottomView.getCurrentScroll() > 0) {
                this.mTopAreaBehavior.setTopAndBottomOffset(-offsetRange);
                return;
            }
            return;
        }
        if (this.mBottomView.getCurrentScroll() > 0) {
            this.mBottomView.consumeScroll(Integer.MIN_VALUE);
        }
        if (currentScroll >= scrollOffsetRange || i <= 0) {
            return;
        }
        int i2 = scrollOffsetRange - currentScroll;
        if (i >= i2) {
            this.mTopView.consumeScroll(Integer.MAX_VALUE);
            this.mTopAreaBehavior.setTopAndBottomOffset(i2 - i);
        } else {
            this.mTopView.consumeScroll(i);
            this.mTopAreaBehavior.setTopAndBottomOffset(0);
        }
    }

    public void scrollBottomViewToTop() {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.consumeScroll(Integer.MAX_VALUE);
        }
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.consumeScroll(Integer.MIN_VALUE);
            int contentHeight = this.mBottomView.getContentHeight();
            if (contentHeight != -1) {
                this.mTopAreaBehavior.setTopAndBottomOffset(Math.min(0, (getHeight() - contentHeight) - ((View) this.mTopView).getHeight()));
            } else {
                this.mTopAreaBehavior.setTopAndBottomOffset((getHeight() - ((View) this.mBottomView).getHeight()) - ((View) this.mTopView).getHeight());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchScroll(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.mIsDraggableScrollBarEnabled) {
            ensureScrollBar();
            this.mDraggableScrollBar.setPercent(getCurrentScrollPercent());
            this.mDraggableScrollBar.awakenScrollBar();
        }
        Iterator<OnScrollListener> it = this.mOnScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onScroll(this, i, i2, i3, i4, i5, i6);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        super.onNestedScroll(view, i, i2, i3, i4, i5);
        if (i4 <= 0 || getCurrentScroll() < getScrollRange()) {
            return;
        }
        stopScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchScrollStateChange(int i, boolean z) {
        Iterator<OnScrollListener> it = this.mOnScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollStateChange(this, i, z);
        }
        this.mCurrentScrollState = i;
    }

    public void scrollBy(int i) {
        QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior;
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView;
        if ((i > 0 || this.mBottomView == null) && (qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior) != null) {
            qMUIContinuousNestedTopAreaBehavior.scroll(this, (View) this.mTopView, i);
        } else {
            if (i == 0 || (iQMUIContinuousNestedBottomView = this.mBottomView) == null) {
                return;
            }
            iQMUIContinuousNestedBottomView.consumeScroll(i);
        }
    }

    public void smoothScrollBy(int i, int i2) {
        QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior;
        if (i == 0) {
            return;
        }
        if ((i > 0 || this.mBottomView == null) && (qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior) != null) {
            qMUIContinuousNestedTopAreaBehavior.smoothScrollBy(this, (View) this.mTopView, i, i2);
            return;
        }
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.smoothScrollYBy(i, i2);
        }
    }

    public void stopScroll() {
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.stopScroll();
        }
        QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior;
        if (qMUIContinuousNestedTopAreaBehavior != null) {
            qMUIContinuousNestedTopAreaBehavior.stopFlingOrScroll();
        }
    }

    public void scrollToTop() {
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.consumeScroll(Integer.MIN_VALUE);
        }
        if (this.mTopView != null) {
            this.mTopAreaBehavior.setTopAndBottomOffset(0);
            this.mTopView.consumeScroll(Integer.MIN_VALUE);
        }
    }

    public void scrollToBottom() {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.consumeScroll(Integer.MAX_VALUE);
            IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
            if (iQMUIContinuousNestedBottomView != null) {
                int contentHeight = iQMUIContinuousNestedBottomView.getContentHeight();
                if (contentHeight != -1) {
                    if (((View) this.mTopView).getHeight() + contentHeight < getHeight()) {
                        this.mTopAreaBehavior.setTopAndBottomOffset(0);
                    } else {
                        this.mTopAreaBehavior.setTopAndBottomOffset((getHeight() - contentHeight) - ((View) this.mTopView).getHeight());
                    }
                } else {
                    this.mTopAreaBehavior.setTopAndBottomOffset((getHeight() - ((View) this.mBottomView).getHeight()) - ((View) this.mTopView).getHeight());
                }
            }
        }
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView2 = this.mBottomView;
        if (iQMUIContinuousNestedBottomView2 != null) {
            iQMUIContinuousNestedBottomView2.consumeScroll(Integer.MAX_VALUE);
        }
    }

    public int getOffsetCurrent() {
        QMUIContinuousNestedTopAreaBehavior qMUIContinuousNestedTopAreaBehavior = this.mTopAreaBehavior;
        if (qMUIContinuousNestedTopAreaBehavior == null) {
            return 0;
        }
        return -qMUIContinuousNestedTopAreaBehavior.getTopAndBottomOffset();
    }

    public int getOffsetRange() {
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView;
        if (this.mTopView == null || (iQMUIContinuousNestedBottomView = this.mBottomView) == null) {
            return 0;
        }
        int contentHeight = iQMUIContinuousNestedBottomView.getContentHeight();
        if (contentHeight != -1) {
            return Math.max(0, (((View) this.mTopView).getHeight() + contentHeight) - getHeight());
        }
        return Math.max(0, (((View) this.mTopView).getHeight() + ((View) this.mBottomView).getHeight()) - getHeight());
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback
    public void onTopAreaOffset(int i) {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        int currentScroll = iQMUIContinuousNestedTopView == null ? 0 : iQMUIContinuousNestedTopView.getCurrentScroll();
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView2 = this.mTopView;
        int scrollOffsetRange = iQMUIContinuousNestedTopView2 == null ? 0 : iQMUIContinuousNestedTopView2.getScrollOffsetRange();
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        int currentScroll2 = iQMUIContinuousNestedBottomView == null ? 0 : iQMUIContinuousNestedBottomView.getCurrentScroll();
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView2 = this.mBottomView;
        dispatchScroll(currentScroll, scrollOffsetRange, -i, getOffsetRange(), currentScroll2, iQMUIContinuousNestedBottomView2 != null ? iQMUIContinuousNestedBottomView2.getScrollOffsetRange() : 0);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback
    public void onTopBehaviorTouchBegin() {
        dispatchScrollStateChange(1, true);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback
    public void onTopBehaviorTouchEnd() {
        dispatchScrollStateChange(0, true);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback
    public void onTopBehaviorFlingOrScrollStart() {
        dispatchScrollStateChange(2, true);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedTopAreaBehavior.Callback
    public void onTopBehaviorFlingOrScrollEnd() {
        dispatchScrollStateChange(0, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (this.mCurrentScrollState != 0) {
                stopScroll();
                this.mIsDismissDownEvent = true;
                this.mDismissDownY = motionEvent.getY();
                if (this.mTouchSlap < 0) {
                    this.mTouchSlap = ViewConfiguration.get(getContext()).getScaledTouchSlop();
                }
                return true;
            }
        } else if (motionEvent.getAction() == 2 && this.mIsDismissDownEvent) {
            if (Math.abs(motionEvent.getY() - this.mDismissDownY) <= this.mTouchSlap) {
                return true;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(0);
            motionEventObtain.offsetLocation(0.0f, this.mDismissDownY - motionEvent.getY());
            super.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
        this.mIsDismissDownEvent = false;
        return super.dispatchTouchEvent(motionEvent);
    }

    public void saveScrollInfo(Bundle bundle) {
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.saveScrollInfo(bundle);
        }
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.saveScrollInfo(bundle);
        }
        bundle.putInt(KEY_SCROLL_INFO_OFFSET, getOffsetCurrent());
    }

    public void restoreScrollInfo(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (this.mTopAreaBehavior != null) {
            this.mTopAreaBehavior.setTopAndBottomOffset(QMUILangHelper.constrain(-bundle.getInt(KEY_SCROLL_INFO_OFFSET, 0), -getOffsetRange(), 0));
        }
        IQMUIContinuousNestedTopView iQMUIContinuousNestedTopView = this.mTopView;
        if (iQMUIContinuousNestedTopView != null) {
            iQMUIContinuousNestedTopView.restoreScrollInfo(bundle);
        }
        IQMUIContinuousNestedBottomView iQMUIContinuousNestedBottomView = this.mBottomView;
        if (iQMUIContinuousNestedBottomView != null) {
            iQMUIContinuousNestedBottomView.restoreScrollInfo(bundle);
        }
    }
}
