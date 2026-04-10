package com.google.android.material.internal;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* JADX INFO: compiled from: NavigationSubMenu.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class g extends SubMenuBuilder {
    public g(Context context, e eVar, MenuItemImpl menuItemImpl) {
        super(context, eVar, menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void onItemsChanged(boolean z2) {
        super.onItemsChanged(z2);
        ((MenuBuilder) getParentMenu()).onItemsChanged(z2);
    }
}
