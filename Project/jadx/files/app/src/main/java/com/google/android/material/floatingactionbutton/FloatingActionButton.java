package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.a.h;
import com.google.android.material.a.k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.d;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.s;
import com.google.android.material.shape.l;
import com.google.android.material.shape.o;
import com.google.android.material.stateful.ExtendableSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, com.google.android.material.g.a, o, CoordinatorLayout.AttachedBehavior {
    private static final int J = R$style.Widget_Design_FloatingActionButton;
    private int A;
    private int B;
    private int C;
    boolean D;
    final Rect E;
    private final Rect F;

    @NonNull
    private final AppCompatImageHelper G;

    @NonNull
    private final com.google.android.material.g.c H;
    private com.google.android.material.floatingactionbutton.d I;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private ColorStateList f15356t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f15357u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private ColorStateList f15358v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f15359w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private ColorStateList f15360x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f15361y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f15362z;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Size {
    }

    class a implements d.j {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void a() {
            this.a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.d.j
        public void b() {
            this.a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class c implements com.google.android.material.k.b {
        c() {
        }

        @Override // com.google.android.material.k.b
        public boolean a() {
            return FloatingActionButton.this.D;
        }

        @Override // com.google.android.material.k.b
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // com.google.android.material.k.b
        public void setShadowPadding(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.E.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.B, i3 + FloatingActionButton.this.B, i4 + FloatingActionButton.this.B, i5 + FloatingActionButton.this.B);
        }
    }

    class d<T extends FloatingActionButton> implements d.i {

        @NonNull
        private final k<T> a;

        d(@NonNull k<T> kVar) {
            this.a = kVar;
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public void a() {
            this.a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.d.i
        public void b() {
            this.a.a(FloatingActionButton.this);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof d) && ((d) obj).a.equals(this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public FloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private d.j c(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @NonNull
    private com.google.android.material.floatingactionbutton.d f() {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, new c()) : new com.google.android.material.floatingactionbutton.d(this, new c());
    }

    private void g() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f15358v;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f15359w;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    private com.google.android.material.floatingactionbutton.d getImpl() {
        if (this.I == null) {
            this.I = f();
        }
        return this.I;
    }

    public void b(@Nullable b bVar) {
        b(bVar, true);
    }

    public boolean d() {
        return getImpl().k();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    public void e() {
        b((b) null);
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.f15356t;
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f15357u;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().c();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().g();
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().b();
    }

    @Px
    public int getCustomSize() {
        return this.A;
    }

    public int getExpandedComponentIdHint() {
        return this.H.a();
    }

    @Nullable
    public h getHideMotionSpec() {
        return getImpl().e();
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f15360x;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.f15360x;
    }

    @NonNull
    public l getShapeAppearanceModel() {
        return (l) Preconditions.checkNotNull(getImpl().h());
    }

    @Nullable
    public h getShowMotionSpec() {
        return getImpl().i();
    }

    public int getSize() {
        return this.f15362z;
    }

    int getSizeDimension() {
        return a(this.f15362z);
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.TintableBackgroundView
    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.f15358v;
    }

    @Override // androidx.core.widget.TintableImageSourceView
    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f15359w;
    }

    public boolean getUseCompatPadding() {
        return this.D;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().l();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().o();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.B = (sizeDimension - this.C) / 2;
        getImpl().x();
        int iMin = Math.min(a(sizeDimension, i2), a(sizeDimension, i3));
        Rect rect = this.E;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.H.a((Bundle) Preconditions.checkNotNull(extendableSavedState.f15834s.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        extendableSavedState.f15834s.put("expandableWidgetHelper", this.H.c());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && a(this.F) && !this.F.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.f15356t != colorStateList) {
            this.f15356t = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f15357u != mode) {
            this.f15357u = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().a(f2);
    }

    public void setCompatElevationResource(@DimenRes int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().b(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().d(f2);
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i2 != this.A) {
            this.A = i2;
            requestLayout();
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().e(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        if (z2 != getImpl().d()) {
            getImpl().a(z2);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(@IdRes int i2) {
        this.H.a(i2);
    }

    public void setHideMotionSpec(@Nullable h hVar) {
        getImpl().a(hVar);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(h.a(getContext(), i2));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().w();
            if (this.f15358v != null) {
                g();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(@DrawableRes int i2) {
        this.G.setImageResource(i2);
        g();
    }

    public void setRippleColor(@ColorInt int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().q();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().q();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setShadowPaddingEnabled(boolean z2) {
        getImpl().b(z2);
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull l lVar) {
        getImpl().a(lVar);
    }

    public void setShowMotionSpec(@Nullable h hVar) {
        getImpl().b(hVar);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(h.a(getContext(), i2));
    }

    public void setSize(int i2) {
        this.A = 0;
        if (i2 != this.f15362z) {
            this.f15362z = i2;
            requestLayout();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.f15358v != colorStateList) {
            this.f15358v = colorStateList;
            g();
        }
    }

    @Override // androidx.core.widget.TintableImageSourceView
    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.f15359w != mode) {
            this.f15359w = mode;
            g();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().r();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().r();
    }

    @Override // android.view.View
    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().r();
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.D != z2) {
            this.D = z2;
            getImpl().n();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private Rect a;
        private b b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f15363c;

        public BaseBehavior() {
            this.f15363c = true;
        }

        private boolean b(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.a(this.b, false);
                return true;
            }
            floatingActionButton.b(this.b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!a(view)) {
                return false;
            }
            b(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.f15363c = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        private static boolean a(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            return this.f15363c && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.a(this.b, false);
                return true;
            }
            floatingActionButton.b(this.b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i2) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = dependencies.get(i3);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i2);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.E;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            int i2;
            Rect rect = floatingActionButton.E;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            int i3 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) {
                i2 = rect.right;
            } else {
                i2 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) {
                i3 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) {
                i3 = -rect.top;
            }
            if (i3 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i3);
            }
            if (i2 != 0) {
                ViewCompat.offsetLeftAndRight(floatingActionButton, i2);
            }
        }
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    void b(@Nullable b bVar, boolean z2) {
        getImpl().b(c(bVar), z2);
    }

    public boolean c() {
        return getImpl().j();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f15360x != colorStateList) {
            this.f15360x = colorStateList;
            getImpl().b(this.f15360x);
        }
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, J), attributeSet, i2);
        this.E = new Rect();
        this.F = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayC = com.google.android.material.internal.l.c(context2, attributeSet, R$styleable.FloatingActionButton, i2, J, new int[0]);
        this.f15356t = com.google.android.material.i.c.a(context2, typedArrayC, R$styleable.FloatingActionButton_backgroundTint);
        this.f15357u = s.a(typedArrayC.getInt(R$styleable.FloatingActionButton_backgroundTintMode, -1), (PorterDuff.Mode) null);
        this.f15360x = com.google.android.material.i.c.a(context2, typedArrayC, R$styleable.FloatingActionButton_rippleColor);
        this.f15362z = typedArrayC.getInt(R$styleable.FloatingActionButton_fabSize, -1);
        this.A = typedArrayC.getDimensionPixelSize(R$styleable.FloatingActionButton_fabCustomSize, 0);
        this.f15361y = typedArrayC.getDimensionPixelSize(R$styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayC.getDimension(R$styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayC.getDimension(R$styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayC.getDimension(R$styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.D = typedArrayC.getBoolean(R$styleable.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.mtrl_fab_min_touch_target);
        this.C = typedArrayC.getDimensionPixelSize(R$styleable.FloatingActionButton_maxImageSize, 0);
        h hVarA = h.a(context2, typedArrayC, R$styleable.FloatingActionButton_showMotionSpec);
        h hVarA2 = h.a(context2, typedArrayC, R$styleable.FloatingActionButton_hideMotionSpec);
        l lVarA = l.a(context2, attributeSet, i2, J, l.f15721m).a();
        boolean z2 = typedArrayC.getBoolean(R$styleable.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayC.getBoolean(R$styleable.FloatingActionButton_android_enabled, true));
        typedArrayC.recycle();
        this.G = new AppCompatImageHelper(this);
        this.G.loadFromAttributes(attributeSet, i2);
        this.H = new com.google.android.material.g.c(this);
        getImpl().a(lVarA);
        getImpl().a(this.f15356t, this.f15357u, this.f15360x, this.f15361y);
        getImpl().b(dimensionPixelSize);
        getImpl().a(dimension);
        getImpl().b(dimension2);
        getImpl().d(dimension3);
        getImpl().a(this.C);
        getImpl().b(hVarA);
        getImpl().a(hVarA2);
        getImpl().a(z2);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void c(@NonNull Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.E;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    public void a(@Nullable b bVar) {
        a(bVar, true);
    }

    public void b(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    void a(@Nullable b bVar, boolean z2) {
        getImpl().a(c(bVar), z2);
    }

    public void b() {
        a((b) null);
    }

    public void a(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void b(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    @Override // com.google.android.material.g.b
    public boolean a() {
        return this.H.b();
    }

    private int a(int i2) {
        int i3 = this.A;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(R$dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return a(1);
        }
        return a(0);
    }

    @Deprecated
    public boolean a(@NonNull Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        c(rect);
        return true;
    }

    private static int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    public void a(@NonNull k<? extends FloatingActionButton> kVar) {
        getImpl().a(new d(kVar));
    }
}
