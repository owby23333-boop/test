package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.l;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.c;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class BottomNavigationView extends NavigationBarView {

    @Deprecated
    public interface a extends NavigationBarView.c {
    }

    @Deprecated
    public interface b extends NavigationBarView.d {
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.bottomNavigationStyle);
    }

    private void b(@NonNull Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, R$color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R$dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected c a(@NonNull Context context) {
        return new com.google.android.material.bottomnavigation.b(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return 5;
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        com.google.android.material.bottomnavigation.b bVar = (com.google.android.material.bottomnavigation.b) getMenuView();
        if (bVar.c() != z2) {
            bVar.setItemHorizontalTranslationEnabled(z2);
            getPresenter().updateMenuView(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable a aVar) {
        setOnItemReselectedListener(aVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable b bVar) {
        setOnItemSelectedListener(bVar);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R$style.Widget_Design_BottomNavigationView);
    }

    private boolean a() {
        return Build.VERSION.SDK_INT < 21 && !(getBackground() instanceof MaterialShapeDrawable);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Context context2 = getContext();
        TintTypedArray tintTypedArrayD = l.d(context2, attributeSet, R$styleable.BottomNavigationView, i2, i3, new int[0]);
        setItemHorizontalTranslationEnabled(tintTypedArrayD.getBoolean(R$styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        tintTypedArrayD.recycle();
        if (a()) {
            b(context2);
        }
    }
}
