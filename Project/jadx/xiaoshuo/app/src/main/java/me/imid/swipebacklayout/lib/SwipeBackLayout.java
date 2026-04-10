package me.imid.swipebacklayout.lib;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.imid.swipebacklayout.lib.ViewDragHelper;

/* JADX INFO: loaded from: classes8.dex */
public class SwipeBackLayout extends FrameLayout {
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final float DEFAULT_SCROLL_THRESHOLD = 0.3f;
    public static final int EDGE_ALL = 11;
    public static final int EDGE_BOTTOM = 8;
    private static final int[] EDGE_FLAGS = {1, 2, 8, 11};
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int FULL_ALPHA = 255;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int OVERSCROLL_DISTANCE = 10;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private Activity mActivity;
    private int mContentLeft;
    private int mContentTop;
    private View mContentView;
    private ViewDragHelper mDragHelper;
    private int mEdgeFlag;
    private boolean mEnable;
    private boolean mInLayout;
    private List<SwipeListener> mListeners;
    private int mScrimColor;
    private float mScrimOpacity;
    private float mScrollPercent;
    private float mScrollThreshold;
    private Drawable mShadowBottom;
    private Drawable mShadowLeft;
    private Drawable mShadowRight;
    private Rect mTmpRect;
    private int mTrackingEdge;

    public interface SwipeListener {
        void onEdgeTouch(int i);

        void onScrollOverThreshold();

        void onScrollStateChange(int i, float f);
    }

    public class ViewDragCallback extends ViewDragHelper.Callback {
        private boolean mIsScrollOverValid;

        private ViewDragCallback() {
        }

