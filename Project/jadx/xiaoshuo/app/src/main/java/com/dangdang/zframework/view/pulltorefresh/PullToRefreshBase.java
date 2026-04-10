package com.dangdang.zframework.view.pulltorefresh;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.dangdang.zframework.R;

/* JADX INFO: loaded from: classes10.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    static final float FRICTION = 2.0f;
    static final int MANUAL_REFRESHING = 3;
    public static final int MODE_BOTH = 3;
    public static final int MODE_NONE = 4;
    public static final int MODE_PULL_DOWN_TO_REFRESH = 1;
    public static final int MODE_PULL_UP_TO_REFRESH = 2;
    static final int PULL_TO_REFRESH = 0;
    static final int REFRESHING = 2;
    static final int RELEASE_TO_REFRESH = 1;
    private int currentMode;
    private PullToRefreshBase<T>.SmoothScrollRunnable currentSmoothScrollRunnable;
    private boolean disableScrollingWhileRefreshing;
    private LoadingLayout footerLayout;
    private final Handler handler;
    private int headerHeight;
    private LoadingLayout headerLayout;
    private float initialMotionY;
    private boolean isBeingDragged;
    private boolean isPullToRefreshEnabled;
    private boolean isPullUpToRefreshEnabled;
    private float lastMotionX;
    private float lastMotionY;
    private Context mContext;
    protected ReadyForPullDownRefreshListener mReadyForPullDownRefreshListener;
    private int mode;
    protected OnRefreshListener onRefreshListener;
    public T refreshableView;
    protected int state;
    private int touchSlop;

    public interface OnLastItemVisibleListener {
        void onLastItemVisible();
    }

    public interface OnRefreshListener {
        void onPullDownRefresh();

        void onPullUpRefresh();
    }

    public interface ReadyForPullDownRefreshListener {
        void onReadyForPullDown(boolean z);
    }

    public final class SmoothScrollRunnable implements Runnable {
        static final int ANIMATION_DURATION_MS = 190;
        static final int ANIMATION_FPS = 16;
        private final Handler handler;
        private final int scrollFromY;
        private final int scrollToY;
        private boolean continueRunning = true;
        private long startTime = -1;
        private int currentY = -1;
        private final Interpolator interpolator = new AccelerateDecelerateInterpolator();

        public SmoothScrollRunnable(Handler handler, int i, int i2) {
            this.handler = handler;
            this.scrollFromY = i;
            this.scrollToY = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.startTime == -1) {
                this.startTime = System.currentTimeMillis();
            } else {
                int iRound = this.scrollFromY - Math.round((this.scrollFromY - this.scrollToY) * this.interpolator.getInterpolation(Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / 190, 1000L), 0L) / 1000.0f));
                this.currentY = iRound;
                PullToRefreshBase.this.setHeaderScroll(iRound);
            }
            if (!this.continueRunning || this.scrollToY == this.currentY) {
                return;
            }
            this.handler.postDelayed(this, 16L);
        }

        public void stop() {
            this.continueRunning = false;
            this.handler.removeCallbacks(this);
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        this.isBeingDragged = false;
        this.state = 0;
        this.mode = 1;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.isPullUpToRefreshEnabled = true;
        this.handler = new Handler();
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        init(context, attributeSet, null);
    }

    private boolean isReadyForPull() {
        int i = this.mode;
        if (i == 1) {
            return isReadyForPullDown();
        }
        if (i == 2) {
            return isReadyForPullUp();
        }
        if (i != 3) {
            return false;
        }
        return isReadyForPullUp() || isReadyForPullDown();
    }

    private void measureView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        int i = layoutParams.height;
        view.measure(childMeasureSpec, i > 0 ? View.MeasureSpec.makeMeasureSpec(i, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    private boolean pullEvent() {
        int iRound;
        int scrollY = getScrollY();
        int i = this.currentMode;
        if (i == 2) {
            iRound = Math.round(Math.max(this.initialMotionY - this.lastMotionY, 0.0f) / 2.0f);
        } else if (i != 4) {
            iRound = Math.round(Math.min(this.initialMotionY - this.lastMotionY, 0.0f) / 2.0f);
            this.headerLayout.scrollPullHeader(Math.abs(iRound), this.headerHeight);
        } else {
            iRound = 0;
        }
        setHeaderScroll(iRound);
        if (iRound != 0) {
            int i2 = this.state;
            if (i2 == 0) {
                if (this.headerHeight >= Math.abs(iRound)) {
                    int i3 = this.currentMode;
                    if (i3 == 1) {
                        this.headerLayout.setRefreshValid(1);
                    } else if (i3 == 2) {
                        this.footerLayout.setRefreshValid(2);
                    }
                    return true;
                }
                this.state = 1;
                int i4 = this.currentMode;
                if (i4 == 1) {
                    this.headerLayout.releaseToRefresh();
                } else if (i4 == 2) {
                    this.footerLayout.releaseToRefresh();
                }
                return true;
            }
            if (i2 == 1 && this.headerHeight >= Math.abs(iRound)) {
                this.state = 0;
                int i5 = this.currentMode;
                if (i5 == 1) {
                    this.headerLayout.pullToRefresh();
                } else if (i5 == 2) {
                    this.footerLayout.pullToRefresh();
                }
                return true;
            }
        }
        return scrollY != iRound;
    }

    public void addRefreshableView(Context context, T t) {
        addView(t, new LinearLayout.LayoutParams(-1, 0, 1.0f));
    }

    public void changeMode(int i) {
        int i2 = this.mode;
        if (i2 == 1) {
            removeView(this.headerLayout);
        } else if (i2 == 2) {
            removeView(this.footerLayout);
        } else if (i2 == 3) {
            removeView(this.headerLayout);
            removeView(this.footerLayout);
        }
        this.headerLayout = null;
        this.footerLayout = null;
        if (i == 1 || i == 3) {
            LoadingLayout downLoadingLayout = getDownLoadingLayout(this.mContext);
            this.headerLayout = downLoadingLayout;
            addView(downLoadingLayout, 0, new LinearLayout.LayoutParams(-1, -2));
            measureView(this.headerLayout);
            this.headerHeight = this.headerLayout.getMeasuredHeight();
        }
        if (i == 2 || i == 3) {
            LoadingLayout upLoadingLayout = getUpLoadingLayout(this.mContext);
            this.footerLayout = upLoadingLayout;
            addView(upLoadingLayout, new LinearLayout.LayoutParams(-1, -2));
            measureView(this.footerLayout);
            this.headerHeight = this.footerLayout.getMeasuredHeight();
        }
        if (i == 4) {
            this.headerHeight = 0;
        }
        if (i == 2) {
            setPadding(0, 0, 0, -this.headerHeight);
        } else if (i != 3) {
            setPadding(0, -this.headerHeight, 0, 0);
        } else {
            int i3 = this.headerHeight;
            setPadding(0, -i3, 0, -i3);
        }
        this.mode = i;
    }

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public final T getAdapterView() {
        return this.refreshableView;
    }

    public final int getCurrentMode() {
        return this.currentMode;
    }

    public LoadingLayout getDownLoadingLayout(Context context) {
        return new ProgressLoadingLayout(context, 1, context.getString(R.string.pull_to_refresh_release_label), context.getString(R.string.pull_to_refresh_pull_label), context.getString(R.string.pull_to_refresh_refreshing_label));
    }

    public final LoadingLayout getFooterLayout() {
        return this.footerLayout;
    }

    public final int getHeaderHeight() {
        return this.headerHeight;
    }

    public final LoadingLayout getHeaderLayout() {
        return this.headerLayout;
    }

    public final int getMode() {
        return this.mode;
    }

    public final T getRefreshableView() {
        return this.refreshableView;
    }

    public LoadingLayout getUpLoadingLayout(Context context) {
        return new ProgressLoadingLayout(context, 2, context.getString(R.string.pull_up_to_refresh_release_label), context.getString(R.string.pull_up_to_refresh_pull_label), context.getString(R.string.pull_to_refresh_refreshing_label));
    }

    public final boolean hasPullFromTop() {
        int i = this.currentMode;
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        return this.disableScrollingWhileRefreshing;
    }

    public final boolean isPullToRefreshEnabled() {
        return this.isPullToRefreshEnabled;
    }

    public final boolean isPullUpToRefreshEnabled() {
        return this.isPullUpToRefreshEnabled;
    }

    public abstract boolean isReadyForPullDown();

    public abstract boolean isReadyForPullUp();

    public final boolean isRefreshing() {
        int i = this.state;
        return i == 2 || i == 3;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (isRefreshing() && this.disableScrollingWhileRefreshing) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.isBeingDragged = false;
            return false;
        }
        if (action != 0 && this.isBeingDragged) {
            return true;
        }
        if (action != 0) {
            if (action == 2 && isReadyForPull()) {
                float y = motionEvent.getY();
                float f = y - this.lastMotionY;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(motionEvent.getX() - this.lastMotionX);
                if (fAbs > this.touchSlop && fAbs > fAbs2) {
                    int i = this.mode;
                    if ((i == 1 || i == 3) && f >= 1.0E-4f && isReadyForPullDown()) {
                        this.lastMotionY = y;
                        this.isBeingDragged = true;
                        this.currentMode = 1;
                        ReadyForPullDownRefreshListener readyForPullDownRefreshListener = this.mReadyForPullDownRefreshListener;
                        if (readyForPullDownRefreshListener != null) {
                            readyForPullDownRefreshListener.onReadyForPullDown(false);
                        }
                    } else {
                        int i2 = this.mode;
                        if ((i2 == 2 || i2 == 3) && f <= 1.0E-4f && isReadyForPullUp()) {
                            this.lastMotionY = y;
                            this.isBeingDragged = true;
                            this.currentMode = 2;
                        }
                    }
                }
            }
        } else if (isReadyForPull()) {
            float y2 = motionEvent.getY();
            this.initialMotionY = y2;
            this.lastMotionY = y2;
            this.lastMotionX = motionEvent.getX();
            this.isBeingDragged = false;
        }
        return this.isBeingDragged;
    }

    public void onRefreshComplete() {
        if (this.state != 0) {
            resetHeader();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.isRefreshing()
            r1 = 1
            if (r0 == 0) goto Lc
            boolean r0 = r4.disableScrollingWhileRefreshing
            if (r0 == 0) goto Lc
            return r1
        Lc:
            int r0 = r5.getAction()
            r2 = 0
            if (r0 != 0) goto L1a
            int r0 = r5.getEdgeFlags()
            if (r0 == 0) goto L1a
            return r2
        L1a:
            int r0 = r5.getAction()
            if (r0 == 0) goto L5e
            r3 = 2
            if (r0 == r1) goto L37
            if (r0 == r3) goto L29
            r5 = 3
            if (r0 == r5) goto L37
            goto L6d
        L29:
            boolean r0 = r4.isBeingDragged
            if (r0 == 0) goto L6d
            float r5 = r5.getY()
            r4.lastMotionY = r5
            r4.pullEvent()
            return r1
        L37:
            boolean r5 = r4.isBeingDragged
            if (r5 == 0) goto L6d
            r4.isBeingDragged = r2
            int r5 = r4.state
            if (r5 != r1) goto L5a
            com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase$OnRefreshListener r5 = r4.onRefreshListener
            if (r5 == 0) goto L5a
            r4.setRefreshingInternal(r1)
            int r5 = r4.currentMode
            if (r5 != r3) goto L52
            com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase$OnRefreshListener r5 = r4.onRefreshListener
            r5.onPullUpRefresh()
            goto L5d
        L52:
            if (r5 != r1) goto L5d
            com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase$OnRefreshListener r5 = r4.onRefreshListener
            r5.onPullDownRefresh()
            goto L5d
        L5a:
            r4.smoothScrollTo(r2)
        L5d:
            return r1
        L5e:
            boolean r0 = r4.isReadyForPull()
            if (r0 == 0) goto L6d
            float r5 = r5.getY()
            r4.initialMotionY = r5
            r4.lastMotionY = r5
            return r1
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dangdang.zframework.view.pulltorefresh.PullToRefreshBase.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void resetHeader() {
        this.state = 0;
        this.isBeingDragged = false;
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.reset();
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.reset();
        }
        smoothScrollTo(0);
    }

    public void setCurrentMode(int i) {
        this.currentMode = i;
    }

    public final void setDisableScrollingWhileRefreshing(boolean z) {
        this.disableScrollingWhileRefreshing = z;
    }

    public void setFooterBackgroundColor(int i) {
        LoadingLayout loadingLayout = this.footerLayout;
        if (loadingLayout != null) {
            loadingLayout.setLoadingBackgroundColor(i);
        }
    }

    public void setHeaderBackgroundColor(int i) {
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setLoadingBackgroundColor(i);
        }
    }

    public final void setHeaderScroll(int i) {
        scrollTo(0, i);
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.onRefreshListener = onRefreshListener;
    }

    public void setPullLabel(String str) {
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setPullLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setPullLabel(str);
        }
    }

    public final void setPullToRefreshEnabled(boolean z) {
        this.isPullToRefreshEnabled = z;
    }

    public final void setPullUpToRefreshEnabled(boolean z) {
        this.isPullUpToRefreshEnabled = z;
    }

    public void setReadyForPullDownRefreshListener(ReadyForPullDownRefreshListener readyForPullDownRefreshListener) {
        this.mReadyForPullDownRefreshListener = readyForPullDownRefreshListener;
    }

    public void setRefreshMode(int i) {
        if (this.mode == i) {
            return;
        }
        changeMode(i);
    }

    public final void setRefreshing() {
        setRefreshing(true);
    }

    public void setRefreshingInternal(boolean z) {
        this.state = 2;
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null && this.currentMode == 1) {
            loadingLayout.refreshing();
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null && this.currentMode == 2) {
            loadingLayout2.refreshing();
        }
        if (z) {
            smoothScrollTo(this.currentMode == 1 ? -this.headerHeight : this.headerHeight);
        }
    }

    public void setRefreshingLabel(String str) {
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setRefreshingLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setRefreshingLabel(str);
        }
    }

    public void setReleaseLabel(String str) {
        LoadingLayout loadingLayout = this.headerLayout;
        if (loadingLayout != null) {
            loadingLayout.setReleaseLabel(str);
        }
        LoadingLayout loadingLayout2 = this.footerLayout;
        if (loadingLayout2 != null) {
            loadingLayout2.setReleaseLabel(str);
        }
    }

    public final void smoothScrollTo(int i) {
        PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable = this.currentSmoothScrollRunnable;
        if (smoothScrollRunnable != null) {
            smoothScrollRunnable.stop();
        }
        if (getScrollY() != i) {
            PullToRefreshBase<T>.SmoothScrollRunnable smoothScrollRunnable2 = new SmoothScrollRunnable(this.handler, getScrollY(), i);
            this.currentSmoothScrollRunnable = smoothScrollRunnable2;
            this.handler.post(smoothScrollRunnable2);
        }
    }

    private void init(Context context, AttributeSet attributeSet, T t) {
        this.mContext = context;
        setOrientation(1);
        this.touchSlop = ViewConfiguration.getTouchSlop();
        if (t != null) {
            this.refreshableView = t;
        } else {
            this.refreshableView = (T) createRefreshableView(context, attributeSet);
        }
        addRefreshableView(context, this.refreshableView);
        int i = this.mode;
        if (i == 1 || i == 3) {
            LoadingLayout downLoadingLayout = getDownLoadingLayout(context);
            this.headerLayout = downLoadingLayout;
            addView(downLoadingLayout, 0, new LinearLayout.LayoutParams(-1, -2));
            measureView(this.headerLayout);
            this.headerHeight = this.headerLayout.getMeasuredHeight();
        }
        int i2 = this.mode;
        if (i2 == 2 || i2 == 3) {
            LoadingLayout upLoadingLayout = getUpLoadingLayout(context);
            this.footerLayout = upLoadingLayout;
            addView(upLoadingLayout, new LinearLayout.LayoutParams(-1, -2));
            measureView(this.footerLayout);
            this.headerHeight = this.footerLayout.getMeasuredHeight();
        }
        int i3 = this.mode;
        if (i3 == 4) {
            this.headerHeight = 0;
        }
        if (i3 == 2) {
            setPadding(0, 0, 0, -this.headerHeight);
        } else if (i3 != 3) {
            setPadding(0, -this.headerHeight, 0, 0);
        } else {
            int i4 = this.headerHeight;
            setPadding(0, -i4, 0, -i4);
        }
        int i5 = this.mode;
        if (i5 != 3) {
            this.currentMode = i5;
        }
    }

    public final void setRefreshing(boolean z) {
        if (isRefreshing()) {
            return;
        }
        setRefreshingInternal(z);
        this.state = 3;
    }

    public PullToRefreshBase(Context context, int i) {
        super(context);
        this.isBeingDragged = false;
        this.state = 0;
        this.mode = 1;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.isPullUpToRefreshEnabled = true;
        this.handler = new Handler();
        this.mode = i;
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isBeingDragged = false;
        this.state = 0;
        this.mode = 1;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.isPullUpToRefreshEnabled = true;
        this.handler = new Handler();
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, int i, T t) {
        super(context);
        this.isBeingDragged = false;
        this.state = 0;
        this.mode = 1;
        this.disableScrollingWhileRefreshing = true;
        this.isPullToRefreshEnabled = true;
        this.isPullUpToRefreshEnabled = true;
        this.handler = new Handler();
        this.mode = i;
        init(context, null, t);
    }
}
