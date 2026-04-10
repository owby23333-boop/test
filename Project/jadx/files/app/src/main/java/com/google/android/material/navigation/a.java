package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: compiled from: NavigationBarItemView.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class a extends FrameLayout implements MenuView.ItemView {
    private static final int[] I = {R.attr.state_checked};
    private final TextView A;
    private final TextView B;
    private int C;

    @Nullable
    private MenuItemImpl D;

    @Nullable
    private ColorStateList E;

    @Nullable
    private Drawable F;

    @Nullable
    private Drawable G;

    @Nullable
    private BadgeDrawable H;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f15597s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f15598t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private float f15599u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private float f15600v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f15601w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f15602x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ImageView f15603y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final ViewGroup f15604z;

    /* JADX INFO: renamed from: com.google.android.material.navigation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NavigationBarItemView.java */
    class ViewOnLayoutChangeListenerC0329a implements View.OnLayoutChangeListener {
        ViewOnLayoutChangeListenerC0329a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (a.this.f15603y.getVisibility() == 0) {
                a aVar = a.this;
                aVar.d(aVar.f15603y);
            }
        }
    }

    public a(@NonNull Context context) {
        super(context);
        this.C = -1;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f15603y = (ImageView) findViewById(R$id.navigation_bar_item_icon_view);
        this.f15604z = (ViewGroup) findViewById(R$id.navigation_bar_item_labels_group);
        this.A = (TextView) findViewById(R$id.navigation_bar_item_small_label_view);
        this.B = (TextView) findViewById(R$id.navigation_bar_item_large_label_view);
        setBackgroundResource(getItemBackgroundResId());
        this.f15597s = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        ViewGroup viewGroup = this.f15604z;
        viewGroup.setTag(R$id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        ViewCompat.setImportantForAccessibility(this.A, 2);
        ViewCompat.setImportantForAccessibility(this.B, 2);
        setFocusable(true);
        a(this.A.getTextSize(), this.B.getTextSize());
        ImageView imageView = this.f15603y;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0329a());
        }
    }

    private boolean b() {
        return this.H != null;
    }

    private void c(@Nullable View view) {
        if (b()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.a.a(this.H, view);
            }
            this.H = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        if (b()) {
            com.google.android.material.badge.a.b(this.H, view, a(view));
        }
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i2 = 0;
        for (int i3 = 0; i3 < iIndexOfChild; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof a) && childAt.getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    private int getSuggestedIconHeight() {
        BadgeDrawable badgeDrawable = this.H;
        int minimumHeight = badgeDrawable != null ? badgeDrawable.getMinimumHeight() / 2 : 0;
        return Math.max(minimumHeight, ((FrameLayout.LayoutParams) this.f15603y.getLayoutParams()).topMargin) + this.f15603y.getMeasuredWidth() + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.H;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.H.d();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15603y.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f15603y.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.H;
    }

    @DrawableRes
    protected int getItemBackgroundResId() {
        return R$drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public MenuItemImpl getItemData() {
        return this.D;
    }

    @DimenRes
    protected int getItemDefaultMarginResId() {
        return R$dimen.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.C;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15604z.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.f15604z.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15604z.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f15604z.getMeasuredWidth() + layoutParams.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i2) {
        this.D = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        CharSequence tooltipText = !TextUtils.isEmpty(menuItemImpl.getTooltipText()) ? menuItemImpl.getTooltipText() : menuItemImpl.getTitle();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21 || i3 > 23) {
            TooltipCompat.setTooltipText(this, tooltipText);
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.D;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.D.isChecked()) {
            FrameLayout.mergeDrawableStates(iArrOnCreateDrawableState, I);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.H;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.D.getTitle();
            if (!TextUtils.isEmpty(this.D.getContentDescription())) {
                title = this.D.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.H.b()));
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatWrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        accessibilityNodeInfoCompatWrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            accessibilityNodeInfoCompatWrap.setClickable(false);
            accessibilityNodeInfoCompatWrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        accessibilityNodeInfoCompatWrap.setRoleDescription(getResources().getString(R$string.item_view_role_description));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        this.H = badgeDrawable;
        ImageView imageView = this.f15603y;
        if (imageView != null) {
            b(imageView);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z2) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z2) {
        this.B.setPivotX(r0.getWidth() / 2);
        this.B.setPivotY(r0.getBaseline());
        this.A.setPivotX(r0.getWidth() / 2);
        this.A.setPivotY(r0.getBaseline());
        int i2 = this.f15601w;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z2) {
                    a(this.f15603y, this.f15597s, 49);
                    ViewGroup viewGroup = this.f15604z;
                    a(viewGroup, ((Integer) viewGroup.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue());
                    this.B.setVisibility(0);
                } else {
                    a(this.f15603y, this.f15597s, 17);
                    a(this.f15604z, 0);
                    this.B.setVisibility(4);
                }
                this.A.setVisibility(4);
            } else if (i2 == 1) {
                ViewGroup viewGroup2 = this.f15604z;
                a(viewGroup2, ((Integer) viewGroup2.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue());
                if (z2) {
                    a(this.f15603y, (int) (this.f15597s + this.f15598t), 49);
                    a(this.B, 1.0f, 1.0f, 0);
                    TextView textView = this.A;
                    float f2 = this.f15599u;
                    a(textView, f2, f2, 4);
                } else {
                    a(this.f15603y, this.f15597s, 49);
                    TextView textView2 = this.B;
                    float f3 = this.f15600v;
                    a(textView2, f3, f3, 4);
                    a(this.A, 1.0f, 1.0f, 0);
                }
            } else if (i2 == 2) {
                a(this.f15603y, this.f15597s, 17);
                this.B.setVisibility(8);
                this.A.setVisibility(8);
            }
        } else if (this.f15602x) {
            if (z2) {
                a(this.f15603y, this.f15597s, 49);
                ViewGroup viewGroup3 = this.f15604z;
                a(viewGroup3, ((Integer) viewGroup3.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue());
                this.B.setVisibility(0);
            } else {
                a(this.f15603y, this.f15597s, 17);
                a(this.f15604z, 0);
                this.B.setVisibility(4);
            }
            this.A.setVisibility(4);
        } else {
            ViewGroup viewGroup4 = this.f15604z;
            a(viewGroup4, ((Integer) viewGroup4.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue());
            if (z2) {
                a(this.f15603y, (int) (this.f15597s + this.f15598t), 49);
                a(this.B, 1.0f, 1.0f, 0);
                TextView textView3 = this.A;
                float f4 = this.f15599u;
                a(textView3, f4, f4, 4);
            } else {
                a(this.f15603y, this.f15597s, 49);
                TextView textView4 = this.B;
                float f5 = this.f15600v;
                a(textView4, f5, f5, 4);
                a(this.A, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z2);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.A.setEnabled(z2);
        this.B.setEnabled(z2);
        this.f15603y.setEnabled(z2);
        if (z2) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.F) {
            return;
        }
        this.F = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.G = drawable;
            ColorStateList colorStateList = this.E;
            if (colorStateList != null) {
                DrawableCompat.setTintList(this.G, colorStateList);
            }
        }
        this.f15603y.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f15603y.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f15603y.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.E = colorStateList;
        if (this.D == null || (drawable = this.G) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, this.E);
        this.G.invalidateSelf();
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemPosition(int i2) {
        this.C = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f15601w != i2) {
            this.f15601w = i2;
            if (this.D != null) {
                setChecked(this.D.isChecked());
            }
        }
    }

    public void setShifting(boolean z2) {
        if (this.f15602x != z2) {
            this.f15602x = z2;
            if (this.D != null) {
                setChecked(this.D.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z2, char c2) {
    }

    public void setTextAppearanceActive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.B, i2);
        a(this.A.getTextSize(), this.B.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.A, i2);
        a(this.A.getTextSize(), this.B.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.A.setTextColor(colorStateList);
            this.B.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.A.setText(charSequence);
        this.B.setText(charSequence);
        MenuItemImpl menuItemImpl = this.D;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.D;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.D.getTooltipText();
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21 || i2 > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    private void b(@Nullable View view) {
        if (b() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.a.a(this.H, view, a(view));
        }
    }

    private static void a(@NonNull View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }

    private static void a(@NonNull View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    private static void a(@NonNull View view, int i2) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i2);
    }

    private void a(float f2, float f3) {
        this.f15598t = f2 - f3;
        this.f15599u = (f3 * 1.0f) / f2;
        this.f15600v = (f2 * 1.0f) / f3;
    }

    void a() {
        c(this.f15603y);
    }

    @Nullable
    private FrameLayout a(View view) {
        ImageView imageView = this.f15603y;
        if (view == imageView && com.google.android.material.badge.a.a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }
}
