package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.i.c;
import com.google.android.material.internal.s;
import com.google.android.material.shape.h;
import com.google.android.material.shape.l;
import com.google.android.material.shape.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialButton extends AppCompatButton implements Checkable, o {
    private static final int[] F = {R.attr.state_checkable};
    private static final int[] G = {R.attr.state_checked};
    private static final int H = R$style.Widget_MaterialComponents_Button;

    @Px
    private int A;

    @Px
    private int B;
    private boolean C;
    private boolean D;
    private int E;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.button.a f15098s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private final LinkedHashSet<a> f15099t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private b f15100u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private PorterDuff.Mode f15101v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private ColorStateList f15102w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private Drawable f15103x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Px
    private int f15104y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Px
    private int f15105z;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface IconGravity {
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        boolean f15106s;

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
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@NonNull Parcel parcel) {
            this.f15106s = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f15106s ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                SavedState.class.getClassLoader();
            }
            a(parcel);
        }
    }

    public interface a {
        void a(MaterialButton materialButton, boolean z2);
    }

    interface b {
        void a(MaterialButton materialButton, boolean z2);
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    private void a(int i2, int i3) {
        if (this.f15103x == null || getLayout() == null) {
            return;
        }
        if (!c() && !b()) {
            if (d()) {
                this.f15105z = 0;
                if (this.E == 16) {
                    this.A = 0;
                    a(false);
                    return;
                }
                int intrinsicHeight = this.f15104y;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f15103x.getIntrinsicHeight();
                }
                int textHeight = (((((i3 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.B) - getPaddingBottom()) / 2;
                if (this.A != textHeight) {
                    this.A = textHeight;
                    a(false);
                    return;
                }
                return;
            }
            return;
        }
        this.A = 0;
        int i4 = this.E;
        if (i4 == 1 || i4 == 3) {
            this.f15105z = 0;
            a(false);
            return;
        }
        int intrinsicWidth = this.f15104y;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f15103x.getIntrinsicWidth();
        }
        int textWidth = (((((i2 - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - intrinsicWidth) - this.B) - ViewCompat.getPaddingStart(this)) / 2;
        if (e() != (this.E == 4)) {
            textWidth = -textWidth;
        }
        if (this.f15105z != textWidth) {
            this.f15105z = textWidth;
            a(false);
        }
    }

    private boolean b() {
        int i2 = this.E;
        return i2 == 3 || i2 == 4;
    }

    private boolean c() {
        int i2 = this.E;
        return i2 == 1 || i2 == 2;
    }

    private boolean d() {
        int i2 = this.E;
        return i2 == 16 || i2 == 32;
    }

    private boolean e() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private boolean f() {
        com.google.android.material.button.a aVar = this.f15098s;
        return (aVar == null || aVar.l()) ? false : true;
    }

    private void g() {
        if (c()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.f15103x, null, null, null);
        } else if (b()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.f15103x, null);
        } else if (d()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.f15103x, null, null);
        }
    }

    @NonNull
    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        return Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (f()) {
            return this.f15098s.a();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f15103x;
    }

    public int getIconGravity() {
        return this.E;
    }

    @Px
    public int getIconPadding() {
        return this.B;
    }

    @Px
    public int getIconSize() {
        return this.f15104y;
    }

    public ColorStateList getIconTint() {
        return this.f15102w;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f15101v;
    }

    @Dimension
    public int getInsetBottom() {
        return this.f15098s.b();
    }

    @Dimension
    public int getInsetTop() {
        return this.f15098s.c();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f15098s.f();
        }
        return null;
    }

    @NonNull
    public l getShapeAppearanceModel() {
        if (f()) {
            return this.f15098s.g();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f15098s.h();
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (f()) {
            return this.f15098s.i();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        return f() ? this.f15098s.j() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return f() ? this.f15098s.k() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.C;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            h.a(this, this.f15098s.e());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (a()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, F);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(iArrOnCreateDrawableState, G);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        com.google.android.material.button.a aVar;
        super.onLayout(z2, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.f15098s) == null) {
            return;
        }
        aVar.a(i5 - i3, i4 - i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f15106s);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15106s = this.C;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a(i2, i3);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        a(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        if (f()) {
            this.f15098s.a(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (!f()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
        } else {
            this.f15098s.n();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        setBackgroundDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z2) {
        if (f()) {
            this.f15098s.a(z2);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (a() && isEnabled() && this.C != z2) {
            this.C = z2;
            refreshDrawableState();
            if (this.D) {
                return;
            }
            this.D = true;
            Iterator<a> it = this.f15099t.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.C);
            }
            this.D = false;
        }
    }

    public void setCornerRadius(@Px int i2) {
        if (f()) {
            this.f15098s.b(i2);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i2) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (f()) {
            this.f15098s.e().b(f2);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f15103x != drawable) {
            this.f15103x = drawable;
            a(true);
            a(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.E != i2) {
            this.E = i2;
            a(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i2) {
        if (this.B != i2) {
            this.B = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(@DrawableRes int i2) {
        setIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setIconSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f15104y != i2) {
            this.f15104y = i2;
            a(true);
        }
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f15102w != colorStateList) {
            this.f15102w = colorStateList;
            a(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f15101v != mode) {
            this.f15101v = mode;
            a(false);
        }
    }

    public void setIconTintResource(@ColorRes int i2) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setInsetBottom(@Dimension int i2) {
        this.f15098s.c(i2);
    }

    public void setInsetTop(@Dimension int i2) {
        this.f15098s.d(i2);
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(@Nullable b bVar) {
        this.f15100u = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        b bVar = this.f15100u;
        if (bVar != null) {
            bVar.a(this, z2);
        }
        super.setPressed(z2);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (f()) {
            this.f15098s.a(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        if (f()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull l lVar) {
        if (!f()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f15098s.a(lVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z2) {
        if (f()) {
            this.f15098s.b(z2);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (f()) {
            this.f15098s.b(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        if (f()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setStrokeWidth(@Px int i2) {
        if (f()) {
            this.f15098s.e(i2);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (f()) {
            this.f15098s.c(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (f()) {
            this.f15098s.a(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.C);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonStyle);
    }

    public void b(@NonNull a aVar) {
        this.f15099t.remove(aVar);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, H), attributeSet, i2);
        this.f15099t = new LinkedHashSet<>();
        this.C = false;
        this.D = false;
        Context context2 = getContext();
        TypedArray typedArrayC = com.google.android.material.internal.l.c(context2, attributeSet, R$styleable.MaterialButton, i2, H, new int[0]);
        this.B = typedArrayC.getDimensionPixelSize(R$styleable.MaterialButton_iconPadding, 0);
        this.f15101v = s.a(typedArrayC.getInt(R$styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f15102w = c.a(getContext(), typedArrayC, R$styleable.MaterialButton_iconTint);
        this.f15103x = c.b(getContext(), typedArrayC, R$styleable.MaterialButton_icon);
        this.E = typedArrayC.getInteger(R$styleable.MaterialButton_iconGravity, 1);
        this.f15104y = typedArrayC.getDimensionPixelSize(R$styleable.MaterialButton_iconSize, 0);
        this.f15098s = new com.google.android.material.button.a(this, l.a(context2, attributeSet, i2, H).a());
        this.f15098s.a(typedArrayC);
        typedArrayC.recycle();
        setCompoundDrawablePadding(this.B);
        a(this.f15103x != null);
    }

    private void a(boolean z2) {
        Drawable drawable = this.f15103x;
        if (drawable != null) {
            this.f15103x = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(this.f15103x, this.f15102w);
            PorterDuff.Mode mode = this.f15101v;
            if (mode != null) {
                DrawableCompat.setTintMode(this.f15103x, mode);
            }
            int intrinsicWidth = this.f15104y;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f15103x.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f15104y;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f15103x.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f15103x;
            int i2 = this.f15105z;
            int i3 = this.A;
            drawable2.setBounds(i2, i3, intrinsicWidth + i2, intrinsicHeight + i3);
        }
        if (z2) {
            g();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        boolean z3 = false;
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((c() && drawable3 != this.f15103x) || ((b() && drawable5 != this.f15103x) || (d() && drawable4 != this.f15103x))) {
            z3 = true;
        }
        if (z3) {
            g();
        }
    }

    public void a(@NonNull a aVar) {
        this.f15099t.add(aVar);
    }

    public boolean a() {
        com.google.android.material.button.a aVar = this.f15098s;
        return aVar != null && aVar.m();
    }
}
