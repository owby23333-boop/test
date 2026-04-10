package com.bytedance.sdk.component.adexpress.a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.sdk.component.utils.tb;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private static boolean z;

    public static int z(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    public static float z(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().getContext();
        }
        return (f * gc(context)) + 0.5f;
    }

    public static int g(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().getContext();
        }
        float fGc = gc(context);
        if (fGc <= 0.0f) {
            fGc = 1.0f;
        }
        return (int) ((f / fGc) + 0.5f);
    }

    public static float dl(Context context, float f) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().getContext();
        }
        return f * gc(context);
    }

    private static float gc(Context context) {
        try {
            if (z) {
                context.getClassLoader().loadClass("android.util.DisplayMetrics").getDeclaredMethod("getDeviceDensity", new Class[0]).setAccessible(true);
                return ((Integer) r1.invoke(r0, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int z(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int g(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int dl(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static String a(Context context) {
        String language;
        try {
            Locale locale = tb.z(context).getConfiguration().getLocales().get(0);
            language = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    language = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            language = "";
        }
        return z(language);
    }

    private static String z(String str) {
        str.hashCode();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }
}
