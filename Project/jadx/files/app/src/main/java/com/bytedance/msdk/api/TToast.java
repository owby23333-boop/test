package com.bytedance.msdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes2.dex */
public final class TToast {
    private static Toast a;

    @SuppressLint({"ShowToast"})
    private static Toast a(Context context) {
        if (context != null) {
            a = Toast.makeText(context.getApplicationContext(), "", 0);
        }
        return a;
    }

    public static void reset() {
        a = null;
    }

    public static void show(Context context, String str) {
        show(context, str, 0);
    }

    public static void show(Context context, String str, int i2) {
        Toast toastA = a(context);
        if (toastA != null) {
            toastA.setDuration(i2);
            toastA.setText(String.valueOf(str));
            toastA.show();
        } else {
            String str2 = "toast msg: " + String.valueOf(str);
        }
    }
}
