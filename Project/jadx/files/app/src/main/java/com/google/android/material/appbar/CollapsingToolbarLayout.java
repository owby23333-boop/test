package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int V = R$style.Widget_Design_CollapsingToolbar;
    private int A;
    private final Rect B;

    @NonNull
    final com.google.android.material.internal.a C;

    @NonNull
    final com.google.android.material.f.a D;
    private boolean E;
    private boolean F;

    @Nullable
    private Drawable G;

    @Nullable
    Drawable H;
    private int I;
    private boolean J;
    private ValueAnimator K;
    private long L;
    private int M;
    private AppBarLayout.d N;
    int O;
    private int P;

    @Nullable
    WindowInsetsCompat Q;
    private int R;
    private boolean S;
    private int T;
    private boolean U;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f14948s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f14949t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private ViewGroup f14950u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private View f14951v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private View f14952w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f14953x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f14954y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f14955z;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TitleCollapseMode {
    }

    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return CollapsingToolbarLayout.this.a(windowInsetsCompat);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    private class c implements AppBarLayout.d {
        c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i2) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.O = i2;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.Q;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                com.google.android.material.appbar.a aVarE = CollapsingToolbarLayout.e(childAt);
                int i4 = layoutParams.a;
                if (i4 == 1) {
                    aVarE.b(MathUtils.clamp(-i2, 0, CollapsingToolbarLayout.this.a(childAt)));
                } else if (i4 == 2) {
                    aVarE.b(Math.round((-i2) * layoutParams.b));
                }
            }
            CollapsingToolbarLayout.this.a();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.H != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            int height = (CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop;
            float f2 = height;
            CollapsingToolbarLayout.this.C.c(Math.min(1.0f, (r0 - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()) / f2));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.C.c(collapsingToolbarLayout3.O + height);
            CollapsingToolbarLayout.this.C.b(Math.abs(i2) / f2);
        }
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void b() {
        if (this.f14948s) {
            ViewGroup viewGroup = null;
            this.f14950u = null;
            this.f14951v = null;
            int i2 = this.f14949t;
            if (i2 != -1) {
                this.f14950u = (ViewGroup) findViewById(i2);
                ViewGroup viewGroup2 = this.f14950u;
                if (viewGroup2 != null) {
                    this.f14951v = b(viewGroup2);
                }
            }
            if (this.f14950u == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if (f(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i3++;
                }
                this.f14950u = viewGroup;
            }
            e();
            this.f14948s = false;
        }
    }

    private boolean c() {
        return this.P == 1;
    }

    private static CharSequence d(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (Build.VERSION.SDK_INT < 21 || !(view instanceof android.widget.Toolbar)) {
            return null;
        }
        return ((android.widget.Toolbar) view).getTitle();
    }

    private void e() {
        View view;
        if (!this.E && (view = this.f14952w) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f14952w);
            }
        }
        if (!this.E || this.f14950u == null) {
            return;
        }
        if (this.f14952w == null) {
            this.f14952w = new View(getContext());
        }
        if (this.f14952w.getParent() == null) {
            this.f14950u.addView(this.f14952w, -1, -1);
        }
    }

    private static boolean f(View view) {
        return (view instanceof Toolbar) || (Build.VERSION.SDK_INT >= 21 && (view instanceof android.widget.Toolbar));
    }

    private boolean g(View view) {
        View view2 = this.f14951v;
        if (view2 == null || view2 == this) {
            if (view == this.f14950u) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    WindowInsetsCompat a(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.Q, windowInsetsCompat2)) {
            this.Q = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        b();
        if (this.f14950u == null && (drawable = this.G) != null && this.I > 0) {
            drawable.mutate().setAlpha(this.I);
            this.G.draw(canvas);
        }
        if (this.E && this.F) {
            if (this.f14950u == null || this.G == null || this.I <= 0 || !c() || this.C.k() >= this.C.l()) {
                this.C.a(canvas);
            } else {
                int iSave = canvas.save();
                canvas.clipRect(this.G.getBounds(), Region.Op.DIFFERENCE);
                this.C.a(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        if (this.H == null || this.I <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.Q;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.H.setBounds(0, -this.O, getWidth(), systemWindowInsetTop - this.O);
            this.H.mutate().setAlpha(this.I);
            this.H.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z2;
        if (this.G == null || this.I <= 0 || !g(view)) {
            z2 = false;
        } else {
            a(this.G, view, getWidth(), getHeight());
            this.G.mutate().setAlpha(this.I);
            this.G.draw(canvas);
            z2 = true;
        }
        return super.drawChild(canvas, view, j2) || z2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.H;
        boolean zA = false;
        if (drawable != null && drawable.isStateful()) {
            zA = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.G;
        if (drawable2 != null && drawable2.isStateful()) {
            zA |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.a aVar = this.C;
        if (aVar != null) {
            zA |= aVar.a(drawableState);
        }
        if (zA) {
            invalidate();
        }
    }

    public int getCollapsedTitleGravity() {
        return this.C.c();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.C.e();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.G;
    }

    public int getExpandedTitleGravity() {
        return this.C.h();
    }

    public int getExpandedTitleMarginBottom() {
        return this.A;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f14955z;
    }

    public int getExpandedTitleMarginStart() {
        return this.f14953x;
    }

    public int getExpandedTitleMarginTop() {
        return this.f14954y;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.C.j();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.C.m();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.C.n();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.C.o();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.C.p();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.C.q();
    }

    int getScrimAlpha() {
        return this.I;
    }

    public long getScrimAnimationDuration() {
        return this.L;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.M;
        if (i2 >= 0) {
            return i2 + this.R + this.T;
        }
        WindowInsetsCompat windowInsetsCompat = this.Q;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.H;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.E) {
            return this.C.r();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.P;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            a(appBarLayout);
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows(appBarLayout));
            if (this.N == null) {
                this.N = new c();
            }
            appBarLayout.a(this.N);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.d dVar = this.N;
        if (dVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).b(dVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        WindowInsetsCompat windowInsetsCompat = this.Q;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            e(getChildAt(i7)).d();
        }
        a(i2, i3, i4, i5, false);
        f();
        a();
        int childCount3 = getChildCount();
        for (int i8 = 0; i8 < childCount3; i8++) {
            e(getChildAt(i8)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        b();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        WindowInsetsCompat windowInsetsCompat = this.Q;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if ((mode == 0 || this.S) && systemWindowInsetTop > 0) {
            this.R = systemWindowInsetTop;
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
        }
        if (this.U && this.C.q() > 1) {
            f();
            a(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int iN = this.C.n();
            if (iN > 1) {
                this.T = Math.round(this.C.g()) * (iN - 1);
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.T, 1073741824));
            }
        }
        if (this.f14950u != null) {
            View view = this.f14951v;
            if (view == null || view == this) {
                setMinimumHeight(c(this.f14950u));
            } else {
                setMinimumHeight(c(view));
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.G;
        if (drawable != null) {
            a(drawable, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.C.b(i2);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        this.C.a(i2);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.C.a(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.G;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.G = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.G;
            if (drawable3 != null) {
                a(drawable3, getWidth(), getHeight());
                this.G.setCallback(this);
                this.G.setAlpha(this.I);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(@DrawableRes int i2) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setExpandedTitleColor(@ColorInt int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.C.e(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.A = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f14955z = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f14953x = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f14954y = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        this.C.d(i2);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.C.b(colorStateList);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.C.b(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z2) {
        this.U = z2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z2) {
        this.S = z2;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i2) {
        this.C.f(i2);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f2) {
        this.C.d(f2);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE) float f2) {
        this.C.e(f2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i2) {
        this.C.g(i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z2) {
        this.C.c(z2);
    }

    void setScrimAlpha(int i2) {
        ViewGroup viewGroup;
        if (i2 != this.I) {
            if (this.G != null && (viewGroup = this.f14950u) != null) {
                ViewCompat.postInvalidateOnAnimation(viewGroup);
            }
            this.I = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j2) {
        this.L = j2;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i2) {
        if (this.M != i2) {
            this.M = i2;
            a();
        }
    }

    public void setScrimsShown(boolean z2) {
        a(z2, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.H;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.H = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.H;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.H.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.H, ViewCompat.getLayoutDirection(this));
                this.H.setVisible(getVisibility() == 0, false);
                this.H.setCallback(this);
                this.H.setAlpha(this.I);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(@DrawableRes int i2) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.C.a(charSequence);
        d();
    }

    public void setTitleCollapseMode(int i2) {
        this.P = i2;
        boolean zC = c();
        this.C.b(zC);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            a((AppBarLayout) parent);
        }
        if (zC && this.G == null) {
            setContentScrimColor(this.D.b(getResources().getDimension(R$dimen.design_appbar_elevation)));
        }
    }

    public void setTitleEnabled(boolean z2) {
        if (z2 != this.E) {
            this.E = z2;
            d();
            e();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.H;
        if (drawable != null && drawable.isVisible() != z2) {
            this.H.setVisible(z2, false);
        }
        Drawable drawable2 = this.G;
        if (drawable2 == null || drawable2.isVisible() == z2) {
            return;
        }
        this.G.setVisible(z2, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.G || drawable == this.H;
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.collapsingToolbarLayoutStyle);
    }

    private static int c(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private void f() {
        if (this.f14950u != null && this.E && TextUtils.isEmpty(this.C.r())) {
            setTitle(d(this.f14950u));
        }
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.C.a(colorStateList);
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, V), attributeSet, i2);
        this.f14948s = true;
        this.B = new Rect();
        this.M = -1;
        this.R = 0;
        this.T = 0;
        Context context2 = getContext();
        this.C = new com.google.android.material.internal.a(this);
        this.C.b(com.google.android.material.a.a.f14916e);
        this.C.c(false);
        this.D = new com.google.android.material.f.a(context2);
        TypedArray typedArrayC = l.c(context2, attributeSet, R$styleable.CollapsingToolbarLayout, i2, V, new int[0]);
        this.C.e(typedArrayC.getInt(R$styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.C.b(typedArrayC.getInt(R$styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = typedArrayC.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.A = dimensionPixelSize;
        this.f14955z = dimensionPixelSize;
        this.f14954y = dimensionPixelSize;
        this.f14953x = dimensionPixelSize;
        if (typedArrayC.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.f14953x = typedArrayC.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (typedArrayC.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.f14955z = typedArrayC.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (typedArrayC.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.f14954y = typedArrayC.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (typedArrayC.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.A = typedArrayC.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.E = typedArrayC.getBoolean(R$styleable.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(typedArrayC.getText(R$styleable.CollapsingToolbarLayout_title));
        this.C.d(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.C.a(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (typedArrayC.hasValue(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.C.d(typedArrayC.getResourceId(R$styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (typedArrayC.hasValue(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.C.a(typedArrayC.getResourceId(R$styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.M = typedArrayC.getDimensionPixelSize(R$styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (typedArrayC.hasValue(R$styleable.CollapsingToolbarLayout_maxLines)) {
            this.C.g(typedArrayC.getInt(R$styleable.CollapsingToolbarLayout_maxLines, 1));
        }
        this.L = typedArrayC.getInt(R$styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(typedArrayC.getDrawable(R$styleable.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(typedArrayC.getDrawable(R$styleable.CollapsingToolbarLayout_statusBarScrim));
        setTitleCollapseMode(typedArrayC.getInt(R$styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.f14949t = typedArrayC.getResourceId(R$styleable.CollapsingToolbarLayout_toolbarId, -1);
        this.S = typedArrayC.getBoolean(R$styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.U = typedArrayC.getBoolean(R$styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        typedArrayC.recycle();
        setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    private void d() {
        setContentDescription(getTitle());
    }

    private void a(AppBarLayout appBarLayout) {
        if (c()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void a(@NonNull Drawable drawable, int i2, int i3) {
        a(drawable, this.f14950u, i2, i3);
    }

    private void a(@NonNull Drawable drawable, @Nullable View view, int i2, int i3) {
        if (c() && view != null && this.E) {
            i3 = view.getBottom();
        }
        drawable.setBounds(0, 0, i2, i3);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {
        int a;
        float b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            this.b = 0.5f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
            this.a = typedArrayObtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(typedArrayObtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(float f2) {
            this.b = f2;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.a = 0;
            this.b = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.b = 0.5f;
        }
    }

    @NonNull
    static com.google.android.material.appbar.a e(@NonNull View view) {
        com.google.android.material.appbar.a aVar = (com.google.android.material.appbar.a) view.getTag(R$id.view_offset_helper);
        if (aVar != null) {
            return aVar;
        }
        com.google.android.material.appbar.a aVar2 = new com.google.android.material.appbar.a(view);
        view.setTag(R$id.view_offset_helper, aVar2);
        return aVar2;
    }

    private void a(int i2, int i3, int i4, int i5, boolean z2) {
        View view;
        if (!this.E || (view = this.f14952w) == null) {
            return;
        }
        this.F = ViewCompat.isAttachedToWindow(view) && this.f14952w.getVisibility() == 0;
        if (this.F || z2) {
            boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
            a(z3);
            this.C.b(z3 ? this.f14955z : this.f14953x, this.B.top + this.f14954y, (i4 - i2) - (z3 ? this.f14953x : this.f14955z), (i5 - i3) - this.A);
            this.C.a(z2);
        }
    }

    @NonNull
    private View b(@NonNull View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private void a(boolean z2) {
        int titleMarginBottom;
        int titleMarginEnd;
        int titleMarginTop;
        View view = this.f14951v;
        if (view == null) {
            view = this.f14950u;
        }
        int iA = a(view);
        com.google.android.material.internal.c.a(this, this.f14952w, this.B);
        ViewGroup viewGroup = this.f14950u;
        int titleMarginStart = 0;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            titleMarginStart = toolbar.getTitleMarginStart();
            titleMarginEnd = toolbar.getTitleMarginEnd();
            titleMarginTop = toolbar.getTitleMarginTop();
            titleMarginBottom = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            titleMarginBottom = 0;
            titleMarginEnd = 0;
            titleMarginTop = 0;
        } else {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            titleMarginStart = toolbar2.getTitleMarginStart();
            titleMarginEnd = toolbar2.getTitleMarginEnd();
            titleMarginTop = toolbar2.getTitleMarginTop();
            titleMarginBottom = toolbar2.getTitleMarginBottom();
        }
        com.google.android.material.internal.a aVar = this.C;
        int i2 = this.B.left + (z2 ? titleMarginEnd : titleMarginStart);
        Rect rect = this.B;
        int i3 = rect.top + iA + titleMarginTop;
        int i4 = rect.right;
        if (z2) {
            titleMarginEnd = titleMarginStart;
        }
        aVar.a(i2, i3, i4 - titleMarginEnd, (this.B.bottom + iA) - titleMarginBottom);
    }

    public void a(boolean z2, boolean z3) {
        if (this.J != z2) {
            if (z3) {
                a(z2 ? 255 : 0);
            } else {
                setScrimAlpha(z2 ? 255 : 0);
            }
            this.J = z2;
        }
    }

    private void a(int i2) {
        b();
        ValueAnimator valueAnimator = this.K;
        if (valueAnimator == null) {
            this.K = new ValueAnimator();
            this.K.setDuration(this.L);
            this.K.setInterpolator(i2 > this.I ? com.google.android.material.a.a.f14914c : com.google.android.material.a.a.f14915d);
            this.K.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.K.cancel();
        }
        this.K.setIntValues(this.I, i2);
        this.K.start();
    }

    final void a() {
        if (this.G == null && this.H == null) {
            return;
        }
        setScrimsShown(getHeight() + this.O < getScrimVisibleHeightTrigger());
    }

    final int a(@NonNull View view) {
        return ((getHeight() - e(view).b()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }
}
