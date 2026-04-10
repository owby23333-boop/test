package com.kwad.sdk.b.kwai;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.r;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static int aaK;
    private static long aaL;

    public static boolean B(View view) {
        return (view.getSystemUiVisibility() & 1024) == 1024;
    }

    @NonNull
    public static Context C(@NonNull View view) {
        Activity activityD = D(view);
        if (activityD == null && (view.getParent() instanceof View)) {
            activityD = D((View) view.getParent());
        }
        return activityD == null ? view.getContext() : activityD;
    }

    @Nullable
    private static Activity D(View view) {
        Object context = view.getContext();
        HashSet hashSet = new HashSet();
        do {
            hashSet.add(context);
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = context instanceof ResContext ? ((ResContext) context).getDelegatedContext() : ((ContextWrapper) context).getBaseContext();
        } while (!hashSet.contains(context));
        return null;
    }

    public static void E(View view) {
        if (view == null || ((View) view.getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        view.setLayoutParams(layoutParams);
    }

    @Nullable
    public static int[] F(View view) {
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

    public static int G(View view) {
        if (view == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static int a(Context context, float f2) {
        return (int) (context == null ? f2 * 2.0f : (f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static View a(ViewGroup viewGroup, int i2, boolean z2) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, true);
    }

    public static void a(View.OnClickListener onClickListener, View... viewArr) {
        for (View view : viewArr) {
            view.setOnClickListener(onClickListener);
        }
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
            int i2 = 0;
            int i3 = 1;
            int i4 = 1;
            boolean z2 = false;
            while (true) {
                float fMeasureText = paint.measureText(str2.substring(i2, i3));
                if (fMeasureText >= width) {
                    i2 = i3 - 1;
                    i4++;
                } else if (i4 == textView.getMaxLines()) {
                    float f2 = fMeasureText + intrinsicWidth;
                    if (paint.measureText(" ") + f2 >= width || f2 + paint.measureText("...") + paint.measureText(" ") >= width) {
                        i3--;
                        z2 = true;
                    } else {
                        if (z2) {
                            str2 = str2.substring(0, i3) + "... ";
                            break;
                        }
                        i3++;
                    }
                } else {
                    i3++;
                }
                if (i3 > str2.length() || i4 > textView.getMaxLines()) {
                    break;
                }
            }
        }
        String str3 = str2 + "*";
        SpannableString spannableString = new SpannableString(str3);
        spannableString.setSpan(new com.kwad.sdk.core.view.a(textView.getContext(), bitmap), str3.length() - 1, str3.length(), 33);
        textView.setText(spannableString);
    }

    public static boolean a(Activity activity) {
        return a(activity.getWindow());
    }

    public static boolean a(View view, int i2, boolean z2) {
        return view != null && b(view, i2, z2) && aH(view.getContext());
    }

    private static boolean a(Window window) {
        return (window.getAttributes().flags & 1024) == 1024;
    }

    @Deprecated
    public static int aF(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int i2 = Build.VERSION.SDK_INT;
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (i2 >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static float aG(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    private static boolean aH(Context context) {
        return am.DJ().aH(context);
    }

    public static int b(Context context, float f2) {
        return (int) (context == null ? f2 / 2.0f : (f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static View b(@NonNull Activity activity) {
        return b(activity.getWindow());
    }

    private static View b(@NonNull Window window) {
        return window.getDecorView().findViewById(R.id.content);
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i2, i3, i4, 0);
            view.requestLayout();
        }
    }

    private static boolean b(View view, int i2, boolean z2) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Context contextC = C(view);
        if (((contextC instanceof Activity) && ((Activity) contextC).isFinishing()) || !view.isShown() || view.getVisibility() != 0 || (z2 && !view.hasWindowFocus())) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long jHeight = ((long) rect.height()) * ((long) rect.width());
            long height = ((long) view.getHeight()) * ((long) view.getWidth());
            if (height > 0 && jHeight * 100 >= ((long) i2) * height) {
                return true;
            }
        }
        return false;
    }

    public static int c(@NonNull Activity activity) {
        return b(activity).getWidth();
    }

    public static int d(@NonNull Activity activity) {
        return b(activity).getHeight();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(android.view.View r5, int r6, int r7) {
        /*
            if (r5 != 0) goto L3
            return
        L3:
            if (r6 == 0) goto L4f
            if (r7 != 0) goto L8
            goto L4f
        L8:
            android.view.ViewParent r0 = r5.getParent()
            android.view.View r0 = (android.view.View) r0
            if (r0 != 0) goto L11
            return
        L11:
            int r1 = r0.getWidth()
            int r0 = r0.getHeight()
            if (r1 == 0) goto L4f
            if (r0 != 0) goto L1e
            goto L4f
        L1e:
            android.view.ViewGroup$LayoutParams r2 = r5.getLayoutParams()
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = -1
            if (r1 <= r0) goto L38
            if (r6 <= r7) goto L2a
            goto L3a
        L2a:
            float r6 = (float) r6
            float r7 = (float) r7
            float r7 = r7 * r3
            float r6 = r6 / r7
            float r7 = (float) r0
            float r6 = r6 * r7
            int r6 = (int) r6
            r2.width = r6
            r2.height = r0
            goto L4c
        L38:
            if (r7 <= r6) goto L3f
        L3a:
            r2.width = r4
            r2.height = r4
            goto L4c
        L3f:
            r2.width = r1
            float r7 = (float) r7
            float r6 = (float) r6
            float r6 = r6 * r3
            float r7 = r7 / r6
            float r6 = (float) r1
            float r7 = r7 * r6
            int r6 = (int) r7
            r2.height = r6
        L4c:
            r5.setLayoutParams(r2)
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.b.kwai.a.d(android.view.View, int, int):void");
    }

    public static void e(View view, int i2, int i3) {
        View view2;
        if (view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i2 > i3) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i2 / (i3 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void f(View view, int i2, int i3) {
        View view2;
        if (view == null || i2 == 0 || i3 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (width <= height || i2 > i3) {
            layoutParams.width = width;
            layoutParams.height = (int) ((i3 / (i2 * 1.0f)) * width);
        } else {
            layoutParams.width = (int) ((i2 / (i3 * 1.0f)) * height);
            layoutParams.height = height;
        }
        view.setLayoutParams(layoutParams);
    }

    public static int g(Context context, int i2) {
        if (context == null || i2 == 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(i2);
    }

    @ColorInt
    public static int getColor(Context context, @ColorRes int i2) {
        return context.getResources().getColor(i2);
    }

    @Deprecated
    public static int getScreenHeight(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    @Deprecated
    public static int getScreenWidth(@Nullable Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(@Nullable Context context) {
        int i2 = aaK;
        if (i2 > 0 || context == null) {
            return i2;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            aaK = context.getResources().getDimensionPixelSize(identifier);
        } else {
            try {
                aaK = context.getResources().getDimensionPixelSize(((Integer) r.d("com.android.internal.R$dimen", "status_bar_height")).intValue());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (aaK <= 0) {
            aaK = a(context, 25.0f);
        }
        return aaK;
    }

    public static boolean m(View view, int i2) {
        return view != null && b(view, i2, true) && view.hasWindowFocus() && aH(view.getContext());
    }

    public static void n(View view, int i2) {
        if (view == null || i2 == 0) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    public static void o(View view, int i2) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i2;
        }
    }

    public static boolean tN() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jAbs = Math.abs(jUptimeMillis - aaL);
        aaL = jUptimeMillis;
        return jAbs < 500;
    }
}
