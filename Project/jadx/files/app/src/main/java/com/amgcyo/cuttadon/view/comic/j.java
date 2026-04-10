package com.amgcyo.cuttadon.view.comic;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: ComicViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, 16L);
        }
    }

    public static int b(View view) {
        return (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
    }

    public static float a(Matrix matrix) {
        matrix.getValues(new float[9]);
        return (float) Math.sqrt(((float) Math.pow(r0[0], 2.0d)) + ((float) Math.pow(r0[3], 2.0d)));
    }

    public static int a(View view) {
        return (view.getHeight() - view.getPaddingTop()) - view.getPaddingBottom();
    }
}
