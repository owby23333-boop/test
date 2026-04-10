package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int W = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    static final Property<View, Float> f15340a0 = new d(Float.class, "width");

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    static final Property<View, Float> f15341b0 = new e(Float.class, "height");

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    static final Property<View, Float> f15342c0 = new f(Float.class, "paddingStart");

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    static final Property<View, Float> f15343d0 = new g(Float.class, "paddingEnd");
    private int I;
    private final com.google.android.material.floatingactionbutton.a J;

    @NonNull
    private final com.google.android.material.floatingactionbutton.f K;

    @NonNull
    private final com.google.android.material.floatingactionbutton.f L;
    private final com.google.android.material.floatingactionbutton.f M;
    private final com.google.android.material.floatingactionbutton.f N;
    private final int O;
    private int P;
    private int Q;

    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> R;
    private boolean S;
    private boolean T;
    private boolean U;

    @NonNull
    protected ColorStateList V;

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private Rect a;

        @Nullable
        private j b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private j f15344c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f15345d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f15346e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f15345d = false;
            this.f15346e = true;
        }

        private boolean b(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                b(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!a(view)) {
                return false;
            }
            b(view, extendedFloatingActionButton);
            return false;
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f15345d = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f15346e = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        private static boolean a(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        protected void b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.a(this.f15346e ? extendedFloatingActionButton.K : extendedFloatingActionButton.N, this.f15346e ? this.f15344c : this.b);
        }

        private boolean a(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f15345d || this.f15346e) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        private boolean a(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                b(extendedFloatingActionButton);
                return true;
            }
            a(extendedFloatingActionButton);
            return true;
        }

        protected void a(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            extendedFloatingActionButton.a(this.f15346e ? extendedFloatingActionButton.L : extendedFloatingActionButton.M, this.f15346e ? this.f15344c : this.b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = dependencies.get(i3);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i2);
            return true;
        }
    }

    class a implements l {
        a() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int a() {
            return ExtendedFloatingActionButton.this.Q;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int b() {
            return ExtendedFloatingActionButton.this.P;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.P + ExtendedFloatingActionButton.this.Q;
        }
    }

    class b implements l {
        b() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int a() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int b() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.l
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f15347s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.floatingactionbutton.f f15348t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ j f15349u;

        c(ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.f fVar, j jVar) {
            this.f15348t = fVar;
            this.f15349u = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f15347s = true;
            this.f15348t.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f15348t.a();
            if (this.f15347s) {
                return;
            }
            this.f15348t.a(this.f15349u);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f15348t.onAnimationStart(animator);
            this.f15347s = false;
        }
    }

    class i extends com.google.android.material.floatingactionbutton.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f15353g;

        public i(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void a(@Nullable j jVar) {
            if (jVar != null) {
                jVar.b(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void b() {
            super.b();
            this.f15353g = true;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void d() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean f() {
            return ExtendedFloatingActionButton.this.b();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int g() {
            return R$animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f15353g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.I = 1;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.I = 0;
            if (this.f15353g) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }
    }

    public static abstract class j {
        public abstract void a(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void b(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void c(ExtendedFloatingActionButton extendedFloatingActionButton);

        public abstract void d(ExtendedFloatingActionButton extendedFloatingActionButton);
    }

    class k extends com.google.android.material.floatingactionbutton.b {
        public k(com.google.android.material.floatingactionbutton.a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void a(@Nullable j jVar) {
            if (jVar != null) {
                jVar.c(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void d() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean f() {
            return ExtendedFloatingActionButton.this.c();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int g() {
            return R$animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.I = 2;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.I = 0;
        }
    }

    interface l {
        int a();

        int b();

        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getWidth();
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.R;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    int getCollapsedSize() {
        int i2 = this.O;
        return i2 < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i2;
    }

    @Nullable
    public com.google.android.material.a.h getExtendMotionSpec() {
        return this.L.e();
    }

    @Nullable
    public com.google.android.material.a.h getHideMotionSpec() {
        return this.N.e();
    }

    @Nullable
    public com.google.android.material.a.h getShowMotionSpec() {
        return this.M.e();
    }

    @Nullable
    public com.google.android.material.a.h getShrinkMotionSpec() {
        return this.K.e();
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.S && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.S = false;
            this.K.d();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z2) {
        this.U = z2;
    }

    public void setExtendMotionSpec(@Nullable com.google.android.material.a.h hVar) {
        this.L.a(hVar);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i2) {
        setExtendMotionSpec(com.google.android.material.a.h.a(getContext(), i2));
    }

    public void setExtended(boolean z2) {
        if (this.S == z2) {
            return;
        }
        com.google.android.material.floatingactionbutton.f fVar = z2 ? this.L : this.K;
        if (fVar.f()) {
            return;
        }
        fVar.d();
    }

    public void setHideMotionSpec(@Nullable com.google.android.material.a.h hVar) {
        this.N.a(hVar);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(com.google.android.material.a.h.a(getContext(), i2));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (!this.S || this.T) {
            return;
        }
        this.P = ViewCompat.getPaddingStart(this);
        this.Q = ViewCompat.getPaddingEnd(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (!this.S || this.T) {
            return;
        }
        this.P = i2;
        this.Q = i4;
    }

    public void setShowMotionSpec(@Nullable com.google.android.material.a.h hVar) {
        this.M.a(hVar);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(com.google.android.material.a.h.a(getContext(), i2));
    }

    public void setShrinkMotionSpec(@Nullable com.google.android.material.a.h hVar) {
        this.K.a(hVar);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i2) {
        setShrinkMotionSpec(com.google.android.material.a.h.a(getContext(), i2));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
        d();
    }

    static class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f2) {
            view.getLayoutParams().width = f2.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }
    }

    static class e extends Property<View, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f2) {
            view.getLayoutParams().height = f2.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, W), attributeSet, i2);
        this.I = 0;
        this.J = new com.google.android.material.floatingactionbutton.a();
        this.M = new k(this.J);
        this.N = new i(this.J);
        this.S = true;
        this.T = false;
        this.U = false;
        Context context2 = getContext();
        this.R = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayC = com.google.android.material.internal.l.c(context2, attributeSet, R$styleable.ExtendedFloatingActionButton, i2, W, new int[0]);
        com.google.android.material.a.h hVarA = com.google.android.material.a.h.a(context2, typedArrayC, R$styleable.ExtendedFloatingActionButton_showMotionSpec);
        com.google.android.material.a.h hVarA2 = com.google.android.material.a.h.a(context2, typedArrayC, R$styleable.ExtendedFloatingActionButton_hideMotionSpec);
        com.google.android.material.a.h hVarA3 = com.google.android.material.a.h.a(context2, typedArrayC, R$styleable.ExtendedFloatingActionButton_extendMotionSpec);
        com.google.android.material.a.h hVarA4 = com.google.android.material.a.h.a(context2, typedArrayC, R$styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.O = typedArrayC.getDimensionPixelSize(R$styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.P = ViewCompat.getPaddingStart(this);
        this.Q = ViewCompat.getPaddingEnd(this);
        com.google.android.material.floatingactionbutton.a aVar = new com.google.android.material.floatingactionbutton.a();
        this.L = new h(aVar, new a(), true);
        this.K = new h(aVar, new b(), false);
        this.M.a(hVarA);
        this.N.a(hVarA2);
        this.L.a(hVarA3);
        this.K.a(hVarA4);
        typedArrayC.recycle();
        setShapeAppearanceModel(com.google.android.material.shape.l.a(context2, attributeSet, i2, W, com.google.android.material.shape.l.f15721m).a());
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        return getVisibility() != 0 ? this.I == 2 : this.I != 1;
    }

    private void d() {
        this.V = getTextColors();
    }

    private boolean e() {
        return (ViewCompat.isLaidOut(this) || (!c() && this.U)) && !isInEditMode();
    }

    class h extends com.google.android.material.floatingactionbutton.b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final l f15350g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f15351h;

        h(com.google.android.material.floatingactionbutton.a aVar, l lVar, boolean z2) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f15350g = lVar;
            this.f15351h = z2;
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void a(@Nullable j jVar) {
            if (jVar == null) {
                return;
            }
            if (this.f15351h) {
                jVar.a(ExtendedFloatingActionButton.this);
            } else {
                jVar.d(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        @NonNull
        public AnimatorSet c() {
            com.google.android.material.a.h hVarI = i();
            if (hVarI.c("width")) {
                PropertyValuesHolder[] propertyValuesHolderArrA = hVarI.a("width");
                propertyValuesHolderArrA[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.f15350g.getWidth());
                hVarI.a("width", propertyValuesHolderArrA);
            }
            if (hVarI.c("height")) {
                PropertyValuesHolder[] propertyValuesHolderArrA2 = hVarI.a("height");
                propertyValuesHolderArrA2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.f15350g.getHeight());
                hVarI.a("height", propertyValuesHolderArrA2);
            }
            if (hVarI.c("paddingStart")) {
                PropertyValuesHolder[] propertyValuesHolderArrA3 = hVarI.a("paddingStart");
                propertyValuesHolderArrA3[0].setFloatValues(ViewCompat.getPaddingStart(ExtendedFloatingActionButton.this), this.f15350g.b());
                hVarI.a("paddingStart", propertyValuesHolderArrA3);
            }
            if (hVarI.c("paddingEnd")) {
                PropertyValuesHolder[] propertyValuesHolderArrA4 = hVarI.a("paddingEnd");
                propertyValuesHolderArrA4[0].setFloatValues(ViewCompat.getPaddingEnd(ExtendedFloatingActionButton.this), this.f15350g.a());
                hVarI.a("paddingEnd", propertyValuesHolderArrA4);
            }
            if (hVarI.c("labelOpacity")) {
                PropertyValuesHolder[] propertyValuesHolderArrA5 = hVarI.a("labelOpacity");
                propertyValuesHolderArrA5[0].setFloatValues(this.f15351h ? 0.0f : 1.0f, this.f15351h ? 1.0f : 0.0f);
                hVarI.a("labelOpacity", propertyValuesHolderArrA5);
            }
            return super.b(hVarI);
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public void d() {
            ExtendedFloatingActionButton.this.S = this.f15351h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f15350g.getLayoutParams().width;
            layoutParams.height = this.f15350g.getLayoutParams().height;
            ViewCompat.setPaddingRelative(ExtendedFloatingActionButton.this, this.f15350g.b(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f15350g.a(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public boolean f() {
            return this.f15351h == ExtendedFloatingActionButton.this.S || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        @Override // com.google.android.material.floatingactionbutton.f
        public int g() {
            return this.f15351h ? R$animator.mtrl_extended_fab_change_size_expand_motion_spec : R$animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.S = this.f15351h;
            ExtendedFloatingActionButton.this.T = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        @Override // com.google.android.material.floatingactionbutton.b, com.google.android.material.floatingactionbutton.f
        public void a() {
            super.a();
            ExtendedFloatingActionButton.this.T = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.f15350g.getLayoutParams().width;
            layoutParams.height = this.f15350g.getLayoutParams().height;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        return getVisibility() == 0 ? this.I == 1 : this.I != 2;
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        d();
    }

    static class f extends Property<View, Float> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f2) {
            ViewCompat.setPaddingRelative(view, f2.intValue(), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingStart(view));
        }
    }

    static class g extends Property<View, Float> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull View view, @NonNull Float f2) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), f2.intValue(), view.getPaddingBottom());
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(@NonNull View view) {
            return Float.valueOf(ViewCompat.getPaddingEnd(view));
        }
    }

    protected void a(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.google.android.material.floatingactionbutton.f fVar, @Nullable j jVar) {
        if (fVar.f()) {
            return;
        }
        if (!e()) {
            fVar.d();
            fVar.a(jVar);
            return;
        }
        measure(0, 0);
        AnimatorSet animatorSetC = fVar.c();
        animatorSetC.addListener(new c(this, fVar, jVar));
        Iterator<Animator.AnimatorListener> it = fVar.h().iterator();
        while (it.hasNext()) {
            animatorSetC.addListener(it.next());
        }
        animatorSetC.start();
    }
}
