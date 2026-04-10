package com.qmuiteam.qmui.recyclerView;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.skin.IQMUISkinHandlerDecoration;
import com.qmuiteam.qmui.skin.QMUISkinHelper;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIResHelper;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIRVDraggableScrollBar extends RecyclerView.ItemDecoration implements IQMUISkinHandlerDecoration, QMUIStickySectionLayout.DrawDecoration {
    private static final long DEFAULT_KEE_SHOW_DURATION = 800;
    private static final long DEFAULT_TRANSITION_DURATION = 100;
    private static final int MIN_COUNT_FOR_PERCENT_CALCULATE = 1000;
    private int[] STATE_NORMAL;
    private int[] STATE_PRESSED;
    private int mBeginAlpha;
    private Callback mCallback;
    private int mCurrentAlpha;
    private int mDragInnerStart;
    private boolean mEnableScrollBarFadeInOut;
    private final int mEndMargin;
    private Runnable mFadeScrollBarAction;
    private final int mInwardOffset;
    private boolean mIsDraggable;
    private boolean mIsInDragging;
    private final boolean mIsLocationInOppositeSide;
    private final boolean mIsVerticalScroll;
    private long mKeepShownTime;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener;
    private float mPercent;
    RecyclerView mRecyclerView;
    private Drawable mScrollBarDrawable;
    private int mScrollBarSkinRes;
    private int mScrollBarSkinTintColorRes;
    private RecyclerView.OnScrollListener mScrollListener;
    private final int mStartMargin;
    private long mStartTransitionTime;
    QMUIStickySectionLayout mStickySectionLayout;
    private int mTargetAlpha;
    private long mTransitionDuration;

    public interface Callback {
        void onDragEnd();

        void onDragStarted();

        void onDragToPercent(float f);
    }

    @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration
    public void onDraw(Canvas canvas, QMUIStickySectionLayout qMUIStickySectionLayout) {
    }

    public QMUIRVDraggableScrollBar(int i, int i2, int i3, boolean z, boolean z2) {
        this.STATE_PRESSED = new int[]{R.attr.state_pressed};
        this.STATE_NORMAL = new int[0];
        this.mEnableScrollBarFadeInOut = false;
        this.mIsDraggable = true;
        this.mKeepShownTime = DEFAULT_KEE_SHOW_DURATION;
        this.mTransitionDuration = 100L;
        this.mStartTransitionTime = 0L;
        this.mBeginAlpha = -1;
        this.mTargetAlpha = -1;
        this.mCurrentAlpha = 255;
        this.mPercent = 0.0f;
        this.mDragInnerStart = 0;
        this.mScrollBarSkinRes = 0;
        this.mScrollBarSkinTintColorRes = 0;
        this.mFadeScrollBarAction = new Runnable() { // from class: com.qmuiteam.qmui.recyclerView.QMUIRVDraggableScrollBar.1
            @Override // java.lang.Runnable
            public void run() {
                QMUIRVDraggableScrollBar.this.mTargetAlpha = 0;
                QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar = QMUIRVDraggableScrollBar.this;
                qMUIRVDraggableScrollBar.mBeginAlpha = qMUIRVDraggableScrollBar.mCurrentAlpha;
                QMUIRVDraggableScrollBar.this.mStartTransitionTime = System.currentTimeMillis();
                QMUIRVDraggableScrollBar.this.invalidate();
            }
        };
        this.mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.qmuiteam.qmui.recyclerView.QMUIRVDraggableScrollBar.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                if (!QMUIRVDraggableScrollBar.this.mIsDraggable || QMUIRVDraggableScrollBar.this.mScrollBarDrawable == null || !QMUIRVDraggableScrollBar.this.needDrawScrollBar(recyclerView)) {
                    return false;
                }
                int action = motionEvent.getAction();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (action == 0) {
                    Rect bounds = QMUIRVDraggableScrollBar.this.mScrollBarDrawable.getBounds();
                    if (QMUIRVDraggableScrollBar.this.mCurrentAlpha > 0 && bounds.contains(x, y)) {
                        QMUIRVDraggableScrollBar.this.startDrag();
                        QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar = QMUIRVDraggableScrollBar.this;
                        qMUIRVDraggableScrollBar.mDragInnerStart = qMUIRVDraggableScrollBar.mIsVerticalScroll ? y - bounds.top : x - bounds.left;
                    }
                } else if (action == 2) {
                    if (QMUIRVDraggableScrollBar.this.mIsInDragging) {
                        QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar2 = QMUIRVDraggableScrollBar.this;
                        qMUIRVDraggableScrollBar2.onDragging(recyclerView, qMUIRVDraggableScrollBar2.mScrollBarDrawable, x, y);
                    }
                } else if ((action == 1 || action == 3) && QMUIRVDraggableScrollBar.this.mIsInDragging) {
                    QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar3 = QMUIRVDraggableScrollBar.this;
                    qMUIRVDraggableScrollBar3.onDragging(recyclerView, qMUIRVDraggableScrollBar3.mScrollBarDrawable, x, y);
                    QMUIRVDraggableScrollBar.this.endDrag();
                }
                return QMUIRVDraggableScrollBar.this.mIsInDragging;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                if (QMUIRVDraggableScrollBar.this.mIsDraggable && QMUIRVDraggableScrollBar.this.mScrollBarDrawable != null && QMUIRVDraggableScrollBar.this.needDrawScrollBar(recyclerView)) {
                    int action = motionEvent.getAction();
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (action == 0) {
                        Rect bounds = QMUIRVDraggableScrollBar.this.mScrollBarDrawable.getBounds();
                        if (QMUIRVDraggableScrollBar.this.mCurrentAlpha <= 0 || !bounds.contains(x, y)) {
                            return;
                        }
                        QMUIRVDraggableScrollBar.this.startDrag();
                        QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar = QMUIRVDraggableScrollBar.this;
                        qMUIRVDraggableScrollBar.mDragInnerStart = qMUIRVDraggableScrollBar.mIsVerticalScroll ? y - bounds.top : x - bounds.left;
                        return;
                    }
                    if (action == 2) {
                        if (QMUIRVDraggableScrollBar.this.mIsInDragging) {
                            QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar2 = QMUIRVDraggableScrollBar.this;
                            qMUIRVDraggableScrollBar2.onDragging(recyclerView, qMUIRVDraggableScrollBar2.mScrollBarDrawable, x, y);
                            return;
                        }
                        return;
                    }
                    if ((action == 1 || action == 3) && QMUIRVDraggableScrollBar.this.mIsInDragging) {
                        QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar3 = QMUIRVDraggableScrollBar.this;
                        qMUIRVDraggableScrollBar3.onDragging(recyclerView, qMUIRVDraggableScrollBar3.mScrollBarDrawable, x, y);
                        QMUIRVDraggableScrollBar.this.endDrag();
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public void onRequestDisallowInterceptTouchEvent(boolean z3) {
                if (z3 && QMUIRVDraggableScrollBar.this.mIsInDragging) {
                    QMUIRVDraggableScrollBar.this.endDrag();
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.qmuiteam.qmui.recyclerView.QMUIRVDraggableScrollBar.3
            private int mPrevStatus = 0;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i4) {
                if (QMUIRVDraggableScrollBar.this.mEnableScrollBarFadeInOut) {
                    if (this.mPrevStatus == 0 && i4 != 0) {
                        QMUIRVDraggableScrollBar.this.mStartTransitionTime = System.currentTimeMillis();
                        QMUIRVDraggableScrollBar qMUIRVDraggableScrollBar = QMUIRVDraggableScrollBar.this;
                        qMUIRVDraggableScrollBar.mBeginAlpha = qMUIRVDraggableScrollBar.mCurrentAlpha;
                        QMUIRVDraggableScrollBar.this.mTargetAlpha = 255;
                        QMUIRVDraggableScrollBar.this.invalidate();
                    } else if (i4 == 0) {
                        recyclerView.postDelayed(QMUIRVDraggableScrollBar.this.mFadeScrollBarAction, QMUIRVDraggableScrollBar.this.mKeepShownTime);
                    }
                }
                this.mPrevStatus = i4;
            }
        };
        this.mStartMargin = i;
        this.mEndMargin = i2;
        this.mInwardOffset = i3;
        this.mIsVerticalScroll = z;
        this.mIsLocationInOppositeSide = z2;
    }

    public QMUIRVDraggableScrollBar(int i, int i2, int i3) {
        this(i, i2, i3, true, false);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidate() {
        QMUIStickySectionLayout qMUIStickySectionLayout = this.mStickySectionLayout;
        if (qMUIStickySectionLayout != null) {
            qMUIStickySectionLayout.invalidate();
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.invalidate();
        }
    }

    public void setScrollBarDrawable(Drawable drawable) {
        this.mScrollBarDrawable = drawable;
        if (drawable != null) {
            drawable.setState(this.mIsInDragging ? this.STATE_PRESSED : this.STATE_NORMAL);
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            QMUISkinHelper.refreshRVItemDecoration(recyclerView, this);
        }
        invalidate();
    }

    public void setScrollBarSkinRes(int i) {
        this.mScrollBarSkinRes = i;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            QMUISkinHelper.refreshRVItemDecoration(recyclerView, this);
        }
        invalidate();
    }

    public void setScrollBarSkinTintColorRes(int i) {
        this.mScrollBarSkinTintColorRes = i;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            QMUISkinHelper.refreshRVItemDecoration(recyclerView, this);
        }
        invalidate();
    }

    public void setDraggable(boolean z) {
        this.mIsDraggable = z;
    }

    public boolean isDraggable() {
        return this.mIsDraggable;
    }

    public void setEnableScrollBarFadeInOut(boolean z) {
        if (this.mEnableScrollBarFadeInOut != z) {
            this.mEnableScrollBarFadeInOut = z;
            if (!z) {
                this.mBeginAlpha = -1;
                this.mTargetAlpha = -1;
                this.mCurrentAlpha = 255;
            } else {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView == null || recyclerView.getScrollState() == 0) {
                    this.mCurrentAlpha = 0;
                }
            }
            invalidate();
        }
    }

    public boolean isEnableScrollBarFadeInOut() {
        return this.mEnableScrollBarFadeInOut;
    }

    private void commonAttachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            setupCallbacks();
            QMUISkinHelper.refreshRVItemDecoration(recyclerView, this);
        }
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        QMUIStickySectionLayout qMUIStickySectionLayout = this.mStickySectionLayout;
        if (qMUIStickySectionLayout != null) {
            qMUIStickySectionLayout.removeDrawDecoration(this);
            this.mStickySectionLayout = null;
        }
        commonAttachToRecyclerView(recyclerView);
    }

    public void attachToStickSectionLayout(QMUIStickySectionLayout qMUIStickySectionLayout) {
        QMUIStickySectionLayout qMUIStickySectionLayout2 = this.mStickySectionLayout;
        if (qMUIStickySectionLayout2 == qMUIStickySectionLayout) {
            return;
        }
        if (qMUIStickySectionLayout2 != null) {
            qMUIStickySectionLayout2.removeDrawDecoration(this);
        }
        this.mStickySectionLayout = qMUIStickySectionLayout;
        if (qMUIStickySectionLayout != null) {
            qMUIStickySectionLayout.addDrawDecoration(this);
            commonAttachToRecyclerView(qMUIStickySectionLayout.getRecyclerView());
        }
    }

    private void setupCallbacks() {
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnScrollListener(this.mScrollListener);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeCallbacks(this.mFadeScrollBarAction);
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDrag() {
        this.mIsInDragging = true;
        Drawable drawable = this.mScrollBarDrawable;
        if (drawable != null) {
            drawable.setState(this.STATE_PRESSED);
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDragStarted();
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.mFadeScrollBarAction);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endDrag() {
        this.mIsInDragging = false;
        Drawable drawable = this.mScrollBarDrawable;
        if (drawable != null) {
            drawable.setState(this.STATE_NORMAL);
        }
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDragEnd();
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDragging(RecyclerView recyclerView, Drawable drawable, int i, int i2) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int usefulSpace = getUsefulSpace(recyclerView);
        boolean z = this.mIsVerticalScroll;
        if (z) {
            intrinsicWidth = intrinsicHeight;
        }
        int i3 = usefulSpace - intrinsicWidth;
        if (z) {
            i = i2;
        }
        float fConstrain = QMUILangHelper.constrain((((i - this.mStartMargin) - this.mDragInnerStart) * 1.0f) / i3, 0.0f, 1.0f);
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDragToPercent(fConstrain);
        }
        this.mPercent = fConstrain;
        if (fConstrain <= 0.0f) {
            recyclerView.scrollToPosition(0);
        } else if (fConstrain >= 1.0f) {
            if (recyclerView.getAdapter() != null) {
                recyclerView.scrollToPosition(r5.getItemCount() - 1);
            }
        } else {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (adapter != null && adapter.getItemCount() > 1000 && (layoutManager instanceof LinearLayoutManager)) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset((int) (adapter.getItemCount() * this.mPercent), 0);
            } else {
                int scrollRange = (int) ((getScrollRange(recyclerView) * this.mPercent) - getCurrentOffset(recyclerView));
                if (this.mIsVerticalScroll) {
                    recyclerView.scrollBy(0, scrollRange);
                } else {
                    recyclerView.scrollBy(scrollRange, 0);
                }
            }
        }
        invalidate();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mStickySectionLayout == null) {
            drawScrollBar(canvas, recyclerView);
        }
    }

    @Override // com.qmuiteam.qmui.widget.section.QMUIStickySectionLayout.DrawDecoration
    public void onDrawOver(Canvas canvas, QMUIStickySectionLayout qMUIStickySectionLayout) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            drawScrollBar(canvas, recyclerView);
        }
    }

    private void drawScrollBar(Canvas canvas, RecyclerView recyclerView) {
        Drawable drawableEnsureScrollBar = ensureScrollBar(recyclerView.getContext());
        if (drawableEnsureScrollBar == null || !needDrawScrollBar(recyclerView)) {
            return;
        }
        if (this.mTargetAlpha != -1 && this.mBeginAlpha != -1) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartTransitionTime;
            long jAbs = (this.mTransitionDuration * ((long) Math.abs(this.mTargetAlpha - this.mBeginAlpha))) / 255;
            if (jCurrentTimeMillis >= jAbs) {
                this.mCurrentAlpha = this.mTargetAlpha;
                this.mTargetAlpha = -1;
                this.mBeginAlpha = -1;
            } else {
                this.mCurrentAlpha = (int) (this.mBeginAlpha + (((((long) (this.mTargetAlpha - r1)) * jCurrentTimeMillis) * 1.0f) / jAbs));
                recyclerView.postInvalidateOnAnimation();
            }
        }
        drawableEnsureScrollBar.setAlpha(this.mCurrentAlpha);
        if (!this.mIsInDragging) {
            this.mPercent = calculatePercent(recyclerView);
        }
        setScrollBarBounds(recyclerView, drawableEnsureScrollBar);
        drawableEnsureScrollBar.draw(canvas);
    }

    private int getUsefulSpace(RecyclerView recyclerView) {
        int width;
        int i;
        if (this.mIsVerticalScroll) {
            width = recyclerView.getHeight() - this.mStartMargin;
            i = this.mEndMargin;
        } else {
            width = recyclerView.getWidth() - this.mStartMargin;
            i = this.mEndMargin;
        }
        return width - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needDrawScrollBar(RecyclerView recyclerView) {
        return this.mIsVerticalScroll ? recyclerView.canScrollVertically(-1) || recyclerView.canScrollVertically(1) : recyclerView.canScrollHorizontally(-1) || recyclerView.canScrollHorizontally(1);
    }

    private void setScrollBarBounds(RecyclerView recyclerView, Drawable drawable) {
        int height;
        int width;
        int usefulSpace = getUsefulSpace(recyclerView);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (this.mIsVerticalScroll) {
            height = (int) ((usefulSpace - intrinsicHeight) * this.mPercent);
            width = this.mIsLocationInOppositeSide ? this.mInwardOffset : (recyclerView.getWidth() - intrinsicWidth) - this.mInwardOffset;
        } else {
            int i = (int) ((usefulSpace - intrinsicWidth) * this.mPercent);
            height = this.mIsLocationInOppositeSide ? this.mInwardOffset : (recyclerView.getHeight() - intrinsicHeight) - this.mInwardOffset;
            width = i;
        }
        drawable.setBounds(width, height, intrinsicWidth + width, intrinsicHeight + height);
    }

    private int getScrollRange(RecyclerView recyclerView) {
        int iComputeHorizontalScrollRange;
        int width;
        if (this.mIsVerticalScroll) {
            iComputeHorizontalScrollRange = recyclerView.computeVerticalScrollRange();
            width = recyclerView.getHeight();
        } else {
            iComputeHorizontalScrollRange = recyclerView.computeHorizontalScrollRange();
            width = recyclerView.getWidth();
        }
        return iComputeHorizontalScrollRange - width;
    }

    private int getCurrentOffset(RecyclerView recyclerView) {
        if (this.mIsVerticalScroll) {
            return recyclerView.computeVerticalScrollOffset();
        }
        return recyclerView.computeHorizontalScrollOffset();
    }

    private float calculatePercent(RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (adapter != null && adapter.getItemCount() > 1000 && (layoutManager instanceof LinearLayoutManager)) {
            return (((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() * 1.0f) / adapter.getItemCount();
        }
        return QMUILangHelper.constrain((getCurrentOffset(recyclerView) * 1.0f) / getScrollRange(recyclerView), 0.0f, 1.0f);
    }

    public Drawable ensureScrollBar(Context context) {
        if (this.mScrollBarDrawable == null) {
            setScrollBarDrawable(ContextCompat.getDrawable(context, com.qmuiteam.qmui.R.drawable.qmui_icon_scroll_bar));
        }
        return this.mScrollBarDrawable;
    }

    @Override // com.qmuiteam.qmui.skin.IQMUISkinHandlerDecoration
    public void handle(RecyclerView recyclerView, QMUISkinManager qMUISkinManager, int i, Resources.Theme theme) {
        Drawable drawable;
        if (this.mScrollBarSkinRes != 0) {
            this.mScrollBarDrawable = QMUIResHelper.getAttrDrawable(recyclerView.getContext(), theme, this.mScrollBarSkinRes);
        } else if (this.mScrollBarSkinTintColorRes != 0 && (drawable = this.mScrollBarDrawable) != null) {
            DrawableCompat.setTintList(drawable, QMUIResHelper.getAttrColorStateList(recyclerView.getContext(), theme, this.mScrollBarSkinTintColorRes));
        }
        invalidate();
    }
}
