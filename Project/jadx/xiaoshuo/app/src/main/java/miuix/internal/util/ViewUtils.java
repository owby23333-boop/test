package miuix.internal.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import miuix.core.R;
import miuix.reflect.Reflects;

/* JADX INFO: loaded from: classes8.dex */
public class ViewUtils {
    private static final int PADDING_KEY = Integer.MIN_VALUE;
    static final String TAG = "ViewUtils";
    private static boolean sSetFrameFetched;
    private static Method sSetFrameMethod;

    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding);
    }

    private ViewUtils() {
    }

    public static boolean containsPoint(View view, int i, int i2) {
        return i > view.getLeft() && i < view.getRight() && i2 > view.getTop() && i2 < view.getBottom();
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @Nullable AttributeSet attributeSet, int i, int i2) {
        doOnApplyWindowInsets(view, attributeSet, i, i2, null);
    }

    @SuppressLint({"PrivateApi", "SoonBlockedPrivateApi"})
    private static void fetchSetFrame() {
        if (sSetFrameFetched) {
            return;
        }
        Class cls = Integer.TYPE;
        Method declaredMethod = Reflects.getDeclaredMethod((Class<?>) View.class, "setFrame", (Class<?>[]) new Class[]{cls, cls, cls, cls});
        sSetFrameMethod = declaredMethod;
        declaredMethod.setAccessible(true);
        sSetFrameFetched = true;
    }

    public static int getBackgroundHeight(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return -1;
    }

    public static int getBackgroundWidth(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            return background.getIntrinsicWidth();
        }
        return -1;
    }

    public static void getBoundsInWindow(@NonNull View view, @NonNull Rect rect) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        rect.set(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight());
    }

    public static void getContentRect(View view, Rect rect) {
        rect.left = view.getScrollX() + view.getPaddingLeft();
        rect.top = view.getScrollY() + view.getPaddingTop();
        rect.right = (view.getWidth() - view.getPaddingRight()) - rect.left;
        rect.bottom = (view.getHeight() - view.getPaddingBottom()) - rect.top;
    }

    public static int getMeasuredHeightWithMargin(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return measuredHeight;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static boolean intersectsWith(View view, Rect rect) {
        return rect != null && view.getLeft() < rect.right && view.getTop() < rect.bottom && view.getRight() > rect.left && view.getBottom() > rect.top;
    }

    public static boolean isLayoutRtl(View view) {
        return view.getLayoutDirection() == 1;
    }

    public static boolean isNightMode(Context context) {
        return isNightMode(context.getResources().getConfiguration());
    }

    public static void layoutChildView(ViewGroup viewGroup, View view, int i, int i2, int i3, int i4) {
        boolean zIsLayoutRtl = isLayoutRtl(viewGroup);
        int width = viewGroup.getWidth();
        int i5 = zIsLayoutRtl ? width - i3 : i;
        if (zIsLayoutRtl) {
            i3 = width - i;
        }
        view.layout(i5, i2, i3, i4);
    }

    public static void requestApplyInsetsWhenAttached(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: miuix.internal.util.ViewUtils.3
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NonNull View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewCompat.requestApplyInsets(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
        }
    }

    public static void resetPaddingBottom(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    public static void resetPaddingTop(View view, int i) {
        view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), view.getPaddingBottom());
    }

    public static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.setLeftTopRightBottom(i, i2, i3, i4);
            return;
        }
        fetchSetFrame();
        Method method = sSetFrameMethod;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @Nullable AttributeSet attributeSet, int i, int i2, @Nullable final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        TypedArray typedArrayObtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.MiuixInsets, i, i2);
        final boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MiuixInsets_miuixPaddingBottomSystemWindowInsets, false);
        final boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MiuixInsets_miuixPaddingLeftSystemWindowInsets, false);
        final boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MiuixInsets_miuixPaddingRightSystemWindowInsets, false);
        typedArrayObtainStyledAttributes.recycle();
        doOnApplyWindowInsets(view, new OnApplyWindowInsetsListener() { // from class: miuix.internal.util.ViewUtils.1
            @Override // miuix.internal.util.ViewUtils.OnApplyWindowInsetsListener
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view2, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull RelativePadding relativePadding) {
                if (z) {
                    relativePadding.bottom += windowInsetsCompat.getSystemWindowInsetBottom();
                }
                boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(view2);
                if (z2) {
                    if (zIsLayoutRtl) {
                        relativePadding.end += windowInsetsCompat.getSystemWindowInsetLeft();
                    } else {
                        relativePadding.start += windowInsetsCompat.getSystemWindowInsetLeft();
                    }
                }
                if (z3) {
                    if (zIsLayoutRtl) {
                        relativePadding.start += windowInsetsCompat.getSystemWindowInsetRight();
                    } else {
                        relativePadding.end += windowInsetsCompat.getSystemWindowInsetRight();
                    }
                }
                relativePadding.applyToView(view2);
                OnApplyWindowInsetsListener onApplyWindowInsetsListener2 = onApplyWindowInsetsListener;
                return onApplyWindowInsetsListener2 != null ? onApplyWindowInsetsListener2.onApplyWindowInsets(view2, windowInsetsCompat, relativePadding) : windowInsetsCompat;
            }
        });
    }

    public static boolean isNightMode(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 30) {
            return configuration.isNightModeActive();
        }
        return (configuration.uiMode & 48) == 32;
    }

    public static class RelativePadding {
        public int bottom;
        public boolean clipToPadding = false;
        public int end;
        public int start;
        public int top;

        public RelativePadding(View view) {
            this.start = ViewCompat.getPaddingStart(view);
            this.top = view.getPaddingTop();
            this.end = ViewCompat.getPaddingEnd(view);
            this.bottom = view.getPaddingBottom();
        }

        public void applyToScrollingView(ViewGroup viewGroup) {
            applyToView(viewGroup);
            viewGroup.setClipToPadding(true);
        }

        public void applyToView(View view) {
            ViewCompat.setPaddingRelative(view, this.start, this.top, this.end, this.bottom);
        }

        public RelativePadding(int i, int i2, int i3, int i4) {
            this.start = i;
            this.top = i2;
            this.end = i3;
            this.bottom = i4;
        }

        public RelativePadding(@NonNull RelativePadding relativePadding) {
            this.start = relativePadding.start;
            this.top = relativePadding.top;
            this.end = relativePadding.end;
            this.bottom = relativePadding.bottom;
        }
    }

    public static void doOnApplyWindowInsets(@NonNull View view, @NonNull final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        final RelativePadding relativePadding = new RelativePadding(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        ViewCompat.setOnApplyWindowInsetsListener(view, new androidx.core.view.OnApplyWindowInsetsListener() { // from class: miuix.internal.util.ViewUtils.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsetsCompat, new RelativePadding(relativePadding));
            }
        });
        requestApplyInsetsWhenAttached(view);
    }
}
