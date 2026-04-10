package com.xuexiang.xupdate.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogUtils {

    public interface IWindowShower {
        void show(Window window);
    }

    private DialogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean showWindow(Activity activity, Window window, IWindowShower iWindowShower) {
        if (activity == null || window == null || iWindowShower == null) {
            return false;
        }
        window.addFlags(8);
        iWindowShower.show(window);
        syncSystemUiVisibility(activity, window);
        window.clearFlags(8);
        return true;
    }

    public static boolean syncSystemUiVisibility(Activity activity, Window window) {
        if (activity == null) {
            return false;
        }
        return syncSystemUiVisibility(activity.getWindow(), window);
    }

    public static boolean syncSystemUiVisibility(Window window, Window window2) {
        if (window == null || window2 == null) {
            return false;
        }
        window2.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility());
        return true;
    }

    public static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean isShouldHideInput(Window window, MotionEvent motionEvent) {
        if (window == null || motionEvent == null || !isSoftInputShow(window) || !(window.getCurrentFocus() instanceof EditText)) {
            return false;
        }
        View decorView = window.getDecorView();
        return (decorView instanceof ViewGroup) && findTouchEditText((ViewGroup) decorView, motionEvent) == null;
    }

    private static View findTouchEditText(ViewGroup viewGroup, MotionEvent motionEvent) {
        if (viewGroup == null) {
            return null;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null && childAt.isShown() && isTouchView(childAt, motionEvent)) {
                if (childAt instanceof EditText) {
                    return childAt;
                }
                if (childAt instanceof ViewGroup) {
                    return findTouchEditText((ViewGroup) childAt, motionEvent);
                }
            }
        }
        return null;
    }

    private static boolean isTouchView(View view, MotionEvent motionEvent) {
        if (view == null || motionEvent == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private static boolean isSoftInputShow(Window window) {
        if (window == null || !(window.getDecorView() instanceof ViewGroup)) {
            return false;
        }
        return isSoftInputShow((ViewGroup) window.getDecorView());
    }

    private static boolean isSoftInputShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        int height = viewGroup.getHeight();
        Rect rect = new Rect();
        viewGroup.getWindowVisibleDisplayFrame(rect);
        return (height - rect.bottom) - getNavigationBarHeight(viewGroup.getContext()) > 0;
    }

    private static int getNavigationBarHeight(Context context) {
        WindowManager windowManager;
        if (context instanceof Activity) {
            windowManager = ((Activity) context).getWindowManager();
        } else {
            windowManager = (WindowManager) context.getSystemService("window");
        }
        if (windowManager == null) {
            return 0;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i3 = i - displayMetrics2.heightPixels;
        return i3 > 0 ? i3 : Math.max(i2 - displayMetrics2.widthPixels, 0);
    }

    public static void hideSoftInput(View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
