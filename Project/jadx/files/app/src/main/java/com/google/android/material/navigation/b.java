package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* JADX INFO: compiled from: NavigationBarMenu.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b extends MenuBuilder {

    @NonNull
    private final Class<?> a;
    private final int b;

    public b(@NonNull Context context, @NonNull Class<?> cls, int i2) {
        super(context);
        this.a = cls;
        this.b = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    @NonNull
    protected MenuItem addInternal(int i2, int i3, int i4, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.b) {
            stopDispatchingItemsChanged();
            MenuItem menuItemAddInternal = super.addInternal(i2, i3, i4, charSequence);
            if (menuItemAddInternal instanceof MenuItemImpl) {
                ((MenuItemImpl) menuItemAddInternal).setExclusiveCheckable(true);
            }
            startDispatchingItemsChanged();
            return menuItemAddInternal;
        }
        String simpleName = this.a.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.b + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int i2, int i3, int i4, @NonNull CharSequence charSequence) {
        throw new UnsupportedOperationException(this.a.getSimpleName() + " does not support submenus");
    }
}
