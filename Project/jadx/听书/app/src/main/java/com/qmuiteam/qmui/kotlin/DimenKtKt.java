package com.qmuiteam.qmui.kotlin;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DimenKt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\b*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001¨\u0006\r"}, d2 = {"dimen", "", "Landroid/content/Context;", "resource", "Landroid/view/View;", "Landroidx/fragment/app/Fragment;", "dip", "value", "", "px2dp", "px", "px2sp", "sp", "qmui_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DimenKtKt {
    public static final int dip(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }

    public static final int dip(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }

    public static final int sp(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (i * context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static final int sp(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (f * context.getResources().getDisplayMetrics().scaledDensity);
    }

    public static final float px2dp(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return i / context.getResources().getDisplayMetrics().density;
    }

    public static final float px2sp(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return i / context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static final int dimen(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDimensionPixelSize(i);
    }

    public static final int dip(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return dip(context, i);
    }

    public static final int dip(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return dip(context, f);
    }

    public static final int sp(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return sp(context, i);
    }

    public static final int sp(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return sp(context, f);
    }

    public static final float px2dp(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return px2dp(context, i);
    }

    public static final float px2sp(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return px2sp(context, i);
    }

    public static final int dimen(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return dimen(context, i);
    }

    public static final int dip(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return dip(context, i);
    }

    public static final int dip(Fragment fragment, float f) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return dip(context, f);
    }

    public static final int sp(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return sp(context, i);
    }

    public static final int sp(Fragment fragment, float f) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return sp(context, f);
    }

    public static final float px2dp(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return px2dp(context, i);
    }

    public static final float px2sp(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return px2sp(context, i);
    }

    public static final int dimen(Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context context = fragment.getContext();
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNullExpressionValue(context, "context!!");
        return dimen(context, i);
    }
}
