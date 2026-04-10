package com.yuewen;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/* JADX INFO: loaded from: classes5.dex */
public class nm0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f14891a = 4000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f14892b = 7000;
    public static Toast c;
    public static Handler d = new Handler();
    public static Runnable e = new a();

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (nm0.c != null) {
                nm0.c.cancel();
            }
        }
    }

    public static void b(Context context, int i, int i2) {
        c(context, context.getResources().getString(i), i2);
    }

    public static void c(Context context, String str, int i) {
        d.removeCallbacks(e);
        Toast toast = c;
        if (toast != null) {
            toast.setText(str);
        } else {
            c = Toast.makeText(context, str, i);
        }
        d.postDelayed(e, i == 0 ? f14891a : f14892b);
        c.show();
    }
}
