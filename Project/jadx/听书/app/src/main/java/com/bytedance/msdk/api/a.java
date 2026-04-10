package com.bytedance.msdk.api;

import android.content.Context;
import android.widget.Toast;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static Toast z;

    public static void z(Context context, String str) {
        z(context, str, 0);
    }

    public static void z(Context context, String str, int i) {
        Toast toastZ = z(context);
        if (toastZ != null) {
            toastZ.setDuration(i);
            toastZ.setText(String.valueOf(str));
            toastZ.show();
            return;
        }
        com.bytedance.msdk.z.gc.dl.g("TToast", "toast msg: ".concat(String.valueOf(str)));
    }

    private static Toast z(Context context) {
        if (context == null) {
            return z;
        }
        Toast toastMakeText = Toast.makeText(context.getApplicationContext(), "", 0);
        z = toastMakeText;
        return toastMakeText;
    }
}
