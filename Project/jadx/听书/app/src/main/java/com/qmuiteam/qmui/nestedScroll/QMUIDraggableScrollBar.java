package com.qmuiteam.qmui.nestedScroll;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIDraggableScrollBar extends View {
    private int[] STATE_NORMAL;
    private int[] STATE_PRESSED;
    private boolean enableFadeInAndOut;
    private int mAdjustDistanceProtection;
    private boolean mAdjustDistanceWithAnimation;
    private int mAdjustMaxDistanceOnce;
    private Callback mCallback;
    private float mCurrentAlpha;
    private Runnable mDelayInvalidateRunnable;
    private Drawable mDragDrawable;
    private float mDragInnerTop;
    private int mDrawableDrawTop;
    private boolean mIsInDragging;
    private int mKeepShownTime;
    private float mPercent;
    private long mStartTransitionTime;
    private int mTransitionDuration;

    interface Callback {
        void onDragEnd();

        void onDragStarted();

        void onDragToPercent(float f);
    }

    protected int getScrollBarBottomMargin() {
        return 0;
    }

    protected int getScrollBarTopMargin() {
        return 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QMUIDraggableScrollBar(Context context) {
        this(context, (AttributeSet) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QMUIDraggableScrollBar(Context context, Drawable drawable) {
        this(context, (AttributeSet) null);
        this.mDragDrawable = drawable.mutate();
    }

    public QMUIDraggableScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.STATE_PRESSED = new int[]{R.attr.state_pressed};
        this.STATE_NORMAL = new int[0];
        this.mKeepShownTime = 800;
        this.mTransitionDuration = 100;
        this.mStartTransitionTime = 0L;
        this.mCurrentAlpha = 0.0f;
        this.mPercent = 0.0f;
        this.mDelayInvalidateRunnable = new Runnable() { // from class: com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar.1
            @Override // java.lang.Runnable
            public void run() {
                QMUIDraggableScrollBar.this.invalidate();
            }
        };
        this.mIsInDragging = false;
        this.mDrawableDrawTop = -1;
        this.mDragInnerTop = 0.0f;
        this.mAdjustDistanceProtection = QMUIDisplayHelper.dp2px(getContext(), 20);
        this.mAdjustMaxDistanceOnce = QMUIDisplayHelper.dp2px(getContext(), 4);
        this.mAdjustDistanceWithAnimation = true;
        this.enableFadeInAndOut = true;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setAdjustDistanceWithAnimation(boolean z) {
        this.mAdjustDistanceWithAnimation = z;
    }

    public void setKeepShownTime(int i) {
        this.mKeepShownTime = i;
    }

    public void setTransitionDuration(int i) {
        this.mTransitionDuration = i;
    }

    public void setEnableFadeInAndOut(boolean z) {
        this.enableFadeInAndOut = z;
    }

    public boolean isEnableFadeInAndOut() {
        return this.enableFadeInAndOut;
    }

    public void setDragDrawable(Drawable drawable) {
        this.mDragDrawable = drawable.mutate();
        invalidate();
    }

    public void setPercent(float f) {
        if (this.mIsInDragging) {
            return;
        }
        setPercentInternal(f);
    }

    private void setPercentInternal(float f) {
        this.mPercent = f;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        Drawable drawable = this.mDragDrawable;
        if (drawable == null) {
            super.onMeasure(i, i2);
        } else {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(drawable.getIntrinsicWidth(), 1073741824), i2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable = this.mDragDrawable;
        if (drawable == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.mIsInDragging = false;
            if (this.mCurrentAlpha > 0.0f && x > getWidth() - drawable.getIntrinsicWidth()) {
                if (y >= this.mDrawableDrawTop && y <= r1 + drawable.getIntrinsicHeight()) {
                    this.mDragInnerTop = y - this.mDrawableDrawTop;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.mIsInDragging = true;
                    Callback callback = this.mCallback;
                    if (callback != null) {
                        callback.onDragStarted();
                        this.mDragDrawable.setState(this.STATE_PRESSED);
                    }
                }
            }
        } else if (action == 2) {
            if (this.mIsInDragging) {
                getParent().requestDisallowInterceptTouchEvent(true);
                onDragging(drawable, y);
            }
        } else if ((action == 1 || action == 3) && this.mIsInDragging) {
            this.mIsInDragging = false;
            onDragging(drawable, y);
            Callback callback2 = this.mCallback;
            if (callback2 != null) {
                callback2.onDragEnd();
                this.mDragDrawable.setState(this.STATE_NORMAL);
            }
        }
        return this.mIsInDragging;
    }

    private void onDragging(Drawable drawable, float f) {
        float fConstrain = QMUILangHelper.constrain(((f - getScrollBarTopMargin()) - this.mDragInnerTop) / (((getHeight() - getScrollBarBottomMargin()) - getScrollBarTopMargin()) - drawable.getIntrinsicHeight()), 0.0f, 1.0f);
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onDragToPercent(fConstrain);
        }
        setPercentInternal(fConstrain);
    }

    public void awakenScrollBar() {
        if (this.mDragDrawable == null) {
            this.mDragDrawable = ContextCompat.getDrawable(getContext(), com.qmuiteam.qmui.R.drawable.qmui_icon_scroll_bar);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.mStartTransitionTime;
        int i = this.mTransitionDuration;
        if (j > i) {
            this.mStartTransitionTime = jCurrentTimeMillis - ((long) i);
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062 A[RETURN] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onDraw(android.graphics.Canvas r16) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qmuiteam.qmui.nestedScroll.QMUIDraggableScrollBar.onDraw(android.graphics.Canvas):void");
    }
}
