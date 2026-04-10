package com.google.android.material.appbar;

import android.R;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.internal.l;

/* JADX INFO: compiled from: ViewUtilsLollipop.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
class b {
    private static final int[] a = {R.attr.stateListAnimator};

    static void a(@NonNull View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    static void a(@NonNull View view, AttributeSet attributeSet, int i2, int i3) {
        Context context = view.getContext();
        TypedArray typedArrayC = l.c(context, attributeSet, a, i2, i3, new int[0]);
        try {
            if (typedArrayC.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, typedArrayC.getResourceId(0, 0)));
            }
        } finally {
            typedArrayC.recycle();
        }
    }

    static void a(@NonNull View view, float f2) {
        int integer = view.getResources().getInteger(R$integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = integer;
        stateListAnimator.addState(new int[]{R.attr.enabled, R$attr.state_liftable, -R$attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j2));
        stateListAnimator.addState(new int[]{R.attr.enabled}, ObjectAnimator.ofFloat(view, "elevation", f2).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }
}
