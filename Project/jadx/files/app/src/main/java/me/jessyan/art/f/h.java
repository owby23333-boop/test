package me.jessyan.art.f;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import me.jessyan.art.R$id;

/* JADX INFO: compiled from: StatusBarUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    private static final int a = R$id.statusbarutil_translucent_view;

    public static void a(@NonNull Activity activity, @ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            activity.getWindow().clearFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().setStatusBarColor(a(i2, i3));
        } else if (i4 >= 19) {
            activity.getWindow().addFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
            a((ViewGroup) activity.getWindow().getDecorView(), i2, i3);
            a(activity, true);
        }
    }

    public static void b(@NonNull Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            activity.getWindow().setStatusBarColor(0);
            a(activity.getWindow(), false);
        } else if (i2 >= 21) {
            activity.getWindow().setStatusBarColor(Color.parseColor("#60000000"));
        }
    }

    public static void c(@NonNull Activity activity, @ColorInt int i2) {
        a(activity, i2, 0);
    }

    public static void d(@NonNull Activity activity, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            activity.getWindow().setStatusBarColor(i2);
            a(activity.getWindow(), false);
        } else if (i3 >= 21) {
            activity.getWindow().setStatusBarColor(Color.parseColor("#60000000"));
        }
    }

    public static void c(@NonNull Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            activity.getWindow().setStatusBarColor(0);
            activity.getWindow().getDecorView().setSystemUiVisibility(1280);
        } else if (i2 >= 19) {
            activity.getWindow().setFlags(DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS, DownloadExpSwitchCode.BACK_BUGFIX_SIGBUS);
        }
    }

    @RequiresApi(23)
    private static void b(Window window, boolean z2) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(z2 ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    private static void d(Window window, boolean z2) {
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z2 ? i2 : 0);
            objArr[1] = Integer.valueOf(i2);
            method.invoke(window, objArr);
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, @NonNull View view) {
        ViewGroup.LayoutParams layoutParams;
        if (Build.VERSION.SDK_INT < 19 || (layoutParams = view.getLayoutParams()) == null || layoutParams.height <= 0 || view.getPaddingTop() != 0) {
            return;
        }
        layoutParams.height += a(context);
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + a(context), view.getPaddingRight(), view.getPaddingBottom());
    }

    private static boolean b() {
        try {
            return Integer.parseInt(((String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, "ro.miui.ui.version.name")).replaceAll("[vV]", "")) >= 6;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void c(Window window, boolean z2) {
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i2 = declaredField.getInt(null);
            int i3 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z2 ? i3 | i2 : (i2 ^ (-1)) & i3);
            window.setAttributes(attributes);
        } catch (Exception unused) {
        }
    }

    private static View b(Activity activity, int i2) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, a((Context) activity)));
        view.setBackgroundColor(Color.argb(i2, 0, 0, 0));
        view.setId(a);
        return view;
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23 && activity != null && activity.getWindow() != null) {
            activity.getWindow().setStatusBarColor(0);
            a(activity.getWindow(), true);
        } else {
            if (Build.VERSION.SDK_INT < 21 || activity == null || activity.getWindow() == null) {
                return;
            }
            activity.getWindow().setStatusBarColor(Color.parseColor("#60000000"));
        }
    }

    @TargetApi(23)
    private static void a(Window window, boolean z2) {
        if (a()) {
            c(window, z2);
        } else if (b()) {
            d(window, z2);
        }
        b(window, z2);
    }

    private static boolean a() {
        return Build.FINGERPRINT.contains("Flyme_OS_4") || Build.VERSION.INCREMENTAL.contains("Flyme_OS_4") || Pattern.compile("Flyme OS [4|5]", 2).matcher(Build.DISPLAY).find();
    }

    private static int a(@ColorInt int i2, int i3) {
        if (i3 == 0) {
            return i2;
        }
        float f2 = 1.0f - (i3 / 255.0f);
        double d2 = ((i2 >> 16) & 255) * f2;
        Double.isNaN(d2);
        int i4 = (int) (d2 + 0.5d);
        double d3 = ((i2 >> 8) & 255) * f2;
        Double.isNaN(d3);
        double d4 = (i2 & 255) * f2;
        Double.isNaN(d4);
        return ((int) (d4 + 0.5d)) | (i4 << 16) | (-16777216) | (((int) (d3 + 0.5d)) << 8);
    }

    private static void a(ViewGroup viewGroup, @ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            int iA = a(i2, i3);
            View viewFindViewById = viewGroup.findViewById(R.id.custom);
            if (viewFindViewById == null && iA != 0) {
                viewFindViewById = new View(viewGroup.getContext());
                viewFindViewById.setId(R.id.custom);
                viewGroup.addView(viewFindViewById, new ViewGroup.LayoutParams(-1, a(viewGroup.getContext())));
            }
            if (viewFindViewById != null) {
                viewFindViewById.setBackgroundColor(iA);
            }
        }
    }

    private static void a(Activity activity, boolean z2) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(z2);
                ((ViewGroup) childAt).setClipToPadding(z2);
            }
        }
    }

    public static int a(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    public static void a(Activity activity, View view) {
        a(activity, 0, view);
    }

    public static void a(Activity activity, @IntRange(from = 0, to = 255) int i2, View view) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        c(activity);
        a(activity, i2);
        if (view != null) {
            Object tag = view.getTag(-123);
            if (tag == null || !((Boolean) tag).booleanValue()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + a((Context) activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                view.setTag(-123, true);
            }
        }
    }

    private static void a(Activity activity, @IntRange(from = 0, to = 255) int i2) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        View viewFindViewById = viewGroup.findViewById(a);
        if (viewFindViewById != null) {
            if (viewFindViewById.getVisibility() == 8) {
                viewFindViewById.setVisibility(0);
            }
            viewFindViewById.setBackgroundColor(Color.argb(i2, 0, 0, 0));
            return;
        }
        viewGroup.addView(b(activity, i2));
    }
}
