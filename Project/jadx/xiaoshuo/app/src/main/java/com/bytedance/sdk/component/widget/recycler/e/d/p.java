package com.bytedance.sdk.component.widget.recycler.e.d;

import android.R;
import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class p {
    private static Method bf;
    private static boolean d;
    private static Field e;
    private static boolean ga;
    private static Field tg;

    public static float bf(ViewConfiguration viewConfiguration, Context context) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }

    private static float d(ViewConfiguration viewConfiguration, Context context) {
        if (bf != null) {
            try {
                return ((Integer) r0.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int e(View view) {
        return view.getLayoutDirection();
    }

    public static int ga(View view) {
        return view.getMinimumHeight();
    }

    public static void m(View view) {
        view.stopNestedScroll();
    }

    public static Display p(View view) {
        return view.getDisplay();
    }

    public static int tg(View view) {
        return view.getMinimumWidth();
    }

    public static boolean v(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean vn(View view) {
        return view.hasTransientState();
    }

    public static int zk(View view) {
        return view.getImportantForAutofill();
    }

    public static int bf(View view) {
        return view.getImportantForAccessibility();
    }

    public static void e(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void bf(View view, int i) {
        view.setImportantForAutofill(i);
    }

    public static void e(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static float e(ViewConfiguration viewConfiguration, Context context) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static void e(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void d(View view) {
        view.postInvalidateOnAnimation();
    }

    public static boolean e(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
