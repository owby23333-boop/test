package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;

/* JADX INFO: compiled from: NavigationMenuPresenter.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class f implements MenuPresenter {
    boolean A;
    ColorStateList B;
    ColorStateList C;
    Drawable D;
    int E;
    int F;
    int G;
    boolean H;
    private int J;
    private int K;
    int L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private NavigationMenuView f15519s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    LinearLayout f15520t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private MenuPresenter.Callback f15521u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    MenuBuilder f15522v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f15523w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    c f15524x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    LayoutInflater f15525y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    int f15526z;
    boolean I = true;
    private int M = -1;
    final View.OnClickListener N = new a();

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z2 = true;
            f.this.b(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            f fVar = f.this;
            boolean zPerformItemAction = fVar.f15522v.performItemAction(itemData, fVar, 0);
            if (itemData != null && itemData.isCheckable() && zPerformItemAction) {
                f.this.f15524x.a(itemData);
            } else {
                z2 = false;
            }
            f.this.b(false);
            if (z2) {
                f.this.updateMenuView(false);
            }
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private class c extends RecyclerView.Adapter<l> {
        private final ArrayList<e> a = new ArrayList<>();
        private MenuItemImpl b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f15528c;

        c() {
            d();
        }

        private void d() {
            if (this.f15528c) {
                return;
            }
            this.f15528c = true;
            this.a.clear();
            this.a.add(new d());
            int size = f.this.f15522v.getVisibleItems().size();
            int i2 = -1;
            boolean z2 = false;
            int size2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItemImpl menuItemImpl = f.this.f15522v.getVisibleItems().get(i3);
                if (menuItemImpl.isChecked()) {
                    a(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i3 != 0) {
                            this.a.add(new C0326f(f.this.L, 0));
                        }
                        this.a.add(new g(menuItemImpl));
                        int size3 = this.a.size();
                        int size4 = subMenu.size();
                        boolean z3 = false;
                        for (int i4 = 0; i4 < size4; i4++) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i4);
                            if (menuItemImpl2.isVisible()) {
                                if (!z3 && menuItemImpl2.getIcon() != null) {
                                    z3 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    a(menuItemImpl);
                                }
                                this.a.add(new g(menuItemImpl2));
                            }
                        }
                        if (z3) {
                            a(size3, this.a.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i2) {
                        size2 = this.a.size();
                        boolean z4 = menuItemImpl.getIcon() != null;
                        if (i3 != 0) {
                            size2++;
                            ArrayList<e> arrayList = this.a;
                            int i5 = f.this.L;
                            arrayList.add(new C0326f(i5, i5));
                        }
                        z2 = z4;
                    } else if (!z2 && menuItemImpl.getIcon() != null) {
                        a(size2, this.a.size());
                        z2 = true;
                    }
                    g gVar = new g(menuItemImpl);
                    gVar.b = z2;
                    this.a.add(gVar);
                    i2 = groupId;
                }
            }
            this.f15528c = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull l lVar, int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((TextView) lVar.itemView).setText(((g) this.a.get(i2)).a().getTitle());
                    return;
                } else {
                    if (itemViewType != 2) {
                        return;
                    }
                    C0326f c0326f = (C0326f) this.a.get(i2);
                    lVar.itemView.setPadding(0, c0326f.b(), 0, c0326f.a());
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.setIconTintList(f.this.C);
            f fVar = f.this;
            if (fVar.A) {
                navigationMenuItemView.setTextAppearance(fVar.f15526z);
            }
            ColorStateList colorStateList = f.this.B;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = f.this.D;
            ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            g gVar = (g) this.a.get(i2);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.b);
            navigationMenuItemView.setHorizontalPadding(f.this.E);
            navigationMenuItemView.setIconPadding(f.this.F);
            f fVar2 = f.this;
            if (fVar2.H) {
                navigationMenuItemView.setIconSize(fVar2.G);
            }
            navigationMenuItemView.setMaxLines(f.this.J);
            navigationMenuItemView.initialize(gVar.a(), 0);
        }

        public MenuItemImpl b() {
            return this.b;
        }

        int c() {
            int i2 = f.this.f15520t.getChildCount() == 0 ? 0 : 1;
            for (int i3 = 0; i3 < f.this.f15524x.getItemCount(); i3++) {
                if (f.this.f15524x.getItemViewType(i3) == 0) {
                    i2++;
                }
            }
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            e eVar = this.a.get(i2);
            if (eVar instanceof C0326f) {
                return 2;
            }
            if (eVar instanceof d) {
                return 3;
            }
            if (eVar instanceof g) {
                return ((g) eVar).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        public void update() {
            d();
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        public l onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                f fVar = f.this;
                return new i(fVar.f15525y, viewGroup, fVar.N);
            }
            if (i2 == 1) {
                return new k(f.this.f15525y, viewGroup);
            }
            if (i2 == 2) {
                return new j(f.this.f15525y, viewGroup);
            }
            if (i2 != 3) {
                return null;
            }
            return new b(f.this.f15520t);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.itemView).a();
            }
        }

        private void a(int i2, int i3) {
            while (i2 < i3) {
                ((g) this.a.get(i2)).b = true;
                i2++;
            }
        }

        public void a(@NonNull MenuItemImpl menuItemImpl) {
            if (this.b == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.b;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.b = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        @NonNull
        public Bundle a() {
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.b;
            if (menuItemImpl != null) {
                bundle.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = this.a.get(i2);
                if (eVar instanceof g) {
                    MenuItemImpl menuItemImplA = ((g) eVar).a();
                    View actionView = menuItemImplA != null ? menuItemImplA.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItemImplA.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public void a(@NonNull Bundle bundle) {
            MenuItemImpl menuItemImplA;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl menuItemImplA2;
            int i2 = bundle.getInt("android:menu:checked", 0);
            if (i2 != 0) {
                this.f15528c = true;
                int size = this.a.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    e eVar = this.a.get(i3);
                    if ((eVar instanceof g) && (menuItemImplA2 = ((g) eVar).a()) != null && menuItemImplA2.getItemId() == i2) {
                        a(menuItemImplA2);
                        break;
                    }
                    i3++;
                }
                this.f15528c = false;
                d();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.a.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    e eVar2 = this.a.get(i4);
                    if ((eVar2 instanceof g) && (menuItemImplA = ((g) eVar2).a()) != null && (actionView = menuItemImplA.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(menuItemImplA.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void a(boolean z2) {
            this.f15528c = z2;
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class d implements e {
        d() {
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private interface e {
    }

    /* JADX INFO: renamed from: com.google.android.material.internal.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class C0326f implements e {
        private final int a;
        private final int b;

        public C0326f(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class g implements e {
        private final MenuItemImpl a;
        boolean b;

        g(MenuItemImpl menuItemImpl) {
            this.a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private class h extends RecyclerViewAccessibilityDelegate {
        h(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(f.this.f15524x.c(), 0, false));
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class i extends l {
        public i(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class j extends l {
        public j(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static class k extends l {
        public k(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* JADX INFO: compiled from: NavigationMenuPresenter.java */
    private static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    private void i() {
        int i2 = (this.f15520t.getChildCount() == 0 && this.I) ? this.K : 0;
        NavigationMenuView navigationMenuView = this.f15519s;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    public void b(int i2) {
        this.f15523w = i2;
    }

    @Nullable
    public Drawable c() {
        return this.D;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public int d() {
        return this.E;
    }

    public int e() {
        return this.F;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void f(int i2) {
        this.J = i2;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Nullable
    public ColorStateList g() {
        return this.B;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f15523w;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.f15519s == null) {
            this.f15519s = (NavigationMenuView) this.f15525y.inflate(R$layout.design_navigation_menu, viewGroup, false);
            NavigationMenuView navigationMenuView = this.f15519s;
            navigationMenuView.setAccessibilityDelegateCompat(new h(navigationMenuView));
            if (this.f15524x == null) {
                this.f15524x = new c();
            }
            int i2 = this.M;
            if (i2 != -1) {
                this.f15519s.setOverScrollMode(i2);
            }
            this.f15520t = (LinearLayout) this.f15525y.inflate(R$layout.design_navigation_item_header, (ViewGroup) this.f15519s, false);
            this.f15519s.setAdapter(this.f15524x);
        }
        return this.f15519s;
    }

    @Nullable
    public ColorStateList h() {
        return this.C;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.f15525y = LayoutInflater.from(context);
        this.f15522v = menuBuilder;
        this.L = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z2) {
        MenuPresenter.Callback callback = this.f15521u;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z2);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(ListMenuPresenter.VIEWS_TAG);
            if (sparseParcelableArray != null) {
                this.f15519s.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f15524x.a(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f15520t.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.f15519s != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f15519s.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray(ListMenuPresenter.VIEWS_TAG, sparseArray);
        }
        c cVar = this.f15524x;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.a());
        }
        if (this.f15520t != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.f15520t.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.f15521u = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z2) {
        c cVar = this.f15524x;
        if (cVar != null) {
            cVar.update();
        }
    }

    public void a(@NonNull MenuItemImpl menuItemImpl) {
        this.f15524x.a(menuItemImpl);
    }

    public int b() {
        return this.f15520t.getChildCount();
    }

    public void c(int i2) {
        this.E = i2;
        updateMenuView(false);
    }

    public void d(int i2) {
        this.F = i2;
        updateMenuView(false);
    }

    public void e(@Dimension int i2) {
        if (this.G != i2) {
            this.G = i2;
            this.H = true;
            updateMenuView(false);
        }
    }

    public void g(@StyleRes int i2) {
        this.f15526z = i2;
        this.A = true;
        updateMenuView(false);
    }

    public void h(int i2) {
        this.M = i2;
        NavigationMenuView navigationMenuView = this.f15519s;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    @Nullable
    public MenuItemImpl a() {
        return this.f15524x.b();
    }

    public void b(@Nullable ColorStateList colorStateList) {
        this.B = colorStateList;
        updateMenuView(false);
    }

    public int f() {
        return this.J;
    }

    public View a(@LayoutRes int i2) {
        View viewInflate = this.f15525y.inflate(i2, (ViewGroup) this.f15520t, false);
        a(viewInflate);
        return viewInflate;
    }

    public void b(boolean z2) {
        c cVar = this.f15524x;
        if (cVar != null) {
            cVar.a(z2);
        }
    }

    public void a(@NonNull View view) {
        this.f15520t.addView(view);
        NavigationMenuView navigationMenuView = this.f15519s;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void a(@Nullable ColorStateList colorStateList) {
        this.C = colorStateList;
        updateMenuView(false);
    }

    public void a(@Nullable Drawable drawable) {
        this.D = drawable;
        updateMenuView(false);
    }

    public void a(boolean z2) {
        if (this.I != z2) {
            this.I = z2;
            i();
        }
    }

    public void a(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.K != systemWindowInsetTop) {
            this.K = systemWindowInsetTop;
            i();
        }
        NavigationMenuView navigationMenuView = this.f15519s;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.f15520t, windowInsetsCompat);
    }
}
