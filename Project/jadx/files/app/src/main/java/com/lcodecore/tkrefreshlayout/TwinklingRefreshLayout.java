package com.lcodecore.tkrefreshlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.g.g;
import com.lcodecore.tkrefreshlayout.header.GoogleDotView;

/* JADX INFO: loaded from: classes3.dex */
public class TwinklingRefreshLayout extends RelativeLayout implements e, NestedScrollingChild {

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private static String f16968v0 = "";

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private static String f16969w0 = "";
    private com.lcodecore.tkrefreshlayout.a A;
    private float B;
    private FrameLayout C;
    protected boolean D;
    protected boolean E;
    protected boolean F;
    protected boolean G;
    protected boolean H;
    protected boolean I;
    protected boolean J;
    protected boolean K;
    protected boolean L;
    protected boolean M;
    protected boolean N;
    protected boolean O;
    protected boolean P;
    protected boolean Q;
    protected boolean R;
    private d S;
    private final int T;
    private e U;
    private final NestedScrollingChildHelper V;
    private com.lcodecore.tkrefreshlayout.g.e W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private com.lcodecore.tkrefreshlayout.d f16970a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private float f16971b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private float f16972c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private VelocityTracker f16973d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private float f16974e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private float f16975f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private float f16976g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private float f16977h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private int f16978i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private int f16979j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private MotionEvent f16980k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private boolean f16981l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private int f16982m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final int[] f16983n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final int[] f16984o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final int[] f16985p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f16986q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f16987r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected float f16988s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f16989s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected float f16990t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private boolean f16991t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected float f16992u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private f f16993u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected float f16994v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private View f16995w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected FrameLayout f16996x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private FrameLayout f16997y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private com.lcodecore.tkrefreshlayout.b f16998z;

    class a implements com.lcodecore.tkrefreshlayout.d {
        a() {
        }

        @Override // com.lcodecore.tkrefreshlayout.d
        public void a(MotionEvent motionEvent, boolean z2) {
            TwinklingRefreshLayout.this.W.a(motionEvent, z2);
        }

        @Override // com.lcodecore.tkrefreshlayout.d
        public void onDown(MotionEvent motionEvent) {
            TwinklingRefreshLayout.this.W.a(motionEvent);
        }

        @Override // com.lcodecore.tkrefreshlayout.d
        public void onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            TwinklingRefreshLayout.this.W.a(motionEvent, motionEvent2, f2, f3);
        }

