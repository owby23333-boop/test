package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.shape.h;
import com.google.android.material.shape.l;
import com.google.android.material.shape.o;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCardView extends CardView implements Checkable, o {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.card.a f15140s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f15141t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f15142u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f15143v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private a f15144w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int[] f15137x = {R.attr.state_checkable};

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int[] f15138y = {R.attr.state_checked};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int[] f15139z = {R$attr.state_dragged};
    private static final int A = R$style.Widget_MaterialComponents_CardView;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z2);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialCardViewStyle);
    }

    private void f() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f15140s.a();
        }
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f15140s.b().getBounds());
        return rectF;
    }

    public boolean d() {
        com.google.android.material.card.a aVar = this.f15140s;
        return aVar != null && aVar.r();
    }

    public boolean e() {
        return this.f15143v;
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f15140s.c();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f15140s.d();
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.f15140s.e();
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.f15140s.f();
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.f15140s.g();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.f15140s.h();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f15140s.p().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f15140s.p().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f15140s.p().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f15140s.p().top;
    }

    @FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d)
    public float getProgress() {
        return this.f15140s.j();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f15140s.i();
    }

    public ColorStateList getRippleColor() {
        return this.f15140s.k();
    }

    @NonNull
    public l getShapeAppearanceModel() {
        return this.f15140s.l();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.f15140s.m();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.f15140s.n();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.f15140s.o();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f15142u;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.a(this, this.f15140s.b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (d()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f15137x);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f15138y);
        }
        if (e()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, f15139z);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(d());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f15140s.a(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f15141t) {
            if (!this.f15140s.q()) {
                this.f15140s.a(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i2) {
        this.f15140s.a(ColorStateList.valueOf(i2));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.f15140s.u();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.f15140s.b(colorStateList);
    }

    public void setCheckable(boolean z2) {
        this.f15140s.b(z2);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (this.f15142u != z2) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f15140s.a(drawable);
    }

    public void setCheckedIconMargin(@Dimension int i2) {
        this.f15140s.a(i2);
    }

    public void setCheckedIconMarginResource(@DimenRes int i2) {
        if (i2 != -1) {
            this.f15140s.a(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        this.f15140s.a(AppCompatResources.getDrawable(getContext(), i2));
    }

    public void setCheckedIconSize(@Dimension int i2) {
        this.f15140s.b(i2);
    }

    public void setCheckedIconSizeResource(@DimenRes int i2) {
        if (i2 != 0) {
            this.f15140s.b(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.f15140s.c(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z2) {
        super.setClickable(z2);
        com.google.android.material.card.a aVar = this.f15140s;
        if (aVar != null) {
            aVar.s();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i2, int i3, int i4, int i5) {
        this.f15140s.a(i2, i3, i4, i5);
    }

    public void setDragged(boolean z2) {
        if (this.f15143v != z2) {
            this.f15143v = z2;
            refreshDrawableState();
            f();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f15140s.v();
    }

    public void setOnCheckedChangeListener(@Nullable a aVar) {
        this.f15144w = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z2) {
        super.setPreventCornerOverlap(z2);
        this.f15140s.v();
        this.f15140s.t();
    }

    public void setProgress(@FloatRange(from = PangleAdapterUtils.CPM_DEFLAUT_VALUE, to = 1.0d) float f2) {
        this.f15140s.b(f2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.f15140s.a(f2);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.f15140s.d(colorStateList);
    }

    public void setRippleColorResource(@ColorRes int i2) {
        this.f15140s.d(AppCompatResources.getColorStateList(getContext(), i2));
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull l lVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(lVar.a(getBoundsAsRectF()));
        }
        this.f15140s.a(lVar);
    }

    public void setStrokeColor(@ColorInt int i2) {
        this.f15140s.e(ColorStateList.valueOf(i2));
    }

    public void setStrokeWidth(@Dimension int i2) {
        this.f15140s.c(i2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z2) {
        super.setUseCompatPadding(z2);
        this.f15140s.v();
        this.f15140s.t();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (d() && isEnabled()) {
            this.f15142u = !this.f15142u;
            refreshDrawableState();
            f();
            a aVar = this.f15144w;
            if (aVar != null) {
                aVar.a(this, this.f15142u);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, A), attributeSet, i2);
        this.f15142u = false;
        this.f15143v = false;
        this.f15141t = true;
        TypedArray typedArrayC = com.google.android.material.internal.l.c(getContext(), attributeSet, R$styleable.MaterialCardView, i2, A, new int[0]);
        this.f15140s = new com.google.android.material.card.a(this, attributeSet, i2, A);
        this.f15140s.a(super.getCardBackgroundColor());
        this.f15140s.a(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        this.f15140s.a(typedArrayC);
        typedArrayC.recycle();
    }

    void a(int i2, int i3, int i4, int i5) {
        super.setContentPadding(i2, i3, i4, i5);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f15140s.a(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f15140s.e(colorStateList);
    }
}
