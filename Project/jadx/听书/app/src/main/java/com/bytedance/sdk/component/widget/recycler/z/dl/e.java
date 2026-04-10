package com.bytedance.sdk.component.widget.recycler.z.dl;

import android.R;
import android.content.Context;
import android.util.TypedValue;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.sdk.component.utils.wp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f843a;
    private static boolean dl;
    private static Method g;
    private static boolean gc;
    private static Field z;

    public static int z(View view) {
        return view.getLayoutDirection();
    }

    public static void z(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void z(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static float z(ViewConfiguration viewConfiguration, Context context) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    public static float g(ViewConfiguration viewConfiguration, Context context) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }

    private static float dl(ViewConfiguration viewConfiguration, Context context) {
        if (g != null) {
            try {
                return ((Integer) r0.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception unused) {
                wp.z("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static int g(View view) {
        return view.getImportantForAccessibility();
    }

    public static void z(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static void dl(View view) {
        view.postInvalidateOnAnimation();
    }

    public static int a(View view) {
        return view.getMinimumWidth();
    }

    public static int gc(View view) {
        return view.getMinimumHeight();
    }

    public static boolean m(View view) {
        return view.hasTransientState();
    }

    public static Display e(View view) {
        return view.getDisplay();
    }

    public static boolean gz(View view) {
        return view.isAttachedToWindow();
    }

    public static int fo(View view) {
        return view.getImportantForAutofill();
    }

    public static void g(View view, int i) {
        view.setImportantForAutofill(i);
    }

    public static boolean z(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    public static void uy(View view) {
        view.stopNestedScroll();
    }
}