        @Override // me.imid.swipebacklayout.lib.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if ((SwipeBackLayout.this.mTrackingEdge & 1) != 0) {
                return Math.min(view.getWidth(), Math.max(i, 0));
            }
            if ((SwipeBackLayout.this.mTrackingEdge & 2) != 0) {
                return Math.min(0, Math.max(i, -view.getWidth()));
            }
            return 0;
        }

        @Override // me.imid.swipebacklayout.lib.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            if ((SwipeBackLayout.this.mTrackingEdge & 8) != 0) {
                return Math.min(0, Math.max(i, -view.getHeight()));
            }
            return 0;
        }

        @Override // me.imid.swipebacklayout.lib.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SwipeBackLayout.this.mEdgeFlag & 3;
        }

        @Override // me.imid.swipebacklayout.lib.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return SwipeBackLayout.this.mEdgeFlag & 8;
        }

        @Override // me.imid.swipebacklayout.lib.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            super.onViewDragStateChanged(i);
            if (SwipeBackLayout.this.mListeners == null || SwipeBackLayout.this.mListeners.isEmpty()) {
                return;
            }
            Iterator it = SwipeBackLayout.this.mListeners.iterator();
            while (it.hasNext()) {
                ((SwipeListener) it.next()).onScrollStateChange(i, SwipeBackLayout.this.mScrollPercent);
            }
        }

        @Override // me.imid.swipebacklayout.lib.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            super.onViewPositionChanged(view, i, i2, i3, i4);
            if ((SwipeBackLayout.this.mTrackingEdge & 1) != 0) {
                SwipeBackLayout.this.mScrollPercent = Math.abs(i / (r3.mContentView.getWidth() + SwipeBackLayout.this.mShadowLeft.getIntrinsicWidth()));
            } else if ((SwipeBackLayout.this.mTrackingEdge & 2) != 0) {
                SwipeBackLayout.this.mScrollPercent = Math.abs(i / (r3.mContentView.getWidth() + SwipeBackLayout.this.mShadowRight.getIntrinsicWidth()));
            } else if ((SwipeBackLayout.this.mTrackingEdge & 8) != 0) {
                SwipeBackLayout.this.mScrollPercent = Math.abs(i2 / (r3.mContentView.getHeight() + SwipeBackLayout.this.mShadowBottom.getIntrinsicHeight()));
            }
            SwipeBackLayout.this.mContentLeft = i;
            SwipeBackLayout.this.mContentTop = i2;
            SwipeBackLayout.this.invalidate();
            if (SwipeBackLayout.this.mScrollPercent < SwipeBackLayout.this.mScrollThreshold && !this.mIsScrollOverValid) {
                this.mIsScrollOverValid = true;
            }
            if (SwipeBackLayout.this.mListeners != null && !SwipeBackLayout.this.mListeners.isEmpty() && SwipeBackLayout.this.mDragHelper.getViewDragState() == 1 && SwipeBackLayout.this.mScrollPercent >= SwipeBackLayout.this.mScrollThreshold && this.mIsScrollOverValid) {
                this.mIsScrollOverValid = false;
                Iterator it = SwipeBackLayout.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((SwipeListener) it.next()).onScrollOverThreshold();
                }
            }
            if (SwipeBackLayout.this.mScrollPercent < 1.0f || SwipeBackLayout.this.mActivity.isFinishing()) {
                return;
            }
            SwipeBackLayout.this.mActivity.finish();
        }

        @Override // me.imid.swipebacklayout.lib.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            int width = view.getWidth();
            int height = view.getHeight();
            int intrinsicWidth = 0;
            if ((SwipeBackLayout.this.mTrackingEdge & 1) != 0) {
                i = 0;
                intrinsicWidth = (f > 0.0f || (f == 0.0f && SwipeBackLayout.this.mScrollPercent > SwipeBackLayout.this.mScrollThreshold)) ? width + SwipeBackLayout.this.mShadowLeft.getIntrinsicWidth() + 10 : 0;
            } else if ((SwipeBackLayout.this.mTrackingEdge & 2) != 0) {
                intrinsicWidth = (f < 0.0f || (f == 0.0f && SwipeBackLayout.this.mScrollPercent > SwipeBackLayout.this.mScrollThreshold)) ? -(width + SwipeBackLayout.this.mShadowLeft.getIntrinsicWidth() + 10) : 0;
                i = 0;
            } else {
                i = ((SwipeBackLayout.this.mTrackingEdge & 8) == 0 || (f2 >= 0.0f && (f2 != 0.0f || SwipeBackLayout.this.mScrollPercent <= SwipeBackLayout.this.mScrollThreshold))) ? 0 : -(height + SwipeBackLayout.this.mShadowBottom.getIntrinsicHeight() + 10);
            }
            SwipeBackLayout.this.mDragHelper.settleCapturedViewAt(intrinsicWidth, i);
            SwipeBackLayout.this.invalidate();
        }

        @Override // me.imid.swipebacklayout.lib.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            boolean zIsEdgeTouched = SwipeBackLayout.this.mDragHelper.isEdgeTouched(SwipeBackLayout.this.mEdgeFlag, i);
            if (zIsEdgeTouched) {
                if (SwipeBackLayout.this.mDragHelper.isEdgeTouched(1, i)) {
                    SwipeBackLayout.this.mTrackingEdge = 1;
                } else if (SwipeBackLayout.this.mDragHelper.isEdgeTouched(2, i)) {
                    SwipeBackLayout.this.mTrackingEdge = 2;
                } else if (SwipeBackLayout.this.mDragHelper.isEdgeTouched(8, i)) {
                    SwipeBackLayout.this.mTrackingEdge = 8;
                }
                if (SwipeBackLayout.this.mListeners != null && !SwipeBackLayout.this.mListeners.isEmpty()) {
                    Iterator it = SwipeBackLayout.this.mListeners.iterator();
                    while (it.hasNext()) {
                        ((SwipeListener) it.next()).onEdgeTouch(SwipeBackLayout.this.mTrackingEdge);
                    }
                }
                this.mIsScrollOverValid = true;
            }
            return zIsEdgeTouched;
        }
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    private void drawScrim(Canvas canvas, View view) {
        int i = (this.mScrimColor & 16777215) | (((int) ((((-16777216) & r0) >>> 24) * this.mScrimOpacity)) << 24);
        int i2 = this.mTrackingEdge;
        if ((i2 & 1) != 0) {
            canvas.clipRect(0, 0, view.getLeft(), getHeight());
        } else if ((i2 & 2) != 0) {
            canvas.clipRect(view.getRight(), 0, getRight(), getHeight());
        } else if ((i2 & 8) != 0) {
            canvas.clipRect(view.getLeft(), view.getBottom(), getRight(), getHeight());
        }
        canvas.drawColor(i);
    }

    private void drawShadow(Canvas canvas, View view) {
        Rect rect = this.mTmpRect;
        view.getHitRect(rect);
        if ((this.mEdgeFlag & 1) != 0) {
            Drawable drawable2 = this.mShadowLeft;
            drawable2.setBounds(rect.left - drawable2.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.mShadowLeft.setAlpha((int) (this.mScrimOpacity * 255.0f));
            this.mShadowLeft.draw(canvas);
        }
        if ((this.mEdgeFlag & 2) != 0) {
            Drawable drawable3 = this.mShadowRight;
            int i = rect.right;
            drawable3.setBounds(i, rect.top, drawable3.getIntrinsicWidth() + i, rect.bottom);
            this.mShadowRight.setAlpha((int) (this.mScrimOpacity * 255.0f));
            this.mShadowRight.draw(canvas);
        }
        if ((this.mEdgeFlag & 8) != 0) {
            Drawable drawable4 = this.mShadowBottom;
            int i2 = rect.left;
            int i3 = rect.bottom;
            drawable4.setBounds(i2, i3, rect.right, drawable4.getIntrinsicHeight() + i3);
            this.mShadowBottom.setAlpha((int) (this.mScrimOpacity * 255.0f));
            this.mShadowBottom.draw(canvas);
        }
    }

    private void setContentView(View view) {
        this.mContentView = view;
    }

    public void addSwipeListener(SwipeListener swipeListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(swipeListener);
    }

    public void attachToActivity(Activity activity) {
        this.mActivity = activity;
        TypedArray typedArrayObtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{R.attr.windowBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(resourceId);
        viewGroup.removeView(viewGroup2);
        addView(viewGroup2);
        setContentView(viewGroup2);
        viewGroup.addView(this);
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mScrimOpacity = 1.0f - this.mScrollPercent;
        if (this.mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        try {
            boolean z = view == this.mContentView;
            boolean zDrawChild = super.drawChild(canvas, view, j);
            if (this.mScrimOpacity > 0.0f && z && this.mDragHelper.getViewDragState() != 0) {
                drawShadow(canvas, view);
                drawScrim(canvas, view);
            }
            return zDrawChild;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnable) {
            return false;
        }
        try {
            return this.mDragHelper.shouldInterceptTouchEvent(motionEvent);
        } catch (ArrayIndexOutOfBoundsException unused) {
            return false;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        View view = this.mContentView;
        if (view != null) {
            int i5 = this.mContentLeft;
            view.layout(i5, this.mContentTop, view.getMeasuredWidth() + i5, this.mContentTop + this.mContentView.getMeasuredHeight());
        }
        this.mInLayout = false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnable) {
            return false;
        }
        this.mDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    public void removeSwipeListener(SwipeListener swipeListener) {
        List<SwipeListener> list = this.mListeners;
        if (list == null) {
            return;
        }
        list.remove(swipeListener);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    public void scrollToFinishActivity() {
        int intrinsicHeight;
        int intrinsicWidth;
        int width = this.mContentView.getWidth();
        int height = this.mContentView.getHeight();
        int i = this.mEdgeFlag;
        int i2 = 0;
        if ((i & 1) != 0) {
            intrinsicWidth = width + this.mShadowLeft.getIntrinsicWidth() + 10;
            this.mTrackingEdge = 1;
        } else {
            if ((i & 2) == 0) {
                if ((i & 8) != 0) {
                    intrinsicHeight = ((-height) - this.mShadowBottom.getIntrinsicHeight()) - 10;
                    this.mTrackingEdge = 8;
                } else {
                    intrinsicHeight = 0;
                }
                this.mDragHelper.smoothSlideViewTo(this.mContentView, i2, intrinsicHeight);
                invalidate();
            }
            intrinsicWidth = ((-width) - this.mShadowRight.getIntrinsicWidth()) - 10;
            this.mTrackingEdge = 2;
        }
        intrinsicHeight = 0;
        i2 = intrinsicWidth;
        this.mDragHelper.smoothSlideViewTo(this.mContentView, i2, intrinsicHeight);
        invalidate();
    }

    public void setEdgeSize(int i) {
        this.mDragHelper.setEdgeSize(i);
    }

    public void setEdgeTrackingEnabled(int i) {
        this.mEdgeFlag = i;
        this.mDragHelper.setEdgeTrackingEnabled(i);
    }

    public void setEnableGesture(boolean z) {
        this.mEnable = z;
    }

    public void setScrimColor(int i) {
        this.mScrimColor = i;
        invalidate();
    }

    public void setScrollThresHold(float f) {
        if (f >= 1.0f || f <= 0.0f) {
            throw new IllegalArgumentException("Threshold value should be between 0 and 1.0");
        }
        this.mScrollThreshold = f;
    }

    public void setSensitivity(Context context, float f) {
        this.mDragHelper.setSensitivity(context, f);
    }

    public void setShadow(Drawable drawable2, int i) {
        if ((i & 1) != 0) {
            this.mShadowLeft = drawable2;
        } else if ((i & 2) != 0) {
            this.mShadowRight = drawable2;
        } else if ((i & 8) != 0) {
            this.mShadowBottom = drawable2;
        }
        invalidate();
    }

    @Deprecated
    public void setSwipeListener(SwipeListener swipeListener) {
        addSwipeListener(swipeListener);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.dangdang.zframework.R.attr.SwipeBackLayoutStyle);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mScrollThreshold = 0.3f;
        this.mEnable = true;
        this.mScrimColor = -1728053248;
        this.mTmpRect = new Rect();
        this.mDragHelper = ViewDragHelper.create(this, new ViewDragCallback());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.dangdang.zframework.R.styleable.SwipeBackLayout, i, com.dangdang.zframework.R.style.SwipeBackLayout);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(com.dangdang.zframework.R.styleable.SwipeBackLayout_edge_size, -1);
        if (dimensionPixelSize > 0) {
            setEdgeSize(dimensionPixelSize);
        }
        setEdgeTrackingEnabled(EDGE_FLAGS[typedArrayObtainStyledAttributes.getInt(com.dangdang.zframework.R.styleable.SwipeBackLayout_edge_flag, 0)]);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.dangdang.zframework.R.styleable.SwipeBackLayout_shadow_left, com.dangdang.zframework.R.drawable.swipe_shadow_left);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(com.dangdang.zframework.R.styleable.SwipeBackLayout_shadow_right, com.dangdang.zframework.R.drawable.swipe_shadow_right);
        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(com.dangdang.zframework.R.styleable.SwipeBackLayout_shadow_bottom, com.dangdang.zframework.R.drawable.swipe_shadow_bottom);
        setShadow(resourceId, 1);
        setShadow(resourceId2, 2);
        setShadow(resourceId3, 8);
        typedArrayObtainStyledAttributes.recycle();
        float f = getResources().getDisplayMetrics().density * 400.0f;
        this.mDragHelper.setMinVelocity(f);
        this.mDragHelper.setMaxVelocity(f * 2.0f);
    }

    public void setShadow(int i, int i2) {
        setShadow(getResources().getDrawable(i), i2);
    }
}
