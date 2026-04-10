package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.c.a;
import com.google.android.material.i.c;
import com.google.android.material.internal.l;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCheckBox extends AppCompatCheckBox {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f15164u = R$style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int[][] f15165v = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private ColorStateList f15166s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f15167t;

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.checkboxStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f15166s == null) {
            int[] iArr = new int[f15165v.length];
            int iA = a.a(this, R$attr.colorControlActivated);
            int iA2 = a.a(this, R$attr.colorSurface);
            int iA3 = a.a(this, R$attr.colorOnSurface);
            iArr[0] = a.a(iA2, iA, 1.0f);
            iArr[1] = a.a(iA2, iA3, 0.54f);
            iArr[2] = a.a(iA2, iA3, 0.38f);
            iArr[3] = a.a(iA2, iA3, 0.38f);
            this.f15166s = new ColorStateList(f15165v, iArr);
        }
        return this.f15166s;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f15167t && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f15167t = z2;
        if (z2) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    public MaterialCheckBox(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, f15164u), attributeSet, i2);
        Context context2 = getContext();
        TypedArray typedArrayC = l.c(context2, attributeSet, R$styleable.MaterialCheckBox, i2, f15164u, new int[0]);
        if (typedArrayC.hasValue(R$styleable.MaterialCheckBox_buttonTint)) {
            CompoundButtonCompat.setButtonTintList(this, c.a(context2, typedArrayC, R$styleable.MaterialCheckBox_buttonTint));
        }
        this.f15167t = typedArrayC.getBoolean(R$styleable.MaterialCheckBox_useMaterialThemeColors, false);
        typedArrayC.recycle();
    }
}
