package com.angcyo.tablayout;

import android.graphics.drawable.GradientDrawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DslGradientDrawable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"dslGradientDrawable", "Landroid/graphics/drawable/GradientDrawable;", "action", "Lkotlin/Function1;", "Lcom/angcyo/tablayout/DslGradientDrawable;", "", "Lkotlin/ExtensionFunctionType;", "TabLayout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DslGradientDrawableKt {
    public static final GradientDrawable dslGradientDrawable(Function1<? super DslGradientDrawable, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        DslGradientDrawable dslGradientDrawable = new DslGradientDrawable();
        action.invoke(dslGradientDrawable);
        GradientDrawable gradientDrawableUpdateOriginDrawable = dslGradientDrawable.updateOriginDrawable();
        Intrinsics.checkNotNull(gradientDrawableUpdateOriginDrawable);
        return gradientDrawableUpdateOriginDrawable;
    }
}
