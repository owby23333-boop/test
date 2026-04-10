package com.qmuiteam.qmui.recyclerView;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.qmuiteam.qmui.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIRVItemSwipeAction extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
    private static final int ACTIVE_POINTER_ID_NONE = -1;
    public static final int ANIMATION_TYPE_SWIPE_ACTION = 3;
    public static final int ANIMATION_TYPE_SWIPE_CANCEL = 2;
    public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 1;
    private static final boolean DEBUG = false;
    private static final int PIXELS_PER_SECOND = 1000;
    public static final int SWIPE_DOWN = 4;
    public static final int SWIPE_LEFT = 1;
    public static final int SWIPE_NONE = 0;
    public static final int SWIPE_RIGHT = 2;
    private static final int SWIPE_TRIGGERED_IMMEDIATELY = -1;
    public static final int SWIPE_UP = 3;
    private static final String TAG = "QMUIRVItemSwipeAction";
    private Callback mCallback;
    private MotionEvent mCurrentDownEvent;
    float mDx;
    float mDy;
    float mInitialTouchX;
    float mInitialTouchY;
    private float mMaxSwipeVelocity;
    RecyclerView mRecyclerView;
    float mSelectedStartX;
    float mSelectedStartY;
    private int mSlop;
    private boolean mSwipeDeleteWhenOnlyOneAction;
    int mSwipeDirection;
    private float mSwipeEscapeVelocity;
    VelocityTracker mVelocityTracker;
    final List<View> mPendingCleanup = new ArrayList();
    private final float[] mTmpPosition = new float[2];
    long mDownTimeMillis = 0;
    int mActivePointerId = -1;
    List<RecoverAnimation> mRecoverAnimations = new ArrayList();
    private long mPressTimeToSwipe = -1;
    private Runnable mLongPressToSwipe = new Runnable() { // from class: com.qmuiteam.qmui.recyclerView.QMUIRVItemSwipeAction.1
        @Override // java.lang.Runnable
        public void run() {
            int iFindPointerIndex;
            if (QMUIRVItemSwipeAction.this.mCurrentDownEvent == null || (iFindPointerIndex = QMUIRVItemSwipeAction.this.mCurrentDownEvent.findPointerIndex(QMUIRVItemSwipeAction.this.mActivePointerId)) < 0) {
                return;
            }
            QMUIRVItemSwipeAction qMUIRVItemSwipeAction = QMUIRVItemSwipeAction.this;
            qMUIRVItemSwipeAction.checkSelectForSwipe(qMUIRVItemSwipeAction.mCurrentDownEvent.getAction(), QMUIRVItemSwipeAction.this.mCurrentDownEvent, iFindPointerIndex, true);
        }
    };
    RecyclerView.ViewHolder mSelected = null;
    private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener() { // from class: com.qmuiteam.qmui.recyclerView.QMUIRVItemSwipeAction.2
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int iFindPointerIndex;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (QMUIRVItemSwipeAction.this.mCurrentDownEvent != null) {
                    QMUIRVItemSwipeAction.this.mCurrentDownEvent.recycle();
                }
                QMUIRVItemSwipeAction.this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                if (QMUIRVItemSwipeAction.this.mPressTimeToSwipe > 0 && QMUIRVItemSwipeAction.this.mSelected == null) {
                    recyclerView.postDelayed(QMUIRVItemSwipeAction.this.mLongPressToSwipe, QMUIRVItemSwipeAction.this.mPressTimeToSwipe);
                }
                QMUIRVItemSwipeAction.this.mActivePointerId = motionEvent.getPointerId(0);
                QMUIRVItemSwipeAction.this.mInitialTouchX = motionEvent.getX();
                QMUIRVItemSwipeAction.this.mInitialTouchY = motionEvent.getY();
                QMUIRVItemSwipeAction.this.obtainVelocityTracker();
                QMUIRVItemSwipeAction.this.mDownTimeMillis = System.currentTimeMillis();
                if (QMUIRVItemSwipeAction.this.mSelected == null) {
                    RecoverAnimation recoverAnimationFindAnimation = QMUIRVItemSwipeAction.this.findAnimation(motionEvent);
                    if (recoverAnimationFindAnimation != null) {
                        QMUIRVItemSwipeAction.this.mInitialTouchX -= recoverAnimationFindAnimation.mX;
                        QMUIRVItemSwipeAction.this.mInitialTouchY -= recoverAnimationFindAnimation.mY;
                        QMUIRVItemSwipeAction.this.endRecoverAnimation(recoverAnimationFindAnimation.mViewHolder, true);
                        if (QMUIRVItemSwipeAction.this.mPendingCleanup.remove(recoverAnimationFindAnimation.mViewHolder.itemView)) {
                            QMUIRVItemSwipeAction.this.mCallback.clearView(QMUIRVItemSwipeAction.this.mRecyclerView, recoverAnimationFindAnimation.mViewHolder);
                        }
                        QMUIRVItemSwipeAction.this.select(recoverAnimationFindAnimation.mViewHolder);
                        QMUIRVItemSwipeAction qMUIRVItemSwipeAction = QMUIRVItemSwipeAction.this;
                        qMUIRVItemSwipeAction.updateDxDy(motionEvent, qMUIRVItemSwipeAction.mSwipeDirection, 0);
                    }
                } else if (QMUIRVItemSwipeAction.this.mSelected instanceof QMUISwipeViewHolder) {
                    if (!((QMUISwipeViewHolder) QMUIRVItemSwipeAction.this.mSelected).checkDown(QMUIRVItemSwipeAction.this.mInitialTouchX, QMUIRVItemSwipeAction.this.mInitialTouchY)) {
                        if (QMUIRVItemSwipeAction.hitTest(QMUIRVItemSwipeAction.this.mSelected.itemView, QMUIRVItemSwipeAction.this.mInitialTouchX, QMUIRVItemSwipeAction.this.mInitialTouchY, QMUIRVItemSwipeAction.this.mSelectedStartX + QMUIRVItemSwipeAction.this.mDx, QMUIRVItemSwipeAction.this.mSelectedStartY + QMUIRVItemSwipeAction.this.mDy)) {
                            QMUIRVItemSwipeAction.this.mInitialTouchX -= QMUIRVItemSwipeAction.this.mDx;
                            QMUIRVItemSwipeAction.this.mInitialTouchY -= QMUIRVItemSwipeAction.this.mDy;
                        } else {
                            QMUIRVItemSwipeAction.this.select(null);
                            return true;
                        }
                    } else {
                        QMUIRVItemSwipeAction.this.mInitialTouchX -= QMUIRVItemSwipeAction.this.mDx;
                        QMUIRVItemSwipeAction.this.mInitialTouchY -= QMUIRVItemSwipeAction.this.mDy;
                    }
                }
            } else if (actionMasked == 3) {
                QMUIRVItemSwipeAction.this.mActivePointerId = -1;
                QMUIRVItemSwipeAction.this.mRecyclerView.removeCallbacks(QMUIRVItemSwipeAction.this.mLongPressToSwipe);
                QMUIRVItemSwipeAction.this.select(null);
            } else if (actionMasked == 1) {
                QMUIRVItemSwipeAction.this.mRecyclerView.removeCallbacks(QMUIRVItemSwipeAction.this.mLongPressToSwipe);
                QMUIRVItemSwipeAction.this.handleActionUp(motionEvent.getX(), motionEvent.getY(), QMUIRVItemSwipeAction.this.mSlop);
                QMUIRVItemSwipeAction.this.mActivePointerId = -1;
            } else if (QMUIRVItemSwipeAction.this.mActivePointerId != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(QMUIRVItemSwipeAction.this.mActivePointerId)) >= 0) {
                QMUIRVItemSwipeAction.this.checkSelectForSwipe(actionMasked, motionEvent, iFindPointerIndex, false);
            }
            if (QMUIRVItemSwipeAction.this.mVelocityTracker != null) {
                QMUIRVItemSwipeAction.this.mVelocityTracker.addMovement(motionEvent);
            }
            return QMUIRVItemSwipeAction.this.mSelected != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            if (QMUIRVItemSwipeAction.this.mVelocityTracker != null) {
                QMUIRVItemSwipeAction.this.mVelocityTracker.addMovement(motionEvent);
            }
            if (QMUIRVItemSwipeAction.this.mActivePointerId == -1) {
                return;
            }
            int actionMasked = motionEvent.getActionMasked();
            int iFindPointerIndex = motionEvent.findPointerIndex(QMUIRVItemSwipeAction.this.mActivePointerId);
            if (iFindPointerIndex >= 0) {
                QMUIRVItemSwipeAction.this.checkSelectForSwipe(actionMasked, motionEvent, iFindPointerIndex, false);
            }
            if (QMUIRVItemSwipeAction.this.mSelected == null) {
                return;
            }
            if (actionMasked == 1) {
                QMUIRVItemSwipeAction.this.mRecyclerView.removeCallbacks(QMUIRVItemSwipeAction.this.mLongPressToSwipe);
                QMUIRVItemSwipeAction.this.handleActionUp(motionEvent.getX(), motionEvent.getY(), QMUIRVItemSwipeAction.this.mSlop);
                if (QMUIRVItemSwipeAction.this.mVelocityTracker != null) {
                    QMUIRVItemSwipeAction.this.mVelocityTracker.clear();
                }
                QMUIRVItemSwipeAction.this.mActivePointerId = -1;
                return;
            }
            if (actionMasked == 2) {
                if (iFindPointerIndex >= 0) {
                    QMUIRVItemSwipeAction qMUIRVItemSwipeAction = QMUIRVItemSwipeAction.this;
                    qMUIRVItemSwipeAction.updateDxDy(motionEvent, qMUIRVItemSwipeAction.mSwipeDirection, iFindPointerIndex);
                    QMUIRVItemSwipeAction.this.mRecyclerView.invalidate();
                    float x = motionEvent.getX(iFindPointerIndex);
                    float y = motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(x - QMUIRVItemSwipeAction.this.mInitialTouchX) > QMUIRVItemSwipeAction.this.mSlop || Math.abs(y - QMUIRVItemSwipeAction.this.mInitialTouchY) > QMUIRVItemSwipeAction.this.mSlop) {
                        QMUIRVItemSwipeAction.this.mRecyclerView.removeCallbacks(QMUIRVItemSwipeAction.this.mLongPressToSwipe);
                        return;
                    }
                    return;
                }
                return;
            }
            if (actionMasked == 3) {
                QMUIRVItemSwipeAction.this.mRecyclerView.removeCallbacks(QMUIRVItemSwipeAction.this.mLongPressToSwipe);
                QMUIRVItemSwipeAction.this.select(null);
                if (QMUIRVItemSwipeAction.this.mVelocityTracker != null) {
                    QMUIRVItemSwipeAction.this.mVelocityTracker.clear();
                }
                QMUIRVItemSwipeAction.this.mActivePointerId = -1;
                return;
            }
            if (actionMasked != 6) {
                return;
            }
            int actionIndex = motionEvent.getActionIndex();
            if (motionEvent.getPointerId(actionIndex) == QMUIRVItemSwipeAction.this.mActivePointerId) {
                QMUIRVItemSwipeAction.this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                QMUIRVItemSwipeAction qMUIRVItemSwipeAction2 = QMUIRVItemSwipeAction.this;
                qMUIRVItemSwipeAction2.updateDxDy(motionEvent, qMUIRVItemSwipeAction2.mSwipeDirection, actionIndex);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
            if (z) {
                QMUIRVItemSwipeAction.this.select(null);
            }
        }
    };

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
    }

    public QMUIRVItemSwipeAction(boolean z, Callback callback) {
        this.mCallback = callback;
        this.mSwipeDeleteWhenOnlyOneAction = z;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            Resources resources = recyclerView.getResources();
            this.mSwipeEscapeVelocity = resources.getDimension(R.dimen.qmui_rv_swipe_action_escape_velocity);
            this.mMaxSwipeVelocity = resources.getDimension(R.dimen.qmui_rv_swipe_action_escape_max_velocity);
            setupCallbacks();
        }
    }

    public void setPressTimeToSwipe(long j) {
        this.mPressTimeToSwipe = j;
    }

    private void setupCallbacks() {
        this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
        this.mRecyclerView.addItemDecoration(this);
        this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.addOnChildAttachStateChangeListener(this);
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeItemDecoration(this);
        this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
        this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            this.mCallback.clearView(this.mRecyclerView, this.mRecoverAnimations.get(0).mViewHolder);
        }
        this.mRecoverAnimations.clear();
        releaseVelocityTracker();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.mCallback.onDrawOver(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, f, f2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f;
        float f2;
        if (this.mSelected != null) {
            getSelectedDxDy(this.mTmpPosition);
            float[] fArr = this.mTmpPosition;
            float f3 = fArr[0];
            f2 = fArr[1];
            f = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        this.mCallback.onDraw(canvas, recyclerView, this.mSelected, this.mRecoverAnimations, f, f2, this.mSwipeDirection);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View view) {
        RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder == null) {
            return;
        }
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null && childViewHolder == viewHolder) {
            select(null);
            return;
        }
        endRecoverAnimation(childViewHolder, false);
        if (this.mPendingCleanup.remove(childViewHolder.itemView)) {
            this.mCallback.clearView(this.mRecyclerView, childViewHolder);
        }
    }

    void updateDxDy(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        if (i == 2) {
            this.mDx = Math.max(0.0f, x - this.mInitialTouchX);
            this.mDy = 0.0f;
            return;
        }
        if (i == 1) {
            this.mDx = Math.min(0.0f, x - this.mInitialTouchX);
            this.mDy = 0.0f;
        } else if (i == 4) {
            this.mDx = 0.0f;
            this.mDy = Math.max(0.0f, y - this.mInitialTouchY);
        } else if (i == 3) {
            this.mDx = 0.0f;
            this.mDy = Math.min(0.0f, y - this.mInitialTouchY);
        }
    }

    void checkSelectForSwipe(int i, MotionEvent motionEvent, int i2, boolean z) {
        RecyclerView.ViewHolder viewHolderFindSwipedView;
        int swipeDirection;
        if (this.mSelected == null) {
            if ((this.mPressTimeToSwipe == -1 && i != 2) || this.mRecyclerView.getScrollState() == 1 || (viewHolderFindSwipedView = findSwipedView(motionEvent, z)) == null || (swipeDirection = this.mCallback.getSwipeDirection(this.mRecyclerView, viewHolderFindSwipedView)) == 0) {
                return;
            }
            long j = this.mPressTimeToSwipe;
            if (j == -1) {
                float x = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                float f = x - this.mInitialTouchX;
                float f2 = y - this.mInitialTouchY;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (swipeDirection == 1) {
                    if (fAbs < this.mSlop || f >= 0.0f) {
                        return;
                    }
                } else if (swipeDirection == 2) {
                    if (fAbs < this.mSlop || f <= 0.0f) {
                        return;
                    }
                } else if (swipeDirection == 3) {
                    if (fAbs2 < this.mSlop || f2 >= 0.0f) {
                        return;
                    }
                } else if (swipeDirection == 4 && (fAbs2 < this.mSlop || f2 <= 0.0f)) {
                    return;
                }
            } else if (j >= System.currentTimeMillis() - this.mDownTimeMillis) {
                return;
            }
            this.mRecyclerView.removeCallbacks(this.mLongPressToSwipe);
            this.mDy = 0.0f;
            this.mDx = 0.0f;
            this.mActivePointerId = motionEvent.getPointerId(0);
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            viewHolderFindSwipedView.itemView.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            select(viewHolderFindSwipedView);
        }
    }

    public void clear() {
        select(null, false);
    }

    void handleActionUp(float f, float f2, int i) {
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null) {
            if (viewHolder instanceof QMUISwipeViewHolder) {
                QMUISwipeViewHolder qMUISwipeViewHolder = (QMUISwipeViewHolder) viewHolder;
                if (!qMUISwipeViewHolder.hasAction()) {
                    select(null, true);
                    return;
                }
                if (qMUISwipeViewHolder.mSwipeActions.size() == 1 && this.mSwipeDeleteWhenOnlyOneAction) {
                    if (this.mCallback.isOverThreshold(this.mRecyclerView, this.mSelected, this.mDx, this.mDy, this.mSwipeDirection)) {
                        select(null, true);
                        return;
                    } else {
                        handleSwipeActionActionUp(qMUISwipeViewHolder, f, f2, i);
                        return;
                    }
                }
                handleSwipeActionActionUp(qMUISwipeViewHolder, f, f2, i);
                return;
            }
            select(null, true);
        }
    }

    void handleSwipeActionActionUp(QMUISwipeViewHolder qMUISwipeViewHolder, float f, float f2, int i) {
        int i2;
        float f3;
        float f4;
        int i3;
        QMUISwipeAction qMUISwipeActionCheckUp = qMUISwipeViewHolder.checkUp(f, f2, i);
        if (qMUISwipeActionCheckUp != null) {
            this.mCallback.onClickAction(this, this.mSelected, qMUISwipeActionCheckUp);
            qMUISwipeViewHolder.clearTouchInfo();
            return;
        }
        qMUISwipeViewHolder.clearTouchInfo();
        int iCheckSwipe = checkSwipe(this.mSelected, this.mSwipeDirection, true);
        if (iCheckSwipe == 0) {
            select(null, true);
            return;
        }
        getSelectedDxDy(this.mTmpPosition);
        float[] fArr = this.mTmpPosition;
        float f5 = fArr[0];
        float f6 = fArr[1];
        if (iCheckSwipe == 1) {
            i2 = -qMUISwipeViewHolder.mActionTotalWidth;
        } else if (iCheckSwipe == 2) {
            i2 = qMUISwipeViewHolder.mActionTotalWidth;
        } else {
            if (iCheckSwipe == 3) {
                i3 = -qMUISwipeViewHolder.mActionTotalHeight;
            } else if (iCheckSwipe == 4) {
                i3 = qMUISwipeViewHolder.mActionTotalHeight;
            } else {
                f3 = 0.0f;
                f4 = 0.0f;
                float f7 = f3 - f5;
                this.mDx += f7;
                float f8 = f4 - f6;
                this.mDy += f8;
                RecoverAnimation recoverAnimation = new RecoverAnimation(qMUISwipeViewHolder, f5, f6, f3, f4, this.mCallback.getInterpolator(3));
                recoverAnimation.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, 3, f7, f8));
                this.mRecoverAnimations.add(recoverAnimation);
                recoverAnimation.start();
                this.mRecyclerView.invalidate();
            }
            f4 = i3;
            f3 = 0.0f;
            float f72 = f3 - f5;
            this.mDx += f72;
            float f82 = f4 - f6;
            this.mDy += f82;
            RecoverAnimation recoverAnimation2 = new RecoverAnimation(qMUISwipeViewHolder, f5, f6, f3, f4, this.mCallback.getInterpolator(3));
            recoverAnimation2.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, 3, f72, f82));
            this.mRecoverAnimations.add(recoverAnimation2);
            recoverAnimation2.start();
            this.mRecyclerView.invalidate();
        }
        f3 = i2;
        f4 = 0.0f;
        float f722 = f3 - f5;
        this.mDx += f722;
        float f822 = f4 - f6;
        this.mDy += f822;
        RecoverAnimation recoverAnimation22 = new RecoverAnimation(qMUISwipeViewHolder, f5, f6, f3, f4, this.mCallback.getInterpolator(3));
        recoverAnimation22.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, 3, f722, f822));
        this.mRecoverAnimations.add(recoverAnimation22);
        recoverAnimation22.start();
        this.mRecyclerView.invalidate();
    }

    void select(RecyclerView.ViewHolder viewHolder) {
        select(viewHolder, false);
    }

    void select(RecyclerView.ViewHolder viewHolder, boolean z) {
        boolean z2;
        float fSignum;
        float fSignum2;
        if (viewHolder == this.mSelected) {
            return;
        }
        endRecoverAnimation(viewHolder, true);
        final RecyclerView.ViewHolder viewHolder2 = this.mSelected;
        if (viewHolder2 != null) {
            if (viewHolder2.itemView.getParent() != null) {
                endRecoverAnimation(viewHolder2, true);
                final int iCheckSwipe = z ? checkSwipe(this.mSelected, this.mSwipeDirection, false) : 0;
                getSelectedDxDy(this.mTmpPosition);
                float[] fArr = this.mTmpPosition;
                float f = fArr[0];
                float f2 = fArr[1];
                if (iCheckSwipe == 1 || iCheckSwipe == 2) {
                    fSignum = 0.0f;
                    fSignum2 = Math.signum(this.mDx) * this.mRecyclerView.getWidth();
                } else if (iCheckSwipe == 3 || iCheckSwipe == 4) {
                    fSignum2 = 0.0f;
                    fSignum = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
                } else {
                    fSignum2 = 0.0f;
                    fSignum = 0.0f;
                }
                int i = iCheckSwipe > 0 ? 1 : 2;
                if (iCheckSwipe > 0) {
                    this.mCallback.onStartSwipeAnimation(this.mSelected, iCheckSwipe);
                }
                RecoverAnimation recoverAnimation = new RecoverAnimation(viewHolder2, f, f2, fSignum2, fSignum, this.mCallback.getInterpolator(3)) { // from class: com.qmuiteam.qmui.recyclerView.QMUIRVItemSwipeAction.3
                    @Override // com.qmuiteam.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        if (this.mOverridden) {
                            return;
                        }
                        if (iCheckSwipe == 0) {
                            QMUIRVItemSwipeAction.this.mCallback.clearView(QMUIRVItemSwipeAction.this.mRecyclerView, viewHolder2);
                            return;
                        }
                        QMUIRVItemSwipeAction.this.mPendingCleanup.add(viewHolder2.itemView);
                        this.mIsPendingCleanup = true;
                        int i2 = iCheckSwipe;
                        if (i2 > 0) {
                            QMUIRVItemSwipeAction.this.postDispatchSwipe(this, i2);
                        }
                    }
                };
                recoverAnimation.setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i, fSignum2 - f, fSignum - f2));
                this.mRecoverAnimations.add(recoverAnimation);
                recoverAnimation.start();
                z2 = true;
            } else {
                this.mCallback.clearView(this.mRecyclerView, viewHolder2);
                z2 = false;
            }
            this.mSelected = null;
        } else {
            z2 = false;
        }
        if (viewHolder != null) {
            this.mSwipeDirection = this.mCallback.getSwipeDirection(this.mRecyclerView, viewHolder);
            this.mSelectedStartX = viewHolder.itemView.getLeft();
            this.mSelectedStartY = viewHolder.itemView.getTop();
            this.mSelected = viewHolder;
            if (viewHolder instanceof QMUISwipeViewHolder) {
                ((QMUISwipeViewHolder) viewHolder).setup(this.mSwipeDirection, this.mSwipeDeleteWhenOnlyOneAction);
            }
        }
        ViewParent parent = this.mRecyclerView.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(this.mSelected != null);
        }
        if (!z2) {
            this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
        }
        this.mCallback.onSelectedChanged(this.mSelected);
        this.mRecyclerView.invalidate();
    }

    private void getSelectedDxDy(float[] fArr) {
        int i = this.mSwipeDirection;
        if (i == 1 || i == 2) {
            fArr[0] = (this.mSelectedStartX + this.mDx) - this.mSelected.itemView.getLeft();
        } else {
            fArr[0] = this.mSelected.itemView.getTranslationX();
        }
        int i2 = this.mSwipeDirection;
        if (i2 == 3 || i2 == 4) {
            fArr[1] = (this.mSelectedStartY + this.mDy) - this.mSelected.itemView.getTop();
        } else {
            fArr[1] = this.mSelected.itemView.getTranslationY();
        }
    }

    void postDispatchSwipe(final RecoverAnimation recoverAnimation, final int i) {
        this.mRecyclerView.post(new Runnable() { // from class: com.qmuiteam.qmui.recyclerView.QMUIRVItemSwipeAction.4
            @Override // java.lang.Runnable
            public void run() {
                if (QMUIRVItemSwipeAction.this.mRecyclerView == null || !QMUIRVItemSwipeAction.this.mRecyclerView.isAttachedToWindow() || recoverAnimation.mOverridden || recoverAnimation.mViewHolder.getAdapterPosition() == -1) {
                    return;
                }
                RecyclerView.ItemAnimator itemAnimator = QMUIRVItemSwipeAction.this.mRecyclerView.getItemAnimator();
                if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !QMUIRVItemSwipeAction.this.hasRunningRecoverAnim()) {
                    QMUIRVItemSwipeAction.this.mCallback.onSwiped(recoverAnimation.mViewHolder, i);
                } else {
                    QMUIRVItemSwipeAction.this.mRecyclerView.post(this);
                }
            }
        });
    }

    boolean hasRunningRecoverAnim() {
        int size = this.mRecoverAnimations.size();
        for (int i = 0; i < size; i++) {
            if (!this.mRecoverAnimations.get(i).mEnded) {
                return true;
            }
        }
        return false;
    }

    private int checkSwipe(RecyclerView.ViewHolder viewHolder, int i, boolean z) {
        float swipeThreshold;
        float swipeThreshold2;
        if (i == 1 || i == 2) {
            int i2 = this.mDx > 0.0f ? 2 : 1;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null && this.mActivePointerId > -1) {
                velocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
                float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
                int i3 = xVelocity <= 0.0f ? 1 : 2;
                float fAbs = Math.abs(xVelocity);
                if (i2 == i3 && fAbs >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) {
                    return i3;
                }
            }
            if (z && (viewHolder instanceof QMUISwipeViewHolder)) {
                swipeThreshold = ((QMUISwipeViewHolder) viewHolder).mActionTotalWidth;
            } else {
                swipeThreshold = this.mCallback.getSwipeThreshold(viewHolder) * this.mRecyclerView.getWidth();
            }
            if (Math.abs(this.mDx) >= swipeThreshold) {
                return i2;
            }
            return 0;
        }
        if (i != 3 && i != 4) {
            return 0;
        }
        int i4 = this.mDy > 0.0f ? 4 : 3;
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null && this.mActivePointerId > -1) {
            velocityTracker2.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
            float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
            int i5 = yVelocity <= 0.0f ? 3 : 4;
            float fAbs2 = Math.abs(yVelocity);
            if (i5 == i4 && fAbs2 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) {
                return i5;
            }
        }
        if (z && (viewHolder instanceof QMUISwipeViewHolder)) {
            swipeThreshold2 = ((QMUISwipeViewHolder) viewHolder).mActionTotalHeight;
        } else {
            swipeThreshold2 = this.mCallback.getSwipeThreshold(viewHolder) * this.mRecyclerView.getHeight();
        }
        if (Math.abs(this.mDy) >= swipeThreshold2) {
            return i4;
        }
        return 0;
    }

    private RecyclerView.ViewHolder findSwipedView(MotionEvent motionEvent, boolean z) {
        View viewFindChildView;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int i = this.mActivePointerId;
        if (i == -1 || layoutManager == null) {
            return null;
        }
        if (z) {
            View viewFindChildView2 = findChildView(motionEvent);
            if (viewFindChildView2 == null) {
                return null;
            }
            return this.mRecyclerView.getChildViewHolder(viewFindChildView2);
        }
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        float x = motionEvent.getX(iFindPointerIndex) - this.mInitialTouchX;
        float y = motionEvent.getY(iFindPointerIndex) - this.mInitialTouchY;
        float fAbs = Math.abs(x);
        float fAbs2 = Math.abs(y);
        int i2 = this.mSlop;
        if (fAbs < i2 && fAbs2 < i2) {
            return null;
        }
        if (fAbs > fAbs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((fAbs2 <= fAbs || !layoutManager.canScrollVertically()) && (viewFindChildView = findChildView(motionEvent)) != null) {
            return this.mRecyclerView.getChildViewHolder(viewFindChildView);
        }
        return null;
    }

    void endRecoverAnimation(RecyclerView.ViewHolder viewHolder, boolean z) {
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder == viewHolder) {
                recoverAnimation.mOverridden |= z;
                if (!recoverAnimation.mEnded) {
                    recoverAnimation.cancel();
                }
                this.mRecoverAnimations.remove(size);
                return;
            }
        }
    }

    View findChildView(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.mSelected;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (hitTest(view, x, y, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
                return view;
            }
        }
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            View view2 = this.mRecoverAnimations.get(size).mViewHolder.itemView;
            if (hitTest(view2, x, y, view2.getX(), view2.getY())) {
                return view2;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x, y);
    }

    RecoverAnimation findAnimation(MotionEvent motionEvent) {
        if (this.mRecoverAnimations.isEmpty()) {
            return null;
        }
        View viewFindChildView = findChildView(motionEvent);
        for (int size = this.mRecoverAnimations.size() - 1; size >= 0; size--) {
            RecoverAnimation recoverAnimation = this.mRecoverAnimations.get(size);
            if (recoverAnimation.mViewHolder.itemView == viewFindChildView) {
                return recoverAnimation;
            }
        }
        return null;
    }

    void obtainVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = VelocityTracker.obtain();
    }

    private void releaseVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hitTest(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    private static class RecoverAnimation implements Animator.AnimatorListener {
        private float mFraction;
        boolean mIsPendingCleanup;
        final float mStartDx;
        final float mStartDy;
        final float mTargetX;
        final float mTargetY;
        private final ValueAnimator mValueAnimator;
        final RecyclerView.ViewHolder mViewHolder;
        float mX;
        float mY;
        boolean mOverridden = false;
        boolean mEnded = false;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        RecoverAnimation(RecyclerView.ViewHolder viewHolder, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
            this.mViewHolder = viewHolder;
            this.mStartDx = f;
            this.mStartDy = f2;
            this.mTargetX = f3;
            this.mTargetY = f4;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mValueAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qmuiteam.qmui.recyclerView.QMUIRVItemSwipeAction.RecoverAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    RecoverAnimation.this.setFraction(valueAnimator.getAnimatedFraction());
                }
            });
            valueAnimatorOfFloat.setTarget(viewHolder.itemView);
            valueAnimatorOfFloat.addListener(this);
            valueAnimatorOfFloat.setInterpolator(timeInterpolator);
            setFraction(0.0f);
        }

        public void setDuration(long j) {
            this.mValueAnimator.setDuration(j);
        }

        public void start() {
            this.mViewHolder.setIsRecyclable(false);
            this.mValueAnimator.start();
        }

        public void cancel() {
            this.mValueAnimator.cancel();
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }

        public void update() {
            float f = this.mStartDx;
            float f2 = this.mTargetX;
            if (f == f2) {
                this.mX = this.mViewHolder.itemView.getTranslationX();
            } else {
                this.mX = f + (this.mFraction * (f2 - f));
            }
            float f3 = this.mStartDy;
            float f4 = this.mTargetY;
            if (f3 == f4) {
                this.mY = this.mViewHolder.itemView.getTranslationY();
            } else {
                this.mY = f3 + (this.mFraction * (f4 - f3));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.mEnded) {
                this.mViewHolder.setIsRecyclable(true);
            }
            this.mEnded = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            setFraction(1.0f);
        }
    }

    public static abstract class Callback {
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;

        public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
            return 250L;
        }

        public TimeInterpolator getInterpolator(int i) {
            return null;
        }

        public int getSwipeDirection(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return 0;
        }

        public float getSwipeEscapeVelocity(float f) {
            return f;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f) {
            return f;
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, boolean z) {
        }

        public void onClickAction(QMUIRVItemSwipeAction qMUIRVItemSwipeAction, RecyclerView.ViewHolder viewHolder, QMUISwipeAction qMUISwipeAction) {
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder) {
        }

        public void onStartSwipeAnimation(RecyclerView.ViewHolder viewHolder, int i) {
        }

        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            if (viewHolder instanceof QMUISwipeViewHolder) {
                ((QMUISwipeViewHolder) viewHolder).clearTouchInfo();
            }
        }

        void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, float f, float f2, int i) {
            int size = list.size();
            float f3 = f;
            float f4 = f2;
            for (int i2 = 0; i2 < size; i2++) {
                RecoverAnimation recoverAnimation = list.get(i2);
                recoverAnimation.update();
                if (recoverAnimation.mViewHolder == viewHolder) {
                    float f5 = recoverAnimation.mX;
                    f4 = recoverAnimation.mY;
                    f3 = f5;
                } else {
                    int iSave = canvas.save();
                    onChildDraw(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, false, i);
                    canvas.restoreToCount(iSave);
                }
            }
            if (viewHolder != null) {
                int iSave2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f3, f4, true, i);
                canvas.restoreToCount(iSave2);
            }
        }

        void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<RecoverAnimation> list, float f, float f2) {
            int size = list.size();
            boolean z = false;
            for (int i = 0; i < size; i++) {
                RecoverAnimation recoverAnimation = list.get(i);
                int iSave = canvas.save();
                onChildDrawOver(canvas, recyclerView, recoverAnimation.mViewHolder, recoverAnimation.mX, recoverAnimation.mY, false);
                canvas.restoreToCount(iSave);
            }
            if (viewHolder != null) {
                int iSave2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, true);
                canvas.restoreToCount(iSave2);
            }
            for (int i2 = size - 1; i2 >= 0; i2--) {
                RecoverAnimation recoverAnimation2 = list.get(i2);
                if (recoverAnimation2.mEnded && !recoverAnimation2.mIsPendingCleanup) {
                    list.remove(i2);
                } else if (!recoverAnimation2.mEnded) {
                    z = true;
                }
            }
            if (z) {
                recyclerView.invalidate();
            }
        }

        protected boolean isOverThreshold(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i) {
            return (i == 1 || i == 2) ? Math.abs(f) >= ((float) recyclerView.getWidth()) * getSwipeThreshold(viewHolder) : Math.abs(f2) >= ((float) recyclerView.getHeight()) * getSwipeThreshold(viewHolder);
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, boolean z, int i) {
            View view = viewHolder.itemView;
            view.setTranslationX(f);
            view.setTranslationY(f2);
            if (!(viewHolder instanceof QMUISwipeViewHolder) || i == 0) {
                return;
            }
            ((QMUISwipeViewHolder) viewHolder).draw(canvas, isOverThreshold(recyclerView, viewHolder, f, f2, i), f, f2);
        }
    }
}
