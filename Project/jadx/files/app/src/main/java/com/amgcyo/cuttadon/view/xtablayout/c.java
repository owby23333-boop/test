package com.amgcyo.cuttadon.view.xtablayout;

import android.content.Context;
import android.content.res.TypedArray;
import com.fatcatfat.io.R;

/* JADX INFO: compiled from: ThemeUtils.java */
/* JADX INFO: loaded from: classes.dex */
class c {
    private static final int[] a = {R.attr.colorPrimary};

    static void a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(a);
        boolean z2 = !typedArrayObtainStyledAttributes.hasValue(0);
        if (typedArrayObtainStyledAttributes != null) {
            typedArrayObtainStyledAttributes.recycle();
        }
        if (z2) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
