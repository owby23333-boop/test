package com.yuewen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.alibaba.android.arouter.utils.Consts;
import com.duokan.database.DBClient;
import com.duokan.reader.BaseEnv;
import com.google.gson.Gson;
import com.yuewen.rt2;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import miuix.popupwidget.widget.GuidePopupWindow;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class lp2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f13963a;

    public static long A(int i, String str, int i2, String str2) {
        String str3 = String.format("%s&%s&%s&%s&%s", BaseEnv.get().b0(), Integer.valueOf(i), str, str2, Integer.valueOf(i2));
        int length = str3.length();
        long jCharAt = 2166136261L;
        for (int i3 = 0; i3 < length; i3++) {
            jCharAt = ((jCharAt * 131) + ((long) str3.charAt(i3))) % 4294967291L;
        }
        return jCharAt;
    }

    public static long B() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(5, 1);
        return calendar.getTimeInMillis();
    }

    public static int C(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int D(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static Rect E(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight());
    }

    public static boolean F(Context context) {
        return DBClient.d.equals(r(context));
    }

    public static boolean G(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() == 0;
    }

    public static boolean H() {
        return Build.MANUFACTURER.contains("Xiaomi");
    }

    public static boolean I(String str) {
        return str != null && str.matches("\\d+(?:\\.\\d+)?");
    }

    public static boolean J() {
        return !Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean K(String str, String str2) {
        return new File(str).equals(new File(str2));
    }

    public static boolean L(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void M(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception unused) {
        }
    }

    public static String N() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(String.format("%02x", Integer.valueOf(bArr[i] & 255)));
        }
        return sb.toString();
    }

    public static String O(String str, char c, String str2) {
        if (str == null || str.indexOf(c) == -1) {
            return null;
        }
        return str.replaceFirst(new String(new char[]{c}), str2);
    }

    public static <T extends Serializable> JSONObject P(T t) {
        if (t == null) {
            return new JSONObject();
        }
        try {
            return new JSONObject(new Gson().toJson(t).toString());
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static <T extends Serializable> String Q(T t) {
        return t == null ? new JSONObject().toString() : new Gson().toJson(t).toString();
    }

    public static void R(Context context, View view, String str) {
        if (context == null || view == null) {
            return;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(rt2.g.ls);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(rt2.g.Oo);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(rt2.g.Vn);
        Rect rectE = E(view);
        GuidePopupWindow guidePopupWindow = new GuidePopupWindow(context);
        TextView textView = new TextView(context);
        textView.setTextSize(0, dimensionPixelSize3);
        textView.setTextColor(resources.getColor(rt2.f.lb));
        textView.setText(str);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        textView.setGravity(17);
        guidePopupWindow.setShowDuration(2000);
        guidePopupWindow.setOutsideTouchable(true);
        guidePopupWindow.setContentView(textView, layoutParams);
        guidePopupWindow.setArrowMode(18);
        guidePopupWindow.show(view, rectE.left, 0, true);
    }

    public static Rect S(View view, Rect rect) {
        Rect rect2 = new Rect(rect);
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            rect2.offset(iArr[0], iArr[1]);
        }
        return rect2;
    }

    public static void a(View view, float f, float f2, float f3, float f4, long j, Boolean bool, Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(f, f2, f3, f4);
        translateAnimation.setDuration(j);
        translateAnimation.setFillAfter(bool.booleanValue());
        translateAnimation.setAnimationListener(animationListener);
        view.startAnimation(translateAnimation);
    }

    public static String b(long j) {
        return c(j, "0.00K");
    }

    public static String c(long j, String str) {
        if (j == 0) {
            return str;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        float f = j / 1024.0f;
        if (f > 1048576.0f) {
            return decimalFormat.format(f / 1048576.0f).toString() + "G";
        }
        if (f > 1024.0f) {
            return decimalFormat.format(f / 1024.0f).toString() + "M";
        }
        return decimalFormat.format(f).toString() + "K";
    }

    public static boolean d(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean e(ConnectivityManager connectivityManager) {
        return connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean f(Context context) {
        if (!ConnectivityManager.isNetworkTypeValid(1)) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return e(connectivityManager) || d(connectivityManager);
    }

    public static void g(View view) {
        try {
            View.class.getMethod("setLayerType", Integer.TYPE, Paint.class).invoke(view, 1, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            file.delete();
            return true;
        }
        if (!file.isDirectory()) {
            return true;
        }
        for (File file2 : file.listFiles()) {
            h(file2.getAbsolutePath());
        }
        file.delete();
        return true;
    }

    public static <T extends Serializable> T i(JSONObject jSONObject, T t, Class<T> cls) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                return (T) new Gson().fromJson(jSONObject.toString(), (Class) cls);
            } catch (Exception unused) {
            }
        }
        return t;
    }

    public static <T extends Serializable> T j(JSONObject jSONObject, Class<T> cls) {
        return (T) i(jSONObject, null, cls);
    }

    public static <T extends Serializable> T k(String str, T t, Class<T> cls) {
        if (TextUtils.isEmpty(str)) {
            return t;
        }
        try {
            return (T) new Gson().fromJson(str, (Class) cls);
        } catch (Exception unused) {
            return t;
        }
    }

    public static <T extends Serializable> T l(String str, Class<T> cls) {
        return (T) k(str, null, cls);
    }

    public static int m(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void n(Context context, OutputStream outputStream, int i) throws Throwable {
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = context.getResources().openRawResource(i);
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStreamOpenRawResource.read(bArr);
                if (i2 < 0) {
                    try {
                        inputStreamOpenRawResource.close();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                outputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th) {
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (Throwable unused2) {
                }
            }
            throw th;
        }
    }

    public static String[] o() {
        int iA = (int) (c04.a() / 1000);
        return new String[]{"_t", String.valueOf(iA), "_c", String.valueOf(s(iA))};
    }

    public static String[] p(String str, int i) {
        int iA = (int) (c04.a() / 1000);
        String strN = N();
        return new String[]{"_t", String.valueOf(iA), "nonce", strN, "_c", String.valueOf(A(iA, str, i, strN))};
    }

    public static String q(String str, String str2) {
        if (str == null) {
            return str2;
        }
        File file = new File(str);
        if (!file.exists()) {
            return str2;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.startsWith("/sdcard")) {
            String str3 = "/mnt" + absolutePath;
            if (K(absolutePath, str)) {
                return str3;
            }
        }
        return absolutePath;
    }

    public static String r(Context context) {
        if (f13963a == null) {
            f13963a = (String) z(context, "UMENG_CHANNEL");
        }
        return f13963a;
    }

    public static int s(int i) {
        String str = BaseEnv.get().b0() + com.alipay.sdk.m.w.a.p + i;
        int length = str.length();
        int iCharAt = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iCharAt = ((iCharAt * 131) + str.charAt(i2)) % 65536;
        }
        return iCharAt;
    }

    public static String t(Context context) {
        return (String) z(context, "DK_DIST_CHANNEL");
    }

    public static String u(String str) {
        int iLastIndexOf = str.lastIndexOf(Consts.DOT);
        return (iLastIndexOf == -1 || iLastIndexOf >= str.length() + (-1)) ? "" : str.substring(iLastIndexOf + 1).toLowerCase();
    }

    public static String v(String str) {
        int iLastIndexOf = str.lastIndexOf("/");
        int iLastIndexOf2 = str.lastIndexOf(Consts.DOT);
        return (iLastIndexOf == -1 || iLastIndexOf2 == -1 || iLastIndexOf2 <= iLastIndexOf) ? str : str.substring(iLastIndexOf + 1, iLastIndexOf2);
    }

    public static String w(String str) {
        int iLastIndexOf = str.lastIndexOf("/") + 1;
        int iLastIndexOf2 = str.lastIndexOf(Consts.DOT);
        return (iLastIndexOf2 == -1 || iLastIndexOf2 <= iLastIndexOf) ? "" : str.substring(iLastIndexOf, iLastIndexOf2);
    }

    public static String x(String str) {
        int iLastIndexOf = str.lastIndexOf(Consts.DOT);
        return (iLastIndexOf == -1 || iLastIndexOf >= str.length() + (-1)) ? str : str.substring(0, iLastIndexOf);
    }

    public static long y(String str) {
        return new File(str).length();
    }

    public static Object z(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
