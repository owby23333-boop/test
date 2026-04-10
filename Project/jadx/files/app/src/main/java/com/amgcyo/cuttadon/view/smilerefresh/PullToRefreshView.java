package com.amgcyo.cuttadon.view.smilerefresh;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes.dex */
public class PullToRefreshView extends ViewGroup implements NestedScrollingParent, NestedScrollingChild {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final String f5528i0 = SwipeRefreshLayout.class.getSimpleName();

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private static final int[] f5529j0 = {R.attr.enabled};
    private final int[] A;
    private final int[] B;
    private boolean C;
    private int D;
    int E;
    private float F;
    private float G;
    private boolean H;
    private int I;
    boolean J;
    private boolean K;
    private DecelerateInterpolator L;
    CircleImageView M;
    private int N;
    protected int O;
    float P;
    protected int Q;
    SmileProgressDrawable R;
    private Animation S;
    private Animation T;
    private Animation U;
    private Animation V;
    private Animation W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    float f5530a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    boolean f5531b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private int f5532c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    boolean f5533d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private i f5534e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private Animation.AnimationListener f5535f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final Animation f5536g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final Animation f5537h0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f5538s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    j f5539t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    boolean f5540u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f5541v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f5542w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f5543x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private NestedScrollingParentHelper f5544y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private NestedScrollingChildHelper f5545z;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            j jVar;
            PullToRefreshView pullToRefreshView = PullToRefreshView.this;
            if (!pullToRefreshView.f5540u) {
                pullToRefreshView.b();
                return;
            }
            pullToRefreshView.R.setAlpha(255);
            PullToRefreshView.this.R.start();
            PullToRefreshView pullToRefreshView2 = PullToRefreshView.this;
            if (pullToRefreshView2.f5531b0 && (jVar = pullToRefreshView2.f5539t) != null) {
                jVar.onRefresh();
            }
            PullToRefreshView pullToRefreshView3 = PullToRefreshView.this;
            pullToRefreshView3.E = pullToRefreshView3.M.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class b extends Animation {
        b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            PullToRefreshView.this.setAnimationProgress(f2);
        }
    }

    class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            PullToRefreshView.this.setAnimationProgress(1.0f - f2);
        }
    }

    class d extends Animation {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f5548s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f5549t;

        d(int i2, int i3) {
            this.f5548s = i2;
            this.f5549t = i3;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            PullToRefreshView.this.R.setAlpha((int) (this.f5548s + ((this.f5549t - r0) * f2)));
        }
    }

    class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PullToRefreshView pullToRefreshView = PullToRefreshView.this;
            if (pullToRefreshView.J) {
                return;
            }
            pullToRefreshView.a((Animation.AnimationListener) null);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class f extends Animation {
        f() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            PullToRefreshView pullToRefreshView = PullToRefreshView.this;
            int iAbs = !pullToRefreshView.f5533d0 ? (int) (pullToRefreshView.f5530a0 - Math.abs(pullToRefreshView.Q)) : (int) pullToRefreshView.f5530a0;
            PullToRefreshView pullToRefreshView2 = PullToRefreshView.this;
            PullToRefreshView.this.a((pullToRefreshView2.O + ((int) ((iAbs - r1) * f2))) - pullToRefreshView2.M.getTop(), false);
        }
    }

    class g extends Animation {
        g() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            PullToRefreshView.this.a(f2);
        }
    }

    class h extends Animation {
        h() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, Transformation transformation) {
            PullToRefreshView pullToRefreshView = PullToRefreshView.this;
            float f3 = pullToRefreshView.P;
            pullToRefreshView.setAnimationProgress(f3 + ((-f3) * f2));
            PullToRefreshView.this.a(f2);
        }
    }

    public interface i {
        boolean a(PullToRefreshView pullToRefreshView, @Nullable View view);
    }

    public interface j {
        void onRefresh();
    }

    public PullToRefreshView(Context context) {
        this(context, null);
    }

    private void a(boolean z2, boolean z3) {
        if (this.f5540u != z2) {
            this.f5531b0 = z3;
            d();
            this.f5540u = z2;
            if (this.f5540u) {
                a(this.E, this.f5535f0);
            } else {
                a(this.f5535f0);
            }
        }
    }

    private void c() {
        this.M = new CircleImageView(getContext(), -328966);
        this.R = new SmileProgressDrawable(getContext(), this);
        this.R.b(-328966);
        this.M.setImageDrawable(this.R);
        this.M.setVisibility(8);
        addView(this.M);
    }

    private void d() {
        if (this.f5538s == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.M)) {
                    this.f5538s = childAt;
                    return;
                }
            }
        }
    }

    private boolean e() {
        return Build.VERSION.SDK_INT < 11;
    }

    private void f() {
        this.V = a(this.R.getAlpha(), 255);
    }

    private void g() {
        this.U = a(this.R.getAlpha(), 76);
    }

    private void setColorViewAlpha(int i2) {
        Drawable background = this.M.getBackground();
        if (background != null) {
            background.setAlpha(i2);
        }
        this.R.setAlpha(i2);
    }

    void b() {
        this.M.clearAnimation();
        this.R.stop();
        this.M.setVisibility(8);
        setColorViewAlpha(255);
        if (this.J) {
            setAnimationProgress(0.0f);
        } else {
            a(this.Q - this.E, true);
        }
        this.E = this.M.getTop();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.f5545z.dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f5545z.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f5545z.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f5545z.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.N;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f5544y.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.f5532c0;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f5545z.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f5545z.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0051  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r4.d()
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r5)
            boolean r1 = r4.K
            r2 = 0
            if (r1 == 0) goto L10
            if (r0 != 0) goto L10
            r4.K = r2
        L10:
            boolean r1 = r4.isEnabled()
            if (r1 == 0) goto L7c
            boolean r1 = r4.K
            if (r1 != 0) goto L7c
            boolean r1 = r4.a()
            if (r1 != 0) goto L7c
            boolean r1 = r4.f5540u
            if (r1 != 0) goto L7c
            boolean r1 = r4.C
            if (r1 == 0) goto L29
            goto L7c
        L29:
            r1 = 1
            if (r0 == 0) goto L56
            r3 = -1
            if (r0 == r1) goto L51
            r1 = 2
            if (r0 == r1) goto L3d
            r1 = 3
            if (r0 == r1) goto L51
            r1 = 6
            if (r0 == r1) goto L39
            goto L79
        L39:
            r4.a(r5)
            goto L79
        L3d:
            int r0 = r4.I
            if (r0 != r3) goto L42
            return r2
        L42:
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L49
            return r2
        L49:
            float r5 = r5.getY(r0)
            r4.d(r5)
            goto L79
        L51:
            r4.H = r2
            r4.I = r3
            goto L79
        L56:
            int r0 = r4.Q
            com.amgcyo.cuttadon.view.smilerefresh.CircleImageView r3 = r4.M
            int r3 = r3.getTop()
            int r0 = r0 - r3
            r4.a(r0, r1)
            int r0 = r5.getPointerId(r2)
            r4.I = r0
            r4.H = r2
            int r0 = r4.I
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L73
            return r2
        L73:
            float r5 = r5.getY(r0)
            r4.G = r5
        L79:
            boolean r5 = r4.H
            return r5
        L7c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amgcyo.cuttadon.view.smilerefresh.PullToRefreshView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f5538s == null) {
            d();
        }
        View view = this.f5538s;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        CircleImageView circleImageView = this.M;
        if (circleImageView != null) {
            int measuredWidth2 = circleImageView.getMeasuredWidth();
            int measuredHeight2 = this.M.getMeasuredHeight();
            int i6 = measuredWidth / 2;
            int i7 = measuredWidth2 / 2;
            int i8 = this.E;
            this.M.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f5538s == null) {
            d();
        }
        View view = this.f5538s;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        CircleImageView circleImageView = this.M;
        if (circleImageView != null) {
            circleImageView.measure(View.MeasureSpec.makeMeasureSpec(this.f5532c0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f5532c0, 1073741824));
            this.N = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.M) {
                    this.N = i4;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f5543x;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f5543x = 0.0f;
                } else {
                    this.f5543x = f2 - f3;
                    iArr[1] = i3;
                }
                c(this.f5543x);
            }
        }
        if (this.f5533d0 && i3 > 0 && this.f5543x == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.M.setVisibility(8);
        }
        int[] iArr2 = this.A;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.B);
        if (i5 + this.B[1] >= 0 || a()) {
            return;
        }
        this.f5543x += Math.abs(r11);
        c(this.f5543x);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f5544y.onNestedScrollAccepted(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f5543x = 0.0f;
        this.C = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.K || this.f5540u || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.f5544y.onStopNestedScroll(view);
        this.C = false;
        float f2 = this.f5543x;
        if (f2 > 0.0f) {
            b(f2);
            this.f5543x = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.K && actionMasked == 0) {
            this.K = false;
        }
        if (!isEnabled() || this.K || a() || this.f5540u || this.C) {
            return false;
        }
        if (actionMasked == 0) {
            this.I = motionEvent.getPointerId(0);
            this.H = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.I);
                if (iFindPointerIndex < 0) {
                    return false;
                }
                if (this.H) {
                    float y2 = (motionEvent.getY(iFindPointerIndex) - this.F) * 0.5f;
                    this.H = false;
                    b(y2);
                }
                this.I = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.I);
                if (iFindPointerIndex2 < 0) {
                    return false;
                }
                float y3 = motionEvent.getY(iFindPointerIndex2);
                d(y3);
                if (this.H) {
                    float f2 = (y3 - this.F) * 0.5f;
                    if (f2 <= 0.0f) {
                        return false;
                    }
                    c(f2);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    if (actionIndex < 0) {
                        return false;
                    }
                    this.I = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    a(motionEvent);
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f5538s instanceof AbsListView)) {
            View view = this.f5538s;
            if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
                super.requestDisallowInterceptTouchEvent(z2);
            }
        }
    }

    void setAnimationProgress(float f2) {
        if (e()) {
            setColorViewAlpha((int) (f2 * 255.0f));
        } else {
            ViewCompat.setScaleX(this.M, f2);
            ViewCompat.setScaleY(this.M, f2);
        }
    }

    @Deprecated
    public void setColorScheme(@ColorInt int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        d();
        this.R.a(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = resources.getColor(iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.f5542w = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (z2) {
            return;
        }
        b();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z2) {
        this.f5545z.setNestedScrollingEnabled(z2);
    }

    public void setOnChildScrollUpCallback(@Nullable i iVar) {
        this.f5534e0 = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.f5539t = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i2) {
        this.M.setBackgroundColor(i2);
        this.R.b(i2);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i2) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i2));
    }

    public void setRefreshing(boolean z2) {
        if (!z2 || this.f5540u == z2) {
            a(z2, false);
            return;
        }
        this.f5540u = z2;
        a(((int) (!this.f5533d0 ? this.f5530a0 + this.Q : this.f5530a0)) - this.E, true);
        this.f5531b0 = false;
        b(this.f5535f0);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.f5532c0 = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f5532c0 = (int) (displayMetrics.density * 40.0f);
            }
            this.M.setImageDrawable(null);
            this.M.setImageDrawable(this.R);
        }
    }

    public void setSmileAnimationDuration(int i2) {
        this.R.a(i2);
    }

    public void setSmileInterpolator(Interpolator interpolator) {
        this.R.a(interpolator);
    }

    public void setSmileStrokeWidth(float f2) {
        this.R.b(f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.f5545z.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f5545z.stopNestedScroll();
    }

    public PullToRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5540u = false;
        this.f5542w = -1.0f;
        this.A = new int[2];
        this.B = new int[2];
        this.I = -1;
        this.N = -1;
        this.f5535f0 = new a();
        this.f5536g0 = new f();
        this.f5537h0 = new g();
        if (isInEditMode()) {
            return;
        }
        this.f5541v = ViewConfiguration.get(context).getScaledTouchSlop();
        this.D = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.L = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f5532c0 = (int) (displayMetrics.density * 40.0f);
        c();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.f5530a0 = displayMetrics.density * 64.0f;
        this.f5542w = this.f5530a0;
        this.f5544y = new NestedScrollingParentHelper(this);
        this.f5545z = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.f5532c0;
        this.E = i2;
        this.Q = i2;
        a(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f5529j0);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void d(float f2) {
        float f3 = this.G;
        float f4 = f2 - f3;
        int i2 = this.f5541v;
        if (f4 <= i2 || this.H) {
            return;
        }
        this.F = f3 + i2;
        this.H = true;
        this.R.setAlpha(76);
    }

    private void c(float f2) {
        float fMin = Math.min(1.0f, Math.abs(f2 / this.f5542w));
        double d2 = fMin;
        Double.isNaN(d2);
        Math.max(d2 - 0.4d, PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        float fAbs = Math.abs(f2) - this.f5542w;
        float f3 = this.f5533d0 ? this.f5530a0 - this.Q : this.f5530a0;
        double dMax = Math.max(0.0f, Math.min(fAbs, f3 * 2.0f) / f3) / 4.0f;
        double dPow = Math.pow(dMax, 2.0d);
        Double.isNaN(dMax);
        float f4 = ((float) (dMax - dPow)) * 2.0f;
        int i2 = this.Q + ((int) ((f3 * fMin) + (f3 * f4 * 2.0f)));
        if (this.M.getVisibility() != 0) {
            this.M.setVisibility(0);
        }
        if (!this.J) {
            ViewCompat.setScaleX(this.M, 1.0f);
            ViewCompat.setScaleY(this.M, 1.0f);
        }
        if (this.J) {
            setAnimationProgress(Math.min(1.0f, f2 / this.f5542w));
        }
        if (f2 < this.f5542w) {
            if (this.R.getAlpha() > 76 && !a(this.U)) {
                g();
            }
        } else if (this.R.getAlpha() < 255 && !a(this.V)) {
            f();
        }
        this.R.a(f4 * 2.0f);
        a(i2 - this.E, true);
    }

    void a(Animation.AnimationListener animationListener) {
        this.T = new c();
        this.T.setDuration(150L);
        this.M.a(animationListener);
        this.M.clearAnimation();
        this.M.startAnimation(this.T);
    }

    private void b(Animation.AnimationListener animationListener) {
        this.M.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
            this.R.setAlpha(255);
        }
        this.S = new b();
        this.S.setDuration(this.D);
        if (animationListener != null) {
            this.M.a(animationListener);
        }
        this.M.clearAnimation();
        this.M.startAnimation(this.S);
    }

    private Animation a(int i2, int i3) {
        if (this.J && e()) {
            return null;
        }
        d dVar = new d(i2, i3);
        dVar.setDuration(300L);
        this.M.a(null);
        this.M.clearAnimation();
        this.M.startAnimation(dVar);
        return dVar;
    }

    private void b(float f2) {
        if (f2 > this.f5542w) {
            a(true, true);
        } else {
            this.f5540u = false;
            b(this.E, this.J ? null : new e());
        }
    }

    public boolean a() {
        i iVar = this.f5534e0;
        if (iVar != null) {
            return iVar.a(this, this.f5538s);
        }
        if (Build.VERSION.SDK_INT < 14) {
            View view = this.f5538s;
            if (!(view instanceof AbsListView)) {
                return ViewCompat.canScrollVertically(view, -1) || this.f5538s.getScrollY() > 0;
            }
            AbsListView absListView = (AbsListView) view;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
        return ViewCompat.canScrollVertically(this.f5538s, -1);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.J) {
            c(i2, animationListener);
            return;
        }
        this.O = i2;
        this.f5537h0.reset();
        this.f5537h0.setDuration(200L);
        this.f5537h0.setInterpolator(this.L);
        if (animationListener != null) {
            this.M.a(animationListener);
        }
        this.M.clearAnimation();
        this.M.startAnimation(this.f5537h0);
    }

    private boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.O = i2;
        this.f5536g0.reset();
        this.f5536g0.setDuration(200L);
        this.f5536g0.setInterpolator(this.L);
        if (animationListener != null) {
            this.M.a(animationListener);
        }
        this.M.clearAnimation();
        this.M.startAnimation(this.f5536g0);
    }

    private void c(int i2, Animation.AnimationListener animationListener) {
        this.O = i2;
        if (e()) {
            this.P = this.R.getAlpha();
        } else {
            this.P = ViewCompat.getScaleX(this.M);
        }
        this.W = new h();
        this.W.setDuration(150L);
        if (animationListener != null) {
            this.M.a(animationListener);
        }
        this.M.clearAnimation();
        this.M.startAnimation(this.W);
    }

    void a(float f2) {
        a((this.O + ((int) ((this.Q - r0) * f2))) - this.M.getTop(), false);
    }

    void a(int i2, boolean z2) {
        this.M.bringToFront();
        ViewCompat.offsetTopAndBottom(this.M, i2);
        this.E = this.M.getTop();
        if (!z2 || Build.VERSION.SDK_INT >= 11) {
            return;
        }
        invalidate();
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.I) {
            this.I = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
