package com.dangdang.zframework.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.dangdang.zframework.R;
import com.dangdang.zframework.view.DDTextView;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes10.dex */
public class UiUtil {
    private static long mLastClickTime;

    public static int dip2px(Context context, float f) {
        return context != null ? (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f) : (int) f;
    }

    private static int getToastBg() {
        return R.drawable.toast_frame;
    }

    public static void hideInput(Context context) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 2);
            }
        } catch (Exception unused) {
        }
    }

    public static void hideSoftInput(View view) {
        if (view != null) {
            try {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean isFastDoubleClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - mLastClickTime;
        if (0 < j && j < 500) {
            return true;
        }
        mLastClickTime = jCurrentTimeMillis;
        return false;
    }

    public static int px2dip(Context context, float f) {
        return context != null ? (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f) : (int) f;
    }

    public static void showSoftInput(final View view) {
        if (view != null) {
            try {
                view.requestFocus();
                new Timer().schedule(new TimerTask() { // from class: com.dangdang.zframework.utils.UiUtil.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                    }
                }, 200L);
            } catch (Exception unused) {
            }
        }
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 0);
    }

    public static void showToast(Context context, String str, int i) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Toast toast = new Toast(applicationContext);
        DDTextView dDTextView = new DDTextView(applicationContext);
        dDTextView.setGravity(17);
        dDTextView.setTextColor(applicationContext.getResources().getColor(R.color.white));
        try {
            dDTextView.setBackgroundResource(getToastBg());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        toast.setView(dDTextView);
        dDTextView.setText(str);
        toast.setDuration(i);
        toast.show();
    }

    public static void showToast(Context context, int i) {
        showToast(context, i, 0);
    }

    public static void showToast(Context context, int i, int i2) {
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        showToast(applicationContext, applicationContext.getString(i), i2);
    }
}
