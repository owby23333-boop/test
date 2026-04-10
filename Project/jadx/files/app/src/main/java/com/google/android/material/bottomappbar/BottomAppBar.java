package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.a.k;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.l;
import com.google.android.material.internal.s;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final int N = R$style.Widget_MaterialComponents_BottomAppBar;
    private final boolean A;
    private final boolean B;
    private int C;
    private ArrayList<j> D;

    @MenuRes
    private int E;
    private boolean F;
    private boolean G;
    private Behavior H;
    private int I;
    private int J;
    private int K;

    @NonNull
    AnimatorListenerAdapter L;

    @NonNull
    k<FloatingActionButton> M;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f15015s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MaterialShapeDrawable f15016t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private Animator f15017u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private Animator f15018v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f15019w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f15020x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f15021y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final boolean f15022z;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        private final Rect f15023e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WeakReference<BottomAppBar> f15024f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f15025g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final View.OnLayoutChangeListener f15026h;

        class a implements View.OnLayoutChangeListener {
            a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f15024f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.b(Behavior.this.f15023e);
                int iHeight = Behavior.this.f15023e.height();
                bottomAppBar.b(iHeight);
                bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().j().a(new RectF(Behavior.this.f15023e)));
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.this.f15025g == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - iHeight) / 2));
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                    if (s.e(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.f15015s;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.f15015s;
                    }
                }
            }
        }

        public Behavior() {
            this.f15026h = new a();
            this.f15023e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i2) {
            this.f15024f = new WeakReference<>(bottomAppBar);
            View viewE = bottomAppBar.e();
            if (viewE != null && !ViewCompat.isLaidOut(viewE)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) viewE.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.f15025g = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (viewE instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) viewE;
                    floatingActionButton.addOnLayoutChangeListener(this.f15026h);
                    bottomAppBar.a(floatingActionButton);
                }
                bottomAppBar.h();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i2);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f15026h = new a();
            this.f15023e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i2, int i3) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f15028s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        boolean f15029t;

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
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f15028s);
            parcel.writeInt(this.f15029t ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f15028s = parcel.readInt();
            this.f15029t = parcel.readInt() != 0;
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.F) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.a(bottomAppBar.f15019w, BottomAppBar.this.G);
        }
    }

    class b implements k<FloatingActionButton> {
        b() {
        }

        @Override // com.google.android.material.a.k
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            BottomAppBar.this.f15016t.c(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // com.google.android.material.a.k
        public void b(@NonNull FloatingActionButton floatingActionButton) {
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().g() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().f(translationX);
                BottomAppBar.this.f15016t.invalidateSelf();
            }
            float fMax = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().b() != fMax) {
                BottomAppBar.this.getTopEdgeTreatment().a(fMax);
                BottomAppBar.this.f15016t.invalidateSelf();
            }
            BottomAppBar.this.f15016t.c(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    class c implements s.e {
        c() {
        }

        @Override // com.google.android.material.internal.s.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull s.f fVar) {
            boolean z2;
            if (BottomAppBar.this.f15022z) {
                BottomAppBar.this.I = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            if (BottomAppBar.this.A) {
                z2 = BottomAppBar.this.K != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.this.K = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z2 = false;
            }
            if (BottomAppBar.this.B) {
                z = BottomAppBar.this.J != windowInsetsCompat.getSystemWindowInsetRight();
                BottomAppBar.this.J = windowInsetsCompat.getSystemWindowInsetRight();
            }
            if (z2 || z) {
                BottomAppBar.this.a();
                BottomAppBar.this.h();
                BottomAppBar.this.g();
            }
            return windowInsetsCompat;
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.b();
            BottomAppBar.this.f15017u = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.c();
        }
    }

    class e extends FloatingActionButton.b {
        final /* synthetic */ int a;

        class a extends FloatingActionButton.b {
            a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.b();
            }
        }

        e(int i2) {
            this.a = i2;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.c(this.a));
            floatingActionButton.b(new a());
        }
    }

    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.b();
            BottomAppBar.this.F = false;
            BottomAppBar.this.f15018v = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.c();
        }
    }

    class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f15033s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f15034t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ int f15035u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ boolean f15036v;

        g(ActionMenuView actionMenuView, int i2, boolean z2) {
            this.f15034t = actionMenuView;
            this.f15035u = i2;
            this.f15036v = z2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f15033s = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f15033s) {
                return;
            }
            boolean z2 = BottomAppBar.this.E != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.a(bottomAppBar.E);
            BottomAppBar.this.a(this.f15034t, this.f15035u, this.f15036v, z2);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ActionMenuView f15038s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f15039t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ boolean f15040u;

        h(ActionMenuView actionMenuView, int i2, boolean z2) {
            this.f15038s = actionMenuView;
            this.f15039t = i2;
            this.f15040u = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15038s.setTranslationX(BottomAppBar.this.a(r0, this.f15039t, this.f15040u));
        }
    }

    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.L.onAnimationStart(animator);
            FloatingActionButton floatingActionButtonD = BottomAppBar.this.d();
            if (floatingActionButtonD != null) {
                floatingActionButtonD.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    interface j {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomAppBarStyle);
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return c(this.f15019w);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public com.google.android.material.bottomappbar.a getTopEdgeTreatment() {
        return (com.google.android.material.bottomappbar.a) this.f15016t.l().h();
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.f15016t.o();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().b();
    }

    public int getFabAlignmentMode() {
        return this.f15019w;
    }

    public int getFabAnimationMode() {
        return this.f15020x;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().d();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().e();
    }

    public boolean getHideOnScroll() {
        return this.f15021y;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.h.a(this, this.f15016t);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            a();
            h();
        }
        g();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f15019w = savedState.f15028s;
        this.G = savedState.f15029t;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15028s = this.f15019w;
        savedState.f15029t = this.G;
        return savedState;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.f15016t, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().a(f2);
            this.f15016t.invalidateSelf();
            h();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        this.f15016t.b(f2);
        getBehavior().a(this, this.f15016t.k() - this.f15016t.j());
    }

    public void setFabAlignmentMode(int i2) {
        a(i2, 0);
    }

    public void setFabAnimationMode(int i2) {
        this.f15020x = i2;
    }

    void setFabCornerSize(@Dimension float f2) {
        if (f2 != getTopEdgeTreatment().c()) {
            getTopEdgeTreatment().b(f2);
            this.f15016t.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@Dimension float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().c(f2);
            this.f15016t.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().d(f2);
            this.f15016t.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z2) {
        this.f15021y = z2;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, N), attributeSet, i2);
        this.f15016t = new MaterialShapeDrawable();
        this.C = 0;
        this.E = 0;
        this.F = false;
        this.G = true;
        this.L = new a();
        this.M = new b();
        Context context2 = getContext();
        TypedArray typedArrayC = l.c(context2, attributeSet, R$styleable.BottomAppBar, i2, N, new int[0]);
        ColorStateList colorStateListA = com.google.android.material.i.c.a(context2, typedArrayC, R$styleable.BottomAppBar_backgroundTint);
        int dimensionPixelSize = typedArrayC.getDimensionPixelSize(R$styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = typedArrayC.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayC.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayC.getDimensionPixelOffset(R$styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.f15019w = typedArrayC.getInt(R$styleable.BottomAppBar_fabAlignmentMode, 0);
        this.f15020x = typedArrayC.getInt(R$styleable.BottomAppBar_fabAnimationMode, 0);
        this.f15021y = typedArrayC.getBoolean(R$styleable.BottomAppBar_hideOnScroll, false);
        this.f15022z = typedArrayC.getBoolean(R$styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.A = typedArrayC.getBoolean(R$styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.B = typedArrayC.getBoolean(R$styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        typedArrayC.recycle();
        this.f15015s = getResources().getDimensionPixelOffset(R$dimen.mtrl_bottomappbar_fabOffsetEndMode);
        com.google.android.material.bottomappbar.a aVar = new com.google.android.material.bottomappbar.a(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        l.b bVarN = com.google.android.material.shape.l.n();
        bVarN.b(aVar);
        this.f15016t.setShapeAppearanceModel(bVarN.a());
        this.f15016t.d(2);
        this.f15016t.a(Paint.Style.FILL);
        this.f15016t.a(context2);
        setElevation(dimensionPixelSize);
        DrawableCompat.setTintList(this.f15016t, colorStateListA);
        ViewCompat.setBackground(this, this.f15016t);
        s.a(this, attributeSet, i2, N, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public View e() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    private boolean f() {
        FloatingActionButton floatingActionButtonD = d();
        return floatingActionButtonD != null && floatingActionButtonD.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f15018v != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (f()) {
            b(actionMenuView, this.f15019w, this.G);
        } else {
            b(actionMenuView, 0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        getTopEdgeTreatment().f(getFabTranslationX());
        View viewE = e();
        this.f15016t.c((this.G && f()) ? 1.0f : 0.0f);
        if (viewE != null) {
            viewE.setTranslationY(getFabTranslationY());
            viewE.setTranslationX(getFabTranslationX());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.H == null) {
            this.H = new Behavior();
        }
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ArrayList<j> arrayList;
        int i2 = this.C;
        this.C = i2 + 1;
        if (i2 != 0 || (arrayList = this.D) == null) {
            return;
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    private void d(int i2) {
        if (this.f15019w == i2 || !ViewCompat.isLaidOut(this)) {
            return;
        }
        Animator animator = this.f15017u;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f15020x == 1) {
            b(i2, arrayList);
        } else {
            a(i2, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f15017u = animatorSet;
        this.f15017u.addListener(new d());
        this.f15017u.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ArrayList<j> arrayList;
        int i2 = this.C - 1;
        this.C = i2;
        if (i2 != 0 || (arrayList = this.D) == null) {
            return;
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float c(int i2) {
        boolean zE = s.e(this);
        if (i2 == 1) {
            return ((getMeasuredWidth() / 2) - (this.f15015s + (zE ? this.K : this.J))) * (zE ? -1 : 1);
        }
        return 0.0f;
    }

    boolean b(@Px int i2) {
        float f2 = i2;
        if (f2 == getTopEdgeTreatment().f()) {
            return false;
        }
        getTopEdgeTreatment().e(f2);
        this.f15016t.invalidateSelf();
        return true;
    }

    public void a(int i2, @MenuRes int i3) {
        this.E = i3;
        this.F = true;
        a(i2, this.G);
        d(i2);
        this.f15019w = i2;
    }

    private void b(int i2, @NonNull List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(d(), "translationX", c(i2));
        objectAnimatorOfFloat.setDuration(300L);
        list.add(objectAnimatorOfFloat);
    }

    private void b(@NonNull ActionMenuView actionMenuView, int i2, boolean z2) {
        a(actionMenuView, i2, z2, false);
    }

    public void a(@MenuRes int i2) {
        if (i2 != 0) {
            this.E = 0;
            getMenu().clear();
            inflateMenu(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public FloatingActionButton d() {
        View viewE = e();
        if (viewE instanceof FloatingActionButton) {
            return (FloatingActionButton) viewE;
        }
        return null;
    }

    protected void a(int i2, List<Animator> list) {
        FloatingActionButton floatingActionButtonD = d();
        if (floatingActionButtonD == null || floatingActionButtonD.c()) {
            return;
        }
        c();
        floatingActionButtonD.a(new e(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, boolean z2) {
        if (!ViewCompat.isLaidOut(this)) {
            this.F = false;
            a(this.E);
            return;
        }
        Animator animator = this.f15018v;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!f()) {
            i2 = 0;
            z2 = false;
        }
        a(i2, z2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f15018v = animatorSet;
        this.f15018v.addListener(new f());
        this.f15018v.start();
    }

    private void a(int i2, boolean z2, @NonNull List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - a(actionMenuView, i2, z2)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.addListener(new g(actionMenuView, i2, z2));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull ActionMenuView actionMenuView, int i2, boolean z2, boolean z3) {
        h hVar = new h(actionMenuView, i2, z2);
        if (z3) {
            actionMenuView.post(hVar);
        } else {
            hVar.run();
        }
    }

    protected int a(@NonNull ActionMenuView actionMenuView, int i2, boolean z2) {
        if (i2 != 1 || !z2) {
            return 0;
        }
        boolean zE = s.e(this);
        int measuredWidth = zE ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                if (zE) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        return measuredWidth - ((zE ? actionMenuView.getRight() : actionMenuView.getLeft()) + (zE ? this.J : -this.K));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Animator animator = this.f15018v;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f15017u;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.a(this.L);
        floatingActionButton.b(new i());
        floatingActionButton.a(this.M);
    }
}