        @Override // com.lcodecore.tkrefreshlayout.d
        public void onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            TwinklingRefreshLayout.this.W.a(motionEvent, motionEvent2, f2, f3, TwinklingRefreshLayout.this.f16971b0, TwinklingRefreshLayout.this.f16972c0);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout frameLayout = TwinklingRefreshLayout.this.f16996x;
            if (frameLayout != null) {
                frameLayout.bringToFront();
            }
        }
    }

    class c implements com.lcodecore.tkrefreshlayout.c {
        c() {
        }

        @Override // com.lcodecore.tkrefreshlayout.c
        public void a() {
            TwinklingRefreshLayout.this.S.i();
        }
    }

    public class d {
        private int b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f17000c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f17001d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f17002e = false;
        private com.lcodecore.tkrefreshlayout.g.a a = new com.lcodecore.tkrefreshlayout.g.a(this);

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.S();
                TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
                if (twinklingRefreshLayout.L || twinklingRefreshLayout.f16995w == null) {
                    return;
                }
                d.this.b(true);
                d.this.a.a();
            }
        }

        public d() {
        }

        public boolean A() {
            return TwinklingRefreshLayout.this.N;
        }

        public boolean B() {
            return TwinklingRefreshLayout.this.K;
        }

        public boolean C() {
            return TwinklingRefreshLayout.this.J;
        }

        public boolean D() {
            return this.f17002e;
        }

        public boolean E() {
            return this.f17001d;
        }

        public boolean F() {
            return TwinklingRefreshLayout.this.L;
        }

        public boolean G() {
            return TwinklingRefreshLayout.this.D;
        }

        public boolean H() {
            return TwinklingRefreshLayout.this.F;
        }

        public boolean I() {
            return 1 == this.b;
        }

        public boolean J() {
            return this.b == 0;
        }

        public void K() {
            TwinklingRefreshLayout.this.U.d();
        }

        public void L() {
            TwinklingRefreshLayout.this.U.b();
        }

        public void M() {
            TwinklingRefreshLayout.this.U.b(TwinklingRefreshLayout.this);
        }

        public void N() {
            TwinklingRefreshLayout.this.U.a();
        }

        public void O() {
            TwinklingRefreshLayout.this.U.a(TwinklingRefreshLayout.this);
        }

        public void P() {
            TwinklingRefreshLayout.this.U.c();
        }

        public void Q() {
            if (TwinklingRefreshLayout.this.A != null) {
                TwinklingRefreshLayout.this.A.reset();
            }
        }

        public void R() {
            if (TwinklingRefreshLayout.this.f16998z != null) {
                TwinklingRefreshLayout.this.f16998z.reset();
            }
        }

        public void S() {
            this.b = 1;
        }

        public void T() {
            this.b = 0;
        }

        public boolean U() {
            return TwinklingRefreshLayout.this.R;
        }

        public boolean V() {
            return TwinklingRefreshLayout.this.Q;
        }

        public void W() {
            TwinklingRefreshLayout.this.post(new a());
        }

        public boolean b() {
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            return twinklingRefreshLayout.I || twinklingRefreshLayout.O;
        }

        public boolean c() {
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            return twinklingRefreshLayout.H || twinklingRefreshLayout.O;
        }

        public boolean d() {
            return TwinklingRefreshLayout.this.M;
        }

        public boolean e() {
            return TwinklingRefreshLayout.this.H;
        }

        public boolean f() {
            return TwinklingRefreshLayout.this.O;
        }

        public boolean g() {
            return TwinklingRefreshLayout.this.I;
        }

        public void h() {
            K();
            if (TwinklingRefreshLayout.this.f16995w != null) {
                this.a.a(true);
            }
        }

        public void i() {
            if (TwinklingRefreshLayout.this.f16995w != null) {
                this.a.b(true);
            }
        }

        public void j() {
            L();
        }

        public com.lcodecore.tkrefreshlayout.g.a k() {
            return this.a;
        }

        public int l() {
            return (int) TwinklingRefreshLayout.this.B;
        }

        public View m() {
            return TwinklingRefreshLayout.this.f16997y;
        }

        public View n() {
            return TwinklingRefreshLayout.this.C;
        }

        public int o() {
            return (int) TwinklingRefreshLayout.this.f16992u;
        }

        public View p() {
            return TwinklingRefreshLayout.this.f16996x;
        }

        public int q() {
            return (int) TwinklingRefreshLayout.this.f16990t;
        }

        public float r() {
            return TwinklingRefreshLayout.this.f16988s;
        }

        public int s() {
            return (int) TwinklingRefreshLayout.this.f16994v;
        }

        public View t() {
            return TwinklingRefreshLayout.this.f16995w;
        }

        public int u() {
            return TwinklingRefreshLayout.this.T;
        }

        public void v() {
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            if (twinklingRefreshLayout.L) {
                twinklingRefreshLayout.setOverScrollTopShow(false);
                TwinklingRefreshLayout.this.setOverScrollBottomShow(false);
                FrameLayout frameLayout = TwinklingRefreshLayout.this.f16996x;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                if (TwinklingRefreshLayout.this.C != null) {
                    TwinklingRefreshLayout.this.C.setVisibility(8);
                }
            }
        }

        public boolean w() {
            return TwinklingRefreshLayout.this.P;
        }

        public boolean x() {
            return this.f17000c;
        }

        public boolean y() {
            return TwinklingRefreshLayout.this.G;
        }

        public boolean z() {
            return TwinklingRefreshLayout.this.E;
        }

        public boolean a() {
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            return (twinklingRefreshLayout.D || twinklingRefreshLayout.E) ? false : true;
        }

        public void b(boolean z2) {
            TwinklingRefreshLayout.this.G = z2;
        }

        public void c(float f2) {
            e eVar = TwinklingRefreshLayout.this.U;
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            eVar.d(twinklingRefreshLayout, f2 / twinklingRefreshLayout.f16992u);
        }

        public void d(float f2) {
            e eVar = TwinklingRefreshLayout.this.U;
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            eVar.a(twinklingRefreshLayout, f2 / twinklingRefreshLayout.B);
        }

        public void e(boolean z2) {
            TwinklingRefreshLayout.this.D = z2;
        }

        public void f(boolean z2) {
            TwinklingRefreshLayout.this.F = z2;
        }

        public void a(boolean z2) {
            TwinklingRefreshLayout.this.E = z2;
        }

        public void b(float f2) {
            e eVar = TwinklingRefreshLayout.this.U;
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            eVar.c(twinklingRefreshLayout, f2 / twinklingRefreshLayout.B);
        }

        public void c(boolean z2) {
            this.f17002e = z2;
        }

        public void d(boolean z2) {
            this.f17001d = z2;
        }

        public void a(float f2) {
            e eVar = TwinklingRefreshLayout.this.U;
            TwinklingRefreshLayout twinklingRefreshLayout = TwinklingRefreshLayout.this;
            eVar.b(twinklingRefreshLayout, f2 / twinklingRefreshLayout.f16992u);
        }

        public boolean a(MotionEvent motionEvent) {
            return TwinklingRefreshLayout.super.dispatchTouchEvent(motionEvent);
        }
    }

    public TwinklingRefreshLayout(Context context) {
        this(context, null, 0);
    }

    public static void setDefaultFooter(String str) {
        f16969w0 = str;
    }

    public static void setDefaultHeader(String str) {
        f16968v0 = str;
    }

    @Override // com.lcodecore.tkrefreshlayout.e
    public void b(TwinklingRefreshLayout twinklingRefreshLayout, float f2) {
        f fVar;
        this.f16998z.a(f2, this.f16988s, this.f16992u);
        if (this.I && (fVar = this.f16993u0) != null) {
            fVar.b(twinklingRefreshLayout, f2);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.V.dispatchNestedFling(f2, f3, z2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.V.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.V.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.V.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = this.W.dispatchTouchEvent(motionEvent);
        a(motionEvent, this.f16970a0);
        a(motionEvent);
        return zDispatchTouchEvent;
    }

    public View getExtraHeaderView() {
        return this.f16997y;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.V.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.V.isNestedScrollingEnabled();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f16995w = getChildAt(3);
        this.S.v();
        d dVar = this.S;
        this.W = new com.lcodecore.tkrefreshlayout.g.f(dVar, new g(dVar));
        i();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.W.b(motionEvent) || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.W.c(motionEvent) || super.onTouchEvent(motionEvent);
    }

    public void setAutoLoadMore(boolean z2) {
        this.M = z2;
        if (this.M) {
            setEnableLoadmore(true);
        }
    }

    public void setBottomHeight(float f2) {
        this.B = com.lcodecore.tkrefreshlayout.h.a.a(getContext(), f2);
    }

    public void setBottomView(com.lcodecore.tkrefreshlayout.a aVar) {
        if (aVar != null) {
            this.C.removeAllViewsInLayout();
            this.C.addView(aVar.getView());
            this.A = aVar;
        }
    }

    public void setDecorator(com.lcodecore.tkrefreshlayout.g.e eVar) {
        if (eVar != null) {
            this.W = eVar;
        }
    }

    public void setEnableKeepIView(boolean z2) {
        this.P = z2;
    }

    public void setEnableLoadmore(boolean z2) {
        this.H = z2;
        com.lcodecore.tkrefreshlayout.a aVar = this.A;
        if (aVar != null) {
            if (this.H) {
                aVar.getView().setVisibility(0);
            } else {
                aVar.getView().setVisibility(8);
            }
        }
    }

    public void setEnableOverScroll(boolean z2) {
        this.O = z2;
    }

    public void setEnableRefresh(boolean z2) {
        this.I = z2;
        com.lcodecore.tkrefreshlayout.b bVar = this.f16998z;
        if (bVar != null) {
            if (this.I) {
                bVar.getView().setVisibility(0);
            } else {
                bVar.getView().setVisibility(8);
            }
        }
    }

    public void setFloatRefresh(boolean z2) {
        this.N = z2;
        if (this.N) {
            post(new b());
        }
    }

    public void setHeaderHeight(float f2) {
        this.f16992u = com.lcodecore.tkrefreshlayout.h.a.a(getContext(), f2);
    }

    public void setHeaderView(com.lcodecore.tkrefreshlayout.b bVar) {
        if (bVar != null) {
            this.f16996x.removeAllViewsInLayout();
            this.f16996x.addView(bVar.getView());
            this.f16998z = bVar;
        }
    }

    public void setMaxBottomHeight(float f2) {
        this.f16990t = com.lcodecore.tkrefreshlayout.h.a.a(getContext(), f2);
    }

    public void setMaxHeadHeight(float f2) {
        this.f16988s = com.lcodecore.tkrefreshlayout.h.a.a(getContext(), f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z2) {
        this.V.setNestedScrollingEnabled(z2);
    }

    public void setOnRefreshListener(f fVar) {
        if (fVar != null) {
            this.f16993u0 = fVar;
        }
    }

    public void setOverScrollBottomShow(boolean z2) {
        this.K = z2;
    }

    public void setOverScrollHeight(float f2) {
        this.f16994v = com.lcodecore.tkrefreshlayout.h.a.a(getContext(), f2);
    }

    public void setOverScrollRefreshShow(boolean z2) {
        this.J = z2;
        this.K = z2;
    }

    public void setOverScrollTopShow(boolean z2) {
        this.J = z2;
    }

    public void setTargetView(View view) {
        if (view != null) {
            this.f16995w = view;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        return this.V.startNestedScroll(i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.V.stopNestedScroll();
    }

    public TwinklingRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(MotionEvent motionEvent, com.lcodecore.tkrefreshlayout.d dVar) {
        int action = motionEvent.getAction();
        if (this.f16973d0 == null) {
            this.f16973d0 = VelocityTracker.obtain();
        }
        this.f16973d0.addMovement(motionEvent);
        int i2 = action & 255;
        boolean z2 = true;
        boolean z3 = i2 == 6;
        int actionIndex = z3 ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x2 = 0.0f;
        float y2 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (actionIndex != i3) {
                x2 += motionEvent.getX(i3);
                y2 += motionEvent.getY(i3);
            }
        }
        float f2 = z3 ? pointerCount - 1 : pointerCount;
        float f3 = x2 / f2;
        float f4 = y2 / f2;
        if (i2 == 0) {
            this.f16974e0 = f3;
            this.f16976g0 = f3;
            this.f16975f0 = f4;
            this.f16977h0 = f4;
            MotionEvent motionEvent2 = this.f16980k0;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.f16980k0 = MotionEvent.obtain(motionEvent);
            this.f16981l0 = true;
            dVar.onDown(motionEvent);
            return;
        }
        if (i2 == 1) {
            int pointerId = motionEvent.getPointerId(0);
            this.f16973d0.computeCurrentVelocity(1000, this.f16978i0);
            this.f16972c0 = this.f16973d0.getYVelocity(pointerId);
            this.f16971b0 = this.f16973d0.getXVelocity(pointerId);
            if (Math.abs(this.f16972c0) > this.f16979j0 || Math.abs(this.f16971b0) > this.f16979j0) {
                dVar.onFling(this.f16980k0, motionEvent, this.f16971b0, this.f16972c0);
            } else {
                z2 = false;
            }
            dVar.a(motionEvent, z2);
            VelocityTracker velocityTracker = this.f16973d0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f16973d0 = null;
                return;
            }
            return;
        }
        if (i2 == 2) {
            float f5 = this.f16974e0 - f3;
            float f6 = this.f16975f0 - f4;
            if (!this.f16981l0) {
                if (Math.abs(f5) >= 1.0f || Math.abs(f6) >= 1.0f) {
                    dVar.onScroll(this.f16980k0, motionEvent, f5, f6);
                    this.f16974e0 = f3;
                    this.f16975f0 = f4;
                    return;
                }
                return;
            }
            int i4 = (int) (f3 - this.f16976g0);
            int i5 = (int) (f4 - this.f16977h0);
            if ((i4 * i4) + (i5 * i5) > this.f16982m0) {
                dVar.onScroll(this.f16980k0, motionEvent, f5, f6);
                this.f16974e0 = f3;
                this.f16975f0 = f4;
                this.f16981l0 = false;
                return;
            }
            return;
        }
        if (i2 == 3) {
            this.f16981l0 = false;
            VelocityTracker velocityTracker2 = this.f16973d0;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f16973d0 = null;
                return;
            }
            return;
        }
        if (i2 == 5) {
            this.f16974e0 = f3;
            this.f16976g0 = f3;
            this.f16975f0 = f4;
            this.f16977h0 = f4;
            return;
        }
        if (i2 != 6) {
            return;
        }
        this.f16974e0 = f3;
        this.f16976g0 = f3;
        this.f16975f0 = f4;
        this.f16977h0 = f4;
        this.f16973d0.computeCurrentVelocity(1000, this.f16978i0);
        int actionIndex2 = motionEvent.getActionIndex();
        int pointerId2 = motionEvent.getPointerId(actionIndex2);
        float xVelocity = this.f16973d0.getXVelocity(pointerId2);
        float yVelocity = this.f16973d0.getYVelocity(pointerId2);
        for (int i6 = 0; i6 < pointerCount; i6++) {
            if (i6 != actionIndex2) {
                int pointerId3 = motionEvent.getPointerId(i6);
                if ((this.f16973d0.getXVelocity(pointerId3) * xVelocity) + (this.f16973d0.getYVelocity(pointerId3) * yVelocity) < 0.0f) {
                    this.f16973d0.clear();
                    return;
                }
            }
        }
    }

    private void g() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 0);
        layoutParams.addRule(12);
        frameLayout.setLayoutParams(layoutParams);
        this.C = frameLayout;
        addView(this.C);
        if (this.A == null) {
            if (TextUtils.isEmpty(f16969w0)) {
                setBottomView(new LoadingView(getContext()));
                return;
            }
            try {
                setBottomView((com.lcodecore.tkrefreshlayout.a) Class.forName(f16969w0).getDeclaredConstructor(Context.class).newInstance(getContext()));
            } catch (Exception e2) {
                String str = "setDefaultFooter classname=" + e2.getMessage();
                setBottomView(new LoadingView(getContext()));
            }
        }
    }

    private void h() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 0);
        layoutParams.addRule(10);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        frameLayout2.setId(R$id.ex_header);
        addView(frameLayout2, new RelativeLayout.LayoutParams(-1, -2));
        addView(frameLayout, layoutParams);
        this.f16997y = frameLayout2;
        this.f16996x = frameLayout;
        if (this.f16998z == null) {
            if (TextUtils.isEmpty(f16968v0)) {
                setHeaderView(new GoogleDotView(getContext()));
                return;
            }
            try {
                setHeaderView((com.lcodecore.tkrefreshlayout.b) Class.forName(f16968v0).getDeclaredConstructor(Context.class).newInstance(getContext()));
            } catch (Exception e2) {
                String str = "setDefaultHeader classname=" + e2.getMessage();
                setHeaderView(new GoogleDotView(getContext()));
            }
        }
    }

    private void i() {
        this.f16970a0 = new a();
    }

    @Override // com.lcodecore.tkrefreshlayout.e
    public void c(TwinklingRefreshLayout twinklingRefreshLayout, float f2) {
        f fVar;
        this.A.a(f2, this.f16990t, this.B);
        if (this.H && (fVar = this.f16993u0) != null) {
            fVar.c(twinklingRefreshLayout, f2);
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.e
    public void d(TwinklingRefreshLayout twinklingRefreshLayout, float f2) {
        f fVar;
        this.f16998z.b(f2, this.f16988s, this.f16992u);
        if (this.I && (fVar = this.f16993u0) != null) {
            fVar.d(twinklingRefreshLayout, f2);
        }
    }

    public void e() {
        this.S.h();
    }

    public void f() {
        this.S.j();
    }

    public TwinklingRefreshLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = true;
        this.P = true;
        this.Q = true;
        this.R = true;
        this.T = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.U = this;
        this.f16978i0 = ViewConfiguration.getMaximumFlingVelocity();
        this.f16979j0 = ViewConfiguration.getMinimumFlingVelocity();
        int i3 = this.T;
        this.f16982m0 = i3 * i3;
        this.f16983n0 = new int[2];
        this.f16984o0 = new int[2];
        this.f16985p0 = new int[2];
        this.f16986q0 = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TwinklingRefreshLayout, i2, 0);
        try {
            this.f16988s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TwinklingRefreshLayout_tr_max_head_height, com.lcodecore.tkrefreshlayout.h.a.a(context, 120.0f));
            this.f16992u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TwinklingRefreshLayout_tr_head_height, com.lcodecore.tkrefreshlayout.h.a.a(context, 80.0f));
            this.f16990t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TwinklingRefreshLayout_tr_max_bottom_height, com.lcodecore.tkrefreshlayout.h.a.a(context, 120.0f));
            this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TwinklingRefreshLayout_tr_bottom_height, com.lcodecore.tkrefreshlayout.h.a.a(context, 60.0f));
            this.f16994v = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.TwinklingRefreshLayout_tr_overscroll_height, (int) this.f16992u);
            this.I = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_enable_refresh, true);
            this.H = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_enable_loadmore, true);
            this.L = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_pureScrollMode_on, false);
            this.J = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_overscroll_top_show, true);
            this.K = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_overscroll_bottom_show, true);
            this.O = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_enable_overscroll, true);
            this.N = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_floatRefresh, false);
            this.M = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_autoLoadMore, false);
            this.P = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_enable_keepIView, true);
            this.Q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_showRefreshingWhenOverScroll, true);
            this.R = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TwinklingRefreshLayout_tr_showLoadingWhenOverScroll, true);
            typedArrayObtainStyledAttributes.recycle();
            this.S = new d();
            h();
            g();
            setFloatRefresh(this.N);
            setAutoLoadMore(this.M);
            setEnableRefresh(this.I);
            setEnableLoadmore(this.H);
            this.V = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.e
    public void b(TwinklingRefreshLayout twinklingRefreshLayout) {
        this.A.a(this.f16990t, this.B);
        f fVar = this.f16993u0;
        if (fVar != null) {
            fVar.b(twinklingRefreshLayout);
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.e
    public void c() {
        f fVar = this.f16993u0;
        if (fVar != null) {
            fVar.c();
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.e
    public void d() {
        f fVar = this.f16993u0;
        if (fVar != null) {
            fVar.d();
        }
        if (this.S.w() || this.S.y()) {
            this.A.onFinish();
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.e
    public void b() {
        f fVar = this.f16993u0;
        if (fVar != null) {
            fVar.b();
        }
        if (this.S.w() || this.S.H()) {
            this.f16998z.a(new c());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout.a(android.view.MotionEvent):boolean");
    }

    @Override // com.lcodecore.tkrefreshlayout.e
    public void a(TwinklingRefreshLayout twinklingRefreshLayout, float f2) {
        f fVar;
        this.A.b(f2, this.f16988s, this.f16992u);
        if (this.H && (fVar = this.f16993u0) != null) {
            fVar.a(twinklingRefreshLayout, f2);
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.e
    public void a(TwinklingRefreshLayout twinklingRefreshLayout) {
        this.f16998z.a(this.f16988s, this.f16992u);
        f fVar = this.f16993u0;
        if (fVar != null) {
            fVar.a(twinklingRefreshLayout);
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.e
    public void a() {
        f fVar = this.f16993u0;
        if (fVar != null) {
            fVar.a();
        }
    }
}
