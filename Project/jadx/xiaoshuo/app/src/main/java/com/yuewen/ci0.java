package com.yuewen;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.duokan.reader.common.ui.SystemUiMode;
import com.google.android.material.badge.BadgeDrawable;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes2.dex */
public class ci0 extends FrameLayout {
    public static final int n = Build.VERSION.SDK_INT;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f9664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f9665b;
    public final int c;
    public final Rect d;
    public boolean e;
    public boolean f;
    public final View g;
    public int h;
    public final View i;
    public int j;
    public SystemUiMode k;
    public View l;
    public cw3 m;

    public class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: com.yuewen.ci0$a$a, reason: collision with other inner class name */
        public class C0591a implements t41<Rect> {
            public C0591a() {
            }

            @Override // com.yuewen.t41
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public boolean a(Rect rect) {
                ci0.this.i(rect);
                rect.set(0, 0, 0, 0);
                return true;
            }
        }

        public a() {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ci0.this.h = windowInsets.getSystemWindowInsetBottom();
            qt1.a("DkDecorView", "onApplyWindowInsets BottomHeight=" + ci0.this.h + " insets: " + windowInsets.toString());
            view.onApplyWindowInsets(e84.j(windowInsets, new C0591a()));
            return windowInsets;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f9668a;

        public b(int i) {
            this.f9668a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ci0.this.j == this.f9668a && ci0.this.g.getVisibility() == 0) {
                ci0.this.g.setBackgroundColor(ci0.this.j);
                ci0.this.i.setBackgroundColor(ci0.this.j);
            }
        }
    }

    @TargetApi(21)
    public ci0(Activity activity) {
        this(activity, false);
    }

    public final void f() {
        View view = this.l;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (this.k == SystemUiMode.DOCK || this.f9664a.isInMultiWindowMode()) {
                Rect rect = this.d;
                layoutParams.rightMargin = rect.right;
                layoutParams.leftMargin = rect.left;
                layoutParams.bottomMargin = rect.bottom;
                this.l.requestLayout();
                q();
                r(this.f9664a.getWindow(), false);
            } else {
                if (layoutParams.rightMargin != 0 || layoutParams.bottomMargin != 0 || layoutParams.leftMargin != 0) {
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    layoutParams.bottomMargin = 0;
                    this.l.requestLayout();
                }
                SystemUiMode systemUiMode = this.k;
                if (systemUiMode == SystemUiMode.GONE) {
                    l();
                    m(this.f9664a.getWindow());
                } else if (systemUiMode == SystemUiMode.STATUS_BAR) {
                    l();
                    r(this.f9664a.getWindow(), true);
                } else {
                    q();
                    r(this.f9664a.getWindow(), false);
                }
            }
        }
        int statusBarHeight = getStatusBarHeight();
        if (statusBarHeight != this.f9665b.getLayoutParams().height) {
            this.f9665b.getLayoutParams().height = statusBarHeight;
            this.f9665b.requestLayout();
        }
        j();
    }

    public final void g() {
        int i = n;
        if (i < 23) {
            if (l32.f()) {
                l32.g(this.f9664a, this.e);
            }
        } else {
            e84.d1(this.f9664a.getWindow().getDecorView(), this.e, this.f);
            if (i > 24 || !l32.f()) {
                return;
            }
            l32.g(this.f9664a, this.e);
        }
    }

    public int getNavBarHeight() {
        return this.h;
    }

    public int getStatusBarHeight() {
        return Math.max(this.c, this.d.top);
    }

    public SystemUiMode getSystemUiMode() {
        return this.k;
    }

    public void h(int i) {
        Window window;
        Activity activity = this.f9664a;
        if (activity == null || n < 21 || (window = activity.getWindow()) == null) {
            return;
        }
        window.setNavigationBarColor(i);
    }

    public void i(Rect rect) {
        if (rect.equals(this.d)) {
            return;
        }
        this.d.set(rect);
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j() {
        /*
            r7 = this;
            android.view.View r0 = r7.g
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r0 = (android.widget.FrameLayout.LayoutParams) r0
            android.graphics.Rect r1 = r7.d
            int r1 = r1.left
            android.view.View r2 = r7.i
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            int r2 = r2.width
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L33
            android.view.View r1 = r7.i
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.graphics.Rect r2 = r7.d
            int r2 = r2.left
            r1.width = r2
            android.view.View r1 = r7.i
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L31
            android.view.View r1 = r7.i
            r1.requestLayout()
        L31:
            r1 = r3
            goto L34
        L33:
            r1 = r4
        L34:
            android.graphics.Rect r2 = r7.d
            int r5 = r2.bottom
            r6 = -1
            if (r5 <= 0) goto L44
            int r2 = r0.height
            if (r2 == r5) goto L66
            r0.height = r5
            r0.width = r6
            goto L67
        L44:
            int r2 = r2.right
            if (r2 <= 0) goto L5f
            android.content.Context r2 = r7.getContext()
            boolean r2 = com.yuewen.e84.z0(r2)
            if (r2 == 0) goto L5f
            int r2 = r0.width
            android.graphics.Rect r4 = r7.d
            int r4 = r4.right
            if (r2 == r4) goto L66
            r0.height = r6
            r0.width = r4
            goto L67
        L5f:
            int r2 = r0.height
            if (r2 == 0) goto L66
            r0.height = r4
            goto L67
        L66:
            r3 = r1
        L67:
            if (r3 == 0) goto L6e
            android.view.View r0 = r7.g
            r0.requestLayout()
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.ci0.j():void");
    }

    public final void k() {
        if (this.g.getVisibility() == 4) {
            return;
        }
        this.g.setVisibility(4);
        if (this.g.getLayoutParams().height > 0) {
            e84.C(this.g, null);
        } else {
            e84.E(this.g, null);
        }
        if (this.i.getVisibility() == 0) {
            this.i.setVisibility(4);
            e84.D(this.i, null);
        }
    }

    public final void l() {
        if (this.f9665b.getVisibility() == 4) {
            return;
        }
        this.f9665b.setVisibility(4);
        e84.F(this.f9665b, null);
    }

    @TargetApi(19)
    public final void m(Window window) {
        e84.u0(window.getDecorView());
        if (n >= 23) {
            requestApplyInsets();
        }
    }

    public void n(cw3 cw3Var) {
        this.m = cw3Var;
        if (cw3Var == null) {
            onWindowSystemUiVisibilityChanged(getWindowSystemUiVisibility());
            if (this.i.getVisibility() == 0) {
                this.i.setVisibility(4);
                e84.D(this.i, null);
                return;
            }
            return;
        }
        Integer num = cw3Var.f10010a;
        if (num != null) {
            this.j = num.intValue();
        }
        if (cw3Var.c()) {
            if (this.g.getAnimation() != null) {
                this.g.clearAnimation();
            }
            if (this.i.getAnimation() != null) {
                this.i.clearAnimation();
            }
            this.g.setBackgroundColor(this.j);
            this.i.setBackgroundColor(this.j);
            if (this.g.getVisibility() != 0 && cw3Var.e) {
                this.g.setVisibility(0);
            }
            if (!cw3Var.d || this.i.getLayoutParams().width <= 0 || this.i.getVisibility() == 0) {
                return;
            }
            this.i.setVisibility(0);
        }
    }

    public void o(Boolean bool, Boolean bool2) {
        if (bool != null) {
            this.e = bool.booleanValue();
        }
        if (bool2 != null) {
            this.f = bool2.booleanValue();
        }
        g();
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        cw3 cw3Var = this.m;
        if (cw3Var == null || !cw3Var.c()) {
            if ((i & 2) == 2) {
                k();
            } else {
                p();
            }
        }
    }

    public final void p() {
        if (this.g.getVisibility() == 0) {
            return;
        }
        this.g.setBackgroundColor(this.j);
        this.g.setVisibility(0);
        if (this.g.getLayoutParams().height > 0) {
            e84.y(this.g, null);
        } else {
            e84.A(this.g, null);
        }
    }

    public final void q() {
        if (this.f9665b.getVisibility() == 0) {
            return;
        }
        this.f9665b.setVisibility(0);
        e84.B(this.f9665b, null);
    }

    @TargetApi(20)
    public final void r(Window window, boolean z) {
        if (z) {
            e84.G0(window.getDecorView());
        } else {
            e84.f1(window.getDecorView());
        }
        if (n >= 23) {
            requestApplyInsets();
        }
    }

    public void setContentView(View view) {
        View view2 = this.l;
        if (view2 != null) {
            removeView(view2);
            this.l = null;
        }
        if (view != null) {
            this.l = view;
            addView(view, 0, new FrameLayout.LayoutParams(-1, -1));
            f();
        }
    }

    public void setNavigationBarColor(int i) {
        if (this.j == i) {
            return;
        }
        this.j = i;
        if (this.g.getVisibility() == 0) {
            rv1.n(new b(i), e84.P(0));
        }
    }

    public void setNavigationBarMode(SystemUiMode systemUiMode) {
        this.f9664a.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        if (systemUiMode == SystemUiMode.GONE) {
            l();
            m(this.f9664a.getWindow());
        } else if (systemUiMode == SystemUiMode.STATUS_BAR) {
            l();
            r(this.f9664a.getWindow(), true);
        } else {
            q();
            r(this.f9664a.getWindow(), false);
        }
        this.k = systemUiMode;
        f();
    }

    public void setStatusBarStyle(boolean z) {
        if (this.e == z) {
            return;
        }
        this.e = z;
        g();
    }

    @TargetApi(21)
    public ci0(Activity activity, boolean z) {
        super(activity);
        Rect rect = new Rect();
        this.d = rect;
        this.e = true;
        this.f = true;
        this.h = 0;
        this.j = -16777216;
        this.k = SystemUiMode.DOCK;
        this.l = null;
        this.f9664a = activity;
        setId(rt2.k.W4);
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.c = getResources().getDimensionPixelSize(identifier);
        } else {
            this.c = e84.k(getContext(), 20.0f);
        }
        View view = new View(getContext());
        this.f9665b = view;
        addView(view, new FrameLayout.LayoutParams(-1, this.c, 48));
        View view2 = new View(getContext());
        this.g = view2;
        view2.setId(rt2.k.M2);
        addView(view2, new FrameLayout.LayoutParams(-1, rect.bottom, BadgeDrawable.BOTTOM_END));
        View view3 = new View(getContext());
        this.i = view3;
        addView(view3, new FrameLayout.LayoutParams(rect.left, -1, 51));
        view3.setVisibility(8);
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
        window.addFlags(Integer.MIN_VALUE);
        if (n >= 23 && !z) {
            int navigationBarColor = window.getNavigationBarColor();
            this.j = navigationBarColor;
            view2.setBackgroundColor(navigationBarColor);
            window.setNavigationBarColor(com.duokan.reader.d.a());
            window.setStatusBarColor(com.duokan.reader.d.a());
            e84.J(window.getDecorView());
            window.getDecorView().setOnApplyWindowInsetsListener(new a());
        }
        g();
    }
}
