package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.c.a;
import com.google.android.material.i.c;
import com.google.android.material.internal.l;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialRadioButton extends AppCompatRadioButton {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f15689u = R$style.Widget_MaterialComponents_CompoundButton_RadioButton;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int[][] f15690v = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private ColorStateList f15691s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f15692t;

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f15691s == null) {
            int iA = a.a(this, R$attr.colorControlActivated);
            int iA2 = a.a(this, R$attr.colorOnSurface);
            int iA3 = a.a(this, R$attr.colorSurface);
            int[] iArr = new int[f15690v.length];
            iArr[0] = a.a(iA3, iA, 1.0f);
            iArr[1] = a.a(iA3, iA2, 0.54f);
            iArr[2] = a.a(iA3, iA2, 0.38f);
            iArr[3] = a.a(iA3, iA2, 0.38f);
            this.f15691s = new ColorStateList(f15690v, iArr);
        }
        return this.f15691s;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f15692t && CompoundButtonCompat.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f15692t = z2;
        if (z2) {
            CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat.setButtonTintList(this, null);
        }
    }

    public MaterialRadioButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, f15689u), attributeSet, i2);
        Context context2 = getContext();
        TypedArray typedArrayC = l.c(context2, attributeSet, R$styleable.MaterialRadioButton, i2, f15689u, new int[0]);
        if (typedArrayC.hasValue(R$styleable.MaterialRadioButton_buttonTint)) {
            CompoundButtonCompat.setButtonTintList(this, c.a(context2, typedArrayC, R$styleable.MaterialRadioButton_buttonTint));
        }
        this.f15692t = typedArrayC.getBoolean(R$styleable.MaterialRadioButton_useMaterialThemeColors, false);
        typedArrayC.recycle();
    }
}
