package com.yuewen;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: loaded from: classes5.dex */
public class wp1 {
    public static boolean a(Context context, View view) {
        if (context != null && view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                return inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        }
        return false;
    }

    public static void b(Context context, EditText editText) {
        if (context == null || editText == null) {
            return;
        }
        editText.requestFocus();
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(editText, 0);
    }
}
