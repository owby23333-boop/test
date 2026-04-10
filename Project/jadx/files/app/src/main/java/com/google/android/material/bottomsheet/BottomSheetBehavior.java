package com.google.android.material.bottomsheet;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.s;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int Y = R$style.Widget_Design_BottomSheet_Modal;
    float A;
    int B;
    float C;
    boolean D;
    private boolean E;
    private boolean F;
    int G;

    @Nullable
    ViewDragHelper H;
    private boolean I;
    private int J;
    private boolean K;
    private int L;
    int M;
    int N;

    @Nullable
    WeakReference<V> O;

    @Nullable
    WeakReference<View> P;

    @NonNull
    private final ArrayList<g> Q;

    @Nullable
    private VelocityTracker R;
    int S;
    private int T;
    boolean U;

    @Nullable
    private Map<View, Integer> V;
    private int W;
    private final ViewDragHelper.Callback X;
    private int a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f15050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f15052f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f15053g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f15054h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f15055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MaterialShapeDrawable f15056j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f15057k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f15058l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f15059m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f15060n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f15061o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f15062p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f15063q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f15064r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f15065s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private l f15066t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f15067u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private BottomSheetBehavior<V>.h f15068v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private ValueAnimator f15069w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    int f15070x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    int f15071y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f15072z;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SaveFlags {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface State {
    }

    class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ View f15078s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f15079t;

        a(BottomSheetBehavior bottomSheetBehavior, View view, ViewGroup.LayoutParams layoutParams) {
            this.f15078s = view;
            this.f15079t = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15078s.setLayoutParams(this.f15079t);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ View f15080s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f15081t;

        b(View view, int i2) {
            this.f15080s = view;
            this.f15081t = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.a(this.f15080s, this.f15081t);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f15056j != null) {
                BottomSheetBehavior.this.f15056j.c(fFloatValue);
            }
        }
    }

    class d implements s.e {
        final /* synthetic */ boolean a;

        d(boolean z2) {
            this.a = z2;
        }

        @Override // com.google.android.material.internal.s.e
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, s.f fVar) {
            BottomSheetBehavior.this.f15065s = windowInsetsCompat.getSystemWindowInsetTop();
            boolean zE = s.e(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.f15060n) {
                BottomSheetBehavior.this.f15064r = windowInsetsCompat.getSystemWindowInsetBottom();
                paddingBottom = fVar.f15547d + BottomSheetBehavior.this.f15064r;
            }
            if (BottomSheetBehavior.this.f15061o) {
                paddingLeft = (zE ? fVar.f15546c : fVar.a) + windowInsetsCompat.getSystemWindowInsetLeft();
            }
            if (BottomSheetBehavior.this.f15062p) {
                paddingRight = (zE ? fVar.a : fVar.f15546c) + windowInsetsCompat.getSystemWindowInsetRight();
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.a) {
                BottomSheetBehavior.this.f15058l = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
            }
            if (BottomSheetBehavior.this.f15060n || this.a) {
                BottomSheetBehavior.this.g(false);
            }
            return windowInsetsCompat;
        }
    }

    class e extends ViewDragHelper.Callback {
        e() {
        }

        private boolean a(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.N + bottomSheetBehavior.a()) / 2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            int iA = BottomSheetBehavior.this.a();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return MathUtils.clamp(i2, iA, bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            if (i2 == 1 && BottomSheetBehavior.this.F) {
                BottomSheetBehavior.this.g(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.a(i3);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int iA;
            int i2 = 4;
            if (f3 < 0.0f) {
                if (BottomSheetBehavior.this.b) {
                    iA = BottomSheetBehavior.this.f15071y;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    int i3 = bottomSheetBehavior.f15072z;
                    if (top > i3) {
                        iA = i3;
                        i2 = 6;
                    } else {
                        iA = bottomSheetBehavior.a();
                    }
                }
                i2 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                if (bottomSheetBehavior2.D && bottomSheetBehavior2.a(view, f3)) {
                    if ((Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) && !a(view)) {
                        if (BottomSheetBehavior.this.b) {
                            iA = BottomSheetBehavior.this.f15071y;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.a()) < Math.abs(view.getTop() - BottomSheetBehavior.this.f15072z)) {
                            iA = BottomSheetBehavior.this.a();
                        } else {
                            iA = BottomSheetBehavior.this.f15072z;
                            i2 = 6;
                        }
                        i2 = 3;
                    } else {
                        iA = BottomSheetBehavior.this.N;
                        i2 = 5;
                    }
                } else if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                    int top2 = view.getTop();
                    if (!BottomSheetBehavior.this.b) {
                        BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                        int i4 = bottomSheetBehavior3.f15072z;
                        if (top2 < i4) {
                            if (top2 < Math.abs(top2 - bottomSheetBehavior3.B)) {
                                iA = BottomSheetBehavior.this.a();
                                i2 = 3;
                            } else {
                                iA = BottomSheetBehavior.this.f15072z;
                            }
                        } else if (Math.abs(top2 - i4) < Math.abs(top2 - BottomSheetBehavior.this.B)) {
                            iA = BottomSheetBehavior.this.f15072z;
                        } else {
                            iA = BottomSheetBehavior.this.B;
                        }
                        i2 = 6;
                    } else if (Math.abs(top2 - BottomSheetBehavior.this.f15071y) < Math.abs(top2 - BottomSheetBehavior.this.B)) {
                        iA = BottomSheetBehavior.this.f15071y;
                        i2 = 3;
                    } else {
                        iA = BottomSheetBehavior.this.B;
                    }
                } else if (BottomSheetBehavior.this.b) {
                    iA = BottomSheetBehavior.this.B;
                } else {
                    int top3 = view.getTop();
                    if (Math.abs(top3 - BottomSheetBehavior.this.f15072z) < Math.abs(top3 - BottomSheetBehavior.this.B)) {
                        iA = BottomSheetBehavior.this.f15072z;
                        i2 = 6;
                    } else {
                        iA = BottomSheetBehavior.this.B;
                    }
                }
            }
            BottomSheetBehavior.this.a(view, i2, iA, true);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.G;
            if (i3 == 1 || bottomSheetBehavior.U) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.S == i2) {
                WeakReference<View> weakReference = bottomSheetBehavior.P;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.O;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class f implements AccessibilityViewCommand {
        final /* synthetic */ int a;

        f(int i2) {
            this.a = i2;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            BottomSheetBehavior.this.f(this.a);
            return true;
        }
    }

    public static abstract class g {
        public abstract void a(@NonNull View view, float f2);

        public abstract void a(@NonNull View view, int i2);
    }

    private class h implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final View f15084s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private boolean f15085t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        int f15086u;

        h(View view, int i2) {
            this.f15084s = view;
            this.f15086u = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.H;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.g(this.f15086u);
            } else {
                ViewCompat.postOnAnimation(this.f15084s, this);
            }
            this.f15085t = false;
        }
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.f15049c = false;
        this.f15057k = -1;
        this.f15068v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList<>();
        this.W = -1;
        this.X = new e();
    }

    private void j(int i2) {
        ValueAnimator valueAnimator;
        if (i2 == 2) {
            return;
        }
        boolean z2 = i2 == 3;
        if (this.f15067u != z2) {
            this.f15067u = z2;
            if (this.f15056j == null || (valueAnimator = this.f15069w) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.f15069w.reverse();
                return;
            }
            float f2 = z2 ? 0.0f : 1.0f;
            this.f15069w.setFloatValues(1.0f - f2, f2);
            this.f15069w.start();
        }
    }

    private void k() {
        V v2;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null || (v2 = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v2, 524288);
        ViewCompat.removeAccessibilityAction(v2, 262144);
        ViewCompat.removeAccessibilityAction(v2, 1048576);
        int i2 = this.W;
        if (i2 != -1) {
            ViewCompat.removeAccessibilityAction(v2, i2);
        }
        if (!this.b && this.G != 6) {
            this.W = a(v2, R$string.bottomsheet_action_expand_halfway, 6);
        }
        if (this.D && this.G != 5) {
            a(v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i3 = this.G;
        if (i3 == 3) {
            a(v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.b ? 4 : 6);
            return;
        }
        if (i3 == 4) {
            a(v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.b ? 3 : 6);
        } else {
            if (i3 != 6) {
                return;
            }
            a(v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            a(v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.O = null;
        this.H = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.O = null;
        this.H = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!v2.isShown() || !this.F) {
            this.I = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            j();
        }
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x2 = (int) motionEvent.getX();
            this.T = (int) motionEvent.getY();
            if (this.G != 2) {
                WeakReference<View> weakReference = this.P;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x2, this.T)) {
                    this.S = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.U = true;
                }
            }
            this.I = this.S == -1 && !coordinatorLayout.isPointInChildBounds(v2, x2, this.T);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.U = false;
            this.S = -1;
            if (this.I) {
                this.I = false;
                return false;
            }
        }
        if (!this.I && (viewDragHelper = this.H) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.P;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.I || this.G == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.H == null || Math.abs(((float) this.T) - motionEvent.getY()) <= ((float) this.H.getTouchSlop())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, int i2) {
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v2)) {
            v2.setFitsSystemWindows(true);
        }
        if (this.O == null) {
            this.f15053g = coordinatorLayout.getResources().getDimensionPixelSize(R$dimen.design_bottom_sheet_peek_height_min);
            c(v2);
            this.O = new WeakReference<>(v2);
            if (this.f15055i && (materialShapeDrawable = this.f15056j) != null) {
                ViewCompat.setBackground(v2, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.f15056j;
            if (materialShapeDrawable2 != null) {
                float elevation = this.C;
                if (elevation == -1.0f) {
                    elevation = ViewCompat.getElevation(v2);
                }
                materialShapeDrawable2.b(elevation);
                this.f15067u = this.G == 3;
                this.f15056j.c(this.f15067u ? 0.0f : 1.0f);
            }
            k();
            if (ViewCompat.getImportantForAccessibility(v2) == 0) {
                ViewCompat.setImportantForAccessibility(v2, 1);
            }
            int measuredWidth = v2.getMeasuredWidth();
            int i3 = this.f15057k;
            if (measuredWidth > i3 && i3 != -1) {
                ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
                layoutParams.width = this.f15057k;
                v2.post(new a(this, v2, layoutParams));
            }
        }
        if (this.H == null) {
            this.H = ViewDragHelper.create(coordinatorLayout, this.X);
        }
        int top = v2.getTop();
        coordinatorLayout.onLayoutChild(v2, i2);
        this.M = coordinatorLayout.getWidth();
        this.N = coordinatorLayout.getHeight();
        this.L = v2.getHeight();
        int i4 = this.N;
        int i5 = i4 - this.L;
        int i6 = this.f15065s;
        if (i5 < i6) {
            if (this.f15063q) {
                this.L = i4;
            } else {
                this.L = i4 - i6;
            }
        }
        this.f15071y = Math.max(0, this.N - this.L);
        f();
        e();
        int i7 = this.G;
        if (i7 == 3) {
            ViewCompat.offsetTopAndBottom(v2, a());
        } else if (i7 == 6) {
            ViewCompat.offsetTopAndBottom(v2, this.f15072z);
        } else if (this.D && i7 == 5) {
            ViewCompat.offsetTopAndBottom(v2, this.N);
        } else {
            int i8 = this.G;
            if (i8 == 4) {
                ViewCompat.offsetTopAndBottom(v2, this.B);
            } else if (i8 == 1 || i8 == 2) {
                ViewCompat.offsetTopAndBottom(v2, top - v2.getTop());
            }
        }
        this.P = new WeakReference<>(a(v2));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, float f2, float f3) {
        WeakReference<View> weakReference = this.P;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.G != 3 || super.onNestedPreFling(coordinatorLayout, v2, view, f2, f3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
        if (i4 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.P;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v2.getTop();
        int i5 = top - i3;
        if (i3 > 0) {
            if (i5 < a()) {
                iArr[1] = top - a();
                ViewCompat.offsetTopAndBottom(v2, -iArr[1]);
                g(3);
            } else {
                if (!this.F) {
                    return;
                }
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v2, -i3);
                g(1);
            }
        } else if (i3 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.B;
            if (i5 > i6 && !this.D) {
                iArr[1] = top - i6;
                ViewCompat.offsetTopAndBottom(v2, -iArr[1]);
                g(4);
            } else {
                if (!this.F) {
                    return;
                }
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v2, -i3);
                g(1);
            }
        }
        a(v2.getTop());
        this.J = i3;
        this.K = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v2, savedState.getSuperState());
        a(savedState);
        int i2 = savedState.f15073s;
        if (i2 == 1 || i2 == 2) {
            this.G = 4;
        } else {
            this.G = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v2), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, @NonNull View view2, int i2, int i3) {
        this.J = 0;
        this.K = false;
        return (i2 & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull View view, int i2) {
        int iA;
        int i3 = 3;
        if (v2.getTop() == a()) {
            g(3);
            return;
        }
        WeakReference<View> weakReference = this.P;
        if (weakReference != null && view == weakReference.get() && this.K) {
            if (this.J > 0) {
                if (this.b) {
                    iA = this.f15071y;
                } else {
                    int top = v2.getTop();
                    int i4 = this.f15072z;
                    if (top > i4) {
                        iA = i4;
                        i3 = 6;
                    } else {
                        iA = a();
                    }
                }
            } else if (this.D && a(v2, i())) {
                iA = this.N;
                i3 = 5;
            } else if (this.J == 0) {
                int top2 = v2.getTop();
                if (!this.b) {
                    int i5 = this.f15072z;
                    if (top2 < i5) {
                        if (top2 < Math.abs(top2 - this.B)) {
                            iA = a();
                        } else {
                            iA = this.f15072z;
                        }
                    } else if (Math.abs(top2 - i5) < Math.abs(top2 - this.B)) {
                        iA = this.f15072z;
                    } else {
                        iA = this.B;
                        i3 = 4;
                    }
                    i3 = 6;
                } else if (Math.abs(top2 - this.f15071y) < Math.abs(top2 - this.B)) {
                    iA = this.f15071y;
                } else {
                    iA = this.B;
                    i3 = 4;
                }
            } else {
                if (this.b) {
                    iA = this.B;
                } else {
                    int top3 = v2.getTop();
                    if (Math.abs(top3 - this.f15072z) < Math.abs(top3 - this.B)) {
                        iA = this.f15072z;
                        i3 = 6;
                    } else {
                        iA = this.B;
                    }
                }
                i3 = 4;
            }
            a((View) v2, i3, iA, false);
            this.K = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v2, @NonNull MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.G == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.H;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            j();
        }
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        if (this.H != null && actionMasked == 2 && !this.I && Math.abs(this.T - motionEvent.getY()) > this.H.getTouchSlop()) {
            this.H.captureChildView(v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z2) {
        V v2;
        if (this.O != null) {
            e();
            if (this.G != 4 || (v2 = this.O.get()) == null) {
                return;
            }
            if (z2) {
                i(this.G);
            } else {
                v2.requestLayout();
            }
        }
    }

    private void h() {
        this.f15069w = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f15069w.setDuration(500L);
        this.f15069w.addUpdateListener(new c());
    }

    private void i(int i2) {
        V v2 = this.O.get();
        if (v2 == null) {
            return;
        }
        ViewParent parent = v2.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v2)) {
            v2.post(new b(v2, i2));
        } else {
            a((View) v2, i2);
        }
    }

    public void d(int i2) {
        a(i2, false);
    }

    public void e(boolean z2) {
        this.E = z2;
    }

    public void f(int i2) {
        if (i2 == this.G) {
            return;
        }
        if (this.O != null) {
            i(i2);
            return;
        }
        if (i2 == 4 || i2 == 3 || i2 == 6 || (this.D && i2 == 5)) {
            this.G = i2;
        }
    }

    public void b(boolean z2) {
        if (this.b == z2) {
            return;
        }
        this.b = z2;
        if (this.O != null) {
            e();
        }
        g((this.b && this.G == 6) ? 3 : this.G);
        k();
    }

    public void c(@Px int i2) {
        this.f15057k = i2;
    }

    public void d(boolean z2) {
        if (this.D != z2) {
            this.D = z2;
            if (!z2 && this.G == 5) {
                f(4);
            }
            k();
        }
    }

    public void e(int i2) {
        this.a = i2;
    }

    private void e() {
        int iG = g();
        if (this.b) {
            this.B = Math.max(this.N - iG, this.f15071y);
        } else {
            this.B = this.N - iG;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto Lc
            boolean r4 = r3.f15052f
            if (r4 != 0) goto L15
            r3.f15052f = r0
            goto L1f
        Lc:
            boolean r2 = r3.f15052f
            if (r2 != 0) goto L17
            int r2 = r3.f15051e
            if (r2 == r4) goto L15
            goto L17
        L15:
            r0 = 0
            goto L1f
        L17:
            r3.f15052f = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.f15051e = r4
        L1f:
            if (r0 == 0) goto L24
            r3.g(r5)
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(int, boolean):void");
    }

    public void c(boolean z2) {
        this.f15059m = z2;
    }

    private AccessibilityViewCommand h(int i2) {
        return new f(i2);
    }

    public int c() {
        return this.G;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final int f15073s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f15074t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        boolean f15075u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        boolean f15076v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f15077w;

        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f15073s = parcel.readInt();
            this.f15074t = parcel.readInt();
            this.f15075u = parcel.readInt() == 1;
            this.f15076v = parcel.readInt() == 1;
            this.f15077w = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f15073s);
            parcel.writeInt(this.f15074t);
            parcel.writeInt(this.f15075u ? 1 : 0);
            parcel.writeInt(this.f15076v ? 1 : 0);
            parcel.writeInt(this.f15077w ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f15073s = bottomSheetBehavior.G;
            this.f15074t = ((BottomSheetBehavior) bottomSheetBehavior).f15051e;
            this.f15075u = ((BottomSheetBehavior) bottomSheetBehavior).b;
            this.f15076v = bottomSheetBehavior.D;
            this.f15077w = ((BottomSheetBehavior) bottomSheetBehavior).E;
        }
    }

    private void c(@NonNull View view) {
        boolean z2 = (Build.VERSION.SDK_INT < 29 || d() || this.f15052f) ? false : true;
        if (this.f15060n || this.f15061o || this.f15062p || z2) {
            s.a(view, new d(z2));
        }
    }

    private void f() {
        this.f15072z = (int) (this.N * (1.0f - this.A));
    }

    private float i() {
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f15050d);
        return this.R.getYVelocity(this.S);
    }

    private void f(boolean z2) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z2) {
                if (this.V != null) {
                    return;
                } else {
                    this.V = new HashMap(childCount);
                }
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.O.get()) {
                    if (z2) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.V.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.f15049c) {
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.f15049c && (map = this.V) != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.V.get(childAt).intValue());
                    }
                }
            }
            if (!z2) {
                this.V = null;
            } else if (this.f15049c) {
                this.O.get().sendAccessibilityEvent(8);
            }
        }
    }

    private void j() {
        this.S = -1;
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.R = null;
        }
    }

    public boolean d() {
        return this.f15059m;
    }

    void g(int i2) {
        V v2;
        if (this.G == i2) {
            return;
        }
        this.G = i2;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null || (v2 = weakReference.get()) == null) {
            return;
        }
        if (i2 == 3) {
            f(true);
        } else if (i2 == 6 || i2 == 5 || i2 == 4) {
            f(false);
        }
        j(i2);
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            this.Q.get(i3).a((View) v2, i2);
        }
        k();
    }

    public void b(int i2) {
        if (i2 >= 0) {
            this.f15070x = i2;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void a(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        if (f2 > 0.0f && f2 < 1.0f) {
            this.A = f2;
            if (this.O != null) {
                f();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void b(@NonNull g gVar) {
        this.Q.remove(gVar);
    }

    MaterialShapeDrawable b() {
        return this.f15056j;
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> b(@NonNull V v2) {
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i2;
        super(context, attributeSet);
        this.a = 0;
        this.b = true;
        this.f15049c = false;
        this.f15057k = -1;
        this.f15068v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList<>();
        this.W = -1;
        this.X = new e();
        this.f15054h = context.getResources().getDimensionPixelSize(R$dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BottomSheetBehavior_Layout);
        this.f15055i = typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (zHasValue) {
            a(context, attributeSet, zHasValue, com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, R$styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            a(context, attributeSet, zHasValue);
        }
        h();
        if (Build.VERSION.SDK_INT >= 21) {
            this.C = typedArrayObtainStyledAttributes.getDimension(R$styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R$styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            c(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_android_maxWidth, -1));
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && (i2 = typedValuePeekValue.data) == -1) {
            d(i2);
        } else {
            d(typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        d(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        c(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        b(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        e(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        a(typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        e(typedArrayObtainStyledAttributes.getInt(R$styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        a(typedArrayObtainStyledAttributes.getFloat(R$styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            b(typedValuePeekValue2.data);
        } else {
            b(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        this.f15060n = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.f15061o = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.f15062p = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.f15063q = typedArrayObtainStyledAttributes.getBoolean(R$styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f15050d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public int a() {
        if (this.b) {
            return this.f15071y;
        }
        return Math.max(this.f15070x, this.f15063q ? 0 : this.f15065s);
    }

    public void a(boolean z2) {
        this.F = z2;
    }

    public void a(@NonNull g gVar) {
        if (this.Q.contains(gVar)) {
            return;
        }
        this.Q.add(gVar);
    }

    private int g() {
        int i2;
        if (this.f15052f) {
            return Math.min(Math.max(this.f15053g, this.N - ((this.M * 9) / 16)), this.L) + this.f15064r;
        }
        if (!this.f15059m && !this.f15060n && (i2 = this.f15058l) > 0) {
            return Math.max(this.f15051e, i2 + this.f15054h);
        }
        return this.f15051e + this.f15064r;
    }

    private void a(@NonNull SavedState savedState) {
        int i2 = this.a;
        if (i2 == 0) {
            return;
        }
        if (i2 == -1 || (i2 & 1) == 1) {
            this.f15051e = savedState.f15074t;
        }
        int i3 = this.a;
        if (i3 == -1 || (i3 & 2) == 2) {
            this.b = savedState.f15075u;
        }
        int i4 = this.a;
        if (i4 == -1 || (i4 & 4) == 4) {
            this.D = savedState.f15076v;
        }
        int i5 = this.a;
        if (i5 == -1 || (i5 & 8) == 8) {
            this.E = savedState.f15077w;
        }
    }

    boolean a(@NonNull View view, float f2) {
        if (this.E) {
            return true;
        }
        if (view.getTop() < this.B) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.B)) / ((float) g()) > 0.5f;
    }

    @Nullable
    @VisibleForTesting
    View a(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View viewA = a(viewGroup.getChildAt(i2));
            if (viewA != null) {
                return viewA;
            }
        }
        return null;
    }

    private void a(@NonNull Context context, AttributeSet attributeSet, boolean z2) {
        a(context, attributeSet, z2, (ColorStateList) null);
    }

    private void a(@NonNull Context context, AttributeSet attributeSet, boolean z2, @Nullable ColorStateList colorStateList) {
        if (this.f15055i) {
            this.f15066t = l.a(context, attributeSet, R$attr.bottomSheetStyle, Y).a();
            this.f15056j = new MaterialShapeDrawable(this.f15066t);
            this.f15056j.a(context);
            if (z2 && colorStateList != null) {
                this.f15056j.a(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.f15056j.setTint(typedValue.data);
        }
    }

    void a(@NonNull View view, int i2) {
        int iA;
        int i3;
        if (i2 == 4) {
            iA = this.B;
        } else if (i2 == 6) {
            int i4 = this.f15072z;
            if (!this.b || i4 > (i3 = this.f15071y)) {
                iA = i4;
            } else {
                iA = i3;
                i2 = 3;
            }
        } else if (i2 == 3) {
            iA = a();
        } else if (this.D && i2 == 5) {
            iA = this.N;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        }
        a(view, i2, iA, false);
    }

    void a(View view, int i2, int i3, boolean z2) {
        ViewDragHelper viewDragHelper = this.H;
        if (viewDragHelper != null && (!z2 ? !viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i3) : !viewDragHelper.settleCapturedViewAt(view.getLeft(), i3))) {
            g(2);
            j(i2);
            if (this.f15068v == null) {
                this.f15068v = new h(view, i2);
            }
            if (!((h) this.f15068v).f15085t) {
                BottomSheetBehavior<V>.h hVar = this.f15068v;
                hVar.f15086u = i2;
                ViewCompat.postOnAnimation(view, hVar);
                ((h) this.f15068v).f15085t = true;
                return;
            }
            this.f15068v.f15086u = i2;
            return;
        }
        g(i2);
    }

    void a(int i2) {
        float f2;
        float fA;
        V v2 = this.O.get();
        if (v2 == null || this.Q.isEmpty()) {
            return;
        }
        int i3 = this.B;
        if (i2 <= i3 && i3 != a()) {
            int i4 = this.B;
            f2 = i4 - i2;
            fA = i4 - a();
        } else {
            int i5 = this.B;
            f2 = i5 - i2;
            fA = this.N - i5;
        }
        float f3 = f2 / fA;
        for (int i6 = 0; i6 < this.Q.size(); i6++) {
            this.Q.get(i6).a(v2, f3);
        }
    }

    private void a(V v2, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i2) {
        ViewCompat.replaceAccessibilityAction(v2, accessibilityActionCompat, null, h(i2));
    }

    private int a(V v2, @StringRes int i2, int i3) {
        return ViewCompat.addAccessibilityAction(v2, v2.getResources().getString(i2), h(i3));
    }
}
