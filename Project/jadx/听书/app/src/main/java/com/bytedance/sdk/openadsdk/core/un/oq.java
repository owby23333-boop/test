package com.bytedance.sdk.openadsdk.core.un;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.media3.common.C;
import com.bytedance.sdk.component.widget.SSWebView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class oq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile float f1382a = -1.0f;
    private static volatile int dl = -1;
    private static int e = 13;
    private static volatile float g = -1.0f;
    private static volatile int gc = -1;
    private static float gz = 0.0f;
    private static volatile int m = -1;
    public static volatile int z = -1;

    public interface z {
        void z(View view);
    }

    public static int g(float f, float f2) {
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((f2 / f) + 0.5f);
    }

    public static int z(float f, float f2) {
        return (int) ((f2 * f) + 0.5f);
    }

    private static boolean z(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    private static boolean a() {
        return g < 0.0f || dl < 0 || f1382a < 0.0f || gc < 0 || m < 0;
    }

    private static float js(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static void z(Context context) {
        Resources resources;
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        }
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (a()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            g = displayMetrics.density;
            dl = displayMetrics.densityDpi;
            f1382a = displayMetrics.scaledDensity;
            gc = displayMetrics.widthPixels;
            m = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (gc > m) {
                    int i = gc;
                    gc = m;
                    m = i;
                    return;
                }
                return;
            }
            if (gc < m) {
                int i2 = gc;
                gc = m;
                m = i2;
            }
        }
    }

    public static float z(Context context, float f) {
        z(context);
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static int g(Context context, float f) {
        z(context);
        float fE = e(context);
        if (fE <= 0.0f) {
            fE = 1.0f;
        }
        return (int) ((f / fE) + 0.5f);
    }

    public static int dl(Context context, float f) {
        z(context);
        return (int) ((f * js(context)) + 0.5f);
    }

    public static int a(Context context, float f) {
        z(context);
        float fJs = js(context);
        if (fJs <= 0.0f) {
            fJs = 1.0f;
        }
        return (int) ((f / fJs) + 0.5f);
    }

    public static int[] g(Context context) {
        WindowManager windowManager = null;
        if (context == null) {
            return null;
        }
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Exception unused) {
        }
        int[] iArr = new int[2];
        if (windowManager != null) {
            try {
                if (Build.VERSION.SDK_INT >= 30) {
                    Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
                    iArr[0] = bounds.width();
                    iArr[1] = bounds.height();
                } else {
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    iArr[0] = displayMetrics.widthPixels;
                    iArr[1] = displayMetrics.heightPixels;
                }
            } catch (Throwable unused2) {
            }
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int[] dl(Context context) {
        z(context);
        return new int[]{gc, m};
    }

    public static int a(Context context) {
        z(context);
        return gc;
    }

    public static int gc(Context context) {
        z(context);
        return m;
    }

    public static float m(Context context) {
        z(context);
        return g;
    }

    public static float e(Context context) {
        z(context);
        return f1382a;
    }

    public static int gz(Context context) {
        z(context);
        return dl;
    }

    public static void z(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i;
        rect.bottom += i2;
        rect.left -= i3;
        rect.right += i4;
        ((View) view.getParent()).setTouchDelegate(new com.bytedance.sdk.component.utils.e(rect, view));
    }

    public static int[] z(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] g(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] dl(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static void z(View view, int i) {
        if (view == null || view.getVisibility() == i || !z(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static void z(View view, float f) {
        if (view == null) {
            return;
        }
        view.setAlpha(f);
    }

    public static boolean a(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean z(SSWebView sSWebView) {
        if (sSWebView == null || !sSWebView.canGoBack()) {
            return false;
        }
        sSWebView.goBack();
        return true;
    }

    public static void z(final com.bytedance.sdk.component.i.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.oq.1
            @Override // java.lang.Runnable
            public void run() {
                WebSettings settings;
                WebView webView = dlVar.getWebView();
                if (webView == null || (settings = webView.getSettings()) == null) {
                    return;
                }
                settings.setTextZoom(100);
            }
        });
    }

    public static void z(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void g(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        z(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    private static void z(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static boolean z() {
        try {
            return !((KeyguardManager) com.bytedance.sdk.openadsdk.core.zw.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject z(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int i = 1;
            if (!jSONObject.has("app_scene")) {
                jSONObject.put("app_scene", com.bytedance.sdk.openadsdk.core.uy.ls().z() ? 1 : 0);
            }
            if (!jSONObject.has("lock_scene")) {
                if (!(!z())) {
                    i = 0;
                }
                jSONObject.put("lock_scene", i);
            }
            if (str != null && !str.isEmpty() && !jSONObject.has("auto_show_check")) {
                jSONObject.put("auto_show_check", str);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.dl("addShowScene error " + th.toString());
        }
        return jSONObject;
    }

    public static void gc(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.un.oq.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                oq.z(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static void m(View view) {
        if (view == null) {
            return;
        }
        z(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.un.oq.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static int fo(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int uy(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float kb(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        }
        try {
            if (context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android") > 0) {
                return context.getApplicationContext().getResources().getDimensionPixelSize(r1);
            }
            return 0.0f;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.g("TTUtils", "Get StatusBarHeight failed:" + th.getMessage());
            return 0.0f;
        }
    }

    public static void z(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            g(activity);
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
    }

    public static void g(Activity activity) {
        try {
            dl(activity);
            activity.getWindow().addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
    }

    public static void dl(Activity activity) {
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(com.umeng.analytics.pro.i.b);
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
    }

    private static boolean uy(Activity activity) {
        try {
            if (activity.getWindow().getDecorView().getHeight() > 0 && activity.getWindow().getDecorView().getWidth() > 0) {
                if (fo((Context) activity) - activity.getWindow().getDecorView().getHeight() <= 0) {
                    return uy((Context) activity) - activity.getWindow().getDecorView().getWidth() > 0;
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean a(Activity activity) {
        return m(activity) || z("ro.miui.notch", activity) == 1 || wp(activity) || i(activity) || pf(activity) || ls(activity) || uy(activity) || v(activity);
    }

    public static void gc(Activity activity) {
        if (dl()) {
            return;
        }
        try {
            final WeakReference weakReference = new WeakReference(activity);
            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.un.oq.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo("check_notch") { // from class: com.bytedance.sdk.openadsdk.core.un.oq.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Activity activity2 = (Activity) weakReference.get();
                                if (activity2 != null && !oq.dl()) {
                                    oq.z = oq.a(activity2) ? 1 : 0;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean g() {
        return z == 1 || z == -1;
    }

    public static boolean dl() {
        return z != -1;
    }

    public static void z(View view, View view2) {
        if (view == null || view2 == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28 && gz == 0.0f) {
                WindowInsets rootWindowInsets = view.getRootWindowInsets();
                if ((rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null) {
                    gz = r3.getSafeInsetTop();
                }
            }
            if (gz == 0.0f) {
                return;
            }
            float fMax = Math.max(kb(view2.getContext()), gz);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + fMax);
            }
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + fMax);
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).topMargin = (int) (r1.topMargin + fMax);
            }
            view2.setLayoutParams(layoutParams);
        } catch (Throwable unused) {
        }
    }

    public static boolean m(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return false;
        }
    }

    public static int z(String str, Activity activity) {
        com.bytedance.sdk.component.a.kb kbVar;
        if (!sy.ls() || (kbVar = (com.bytedance.sdk.component.a.kb) com.bytedance.sdk.openadsdk.ats.dl.z("system_info")) == null) {
            return 0;
        }
        return kbVar.getInt(str);
    }

    public static boolean wp(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean i(Context context) {
        try {
            if ("V1938CT".equals(uy.g())) {
                return false;
            }
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean v(Context context) {
        String strUy = eo.uy("com.kllk.feature.screen.heteromorphism");
        if (context == null || context.getPackageManager() == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature(strUy);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean pf(Context context) {
        String strG = uy.g();
        return strG.equals("IN2010") || strG.equals("IN2020") || strG.equals("KB2000");
    }

    public static boolean ls(Context context) {
        return Build.MANUFACTURER.equals("samsung");
    }

    public static void z(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.wp.a("OnclickListener ", str + " is null , can not set OnClickListener !!!");
        } else {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void z(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.wp.a("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
        } else {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public static void z(final View view, final z zVar) {
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.un.oq.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z(view);
                }
            }
        });
    }

    public static void z(View view, final com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (view == null || naVar == null) {
            return;
        }
        view.setClickable(true);
        view.setFocusable(true);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.un.oq.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                m.z(com.bytedance.sdk.openadsdk.core.zw.getContext(), naVar);
            }
        });
    }

    public static void z(TextView textView, String str, Context context) {
        if (textView == null || TextUtils.isEmpty(str) || context == null) {
            return;
        }
        textView.setText(str);
        textView.setTextSize(2, 8.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#1F161823"));
        gradientDrawable.setCornerRadius(dl(context, 3.0f));
        textView.setBackgroundDrawable(gradientDrawable);
        textView.setTextColor(com.bytedance.sdk.component.utils.tb.uy(context, "tt_adx_logo_desc"));
        textView.setGravity(17);
        textView.setPadding(dl(context, 2.0f), dl(context, 3.0f), dl(context, 2.0f), dl(context, 3.0f));
    }

    public static void z(TextView textView, com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (textView == null || naVar == null) {
            z(textView);
            return;
        }
        String strSa = naVar.sa();
        if (TextUtils.isEmpty(strSa)) {
            z(textView);
            z((View) textView, naVar);
        } else {
            z(textView, strSa, com.bytedance.sdk.openadsdk.core.zw.getContext());
        }
    }

    public static void z(TextView textView, com.bytedance.sdk.openadsdk.core.iq.na naVar, int i, int i2) {
        if (textView == null || naVar == null) {
            z(textView, i, i2);
            return;
        }
        String strSa = naVar.sa();
        if (TextUtils.isEmpty(strSa)) {
            z(textView, i, i2);
            z((View) textView, naVar);
        } else {
            z(textView, strSa, com.bytedance.sdk.openadsdk.core.zw.getContext());
        }
    }

    public static Bitmap e(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        view.draw(canvas);
        canvas.save();
        return bitmapCreateBitmap;
    }

    private static void z(TextView textView) {
        if (textView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = dl(com.bytedance.sdk.openadsdk.core.zw.getContext(), 32.0f);
        layoutParams.height = dl(com.bytedance.sdk.openadsdk.core.zw.getContext(), 14.0f);
        textView.setLayoutParams(layoutParams);
    }

    private static void z(TextView textView, int i, int i2) {
        if (i <= 0) {
            i = 32;
        }
        if (i2 <= 0) {
            i2 = 14;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = dl(com.bytedance.sdk.openadsdk.core.zw.getContext(), i);
        layoutParams.height = dl(com.bytedance.sdk.openadsdk.core.zw.getContext(), i2);
        textView.setLayoutParams(layoutParams);
    }

    public static void e(Activity activity) {
        try {
            kb(activity);
        } catch (Throwable unused) {
        }
    }

    public static void gz(Activity activity) {
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(activity, null);
        } catch (Throwable unused) {
        }
    }

    private static void kb(Activity activity) {
        Object objInvoke;
        try {
            Method declaredMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
            declaredMethod.setAccessible(true);
            objInvoke = declaredMethod.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            objInvoke = null;
        }
        try {
            Class<?> cls = null;
            for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
                if (cls2.getSimpleName().startsWith("TranslucentConversionListener")) {
                    cls = cls2;
                }
            }
            Method declaredMethod2 = Activity.class.getDeclaredMethod("convertToTranslucent", cls, ActivityOptions.class);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(activity, null, objInvoke);
        } catch (Throwable unused2) {
        }
    }

    public static void g(View view, final float f) {
        if (view != null && f > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.un.oq.7
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            view.setClipToOutline(true);
        }
    }

    @Deprecated
    public static void z(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Toast toast = new Toast(context);
        LinearLayout linearLayout = new LinearLayout(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.z.z.g().z(context, 4.0f));
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iDl = dl(context, 20.0f);
        int iDl2 = dl(context, 11.0f);
        textView.setPadding(iDl, iDl2, iDl, iDl2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(e);
        textView.setGravity(17);
        textView.setText(str);
        linearLayout.addView(textView);
        toast.setView(linearLayout);
        toast.setGravity(17, 0, 0);
        toast.setDuration(i);
        toast.show();
    }

    public static TextView p(Context context) {
        if (context == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.z.z.g().z(context, 4.0f));
        TextView textView = new TextView(context);
        textView.setClickable(false);
        textView.setFocusable(false);
        textView.setBackground(gradientDrawable);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) (((double) gc(context)) * (-0.3d));
        int iDl = dl(context, 20.0f);
        int iDl2 = dl(context, 11.0f);
        textView.setPadding(iDl, iDl2, iDl, iDl2);
        textView.setLayoutParams(layoutParams);
        textView.setTextColor(-1);
        textView.setTextSize(e);
        textView.setGravity(17);
        return textView;
    }

    public static void gz(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static boolean fo(Activity activity) {
        return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static int fv(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
