package com.google.android.material.chip;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.AnimatorRes;
import androidx.annotation.BoolRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.a.h;
import com.google.android.material.chip.a;
import com.google.android.material.i.d;
import com.google.android.material.i.f;
import com.google.android.material.internal.s;
import com.google.android.material.shape.l;
import com.google.android.material.shape.o;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0320a, o {
    private static final int I = R$style.Widget_MaterialComponents_Chip_Action;
    private static final Rect J = new Rect();
    private static final int[] K = {R.attr.state_selected};
    private static final int[] L = {R.attr.state_checkable};
    private boolean A;
    private boolean B;
    private int C;

    @Dimension(unit = 1)
    private int D;

    @NonNull
    private final c E;
    private final Rect F;
    private final RectF G;
    private final f H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private com.google.android.material.chip.a f15168s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private InsetDrawable f15169t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private RippleDrawable f15170u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private View.OnClickListener f15171v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private CompoundButton.OnCheckedChangeListener f15172w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f15173x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f15174y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f15175z;

    class a extends f {
        a() {
        }

        @Override // com.google.android.material.i.f
        public void a(int i2) {
        }

        @Override // com.google.android.material.i.f
        public void a(@NonNull Typeface typeface, boolean z2) {
            Chip chip = Chip.this;
            chip.setText(chip.f15168s.g0() ? Chip.this.f15168s.X() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, @NonNull Outline outline) {
            if (Chip.this.f15168s != null) {
                Chip.this.f15168s.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    private class c extends ExploreByTouchHelper {
        c(Chip chip) {
            super(chip);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f2, float f3) {
            return (Chip.this.i() && Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 1 : 0;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(@NonNull List<Integer> list) {
            list.add(0);
            if (Chip.this.i() && Chip.this.c() && Chip.this.f15171v != null) {
                list.add(1);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i2, int i3, Bundle bundle) {
            if (i3 != 16) {
                return false;
            }
            if (i2 == 0) {
                return Chip.this.performClick();
            }
            if (i2 == 1) {
                return Chip.this.d();
            }
            return false;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.b());
            accessibilityNodeInfoCompat.setClickable(Chip.this.isClickable());
            if (Chip.this.b() || Chip.this.isClickable()) {
                accessibilityNodeInfoCompat.setClassName(Chip.this.b() ? "android.widget.CompoundButton" : "android.widget.Button");
            } else {
                accessibilityNodeInfoCompat.setClassName("android.view.View");
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.setText(text);
            } else {
                accessibilityNodeInfoCompat.setContentDescription(text);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (i2 != 1) {
                accessibilityNodeInfoCompat.setContentDescription("");
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.J);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                Context context = Chip.this.getContext();
                int i3 = R$string.mtrl_chip_close_icon_content_description;
                Object[] objArr = new Object[1];
                if (TextUtils.isEmpty(text)) {
                    text = "";
                }
                objArr[0] = text;
                accessibilityNodeInfoCompat.setContentDescription(context.getString(i3, objArr).trim());
            }
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onVirtualViewKeyboardFocusChanged(int i2, boolean z2) {
            if (i2 == 1) {
                Chip.this.A = z2;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context) {
        this(context, null);
    }

    @NonNull
    private int[] g() {
        int i2 = 0;
        int i3 = isEnabled() ? 1 : 0;
        if (this.A) {
            i3++;
        }
        if (this.f15175z) {
            i3++;
        }
        if (this.f15174y) {
            i3++;
        }
        if (isChecked()) {
            i3++;
        }
        int[] iArr = new int[i3];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.A) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.f15175z) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.f15174y) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public RectF getCloseIconTouchBounds() {
        this.G.setEmpty();
        if (i() && this.f15171v != null) {
            this.f15168s.a(this.G);
        }
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.F.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.F;
    }

    @Nullable
    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.Y();
        }
        return null;
    }

    private void h() {
        if (getBackgroundDrawable() == this.f15169t && this.f15168s.getCallback() == null) {
            this.f15168s.setCallback(this.f15169t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        com.google.android.material.chip.a aVar = this.f15168s;
        return (aVar == null || aVar.K() == null) ? false : true;
    }

    private void j() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    private void k() {
        if (this.f15169t != null) {
            this.f15169t = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            m();
        }
    }

    private void l() {
        if (i() && c() && this.f15171v != null) {
            ViewCompat.setAccessibilityDelegate(this, this.E);
        } else {
            ViewCompat.setAccessibilityDelegate(this, null);
        }
    }

    private void m() {
        if (com.google.android.material.j.b.a) {
            n();
            return;
        }
        this.f15168s.g(true);
        ViewCompat.setBackground(this, getBackgroundDrawable());
        o();
        h();
    }

    private void n() {
        this.f15170u = new RippleDrawable(com.google.android.material.j.b.b(this.f15168s.V()), getBackgroundDrawable(), null);
        this.f15168s.g(false);
        ViewCompat.setBackground(this, this.f15170u);
        o();
    }

    private void o() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f15168s) == null) {
            return;
        }
        int iC = (int) (aVar.C() + this.f15168s.Z() + this.f15168s.x());
        int iH = (int) (this.f15168s.H() + this.f15168s.a0() + this.f15168s.w());
        if (this.f15169t != null) {
            Rect rect = new Rect();
            this.f15169t.getPadding(rect);
            iH += rect.left;
            iC += rect.right;
        }
        ViewCompat.setPaddingRelative(this, iH, getPaddingTop(), iC, getPaddingBottom());
    }

    private void p() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.b(getContext(), paint, this.H);
        }
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.f15175z != z2) {
            this.f15175z = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.f15174y != z2) {
            this.f15174y = z2;
            refreshDrawableState();
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return a(motionEvent) || this.E.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.E.dispatchKeyEvent(keyEvent) || this.E.getKeyboardFocusedVirtualViewId() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f15168s;
        if ((aVar == null || !aVar.d0()) ? false : this.f15168s.a(g())) {
            invalidate();
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f15169t;
        return insetDrawable == null ? this.f15168s : insetDrawable;
    }

    @Nullable
    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.y();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.z();
        }
        return null;
    }

    @Nullable
    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.A();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return Math.max(0.0f, aVar.B());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f15168s;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.C();
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.D();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.E();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.F();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.G();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.H();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.I();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.J();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Nullable
    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.K();
        }
        return null;
    }

    @Nullable
    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.L();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.M();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.N();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.O();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.Q();
        }
        return null;
    }

    @Override // android.widget.TextView
    @Nullable
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.R();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(@NonNull Rect rect) {
        if (this.E.getKeyboardFocusedVirtualViewId() == 1 || this.E.getAccessibilityFocusedVirtualViewId() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    @Nullable
    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.S();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.T();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.U();
        }
        return 0.0f;
    }

    @Nullable
    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.V();
        }
        return null;
    }

    @NonNull
    public l getShapeAppearanceModel() {
        return this.f15168s.l();
    }

    @Nullable
    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.W();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.Z();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            return aVar.a0();
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.h.a(this, this.f15168s);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, K);
        }
        if (b()) {
            CheckBox.mergeDrawableStates(iArrOnCreateDrawableState, L);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        this.E.onFocusChanged(z2, i2, rect);
    }

    @Override // android.view.View
    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (b() || isClickable()) {
            accessibilityNodeInfo.setClassName(b() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfo.setClassName("android.view.View");
        }
        accessibilityNodeInfo.setCheckable(b());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(chipGroup.a(this), 1, chipGroup.a() ? chipGroup.b(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @Nullable
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(@NonNull MotionEvent motionEvent, int i2) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.C != i2) {
            this.C = i2;
            o();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L39
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L34
            goto L40
        L21:
            boolean r0 = r5.f15174y
            if (r0 == 0) goto L40
            if (r1 != 0) goto L3e
            r5.setCloseIconPressed(r2)
            goto L3e
        L2b:
            boolean r0 = r5.f15174y
            if (r0 == 0) goto L34
            r5.d()
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            r5.setCloseIconPressed(r2)
            goto L41
        L39:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r3)
        L3e:
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            if (r0 != 0) goto L49
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L4a
        L49:
            r2 = 1
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f15170u) {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f15170u) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i2) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.b(z2);
        }
    }

    public void setCheckableResource(@BoolRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.e(i2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar == null) {
            this.f15173x = z2;
            return;
        }
        if (aVar.c0()) {
            boolean zIsChecked = isChecked();
            super.setChecked(z2);
            if (zIsChecked == z2 || (onCheckedChangeListener = this.f15172w) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z2);
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.a(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(@BoolRes int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.f(i2);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
    }

    public void setCheckedIconTintResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.g(i2);
        }
    }

    public void setCheckedIconVisible(@BoolRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.h(i2);
        }
    }

    public void setChipBackgroundColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.d(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.f(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.j(i2);
        }
    }

    public void setChipDrawable(@NonNull com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f15168s;
        if (aVar2 != aVar) {
            b(aVar2);
            this.f15168s = aVar;
            this.f15168s.f(false);
            a(this.f15168s);
            a(this.D);
        }
    }

    public void setChipEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.g(f2);
        }
    }

    public void setChipEndPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.k(i2);
        }
    }

    public void setChipIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.b(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(@BoolRes int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(@DrawableRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.l(i2);
        }
    }

    public void setChipIconSize(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.h(f2);
        }
    }

    public void setChipIconSizeResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.m(i2);
        }
    }

    public void setChipIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.e(colorStateList);
        }
    }

    public void setChipIconTintResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.n(i2);
        }
    }

    public void setChipIconVisible(@BoolRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.o(i2);
        }
    }

    public void setChipMinHeight(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.i(f2);
        }
    }

    public void setChipMinHeightResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.p(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.j(f2);
        }
    }

    public void setChipStartPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.q(i2);
        }
    }

    public void setChipStrokeColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.f(colorStateList);
        }
    }

    public void setChipStrokeColorResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.r(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.k(f2);
        }
    }

    public void setChipStrokeWidthResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.s(i2);
        }
    }

    @Deprecated
    public void setChipText(@Nullable CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(@StringRes int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(@Nullable Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.c(drawable);
        }
        l();
    }

    public void setCloseIconContentDescription(@Nullable CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.a(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(@BoolRes int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.l(f2);
        }
    }

    public void setCloseIconEndPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.t(i2);
        }
    }

    public void setCloseIconResource(@DrawableRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.u(i2);
        }
        l();
    }

    public void setCloseIconSize(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.m(f2);
        }
    }

    public void setCloseIconSizeResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.v(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.n(f2);
        }
    }

    public void setCloseIconStartPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.w(i2);
        }
    }

    public void setCloseIconTint(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.g(colorStateList);
        }
    }

    public void setCloseIconTintResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.x(i2);
        }
    }

    public void setCloseIconVisible(@BoolRes int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i4 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.b(f2);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f15168s == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.a(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.B = z2;
        a(this.D);
    }

    @Override // android.widget.TextView
    public void setGravity(int i2) {
        if (i2 != 8388627) {
            return;
        }
        super.setGravity(i2);
    }

    public void setHideMotionSpec(@Nullable h hVar) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.a(hVar);
        }
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.y(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.o(f2);
        }
    }

    public void setIconEndPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.z(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.p(f2);
        }
    }

    public void setIconStartPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.A(i2);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        if (this.f15168s != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i2);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i2);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(@Px int i2) {
        super.setMaxWidth(i2);
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.B(i2);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i2) {
        if (i2 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i2);
    }

    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f15172w = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f15171v = onClickListener;
        l();
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.h(colorStateList);
        }
        if (this.f15168s.b0()) {
            return;
        }
        n();
    }

    public void setRippleColorResource(@ColorRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.C(i2);
            if (this.f15168s.b0()) {
                return;
            }
            n();
        }
    }

    @Override // com.google.android.material.shape.o
    public void setShapeAppearanceModel(@NonNull l lVar) {
        this.f15168s.setShapeAppearanceModel(lVar);
    }

    public void setShowMotionSpec(@Nullable h hVar) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.b(hVar);
        }
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.D(i2);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (!z2) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z2);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f15168s == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(this.f15168s.g0() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.b(charSequence);
        }
    }

    public void setTextAppearance(@Nullable d dVar) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.a(dVar);
        }
        p();
    }

    public void setTextAppearanceResource(@StyleRes int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.q(f2);
        }
    }

    public void setTextEndPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.F(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.r(f2);
        }
    }

    public void setTextStartPaddingResource(@DimenRes int i2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.G(i2);
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipStyle);
    }

    private void b(@Nullable com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.a((a.InterfaceC0320a) null);
        }
    }

    public boolean c() {
        com.google.android.material.chip.a aVar = this.f15168s;
        return aVar != null && aVar.e0();
    }

    @CallSuper
    public boolean d() {
        boolean z2 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f15171v;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        }
        this.E.sendEventForVirtualView(1, 1);
        return z2;
    }

    public boolean e() {
        return this.B;
    }

    public void setCloseIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.e(z2);
        }
        l();
    }

    public Chip(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, I), attributeSet, i2);
        this.F = new Rect();
        this.G = new RectF();
        this.H = new a();
        Context context2 = getContext();
        a(attributeSet);
        com.google.android.material.chip.a aVarA = com.google.android.material.chip.a.a(context2, attributeSet, i2, I);
        a(context2, attributeSet, i2);
        setChipDrawable(aVarA);
        aVarA.b(ViewCompat.getElevation(this));
        TypedArray typedArrayC = com.google.android.material.internal.l.c(context2, attributeSet, R$styleable.Chip, i2, I, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(com.google.android.material.i.c.a(context2, typedArrayC, R$styleable.Chip_android_textColor));
        }
        boolean zHasValue = typedArrayC.hasValue(R$styleable.Chip_shapeAppearance);
        typedArrayC.recycle();
        this.E = new c(this);
        l();
        if (!zHasValue) {
            j();
        }
        setChecked(this.f15173x);
        setText(aVarA.X());
        setEllipsize(aVarA.R());
        p();
        if (!this.f15168s.g0()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        o();
        if (e()) {
            setMinHeight(this.D);
        }
        this.C = ViewCompat.getLayoutDirection(this);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        TypedArray typedArrayC = com.google.android.material.internal.l.c(context, attributeSet, R$styleable.Chip, i2, I, new int[0]);
        this.B = typedArrayC.getBoolean(R$styleable.Chip_ensureMinTouchTargetSize, false);
        this.D = (int) Math.ceil(typedArrayC.getDimension(R$styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil(s.a(getContext(), 48))));
        typedArrayC.recycle();
    }

    public boolean b() {
        com.google.android.material.chip.a aVar = this.f15168s;
        return aVar != null && aVar.c0();
    }

    public void setCheckedIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.c(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.d(z2);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.E(i2);
        }
        p();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        com.google.android.material.chip.a aVar = this.f15168s;
        if (aVar != null) {
            aVar.E(i2);
        }
        p();
    }

    private void a(@Nullable AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background");
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") == null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") == null) {
                if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") == null) {
                    if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") == null) {
                        if (attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) == 1 && attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) == 1) {
                            attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
                            return;
                        }
                        throw new UnsupportedOperationException("Chip does not support multi-line text");
                    }
                    throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
                }
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    private void a(@NonNull com.google.android.material.chip.a aVar) {
        aVar.a(this);
    }

    @Override // com.google.android.material.chip.a.InterfaceC0320a
    public void a() {
        a(this.D);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @SuppressLint({"PrivateApi"})
    private boolean a(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.E)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.E, Integer.MIN_VALUE);
                    return true;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return false;
    }

    public boolean a(@Dimension int i2) {
        this.D = i2;
        if (!e()) {
            if (this.f15169t != null) {
                k();
            } else {
                m();
            }
            return false;
        }
        int iMax = Math.max(0, i2 - this.f15168s.getIntrinsicHeight());
        int iMax2 = Math.max(0, i2 - this.f15168s.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f15169t != null) {
                k();
            } else {
                m();
            }
            return false;
        }
        int i3 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i4 = iMax > 0 ? iMax / 2 : 0;
        if (this.f15169t != null) {
            Rect rect = new Rect();
            this.f15169t.getPadding(rect);
            if (rect.top == i4 && rect.bottom == i4 && rect.left == i3 && rect.right == i3) {
                m();
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i2) {
                setMinHeight(i2);
            }
            if (getMinWidth() != i2) {
                setMinWidth(i2);
            }
        } else {
            setMinHeight(i2);
            setMinWidth(i2);
        }
        a(i3, i4, i3, i4);
        m();
        return true;
    }

    private void a(int i2, int i3, int i4, int i5) {
        this.f15169t = new InsetDrawable((Drawable) this.f15168s, i2, i3, i4, i5);
    }
}
