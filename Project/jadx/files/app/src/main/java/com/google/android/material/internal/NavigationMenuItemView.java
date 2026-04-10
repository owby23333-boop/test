package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] I = {R.attr.state_checked};
    boolean A;
    private final CheckedTextView B;
    private FrameLayout C;
    private MenuItemImpl D;
    private ColorStateList E;
    private boolean F;
    private Drawable G;
    private final AccessibilityDelegateCompat H;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f15461y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f15462z;

    class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.A);
        }
    }

    public NavigationMenuItemView(@NonNull Context context) {
        this(context, null);
    }

    private void b() {
        if (d()) {
            this.B.setVisibility(8);
            FrameLayout frameLayout = this.C;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.C.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.B.setVisibility(0);
        FrameLayout frameLayout2 = this.C;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.C.setLayoutParams(layoutParams2);
        }
    }

    @Nullable
    private StateListDrawable c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(I, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean d() {
        return this.D.getTitle() == null && this.D.getIcon() == null && this.D.getActionView() != null;
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.C == null) {
                this.C = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            this.C.removeAllViews();
            this.C.addView(view);
        }
    }

    public void a() {
        FrameLayout frameLayout = this.C;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.B.setCompoundDrawables(null, null, null, null);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.D;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i2) {
        this.D = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, c());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.D;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.D.isChecked()) {
            ViewGroup.mergeDrawableStates(iArrOnCreateDrawableState, I);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.A != z2) {
            this.A = z2;
            this.H.sendAccessibilityEvent(this.B, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.B.setChecked(z2);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.F) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.E);
            }
            int i2 = this.f15461y;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.f15462z) {
            if (this.G == null) {
                this.G = ResourcesCompat.getDrawable(getResources(), R$drawable.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.G;
                if (drawable2 != null) {
                    int i3 = this.f15461y;
                    drawable2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.G;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.B, drawable, null, null, null);
    }

    public void setIconPadding(int i2) {
        this.B.setCompoundDrawablePadding(i2);
    }

    public void setIconSize(@Dimension int i2) {
        this.f15461y = i2;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.E = colorStateList;
        this.F = this.E != null;
        MenuItemImpl menuItemImpl = this.D;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i2) {
        this.B.setMaxLines(i2);
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.f15462z = z2;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z2, char c2) {
    }

    public void setTextAppearance(int i2) {
        TextViewCompat.setTextAppearance(this.B, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.B.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.B.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.H = new a();
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R$dimen.design_navigation_icon_size));
        this.B = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.B.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(this.B, this.H);
    }
}
