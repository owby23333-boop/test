package com.google.android.material.navigation;

import android.R;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.j;
import java.util.HashSet;

/* JADX INFO: compiled from: NavigationBarMenuView.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class c extends ViewGroup implements MenuView {
    private static final int[] L = {R.attr.state_checked};
    private static final int[] M = {-16842910};

    @Nullable
    private ColorStateList A;

    @Dimension
    private int B;
    private ColorStateList C;

    @Nullable
    private final ColorStateList D;

    @StyleRes
    private int E;

    @StyleRes
    private int F;
    private Drawable G;
    private int H;

    @NonNull
    private SparseArray<BadgeDrawable> I;
    private NavigationBarPresenter J;
    private MenuBuilder K;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final TransitionSet f15606s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private final View.OnClickListener f15607t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Pools.Pool<com.google.android.material.navigation.a> f15608u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    private final SparseArray<View.OnTouchListener> f15609v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f15610w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    private com.google.android.material.navigation.a[] f15611x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f15612y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f15613z;

    /* JADX INFO: compiled from: NavigationBarMenuView.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItemImpl itemData = ((com.google.android.material.navigation.a) view).getItemData();
            if (c.this.K.performItemAction(itemData, c.this.J, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public c(@NonNull Context context) {
        super(context);
        this.f15608u = new Pools.SynchronizedPool(5);
        this.f15609v = new SparseArray<>(5);
        this.f15612y = 0;
        this.f15613z = 0;
        this.I = new SparseArray<>(5);
        this.D = a(R.attr.textColorSecondary);
        this.f15606s = new AutoTransition();
        this.f15606s.setOrdering(0);
        this.f15606s.setDuration(115L);
        this.f15606s.setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator());
        this.f15606s.addTransition(new j());
        this.f15607t = new a();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private void c() {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            hashSet.add(Integer.valueOf(this.K.getItem(i2).getItemId()));
        }
        for (int i3 = 0; i3 < this.I.size(); i3++) {
            int iKeyAt = this.I.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                this.I.delete(iKeyAt);
            }
        }
    }

    private boolean c(int i2) {
        return i2 != -1;
    }

    private com.google.android.material.navigation.a getNewItem() {
        com.google.android.material.navigation.a aVarAcquire = this.f15608u.acquire();
        return aVarAcquire == null ? a(getContext()) : aVarAcquire;
    }

    private void setBadgeIfNeeded(@NonNull com.google.android.material.navigation.a aVar) {
        BadgeDrawable badgeDrawable;
        int id = aVar.getId();
        if (c(id) && (badgeDrawable = this.I.get(id)) != null) {
            aVar.setBadge(badgeDrawable);
        }
    }

    @NonNull
    protected abstract com.google.android.material.navigation.a a(@NonNull Context context);

    protected boolean a(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.I;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.A;
    }

    @Nullable
    public Drawable getItemBackground() {
        com.google.android.material.navigation.a[] aVarArr = this.f15611x;
        return (aVarArr == null || aVarArr.length <= 0) ? this.G : aVarArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.H;
    }

    @Dimension
    public int getItemIconSize() {
        return this.B;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.F;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.E;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.C;
    }

    public int getLabelVisibilityMode() {
        return this.f15610w;
    }

    @Nullable
    protected MenuBuilder getMenu() {
        return this.K;
    }

    public int getSelectedItemId() {
        return this.f15612y;
    }

    protected int getSelectedItemPosition() {
        return this.f15613z;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder menuBuilder) {
        this.K = menuBuilder;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.K.getVisibleItems().size(), false, 1));
    }

    void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.I = sparseArray;
        com.google.android.material.navigation.a[] aVarArr = this.f15611x;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setBadge(sparseArray.get(aVar.getId()));
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.A = colorStateList;
        com.google.android.material.navigation.a[] aVarArr = this.f15611x;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.G = drawable;
        com.google.android.material.navigation.a[] aVarArr = this.f15611x;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.H = i2;
        com.google.android.material.navigation.a[] aVarArr = this.f15611x;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemBackground(i2);
            }
        }
    }

    public void setItemIconSize(@Dimension int i2) {
        this.B = i2;
        com.google.android.material.navigation.a[] aVarArr = this.f15611x;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.F = i2;
        com.google.android.material.navigation.a[] aVarArr = this.f15611x;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.C;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.E = i2;
        com.google.android.material.navigation.a[] aVarArr = this.f15611x;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.C;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.C = colorStateList;
        com.google.android.material.navigation.a[] aVarArr = this.f15611x;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.f15610w = i2;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.J = navigationBarPresenter;
    }

    @Nullable
    public ColorStateList a(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{M, L, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(M, defaultColor), i3, defaultColor});
    }

    public void b() {
        MenuBuilder menuBuilder = this.K;
        if (menuBuilder == null || this.f15611x == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.f15611x.length) {
            a();
            return;
        }
        int i2 = this.f15612y;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.K.getItem(i3);
            if (item.isChecked()) {
                this.f15612y = item.getItemId();
                this.f15613z = i3;
            }
        }
        if (i2 != this.f15612y) {
            TransitionManager.beginDelayedTransition(this, this.f15606s);
        }
        boolean zA = a(this.f15610w, this.K.getVisibleItems().size());
        for (int i4 = 0; i4 < size; i4++) {
            this.J.a(true);
            this.f15611x[i4].setLabelVisibilityMode(this.f15610w);
            this.f15611x[i4].setShifting(zA);
            this.f15611x[i4].initialize((MenuItemImpl) this.K.getItem(i4), 0);
            this.J.a(false);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a() {
        removeAllViews();
        com.google.android.material.navigation.a[] aVarArr = this.f15611x;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                if (aVar != null) {
                    this.f15608u.release(aVar);
                    aVar.a();
                }
            }
        }
        if (this.K.size() == 0) {
            this.f15612y = 0;
            this.f15613z = 0;
            this.f15611x = null;
            return;
        }
        c();
        this.f15611x = new com.google.android.material.navigation.a[this.K.size()];
        boolean zA = a(this.f15610w, this.K.getVisibleItems().size());
        for (int i2 = 0; i2 < this.K.size(); i2++) {
            this.J.a(true);
            this.K.getItem(i2).setCheckable(true);
            this.J.a(false);
            com.google.android.material.navigation.a newItem = getNewItem();
            this.f15611x[i2] = newItem;
            newItem.setIconTintList(this.A);
            newItem.setIconSize(this.B);
            newItem.setTextColor(this.D);
            newItem.setTextAppearanceInactive(this.E);
            newItem.setTextAppearanceActive(this.F);
            newItem.setTextColor(this.C);
            Drawable drawable = this.G;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.H);
            }
            newItem.setShifting(zA);
            newItem.setLabelVisibilityMode(this.f15610w);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.K.getItem(i2);
            newItem.initialize(menuItemImpl, 0);
            newItem.setItemPosition(i2);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.f15609v.get(itemId));
            newItem.setOnClickListener(this.f15607t);
            int i3 = this.f15612y;
            if (i3 != 0 && itemId == i3) {
                this.f15613z = i2;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        this.f15613z = Math.min(this.K.size() - 1, this.f15613z);
        this.K.getItem(this.f15613z).setChecked(true);
    }

    void b(int i2) {
        int size = this.K.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.K.getItem(i3);
            if (i2 == item.getItemId()) {
                this.f15612y = i2;
                this.f15613z = i3;
                item.setChecked(true);
                return;
            }
        }
    }
}
