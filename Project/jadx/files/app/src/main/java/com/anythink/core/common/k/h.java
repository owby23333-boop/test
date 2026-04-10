package com.anythink.core.common.k;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final String a = "CommonUtils";
    public static char[] b = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static char[] f7704d = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static char[] f7705e = {'.', 'X'};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f7706f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f7707g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f7708h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f7709i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f7710j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f7711k = 7;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f7712l = 14;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f7713m = 19;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f7714n = 16;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f7715o = 26;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static char[] f7703c = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};

    /* JADX INFO: renamed from: com.anythink.core.common.k.h$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnSystemUiVisibilityChangeListener {
        final /* synthetic */ View a;

        AnonymousClass1(View view) {
            this.a = view;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public final void onSystemUiVisibilityChange(int i2) {
            if ((i2 & 2) == 0) {
                h.a(this.a);
            }
        }
    }

    public static <T extends String> boolean a(T t2) {
        return t2 == null || t2.length() == 0;
    }

    public static <T extends String> boolean b(T t2) {
        return t2 != null && t2.length() > 0;
    }

    public static Map<String, Object> c(String str) {
        HashMap map = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static int[] b(Context context, String str) {
        int i2;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
            if (field.getName().equals(str)) {
                return (int[]) field.get(null);
            }
            return null;
        }
        return null;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean a(String str, Context context) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                StringBuilder sb = new StringBuilder("Permission ");
                sb.append(str);
                sb.append(" is granted");
                return true;
            }
            StringBuilder sb2 = new StringBuilder("Permission ");
            sb2.append(str);
            sb2.append(" is NOT granted");
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static int b(Context context, String str, String str2) {
        int i2;
        String str3 = str + "_" + str2;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        for (Class<?> cls : Class.forName(context.getPackageName() + ".R").getClasses()) {
            if (cls.getSimpleName().equals("styleable")) {
                for (Field field : cls.getFields()) {
                    if (field.getName().equals(str3)) {
                        return ((Integer) field.get(null)).intValue();
                    }
                    return 0;
                }
            }
        }
        return 0;
    }

    public static int a(Context context, String str, String str2) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getIdentifier("anythink_".concat(String.valueOf(str)), str2, context.getPackageName());
    }

    public static String[] a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            String[] strArr = new String[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                strArr[i2] = jSONArray.optString(i2);
            }
            return strArr;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void a(Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(4870);
            decorView.setOnSystemUiVisibilityChangeListener(new AnonymousClass1(decorView));
        }
    }

    private static View.OnSystemUiVisibilityChangeListener b(View view) {
        return new AnonymousClass1(view);
    }

    public static int b(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(a(f7706f))).getMethod(String.valueOf(a(f7708h)), String.class, Integer.TYPE).invoke(Class.forName(String.valueOf(a(f7707g))).getMethod(String.valueOf(a(f7709i)), new Class[0]).invoke(context, new Object[0]), str, 8192);
        } catch (Throwable unused) {
            return null;
        }
    }

    static void a(View view) {
        view.setSystemUiVisibility(4870);
    }

    public static boolean a() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted("http://www.toponad.com");
            }
            if (Build.VERSION.SDK_INT >= 23) {
                return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(Object[] objArr) {
        int length;
        if (objArr == null || objArr.length - 1 == -1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            sb.append(String.valueOf(objArr[i2]));
            if (i2 == length) {
                return sb.toString();
            }
            sb.append(",");
            i2++;
        }
    }

    public static synchronized boolean a(Context context, String str) {
        boolean z2;
        z2 = false;
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (b(str, context) != null) {
                        z2 = true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return z2;
    }

    private static final char[] a(int i2) {
        StringBuilder sb;
        if (i2 == 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(b, f7711k)));
            sb.append(f7705e[f7710j]);
            sb.append(String.valueOf(Arrays.copyOfRange(b, f7711k, f7712l)));
            sb.append(f7705e[f7710j]);
            sb.append(String.valueOf(Arrays.copyOfRange(b, f7712l, f7714n)));
            sb.append(f7705e[f7710j]);
            sb.append(String.valueOf(f7703c));
        } else if (i2 == 1) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(b, f7711k)));
            sb.append(f7705e[f7710j]);
            sb.append(String.valueOf(Arrays.copyOfRange(b, f7711k, f7712l)));
            sb.append(f7705e[f7710j]);
            sb.append(String.valueOf(Arrays.copyOfRange(b, f7713m, f7715o)));
        } else if (i2 == 2) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(b, f7714n, f7713m)));
            sb.append(String.valueOf(f7704d));
        } else if (i2 != 3) {
            sb = null;
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(b, f7714n, f7713m)));
            sb.append(String.valueOf(f7703c));
        }
        return sb.toString().toCharArray();
    }
}
