package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import androidx.annotation.DimenRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;

/* JADX INFO: compiled from: NavigationRailItemView.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class a extends com.google.android.material.navigation.a {
    public a(@NonNull Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.a
    @DimenRes
    protected int getItemDefaultMarginResId() {
        return R$dimen.mtrl_navigation_rail_icon_margin;
    }

    @Override // com.google.android.material.navigation.a
    @LayoutRes
    protected int getItemLayoutResId() {
        return R$layout.mtrl_navigation_rail_item;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (View.MeasureSpec.getMode(i3) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i3)), i3, 0));
        }
    }
}
