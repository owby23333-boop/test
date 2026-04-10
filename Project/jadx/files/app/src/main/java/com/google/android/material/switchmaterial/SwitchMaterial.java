package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.f.a;
import com.google.android.material.internal.l;
import com.google.android.material.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchMaterial extends SwitchCompat {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f15835w = R$style.Widget_MaterialComponents_CompoundButton_Switch;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int[][] f15836x = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    private final a f15837s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    private ColorStateList f15838t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private ColorStateList f15839u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f15840v;

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.switchStyle);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.f15838t == null) {
            int iA = com.google.android.material.c.a.a(this, R$attr.colorSurface);
            int iA2 = com.google.android.material.c.a.a(this, R$attr.colorControlActivated);
            float dimension = getResources().getDimension(R$dimen.mtrl_switch_thumb_elevation);
            if (this.f15837s.a()) {
                dimension += s.d(this);
            }
            int iB = this.f15837s.b(iA, dimension);
            int[] iArr = new int[f15836x.length];
            iArr[0] = com.google.android.material.c.a.a(iA, iA2, 1.0f);
            iArr[1] = iB;
            iArr[2] = com.google.android.material.c.a.a(iA, iA2, 0.38f);
            iArr[3] = iB;
            this.f15838t = new ColorStateList(f15836x, iArr);
        }
        return this.f15838t;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.f15839u == null) {
            int[] iArr = new int[f15836x.length];
            int iA = com.google.android.material.c.a.a(this, R$attr.colorSurface);
            int iA2 = com.google.android.material.c.a.a(this, R$attr.colorControlActivated);
            int iA3 = com.google.android.material.c.a.a(this, R$attr.colorOnSurface);
            iArr[0] = com.google.android.material.c.a.a(iA, iA2, 0.54f);
            iArr[1] = com.google.android.material.c.a.a(iA, iA3, 0.32f);
            iArr[2] = com.google.android.material.c.a.a(iA, iA2, 0.12f);
            iArr[3] = com.google.android.material.c.a.a(iA, iA3, 0.12f);
            this.f15839u = new ColorStateList(f15836x, iArr);
        }
        return this.f15839u;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f15840v && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f15840v && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z2) {
        this.f15840v = z2;
        if (z2) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }

    public SwitchMaterial(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.b(context, attributeSet, i2, f15835w), attributeSet, i2);
        Context context2 = getContext();
        this.f15837s = new a(context2);
        TypedArray typedArrayC = l.c(context2, attributeSet, R$styleable.SwitchMaterial, i2, f15835w, new int[0]);
        this.f15840v = typedArrayC.getBoolean(R$styleable.SwitchMaterial_useMaterialThemeColors, false);
        typedArrayC.recycle();
    }
}
