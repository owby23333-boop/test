package com.yuewen;

import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaomi.ad.common.util.SignatureUtils;

/* JADX INFO: loaded from: classes5.dex */
public class le4 {
    public static void a(View view, String str, StringBuilder sb) {
        String resourceEntryName;
        if (view == null) {
            return;
        }
        sb.append(str);
        sb.append(view.getClass().getName());
        int id = view.getId();
        try {
            resourceEntryName = view.getResources().getResourceEntryName(id);
        } catch (Exception e) {
            e.printStackTrace();
            resourceEntryName = null;
        }
        sb.append("(");
        sb.append(id);
        sb.append(":");
        sb.append(resourceEntryName);
        sb.append(")");
        sb.append(SignatureUtils.DELIMITER);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            String str2 = "--" + str;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), str2, sb);
            }
        }
    }

    public static String b(View view) {
        if (view == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        a(view, "", sb);
        return sb.toString();
    }

    public static int c(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (str.equalsIgnoreCase("TOP")) {
            return 48;
        }
        if (str.equalsIgnoreCase("BOTTOM")) {
            return 80;
        }
        if (str.equalsIgnoreCase("LEFT")) {
            return 3;
        }
        if (str.equalsIgnoreCase("RIGHT")) {
            return 5;
        }
        if (str.equalsIgnoreCase("CENTER_VERTICAL")) {
            return 16;
        }
        if (str.equalsIgnoreCase("CENTER_HORIZONTAL")) {
            return 1;
        }
        if (str.equalsIgnoreCase("CENTER")) {
            return 17;
        }
        return i;
    }

    public static boolean d(View view) {
        if (view == null) {
            return false;
        }
        view.setVisibility(8);
        return true;
    }

    public static boolean e(View view) {
        if (view == null) {
            return false;
        }
        view.setVisibility(4);
        return true;
    }

    public static boolean f(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return false;
        }
        view.setOnClickListener(onClickListener);
        return true;
    }

    public static void g(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (view.getVisibility() == 0) {
            if (z) {
                return;
            }
        } else if (view.getVisibility() == 8 && !z) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public static void h(TextView textView, String str) {
        if (textView == null || TextUtils.equals(textView.getText(), str)) {
            return;
        }
        textView.setText(str);
    }

    public static void i(TextView textView, ColorStateList colorStateList) {
        if (textView == null || textView.getTextColors() == colorStateList) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public static boolean j(View view, int i) {
        if (view == null || view.getVisibility() == i) {
            return false;
        }
        view.setVisibility(i);
        return true;
    }

    public static boolean k(View view) {
        if (view == null) {
            return false;
        }
        view.setVisibility(0);
        return true;
    }

    public static boolean l(View view) {
        return view != null && view.getVisibility() == 0;
    }
}
