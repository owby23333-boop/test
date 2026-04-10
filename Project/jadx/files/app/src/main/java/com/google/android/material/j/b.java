package com.google.android.material.j;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: compiled from: RippleUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b {
    public static final boolean a;
    private static final int[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f15549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f15550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f15551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f15552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f15553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f15554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f15555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f15556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f15557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @VisibleForTesting
    static final String f15558l;

    static {
        a = Build.VERSION.SDK_INT >= 21;
        b = new int[]{R.attr.state_pressed};
        f15549c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        f15550d = new int[]{R.attr.state_focused};
        f15551e = new int[]{R.attr.state_hovered};
        f15552f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        f15553g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        f15554h = new int[]{R.attr.state_selected, R.attr.state_focused};
        f15555i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        f15556j = new int[]{R.attr.state_selected};
        f15557k = new int[]{R.attr.state_enabled, R.attr.state_pressed};
        f15558l = b.class.getSimpleName();
    }

    private b() {
    }

    @NonNull
    public static ColorStateList a(@Nullable ColorStateList colorStateList) {
        if (a) {
            return new ColorStateList(new int[][]{f15556j, StateSet.NOTHING}, new int[]{a(colorStateList, f15552f), a(colorStateList, b)});
        }
        int[] iArr = f15552f;
        int[] iArr2 = f15553g;
        int[] iArr3 = f15554h;
        int[] iArr4 = f15555i;
        int[] iArr5 = b;
        int[] iArr6 = f15549c;
        int[] iArr7 = f15550d;
        int[] iArr8 = f15551e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f15556j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a(colorStateList, iArr), a(colorStateList, iArr2), a(colorStateList, iArr3), a(colorStateList, iArr4), 0, a(colorStateList, iArr5), a(colorStateList, iArr6), a(colorStateList, iArr7), a(colorStateList, iArr8), 0});
    }

    @NonNull
    public static ColorStateList b(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0) {
            Color.alpha(colorStateList.getColorForState(f15557k, 0));
        }
        return colorStateList;
    }

    public static boolean a(@NonNull int[] iArr) {
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z2 = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z3 = true;
            }
        }
        return z2 && z3;
    }

    @ColorInt
    private static int a(@Nullable ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return a ? a(colorForState) : colorForState;
    }

    @ColorInt
    @TargetApi(21)
    private static int a(@ColorInt int i2) {
        return ColorUtils.setAlphaComponent(i2, Math.min(Color.alpha(i2) * 2, 255));
    }
}
