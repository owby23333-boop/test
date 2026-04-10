package com.kwad.sdk.c.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.sdk.utils.z;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static int avc;
    private static long avd;

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int h(Context context, int i) {
        return context.getResources().getDimensionPixelSize(i);
    }

    public static int b(Context context, float f) {
        return a(2, f, context);
    }

    private static int a(int i, float f, Context context) {
        float fApplyDimension = TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
        int i2 = (int) (fApplyDimension >= 0.0f ? fApplyDimension + 0.5f : fApplyDimension - 0.5f);
        if (i2 != 0) {
            return i2;
        }
        if (f == 0.0f) {
            return 0;
        }
        return f > 0.0f ? 1 : -1;
    }

    public static boolean G(View view) {
        return (view.getSystemUiVisibility() & 1024) == 1024;
    }

    public static boolean d(Activity activity) {
        return b(activity.getWindow());
    }

    private static boolean b(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view : viewArr) {
            view.setOnClickListener(onClickListener);
        }
    }

    public static int bh(Context context) {
        return px2dip(context, getStatusBarHeight(context));
    }

    public static int getStatusBarHeight(Context context) {
        int i = avc;
        if (i > 0 || context == null) {
            return i;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            avc = context.getResources().getDimensionPixelSize(identifier);
        } else {
            try {
                avc = context.getResources().getDimensionPixelSize(((Integer) z.getField("com.android.internal.R$dimen", "status_bar_height")).intValue());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (avc <= 0) {
            avc = a(context, 25.0f);
        }
        return avc;
    }

    @Deprecated
    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT >= 35) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Rect bounds = currentWindowMetrics.getBounds();
                Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
                return (bounds.height() - insets.top) - insets.bottom;
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Deprecated
    public static int bi(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT >= 35) {
                WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Rect bounds = currentWindowMetrics.getBounds();
                Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
                return (bounds.width() - insets.left) - insets.right;
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static View e(Activity activity) {
        return c(activity.getWindow());
    }

    private static View c(Window window) {
        return window.getDecorView().findViewById(R.id.content);
    }

    public static int f(Activity activity) {
        return e(activity).getWidth();
    }

    public static int g(Activity activity) {
        return e(activity).getHeight();
    }

    public static float bj(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static boolean DE() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (Math.abs(jUptimeMillis - avd) < 500) {
            avd = jUptimeMillis;
            return true;
        }
        avd = jUptimeMillis;
        return false;
    }

    public static View a(ViewGroup viewGroup, int i, boolean z) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, true);
    }

    public static void d(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height) {
            if (i > i2) {
                layoutParams.width = -1;
                layoutParams.height = -1;
            } else {
                layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
                layoutParams.height = height;
            }
        } else if (i2 > i) {
            layoutParams.width = -1;
            layoutParams.height = -1;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void H(View view) {
        if (view == null || ((View) view.getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
    }

    public static void e(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i > i2) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void f(View view, int i, int i2) {
        View view2;
        if (view == null || i == 0 || i2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width > height && i <= i2) {
            layoutParams.width = (int) ((i / (i2 * 1.0f)) * height);
            layoutParams.height = height;
        } else {
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void a(View view, float f, float f2) {
        View view2;
        if (view == null || f == 0.0f || f2 == 0.0f || (view2 = (View) view.getParent()) == null) {
            return;
        }
        float width = view2.getWidth();
        float height = view2.getHeight();
        if (width == 0.0f || height == 0.0f) {
            return;
        }
        float f3 = height / width;
        float f4 = f2 / f;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (f4 > f3) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) (width * f4);
        } else {
            layoutParams.height = (int) height;
            layoutParams.width = (int) (height / f4);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void a(TextView textView, String str, Bitmap bitmap) {
        String str2 = str + " ";
        TextPaint paint = textView.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int iCeil = ((int) Math.ceil(fontMetrics.descent - fontMetrics.top)) + 2;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getContext().getResources(), bitmap);
        int intrinsicWidth = (bitmapDrawable.getIntrinsicWidth() * iCeil) / bitmapDrawable.getIntrinsicHeight();
        bitmapDrawable.setBounds(0, a(textView.getContext(), 1.0f), intrinsicWidth, iCeil);
        float width = textView.getWidth();
        if (paint.measureText(str2) > width) {
            int i = 1;
            int i2 = 1;
            int i3 = 0;
            boolean z = false;
            while (true) {
                float fMeasureText = paint.measureText(str2.substring(i3, i));
                if (fMeasureText >= width) {
                    i3 = i - 1;
                    i2++;
                } else if (i2 == textView.getMaxLines()) {
                    float f = fMeasureText + intrinsicWidth;
                    if (paint.measureText(" ") + f >= width || f + paint.measureText("...") + paint.measureText(" ") >= width) {
                        i--;
                        z = true;
                    } else {
                        if (z) {
                            str2 = str2.substring(0, i) + "... ";
                            break;
                        }
                        i++;
                    }
                } else {
                    i++;
                }
                if (i > str2.length() || i2 > textView.getMaxLines()) {
                    break;
                }
            }
        }
        String str3 = str2 + "*";
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new com.kwad.sdk.core.view.a(textView.getContext(), bitmap), str3.length() - 1, str3.length(), 33);
        textView.setText(spannableString);
    }

    public static int getColor(Context context, int i) {
        return context.getResources().getColor(i);
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i, i2, i3, 0);
            view.requestLayout();
        }
    }

    public static int[] I(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int height = view.getHeight();
        iArr[0] = iArr[0] + (width / 2);
        iArr[1] = iArr[1] + (height / 2);
        return iArr;
    }

    public static void m(View view, int i) {
        if (view == null || i == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public static int J(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static void n(View view, int i) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        }
    }
}
