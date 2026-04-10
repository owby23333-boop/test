package com.google.android.material.bottomnavigation;

import android.content.Context;
import androidx.annotation.DimenRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;

/* JADX INFO: compiled from: BottomNavigationItemView.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a extends com.google.android.material.navigation.a {
    public a(@NonNull Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.a
    @DimenRes
    protected int getItemDefaultMarginResId() {
        return R$dimen.design_bottom_navigation_margin;
    }

    @Override // com.google.android.material.navigation.a
    @LayoutRes
    protected int getItemLayoutResId() {
        return R$layout.design_bottom_navigation_item;
    }
}
