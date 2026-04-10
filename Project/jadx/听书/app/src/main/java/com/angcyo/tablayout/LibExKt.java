package com.angcyo.tablayout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.analytics.pro.d;
import com.xuexiang.xupdate.utils.ShellUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LibEx.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0000\u001a \u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0000\u001a \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0000\u001a \u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0000\u001aD\u0010 \u001a\u00020!*\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u0005H\u0000\u001a\u0016\u0010)\u001a\u0004\u0018\u00010\b*\u00020\b2\u0006\u0010*\u001a\u00020\u0005H\u0000\u001a\"\u0010+\u001a\u00020,*\u00020\b2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010.\u001a\u00020,H\u0000\u001a\u0016\u0010/\u001a\u00020,*\u00020\b2\b\b\u0002\u0010.\u001a\u00020,H\u0000\u001a&\u0010/\u001a\u00020,*\u00020\b2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020,H\u0000\u001a\u0014\u00102\u001a\u000203*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0000\u001a \u00104\u001a\u00020\b*\u0002052\b\b\u0001\u00106\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u000203H\u0000\u001a*\u00108\u001a\u000203\"\u0004\b\u0000\u00109*\n\u0012\u0004\u0012\u0002H9\u0018\u00010:2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u0002H9\u0018\u00010:H\u0000\u001a\n\u0010<\u001a\u000203*\u00020\u0005\u001a\n\u0010=\u001a\u000203*\u00020\u0005\u001a\f\u0010>\u001a\u00020?*\u00020@H\u0000\u001a\f\u0010A\u001a\u00020?*\u00020@H\u0000\u001a\f\u0010B\u001a\u00020?*\u00020@H\u0000\u001a\u0014\u0010C\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0013\u001a\u00020\u0005*\b\u0012\u0002\b\u0003\u0018\u00010D\u001a\u000e\u0010E\u001a\u00020\u0001*\u0004\u0018\u00010FH\u0000\u001a\u0018\u0010G\u001a\u00020\u0001*\u0004\u0018\u00010F2\b\u0010H\u001a\u0004\u0018\u00010#H\u0000\u001a\u0018\u0010I\u001a\u0004\u0018\u00010J*\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020\u0005H\u0000\u001a\u0016\u0010I\u001a\u00020?*\u0004\u0018\u00010\b2\u0006\u0010K\u001a\u00020\u0005H\u0000\"\u0014\u0010\u0000\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t\"\u0018\u0010\n\u001a\u00020\u0005*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\"\u0018\u0010\f\u001a\u00020\u0005*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\t\"\u0018\u0010\u000e\u001a\u00020\u0005*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t\"\u0018\u0010\u0010\u001a\u00020\u0005*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\t¨\u0006L"}, d2 = {t.q, "", "getDp", "()F", "dpi", "", "getDpi", "()I", "Landroid/view/View;", "(Landroid/view/View;)I", "screenHeight", "getScreenHeight", "screenWidth", "getScreenWidth", "viewDrawHeight", "getViewDrawHeight", "viewDrawWidth", "getViewDrawWidth", "atmostMeasure", "size", "clamp", "value", "min", "max", "evaluateColor", "fraction", "startColor", "endColor", "exactlyMeasure", "navBarHeight", d.R, "Landroid/content/Context;", "calcLayoutWidthHeight", "", "rLayoutWidth", "", "rLayoutHeight", "parentWidth", "parentHeight", "rLayoutWidthExclude", "rLayoutHeightExclude", "getChildOrNull", "index", "getLocationInParent", "Landroid/graphics/Rect;", "parentView", "result", "getViewRect", "offsetX", "offsetY", "have", "", "inflate", "Landroid/view/ViewGroup;", "layoutId", "attachToRoot", "isChange", ExifInterface.GPS_DIRECTION_TRUE, "", AdnName.OTHER, "isHorizontal", "isVertical", "loge", "", "", "logi", "logw", "remove", "", "textHeight", "Landroid/graphics/Paint;", "textWidth", "text", "tintDrawableColor", "Landroid/graphics/drawable/Drawable;", "color", "TabLayout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LibExKt {
    public static final float clamp(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static final int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static final boolean have(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return false;
        }
        return (i == 0 && i2 == 0) || (((i > 0 && i2 > 0) || (i < 0 && i2 < 0)) && (i & i2) == i2);
    }

    public static final boolean isHorizontal(int i) {
        return i == 0;
    }

    public static final boolean isVertical(int i) {
        return i == 1;
    }

    public static final int remove(int i, int i2) {
        return i & (~i2);
    }

    public static final int getDpi() {
        return (int) getDp();
    }

    public static final float getDp() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static final int getDpi(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (int) view.getContext().getResources().getDisplayMetrics().density;
    }

    public static final int getScreenWidth(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static final int getScreenHeight(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static final int getViewDrawWidth(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (view.getMeasuredWidth() - view.getPaddingLeft()) - view.getPaddingRight();
    }

    public static final int getViewDrawHeight(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return (view.getMeasuredHeight() - view.getPaddingTop()) - view.getPaddingBottom();
    }

    public static final int exactlyMeasure(int i) {
        return View.MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    public static final int exactlyMeasure(float f) {
        return exactlyMeasure((int) f);
    }

    public static final int atmostMeasure(int i) {
        return View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
    }

    public static final void logi(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Log.i("DslTabLayout", String.valueOf(obj));
    }

    public static final void logw(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Log.w("DslTabLayout", String.valueOf(obj));
    }

    public static final void loge(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Log.e("DslTabLayout", String.valueOf(obj));
    }

    public static final int[] calcLayoutWidthHeight(View view, String str, String str2, int i, int i2, int i3, int i4) {
        Float floatOrNull;
        Float floatOrNull2;
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = {-1, -1};
        String str3 = str;
        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
            return iArr;
        }
        if (!TextUtils.isEmpty(str3)) {
            Intrinsics.checkNotNull(str);
            if (StringsKt.contains((CharSequence) str3, (CharSequence) "sw", true)) {
                Float floatOrNull3 = StringsKt.toFloatOrNull(StringsKt.replace(str, "sw", "", true));
                if (floatOrNull3 != null) {
                    floatOrNull3.floatValue();
                    iArr[0] = (int) (floatOrNull3.floatValue() * (getScreenWidth(view) - i3));
                }
            } else if (StringsKt.contains((CharSequence) str3, (CharSequence) "pw", true) && (floatOrNull2 = StringsKt.toFloatOrNull(StringsKt.replace(str, "pw", "", true))) != null) {
                floatOrNull2.floatValue();
                iArr[0] = (int) (floatOrNull2.floatValue() * (i - i3));
            }
        }
        String str4 = str2;
        if (!TextUtils.isEmpty(str4)) {
            Intrinsics.checkNotNull(str2);
            if (StringsKt.contains((CharSequence) str4, (CharSequence) ShellUtils.COMMAND_SH, true)) {
                Float floatOrNull4 = StringsKt.toFloatOrNull(StringsKt.replace(str2, ShellUtils.COMMAND_SH, "", true));
                if (floatOrNull4 != null) {
                    floatOrNull4.floatValue();
                    iArr[1] = (int) (floatOrNull4.floatValue() * (getScreenHeight(view) - i4));
                }
            } else if (StringsKt.contains((CharSequence) str4, (CharSequence) "ph", true) && (floatOrNull = StringsKt.toFloatOrNull(StringsKt.replace(str2, "ph", "", true))) != null) {
                floatOrNull.floatValue();
                iArr[1] = (int) (floatOrNull.floatValue() * (i2 - i4));
            }
        }
        return iArr;
    }

    public static final int evaluateColor(float f, int i, int i2) {
        float fClamp = MathUtils.clamp(f, 0.0f, 1.0f);
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * fClamp))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * fClamp))) << 16) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r2) * fClamp))) << 8) | ((i & 255) + ((int) (fClamp * ((i2 & 255) - r7))));
    }

    public static final Drawable tintDrawableColor(Drawable drawable, int i) {
        if (drawable == null) {
            return drawable;
        }
        Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
        Intrinsics.checkNotNullExpressionValue(drawableMutate, "mutate(...)");
        DrawableCompat.setTint(drawableMutate, i);
        return drawableMutate;
    }

    public static final void tintDrawableColor(View view, int i) {
        if (view instanceof TextView) {
            Drawable[] drawableArr = new Drawable[4];
            TextView textView = (TextView) view;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            Intrinsics.checkNotNullExpressionValue(compoundDrawables, "getCompoundDrawables(...)");
            Drawable[] drawableArr2 = compoundDrawables;
            int length = drawableArr2.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                Drawable drawable = drawableArr2[i2];
                drawableArr[i3] = drawable != null ? tintDrawableColor(drawable, i) : null;
                i2++;
                i3 = i4;
            }
            textView.setCompoundDrawables(drawableArr[0], drawableArr[1], drawableArr[2], drawableArr[3]);
            return;
        }
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Drawable drawable2 = imageView.getDrawable();
            imageView.setImageDrawable(drawable2 != null ? tintDrawableColor(drawable2, i) : null);
        }
    }

    public static final float textWidth(Paint paint, String str) {
        if (TextUtils.isEmpty(str) || paint == null) {
            return 0.0f;
        }
        return paint.measureText(str);
    }

    public static final float textHeight(Paint paint) {
        if (paint != null) {
            return paint.descent() - paint.ascent();
        }
        return 0.0f;
    }

    public static final View getChildOrNull(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!(view instanceof ViewGroup)) {
            return view;
        }
        boolean z = false;
        if (i >= 0 && i < ((ViewGroup) view).getChildCount()) {
            z = true;
        }
        if (z) {
            return ((ViewGroup) view).getChildAt(i);
        }
        return null;
    }

    public static /* synthetic */ Rect getLocationInParent$default(View view, View view2, Rect rect, int i, Object obj) {
        if ((i & 1) != 0) {
            view2 = null;
        }
        if ((i & 2) != 0) {
            rect = new Rect();
        }
        return getLocationInParent(view, view2, rect);
    }

    public static final Rect getLocationInParent(View view, View view2, Rect result) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        if (view2 == null) {
            Object parent = view.getParent();
            view2 = parent instanceof View ? (View) parent : null;
        }
        if (view2 == null) {
            getViewRect(view, result);
        } else {
            result.set(0, 0, 0, 0);
            if (!Intrinsics.areEqual(view, view2)) {
                getLocationInParent$doIt(view, view2, result);
            }
            result.right = result.left + view.getMeasuredWidth();
            result.bottom = result.top + view.getMeasuredHeight();
        }
        return result;
    }

    private static final void getLocationInParent$doIt(View view, View view2, Rect rect) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            rect.left += view.getLeft();
            rect.top += view.getTop();
            if (Intrinsics.areEqual(parent, view2)) {
                return;
            }
            getLocationInParent$doIt((View) parent, view2, rect);
        }
    }

    public static /* synthetic */ Rect getViewRect$default(View view, Rect rect, int i, Object obj) {
        if ((i & 1) != 0) {
            rect = new Rect();
        }
        return getViewRect(view, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final android.graphics.Rect getViewRect(android.view.View r4, android.graphics.Rect r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r0 = r4.getContext()
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L15
            android.app.Activity r0 = (android.app.Activity) r0
            goto L16
        L15:
            r0 = 0
        L16:
            r1 = 0
            if (r0 == 0) goto L35
            android.view.Window r2 = r0.getWindow()
            android.view.View r2 = r2.getDecorView()
            r2.getGlobalVisibleRect(r5)
            int r2 = r5.width()
            int r3 = r5.height()
            if (r2 <= r3) goto L35
            android.content.Context r0 = (android.content.Context) r0
            int r0 = navBarHeight(r0)
            goto L36
        L35:
            r0 = r1
        L36:
            android.graphics.Rect r4 = getViewRect(r4, r0, r1, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.angcyo.tablayout.LibExKt.getViewRect(android.view.View, android.graphics.Rect):android.graphics.Rect");
    }

    public static /* synthetic */ Rect getViewRect$default(View view, int i, int i2, Rect rect, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            rect = new Rect();
        }
        return getViewRect(view, i, i2, rect);
    }

    public static final Rect getViewRect(View view, int i, int i2, Rect result) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0] + i;
        int i4 = iArr[1] + i2;
        result.set(i3, i4, view.getMeasuredWidth() + i3, view.getMeasuredHeight() + i4);
        return result;
    }

    public static final int navBarHeight(Context context) {
        int iWidth;
        int iWidth2;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(context instanceof Activity)) {
            return 0;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Activity activity = (Activity) context;
        activity.getWindow().getDecorView().getGlobalVisibleRect(rect);
        activity.getWindow().findViewById(android.R.id.content).getGlobalVisibleRect(rect2);
        if (rect.width() > rect.height()) {
            iWidth = rect.width();
            iWidth2 = rect2.width();
        } else {
            iWidth = rect.bottom;
            iWidth2 = rect2.bottom;
        }
        return iWidth - iWidth2;
    }

    public static final int size(Collection<?> collection) {
        if (collection != null) {
            return collection.size();
        }
        return 0;
    }

    public static final <T> boolean isChange(List<? extends T> list, List<? extends T> list2) {
        if (size(list) != size(list2)) {
            return true;
        }
        if (list != null) {
            int i = 0;
            for (T t : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (!Intrinsics.areEqual(t, list2 != null ? CollectionsKt.getOrNull(list2, i) : null)) {
                    return true;
                }
                i = i2;
            }
        }
        return false;
    }

    public static /* synthetic */ View inflate$default(ViewGroup viewGroup, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return inflate(viewGroup, i, z);
    }

    public static final View inflate(ViewGroup viewGroup, int i, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        if (i == -1) {
            return viewGroup;
        }
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        Intrinsics.checkNotNull(viewInflate);
        return viewInflate;
    }
}
