package com.kathline.horizontalrefresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalRefreshLayout extends FrameLayout {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private float G;
    private int H;
    private boolean I;
    private boolean J;
    private int K;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Context f16405s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.kathline.horizontalrefresh.b f16406t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.kathline.horizontalrefresh.b f16407u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private View f16408v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private View f16409w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private View f16410x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private com.kathline.horizontalrefresh.a f16411y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f16412z;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HorizontalRefreshLayout.this.K = 0;
            HorizontalRefreshLayout.this.H = -1;
            HorizontalRefreshLayout.this.G = 0.0f;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HorizontalRefreshLayout.this.G = r2.A;
            if (HorizontalRefreshLayout.this.f16411y != null) {
                if (HorizontalRefreshLayout.this.H == 0) {
                    HorizontalRefreshLayout.this.f16411y.b();
                } else if (HorizontalRefreshLayout.this.H == 1) {
                    HorizontalRefreshLayout.this.f16411y.a();
                }
            }
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (HorizontalRefreshLayout.this.f16411y != null) {
                if (HorizontalRefreshLayout.this.H == 0) {
                    HorizontalRefreshLayout.this.f16411y.b();
                } else if (HorizontalRefreshLayout.this.H == 1) {
                    HorizontalRefreshLayout.this.f16411y.a();
                }
            }
            HorizontalRefreshLayout.this.G = -r2.B;
        }
    }

    public HorizontalRefreshLayout(Context context) {
        super(context);
        this.G = 0.0f;
        this.H = -1;
        this.I = true;
        this.J = true;
        this.K = 0;
        e();
    }

    private void e() {
        this.f16405s = getContext();
        ViewConfiguration.get(this.f16405s).getScaledTouchSlop();
    }

    private void f() {
        View view;
        View view2;
        if (this.H == 0 && (view2 = this.f16409w) != null) {
            this.K = 4;
            view2.animate().translationX(0.0f).setDuration(150L).start();
            this.f16406t.a(this.f16409w);
            View view3 = this.f16408v;
            if (view3 != null) {
                view3.animate().translationX(this.A).setDuration(150L).setListener(new b()).start();
                return;
            }
            return;
        }
        if (this.H != 1 || (view = this.f16410x) == null) {
            return;
        }
        this.K = 4;
        view.animate().translationXBy((-this.G) - this.B).setDuration(150L).start();
        this.f16407u.a(this.f16410x);
        View view4 = this.f16408v;
        if (view4 != null) {
            view4.animate().translationX(-this.B).setDuration(150L).setListener(new c()).start();
        }
    }

    private void g() {
        View view;
        View view2 = this.f16408v;
        if (view2 != null) {
            view2.animate().translationX(0.0f).setDuration(150L).setListener(new a()).start();
        }
        int i2 = this.H;
        if (i2 == 0) {
            View view3 = this.f16409w;
            if (view3 != null) {
                this.f16406t.a(0, view3);
                this.f16409w.animate().translationX(-this.A).setDuration(150L).start();
                return;
            }
            return;
        }
        if (i2 != 1 || (view = this.f16410x) == null) {
            return;
        }
        this.f16407u.a(0, view);
        this.f16410x.animate().translationX(this.B).setDuration(150L).start();
    }

    private void setLeftHeadView(View view) {
        this.f16409w = view;
        ((FrameLayout.LayoutParams) this.f16409w.getLayoutParams()).gravity = GravityCompat.START;
        addView(this.f16409w, 0);
    }

    private void setRightHeadView(View view) {
        this.f16410x = view;
        ((FrameLayout.LayoutParams) this.f16410x.getLayoutParams()).gravity = GravityCompat.END;
        addView(this.f16410x, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.D = x2;
            this.F = x2;
            this.E = y2;
        } else if (action == 2) {
            int i2 = x2 - this.D;
            if (Math.abs(i2) > Math.abs(y2 - this.E)) {
                if (this.f16409w != null && i2 > 0 && !b() && this.K != 4 && this.J) {
                    this.H = 0;
                } else if (this.f16410x != null && i2 < 0 && !a() && this.K != 4 && this.I) {
                    this.H = 1;
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0074  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            int r2 = r7.getAction()
            if (r2 == 0) goto L79
            r3 = 0
            r4 = 1
            if (r2 == r4) goto L74
            r5 = 2
            if (r2 == r5) goto L1b
            r0 = 3
            if (r2 == r0) goto L74
            goto L7f
        L1b:
            int r2 = r6.D
            int r2 = r0 - r2
            int r5 = r6.E
            int r5 = r1 - r5
            r6.D = r0
            r6.F = r0
            r6.E = r1
            int r0 = java.lang.Math.abs(r2)
            int r1 = java.lang.Math.abs(r5)
            if (r0 <= r1) goto L7f
            android.view.View r0 = r6.f16409w
            r1 = 4
            if (r0 == 0) goto L54
            if (r2 <= 0) goto L54
            boolean r0 = r6.b()
            if (r0 != 0) goto L54
            int r0 = r6.K
            if (r0 == r1) goto L54
            boolean r0 = r6.J
            if (r0 == 0) goto L54
            r6.H = r3
            r6.K = r4
            com.kathline.horizontalrefresh.b r7 = r6.f16406t
            android.view.View r0 = r6.f16409w
            r7.a(r3, r0)
            return r4
        L54:
            android.view.View r0 = r6.f16410x
            if (r0 == 0) goto L7f
            if (r2 >= 0) goto L7f
            boolean r0 = r6.a()
            if (r0 != 0) goto L7f
            int r0 = r6.K
            if (r0 == r1) goto L7f
            boolean r0 = r6.I
            if (r0 == 0) goto L7f
            r6.H = r4
            r6.K = r4
            com.kathline.horizontalrefresh.b r7 = r6.f16407u
            android.view.View r0 = r6.f16410x
            r7.a(r4, r0)
            return r4
        L74:
            r6.D = r3
            r6.E = r3
            goto L7f
        L79:
            r6.D = r0
            r6.F = r0
            r6.E = r1
        L7f:
            boolean r7 = super.onInterceptTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kathline.horizontalrefresh.HorizontalRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (getChildCount() == 0) {
            return;
        }
        if (this.f16408v == null) {
            d();
            if (this.f16408v == null) {
                return;
            }
        }
        if (this.K == 0) {
            View view = this.f16409w;
            if (view != null) {
                view.setTranslationX(-this.A);
            }
            View view2 = this.f16410x;
            if (view2 != null) {
                view2.setTranslationX(this.B);
            }
        }
        super.onLayout(z2, i2, i3, i4, i5);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = this.f16409w;
        if (view != null) {
            this.A = view.getMeasuredWidth();
            int i4 = this.A;
            double d2 = i4;
            Double.isNaN(d2);
            this.f16412z = (int) (d2 * 0.6d);
            this.C = i4 + this.f16412z;
        }
        View view2 = this.f16410x;
        if (view2 != null) {
            this.B = view2.getMeasuredWidth();
            if (this.f16412z == 0) {
                int i5 = this.B;
                double d3 = i5;
                Double.isNaN(d3);
                this.f16412z = (int) (d3 * 0.6d);
                this.C = i5 + this.f16412z;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.K == 4) {
            return super.onTouchEvent(motionEvent);
        }
        int x2 = (int) motionEvent.getX();
        motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.F = x2;
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                int i2 = x2 - this.F;
                this.F = x2;
                this.G += i2 * (1.0f - Math.abs(this.G / this.C));
                getParent().requestDisallowInterceptTouchEvent(true);
                int i3 = this.H;
                if (i3 == 0) {
                    float f2 = this.G;
                    if (f2 <= 0.0f) {
                        this.G = 0.0f;
                        this.f16408v.setTranslationX(0.0f);
                    } else {
                        int i4 = this.C;
                        if (f2 >= i4) {
                            this.G = i4;
                            this.f16408v.setTranslationX(this.G);
                        } else {
                            this.f16408v.setTranslationX(f2);
                            if (this.K == 3 || this.G < this.A) {
                                this.K = 2;
                                this.f16406t.a(this.G, Math.abs(this.G / this.A), this.f16409w);
                            } else {
                                this.K = 3;
                                this.f16406t.b(this.f16409w);
                            }
                        }
                    }
                    String str = "-leftHeaderWidth: " + (-this.A) + ", mTargetTranslationX: " + this.G + ", " + ((-this.A) + this.G);
                    this.f16409w.setTranslationX((-this.A) + this.G);
                } else if (i3 == 1) {
                    float f3 = this.G;
                    if (f3 >= 0.0f) {
                        this.G = 0.0f;
                        this.f16408v.setTranslationX(0.0f);
                    } else {
                        int i5 = this.C;
                        if (f3 <= (-i5)) {
                            this.G = -i5;
                            this.f16408v.setTranslationX(this.G);
                        } else {
                            this.f16408v.setTranslationX(f3);
                            if (this.K == 3 || this.G > (-this.B)) {
                                this.K = 2;
                                this.f16407u.a(this.G, Math.abs(this.G / this.B), this.f16410x);
                            } else {
                                this.K = 3;
                                this.f16407u.b(this.f16410x);
                            }
                        }
                    }
                    this.f16410x.setTranslationX(this.B + this.G);
                }
                return true;
            }
            if (action != 3) {
                return super.onTouchEvent(motionEvent);
            }
        }
        this.D = 0;
        this.F = 0;
        this.E = 0;
        int i6 = this.H;
        if (i6 == 0) {
            if (this.G < this.A) {
                g();
            } else {
                f();
            }
        } else if (i6 == 1) {
            if (this.G > (-this.B)) {
                g();
            } else {
                f();
            }
        }
        return true;
    }

    public void setFinishRefresh(boolean z2) {
    }

    public void setLeftEnable(boolean z2) {
        this.J = z2;
    }

    public void setRefreshCallback(com.kathline.horizontalrefresh.a aVar) {
        this.f16411y = aVar;
    }

    public void setRightEnable(boolean z2) {
        this.I = z2;
    }

    private void d() {
        if (this.f16408v == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.f16409w) && !childAt.equals(this.f16410x)) {
                    this.f16408v = childAt;
                    return;
                }
            }
        }
    }

    public void c() {
        g();
    }

    public boolean b() {
        return this.f16408v.canScrollHorizontally(-1);
    }

    public void a(com.kathline.horizontalrefresh.b bVar, int i2) {
        if (i2 == 0) {
            this.f16406t = bVar;
            setLeftHeadView(this.f16406t.a((ViewGroup) this));
        } else if (i2 == 1) {
            this.f16407u = bVar;
            setRightHeadView(this.f16407u.a((ViewGroup) this));
        }
    }

    public HorizontalRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = 0.0f;
        this.H = -1;
        this.I = true;
        this.J = true;
        this.K = 0;
        e();
    }

    public boolean a() {
        return this.f16408v.canScrollHorizontally(1);
    }

    public HorizontalRefreshLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.G = 0.0f;
        this.H = -1;
        this.I = true;
        this.J = true;
        this.K = 0;
        e();
    }
}
