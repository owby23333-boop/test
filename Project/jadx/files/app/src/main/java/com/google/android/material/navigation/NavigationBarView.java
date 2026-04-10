package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.l;
import com.google.android.material.internal.s;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.navigation.b f15582s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    private final com.google.android.material.navigation.c f15583t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    private final NavigationBarPresenter f15584u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private ColorStateList f15585v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private MenuInflater f15586w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private d f15587x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private c f15588y;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface LabelVisibility {
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @Nullable
        Bundle f15589s;

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

        private void a(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.f15589s = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f15589s);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? SavedState.class.getClassLoader() : classLoader);
        }
    }

    class a implements MenuBuilder.Callback {
        a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            if (NavigationBarView.this.f15588y == null || menuItem.getItemId() != NavigationBarView.this.getSelectedItemId()) {
                return (NavigationBarView.this.f15587x == null || NavigationBarView.this.f15587x.a(menuItem)) ? false : true;
            }
            NavigationBarView.this.f15588y.a(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    class b implements s.e {
        b(NavigationBarView navigationBarView) {
        }

        @Override // com.google.android.material.internal.s.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull s.f fVar) {
            fVar.f15547d += windowInsetsCompat.getSystemWindowInsetBottom();
            boolean z2 = ViewCompat.getLayoutDirection(view) == 1;
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
            fVar.a += z2 ? systemWindowInsetRight : systemWindowInsetLeft;
            int i2 = fVar.f15546c;
            if (!z2) {
                systemWindowInsetLeft = systemWindowInsetRight;
            }
            fVar.f15546c = i2 + systemWindowInsetLeft;
            fVar.a(view);
            return windowInsetsCompat;
        }
    }

    public interface c {
        void a(@NonNull MenuItem menuItem);
    }

    public interface d {
        boolean a(@NonNull MenuItem menuItem);
    }

    public NavigationBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, i3), attributeSet, i2);
        this.f15584u = new NavigationBarPresenter();
        Context context2 = getContext();
        TintTypedArray tintTypedArrayD = l.d(context2, attributeSet, R$styleable.NavigationBarView, i2, i3, R$styleable.NavigationBarView_itemTextAppearanceInactive, R$styleable.NavigationBarView_itemTextAppearanceActive);
        this.f15582s = new com.google.android.material.navigation.b(context2, getClass(), getMaxItemCount());
        this.f15583t = a(context2);
        this.f15584u.a(this.f15583t);
        this.f15584u.a(1);
        this.f15583t.setPresenter(this.f15584u);
        this.f15582s.addMenuPresenter(this.f15584u);
        this.f15584u.initForMenu(getContext(), this.f15582s);
        if (tintTypedArrayD.hasValue(R$styleable.NavigationBarView_itemIconTint)) {
            this.f15583t.setIconTintList(tintTypedArrayD.getColorStateList(R$styleable.NavigationBarView_itemIconTint));
        } else {
            com.google.android.material.navigation.c cVar = this.f15583t;
            cVar.setIconTintList(cVar.a(R.attr.textColorSecondary));
        }
        setItemIconSize(tintTypedArrayD.getDimensionPixelSize(R$styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R$dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (tintTypedArrayD.hasValue(R$styleable.NavigationBarView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(tintTypedArrayD.getResourceId(R$styleable.NavigationBarView_itemTextAppearanceInactive, 0));
        }
        if (tintTypedArrayD.hasValue(R$styleable.NavigationBarView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(tintTypedArrayD.getResourceId(R$styleable.NavigationBarView_itemTextAppearanceActive, 0));
        }
        if (tintTypedArrayD.hasValue(R$styleable.NavigationBarView_itemTextColor)) {
            setItemTextColor(tintTypedArrayD.getColorStateList(R$styleable.NavigationBarView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ViewCompat.setBackground(this, b(context2));
        }
        if (tintTypedArrayD.hasValue(R$styleable.NavigationBarView_elevation)) {
            setElevation(tintTypedArrayD.getDimensionPixelSize(R$styleable.NavigationBarView_elevation, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), com.google.android.material.i.c.a(context2, tintTypedArrayD, R$styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(tintTypedArrayD.getInteger(R$styleable.NavigationBarView_labelVisibilityMode, -1));
        int resourceId = tintTypedArrayD.getResourceId(R$styleable.NavigationBarView_itemBackground, 0);
        if (resourceId != 0) {
            this.f15583t.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(com.google.android.material.i.c.a(context2, tintTypedArrayD, R$styleable.NavigationBarView_itemRippleColor));
        }
        if (tintTypedArrayD.hasValue(R$styleable.NavigationBarView_menu)) {
            a(tintTypedArrayD.getResourceId(R$styleable.NavigationBarView_menu, 0));
        }
        tintTypedArrayD.recycle();
        addView(this.f15583t);
        this.f15582s.setCallback(new a());
        a();
    }

    private MenuInflater getMenuInflater() {
        if (this.f15586w == null) {
            this.f15586w = new SupportMenuInflater(getContext());
        }
        return this.f15586w;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract com.google.android.material.navigation.c a(@NonNull Context context);

    @Nullable
    public Drawable getItemBackground() {
        return this.f15583t.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.f15583t.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.f15583t.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f15583t.getIconTintList();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f15585v;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.f15583t.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f15583t.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f15583t.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f15583t.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.f15582s;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView getMenuView() {
        return this.f15583t;
    }

    @NonNull
    protected NavigationBarPresenter getPresenter() {
        return this.f15584u;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.f15583t.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.a(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f15582s.restorePresenterStates(savedState.f15589s);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15589s = new Bundle();
        this.f15582s.savePresenterStates(savedState.f15589s);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        h.a(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f15583t.setItemBackground(drawable);
        this.f15585v = null;
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        this.f15583t.setItemBackgroundRes(i2);
        this.f15585v = null;
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f15583t.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(@DimenRes int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f15583t.setIconTintList(colorStateList);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f15585v == colorStateList) {
            if (colorStateList != null || this.f15583t.getItemBackground() == null) {
                return;
            }
            this.f15583t.setItemBackground(null);
            return;
        }
        this.f15585v = colorStateList;
        if (colorStateList == null) {
            this.f15583t.setItemBackground(null);
            return;
        }
        ColorStateList colorStateListA = com.google.android.material.j.b.a(colorStateList);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f15583t.setItemBackground(new RippleDrawable(colorStateListA, null, null));
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(1.0E-5f);
        Drawable drawableWrap = DrawableCompat.wrap(gradientDrawable);
        DrawableCompat.setTintList(drawableWrap, colorStateListA);
        this.f15583t.setItemBackground(drawableWrap);
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.f15583t.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.f15583t.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f15583t.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f15583t.getLabelVisibilityMode() != i2) {
            this.f15583t.setLabelVisibilityMode(i2);
            this.f15584u.updateMenuView(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable c cVar) {
        this.f15588y = cVar;
    }

    public void setOnItemSelectedListener(@Nullable d dVar) {
        this.f15587x = dVar;
    }

    public void setSelectedItemId(@IdRes int i2) {
        MenuItem menuItemFindItem = this.f15582s.findItem(i2);
        if (menuItemFindItem == null || this.f15582s.performItemAction(menuItemFindItem, this.f15584u, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }

    private void a() {
        s.a(this, new b(this));
    }

    @NonNull
    private MaterialShapeDrawable b(Context context) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            materialShapeDrawable.a(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        materialShapeDrawable.a(context);
        return materialShapeDrawable;
    }

    public void a(int i2) {
        this.f15584u.a(true);
        getMenuInflater().inflate(i2, this.f15582s);
        this.f15584u.a(false);
        this.f15584u.updateMenuView(true);
    }
}
