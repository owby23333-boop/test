package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.umeng.analytics.pro.o;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends g {
    public static final String a = "SameTools";
    static List<String> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static char[] f10714c = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static char[] f10715d = {'.', 'X'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f10716e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f10717f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f10718g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f10719h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f10720i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f10721j = 7;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f10722k = 14;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f10723l = 19;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static int f10724m = 16;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f10725n = 26;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f10726o = 1;

    public static int a(int i2) {
        if ((i2 > 100 && i2 < 199) || i2 == 2) {
            return 1;
        }
        if ((i2 <= 200 || i2 >= 299) && i2 != 4) {
            return (i2 <= 500 || i2 >= 599) ? -1 : 5;
        }
        return 2;
    }

    public static <T extends String> boolean a(T t2) {
        return t2 == null || t2.length() == 0;
    }

    public static boolean b(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static float c(Context context) {
        if (context == null) {
            return 2.5f;
        }
        try {
            float f2 = context.getResources().getDisplayMetrics().density;
            if (f2 == 0.0f) {
                return 2.5f;
            }
            return f2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 2.5f;
        }
    }

    public static int d(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int e(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return k(context).heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int f(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return k(context).widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int g(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private static <T extends String> boolean h(T t2) {
        return t2 != null && t2.length() > 0;
    }

    public static int i(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", DispatchConstants.ANDROID) != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 0;
    }

    public static int j(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo currentWebViewPackage = Build.VERSION.SDK_INT >= 26 ? WebView.getCurrentWebViewPackage() : context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.a aVarB = com.anythink.expressad.d.b.b();
            if (aVarB == null) {
                com.anythink.expressad.d.b.a();
                aVarB = com.anythink.expressad.d.b.c();
            }
            if (currentWebViewPackage == null || TextUtils.isEmpty(currentWebViewPackage.versionName) || !currentWebViewPackage.versionName.equals("77.0.3865.92")) {
                return aVarB.P();
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static DisplayMetrics k(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            return displayMetrics;
        } catch (Throwable th) {
            th.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }

    private static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private static <T> boolean a(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static String c(String str) {
        try {
            return w.b(str) ? URLEncoder.encode(str, com.anythink.expressad.foundation.g.a.bN) : "";
        } catch (Throwable th) {
            o.b(a, th.getMessage(), th);
            return "";
        }
    }

    public static int a(Context context, float f2) {
        float f3 = 2.5f;
        if (context != null) {
            try {
                float f4 = context.getResources().getDisplayMetrics().density;
                if (f4 != 0.0f) {
                    f3 = f4;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static int b(Context context, float f2) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f2 * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean e(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            r0 = 1
            if (r4 == 0) goto L44
            java.lang.String r2 = "dyview"
            java.lang.String r2 = r4.getQueryParameter(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r3 == 0) goto L21
            java.lang.String r2 = "view"
            java.lang.String r2 = r4.getQueryParameter(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
        L21:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L48
            if (r3 != 0) goto L32
            r3 = -1
            int r3 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L46
        L2c:
            int r3 = r3 % 2
            if (r3 != 0) goto L32
            r2 = 1
            goto L33
        L32:
            r2 = 0
        L33:
            java.lang.String r3 = "natmp"
            java.lang.String r4 = r4.getQueryParameter(r3)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L54
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L42 java.lang.Throwable -> L54
            if (r4 != 0) goto L40
            goto L45
        L40:
            r0 = r2
            goto L45
        L42:
            r4 = move-exception
            goto L4a
        L44:
            r0 = 0
        L45:
            return r0
        L46:
            r2 = 0
            goto L54
        L48:
            r4 = move-exception
            r2 = 0
        L4a:
            java.lang.String r0 = "SameTools"
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L54
            com.anythink.expressad.foundation.h.o.d(r0, r4)     // Catch: java.lang.Throwable -> L54
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.h.t.e(java.lang.String):boolean");
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return false;
            }
            String queryParameter = uri.getQueryParameter(com.anythink.expressad.a.Z);
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("0");
        } catch (Exception e2) {
            o.d(a, e2.getMessage());
            return false;
        }
    }

    public static int g(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return -1;
            }
            String queryParameter = uri.getQueryParameter(com.anythink.expressad.a.C);
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = uri.getQueryParameter(com.anythink.expressad.a.B);
            }
            if (TextUtils.isEmpty(queryParameter)) {
                return -1;
            }
            try {
                return Integer.parseInt(queryParameter);
            } catch (Exception unused) {
                return -1;
            }
        } catch (Exception e2) {
            o.d(a, e2.getMessage());
            return -1;
        }
    }

    private static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                Uri uri = Uri.parse(str);
                if (uri != null) {
                    return !TextUtils.isEmpty(uri.getQueryParameter(com.anythink.expressad.a.C));
                }
                return false;
            } catch (Exception e2) {
                o.d(a, e2.getMessage());
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int a() {
        int i2 = f10726o;
        f10726o = i2 + 1;
        return i2;
    }

    public static double b(String str) {
        try {
            return !TextUtils.isEmpty(str) ? Double.parseDouble(str) : PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        } catch (Exception e2) {
            e2.printStackTrace();
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
    }

    public static boolean a(String str, Context context) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            if (uri == null) {
                return false;
            }
            String queryParameter = uri.getQueryParameter(com.anythink.expressad.a.f7982z);
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("1");
        } catch (Exception e2) {
            o.d(a, e2.getMessage());
            return false;
        }
    }

    public static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                return cVar.N() == 1;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(b(f10716e))).getMethod(String.valueOf(b(f10718g)), String.class, Integer.TYPE).invoke(Class.forName(String.valueOf(b(f10717f))).getMethod(String.valueOf(b(f10719h)), new Class[0]).invoke(context, new Object[0]), str, 8192);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        try {
            if (obj instanceof String) {
                return Integer.parseInt((String) obj);
            }
            return 0;
        } catch (Throwable th) {
            o.b(a, th.getMessage(), th);
            return 0;
        }
    }

    public static double a(Double d2) {
        try {
            String str = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d2);
            return w.b(str) ? Double.parseDouble(str) : PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        } catch (Exception e2) {
            e2.printStackTrace();
            return PangleAdapterUtils.CPM_DEFLAUT_VALUE;
        }
    }

    private static final char[] b(int i2) {
        StringBuilder sb;
        if (i2 == 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(s.b, f10721j)));
            sb.append(f10715d[f10720i]);
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, f10721j, f10722k)));
            sb.append(f10715d[f10720i]);
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, f10722k, f10724m)));
            sb.append(f10715d[f10720i]);
            sb.append(String.valueOf(r.f10698c));
        } else if (i2 == 1) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(s.b, f10721j)));
            sb.append(f10715d[f10720i]);
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, f10721j, f10722k)));
            sb.append(f10715d[f10720i]);
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, f10723l, f10725n)));
        } else if (i2 == 2) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, f10724m, f10723l)));
            sb.append(String.valueOf(f10714c));
        } else if (i2 != 3) {
            sb = null;
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(s.b, f10724m, f10723l)));
            sb.append(String.valueOf(r.f10698c));
        }
        return sb.toString().toCharArray();
    }

    public static void a(View view) {
        if (view == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                view.setSystemUiVisibility(o.a.f19769f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static List<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String strOptString = jSONArray.optString(i2);
                if (w.b(strOptString)) {
                    arrayList.add(strOptString);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            o.b(a, th.getMessage(), th);
            return null;
        }
    }

    private static boolean b(List list) {
        return !(list == null || list.isEmpty());
    }

    private static <T> boolean b(T[] tArr) {
        return !(tArr == null || tArr.length == 0);
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

    private static synchronized String a(String str, Context context, String str2) {
        StringBuilder sb;
        try {
            Set<String> queryParameterNames = Uri.parse(str).getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                sb = new StringBuilder("&rtins_type=");
            } else {
                sb = new StringBuilder("?rtins_type=");
            }
        } catch (Exception unused) {
            sb = new StringBuilder("&rtins_type=");
        }
        try {
            if (b(str2, context) != null) {
                sb.append(1);
            } else {
                sb.append(2);
            }
        } catch (Exception unused2) {
            sb.append(0);
        }
        return sb.toString();
    }

    public static synchronized String a(Context context, String str, String str2) {
        StringBuilder sb;
        sb = new StringBuilder(str2);
        try {
            sb.append(a(str2, context, str));
        } catch (Exception unused) {
        }
        return sb.toString();
    }
}
