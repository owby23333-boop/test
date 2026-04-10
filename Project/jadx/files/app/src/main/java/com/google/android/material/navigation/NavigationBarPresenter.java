package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationBarPresenter implements MenuPresenter {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MenuBuilder f15576s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c f15577t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f15578u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f15579v;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f15580s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @Nullable
        ParcelableSparseArray f15581t;

        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            parcel.writeInt(this.f15580s);
            parcel.writeParcelable(this.f15581t, 0);
        }

        SavedState(@NonNull Parcel parcel) {
            this.f15580s = parcel.readInt();
            this.f15581t = (ParcelableSparseArray) parcel.readParcelable(SavedState.class.getClassLoader());
        }
    }

    public void a(@NonNull c cVar) {
        this.f15577t = cVar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(@Nullable MenuBuilder menuBuilder, @Nullable MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(@Nullable MenuBuilder menuBuilder, @Nullable MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f15579v;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @Nullable
    public MenuView getMenuView(@Nullable ViewGroup viewGroup) {
        return this.f15577t;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.f15576s = menuBuilder;
        this.f15577t.initialize(this.f15576s);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(@Nullable MenuBuilder menuBuilder, boolean z2) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(@NonNull Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f15577t.b(savedState.f15580s);
            this.f15577t.setBadgeDrawables(com.google.android.material.badge.a.a(this.f15577t.getContext(), savedState.f15581t));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f15580s = this.f15577t.getSelectedItemId();
        savedState.f15581t = com.google.android.material.badge.a.a(this.f15577t.getBadgeDrawables());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(@Nullable SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(@Nullable MenuPresenter.Callback callback) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z2) {
        if (this.f15578u) {
            return;
        }
        if (z2) {
            this.f15577t.a();
        } else {
            this.f15577t.b();
        }
    }

    public void a(int i2) {
        this.f15579v = i2;
    }

    public void a(boolean z2) {
        this.f15578u = z2;
    }
}
