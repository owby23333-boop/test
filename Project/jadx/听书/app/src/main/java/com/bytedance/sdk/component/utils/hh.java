package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes2.dex */
public class hh {
    private static SoftReference<Toast> z;

    private static Toast z(Context context) {
        if (context == null) {
            SoftReference<Toast> softReference = z;
            if (softReference != null) {
                return softReference.get();
            }
            return null;
        }
        SoftReference<Toast> softReference2 = new SoftReference<>(Toast.makeText(context.getApplicationContext(), "", 0));
        z = softReference2;
        return softReference2.get();
    }

    public static Toast z(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toast = new Toast(context);
        toast.setDuration(i);
        toast.setGravity(i2, i3, i4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(z(context, 10.0f));
        gradientDrawable.setColor(Color.parseColor("#CC161823"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(z(context, 20.0f), z(context, 12.0f), z(context, 20.0f), z(context, 12.0f));
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        return toast;
    }

    public static void z(Context context, String str, int i) {
        g(context, str, i, 80, 0, z(context, 40.0f));
    }

    public static void g(Context context, String str, int i, int i2, int i3, int i4) {
        Toast toastZ = z(context);
        if (toastZ != null) {
            toastZ.setDuration(i);
            toastZ.setGravity(i2, i3, i4);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(z(context, 10.0f));
            gradientDrawable.setColor(Color.parseColor("#CC161823"));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setBackground(gradientDrawable);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(z(context, 20.0f), z(context, 12.0f), z(context, 20.0f), z(context, 12.0f));
            TextView textView = new TextView(context);
            textView.setTextColor(-1);
            textView.setText(str);
            textView.setTextSize(2, 14.0f);
            linearLayout.addView(textView);
            toastZ.setView(linearLayout);
            toastZ.show();
            return;
        }
        wp.z("TToast", "toast msg: ".concat(String.valueOf(str)));
    }

    private static int z(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
