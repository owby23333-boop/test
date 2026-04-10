package com.kwad.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class az {
    static final String TAG = "az";

    static void a(Context context, String str, String str2, int i2) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().putInt(str2, i2).apply();
    }

    static void a(Context context, String str, String str2, long j2) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().putLong(str2, j2).apply();
    }

    static void a(Context context, String str, String str2, String str3, boolean z2) {
        if (context == null) {
            return;
        }
        if (z2 && !com.kwad.sdk.core.kwai.c.bI(str3)) {
            str3 = com.kwad.sdk.core.kwai.c.bG(str3);
        }
        context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }

    private static void a(SharedPreferences.Editor editor, String str, Object obj) {
        if (str != null) {
            if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
                return;
            }
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            }
            if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else if (obj instanceof String) {
                editor.putString(str, String.valueOf(obj));
            }
        }
    }

    static <T> void a(String str, Map<String, T> map) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            try {
                a(editorEdit, entry.getKey(), entry.getValue());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.e(TAG, Log.getStackTraceString(th));
            }
        }
        editorEdit.apply();
    }

    static void ab(String str, String str2) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return;
        }
        j(context, str, str2);
    }

    public static void aq(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    static int b(Context context, String str, String str2, int i2) {
        return context == null ? i2 : context.getSharedPreferences(str, 0).getInt(str2, i2);
    }

    static long b(Context context, String str, String str2, long j2) {
        return context == null ? j2 : context.getSharedPreferences(str, 0).getLong(str2, j2);
    }

    static void b(String str, String str2, int i2) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return;
        }
        a(context, str, str2, i2);
    }

    static int c(String str, String str2, int i2) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return 0;
        }
        return b(context, str, str2, 0);
    }

    static void c(Context context, @NonNull String str, @NonNull String str2, String str3) {
        if (context == null) {
            return;
        }
        a(context, str, str2, str3, false);
    }

    static void c(Context context, String str, String str2, boolean z2) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().putBoolean(str2, z2).apply();
    }

    static String d(Context context, String str, String str2, String str3) {
        String string;
        return (context == null || (string = context.getSharedPreferences(str, 0).getString(str2, str3)) == null || TextUtils.isEmpty(string)) ? str3 : (TextUtils.equals(string, str3) || !com.kwad.sdk.core.kwai.c.bI(string)) ? string : com.kwad.sdk.core.kwai.c.bH(string);
    }

    static boolean d(Context context, String str, String str2, boolean z2) {
        return context == null ? z2 : context.getSharedPreferences(str, 0).getBoolean(str2, z2);
    }

    static SharedPreferences ew(String str) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
            return null;
        }
    }

    private static void g(String str, String str2, String str3) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return;
        }
        c(context, str, str2, str3);
    }

    static String h(String str, String str2, String str3) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        return context == null ? str3 : d(context, str, str2, str3);
    }

    static void h(String str, String str2, boolean z2) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return;
        }
        c(context, str, str2, true);
    }

    static void i(String str, String str2, String str3) {
        if (com.kwad.sdk.core.kwai.c.bI(str)) {
            return;
        }
        g(str2, str3, com.kwad.sdk.core.kwai.c.bG(str));
    }

    static boolean i(String str, String str2, boolean z2) {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return false;
        }
        return d(context, str, str2, false);
    }

    static void j(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences(str, 0).edit().remove(str2).apply();
    }
}
