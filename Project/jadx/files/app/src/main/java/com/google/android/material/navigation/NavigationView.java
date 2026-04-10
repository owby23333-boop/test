package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.e;
import com.google.android.material.internal.f;
import com.google.android.material.internal.l;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.h;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] E = {R.attr.state_checked};
    private static final int[] F = {-16842910};
    private static final int G = R$style.Widget_Design_NavigationView;
    private final int A;
    private final int[] B;
    private MenuInflater C;
    private ViewTreeObserver.OnGlobalLayoutListener D;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    private final e f15591x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final f f15592y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    c f15593z;

    class a implements MenuBuilder.Callback {
        a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            c cVar = NavigationView.this.f15593z;
            return cVar != null && cVar.a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.B);
            boolean z2 = NavigationView.this.B[1] == 0;
            NavigationView.this.f15592y.a(z2);
            NavigationView.this.setDrawTopInsetForeground(z2);
            Activity activity = com.google.android.material.internal.b.getActivity(NavigationView.this.getContext());
            if (activity == null || Build.VERSION.SDK_INT < 21) {
                return;
            }
            NavigationView.this.setDrawBottomInsetForeground((activity.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
        }
    }

    public interface c {
        boolean a(@NonNull MenuItem menuItem);
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.navigationViewStyle);
    }

    @Nullable
    private ColorStateList c(int i2) {
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
        return new ColorStateList(new int[][]{F, E, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(F, defaultColor), i3, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.C == null) {
            this.C = new SupportMenuInflater(getContext());
        }
        return this.C;
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.f15592y.a();
    }

    public int getHeaderCount() {
        return this.f15592y.b();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f15592y.c();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.f15592y.d();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.f15592y.e();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f15592y.h();
    }

    public int getItemMaxLines() {
        return this.f15592y.f();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f15592y.g();
    }

    @NonNull
    public Menu getMenu() {
        return this.f15591x;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.a(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.D);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.D);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.A), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.A, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f15591x.restorePresenterStates(savedState.f15594s);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f15594s = new Bundle();
        this.f15591x.savePresenterStates(savedState.f15594s);
        return savedState;
    }

    public void setCheckedItem(@IdRes int i2) {
        MenuItem menuItemFindItem = this.f15591x.findItem(i2);
        if (menuItemFindItem != null) {
            this.f15592y.a((MenuItemImpl) menuItemFindItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        h.a(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f15592y.a(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemHorizontalPadding(@Dimension int i2) {
        this.f15592y.c(i2);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i2) {
        this.f15592y.c(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(@Dimension int i2) {
        this.f15592y.d(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.f15592y.d(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f15592y.e(i2);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f15592y.a(colorStateList);
    }

    public void setItemMaxLines(int i2) {
        this.f15592y.f(i2);
    }

    public void setItemTextAppearance(@StyleRes int i2) {
        this.f15592y.g(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f15592y.b(colorStateList);
    }

    public void setNavigationItemSelectedListener(@Nullable c cVar) {
        this.f15593z = cVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        super.setOverScrollMode(i2);
        f fVar = this.f15592y;
        if (fVar != null) {
            fVar.h(i2);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @Nullable
        public Bundle f15594s;

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

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f15594s = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f15594s);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        boolean z2;
        int resourceId;
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, G), attributeSet, i2);
        this.f15592y = new f();
        this.B = new int[2];
        Context context2 = getContext();
        this.f15591x = new e(context2);
        TintTypedArray tintTypedArrayD = l.d(context2, attributeSet, R$styleable.NavigationView, i2, G, new int[0]);
        if (tintTypedArrayD.hasValue(R$styleable.NavigationView_android_background)) {
            ViewCompat.setBackground(this, tintTypedArrayD.getDrawable(R$styleable.NavigationView_android_background));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            com.google.android.material.shape.l lVarA = com.google.android.material.shape.l.a(context2, attributeSet, i2, G).a();
            Drawable background = getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(lVarA);
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.a(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.a(context2);
            ViewCompat.setBackground(this, materialShapeDrawable);
        }
        if (tintTypedArrayD.hasValue(R$styleable.NavigationView_elevation)) {
            setElevation(tintTypedArrayD.getDimensionPixelSize(R$styleable.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(tintTypedArrayD.getBoolean(R$styleable.NavigationView_android_fitsSystemWindows, false));
        this.A = tintTypedArrayD.getDimensionPixelSize(R$styleable.NavigationView_android_maxWidth, 0);
        ColorStateList colorStateList = tintTypedArrayD.hasValue(R$styleable.NavigationView_itemIconTint) ? tintTypedArrayD.getColorStateList(R$styleable.NavigationView_itemIconTint) : c(R.attr.textColorSecondary);
        if (tintTypedArrayD.hasValue(R$styleable.NavigationView_itemTextAppearance)) {
            resourceId = tintTypedArrayD.getResourceId(R$styleable.NavigationView_itemTextAppearance, 0);
            z2 = true;
        } else {
            z2 = false;
            resourceId = 0;
        }
        if (tintTypedArrayD.hasValue(R$styleable.NavigationView_itemIconSize)) {
            setItemIconSize(tintTypedArrayD.getDimensionPixelSize(R$styleable.NavigationView_itemIconSize, 0));
        }
        ColorStateList colorStateList2 = tintTypedArrayD.hasValue(R$styleable.NavigationView_itemTextColor) ? tintTypedArrayD.getColorStateList(R$styleable.NavigationView_itemTextColor) : null;
        if (!z2 && colorStateList2 == null) {
            colorStateList2 = c(R.attr.textColorPrimary);
        }
        Drawable drawable = tintTypedArrayD.getDrawable(R$styleable.NavigationView_itemBackground);
        if (drawable == null && b(tintTypedArrayD)) {
            drawable = a(tintTypedArrayD);
        }
        if (tintTypedArrayD.hasValue(R$styleable.NavigationView_itemHorizontalPadding)) {
            this.f15592y.c(tintTypedArrayD.getDimensionPixelSize(R$styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int dimensionPixelSize = tintTypedArrayD.getDimensionPixelSize(R$styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(tintTypedArrayD.getInt(R$styleable.NavigationView_itemMaxLines, 1));
        this.f15591x.setCallback(new a());
        this.f15592y.b(1);
        this.f15592y.initForMenu(context2, this.f15591x);
        this.f15592y.a(colorStateList);
        this.f15592y.h(getOverScrollMode());
        if (z2) {
            this.f15592y.g(resourceId);
        }
        this.f15592y.b(colorStateList2);
        this.f15592y.a(drawable);
        this.f15592y.d(dimensionPixelSize);
        this.f15591x.addMenuPresenter(this.f15592y);
        addView((View) this.f15592y.getMenuView(this));
        if (tintTypedArrayD.hasValue(R$styleable.NavigationView_menu)) {
            b(tintTypedArrayD.getResourceId(R$styleable.NavigationView_menu, 0));
        }
        if (tintTypedArrayD.hasValue(R$styleable.NavigationView_headerLayout)) {
            a(tintTypedArrayD.getResourceId(R$styleable.NavigationView_headerLayout, 0));
        }
        tintTypedArrayD.recycle();
        a();
    }

    @NonNull
    private final Drawable a(@NonNull TintTypedArray tintTypedArray) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(com.google.android.material.shape.l.a(getContext(), tintTypedArray.getResourceId(R$styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(R$styleable.NavigationView_itemShapeAppearanceOverlay, 0)).a());
        materialShapeDrawable.a(com.google.android.material.i.c.a(getContext(), tintTypedArray, R$styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) materialShapeDrawable, tintTypedArray.getDimensionPixelSize(R$styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(R$styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(R$styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(R$styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private boolean b(@NonNull TintTypedArray tintTypedArray) {
        return tintTypedArray.hasValue(R$styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(R$styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f15591x.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f15592y.a((MenuItemImpl) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public void b(int i2) {
        this.f15592y.b(true);
        getMenuInflater().inflate(i2, this.f15591x);
        this.f15592y.b(false);
        this.f15592y.updateMenuView(false);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void a(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.f15592y.a(windowInsetsCompat);
    }

    public View a(@LayoutRes int i2) {
        return this.f15592y.a(i2);
    }

    private void a() {
        this.D = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.D);
    }
}
